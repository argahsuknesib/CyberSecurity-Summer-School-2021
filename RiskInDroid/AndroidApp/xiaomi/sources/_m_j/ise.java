package _m_j;

import _m_j.ise.O00000Oo;
import io.realm.internal.OsObject;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ise<T extends O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<T> f1600O000000o = new CopyOnWriteArrayList();
    public boolean O00000Oo = false;

    public interface O000000o<T extends O00000Oo> {
        void O000000o(T t, Object obj);
    }

    public static abstract class O00000Oo<T, S> {

        /* renamed from: O000000o  reason: collision with root package name */
        final WeakReference<T> f1601O000000o;
        protected final S O00000Oo;
        boolean O00000o0 = false;

        public O00000Oo(T t, S s) {
            this.O00000Oo = s;
            this.f1601O000000o = new WeakReference<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof O00000Oo) {
                O00000Oo o00000Oo = (O00000Oo) obj;
                return this.O00000Oo.equals(o00000Oo.O00000Oo) && this.f1601O000000o.get() == o00000Oo.f1601O000000o.get();
            }
        }

        public int hashCode() {
            T t = this.f1601O000000o.get();
            int i = 0;
            int hashCode = ((t != null ? t.hashCode() : 0) + 527) * 31;
            S s = this.O00000Oo;
            if (s != null) {
                i = s.hashCode();
            }
            return hashCode + i;
        }
    }

    public final void O000000o(O000000o<OsObject.O00000Oo> o000000o) {
        for (T t : this.f1600O000000o) {
            if (!this.O00000Oo) {
                T t2 = t.f1601O000000o.get();
                if (t2 == null) {
                    this.f1600O000000o.remove(t);
                } else if (!t.O00000o0) {
                    o000000o.O000000o(t, t2);
                }
            } else {
                return;
            }
        }
    }

    public final boolean O000000o() {
        return this.f1600O000000o.isEmpty();
    }

    public final void O000000o(OsObject.O00000Oo o00000Oo) {
        if (!this.f1600O000000o.contains(o00000Oo)) {
            this.f1600O000000o.add(o00000Oo);
            o00000Oo.O00000o0 = false;
        }
        if (this.O00000Oo) {
            this.O00000Oo = false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: U
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
    public final <S, U> void O000000o(S r4, U r5) {
        /*
            r3 = this;
            java.util.List<T> r0 = r3.f1600O000000o
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r0.next()
            _m_j.ise$O00000Oo r1 = (_m_j.ise.O00000Oo) r1
            java.lang.ref.WeakReference<T> r2 = r1.f1601O000000o
            java.lang.Object r2 = r2.get()
            if (r4 != r2) goto L_0x0006
            S r2 = r1.O00000Oo
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0006
            r4 = 1
            r1.O00000o0 = r4
            java.util.List<T> r4 = r3.f1600O000000o
            r4.remove(r1)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.ise.O000000o(java.lang.Object, java.lang.Object):void");
    }

    public final void O000000o(Object obj) {
        for (T t : this.f1600O000000o) {
            T t2 = t.f1601O000000o.get();
            if (t2 == null || t2 == obj) {
                t.O00000o0 = true;
                this.f1600O000000o.remove(t);
            }
        }
    }
}
