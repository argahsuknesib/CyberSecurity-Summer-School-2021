package _m_j;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.swmansion.gesturehandler.PointerEventsConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public final class dee {
    private static final PointF O0000O0o = new PointF();
    private static final float[] O0000OOo = new float[2];
    private static final float[] O0000Oo = new float[2];
    private static final Matrix O0000Oo0 = new Matrix();
    private static final Comparator<dec> O0000OoO = new Comparator<dec>() {
        /* class _m_j.dee.AnonymousClass1 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            dec dec = (dec) obj;
            dec dec2 = (dec) obj2;
            if ((dec.O0000oO0 && dec2.O0000oO0) || (dec.O0000oO && dec2.O0000oO)) {
                return Integer.signum(dec2.O0000o - dec.O0000o);
            }
            if (dec.O0000oO0) {
                return -1;
            }
            if (dec2.O0000oO0) {
                return 1;
            }
            if (dec.O0000oO) {
                return -1;
            }
            if (dec2.O0000oO) {
                return 1;
            }
            return 0;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    final dec[] f14545O000000o = new dec[20];
    int O00000Oo = 0;
    int O00000o = 0;
    boolean O00000o0 = false;
    boolean O00000oO = false;
    public float O00000oo = 0.0f;
    private final ViewGroup O0000Ooo;
    private final dec[] O0000o = new dec[20];
    private final den O0000o0;
    private final def O0000o00;
    private final dec[] O0000o0O = new dec[20];
    private final dec[] O0000o0o = new dec[20];
    private int O0000oO = 0;
    private int O0000oO0 = 0;

    static boolean O000000o(int i) {
        return i == 3 || i == 1 || i == 5;
    }

    public dee(ViewGroup viewGroup, def def, den den) {
        this.O0000Ooo = viewGroup;
        this.O0000o00 = def;
        this.O0000o0 = den;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        if (r7 == r12.O0000Ooo) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
    public final boolean O000000o(MotionEvent motionEvent) {
        boolean z;
        this.O00000o0 = true;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            O0000Oo[0] = motionEvent.getX(actionIndex);
            O0000Oo[1] = motionEvent.getY(actionIndex);
            O00000Oo(this.O0000Ooo, O0000Oo, pointerId);
            O000000o(this.O0000Ooo, O0000Oo, pointerId);
        } else if (actionMasked == 3) {
            for (int i = this.O00000Oo - 1; i >= 0; i--) {
                this.f14545O000000o[i].O00000o0();
            }
            int i2 = this.O0000oO0;
            for (int i3 = 0; i3 < i2; i3++) {
                this.O0000o0o[i3] = this.O0000o0O[i3];
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                this.O0000o0o[i4].O00000o0();
            }
        }
        int i5 = this.O0000oO0;
        System.arraycopy(this.O0000o0O, 0, this.O0000o0o, 0, i5);
        Arrays.sort(this.O0000o0o, 0, i5, O0000OoO);
        for (int i6 = 0; i6 < i5; i6++) {
            dec dec = this.O0000o0o[i6];
            View view = dec.O00000oo;
            if (view != null) {
                if (view != this.O0000Ooo) {
                    ViewParent parent = view.getParent();
                    while (parent != null && parent != this.O0000Ooo) {
                        parent = parent.getParent();
                    }
                }
                z = true;
                if (z) {
                    dec.O00000o0();
                } else {
                    if ((!dec.O0000Oo0 || dec.O0000O0o == 1 || dec.O0000O0o == 3 || dec.O0000O0o == 5 || dec.O00000o <= 0) ? false : true) {
                        int actionMasked2 = motionEvent.getActionMasked();
                        if (!dec.O0000oO || actionMasked2 != 2) {
                            float[] fArr = O0000Oo;
                            O000000o(dec.O00000oo, motionEvent, fArr);
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            motionEvent.setLocation(fArr[0], fArr[1]);
                            dec.O00000Oo(motionEvent);
                            if (dec.O0000oO0 && dec.O0000o0O != null) {
                                dec.O0000o0O.O000000o(dec, motionEvent);
                            }
                            motionEvent.setLocation(x, y);
                            if (actionMasked2 == 1 || actionMasked2 == 6) {
                                int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
                                if (dec.O00000o0[pointerId2] != -1) {
                                    dec.O00000o0[pointerId2] = -1;
                                    dec.O00000o--;
                                }
                            }
                        }
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        this.O00000o0 = false;
        if (this.O00000oO && this.O00000o == 0) {
            O000000o();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        boolean z = false;
        for (int i = this.O0000oO0 - 1; i >= 0; i--) {
            dec dec = this.O0000o0O[i];
            if (O000000o(dec.O0000O0o) && !dec.O0000oO) {
                this.O0000o0O[i] = null;
                dec.O0000Oo0();
                dec.O0000oO0 = false;
                dec.O0000oO = false;
                dec.O0000o = Integer.MAX_VALUE;
                z = true;
            }
        }
        if (z) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.O0000oO0; i3++) {
                dec[] decArr = this.O0000o0O;
                if (decArr[i3] != null) {
                    decArr[i2] = decArr[i3];
                    i2++;
                }
            }
            this.O0000oO0 = i2;
        }
        this.O00000oO = false;
    }

    private boolean O00000Oo(dec dec) {
        for (int i = 0; i < this.O0000oO0; i++) {
            dec dec2 = this.O0000o0O[i];
            if (!O000000o(dec2.O0000O0o) && O000000o(dec, dec2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dec dec) {
        if (O00000Oo(dec)) {
            O00000o(dec);
            return;
        }
        O00000o0(dec);
        dec.O0000oO = false;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        int i = 0;
        for (int i2 = 0; i2 < this.O00000Oo; i2++) {
            if (this.f14545O000000o[i2].O0000oO) {
                dec[] decArr = this.f14545O000000o;
                decArr[i] = decArr[i2];
                i++;
            }
        }
        this.O00000Oo = i;
    }

    private void O000000o(View view, MotionEvent motionEvent, float[] fArr) {
        if (view == this.O0000Ooo) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
        } else if (view == null || !(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Parent is null? View is no longer in the tree");
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            O000000o(viewGroup, motionEvent, fArr);
            PointF pointF = O0000O0o;
            O000000o(fArr[0], fArr[1], viewGroup, view, pointF);
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
        }
    }

    private void O00000o(dec dec) {
        int i = 0;
        while (true) {
            int i2 = this.O00000Oo;
            if (i >= i2) {
                dec[] decArr = this.f14545O000000o;
                if (i2 < decArr.length) {
                    this.O00000Oo = i2 + 1;
                    decArr[i2] = dec;
                    dec.O0000oO = true;
                    int i3 = this.O0000oO;
                    this.O0000oO = i3 + 1;
                    dec.O0000o = i3;
                    return;
                }
                throw new IllegalStateException("Too many recognizers");
            } else if (this.f14545O000000o[i] != dec) {
                i++;
            } else {
                return;
            }
        }
    }

    private boolean O000000o(View view, float[] fArr, int i) {
        ArrayList<dec> O000000o2 = this.O0000o00.O000000o(view);
        if (O000000o2 == null) {
            return false;
        }
        int size = O000000o2.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            dec dec = O000000o2.get(i2);
            if (dec.O0000Oo0 && dec.O000000o(view, fArr[0], fArr[1])) {
                int i3 = 0;
                while (true) {
                    int i4 = this.O0000oO0;
                    if (i3 < i4) {
                        if (this.O0000o0O[i3] == dec) {
                            break;
                        }
                        i3++;
                    } else {
                        dec[] decArr = this.O0000o0O;
                        if (i4 < decArr.length) {
                            this.O0000oO0 = i4 + 1;
                            decArr[i4] = dec;
                            dec.O0000oO0 = false;
                            dec.O0000oO = false;
                            dec.O0000o = Integer.MAX_VALUE;
                            if (dec.O00000oo == null && dec.O0000o0 == null) {
                                Arrays.fill(dec.O00000o0, -1);
                                dec.O00000o = 0;
                                dec.O0000O0o = 0;
                                dec.O00000oo = view;
                                dec.O0000o0 = this;
                            } else {
                                throw new IllegalStateException("Already prepared or hasn't been reset");
                            }
                        } else {
                            throw new IllegalStateException("Too many recognizers");
                        }
                    }
                }
                dec.O000000o(i);
                z = true;
            }
        }
        return z;
    }

    private boolean O000000o(ViewGroup viewGroup, float[] fArr, int i) {
        boolean z;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View O000000o2 = this.O0000o0.O000000o(viewGroup, childCount);
            if (O000000o(O000000o2)) {
                PointF pointF = O0000O0o;
                O000000o(fArr[0], fArr[1], viewGroup, O000000o2, pointF);
                float f = fArr[0];
                float f2 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                if (!O00000Oo(O000000o2) || O000000o(fArr[0], fArr[1], O000000o2)) {
                    z = O00000Oo(O000000o2, fArr, i);
                } else {
                    z = false;
                }
                fArr[0] = f;
                fArr[1] = f2;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean O000000o(View view, float[] fArr) {
        return (!(view instanceof ViewGroup) || view.getBackground() != null) && O000000o(fArr[0], fArr[1], view);
    }

    private boolean O00000Oo(View view, float[] fArr, int i) {
        PointerEventsConfig O000000o2 = this.O0000o0.O000000o(view);
        if (O000000o2 == PointerEventsConfig.NONE) {
            return false;
        }
        if (O000000o2 == PointerEventsConfig.BOX_ONLY) {
            if (O000000o(view, fArr, i) || O000000o(view, fArr)) {
                return true;
            }
            return false;
        } else if (O000000o2 == PointerEventsConfig.BOX_NONE) {
            if (view instanceof ViewGroup) {
                return O000000o((ViewGroup) view, fArr, i);
            }
            return false;
        } else if (O000000o2 == PointerEventsConfig.AUTO) {
            boolean O000000o3 = view instanceof ViewGroup ? O000000o((ViewGroup) view, fArr, i) : false;
            if (O000000o(view, fArr, i) || O000000o3 || O000000o(view, fArr)) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("Unknown pointer event type: " + O000000o2.toString());
        }
    }

    private boolean O000000o(View view) {
        return view.getVisibility() == 0 && view.getAlpha() >= this.O00000oo;
    }

    private static void O000000o(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        float scrollY = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = O0000OOo;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = O0000Oo0;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            float f3 = fArr[0];
            scrollY = fArr[1];
            scrollX = f3;
        }
        pointF.set(scrollX, scrollY);
    }

    private boolean O00000Oo(View view) {
        return !(view instanceof ViewGroup) || this.O0000o0.O000000o((ViewGroup) view);
    }

    private static boolean O000000o(float f, float f2, View view) {
        return f >= 0.0f && f <= ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    static boolean O000000o(dec dec, dec dec2) {
        if (dec != dec2) {
            return dec.O00000o0(dec2) || dec2.O00000Oo(dec);
        }
        return false;
    }

    private static boolean O00000Oo(dec dec, dec dec2) {
        return dec == dec2 || dec.O00000o(dec2) || dec2.O00000o(dec);
    }

    private static boolean O00000o0(dec dec, dec dec2) {
        if (!dec.O000000o(dec2) || O00000Oo(dec, dec2)) {
            return false;
        }
        if (dec == dec2) {
            return true;
        }
        if (dec.O0000oO || dec.O0000O0o == 4) {
            return dec.O00000oO(dec2);
        }
        return true;
    }

    private void O00000o0(dec dec) {
        int i = dec.O0000O0o;
        dec.O0000oO = false;
        dec.O0000oO0 = true;
        int i2 = this.O0000oO;
        this.O0000oO = i2 + 1;
        dec.O0000o = i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.O0000oO0; i4++) {
            dec dec2 = this.O0000o0O[i4];
            if (O00000o0(dec2, dec)) {
                this.O0000o[i3] = dec2;
                i3++;
            }
        }
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            this.O0000o[i5].O00000o0();
        }
        for (int i6 = this.O00000Oo - 1; i6 >= 0; i6--) {
            dec dec3 = this.f14545O000000o[i6];
            if (O00000o0(dec3, dec)) {
                dec3.O00000o0();
                dec3.O0000oO = false;
            }
        }
        O00000Oo();
        dec.O000000o(4, 2);
        if (i != 4) {
            dec.O000000o(5, 4);
            if (i != 5) {
                dec.O000000o(0, 5);
            }
        }
    }
}
