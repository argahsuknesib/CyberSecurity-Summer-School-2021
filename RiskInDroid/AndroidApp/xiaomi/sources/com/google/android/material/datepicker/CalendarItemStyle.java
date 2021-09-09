package com.google.android.material.datepicker;

import _m_j.bf;
import _m_j.cb;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.xiaomi.smarthome.R;

final class CalendarItemStyle {
    private final ColorStateList backgroundColor;
    private final Rect insets;
    private final ShapeAppearanceModel itemShape;
    private final ColorStateList strokeColor;
    private final int strokeWidth;
    private final ColorStateList textColor;

    private CalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, ShapeAppearanceModel shapeAppearanceModel, Rect rect) {
        bf.O000000o(rect.left);
        bf.O000000o(rect.top);
        bf.O000000o(rect.right);
        bf.O000000o(rect.bottom);
        this.insets = rect;
        this.textColor = colorStateList2;
        this.backgroundColor = colorStateList;
        this.strokeColor = colorStateList3;
        this.strokeWidth = i;
        this.itemShape = shapeAppearanceModel;
    }

    static CalendarItemStyle create(Context context, int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{16843191, 16843192, 16843193, 16843194, R.attr.itemFillColor, R.attr.itemShapeAppearance, R.attr.itemShapeAppearanceOverlay, R.attr.itemStrokeColor, R.attr.itemStrokeWidth, R.attr.itemTextColor});
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
            ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, 4);
            ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, 9);
            ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, 7);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
            ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0)).build();
            obtainStyledAttributes.recycle();
            return new CalendarItemStyle(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, build, rect);
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    /* access modifiers changed from: package-private */
    public final void styleItem(TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable2.setShapeAppearanceModel(this.itemShape);
        materialShapeDrawable.setFillColor(this.backgroundColor);
        materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        textView.setTextColor(this.textColor);
        cb.O000000o(textView, new InsetDrawable(Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.textColor.withAlpha(30), materialShapeDrawable, materialShapeDrawable2) : materialShapeDrawable, this.insets.left, this.insets.top, this.insets.right, this.insets.bottom));
    }

    /* access modifiers changed from: package-private */
    public final int getLeftInset() {
        return this.insets.left;
    }

    /* access modifiers changed from: package-private */
    public final int getRightInset() {
        return this.insets.right;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        return this.insets.top;
    }

    /* access modifiers changed from: package-private */
    public final int getBottomInset() {
        return this.insets.bottom;
    }
}
