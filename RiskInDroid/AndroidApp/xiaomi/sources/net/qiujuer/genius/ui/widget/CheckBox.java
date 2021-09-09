package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.xiaomi.smarthome.R;

public class CheckBox extends android.widget.CheckBox {
    private izp mMarkDrawable;

    public CheckBox(Context context) {
        super(context);
        init(null, R.attr.gCheckBoxStyle, 2132738381);
    }

    public CheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.attr.gCheckBoxStyle, 2132738381);
    }

    public CheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 2132738381);
    }

    @TargetApi(21)
    public CheckBox(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(CheckBox.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CheckBox.class.getName());
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        Typeface O000000o2;
        Context context = getContext();
        Resources resources = getResources();
        float f = resources.getDisplayMetrics().density;
        int i3 = (int) (2.0f * f);
        if (attributeSet == null) {
            this.mMarkDrawable = new izp(resources.getColorStateList(R.color.g_default_check_box));
            setButtonDrawable(this.mMarkDrawable);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.gBorderSize, R.attr.gFont, R.attr.gIntervalSize, R.attr.gMarkColor, R.attr.gMarkSize}, i, i2);
        boolean z = false;
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(0, i3);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(2, i3);
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(4, -1);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        if (colorStateList == null) {
            colorStateList = resources.getColorStateList(R.color.g_default_check_box);
        }
        if (dimensionPixelOffset3 < 0) {
            dimensionPixelOffset3 = (int) (f * 22.0f);
        } else {
            z = true;
        }
        this.mMarkDrawable = new izp(colorStateList);
        this.mMarkDrawable.O00000Oo(dimensionPixelOffset);
        this.mMarkDrawable.O00000o0(dimensionPixelOffset2);
        this.mMarkDrawable.O000000o(dimensionPixelOffset3, z);
        this.mMarkDrawable.O000000o(isInEditMode());
        setButtonDrawable(this.mMarkDrawable);
        if (!isInEditMode() && string != null && string.length() > 0 && (O000000o2 = izh.O000000o(getContext(), string)) != null) {
            setTypeface(O000000o2);
        }
    }

    public void setBorderSize(int i) {
        this.mMarkDrawable.O00000Oo(i);
    }

    public void setIntervalSize(int i) {
        this.mMarkDrawable.O00000o0(i);
    }

    public void setMarkSize(int i) {
        this.mMarkDrawable.O000000o(i, true);
    }

    public int getBorderSize() {
        return this.mMarkDrawable.O0000Oo0;
    }

    public int getIntervalSize() {
        return this.mMarkDrawable.O0000Oo;
    }

    public int getMarkSize() {
        return this.mMarkDrawable.O0000OoO;
    }

    public void setMarkColor(int i) {
        this.mMarkDrawable.O000000o(i);
    }

    public void setMarkColor(ColorStateList colorStateList) {
        this.mMarkDrawable.O000000o(colorStateList);
    }

    public ColorStateList getMarkColor() {
        return this.mMarkDrawable.f1672O000000o;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshDrawableState();
    }
}
