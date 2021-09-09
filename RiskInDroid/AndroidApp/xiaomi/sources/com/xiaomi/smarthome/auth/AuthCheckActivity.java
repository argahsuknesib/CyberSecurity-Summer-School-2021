package com.xiaomi.smarthome.auth;

import _m_j.eya;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.fai;
import _m_j.faj;
import _m_j.fak;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ggb;
import _m_j.gge;
import _m_j.gof;
import _m_j.gsy;
import _m_j.gty;
import _m_j.hor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.auth.model.AuthCallBackInfo;
import com.xiaomi.smarthome.authlib.IAuthCallBack;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.authorization.page.DeviceAuthSlaveListActivity;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;

public class AuthCheckActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f4234O000000o;
    XQProgressDialog O00000Oo;
    fno.O000000o O00000o = new fno.O000000o() {
        /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass10 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            gsy.O000000o(LogType.GENERAL, "AuthManager", "onRefreshClientDeviceSuccesstype   ".concat(String.valueOf(i)));
            if (i == 3) {
                AuthCheckActivity authCheckActivity = AuthCheckActivity.this;
                authCheckActivity.isDeviceReady = true;
                if (authCheckActivity.isDeviceReady && AuthCheckActivity.this.isHomeReady) {
                    AuthCheckActivity.this.appDataFreshSuccess();
                }
            }
        }
    };
    View.OnClickListener O00000o0 = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass9 */

        public final void onClick(View view) {
            int i = AuthCheckActivity.this.mRequestCode;
            if (i == 2) {
                Intent intent = new Intent(ServiceApplication.getAppContext(), DeviceAuthSlaveListActivity.class);
                AuthCheckActivity.this.mData.putBoolean("bottom_bar", true);
                intent.putExtras(AuthCheckActivity.this.mData);
                AuthCheckActivity.this.startActivity(intent);
                AuthCheckActivity.this.finish();
            } else if (i == 4) {
                AuthCheckActivity.this.goRequestPage();
            } else if (i == 6) {
                String string = AuthCheckActivity.this.mData.getString("device_id");
                if (TextUtils.isEmpty(string) || fno.O000000o().O000000o(string) == null || !fno.O000000o().O000000o(string).isOnline) {
                    fbt fbt = new fbt(AuthCheckActivity.this, "SmartConfigMainActivity");
                    if (AuthCheckActivity.this.getIntent() != null) {
                        fbt.O000000o("connect_source", AuthCheckActivity.this.getIntent().getIntExtra("connect_source", 0));
                        fbt.O000000o("connect_unique", AuthCheckActivity.this.getIntent().getStringExtra("connect_unique"));
                    }
                    fbt.O000000o("did", AuthCheckActivity.this.mData.getString("device_id"));
                    fbt.O000000o("strategy_id", 10);
                    if (AuthCheckActivity.this.mData.getString("device_bind_key") != null) {
                        fbt.O000000o("bind_key", AuthCheckActivity.this.mData.getString("device_bind_key"));
                    } else {
                        fbt.O000000o("token", AuthCheckActivity.this.mData.getString("device_token"));
                        fbt.O000000o().putLong("timestamp", AuthCheckActivity.this.mData.getLong("token_timestamp"));
                        fbt.O000000o("sn", AuthCheckActivity.this.mData.getString("device_sn"));
                    }
                    fbs.O000000o(fbt);
                    AuthCheckActivity.this.finish();
                    return;
                }
                Intent intent2 = new Intent(ServiceApplication.getAppContext(), DeviceAuthSlaveListActivity.class);
                AuthCheckActivity.this.mData.putString("device_id", string);
                AuthCheckActivity.this.mData.putBoolean("bottom_bar", true);
                fak.O000000o().O0000O0o = 2;
                intent2.putExtras(AuthCheckActivity.this.mData);
                AuthCheckActivity.this.startActivity(intent2);
                AuthCheckActivity.this.finish();
            }
        }
    };
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o = "-1";
    private BroadcastReceiver O0000OOo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "home_room_updated") && TextUtils.equals("home_room_sync", intent.getStringExtra("operation"))) {
                if (intent.getIntExtra("result_code", -1) == ErrorCode.SUCCESS.getCode()) {
                    AuthCheckActivity authCheckActivity = AuthCheckActivity.this;
                    authCheckActivity.isHomeReady = true;
                    if (authCheckActivity.isDeviceReady && AuthCheckActivity.this.isHomeReady) {
                        AuthCheckActivity.this.appDataFreshSuccess();
                        return;
                    }
                    return;
                }
                AuthCheckActivity.this.appDataFreshFail();
            }
        }
    };
    private MLAlertDialog O0000Oo0;
    public boolean hasGotoLogin = false;
    public boolean isDeviceReady = false;
    public boolean isHomeReady = false;
    @BindView(6474)
    TextView mAppDescTV;
    @BindView(6475)
    SimpleDraweeView mAppIconIV;
    @BindView(6476)
    TextView mAppNameTV;
    public IAuthCallBack mCallBack;
    @BindView(6477)
    TextView mConfigTV;
    public Bundle mData;
    public int mRequestCode = -1;
    @BindView(7578)
    TextView mTitle;
    @BindView(7573)
    ImageView mTitleReturn;

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_auth_check_layout);
        ButterKnife.bind(this);
        this.mTitle.setText((int) R.string.outer_auth_request);
        this.mTitleReturn.setVisibility(8);
        Intent intent = getIntent();
        intent.setExtrasClassLoader(IAuthCallBack.class.getClassLoader());
        if (intent != null) {
            fak.O0000Oo0 = intent.getIntExtra("sdk_version_code", -1);
        }
        if (fak.O0000Oo0 >= 7) {
            fak.O000000o();
            fak.O00000o();
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                fak.O000000o().O00000oO = ((AuthCallBackInfo) extras.getParcelable("extra_auth_callback")).mAuthCallBack;
                fak.O000000o().O00000oo = extras;
                fak.O000000o().O0000O0o = extras.getInt("request_auth_code");
            }
        }
        eya.O000000o().O00000Oo();
        eya.O000000o().f15942O000000o = true;
        eya.O000000o().O000000o(this);
        this.mCallBack = fak.O000000o().O00000oO;
        this.mData = fak.O000000o().O00000oo;
        Bundle bundle2 = this.mData;
        if (bundle2 != null) {
            this.O0000O0o = bundle2.getString("extra_user_id", "-1");
        }
        fno.O000000o().O000000o(this.O00000o);
        if (O000000o(this.mData)) {
            ezt.O000000o().startCheck(new ezq() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass3 */

                public final void O000000o() {
                    AuthCheckActivity.this.exitAuth();
                }

                public final void O00000Oo() {
                    AuthCheckActivity.this.exitAuth();
                }

                public final void O00000o0() {
                    gsy.O000000o(6, "AuthManager", "onAllFinished");
                    if (AuthCheckActivity.this.isValid()) {
                        AuthCheckActivity.this.showProgressDialog();
                    }
                    CoreApi.O000000o().O000000o(AuthCheckActivity.this, new CoreApi.O0000o0() {
                        /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass3.AnonymousClass1 */

                        public final void onCoreReady() {
                            gsy.O000000o(6, "AuthManager", "onCoreReady");
                            if (AuthCheckActivity.this.isValid()) {
                                AuthCheckActivity.this.doWork();
                            }
                        }
                    });
                }
            });
        } else {
            exitAuth();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("home_room_updated");
        ft.O000000o(this).O000000o(this.O0000OOo, intentFilter);
    }

    private boolean O000000o(Bundle bundle) {
        if (bundle != null) {
            try {
                this.f4234O000000o = bundle.getString("extra_application_id");
                this.O00000oO = bundle.getString("extra_package_name");
                this.O00000oo = bundle.getString("extra_app_sign");
                this.mRequestCode = bundle.getInt("request_auth_code");
                gsy.O000000o(6, "AuthManager", "mRequestCode" + this.mRequestCode);
                fak.O0000Oo0 = bundle.getInt("sdk_version_code", -1);
                fak.O0000Oo = bundle.getString("sdk_version_name", "-1");
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "AuthManager", "mAppSign  " + this.O00000oo);
                LogType logType2 = LogType.GENERAL;
                gsy.O000000o(logType2, "AuthManager", "mPackageName  " + this.O00000oO);
                LogType logType3 = LogType.GENERAL;
                gsy.O000000o(logType3, "AuthManager", "appId  " + this.f4234O000000o);
                StringBuilder sb = new StringBuilder("callback == null");
                sb.append(fak.O000000o().O00000oO == null);
                sb.append(fak.O000000o().O00000oO);
                gsy.O000000o(6, "AuthManager", sb.toString());
                if (fak.O0000Oo0 <= 8) {
                    if (fak.O0000Oo0 >= 4) {
                        if (!TextUtils.isEmpty(this.f4234O000000o) || this.mCallBack == null) {
                            fak.O000000o();
                            if (!fak.O00000Oo(this.O00000oO) && this.mCallBack != null) {
                                this.mCallBack.onFail(-100, fai.O000000o(-100));
                                return false;
                            } else if (!TextUtils.isEmpty(this.O00000oo) || this.mCallBack == null) {
                                if (this.mRequestCode != -1) {
                                    if (this.mRequestCode != 4) {
                                        if (this.mRequestCode == 2) {
                                            if (TextUtils.isEmpty(this.mData.getString("device_id"))) {
                                                this.mCallBack.onFail(-109, fai.O000000o(-109));
                                                return false;
                                            }
                                            LogType logType4 = LogType.GENERAL;
                                            gsy.O000000o(logType4, "AuthManager", "did  " + this.mData.getString("device_id"));
                                        } else if (this.mRequestCode == 6 && TextUtils.isEmpty(this.mData.getString("device_id"))) {
                                            this.mCallBack.onFail(-109, fai.O000000o(-112));
                                            return false;
                                        }
                                        fak.O000000o().O00000o = this.O00000oo;
                                        fak.O000000o().O00000o0 = this.O00000oO;
                                        fak.O000000o().f16002O000000o = this.f4234O000000o;
                                    }
                                }
                                if (this.mCallBack != null) {
                                    this.mCallBack.onFail(-108, fai.O000000o(-108));
                                    return false;
                                }
                                fak.O000000o().O00000o = this.O00000oo;
                                fak.O000000o().O00000o0 = this.O00000oO;
                                fak.O000000o().f16002O000000o = this.f4234O000000o;
                            } else {
                                this.mCallBack.onFail(-105, fai.O000000o(-105));
                                return false;
                            }
                        } else {
                            this.mCallBack.onFail(-104, fai.O000000o(-104));
                            return false;
                        }
                    }
                }
                this.mCallBack.onFail(-114, fai.O000000o(-114));
                return false;
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        } else if (this.mCallBack != null) {
            this.mCallBack.onFail(-101, fai.O000000o(-101));
            return false;
        }
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.hasGotoLogin) {
            if (isValid()) {
                showProgressDialog();
                doWork();
            }
            this.hasGotoLogin = false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fak.O000000o(_m_j.fsm, boolean):void
     arg types: [com.xiaomi.smarthome.auth.AuthCheckActivity$8, int]
     candidates:
      _m_j.fak.O000000o(java.lang.String, _m_j.fsm):_m_j.fsn
      _m_j.fak.O000000o(java.util.List<java.lang.String>, _m_j.fsm):_m_j.fsn
      _m_j.fak.O000000o(_m_j.fsm, boolean):void */
    public void doWork() {
        if (!CoreApi.O000000o().O0000Ooo()) {
            O000000o();
            new MLAlertDialog.Builder(this).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AuthCheckActivity.this.gotoLoginPage();
                    AuthCheckActivity.this.hasGotoLogin = true;
                    dialogInterface.dismiss();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    AuthCheckActivity.this.exitAuth();
                }
            }).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AuthCheckActivity.this.exitAuth();
                }
            }).O00000Oo((int) R.string.loing_helper_title).O00000oo();
        } else if (!gof.O00000o0()) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass7 */

                public final void run() {
                    if (AuthCheckActivity.this.mCallBack != null) {
                        try {
                            AuthCheckActivity.this.mCallBack.onFail(-116, fai.O000000o(-116));
                            AuthCheckActivity.this.exitAuth();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    AuthCheckActivity.this.exitAuth();
                }
            }, 1000);
        } else {
            gsy.O000000o(LogType.GENERAL, "AuthManager", "initData");
            fak.O000000o().O000000o((fsm) new fsm() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass8 */

                public final void onSuccess(Object obj) {
                    gsy.O000000o(6, "AuthManager", "updateAuthDefaultInfo  onSuccess");
                    fak O000000o2 = fak.O000000o();
                    int i = AuthCheckActivity.this.mRequestCode;
                    boolean z = false;
                    if (O000000o2.O00000Oo != null && O000000o2.O00000Oo.O00000oo != null && O000000o2.O00000Oo.O00000oo.size() != 0) {
                        List<faj.O000000o> list = O000000o2.O00000Oo.O00000oo;
                        if (i == 4) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= list.size()) {
                                    break;
                                } else if (list.get(i2).f16001O000000o == 4) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else if (i != 2) {
                            if (i == 6) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= list.size()) {
                                        break;
                                    } else if (list.get(i3).f16001O000000o == 6) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        }
                        z = true;
                    }
                    if (!z) {
                        try {
                            AuthCheckActivity.this.mCallBack.onFail(-111, fai.O000000o(-111));
                            AuthCheckActivity.this.exitAuth();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    fno.O000000o().O0000Oo0();
                    ggb.O00000Oo().O00000o0();
                }

                public final void onFailure(final fso fso) {
                    AuthCheckActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            if (AuthCheckActivity.this.mCallBack != null) {
                                try {
                                    if (fso != null) {
                                        if (!TextUtils.isEmpty(fso.O00000Oo)) {
                                            String str = fso.O00000Oo;
                                            gsy.O000000o(6, "AuthManager", "error msg".concat(String.valueOf(str)));
                                            if (str.equalsIgnoreCase("unknown app")) {
                                                AuthCheckActivity.this.mCallBack.onFail(-104, fai.O000000o(-104));
                                            } else if (str.equalsIgnoreCase("invalid package name")) {
                                                AuthCheckActivity.this.mCallBack.onFail(-100, fai.O000000o(-100));
                                            } else if (str.equalsIgnoreCase("invalid package sign")) {
                                                AuthCheckActivity.this.mCallBack.onFail(-105, fai.O000000o(-105));
                                            } else {
                                                AuthCheckActivity.this.mCallBack.onFail(-107, fai.O000000o(-107));
                                            }
                                        }
                                    }
                                    AuthCheckActivity.this.mCallBack.onFail(-107, fai.O000000o(-107));
                                    gsy.O000000o(6, "AuthManager", "error == null");
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                            AuthCheckActivity.this.exitAuth();
                        }
                    }, 1000);
                }
            }, true);
        }
    }

    public void showProgressDialog() {
        this.O00000Oo = new XQProgressDialog(this);
        this.O00000Oo.setCancelable(false);
        this.O00000Oo.setMessage(getResources().getString(R.string.loading_share_info));
        this.O00000Oo.show();
    }

    private void O000000o() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public void gotoLoginPage() {
        gge.O000000o().O00000Oo();
        fno.O000000o().O0000Oo();
        hor.O000000o().clearScenedata();
        fno.O000000o().O0000Oo0();
        ggb.O00000Oo().O00000o0();
        sendBroadcast(new Intent("update_remote_wifi_log"));
        gty.O000000o().startLogin(CommonApplication.getAppContext(), 3, null);
    }

    public void goRequestPage() {
        if (this.mRequestCode == 4) {
            Intent intent = new Intent(this, ThirdAuthMainActivity.class);
            intent.putExtras(this.mData);
            startActivity(intent);
            finish();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        IAuthCallBack iAuthCallBack = this.mCallBack;
        if (iAuthCallBack != null) {
            try {
                iAuthCallBack.onFail(-106, fai.O000000o(-106));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        exitAuth();
    }

    public void exitAuth() {
        fak.O000000o();
        fak.O00000o();
        finish();
    }

    public void appDataFreshSuccess() {
        CharSequence charSequence;
        O000000o();
        this.mAppIconIV.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(200).setPlaceholderImage(getResources().getDrawable(R.drawable.ic_launcher)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setRoundingParams(RoundingParams.fromCornersRadius(20.0f)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        this.mAppIconIV.setBackgroundResource(R.color.mj_color_black_00_transparent);
        faj faj = fak.O000000o().O00000Oo;
        if (faj == null) {
            this.mAppIconIV.setImageURI(Uri.parse(""));
            this.mAppNameTV.setText("");
            this.mAppDescTV.setText("");
            this.mConfigTV.setText((int) R.string.auth_check_config);
        } else {
            this.mAppIconIV.setImageURI(Uri.parse(faj.O00000o0));
            this.mAppNameTV.setText(faj.f16000O000000o);
            this.mAppDescTV.setText(faj.O00000Oo);
            if (TextUtils.isEmpty(faj.O00000oO)) {
                this.mConfigTV.setText((int) R.string.auth_check_config);
            } else {
                this.mConfigTV.setText(faj.O00000oO);
            }
        }
        if (TextUtils.equals("-1", this.O0000O0o) || TextUtils.equals(CoreApi.O000000o().O0000o0(), this.O0000O0o)) {
            this.mConfigTV.setOnClickListener(this.O00000o0);
            return;
        }
        CharSequence text = this.mAppNameTV.getText();
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        MLAlertDialog mLAlertDialog = this.O0000Oo0;
        if (mLAlertDialog == null) {
            MLAlertDialog.Builder O000000o2 = builder.O000000o((int) R.string.account_error_title);
            Object[] objArr = new Object[1];
            if (text == null) {
                charSequence = "";
            } else {
                charSequence = text;
            }
            objArr[0] = charSequence;
            MLAlertDialog.Builder O00000Oo2 = O000000o2.O00000Oo(getString(R.string.account_error_msg, objArr));
            Object[] objArr2 = new Object[1];
            if (text == null) {
                text = "";
            }
            objArr2[0] = text;
            this.O0000Oo0 = O00000Oo2.O00000o0(getString(R.string.account_error_btn, objArr2), new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.AuthCheckActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AuthCheckActivity.this.exitAuth();
                }
            }).O00000oo();
        } else if (!mLAlertDialog.isShowing()) {
            this.O0000Oo0.show();
        }
    }

    public void appDataFreshFail() {
        if (isValid()) {
            O000000o();
        }
        IAuthCallBack iAuthCallBack = this.mCallBack;
        if (iAuthCallBack != null) {
            try {
                iAuthCallBack.onFail(-116, fai.O000000o(-116));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        exitAuth();
    }

    public void onDestroy() {
        super.onDestroy();
        fno.O000000o().O00000Oo(this.O00000o);
        eya.O000000o().O00000Oo(this);
        ft.O000000o(this).O000000o(this.O0000OOo);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        gsy.O00000Oo("AuthManager", "onSaveInstanceState" + bundle.getParcelable("extra_auth_callback"));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        gsy.O00000Oo("AuthManager", "onRestoreInstanceState" + bundle.getParcelable("extra_auth_callback"));
    }
}
