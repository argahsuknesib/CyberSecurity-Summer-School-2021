package com.xiaomi.smarthome.library.common.widget;

import _m_j.gqw;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.google.android.exoplayer2.source.ExtractorMediaSource;

@SuppressLint({"AppCompatCustomView"})
public class AutoSizeTextView extends TextView {
    private gqw mAutoSize;

    private void init() {
    }

    public AutoSizeTextView(Context context) {
        super(context);
        init();
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        gqw autoSize = getAutoSize();
        if (autoSize.O0000OoO > autoSize.O0000Oo && autoSize.O0000Oo > 0.0f && autoSize.O0000Ooo != 0.0f) {
            super.setTextSize(0, (float) autoSize.O000000o((float) View.MeasureSpec.getSize(i), (float) View.MeasureSpec.getSize(i2)));
        }
        super.onMeasure(i, i2);
    }

    public void setTextSize(float f, float f2, int i, int i2) {
        int i3;
        gqw autoSize = getAutoSize();
        DisplayMetrics displayMetrics = autoSize.O0000Oo0.getResources().getDisplayMetrics();
        autoSize.O0000Oo = TypedValue.applyDimension(i2, f, displayMetrics);
        autoSize.O0000OoO = TypedValue.applyDimension(i2, f2, displayMetrics);
        autoSize.O0000Ooo = TypedValue.applyDimension(i2, (float) i, displayMetrics);
        float f3 = autoSize.O0000Oo;
        float f4 = autoSize.O0000OoO;
        float f5 = autoSize.O0000Ooo;
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f3 + "px) is less or equal to (0px)");
        } else if (f4 <= f3) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f4 + "px) is less or equal to minimum auto-size text size (" + f3 + "px)");
        } else if (f5 > 0.0f) {
            autoSize.O00000Oo = 1;
            autoSize.O00000oO = f3;
            autoSize.O00000oo = f4;
            autoSize.O00000o = f5;
            autoSize.O0000O0o = false;
            if (autoSize.O000000o()) {
                if (autoSize.O00000o0) {
                    if (autoSize.O0000OOo.getMeasuredHeight() > 0 && autoSize.O0000OOo.getMeasuredWidth() > 0) {
                        if (((Boolean) gqw.O000000o(autoSize.O0000OOo, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
                            i3 = ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
                        } else {
                            i3 = (autoSize.O0000OOo.getMeasuredWidth() - autoSize.O0000OOo.getTotalPaddingLeft()) - autoSize.O0000OOo.getTotalPaddingRight();
                        }
                        int height = (autoSize.O0000OOo.getHeight() - autoSize.O0000OOo.getCompoundPaddingBottom()) - autoSize.O0000OOo.getCompoundPaddingTop();
                        if (i3 > 0 && height > 0) {
                            synchronized (gqw.f18162O000000o) {
                                float O000000o2 = (float) autoSize.O000000o((float) i3, (float) height);
                                if (O000000o2 != autoSize.O0000OOo.getTextSize()) {
                                    autoSize.O000000o(TypedValue.applyDimension(0, O000000o2, (autoSize.O0000Oo0 == null ? Resources.getSystem() : autoSize.O0000Oo0.getResources()).getDisplayMetrics()));
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                autoSize.O00000o0 = true;
            }
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f5 + "px) is less or equal to (0px)");
        }
    }

    private gqw getAutoSize() {
        if (this.mAutoSize == null) {
            this.mAutoSize = new gqw(this);
        }
        return this.mAutoSize;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        requestLayout();
    }
}
