package com.youth.banner.transformer;

import android.view.View;

public class CubeOutTransformer extends ABaseTransformer {
    public boolean isPagingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        float f2 = 0.0f;
        if (f < 0.0f) {
            f2 = (float) view.getWidth();
        }
        view.setPivotX(f2);
        view.setPivotY(((float) view.getHeight()) * 0.5f);
        view.setRotationY(f * 90.0f);
    }
}
