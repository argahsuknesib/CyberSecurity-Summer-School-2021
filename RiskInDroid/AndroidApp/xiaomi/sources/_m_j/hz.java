package _m_j;

import android.animation.TypeEvaluator;

public final class hz implements TypeEvaluator<float[]> {

    /* renamed from: O000000o  reason: collision with root package name */
    private float[] f1006O000000o;

    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        float[] fArr3 = this.f1006O000000o;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return fArr3;
    }

    public hz(float[] fArr) {
        this.f1006O000000o = fArr;
    }
}
