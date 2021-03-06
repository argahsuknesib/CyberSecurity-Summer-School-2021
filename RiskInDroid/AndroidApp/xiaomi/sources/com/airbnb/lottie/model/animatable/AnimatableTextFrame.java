package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableTextFrame(List<Keyframe<DocumentData>> list) {
        super((List) list);
    }

    public TextKeyframeAnimation createAnimation() {
        return new TextKeyframeAnimation(this.keyframes);
    }
}
