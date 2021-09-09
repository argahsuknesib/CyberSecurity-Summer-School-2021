package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fwa;
import _m_j.fwc;
import _m_j.fwd;
import _m_j.fwg;
import _m_j.fwh;
import _m_j.fwk;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyManager;

public class DevicePinMotifyOpenActivity extends DevicePinMotifyActivity {
    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.O00000Oo = getString(R.string.device_more_add_pin_title);
        this.O00000o0 = getString(R.string.device_more_add_pin_desc1);
        this.O00000o = getString(R.string.device_more_add_pin_desc2);
        this.O00000oO = getString(R.string.device_more_add_pin_error);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        if (this.O0000oO0) {
            VerifyGlobalManager verifyGlobalManager = this.O0000oO;
            AnonymousClass1 r2 = new fwg<Boolean>() {
                /* class com.xiaomi.smarthome.framework.page.verify.DevicePinMotifyOpenActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        DevicePinMotifyOpenActivity.this.O0000OOo();
                        return;
                    }
                    DevicePinMotifyOpenActivity.this.O00000oo();
                    DevicePinMotifyOpenActivity.this.O0000O0o();
                }

                public final void onFailure(fso fso) {
                    DevicePinMotifyOpenActivity.this.O00000oo();
                    DevicePinMotifyOpenActivity.this.O0000O0o();
                }
            };
            if (!VerifyGlobalManager.O00000Oo(this)) {
                r2.onFailure(new fso(-1, getString(R.string.device_more_security_network_error)));
            }
            if (!TextUtils.isDigitsOnly(str) || str.length() != 4) {
                r2.onFailure(new fso(-99, "pin format invalid"));
                return;
            }
            fwd.O000000o().O000000o(this, 1, str, 2, new fsm<Boolean, fso>(str, r2) {
                /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass7 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f8022O000000o;
                final /* synthetic */ fwg O00000Oo;

                {
                    this.f8022O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    VerifyManager.O00000o0.put(CoreApi.O000000o().O0000o0(), new fwc(this.f8022O000000o));
                    this.O00000Oo.onSuccess((Boolean) obj);
                }

                public final void onFailure(fso fso) {
                    this.O00000Oo.onFailure(fso);
                }
            });
            return;
        }
        fwk fwk = this.O0000O0o;
        String str2 = this.O0000o.model;
        String str3 = this.O0000o.version;
        String str4 = this.f7933O000000o;
        AnonymousClass2 r4 = new fwh() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinMotifyOpenActivity.AnonymousClass2 */

            public final void O00000Oo() {
            }

            public final void O000000o() {
                DevicePinMotifyOpenActivity.this.O0000OOo();
            }

            public final void O000000o(String str) {
                O00000o0();
            }

            public final void O00000o0() {
                DevicePinMotifyOpenActivity.this.O00000oo();
                DevicePinMotifyOpenActivity.this.O0000O0o();
            }
        };
        if (!fwk.O00000Oo(fwk.f8025O000000o)) {
            r4.O00000o0();
        } else if (!TextUtils.isDigitsOnly(str) || str.length() != fwk.O000000o(str2, str3)) {
            r4.O000000o("pin format invalid");
        } else {
            fwa.O000000o().O000000o(fwk.f8025O000000o, str4, str, "", new fsm<Integer, fso>(str4, str, r4) {
                /* class _m_j.fwk.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f17311O000000o;
                final /* synthetic */ String O00000Oo;
                final /* synthetic */ fwh O00000o0;

                {
                    this.f17311O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                }

                public final void onFailure(fso fso) {
                    this.O00000o0.O000000o(fso.O00000Oo);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    VerifyManager.O00000o0.put(this.f17311O000000o, new fwc(this.O00000Oo));
                    this.O00000o0.O000000o();
                }
            });
        }
    }
}
