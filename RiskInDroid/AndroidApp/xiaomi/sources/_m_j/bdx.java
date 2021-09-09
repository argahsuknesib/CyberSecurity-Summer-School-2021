package _m_j;

import com.imi.fastjson.JSONArray;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

public final class bdx implements bff {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final bdx f12894O000000o = new bdx();

    public final int O000000o() {
        return 14;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:49:0x00c2 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r2v12 */
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
    /* JADX WARNING: Multi-variable type inference failed */
    public final <T> T O000000o(_m_j.bdo r7, java.lang.reflect.Type r8, java.lang.Object r9) {
        /*
            r6 = this;
            _m_j.bdp r0 = r7.O0000O0o()
            int r1 = r0.O00000o0()
            r2 = 0
            r3 = 16
            r4 = 8
            if (r1 != r4) goto L_0x0013
            r0.O000000o(r3)
            return r2
        L_0x0013:
            java.lang.Class<java.util.concurrent.atomic.AtomicIntegerArray> r1 = java.util.concurrent.atomic.AtomicIntegerArray.class
            r4 = 0
            if (r8 != r1) goto L_0x0042
            com.imi.fastjson.JSONArray r8 = new com.imi.fastjson.JSONArray
            r8.<init>()
            r7.O00000Oo(r8)
            java.util.concurrent.atomic.AtomicIntegerArray r7 = new java.util.concurrent.atomic.AtomicIntegerArray
            int r9 = r8.size()
            r7.<init>(r9)
        L_0x0029:
            int r9 = r8.size()
            if (r4 >= r9) goto L_0x0041
            java.lang.Object r9 = r8.get(r4)
            java.lang.Integer r9 = _m_j.bih.O0000Oo(r9)
            int r9 = r9.intValue()
            r7.set(r4, r9)
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0041:
            return r7
        L_0x0042:
            java.lang.Class<java.util.concurrent.atomic.AtomicLongArray> r1 = java.util.concurrent.atomic.AtomicLongArray.class
            if (r8 != r1) goto L_0x0070
            com.imi.fastjson.JSONArray r8 = new com.imi.fastjson.JSONArray
            r8.<init>()
            r7.O00000Oo(r8)
            java.util.concurrent.atomic.AtomicLongArray r7 = new java.util.concurrent.atomic.AtomicLongArray
            int r9 = r8.size()
            r7.<init>(r9)
        L_0x0057:
            int r9 = r8.size()
            if (r4 >= r9) goto L_0x006f
            java.lang.Object r9 = r8.get(r4)
            java.lang.Long r9 = _m_j.bih.O0000Oo0(r9)
            long r0 = r9.longValue()
            r7.set(r4, r0)
            int r4 = r4 + 1
            goto L_0x0057
        L_0x006f:
            return r7
        L_0x0070:
            int r1 = r0.O00000o0()
            r5 = 4
            if (r1 != r5) goto L_0x007f
            byte[] r7 = r0.O0000o0o()
            r0.O000000o(r3)
            return r7
        L_0x007f:
            boolean r0 = r8 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x00d6
            java.lang.reflect.GenericArrayType r8 = (java.lang.reflect.GenericArrayType) r8
            java.lang.reflect.Type r8 = r8.getGenericComponentType()
            boolean r0 = r8 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x00d2
            java.lang.reflect.TypeVariable r8 = (java.lang.reflect.TypeVariable) r8
            _m_j.bdt r0 = r7.O00000o()
            java.lang.reflect.Type r0 = r0.O00000o0
            boolean r1 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r1 == 0) goto L_0x00cf
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type r1 = r0.getRawType()
            boolean r3 = r1 instanceof java.lang.Class
            if (r3 == 0) goto L_0x00c5
            java.lang.Class r1 = (java.lang.Class) r1
            java.lang.reflect.TypeVariable[] r1 = r1.getTypeParameters()
        L_0x00a9:
            int r3 = r1.length
            if (r4 >= r3) goto L_0x00c5
            r3 = r1[r4]
            java.lang.String r3 = r3.getName()
            java.lang.String r5 = r8.getName()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00c2
            java.lang.reflect.Type[] r2 = r0.getActualTypeArguments()
            r2 = r2[r4]
        L_0x00c2:
            int r4 = r4 + 1
            goto L_0x00a9
        L_0x00c5:
            boolean r8 = r2 instanceof java.lang.Class
            if (r8 == 0) goto L_0x00cc
            java.lang.Class r2 = (java.lang.Class) r2
            goto L_0x00dc
        L_0x00cc:
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            goto L_0x00dc
        L_0x00cf:
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            goto L_0x00dc
        L_0x00d2:
            r2 = r8
            java.lang.Class r2 = (java.lang.Class) r2
            goto L_0x00dc
        L_0x00d6:
            java.lang.Class r8 = (java.lang.Class) r8
            java.lang.Class r2 = r8.getComponentType()
        L_0x00dc:
            com.imi.fastjson.JSONArray r8 = new com.imi.fastjson.JSONArray
            r8.<init>()
            r7.O000000o(r2, r8, r9)
            java.lang.Object r7 = r6.O000000o(r7, r2, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bdx.O000000o(_m_j.bdo, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T
     arg types: [java.lang.Object, java.lang.Class<?>, _m_j.bdu]
     candidates:
      _m_j.bih.O000000o(java.lang.Object, java.lang.reflect.Type, _m_j.bdu):T
      _m_j.bih.O000000o(java.util.Map<java.lang.String, java.lang.Object>, java.lang.Class, _m_j.bdu):T
      _m_j.bih.O000000o(java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.String>, boolean):java.util.List<_m_j.bid>
      _m_j.bih.O000000o(java.lang.Object, java.lang.Class, _m_j.bdu):T */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    private <T> T O000000o(bdo bdo, Class<?> cls, JSONArray jSONArray) {
        Object obj;
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T newInstance = Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object obj2 = jSONArray.get(i);
            if (obj2 == jSONArray) {
                Array.set(newInstance, i, newInstance);
            } else if (cls.isArray()) {
                if (!cls.isInstance(obj2)) {
                    obj2 = O000000o(bdo, cls, (JSONArray) obj2);
                }
                Array.set(newInstance, i, obj2);
            } else {
                if (obj2 instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) obj2;
                    int size2 = jSONArray2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (jSONArray2.get(i2) == jSONArray) {
                            jSONArray2.set(i, newInstance);
                            z = true;
                        }
                    }
                    if (z) {
                        obj = jSONArray2.toArray();
                        if (obj == null) {
                            obj = bih.O000000o(obj2, (Class) cls, bdo.O00000o0());
                        }
                        Array.set(newInstance, i, obj);
                    }
                }
                obj = null;
                if (obj == null) {
                }
                Array.set(newInstance, i, obj);
            }
        }
        jSONArray.O00000o0(newInstance);
        jSONArray.O000000o((Type) cls);
        return newInstance;
    }
}
