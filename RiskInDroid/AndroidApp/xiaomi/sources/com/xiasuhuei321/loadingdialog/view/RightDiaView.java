package com.xiasuhuei321.loadingdialog.view;

import _m_j.ihv;
import _m_j.ihw;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class RightDiaView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f12149O000000o;
    private final String O00000Oo;
    private Context O00000o;
    private ihv O00000o0;
    private int O00000oO;
    private float O00000oo;
    private Paint O0000O0o;
    private RectF O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private boolean O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o;

    public RightDiaView(Context context) {
        this(context, null);
    }

    public RightDiaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RightDiaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = getClass().getSimpleName();
        this.O00000oO = 0;
        this.O00000oo = 0.0f;
        this.O0000o00 = 0;
        this.O0000o0 = true;
        this.O0000o0O = 1;
        this.f12149O000000o = 0;
        this.O0000o0o = 0;
        this.O0000O0o = new Paint();
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setStyle(Paint.Style.STROKE);
        this.O0000O0o.setColor(-1);
        this.O0000O0o.setStrokeWidth(8.0f);
        this.O00000o = context;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE && mode2 != Integer.MIN_VALUE) {
            if (size < size2) {
                size = size2;
            }
            this.O00000oO = size;
        } else if (mode == Integer.MIN_VALUE && mode2 != Integer.MIN_VALUE) {
            this.O00000oO = size2;
        } else if (mode != Integer.MIN_VALUE) {
            this.O00000oO = size;
        } else {
            this.O00000oO = ihw.O000000o(this.O00000o, 80.0f);
        }
        int i3 = this.O00000oO;
        setMeasuredDimension(i3, i3);
        this.O00000oo = 8.0f;
        float f = this.O00000oo;
        int i4 = this.O00000oO;
        this.O0000OOo = new RectF(f, f, ((float) i4) - f, ((float) i4) - f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        ihv ihv;
        int i;
        int i2;
        if (this.O0000o0) {
            int i3 = this.f12149O000000o;
            if (i3 < 100) {
                this.f12149O000000o = i3 + this.O0000o0O;
            }
            canvas.drawArc(this.O0000OOo, 235.0f, (float) ((this.f12149O000000o * 360) / 100), false, this.O0000O0o);
            int i4 = this.O00000oO;
            int i5 = i4 / 2;
            int i6 = i5 - (i4 / 5);
            int i7 = (i4 / 2) - 8;
            if (this.f12149O000000o == 100) {
                int i8 = this.O0000Oo0;
                int i9 = i7 / 3;
                if (i8 < i9) {
                    int i10 = this.O0000o0O;
                    this.O0000Oo0 = i8 + i10;
                    this.O0000Oo += i10;
                }
                canvas.drawLine((float) i6, (float) i5, (float) (this.O0000Oo0 + i6), (float) (this.O0000Oo + i5), this.O0000O0o);
                int i11 = this.O0000Oo0;
                if (i11 >= i9 && this.O0000OoO == 0 && this.O0000Ooo == 0) {
                    this.O0000OoO = i11;
                    int i12 = this.O0000Oo;
                    this.O0000Ooo = i12;
                    int i13 = this.O0000o0O;
                    this.O0000Oo0 = i11 + i13;
                    this.O0000Oo = i12 + i13;
                }
                if (this.O0000Oo0 >= i9 && (i = this.O0000OoO) <= i7 && (i2 = this.O0000Ooo) <= i5 - i9) {
                    int i14 = this.O0000o0O;
                    this.O0000OoO = i + i14;
                    this.O0000Ooo = i2 - i14;
                }
                canvas.drawLine((float) ((this.O0000Oo0 + i6) - 1), (float) ((this.O0000Oo + i5) - 4), (float) (i6 + this.O0000OoO), (float) (i5 + this.O0000Ooo), this.O0000O0o);
            }
            if (this.O0000OoO > i7 && this.f12149O000000o >= 100 && this.O0000Oo0 != i7 / 3) {
                if (this.O0000o0o == 0 && this.O0000o00 == 0 && (ihv = this.O00000o0) != null) {
                    ihv.O000000o(this);
                    this.O0000o0o++;
                }
                this.O0000o00--;
                if (this.O0000o00 >= 0) {
                    this.O0000Oo0 = 0;
                    this.O0000OoO = 0;
                    this.O0000Oo = 0;
                    this.O0000Ooo = 0;
                    this.f12149O000000o = 0;
                    invalidate();
                } else {
                    return;
                }
            }
            invalidate();
            return;
        }
        canvas.drawArc(this.O0000OOo, 0.0f, 360.0f, false, this.O0000O0o);
        int i15 = this.O00000oO;
        int i16 = i15 / 2;
        int i17 = i16 - (i15 / 5);
        int i18 = (i15 / 2) - 8;
        int i19 = i18 / 3;
        int i20 = i17 + i19;
        int i21 = i16 + i19;
        Canvas canvas2 = canvas;
        canvas2.drawLine((float) i17, (float) i16, (float) i20, (float) i21, this.O0000O0o);
        canvas2.drawLine((float) (i20 - 1), (float) (i21 - 4), (float) (i17 + i18), (float) (i16 - i19), this.O0000O0o);
        ihv ihv2 = this.O00000o0;
        if (ihv2 != null) {
            ihv2.O000000o(this);
        }
    }

    /* access modifiers changed from: protected */
    public void setRepeatTime(int i) {
        if (this.O0000o0) {
            this.O0000o00 = i;
        }
    }

    /* access modifiers changed from: protected */
    public void setDrawDynamic(boolean z) {
        this.O0000o0 = z;
    }

    /* access modifiers changed from: protected */
    public void setSpeed(int i) {
        if (i > 0 || i < 3) {
            this.O0000o0O = i;
            return;
        }
        throw new IllegalArgumentException("support speed >0 & < 3, the speed you set is: ".concat(String.valueOf(i)));
    }

    /* access modifiers changed from: protected */
    public void setDrawColor(int i) {
        this.O0000O0o.setColor(i);
    }

    public void setOnDrawFinishListener(ihv ihv) {
        this.O00000o0 = ihv;
    }
}
