package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.io.IOException;

public class blm {
    private static blm O00000o0;
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13038O000000o;
    private Context O00000Oo;
    private bmg O00000o;

    private blm() {
        this.f13038O000000o = 0;
        this.O00000Oo = null;
        this.O00000o = new bmg() {
            /* class _m_j.blm.AnonymousClass1 */

            public final void run() {
                try {
                    blm blm = blm.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(blm.this.f13038O000000o);
                    blm.O000000o(blm, sb.toString());
                } catch (Throwable th) {
                    bmz.O00000o("SeqManager", "setSettingSeq failed: %s", th);
                }
                try {
                    blm blm2 = blm.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(blm.this.f13038O000000o);
                    blm.O00000Oo(blm2, sb2.toString());
                } catch (Throwable th2) {
                    bmz.O00000o("SeqManager", "setSharedPreferencesSeq failed: %s", th2);
                }
            }
        };
        this.O00000Oo = blw.f13081O000000o;
    }

    public static blm O000000o() {
        if (O00000o0 == null) {
            synchronized (blm.class) {
                if (O00000o0 == null) {
                    O00000o0 = new blm();
                }
            }
        }
        return O00000o0;
    }

    private String O00000o() {
        try {
            int i = Build.VERSION.SDK_INT < 23 ? 3 : 0;
            if (this.O00000Oo != null) {
                String string = this.O00000Oo.getSharedPreferences("seq", i).getString("seq", null);
                if (!bnd.O000000o(string)) {
                    return string;
                }
                throw new Exception("from shared preference empty id");
            }
            throw new Exception("mContext == null");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String O00000o0() {
        String str = "";
        try {
            if (this.O00000Oo != null) {
                try {
                    str = Settings.System.getString(this.O00000Oo.getContentResolver(), "com.shumei.seq");
                    if (!bnd.O000000o(str)) {
                        return str;
                    }
                    throw new IOException("from setting empty id");
                } catch (Exception e) {
                    bmz.O00000o("SeqManager", "get seq from Settings failed: %s", e);
                }
            } else {
                throw new Exception("mContext = null");
            }
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0028 A[PHI: r2 10  PHI: (r2v1 java.lang.String) = (r2v0 java.lang.String), (r2v2 java.lang.String) binds: [B:15:0x0021, B:13:0x001e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    private String O00000oO() {
        String str;
        try {
            str = O00000o0();
            try {
                if (bnd.O00000Oo(str)) {
                    return str;
                }
            } catch (Exception unused) {
                bmz.O000000o("SeqManager", "getSeq from setting failed", new Object[0]);
                str = O00000o();
                if (bnd.O00000Oo(str)) {
                }
            }
        } catch (Exception unused2) {
            str = null;
            bmz.O000000o("SeqManager", "getSeq from setting failed", new Object[0]);
            str = O00000o();
            if (bnd.O00000Oo(str)) {
            }
        }
        try {
            str = O00000o();
            return bnd.O00000Oo(str) ? str : str;
        } catch (Exception unused3) {
            bmz.O000000o("SeqManager", "getSeq sfrom shared perferences failed", new Object[0]);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0016 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000a */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0010 A[SYNTHETIC, Splitter:B:10:0x0010] */
    public final synchronized String O00000Oo() {
        StringBuilder sb;
        if (this.f13038O000000o == 0) {
            String str = null;
            str = O00000oO();
            if (bnd.O00000Oo(str)) {
                this.f13038O000000o = Integer.parseInt(str);
            }
        }
        this.f13038O000000o++;
        this.O00000o.O000000o();
        sb = new StringBuilder();
        sb.append(this.f13038O000000o);
        return sb.toString();
    }

    static /* synthetic */ void O000000o(blm blm, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            try {
                if (blm.O00000Oo != null) {
                    Settings.System.putString(blm.O00000Oo.getContentResolver(), "com.shumei.seq", str);
                    return;
                }
                throw new Exception("mContext == null");
            } catch (Exception e) {
                throw new Exception(e);
            }
        } else {
            throw new IOException("sdk " + Build.VERSION.SDK_INT + " less then 23");
        }
    }

    static /* synthetic */ void O00000Oo(blm blm, String str) {
        int i = Build.VERSION.SDK_INT < 23 ? 2 : 0;
        try {
            if (blm.O00000Oo != null) {
                SharedPreferences.Editor edit = blm.O00000Oo.getSharedPreferences("seq", i).edit();
                edit.putString("seq", str);
                if (!edit.commit()) {
                    throw new IOException("editor commit failed");
                }
                return;
            }
            throw new Exception("mContext == null");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
