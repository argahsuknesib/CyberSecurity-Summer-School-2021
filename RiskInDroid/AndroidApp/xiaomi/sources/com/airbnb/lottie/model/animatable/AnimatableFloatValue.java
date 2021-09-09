package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super((List) list);
    }

    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new FloatKeyframeAnimation(this.keyframes);
    }
}
