package com.xiaomi.mico.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ContainerUtil {
    private static final ArrayList<Object> NULL_LIST = new ArrayList<Object>() {
        /* class com.xiaomi.mico.common.util.ContainerUtil.AnonymousClass1 */

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException("ContainerUtil : Unsupported add operation on const empty list");
        }

        public final boolean addAll(Collection<?> collection) {
            throw new UnsupportedOperationException("ContainerUtil : Unsupported addAll operation on const empty list");
        }

        public final boolean addAll(int i, Collection<?> collection) {
            throw new UnsupportedOperationException("ContainerUtil : Unsupported addAll operation on const empty list");
        }

        public final void add(int i, Object obj) {
            throw new UnsupportedOperationException("ContainerUtil : Unsupported add by index operation on const empty list");
        }
    };

    public static <T> ArrayList<T> getEmptyArrayList() {
        return NULL_LIST;
    }

    public static <T> List<T> getEmptyList() {
        return NULL_LIST;
    }

    public static <T> boolean hasData(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static <T> boolean isEmpty(Collection collection) {
        return !hasData(collection);
    }

    public static <T> int getSize(Collection collection) {
        if (hasData(collection)) {
            return collection.size();
        }
        return 0;
    }

    public static <T> int getSize(Object[] objArr) {
        if (hasData(objArr)) {
            return objArr.length;
        }
        return 0;
    }

    public static <K, V> boolean hasData(Map map) {
        return map != null && !map.isEmpty();
    }

    public static <K, V> boolean isEmpty(Map map) {
        return !hasData(map);
    }

    public static <T> Collection<T> removeEmpties(Collection<T> collection) {
        if (isEmpty(collection)) {
            return collection;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean hasData(String str) {
        return !isEmpty(str);
    }

    public static <T> boolean isEmpty(Object[] objArr) {
        return !hasData(objArr);
    }

    public static boolean isEmpty(boolean[] zArr) {
        return !hasData(zArr);
    }

    public static <T> boolean hasData(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? false : true;
    }

    public static boolean hasData(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? false : true;
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
    public static <T> boolean equals(java.util.List<T> r5, java.util.List<T> r6) {
        /*
            r0 = 1
            if (r5 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = hasData(r5)
            r2 = 0
            if (r1 == 0) goto L_0x0011
            boolean r1 = hasData(r6)
            if (r1 == 0) goto L_0x004f
        L_0x0011:
            boolean r1 = hasData(r5)
            if (r1 != 0) goto L_0x001e
            boolean r1 = hasData(r6)
            if (r1 == 0) goto L_0x001e
            goto L_0x004f
        L_0x001e:
            boolean r1 = hasData(r5)
            if (r1 == 0) goto L_0x004e
            boolean r1 = hasData(r6)
            if (r1 == 0) goto L_0x004e
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L_0x0035
            goto L_0x004f
        L_0x0035:
            r1 = 0
        L_0x0036:
            int r3 = r5.size()
            if (r1 >= r3) goto L_0x004e
            java.lang.Object r3 = r5.get(r1)
            java.lang.Object r4 = r6.get(r1)
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x004b
            goto L_0x004f
        L_0x004b:
            int r1 = r1 + 1
            goto L_0x0036
        L_0x004e:
            r2 = 1
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mico.common.util.ContainerUtil.equals(java.util.List, java.util.List):boolean");
    }
}
