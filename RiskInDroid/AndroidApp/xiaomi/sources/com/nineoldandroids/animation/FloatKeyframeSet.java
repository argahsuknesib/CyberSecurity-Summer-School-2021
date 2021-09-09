package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet {
    private float deltaValue;
    private boolean firstTime = true;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
    }

    public Object getValue(float f) {
        return Float.valueOf(getFloatValue(f));
    }

    public FloatKeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i = 0; i < size; i++) {
            floatKeyframeArr[i] = (Keyframe.FloatKeyframe) ((Keyframe) arrayList.get(i)).clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public float getFloatValue(float f) {
        float floatValue;
        float f2;
        float floatValue2;
        float floatValue3;
        float f3;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                this.lastValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            if (this.mEvaluator != null) {
                return ((Number) this.mEvaluator.evaluate(f, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
            }
            floatValue = this.firstValue;
            f2 = this.deltaValue;
        } else {
            if (f <= 0.0f) {
                Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
                Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.mKeyframes.get(1);
                floatValue2 = floatKeyframe.getFloatValue();
                floatValue3 = floatKeyframe2.getFloatValue();
                float fraction = floatKeyframe.getFraction();
                float fraction2 = floatKeyframe2.getFraction();
                Interpolator interpolator = floatKeyframe2.getInterpolator();
                if (interpolator != null) {
                    f = interpolator.getInterpolation(f);
                }
                f3 = (f - fraction) / (fraction2 - fraction);
                if (this.mEvaluator != null) {
                    return ((Number) this.mEvaluator.evaluate(f3, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
                }
            } else if (f >= 1.0f) {
                Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
                Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
                floatValue2 = floatKeyframe3.getFloatValue();
                floatValue3 = floatKeyframe4.getFloatValue();
                float fraction3 = floatKeyframe3.getFraction();
                float fraction4 = floatKeyframe4.getFraction();
                Interpolator interpolator2 = floatKeyframe4.getInterpolator();
                if (interpolator2 != null) {
                    f = interpolator2.getInterpolation(f);
                }
                f3 = (f - fraction3) / (fraction4 - fraction3);
                if (this.mEvaluator != null) {
                    return ((Number) this.mEvaluator.evaluate(f3, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
                }
            } else {
                Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
                int i = 1;
                while (i < this.mNumKeyframes) {
                    Keyframe.FloatKeyframe floatKeyframe6 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i);
                    if (f < floatKeyframe6.getFraction()) {
                        Interpolator interpolator3 = floatKeyframe6.getInterpolator();
                        if (interpolator3 != null) {
                            f = interpolator3.getInterpolation(f);
                        }
                        f = (f - floatKeyframe5.getFraction()) / (floatKeyframe6.getFraction() - floatKeyframe5.getFraction());
                        floatValue = floatKeyframe5.getFloatValue();
                        float floatValue4 = floatKeyframe6.getFloatValue();
                        if (this.mEvaluator != null) {
                            return ((Number) this.mEvaluator.evaluate(f, Float.valueOf(floatValue), Float.valueOf(floatValue4))).floatValue();
                        }
                        f2 = floatValue4 - floatValue;
                    } else {
                        i++;
                        floatKeyframe5 = floatKeyframe6;
                    }
                }
                return ((Number) ((Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).floatValue();
            }
            return floatValue2 + (f3 * (floatValue3 - floatValue2));
        }
        return floatValue + (f * f2);
    }
}
