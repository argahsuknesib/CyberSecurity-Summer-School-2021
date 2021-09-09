package _m_j;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.List;
import java.util.Random;

public class hfi {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Bitmap f18859O000000o;
    public float O00000Oo;
    public float O00000o;
    public float O00000o0;
    public float O00000oO;
    public int O00000oo;
    public int O0000O0o;
    int O0000OOo;
    public float O0000Oo;
    public float O0000Oo0;
    public float O0000OoO;
    public float O0000Ooo;
    AccelerateInterpolator O0000o;
    public float O0000o0;
    public float O0000o00;
    public int O0000o0O;
    DecelerateInterpolator O0000o0o;
    protected long O0000oO;
    Random O0000oO0;
    int O0000oOO;
    private float O0000oOo;
    private float O0000oo;
    private float O0000oo0;
    private Matrix O0000ooO;
    private Paint O0000ooo;
    private float O000O00o;
    private long O000O0OO;
    private int O000O0Oo;
    private ValueAnimator O000O0o;
    private List<hfp> O000O0o0;
    private int O00oOoOo;
    private float O00oOooO;
    private float O00oOooo;

    private hfi(float f) {
        this.O0000oOo = 1.0f;
        this.O00000o = 1.0f;
        this.O00000oO = 1.0f;
        this.O00000oo = 255;
        this.O0000O0o = 255;
        this.O0000OOo = 100;
        this.O0000Oo0 = 0.0f;
        this.O0000Oo = 0.0f;
        this.O0000OoO = 0.0f;
        this.O0000Ooo = 0.0f;
        this.O0000o0O = 17170443;
        this.O0000ooO = new Matrix();
        this.O0000ooo = new Paint();
        this.O0000ooo.setAntiAlias(true);
        this.O0000ooo.setFilterBitmap(true);
        this.O0000oO0 = new Random();
        this.O0000o0o = new DecelerateInterpolator();
        this.O0000o = new AccelerateInterpolator();
        this.O0000OOo = (int) ((20.0f * f * this.O0000oO0.nextFloat()) + (80.0f * f));
        this.O0000oOo = f;
        this.O000O0o = new ValueAnimator();
    }

    public hfi() {
        this(1.0f);
    }

    public hfi(Bitmap bitmap, float f) {
        this(f);
        this.f18859O000000o = bitmap;
    }

    public final void O000000o() {
        this.O00000o = 1.0f;
        this.O00000oO = this.O00000o;
        this.O00000oo = 255;
        this.O0000O0o = this.O00000oo;
    }

    public final void O000000o(long j, float f, float f2) {
        long j2 = j;
        this.O000O0Oo = this.f18859O000000o.getWidth() / 2;
        this.O00oOoOo = this.f18859O000000o.getHeight() / 2;
        if (this.O0000oOO == 3) {
            float nextFloat = (((this.O0000oO0.nextFloat() - 0.5f) * 2.0f) + 10.0f) * this.O0000oOo;
            this.O00oOooO = (f - ((float) this.O000O0Oo)) + nextFloat;
            this.O00oOooo = (f2 - ((float) this.O00oOoOo)) + nextFloat;
            this.O00000Oo = this.O00oOooO;
            this.O00000o0 = this.O00oOooo;
            double nextFloat2 = (double) this.O0000oO0.nextFloat();
            Double.isNaN(nextFloat2);
            double d = (double) this.O0000oOo;
            Double.isNaN(d);
            double nextFloat3 = (double) (this.O0000oO0.nextFloat() * 2.0f);
            Double.isNaN(nextFloat3);
            double d2 = (double) this.O00oOooO;
            double d3 = (double) ((int) ((((nextFloat2 - 0.5d) * 2.0d * 40.0d) + 10.0d) * d));
            double d4 = (double) ((float) (nextFloat3 * 3.141592653589793d));
            double cos = Math.cos(d4);
            Double.isNaN(d3);
            Double.isNaN(d2);
            this.O0000oo0 = (float) (d2 + (cos * d3));
            double d5 = (double) this.O00oOooo;
            double sin = Math.sin(d4);
            Double.isNaN(d3);
            Double.isNaN(d5);
            this.O0000oo = (float) (d5 + (d3 * sin));
            if (j2 > 0) {
                long j3 = j2 / 2;
                this.O000O0OO = ((long) this.O0000oO0.nextInt((int) j3)) + j3;
                return;
            }
            this.O000O0OO = j2;
            return;
        }
        float nextFloat4 = (this.O0000oO0.nextFloat() - 0.5f) * 2.0f * this.O0000oOo * 20.0f;
        this.O00oOooO = (f - ((float) this.O000O0Oo)) + nextFloat4;
        this.O00oOooo = (f2 - ((float) this.O00oOoOo)) + nextFloat4;
        this.O00000Oo = this.O00oOooO;
        this.O00000o0 = this.O00oOooo;
        double nextFloat5 = (double) this.O0000oO0.nextFloat();
        Double.isNaN(nextFloat5);
        double d6 = (double) (((1920.0f - this.O00oOooo) / 1920.0f) * 170.0f);
        Double.isNaN(d6);
        double nextFloat6 = (double) (this.O0000oO0.nextFloat() * 2.0f);
        Double.isNaN(nextFloat6);
        double d7 = (double) this.O00oOooO;
        double d8 = (double) ((int) (((nextFloat5 - 0.5d) * 2.0d * 20.0d) + 10.0d + d6));
        double d9 = (double) ((float) (nextFloat6 * 3.141592653589793d));
        double cos2 = Math.cos(d9);
        Double.isNaN(d8);
        Double.isNaN(d7);
        this.O0000oo0 = (float) (d7 + (cos2 * d8));
        double d10 = (double) this.O00oOooo;
        double sin2 = Math.sin(d9);
        Double.isNaN(d8);
        Double.isNaN(d10);
        this.O0000oo = (float) (d10 + (d8 * sin2));
        this.O000O0OO = j2;
    }

