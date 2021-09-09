package _m_j;

import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public final class ccj extends Animation {

    /* renamed from: O000000o  reason: collision with root package name */
    public PointF f13629O000000o;
    public float O00000Oo;
    public PointF O00000o;
    public final Paint O00000o0;
    public PointF O00000oO;
    private float O00000oo;
    private float O0000O0o;

    public final void O000000o(int i) {
        this.O00000Oo = (float) ((-new Random().nextInt(i)) + i);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.O00000oo;
        O000000o(f2 + ((this.O0000O0o - f2) * f));
    }

    public final void O000000o(float f, float f2) {
        this.O00000oo = f;
        this.O0000O0o = f2;
        super.start();
    }

    public final void O000000o(float f) {
        this.O00000o0.setAlpha((int) (f * 255.0f));
    }
}
