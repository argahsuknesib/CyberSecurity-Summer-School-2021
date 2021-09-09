package _m_j;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

public class qk {
    private static final String O00000oo = "qk";

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2398O000000o;
    public oh O00000Oo;
    public ox O00000o;
    public qm O00000o0;
    public to O00000oO = new to() {
        /* class _m_j.qk.AnonymousClass1 */

        public final void O000000o(pm pmVar) {
            qk.O000000o(qk.this, pmVar.O000000o());
        }
    };
    private O000000o O0000O0o;

    public interface O000000o {
        void O000000o();
    }

    public qk(Context context, oh ohVar, ox oxVar, O000000o o000000o) {
        this.f2398O000000o = context;
        this.O00000Oo = ohVar;
        this.O00000o = oxVar;
        this.O0000O0o = o000000o;
    }

    static /* synthetic */ void O000000o(qk qkVar, String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("c");
                boolean z2 = false;
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("cls", qkVar.O00000Oo.O00000o0.f2343O000000o);
                    if (optBoolean != qkVar.O00000Oo.O00000o0.f2343O000000o) {
                        qkVar.O00000Oo.O00000o0.f2343O000000o = optBoolean;
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean optBoolean2 = optJSONObject.optBoolean("cts", qkVar.O00000Oo.O00000o.f2344O000000o);
                    if (optBoolean2 != qkVar.O00000Oo.O00000o.f2344O000000o) {
                        qkVar.O00000Oo.O00000o.f2344O000000o = optBoolean2;
                        z = true;
                    }
                    if (optJSONObject.optInt("cnwuss", qkVar.O00000Oo.O00000oO.f2345O000000o ? 1 : 0) == 1) {
                        z2 = true;
                    }
                    if (z2 != qkVar.O00000Oo.O00000oO.f2345O000000o) {
                        qkVar.O00000Oo.O00000oO.f2345O000000o = z2;
                        z = true;
                    }
                    boolean optBoolean3 = optJSONObject.optBoolean("cfup", qkVar.O00000Oo.O00000o0.O00000o);
                    if (optBoolean3 != qkVar.O00000Oo.O00000o0.O00000o) {
                        qkVar.O00000Oo.O00000o0.O00000o = optBoolean3;
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                if (z2 && qkVar.O0000O0o != null) {
                    qkVar.O0000O0o.O000000o();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
