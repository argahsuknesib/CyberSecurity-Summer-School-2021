package com.xiaomi.smarthome.camera.view.widget;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView;

public class Info {
    RectF mBaseRect = new RectF();
    float mDegrees;
    RectF mImgRect = new RectF();
    RectF mRect = new RectF();
    float mScale;
    ImageView.ScaleType mScaleType;
    PointF mScreenCenter = new PointF();
    RectF mWidgetRect = new RectF();

    public Info(RectF rectF, RectF rectF2, RectF rectF3, RectF rectF4, PointF pointF, float f, float f2, ImageView.ScaleType scaleType) {
        this.mRect.set(rectF);
        this.mImgRect.set(rectF2);
        this.mWidgetRect.set(rectF3);
        this.mScale = f;
        this.mScaleType = scaleType;
        this.mDegrees = f2;
        this.mBaseRect.set(rectF4);
        this.mScreenCenter.set(pointF);
    }
}
