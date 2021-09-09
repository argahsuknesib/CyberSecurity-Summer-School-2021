package com.xiaomi.smarthome.newui.onekey_delete;

import _m_j.gri;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.xiaomi.smarthome.R;

public class PaperShredderView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public float f10252O000000o;
    public float O00000Oo;
    private final Bitmap O00000o;
    private final Bitmap O00000o0;
    private final Rect O00000oO;
    private final Rect O00000oo;
    private final Paint O0000O0o;
    private final RectF O0000OOo;
    private ValueAnimator O0000Oo;
    private final RectF O0000Oo0;

    public PaperShredderView(Context context) {
        this(context, null);
    }

    public PaperShredderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaperShredderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o0 = BitmapFactory.decodeResource(getResources(), R.drawable.paper_shredder_back);
        this.O00000o = BitmapFactory.decodeResource(getResources(), R.drawable.paper_shredder_front);
        this.O00000oO = new Rect(0, 0, this.O00000o0.getWidth(), this.O00000o0.getHeight());
        this.O00000oo = new Rect(0, 0, this.O00000o.getWidth(), this.O00000o.getHeight());
        this.O0000O0o = new Paint();
        this.O0000OOo = new RectF();
        this.O0000Oo0 = new RectF();
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setColor(-1);
        this.O0000O0o.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.O0000O0o.setColor(-1);
        canvas.drawBitmap(this.O00000o0, this.O00000oO, new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), (Paint) null);
        this.O0000O0o.setColor(-1);
        this.O0000O0o.setAlpha(255);
        int measuredWidth = getMeasuredWidth();
        float measuredHeight = (float) getMeasuredHeight();
        float f = ((this.O00000Oo * measuredHeight) / 3.0f) * 0.8f;
        RectF rectF = this.O0000OOo;
        rectF.top = f;
        rectF.bottom = (measuredHeight / 3.0f) + f;
        float f2 = (float) (measuredWidth / 4);
        rectF.left = f2;
        rectF.right = ((float) measuredWidth) - f2;
        float f3 = (float) (measuredWidth / 50);
        canvas.drawRoundRect(rectF, f3, f3, this.O0000O0o);
        O000000o(canvas);
        int measuredHeight2 = getMeasuredHeight();
        RectF rectF2 = this.O0000Oo0;
        float f4 = (float) measuredHeight2;
        float f5 = f4 / 2.0f;
        float f6 = (f4 / 3.0f) / 2.0f;
        rectF2.top = (f5 - f6) - 10.0f;
        rectF2.bottom = f5 + f6;
        float measuredWidth2 = (float) (getMeasuredWidth() / 20);
        rectF2.left = measuredWidth2;
        this.O0000Oo0.right = ((float) getMeasuredWidth()) - measuredWidth2;
        this.O0000O0o.setColor(-7829368);
        canvas.drawBitmap(this.O00000o, this.O00000oo, this.O0000Oo0, this.O0000O0o);
        canvas.restore();
    }

    private void O000000o(Canvas canvas) {
        Path path = new Path();
        float width = this.O0000OOo.width() / 13.0f;
        float f = width / 7.0f;
        this.O0000O0o.setColor(-1);
        this.O0000O0o.setAlpha((int) ((1.0f - this.f10252O000000o) * 255.0f));
        int i = 0;
        while (i < 13) {
            path.reset();
            float f2 = ((float) i) * width;
            path.moveTo(this.O0000OOo.left + f2 + f, this.O0000OOo.bottom);
            i++;
            float f3 = ((float) i) * width;
            path.lineTo((this.O0000OOo.left + f3) - f, this.O0000OOo.bottom);
            float height = ((this.O0000OOo.height() * 2.0f) / 3.0f) + (this.O0000OOo.height() / 3.0f);
            path.quadTo((this.O0000OOo.left + f3) - f, this.O0000OOo.bottom, (this.O0000OOo.left + f3) - f, this.O0000OOo.bottom + height);
            path.lineTo(this.O0000OOo.left + f2 + f, this.O0000OOo.bottom + height);
            path.quadTo(this.O0000OOo.left + f2 + f, this.O0000OOo.bottom, this.O0000OOo.left + f2 + f, this.O0000OOo.bottom);
            path.close();
            canvas.drawPath(path, this.O0000O0o);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int O000000o2 = gri.O000000o(150.0f);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(O000000o2, O000000o2);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(O000000o2, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, O000000o2);
        }
    }

    public final void O000000o() {
        O00000Oo();
        O00000o0();
    }

    private void O00000Oo() {
        if (this.O0000Oo != null) {
            clearAnimation();
            this.O0000Oo.setRepeatCount(0);
            this.O0000Oo.cancel();
            this.O0000Oo.end();
            this.f10252O000000o = 0.0f;
            postInvalidate();
        }
    }

    private ValueAnimator O00000o0() {
        this.O0000Oo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.O0000Oo.setDuration(2000L);
        this.O0000Oo.setInterpolator(new DecelerateInterpolator());
        this.O0000Oo.setRepeatCount(-1);
        this.O0000Oo.setRepeatMode(1);
        this.O0000Oo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.newui.onekey_delete.PaperShredderView.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PaperShredderView.this.f10252O000000o = valueAnimator.getAnimatedFraction();
                PaperShredderView.this.O00000Oo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                PaperShredderView.this.invalidate();
            }
        });
        if (!this.O0000Oo.isRunning()) {
            this.O0000Oo.start();
        }
        return this.O0000Oo;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000Oo();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O000000o();
    }
}
