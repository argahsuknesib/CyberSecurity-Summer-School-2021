package com.youth.banner.transformer;

import android.view.View;

public class ZoomInTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float f2 = 0.0f;
        float abs = f < 0.0f ? f + 1.0f : Math.abs(1.0f - f);
        view.setScaleX(abs);
        view.setScaleY(abs);
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(((float) view.getHeight()) * 0.5f);
        if (f >= -1.0f && f <= 1.0f) {
            f2 = 1.0f - (abs - 1.0f);
        }
        view.setAlpha(f2);
    }
}
