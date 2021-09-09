package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class AnimatableTransform implements ModifierContent, ContentModel {
    private final AnimatablePathValue anchorPoint;
    private final AnimatableFloatValue endOpacity;
    private final AnimatableIntegerValue opacity;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatableFloatValue rotation;
    private final AnimatableScaleValue scale;
    private final AnimatableFloatValue startOpacity;

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public AnimatableTransform() {
        this(new AnimatablePathValue(), new AnimatablePathValue(), new AnimatableScaleValue(), new AnimatableFloatValue(), new AnimatableIntegerValue(), new AnimatableFloatValue(), new AnimatableFloatValue());
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3) {
        this.anchorPoint = animatablePathValue;
        this.position = animatableValue;
        this.scale = animatableScaleValue;
        this.rotation = animatableFloatValue;
        this.opacity = animatableIntegerValue;
        this.startOpacity = animatableFloatValue2;
        this.endOpacity = animatableFloatValue3;
    }

    public AnimatablePathValue getAnchorPoint() {
        return this.anchorPoint;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatableScaleValue getScale() {
        return this.scale;
    }

    public AnimatableFloatValue getRotation() {
        return this.rotation;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getStartOpacity() {
        return this.startOpacity;
    }

    public AnimatableFloatValue getEndOpacity() {
        return this.endOpacity;
    }

    public TransformKeyframeAnimation createAnimation() {
        return new TransformKeyframeAnimation(this);
    }
}
