package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {
    private int deltaValue;
    private boolean firstTime = true;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
    }

    public Object getValue(float f) {
        return Integer.valueOf(getIntValue(f));
    }

    public IntKeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i = 0; i < size; i++) {
            intKeyframeArr[i] = (Keyframe.IntKeyframe) ((Keyframe) arrayList.get(i)).clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public int getIntValue(float f) {
        int intValue;
        int i;
        int intValue2;
        int intValue3;
        float f2;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                this.lastValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            if (this.mEvaluator != null) {
                return ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
            }
            intValue = this.firstValue;
            i = this.deltaValue;
        } else {
            if (f <= 0.0f) {
                Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
                Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.mKeyframes.get(1);
                intValue2 = intKeyframe.getIntValue();
                intValue3 = intKeyframe2.getIntValue();
                float fraction = intKeyframe.getFraction();
                float fraction2 = intKeyframe2.getFraction();
                Interpolator interpolator = intKeyframe2.getInterpolator();
                if (interpolator != null) {
                    f = interpolator.getInterpolation(f);
                }
                f2 = (f - fraction) / (fraction2 - fraction);
                if (this.mEvaluator != null) {
                    return ((Number) this.mEvaluator.evaluate(f2, Integer.valueOf(intValue2), Integer.valueOf(intValue3))).intValue();
                }
            } else if (f >= 1.0f) {
                Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
                Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
                intValue2 = intKeyframe3.getIntValue();
                intValue3 = intKeyframe4.getIntValue();
                float fraction3 = intKeyframe3.getFraction();
                float fraction4 = intKeyframe4.getFraction();
                Interpolator interpolator2 = intKeyframe4.getInterpolator();
                if (interpolator2 != null) {
                    f = interpolator2.getInterpolation(f);
                }
                f2 = (f - fraction3) / (fraction4 - fraction3);
                if (this.mEvaluator != null) {
                    return ((Number) this.mEvaluator.evaluate(f2, Integer.valueOf(intValue2), Integer.valueOf(intValue3))).intValue();
                }
            } else {
                Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
                int i2 = 1;
                while (i2 < this.mNumKeyframes) {
                    Keyframe.IntKeyframe intKeyframe6 = (Keyframe.IntKeyframe) this.mKeyframes.get(i2);
                    if (f < intKeyframe6.getFraction()) {
                        Interpolator interpolator3 = intKeyframe6.getInterpolator();
                        if (interpolator3 != null) {
                            f = interpolator3.getInterpolation(f);
                        }
                        f = (f - intKeyframe5.getFraction()) / (intKeyframe6.getFraction() - intKeyframe5.getFraction());
                        intValue = intKeyframe5.getIntValue();
                        int intValue4 = intKeyframe6.getIntValue();
                        if (this.mEvaluator != null) {
                            return ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(intValue), Integer.valueOf(intValue4))).intValue();
                        }
                        i = intValue4 - intValue;
                    } else {
                        i2++;
                        intKeyframe5 = intKeyframe6;
                    }
                }
                return ((Number) ((Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).intValue();
            }
            return intValue2 + ((int) (f2 * ((float) (intValue3 - intValue2))));
        }
        return intValue + ((int) (f * ((float) i)));
    }
}
