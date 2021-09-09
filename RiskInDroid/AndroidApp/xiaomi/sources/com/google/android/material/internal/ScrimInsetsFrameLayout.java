package com.google.android.material.internal;

import _m_j.bw;
import _m_j.cb;
import _m_j.ci;
import _m_j.r;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    /* access modifiers changed from: protected */
    public void onInsetsChanged(ci ciVar) {
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet2, new int[]{R.attr.insetForeground}, i, 2132739079, new int[0]);
        this.insetForeground = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        cb.O000000o(this, new bw() {
            /* class com.google.android.material.internal.ScrimInsetsFrameLayout.AnonymousClass1 */

            public ci onApplyWindowInsets(View view, ci ciVar) {
                if (ScrimInsetsFrameLayout.this.insets == null) {
                    ScrimInsetsFrameLayout.this.insets = new Rect();
                }
                ScrimInsetsFrameLayout.this.insets.set(ciVar.O000000o(), ciVar.O00000Oo(), ciVar.O00000o0(), ciVar.O00000o());
                ScrimInsetsFrameLayout.this.onInsetsChanged(ciVar);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                boolean z = true;
                if ((!ciVar.O00000Oo.O0000O0o().equals(r.f2418O000000o)) && ScrimInsetsFrameLayout.this.insetForeground != null) {
                    z = false;
                }
                scrimInsetsFrameLayout.setWillNotDraw(z);
                cb.O00000oo(ScrimInsetsFrameLayout.this);
                return ciVar.O00000Oo.O00000o0();
            }
        });
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.insetForeground = drawable;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.drawTopInsetForeground = z;
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.drawBottomInsetForeground = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets != null && this.insetForeground != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (this.drawTopInsetForeground) {
                this.tempRect.set(0, 0, width, this.insets.top);
                this.insetForeground.setBounds(this.tempRect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawBottomInsetForeground) {
                this.tempRect.set(0, height - this.insets.bottom, width, height);
                this.insetForeground.setBounds(this.tempRect);
                this.insetForeground.draw(canvas);
            }
            this.tempRect.set(0, this.insets.top, this.insets.left, height - this.insets.bottom);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
            this.tempRect.set(width - this.insets.right, this.insets.top, width, height - this.insets.bottom);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }
}
