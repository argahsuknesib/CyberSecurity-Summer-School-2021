package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class ggp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f17747O000000o = false;

    private static List<String> O00000Oo(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(list2);
        return arrayList;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:57:0x00bb */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.LinkedList] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
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
    public static java.util.List<java.lang.String> O000000o(java.util.List<java.lang.String> r12, java.util.List<java.lang.String> r13) {
        /*
            java.lang.String r0 = "MergedList"
            boolean r1 = r12.isEmpty()     // Catch:{ Exception -> 0x010b }
            if (r1 == 0) goto L_0x000b
            r3 = r13
            goto L_0x00bb
        L_0x000b:
            boolean r1 = r13.isEmpty()     // Catch:{ Exception -> 0x010b }
            if (r1 == 0) goto L_0x0014
            r3 = r12
            goto L_0x00bb
        L_0x0014:
            java.util.List r1 = O00000Oo(r13, r12)     // Catch:{ Exception -> 0x010b }
            java.util.List r2 = O00000Oo(r13, r1)     // Catch:{ Exception -> 0x010b }
            r3 = 0
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x010b }
            java.lang.Object[] r4 = r12.toArray(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ Exception -> 0x010b }
            int r5 = r2.size()     // Catch:{ Exception -> 0x010b }
            int[] r5 = new int[r5]     // Catch:{ Exception -> 0x010b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x010b }
            r6 = 0
        L_0x0030:
            boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x010b }
            if (r7 == 0) goto L_0x0053
            java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x010b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x010b }
            r8 = r6
            r6 = 0
        L_0x003e:
            int r9 = r4.length     // Catch:{ Exception -> 0x010b }
            if (r6 >= r9) goto L_0x0051
            r9 = r4[r6]     // Catch:{ Exception -> 0x010b }
            boolean r9 = r7.equals(r9)     // Catch:{ Exception -> 0x010b }
            if (r9 == 0) goto L_0x004e
            int r9 = r8 + 1
            r5[r8] = r6     // Catch:{ Exception -> 0x010b }
            r8 = r9
        L_0x004e:
            int r6 = r6 + 1
            goto L_0x003e
        L_0x0051:
            r6 = r8
            goto L_0x0030
        L_0x0053:
            int r2 = r5.length     // Catch:{ Exception -> 0x010b }
            int r2 = r2 / 2
        L_0x0056:
            if (r2 <= 0) goto L_0x0086
            r6 = 0
        L_0x0059:
            int r7 = r6 + r2
            int r8 = r5.length     // Catch:{ Exception -> 0x010b }
            if (r7 >= r8) goto L_0x0083
            r7 = 0
        L_0x005f:
            int r8 = r7 + r2
            int r9 = r5.length     // Catch:{ Exception -> 0x010b }
            if (r8 >= r9) goto L_0x0080
            r9 = r5[r7]     // Catch:{ Exception -> 0x010b }
            r10 = r5[r8]     // Catch:{ Exception -> 0x010b }
            if (r9 <= r10) goto L_0x007e
            r9 = r5[r8]     // Catch:{ Exception -> 0x010b }
            r10 = r5[r7]     // Catch:{ Exception -> 0x010b }
            r5[r8] = r10     // Catch:{ Exception -> 0x010b }
            r5[r7] = r9     // Catch:{ Exception -> 0x010b }
            r7 = r5[r7]     // Catch:{ Exception -> 0x010b }
            r9 = r5[r8]     // Catch:{ Exception -> 0x010b }
            r10 = r4[r7]     // Catch:{ Exception -> 0x010b }
            r11 = r4[r9]     // Catch:{ Exception -> 0x010b }
            r4[r7] = r11     // Catch:{ Exception -> 0x010b }
            r4[r9] = r10     // Catch:{ Exception -> 0x010b }
        L_0x007e:
            r7 = r8
            goto L_0x005f
        L_0x0080:
            int r6 = r6 + 1
            goto L_0x0059
        L_0x0083:
            int r2 = r2 / 2
            goto L_0x0056
        L_0x0086:
            java.util.List r2 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x010b }
            java.util.LinkedList r3 = new java.util.LinkedList     // Catch:{ Exception -> 0x010b }
            r3.<init>(r2)     // Catch:{ Exception -> 0x010b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x010b }
        L_0x0093:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x010b }
            if (r2 == 0) goto L_0x00bb
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x010b }
            int r4 = r13.indexOf(r2)     // Catch:{ Exception -> 0x010b }
            if (r4 != 0) goto L_0x00a9
            r3.addFirst(r2)     // Catch:{ Exception -> 0x010b }
            goto L_0x0093
        L_0x00a9:
            int r4 = r4 + -1
            java.lang.Object r4 = r13.get(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x010b }
            int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x010b }
            int r4 = r4 + 1
            r3.add(r4, r2)     // Catch:{ Exception -> 0x010b }
            goto L_0x0093
        L_0x00bb:
            boolean r1 = _m_j.ggp.f17747O000000o     // Catch:{ Exception -> 0x010b }
            if (r1 == 0) goto L_0x010a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = "oldOrder: "
            r1.<init>(r2)     // Catch:{ Exception -> 0x010b }
            java.lang.Object[] r12 = r12.toArray()     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = java.util.Arrays.toString(r12)     // Catch:{ Exception -> 0x010b }
            r1.append(r12)     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r1.toString()     // Catch:{ Exception -> 0x010b }
            _m_j.gsy.O00000Oo(r0, r12)     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = "newOrder: "
            r12.<init>(r1)     // Catch:{ Exception -> 0x010b }
            java.lang.Object[] r1 = r13.toArray()     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = java.util.Arrays.deepToString(r1)     // Catch:{ Exception -> 0x010b }
            r12.append(r1)     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x010b }
            _m_j.gsy.O00000Oo(r0, r12)     // Catch:{ Exception -> 0x010b }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = "results: "
            r12.<init>(r1)     // Catch:{ Exception -> 0x010b }
            java.lang.Object[] r1 = r3.toArray()     // Catch:{ Exception -> 0x010b }
            java.lang.String r1 = java.util.Arrays.deepToString(r1)     // Catch:{ Exception -> 0x010b }
            r12.append(r1)     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x010b }
            _m_j.gsy.O00000Oo(r0, r12)     // Catch:{ Exception -> 0x010b }
        L_0x010a:
            return r3
        L_0x010b:
            r12 = move-exception
            r1 = 6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "compareAndSortMuted: "
            r2.<init>(r3)
            java.lang.String r12 = android.util.Log.getStackTraceString(r12)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            _m_j.gsy.O000000o(r1, r0, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.ggp.O000000o(java.util.List, java.util.List):java.util.List");
    }
}
