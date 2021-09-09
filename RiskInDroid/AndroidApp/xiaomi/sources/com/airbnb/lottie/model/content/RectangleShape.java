package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RectangleShape implements ContentModel {
    private final AnimatableFloatValue cornerRadius;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue) {
        this.name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.cornerRadius = animatableFloatValue;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.cornerRadius;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.position + ", size=" + this.size + '}';
    }
}
