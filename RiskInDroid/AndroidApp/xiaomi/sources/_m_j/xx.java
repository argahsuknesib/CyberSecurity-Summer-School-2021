package _m_j;

import _m_j.xr;
import com.google.android.gms.common.internal.GmsLogger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class xx<T extends xr> {
    static final /* synthetic */ boolean O00000Oo = (!xx.class.desiredAssertionStatus());

    /* renamed from: O000000o  reason: collision with root package name */
    protected final T f2602O000000o;

    public xx(T t) {
        this.f2602O000000o = t;
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
    public java.lang.String O000000o(int r4) {
        /*
            r3 = this;
            T r0 = r3.f2602O000000o
            java.lang.Object r0 = r0.O0000o0o(r4)
            if (r0 != 0) goto L_0x000a
            r4 = 0
            return r4
        L_0x000a:
            java.lang.Class r1 = r0.getClass()
            boolean r1 = r1.isArray()
            if (r1 == 0) goto L_0x002d
            int r1 = java.lang.reflect.Array.getLength(r0)
            r2 = 16
            if (r1 <= r2) goto L_0x002d
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r0] = r1
            java.lang.String r0 = "[%d values]"
            java.lang.String r4 = java.lang.String.format(r0, r4)
            return r4
        L_0x002d:
            boolean r1 = r0 instanceof java.util.Date
            if (r1 == 0) goto L_0x0047
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r1 = "EEE MMM dd HH:mm:ss Z yyyy"
            r4.<init>(r1)
            java.util.Date r0 = (java.util.Date) r0
            java.lang.String r4 = r4.format(r0)
            java.lang.String r0 = "([0-9]{2} [^ ]+)$"
            java.lang.String r1 = ":$1"
            java.lang.String r4 = r4.replaceAll(r0, r1)
            return r4
        L_0x0047:
            T r0 = r3.f2602O000000o
            java.lang.String r4 = r0.O0000o0(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(int):java.lang.String");
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
    protected final java.lang.String O000000o(int r5, int r6) {
        /*
            r4 = this;
            T r0 = r4.f2602O000000o
            int[] r5 = r0.O00000oo(r5)
            r0 = 0
            if (r5 != 0) goto L_0x000a
            return r0
        L_0x000a:
            if (r5 != 0) goto L_0x000d
            return r0
        L_0x000d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
        L_0x0013:
            r2 = 4
            if (r1 >= r2) goto L_0x0034
            int r2 = r5.length
            if (r1 >= r2) goto L_0x0034
            if (r1 != r6) goto L_0x0020
            r2 = 46
            r0.append(r2)
        L_0x0020:
            r2 = r5[r1]
            char r2 = (char) r2
            r3 = 48
            if (r2 >= r3) goto L_0x002a
            int r2 = r2 + 48
            char r2 = (char) r2
        L_0x002a:
            if (r1 != 0) goto L_0x002e
            if (r2 == r3) goto L_0x0031
        L_0x002e:
            r0.append(r2)
        L_0x0031:
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0034:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(int, int):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final String O000000o(int i, String... strArr) {
        return O000000o(i, 0, strArr);
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
    protected final java.lang.String O000000o(int r5, int r6, java.lang.String... r7) {
        /*
            r4 = this;
            T r0 = r4.f2602O000000o
            java.lang.Long r5 = r0.O0000Oo(r5)
            if (r5 != 0) goto L_0x000a
            r5 = 0
            return r5
        L_0x000a:
            long r0 = r5.longValue()
            long r2 = (long) r6
            long r0 = r0 - r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 < 0) goto L_0x0022
            int r6 = r7.length
            long r2 = (long) r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0022
            int r6 = (int) r0
            r6 = r7[r6]
            if (r6 == 0) goto L_0x0022
            return r6
        L_0x0022:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Unknown ("
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = ")"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(int, int, java.lang.String[]):java.lang.String");
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
    protected final java.lang.String O00000Oo(int r4) {
        /*
            r3 = this;
            T r0 = r3.f2602O000000o
            byte[] r4 = r0.O0000O0o(r4)
            if (r4 != 0) goto L_0x000a
            r4 = 0
            return r4
        L_0x000a:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            int r2 = r4.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            int r4 = r4.length
            r1 = 1
            if (r4 != r1) goto L_0x001c
            java.lang.String r4 = ""
            goto L_0x001e
        L_0x001c:
            java.lang.String r4 = "s"
        L_0x001e:
            r0[r1] = r4
            java.lang.String r4 = "(%d byte%s)"
            java.lang.String r4 = java.lang.String.format(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000Oo(int):java.lang.String");
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
    protected final java.lang.String O00000o0(int r2) {
        /*
            r1 = this;
            T r0 = r1.f2602O000000o
            com.drew.lang.Rational r2 = r0.O0000Ooo(r2)
            if (r2 != 0) goto L_0x000a
            r2 = 0
            return r2
        L_0x000a:
            r0 = 1
            java.lang.String r2 = r2.O000000o(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000o0(int):java.lang.String");
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
    protected final java.lang.String O000000o() {
        /*
            r6 = this;
            T r0 = r6.f2602O000000o
            r1 = 516(0x204, float:7.23E-43)
            com.drew.lang.Rational r0 = r0.O0000Ooo(r1)
            if (r0 != 0) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "%.3"
            r1.<init>(r2)
            java.lang.String r2 = "f"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            double r4 = r0.doubleValue()
            java.lang.Double r0 = java.lang.Double.valueOf(r4)
            r2[r3] = r0
            java.lang.String r0 = java.lang.String.format(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o():java.lang.String");
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
    protected final java.lang.String O000000o(int r3, java.lang.String r4) {
        /*
            r2 = this;
            T r0 = r2.f2602O000000o
            java.lang.Integer r3 = r0.O00000o0(r3)
            if (r3 != 0) goto L_0x000a
            r3 = 0
            return r3
        L_0x000a:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r3
            java.lang.String r3 = java.lang.String.format(r4, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(int, java.lang.String):java.lang.String");
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
    protected final java.lang.String O000000o(java.lang.String r4) {
        /*
            r3 = this;
            T r0 = r3.f2602O000000o
            r1 = 146(0x92, float:2.05E-43)
            java.lang.String r0 = r0.O0000o0(r1)
            if (r0 != 0) goto L_0x000c
            r4 = 0
            return r4
        L_0x000c:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r0
            java.lang.String r4 = java.lang.String.format(r4, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(java.lang.String):java.lang.String");
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
    protected final java.lang.String O00000Oo() {
        /*
            r4 = this;
            T r0 = r4.f2602O000000o
            r1 = 182(0xb6, float:2.55E-43)
            java.lang.Long r0 = r0.O0000Oo(r1)
            if (r0 != 0) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            java.util.Date r1 = new java.util.Date
            long r2 = r0.longValue()
            r1.<init>(r2)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000Oo():java.lang.String");
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
    protected final java.lang.String O000000o(int r9, java.lang.Object... r10) {
        /*
            r8 = this;
            T r0 = r8.f2602O000000o
            java.lang.Integer r9 = r0.O00000o0(r9)
            if (r9 != 0) goto L_0x000a
            r9 = 0
            return r9
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r9
            r9 = 0
        L_0x0012:
            int r3 = r10.length
            if (r3 <= r9) goto L_0x0058
            r3 = r10[r9]
            r4 = 1
            if (r3 == 0) goto L_0x004c
            int r5 = r2.intValue()
            r5 = r5 & r4
            if (r5 != r4) goto L_0x0023
            r5 = 1
            goto L_0x0024
        L_0x0023:
            r5 = 0
        L_0x0024:
            boolean r6 = r3 instanceof java.lang.String[]
            if (r6 == 0) goto L_0x0041
            java.lang.String[] r3 = (java.lang.String[]) r3
            java.lang.String[] r3 = (java.lang.String[]) r3
            boolean r6 = _m_j.xx.O00000Oo
            if (r6 != 0) goto L_0x003b
            int r6 = r3.length
            r7 = 2
            if (r6 != r7) goto L_0x0035
            goto L_0x003b
        L_0x0035:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x003b:
            r3 = r3[r5]
            r0.add(r3)
            goto L_0x004c
        L_0x0041:
            if (r5 == 0) goto L_0x004c
            boolean r5 = r3 instanceof java.lang.String
            if (r5 == 0) goto L_0x004c
            java.lang.String r3 = (java.lang.String) r3
            r0.add(r3)
        L_0x004c:
            int r2 = r2.intValue()
            int r2 = r2 >> r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r9 = r9 + 1
            goto L_0x0012
        L_0x0058:
            java.lang.String r9 = ", "
            java.lang.String r9 = _m_j.xp.O000000o(r0, r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(int, java.lang.Object[]):java.lang.String");
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
    protected final java.lang.String O00000o0() {
        /*
            r6 = this;
            T r0 = r6.f2602O000000o
            r1 = 37
            byte[] r0 = r0.O0000O0o(r1)
            if (r0 != 0) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000f:
            int r4 = r0.length
            if (r3 >= r4) goto L_0x0021
            byte r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            if (r4 == 0) goto L_0x0020
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 <= r5) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0020:
            r1 = r3
        L_0x0021:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r0, r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000o0():java.lang.String");
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
    protected final java.lang.String O000000o(int r3, java.nio.charset.Charset r4) {
        /*
            r2 = this;
            T r0 = r2.f2602O000000o
            byte[] r3 = r0.O0000O0o(r3)
            r0 = 0
            if (r3 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0018 }
            java.lang.String r4 = r4.name()     // Catch:{ UnsupportedEncodingException -> 0x0018 }
            r1.<init>(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x0018 }
            java.lang.String r3 = r1.trim()     // Catch:{ UnsupportedEncodingException -> 0x0018 }
            return r3
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O000000o(int, java.nio.charset.Charset):java.lang.String");
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
    protected final java.lang.String O00000o() {
        /*
            r3 = this;
            T r0 = r3.f2602O000000o
            r1 = 515(0x203, float:7.22E-43)
            com.drew.lang.Rational r0 = r0.O0000Ooo(r1)
            if (r0 == 0) goto L_0x0010
            r1 = 1
            java.lang.String r0 = r0.O000000o(r1)
            return r0
        L_0x0010:
            T r0 = r3.f2602O000000o
            java.lang.Double r0 = r0.O0000OOo(r1)
            if (r0 == 0) goto L_0x0024
            java.text.DecimalFormat r1 = new java.text.DecimalFormat
            java.lang.String r2 = "0.###"
            r1.<init>(r2)
            java.lang.String r0 = r1.format(r0)
            return r0
        L_0x0024:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000o():java.lang.String");
    }

    protected static String O000000o(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return "f/" + decimalFormat.format(d);
    }

    protected static String O00000Oo(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat.format(d) + " mm";
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
    protected final java.lang.String O00000o(int r8) {
        /*
            r7 = this;
            T r0 = r7.f2602O000000o
            com.drew.lang.Rational[] r8 = r0.O0000o00(r8)
            if (r8 == 0) goto L_0x00b2
            int r0 = r8.length
            r1 = 4
            if (r0 != r1) goto L_0x00b2
            r0 = 0
            r1 = r8[r0]
            boolean r1 = r1.O00000o0()
            r2 = 2
            if (r1 == 0) goto L_0x0020
            r1 = r8[r2]
            boolean r1 = r1.O00000o0()
            if (r1 == 0) goto L_0x0020
            goto L_0x00b2
        L_0x0020:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = r8[r0]
            r4 = 1
            r5 = r8[r4]
            boolean r3 = r3.O000000o(r5)
            java.lang.String r5 = "mm"
            r6 = 45
            if (r3 == 0) goto L_0x0041
            r0 = r8[r0]
            java.lang.String r0 = r0.O000000o(r4)
            r1.append(r0)
            r1.append(r5)
            goto L_0x0059
        L_0x0041:
            r0 = r8[r0]
            java.lang.String r0 = r0.O000000o(r4)
            r1.append(r0)
            r1.append(r6)
            r0 = r8[r4]
            java.lang.String r0 = r0.O000000o(r4)
            r1.append(r0)
            r1.append(r5)
        L_0x0059:
            r0 = r8[r2]
            boolean r0 = r0.O00000o0()
            if (r0 != 0) goto L_0x00ad
            r0 = 32
            r1.append(r0)
            java.text.DecimalFormat r0 = new java.text.DecimalFormat
            java.lang.String r3 = "0.0"
            r0.<init>(r3)
            java.math.RoundingMode r3 = java.math.RoundingMode.HALF_UP
            r0.setRoundingMode(r3)
            r3 = r8[r2]
            r4 = 3
            r5 = r8[r4]
            boolean r3 = r3.O000000o(r5)
            if (r3 == 0) goto L_0x008b
            r8 = r8[r2]
            double r2 = r8.doubleValue()
            java.lang.String r8 = O000000o(r2)
            r1.append(r8)
            goto L_0x00ad
        L_0x008b:
            java.lang.String r3 = "f/"
            r1.append(r3)
            r2 = r8[r2]
            double r2 = r2.doubleValue()
            java.lang.String r2 = r0.format(r2)
            r1.append(r2)
            r1.append(r6)
            r8 = r8[r4]
            double r2 = r8.doubleValue()
            java.lang.String r8 = r0.format(r2)
            r1.append(r8)
        L_0x00ad:
            java.lang.String r8 = r1.toString()
            return r8
        L_0x00b2:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000o(int):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final String O00000oO() {
        return O000000o(274, 1, "Top, left side (Horizontal / normal)", "Top, right side (Mirror horizontal)", "Bottom, right side (Rotate 180)", "Bottom, left side (Mirror vertical)", "Left side, top (Mirror horizontal and rotate 270 CW)", "Right side, top (Rotate 90 CW)", "Right side, bottom (Mirror horizontal and rotate 90 CW)", "Left side, bottom (Rotate 270 CW)");
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
    protected final java.lang.String O00000oO(int r8) {
        /*
            r7 = this;
            T r0 = r7.f2602O000000o
            java.lang.Float r8 = r0.O0000Oo0(r8)
            if (r8 != 0) goto L_0x000a
            r8 = 0
            return r8
        L_0x000a:
            float r0 = r8.floatValue()
            r1 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r2 = " sec"
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x005f
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            float r8 = r8.floatValue()
            double r5 = (double) r8
            double r3 = java.lang.Math.log(r3)
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r3
            double r3 = java.lang.Math.exp(r5)
            double r0 = r0 / r3
            float r8 = (float) r0
            double r0 = (double) r8
            r3 = 4621819117588971520(0x4024000000000000, double:10.0)
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r3
            long r0 = java.lang.Math.round(r0)
            float r8 = (float) r0
            r0 = 1092616192(0x41200000, float:10.0)
            float r8 = r8 / r0
            java.text.DecimalFormat r0 = new java.text.DecimalFormat
            java.lang.String r1 = "0.##"
            r0.<init>(r1)
            java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP
            r0.setRoundingMode(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            double r3 = (double) r8
            java.lang.String r8 = r0.format(r3)
            r1.append(r8)
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            return r8
        L_0x005f:
            float r8 = r8.floatValue()
            double r0 = (double) r8
            double r3 = java.lang.Math.log(r3)
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r3
            double r0 = java.lang.Math.exp(r0)
            int r8 = (int) r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "1/"
            r0.<init>(r1)
            r0.append(r8)
            r0.append(r2)
            java.lang.String r8 = r0.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.xx.O00000oO(int):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final String O000000o(short s) {
        if (s == 0) {
            return "Unknown";
        }
        if (s == 1) {
            return "Daylight";
        }
        if (s == 2) {
            return "Fluorescent";
        }
        if (s == 3) {
            return "Tungsten (Incandescent)";
        }
        if (s == 4) {
            return "Flash";
        }
        if (s == 255) {
            return "Other";
        }
        switch (s) {
            case 9:
                return "Fine Weather";
            case 10:
                return "Cloudy";
            case 11:
                return "Shade";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "Daylight Fluorescent";
            case 13:
                return "Day White Fluorescent";
            case 14:
                return "Cool White Fluorescent";
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return "White Fluorescent";
            case 16:
                return "Warm White Fluorescent";
            case 17:
                return "Standard Light A";
            case 18:
                return "Standard Light B";
            case 19:
                return "Standard Light C";
            case 20:
                return "D55";
            case 21:
                return "D65";
            case 22:
                return "D75";
            case 23:
                return "D50";
            case 24:
                return "ISO Studio Tungsten";
            default:
                return O000000o((int) s);
        }
    }
}
