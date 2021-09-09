package _m_j;

import _m_j.auh;
import android.graphics.RectF;
import com.github.barteksc.pdfviewer.PDFView;

public final class atn {

    /* renamed from: O000000o  reason: collision with root package name */
    private PDFView f12602O000000o;
    private int O00000Oo;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private float O0000OOo;
    private final int O0000Oo;
    private final RectF O0000Oo0 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final O00000Oo O0000OoO = new O00000Oo(this, (byte) 0);
    private final O00000Oo O0000Ooo = new O00000Oo(this, (byte) 0);
    private final O000000o O0000o0 = new O000000o(this, (byte) 0);
    private final O000000o O0000o00 = new O000000o(this, (byte) 0);
    private final O000000o O0000o0O = new O000000o(this, (byte) 0);

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f12604O000000o;
        int O00000Oo;
        int O00000o0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(atn atn, byte b) {
            this();
        }
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f12603O000000o;
        int O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(atn atn, byte b) {
            this();
        }
    }

    public atn(PDFView pDFView) {
        this.f12602O000000o = pDFView;
        this.O0000Oo = auk.O000000o(pDFView.getContext(), auh.O00000o);
    }

    private void O000000o(O000000o o000000o, int i) {
        dbk O000000o2 = this.f12602O000000o.O00000oo.O000000o(i);
        float zoom = (auh.O00000o0 * (1.0f / O000000o2.O00000Oo)) / this.f12602O000000o.getZoom();
        float zoom2 = (auh.O00000o0 * (1.0f / O000000o2.f14452O000000o)) / this.f12602O000000o.getZoom();
        o000000o.f12603O000000o = aui.O00000o(1.0f / zoom);
        o000000o.O00000Oo = aui.O00000o(1.0f / zoom2);
    }

    private O00000Oo O000000o(O00000Oo o00000Oo, O000000o o000000o, float f, float f2, boolean z) {
        float f3;
        float f4;
        float f5 = -aui.O000000o(f);
        float f6 = -aui.O000000o(f2);
        o00000Oo.f12604O000000o = this.f12602O000000o.O00000oo.O000000o(this.f12602O000000o.O0000o ? f6 : f5, this.f12602O000000o.getZoom());
        O000000o(o000000o, o00000Oo.f12604O000000o);
        dbk O000000o2 = this.f12602O000000o.O00000oo.O000000o(o00000Oo.f12604O000000o, this.f12602O000000o.getZoom());
        float f7 = O000000o2.O00000Oo / ((float) o000000o.f12603O000000o);
        float f8 = O000000o2.f14452O000000o / ((float) o000000o.O00000Oo);
        float O00000o2 = this.f12602O000000o.O00000oo.O00000o(o00000Oo.f12604O000000o, this.f12602O000000o.getZoom());
        if (this.f12602O000000o.O0000o) {
            f3 = Math.abs(f6 - this.f12602O000000o.O00000oo.O00000o0(o00000Oo.f12604O000000o, this.f12602O000000o.getZoom())) / f7;
            f4 = aui.O00000Oo(f5 - O00000o2) / f8;
        } else {
            f3 = aui.O00000Oo(f6 - O00000o2) / f7;
            f4 = Math.abs(f5 - this.f12602O000000o.O00000oo.O00000o0(o00000Oo.f12604O000000o, this.f12602O000000o.getZoom())) / f8;
        }
        if (z) {
            o00000Oo.O00000Oo = aui.O00000o(f3);
            o00000Oo.O00000o0 = aui.O00000o(f4);
        } else {
            o00000Oo.O00000Oo = aui.O00000o0(f3);
            o00000Oo.O00000o0 = aui.O00000o0(f4);
        }
        return o00000Oo;
    }

    private void O000000o(O000000o o000000o) {
        this.O00000oO = 1.0f / ((float) o000000o.O00000Oo);
        this.O00000oo = 1.0f / ((float) o000000o.f12603O000000o);
        this.O0000O0o = auh.O00000o0 / this.O00000oO;
        this.O0000OOo = auh.O00000o0 / this.O00000oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.atn.O000000o(_m_j.atn$O00000Oo, _m_j.atn$O000000o, float, float, boolean):_m_j.atn$O00000Oo
     arg types: [_m_j.atn$O00000Oo, _m_j.atn$O000000o, float, float, int]
     candidates:
      _m_j.atn.O000000o(int, int, int, float, float):boolean
      _m_j.atn.O000000o(_m_j.atn$O00000Oo, _m_j.atn$O000000o, float, float, boolean):_m_j.atn$O00000Oo */
    private void O00000Oo() {
        int i;
        float zoom = ((float) this.O0000Oo) * this.f12602O000000o.getZoom();
        float f = this.O00000o0;
        float f2 = (-f) + zoom;
        float width = ((-f) - ((float) this.f12602O000000o.getWidth())) - zoom;
        float f3 = this.O00000o;
        O000000o(this.O0000OoO, this.O0000o00, f2, (-f3) + zoom, false);
        O000000o(this.O0000Ooo, this.O0000o0, width, ((-f3) - ((float) this.f12602O000000o.getHeight())) - zoom, true);
        for (int i2 = this.O0000OoO.f12604O000000o; i2 <= this.O0000Ooo.f12604O000000o; i2++) {
            dbk O000000o2 = this.f12602O000000o.O00000oo.O000000o(i2);
            float f4 = auh.O00000Oo * O000000o2.f14452O000000o;
            float f5 = O000000o2.O00000Oo * auh.O00000Oo;
            if (!this.f12602O000000o.O00000o0.O000000o(i2, this.O0000Oo0)) {
                this.f12602O000000o.O0000o0.O000000o(i2, f4, f5, this.O0000Oo0, true, 0, this.f12602O000000o.O0000oo0, this.f12602O000000o.O0000oo);
            }
        }
        int i3 = (this.O0000Ooo.f12604O000000o - this.O0000OoO.f12604O000000o) + 1;
        int i4 = 0;
        for (int i5 = this.O0000OoO.f12604O000000o; i5 <= this.O0000Ooo.f12604O000000o && i4 < auh.O000000o.f12621O000000o; i5++) {
            if (i5 == this.O0000OoO.f12604O000000o && i3 > 1) {
                O00000Oo o00000Oo = this.O0000OoO;
                O000000o o000000o = this.O0000o00;
                int i6 = auh.O000000o.f12621O000000o - i4;
                O000000o(o000000o);
                if (this.f12602O000000o.O0000o) {
                    i = O000000o(o00000Oo.f12604O000000o, o00000Oo.O00000Oo, o000000o.f12603O000000o - 1, 0, o000000o.O00000Oo - 1, i6);
                } else {
                    i = O000000o(o00000Oo.f12604O000000o, 0, o000000o.f12603O000000o - 1, o00000Oo.O00000o0, o000000o.O00000Oo - 1, i6);
                }
            } else if (i5 == this.O0000Ooo.f12604O000000o && i3 > 1) {
                O00000Oo o00000Oo2 = this.O0000Ooo;
                O000000o o000000o2 = this.O0000o0;
                int i7 = auh.O000000o.f12621O000000o - i4;
                O000000o(o000000o2);
                if (this.f12602O000000o.O0000o) {
                    i = O000000o(o00000Oo2.f12604O000000o, 0, o00000Oo2.O00000Oo, 0, o000000o2.O00000Oo - 1, i7);
                } else {
                    i = O000000o(o00000Oo2.f12604O000000o, 0, o000000o2.f12603O000000o - 1, 0, o00000Oo2.O00000o0, i7);
                }
            } else if (i3 == 1) {
                O00000Oo o00000Oo3 = this.O0000OoO;
                O00000Oo o00000Oo4 = this.O0000Ooo;
                O000000o(this.O0000o00);
                i = O000000o(o00000Oo3.f12604O000000o, o00000Oo3.O00000Oo, o00000Oo4.O00000Oo, o00000Oo3.O00000o0, o00000Oo4.O00000o0, auh.O000000o.f12621O000000o - i4);
            } else {
                O000000o(this.O0000o0O, i5);
                O000000o o000000o3 = this.O0000o0O;
                int i8 = auh.O000000o.f12621O000000o - i4;
                O000000o(o000000o3);
                i = O000000o(i5, 0, o000000o3.f12603O000000o - 1, 0, o000000o3.O00000Oo - 1, i8);
            }
            i4 += i;
        }
    }

    private int O000000o(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i2 <= i3) {
            int i8 = i7;
            for (int i9 = i4; i9 <= i5; i9++) {
                if (O000000o(i, i2, i9, this.O00000oO, this.O00000oo)) {
                    i8++;
                }
                if (i8 >= i6) {
                    return i8;
                }
            }
            i2++;
            i7 = i8;
        }
        return i7;
    }

    private boolean O000000o(int i, int i2, int i3, float f, float f2) {
        float f3 = ((float) i3) * f;
        float f4 = ((float) i2) * f2;
        float f5 = this.O0000O0o;
        float f6 = this.O0000OOo;
        float f7 = f3 + f > 1.0f ? 1.0f - f3 : f;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 * f7;
        float f10 = f6 * f8;
        RectF rectF = new RectF(f3, f4, f7 + f3, f8 + f4);
        if (f9 <= 0.0f || f10 <= 0.0f) {
            return false;
        }
        if (!this.f12602O000000o.O00000o0.O000000o(i, rectF, this.O00000Oo)) {
            this.f12602O000000o.O0000o0.O000000o(i, f9, f10, rectF, false, this.O00000Oo, this.f12602O000000o.O0000oo0, this.f12602O000000o.O0000oo);
        }
        this.O00000Oo++;
        return true;
    }

    public final void O000000o() {
        this.O00000Oo = 1;
        this.O00000o0 = -aui.O000000o(this.f12602O000000o.getCurrentXOffset());
        this.O00000o = -aui.O000000o(this.f12602O000000o.getCurrentYOffset());
        O00000Oo();
    }
}
