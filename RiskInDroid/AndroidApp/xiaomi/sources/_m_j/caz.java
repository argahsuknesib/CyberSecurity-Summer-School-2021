package _m_j;

import _m_j.caw;
import _m_j.cbi;
import _m_j.cbm;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.xiaomi.smarthome.R;

public final class caz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13578O000000o = cap.class.getSimpleName();

    public static void O000000o(final Context context, cbi.O00000o0 o00000o0) {
        boolean z;
        int O000000o2;
        AppEventsLogger.newLogger(context).logEvent("fb_mobile_activate_app");
        ceh.O000000o(new Runnable() {
            /* class _m_j.caz.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
             arg types: [android.content.Context, java.lang.String, int]
             candidates:
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
              _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
             arg types: [android.content.Context, java.lang.String, int]
             candidates:
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
              _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
            public final void run() {
                ccn O0000o00 = ccn.O0000o00();
                if (O0000o00.O0000O0o() && !cbm.O00000o0.O000000o(context, "pref_miui_account_available", false)) {
                    String str = caz.f13578O000000o;
                    StringBuilder sb = new StringBuilder("hasSystemAccount ,get getServiceID:");
                    caw.O000000o.O00000oO();
                    sb.append(String.valueOf(caw.O000000o.O00000o0()));
                    ccr.O00000Oo(str, sb.toString());
                    caw.O000000o.O00000oO();
                    String O000000o2 = O0000o00.O000000o(caw.O000000o.O00000o0(), true);
                    String str2 = caz.f13578O000000o;
                    ccr.O00000Oo(str2, "hasSystemAccount ,get authToken:" + String.valueOf(O000000o2));
                    if (!TextUtils.isEmpty(O000000o2)) {
                        cbm.O00000o0.O00000Oo(context, "pref_miui_account_available", true);
                    }
                }
            }
        });
        cbi.O000000o(context, new Runnable() {
            /* class _m_j.caz.AnonymousClass2 */

            public final void run() {
            }
        }, o00000o0);
        if (!bzw.O000000o() || !cbf.O00000o0() || (O000000o2 = cbm.O00000o0.O000000o(context, "pref_data_saver_toast_count", 0)) >= 3) {
            z = false;
        } else {
            cbm.O00000o0.O00000Oo(context, "pref_data_saver_toast_count", O000000o2 + 1);
            z = true;
        }
        if (z) {
            cec.O000000o(context, (int) R.string.shop_settting_data_saver_toast, 1);
        }
        if (cbf.O00000o()) {
            cec.O000000o(context, (int) R.string.shop_toast_network_unavailable, 1);
        }
        new O000000o((byte) 0).execute(new Void[0]);
    }

    static class O000000o extends AsyncTask<Void, Void, Void> {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            bzu.O00000Oo();
            bzu.O000000o();
            return null;
        }
    }
}
