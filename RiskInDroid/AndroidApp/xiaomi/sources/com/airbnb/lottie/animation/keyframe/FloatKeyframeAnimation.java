package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    public Float getValue(Keyframe<Float> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.valueCallback != null) {
            Float f2 = (Float) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), getProgress());
            if (f2 != null) {
                return f2;
            }
        }
        return Float.valueOf(MiscUtils.lerp(((Float) keyframe.startValue).floatValue(), ((Float) keyframe.endValue).floatValue(), f));
    }
}
