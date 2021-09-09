package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.xiaomi.smarthome.R;

public abstract class BaseSeekbar extends BaseProgressBar {
    protected Drawable O00000oo;
    protected int O0000O0o;
    float O0000OOo;
    private int O0000Oo = 1;
    boolean O0000Oo0 = true;
    private float O0000OoO;

    /* access modifiers changed from: package-private */
    public void O000000o() {
    }

    /* access modifiers changed from: package-private */
    public void O00000Oo() {
    }

    public BaseSeekbar(Context context) {
        super(context);
    }

    public BaseSeekbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int O000000o2 = gri.O000000o(5.0f);
        setPadding(O000000o2, O000000o2, O000000o2, O000000o2);
        setThumb(getResources().getDrawable(R.drawable.color_seekbar_thum));
        setThumbOffset(gri.O000000o(5.0f));
        this.O0000OoO = 0.5f;
    }

    public void setThumb(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.O00000oo = drawable;
        invalidate();
    }

    public int getThumbOffset() {
        return this.O0000O0o;
    }

    public void setThumbOffset(int i) {
        this.O0000O0o = i;
        invalidate();
    }

    public void setKeyProgressIncrement(int i) {
        if (i < 0) {
            i = -i;
        }
        this.O0000Oo = i;
    }

    public int getKeyProgressIncrement() {
        return this.O0000Oo;
    }

    public synchronized void setMax(int i) {
        super.setMax(i);
        if (this.O0000Oo == 0 || getMax() / this.O0000Oo > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(((float) getMax()) / 20.0f)));
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.O00000oo || super.verifyDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (this.O0000OoO * 255.0f));
        }
        Drawable drawable = this.O00000oo;
        if (drawable != null && drawable.isStateful()) {
            this.O00000oo.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public void O000000o(float f, boolean z) {
        Drawable drawable = this.O00000oo;
        if (drawable != null) {
            O000000o(getWidth(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.O00000oo;
        if (drawable == null) {
            i5 = 0;
        } else {
            i5 = drawable.getIntrinsicHeight();
        }
        int min = Math.min(this.O00000o, (i2 - getPaddingTop()) - getPaddingBottom());
        int max = getMax();
        float progress = max > 0 ? ((float) getProgress()) / ((float) max) : 0.0f;
        if (i5 > min) {
            if (drawable != null) {
                O000000o(i, drawable, progress, 0);
            }
            int i6 = (i5 - min) / 2;
            if (currentDrawable != null) {
                currentDrawable.setBounds(0, i6, (i - getPaddingRight()) - getPaddingLeft(), ((i2 - getPaddingBottom()) - i6) - getPaddingTop());
                return;
            }
            return;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, 0, (i - getPaddingRight()) - getPaddingLeft(), (i2 - getPaddingBottom()) - getPaddingTop());
        }
        int i7 = (min - i5) / 2;
        if (drawable != null) {
            O000000o(i, drawable, progress, i7);
        }
    }

    private void O000000o(int i, Drawable drawable, float f, int i2) {
        int i3;
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i4 = (int) (f * ((float) ((paddingLeft - intrinsicWidth) + (this.O0000O0o * 2))));
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.top;
            i3 = bounds.bottom;
        } else {
            i3 = i2 + intrinsicHeight;
        }
        drawable.setBounds(i4, i2, intrinsicWidth + i4, i3);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000oo != null) {
            canvas.save();
            canvas.translate((float) (getPaddingLeft() - this.O0000O0o), (float) getPaddingTop());
            this.O00000oo.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        Drawable currentDrawable = getCurrentDrawable();
        int i4 = 0;
        int intrinsicHeight = this.O00000oo == null ? 0 : this.O00000oo.getIntrinsicHeight();
        if (currentDrawable != null) {
            i4 = Math.max(this.f9140O000000o, Math.min(this.O00000Oo, currentDrawable.getIntrinsicWidth()));
            i3 = Math.max(intrinsicHeight, Math.max(this.O00000o0, Math.min(this.O00000o, currentDrawable.getIntrinsicHeight())));
        } else {
            i3 = 0;
        }
        setMeasuredDimension(resolveSize(i4 + getPaddingLeft() + getPaddingRight(), i), resolveSize(i3 + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000Oo0 || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                O000000o(motionEvent);
            } else if (action == 2) {
                O000000o(motionEvent);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            O00000Oo();
            setPressed(false);
        } else {
            setPressed(true);
            O000000o();
            O000000o(motionEvent);
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.BaseSeekbar.O000000o(float, boolean):void
      com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(float, boolean):void
      com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(int, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
    private void O000000o(MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        int width = getWidth();
        int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        int x = (int) motionEvent.getX();
        if (x < getPaddingLeft()) {
            f = 0.0f;
        } else if (x > width - getPaddingRight()) {
            f = 1.0f;
        } else {
            f = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
            f2 = this.O0000OOo;
            float max = (float) getMax();
            f3 = (f * max) + f2;
            if (f3 >= 0.0f) {
                f3 = 0.0f;
            } else if (f3 > max) {
                f3 = max;
            }
            O000000o((int) f3, true);
        }
        f2 = 0.0f;
        float max2 = (float) getMax();
        f3 = (f * max2) + f2;
        if (f3 >= 0.0f) {
        }
        O000000o((int) f3, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.BaseSeekbar.O000000o(float, boolean):void
      com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(float, boolean):void
      com.xiaomi.smarthome.library.common.widget.BaseProgressBar.O000000o(int, boolean):void */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int progress = getProgress();
        if (i != 21) {
            if (i == 22 && progress < getMax()) {
                O000000o(progress + this.O0000Oo, true);
                return true;
            }
        } else if (progress > 0) {
            O000000o(progress - this.O0000Oo, true);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
