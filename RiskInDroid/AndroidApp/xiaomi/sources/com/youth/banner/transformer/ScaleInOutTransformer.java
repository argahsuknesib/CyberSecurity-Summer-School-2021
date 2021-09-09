package com.youth.banner.transformer;

import android.view.View;

public class ScaleInOutTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        view.setPivotX(f < 0.0f ? 0.0f : (float) view.getWidth());
        view.setPivotY(((float) view.getHeight()) / 2.0f);
        float f2 = f < 0.0f ? f + 1.0f : 1.0f - f;
        view.setScaleX(f2);
        view.setScaleY(f2);
    }
}
