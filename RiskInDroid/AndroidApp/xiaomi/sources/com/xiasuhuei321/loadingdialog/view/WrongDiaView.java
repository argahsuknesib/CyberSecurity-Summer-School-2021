package com.xiasuhuei321.loadingdialog.view;

import _m_j.ihv;
import _m_j.ihw;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class WrongDiaView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    int f12150O000000o;
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

    public WrongDiaView(Context context) {
        this(context, null);
    }

    public WrongDiaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WrongDiaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = getClass().getSimpleName();
        this.O00000oO = 0;
        this.O00000oo = 0.0f;
        this.O0000o00 = 0;
        this.O0000o0 = true;
        this.O0000o0O = 1;
        this.O0000o0o = 0;
        this.f12150O000000o = 0;
        this.O00000o = context;
        this.O0000O0o = new Paint();
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setStyle(Paint.Style.STROKE);
        this.O0000O0o.setColor(-1);
        this.O0000O0o.setStrokeWidth(8.0f);
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
        if (this.O0000o0) {
            int i = this.f12150O000000o;
            if (i < 100) {
                this.f12150O000000o = i + this.O0000o0O;
            }
            canvas.drawArc(this.O0000OOo, 235.0f, (float) ((this.f12150O000000o * 360) / 100), false, this.O0000O0o);
            int i2 = this.O00000oO;
            int i3 = (i2 * 3) / 10;
            int i4 = (i2 * 7) / 10;
            if (this.f12150O000000o == 100) {
                int i5 = this.O0000Oo0;
                if (i5 + i3 <= i4) {
                    int i6 = this.O0000o0O;
                    this.O0000Oo0 = i5 + i6;
                    this.O0000Oo += i6;
                }
                float f = (float) i3;
                canvas.drawLine(f, f, (float) (this.O0000Oo0 + i3), (float) (this.O0000Oo + i3), this.O0000O0o);
                int i7 = this.O0000Oo0;
                if (i7 == (this.O00000oO * 2) / 5) {
                    this.O0000Oo0 = i7 + 1;
                    this.O0000Oo++;
                }
                if (this.O0000Oo0 >= (this.O00000oO * 2) / 5) {
                    int i8 = this.O0000Ooo;
                    if (i4 - i8 >= i3) {
                        int i9 = this.O0000OoO;
                        int i10 = this.O0000o0O;
                        this.O0000OoO = i9 - i10;
                        this.O0000Ooo = i8 + i10;
                    }
                }
                canvas.drawLine((float) i4, f, (float) (this.O0000OoO + i4), (float) (this.O0000Ooo + i3), this.O0000O0o);
                if (i4 - this.O0000Ooo < i3) {
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
                        this.f12150O000000o = 0;
                        invalidate();
                    } else {
                        return;
                    }
                }
            }
            invalidate();
            return;
        }
        canvas.drawArc(this.O0000OOo, 0.0f, 360.0f, false, this.O0000O0o);
        int i11 = this.O00000oO;
        int i12 = (i11 * 3) / 10;
        float f2 = (float) i12;
        float f3 = f2;
        canvas.drawLine(f2, f3, (float) (((i11 * 2) / 5) + i12), (float) (((i11 * 2) / 5) + i12), this.O0000O0o);
        int i13 = this.O00000oO;
        canvas.drawLine((float) (((i13 * 2) / 5) + i12), f3, f2, (float) (i12 + ((i13 * 2) / 5)), this.O0000O0o);
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
        throw new IllegalArgumentException("how can u set this speed??  " + i + "  do not use reflect to use this method!u can see the LoadingDialog class for how toset the speed");
    }

    /* access modifiers changed from: protected */
    public void setDrawColor(int i) {
        this.O0000O0o.setColor(i);
    }

    public void setOnDrawFinishListener(ihv ihv) {
        this.O00000o0 = ihv;
    }
}
