package com.airbnb.lottie.model.animatable;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super((List) list);
    }

    public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
        return new ShapeKeyframeAnimation(this.keyframes);
    }
}