    public boolean O000000o(long j) {
        long j2 = j - this.O0000oO;
        long j3 = this.O000O0OO;
        if (j2 > j3) {
            return false;
        }
        int i = this.O0000oOO;
        if (i == 2) {
            float f = (float) j2;
            float f2 = f * 1.0f;
            this.O00000o0 = this.O00oOooo + (this.O0000Ooo * ((float) this.O0000OOo) * this.O0000o0o.getInterpolation(f2 / ((float) (j3 + 100)))) + (this.O0000o0 * f * f);
            this.O00000Oo = this.O00oOooO + (this.O0000OoO * ((float) this.O0000OOo) * this.O0000o0o.getInterpolation(f2 / ((float) (this.O000O0OO + 100)))) + (this.O0000o00 * f * f);
            DecelerateInterpolator decelerateInterpolator = this.O0000o0o;
            long j4 = this.O000O0OO;
            this.O00000o = (decelerateInterpolator.getInterpolation((((float) (j4 - j2)) * 1.0f) / ((float) j4)) * 0.6f) + 0.2f;
        } else if (i == 4) {
            this.O00000o0 += ((((this.O0000Ooo * 1.5f) * ((float) (j3 - j2))) * 1.0f) / ((float) (j3 + 100))) + 0.0f;
            this.O00000Oo += ((((this.O0000OoO * 1.5f) * ((float) (j3 - j2))) * 1.0f) / ((float) (j3 + 100))) + 0.0f;
        } else if (i == 1) {
            this.O00000Oo = this.O0000oo0;
            this.O00000o0 = this.O0000oo;
        } else if (i == 3) {
            this.O00000Oo = this.O0000oo0;
            this.O00000o0 = this.O0000oo;
            if (this.O0000O0o > 0) {
                this.O0000O0o = (int) (this.O0000o0o.getInterpolation((((float) (j3 - j2)) * 1.0f) / ((float) j3)) * ((float) this.O00000oo));
            }
            AccelerateInterpolator accelerateInterpolator = this.O0000o;
            long j5 = this.O000O0OO;
            this.O00000oO = accelerateInterpolator.getInterpolation((((float) (j5 - j2)) * 1.0f) / ((float) j5)) * this.O00000o;
        } else {
            float f3 = (float) j2;
            this.O00000Oo = this.O00oOooO + (this.O0000OoO * f3) + (this.O0000o00 * f3 * f3);
            this.O00000o0 = this.O00oOooo + (this.O0000Ooo * f3) + (this.O0000o0 * f3 * f3);
        }
        this.O000O00o = this.O0000Oo0 + ((this.O0000Oo * ((float) j2)) / 1000.0f);
        for (int i2 = 0; i2 < this.O000O0o0.size(); i2++) {
            this.O000O0o0.get(i2).O000000o(this, j2);
        }
        return true;
    }

    public final void O000000o(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 2));
        this.O0000ooO.reset();
        this.O0000ooO.postRotate(this.O000O00o, (float) this.O000O0Oo, (float) this.O00oOoOo);
        int i = this.O0000oOO;
        if (i == 3) {
            Matrix matrix = this.O0000ooO;
            float f = this.O00000oO;
            matrix.postScale(f, f, (float) this.O000O0Oo, (float) this.O00oOoOo);
            this.O0000ooO.postTranslate(this.O00000Oo, this.O00000o0);
            this.O0000ooo.setAlpha(this.O0000O0o);
        } else if (i == 4) {
            Matrix matrix2 = this.O0000ooO;
            float f2 = this.O00000o;
            matrix2.postScale(f2, f2, (float) this.O000O0Oo, (float) this.O00oOoOo);
            this.O0000ooO.postTranslate(this.O00000Oo, this.O00000o0);
            if (this.O0000oO0.nextInt() % 2 == 0) {
                this.O0000ooo.setAlpha(this.O00000oo);
            }
        } else {
            Matrix matrix3 = this.O0000ooO;
            float f3 = this.O00000o;
            matrix3.postScale(f3, f3, (float) this.O000O0Oo, (float) this.O00oOoOo);
            this.O0000ooO.postTranslate(this.O00000Oo, this.O00000o0);
            this.O0000ooo.setAlpha(this.O00000oo);
        }
        canvas.drawBitmap(this.f18859O000000o, this.O0000ooO, this.O0000ooo);
    }

    public final hfi O000000o(long j, List<hfp> list) {
        this.O0000oO = j;
        this.O000O0o0 = list;
        return this;
    }
}
