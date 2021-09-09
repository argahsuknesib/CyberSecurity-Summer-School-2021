package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public final class euy extends euz {
    private boolean O000OoO;
    private int O000OoOO;
    private float O000OoOo;
    private float O000Ooo;
    private float O000Ooo0;
    private int O000OooO;
    private Paint O000Oooo;
    private RectF O000o;
    private RectF O000o0;
    private Paint O000o00;
    private Paint O000o000;
    private float O000o00O;
    private float O000o00o;
    private RectF O000o0O;
    private RectF O000o0O0;
    private RectF O000o0OO;
    private RectF O000o0Oo;
    private RectF O000o0o;
    private RectF O000o0o0;
    private RectF O000o0oo;
    private float O000oO;
    private float O000oO0;
    private RectF O000oO00;
    private float O000oO0O;
    private boolean O000oO0o;
    private int O000oOO;
    private float O000oOO0;
    private boolean O00O0Oo;

    public final void O000000o(Context context, TypedArray typedArray) {
        super.O000000o(context, typedArray);
        this.O000OooO = typedArray.getColor(33, -12303292);
        this.O000Ooo0 = typedArray.getDimension(36, 0.0f);
        this.O000OoO = typedArray.getBoolean(8, true);
        this.O000OoOO = typedArray.getColor(34, Color.parseColor("#30FFFFFF"));
        this.O000OoOo = typedArray.getDimension(35, (float) evf.O000000o(context, 0.5f));
        this.O000Ooo = typedArray.getDimension(37, 0.0f);
        this.O000o00O = this.O000Ooo;
        this.O000oO = typedArray.getDimension(32, (float) evf.O000000o(context, 1.0f));
        this.O000oOO0 = typedArray.getDimension(31, 0.0f);
        this.O000oOO = typedArray.getColor(30, -16777216);
        boolean z = false;
        this.O000oO0o = typedArray.getBoolean(7, false);
        if (typedArray.hasValue(33) || !this.O000oO0o) {
            z = true;
        }
        this.O00O0Oo = z;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        super.O000000o();
        this.O000Oooo = new Paint(1);
        this.O000Oooo.setStyle(Paint.Style.FILL);
        this.O000Oooo.setColor(this.O000OooO);
        if (this.O000oO0o) {
            O0000Oo0();
        }
        if (this.O000OoO) {
            O0000Oo();
        }
    }

    private void O0000Oo0() {
        if (this.O000o000 == null) {
            this.O000o000 = new Paint(1);
            this.O000o000.setColor(this.O000oOO);
            if (!this.O00O0Oo) {
                this.O000o000.setStrokeWidth(this.O000oO);
                this.O000o000.setStyle(Paint.Style.STROKE);
            }
        }
    }

    private void O0000Oo() {
        if (this.O000o00 == null) {
            this.O000o00 = new Paint(1);
            this.O000o00.setColor(this.O000OoOO);
            this.O000o00.setStrokeWidth(this.O000OoOo);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        super.O00000Oo();
        if (this.O000o00O == 0.0f || this.O000Ooo < this.O000Oo0) {
            this.O000Ooo = this.O000Oo0 + ((float) (evf.O000000o(this.O0000o0, 2.0f) * 4));
        }
    }

    private float O000000o(String str, float f) {
        float f2;
        float f3;
        Rect rect = new Rect();
        this.O000O00o.getTextBounds(str, 0, str.length(), rect);
        int i = this.O000OoO0;
        if (i == 0) {
            return f - ((float) rect.top);
        }
        if (i != 2) {
            float f4 = this.O000Ooo;
            f2 = ((f + f4) - (f4 / 2.0f)) + ((float) (rect.height() / 2));
            f3 = this.O000oO;
        } else {
            f2 = (f + this.O000Ooo) - ((float) rect.bottom);
            f3 = this.O000oO * 2.0f;
        }
        return f2 + f3;
    }

    private void O000000o(RectF rectF) {
        Paint.FontMetrics fontMetrics = this.O00oOooo.getFontMetrics();
        this.O000oO0O = ((rectF.top + ((((rectF.bottom - rectF.top) - fontMetrics.bottom) + fontMetrics.top) / 2.0f)) - fontMetrics.top) - this.O000Oo0o;
        this.O000oO0 = rectF.centerY() + (this.O000OoOo == ((float) evf.O000000o(this.O0000o0, 0.5f)) ? this.O000OoOo : this.O000OoOo / 2.0f);
    }

    public final int O00000o0() {
        float f;
        float O00000oo = O00000oo(this.O000Ooo + (this.O000oO * 2.0f));
        if (this.O00000oo) {
            if (this.O00oOooO) {
                Rect rect = new Rect();
                String valueOf = String.valueOf(this.f15837O000000o);
                this.O00oOooo.getTextBounds(valueOf, 0, valueOf.length(), rect);
                this.O000o00o = (float) (rect.width() + (evf.O000000o(this.O0000o0, 2.0f) * 4));
                f = this.O000o00o;
            } else {
                f = this.O000Ooo;
                this.O000o00o = f;
            }
            O00000oo = O00000oo + f + (this.O000oO * 2.0f);
        }
        return (int) Math.ceil((double) O00000oo);
    }

    public final int O00000o() {
        return (int) (this.O000Ooo + (this.O000oO * 2.0f));
    }

    public final void O000000o(View view, int i, int i2, int i3, int i4) {
        float f;
        int paddingTop = view.getPaddingTop();
        float f2 = paddingTop == view.getPaddingBottom() ? (float) ((i2 - i4) / 2) : (float) paddingTop;
        if (this.O00000oo && this.O0000oOo > 0.0f) {
            this.O000OOo0 = O000000o(this.O0000o0o, f2);
        }
        if (this.O0000O0o && this.O0000oo0 > 0.0f) {
            this.O000OOo = O000000o(this.O0000o, f2);
        }
        if (this.O0000OOo && this.O0000oo > 0.0f) {
            this.O000OOoO = O000000o(this.O0000oO0, f2);
        }
        if (this.O0000ooO > 0.0f) {
            this.O000OOoo = O000000o(this.O0000oO, f2);
        }
        if (this.O0000Oo && this.O0000ooo > 0.0f) {
            this.O000Oo00 = O000000o(this.O0000oOO, f2);
        }
        this.O000O0Oo = view.getPaddingLeft() == view.getPaddingRight() ? (float) ((i - i3) / 2) : (float) view.getPaddingLeft();
        boolean z = false;
        if (this.O00000oo) {
            if (this.O000oO0o) {
                float f3 = this.O000O0Oo;
                float f4 = this.O000O0Oo + this.O000o00o;
                float f5 = this.O000oO;
                this.O000o0o0 = new RectF(f3, f2, f4 + (f5 * 2.0f), this.O000Ooo + f2 + (f5 * 2.0f));
                float f6 = this.O000O0Oo;
                float f7 = this.O000oO;
                float f8 = this.O000O0Oo + this.O000o00o;
                float f9 = this.O000oO;
                this.O000o0 = new RectF(f6 + f7, f7 + f2, f8 + f9, this.O000Ooo + f2 + f9);
            } else {
                this.O000o0 = new RectF(this.O000O0Oo, f2, this.O000O0Oo + this.O000o00o, this.O000Ooo + f2);
            }
            f = this.O000O0Oo + this.O000o00o + this.O0000oOo + this.O00oOoOo + this.O000O0o0 + (this.O000oO * 2.0f);
            if (!this.O0000O0o && !this.O0000OOo && !this.O0000Oo0) {
                O000000o(this.O000o0);
                z = true;
            }
        } else {
            f = this.O000O0Oo;
        }
        if (this.O0000O0o) {
            if (this.O000oO0o) {
                float f10 = this.O000Ooo;
                float f11 = this.O000oO;
                this.O000o0o = new RectF(f, f2, f + f10 + (f11 * 2.0f), f10 + f2 + (f11 * 2.0f));
                float f12 = this.O000oO;
                float f13 = this.O000Ooo;
                this.O000o0O0 = new RectF(f + f12, f2 + f12, f + f13 + f12, f13 + f2 + f12);
            } else {
                float f14 = this.O000Ooo;
                this.O000o0O0 = new RectF(f, f2, f + f14, f14 + f2);
            }
            f = f + this.O000Ooo + this.O0000oo0 + this.O000O0oo + this.O000OO00 + (this.O000oO * 2.0f);
            if (!z) {
                O000000o(this.O000o0O0);
                z = true;
            }
        }
        if (this.O0000OOo) {
            if (this.O000oO0o) {
                float f15 = this.O000Ooo;
                float f16 = this.O000oO;
                this.O000o0oo = new RectF(f, f2, f + f15 + (f16 * 2.0f), f15 + f2 + (f16 * 2.0f));
                float f17 = this.O000oO;
                float f18 = this.O000Ooo;
                this.O000o0O = new RectF(f + f17, f2 + f17, f + f18 + f17, f18 + f2 + f17);
            } else {
                float f19 = this.O000Ooo;
                this.O000o0O = new RectF(f, f2, f + f19, f19 + f2);
            }
            f = f + this.O000Ooo + this.O0000oo + this.O000OO0o + this.O000OO + (this.O000oO * 2.0f);
            if (!z) {
                O000000o(this.O000o0O);
                z = true;
            }
        }
        if (this.O0000Oo0) {
            if (this.O000oO0o) {
                float f20 = this.O000Ooo;
                float f21 = this.O000oO;
                this.O000o = new RectF(f, f2, f + f20 + (f21 * 2.0f), f20 + f2 + (f21 * 2.0f));
                float f22 = this.O000oO;
                float f23 = this.O000Ooo;
                this.O000o0OO = new RectF(f + f22, f2 + f22, f + f23 + f22, f23 + f2 + f22);
            } else {
                float f24 = this.O000Ooo;
                this.O000o0OO = new RectF(f, f2, f + f24, f24 + f2);
            }
            if (this.O0000Oo) {
                float f25 = f + this.O000Ooo + this.O0000ooO + this.O000O0o + this.O000O0oO;
                float f26 = this.O000oO;
                float f27 = f25 + (f26 * 2.0f);
                if (this.O000oO0o) {
                    float f28 = this.O000Ooo;
                    this.O000oO00 = new RectF(f27, f2, f27 + f28 + (f26 * 2.0f), f28 + f2 + (f26 * 2.0f));
                    float f29 = this.O000oO;
                    float f30 = this.O000Ooo;
                    this.O000o0Oo = new RectF(f27 + f29, f2 + f29, f27 + f30 + f29, f2 + f30 + f29);
                } else {
                    float f31 = this.O000Ooo;
                    this.O000o0Oo = new RectF(f27, f2, f27 + f31, f31 + f2);
                }
            }
            if (!z) {
                O000000o(this.O000o0OO);
            }
        }
    }

    public final void O000000o(Canvas canvas) {
        float f;
        RectF rectF;
        if (this.O00000oo) {
            if (this.O000oO0o && (rectF = this.O000o0o0) != null) {
                float f2 = this.O000oOO0;
                canvas.drawRoundRect(rectF, f2, f2, this.O000o000);
            }
            if (this.O00O0Oo) {
                RectF rectF2 = this.O000o0;
                float f3 = this.O000Ooo0;
                canvas.drawRoundRect(rectF2, f3, f3, this.O000Oooo);
                if (this.O000OoO) {
                    canvas.drawLine(this.O000O0Oo + this.O000oO, this.O000oO0, this.O000O0Oo + this.O000o00o + this.O000oO, this.O000oO0, this.O000o00);
                }
            }
            canvas.drawText(evf.O000000o(this.f15837O000000o), this.O000o0.centerX(), this.O000oO0O, this.O00oOooo);
            if (this.O0000oOo > 0.0f) {
                canvas.drawText(this.O0000o0o, this.O000O0Oo + this.O000o00o + this.O00oOoOo + (this.O000oO * 2.0f), this.O000OOo0, this.O000O00o);
            }
            f = this.O000O0Oo + this.O000o00o + this.O0000oOo + this.O00oOoOo + this.O000O0o0 + (this.O000oO * 2.0f);
        } else {
            f = this.O000O0Oo;
        }
        if (this.O0000O0o) {
            if (this.O000oO0o) {
                RectF rectF3 = this.O000o0o;
                float f4 = this.O000oOO0;
                canvas.drawRoundRect(rectF3, f4, f4, this.O000o000);
            }
            if (this.O00O0Oo) {
                RectF rectF4 = this.O000o0O0;
                float f5 = this.O000Ooo0;
                canvas.drawRoundRect(rectF4, f5, f5, this.O000Oooo);
                if (this.O000OoO) {
                    float f6 = this.O000oO;
                    float f7 = this.O000oO0;
                    canvas.drawLine(f + f6, f7, this.O000Ooo + f + f6, f7, this.O000o00);
                }
            }
            canvas.drawText(evf.O000000o(this.O00000Oo), this.O000o0O0.centerX(), this.O000oO0O, this.O00oOooo);
            if (this.O0000oo0 > 0.0f) {
                canvas.drawText(this.O0000o, this.O000Ooo + f + this.O000O0oo + (this.O000oO * 2.0f), this.O000OOo, this.O000O00o);
            }
            f = f + this.O000Ooo + this.O0000oo0 + this.O000O0oo + this.O000OO00 + (this.O000oO * 2.0f);
        }
        if (this.O0000OOo) {
            if (this.O000oO0o) {
                RectF rectF5 = this.O000o0oo;
                float f8 = this.O000oOO0;
                canvas.drawRoundRect(rectF5, f8, f8, this.O000o000);
            }
            if (this.O00O0Oo) {
                RectF rectF6 = this.O000o0O;
                float f9 = this.O000Ooo0;
                canvas.drawRoundRect(rectF6, f9, f9, this.O000Oooo);
                if (this.O000OoO) {
                    float f10 = this.O000oO;
                    float f11 = this.O000oO0;
                    canvas.drawLine(f + f10, f11, this.O000Ooo + f + f10, f11, this.O000o00);
                }
            }
            canvas.drawText(evf.O000000o(this.O00000o0), this.O000o0O.centerX(), this.O000oO0O, this.O00oOooo);
            if (this.O0000oo > 0.0f) {
                canvas.drawText(this.O0000oO0, this.O000Ooo + f + this.O000OO0o + (this.O000oO * 2.0f), this.O000OOoO, this.O000O00o);
            }
            f = f + this.O000Ooo + this.O0000oo + this.O000OO0o + this.O000OO + (this.O000oO * 2.0f);
        }
        if (this.O0000Oo0) {
            if (this.O000oO0o) {
                RectF rectF7 = this.O000o;
                float f12 = this.O000oOO0;
                canvas.drawRoundRect(rectF7, f12, f12, this.O000o000);
            }
            if (this.O00O0Oo) {
                RectF rectF8 = this.O000o0OO;
                float f13 = this.O000Ooo0;
                canvas.drawRoundRect(rectF8, f13, f13, this.O000Oooo);
                if (this.O000OoO) {
                    float f14 = this.O000oO;
                    float f15 = this.O000oO0;
                    canvas.drawLine(f + f14, f15, this.O000Ooo + f + f14, f15, this.O000o00);
                }
            }
            canvas.drawText(evf.O000000o(this.O00000o), this.O000o0OO.centerX(), this.O000oO0O, this.O00oOooo);
            if (this.O0000ooO > 0.0f) {
                canvas.drawText(this.O0000oO, this.O000Ooo + f + this.O000O0o + (this.O000oO * 2.0f), this.O000OOoo, this.O000O00o);
            }
            if (this.O0000Oo) {
                if (this.O000oO0o) {
                    RectF rectF9 = this.O000oO00;
                    float f16 = this.O000oOO0;
                    canvas.drawRoundRect(rectF9, f16, f16, this.O000o000);
                }
                float f17 = f + this.O000Ooo + this.O0000ooO + this.O000O0o + this.O000O0oO + (this.O000oO * 2.0f);
                if (this.O00O0Oo) {
                    RectF rectF10 = this.O000o0Oo;
                    float f18 = this.O000Ooo0;
                    canvas.drawRoundRect(rectF10, f18, f18, this.O000Oooo);
                    if (this.O000OoO) {
                        float f19 = this.O000oO;
                        float f20 = this.O000oO0;
                        canvas.drawLine(f17 + f19, f20, this.O000Ooo + f17 + f19, f20, this.O000o00);
                    }
                }
                canvas.drawText(evf.O00000Oo(this.O00000oO), this.O000o0Oo.centerX(), this.O000oO0O, this.O00oOooo);
                if (this.O0000ooo > 0.0f) {
                    canvas.drawText(this.O0000oOO, f17 + this.O000Ooo + this.O000OOOo + (this.O000oO * 2.0f), this.O000Oo00, this.O000O00o);
                }
            }
        }
    }

    public final void O000000o(float f) {
        this.O000Ooo = (float) evf.O000000o(this.O0000o0, f);
    }

    public final void O000000o(int i) {
        this.O000OooO = i;
        this.O000Oooo.setColor(this.O000OooO);
        if (i != 0 || !this.O000oO0o) {
            this.O00O0Oo = true;
            if (this.O000oO0o) {
                this.O000o000.setStrokeWidth(0.0f);
                this.O000o000.setStyle(Paint.Style.FILL);
                return;
            }
            return;
        }
        this.O00O0Oo = false;
        this.O000o000.setStrokeWidth(this.O000oO);
        this.O000o000.setStyle(Paint.Style.STROKE);
    }

    public final void O00000Oo(float f) {
        this.O000Ooo0 = (float) evf.O000000o(this.O0000o0, f);
    }

    public final void O000000o(boolean z) {
        this.O000OoO = z;
        if (this.O000OoO) {
            O0000Oo();
        } else {
            this.O000o00 = null;
        }
    }

    public final void O00000Oo(int i) {
        this.O000OoOO = i;
        Paint paint = this.O000o00;
        if (paint != null) {
            paint.setColor(this.O000OoOO);
        }
    }

    public final void O00000o0(float f) {
        this.O000OoOo = (float) evf.O000000o(this.O0000o0, f);
        Paint paint = this.O000o00;
        if (paint != null) {
            paint.setStrokeWidth(this.O000OoOo);
        }
    }

    public final void O00000Oo(boolean z) {
        this.O000oO0o = z;
        if (this.O000oO0o) {
            O0000Oo0();
            return;
        }
        this.O000o000 = null;
        this.O000oO = 0.0f;
    }

    public final void O00000o0(int i) {
        this.O000oOO = i;
        Paint paint = this.O000o000;
        if (paint != null) {
            paint.setColor(this.O000oOO);
        }
    }

    public final void O00000o(float f) {
        this.O000oO = (float) evf.O000000o(this.O0000o0, f);
        Paint paint = this.O000o000;
        if (paint != null && !this.O00O0Oo) {
            paint.setStrokeWidth(this.O000oO);
            this.O000o000.setStyle(Paint.Style.STROKE);
        }
    }

    public final void O00000oO(float f) {
        this.O000oOO0 = (float) evf.O000000o(this.O0000o0, f);
    }
}
