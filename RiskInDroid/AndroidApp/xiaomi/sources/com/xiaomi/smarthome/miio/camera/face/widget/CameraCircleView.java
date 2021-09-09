package com.xiaomi.smarthome.miio.camera.face.widget;

import _m_j.civ;
import _m_j.gpc;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class CameraCircleView extends View {
    public static final String TAG = "CameraCircleView";
    private Paint circlePaint;
    public float circleR;
    public float circleX;
    public float circleY;
    Rect destRect;
    private Bitmap four_corners;
    private Paint mBitPaint;
    private int mHeight;
    private int mWidth;
    public float offset;
    private Paint rectPaint;
    Rect srcRect;
    public boolean taked;
    private Paint textPaint;
    private Rect textRect;

    public CameraCircleView(Context context) {
        this(context, null);
    }

    public CameraCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rectPaint = new Paint();
        this.circlePaint = new Paint();
        this.textPaint = new Paint();
        this.mBitPaint = new Paint(1);
        this.taked = false;
        setLayerType(1, null);
        this.circlePaint.setColor(-7829368);
        this.circlePaint.setAntiAlias(true);
        this.circlePaint.setStyle(Paint.Style.FILL);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.rectPaint.setColor(getResources().getColor(R.color.mj_color_white));
        this.rectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        this.rectPaint.setAntiAlias(true);
        this.textPaint.setColor(getResources().getColor(R.color.mj_color_black));
        this.textPaint.setTextSize((float) gpc.O000000o(context, 14.0f));
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.mBitPaint.setFilterBitmap(true);
        this.mBitPaint.setDither(true);
        this.four_corners = BitmapFactory.decodeResource(context.getResources(), R.drawable.mask_face_four_corners);
        this.srcRect = new Rect(0, 0, this.four_corners.getWidth(), this.four_corners.getHeight());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        int i5 = this.mWidth;
        this.circleX = (float) (i5 / 2);
        int i6 = this.mHeight;
        if (i5 >= i6 / 2) {
            this.offset = (float) (i6 / 10);
            this.circleR = (float) (i6 / 5);
            this.circleY = ((float) (i6 / 4)) + this.offset;
        } else if (i6 > i5) {
            this.offset = (float) (i5 / 5);
            this.circleR = ((float) i5) / 2.5f;
            this.circleY = this.circleX + this.offset;
        } else {
            this.circleR = ((float) i6) / 2.5f;
            this.circleY = (float) (i6 / 2);
        }
        String str = TAG;
        civ.O000000o(str, this.mWidth + "-" + this.mHeight);
        String str2 = TAG;
        civ.O000000o(str2, "circleX=" + this.circleX + " circleY" + this.circleY + " circleR" + this.circleR);
        String str3 = TAG;
        StringBuilder sb = new StringBuilder("offset");
        sb.append(this.offset);
        civ.O000000o(str3, sb.toString());
        int i7 = (int) (this.circleY + this.circleR + (this.offset / 2.0f));
        this.textRect = new Rect(0, i7, this.mWidth, i7 + 60);
        double d = (double) this.circleR;
        Double.isNaN(d);
        double d2 = d * 0.6d;
        civ.O000000o(TAG, "anchor=".concat(String.valueOf(d2)));
        float f = this.circleX;
        double d3 = (double) f;
        Double.isNaN(d3);
        int i8 = (int) (d3 - d2);
        float f2 = this.circleY;
        double d4 = (double) f2;
        Double.isNaN(d4);
        int i9 = (int) (d4 - d2);
        double d5 = (double) f;
        Double.isNaN(d5);
        int i10 = (int) (d5 + d2);
        double d6 = (double) f2;
        Double.isNaN(d6);
        String str4 = TAG;
        civ.O000000o(str4, i8 + "-" + i9 + "-" + i10);
        this.destRect = new Rect(i8, i9, i10, (int) (d2 + d6));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect;
        civ.O000000o(TAG, "onDraw...");
        canvas.drawCircle(this.circleX, this.circleY, this.circleR, this.circlePaint);
        canvas.drawRect(0.0f, 0.0f, (float) this.mWidth, (float) this.mHeight, this.rectPaint);
        if (!this.taked) {
            Bitmap bitmap = this.four_corners;
            if (!(bitmap == null || (rect = this.destRect) == null)) {
                canvas.drawBitmap(bitmap, this.srcRect, rect, this.mBitPaint);
            }
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            canvas.drawText(getContext().getString(R.string.camera_take_photo_tips), (float) this.textRect.centerX(), (float) ((int) ((((float) this.textRect.centerY()) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f))), this.textPaint);
        }
    }
}
