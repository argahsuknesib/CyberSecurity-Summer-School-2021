package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public final class czk extends Animation {

    /* renamed from: O000000o  reason: collision with root package name */
    public PointF f14409O000000o;
    public float O00000Oo;
    protected final Paint O00000o = new Paint();
    public int O00000o0;
    protected float O00000oO = 1.0f;
    protected float O00000oo = 0.4f;
    protected PointF O0000O0o;
    protected PointF O0000OOo;

    public czk(int i, PointF pointF, PointF pointF2, int i2, int i3) {
        this.O00000o0 = i;
        this.f14409O000000o = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        this.O0000O0o = new PointF(pointF.x - this.f14409O000000o.x, pointF.y - this.f14409O000000o.y);
        this.O0000OOo = new PointF(pointF2.x - this.f14409O000000o.x, pointF2.y - this.f14409O000000o.y);
        O000000o(i2);
        this.O00000o.setStrokeWidth((float) i3);
        this.O00000o.setAntiAlias(true);
        this.O00000o.setStyle(Paint.Style.STROKE);
    }

    public final void O000000o(int i) {
        this.O00000o.setColor(i);
    }

    public final void O00000Oo(int i) {
        this.O00000Oo = (float) ((-new Random().nextInt(i)) + i);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.O00000oO;
        O000000o(f2 + ((this.O00000oo - f2) * f));
    }

    public final void O000000o() {
        this.O00000oO = 1.0f;
        this.O00000oo = 0.4f;
        super.start();
    }

    public final void O000000o(float f) {
        this.O00000o.setAlpha((int) (f * 255.0f));
    }

    public final void O000000o(Canvas canvas) {
        canvas.drawLine(this.O0000O0o.x, this.O0000O0o.y, this.O0000OOo.x, this.O0000OOo.y, this.O00000o);
    }
}
