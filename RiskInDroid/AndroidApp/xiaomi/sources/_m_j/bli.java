package _m_j;

import com.ishumei.smantifraud.SmAntiFraud;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bli implements blk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f13036O000000o;
    private static String O00000Oo;
    private static String O00000o;
    private static String O00000o0;
    private static String O00000oO;
    private static String O00000oo;
    private static String O0000O0o;
    private static String O0000OOo;
    private static String O0000Oo;
    private static String O0000Oo0;
    private static String O0000OoO;
    private static String O0000Ooo;
    private static String O0000o;
    private static String O0000o0;
    private static String O0000o00;
    private static String O0000o0O;
    private static String O0000o0o;
    private static bli O0000oO0 = null;

    static {
        try {
            f13036O000000o = bnd.O00000o0("8f8d96899e9c86");
            O00000Oo = bnd.O00000o0("8d8b868f9a");
            O00000o0 = bnd.O00000o0("8b9e8d989a8ba08c9b94");
            O00000o = bnd.O00000o0("9e9d8b929e9c");
            O00000oO = bnd.O00000o0("9e878f908c9a9b");
            O00000oo = bnd.O00000o0("9e96919990");
            O0000O0o = bnd.O00000o0("908c");
            O0000OOo = bnd.O00000o0("96929a96");
            O0000Oo0 = bnd.O00000o0("96929a96ce");
            O0000Oo = bnd.O00000o0("96929a96cd");
            O0000OoO = bnd.O00000o0("9e9b969b");
            O0000Ooo = bnd.O00000o0("8c91");
            O0000o00 = bnd.O00000o0("9e9d8b929e9c");
            O0000o0 = bnd.O00000o0("8c92969b");
            O0000o0O = bnd.O00000o0("919a8b");
            O0000o0o = bnd.O00000o0("9d90908b");
            O0000o = bnd.O00000o0("9e8f8fb69b");
        } catch (Exception unused) {
        }
    }

    public static bli O000000o() {
        if (O0000oO0 == null) {
            synchronized (bli.class) {
                if (O0000oO0 == null) {
                    O0000oO0 = new bli();
                }
            }
        }
        return O0000oO0;
    }

    public final Map<String, Object> O000000o(int i) {
        HashMap hashMap = new HashMap();
        try {
            Set<String> set = SmAntiFraud.f4498O000000o.O0000Ooo;
            if (set == null) {
                set = Collections.emptySet();
            }
            hashMap.put(O00000Oo, "core");
            int i2 = i & 1;
            hashMap.put(f13036O000000o, i2 == 1 ? "md5" : "none");
            hashMap.put(O0000O0o, "android");
            hashMap.put(O0000o, SmAntiFraud.f4498O000000o.O0000o00);
            blo.O000000o().O00000o0();
            hashMap.put(O0000o0, blo.O000000o().O00000Oo());
            if (i2 == 1) {
                if (!set.contains(O0000OOo)) {
                    hashMap.put(O0000OOo, bne.O00000oo(bms.O000000o().O00000Oo()));
                    hashMap.put(O0000Oo0, bne.O00000oo(bms.O000000o().O000000o(1)));
                    hashMap.put(O0000Oo, bne.O00000oo(bms.O000000o().O000000o(2)));
                }
                if (!set.contains(O0000OoO)) {
                    hashMap.put(O0000OoO, bne.O00000oo(bmq.O000000o().O00000Oo()));
                }
                if (!set.contains(O0000Ooo)) {
                    String str = O0000Ooo;
                    bmr.O000000o();
                    hashMap.put(str, bne.O00000oo(bmr.O000000o(bnd.O00000o0("8d90d18c9a8d969e939190"))));
                }
                if (!set.contains(O0000o00)) {
                    hashMap.put(O0000o00, bne.O00000oo(bmo.O000000o().O00000o()));
                }
                if (!set.contains(O00000o)) {
                    String str2 = O00000o;
                    bmh.O000000o();
                    hashMap.put(str2, bne.O00000oo(bmh.O00000o0()));
                }
                if (!set.contains(O0000o0O)) {
                    bmo.O000000o();
                    List<String> O0000OOo2 = bmo.O0000OOo();
                    ArrayList arrayList = new ArrayList(O0000OOo2.size());
                    for (String O00000oo2 : O0000OOo2) {
                        arrayList.add(bne.O00000oo(O00000oo2));
                    }
                    hashMap.put(O0000o0O, arrayList);
                }
            } else {
                if (!set.contains(O0000OOo)) {
                    hashMap.put(O0000OOo, bms.O000000o().O00000Oo());
                    hashMap.put(O0000Oo0, bms.O000000o().O000000o(1));
                    hashMap.put(O0000Oo, bms.O000000o().O000000o(2));
                }
                if (!set.contains(O0000OoO)) {
                    hashMap.put(O0000OoO, bmq.O000000o().O00000Oo());
                }
                if (!set.contains(O0000Ooo)) {
                    String str3 = O0000Ooo;
                    bmr.O000000o();
                    hashMap.put(str3, bmr.O000000o(bnd.O00000o0("8d90d18c9a8d969e939190")));
                }
                if (!set.contains(O0000o00)) {
                    hashMap.put(O0000o00, bmo.O000000o().O00000o());
                }
                if (!set.contains(O00000o)) {
                    String str4 = O00000o;
                    bmh.O000000o();
                    hashMap.put(str4, bmh.O00000o0());
                }
                if (!set.contains(O0000o0O)) {
                    bmo.O000000o();
                    hashMap.put(O0000o0O, bmo.O0000OOo());
                }
            }
            String str5 = O0000o0o;
            bmq.O000000o();
            hashMap.put(str5, Long.valueOf(bmq.O00000o0()));
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
