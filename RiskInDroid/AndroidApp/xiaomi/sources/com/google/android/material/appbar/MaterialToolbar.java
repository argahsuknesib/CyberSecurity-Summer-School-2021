package com.google.android.material.appbar;

import _m_j.ab;
import _m_j.cb;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;

public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = 2132739197;
    private Integer navigationIconTint;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        Context context3 = context2;
        AttributeSet attributeSet2 = attributeSet;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context3, attributeSet2, new int[]{R.attr.navigationIconTint}, i, DEF_STYLE_RES, new int[0]);
        if (obtainStyledAttributes.hasValue(0)) {
            setNavigationIconTint(obtainStyledAttributes.getColor(0, -1));
        }
        obtainStyledAttributes.recycle();
        initBackground(context2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.navigationIconTint = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    private void initBackground(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            materialShapeDrawable.initializeElevationOverlay(context);
            materialShapeDrawable.setElevation(cb.O0000oOO(this));
            cb.O000000o(this, materialShapeDrawable);
        }
    }

    private Drawable maybeTintNavigationIcon(Drawable drawable) {
        if (drawable == null || this.navigationIconTint == null) {
            return drawable;
        }
        Drawable O00000oo = ab.O00000oo(drawable);
        ab.O000000o(O00000oo, this.navigationIconTint.intValue());
        return O00000oo;
    }
}
