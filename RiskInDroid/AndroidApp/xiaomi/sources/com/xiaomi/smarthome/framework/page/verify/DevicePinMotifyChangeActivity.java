package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fll;
import _m_j.foc;
import _m_j.fqx;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fte;
import _m_j.fwa;
import _m_j.fwb;
import _m_j.fwc;
import _m_j.fwd;
import _m_j.fwg;
import _m_j.fwh;
import _m_j.fwk;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyManager;

public class DevicePinMotifyChangeActivity extends DevicePinMotifyActivity {
    private String O0000oo;

    static void O000000o(Activity activity, String str, String str2, String str3, boolean z, int i) {
        Intent intent = new Intent(activity, DevicePinMotifyChangeActivity.class);
        fwb.O000000o(intent, str);
        fwb.O00000Oo(intent, str3);
        intent.putExtra("xiaomi.smarthome.old_pin", str2);
        fwb.O000000o(intent, z);
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        if (this.O0000oO0 || !fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            this.O00000Oo = getString(R.string.device_more_change_pin_title);
        } else {
            this.O00000Oo = getString(R.string.ble_secure_change_pin_code);
        }
        this.O00000o0 = getString(R.string.device_more_add_pin_desc1);
        this.O00000o = getString(R.string.device_more_add_pin_desc2);
        this.O00000oO = getString(R.string.device_more_add_pin_error);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Intent intent) {
        super.O000000o(intent);
        this.O0000oo = intent.getStringExtra("xiaomi.smarthome.old_pin");
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(final String str) {
        if (this.O0000oO0) {
            VerifyGlobalManager verifyGlobalManager = this.O0000oO;
            AnonymousClass1 r2 = new fwg<Boolean>() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinMotifyChangeActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        DevicePinMotifyChangeActivity.this.O0000OOo();
                    } else {
                        DevicePinMotifyChangeActivity.this.O00000o0("");
                    }
                }

                public final void onFailure(fso fso) {
                    DevicePinMotifyChangeActivity.this.O00000oo();
                    DevicePinMotifyChangeActivity.this.O0000O0o();
                }
            };
            if (!VerifyGlobalManager.O00000Oo(this)) {
                r2.onFailure(new fso(-1, getString(R.string.device_more_security_network_error)));
            }
            if (!TextUtils.isDigitsOnly(str) || str.length() != 4) {
                r2.onFailure(new fso(-99, "pin format invalid"));
                return;
            }
            fwd.O000000o().O000000o(this, 1, str, 1, new fsm<Boolean, fso>(str, r2) {
                /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass9 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f8024O000000o;
                final /* synthetic */ fwg O00000Oo;

                {
                    this.f8024O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    VerifyManager.O00000o0.put(CoreApi.O000000o().O0000o0(), new fwc(this.f8024O000000o));
                    this.O00000Oo.onSuccess((Boolean) obj);
                }

                public final void onFailure(fso fso) {
                    this.O00000Oo.onFailure(fso);
                }
            });
        } else if (fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            int O0000o0 = foc.O0000o0(this.O0000o.mac);
            String O00000Oo = fll.O00000Oo(foc.O0000o00(this.O0000o.mac), foc.O0000Ooo(this.O0000o.mac), O0000o0);
            if (TextUtils.isEmpty(O00000Oo)) {
                fte.O00000Oo("change secure pin failed because decryptLtmk is empty");
                O00000o0("");
                return;
            }
            final String O000000o2 = fll.O000000o(str, O00000Oo, O0000o0);
            if (TextUtils.isEmpty(O000000o2)) {
                fte.O00000Oo("change secure pin failed because encryptLtmk is empty");
                O00000o0("");
                return;
            }
            fwa.O000000o().O00000Oo(CommonApplication.getAppContext(), this.O0000o.did, O000000o2, new fsm<Void, fso>() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinMotifyChangeActivity.AnonymousClass2 */

                public final void onFailure(fso fso) {
                    StringBuilder sb = new StringBuilder("changeSecurePinLtmk failed, error = ");
                    sb.append(fso == null ? null : fso.toString());
                    fte.O00000Oo(sb.toString());
                    DevicePinMotifyChangeActivity.this.O00000oo();
                    DevicePinMotifyChangeActivity.this.O0000O0o();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    foc.O0000OOo(DevicePinMotifyChangeActivity.this.O0000o.mac, str);
                    foc.O00000oo(DevicePinMotifyChangeActivity.this.O0000o.mac, O000000o2);
                    DevicePinMotifyChangeActivity.this.O0000OOo();
                }
            });
        } else {
            fwk fwk = this.O0000O0o;
            String str2 = this.O0000o.model;
            String str3 = this.O0000o.version;
            String str4 = this.f7933O000000o;
            String str5 = this.O0000oo;
            AnonymousClass3 r4 = new fwh() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinMotifyChangeActivity.AnonymousClass3 */

                public final void O000000o() {
                    DevicePinMotifyChangeActivity.this.O0000OOo();
                }

                public final void O00000Oo() {
                    DevicePinMotifyChangeActivity.this.O00000o0("");
                }

                public final void O000000o(String str) {
                    O00000o0();
                }

                public final void O00000o0() {
                    DevicePinMotifyChangeActivity.this.O00000oo();
                    DevicePinMotifyChangeActivity.this.O0000O0o();
                }
            };
            if (!fwk.O00000Oo(fwk.f8025O000000o)) {
                r4.O00000o0();
            } else if (!TextUtils.isDigitsOnly(str) || str.length() != fwk.O000000o(str2, str3)) {
                r4.O000000o("pin format invalid");
            } else {
                fwa.O000000o().O000000o(fwk.f8025O000000o, str4, str, str5, new fsm<Integer, fso>(r4, str4, str) {
                    /* class _m_j.fwk.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fwh f17313O000000o;
                    final /* synthetic */ String O00000Oo;
                    final /* synthetic */ String O00000o0;

                    {
                        this.f17313O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (((Integer) obj).intValue() != 0) {
                            this.f17313O000000o.O00000Oo();
                            return;
                        }
                        if (fwk.this.O00000Oo(this.O00000Oo)) {
                            fwk.this.O000000o(this.O00000Oo);
                        }
                        VerifyManager.O00000o0.put(this.O00000Oo, new fwc(this.O00000o0));
                        this.f17313O000000o.O000000o();
                    }

                    public final void onFailure(fso fso) {
                        this.f17313O000000o.O000000o(fso.O00000Oo);
                    }
                });
            }
        }
    }
}
