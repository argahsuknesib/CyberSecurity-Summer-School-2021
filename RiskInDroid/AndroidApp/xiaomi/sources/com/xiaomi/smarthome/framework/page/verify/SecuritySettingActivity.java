package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fnn;
import _m_j.fno;
import _m_j.foc;
import _m_j.fqx;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fwb;
import _m_j.fwe;
import _m_j.fwf;
import _m_j.fwj;
import _m_j.fwk;
import _m_j.fwo;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.izb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import javax.crypto.Cipher;
import org.json.JSONObject;

public class SecuritySettingActivity extends BaseActivity implements fwe {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f7979O000000o;
    private boolean O00000Oo;
    private boolean O00000o;
    private Runnable O00000o0;
    public Device mDevice;
    public String mDeviceId;
    public String mPinCode;
    public fwk mVerifyManager;
    @BindView(6105)
    View vChangeSecurePin;
    @BindView(6108)
    View vFingerPrintSetting;
    @BindView(6109)
    SwitchButton vFingerPrintSwitch;
    @BindView(6110)
    View vFingerPrintTitle;
    @BindView(6103)
    View vPasswordChange;
    @BindView(6104)
    TextView vPasswordChangeTitle;
    @BindView(6107)
    View vPasswordClose;
    @BindView(6111)
    View vPasswordOpen;
    @BindView(6120)
    SwitchButton vSecurePinSwitch;
    @BindView(6119)
    View vShowSecurePin;
    @BindView(5474)
    TextView vTitle;
    public fwo vVerifyDialog;

