package com.tiqiaa.icontrol.util;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PooledMap<K, V> extends AbstractMap<K, V> {
    private Queue<PooledMap<K, V>.Entry> entries = new LinkedList();
    private int maxSize = 50;

    public PooledMap() {
    }

    public PooledMap(int i) {
        this.maxSize = i;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new HashSet(this.entries);
    }

    public class Entry implements Map.Entry<K, V> {
        public K key;
        public V value;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v) {
            this.value = v;
            return v;
        }
    }

    public synchronized V put(K k, V v) {
        if (containsKey(k)) {
            remove(k);
        }
        if (this.entries.size() >= this.maxSize) {
            this.entries.remove();
        }
        this.entries.add(new Entry(k, v));
        return v;
    }

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
    public synchronized V get(java.lang.Object r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Queue<com.tiqiaa.icontrol.util.PooledMap<K, V>$Entry> r0 = r3.entries     // Catch:{ all -> 0x002c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002c }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0010
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0010:
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x002c }
            com.tiqiaa.icontrol.util.PooledMap$Entry r1 = (com.tiqiaa.icontrol.util.PooledMap.Entry) r1     // Catch:{ all -> 0x002c }
            K r2 = r1.key     // Catch:{ all -> 0x002c }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0007
            java.util.Queue<com.tiqiaa.icontrol.util.PooledMap<K, V>$Entry> r4 = r3.entries     // Catch:{ all -> 0x002c }
            r4.remove(r1)     // Catch:{ all -> 0x002c }
            java.util.Queue<com.tiqiaa.icontrol.util.PooledMap<K, V>$Entry> r4 = r3.entries     // Catch:{ all -> 0x002c }
            r4.add(r1)     // Catch:{ all -> 0x002c }
            V r4 = r1.value     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return r4
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0030
        L_0x002f:
            throw r4
        L_0x0030:
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiqiaa.icontrol.util.PooledMap.get(java.lang.Object):java.lang.Object");
    }

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
    public synchronized V remove(java.lang.Object r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Queue<com.tiqiaa.icontrol.util.PooledMap<K, V>$Entry> r0 = r3.entries     // Catch:{ all -> 0x0027 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0027 }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0010
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0010:
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0027 }
            com.tiqiaa.icontrol.util.PooledMap$Entry r1 = (com.tiqiaa.icontrol.util.PooledMap.Entry) r1     // Catch:{ all -> 0x0027 }
            K r2 = r1.key     // Catch:{ all -> 0x0027 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0007
            java.util.Queue<com.tiqiaa.icontrol.util.PooledMap<K, V>$Entry> r4 = r3.entries     // Catch:{ all -> 0x0027 }
            r4.remove(r1)     // Catch:{ all -> 0x0027 }
            V r4 = r1.value     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)
            return r4
        L_0x0027:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x002b
        L_0x002a:
            throw r4
        L_0x002b:
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiqiaa.icontrol.util.PooledMap.remove(java.lang.Object):java.lang.Object");
    }

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
    public boolean containsKey(java.lang.Object r3) {
        /*
            r2 = this;
            java.util.Queue<com.tiqiaa.icontrol.util.PooledMap<K, V>$Entry> r0 = r2.entries
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x000e
            r3 = 0
            return r3
        L_0x000e:
            java.lang.Object r1 = r0.next()
            com.tiqiaa.icontrol.util.PooledMap$Entry r1 = (com.tiqiaa.icontrol.util.PooledMap.Entry) r1
            K r1 = r1.key
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0006
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiqiaa.icontrol.util.PooledMap.containsKey(java.lang.Object):boolean");
    }

    public Collection<V> values() {
        ArrayList arrayList = new ArrayList();
        for (PooledMap<K, V>.Entry entry : this.entries) {
            arrayList.add(entry.value);
        }
        return arrayList;
    }

    public Set<K> keySet() {
        HashSet hashSet = new HashSet();
        for (PooledMap<K, V>.Entry entry : this.entries) {
            hashSet.add(entry.key);
        }
        return hashSet;
    }
}
