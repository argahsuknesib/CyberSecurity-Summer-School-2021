package com.smarthome.connect.view;

import _m_j.ddg;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class BaseBindView extends RelativeLayout implements ddg {

    public enum StepStatus {
        LOADING,
        SUCCESS,
        FAILED
    }

    public void O000000o() {
    }

    public void O000000o(int i) {
    }

    public void O000000o(int i, int i2) {
    }

    public void O000000o(StepStatus stepStatus, int i, int i2) {
    }

    public void O000000o(StepStatus stepStatus, String str, int i) {
    }

    public void O000000o(String str, String str2) {
    }

    public void setProgress(int i) {
    }

    public BaseBindView(Context context) {
        super(context);
    }

    public BaseBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseBindView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
