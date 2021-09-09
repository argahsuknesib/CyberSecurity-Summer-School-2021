package _m_j;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public final class cos {

    /* renamed from: O000000o  reason: collision with root package name */
    private static cod f14172O000000o;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        f14172O000000o = new cod(max, max);
    }

    public static cod O000000o(cok cok, cod cod) {
        int O000000o2 = cok.O000000o();
        if (O000000o2 <= 0) {
            O000000o2 = cod.f14165O000000o;
        }
        int O00000Oo = cok.O00000Oo();
        if (O00000Oo <= 0) {
            O00000Oo = cod.O00000Oo;
        }
        return new cod(O000000o2, O00000Oo);
    }

    /* renamed from: _m_j.cos$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14173O000000o = new int[ViewScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            f14173O000000o[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            f14173O000000o[ViewScaleType.CROP.ordinal()] = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    public static int O000000o(cod cod, cod cod2, ViewScaleType viewScaleType, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = cod.f14165O000000o;
        int i5 = cod.O00000Oo;
        int i6 = cod2.f14165O000000o;
        int i7 = cod2.O00000Oo;
        int i8 = AnonymousClass1.f14173O000000o[viewScaleType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                i = 1;
            } else if (z) {
                int i9 = i4 / 2;
                int i10 = i5 / 2;
                i3 = 1;
                while (i9 / i3 > i6 && i10 / i3 > i7) {
                    i3 *= 2;
                }
            } else {
                i = Math.min(i4 / i6, i5 / i7);
            }
            if (i <= 0) {
                i = 1;
            }
            i2 = f14172O000000o.f14165O000000o;
            int i11 = f14172O000000o.O00000Oo;
            while (true) {
                if (i4 / i > i2 && i5 / i <= i11) {
                    return i;
                }
                i = z ? i * 2 : i + 1;
            }
        } else if (z) {
            int i12 = i4 / 2;
            int i13 = i5 / 2;
            int i14 = 1;
            while (true) {
                if (i12 / i3 <= i6 && i13 / i3 <= i7) {
                    break;
                }
                i14 = i3 * 2;
            }
        } else {
            i = Math.max(i4 / i6, i5 / i7);
            if (i <= 0) {
            }
            i2 = f14172O000000o.f14165O000000o;
            int i112 = f14172O000000o.O00000Oo;
            while (true) {
                if (i4 / i > i2) {
                }
                if (z) {
                }
            }
        }
        i = i3;
        if (i <= 0) {
        }
        i2 = f14172O000000o.f14165O000000o;
        int i1122 = f14172O000000o.O00000Oo;
        while (true) {
            if (i4 / i > i2) {
            }
            if (z) {
            }
        }
    }

    public static int O000000o(cod cod) {
        int i = cod.f14165O000000o;
        int i2 = cod.O00000Oo;
        return Math.max((int) Math.ceil((double) (((float) i) / ((float) f14172O000000o.f14165O000000o))), (int) Math.ceil((double) (((float) i2) / ((float) f14172O000000o.O00000Oo))));
    }

    public static float O00000Oo(cod cod, cod cod2, ViewScaleType viewScaleType, boolean z) {
        int i = cod.f14165O000000o;
        int i2 = cod.O00000Oo;
        int i3 = cod2.f14165O000000o;
        int i4 = cod2.O00000Oo;
        float f = (float) i;
        float f2 = f / ((float) i3);
        float f3 = (float) i2;
        float f4 = f3 / ((float) i4);
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f2 < f4) && (viewScaleType != ViewScaleType.CROP || f2 >= f4)) {
            i3 = (int) (f / f4);
        } else {
            i4 = (int) (f3 / f2);
        }
        if ((z || i3 >= i || i4 >= i2) && (!z || i3 == i || i4 == i2)) {
            return 1.0f;
        }
        return ((float) i3) / f;
    }
}
