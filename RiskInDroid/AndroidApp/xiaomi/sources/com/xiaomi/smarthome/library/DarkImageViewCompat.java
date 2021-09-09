package com.xiaomi.smarthome.library;

import _m_j.gku;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.xiaomi.smarthome.R;

public class DarkImageViewCompat extends AppCompatImageView {
    public DarkImageViewCompat(Context context) {
        this(context, null);
    }

    public DarkImageViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DarkImageViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.dark_pct});
        float f = obtainStyledAttributes.getFloat(0, 0.8f);
        obtainStyledAttributes.recycle();
        if (gku.O000000o(context)) {
            setColorFilter(getColorMatrixColorFilter(f));
        }
    }

    private boolean isInPlugin() {
        String simpleName = getContext().getClass().getSimpleName();
        return simpleName.contains("LoadingBaseActivity") || simpleName.contains("PluginRNActivity") || simpleName.contains("PluginHostActivity");
    }

    public static ColorMatrixColorFilter getColorMatrixColorFilter(float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(f, f, f, 1.0f);
        return new ColorMatrixColorFilter(colorMatrix);
    }
}
