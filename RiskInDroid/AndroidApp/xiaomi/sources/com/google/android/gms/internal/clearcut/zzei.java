package com.google.android.gms.internal.clearcut;

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

class zzei<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzgu;
    private final int zzol;
    /* access modifiers changed from: private */
    public List<zzep> zzom;
    /* access modifiers changed from: private */
    public Map<K, V> zzon;
    private volatile zzer zzoo;
    /* access modifiers changed from: private */
    public Map<K, V> zzop;
    private volatile zzel zzoq;

    private zzei(int i) {
        this.zzol = i;
        this.zzom = Collections.emptyList();
        this.zzon = Collections.emptyMap();
        this.zzop = Collections.emptyMap();
    }

    /* synthetic */ zzei(int i, zzej zzej) {
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
            java.util.List<com.google.android.gms.internal.clearcut.zzep> r0 = r4.zzom
            int r0 = r0.size()
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0025
            java.util.List<com.google.android.gms.internal.clearcut.zzep> r1 = r4.zzom
            java.lang.Object r1 = r1.get(r0)
            com.google.android.gms.internal.clearcut.zzep r1 = (com.google.android.gms.internal.clearcut.zzep) r1
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
            java.util.List<com.google.android.gms.internal.clearcut.zzep> r3 = r4.zzom
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.clearcut.zzep r3 = (com.google.android.gms.internal.clearcut.zzep) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzei.zza(java.lang.Comparable):int");
    }

    static <FieldDescriptorType extends zzca<FieldDescriptorType>> zzei<FieldDescriptorType, Object> zzaj(int i) {
        return new zzej(i);
    }

    /* access modifiers changed from: private */
    public final V zzal(int i) {
        zzdu();
        V value = this.zzom.remove(i).getValue();
        if (!this.zzon.isEmpty()) {
            Iterator it = zzdv().entrySet().iterator();
            this.zzom.add(new zzep(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzdu() {
        if (this.zzgu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzdv() {
        zzdu();
        if (this.zzon.isEmpty() && !(this.zzon instanceof TreeMap)) {
            this.zzon = new TreeMap();
            this.zzop = ((TreeMap) this.zzon).descendingMap();
        }
        return (SortedMap) this.zzon;
    }

    public void clear() {
        zzdu();
        if (!this.zzom.isEmpty()) {
            this.zzom.clear();
        }
        if (!this.zzon.isEmpty()) {
            this.zzon.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzon.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzoo == null) {
            this.zzoo = new zzer(this, null);
        }
        return this.zzoo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzei)) {
            return super.equals(obj);
        }
        zzei zzei = (zzei) obj;
        int size = size();
        if (size != zzei.size()) {
            return false;
        }
        int zzdr = zzdr();
        if (zzdr != zzei.zzdr()) {
            return entrySet().equals(zzei.entrySet());
        }
        for (int i = 0; i < zzdr; i++) {
            if (!zzak(i).equals(zzei.zzak(i))) {
                return false;
            }
        }
        if (zzdr != size) {
            return this.zzon.equals(zzei.zzon);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzom.get(zza).getValue() : this.zzon.get(comparable);
    }

    public int hashCode() {
        int zzdr = zzdr();
        int i = 0;
        for (int i2 = 0; i2 < zzdr; i2++) {
            i += this.zzom.get(i2).hashCode();
        }
        return this.zzon.size() > 0 ? i + this.zzon.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    public V remove(Object obj) {
        zzdu();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzal(zza);
        }
        if (this.zzon.isEmpty()) {
            return null;
        }
        return this.zzon.remove(comparable);
    }

    public int size() {
        return this.zzom.size() + this.zzon.size();
    }

    /* renamed from: zza */
    public final V put(Comparable comparable, Object obj) {
        zzdu();
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzom.get(zza).setValue(obj);
        }
        zzdu();
        if (this.zzom.isEmpty() && !(this.zzom instanceof ArrayList)) {
            this.zzom = new ArrayList(this.zzol);
        }
        int i = -(zza + 1);
        if (i >= this.zzol) {
            return zzdv().put(comparable, obj);
        }
        int size = this.zzom.size();
        int i2 = this.zzol;
        if (size == i2) {
            zzep remove = this.zzom.remove(i2 - 1);
            zzdv().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzom.add(i, new zzep(this, comparable, obj));
        return null;
    }

    public final Map.Entry<K, V> zzak(int i) {
        return this.zzom.get(i);
    }

    public final int zzdr() {
        return this.zzom.size();
    }

    public final Iterable<Map.Entry<K, V>> zzds() {
        return this.zzon.isEmpty() ? zzem.zzdx() : this.zzon.entrySet();
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzdt() {
        if (this.zzoq == null) {
            this.zzoq = new zzel(this, null);
        }
        return this.zzoq;
    }

    public void zzv() {
        if (!this.zzgu) {
            this.zzon = this.zzon.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzon);
            this.zzop = this.zzop.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzop);
            this.zzgu = true;
        }
    }
}
