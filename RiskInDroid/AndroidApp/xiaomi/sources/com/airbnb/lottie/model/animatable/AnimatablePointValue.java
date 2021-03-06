package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new PointKeyframeAnimation(this.keyframes);
    }
}
