package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class CustomDynamicTextView extends TextView {
    public int mCurrentNumber = 0;
    public String mDynamicTextUnit;
    public Handler mHandler = new Handler();
    public int mMaxNumber;
    private Runnable mRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.library.common.widget.CustomDynamicTextView.AnonymousClass1 */

        public final void run() {
            CustomDynamicTextView.this.mCurrentNumber++;
            if (CustomDynamicTextView.this.mCurrentNumber > CustomDynamicTextView.this.mMaxNumber) {
                CustomDynamicTextView.this.mCurrentNumber = 0;
            }
            String str = "";
            for (int i = 0; i < CustomDynamicTextView.this.mCurrentNumber; i++) {
                str = str.concat(CustomDynamicTextView.this.mDynamicTextUnit);
            }
            CustomDynamicTextView.this.setText(CustomDynamicTextView.this.mStaticText + str);
            CustomDynamicTextView.this.mHandler.postDelayed(this, 500);
        }
    };
    public String mStaticText;

    public CustomDynamicTextView(Context context) {
        super(context);
    }

    public CustomDynamicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.dynamic_max_number, R.attr.dynamic_text_unit, R.attr.static_text});
        this.mStaticText = obtainStyledAttributes.getString(2);
        this.mDynamicTextUnit = obtainStyledAttributes.getString(1);
        this.mMaxNumber = obtainStyledAttributes.getInt(0, 3);
        obtainStyledAttributes.recycle();
    }

    public void show() {
        if (getVisibility() != 0) {
            setVisibility(0);
            this.mCurrentNumber = 0;
            setText(this.mStaticText);
            this.mHandler.post(this.mRunnable);
        }
    }

    public void hide() {
        if (8 != getVisibility()) {
            setVisibility(8);
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
