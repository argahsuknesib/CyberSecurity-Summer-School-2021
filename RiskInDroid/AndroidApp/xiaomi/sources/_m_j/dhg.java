package _m_j;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.ar;
import com.tencent.bugly.proguard.k;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dhg {

    /* renamed from: O000000o  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f14639O000000o = new HashMap<>();
    protected String O00000Oo;
    private HashMap<String, Object> O00000o;
    dhq O00000o0;

    dhg() {
        new HashMap();
        this.O00000o = new HashMap<>();
        this.O00000Oo = "GBK";
        this.O00000o0 = new dhq();
    }

    public void O000000o(String str) {
        this.O00000Oo = str;
    }

    private static aq O000000o(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.f5835a = userInfoBean.O00000oO;
        aqVar.e = userInfoBean.O0000Oo;
        aqVar.d = userInfoBean.O00000o0;
        aqVar.c = userInfoBean.O00000o;
        aqVar.g = dgs.O000000o().O00000oo();
        aqVar.h = userInfoBean.O0000o0O == 1;
        int i = userInfoBean.O00000Oo;
        if (i == 1) {
            aqVar.b = 1;
        } else if (i == 2) {
            aqVar.b = 4;
        } else if (i == 3) {
            aqVar.b = 2;
        } else if (i == 4) {
            aqVar.b = 3;
        } else if (userInfoBean.O00000Oo < 10 || userInfoBean.O00000Oo >= 20) {
            did.O00000oO("unknown uinfo type %d ", Integer.valueOf(userInfoBean.O00000Oo));
            return null;
        } else {
            aqVar.b = (byte) userInfoBean.O00000Oo;
        }
        aqVar.f = new HashMap();
        if (userInfoBean.O0000o0o >= 0) {
            Map<String, String> map = aqVar.f;
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.O0000o0o);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.O0000o >= 0) {
            Map<String, String> map2 = aqVar.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.O0000o);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.O0000oO0 != null && userInfoBean.O0000oO0.size() > 0) {
            for (Map.Entry next : userInfoBean.O0000oO0.entrySet()) {
                Map<String, String> map3 = aqVar.f;
                map3.put("C03_" + ((String) next.getKey()), next.getValue());
            }
        }
        if (userInfoBean.O0000oO != null && userInfoBean.O0000oO.size() > 0) {
            for (Map.Entry next2 : userInfoBean.O0000oO.entrySet()) {
                Map<String, String> map4 = aqVar.f;
                map4.put("C04_" + ((String) next2.getKey()), next2.getValue());
            }
        }
        Map<String, String> map5 = aqVar.f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.O0000Ooo);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = aqVar.f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.O0000O0o);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = aqVar.f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.O0000OOo);
        map7.put("F03", sb5.toString());
        Map<String, String> map8 = aqVar.f;
        map8.put("F04", userInfoBean.O0000Oo);
        Map<String, String> map9 = aqVar.f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.O0000Oo0);
        map9.put("F05", sb6.toString());
        Map<String, String> map10 = aqVar.f;
        map10.put("F06", userInfoBean.O0000o00);
        Map<String, String> map11 = aqVar.f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.O0000OoO);
        map11.put("F10", sb7.toString());
        did.O00000o0("summary type %d vm:%d", Byte.valueOf(aqVar.b), Integer.valueOf(aqVar.f.size()));
        return aqVar;
    }

    private static String O000000o(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            String str = "map";
            if (i < arrayList.size()) {
                String str2 = arrayList.get(i);
                if (str2.equals("java.lang.Integer") || str2.equals("int")) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else if (str2.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else if (str2.equals("java.lang.String")) {
                    str = "string";
                } else if (str2.equals("java.util.List")) {
                    str = "list";
                } else if (!str2.equals("java.util.Map")) {
                    str = str2;
                }
                arrayList.set(i, str);
                i++;
            } else {
                Collections.reverse(arrayList);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    String str3 = arrayList.get(i2);
                    if (str3.equals("list")) {
                        int i3 = i2 - 1;
                        arrayList.set(i3, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals(str)) {
                        int i4 = i2 - 1;
                        arrayList.set(i4, "<" + arrayList.get(i4) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        int i5 = i2 - 1;
                        arrayList.set(i5, "<" + arrayList.get(i5));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void O000000o(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (obj == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(obj instanceof Set)) {
            dhr dhr = new dhr();
            dhr.O00000Oo = this.O00000Oo;
            dhr.O000000o(obj, 0);
            byte[] O000000o2 = dhs.O000000o(dhr.f14645O000000o);
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            O000000o(arrayList, obj);
            hashMap.put(O000000o((ArrayList<String>) arrayList), O000000o2);
            this.O00000o.remove(str);
            this.f14639O000000o.put(str, hashMap);
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    public static ar O000000o(List<UserInfoBean> list, int i) {
        dgs O000000o2;
        if (list == null || list.size() == 0 || (O000000o2 = dgs.O000000o()) == null) {
            return null;
        }
        O000000o2.O0000o();
        ar arVar = new ar();
        arVar.b = O000000o2.O00000oo;
        arVar.c = O000000o2.O00000oO();
        ArrayList<aq> arrayList = new ArrayList<>();
        for (UserInfoBean O000000o3 : list) {
            aq O000000o4 = O000000o(O000000o3);
            if (O000000o4 != null) {
                arrayList.add(O000000o4);
            }
        }
        arVar.d = arrayList;
        arVar.e = new HashMap();
        Map<String, String> map = arVar.e;
        map.put("A7", O000000o2.O0000OOo);
        Map<String, String> map2 = arVar.e;
        map2.put("A6", O000000o2.O0000o0o());
        Map<String, String> map3 = arVar.e;
        map3.put("A5", O000000o2.O0000o0O());
        Map<String, String> map4 = arVar.e;
        StringBuilder sb = new StringBuilder();
        sb.append(O000000o2.O0000o00());
        map4.put("A2", sb.toString());
        Map<String, String> map5 = arVar.e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(O000000o2.O0000o00());
        map5.put("A1", sb2.toString());
        Map<String, String> map6 = arVar.e;
        map6.put("A24", O000000o2.O0000Oo);
        Map<String, String> map7 = arVar.e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(O000000o2.O0000o0());
        map7.put("A17", sb3.toString());
        Map<String, String> map8 = arVar.e;
        map8.put("A15", O000000o2.O0000oOO());
        Map<String, String> map9 = arVar.e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(O000000o2.O0000oOo());
        map9.put("A13", sb4.toString());
        Map<String, String> map10 = arVar.e;
        map10.put("F08", O000000o2.O000O0Oo);
        Map<String, String> map11 = arVar.e;
        map11.put("F09", O000000o2.O00oOoOo);
        Map<String, String> O000O0Oo = O000000o2.O000O0Oo();
        if (O000O0Oo != null && O000O0Oo.size() > 0) {
            for (Map.Entry next : O000O0Oo.entrySet()) {
                Map<String, String> map12 = arVar.e;
                map12.put("C04_" + ((String) next.getKey()), next.getValue());
            }
        }
        if (i == 1) {
            arVar.f5837a = 1;
        } else if (i != 2) {
            did.O00000oO("unknown up type %d ", Integer.valueOf(i));
            return null;
        } else {
            arVar.f5837a = 2;
        }
        return arVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <T extends com.tencent.bugly.proguard.k> T O000000o(byte[] r2, java.lang.Class r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0024
            int r1 = r2.length
            if (r1 > 0) goto L_0x0007
            goto L_0x0024
        L_0x0007:
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Throwable -> 0x001a }
            com.tencent.bugly.proguard.k r3 = (com.tencent.bugly.proguard.k) r3     // Catch:{ Throwable -> 0x001a }
            _m_j.dhq r1 = new _m_j.dhq     // Catch:{ Throwable -> 0x001a }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x001a }
            java.lang.String r2 = "utf-8"
            r1.f14643O000000o = r2     // Catch:{ Throwable -> 0x001a }
            r3.O000000o(r1)     // Catch:{ Throwable -> 0x001a }
            return r3
        L_0x001a:
            r2 = move-exception
            boolean r3 = _m_j.did.O00000Oo(r2)
            if (r3 != 0) goto L_0x0024
            r2.printStackTrace()
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.dhg.O000000o(byte[], java.lang.Class):com.tencent.bugly.proguard.k");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x027e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0283, code lost:
        if (_m_j.did.O00000Oo(r8) == false) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0285, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0288, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static am O000000o(Context context, int i, byte[] bArr) {
        dgs O000000o2 = dgs.O000000o();
        StrategyBean O00000o02 = dgu.O000000o().O00000o0();
        if (O000000o2 == null || O00000o02 == null) {
            did.O00000oO("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        am amVar = new am();
        synchronized (O000000o2) {
            amVar.f5828a = 1;
            amVar.b = O000000o2.O00000o0();
            amVar.c = O000000o2.O00000oO;
            amVar.d = O000000o2.O0000o0;
            amVar.e = O000000o2.O0000o;
            O000000o2.getClass();
            amVar.f = "2.6.6";
            amVar.g = i;
            amVar.h = bArr == null ? "".getBytes() : bArr;
            amVar.i = O000000o2.O0000Oo0;
            amVar.j = O000000o2.O0000Oo;
            amVar.k = new HashMap();
            amVar.l = O000000o2.O00000Oo();
            amVar.m = O00000o02.O0000o0o;
            amVar.o = O000000o2.O00000oO();
            amVar.p = dgt.O00000oo(context);
            amVar.q = System.currentTimeMillis();
            amVar.r = O000000o2.O0000OOo();
            amVar.s = O000000o2.O0000O0o();
            amVar.t = O000000o2.O0000Oo();
            amVar.u = O000000o2.O0000Oo0();
            amVar.v = O000000o2.O0000OoO();
            amVar.w = amVar.p;
            O000000o2.getClass();
            amVar.n = "com.tencent.bugly";
            Map<String, String> map = amVar.k;
            map.put("A26", O000000o2.O0000oo0());
            Map<String, String> map2 = amVar.k;
            map2.put("A60", O000000o2.O0000oo());
            Map<String, String> map3 = amVar.k;
            map3.put("A61", O000000o2.O0000ooO());
            Map<String, String> map4 = amVar.k;
            StringBuilder sb = new StringBuilder();
            sb.append(O000000o2.O000O0oO);
            map4.put("F11", sb.toString());
            Map<String, String> map5 = amVar.k;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O000000o2.O000O0o);
            map5.put("F12", sb2.toString());
            Map<String, String> map6 = amVar.k;
            map6.put("G1", O000000o2.O0000oO0());
            if (O000000o2.O000OO00) {
                Map<String, String> map7 = amVar.k;
                map7.put("G2", O000000o2.O000O0oO());
                Map<String, String> map8 = amVar.k;
                map8.put("G3", O000000o2.O000O0oo());
                Map<String, String> map9 = amVar.k;
                map9.put("G4", O000000o2.O000OO00());
                Map<String, String> map10 = amVar.k;
                map10.put("G5", dgs.O000OO0o());
                Map<String, String> map11 = amVar.k;
                map11.put("G6", O000000o2.O000OO());
                Map<String, String> map12 = amVar.k;
                map12.put("G7", Long.toString(dgs.O000OOOo()));
            }
            Map<String, String> map13 = amVar.k;
            map13.put("D3", O000000o2.O0000o0O);
            if (dgm.O00000Oo != null) {
                for (dgl next : dgm.O00000Oo) {
                    if (!(next.O00000Oo == null || next.O00000o0 == null)) {
                        amVar.k.put(next.O00000Oo, next.O00000o0);
                    }
                }
            }
            amVar.k.put("G15", dif.O00000Oo("G15", ""));
            amVar.k.put("D4", dif.O00000Oo("D4", "0"));
        }
        dia O000000o3 = dia.O000000o();
        if (!(O000000o3 == null || O000000o3.O00000oo || bArr == null)) {
            amVar.h = dif.O000000o(amVar.h, O00000o02.O0000oOo);
            if (amVar.h == null) {
                did.O00000oO("reqPkg sbuffer error!", new Object[0]);
                return null;
            }
        }
        Map<String, String> O000O0OO = O000000o2.O000O0OO();
        if (O000O0OO != null) {
            for (Map.Entry next2 : O000O0OO.entrySet()) {
                amVar.k.put(next2.getKey(), next2.getValue());
            }
        }
        return amVar;
    }

    private void O000000o(ArrayList<String> arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (!obj.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                } else if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    obj = Array.get(obj, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            } else if (obj instanceof Array) {
                throw new IllegalArgumentException("can not support Array, please use List");
            } else if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    obj = list.get(0);
                } else {
                    arrayList.add("?");
                    return;
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj = map.get(next);
                    arrayList.add(next.getClass().getName());
                } else {
                    arrayList.add("?");
                    arrayList.add("?");
                    return;
                }
            } else {
                arrayList.add(obj.getClass().getName());
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhr.O000000o(java.util.Map, int):void
     arg types: [java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>>, int]
     candidates:
      _m_j.dhr.O000000o(byte, int):void
      _m_j.dhr.O000000o(int, int):void
      _m_j.dhr.O000000o(long, int):void
      _m_j.dhr.O000000o(com.tencent.bugly.proguard.k, int):void
      _m_j.dhr.O000000o(java.lang.Object, int):void
      _m_j.dhr.O000000o(java.lang.String, int):void
      _m_j.dhr.O000000o(java.util.Collection, int):void
      _m_j.dhr.O000000o(short, int):void
      _m_j.dhr.O000000o(boolean, int):void
      _m_j.dhr.O000000o(byte[], int):void
      _m_j.dhr.O000000o(java.util.Map, int):void */
    public byte[] O000000o() {
        dhr dhr = new dhr(0);
        dhr.O00000Oo = this.O00000Oo;
        dhr.O000000o((Map) this.f14639O000000o, 0);
        return dhs.O000000o(dhr.f14645O000000o);
    }

    public void O000000o(byte[] bArr) {
        this.O00000o0.O000000o(bArr);
        this.O00000o0.f14643O000000o = this.O00000Oo;
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f14639O000000o = this.O00000o0.O000000o(hashMap);
    }

    public static byte[] O000000o(Object obj) {
        try {
            dhn dhn = new dhn();
            dhn.O00000Oo();
            dhn.O000000o("utf-8");
            dhn.O00000oO.b = 1;
            dhn.O00000oO.c = "RqdServer";
            dhn.O00000oO.d = "sync";
            dhn.O000000o("detail", obj);
            return dhn.O000000o();
        } catch (Throwable th) {
            if (did.O00000Oo(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static an O000000o(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                dhn dhn = new dhn();
                dhn.O00000Oo();
                dhn.O000000o("utf-8");
                dhn.O000000o(bArr);
                Object O00000Oo2 = dhn.O00000Oo("detail", new an());
                an cast = an.class.isInstance(O00000Oo2) ? an.class.cast(O00000Oo2) : null;
                if (!z && cast != null && cast.c != null && cast.c.length > 0) {
                    did.O00000o0("resp buf %d", Integer.valueOf(cast.c.length));
                    cast.c = dif.O00000Oo(cast.c, StrategyBean.O00000o);
                    if (cast.c == null) {
                        did.O00000oO("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return cast;
            } catch (Throwable th) {
                if (!did.O00000Oo(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] O000000o(k kVar) {
        try {
            dhr dhr = new dhr();
            dhr.O00000Oo = "utf-8";
            kVar.O000000o(dhr);
            byte[] bArr = new byte[dhr.f14645O000000o.position()];
            System.arraycopy(dhr.f14645O000000o.array(), 0, bArr, 0, dhr.f14645O000000o.position());
            return bArr;
        } catch (Throwable th) {
            if (did.O00000Oo(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
