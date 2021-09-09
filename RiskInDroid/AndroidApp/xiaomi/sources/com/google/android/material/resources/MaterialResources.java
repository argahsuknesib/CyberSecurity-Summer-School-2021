package com.google.android.material.resources;

import _m_j.OO0000o;
import _m_j.Oo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        int color;
        int resourceId;
        ColorStateList O000000o2;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0 && (O000000o2 = OO0000o.O000000o(context, resourceId)) != null) {
            return O000000o2;
        }
        if (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i, -1)) == -1) {
            return typedArray.getColorStateList(i);
        }
        return ColorStateList.valueOf(color);
    }

    public static ColorStateList getColorStateList(Context context, Oo oo, int i) {
        int O00000Oo;
        int O0000O0o;
        ColorStateList O000000o2;
        if (oo.O0000O0o(i) && (O0000O0o = oo.O0000O0o(i, 0)) != 0 && (O000000o2 = OO0000o.O000000o(context, O0000O0o)) != null) {
            return O000000o2;
        }
        if (Build.VERSION.SDK_INT > 15 || (O00000Oo = oo.O00000Oo(i, -1)) == -1) {
            return oo.O00000oO(i);
        }
        return ColorStateList.valueOf(O00000Oo);
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable O00000Oo;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (O00000Oo = OO0000o.O00000Oo(context, resourceId)) == null) {
            return typedArray.getDrawable(i);
        }
        return O00000Oo;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i2);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean isFontScaleAtLeast2_0(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    static int getIndexWithValue(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
