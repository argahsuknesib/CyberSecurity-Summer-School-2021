package com.scwang.smartrefresh.header;

import _m_j.czu;
import _m_j.czx;
import _m_j.dae;
import _m_j.dao;
import _m_j.q;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

public class BezierCircleHeader extends dae implements czu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Path f5511O000000o;
    protected Paint O00000Oo;
    protected Paint O00000o;
    protected Paint O00000o0;
    protected float O00000oO;
    protected float O00000oo;
    protected float O0000O0o;
    protected float O0000OOo;
    protected boolean O0000Oo;
    protected float O0000Oo0;
    protected boolean O0000OoO;
    protected boolean O0000Ooo;
    protected boolean O0000o;
    protected int O0000o0;
    protected float O0000o00;
    protected int O0000o0O;
    protected boolean O0000o0o;

    public BezierCircleHeader(Context context) {
        this(context, null);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000o0 = 90;
        this.O0000o0O = 90;
        this.O0000o0o = true;
        this.O0000o = false;
        this.O000OoOo = SpinnerStyle.Scale;
        setMinimumHeight(dao.O000000o(100.0f));
        this.O00000Oo = new Paint();
        this.O00000Oo.setColor(-15614977);
        this.O00000Oo.setAntiAlias(true);
        this.O00000o0 = new Paint();
        this.O00000o0.setColor(-1);
        this.O00000o0.setAntiAlias(true);
        this.O00000o = new Paint();
        this.O00000o.setAntiAlias(true);
        this.O00000o.setColor(-1);
        this.O00000o.setStyle(Paint.Style.STROKE);
        this.O00000o.setStrokeWidth((float) dao.O000000o(2.0f));
        this.f5511O000000o = new Path();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.O0000Oo = true;
            this.O0000Ooo = true;
            this.O00000oo = (float) height;
            this.O0000o0 = 270;
            float f = this.O00000oo;
            this.O0000Oo0 = f / 2.0f;
            this.O0000o00 = f / 6.0f;
        }
        float min = Math.min(this.O00000oo, (float) height);
        if (this.O00000oO != 0.0f) {
            this.f5511O000000o.reset();
            float f2 = (float) width;
            this.f5511O000000o.lineTo(f2, 0.0f);
            this.f5511O000000o.lineTo(f2, min);
            this.f5511O000000o.quadTo((float) (width / 2), (this.O00000oO * 2.0f) + min, 0.0f, min);
            this.f5511O000000o.close();
            canvas2.drawPath(this.f5511O000000o, this.O00000Oo);
        } else {
            canvas.drawRect(0.0f, 0.0f, (float) width, min, this.O00000Oo);
        }
        float f3 = this.O0000O0o;
        if (f3 > 0.0f) {
            float f4 = (float) (width / 2);
            float f5 = this.O0000o00;
            float f6 = (f4 - (4.0f * f5)) + (3.0f * f3 * f5);
            if (((double) f3) < 0.9d) {
                this.f5511O000000o.reset();
                this.f5511O000000o.moveTo(f6, this.O0000Oo0);
                Path path = this.f5511O000000o;
                float f7 = this.O0000Oo0;
                path.quadTo(f4, f7 - ((this.O0000o00 * this.O0000O0o) * 2.0f), ((float) width) - f6, f7);
                canvas2.drawPath(this.f5511O000000o, this.O00000o0);
            } else {
                canvas2.drawCircle(f4, this.O0000Oo0, f5, this.O00000o0);
            }
        }
        if (this.O0000Oo) {
            canvas2.drawCircle((float) (width / 2), this.O0000Oo0, this.O0000o00, this.O00000o0);
            float f8 = this.O00000oo;
            O000000o(canvas2, width, (this.O00000oO + f8) / f8);
        }
        if (this.O0000Ooo) {
            float strokeWidth = this.O0000o00 + (this.O00000o.getStrokeWidth() * 2.0f);
            int i = 3;
            this.O0000o0O += this.O0000o0o ? 3 : 10;
            int i2 = this.O0000o0;
            if (this.O0000o0o) {
                i = 10;
            }
            this.O0000o0 = i2 + i;
            this.O0000o0O %= 360;
            this.O0000o0 %= 360;
            int i3 = this.O0000o0 - this.O0000o0O;
            if (i3 < 0) {
                i3 += 360;
            }
            int i4 = i3;
            float f9 = (float) (width / 2);
            float f10 = this.O0000Oo0;
            canvas.drawArc(new RectF(f9 - strokeWidth, f10 - strokeWidth, f9 + strokeWidth, f10 + strokeWidth), (float) this.O0000o0O, (float) i4, false, this.O00000o);
            if (i4 >= 270) {
                this.O0000o0o = false;
            } else if (i4 <= 10) {
                this.O0000o0o = true;
            }
            invalidate();
        }
        if (this.O0000OOo > 0.0f) {
            int color = this.O00000o.getColor();
            if (((double) this.O0000OOo) < 0.3d) {
                int i5 = width / 2;
                canvas2.drawCircle((float) i5, this.O0000Oo0, this.O0000o00, this.O00000o0);
                float f11 = this.O0000o00;
                float f12 = this.O0000OOo;
                int strokeWidth2 = (int) (f11 + (this.O00000o.getStrokeWidth() * 2.0f * ((f12 / 0.3f) + 1.0f)));
                this.O00000o.setColor(q.O00000Oo(color, (int) ((1.0f - (f12 / 0.3f)) * 255.0f)));
                float f13 = this.O0000Oo0;
                float f14 = (float) strokeWidth2;
                canvas.drawArc(new RectF((float) (i5 - strokeWidth2), f13 - f14, (float) (i5 + strokeWidth2), f13 + f14), 0.0f, 360.0f, false, this.O00000o);
            }
            this.O00000o.setColor(color);
            float f15 = this.O0000OOo;
            if (((double) f15) >= 0.3d && ((double) f15) < 0.7d) {
                float f16 = (f15 - 0.3f) / 0.4f;
                float f17 = this.O00000oo;
                this.O0000Oo0 = (float) ((int) ((f17 / 2.0f) + ((f17 - (f17 / 2.0f)) * f16)));
                canvas2.drawCircle((float) (width / 2), this.O0000Oo0, this.O0000o00, this.O00000o0);
                if (this.O0000Oo0 >= this.O00000oo - (this.O0000o00 * 2.0f)) {
                    this.O0000OoO = true;
                    O000000o(canvas2, width, f16);
                }
                this.O0000OoO = false;
            }
            float f18 = this.O0000OOo;
            if (((double) f18) >= 0.7d && f18 <= 1.0f) {
                float f19 = (f18 - 0.7f) / 0.3f;
                float f20 = (float) (width / 2);
                float f21 = this.O0000o00;
                int i6 = (int) ((f20 - f21) - ((f21 * 2.0f) * f19));
                this.f5511O000000o.reset();
                this.f5511O000000o.moveTo((float) i6, this.O00000oo);
                Path path2 = this.f5511O000000o;
                float f22 = this.O00000oo;
                path2.quadTo(f20, f22 - (this.O0000o00 * (1.0f - f19)), (float) (width - i6), f22);
                canvas2.drawPath(this.f5511O000000o, this.O00000o0);
            }
        }
        super.dispatchDraw(canvas);
    }

    private void O000000o(Canvas canvas, int i, float f) {
        if (this.O0000OoO) {
            float f2 = this.O00000oo + this.O00000oO;
            float f3 = this.O0000Oo0;
            float f4 = this.O0000o00;
            float f5 = f3 + ((f4 * f) / 2.0f);
            float f6 = (float) (i / 2);
            float sqrt = ((float) Math.sqrt((double) (f4 * f4 * (1.0f - ((f * f) / 4.0f))))) + f6;
            float f7 = this.O0000o00;
            float f8 = f6 + (((3.0f * f7) / 4.0f) * (1.0f - f));
            float f9 = f7 + f8;
            this.f5511O000000o.reset();
            this.f5511O000000o.moveTo(sqrt, f5);
            this.f5511O000000o.quadTo(f8, f2, f9, f2);
            float f10 = (float) i;
            this.f5511O000000o.lineTo(f10 - f9, f2);
            this.f5511O000000o.quadTo(f10 - f8, f2, f10 - sqrt, f5);
            canvas.drawPath(this.f5511O000000o, this.O00000o0);
        }
    }

    public final void O000000o(boolean z, float f, int i, int i2, int i3) {
        if (z || this.O0000o) {
            this.O0000o = true;
            this.O00000oo = (float) i2;
            this.O00000oO = ((float) Math.max(i - i2, 0)) * 0.8f;
        }
    }

    public final void O000000o(czx czx, int i, int i2) {
        this.O0000o = false;
        this.O00000oo = (float) i;
        this.O0000o00 = (float) (i / 6);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        final float min = Math.min(this.O00000oO * 0.8f, this.O00000oo / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.O00000oO, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.BezierCircleHeader.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            float f5512O000000o = 0.0f;
            float O00000Oo;
            int O00000o = 0;
            float O00000o0 = 0.0f;

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.O00000o == 0 && floatValue <= 0.0f) {
                    this.O00000o = 1;
                    this.f5512O000000o = Math.abs(floatValue - BezierCircleHeader.this.O00000oO);
                }
                if (this.O00000o == 1) {
                    this.O00000o0 = (-floatValue) / min;
                    if (this.O00000o0 >= BezierCircleHeader.this.O0000O0o) {
                        BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                        bezierCircleHeader.O0000O0o = this.O00000o0;
                        bezierCircleHeader.O0000Oo0 = bezierCircleHeader.O00000oo + floatValue;
                        this.f5512O000000o = Math.abs(floatValue - BezierCircleHeader.this.O00000oO);
                    } else {
                        this.O00000o = 2;
                        BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                        bezierCircleHeader2.O0000O0o = 0.0f;
                        bezierCircleHeader2.O0000Oo = true;
                        bezierCircleHeader2.O0000OoO = true;
                        this.O00000Oo = bezierCircleHeader2.O0000Oo0;
                    }
                }
                if (this.O00000o == 2 && BezierCircleHeader.this.O0000Oo0 > BezierCircleHeader.this.O00000oo / 2.0f) {
                    BezierCircleHeader bezierCircleHeader3 = BezierCircleHeader.this;
                    bezierCircleHeader3.O0000Oo0 = Math.max(bezierCircleHeader3.O00000oo / 2.0f, BezierCircleHeader.this.O0000Oo0 - this.f5512O000000o);
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    float f = this.O00000Oo;
                    float f2 = (animatedFraction * ((BezierCircleHeader.this.O00000oo / 2.0f) - f)) + f;
                    if (BezierCircleHeader.this.O0000Oo0 > f2) {
                        BezierCircleHeader.this.O0000Oo0 = f2;
                    }
                }
                if (BezierCircleHeader.this.O0000OoO && floatValue < BezierCircleHeader.this.O00000oO) {
                    BezierCircleHeader bezierCircleHeader4 = BezierCircleHeader.this;
                    bezierCircleHeader4.O0000Ooo = true;
                    bezierCircleHeader4.O0000OoO = false;
                    bezierCircleHeader4.O0000o0o = true;
                    bezierCircleHeader4.O0000o0O = 90;
                    bezierCircleHeader4.O0000o0 = 90;
                }
                if (!BezierCircleHeader.this.O0000o) {
                    BezierCircleHeader bezierCircleHeader5 = BezierCircleHeader.this;
                    bezierCircleHeader5.O00000oO = floatValue;
                    bezierCircleHeader5.invalidate();
                }
            }
        });
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public final int O000000o(czx czx, boolean z) {
        this.O0000Oo = false;
        this.O0000Ooo = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.scwang.smartrefresh.header.BezierCircleHeader.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                bezierCircleHeader.O0000OOo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                bezierCircleHeader.invalidate();
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800L);
        ofFloat.start();
        return 800;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.O00000Oo.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.O00000o0.setColor(iArr[1]);
                this.O00000o.setColor(iArr[1]);
            }
        }
    }
}
