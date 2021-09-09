package com.xiaomi.smarthome.uwb.lib.securityCode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.auth.AuthResultCallback;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import com.xiaomi.smarthome.uwb.lib.auth.OobRequestCallback;
import com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.keyretriever.BaseMitvSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.keyretriever.MitvSpecificKeyCallback;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeView;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class SecurityCodeActivityImpl {
    boolean mAuthSuccess = false;
    UwbConEngine.IEngineStateCallback mEngineStateCallback = new UwbConEngine.IEngineStateCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass2 */

        public void onSwitchCommunication(int i, String str) {
        }

        public void onConnEstablished() {
            UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus IEngineStateCallback onConnEstablished");
            SecurityCodeActivityImpl securityCodeActivityImpl = SecurityCodeActivityImpl.this;
            securityCodeActivityImpl.mExitUwb = false;
            if (securityCodeActivityImpl.getActivity() instanceof SecurityCodeActivityCallback) {
                ((SecurityCodeActivityCallback) SecurityCodeActivityImpl.this.getActivity()).onConnEstablished(SecurityCodeActivityImpl.this.mUwbScanDevice);
                SecurityCodeActivityImpl.this.getActivity().finish();
            }
        }

        public void onRetryKeyRetrieve() {
            UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus IEngineStateCallback onRetryKeyRetrieve");
        }

        public void onConnectionError(int i, String str) {
            UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus onConnectionError: " + i + " msg: " + str);
            SecurityCodeActivityImpl.this.runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass2.AnonymousClass1 */

                public void run() {
                    if (SecurityCodeActivityImpl.this.getActivity() != null) {
                        Toast.makeText(SecurityCodeActivityImpl.this.getActivity(), SecurityCodeActivityImpl.this.getActivity().getText(R.string.mj_uwb_connect_fail), 1).show();
                        SecurityCodeActivityImpl.this.getActivity().finish();
                    }
                }
            });
        }

        public void onEstablishSecurityError(int i, String str) {
            UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus onEstablishSecurityError: " + i + " msg: " + str);
            SecurityCodeActivityImpl.this.runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass2.AnonymousClass2 */

                public void run() {
                    if (SecurityCodeActivityImpl.this.getActivity() != null) {
                        Toast.makeText(SecurityCodeActivityImpl.this.getActivity(), SecurityCodeActivityImpl.this.getActivity().getText(R.string.mj_uwb_connect_fail), 1).show();
                        SecurityCodeActivityImpl.this.getActivity().finish();
                    }
                }
            });
        }
    };
    boolean mExitUwb = true;
    Handler mHandler;
    MitvSpecificKeyCallback mMitvSpecificKeyCallback = new MitvSpecificKeyCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass3 */

        public void onSuccess(int i, Bundle bundle) {
            if (12288 == i && bundle != null) {
                SecurityCodeActivityImpl.this.mUid = bundle.getString("UID");
                SecurityCodeActivityImpl.this.mTvKey = bundle.getString("TVKey");
                UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus MitvSpecificKeyCallback onStartKeyRetrieve mUid: " + SecurityCodeActivityImpl.this.mUid + " mTvKey: " + SecurityCodeActivityImpl.this.mTvKey);
                if (!TextUtils.isEmpty(SecurityCodeActivityImpl.this.mUid) && !TextUtils.isEmpty(SecurityCodeActivityImpl.this.mTvKey)) {
                    SecurityCodeActivityImpl.this.closeLoadingView();
                    SecurityCodeActivityImpl.this.openSecurityGroup();
                    SecurityCodeActivityImpl.this.startAuth();
                }
            }
        }

        public void onFailed(int i) {
            UwbLogUtil.e("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus MitvSpecificKeyCallback onFailed: ".concat(String.valueOf(i)));
            if (-2 == i) {
                SecurityCodeActivityImpl.this.closeLoadingView();
                SecurityCodeActivityImpl.this.closeSecurityGroup();
                SecurityCodeActivityImpl.this.openTimeOutView(R.string.mj_uwb_connect_fail);
            }
        }
    };
    Runnable mStartAuthRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass1 */

        public void run() {
            if (SecurityCodeActivityImpl.this.getActivity() != null) {
                SecurityCodeActivityImpl.this.mStrangerRegister.startAuth();
            }
        }
    };
    UwbStrangerRegister mStrangerRegister;
    String mTvKey;
    String mUid;
    UwbScanDevice mUwbScanDevice;
    WeakReference<Activity> mWeakReference;

    public static void startSecurityCodeActivity(UwbScanDevice uwbScanDevice, Class<?> cls) {
        UwbLogUtil.e("Mijia-UWB-timestamp", "startKeyRetrieve start");
        Intent intent = new Intent();
        intent.setClass(UwbSdk.getApplication(), cls);
        intent.putExtra("UWB_SCAN_DEVICE", uwbScanDevice.toJSON().toString());
        intent.setFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
    }

    public boolean onCreate(Activity activity) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mWeakReference = new WeakReference<>(activity);
        try {
            this.mUwbScanDevice = UwbScanDevice.parse(new JSONObject(activity.getIntent().getStringExtra("UWB_SCAN_DEVICE")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus SecurityCodeActivity mUwbScanDevice: " + this.mUwbScanDevice);
        if (this.mUwbScanDevice == null) {
            activity.finish();
            return false;
        }
        activity.setContentView((int) R.layout.activity_security_code);
        openLoadingView();
        BaseMitvSpecificKeyRetriever.setGlobalMitvSpecificKeyCallback(this.mMitvSpecificKeyCallback);
        UwbApi.getInstance().isEngineReady(this.mEngineStateCallback);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void openLoadingView() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass4 */

            public void run() {
                Activity activity = SecurityCodeActivityImpl.this.getActivity();
                if (activity != null) {
                    activity.findViewById(R.id.loading_l).setVisibility(0);
                    ((ProgressBar) SecurityCodeActivityImpl.this.getActivity().findViewById(R.id.progress)).startAnimation(AnimationUtils.loadAnimation(SecurityCodeActivityImpl.this.getActivity(), R.anim.uwb_mj_rotate_loading));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void closeLoadingView() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass5 */

            public void run() {
                Activity activity = SecurityCodeActivityImpl.this.getActivity();
                if (activity != null) {
                    ProgressBar progressBar = (ProgressBar) SecurityCodeActivityImpl.this.getActivity().findViewById(R.id.progress);
                    if (progressBar != null) {
                        progressBar.clearAnimation();
                    }
                    activity.findViewById(R.id.loading_l).setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void openSecurityGroup() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass6 */

            public void run() {
                final Activity activity = SecurityCodeActivityImpl.this.getActivity();
                if (activity != null) {
                    activity.findViewById(R.id.security_group).setVisibility(0);
                    final SecurityCodeView securityCodeView = (SecurityCodeView) activity.findViewById(R.id.edit_security_code);
                    final TextView textView = (TextView) activity.findViewById(R.id.code_info_tv);
                    securityCodeView.setInputCompleteListener(new SecurityCodeView.InputCompleteListener() {
                        /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass6.AnonymousClass1 */

                        public void deleteContent(boolean z) {
                        }

                        public void inputComplete() {
                            Activity activity = SecurityCodeActivityImpl.this.getActivity();
                            if (activity != null) {
                                String editContent = securityCodeView.getEditContent();
                                UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus securityCode mInputCompleteListener: ".concat(String.valueOf(editContent)));
                                if (!SecurityCodeActivityImpl.this.mStrangerRegister.set4DigitPinOob(editContent)) {
                                    Toast.makeText(activity, activity.getText(R.string.mj_uwb_connect_fail), 1).show();
                                    activity.finish();
                                }
                            }
                        }

                        public void afterTextChanged(Editable editable) {
                            if (!editable.toString().equals("")) {
                                textView.setTextColor(activity.getResources().getColor(R.color.security_code_info));
                                textView.setText((int) R.string.mj_uwb_input_security_code_on_tv);
                            }
                        }
                    });
                    securityCodeView.showSoftInput();
                    UIUtils.initBottomMargin(activity, activity.findViewById(R.id.security_group));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void closeSecurityGroup() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass7 */

            public void run() {
                Activity activity = SecurityCodeActivityImpl.this.getActivity();
                if (activity != null) {
                    activity.findViewById(R.id.security_group).setVisibility(8);
                    ((SecurityCodeView) activity.findViewById(R.id.edit_security_code)).hideSoftInput();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void startAuth() {
        this.mStrangerRegister = new UwbStrangerRegister(this.mUid, new OobRequestCallback() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass8 */

            public void onRequestOobRanging1M() {
            }

            public void onRequestOobRanging2M() {
            }

            public void onRequestOob4DigitPin() {
                UwbLogUtil.d("Mijia-UWB-SecurityCodeActivityImpl", "Tv should request oob");
            }
        }, new AuthResultCallback() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass9 */

            public void onSuccess(Bundle bundle) {
                UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus UwbStrangerRegister onSuccess");
                SecurityCodeActivityImpl securityCodeActivityImpl = SecurityCodeActivityImpl.this;
                securityCodeActivityImpl.mAuthSuccess = true;
                securityCodeActivityImpl.closeSecurityGroup();
                SecurityCodeActivityImpl.this.openLoadingView();
                String hexString = ByteUtils.toHexString(bundle.getByteArray("stranger_specific_key"));
                if (SecurityCodeActivityImpl.this.getActivity() instanceof SecurityCodeActivityCallback) {
                    ((SecurityCodeActivityCallback) SecurityCodeActivityImpl.this.getActivity()).onAuthSuccess(SecurityCodeActivityImpl.this.mUwbScanDevice, hexString, SecurityCodeActivityImpl.this.mTvKey, SecurityCodeActivityImpl.this.mUid);
                }
            }

            public void onFailed(int i) {
                UwbLogUtil.d("Mijia-UWB-SecurityCodeActivityImpl", "UwbStrangerRegister onFailed: ".concat(String.valueOf(i)));
                if (-2 == i) {
                    SecurityCodeActivityImpl.this.closeSecurityGroup();
                    SecurityCodeActivityImpl.this.openTimeOutView(R.string.mj_uwb_security_code_timeout);
                } else if (-6 == i) {
                    SecurityCodeActivityImpl.this.runOnUiThread(new Runnable() {
                        /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass9.AnonymousClass1 */

                        public void run() {
                            Activity activity = SecurityCodeActivityImpl.this.getActivity();
                            if (activity != null) {
                                TextView textView = (TextView) activity.findViewById(R.id.code_info_tv);
                                ((SecurityCodeView) activity.findViewById(R.id.edit_security_code)).clearEditText();
                                textView.setTextColor(activity.getResources().getColor(R.color.security_code_error));
                                textView.setText((int) R.string.mj_uwb_security_code_error);
                                SecurityCodeActivityImpl.this.mHandler.postDelayed(SecurityCodeActivityImpl.this.mStartAuthRunnable, 1000);
                            }
                        }
                    });
                }
            }
        }, UwbConst.AppId.MI_LINK, UwbConst.Target.SEND_DATA_TO_HID);
        this.mStrangerRegister.startAuth();
    }

    /* access modifiers changed from: package-private */
    public void openTimeOutView(final int i) {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass10 */

            public void run() {
                final Activity activity = SecurityCodeActivityImpl.this.getActivity();
                if (activity != null) {
                    View findViewById = activity.findViewById(R.id.timeout_pop_l);
                    findViewById.setVisibility(0);
                    ((TextView) activity.findViewById(R.id.timeout_msg_tv)).setText(activity.getString(i));
                    UIUtils.initBottomMargin(activity, findViewById);
                    activity.findViewById(R.id.i_know_btn).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl.AnonymousClass10.AnonymousClass1 */

                        public void onClick(View view) {
                            activity.finish();
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Activity getActivity() {
        Activity activity = this.mWeakReference.get();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    /* access modifiers changed from: package-private */
    public void runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(runnable);
        }
    }

    public void onDestroy() {
        UwbStrangerRegister uwbStrangerRegister;
        if (!this.mAuthSuccess && (uwbStrangerRegister = this.mStrangerRegister) != null) {
            uwbStrangerRegister.stopAuth();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        closeLoadingView();
    }

    public boolean needExitUwb() {
        UwbLogUtil.w("Mijia-UWB-SecurityCodeActivityImpl", "UwbLogUtilPlus securitycodeactivity  needExitUwb: " + this.mExitUwb);
        return this.mExitUwb;
    }
}
