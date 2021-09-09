package com.youth.banner.transformer;

import android.view.View;

public class ZoomOutTranformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float abs = Math.abs(f) + 1.0f;
        view.setScaleX(abs);
        view.setScaleY(abs);
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(((float) view.getHeight()) * 0.5f);
        view.setAlpha((f < -1.0f || f > 1.0f) ? 0.0f : 1.0f - (abs - 1.0f));
        if (f == -1.0f) {
            view.setTranslationX((float) (view.getWidth() * -1));
        }
    }
}
