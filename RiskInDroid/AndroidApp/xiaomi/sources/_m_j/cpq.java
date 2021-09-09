package _m_j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class cpq<T extends View, Output> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final cpo f14214O000000o = cpo.O000000o(cpq.class.getSimpleName());
    cqd<Void> O00000Oo = new cqd<>();
    T O00000o;
    O000000o O00000o0;
    public boolean O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo0;

    public interface O000000o {
        void O000000o();

        void O00000Oo();
    }

    /* access modifiers changed from: protected */
    public abstract T O000000o(Context context, ViewGroup viewGroup);

    /* access modifiers changed from: package-private */
    public abstract Class<Output> O000000o();

    /* access modifiers changed from: package-private */
    public abstract Output O00000Oo();

    public boolean O00000oo() {
        return true;
    }

    cpq(Context context, ViewGroup viewGroup, O000000o o000000o) {
        this.O00000o = O000000o(context, viewGroup);
        this.O00000o0 = null;
    }

    /* access modifiers changed from: package-private */
    public void O000000o(int i, int i2) {
        f14214O000000o.O000000o(1, "setDesiredSize:", "desiredW=", Integer.valueOf(i), "desiredH=", Integer.valueOf(i2));
        this.O0000OOo = i;
        this.O0000Oo0 = i2;
        O0000O0o();
    }

    /* access modifiers changed from: package-private */
    public final cpz O00000o0() {
        return new cpz(this.O00000oo, this.O0000O0o);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i, int i2) {
        f14214O000000o.O000000o(1, "onSurfaceAvailable:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        this.O00000oo = i;
        this.O0000O0o = i2;
        O0000O0o();
        this.O00000o0.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(int i, int i2) {
        f14214O000000o.O000000o(1, "onSurfaceSizeChanged:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        if (i != this.O00000oo || i2 != this.O0000O0o) {
            this.O00000oo = i;
            this.O0000O0o = i2;
            O0000O0o();
            this.O00000o0.O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        this.O00000oo = 0;
        this.O0000O0o = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000oO() {
        return this.O00000oo > 0 && this.O0000O0o > 0;
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private final void O0000O0o() {
        /*
            r2 = this;
            _m_j.cqd<java.lang.Void> r0 = r2.O00000Oo
            r0.O000000o()
            boolean r0 = r2.O00000oo()
            if (r0 != 0) goto L_0x0012
            _m_j.cqd<java.lang.Void> r0 = r2.O00000Oo
            r1 = 0
            r0.O000000o(r1)
            return
        L_0x0012:
            T r0 = r2.O00000o
            _m_j.cpq$1 r1 = new _m_j.cpq$1
            r1.<init>()
            r0.post(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.cpq.O0000O0o():void");
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    protected void O000000o(float r2, float r3) {
        /*
            r1 = this;
            T r0 = r1.O00000o
            r0.setScaleX(r2)
            T r2 = r1.O00000o
            r2.setScaleY(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.cpq.O000000o(float, float):void");
    }
}
