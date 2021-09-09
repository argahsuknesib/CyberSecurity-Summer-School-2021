package com.youth.banner.transformer;

import android.view.View;

public class StackTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = ((float) (-view.getWidth())) * f;
        }
        view.setTranslationX(f2);
    }
}
