package _m_j;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public final class cp implements Interpolator {

    /* renamed from: O000000o  reason: collision with root package name */
    private final float[] f14178O000000o;
    private final float[] O00000Oo;

    private cp(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f14178O000000o = new float[i];
        this.O00000Oo = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.f14178O000000o[i2] = fArr[0];
            this.O00000Oo[i2] = fArr[1];
        }
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f14178O000000o.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f14178O000000o[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f14178O000000o;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.O00000Oo[i];
        }
        float[] fArr2 = this.O00000Oo;
        float f3 = fArr2[i];
        return f3 + (((f - fArr[i]) / f2) * (fArr2[length] - f3));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    cp(float f, float f2) {
        this(r0);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public cp(float f, float f2, float f3, float f4) {
        this(r7);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
    }
}
