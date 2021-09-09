package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ListUtils {
    private ListUtils() {
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public static <T> java.util.ArrayList<T> copyAndRemoveElementFromListIfPresent(java.util.List<T> r5, T r6) {
        /*
            int r0 = r5.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
        L_0x000a:
            if (r2 >= r0) goto L_0x001e
            java.lang.Object r3 = r5.get(r2)
            if (r6 == 0) goto L_0x0018
            boolean r4 = r6.equals(r3)
            if (r4 != 0) goto L_0x001b
        L_0x0018:
            r1.add(r3)
        L_0x001b:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x001e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ListUtils.copyAndRemoveElementFromListIfPresent(java.util.List, java.lang.Object):java.util.ArrayList");
    }

    public static <T> ArrayList<T> copyAndRemoveElementsFromListIfPresent(List<T> list, Collection<T> collection) {
        Preconditions.checkNotNull(collection);
        ArrayList<T> arrayList = new ArrayList<>(list.size());
        for (T next : list) {
            if (!collection.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
