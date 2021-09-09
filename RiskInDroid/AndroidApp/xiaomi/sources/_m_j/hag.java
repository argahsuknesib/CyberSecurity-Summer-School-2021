package _m_j;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class hag extends Animation {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Resources f18698O000000o = null;
    private float O00000Oo = 1.0f;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private int O00000oo = 0;
    private int O0000O0o = 0;
    private int O0000OOo = 0;
    private int O0000Oo = 0;
    private int O0000Oo0 = 0;
    private int O0000OoO = 0;
    private int O0000Ooo = 0;
    private float O0000o = 0.0f;
    private int O0000o0 = 0;
    private int O0000o00 = 0;
    private int O0000o0O = 0;
    private float O0000o0o = 0.0f;
    private float O0000oO;
    private float O0000oO0;

    public hag(float f) {
        this.O00000o0 = f;
        this.O00000o = 1.0f;
        this.O00000oO = f;
        this.O0000o0o = 0.5f;
        this.O0000o0 = 1;
        this.O0000o = 0.5f;
        this.O0000o0O = 1;
        if (this.O0000o0 == 0) {
            this.O0000oO0 = this.O0000o0o;
        }
        if (this.O0000o0O == 0) {
            this.O0000oO = this.O0000o;
        }
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        float f2;
        float scaleFactor = getScaleFactor();
        float f3 = 1.0f;
        if (this.O00000Oo == 1.0f && this.O00000o0 == 1.0f) {
            f2 = 1.0f;
        } else {
            float f4 = (f < 0.0f || f > 0.5f) ? 1.0f - f : f;
            float f5 = this.O00000Oo;
            f2 = f5 + ((this.O00000o0 - f5) * f4);
        }
        if (!(this.O00000o == 1.0f && this.O00000oO == 1.0f)) {
            if (f < 0.0f || f > 0.5f) {
                f = 1.0f - f;
            }
            float f6 = this.O00000o;
            f3 = ((this.O00000oO - f6) * f) + f6;
        }
        if (this.O0000oO0 == 0.0f && this.O0000oO == 0.0f) {
            transformation.getMatrix().setScale(f2, f3);
        } else {
            transformation.getMatrix().setScale(f2, f3, this.O0000oO0 * scaleFactor, scaleFactor * this.O0000oO);
        }
    }

    private float O000000o(float f, int i, int i2, int i3, int i4) {
        float f2;
        if (i == 6) {
            f2 = TypedValue.complexToFraction(i2, (float) i3, (float) i4);
        } else if (i != 5) {
            return f;
        } else {
            f2 = TypedValue.complexToDimension(i2, this.f18698O000000o.getDisplayMetrics());
        }
        if (i3 == 0) {
            return 1.0f;
        }
        return f2 / ((float) i3);
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.O00000Oo = O000000o(this.O00000Oo, this.O00000oo, this.O0000Oo, i, i3);
        this.O00000o0 = O000000o(this.O00000o0, this.O0000O0o, this.O0000OoO, i, i3);
        int i5 = i2;
        int i6 = i4;
        this.O00000o = O000000o(this.O00000o, this.O0000OOo, this.O0000Ooo, i5, i6);
        this.O00000oO = O000000o(this.O00000oO, this.O0000Oo0, this.O0000o00, i5, i6);
        this.O0000oO0 = resolveSize(this.O0000o0, this.O0000o0o, i, i3);
        this.O0000oO = resolveSize(this.O0000o0O, this.O0000o, i2, i4);
    }
}
