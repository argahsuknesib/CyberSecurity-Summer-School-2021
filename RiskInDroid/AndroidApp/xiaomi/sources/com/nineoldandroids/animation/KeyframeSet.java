package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet {
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes = new ArrayList<>();
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.mNumKeyframes = keyframeArr.length;
        this.mKeyframes.addAll(Arrays.asList(keyframeArr));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        this.mLastKeyframe = this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }

    public static KeyframeSet ofInt(int... iArr) {
        int length = iArr.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                intKeyframeArr[i] = (Keyframe.IntKeyframe) Keyframe.ofInt(((float) i) / ((float) (length - 1)), iArr[i]);
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofFloat(float... fArr) {
        int length = fArr.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                floatKeyframeArr[i] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(((float) i) / ((float) (length - 1)), fArr[i]);
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < length; i2++) {
            if (keyframeArr[i2] instanceof Keyframe.FloatKeyframe) {
                z = true;
            } else if (keyframeArr[i2] instanceof Keyframe.IntKeyframe) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[length];
            while (i < length) {
                floatKeyframeArr[i] = (Keyframe.FloatKeyframe) keyframeArr[i];
                i++;
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        } else if (!z2 || z || z3) {
            return new KeyframeSet(keyframeArr);
        } else {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[length];
            while (i < length) {
                intKeyframeArr[i] = (Keyframe.IntKeyframe) keyframeArr[i];
                i++;
            }
            return new IntKeyframeSet(intKeyframeArr);
        }
    }

    public static KeyframeSet ofObject(Object... objArr) {
        int length = objArr.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                objectKeyframeArr[i] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(((float) i) / ((float) (length - 1)), objArr[i]);
            }
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
    }

    public KeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = arrayList.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i = 0; i < size; i++) {
            keyframeArr[i] = arrayList.get(i).clone();
        }
        return new KeyframeSet(keyframeArr);
    }

    public Object getValue(float f) {
        int i = this.mNumKeyframes;
        if (i == 2) {
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            return this.mEvaluator.evaluate(f, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        }
        int i2 = 1;
        if (f <= 0.0f) {
            Keyframe keyframe = this.mKeyframes.get(1);
            Interpolator interpolator2 = keyframe.getInterpolator();
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float fraction = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((f - fraction) / (keyframe.getFraction() - fraction), this.mFirstKeyframe.getValue(), keyframe.getValue());
        } else if (f >= 1.0f) {
            Keyframe keyframe2 = this.mKeyframes.get(i - 2);
            Interpolator interpolator3 = this.mLastKeyframe.getInterpolator();
            if (interpolator3 != null) {
                f = interpolator3.getInterpolation(f);
            }
            float fraction2 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((f - fraction2) / (this.mLastKeyframe.getFraction() - fraction2), keyframe2.getValue(), this.mLastKeyframe.getValue());
        } else {
            Keyframe keyframe3 = this.mFirstKeyframe;
            while (i2 < this.mNumKeyframes) {
                Keyframe keyframe4 = this.mKeyframes.get(i2);
                if (f < keyframe4.getFraction()) {
                    Interpolator interpolator4 = keyframe4.getInterpolator();
                    if (interpolator4 != null) {
                        f = interpolator4.getInterpolation(f);
                    }
                    float fraction3 = keyframe3.getFraction();
                    return this.mEvaluator.evaluate((f - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
                }
                i2++;
                keyframe3 = keyframe4;
            }
            return this.mLastKeyframe.getValue();
        }
    }

    public String toString() {
        String str = " ";
        for (int i = 0; i < this.mNumKeyframes; i++) {
            str = str + this.mKeyframes.get(i).getValue() + "  ";
        }
        return str;
    }
}
