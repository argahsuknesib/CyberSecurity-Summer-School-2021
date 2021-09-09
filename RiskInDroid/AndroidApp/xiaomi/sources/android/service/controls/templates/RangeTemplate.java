package android.service.controls.templates;

import android.os.Bundle;

public final class RangeTemplate extends ControlTemplate {
    private final float mCurrentValue;
    private final CharSequence mFormatString;
    private final float mMaxValue;
    private final float mMinValue;
    private final float mStepValue;

    public final int getTemplateType() {
        return 2;
    }

    public RangeTemplate(String str, float f, float f2, float f3, float f4, CharSequence charSequence) {
        super(str);
        this.mMinValue = f;
        this.mMaxValue = f2;
        this.mCurrentValue = f3;
        this.mStepValue = f4;
        if (charSequence != null) {
            this.mFormatString = charSequence;
        } else {
            this.mFormatString = "%.1f";
        }
        validate();
    }

    RangeTemplate(Bundle bundle) {
        super(bundle);
        this.mMinValue = bundle.getFloat("key_min_value");
        this.mMaxValue = bundle.getFloat("key_max_value");
        this.mCurrentValue = bundle.getFloat("key_current_value");
        this.mStepValue = bundle.getFloat("key_step_value");
        this.mFormatString = bundle.getCharSequence("key_format_string", "%.1f");
        validate();
    }

    public final float getMinValue() {
        return this.mMinValue;
    }

    public final float getMaxValue() {
        return this.mMaxValue;
    }

    public final float getCurrentValue() {
        return this.mCurrentValue;
    }

    public final float getStepValue() {
        return this.mStepValue;
    }

    public final CharSequence getFormatString() {
        return this.mFormatString;
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putFloat("key_min_value", this.mMinValue);
        dataBundle.putFloat("key_max_value", this.mMaxValue);
        dataBundle.putFloat("key_current_value", this.mCurrentValue);
        dataBundle.putFloat("key_step_value", this.mStepValue);
        dataBundle.putCharSequence("key_format_string", this.mFormatString);
        return dataBundle;
    }

    private void validate() {
        if (Float.compare(this.mMinValue, this.mMaxValue) > 0) {
            throw new IllegalArgumentException(String.format("minValue=%f > maxValue=%f", Float.valueOf(this.mMinValue), Float.valueOf(this.mMaxValue)));
        } else if (Float.compare(this.mMinValue, this.mCurrentValue) > 0) {
            throw new IllegalArgumentException(String.format("minValue=%f > currentValue=%f", Float.valueOf(this.mMinValue), Float.valueOf(this.mCurrentValue)));
        } else if (Float.compare(this.mCurrentValue, this.mMaxValue) <= 0) {
            float f = this.mStepValue;
            if (f <= 0.0f) {
                throw new IllegalArgumentException(String.format("stepValue=%f <= 0", Float.valueOf(f)));
            }
        } else {
            throw new IllegalArgumentException(String.format("currentValue=%f > maxValue=%f", Float.valueOf(this.mCurrentValue), Float.valueOf(this.mMaxValue)));
        }
    }
}
