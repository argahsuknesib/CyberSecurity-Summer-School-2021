package _m_j;

import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.util.ArrayList;
import java.util.List;

public final class ato {
    private static final Object O0000O0o = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public dbj f12605O000000o;
    public PdfiumCore O00000Oo;
    SparseBooleanArray O00000o = new SparseBooleanArray();
    public int O00000o0 = 0;
    public float O00000oO = 0.0f;
    public int[] O00000oo;
    private List<Size> O0000OOo = new ArrayList();
    private Size O0000Oo = new Size(0, 0);
    private List<dbk> O0000Oo0 = new ArrayList();
    private Size O0000OoO = new Size(0, 0);
    private dbk O0000Ooo = new dbk(0.0f, 0.0f);
    private List<Float> O0000o = new ArrayList();
    private boolean O0000o0 = true;
    private dbk O0000o00 = new dbk(0.0f, 0.0f);
    private int O0000o0O = 0;
    private boolean O0000o0o;
    private final FitPolicy O0000oO;
    private List<Float> O0000oO0 = new ArrayList();

    ato(PdfiumCore pdfiumCore, dbj dbj, FitPolicy fitPolicy, Size size, int[] iArr, boolean z, int i, boolean z2) {
        this.O00000Oo = pdfiumCore;
        this.f12605O000000o = dbj;
        this.O0000oO = fitPolicy;
        this.O00000oo = iArr;
        this.O0000o0 = z;
        this.O0000o0O = i;
        this.O0000o0o = z2;
        O00000Oo(size);
    }

    private void O00000Oo(Size size) {
        int[] iArr = this.O00000oo;
        if (iArr != null) {
            this.O00000o0 = iArr.length;
        } else {
            this.O00000o0 = this.O00000Oo.O000000o(this.f12605O000000o);
        }
        for (int i = 0; i < this.O00000o0; i++) {
            Size O00000Oo2 = this.O00000Oo.O00000Oo(this.f12605O000000o, O00000o(i));
            if (O00000Oo2.f5609O000000o > this.O0000Oo.f5609O000000o) {
                this.O0000Oo = O00000Oo2;
            }
            if (O00000Oo2.O00000Oo > this.O0000OoO.O00000Oo) {
                this.O0000OoO = O00000Oo2;
            }
            this.O0000OOo.add(O00000Oo2);
        }
        O000000o(size);
    }

    public final void O000000o(Size size) {
        this.O0000Oo0.clear();
        auj auj = new auj(this.O0000oO, this.O0000Oo, this.O0000OoO, size);
        this.O0000o00 = auj.f12623O000000o;
        this.O0000Ooo = auj.O00000Oo;
        for (Size O000000o2 : this.O0000OOo) {
            this.O0000Oo0.add(auj.O000000o(O000000o2));
        }
        if (this.O0000o0o) {
            O00000o0(size);
        }
        O00000Oo();
        O00000o0();
    }

    public final dbk O000000o(int i) {
        if (O00000o(i) < 0) {
            return new dbk(0.0f, 0.0f);
        }
        return this.O0000Oo0.get(i);
    }

    public final dbk O000000o(int i, float f) {
        dbk O000000o2 = O000000o(i);
        return new dbk(O000000o2.f14452O000000o * f, O000000o2.O00000Oo * f);
    }

