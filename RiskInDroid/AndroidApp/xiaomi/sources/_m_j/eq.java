package _m_j;

import android.view.animation.Interpolator;

abstract class eq implements Interpolator {

    /* renamed from: O000000o  reason: collision with root package name */
    private final float[] f15718O000000o;
    private final float O00000Oo = (1.0f / ((float) (this.f15718O000000o.length - 1)));

    protected eq(float[] fArr) {
        this.f15718O000000o = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f15718O000000o;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.O00000Oo;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f15718O000000o;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
