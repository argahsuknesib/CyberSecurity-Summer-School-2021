package _m_j;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;

public final class dag extends daf implements ValueAnimator.AnimatorUpdateListener, Animatable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f14416O000000o = 0;
    protected int O00000Oo = 0;
    protected ValueAnimator O00000o = ValueAnimator.ofInt(30, 3600);
    protected int O00000o0 = 0;
    protected Path O00000oO = new Path();

    public dag() {
        this.O00000o.setDuration(10000L);
        this.O00000o.setInterpolator(new LinearInterpolator());
        this.O00000o.setRepeatCount(-1);
        this.O00000o.setRepeatMode(1);
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.O00000o0 = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int max = Math.max(1, width / 20);
        if (!(this.f14416O000000o == width && this.O00000Oo == height)) {
            this.O00000oO.reset();
            float f = (float) (width - max);
            int i = height / 2;
            float f2 = (float) i;
            float f3 = (float) max;
            this.O00000oO.addCircle(f, f2, f3, Path.Direction.CW);
            float f4 = (float) (width - (max * 5));
            this.O00000oO.addRect(f4, (float) (i - max), f, (float) (i + max), Path.Direction.CW);
            this.O00000oO.addCircle(f4, f2, f3, Path.Direction.CW);
            this.f14416O000000o = width;
            this.O00000Oo = height;
        }
        canvas.save();
        float f5 = (float) (width / 2);
        float f6 = (float) (height / 2);
        canvas.rotate((float) this.O00000o0, f5, f6);
        for (int i2 = 0; i2 < 12; i2++) {
            this.O0000o00.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.O00000oO, this.O0000o00);
        }
        canvas.restore();
    }

    public final void start() {
        if (!this.O00000o.isRunning()) {
            this.O00000o.addUpdateListener(this);
            this.O00000o.start();
        }
    }

    public final void stop() {
        if (this.O00000o.isRunning()) {
            this.O00000o.removeAllListeners();
            this.O00000o.removeAllUpdateListeners();
            this.O00000o.cancel();
        }
    }

    public final boolean isRunning() {
        return this.O00000o.isRunning();
    }
}
