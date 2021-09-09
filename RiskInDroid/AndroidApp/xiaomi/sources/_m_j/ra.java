package _m_j;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public final class ra {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2419O000000o;
    public pg O00000Oo;
    public qm O00000o;
    public pi O00000o0;
    public to O00000oO = new to() {
        /* class _m_j.ra.AnonymousClass1 */

        public final void O000000o(pm pmVar) {
            ra raVar = ra.this;
            String O000000o2 = pmVar.O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                try {
                    JSONObject jSONObject = new JSONObject(O000000o2);
                    raVar.O00000o0.f2383O000000o = new O000000o(jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
    };

    static class O000000o implements pf {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f2421O000000o = true;
        private long O00000Oo = 0;
        private int O00000o = 6;
        private boolean O00000o0 = false;
        private int O00000oO = 8;
        private String[] O00000oo;
        private int O0000O0o = 10;
        private int O0000OOo = 5;
        private boolean O0000Oo = false;
        private int O0000Oo0 = 100;

        O000000o(JSONObject jSONObject) {
            this.f2421O000000o = jSONObject.optBoolean("loe", true);
            this.O00000Oo = jSONObject.optLong("loct", 0);
            this.O00000o0 = jSONObject.optBoolean("loca", false);
            this.O00000o = jSONObject.optInt("lott", 6);
            this.O00000oO = jSONObject.optInt("lomwn", 8);
            try {
                this.O00000oo = jSONObject.optString("locpl", "").split(",");
            } catch (Exception unused) {
            }
            this.O0000O0o = jSONObject.optInt("lomrt", 10);
            this.O0000OOo = jSONObject.optInt("lomnwrt", 5);
            this.O0000Oo0 = jSONObject.optInt("lomnpr", 100);
            this.O0000Oo = jSONObject.optBoolean("lonfd", false);
        }

        public final boolean O000000o() {
            return this.f2421O000000o;
        }

        public final long O00000Oo() {
            return this.O00000Oo;
        }

        public final int O00000o() {
            return this.O00000o;
        }

        public final boolean O00000o0() {
            return this.O00000o0;
        }

        public final int O00000oO() {
            return this.O00000oO;
        }

        public final String[] O00000oo() {
            return this.O00000oo;
        }

        public final int O0000O0o() {
            return this.O0000O0o;
        }

        public final int O0000OOo() {
            return this.O0000OOo;
        }

        public final boolean O0000Oo() {
            return this.O0000Oo;
        }

        public final int O0000Oo0() {
            return this.O0000Oo0;
        }
    }

    public ra(Context context, pg pgVar, pi piVar) {
        this.f2419O000000o = context;
        this.O00000Oo = pgVar;
        this.O00000o0 = piVar;
    }
}
