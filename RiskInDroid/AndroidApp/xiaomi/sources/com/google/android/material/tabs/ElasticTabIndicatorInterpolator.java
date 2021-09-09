package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
    }

    private static float decInterp(float f) {
        double d = (double) f;
        Double.isNaN(d);
        return (float) Math.sin((d * 3.141592653589793d) / 2.0d);
    }

    private static float accInterp(float f) {
        double d = (double) f;
        Double.isNaN(d);
        return (float) (1.0d - Math.cos((d * 3.141592653589793d) / 2.0d));
    }

    /* access modifiers changed from: package-private */
    public void setIndicatorBoundsForOffset(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float f2;
        float f3;
        RectF calculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        RectF calculateIndicatorWidthForTab2 = calculateIndicatorWidthForTab(tabLayout, view2);
        if (calculateIndicatorWidthForTab.left < calculateIndicatorWidthForTab2.left) {
            f3 = accInterp(f);
            f2 = decInterp(f);
        } else {
            f3 = decInterp(f);
            f2 = accInterp(f);
        }
        drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, f3), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, f2), drawable.getBounds().bottom);
    }
}
