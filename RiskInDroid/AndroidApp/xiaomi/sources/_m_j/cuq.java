package _m_j;

import android.app.Activity;
import android.text.TextUtils;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class cuq extends cve {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f14371O000000o = true;
    private final Map<String, cuo> O00000Oo = new HashMap();
    private final String O00000o0;
    private final String O00000oO;
    private final czc O00000oo = new czc("UriAnnotationHandler") {
        /* class _m_j.cuq.AnonymousClass1 */

        public final void O000000o() {
            cux.O000000o(cuq.this, cuk.class);
        }
    };

    public String toString() {
        return "UriAnnotationHandler";
    }

    public cuq(String str, String str2) {
        this.O00000o0 = czf.O00000Oo(str);
        this.O00000oO = czf.O00000Oo(str2);
    }

    public void O000000o(String str, String str2, String str3, Object obj, boolean z, cvf... cvfArr) {
        cve cve;
        if (TextUtils.isEmpty(str)) {
            str = this.O00000o0;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.O00000oO;
        }
        String O000000o2 = czf.O000000o(str, str2);
        cuo cuo = this.O00000Oo.get(O000000o2);
        if (cuo == null) {
            cuo = new cuo();
            if (f14371O000000o) {
                cuo.O00000o0 = cum.f14366O000000o;
            }
            this.O00000Oo.put(O000000o2, cuo);
        }
        if (!TextUtils.isEmpty(str3)) {
            String O00000o02 = czf.O00000o0(str3);
            T t = null;
            if (obj instanceof cve) {
                cve = (cve) obj;
            } else if (obj instanceof String) {
                cve = new cud((String) obj);
            } else {
                if (obj instanceof Class) {
                    Class cls = (Class) obj;
                    if (cls != null && Activity.class.isAssignableFrom(cls) && !Modifier.isAbstract(cls.getModifiers())) {
                        cve = new cue(cls);
                    }
                }
                cve = null;
            }
            if (cve != null) {
                if (!z) {
                    cve.O000000o(cul.f14365O000000o);
                }
                cve.O000000o(cvfArr);
            }
            czb<cve> czb = cuo.O00000Oo;
            if (!TextUtils.isEmpty(O00000o02) && cve != null) {
                t = czb.f14394O000000o.put(czf.O000000o(O00000o02), cve);
            }
            cve cve2 = (cve) t;
            if (cve2 != null) {
                Object[] objArr = {cuo, O00000o02, cve2, cve};
                cvb.O0000O0o();
            }
        }
    }

    private cuo O00000Oo(cvg cvg) {
        return this.O00000Oo.get(cvg.O00000o0());
    }

    public final void O00000Oo(cvg cvg, cvd cvd) {
        this.O00000oo.O00000Oo();
        super.O00000Oo(cvg, cvd);
    }

    public final boolean O000000o(cvg cvg) {
        return O00000Oo(cvg) != null;
    }

    public final void O000000o(cvg cvg, cvd cvd) {
        cuo O00000Oo2 = O00000Oo(cvg);
        if (O00000Oo2 != null) {
            O00000Oo2.O00000Oo(cvg, cvd);
        } else {
            cvd.O000000o();
        }
    }
}
