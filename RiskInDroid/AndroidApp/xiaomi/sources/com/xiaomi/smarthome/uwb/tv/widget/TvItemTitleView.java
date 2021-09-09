package com.xiaomi.smarthome.uwb.tv.widget;

import _m_j.gpc;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TvItemTitleView extends AppCompatTextView {
    int mLeftMargin = gpc.O000000o(7.0f);
    Paint mPaint;
    int mRectHeight = gpc.O000000o(10.0f);
    int mTopMargin = gpc.O000000o(2.0f);

    public TvItemTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
