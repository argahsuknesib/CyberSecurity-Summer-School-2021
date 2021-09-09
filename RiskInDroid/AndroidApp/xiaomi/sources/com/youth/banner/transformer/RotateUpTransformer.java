package com.youth.banner.transformer;

import android.view.View;

public class RotateUpTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(f * -15.0f);
    }
}
