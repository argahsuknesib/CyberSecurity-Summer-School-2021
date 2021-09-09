package com.youth.banner.transformer;

import android.view.View;

public class FlipVerticalTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float f2 = f * -180.0f;
        view.setAlpha((f2 > 90.0f || f2 < -90.0f) ? 0.0f : 1.0f);
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(((float) view.getHeight()) * 0.5f);
        view.setRotationX(f2);
    }

    /* access modifiers changed from: protected */
    public void onPostTransform(View view, float f) {
        super.onPostTransform(view, f);
        if (f <= -0.5f || f >= 0.5f) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }
}
