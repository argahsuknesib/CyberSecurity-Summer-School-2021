package _m_j;

import _m_j.dec;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;

public class dec<T extends dec> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f14544O000000o = 11;
    private static MotionEvent.PointerProperties[] O00000Oo;
    private static MotionEvent.PointerCoords[] O0000oOO;
    int O00000o = 0;
    final int[] O00000o0 = new int[f14544O000000o];
    public int O00000oO;
    public View O00000oo;
    public int O0000O0o = 0;
    public boolean O0000OOo;
    public float O0000Oo;
    boolean O0000Oo0 = true;
    public float O0000OoO;
    public boolean O0000Ooo;
    int O0000o;
    dee O0000o0;
    public int O0000o00 = 0;
    public dei<T> O0000o0O;
    public ded O0000o0o;
    boolean O0000oO;
    boolean O0000oO0;
    private float O0000oOo;
    private float[] O0000oo;
    private float O0000oo0;
    private float O0000ooO;
    private float O0000ooo;

    /* access modifiers changed from: protected */
    public void O000000o() {
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
    }

    /* access modifiers changed from: protected */
    public void O0000OOo() {
    }

    private static boolean O000000o(float f) {
        return !Float.isNaN(f);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2) {
        dei<T> dei = this.O0000o0O;
        if (dei != null) {
            dei.O000000o(this, i, i2);
        }
    }

    public final boolean O000000o(dec dec) {
        int i = 0;
        while (true) {
            int[] iArr = this.O00000o0;
            if (i >= iArr.length) {
                return false;
            }
            if (iArr[i] != -1 && dec.O00000o0[i] != -1) {
                return true;
            }
            i++;
        }
    }

    public final T O000000o(boolean z) {
        if (this.O00000oo != null) {
            O00000o0();
        }
        this.O0000Oo0 = z;
        return this;
    }

    public final T O000000o(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.O0000oo == null) {
            this.O0000oo = new float[6];
        }
        float[] fArr = this.O0000oo;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        if (O000000o(f5) && O000000o(f) && O000000o(f3)) {
            throw new IllegalArgumentException("Cannot have all of left, right and width defined");
        } else if (O000000o(f5) && !O000000o(f) && !O000000o(f3)) {
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
        } else if (O000000o(f6) && O000000o(f4) && O000000o(f2)) {
            throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
        } else if (!O000000o(f6) || O000000o(f4) || O000000o(f2)) {
            return this;
        } else {
            throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
        }
    }

    public final void O000000o(int i) {
        int[] iArr = this.O00000o0;
        if (iArr[i] == -1) {
            int i2 = 0;
            while (i2 < this.O00000o) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.O00000o0;
                    if (i3 < iArr2.length && iArr2[i3] != i2) {
                        i3++;
                    }
                }
                if (i3 == this.O00000o0.length) {
                    break;
                }
                i2++;
            }
            iArr[i] = i2;
            this.O00000o++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    public final void O00000Oo(MotionEvent motionEvent) {
        int i;
        boolean z;
        MotionEvent motionEvent2;
        int i2;
        int i3;
        int pointerCount;
        MotionEvent motionEvent3 = motionEvent;
        if (this.O0000Oo0 && (i = this.O0000O0o) != 3 && i != 1) {
            int i4 = 5;
            if (i != 5 && this.O00000o > 0) {
                if (motionEvent.getPointerCount() == this.O00000o) {
                    int i5 = 0;
                    while (true) {
                        int[] iArr = this.O00000o0;
                        if (i5 < iArr.length) {
                            if (iArr[i5] != -1 && iArr[i5] != i5) {
                                break;
                            }
                            i5++;
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        motionEvent2 = motionEvent3;
                    } else {
                        int actionMasked = motionEvent.getActionMasked();
                        if (actionMasked == 0 || actionMasked == 5) {
                            i2 = motionEvent.getActionIndex();
                            if (this.O00000o0[motionEvent3.getPointerId(i2)] != -1) {
                                if (this.O00000o == 1) {
                                    i4 = 0;
                                }
                                if (O00000Oo == null) {
                                    int i6 = f14544O000000o;
                                    O00000Oo = new MotionEvent.PointerProperties[i6];
                                    O0000oOO = new MotionEvent.PointerCoords[i6];
                                }
                                for (i3 = this.O00000o; i3 > 0; i3--) {
                                    MotionEvent.PointerProperties[] pointerPropertiesArr = O00000Oo;
                                    int i7 = i3 - 1;
                                    if (pointerPropertiesArr[i7] != null) {
                                        break;
                                    }
                                    pointerPropertiesArr[i7] = new MotionEvent.PointerProperties();
                                    O0000oOO[i7] = new MotionEvent.PointerCoords();
                                }
                                float x = motionEvent.getX();
                                float y = motionEvent.getY();
                                motionEvent3.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                pointerCount = motionEvent.getPointerCount();
                                int i8 = i4;
                                int i9 = 0;
                                for (int i10 = 0; i10 < pointerCount; i10++) {
                                    int pointerId = motionEvent3.getPointerId(i10);
                                    if (this.O00000o0[pointerId] != -1) {
                                        motionEvent3.getPointerProperties(i10, O00000Oo[i9]);
                                        O00000Oo[i9].id = this.O00000o0[pointerId];
                                        motionEvent3.getPointerCoords(i10, O0000oOO[i9]);
                                        if (i10 == i2) {
                                            i8 |= i9 << 8;
                                        }
                                        i9++;
                                    }
                                }
                                motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i8, i9, O00000Oo, O0000oOO, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                motionEvent3.setLocation(x, y);
                                motionEvent2.setLocation(x, y);
                            }
                        } else {
                            i4 = 6;
                            if (actionMasked == 1 || actionMasked == 6) {
                                i2 = motionEvent.getActionIndex();
                                if (this.O00000o0[motionEvent3.getPointerId(i2)] != -1) {
                                    if (this.O00000o == 1) {
                                        i4 = 1;
                                    }
                                    if (O00000Oo == null) {
                                    }
                                    while (i3 > 0) {
                                    }
                                    float x2 = motionEvent.getX();
                                    float y2 = motionEvent.getY();
                                    motionEvent3.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                    pointerCount = motionEvent.getPointerCount();
                                    int i82 = i4;
                                    int i92 = 0;
                                    while (i10 < pointerCount) {
                                    }
                                    motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i82, i92, O00000Oo, O0000oOO, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                    motionEvent3.setLocation(x2, y2);
                                    motionEvent2.setLocation(x2, y2);
                                }
                            } else {
                                i4 = actionMasked;
                                i2 = -1;
                                if (O00000Oo == null) {
                                }
                                while (i3 > 0) {
                                }
                                float x22 = motionEvent.getX();
                                float y22 = motionEvent.getY();
                                motionEvent3.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                pointerCount = motionEvent.getPointerCount();
                                int i822 = i4;
                                int i922 = 0;
                                while (i10 < pointerCount) {
                                }
                                motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i822, i922, O00000Oo, O0000oOO, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                motionEvent3.setLocation(x22, y22);
                                motionEvent2.setLocation(x22, y22);
                            }
                        }
                        i4 = 2;
                        if (O00000Oo == null) {
                        }
                        while (i3 > 0) {
                        }
                        float x222 = motionEvent.getX();
                        float y222 = motionEvent.getY();
                        motionEvent3.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                        pointerCount = motionEvent.getPointerCount();
                        int i8222 = i4;
                        int i9222 = 0;
                        while (i10 < pointerCount) {
                        }
                        motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i8222, i9222, O00000Oo, O0000oOO, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                        motionEvent3.setLocation(x222, y222);
                        motionEvent2.setLocation(x222, y222);
                    }
                    this.O0000oOo = motionEvent2.getX();
                    this.O0000oo0 = motionEvent2.getY();
                    this.O0000o00 = motionEvent2.getPointerCount();
                    this.O0000OOo = O000000o(this.O00000oo, this.O0000oOo, this.O0000oo0);
                    if (this.O0000Ooo || this.O0000OOo) {
                        this.O0000Oo = deg.O000000o(motionEvent2, true);
                        this.O0000OoO = deg.O00000Oo(motionEvent2, true);
                        this.O0000ooO = motionEvent2.getRawX() - motionEvent2.getX();
                        this.O0000ooo = motionEvent2.getRawY() - motionEvent2.getY();
                        O000000o(motionEvent2);
                        if (motionEvent2 == motionEvent3) {
                            motionEvent2.recycle();
                            return;
                        }
                        return;
                    }
                    int i11 = this.O0000O0o;
                    if (i11 == 4) {
                        O00000o0();
                        return;
                    } else if (i11 == 2) {
                        O00000o();
                        return;
                    } else {
                        return;
                    }
                }
                z = true;
                if (z) {
                }
                this.O0000oOo = motionEvent2.getX();
                this.O0000oo0 = motionEvent2.getY();
                this.O0000o00 = motionEvent2.getPointerCount();
                this.O0000OOo = O000000o(this.O00000oo, this.O0000oOo, this.O0000oo0);
                if (this.O0000Ooo) {
                }
                this.O0000Oo = deg.O000000o(motionEvent2, true);
                this.O0000OoO = deg.O00000Oo(motionEvent2, true);
                this.O0000ooO = motionEvent2.getRawX() - motionEvent2.getX();
                this.O0000ooo = motionEvent2.getRawY() - motionEvent2.getY();
                O000000o(motionEvent2);
                if (motionEvent2 == motionEvent3) {
                }
            }
        }
    }

    private void O00000Oo(int i) {
        int i2 = this.O0000O0o;
        if (i2 != i) {
            this.O0000O0o = i;
            dee dee = this.O0000o0;
            dee.O00000o++;
            if (dee.O000000o(i)) {
                for (int i3 = 0; i3 < dee.O00000Oo; i3++) {
                    dec dec = dee.f14545O000000o[i3];
                    if (dee.O000000o(dec, this)) {
                        if (i == 5) {
                            dec.O00000o0();
                            dec.O0000oO = false;
                        } else {
                            dee.O000000o(dec);
                        }
                    }
                }
                dee.O00000Oo();
            }
            if (i == 4) {
                dee.O000000o(this);
            } else if (!(i2 == 4 || i2 == 5) || this.O0000oO0) {
                O000000o(i, i2);
            }
            dee.O00000o--;
            if (dee.O00000o0 || dee.O00000o != 0) {
                dee.O00000oO = true;
            } else {
                dee.O000000o();
            }
            O0000OOo();
        }
    }

    public boolean O00000Oo(dec dec) {
        if (dec == this || this.O0000o0o != null) {
        }
        return false;
    }

    public final boolean O00000o0(dec dec) {
        ded ded;
        if (dec == this || (ded = this.O0000o0o) == null) {
            return false;
        }
        return ded.O000000o(this, dec);
    }

    public boolean O00000o(dec dec) {
        if (dec == this) {
            return true;
        }
        ded ded = this.O0000o0o;
        if (ded != null) {
            return ded.O00000Oo(this, dec);
        }
        return false;
    }

    public boolean O00000oO(dec dec) {
        if (!(dec == this || this.O0000o0o == null)) {
        }
        return false;
    }

    public final boolean O000000o(View view, float f, float f2) {
        float f3;
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        float[] fArr = this.O0000oo;
        float f4 = 0.0f;
        if (fArr != null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[2];
            float f8 = fArr[3];
            f3 = O000000o(f5) ? 0.0f - f5 : 0.0f;
            if (O000000o(f6)) {
                f4 = 0.0f - f8;
            }
            if (O000000o(f7)) {
                width += f7;
            }
            if (O000000o(f8)) {
                height += f8;
            }
            float[] fArr2 = this.O0000oo;
            float f9 = fArr2[4];
            float f10 = fArr2[5];
            if (O000000o(f9)) {
                if (!O000000o(f5)) {
                    f3 = width - f9;
                } else if (!O000000o(f7)) {
                    width = f9 + f3;
                }
            }
            if (O000000o(f10)) {
                if (!O000000o(f4)) {
                    f4 = height - f10;
                } else if (!O000000o(height)) {
                    height = f4 + f10;
                }
            }
        } else {
            f3 = 0.0f;
        }
        return f >= f3 && f <= width && f2 >= f4 && f2 <= height;
    }

    public final void O00000o0() {
        int i = this.O0000O0o;
        if (i == 4 || i == 0 || i == 2) {
            O000000o();
            O00000Oo(3);
        }
    }

    public final void O00000o() {
        int i = this.O0000O0o;
        if (i == 4 || i == 0 || i == 2) {
            O00000Oo(1);
        }
    }

    public final void O00000oO() {
        int i = this.O0000O0o;
        if (i == 0 || i == 2) {
            O00000Oo(4);
        }
    }

    public final void O00000oo() {
        if (this.O0000O0o == 0) {
            O00000Oo(2);
        }
    }

    public final void O0000O0o() {
        int i = this.O0000O0o;
        if (i == 2 || i == 4) {
            O00000Oo(5);
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o(MotionEvent motionEvent) {
        O00000Oo(1);
    }

    public final void O0000Oo0() {
        this.O00000oo = null;
        this.O0000o0 = null;
        Arrays.fill(this.O00000o0, -1);
        this.O00000o = 0;
        O00000Oo();
    }

    public String toString() {
        View view = this.O00000oo;
        String simpleName = view == null ? null : view.getClass().getSimpleName();
        return getClass().getSimpleName() + "@[" + this.O00000oO + "]:" + simpleName;
    }

    public final float O0000Oo() {
        return this.O0000Oo - this.O0000ooO;
    }

    public final float O0000OoO() {
        return this.O0000OoO - this.O0000ooo;
    }
}
