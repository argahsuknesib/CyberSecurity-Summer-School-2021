package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzaay<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzbls;
    private final int zzbtx;
    /* access modifiers changed from: private */
    public List<zzabd> zzbty;
    /* access modifiers changed from: private */
    public Map<K, V> zzbtz;
    private volatile zzabf zzbua;
    private Map<K, V> zzbub;

    private zzaay(int i) {
        this.zzbtx = i;
        this.zzbty = Collections.emptyList();
        this.zzbtz = Collections.emptyMap();
        this.zzbub = Collections.emptyMap();
    }

    /* synthetic */ zzaay(int i, zzaaz zzaaz) {
        this(i);
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private final int zza(K r5) {
        /*
            r4 = this;
            java.util.List<com.google.android.gms.internal.measurement.zzabd> r0 = r4.zzbty
            int r0 = r0.size()
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0025
            java.util.List<com.google.android.gms.internal.measurement.zzabd> r1 = r4.zzbty
            java.lang.Object r1 = r1.get(r0)
            com.google.android.gms.internal.measurement.zzabd r1 = (com.google.android.gms.internal.measurement.zzabd) r1
            java.lang.Object r1 = r1.getKey()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r1 = r5.compareTo(r1)
            if (r1 <= 0) goto L_0x0022
            int r0 = r0 + 2
            int r5 = -r0
            return r5
        L_0x0022:
            if (r1 != 0) goto L_0x0025
            return r0
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r1 > r0) goto L_0x0049
            int r2 = r1 + r0
            int r2 = r2 / 2
            java.util.List<com.google.android.gms.internal.measurement.zzabd> r3 = r4.zzbty
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.measurement.zzabd r3 = (com.google.android.gms.internal.measurement.zzabd) r3
            java.lang.Object r3 = r3.getKey()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L_0x0043
            int r0 = r2 + -1
            goto L_0x0026
        L_0x0043:
            if (r3 <= 0) goto L_0x0048
            int r1 = r2 + 1
            goto L_0x0026
        L_0x0048:
            return r2
        L_0x0049:
            int r1 = r1 + 1
            int r5 = -r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaay.zza(java.lang.Comparable):int");
    }

    static <FieldDescriptorType extends zzzo<FieldDescriptorType>> zzaay<FieldDescriptorType, Object> zzag(int i) {
        return new zzaaz(i);
    }

    /* access modifiers changed from: private */
    public final V zzai(int i) {
        zzul();
        V value = this.zzbty.remove(i).getValue();
        if (!this.zzbtz.isEmpty()) {
            Iterator it = zzum().entrySet().iterator();
            this.zzbty.add(new zzabd(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzul() {
        if (this.zzbls) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzum() {
        zzul();
        if (this.zzbtz.isEmpty() && !(this.zzbtz instanceof TreeMap)) {
            this.zzbtz = new TreeMap();
            this.zzbub = ((TreeMap) this.zzbtz).descendingMap();
        }
        return (SortedMap) this.zzbtz;
    }

    public void clear() {
        zzul();
        if (!this.zzbty.isEmpty()) {
            this.zzbty.clear();
        }
        if (!this.zzbtz.isEmpty()) {
            this.zzbtz.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzbtz.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzbua == null) {
            this.zzbua = new zzabf(this, null);
        }
        return this.zzbua;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaay)) {
            return super.equals(obj);
        }
        zzaay zzaay = (zzaay) obj;
        int size = size();
        if (size != zzaay.size()) {
            return false;
        }
        int zzuj = zzuj();
        if (zzuj != zzaay.zzuj()) {
            return entrySet().equals(zzaay.entrySet());
        }
        for (int i = 0; i < zzuj; i++) {
            if (!zzah(i).equals(zzaay.zzah(i))) {
                return false;
            }
        }
        if (zzuj != size) {
            return this.zzbtz.equals(zzaay.zzbtz);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzbty.get(zza).getValue() : this.zzbtz.get(comparable);
    }

    public int hashCode() {
        int zzuj = zzuj();
        int i = 0;
        for (int i2 = 0; i2 < zzuj; i2++) {
            i += this.zzbty.get(i2).hashCode();
        }
        return this.zzbtz.size() > 0 ? i + this.zzbtz.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzbls;
    }

    public V remove(Object obj) {
        zzul();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzai(zza);
        }
        if (this.zzbtz.isEmpty()) {
            return null;
        }
        return this.zzbtz.remove(comparable);
    }

    public int size() {
        return this.zzbty.size() + this.zzbtz.size();
    }

    /* renamed from: zza */
    public final V put(Comparable comparable, Object obj) {
        zzul();
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzbty.get(zza).setValue(obj);
        }
        zzul();
        if (this.zzbty.isEmpty() && !(this.zzbty instanceof ArrayList)) {
            this.zzbty = new ArrayList(this.zzbtx);
        }
        int i = -(zza + 1);
        if (i >= this.zzbtx) {
            return zzum().put(comparable, obj);
        }
        int size = this.zzbty.size();
        int i2 = this.zzbtx;
        if (size == i2) {
            zzabd remove = this.zzbty.remove(i2 - 1);
            zzum().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzbty.add(i, new zzabd(this, comparable, obj));
        return null;
    }

    public final Map.Entry<K, V> zzah(int i) {
        return this.zzbty.get(i);
    }

    public void zzrg() {
        if (!this.zzbls) {
            this.zzbtz = this.zzbtz.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzbtz);
            this.zzbub = this.zzbub.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzbub);
            this.zzbls = true;
        }
    }

    public final int zzuj() {
        return this.zzbty.size();
    }

    public final Iterable<Map.Entry<K, V>> zzuk() {
        return this.zzbtz.isEmpty() ? zzaba.zzun() : this.zzbtz.entrySet();
    }
}
