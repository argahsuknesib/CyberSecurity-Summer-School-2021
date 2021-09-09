package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fob;
import _m_j.foc;
import _m_j.fon;
import _m_j.fpo;
import _m_j.fqx;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fvz;
import _m_j.fwg;
import _m_j.fwh;
import _m_j.gle;
import _m_j.gqg;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceApi;
import org.json.JSONObject;

public abstract class DevicePinVerifyActivity extends DevicePinActivity {
    private long O0000oo;
    protected fvz O0000oo0;
    private int O0000ooO;

    /* access modifiers changed from: protected */
    public boolean O000000o(String str, Bundle bundle) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(String str);

    public boolean invokeOnPinCodeInputFinishWhileOverInput() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void O00000o() {
        this.O0000oo0 = fvz.O000000o();
        if (this.O0000oo0.O00000Oo(this.f7933O000000o == null ? this.O0000oOO : this.f7933O000000o)) {
            gqg.O00000Oo(getString(R.string.device_more_verify_locked));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o(final String str) {
        O00000oO();
        if (this.O0000oO0) {
            this.O0000oO.O000000o(this, str, this.f7933O000000o, new fwg<Boolean>() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    DevicePinVerifyActivity.this.O00000oo();
                    if (((Boolean) obj).booleanValue()) {
                        DevicePinVerifyActivity.this.O00000Oo(str);
                    } else {
                        DevicePinVerifyActivity.this.O0000OOo();
                    }
                }

                public final void onFailure(fso fso) {
                    DevicePinVerifyActivity.this.O00000oo();
                    DevicePinVerifyActivity.this.O0000O0o();
                }
            });
        } else if (fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            DeviceApi.getEncryptLtmk(this, this.O0000o.did, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    final int i;
                    String str;
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        str = jSONObject.optString("key");
                        i = jSONObject.optInt("encrypt_type");
                    } else {
                        str = "";
                        i = 0;
                    }
                    if (TextUtils.isEmpty(str) || i == 0) {
                        DevicePinVerifyActivity.this.O00000oo();
                        DevicePinVerifyActivity.this.O0000O0o();
                        return;
                    }
                    if (TextUtils.isEmpty(foc.O000000o(DevicePinVerifyActivity.this.O0000o.mac)) && !TextUtils.isEmpty(DevicePinVerifyActivity.this.O0000o.getDid())) {
                        foc.O00000o0(DevicePinVerifyActivity.this.O0000o.mac, DevicePinVerifyActivity.this.O0000o.getDid());
                    }
                    String O0000Ooo = foc.O0000Ooo(DevicePinVerifyActivity.this.O0000o.mac);
                    String O0000o00 = foc.O0000o00(DevicePinVerifyActivity.this.O0000o.mac);
                    if (!TextUtils.equals(O0000Ooo, str) || TextUtils.isEmpty(O0000o00)) {
                        DevicePinVerifyActivity.this.O00000oo();
                        foc.O00000oo(DevicePinVerifyActivity.this.O0000o.mac, str);
                        DevicePinVerifyActivity devicePinVerifyActivity = DevicePinVerifyActivity.this;
                        if (devicePinVerifyActivity.O0000Oo != null) {
                            devicePinVerifyActivity.O0000Oo.setVisibility(0);
                            if (devicePinVerifyActivity.O0000OoO != null) {
                                Animation loadAnimation = AnimationUtils.loadAnimation(devicePinVerifyActivity.getContext(), R.anim.rotate_infinite);
                                loadAnimation.setDuration(1000);
                                devicePinVerifyActivity.O0000OoO.startAnimation(loadAnimation);
                            }
                        }
                        fpo.O000000o(DevicePinVerifyActivity.this.O0000o.mac, str, str, i, new gle() {
                            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyActivity.AnonymousClass2.AnonymousClass1 */

                            public final void O000000o(int i, Bundle bundle) {
                            }

                            public final void O00000Oo(int i, Bundle bundle) {
                            }

                            public final void O00000o0(int i, Bundle bundle) {
                            }

                            public final void O00000o(int i, Bundle bundle) {
                                DevicePinVerifyActivity devicePinVerifyActivity = DevicePinVerifyActivity.this;
                                if (devicePinVerifyActivity.O0000OoO != null) {
                                    devicePinVerifyActivity.O0000OoO.clearAnimation();
                                }
                                if (devicePinVerifyActivity.O0000Oo != null) {
                                    devicePinVerifyActivity.O0000Oo.setVisibility(8);
                                }
                                if (i == 0) {
                                    foc.O0000OOo(DevicePinVerifyActivity.this.O0000o.mac, str);
                                    foc.O00000Oo(DevicePinVerifyActivity.this.O0000o.mac, i);
                                    if (!DevicePinVerifyActivity.this.O000000o(str, bundle)) {
                                        DevicePinVerifyActivity.this.O00000Oo(str);
                                        return;
                                    }
                                    return;
                                }
                                DevicePinVerifyActivity devicePinVerifyActivity2 = DevicePinVerifyActivity.this;
                                if (devicePinVerifyActivity2.mSecurePinFailedLayout != null) {
                                    devicePinVerifyActivity2.mSecurePinFailureCode = i;
                                    devicePinVerifyActivity2.mSecurePinFailedLayout.setVisibility(0);
                                    if (i == -6 || i == -5) {
                                        devicePinVerifyActivity2.O0000Ooo.setText((int) R.string.ble_new_connect_step_failed);
                                        devicePinVerifyActivity2.O0000o00.setText((int) R.string.ble_new_connect_failed_title);
                                        devicePinVerifyActivity2.O0000o0.setVisibility(4);
                                        devicePinVerifyActivity2.O0000o0O.setVisibility(4);
                                        devicePinVerifyActivity2.O0000o0o.setText((int) R.string.ble_new_reopen_and_retry);
                                    } else {
                                        devicePinVerifyActivity2.O0000Ooo.setText((int) R.string.ble_secure_pin_verify_failed_title);
                                        devicePinVerifyActivity2.O0000o00.setText((int) R.string.ble_secure_pin_verify_failed_message_1);
                                        devicePinVerifyActivity2.O0000o0.setVisibility(0);
                                        devicePinVerifyActivity2.O0000o0O.setVisibility(0);
                                        devicePinVerifyActivity2.O0000o0.setText((int) R.string.ble_secure_pin_verify_failed_message_2);
                                        devicePinVerifyActivity2.O0000o0O.setText((int) R.string.ble_secure_pin_verify_failed_message_3);
                                        devicePinVerifyActivity2.O0000o0o.setText((int) R.string.ble_new_reopen_and_retry_btn);
                                    }
                                }
                                fob.O000000o((fon) null);
                            }
                        });
                    } else if (TextUtils.equals(str, O0000o00)) {
                        DevicePinVerifyActivity.this.O00000oo();
                        DevicePinVerifyActivity.this.O00000Oo(str);
                    } else {
                        DevicePinVerifyActivity.this.O00000oo();
                        DevicePinVerifyActivity.this.O0000OOo();
                    }
                }

                public final void onFailure(fso fso) {
                    DevicePinVerifyActivity.this.O00000oo();
                    DevicePinVerifyActivity.this.O0000O0o();
                }
            });
        } else {
            this.O0000O0o.O000000o(this.O0000o.model, this.O0000o.version, this.f7933O000000o, str, new fwh() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyActivity.AnonymousClass3 */

                public final void O000000o() {
                    DevicePinVerifyActivity.this.O00000oo();
                    DevicePinVerifyActivity.this.O00000Oo(str);
                }

                public final void O00000Oo() {
                    DevicePinVerifyActivity.this.O00000oo();
                    DevicePinVerifyActivity.this.O0000OOo();
                }

                public final void O000000o(String str) {
                    O00000o0();
                }

                public final void O00000o0() {
                    DevicePinVerifyActivity.this.O00000oo();
                    DevicePinVerifyActivity.this.O0000O0o();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        O000000o(this.vPinInputView.getPinCode());
    }

    /* access modifiers changed from: protected */
    public final void O0000OOo() {
        this.vPinInputView.O00000o0();
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo0.setText(this.O00000oO);
        } else {
            this.vDesc.setText(this.O00000oO);
        }
        if (this.O0000oo == 0 || System.currentTimeMillis() - this.O0000oo < 300000) {
            this.O0000ooO++;
        } else {
            this.O0000ooO = 1;
        }
        this.O0000oo = System.currentTimeMillis();
        if (this.O0000ooO >= 5) {
            this.O0000oo0.O000000o(this.f7933O000000o == null ? this.O0000oOO : this.f7933O000000o);
            gqg.O00000Oo(getString(R.string.device_more_verify_locked));
            finish();
        }
    }
}
