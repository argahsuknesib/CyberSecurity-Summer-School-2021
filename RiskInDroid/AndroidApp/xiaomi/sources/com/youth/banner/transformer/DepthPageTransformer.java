package com.youth.banner.transformer;

import android.view.View;

public class DepthPageTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        if (f <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            float abs = ((1.0f - Math.abs(f)) * 0.25f) + 0.75f;
            view.setAlpha(1.0f - f);
            view.setPivotY(((float) view.getHeight()) * 0.5f);
            view.setTranslationX(((float) view.getWidth()) * (-f));
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
