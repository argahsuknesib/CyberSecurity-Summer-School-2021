package bsh;

import _m_j.ld;

class BSHEnhancedForStatement extends SimpleNode implements ld {
    String varName;

    BSHEnhancedForStatement() {
        super(32);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v1, types: [bsh.SimpleNode] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [bsh.SimpleNode] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r5v5, types: [bsh.SimpleNode] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.Object, int]
     candidates:
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], boolean):bsh.BshMethod
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Class[], bsh.Interpreter):java.lang.Object
      bsh.NameSpace.O000000o(java.lang.String, java.lang.Object, boolean):void */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
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
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d A[LOOP:0: B:14:0x0058->B:33:0x009d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f A[SYNTHETIC] */
    public final java.lang.Object O000000o(_m_j.kv r12, bsh.Interpreter r13) throws bsh.EvalError {
        /*
            r11 = this;
            r0 = 0
            bsh.NameSpace r1 = r12.O000000o(r0)
            bsh.Node r2 = r11.O000000o(r0)
            bsh.SimpleNode r2 = (bsh.SimpleNode) r2
            int r3 = r11.O00000o0()
            boolean r4 = r2 instanceof bsh.BSHType
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x002f
            bsh.BSHType r2 = (bsh.BSHType) r2
            java.lang.Class r2 = r2.O00000Oo(r12, r13)
            bsh.Node r4 = r11.O000000o(r6)
            bsh.SimpleNode r4 = (bsh.SimpleNode) r4
            r7 = 2
            if (r3 <= r7) goto L_0x002b
            bsh.Node r3 = r11.O000000o(r7)
            r5 = r3
            bsh.SimpleNode r5 = (bsh.SimpleNode) r5
        L_0x002b:
            r3 = r5
            r5 = r2
            r2 = r4
            goto L_0x0039
        L_0x002f:
            if (r3 <= r6) goto L_0x0038
            bsh.Node r3 = r11.O000000o(r6)
            bsh.SimpleNode r3 = (bsh.SimpleNode) r3
            goto L_0x0039
        L_0x0038:
            r3 = r5
        L_0x0039:
            bsh.BlockNameSpace r4 = new bsh.BlockNameSpace
            r4.<init>(r1)
            r12.O00000Oo(r4)
            java.lang.Object r2 = r2.O000000o(r12, r13)
            bsh.Primitive r7 = bsh.Primitive.O00000Oo
            if (r2 == r7) goto L_0x00d2
            _m_j.ky.O000000o()
            boolean r7 = _m_j.ky.O000000o(r2)
            if (r7 == 0) goto L_0x00ba
            _m_j.ku r2 = _m_j.ky.O00000Oo(r2)
            bsh.Primitive r7 = bsh.Primitive.O00000o0
        L_0x0058:
            boolean r8 = r2.O00000Oo()
            if (r8 != 0) goto L_0x005f
            goto L_0x00a0
        L_0x005f:
            if (r5 == 0) goto L_0x0070
            java.lang.String r8 = r11.varName     // Catch:{ UtilEvalError -> 0x00a4 }
            java.lang.Object r9 = r2.O000000o()     // Catch:{ UtilEvalError -> 0x00a4 }
            bsh.Modifiers r10 = new bsh.Modifiers     // Catch:{ UtilEvalError -> 0x00a4 }
            r10.<init>()     // Catch:{ UtilEvalError -> 0x00a4 }
            r4.O000000o(r8, r5, r9, r10)     // Catch:{ UtilEvalError -> 0x00a4 }
            goto L_0x0079
        L_0x0070:
            java.lang.String r8 = r11.varName     // Catch:{ UtilEvalError -> 0x00a4 }
            java.lang.Object r9 = r2.O000000o()     // Catch:{ UtilEvalError -> 0x00a4 }
            r4.O000000o(r8, r9, r0)     // Catch:{ UtilEvalError -> 0x00a4 }
        L_0x0079:
            if (r3 == 0) goto L_0x0099
            java.lang.Object r8 = r3.O000000o(r12, r13)
            boolean r9 = r8 instanceof _m_j.li
            if (r9 == 0) goto L_0x0099
            r9 = r8
            _m_j.li r9 = (_m_j.li) r9
            int r9 = r9.f2166O000000o
            r10 = 12
            if (r9 == r10) goto L_0x0096
            r10 = 19
            if (r9 == r10) goto L_0x0099
            r10 = 46
            if (r9 == r10) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            r7 = r8
        L_0x0096:
            r8 = r7
            r7 = 1
            goto L_0x009b
        L_0x0099:
            r8 = r7
            r7 = 0
        L_0x009b:
            if (r7 != 0) goto L_0x009f
            r7 = r8
            goto L_0x0058
        L_0x009f:
            r7 = r8
        L_0x00a0:
            r12.O00000Oo(r1)
            return r7
        L_0x00a4:
            r13 = move-exception
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            java.lang.String r1 = "for loop iterator variable:"
            r0.<init>(r1)
            java.lang.String r1 = r11.varName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            bsh.EvalError r12 = r13.toEvalError(r0, r11, r12)
            throw r12
        L_0x00ba:
            bsh.EvalError r13 = new bsh.EvalError
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            java.lang.String r1 = "Can't iterate over type: "
            r0.<init>(r1)
            java.lang.Class r1 = r2.getClass()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0, r11, r12)
            throw r13
        L_0x00d2:
            bsh.EvalError r13 = new bsh.EvalError
            java.lang.String r0 = "The collection, array, map, iterator, or enumeration portion of a for statement cannot be null."
            r13.<init>(r0, r11, r12)
            goto L_0x00db
        L_0x00da:
            throw r13
        L_0x00db:
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHEnhancedForStatement.O000000o(_m_j.kv, bsh.Interpreter):java.lang.Object");
    }
}
