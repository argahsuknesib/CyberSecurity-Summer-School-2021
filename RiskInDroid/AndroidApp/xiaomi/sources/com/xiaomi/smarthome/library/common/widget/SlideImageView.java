package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SlideImageView extends ImageView {
    private Paint mBlackPaint;
    private int mCurrentBlack = 0;
    public Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.SlideImageView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 100) {
                SlideImageView.this.invalidate();
                SlideImageView.this.mHandler.sendEmptyMessageDelayed(100, 300);
            } else if (i == 101) {
                SlideImageView.this.invalidate();
            }
        }
    };
    private Paint mNormalPaint;
    private float[] mPointXs = new float[6];

    public SlideImageView(Context context) {
        super(context);
        init();
    }

    public SlideImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SlideImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: package-private */
    public void init() {
        this.mNormalPaint = new Paint(5);
        this.mNormalPaint.setColor(-3421237);
        this.mBlackPaint = new Paint(5);
        this.mBlackPaint.setColor(-7368817);
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                this.mPointXs[i] = 18.0f;
            } else {
                float[] fArr = this.mPointXs;
                fArr[i] = fArr[i - 1] + 7.0f;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(gri.O000000o(68.0f), gri.O000000o(5.0f));
    }

    public void startConnection() {
        this.mHandler.sendEmptyMessage(100);
    }

    public void stopConnection() {
        this.mHandler.removeMessages(100);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 6; i++) {
            if (i == this.mCurrentBlack) {
                canvas.drawCircle((float) gri.O000000o(this.mPointXs[i]), (float) gri.O000000o(1.5f), (float) gri.O000000o(1.5f), this.mBlackPaint);
            } else {
                canvas.drawCircle((float) gri.O000000o(this.mPointXs[i]), (float) gri.O000000o(1.5f), (float) gri.O000000o(1.5f), this.mNormalPaint);
            }
        }
        int i2 = this.mCurrentBlack + 1;
        this.mCurrentBlack = i2;
        this.mCurrentBlack = i2 % 6;
    }
}
