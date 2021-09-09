package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    BaseAnimatableValue(Object obj) {
        this(Collections.singletonList(new Keyframe(obj)));
    }

    BaseAnimatableValue(List list) {
        this.keyframes = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb.toString();
    }
}
