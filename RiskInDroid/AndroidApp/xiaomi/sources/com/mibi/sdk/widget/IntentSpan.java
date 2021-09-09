package com.mibi.sdk.widget;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class IntentSpan extends ClickableSpan {
    private int mColor;
    private Context mContext;
    private OnClickListener mOnClickListener;
    private String mTitle;
    private String mUrl;

    public interface OnClickListener {
        void onClick(String str, String str2);
    }

    public IntentSpan(Context context, String str, String str2) {
        this(context, str, str2, 17170435);
    }

    public IntentSpan(Context context, String str, String str2, int i) {
        this.mContext = context;
        this.mTitle = str;
        this.mUrl = str2;
        this.mColor = i;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(true);
        textPaint.setColor(this.mContext.getResources().getColor(this.mColor));
    }

    public void onClick(View view) {
        OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.mUrl, this.mTitle);
        }
    }
}