    public final dbk O000000o() {
        return this.O0000o0 ? this.O0000o00 : this.O0000Ooo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    private void O00000o0(Size size) {
        float f;
        float f2;
        this.O0000oO0.clear();
        for (int i = 0; i < this.O00000o0; i++) {
            dbk dbk = this.O0000Oo0.get(i);
            if (this.O0000o0) {
                f = (float) size.O00000Oo;
                f2 = dbk.O00000Oo;
            } else {
                f = (float) size.f5609O000000o;
                f2 = dbk.f14452O000000o;
            }
            float max = Math.max(0.0f, f - f2);
            if (i < this.O00000o0 - 1) {
                max += (float) this.O0000o0O;
            }
            this.O0000oO0.add(Float.valueOf(max));
        }
    }

    private void O00000o0() {
        float f;
        float f2;
        float f3;
        this.O0000o.clear();
        float f4 = 0.0f;
        for (int i = 0; i < this.O00000o0; i++) {
            dbk dbk = this.O0000Oo0.get(i);
            if (this.O0000o0) {
                f2 = dbk.O00000Oo;
            } else {
                f2 = dbk.f14452O000000o;
            }
            if (this.O0000o0o) {
                f += this.O0000oO0.get(i).floatValue() / 2.0f;
                if (i == 0) {
                    f -= ((float) this.O0000o0O) / 2.0f;
                } else if (i == this.O00000o0 - 1) {
                    f += ((float) this.O0000o0O) / 2.0f;
                }
                this.O0000o.add(Float.valueOf(f));
                f3 = this.O0000oO0.get(i).floatValue() / 2.0f;
            } else {
                this.O0000o.add(Float.valueOf(f));
                f3 = (float) this.O0000o0O;
            }
            f4 = f + f2 + f3;
        }
    }

    public final float O00000Oo(int i, float f) {
        float f2;
        dbk O000000o2 = O000000o(i);
        if (this.O0000o0) {
            f2 = O000000o2.O00000Oo;
        } else {
            f2 = O000000o2.f14452O000000o;
        }
        return f2 * f;
    }

    private float O00000oO(int i, float f) {
        return (this.O0000o0o ? this.O0000oO0.get(i).floatValue() : (float) this.O0000o0O) * f;
    }

    public final float O00000o0(int i, float f) {
        if (O00000o(i) < 0) {
            return 0.0f;
        }
        return this.O0000o.get(i).floatValue() * f;
    }

    public final float O00000o(int i, float f) {
        float f2;
        float f3;
        dbk O000000o2 = O000000o(i);
        if (this.O0000o0) {
            f2 = O000000o().f14452O000000o;
            f3 = O000000o2.f14452O000000o;
        } else {
            f2 = O000000o().O00000Oo;
            f3 = O000000o2.O00000Oo;
        }
        return (f * (f2 - f3)) / 2.0f;
    }

    public final boolean O00000Oo(int i) throws PageRenderingException {
        int O00000o2 = O00000o(i);
        if (O00000o2 < 0) {
            return false;
        }
        synchronized (O0000O0o) {
            if (this.O00000o.indexOfKey(O00000o2) >= 0) {
                return false;
            }
            try {
                this.O00000Oo.O000000o(this.f12605O000000o, O00000o2);
                this.O00000o.put(O00000o2, true);
                return true;
            } catch (Exception e) {
                this.O00000o.put(O00000o2, false);
                throw new PageRenderingException(i, e);
            }
        }
    }

    public final int O00000o0(int i) {
        if (i <= 0) {
            return 0;
        }
        int[] iArr = this.O00000oo;
        if (iArr == null) {
            int i2 = this.O00000o0;
            if (i >= i2) {
                return i2 - 1;
            }
        } else if (i >= iArr.length) {
            return iArr.length - 1;
        }
        return i;
    }

    public final int O00000o(int i) {
        int i2;
        int[] iArr = this.O00000oo;
        if (iArr == null) {
            i2 = i;
        } else if (i < 0 || i >= iArr.length) {
            return -1;
        } else {
            i2 = iArr[i];
        }
        if (i2 < 0 || i >= this.O00000o0) {
            return -1;
        }
        return i2;
    }

    private void O00000Oo() {
        float f;
        float f2;
        float f3 = 0.0f;
        for (int i = 0; i < this.O00000o0; i++) {
            dbk dbk = this.O0000Oo0.get(i);
            if (this.O0000o0) {
                f = dbk.O00000Oo;
            } else {
                f = dbk.f14452O000000o;
            }
            f3 += f;
            if (this.O0000o0o) {
                f2 = this.O0000oO0.get(i).floatValue();
            } else if (i < this.O00000o0 - 1) {
                f2 = (float) this.O0000o0O;
            }
            f3 += f2;
        }
        this.O00000oO = f3;
    }

    public final int O000000o(float f, float f2) {
        int i = 0;
        int i2 = 0;
        while (i < this.O00000o0 && (this.O0000o.get(i).floatValue() * f2) - (O00000oO(i, f2) / 2.0f) < f) {
            i2++;
            i++;
        }
        int i3 = i2 - 1;
        if (i3 >= 0) {
            return i3;
        }
        return 0;
    }
}
