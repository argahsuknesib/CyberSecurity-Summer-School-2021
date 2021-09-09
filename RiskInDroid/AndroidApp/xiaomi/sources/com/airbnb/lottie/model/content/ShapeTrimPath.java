package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeTrimPath implements ContentModel {
    private final AnimatableFloatValue end;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableFloatValue start;
    private final Type type;

    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public ShapeTrimPath(String str, Type type2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3) {
        this.name = str;
        this.type = type2;
        this.start = animatableFloatValue;
        this.end = animatableFloatValue2;
        this.offset = animatableFloatValue3;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public AnimatableFloatValue getEnd() {
        return this.end;
    }

    public AnimatableFloatValue getStart() {
        return this.start;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.start + ", end: " + this.end + ", offset: " + this.offset + "}";
    }
}
