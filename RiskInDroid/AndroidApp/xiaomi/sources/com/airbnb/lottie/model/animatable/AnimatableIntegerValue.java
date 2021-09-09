package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableIntegerValue() {
        super((Object) 100);
    }

    public AnimatableIntegerValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new IntegerKeyframeAnimation(this.keyframes);
    }
}
