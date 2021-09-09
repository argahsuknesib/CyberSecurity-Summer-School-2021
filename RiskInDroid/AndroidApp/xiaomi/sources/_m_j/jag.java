package _m_j;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;

public final class jag extends Shape {

    /* renamed from: O000000o  reason: collision with root package name */
    public RectF f1695O000000o;
    private DashPathEffect O00000Oo;
    private Path O00000o0;

    public jag(RectF rectF) {
        this(rectF, 0.0f, 0.0f);
    }

    public jag(RectF rectF, float f, float f2) {
        this.f1695O000000o = null;
        this.O00000Oo = null;
        this.O00000o0 = null;
        if (rectF.left != 0.0f || rectF.top != 0.0f || rectF.right != 0.0f || rectF.bottom != 0.0f) {
            this.f1695O000000o = rectF;
            if (f > 0.0f && f2 > 0.0f) {
                this.O00000Oo = new DashPathEffect(new float[]{f, f2}, 0.0f);
                this.O00000o0 = new Path();
            }
        }
    }

    public final void draw(Canvas canvas, Paint paint) {
        if (this.f1695O000000o != null) {
            float width = getWidth();
            float height = getHeight();
            if (this.O00000Oo == null) {
                if (this.f1695O000000o.left > 0.0f) {
                    canvas.drawRect(0.0f, 0.0f, this.f1695O000000o.left, height, paint);
                }
                if (this.f1695O000000o.top > 0.0f) {
                    canvas.drawRect(0.0f, 0.0f, width, this.f1695O000000o.top, paint);
                }
                if (this.f1695O000000o.right > 0.0f) {
                    canvas.drawRect(width - this.f1695O000000o.right, 0.0f, width, height, paint);
                }
                if (this.f1695O000000o.bottom > 0.0f) {
                    canvas.drawRect(0.0f, height - this.f1695O000000o.bottom, width, height, paint);
                    return;
                }
                return;
            }
            if (paint.getPathEffect() != this.O00000Oo) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setPathEffect(this.O00000Oo);
            }
            if (this.f1695O000000o.left > 0.0f) {
                paint.setStrokeWidth(this.f1695O000000o.left);
                O000000o(this.f1695O000000o.left / 2.0f, 0.0f, this.f1695O000000o.left / 2.0f, height);
                canvas.drawPath(this.O00000o0, paint);
            }
            if (this.f1695O000000o.top > 0.0f) {
                paint.setStrokeWidth(this.f1695O000000o.top);
                O000000o(0.0f, this.f1695O000000o.top / 2.0f, width, this.f1695O000000o.top / 2.0f);
                canvas.drawPath(this.O00000o0, paint);
            }
            if (this.f1695O000000o.right > 0.0f) {
                paint.setStrokeWidth(this.f1695O000000o.right);
                O000000o(width - (this.f1695O000000o.right / 2.0f), 0.0f, width - (this.f1695O000000o.right / 2.0f), height);
                canvas.drawPath(this.O00000o0, paint);
            }
            if (this.f1695O000000o.bottom > 0.0f) {
                paint.setStrokeWidth(this.f1695O000000o.bottom);
                O000000o(0.0f, height - (this.f1695O000000o.bottom / 2.0f), width, height - (this.f1695O000000o.bottom / 2.0f));
                canvas.drawPath(this.O00000o0, paint);
            }
        }
    }

    private void O000000o(float f, float f2, float f3, float f4) {
        this.O00000o0.reset();
        this.O00000o0.moveTo(f, f2);
        this.O00000o0.lineTo(f3, f4);
    }
}
