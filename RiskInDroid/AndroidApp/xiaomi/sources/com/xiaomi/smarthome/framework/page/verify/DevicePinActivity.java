package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fmd;
import _m_j.fno;
import _m_j.fob;
import _m_j.fon;
import _m_j.fqx;
import _m_j.fwk;
import _m_j.gnl;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hyy;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public abstract class DevicePinActivity extends BaseActivity implements PinSoftKeyboard.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f7933O000000o;
    protected String O00000Oo;
    protected String O00000o;
    protected String O00000o0;
    protected String O00000oO;
    protected String O00000oo;
    protected fwk O0000O0o;
    TextView O0000OOo;
    View O0000Oo;
    TextView O0000Oo0;
    ImageView O0000OoO;
    TextView O0000Ooo;
    protected Device O0000o;
    TextView O0000o0;
    TextView O0000o00;
    TextView O0000o0O;
    TextView O0000o0o;
    protected VerifyGlobalManager O0000oO;
    protected boolean O0000oO0 = false;
    protected String O0000oOO;
    protected boolean O0000oOo;
    private ImageView O0000oo;
    private XQProgressDialog O0000oo0;
    private MLAlertDialog O0000ooO;
    public View mSecurePinFailedLayout;
    public int mSecurePinFailureCode;
    @BindView(6114)
    TextView vDesc;
    @BindView(6113)
    PinInputView vPinInputView;
    @BindView(6117)
    PinSoftKeyboard vPinSoftKeyboard;
    @BindView(6118)
    TextView vSubHint;

    /* access modifiers changed from: protected */
    public void O000000o(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(String str);

    /* access modifiers changed from: protected */
    public boolean O000000o() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void O00000Oo();

    /* access modifiers changed from: protected */
    public void O00000o() {
    }

    /* access modifiers changed from: protected */
    public abstract void O00000o0();

    public boolean invokeOnPinCodeInputFinishWhileOverInput() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000oOo = getIntent().getBooleanExtra("style_dialog", false);
        if (!this.O0000oOo) {
            overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        }
        O00000Oo(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        O00000Oo(intent);
    }

    private void O0000OOo() {
        this.O0000oo = (ImageView) findViewById(R.id.ble_secure_pin_faq);
        this.O0000Oo = findViewById(R.id.ble_secure_pin_connect_layout);
        this.O0000OoO = (ImageView) findViewById(R.id.connect_loading);
        this.mSecurePinFailedLayout = findViewById(R.id.ble_secure_pin_failed_layout);
        this.O0000Ooo = (TextView) findViewById(R.id.pin_failed_title);
        this.O0000o00 = (TextView) findViewById(R.id.pin_failed_text_1);
        this.O0000o0 = (TextView) findViewById(R.id.pin_failed_text_2);
        this.O0000o0O = (TextView) findViewById(R.id.pin_failed_text_3);
        this.O0000o0o = (TextView) findViewById(R.id.failed_retry_btn);
        this.O0000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass1 */

            public final void onClick(View view) {
                new MLAlertDialog.Builder(DevicePinActivity.this).O000000o((int) R.string.ble_secure_pin_code).O00000Oo((int) R.string.ble_secure_pin_code_tips).O000000o((int) R.string.reassure_ok, (DialogInterface.OnClickListener) null).O00000o().show();
            }
        });
        this.O0000o0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass2 */

            public final void onClick(View view) {
                if (DevicePinActivity.this.mSecurePinFailureCode == -6 || DevicePinActivity.this.mSecurePinFailureCode == -5) {
                    DevicePinActivity.this.reopenBluetooth();
                    return;
                }
                DevicePinActivity.this.mSecurePinFailedLayout.setVisibility(8);
                DevicePinActivity.this.vPinInputView.O00000Oo();
            }
        });
    }

    private void O00000Oo(Intent intent) {
        boolean z = false;
        this.O0000oO0 = intent.getBooleanExtra("verify_for_global_pin", false);
        this.f7933O000000o = intent.getStringExtra("extra_device_did");
        if (!TextUtils.isEmpty(this.f7933O000000o) && !this.O0000oO0) {
            this.O0000o = fno.O000000o().O000000o(this.f7933O000000o);
            Device device = this.O0000o;
            if (device == null) {
                gqg.O00000Oo("deviceId不能为空");
                setResult(0);
                finish();
                return;
            }
            if ((device.pinCodeType & 2) == 2) {
                z = true;
            }
            this.O0000oO0 = z;
        }
        this.O00000oo = intent.getStringExtra("xiaomi.smarthome.desc");
        if (O000000o() && !TextUtils.isEmpty(this.O00000oo)) {
            this.O00000o0 = this.O00000oo;
        }
        O000000o(intent);
        Device device2 = this.O0000o;
        if (device2 == null || !fqx.O000000o(device2.model, this.O0000o.version)) {
            if (this.O0000oOo) {
                hyy.O00000o0(this);
                if (hyy.O000000o()) {
                    setContentView((int) R.layout.mj_pad_dialog_device_pin);
                } else {
                    setContentView((int) R.layout.mj_dialog_device_pin);
                }
            } else {
                setContentView((int) R.layout.activity_device_pin);
                ((ImageView) findViewById(R.id.module_a_3_return_btn)).setImageResource(R.drawable.common_title_bar_cancel_b);
            }
            this.O0000OOo = (TextView) findViewById(R.id.xiaomi_sm_pin_inputs_title);
            this.O0000Oo0 = (TextView) findViewById(R.id.xiaomi_sm_pin_input_incorrect_tip);
        } else {
            setContentView((int) R.layout.activity_device_lock_secure_pin);
            this.O0000OOo = (TextView) findViewById(R.id.module_a_3_return_title);
            O0000OOo();
        }
        ButterKnife.bind(this);
        if (this.O0000oO0) {
            this.O0000oOO = CoreApi.O000000o().O0000o0();
            this.O0000oO = VerifyGlobalManager.O000000o(this);
        } else {
            this.O0000O0o = fwk.O000000o(this);
        }
        O00000Oo();
        this.O0000OOo.setText(this.O00000Oo);
        this.vDesc.setText(this.O00000o0);
        this.vPinSoftKeyboard.setClickListener(this);
        O00000o();
        O000000o(4);
    }

    public void onResume() {
        super.onResume();
        O000000o(0);
    }

    public void onPause() {
        super.onPause();
        O000000o(4);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
    }

    @OnClick({5470})
    public void onClickBack() {
        setResult(0);
        finish();
    }

    public void onNumberClick(int i) {
        String pinCode = this.vPinInputView.getPinCode();
        if (invokeOnPinCodeInputFinishWhileOverInput() || TextUtils.isEmpty(pinCode) || pinCode.length() < this.vPinInputView.getPincodeNumber()) {
            TextView textView = this.O0000Oo0;
            if (textView != null && textView.getVisibility() == 0) {
                this.O0000Oo0.setVisibility(4);
            }
            final String O000000o2 = this.vPinInputView.O000000o(i);
            if (O000000o2.length() >= this.vPinInputView.getPincodeNumber()) {
                new Handler(getMainLooper()).postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass3 */

                    public final void run() {
                        DevicePinActivity.this.O000000o(O000000o2);
                    }
                }, 100);
                return;
            }
            return;
        }
        gsy.O00000Oo("DevicePinActivity", "onNumberClick: pin code is over input, max length:" + this.vPinInputView.getPincodeNumber());
    }

    public void onBackClick() {
        setResult(0);
        finish();
    }

    public void onDeleteClick() {
        this.vPinInputView.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O00000oO() {
        if (isValid()) {
            this.O0000oo0 = new XQProgressDialog(this);
            this.O0000oo0.setMessage(getString(R.string.device_more_security_loading_operation));
            this.O0000oo0.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000oo() {
        XQProgressDialog xQProgressDialog = this.O0000oo0;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public final void O0000O0o() {
        if (isValid()) {
            new MLAlertDialog.Builder(this).O000000o(getString(R.string.device_more_security_network_error)).O000000o(getString(R.string.mj_retry), new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    DevicePinActivity.this.O00000o0();
                }
            }).O00000Oo(getString(R.string.sh_common_cancel), new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    DevicePinActivity.this.setResult(0);
                    DevicePinActivity.this.finish();
                }
            }).O00000o().show();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        View view = this.O0000Oo;
        if (view != null && view.getVisibility() == 0) {
            XmBluetoothManager.getInstance().disconnect(this.O0000o.mac);
        }
    }

    public void dismissReopenBluetoothDialog() {
        MLAlertDialog mLAlertDialog = this.O0000ooO;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O0000ooO.dismiss();
        }
    }

    public void reopenBluetooth() {
        if (this.O0000ooO == null) {
            this.O0000ooO = new XQProgressDialog(this);
            this.O0000ooO.setMessage(getString(R.string.reopening_bluetooth));
            this.O0000ooO.setCancelable(false);
        }
        if (!this.O0000ooO.isShowing()) {
            this.O0000ooO.show();
        }
        if (gnl.O00000Oo()) {
            fmd.O00000Oo(new BleResponse() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass6 */

                public final void onResponse(int i, Object obj) {
                    fmd.O000000o(new BleResponse() {
                        /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass6.AnonymousClass1 */

                        public final void onResponse(int i, Object obj) {
                            fob.O000000o((fon) null);
                            DevicePinActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    DevicePinActivity.this.dismissReopenBluetoothDialog();
                                    DevicePinActivity.this.mSecurePinFailedLayout.setVisibility(8);
                                    DevicePinActivity.this.O00000o0();
                                }
                            }, 5000);
                        }
                    });
                }
            });
        } else {
            fmd.O000000o(new BleResponse() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass7 */

                public final void onResponse(int i, Object obj) {
                    fob.O000000o((fon) null);
                    DevicePinActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.page.verify.DevicePinActivity.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            DevicePinActivity.this.dismissReopenBluetoothDialog();
                            DevicePinActivity.this.mSecurePinFailedLayout.setVisibility(8);
                            DevicePinActivity.this.O00000o0();
                        }
                    }, 5000);
                }
            });
        }
    }
}
