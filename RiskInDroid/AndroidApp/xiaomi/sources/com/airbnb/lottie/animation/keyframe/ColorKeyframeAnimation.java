package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public Integer getValue(Keyframe<Integer> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) keyframe.startValue).intValue();
        int intValue2 = ((Integer) keyframe.endValue).intValue();
        if (this.valueCallback != null) {
            Integer num = (Integer) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, getLinearCurrentKeyframeProgress(), getProgress());
            if (num != null) {
                return num;
            }
        }
        return Integer.valueOf(GammaEvaluator.evaluate(f, intValue, intValue2));
    }
}
