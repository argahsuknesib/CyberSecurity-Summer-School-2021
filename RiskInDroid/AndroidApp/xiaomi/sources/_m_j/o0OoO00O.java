package _m_j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class o0OoO00O<K, V> implements Iterable<Map.Entry<K, V>> {
    public O00000o0<K, V> O00000Oo;
    public WeakHashMap<O0000OOo<K, V>, Boolean> O00000o = new WeakHashMap<>();
    public O00000o0<K, V> O00000o0;
    public int O00000oO = 0;

    interface O0000OOo<K, V> {
        void a_(O00000o0<K, V> o00000o0);
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
    protected _m_j.o0OoO00O.O00000o0<K, V> O000000o(K r3) {
        /*
            r2 = this;
            _m_j.o0OoO00O$O00000o0<K, V> r0 = r2.O00000Oo
        L_0x0002:
            if (r0 == 0) goto L_0x000f
            K r1 = r0.f2259O000000o
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x000f
            _m_j.o0OoO00O$O00000o0<K, V> r0 = r0.O00000o0
            goto L_0x0002
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.o0OoO00O.O000000o(java.lang.Object):_m_j.o0OoO00O$O00000o0");
    }

    public V O000000o(K k, V v) {
        O00000o0 O000000o2 = O000000o(k);
        if (O000000o2 != null) {
            return O000000o2.O00000Oo;
        }
        O00000Oo(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    public final O00000o0<K, V> O00000Oo(K k, V v) {
        O00000o0<K, V> o00000o0 = new O00000o0<>(k, v);
        this.O00000oO++;
        O00000o0<K, V> o00000o02 = this.O00000o0;
        if (o00000o02 == null) {
            this.O00000Oo = o00000o0;
            this.O00000o0 = this.O00000Oo;
            return o00000o0;
        }
        o00000o02.O00000o0 = o00000o0;
        o00000o0.O00000o = o00000o02;
        this.O00000o0 = o00000o0;
        return o00000o0;
    }

    public V O00000Oo(K k) {
        O00000o0 O000000o2 = O000000o(k);
        if (O000000o2 == null) {
            return null;
        }
        this.O00000oO--;
        if (!this.O00000o.isEmpty()) {
            for (O0000OOo<K, V> a_ : this.O00000o.keySet()) {
                a_.a_(O000000o2);
            }
        }
        if (O000000o2.O00000o != null) {
            O000000o2.O00000o.O00000o0 = O000000o2.O00000o0;
        } else {
            this.O00000Oo = O000000o2.O00000o0;
        }
        if (O000000o2.O00000o0 != null) {
            O000000o2.O00000o0.O00000o = O000000o2.O00000o;
        } else {
            this.O00000o0 = O000000o2.O00000o;
        }
        O000000o2.O00000o0 = null;
        O000000o2.O00000o = null;
        return O000000o2.O00000Oo;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        O000000o o000000o = new O000000o(this.O00000Oo, this.O00000o0);
        this.O00000o.put(o000000o, Boolean.FALSE);
        return o000000o;
    }

    public final o0OoO00O<K, V>.O00000o O000000o() {
        o0OoO00O<K, V>.O00000o o00000o = new O00000o();
        this.O00000o.put(o00000o, Boolean.FALSE);
        return o00000o;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0OoO00O)) {
            return false;
        }
        o0OoO00O o0ooo00o = (o0OoO00O) obj;
        if (this.O00000oO != o0ooo00o.O00000oO) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = o0ooo00o.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    static abstract class O0000O0o<K, V> implements O0000OOo<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000o0<K, V> f2260O000000o;
        O00000o0<K, V> O00000Oo;

        /* access modifiers changed from: package-private */
        public abstract O00000o0<K, V> O000000o(O00000o0<K, V> o00000o0);

        /* access modifiers changed from: package-private */
        public abstract O00000o0<K, V> O00000Oo(O00000o0<K, V> o00000o0);

        O0000O0o(O00000o0<K, V> o00000o0, O00000o0<K, V> o00000o02) {
            this.f2260O000000o = o00000o02;
            this.O00000Oo = o00000o0;
        }

        public boolean hasNext() {
            return this.O00000Oo != null;
        }

        public final void a_(O00000o0<K, V> o00000o0) {
            if (this.f2260O000000o == o00000o0 && o00000o0 == this.O00000Oo) {
                this.O00000Oo = null;
                this.f2260O000000o = null;
            }
            O00000o0<K, V> o00000o02 = this.f2260O000000o;
            if (o00000o02 == o00000o0) {
                this.f2260O000000o = O00000Oo(o00000o02);
            }
            if (this.O00000Oo == o00000o0) {
                this.O00000Oo = O000000o();
            }
        }

        private O00000o0<K, V> O000000o() {
            O00000o0<K, V> o00000o0 = this.O00000Oo;
            O00000o0<K, V> o00000o02 = this.f2260O000000o;
            if (o00000o0 == o00000o02 || o00000o02 == null) {
                return null;
            }
            return O000000o(o00000o0);
        }

        public /* synthetic */ Object next() {
            O00000o0<K, V> o00000o0 = this.O00000Oo;
            this.O00000Oo = O000000o();
            return o00000o0;
        }
    }

    static class O000000o<K, V> extends O0000O0o<K, V> {
        O000000o(O00000o0<K, V> o00000o0, O00000o0<K, V> o00000o02) {
            super(o00000o0, o00000o02);
        }

        /* access modifiers changed from: package-private */
        public final O00000o0<K, V> O000000o(O00000o0<K, V> o00000o0) {
            return o00000o0.O00000o0;
        }

        /* access modifiers changed from: package-private */
        public final O00000o0<K, V> O00000Oo(O00000o0<K, V> o00000o0) {
            return o00000o0.O00000o;
        }
    }

    public static class O00000Oo<K, V> extends O0000O0o<K, V> {
        public O00000Oo(O00000o0<K, V> o00000o0, O00000o0<K, V> o00000o02) {
            super(o00000o0, o00000o02);
        }

        /* access modifiers changed from: package-private */
        public final O00000o0<K, V> O000000o(O00000o0<K, V> o00000o0) {
            return o00000o0.O00000o;
        }

        /* access modifiers changed from: package-private */
        public final O00000o0<K, V> O00000Oo(O00000o0<K, V> o00000o0) {
            return o00000o0.O00000o0;
        }
    }

    public class O00000o implements O0000OOo<K, V>, Iterator<Map.Entry<K, V>> {
        private O00000o0<K, V> O00000Oo;
        private boolean O00000o0 = true;

        O00000o() {
        }

        public final void a_(O00000o0<K, V> o00000o0) {
            O00000o0<K, V> o00000o02 = this.O00000Oo;
            if (o00000o0 == o00000o02) {
                this.O00000Oo = o00000o02.O00000o;
                this.O00000o0 = this.O00000Oo == null;
            }
        }

        public final boolean hasNext() {
            if (this.O00000o0) {
                return o0OoO00O.this.O00000Oo != null;
            }
            O00000o0<K, V> o00000o0 = this.O00000Oo;
            return (o00000o0 == null || o00000o0.O00000o0 == null) ? false : true;
        }

        public final /* bridge */ /* synthetic */ Object next() {
            O00000o0<K, V> o00000o0;
            if (this.O00000o0) {
                this.O00000o0 = false;
                o00000o0 = o0OoO00O.this.O00000Oo;
            } else {
                O00000o0<K, V> o00000o02 = this.O00000Oo;
                o00000o0 = o00000o02 != null ? o00000o02.O00000o0 : null;
            }
            this.O00000Oo = o00000o0;
            return this.O00000Oo;
        }
    }

    public static class O00000o0<K, V> implements Map.Entry<K, V> {

        /* renamed from: O000000o  reason: collision with root package name */
        final K f2259O000000o;
        final V O00000Oo;
        public O00000o0<K, V> O00000o;
        O00000o0<K, V> O00000o0;

        O00000o0(K k, V v) {
            this.f2259O000000o = k;
            this.O00000Oo = v;
        }

        public final K getKey() {
            return this.f2259O000000o;
        }

        public final V getValue() {
            return this.O00000Oo;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return ((Object) this.f2259O000000o) + "=" + ((Object) this.O00000Oo);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof O00000o0)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            return this.f2259O000000o.equals(o00000o0.f2259O000000o) && this.O00000Oo.equals(o00000o0.O00000Oo);
        }

        public final int hashCode() {
            return this.f2259O000000o.hashCode() ^ this.O00000Oo.hashCode();
        }
    }
}
