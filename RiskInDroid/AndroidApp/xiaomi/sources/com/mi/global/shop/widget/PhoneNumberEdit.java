package com.mi.global.shop.widget;

import _m_j.byl;
import _m_j.cad;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

public class PhoneNumberEdit extends CustomEditTextView {
    private String mPrefix = "";
    private Rect mPrefixRect = new Rect();

    public PhoneNumberEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (cad.O00000o()) {
            this.mPrefix = byl.O00000oO().getString(R.string.user_address_phoneareacode);
        }
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        TextPaint paint = getPaint();
        String str = this.mPrefix;
        paint.getTextBounds(str, 0, str.length(), this.mPrefixRect);
        Rect rect = this.mPrefixRect;
        rect.right = (int) (((float) rect.right) + getPaint().measureText(" "));
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(this.mPrefix, (float) super.getCompoundPaddingLeft(), (float) getBaseline(), getPaint());
    }

    public int getCompoundPaddingLeft() {
        return super.getCompoundPaddingLeft() + this.mPrefixRect.width() + 10;
    }
}
