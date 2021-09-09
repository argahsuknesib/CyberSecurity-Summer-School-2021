package com.youth.banner.transformer;

import android.view.View;

public class RotateDownTransformer extends ABaseTransformer {
    /* access modifiers changed from: protected */
    public boolean isPagingEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onTransform(View view, float f) {
        view.setPivotX(((float) view.getWidth()) * 0.5f);
        view.setPivotY((float) view.getHeight());
        view.setRotation(f * -15.0f * -1.25f);
    }
}
