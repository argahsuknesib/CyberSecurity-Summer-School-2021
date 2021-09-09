package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StarImageView extends ImageView {
    private float mLevel;
    Paint mPaint = new Paint();
    private Bitmap mStarEmpty;
    private Bitmap mStarFull;
    private Bitmap mStarHalf;

    public StarImageView(Context context) {
        super(context);
    }

    public StarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setStartBitmap(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.mStarFull = bitmap;
        this.mStarHalf = bitmap2;
        this.mStarEmpty = bitmap3;
    }

    public void setLevel(float f) {
        this.mLevel = f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.mStarFull;
        if (bitmap != null) {
            float f = this.mLevel;
            if (f <= 0.0f) {
                canvas.drawBitmap(this.mStarEmpty, 0.0f, 0.0f, this.mPaint);
            } else if (((double) f) <= 0.5d) {
                canvas.drawBitmap(this.mStarHalf, 0.0f, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
            }
            int width = this.mStarEmpty.getWidth() + 0 + gri.O000000o(5.0f);
            float f2 = this.mLevel;
            if (f2 <= 1.0f) {
                canvas.drawBitmap(this.mStarEmpty, (float) width, 0.0f, this.mPaint);
            } else if (((double) f2) <= 1.5d) {
                canvas.drawBitmap(this.mStarHalf, (float) width, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(this.mStarFull, (float) width, 0.0f, this.mPaint);
            }
            int width2 = width + this.mStarEmpty.getWidth() + gri.O000000o(5.0f);
            float f3 = this.mLevel;
            if (f3 <= 2.0f) {
                canvas.drawBitmap(this.mStarEmpty, (float) width2, 0.0f, this.mPaint);
            } else if (((double) f3) <= 2.5d) {
                canvas.drawBitmap(this.mStarHalf, (float) width2, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(this.mStarFull, (float) width2, 0.0f, this.mPaint);
            }
            int width3 = width2 + this.mStarEmpty.getWidth() + gri.O000000o(5.0f);
            float f4 = this.mLevel;
            if (f4 <= 3.0f) {
                canvas.drawBitmap(this.mStarEmpty, (float) width3, 0.0f, this.mPaint);
            } else if (((double) f4) <= 3.5d) {
                canvas.drawBitmap(this.mStarHalf, (float) width3, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(this.mStarFull, (float) width3, 0.0f, this.mPaint);
            }
            int width4 = width3 + this.mStarEmpty.getWidth() + gri.O000000o(5.0f);
            float f5 = this.mLevel;
            if (f5 <= 4.0f) {
                canvas.drawBitmap(this.mStarEmpty, (float) width4, 0.0f, this.mPaint);
            } else if (((double) f5) <= 4.5d) {
                canvas.drawBitmap(this.mStarHalf, (float) width4, 0.0f, this.mPaint);
            } else {
                canvas.drawBitmap(this.mStarFull, (float) width4, 0.0f, this.mPaint);
            }
        }
    }
}
