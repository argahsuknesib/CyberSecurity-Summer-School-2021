package com.google.android.material.elevation;

import _m_j.q;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.xiaomi.smarthome.R;

public class ElevationOverlayProvider {
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(context, (int) R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(context, (int) R.attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f, View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f) {
        return compositeOverlayIfNeeded(this.colorSurface, f);
    }

    public int compositeOverlayIfNeeded(int i, float f, View view) {
        return compositeOverlayIfNeeded(i, f + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayIfNeeded(int i, float f) {
        return (!this.elevationOverlayEnabled || !isThemeSurfaceColor(i)) ? i : compositeOverlay(i, f);
    }

    public int compositeOverlay(int i, float f, View view) {
        return compositeOverlay(i, f + getParentAbsoluteElevation(view));
    }

    public int compositeOverlay(int i, float f) {
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f);
        return q.O00000Oo(MaterialColors.layer(q.O00000Oo(i, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction), Color.alpha(i));
    }

    public int calculateOverlayAlpha(float f) {
        return Math.round(calculateOverlayAlphaFraction(f) * 255.0f);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public float calculateOverlayAlphaFraction(float f) {
        float f2 = this.displayDensity;
        if (f2 <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p((double) (f / f2))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public float getParentAbsoluteElevation(View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    private boolean isThemeSurfaceColor(int i) {
        return q.O00000Oo(i, 255) == this.colorSurface;
    }
}