    public static void startActivity(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, SecuritySettingActivity.class);
        intent.putExtra("extra_device_did", str);
        intent.putExtra("xiaomi.smarthome.custom_hint", str2);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.activity_security_setting);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        this.mDeviceId = intent.getStringExtra("extra_device_did");
        this.f7979O000000o = intent.getStringExtra("xiaomi.smarthome.custom_hint");
        if (TextUtils.isEmpty(this.mDeviceId)) {
            gqg.O00000Oo("设备id不能为空");
            finish();
        }
        this.mDevice = fno.O000000o().O000000o(this.mDeviceId);
        Device device = this.mDevice;
        if (device == null) {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "", this.mDeviceId + " device is null!");
            finish();
            return;
        }
        if (fqx.O000000o(device.model, this.mDevice.version)) {
            this.vTitle.setText(getString(R.string.ble_secure_pin_device_more_title));
        } else {
            this.vTitle.setText(getString(R.string.device_more_security_title));
        }
        this.mVerifyManager = fwk.O000000o(this);
        refreshSettingUI();
    }

    /* access modifiers changed from: private */
    @TargetApi(23)
    public void O000000o() {
        fwo fwo = this.vVerifyDialog;
        if (fwo != null) {
            fwo.O00000Oo();
        }
        this.mVerifyManager.O000000o(this.mDeviceId, this);
    }

    public void onResume() {
        super.onResume();
        this.O00000Oo = true;
        Runnable runnable = this.O00000o0;
        if (runnable != null) {
            runnable.run();
        }
        fwo fwo = this.vVerifyDialog;
        if (fwo != null && this.O00000o) {
            fwo.O000000o(getString(R.string.device_more_fingerprint_title));
        }
    }

    public void onPause() {
        fwo fwo = this.vVerifyDialog;
        if (fwo != null) {
            this.O00000o = !fwo.O00000o0;
            this.vVerifyDialog.O000000o();
        }
        this.O00000Oo = false;
        this.O00000o0 = null;
        super.onPause();
    }

    public void refreshSettingUI() {
        this.vFingerPrintSwitch.setOnTouchEnable(false);
        this.vSecurePinSwitch.setOnTouchEnable(false);
        if (!fqx.O000000o(this.mDevice.model, this.mDevice.version)) {
            showPinCloseStyle();
            if (this.mDevice.isSetPinCode == 1) {
                showPinOpenStyle();
                O00000Oo();
                return;
            }
            showPinCloseStyle();
        } else if (foc.O0000o0O(this.mDevice.mac)) {
            showSecurePinOpenStyle();
            O00000Oo();
        } else {
            showSecurePinCloseStyle();
        }
    }

    private void O00000Oo() {
        if (!this.mVerifyManager.O000000o()) {
            showFingerPrintUnSupport();
        } else if (this.mVerifyManager.O00000Oo(this.mDeviceId)) {
            showFingerPrintSupportOpen();
        } else {
            showFingerPrintSupportClose();
        }
    }

    public void showPinCloseStyle() {
        this.vPasswordOpen.setVisibility(0);
        this.vPasswordClose.setVisibility(8);
        this.vPasswordChange.setVisibility(0);
        this.vPasswordChange.setClickable(false);
        this.vPasswordChangeTitle.setTextColor(ContextCompat.O00000o0(this, R.color.mj_color_black_50_transparent));
        this.vFingerPrintTitle.setVisibility(8);
        this.vFingerPrintSetting.setVisibility(8);
    }

    public void showPinOpenStyle() {
        this.vPasswordOpen.setVisibility(8);
        this.vPasswordClose.setVisibility(0);
        this.vPasswordChange.setVisibility(0);
        this.vPasswordChange.setClickable(true);
        this.vPasswordChangeTitle.setTextColor(ContextCompat.O00000o0(this, R.color.mj_color_black_80_transparent));
    }

    public void showSecurePinCloseStyle() {
        this.vPasswordOpen.setVisibility(8);
        this.vPasswordClose.setVisibility(8);
        this.vPasswordChange.setVisibility(8);
        this.vFingerPrintTitle.setVisibility(8);
        this.vFingerPrintSetting.setVisibility(8);
        this.vShowSecurePin.setVisibility(0);
        this.vSecurePinSwitch.setChecked(false);
        this.vChangeSecurePin.setVisibility(0);
    }

    public void showSecurePinOpenStyle() {
        this.vPasswordOpen.setVisibility(8);
        this.vPasswordClose.setVisibility(8);
        this.vPasswordChange.setVisibility(8);
        this.vShowSecurePin.setVisibility(0);
        this.vSecurePinSwitch.setChecked(true);
        this.vChangeSecurePin.setVisibility(0);
    }

    public void showFingerPrintSupportOpen() {
        this.vFingerPrintTitle.setVisibility(0);
        this.vFingerPrintSetting.setVisibility(0);
        this.vFingerPrintSwitch.setChecked(true);
    }

    public void showFingerPrintSupportClose() {
        this.vFingerPrintTitle.setVisibility(0);
        this.vFingerPrintSetting.setVisibility(0);
        this.vFingerPrintSwitch.setChecked(false);
    }

    public void showFingerPrintUnSupport() {
        this.vFingerPrintTitle.setVisibility(8);
        this.vFingerPrintSetting.setVisibility(8);
    }

    @OnClick({5470})
    public void onClickBack() {
        finish();
    }

    @OnClick({6111})
    public void onClickPasswordOpen() {
        fwb.O000000o(this, this.mDeviceId, this.f7979O000000o, false, 7000);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwb.O000000o(android.content.Intent, boolean):void
     arg types: [android.content.Intent, int]
     candidates:
      _m_j.fwb.O000000o(android.content.Intent, java.lang.String):void
      _m_j.fwb.O000000o(android.content.Intent, boolean):void */
    @OnClick({6107})
    public void onClickPasswordClose() {
        String str = this.mDeviceId;
        Intent intent = new Intent(this, DevicePinVerifyCloseActivity.class);
        fwb.O000000o(intent, str);
        fwb.O000000o(intent, false);
        startActivityForResult(intent, 7001);
    }

    @OnClick({6103})
    public void onClickPasswordChange() {
        fwb.O000000o(this, this.mDeviceId, this.f7979O000000o);
    }

    @OnClick({6108, 6109})
    public void onClickFingerPrintSetting() {
        if (this.vFingerPrintSwitch.isChecked()) {
            this.mVerifyManager.O000000o(this.mDeviceId);
            this.vFingerPrintSwitch.setChecked(false);
            return;
        }
        this.mPinCode = fwk.O000000o(this.mDeviceId, 10000);
        if (!TextUtils.isEmpty(this.mPinCode)) {
            O000000o();
            return;
        }
        String str = this.mDeviceId;
        Intent intent = new Intent(this, DevicePinVerifyFPOpenActivity.class);
        fwb.O000000o(intent, str);
        startActivityForResult(intent, 7003);
    }

    @OnClick({6119, 6120})
    public void onClickSecurePin() {
        if (this.vSecurePinSwitch.isChecked()) {
            O000000o(false);
        } else {
            O000000o(true);
        }
    }

    @OnClick({6105})
    public void onClickChangeSecurePin() {
        fwb.O000000o(this, this.mDeviceId, this.f7979O000000o);
    }

    private void O000000o(final boolean z) {
        DeviceApi.setSecurePinSwitch(this.mDeviceId, z, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity.AnonymousClass1 */

            public final void onFailure(fso fso) {
                izb.O000000o(SecuritySettingActivity.this, (int) R.string.toast_failed_retry, 0).show();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                SecuritySettingActivity.this.vSecurePinSwitch.setChecked(z);
                foc.O000000o(SecuritySettingActivity.this.mDevice.mac, z);
                SecuritySettingActivity.this.refreshSettingUI();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 7000:
                if (i2 == -1) {
                    this.mDevice.isSetPinCode = 1;
                    fno.O000000o().O00000o0(this.mDevice);
                    refreshSettingUI();
                    fno.O000000o().O0000Oo0();
                    return;
                }
                return;
            case 7001:
                if (i2 == -1) {
                    this.mDevice.isSetPinCode = 0;
                    fno.O000000o().O00000o0(this.mDevice);
                    refreshSettingUI();
                    fno.O000000o().O0000Oo0();
                    return;
                }
                return;
            case 7002:
                if (i2 == -1) {
                    refreshSettingUI();
                    return;
                }
                return;
            case 7003:
                if (i2 == -1) {
                    this.mPinCode = intent.getStringExtra("xiaomi.smarthome.pincode");
                    if (TextUtils.isEmpty(this.mPinCode)) {
                        return;
                    }
                    if (this.O00000Oo) {
                        O000000o();
                        return;
                    } else {
                        this.O00000o0 = new Runnable() {
                            /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$SecuritySettingActivity$hYnSoaaeYAL1uTyAn5tMUrwKvQc */

                            public final void run() {
                                SecuritySettingActivity.this.O000000o();
                            }
                        };
                        return;
                    }
                } else {
                    return;
                }
            case 7004:
                if (i2 == -1) {
                    O000000o();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @TargetApi(23)
    public void onGetCipherSuccess(Cipher cipher) {
        final String str;
        DeviceTagInterface.Category O00000o02 = fnn.O000000o().O00000Oo().O00000o0(this.mDevice.model);
        if (O00000o02 == null) {
            str = "";
        } else {
            str = O00000o02.name;
        }
        this.vVerifyDialog = new fwo(this, new FingerprintManager.CryptoObject(cipher), new fwf() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivity.AnonymousClass2 */

            public final void O000000o(Cipher cipher) {
                SecuritySettingActivity.this.vVerifyDialog.O00000Oo();
                hxi.O0000Oo.O000000o(SecuritySettingActivity.this.mDevice.model, str, CoreApi.O000000o().O0000o0(), true);
                if (!TextUtils.isEmpty(SecuritySettingActivity.this.mPinCode)) {
                    SecuritySettingActivity.this.mVerifyManager.O000000o(SecuritySettingActivity.this.mDeviceId, SecuritySettingActivity.this.mPinCode, cipher);
                    SecuritySettingActivity.this.vFingerPrintSwitch.setChecked(true);
                }
            }

            public final void O000000o() {
                SecuritySettingActivity.this.vVerifyDialog.O00000Oo();
                hxi.O0000Oo.O000000o(SecuritySettingActivity.this.mDevice.model, str, CoreApi.O000000o().O0000o0(), false);
            }

            public final void O000000o(CharSequence charSequence) {
                gqg.O00000Oo(charSequence);
                SecuritySettingActivity.this.vVerifyDialog.O00000Oo();
            }

            public final void O00000Oo() {
                SecuritySettingActivity.this.vVerifyDialog.O00000Oo();
                hxi.O0000Oo.O000000o(SecuritySettingActivity.this.mDevice.model, str, CoreApi.O000000o().O0000o0(), false);
            }
        }, false);
        this.vVerifyDialog.O000000o(getString(R.string.device_more_fingerprint_title));
    }

    public void onGetResetCipherSuccess(Cipher cipher) {
        onGetCipherSuccess(cipher);
    }

    public void onGetCipherError(int i, String str) {
        if (i == fwj.O00000o) {
            Intent createConfirmDeviceCredentialIntent = ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent("", "");
            if (createConfirmDeviceCredentialIntent != null) {
                startActivityForResult(createConfirmDeviceCredentialIntent, 7004);
                return;
            }
            return;
        }
        gqg.O00000Oo(getString(R.string.device_more_fingerprint_open_fail));
    }
}
