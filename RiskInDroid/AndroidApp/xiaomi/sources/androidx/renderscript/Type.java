package androidx.renderscript;

import _m_j.hi;

public class Type extends hi {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f2970O000000o;
    protected int O00000Oo;
    protected boolean O00000o;
    protected int O00000o0;
    protected boolean O00000oO;
    protected int O00000oo;
    int O0000O0o;
    protected Element O0000OOo;

    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);
        
        int mID;

        private CubemapFace(int i) {
            this.mID = i;
        }
    }

    protected Type(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        RenderScript f2971O000000o;
        int O00000Oo = 1;
        int O00000o;
        int O00000o0;
        boolean O00000oO;
        boolean O00000oo;
        int O0000O0o;
        Element O0000OOo;

        public O000000o(RenderScript renderScript, Element element) {
            if (element.O0000o0O == 0 && element.O00000Oo() == null) {
                throw new RSIllegalArgumentException("Invalid object.");
            }
            this.f2971O000000o = renderScript;
            this.O0000OOo = element;
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        boolean z = this.O00000o;
        int i = this.f2970O000000o;
        int i2 = this.O00000Oo;
        int i3 = this.O00000o0;
        int i4 = this.O00000oO ? 6 : 1;
        if (i == 0) {
            i = 1;
        }
        if (i2 == 0) {
            i2 = 1;
        }
        if (i3 == 0) {
            i3 = 1;
        }
        int i5 = i * i2 * i3 * i4;
        while (z && (i > 1 || i2 > 1 || i3 > 1)) {
            if (i > 1) {
                i >>= 1;
            }
            if (i2 > 1) {
                i2 >>= 1;
            }
            if (i3 > 1) {
                i3 >>= 1;
            }
            i5 += i * i2 * i3 * i4;
        }
        this.O0000O0o = i5;
    }
}
