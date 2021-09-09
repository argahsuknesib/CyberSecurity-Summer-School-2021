package _m_j;

import android.graphics.PointF;
import android.graphics.RectF;

public final class izd {

    /* renamed from: O000000o  reason: collision with root package name */
    private O00000Oo f1661O000000o = null;
    private float O00000Oo = 0.8f;
    private float O00000o0 = 0.46f;

    public static double O000000o(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }

    public static double O00000Oo(double d) {
        return (d * 3.141592653589793d) / 4.0d;
    }

    public static double O00000o0(double d) {
        return (d * 3.141592653589793d) / 4.0d;
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: android.graphics.Path.addRect(android.graphics.RectF, android.graphics.Path$Direction):void in method: _m_j.izd.O000000o(android.graphics.Path):android.graphics.Path, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: android.graphics.Path.addRect(android.graphics.RectF, android.graphics.Path$Direction):void
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:540)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public final android.graphics.Path O000000o(android.graphics.Path r1) {
        /*
            r14 = this;
            if (r15 != 0) goto L_0x0007
            android.graphics.Path r15 = new android.graphics.Path
            r15.<init>()
        L_0x0007:
            r15.reset()
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            r7 = 0
            r8 = 1
            if (r0 == 0) goto L_0x0027
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            if (r0 == 0) goto L_0x0027
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            if (r0 == 0) goto L_0x0027
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            if (r0 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            r9 = 0
            if (r0 == 0) goto L_0x003e
            android.graphics.RectF r0 = new android.graphics.RectF
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            float r1 = r1.f1663O000000o
            _m_j.izd$O00000Oo r2 = r14.f1661O000000o
            float r2 = r2.O00000Oo
            r0.<init>(r9, r9, r1, r2)
            android.graphics.Path$Direction r1 = android.graphics.Path.Direction.CCW
            r15.addRect(r0, r1)
            return r15
        L_0x003e:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            float r0 = r0.O0000O0o
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0069
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.RectF r0 = r0.f1662O000000o
            r1 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            _m_j.izd$O00000Oo r3 = r14.f1661O000000o
            _m_j.izd$O000000o r3 = r3.O00000oO
            double r3 = r3.O00000oo
            double r3 = r3 + r1
            double r1 = O000000o(r3)
            float r1 = (float) r1
            _m_j.izd$O00000Oo r2 = r14.f1661O000000o
            _m_j.izd$O000000o r2 = r2.O00000oO
            float r2 = r2.O0000O0o
            r15.arcTo(r0, r1, r2)
            goto L_0x0080
        L_0x0069:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r7]
            float r0 = r0.x
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            _m_j.izd$O000000o r1 = r1.O00000oO
            android.graphics.PointF[] r1 = r1.O0000OOo
            r1 = r1[r7]
            float r1 = r1.y
            r15.moveTo(r0, r1)
        L_0x0080:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            double r0 = r0.O00000o0
            r10 = 0
            r12 = 3
            r13 = 2
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x00ce
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x00ce:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r1 = r0.f1663O000000o
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            float r2 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            float r3 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            double r4 = r0.O00000o0
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r6 = r0.O00000o
            boolean r0 = O000000o(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x0103
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r7]
            float r0 = r0.x
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            _m_j.izd$O000000o r1 = r1.O00000oo
            android.graphics.PointF[] r1 = r1.O0000OOo
            r1 = r1[r7]
            float r1 = r1.y
            r15.lineTo(r0, r1)
        L_0x0103:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            double r0 = r0.O00000o0
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x014d
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x014d:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            float r0 = r0.O0000O0o
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0177
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.RectF r0 = r0.f1662O000000o
            r1 = 4616991696741409234(0x4012d97c7f3321d2, double:4.71238898038469)
            _m_j.izd$O00000Oo r3 = r14.f1661O000000o
            _m_j.izd$O000000o r3 = r3.O00000oo
            double r3 = r3.O00000oO
            double r3 = r3 + r1
            double r1 = O000000o(r3)
            float r1 = (float) r1
            _m_j.izd$O00000Oo r2 = r14.f1661O000000o
            _m_j.izd$O000000o r2 = r2.O00000oo
            float r2 = r2.O0000O0o
            r15.arcTo(r0, r1, r2)
        L_0x0177:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            double r0 = r0.O00000o
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x01c1
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x01c1:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r1 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oo
            float r2 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            float r3 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            double r4 = r0.O00000o0
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r6 = r0.O00000o
            boolean r0 = O00000Oo(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x01f6
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r7]
            float r0 = r0.x
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            _m_j.izd$O000000o r1 = r1.O0000O0o
            android.graphics.PointF[] r1 = r1.O0000Oo0
            r1 = r1[r7]
            float r1 = r1.y
            r15.lineTo(r0, r1)
        L_0x01f6:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            double r0 = r0.O00000o
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0240
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x0240:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            float r0 = r0.O0000O0o
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0264
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.RectF r0 = r0.f1662O000000o
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            _m_j.izd$O000000o r1 = r1.O0000O0o
            double r1 = r1.O00000oo
            double r1 = O000000o(r1)
            float r1 = (float) r1
            _m_j.izd$O00000Oo r2 = r14.f1661O000000o
            _m_j.izd$O000000o r2 = r2.O0000O0o
            float r2 = r2.O0000O0o
            r15.arcTo(r0, r1, r2)
        L_0x0264:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            double r0 = r0.O00000o0
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x02ae
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x02ae:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r1 = r0.f1663O000000o
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000O0o
            float r2 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            float r3 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            double r4 = r0.O00000o0
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r6 = r0.O00000o
            boolean r0 = O000000o(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x02e3
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r7]
            float r0 = r0.x
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            _m_j.izd$O000000o r1 = r1.O0000OOo
            android.graphics.PointF[] r1 = r1.O0000OOo
            r1 = r1[r7]
            float r1 = r1.y
            r15.lineTo(r0, r1)
        L_0x02e3:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            double r0 = r0.O00000o0
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x032d
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000OOo
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x032d:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            float r0 = r0.O0000O0o
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0357
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.RectF r0 = r0.f1662O000000o
            r1 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            _m_j.izd$O00000Oo r3 = r14.f1661O000000o
            _m_j.izd$O000000o r3 = r3.O0000OOo
            double r3 = r3.O00000oO
            double r3 = r3 + r1
            double r1 = O000000o(r3)
            float r1 = (float) r1
            _m_j.izd$O00000Oo r2 = r14.f1661O000000o
            _m_j.izd$O000000o r2 = r2.O0000OOo
            float r2 = r2.O0000O0o
            r15.arcTo(r0, r1, r2)
        L_0x0357:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            double r0 = r0.O00000o
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x03a1
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x03a1:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r1 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O0000OOo
            float r2 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            float r3 = r0.O00000Oo
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            double r4 = r0.O00000o0
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            float r6 = r0.O00000o
            boolean r0 = O00000Oo(r1, r2, r3, r4, r6)
            if (r0 != 0) goto L_0x03d6
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r7]
            float r0 = r0.x
            _m_j.izd$O00000Oo r1 = r14.f1661O000000o
            _m_j.izd$O000000o r1 = r1.O00000oO
            android.graphics.PointF[] r1 = r1.O0000Oo0
            r1 = r1[r7]
            float r1 = r1.y
            r15.lineTo(r0, r1)
        L_0x03d6:
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            double r0 = r0.O00000o
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0420
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r1 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r8]
            float r2 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r3 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r13]
            float r4 = r0.y
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r5 = r0.x
            _m_j.izd$O00000Oo r0 = r14.f1661O000000o
            _m_j.izd$O000000o r0 = r0.O00000oO
            android.graphics.PointF[] r0 = r0.O0000Oo0
            r0 = r0[r12]
            float r6 = r0.y
            r0 = r15
            r0.cubicTo(r1, r2, r3, r4, r5, r6)
        L_0x0420:
            r15.close()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.izd.O000000o(android.graphics.Path):android.graphics.Path");
    }

    public final void O000000o(RectF rectF, float f, float f2, float f3) {
        O000000o(rectF, new float[]{f, f, f, f, f, f, f, f}, f2, f3);
    }

    private void O000000o() {
        if (this.f1661O000000o.O00000oO == null) {
            this.f1661O000000o.O00000oO = new O000000o();
        }
        if (this.f1661O000000o.O00000oo == null) {
            this.f1661O000000o.O00000oo = new O000000o();
        }
        if (this.f1661O000000o.O0000O0o == null) {
            this.f1661O000000o.O0000O0o = new O000000o();
        }
        if (this.f1661O000000o.O0000OOo == null) {
            this.f1661O000000o.O0000OOo = new O000000o();
        }
    }

    private static boolean O000000o(float f, float f2, float f3, double d, float f4) {
        double d2 = (double) f;
        double d3 = (double) (f2 + f3);
        double d4 = (double) f4;
        Double.isNaN(d4);
        Double.isNaN(d3);
        return d2 <= d3 * ((d * d4) + 1.0d);
    }

    private static boolean O00000Oo(float f, float f2, float f3, double d, float f4) {
        double d2 = (double) f;
        double d3 = (double) (f2 + f3);
        double d4 = (double) f4;
        Double.isNaN(d4);
        Double.isNaN(d3);
        return d2 <= d3 * ((d * d4) + 1.0d);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public static double O000000o(float f, float f2, double d, float f3) {
        return O000000o(f, f2, f2, d, f3) ? (double) Math.max(Math.min(((f / (f2 * 2.0f)) - 1.0f) / f3, 1.0f), 0.0f) : d;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public static double O00000Oo(float f, float f2, double d, float f3) {
        return O00000Oo(f, f2, f2, d, f3) ? (double) Math.max(Math.min(((f / (f2 * 2.0f)) - 1.0f) / f3, 1.0f), 0.0f) : d;
    }

    public static double O000000o(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return d2 * (1.0d - Math.cos(d));
    }

    public static double O00000Oo(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return d2 * (1.0d - Math.sin(d));
    }

    public static double O00000o0(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return d2 * (1.0d - Math.sin(d));
    }

    public static double O00000o(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return d2 * (1.0d - Math.cos(d));
    }

    public static double O00000oO(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return d2 * (1.0d - Math.tan(d / 2.0d));
    }

    public static double O00000oo(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return d2 * (1.0d - Math.tan(d / 2.0d));
    }

    public static double O0000O0o(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return ((d2 * 1.5d) * Math.tan(d / 2.0d)) / (Math.cos(d) + 1.0d);
    }

    public static double O0000OOo(float f, double d) {
        double d2 = (double) f;
        Double.isNaN(d2);
        return ((d2 * 1.5d) * Math.tan(d / 2.0d)) / (Math.cos(d) + 1.0d);
    }

    public static double O000000o(double d, double d2) {
        if (d2 == 0.0d) {
            return 0.0d;
        }
        double d3 = d2 / 2.0d;
        return (((((d * 0.46000000834465027d) + Math.tan(d3)) * 2.0d) * (Math.cos(d2) + 1.0d)) / (Math.tan(d3) * 3.0d)) - 1.0d;
    }

    public static double O00000Oo(double d, double d2) {
        if (d2 == 0.0d) {
            return 0.0d;
        }
        double d3 = d2 / 2.0d;
        return (((((d * 0.46000000834465027d) + Math.tan(d3)) * 2.0d) * (Math.cos(d2) + 1.0d)) / (Math.tan(d3) * 3.0d)) - 1.0d;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public RectF f1662O000000o;
        public float O00000Oo;
        public double O00000o;
        public double O00000o0;
        public double O00000oO;
        public double O00000oo;
        public float O0000O0o;
        public PointF[] O0000OOo = new PointF[4];
        public PointF[] O0000Oo0 = new PointF[4];

        public final void O000000o(float f, RectF rectF, float f2, float f3, double d, float f4, int i) {
            RectF rectF2 = rectF;
            float f5 = f2;
            float f6 = f3;
            double d2 = d;
            float f7 = f4;
            int i2 = i;
            this.O00000Oo = f;
            float width = rectF.width();
            float height = rectF.height();
            float f8 = rectF2.left;
            float f9 = rectF2.top;
            float f10 = rectF2.right;
            float f11 = rectF2.bottom;
            this.O00000o0 = izd.O000000o(width, this.O00000Oo, d2, f7);
            this.O00000o = izd.O00000Oo(height, this.O00000Oo, d2, f7);
            this.O00000oO = izd.O00000o0(this.O00000o0);
            this.O00000oo = izd.O00000Oo(this.O00000o);
            this.O0000O0o = (float) izd.O000000o((1.5707963267948966d - this.O00000oo) - this.O00000oO);
            double d3 = this.O00000o0;
            double d4 = (double) f7;
            Double.isNaN(d4);
            double O000000o2 = izd.O000000o(d3 * d4, this.O00000oO);
            float f12 = f10;
            double O00000o02 = izd.O00000o0(this.O00000Oo, this.O00000oO);
            double O00000o2 = izd.O00000o(this.O00000Oo, this.O00000oO);
            double O00000oO2 = izd.O00000oO(this.O00000Oo, this.O00000oO);
            double O0000O0o2 = izd.O0000O0o(this.O00000Oo, this.O00000oO);
            double d5 = O000000o2 * O0000O0o2;
            double d6 = this.O00000o;
            Double.isNaN(d4);
            double O00000Oo2 = izd.O00000Oo(d6 * d4, this.O00000oo);
            double d7 = O0000O0o2;
            double O000000o3 = izd.O000000o(this.O00000Oo, this.O00000oo);
            double O00000Oo3 = izd.O00000Oo(this.O00000Oo, this.O00000oo);
            double O00000oo2 = izd.O00000oo(this.O00000Oo, this.O00000oo);
            double d8 = O000000o3;
            double O0000OOo2 = izd.O0000OOo(this.O00000Oo, this.O00000oo);
            double d9 = O00000Oo2 * O0000OOo2;
            if (i2 == 0) {
                float f13 = f8 + f5;
                float f14 = f9 + f6;
                float f15 = this.O00000Oo;
                this.f1662O000000o = new RectF(f13, f14, (f15 * 2.0f) + f13, (f15 * 2.0f) + f14);
                PointF[] pointFArr = this.O0000OOo;
                double d10 = (double) f13;
                Double.isNaN(d10);
                double d11 = (double) f14;
                Double.isNaN(d11);
                pointFArr[0] = new PointF((float) (O00000o02 + d10), (float) (O00000o2 + d11));
                PointF[] pointFArr2 = this.O0000OOo;
                Double.isNaN(d10);
                pointFArr2[1] = new PointF((float) (O00000oO2 + d10), f14);
                PointF[] pointFArr3 = this.O0000OOo;
                double d12 = O00000oO2 + d7;
                Double.isNaN(d10);
                pointFArr3[2] = new PointF((float) (d12 + d10), f14);
                PointF[] pointFArr4 = this.O0000OOo;
                Double.isNaN(d10);
                pointFArr4[3] = new PointF((float) (d12 + d5 + d10), f14);
                PointF[] pointFArr5 = this.O0000Oo0;
                double d13 = O00000oo2 + O0000OOo2;
                Double.isNaN(d11);
                float f16 = f13;
                pointFArr5[0] = new PointF(f16, (float) (d13 + d9 + d11));
                PointF[] pointFArr6 = this.O0000Oo0;
                Double.isNaN(d11);
                pointFArr6[1] = new PointF(f16, (float) (d13 + d11));
                PointF[] pointFArr7 = this.O0000Oo0;
                Double.isNaN(d11);
                pointFArr7[2] = new PointF(f16, (float) (O00000oo2 + d11));
                PointF[] pointFArr8 = this.O0000Oo0;
                Double.isNaN(d10);
                Double.isNaN(d11);
                pointFArr8[3] = new PointF((float) (d8 + d10), (float) (O00000Oo3 + d11));
                return;
            }
            double d14 = d9;
            double d15 = O0000OOo2;
            if (i2 == 1) {
                float f17 = f9 + f6;
                float f18 = this.O00000Oo;
                float f19 = f12 - f5;
                this.f1662O000000o = new RectF((f12 - (f18 * 2.0f)) - f5, f17, f19, (f18 * 2.0f) + f17);
                PointF[] pointFArr9 = this.O0000OOo;
                double d16 = (double) f12;
                Double.isNaN(d16);
                double d17 = d16 - O00000oO2;
                double d18 = d17 - d7;
                double d19 = (double) f5;
                Double.isNaN(d19);
                double d20 = O00000oo2;
                pointFArr9[0] = new PointF((float) ((d18 - d5) - d19), f17);
                PointF[] pointFArr10 = this.O0000OOo;
                Double.isNaN(d19);
                pointFArr10[1] = new PointF((float) (d18 - d19), f17);
                PointF[] pointFArr11 = this.O0000OOo;
                Double.isNaN(d19);
                pointFArr11[2] = new PointF((float) (d17 - d19), f17);
                PointF[] pointFArr12 = this.O0000OOo;
                Double.isNaN(d16);
                Double.isNaN(d19);
                double d21 = (double) f17;
                Double.isNaN(d21);
                pointFArr12[3] = new PointF((float) ((d16 - O00000o02) - d19), (float) (O00000o2 + d21));
                PointF[] pointFArr13 = this.O0000Oo0;
                Double.isNaN(d16);
                Double.isNaN(d19);
                Double.isNaN(d21);
                pointFArr13[0] = new PointF((float) ((d16 - d8) - d19), (float) (O00000Oo3 + d21));
                PointF[] pointFArr14 = this.O0000Oo0;
                Double.isNaN(d21);
                float f20 = f19;
                pointFArr14[1] = new PointF(f20, (float) (d20 + d21));
                PointF[] pointFArr15 = this.O0000Oo0;
                double d22 = d20 + d15;
                Double.isNaN(d21);
                pointFArr15[2] = new PointF(f20, (float) (d22 + d21));
                PointF[] pointFArr16 = this.O0000Oo0;
                Double.isNaN(d21);
                pointFArr16[3] = new PointF(f20, (float) (d22 + d14 + d21));
                return;
            }
            float f21 = f12;
            double d23 = O00000oo2;
            if (i2 == 2) {
                float f22 = this.O00000Oo;
                float f23 = f21 - f5;
                float f24 = f11 - f6;
                this.f1662O000000o = new RectF((f21 - (f22 * 2.0f)) - f5, (f11 - (f22 * 2.0f)) - f6, f23, f24);
                PointF[] pointFArr17 = this.O0000OOo;
                double d24 = (double) f21;
                Double.isNaN(d24);
                double d25 = (double) f5;
                Double.isNaN(d25);
                float f25 = f23;
                double d26 = (double) f11;
                Double.isNaN(d26);
                double d27 = d25;
                double d28 = (double) f6;
                Double.isNaN(d28);
                pointFArr17[0] = new PointF((float) ((d24 - O00000o02) - d25), (float) ((d26 - O00000o2) - d28));
                PointF[] pointFArr18 = this.O0000OOo;
                Double.isNaN(d24);
                double d29 = d24 - O00000oO2;
                Double.isNaN(d27);
                float f26 = f24;
                pointFArr18[1] = new PointF((float) (d29 - d27), f26);
                PointF[] pointFArr19 = this.O0000OOo;
                double d30 = d29 - d7;
                Double.isNaN(d27);
                pointFArr19[2] = new PointF((float) (d30 - d27), f26);
                PointF[] pointFArr20 = this.O0000OOo;
                Double.isNaN(d27);
                pointFArr20[3] = new PointF((float) ((d30 - d5) - d27), f26);
                PointF[] pointFArr21 = this.O0000Oo0;
                Double.isNaN(d26);
                double d31 = d26 - d23;
                double d32 = d31 - d15;
                Double.isNaN(d28);
                PointF[] pointFArr22 = pointFArr21;
                float f27 = f25;
                pointFArr22[0] = new PointF(f27, (float) ((d32 - d14) - d28));
                PointF[] pointFArr23 = this.O0000Oo0;
                Double.isNaN(d28);
                pointFArr23[1] = new PointF(f27, (float) (d32 - d28));
                PointF[] pointFArr24 = this.O0000Oo0;
                Double.isNaN(d28);
                pointFArr24[2] = new PointF(f27, (float) (d31 - d28));
                PointF[] pointFArr25 = this.O0000Oo0;
                Double.isNaN(d24);
                Double.isNaN(d27);
                Double.isNaN(d26);
                Double.isNaN(d28);
                pointFArr25[3] = new PointF((float) ((d24 - d8) - d27), (float) ((d26 - O00000Oo3) - d28));
            } else if (i2 == 3) {
                float f28 = f8 + f5;
                float f29 = this.O00000Oo;
                float f30 = f11 - f6;
                this.f1662O000000o = new RectF(f28, (f11 - (f29 * 2.0f)) - f6, (f29 * 2.0f) + f28, f30);
                PointF[] pointFArr26 = this.O0000OOo;
                double d33 = O00000oO2 + d7;
                double d34 = (double) f28;
                Double.isNaN(d34);
                pointFArr26[0] = new PointF((float) (d33 + d5 + d34), f30);
                PointF[] pointFArr27 = this.O0000OOo;
                Double.isNaN(d34);
                pointFArr27[1] = new PointF((float) (d33 + d34), f30);
                PointF[] pointFArr28 = this.O0000OOo;
                Double.isNaN(d34);
                pointFArr28[2] = new PointF((float) (O00000oO2 + d34), f30);
                PointF[] pointFArr29 = this.O0000OOo;
                Double.isNaN(d34);
                double d35 = (double) f11;
                Double.isNaN(d35);
                double d36 = (double) f6;
                Double.isNaN(d36);
                pointFArr29[3] = new PointF((float) (O00000o02 + d34), (float) ((d35 - O00000o2) - d36));
                PointF[] pointFArr30 = this.O0000Oo0;
                Double.isNaN(d34);
                Double.isNaN(d35);
                Double.isNaN(d36);
                pointFArr30[0] = new PointF((float) (d8 + d34), (float) ((d35 - O00000Oo3) - d36));
                PointF[] pointFArr31 = this.O0000Oo0;
                Double.isNaN(d35);
                double d37 = d35 - d23;
                Double.isNaN(d36);
                pointFArr31[1] = new PointF(f28, (float) (d37 - d36));
                PointF[] pointFArr32 = this.O0000Oo0;
                double d38 = d37 - d15;
                Double.isNaN(d36);
                pointFArr32[2] = new PointF(f28, (float) (d38 - d36));
                PointF[] pointFArr33 = this.O0000Oo0;
                Double.isNaN(d36);
                pointFArr33[3] = new PointF(f28, (float) ((d38 - d14) - d36));
            }
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f1663O000000o;
        public float O00000Oo;
        public float O00000o;
        public double O00000o0;
        public O000000o O00000oO = null;
        public O000000o O00000oo = null;
        public O000000o O0000O0o = null;
        public O000000o O0000OOo = null;

        public O00000Oo(float f, float f2, double d, float f3) {
            this.f1663O000000o = f;
            this.O00000Oo = f2;
            this.O00000o0 = d;
            this.O00000o = f3;
        }
    }

    public final void O000000o(RectF rectF, float[] fArr, float f, float f2) {
        float[] fArr2 = fArr;
        float f3 = this.O00000o0;
        float f4 = this.O00000Oo;
        float width = rectF.width();
        float height = rectF.height();
        double d = (double) f4;
        this.f1661O000000o = new O00000Oo(width, height, d, f3);
        if (fArr2 != null) {
            float[] fArr3 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            for (int i = 0; i < Math.min(8, fArr2.length); i++) {
                fArr3[i] = fArr2[i];
            }
            float f5 = fArr3[0];
            float f6 = fArr3[1];
            float f7 = fArr3[2];
            float f8 = fArr3[3];
            float f9 = fArr3[4];
            float f10 = fArr3[5];
            float f11 = fArr3[6];
            float f12 = fArr3[7];
            if (f5 + f7 > width) {
                f5 = (fArr3[0] * width) / (fArr3[0] + fArr3[2]);
                f7 = (fArr3[2] * width) / (fArr3[0] + fArr3[2]);
            }
            float f13 = f7;
            if (f8 + f10 > height) {
                f8 = (fArr3[3] * height) / (fArr3[3] + fArr3[5]);
                f10 = (fArr3[5] * height) / (fArr3[3] + fArr3[5]);
            }
            float f14 = f10;
            if (f9 + f11 > width) {
                f9 = (fArr3[4] * width) / (fArr3[4] + fArr3[6]);
                f11 = (width * fArr3[6]) / (fArr3[4] + fArr3[6]);
            }
            float f15 = f9;
            float f16 = f11;
            if (f12 + f6 > height) {
                f12 = (fArr3[7] * height) / (fArr3[7] + fArr3[1]);
                f6 = (height * fArr3[1]) / (fArr3[7] + fArr3[1]);
            }
            O000000o();
            O000000o o000000o = this.f1661O000000o.O00000oO;
            float min = Math.min(f5, f6);
            O000000o o000000o2 = o000000o;
            float f17 = min;
            RectF rectF2 = rectF;
            float f18 = f;
            float f19 = f2;
            float f20 = f13;
            float f21 = f16;
            float f22 = f3;
            o000000o2.O000000o(f17, rectF2, f18, f19, d, f22, 0);
            double d2 = d;
            this.f1661O000000o.O00000oo.O000000o(Math.min(f20, f8), rectF2, f18, f19, d2, f22, 1);
            this.f1661O000000o.O0000O0o.O000000o(Math.min(f15, f14), rectF2, f18, f19, d2, f22, 2);
            this.f1661O000000o.O0000OOo.O000000o(Math.min(f21, f12), rectF, f18, f19, d2, f22, 3);
        }
    }
}
