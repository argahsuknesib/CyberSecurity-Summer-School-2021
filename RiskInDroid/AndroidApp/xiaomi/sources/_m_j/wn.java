package _m_j;

import _m_j.aez;
import java.io.IOException;

public abstract class wn<T extends aez> {

    /* renamed from: O000000o  reason: collision with root package name */
    protected xu f2579O000000o;
    protected T O00000Oo = O000000o();

    /* access modifiers changed from: protected */
    public abstract T O000000o();

    /* access modifiers changed from: protected */
    public abstract wn O000000o(afd afd, byte[] bArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean O000000o(afd afd);

    /* access modifiers changed from: protected */
    public abstract boolean O00000Oo(afd afd);

    public wn(xu xuVar) {
        this.f2579O000000o = xuVar;
        xuVar.O000000o((xr) this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public final wn O00000o0(afd afd) throws IOException {
        return O000000o(afd, null);
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
    public final void O000000o(java.lang.String r2) {
        /*
            r1 = this;
            T r0 = r1.O00000Oo
            r0.O000000o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.wn.O000000o(java.lang.String):void");
    }
}
