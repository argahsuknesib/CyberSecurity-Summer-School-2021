package com.google.android.gms.common.util;

import _m_j.jdn;
import java.util.HashMap;

public class MapUtils {
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: K
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <K, V> K getKeyFromMap(java.util.Map<K, V> r2, K r3) {
        /*
            boolean r0 = r2.containsKey(r3)
            if (r0 == 0) goto L_0x001f
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = r2.next()
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x000e
            return r0
        L_0x001f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.MapUtils.getKeyFromMap(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            } else {
                z = false;
            }
            String str = hashMap.get(next);
            sb.append(jdn.f1779O000000o);
            sb.append(next);
            sb.append("\":");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(jdn.f1779O000000o);
                sb.append(str);
                sb.append(jdn.f1779O000000o);
            }
        }
        sb.append("}");
    }
}
