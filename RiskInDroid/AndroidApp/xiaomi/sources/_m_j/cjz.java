package _m_j;

import android.view.View;
import java.lang.ref.WeakReference;

public final class cjz {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13960O000000o;
    public int O00000Oo;
    public int O00000o = 0;
    public int O00000o0;
    private WeakReference<View> O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo0;

    public cjz(View view) {
        this.O00000oO = new WeakReference<>(view);
    }

    public final void O000000o(int i, int i2) {
        this.O00000oo = i;
        this.O0000O0o = i2;
    }

    public final void O00000Oo(int i, int i2) {
        this.O0000OOo = i;
        this.O0000Oo0 = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        if (r4 != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ae, code lost:
        if (r4 != false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        r12 = (int) (r0 / r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        r11 = (int) (r3 * r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f4, code lost:
        if (r1 > r11) goto L_0x0114;
     */
    public final void O00000o0(int i, int i2) {
        int i3;
        float f;
        int i4;
        int i5 = this.f13960O000000o;
        if (i5 == 90 || i5 == 270) {
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int defaultSize = View.getDefaultSize(this.O00000oo, i);
        int defaultSize2 = View.getDefaultSize(this.O0000O0o, i2);
        if (this.O00000o != 3) {
            if (this.O00000oo <= 0 || this.O0000O0o <= 0) {
                i = defaultSize;
                i2 = defaultSize2;
            } else {
                int mode = View.MeasureSpec.getMode(i);
                i = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f2 = (float) i;
                    float f3 = (float) i2;
                    float f4 = f2 / f3;
                    int i7 = this.O00000o;
                    if (i7 == 4) {
                        int i8 = this.f13960O000000o;
                        f = (i8 == 90 || i8 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i7 != 5) {
                        f = ((float) this.O00000oo) / ((float) this.O0000O0o);
                        int i9 = this.O0000OOo;
                        if (i9 > 0 && (i4 = this.O0000Oo0) > 0) {
                            f = (f * ((float) i9)) / ((float) i4);
                        }
                    } else {
                        int i10 = this.f13960O000000o;
                        f = (i10 == 90 || i10 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z = f > f4;
                    int i11 = this.O00000o;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (!(i11 == 4 || i11 == 5)) {
                                if (z) {
                                    i = Math.min(this.O00000oo, i);
                                    i2 = (int) (((float) i) / f);
                                } else {
                                    i2 = Math.min(this.O0000O0o, i2);
                                    i = (int) (((float) i2) * f);
                                }
                            }
                        }
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i12 = this.O00000oo;
                    int i13 = i12 * i2;
                    int i14 = this.O0000O0o;
                    if (i13 < i * i14) {
                        i = (i12 * i2) / i14;
                    } else if (i12 * i2 > i * i14) {
                        i2 = (i14 * i) / i12;
                    }
                } else if (mode == 1073741824) {
                    int i15 = (this.O0000O0o * i) / this.O00000oo;
                    if (mode2 != Integer.MIN_VALUE || i15 <= i2) {
                        i2 = i15;
                    }
                } else {
                    if (mode2 == 1073741824) {
                        i3 = (this.O00000oo * i2) / this.O0000O0o;
                        if (mode == Integer.MIN_VALUE) {
                        }
                    } else {
                        i3 = this.O00000oo;
                        int i16 = this.O0000O0o;
                        if (mode2 != Integer.MIN_VALUE || i16 <= i2) {
                            i2 = i16;
                        } else {
                            i3 = (i3 * i2) / i16;
                        }
                        if (mode == Integer.MIN_VALUE && i3 > i) {
                            i2 = (this.O0000O0o * i) / this.O00000oo;
                        }
                    }
                    i = i3;
                }
            }
        }
        this.O00000Oo = i;
        this.O00000o0 = i2;
    }
}
