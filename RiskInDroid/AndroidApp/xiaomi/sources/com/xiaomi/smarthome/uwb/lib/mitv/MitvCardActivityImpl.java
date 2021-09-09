package com.xiaomi.smarthome.uwb.lib.mitv;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.api.UwbMitvApi;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbDataListener;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvNotif;
import com.xiaomi.smarthome.uwb.lib.mitv.parse.IMitvDataParseCB;
import com.xiaomi.smarthome.uwb.lib.mitv.parse.TVUwbDataBuilder;
import com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class MitvCardActivityImpl {
    public final String TAG = MitvCardActivityImpl.class.getCanonicalName();
    UwbConEngine.IEngineStateCallback mEngineStateCallback = new UwbConEngine.IEngineStateCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass3 */

        public void onRetryKeyRetrieve() {
        }

        public void onConnEstablished() {
            UwbLogUtil.w(MitvCardActivityImpl.this.TAG, "UwbLogUtilPlus IEngineStateCallback onConnEstablished");
            if (MitvCardActivityImpl.this.mIsPlugin) {
                UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-9-plus-card-ready:" + System.currentTimeMillis());
            } else {
                UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-9-mijia-card-ready:" + System.currentTimeMillis());
            }
            MitvCardActivityImpl mitvCardActivityImpl = MitvCardActivityImpl.this;
            mitvCardActivityImpl.mUwbReady = true;
            mitvCardActivityImpl.onUwbConnected();
            MitvCardActivityImpl.this.mMitvCardView.setBlueToothReady(true);
        }

        public void onConnectionError(final int i, final String str) {
            MitvCardActivityImpl.this.runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass3.AnonymousClass1 */

                public void run() {
                    String str = MitvCardActivityImpl.this.TAG;
                    UwbLogUtil.w(str, "UwbLogUtilPlus onConnectionError: " + i + " msg: " + str);
                    Toast.makeText(UwbSdk.getApplication(), UwbSdk.getApplication().getText(R.string.mj_uwb_connect_fail), 1).show();
                    if (MitvCardActivityImpl.this.getActivity() != null) {
                        MitvCardActivityImpl.this.getActivity().finish();
                    }
                }
            });
        }

        public void onEstablishSecurityError(final int i, final String str) {
            MitvCardActivityImpl.this.runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass3.AnonymousClass2 */

                public void run() {
                    String str = MitvCardActivityImpl.this.TAG;
                    UwbLogUtil.w(str, "UwbLogUtilPlus onEstablishSecurityError: " + i + " msg: " + str);
                    Toast.makeText(UwbSdk.getApplication(), UwbSdk.getApplication().getText(R.string.mj_uwb_connect_fail), 1).show();
                    if (MitvCardActivityImpl.this.getActivity() != null) {
                        MitvCardActivityImpl.this.getActivity().finish();
                    }
                }
            });
        }

        public void onSwitchCommunication(int i, String str) {
            UwbLogUtil.w(MitvCardActivityImpl.this.TAG, "UwbLogUtilPlus onSwitchCommunication: ".concat(String.valueOf(i)));
            if (i == 0) {
                MitvCardActivityImpl.this.mMitvCardView.setBlueToothReady(true);
            }
        }
    };
    Runnable mExitRunning = new Runnable() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass1 */

        public void run() {
            if (MitvCardActivityImpl.this.getActivity() != null) {
                MitvCardActivityImpl.this.getActivity().finish();
            }
        }
    };
    Handler mHandler;
    boolean mHasLog = false;
    boolean mIsPlugin;
    MitvCardCallback mMitvCardCallback;
    MitvCardView mMitvCardView;
    MitvInfo mMitvInfo;
    int mReqTvInfoCnt = 0;
    Runnable mReqTvInfoRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass2 */

        public void run() {
            if (MitvCardActivityImpl.this.mMitvInfo != null && TextUtils.isEmpty(MitvCardActivityImpl.this.mMitvInfo.getTvName()) && MitvCardActivityImpl.this.mReqTvInfoCnt < 2) {
                UwbLogUtil.d(MitvCardActivityImpl.this.TAG, "UwbLogUtilPlus reqTvInfo, again");
                MitvCardActivityImpl.this.mReqTvInfoCnt++;
                UwbMitvApi.reqTvInfo();
                MitvCardActivityImpl.this.mHandler.postDelayed(this, 1000);
            }
        }
    };
    View.OnClickListener mStatOnClickListener;
    View mTagUpgradePopLayout;
    UwbDataListener mUWBDataListener = new UwbDataListener() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass4 */

        public void onConnectionState(String str, int i) {
        }

        public void onSendPayload(int i) {
        }

        public void onPayloadReceived(Payload payload) {
            String str = MitvCardActivityImpl.this.TAG;
            UwbLogUtil.w(str, "UwbLogUtilPlus onPayloadReceived: " + TVUwbDataBuilder.byteArrToString(payload.getData()));
            UwbMitvApi.parsePayload(payload, new IMitvDataParseCB() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass4.AnonymousClass1 */

                public void onFailed(int i, String str) {
                }

                public void onSuccess(MitvInfo mitvInfo, final MitvNotif mitvNotif) {
                    if (mitvInfo != null) {
                        if (!TextUtils.isEmpty(mitvInfo.getBleMac())) {
                            UwbLogUtil.w(MitvCardActivityImpl.this.TAG, "UwbLogUtilPlus saveMitvBleMac");
                            MitvCardActivityImpl.this.mMitvCardCallback.saveMitvBleMac(mitvInfo.getBleMac());
                        }
                        if (MitvCardActivityImpl.this.mMitvInfo == null) {
                            MitvCardActivityImpl.this.mMitvInfo = mitvInfo;
                            if (mitvInfo.getScreenOn() != null && mitvInfo.getScreenOn().equalsIgnoreCase("1")) {
                                UwbMitvApi.doKeyEvent(26);
                            } else if (!MitvCardActivityImpl.this.mIsPlugin) {
                                UwbMitvApi.reqPlayerInfo();
                            }
                        } else {
                            MitvCardActivityImpl.this.mMitvInfo.merge(mitvInfo);
                        }
                        MitvCardActivityImpl.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                MitvCardActivityImpl.this.refreshUI();
                            }
                        });
                    }
                    if (mitvNotif != null) {
                        MitvCardActivityImpl.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                MitvCardActivityImpl.this.onNotif(mitvNotif);
                            }
                        });
                    }
                }
            });
        }
    };
    boolean mUwbReady = false;
    UwbScanDevice mUwbScanDevice;
    WeakReference<Activity> mWeakReference;

    public boolean onCreate(Activity activity, MitvCardCallback mitvCardCallback, boolean z) {
        this.mWeakReference = new WeakReference<>(activity);
        this.mMitvCardCallback = mitvCardCallback;
        this.mIsPlugin = z;
        try {
            this.mUwbScanDevice = UwbScanDevice.parse(new JSONObject(activity.getIntent().getStringExtra("UWB_SCAN_DEVICE")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = this.TAG;
        UwbLogUtil.w(str, "UwbLogUtilPlus mUwbScanDevice: " + this.mUwbScanDevice);
        if (this.mUwbScanDevice == null) {
            activity.finish();
            return false;
        }
        this.mMitvCardCallback.setContentView();
        initUI();
        this.mMitvCardCallback.startShowAni();
        this.mHandler = new Handler(Looper.getMainLooper());
        UwbApi.getInstance().isEngineReady(this.mEngineStateCallback);
        return true;
    }

    public void setmStatOnClickListener(View.OnClickListener onClickListener) {
        this.mStatOnClickListener = onClickListener;
        MitvCardView mitvCardView = this.mMitvCardView;
        if (mitvCardView != null) {
            mitvCardView.setmStatOnClickListener(this.mStatOnClickListener);
        }
    }

    public void onStart() {
        if (this.mUwbReady) {
            UwbIdmManager.getInstance().addUWBDataListener(this.mUWBDataListener);
        }
    }

    public void onStop() {
        UwbIdmManager.getInstance().removeUWBDataListener(this.mUWBDataListener);
    }

    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && !this.mHasLog) {
            this.mHasLog = true;
            if (this.mIsPlugin) {
                UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-8-plus-card-complete:" + System.currentTimeMillis());
                return;
            }
            UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-8-mijia-card-complete:" + System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: package-private */
    public void onUwbConnected() {
        if (getActivity() != null) {
            UwbLogUtil.w(this.TAG, "UwbLogUtilPlus onUwbConnected");
            UwbIdmManager.getInstance().addUWBDataListener(this.mUWBDataListener);
            UwbMitvApi.reqTvInfo();
            this.mReqTvInfoCnt = 0;
            this.mHandler.postDelayed(this.mReqTvInfoRunnable, 1000);
        }
    }

    /* access modifiers changed from: package-private */
    public void initUI() {
        if (getActivity() != null) {
            this.mTagUpgradePopLayout = getActivity().findViewById(R.id.tag_upgrade_pop_l);
            this.mMitvCardView = (MitvCardView) getActivity().findViewById(R.id.tvcard_v);
            View.OnClickListener onClickListener = this.mStatOnClickListener;
            if (onClickListener != null) {
                this.mMitvCardView.setmStatOnClickListener(onClickListener);
            }
            if (UwbDeviceUtil.isMitvLogin(this.mUwbScanDevice)) {
                this.mMitvCardView.hideMoreView();
            } else {
                this.mMitvCardView.showLoginView(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass5 */

                    public void onClick(View view) {
                        MitvCardActivityImpl.this.mMitvCardCallback.onLoginClick();
                    }
                });
            }
            if (UwbDeviceUtil.isTagPower(this.mUwbScanDevice)) {
                this.mMitvCardView.showTagPowerTv(false, null);
            } else {
                this.mMitvCardView.showTagPowerTv(true, new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass6 */

                    public void onClick(View view) {
                        if (MitvCardActivityImpl.this.getActivity() != null) {
                            MitvCardActivityImpl.this.getActivity().findViewById(R.id.power_off_pop_l).setVisibility(0);
                            MitvCardActivityImpl.this.getActivity().findViewById(R.id.know_it_btn).setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass6.AnonymousClass1 */

                                public void onClick(View view) {
                                    if (MitvCardActivityImpl.this.getActivity() != null) {
                                        MitvCardActivityImpl.this.getActivity().findViewById(R.id.power_off_pop_l).setVisibility(8);
                                    }
                                }
                            });
                        }
                    }
                });
            }
            getActivity().findViewById(R.id.power_iv).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass7 */

                public void onClick(View view) {
                    if (MitvCardActivityImpl.this.mMitvInfo != null) {
                        if (MitvCardActivityImpl.this.mStatOnClickListener != null) {
                            MitvCardActivityImpl.this.mStatOnClickListener.onClick(view);
                        }
                        int mitvPowerStatus = UwbDeviceUtil.getMitvPowerStatus(MitvCardActivityImpl.this.mMitvInfo);
                        UwbLogUtil.w(MitvCardActivityImpl.this.TAG, "UwbLogUtilPlus on power click: ".concat(String.valueOf(mitvPowerStatus)));
                        if (1 == mitvPowerStatus) {
                            UwbMitvApi.doKeyEvent(26);
                            MitvCardActivityImpl.this.switchPowerLayout(false);
                        } else if (2 == mitvPowerStatus) {
                            UwbMitvApi.doKeyEvent(26);
                            MitvCardActivityImpl.this.mHandler.postDelayed(MitvCardActivityImpl.this.mExitRunning, 2000);
                        }
                    }
                }
            });
            UIUtils.initBottomMargin(getActivity(), getActivity().findViewById(R.id.power_off_pop_l));
            UIUtils.initBottomMargin(getActivity(), getActivity().findViewById(R.id.tag_upgrade_pop_l));
            UIUtils.initBottomMargin(getActivity(), getActivity().findViewById(R.id.mitv_power_l));
            UIUtils.initBottomMargin(getActivity(), getActivity().findViewById(R.id.tvcard_l));
            this.mMitvCardCallback.initUI();
        }
    }

    /* access modifiers changed from: package-private */
    public void switchPowerLayout(boolean z) {
        if (getActivity() != null) {
            if (!z) {
                getActivity().findViewById(R.id.tvcard_l).setVisibility(8);
                getActivity().findViewById(R.id.mitv_power_l).setVisibility(0);
                ((TextView) getActivity().findViewById(R.id.mitv_state_tv)).setText((int) R.string.mj_uwb_mitv_control_power_off);
                ((LottieAnimationView) getActivity().findViewById(R.id.mitv_poster_lotiew)).setAnimation("lottie/tv_card_power_anim.json");
                getActivity().findViewById(R.id.screen_on_iv).setClickable(true);
                getActivity().findViewById(R.id.screen_on_iv).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass8 */

                    public void onClick(View view) {
                        MitvCardActivityImpl.this.onPowerBtnClicked();
                        if (MitvCardActivityImpl.this.mStatOnClickListener != null) {
                            MitvCardActivityImpl.this.mStatOnClickListener.onClick(view);
                        }
                    }
                });
                return;
            }
            getActivity().findViewById(R.id.tvcard_l).setVisibility(0);
            getActivity().findViewById(R.id.mitv_power_l).setVisibility(8);
            ((LottieAnimationView) getActivity().findViewById(R.id.mitv_poster_lotiew)).cancelAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPowerBtnClicked() {
        UwbMitvApi.doKeyEvent(26);
        ((TextView) getActivity().findViewById(R.id.mitv_state_tv)).setText((int) R.string.mj_uwb_mitv_control_power_oning);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getActivity().findViewById(R.id.mitv_poster_lotiew);
        lottieAnimationView.setAnimation("lottie/tv_card_power_anim.json");
        lottieAnimationView.setRepeatCount(Integer.MAX_VALUE);
        lottieAnimationView.setRepeatMode(2);
        lottieAnimationView.playAnimation();
    }

    /* access modifiers changed from: package-private */
    public void refreshUI() {
        this.mMitvCardView.refreshUI(this.mMitvInfo);
        this.mMitvCardCallback.refreshUI();
    }

    /* access modifiers changed from: package-private */
    public void onNotif(MitvNotif mitvNotif) {
        if (getActivity() != null) {
            if ("notifyTagOtaUpgradeInfo".equalsIgnoreCase(mitvNotif.getmNotif())) {
                openTagUpgradeView(mitvNotif);
            } else if ("notifyScreenState".equalsIgnoreCase(mitvNotif.getmNotif())) {
                UwbLogUtil.w(this.TAG, "UwbLogUtilPlus NotifyScreenState");
                if (TextUtils.equals(mitvNotif.getmParam().get("screenOn"), "0")) {
                    if (getActivity().findViewById(R.id.tvcard_l).getVisibility() != 0) {
                        switchPowerLayout(true);
                    }
                    UwbMitvApi.reqPlayerInfo();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void openTagUpgradeView(MitvNotif mitvNotif) {
        if (getActivity() != null) {
            this.mTagUpgradePopLayout.setVisibility(0);
            Map<String, String> map = mitvNotif.getmParam();
            ((TextView) getActivity().findViewById(R.id.tag_upgrade_title_tv)).setText(this.mMitvInfo.getTvName());
            ((TextView) getActivity().findViewById(R.id.tag_upgrade_info_tv)).setText(getActivity().getString(R.string.mj_uwb_tag_has_upgrade_version, new Object[]{map.get("tagLatestVer")}));
            getActivity().findViewById(R.id.upgrade_ignore_btn).setClickable(true);
            getActivity().findViewById(R.id.upgrade_ignore_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass9 */

                public void onClick(View view) {
                    MitvCardActivityImpl.this.onTagUpgradeIgnore();
                }
            });
            getActivity().findViewById(R.id.upgrade_accept_btn).setClickable(true);
            getActivity().findViewById(R.id.upgrade_accept_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl.AnonymousClass10 */

                public void onClick(View view) {
                    MitvCardActivityImpl.this.onUpgradeAccept();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void onTagUpgradeIgnore() {
        this.mTagUpgradePopLayout.setVisibility(8);
        UwbMitvApi.doUpgradeTag(0);
    }

    /* access modifiers changed from: package-private */
    public void onUpgradeAccept() {
        this.mTagUpgradePopLayout.setVisibility(8);
        UwbMitvApi.doUpgradeTag(1);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (getActivity() != null) {
            if (1 == i) {
                if (iArr.length > 0 && iArr[0] == -1) {
                    Toast.makeText(getActivity(), getActivity().getString(R.string.mj_uwb_record_permission_denied), 1).show();
                }
            } else if (2 == i && iArr.length > 0 && iArr[0] == -1) {
                Toast.makeText(getActivity(), getActivity().getString(R.string.mj_uwb_camera_permission_denied), 1).show();
            }
        }
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

    public UwbScanDevice getmUwbScanDevice() {
        return this.mUwbScanDevice;
    }

    public MitvInfo getmMitvInfo() {
        return this.mMitvInfo;
    }

    public MitvCardView getmMitvCardView() {
        return this.mMitvCardView;
    }
}
