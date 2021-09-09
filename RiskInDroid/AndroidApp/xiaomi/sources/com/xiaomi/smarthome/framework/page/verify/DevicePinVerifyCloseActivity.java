package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fwa;
import _m_j.fwh;
import _m_j.fwk;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyManager;

public class DevicePinVerifyCloseActivity extends DevicePinVerifyActivity {
    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        O00000oO();
        fwk fwk = this.O0000O0o;
        String str2 = this.f7933O000000o;
        AnonymousClass1 r1 = new fwh() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyCloseActivity.AnonymousClass1 */

            public final void O000000o() {
                DevicePinVerifyCloseActivity.this.O00000oo();
                DevicePinVerifyCloseActivity.this.setResult(-1);
                DevicePinVerifyCloseActivity.this.finish();
            }

            public final void O00000Oo() {
                DevicePinVerifyCloseActivity.this.O00000oo();
                DevicePinVerifyCloseActivity.this.O0000OOo();
            }

            public final void O000000o(String str) {
                O00000o0();
            }

            public final void O00000o0() {
                DevicePinVerifyCloseActivity.this.O00000oo();
                DevicePinVerifyCloseActivity.this.O0000O0o();
            }
        };
        if (!fwk.O00000Oo(fwk.f8025O000000o)) {
            r1.O00000o0();
            return;
        }
        fwa.O000000o().O000000o(fwk.f8025O000000o, str2, "", str, new fsm<Integer, fso>(r1, str2) {
            /* class _m_j.fwk.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ fwh f17312O000000o;
            final /* synthetic */ String O00000Oo;

            {
                this.f17312O000000o = r2;
                this.O00000Oo = r3;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (((Integer) obj).intValue() != 0) {
                    this.f17312O000000o.O00000Oo();
                    return;
                }
                if (fwk.O00000o0(fwk.this.f8025O000000o) && fwk.this.O000000o()) {
                    fwk.this.O00000Oo.O00000Oo(this.O00000Oo);
                }
                VerifyManager.O00000o0.remove(this.O00000Oo);
                this.f17312O000000o.O000000o();
            }

            public final void onFailure(fso fso) {
                this.f17312O000000o.O000000o(fso.O00000Oo);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.O00000Oo = getString(R.string.device_more_close_pin_title);
        this.O00000o0 = getString(R.string.device_more_verify_pin_desc);
        this.O00000oO = getString(R.string.device_more_verify_pin_error);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        setResult(-1);
        finish();
    }
}
