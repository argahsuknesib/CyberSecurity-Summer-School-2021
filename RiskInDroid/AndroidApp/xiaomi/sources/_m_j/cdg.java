package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.util.ArrayList;
import java.util.List;

public final class cdg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static cdg f13659O000000o;
    private static final List<cdn> O00000o0 = new ArrayList();
    private Handler O00000Oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.cdg.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 31415927) {
                String O00000Oo = cdd.O00000Oo(ccx.O000000o());
                if (TextUtils.isEmpty(O00000Oo)) {
                    O00000Oo = "NULL";
                }
                long longValue = Long.valueOf(cdg.O00000Oo()).longValue();
                cdh.O000000o();
                long O00000Oo2 = cdh.O00000Oo();
                cdo cdo = new cdo(longValue, O00000Oo2, O00000Oo);
                cdb.O000000o(cdo);
                cdc.O000000o("Session recordSession beginTs " + longValue + " endTs " + O00000Oo2 + " sessionid " + cdo.O000000o() + " session_time " + (O00000Oo2 - longValue), (Throwable) null);
                cde.O00000Oo(ccx.O000000o(), "page_ref", "");
            }
        }
    };
    private List<cds> O00000o = new ArrayList();

    public static cdg O000000o() {
        if (f13659O000000o == null) {
            f13659O000000o = new cdg();
        }
        return f13659O000000o;
    }

    private cdg() {
    }

    public final void O000000o(String str, String str2, String str3) {
        if (!O000000o(str)) {
            cds cds = new cds(str, str2, str3);
            this.O00000o.add(cds);
            cdb.O000000o(cds);
        }
    }

    private boolean O000000o(String str) {
        boolean z = false;
        for (cds next : this.O00000o) {
            if (!TextUtils.isEmpty(str) && str.equals(next.O00000oO)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long */
    public static String O00000Oo() {
        return String.valueOf(cde.O000000o(ccx.O000000o(), "session_begin", 0L));
    }

    public static void O00000o0() {
        cdh.O000000o();
        long O00000Oo2 = cdh.O00000Oo();
        cde.O00000Oo(ccx.O000000o(), "session_begin", O00000Oo2);
        cde.O00000Oo(ccx.O000000o(), "page_ref", "");
        cdc.O000000o("Session resetSessionId pageRef  sessionid ".concat(String.valueOf(O00000Oo2)), (Throwable) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long */
    public final void O00000o() {
        long O000000o2 = cde.O000000o(ccx.O000000o(), "session_begin", 0L);
        cdh.O000000o();
        if (cdh.O00000Oo() - O000000o2 > 1800000) {
            this.O00000Oo.sendEmptyMessage(31415927);
        } else {
            this.O00000Oo.removeMessages(31415927);
        }
    }

    public final void O00000oO() {
        this.O00000Oo.sendEmptyMessageDelayed(31415927, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void */
    public static void O000000o(Context context, String str) {
        if (context != null) {
            try {
                cdh.O000000o();
                long O00000Oo2 = cdh.O00000Oo();
                String O000000o2 = cde.O000000o(ccx.O000000o(), "page_ref", "");
                boolean O00000Oo3 = cde.O00000Oo(ccx.O000000o(), "page_close_closed_ref");
                cdc.O000000o("Session recordActActivated pageClosedNormal ".concat(String.valueOf(O00000Oo3)), (Throwable) null);
                if (!O00000Oo3 || TextUtils.isEmpty(O000000o2)) {
                    O00000o0();
                    O000000o2 = "";
                }
                cdn cdn = new cdn(O00000Oo(), O00000Oo2, O00000Oo2, str, O000000o2);
                O00000o0.clear();
                O00000o0.add(cdn);
                cde.O00000Oo(ccx.O000000o(), "page_ref", str);
                cde.O000000o(ccx.O000000o(), "page_close_closed_ref", false);
                cdc.O000000o("Session recordActActivated pageRef " + O000000o2 + " pageName " + str + " sessionid " + cdn.O000000o(), (Throwable) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void */
    public final void O00000oo() {
        try {
            cdh.O000000o();
            Long valueOf = Long.valueOf(cdh.O00000Oo());
            if (!O00000o0.isEmpty() && O00000o0.size() > 0) {
                cdn cdn = O00000o0.get(0);
                O00000o0.clear();
                cdn.O00000oo = valueOf.longValue();
                cdb.O000000o(cdn);
                this.O00000o.clear();
                cde.O000000o(ccx.O000000o(), "page_close_closed_ref", true);
                cdc.O000000o("Session recordActDeactivated ptEvent " + cdn.O0000O0o + " pageRef " + cdn.O0000OOo + " sessionid " + cdn.O000000o() + " page_time " + (cdn.O00000oo - cdn.O00000oO), (Throwable) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
