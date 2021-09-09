package _m_j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.view.View;

public final class dqh extends View implements dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Paint f14850O000000o = new Paint();
    protected dqf O00000Oo;

    public dqh(Context context, dqf dqf) {
        super(context);
        this.O00000Oo = dqf;
    }

    public final void setColor(int i) {
        this.f14850O000000o.setColor(i);
    }

    public final void O000000o(int i, int i2, int i3) {
        this.f14850O000000o.setStrokeWidth((float) i2);
        this.f14850O000000o.setColor(i);
        this.f14850O000000o.setAntiAlias(true);
        if (i3 == 1) {
            this.f14850O000000o.setStyle(Paint.Style.FILL);
        } else if (i3 == 2) {
            this.f14850O000000o.setStyle(Paint.Style.STROKE);
            this.f14850O000000o.setPathEffect(new DashPathEffect(this.O00000Oo.O000o0O0, 1.0f));
            setLayerType(1, null);
        }
    }

    public final void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public final int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    public final void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        float strokeWidth;
        float strokeWidth2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.O00000Oo.O000O0oo().f14826O000000o;
        int i4 = this.O00000Oo.O000O0oo().O00000Oo;
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                if (i3 != -1) {
                    if (i3 == -2) {
                        strokeWidth2 = Math.min((float) size, this.f14850O000000o.getStrokeWidth());
                    }
                    size = i3;
                }
            } else if (mode != 0) {
                size = 0;
            } else if (i3 != -1) {
                if (i3 == -2) {
                    strokeWidth2 = this.f14850O000000o.getStrokeWidth();
                }
                size = i3;
            }
            size = (int) strokeWidth2;
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                if (i4 != -1) {
                    if (i4 == -2) {
                        strokeWidth = Math.min((float) size2, this.f14850O000000o.getStrokeWidth());
                    }
                    size2 = i4;
                }
            } else if (mode2 != 0) {
                size2 = 0;
            } else if (i4 != -1) {
                if (i4 == -2) {
                    strokeWidth = this.f14850O000000o.getStrokeWidth();
                }
                size2 = i4;
            }
            size2 = (int) strokeWidth;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int comMeasuredHeight = getComMeasuredHeight();
        dov.O00000Oo(canvas, this.O00000Oo.O0000Oo(), measuredWidth, comMeasuredHeight, 0, 0, 0, 0, 0);
        int strokeWidth = (int) this.f14850O000000o.getStrokeWidth();
        int O0000o0o = this.O00000Oo.O0000o0o();
        if (this.O00000Oo.O00000Oo()) {
            float f = (float) ((O0000o0o & 32) != 0 ? comMeasuredHeight >> 1 : (O0000o0o & 16) != 0 ? comMeasuredHeight - (strokeWidth >> 1) : strokeWidth >> 1);
            canvas.drawLine((float) this.O00000Oo.O00oOoOo(), f, (float) (measuredWidth - this.O00000Oo.O000O0o()), f, this.f14850O000000o);
            return;
        }
        float f2 = (float) ((O0000o0o & 4) != 0 ? measuredWidth >> 1 : (O0000o0o & 2) != 0 ? measuredWidth - (strokeWidth >> 1) : strokeWidth >> 1);
        canvas.drawLine(f2, (float) this.O00000Oo.O000O0o0(), f2, (float) (comMeasuredHeight - this.O00000Oo.O000O0oO()), this.f14850O000000o);
    }
}
