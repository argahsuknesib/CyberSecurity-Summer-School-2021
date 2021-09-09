package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class o extends t {
    private String b;
    private byte[] c;
    private String d = "application/x-www-form-urlencoded";
    private ArrayList<Header> e = new ArrayList<>();
    private Map<String, String> f = new HashMap();
    private boolean g;

    public o(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(String str, String str2) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        this.f.put(str, str2);
    }

    public final void a(Header header) {
        this.e.add(header);
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void a(byte[] bArr) {
        this.c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final ArrayList<Header> d() {
        return this.e;
    }

    public final boolean e() {
        return this.g;
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: MethodInvokeVisitor
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:513)
        	at jadx.core.clsp.ClspGraph.getClsDetails(ClspGraph.java:76)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:100)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0013
            return r1
        L_0x0013:
            com.alipay.android.phone.mrpc.core.o r5 = (com.alipay.android.phone.mrpc.core.o) r5
            byte[] r2 = r4.c
            if (r2 != 0) goto L_0x001e
            byte[] r2 = r5.c
            if (r2 == 0) goto L_0x0027
            return r1
        L_0x001e:
            byte[] r3 = r5.c
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0027
            return r1
        L_0x0027:
            java.lang.String r2 = r4.b
            if (r2 != 0) goto L_0x0030
            java.lang.String r5 = r5.b
            if (r5 == 0) goto L_0x0039
            return r1
        L_0x0030:
            java.lang.String r5 = r5.b
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0039
            return r1
        L_0x0039:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.o.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Map<String, String> map = this.f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f.get("id").hashCode() + 31) * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.b, this.e);
    }
}
