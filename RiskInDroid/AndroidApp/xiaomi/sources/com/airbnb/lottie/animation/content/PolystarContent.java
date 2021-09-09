package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private TrimPathContent trimPath;
    private final PolystarShape.Type type;

    public PolystarContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable2;
        this.name = polystarShape.getName();
        this.type = polystarShape.getType();
        this.pointsAnimation = polystarShape.getPoints().createAnimation();
        this.positionAnimation = polystarShape.getPosition().createAnimation();
        this.rotationAnimation = polystarShape.getRotation().createAnimation();
        this.outerRadiusAnimation = polystarShape.getOuterRadius().createAnimation();
        this.outerRoundednessAnimation = polystarShape.getOuterRoundedness().createAnimation();
        if (this.type == PolystarShape.Type.Star) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(this.pointsAnimation);
        baseLayer.addAnimation(this.positionAnimation);
        baseLayer.addAnimation(this.rotationAnimation);
        baseLayer.addAnimation(this.outerRadiusAnimation);
        baseLayer.addAnimation(this.outerRoundednessAnimation);
        if (this.type == PolystarShape.Type.Star) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        this.pointsAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
        this.rotationAnimation.addUpdateListener(this);
        this.outerRadiusAnimation.addUpdateListener(this);
        this.outerRoundednessAnimation.addUpdateListener(this);
        if (this.type == PolystarShape.Type.Star) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.Simultaneously) {
                    this.trimPath = trimPathContent;
                    this.trimPath.addListener(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
        }
        this.path.close();
        Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
        this.isPathValid = true;
        return this.path;
    }

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = new int[PolystarShape.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.Star.ordinal()] = 1;
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.Polygon.ordinal()] = 2;
        }
    }

    public String getName() {
        return this.name;
    }

    private void createStarPath() {
        double d;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float floatValue = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d3 = (double) floatValue;
        Double.isNaN(d3);
        float f17 = (float) (6.283185307179586d / d3);
        float f18 = f17 / 2.0f;
        float f19 = floatValue - ((float) ((int) floatValue));
        if (f19 != 0.0f) {
            double d4 = (double) ((1.0f - f19) * f18);
            Double.isNaN(d4);
            radians += d4;
        }
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.getValue().floatValue() / 100.0f : 0.0f;
        if (f19 != 0.0f) {
            float f20 = ((floatValue2 - floatValue3) * f19) + floatValue3;
            double d5 = (double) f20;
            double cos = Math.cos(radians);
            Double.isNaN(d5);
            d = d3;
            float f21 = (float) (d5 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d5);
            float f22 = (float) (d5 * sin);
            this.path.moveTo(f21, f22);
            double d6 = (double) ((f17 * f19) / 2.0f);
            Double.isNaN(d6);
            d2 = radians + d6;
            f3 = f21;
            f = f20;
            f5 = floatValue2;
            float f23 = f18;
            f2 = f22;
            f4 = f23;
        } else {
            d = d3;
            f5 = floatValue2;
            double d7 = (double) f5;
            double cos2 = Math.cos(radians);
            Double.isNaN(d7);
            f4 = f18;
            f3 = (float) (d7 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d7);
            f2 = (float) (d7 * sin2);
            this.path.moveTo(f3, f2);
            double d8 = (double) f4;
            Double.isNaN(d8);
            d2 = radians + d8;
            f = 0.0f;
        }
        double ceil = Math.ceil(d) * 2.0d;
        int i = 0;
        double d9 = d2;
        boolean z = false;
        while (true) {
            double d10 = (double) i;
            if (d10 < ceil) {
                float f24 = z ? f5 : floatValue3;
                if (f == 0.0f || d10 != ceil - 2.0d) {
                    f6 = f24;
                    f7 = f4;
                } else {
                    f6 = f24;
                    f7 = (f17 * f19) / 2.0f;
                }
                if (f == 0.0f || d10 != ceil - 1.0d) {
                    f8 = f17;
                    f10 = f6;
                    f9 = f5;
                } else {
                    f8 = f17;
                    f9 = f5;
                    f10 = f;
                }
                double d11 = (double) f10;
                double cos3 = Math.cos(d9);
                Double.isNaN(d11);
                double d12 = d10;
                float f25 = (float) (d11 * cos3);
                double sin3 = Math.sin(d9);
                Double.isNaN(d11);
                float f26 = (float) (d11 * sin3);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.path.lineTo(f25, f26);
                    f11 = f26;
                    f14 = f4;
                    f13 = floatValue3;
                    f12 = floatValue4;
                    f15 = floatValue5;
                    f16 = f7;
                } else {
                    f14 = f4;
                    f13 = floatValue3;
                    f12 = floatValue4;
                    double atan2 = (double) ((float) (Math.atan2((double) f2, (double) f3) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    f15 = floatValue5;
                    float f27 = f7;
                    f11 = f26;
                    double atan22 = (double) ((float) (Math.atan2((double) f26, (double) f25) - 1.5707963267948966d));
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f28 = z ? f12 : f15;
                    float f29 = z ? f15 : f12;
                    float f30 = (z ? f13 : f9) * f28 * 0.47829f;
                    float f31 = cos4 * f30;
                    float f32 = f30 * sin4;
                    float f33 = (z ? f9 : f13) * f29 * 0.47829f;
                    float f34 = cos5 * f33;
                    float f35 = f33 * sin5;
                    if (f19 != 0.0f) {
                        if (i == 0) {
                            f31 *= f19;
                            f32 *= f19;
                        } else if (d12 == ceil - 1.0d) {
                            f34 *= f19;
                            f35 *= f19;
                        }
                    }
                    this.path.cubicTo(f3 - f31, f2 - f32, f25 + f34, f11 + f35, f25, f11);
                    f16 = f27;
                }
                double d13 = (double) f16;
                Double.isNaN(d13);
                d9 += d13;
                z = !z;
                i++;
                floatValue5 = f15;
                f3 = f25;
                f4 = f14;
                f5 = f9;
                f17 = f8;
                floatValue3 = f13;
                floatValue4 = f12;
                f2 = f11;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void createPolygonPath() {
        double d;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor((double) this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d4 = (double) floor;
        Double.isNaN(d4);
        float floatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d5 = (double) floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d5);
        float f = (float) (cos * d5);
        double sin = Math.sin(radians);
        Double.isNaN(d5);
        float f2 = (float) (sin * d5);
        this.path.moveTo(f, f2);
        double d6 = (double) ((float) (6.283185307179586d / d4));
        Double.isNaN(d6);
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (((double) i2) < ceil) {
            double cos2 = Math.cos(d7);
            Double.isNaN(d5);
            float f3 = (float) (cos2 * d5);
            double sin2 = Math.sin(d7);
            Double.isNaN(d5);
            double d8 = ceil;
            float f4 = (float) (d5 * sin2);
            if (floatValue != 0.0f) {
                d3 = d5;
                i = i2;
                d2 = d7;
                double atan2 = (double) ((float) (Math.atan2((double) f2, (double) f) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d = d6;
                double atan22 = (double) ((float) (Math.atan2((double) f4, (double) f3) - 1.5707963267948966d));
                float f5 = floatValue2 * floatValue * 0.25f;
                this.path.cubicTo(f - (cos3 * f5), f2 - (((float) Math.sin(atan2)) * f5), f3 + (((float) Math.cos(atan22)) * f5), f4 + (f5 * ((float) Math.sin(atan22))), f3, f4);
            } else {
                d2 = d7;
                d3 = d5;
                d = d6;
                i = i2;
                this.path.lineTo(f3, f4);
            }
            Double.isNaN(d);
            d7 = d2 + d;
            i2 = i + 1;
            f2 = f4;
            f = f3;
            ceil = d8;
            d5 = d3;
            d6 = d;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }
}
