package com.xiaomi.smarthome.device.authorization.page;

import _m_j.ee;
import _m_j.eya;
import _m_j.fai;
import _m_j.faj;
import _m_j.fak;
import _m_j.fmh;
import _m_j.fno;
import _m_j.gqg;
import _m_j.gsy;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.authlib.IAuthCallBack;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;

public class DeviceAuthSlaveListActivity extends BaseActivity {
    private static final String O00000oO = "DeviceAuthSlaveListActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f7084O000000o = false;
    boolean O00000Oo = false;
    String O00000o;
    boolean O00000o0 = false;
    private DeviceAuthFragment O00000oo;
    private IAuthCallBack O0000O0o = fak.O000000o().O00000oO;
    private String[] O0000OOo;
    private boolean O0000Oo = false;
    private int O0000Oo0 = -1;
    @BindView(6773)
    LinearLayout commonWhiteEmptyView;
    public ee mFragmentManager;
    public Handler mHandler = new O000000o(this, (byte) 0);
    public XQProgressDialog mProcessDialog;
    @BindView(6517)
    TextView mThirdOkButton;
    @BindView(7578)
    TextView mTitleTextView;
    @BindView(7573)
    ImageView moduleA4ReturnBtn;

    public void onCreate(Bundle bundle) {
        faj faj;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            gsy.O000000o(LogType.GENERAL, "AuthManager", "DeviceAuthSlaveListActivity intent == null");
            finish();
        } else {
            this.O00000o = intent.getStringExtra("device_id");
            if (TextUtils.isEmpty(this.O00000o)) {
                gsy.O000000o(LogType.GENERAL, "AuthManager", "DeviceAuthSlaveListActivity TextUtils.isEmpty(mDid)");
                finish();
            } else if (fno.O000000o().O000000o(this.O00000o) == null) {
                gsy.O000000o(LogType.GENERAL, "AuthManager", "DeviceAuthSlaveListActivity cannot find device");
                gqg.O00000Oo((int) R.string.auth_no_match);
                finish();
            } else {
                this.O0000Oo0 = fak.O000000o().O0000O0o;
                this.O0000Oo = intent.getBooleanExtra("bottom_bar", false);
            }
        }
        setContentView((int) R.layout.activity_voicectrl);
        ButterKnife.bind(this);
        int i = this.O0000Oo0;
        if ((i == 2 || i == 6) && (faj = fak.O000000o().O00000Oo) != null) {
            this.mThirdOkButton.setText(getString(R.string.action_back) + faj.f16000O000000o);
        }
        this.moduleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthSlaveListActivity.AnonymousClass2 */

            public final void onClick(View view) {
                DeviceAuthSlaveListActivity.this.onBackPressed();
            }
        });
        ((TextView) this.commonWhiteEmptyView.findViewById(R.id.common_white_empty_text)).setText((int) R.string.no_data_tips);
        this.mFragmentManager = getSupportFragmentManager();
        this.O0000OOo = new String[]{getString(R.string.auth_contrl_device_title), getString(R.string.auth_contrl_scene_title)};
        this.O00000oo = new DeviceAuthFragment();
        this.mFragmentManager.O000000o().O000000o(R.id.fragment_container, this.O00000oo, this.O0000OOo[0]).O00000Oo();
        this.mThirdOkButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthSlaveListActivity.AnonymousClass3 */

            public final void onClick(View view) {
                DeviceAuthSlaveListActivity.this.onBackPressed();
            }
        });
        if (this.O0000Oo) {
            this.mThirdOkButton.setVisibility(0);
        } else {
            this.mThirdOkButton.setVisibility(8);
        }
        if (this.O0000Oo0 != -1) {
            eya.O000000o().O000000o(this);
        }
    }

    public void onBackPressed() {
        IAuthCallBack iAuthCallBack;
        if (this.f7084O000000o) {
            uploadDeviceAuth();
        }
        int i = this.O0000Oo0;
        if ((i == 2 || i == 6) && (iAuthCallBack = this.O0000O0o) != null) {
            try {
                iAuthCallBack.onSuccess(100, fai.O000000o(100));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            setResult(-1, new Intent());
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void showProgressDialog(String str) {
        this.mProcessDialog = new XQProgressDialog(this);
        this.mProcessDialog.setCancelable(true);
        this.mProcessDialog.setMessage(str);
        this.mProcessDialog.show();
        this.mProcessDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthSlaveListActivity.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
    }

    public void uploadDeviceAuth() {
        DeviceAuthFragment deviceAuthFragment = this.O00000oo;
        if (deviceAuthFragment != null && deviceAuthFragment.mRecyclerView != null) {
            if (TextUtils.equals(this.O00000oo.O0000o0, DeviceAuthFragment.f7054O000000o)) {
                fmh.O000000o().O000000o(this, this.O00000o, this.O00000oo.O0000OOo, this.O00000oo.O00000oo);
            } else if (TextUtils.equals(this.O00000oo.O0000o0, DeviceAuthFragment.O00000Oo)) {
                fmh.O000000o().O000000o(this, this.O00000o, this.O00000oo.O0000O0o);
            }
        }
    }

    public void setDeviceAuthChanged(boolean z) {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000);
        this.f7084O000000o = z;
    }

    public void setDeviceDataReady(boolean z, boolean z2) {
        this.O00000Oo = z;
        boolean z3 = !this.O00000Oo;
        if (isValid() && !z3) {
            if (this.mProcessDialog != null) {
                getWindow().getDecorView().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthSlaveListActivity.AnonymousClass4 */

                    public final void run() {
                        if (DeviceAuthSlaveListActivity.this.mProcessDialog != null) {
                            DeviceAuthSlaveListActivity.this.mProcessDialog.dismiss();
                        }
                    }
                }, 500);
            }
            if (!z2) {
                gqg.O00000Oo((int) R.string.home_set_failed);
            }
        }
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<DeviceAuthSlaveListActivity> f7089O000000o;

        /* synthetic */ O000000o(DeviceAuthSlaveListActivity deviceAuthSlaveListActivity, byte b) {
            this(deviceAuthSlaveListActivity);
        }

        private O000000o(DeviceAuthSlaveListActivity deviceAuthSlaveListActivity) {
            this.f7089O000000o = new WeakReference<>(deviceAuthSlaveListActivity);
        }

        public final void handleMessage(Message message) {
            DeviceAuthSlaveListActivity deviceAuthSlaveListActivity;
            WeakReference<DeviceAuthSlaveListActivity> weakReference = this.f7089O000000o;
            if (weakReference != null && (deviceAuthSlaveListActivity = weakReference.get()) != null && message.what == 1) {
                deviceAuthSlaveListActivity.uploadDeviceAuth();
            }
        }
    }
}
