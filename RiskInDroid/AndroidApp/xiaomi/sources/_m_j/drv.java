package _m_j;

import rx.Observable;
import rx.functions.Func1;

final class drv<T, R> implements drr<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    final Observable<R> f14883O000000o;
    final R O00000Oo;

    public final /* synthetic */ Object call(Object obj) {
        return ((Observable) obj).takeUntil(this.f14883O000000o.takeFirst(new Func1<T, Boolean>(this.O00000Oo) {
            /* class _m_j.drt.AnonymousClass1 */

            /* renamed from: O000000o */
            final /* synthetic */ Object f14881O000000o;

            {
                this.f14881O000000o = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                return Boolean.valueOf(obj.equals(this.f14881O000000o));
            }
        }));
    }

    public drv(Observable<R> observable, R r) {
        this.f14883O000000o = observable;
        this.O00000Oo = r;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: R
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
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            if (r3 != r4) goto L_0x0004
            r4 = 1
            return r4
        L_0x0004:
            r0 = 0
            if (r4 == 0) goto L_0x0028
            java.lang.Class r1 = r3.getClass()
            java.lang.Class r2 = r4.getClass()
            if (r1 == r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            _m_j.drv r4 = (_m_j.drv) r4
            rx.Observable<R> r1 = r3.f14883O000000o
            rx.Observable<R> r2 = r4.f14883O000000o
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x001f
            return r0
        L_0x001f:
            R r0 = r3.O00000Oo
            R r4 = r4.O00000Oo
            boolean r4 = r0.equals(r4)
            return r4
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.drv.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (this.f14883O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
    }

    public final String toString() {
        return "UntilEventObservableTransformer{lifecycle=" + this.f14883O000000o + ", event=" + ((Object) this.O00000Oo) + '}';
    }
}
