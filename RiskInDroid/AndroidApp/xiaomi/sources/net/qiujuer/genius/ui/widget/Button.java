package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izx;
import _m_j.jab;
import _m_j.jaf;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.xiaomi.smarthome.R;

public class Button extends android.widget.Button implements izx.O00000o, izx.O00000o0 {
    private izx mTouchDrawable;

    public Button(Context context) {
        this(context, null);
    }

    public Button(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gButtonStyle);
    }

    public Button(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 2132738379);
    }

    @TargetApi(21)
    public Button(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        Typeface O000000o2;
        AttributeSet attributeSet2 = attributeSet;
        if (attributeSet2 != null) {
            Context context = getContext();
            Resources resources = getResources();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, new int[]{R.attr.gFont, R.attr.gInterceptEvent, R.attr.gTouchColor, R.attr.gTouchCornerRadius, R.attr.gTouchCornerRadiusBL, R.attr.gTouchCornerRadiusBR, R.attr.gTouchCornerRadiusTL, R.attr.gTouchCornerRadiusTR, R.attr.gTouchDurationRate, R.attr.gTouchEffect}, i, i2);
            String string = obtainStyledAttributes.getString(0);
            int i3 = obtainStyledAttributes.getInt(9, 0);
            int color = obtainStyledAttributes.getColor(2, 805306368);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(3, resources.getDimensionPixelOffset(R.dimen.g_button_touch_corners_radius));
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(6, dimensionPixelOffset);
            int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(7, dimensionPixelOffset);
            int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(4, dimensionPixelOffset);
            float f = (float) dimensionPixelOffset2;
            float f2 = (float) dimensionPixelOffset3;
            float dimensionPixelOffset5 = (float) obtainStyledAttributes.getDimensionPixelOffset(5, dimensionPixelOffset);
            float f3 = (float) dimensionPixelOffset4;
            jaf jaf = new jaf(new float[]{f, f, f2, f2, dimensionPixelOffset5, dimensionPixelOffset5, f3, f3});
            float f4 = obtainStyledAttributes.getFloat(8, 1.0f);
            int i4 = obtainStyledAttributes.getInt(1, 1);
            obtainStyledAttributes.recycle();
            if (i3 != 0) {
                izx izx = new izx();
                izx.O00000Oo(color);
                izx.O000000o(jab.O000000o(i3));
                izx.O000000o(f4);
                izx.O00000Oo(f4);
                izx.O00000oO = i4;
                if (!isInEditMode()) {
                    izx.O000000o(jaf);
                }
                setTouchDrawable(izx);
            }
            if (!isInEditMode() && string != null && string.length() > 0 && (O000000o2 = izh.O000000o(getContext(), string)) != null) {
                setTypeface(O000000o2);
            }
        }
    }

    public izx getTouchDrawable() {
        return this.mTouchDrawable;
    }

    public void setTouchDrawable(izx izx) {
        izx izx2 = this.mTouchDrawable;
        if (izx2 != izx) {
            if (izx2 != null) {
                izx2.setCallback(null);
            }
            if (izx != null) {
                izx.setCallback(this);
                if (getLayerType() != 1) {
                    setLayerType(1, null);
                }
            }
            this.mTouchDrawable = izx;
        }
    }

    public void setLayerType(int i, Paint paint) {
        if (this.mTouchDrawable != null) {
            i = 1;
        }
        super.setLayerType(i, paint);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            izx.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        izx izx = this.mTouchDrawable;
        return (izx != null && drawable == izx) || super.verifyDrawable(drawable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        izx izx = this.mTouchDrawable;
        if (onTouchEvent && izx != null && isEnabled()) {
            izx.O000000o(motionEvent);
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            izx.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public boolean performClick() {
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            return izx.O000000o(this) && super.performClick();
        }
        return super.performClick();
    }

    public boolean performLongClick() {
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            return izx.O000000o(this) && super.performLongClick();
        }
        return super.performLongClick();
    }

    public void postPerformClick() {
        if (!post(new Runnable() {
            /* class net.qiujuer.genius.ui.widget.Button.AnonymousClass1 */

            public final void run() {
                Button.this.performClick();
            }
        })) {
            performClick();
        }
    }

    public void postPerformLongClick() {
        if (!post(new Runnable() {
            /* class net.qiujuer.genius.ui.widget.Button.AnonymousClass2 */

            public final void run() {
                Button.this.performLongClick();
            }
        })) {
            performLongClick();
        }
    }
}
