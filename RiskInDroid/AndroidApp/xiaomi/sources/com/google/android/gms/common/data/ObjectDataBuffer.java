package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class ObjectDataBuffer<T> extends AbstractDataBuffer<T> implements DataBufferObserver.Observable, ObjectExclusionFilterable<T> {
    private final ArrayList<Integer> zzob;
    private final HashSet<Integer> zzoe;
    private DataBufferObserverSet zzof;
    private final ArrayList<T> zzog;

    public ObjectDataBuffer() {
        super(null);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = new ArrayList<>();
        this.zzof = new DataBufferObserverSet();
        zzcl();
    }

    public ObjectDataBuffer(ArrayList<T> arrayList) {
        super(null);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = arrayList;
        this.zzof = new DataBufferObserverSet();
        zzcl();
    }

    public ObjectDataBuffer(T... tArr) {
        super(null);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = new ArrayList<>(Arrays.asList(tArr));
        this.zzof = new DataBufferObserverSet();
        zzcl();
    }

    private final void zzcl() {
        this.zzob.clear();
        int size = this.zzog.size();
        for (int i = 0; i < size; i++) {
            if (!this.zzoe.contains(Integer.valueOf(i))) {
                this.zzob.add(Integer.valueOf(i));
            }
        }
    }

    public final void add(T t) {
        int size = this.zzog.size();
        this.zzog.add(t);
        zzcl();
        if (this.zzof.hasObservers()) {
            Asserts.checkState(!this.zzoe.contains(Integer.valueOf(size)));
            int size2 = this.zzob.size();
            boolean z = false;
            Asserts.checkState(size2 > 0);
            int i = size2 - 1;
            if (this.zzob.get(i).intValue() == size) {
                z = true;
            }
            Asserts.checkState(z);
            this.zzof.onDataRangeInserted(i, 1);
        }
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.addObserver(dataBufferObserver);
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
    public final void filterOut(T r11) {
        /*
            r10 = this;
            java.util.ArrayList<T> r0 = r10.zzog
            int r0 = r0.size()
            r1 = 0
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
            r7 = -1
        L_0x000d:
            if (r3 >= r0) goto L_0x0056
            java.util.HashSet<java.lang.Integer> r8 = r10.zzoe
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            boolean r8 = r8.contains(r9)
            r9 = 1
            if (r8 != 0) goto L_0x0053
            int r6 = r6 + 1
            java.util.ArrayList<T> r8 = r10.zzog
            java.lang.Object r8 = r8.get(r3)
            boolean r8 = r11.equals(r8)
            if (r8 == 0) goto L_0x0045
            java.util.HashSet<java.lang.Integer> r4 = r10.zzoe
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r4.add(r8)
            com.google.android.gms.common.data.DataBufferObserverSet r4 = r10.zzof
            boolean r4 = r4.hasObservers()
            if (r4 == 0) goto L_0x0043
            if (r5 >= 0) goto L_0x0041
            r5 = r6
            r4 = 1
            r7 = 1
            goto L_0x0053
        L_0x0041:
            int r7 = r7 + 1
        L_0x0043:
            r4 = 1
            goto L_0x0053
        L_0x0045:
            if (r5 < 0) goto L_0x0053
            r10.zzcl()
            com.google.android.gms.common.data.DataBufferObserverSet r4 = r10.zzof
            r4.onDataRangeRemoved(r5, r7)
            int r6 = r6 - r7
            r4 = 0
            r5 = -1
            r7 = -1
        L_0x0053:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0056:
            if (r4 == 0) goto L_0x005b
            r10.zzcl()
        L_0x005b:
            if (r5 < 0) goto L_0x0062
            com.google.android.gms.common.data.DataBufferObserverSet r11 = r10.zzof
            r11.onDataRangeRemoved(r5, r7)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.ObjectDataBuffer.filterOut(java.lang.Object):void");
    }

    public final void filterOutRaw(int i) {
        int i2;
        boolean add = this.zzoe.add(Integer.valueOf(i));
        if (this.zzof.hasObservers() && add) {
            i2 = 0;
            int size = this.zzob.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.zzob.get(i2).intValue() == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        i2 = -1;
        zzcl();
        if (i2 >= 0) {
            this.zzof.onDataRangeRemoved(i2, 1);
        }
    }

    public final T get(int i) {
        return this.zzog.get(getRawPosition(i));
    }

    public final int getCount() {
        return this.zzog.size() - this.zzoe.size();
    }

    public final Bundle getMetadata() {
        return null;
    }

    public final int getPositionFromRawPosition(int i) {
        int i2 = -1;
        for (int i3 = 0; i3 <= i; i3++) {
            if (!this.zzoe.contains(Integer.valueOf(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public final T getRaw(int i) {
        return this.zzog.get(i);
    }

    public final int getRawCount() {
        return this.zzog.size();
    }

    public final int getRawPosition(int i) {
        if (i >= 0 && i < getCount()) {
            return this.zzob.get(i).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void insertRaw(int i, T t) {
        this.zzog.add(i, t);
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator<Integer> it = this.zzoe.iterator();
        int i2 = i;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() < i) {
                i2--;
            } else {
                hashSet.add(Integer.valueOf(next.intValue() + 1));
                it.remove();
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (this.zzof.hasObservers()) {
            this.zzof.onDataRangeInserted(i2, 1);
        }
    }

    public final boolean isRawPositionFiltered(int i) {
        return this.zzoe.contains(Integer.valueOf(i));
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
    public final void notifyChanged(T r5) {
        /*
            r4 = this;
            com.google.android.gms.common.data.DataBufferObserverSet r0 = r4.zzof
            boolean r0 = r0.hasObservers()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            r0 = 0
            java.util.ArrayList<java.lang.Integer> r1 = r4.zzob
            int r1 = r1.size()
        L_0x0010:
            if (r0 >= r1) goto L_0x0033
            java.util.ArrayList<T> r2 = r4.zzog
            java.util.ArrayList<java.lang.Integer> r3 = r4.zzob
            java.lang.Object r3 = r3.get(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object r2 = r2.get(r3)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.common.data.DataBufferObserverSet r2 = r4.zzof
            r3 = 1
            r2.onDataRangeChanged(r0, r3)
        L_0x0030:
            int r0 = r0 + 1
            goto L_0x0010
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.ObjectDataBuffer.notifyChanged(java.lang.Object):void");
    }

    public final void release() {
        this.zzof.clear();
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.removeObserver(dataBufferObserver);
    }

    public final void removeRaw(int i) {
        this.zzog.remove(i);
        boolean remove = this.zzoe.remove(Integer.valueOf(i));
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator<Integer> it = this.zzoe.iterator();
        int i2 = i;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() < i) {
                i2--;
            } else {
                it.remove();
                hashSet.add(Integer.valueOf(next.intValue() - 1));
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (!remove && this.zzof.hasObservers()) {
            this.zzof.onDataRangeRemoved(i2, 1);
        }
    }

    public final boolean setRaw(int i, T t) {
        this.zzog.set(i, t);
        boolean z = !this.zzoe.contains(Integer.valueOf(i));
        if (z && this.zzof.hasObservers()) {
            int i2 = 0;
            int size = this.zzob.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.zzob.get(i2).intValue() == i) {
                    this.zzof.onDataRangeChanged(i2, 1);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return z;
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
    public final void unfilter(T r11) {
        /*
            r10 = this;
            java.util.ArrayList<T> r0 = r10.zzog
            int r0 = r0.size()
            r1 = 0
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = 0
            r7 = -1
        L_0x000d:
            if (r3 >= r0) goto L_0x0062
            java.util.HashSet<java.lang.Integer> r8 = r10.zzoe
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            boolean r8 = r8.contains(r9)
            r9 = 1
            if (r8 != 0) goto L_0x002d
            int r6 = r6 + 1
            if (r5 < 0) goto L_0x005f
        L_0x0020:
            r10.zzcl()
            com.google.android.gms.common.data.DataBufferObserverSet r4 = r10.zzof
            r4.onDataRangeInserted(r5, r7)
            int r6 = r6 + r7
            r4 = 0
            r5 = -1
            r7 = -1
            goto L_0x005f
        L_0x002d:
            java.util.ArrayList<T> r8 = r10.zzog
            java.lang.Object r8 = r8.get(r3)
            boolean r8 = r11.equals(r8)
            if (r8 == 0) goto L_0x0054
            java.util.HashSet<java.lang.Integer> r4 = r10.zzoe
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r4.remove(r8)
            com.google.android.gms.common.data.DataBufferObserverSet r4 = r10.zzof
            boolean r4 = r4.hasObservers()
            if (r4 == 0) goto L_0x0052
            if (r5 >= 0) goto L_0x0050
            r5 = r6
            r4 = 1
            r7 = 1
            goto L_0x005f
        L_0x0050:
            int r7 = r7 + 1
        L_0x0052:
            r4 = 1
            goto L_0x005f
        L_0x0054:
            com.google.android.gms.common.data.DataBufferObserverSet r8 = r10.zzof
            boolean r8 = r8.hasObservers()
            if (r8 == 0) goto L_0x005f
            if (r5 < 0) goto L_0x005f
            goto L_0x0020
        L_0x005f:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            r10.zzcl()
        L_0x0067:
            if (r5 < 0) goto L_0x006e
            com.google.android.gms.common.data.DataBufferObserverSet r11 = r10.zzof
            r11.onDataRangeInserted(r5, r7)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.ObjectDataBuffer.unfilter(java.lang.Object):void");
    }

    public final void unfilterRaw(int i) {
        boolean remove = this.zzoe.remove(Integer.valueOf(i));
        zzcl();
        if (this.zzof.hasObservers() && remove) {
            int i2 = -1;
            int i3 = 0;
            int size = this.zzob.size();
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (this.zzob.get(i3).intValue() == i) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.zzof.onDataRangeInserted(i2, 1);
            }
        }
    }
}
