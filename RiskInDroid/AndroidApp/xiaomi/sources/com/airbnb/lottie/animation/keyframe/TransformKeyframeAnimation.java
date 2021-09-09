package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;

public class TransformKeyframeAnimation {
    private final BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    private final BaseKeyframeAnimation<?, Float> endOpacity;
    private final Matrix matrix = new Matrix();
    private final BaseKeyframeAnimation<Integer, Integer> opacity;
    private final BaseKeyframeAnimation<?, PointF> position;
    private final BaseKeyframeAnimation<Float, Float> rotation;
    private final BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    private final BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.anchorPoint = animatableTransform.getAnchorPoint().createAnimation();
        this.position = animatableTransform.getPosition().createAnimation();
        this.scale = animatableTransform.getScale().createAnimation();
        this.rotation = animatableTransform.getRotation().createAnimation();
        this.opacity = animatableTransform.getOpacity().createAnimation();
        if (animatableTransform.getStartOpacity() != null) {
            this.startOpacity = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.startOpacity = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.endOpacity = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.opacity);
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.startOpacity;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.endOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseLayer.addAnimation(baseKeyframeAnimation2);
        }
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.anchorPoint.addUpdateListener(animationListener);
        this.position.addUpdateListener(animationListener);
        this.scale.addUpdateListener(animationListener);
        this.rotation.addUpdateListener(animationListener);
        this.opacity.addUpdateListener(animationListener);
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.startOpacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.endOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public void setProgress(float f) {
        this.anchorPoint.setProgress(f);
        this.position.setProgress(f);
        this.scale.setProgress(f);
        this.rotation.setProgress(f);
        this.opacity.setProgress(f);
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.startOpacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.endOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
    }

    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.position.getValue();
        if (!(value.x == 0.0f && value.y == 0.0f)) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.rotation.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        ScaleXY value2 = this.scale.getValue();
        if (!(value2.getScaleX() == 1.0f && value2.getScaleY() == 1.0f)) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.anchorPoint.getValue();
        if (!(value3.x == 0.0f && value3.y == 0.0f)) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f) {
        PointF value = this.position.getValue();
        PointF value2 = this.anchorPoint.getValue();
        ScaleXY value3 = this.scale.getValue();
        float floatValue = this.rotation.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        double d = (double) f;
        this.matrix.preScale((float) Math.pow((double) value3.getScaleX(), d), (float) Math.pow((double) value3.getScaleY(), d));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean applyValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            this.anchorPoint.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            this.position.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_SCALE) {
            this.scale.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_ROTATION) {
            this.rotation.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_OPACITY) {
            this.opacity.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_START_OPACITY && (baseKeyframeAnimation2 = this.startOpacity) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        } else if (t != LottieProperty.TRANSFORM_END_OPACITY || (baseKeyframeAnimation = this.endOpacity) == null) {
            return false;
        } else {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return true;
        }
    }
}
