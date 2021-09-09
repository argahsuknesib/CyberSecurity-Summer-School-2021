package com.mi.global.shop.widget.ptr.header;

import _m_j.ccf;
import _m_j.cch;
import _m_j.cci;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.mi.global.shop.widget.ptr.PtrFrameLayout;

public class MaterialHeader extends View implements ccf {

    /* renamed from: O000000o  reason: collision with root package name */
    public cci f5035O000000o;
    public float O00000Oo = 1.0f;
    private PtrFrameLayout O00000o;
    public Animation O00000o0 = new Animation() {
        /* class com.mi.global.shop.widget.ptr.header.MaterialHeader.AnonymousClass1 */

        public final void applyTransformation(float f, Transformation transformation) {
            MaterialHeader materialHeader = MaterialHeader.this;
            materialHeader.O00000Oo = 1.0f - f;
            materialHeader.f5035O000000o.setAlpha((int) (MaterialHeader.this.O00000Oo * 255.0f));
            MaterialHeader.this.invalidate();
        }
    };

    public final void O00000Oo(PtrFrameLayout ptrFrameLayout) {
    }

    public MaterialHeader(Context context) {
        super(context);
        O000000o();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public void setPtrFrameLayout(PtrFrameLayout ptrFrameLayout) {
        final AnonymousClass2 r0 = new cch() {
            /* class com.mi.global.shop.widget.ptr.header.MaterialHeader.AnonymousClass2 */

            public final void run() {
                MaterialHeader materialHeader = MaterialHeader.this;
                materialHeader.startAnimation(materialHeader.O00000o0);
            }
        };
        this.O00000o0.setDuration(200);
        this.O00000o0.setAnimationListener(new Animation.AnimationListener() {
            /* class com.mi.global.shop.widget.ptr.header.MaterialHeader.AnonymousClass3 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                r0.O00000Oo();
            }
        });
        this.O00000o = ptrFrameLayout;
        this.O00000o.setRefreshCompleteHook(r0);
    }

    private void O000000o() {
        this.f5035O000000o = new cci(getContext(), this);
        this.f5035O000000o.O000000o();
        this.f5035O000000o.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f5035O000000o) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void setColorSchemeColors(int[] iArr) {
        cci cci = this.f5035O000000o;
        cci.O00000o0.O000000o(iArr);
        cci.O00000o0.O0000OoO = 0;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f5035O000000o.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom(), 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int intrinsicHeight = this.f5035O000000o.getIntrinsicHeight();
        this.f5035O000000o.setBounds(0, 0, intrinsicHeight, intrinsicHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = this.f5035O000000o.getBounds();
        canvas.translate((float) (getPaddingLeft() + ((getMeasuredWidth() - this.f5035O000000o.getIntrinsicWidth()) / 2)), (float) getPaddingTop());
        float f = this.O00000Oo;
        canvas.scale(f, f, bounds.exactCenterX(), bounds.exactCenterY());
        this.f5035O000000o.draw(canvas);
        canvas.restoreToCount(save);
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout) {
        this.O00000Oo = 1.0f;
        this.f5035O000000o.stop();
    }

    public final void O00000o0(PtrFrameLayout ptrFrameLayout) {
        this.f5035O000000o.setAlpha(255);
        this.f5035O000000o.start();
    }

    public final void O00000o(PtrFrameLayout ptrFrameLayout) {
        this.f5035O000000o.stop();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public final void O000000o(PtrFrameLayout ptrFrameLayout, boolean z, byte b, int i, int i2, float f, float f2) {
        float min = Math.min(1.0f, f2);
        if (b == 2) {
            this.f5035O000000o.setAlpha((int) (255.0f * min));
            this.f5035O000000o.O00000o0.O000000o(true);
            cci cci = this.f5035O000000o;
            float min2 = Math.min(0.8f, min * 0.8f);
            cci.O00000o0.O000000o(0.0f);
            cci.O00000o0.O00000Oo(min2);
            cci cci2 = this.f5035O000000o;
            cci2.O00000o0.O00000o(Math.min(1.0f, min));
            this.f5035O000000o.O00000o0.O00000o0((((0.4f * min) - 16.0f) + (min * 2.0f)) * 0.5f);
            invalidate();
        }
    }
}
