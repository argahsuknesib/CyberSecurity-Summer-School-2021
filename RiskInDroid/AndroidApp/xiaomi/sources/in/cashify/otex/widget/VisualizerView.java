package in.cashify.otex.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.xiaomi.smarthome.R;

public class VisualizerView extends SurfaceView {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12283O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public final Paint O0000O0o = new Paint();
    public final Paint O0000OOo = new Paint();
    public float O0000Oo;
    public final Paint O0000Oo0 = new Paint();
    public float O0000OoO;

    public enum a {
        BAR(1),
        PIXEL(2),
        FADE(4);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f12284a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f12284a = i;
        }

        public final int a() {
            return this.f12284a;
        }
    }

    private void O000000o(Canvas canvas, int i) {
        RectF rectF;
        int i2 = this.f12283O000000o / 3;
        int i3 = i2 * 2;
        while (i2 <= i3) {
            float O00000Oo2 = O00000Oo(i);
            float f = this.O0000Oo;
            float f2 = this.O0000OoO;
            float f3 = (((float) i2) * f) + f2;
            i2++;
            float f4 = (((float) i2) * f) - f2;
            int i4 = (int) (O00000Oo2 / (f4 - f3));
            if (i4 == 0) {
                i4 = 1;
            }
            float f5 = O00000Oo2 / ((float) i4);
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    int i6 = this.O00000oO;
                    if (i6 == 0) {
                        float f6 = ((float) this.O00000oo) - (((float) i5) * f5);
                        rectF = new RectF(f3, (f6 - f5) + this.O0000OoO, f4, f6);
                    } else if (i6 == 1) {
                        float f7 = ((float) this.O00000oo) + (((float) i5) * f5);
                        rectF = new RectF(f3, f7, f4, (f7 + f5) - this.O0000OoO);
                    } else if (i6 == 2) {
                        float f8 = (((float) this.O00000oo) - (O00000Oo2 / 2.0f)) + (((float) i5) * f5);
                        rectF = new RectF(f3, (f8 - f5) + this.O0000OoO, f4, f8);
                    } else {
                        return;
                    }
                    canvas.drawRect(rectF, this.O0000O0o);
                    i5++;
                }
            }
        }
    }

    private float O00000Oo(int i) {
        int i2;
        double random = Math.random();
        double d = (double) i;
        Double.isNaN(d);
        double d2 = (random * d) + 1.0d;
        float height = (float) getHeight();
        int i3 = this.O00000oO;
        if (i3 == 0) {
            i2 = this.O00000oo;
        } else if (i3 != 1) {
            if (i3 == 2) {
                i2 = getHeight();
            }
            return (height / 100.0f) * ((float) d2);
        } else {
            i2 = getHeight() - this.O00000oo;
        }
        height = (float) i2;
        return (height / 100.0f) * ((float) d2);
    }

    public void setBaseY(int i) {
        this.O00000oo = i;
    }

    public VisualizerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.backColor, R.attr.numColumns, R.attr.renderColor, R.attr.renderRange, R.attr.renderType});
        this.f12283O000000o = obtainStyledAttributes.getInteger(1, 20);
        this.O00000Oo = obtainStyledAttributes.getColor(2, -1);
        this.O00000o = obtainStyledAttributes.getInt(4, a.BAR.a());
        this.O00000oO = obtainStyledAttributes.getInteger(3, 2);
        this.O00000o0 = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        this.O0000O0o.setColor(this.O00000Oo);
        this.O0000O0o.setStrokeWidth(1.0f);
        this.O0000OOo.setColor(this.O00000o0);
        this.O0000Oo0.setColor(Color.argb(138, 255, 255, 255));
    }

    public final synchronized void O000000o(int i) {
        RectF rectF;
        if (this.f12283O000000o > getWidth()) {
            this.f12283O000000o = 20;
        }
        this.O0000Oo = ((float) getWidth()) / ((float) this.f12283O000000o);
        this.O0000OoO = this.O0000Oo / 8.0f;
        if (this.O00000oo == 0) {
            this.O00000oo = getHeight() / 2;
        }
        Canvas lockCanvas = getHolder().lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.O0000OOo);
            if (i <= 0) {
                float height = (float) (getHeight() >> 1);
                lockCanvas.drawLine(0.0f, height, (float) getWidth(), height, this.O0000O0o);
            }
            int i2 = this.O00000o;
            if (lockCanvas != null) {
                if ((a.BAR.a() & i2) != 0) {
                    int i3 = this.f12283O000000o / 3;
                    int i4 = i3 * 2;
                    while (i3 <= i4) {
                        float O00000Oo2 = O00000Oo(i);
                        float f = this.O0000Oo;
                        float f2 = this.O0000OoO;
                        float f3 = (((float) i3) * f) + f2;
                        i3++;
                        float f4 = (((float) i3) * f) - f2;
                        int i5 = this.O00000oO;
                        if (i5 == 0) {
                            float f5 = (float) this.O00000oo;
                            rectF = new RectF(f3, f5 - O00000Oo2, f4, f5);
                        } else if (i5 == 1) {
                            float f6 = (float) this.O00000oo;
                            rectF = new RectF(f3, f6, f4, O00000Oo2 + f6);
                        } else if (i5 != 2) {
                            float f7 = (float) this.O00000oo;
                            rectF = new RectF(f3, f7 - O00000Oo2, f4, f7);
                        } else {
                            float f8 = (float) this.O00000oo;
                            rectF = new RectF(f3, f8 - O00000Oo2, f4, f8 + O00000Oo2);
                        }
                        lockCanvas.drawRect(rectF, this.O0000O0o);
                    }
                }
                if ((a.PIXEL.a() & i2) != 0) {
                    O000000o(lockCanvas, i);
                }
            }
            getHolder().unlockCanvasAndPost(lockCanvas);
        }
    }
}
