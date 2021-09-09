package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

public class Mask {
    private final MaskMode maskMode;
    private final AnimatableShapeValue maskPath;
    private final AnimatableIntegerValue opacity;

    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode2, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue) {
        this.maskMode = maskMode2;
        this.maskPath = animatableShapeValue;
        this.opacity = animatableIntegerValue;
    }

    public MaskMode getMaskMode() {
        return this.maskMode;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.maskPath;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }
}
