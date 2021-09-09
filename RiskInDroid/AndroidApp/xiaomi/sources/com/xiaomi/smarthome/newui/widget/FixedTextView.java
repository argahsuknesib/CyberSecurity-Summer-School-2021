package com.xiaomi.smarthome.newui.widget;

import _m_j.gri;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class FixedTextView extends TextView {
    private static final String TAG = "FixedTextView";
    private int mOneCharWidth;
    private float mTextSize;
    private int mXmlWidth;

    public FixedTextView(Context context) {
        this(context, null);
    }

    public FixedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextSize = getTextSize();
        this.mOneCharWidth = measureOneCharWidth();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842996}, i, 0);
        try {
            int O000000o2 = getResources().getDisplayMetrics().widthPixels - gri.O000000o(72.0f);
            this.mXmlWidth = obtainStyledAttributes.getLayoutDimension(0, -1);
            if (this.mXmlWidth == -1) {
                this.mXmlWidth = O000000o2;
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private int measureOneCharWidth() {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.mTextSize);
        return (int) textPaint.measureText("字");
    }

    public void setText(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            setText(handleStartListTextView(charSequence.toString(), i));
        }
    }

    private String handleStartListTextView(String str, int i) {
        int i2 = this.mOneCharWidth * i;
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        int measureText = (int) (((float) i2) + paint.measureText(""));
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        float f = 0.0f;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            float measureText2 = paint.measureText(charArray, i3, 1);
            if (((float) measureText) - f < measureText2) {
                return ((Object) str.subSequence(0, i3)) + "...";
            }
            f += measureText2;
        }
        return str;
    }

    public void setTextAutoCutOff(CharSequence charSequence, String str) {
        if (!TextUtils.isEmpty(charSequence)) {
            setText(getCutOffTextIfNeed(charSequence.toString(), str));
        }
    }

    private String getCutOffTextIfNeed(String str, String str2) {
        int i = this.mXmlWidth;
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        int measureText = (int) (((float) i) + paint.measureText(""));
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        float f = 0.0f;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            float measureText2 = paint.measureText(charArray, i2, 1);
            if (((float) measureText) - f < measureText2) {
                String substring = str.substring(0, i2);
                if (str2 != null && substring.contains(str2)) {
                    substring = substring.substring(0, substring.lastIndexOf(str2));
                }
                return substring + "...";
            }
            f += measureText2;
        }
        return str;
    }
}
