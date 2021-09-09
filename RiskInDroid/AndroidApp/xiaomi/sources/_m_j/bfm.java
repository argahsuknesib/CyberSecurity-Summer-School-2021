package _m_j;

import java.lang.reflect.Constructor;

public final class bfm extends bew {
    public final int O000000o() {
        return 12;
    }

    public bfm(bdu bdu, Class<?> cls) {
        super(bdu, cls);
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
    public final <T> T O000000o(_m_j.bdo r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            r12 = this;
            _m_j.bdp r15 = r13.O0000O0o()
            int r0 = r15.O00000o0()
            r1 = 8
            r2 = 0
            if (r0 != r1) goto L_0x0011
            r15.O000000o()
            return r2
        L_0x0011:
            int r0 = r13.O0000O0o
            r3 = 2
            java.lang.String r4 = "syntax error"
            if (r0 != r3) goto L_0x001c
            r0 = 0
            r13.O0000O0o = r0
            goto L_0x0024
        L_0x001c:
            int r0 = r15.O00000o0()
            r3 = 12
            if (r0 != r3) goto L_0x0100
        L_0x0024:
            if (r14 == 0) goto L_0x0035
            boolean r0 = r14 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0035
            java.lang.Class r14 = (java.lang.Class) r14
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            boolean r0 = r0.isAssignableFrom(r14)
            if (r0 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r14 = r2
        L_0x0036:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3 = r14
            r14 = r2
            r5 = r14
            r6 = r5
        L_0x003f:
            _m_j.bdv r7 = r13.O00000Oo()
            java.lang.String r7 = r15.O000000o(r7)
            r8 = 13
            r9 = 16
            if (r7 != 0) goto L_0x0066
            int r10 = r15.O00000o0()
            if (r10 != r8) goto L_0x0058
            r15.O000000o(r9)
            goto L_0x00de
        L_0x0058:
            int r10 = r15.O00000o0()
            if (r10 != r9) goto L_0x0066
            com.imi.fastjson.parser.Feature r10 = com.imi.fastjson.parser.Feature.AllowArbitraryCommas
            boolean r10 = r15.O000000o(r10)
            if (r10 != 0) goto L_0x003f
        L_0x0066:
            r10 = 4
            r15.O00000Oo(r10)
            java.lang.String r11 = _m_j.bdf.f12884O000000o
            boolean r11 = r11.equals(r7)
            if (r11 == 0) goto L_0x008a
            int r3 = r15.O00000o0()
            if (r3 != r10) goto L_0x0084
            java.lang.String r3 = r15.O0000oO0()
            java.lang.Class r3 = _m_j.bih.O000000o(r3)
            r15.O000000o(r9)
            goto L_0x00d5
        L_0x0084:
            com.imi.fastjson.JSONException r13 = new com.imi.fastjson.JSONException
            r13.<init>(r4)
            throw r13
        L_0x008a:
            java.lang.String r11 = "message"
            boolean r11 = r11.equals(r7)
            if (r11 == 0) goto L_0x00ae
            int r5 = r15.O00000o0()
            if (r5 != r1) goto L_0x009a
            r5 = r2
            goto L_0x00a4
        L_0x009a:
            int r5 = r15.O00000o0()
            if (r5 != r10) goto L_0x00a8
            java.lang.String r5 = r15.O0000oO0()
        L_0x00a4:
            r15.O000000o()
            goto L_0x00d5
        L_0x00a8:
            com.imi.fastjson.JSONException r13 = new com.imi.fastjson.JSONException
            r13.<init>(r4)
            throw r13
        L_0x00ae:
            java.lang.String r10 = "cause"
            boolean r11 = r10.equals(r7)
            if (r11 == 0) goto L_0x00bd
            java.lang.Object r14 = r12.O000000o(r13, r2, r10)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            goto L_0x00d5
        L_0x00bd:
            java.lang.String r10 = "stackTrace"
            boolean r10 = r10.equals(r7)
            if (r10 == 0) goto L_0x00ce
            java.lang.Class<java.lang.StackTraceElement[]> r6 = java.lang.StackTraceElement[].class
            java.lang.Object r6 = r13.O000000o(r6)
            java.lang.StackTraceElement[] r6 = (java.lang.StackTraceElement[]) r6
            goto L_0x00d5
        L_0x00ce:
            java.lang.Object r10 = r13.O000000o(r2)
            r0.put(r7, r10)
        L_0x00d5:
            int r7 = r15.O00000o0()
            if (r7 != r8) goto L_0x003f
            r15.O000000o(r9)
        L_0x00de:
            if (r3 != 0) goto L_0x00e6
            java.lang.Exception r13 = new java.lang.Exception
            r13.<init>(r5, r14)
            goto L_0x00f1
        L_0x00e6:
            java.lang.Throwable r13 = O000000o(r5, r14, r3)     // Catch:{ Exception -> 0x00f7 }
            if (r13 != 0) goto L_0x00f1
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ Exception -> 0x00f7 }
            r13.<init>(r5, r14)     // Catch:{ Exception -> 0x00f7 }
        L_0x00f1:
            if (r6 == 0) goto L_0x00f6
            r13.setStackTrace(r6)
        L_0x00f6:
            return r13
        L_0x00f7:
            r13 = move-exception
            com.imi.fastjson.JSONException r14 = new com.imi.fastjson.JSONException
            java.lang.String r15 = "create instance error"
            r14.<init>(r15, r13)
            throw r14
        L_0x0100:
            com.imi.fastjson.JSONException r13 = new com.imi.fastjson.JSONException
            r13.<init>(r4)
            goto L_0x0107
        L_0x0106:
            throw r13
        L_0x0107:
            goto L_0x0106
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.bfm.O000000o(_m_j.bdo, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    private static Throwable O000000o(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            if (constructor4.getParameterTypes().length == 0) {
                constructor3 = constructor4;
            } else if (constructor4.getParameterTypes().length == 1 && constructor4.getParameterTypes()[0] == String.class) {
                constructor2 = constructor4;
            } else if (constructor4.getParameterTypes().length == 2 && constructor4.getParameterTypes()[0] == String.class && constructor4.getParameterTypes()[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        } else if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        } else if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        } else {
            return null;
        }
    }
}
