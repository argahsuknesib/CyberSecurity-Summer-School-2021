package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izj;
import _m_j.jag;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.xiaomi.smarthome.R;

public class TextView extends android.widget.TextView {
    private int mBorder;
    private int mBorderColor;
    private Drawable mBorderDrawable;
    private int mBorderSize;

    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.attr.gTextViewStyle, 2132738387);
    }

    public TextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 2132738387);
    }

    @TargetApi(21)
    public TextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextView.class.getName());
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        Typeface O000000o2;
        if (attributeSet != null) {
            Context context = getContext();
            Resources resources = getResources();
            float f = resources.getDisplayMetrics().density;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.gBorder, R.attr.gBorderColor, R.attr.gBorderSize, R.attr.gFont}, i, i2);
            int i3 = obtainStyledAttributes.getInt(0, 0);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(2, (int) f);
            int color = obtainStyledAttributes.getColor(1, izj.O000000o(resources, (int) R.color.g_default_base_secondary));
            String string = obtainStyledAttributes.getString(3);
            obtainStyledAttributes.recycle();
            setBorder(i3, dimensionPixelOffset, color);
            if (!isInEditMode() && string != null && string.length() > 0 && (O000000o2 = izh.O000000o(getContext(), string)) != null) {
                setTypeface(O000000o2);
            }
        }
    }

    public void setBorder(int i, int i2, int i3) {
        RectF rectF;
        if (this.mBorder != i || this.mBorderSize != i2 || this.mBorderColor != i3) {
            this.mBorder = i;
            this.mBorderSize = i2;
            this.mBorderColor = i3;
            if (i <= 0) {
                this.mBorderDrawable = null;
            } else {
                if ((i & 4369) == 4369) {
                    float f = (float) i2;
                    rectF = new RectF(f, f, f, f);
                } else {
                    int i4 = (i & 1) == 1 ? i2 : 0;
                    int i5 = (i & 16) == 16 ? i2 : 0;
                    int i6 = (i & 256) == 256 ? i2 : 0;
                    if ((i & 4096) != 4096) {
                        i2 = 0;
                    }
                    rectF = new RectF((float) i4, (float) i6, (float) i5, (float) i2);
                }
                Drawable drawable = this.mBorderDrawable;
                if (drawable == null) {
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new jag(rectF));
                    shapeDrawable.getPaint().setColor(i3);
                    shapeDrawable.setCallback(this);
                    this.mBorderDrawable = shapeDrawable;
                } else {
                    ShapeDrawable shapeDrawable2 = (ShapeDrawable) drawable;
                    shapeDrawable2.getPaint().setColor(i3);
                    jag jag = (jag) shapeDrawable2.getShape();
                    if (rectF.left == 0.0f && rectF.top == 0.0f && rectF.right == 0.0f && rectF.bottom == 0.0f) {
                        jag.f1695O000000o = null;
                    } else if (jag.f1695O000000o == null) {
                        jag.f1695O000000o = new RectF(rectF);
                    } else {
                        jag.f1695O000000o.set(rectF);
                    }
                }
            }
            invalidate();
        }
    }

    public int getBorder() {
        return this.mBorder;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderSize() {
        return this.mBorderSize;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.mBorderDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.mBorderDrawable;
        return (drawable2 != null && drawable == drawable2) || super.verifyDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = this.mBorderDrawable;
        if (!(drawable == null || this.mBorderSize <= 0 || this.mBorderColor == 0)) {
            drawable.draw(canvas);
        }
        super.onDraw(canvas);
    }
}
