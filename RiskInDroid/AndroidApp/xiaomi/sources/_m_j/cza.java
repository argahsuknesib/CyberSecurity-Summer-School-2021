package _m_j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cza<I> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Map<Class, cza> f14393O000000o = new HashMap();
    private static final czc O00000o0 = new czc("ServiceLoader") {
        /* class _m_j.cza.AnonymousClass1 */

        public final void O000000o() {
            try {
                Class.forName("com.sankuai.waimai.router.generated.ServiceLoaderInit").getMethod("init", new Class[0]).invoke(null, new Object[0]);
                cvb.O00000o();
            } catch (Exception unused) {
                cvb.O0000OOo();
            }
        }
    };
    public HashMap<String, cyz> O00000Oo;
    private final String O00000o;

    /* synthetic */ cza() {
        this(null);
    }

    public static void O000000o(Class cls, String str, Class cls2, boolean z) {
        cza cza = f14393O000000o.get(cls);
        if (cza == null) {
            cza = new cza(cls);
            f14393O000000o.put(cls, cza);
        }
        cza.O00000Oo.put(str, new cyz(str, cls2, z));
    }

    public static <T> cza<T> O000000o(Class<T> cls) {
        O00000o0.O00000Oo();
        if (cls == null) {
            new NullPointerException("ServiceLoader.load的class参数不应为空");
            cvb.O0000OOo();
            return O000000o.O00000o0;
        }
        cza<T> cza = f14393O000000o.get(cls);
        if (cza == null) {
            synchronized (f14393O000000o) {
                cza = f14393O000000o.get(cls);
                if (cza == null) {
                    cza = new cza<>(cls);
                    f14393O000000o.put(cls, cza);
                }
            }
        }
        return cza;
    }

    private cza(Class cls) {
        this.O00000Oo = new HashMap<>();
        if (cls == null) {
            this.O00000o = "";
        } else {
            this.O00000o = cls.getName();
        }
    }

    public <T extends I> List<T> O000000o() {
        return O00000Oo();
    }

    public <T extends I> List<T> O00000Oo() {
        Collection<cyz> values = this.O00000Oo.values();
        if (values.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(values.size());
        for (cyz O000000o2 : values) {
            Object O000000o3 = O000000o(O000000o2, null);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "ServiceLoader (" + this.O00000o + ")";
    }

    public static class O000000o extends cza {
        public static final cza O00000o0 = new O000000o();

        public final String toString() {
            return "EmptyServiceLoader";
        }

        public final List O000000o() {
            return Collections.emptyList();
        }

        public final List O00000Oo() {
            return Collections.emptyList();
        }
    }

    public static <T extends I> T O000000o(cyz cyz, cyy cyy) {
        if (cyz == null) {
            return null;
        }
        Class cls = cyz.O00000Oo;
        if (cyz.O00000o0) {
            try {
                return czg.O000000o(cls, cyy);
            } catch (Exception unused) {
                cvb.O0000OOo();
                return null;
            }
        } else {
            if (cyy == null) {
                try {
                    cyy = cux.O000000o();
                } catch (Exception unused2) {
                    cvb.O0000OOo();
                    return null;
                }
            }
            T O000000o2 = cyy.O000000o(cls);
            Object[] objArr = {cls, O000000o2};
            cvb.O00000o();
            return O000000o2;
        }
    }
}
