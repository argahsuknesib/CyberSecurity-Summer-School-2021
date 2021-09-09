package com.xiaomi.smarthome.camera.v4.view;

import _m_j.gsy;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView;

public class DirectionCtrlViewSingle extends DirectionCtrlView {
    int rightD;

    public DirectionCtrlViewSingle(Context context) {
        super(context);
        init(null, 0);
    }

    public DirectionCtrlViewSingle(Context context, boolean z, float f) {
        super(context);
        this.mScale = f;
        this.supportCenterClick = z;
        init(null, 0);
    }

    public DirectionCtrlViewSingle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public DirectionCtrlViewSingle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (getVisibility() != 0) {
            return false;
        }
        if (!this.mIsDisabled) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownTime = System.currentTimeMillis();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            gsy.O00000Oo("DirectionCtrlView2", "x=" + x + " y=" + y);
            if (y < ((float) this.mCenterEdge) || y > ((float) this.rightD)) {
                this.direction = -1;
            } else {
                gsy.O00000Oo("DirectionCtrlView2", "mCenterEdge=" + this.mCenterEdge + " rightD=" + this.rightD + " supportCenterClick=" + this.supportCenterClick);
                if (this.supportCenterClick && x >= ((float) this.mCenterEdge) && x <= ((float) this.rightD)) {
                    this.isPress = true;
                    this.direction = 0;
                    invalidate();
                } else if (x < ((float) this.mRadius)) {
                    this.isPress = true;
                    this.direction = 1;
                    invalidate();
                } else if (x > ((float) this.mRadius)) {
                    this.isPress = true;
                    this.direction = 2;
                    invalidate();
                }
                if (!(this.direction == 0 || !this.isPress || this.mOnDirectionCtrlListener == null)) {
                    this.mOnDirectionCtrlListener.onActionDown();
                }
                if (this.direction != 0 && this.isPress) {
                    getHandler().post(this.directionRunnable);
                }
            }
        } else if (action == 1 || (action != 2 && action == 3)) {
            this.isPress = false;
            if (this.direction == 0 && this.mOnDirectionCtrlListener != null) {
                this.mOnDirectionCtrlListener.onCenterClick();
            }
            if (this.mOnDirectionCtrlListener != null) {
                DirectionCtrlView.OnDirectionCtrlListener onDirectionCtrlListener = this.mOnDirectionCtrlListener;
                if (System.currentTimeMillis() - this.mDownTime > 500) {
                    z = true;
                }
                onDirectionCtrlListener.onActionUp(z);
            }
            this.direction = -1;
            getHandler().removeCallbacks(this.directionRunnable);
            invalidate();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.view_scale})) == null)) {
            this.mScale = obtainStyledAttributes.getFloat(0, 1.0f);
            obtainStyledAttributes.recycle();
        }
        this.mPaint = new Paint();
        this.mPaint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        setBackgroundColor(0);
        if (i2 != 1) {
            this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_bg_single);
        } else if (this.supportCenterClick) {
            this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_single);
        } else {
            this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_single_nocenter);
        }
        int width = (int) (((float) this.bitmap.getWidth()) * this.mScale);
        int height = (int) (((float) this.bitmap.getHeight()) * this.mScale);
        if (Math.abs(this.mScale - 1.0f) > this.threshold) {
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, width, height, true);
        }
        this.mBgWidth = this.bitmap.getWidth();
        this.mDiameter = this.mBgWidth;
        this.mRadius = this.mBgWidth / 2;
        this.mCenterEdge = (int) (((float) this.mDiameter) / 3.0f);
        this.rightD = this.mDiameter - this.mCenterEdge;
        if (i2 == 1) {
            this.mPtzTop = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_top);
        } else {
            this.mPtzTop = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_up_press);
        }
        int width2 = (int) (((float) this.mPtzTop.getWidth()) * this.mScale);
        int height2 = (int) (((float) this.mPtzTop.getHeight()) * this.mScale);
        if (Math.abs(this.mScale - 1.0f) > this.threshold) {
            this.mPtzTop = Bitmap.createScaledBitmap(this.mPtzTop, width2, height2, true);
        }
        this.mArrowW = this.mPtzTop.getWidth();
        this.mArrowH = this.mPtzTop.getHeight();
        if (i2 == 1) {
            this.mPtzBottom = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bottom);
        } else {
            this.mPtzBottom = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_down_press);
        }
        int width3 = (int) (((float) this.mPtzBottom.getWidth()) * this.mScale);
        int height3 = (int) (((float) this.mPtzBottom.getHeight()) * this.mScale);
        if (Math.abs(this.mScale - 1.0f) > this.threshold) {
            this.mPtzBottom = Bitmap.createScaledBitmap(this.mPtzBottom, width3, height3, true);
        }
        if (i2 == 1) {
            this.mPtzLeft = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_left_single);
        } else {
            this.mPtzLeft = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_left_press_single);
        }
        int width4 = (int) (((float) this.mPtzLeft.getWidth()) * this.mScale);
        int height4 = (int) (((float) this.mPtzLeft.getHeight()) * this.mScale);
        if (Math.abs(this.mScale - 1.0f) > this.threshold) {
            this.mPtzLeft = Bitmap.createScaledBitmap(this.mPtzLeft, width4, height4, true);
        }
        if (i2 == 1) {
            this.mPtzRight = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_right_single);
        } else {
            this.mPtzRight = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_right_press_single);
        }
        int width5 = (int) (((float) this.mPtzRight.getWidth()) * this.mScale);
        int height5 = (int) (((float) this.mPtzRight.getHeight()) * this.mScale);
        if (Math.abs(this.mScale - 1.0f) > this.threshold) {
            this.mPtzRight = Bitmap.createScaledBitmap(this.mPtzRight, width5, height5, true);
        }
        if (i2 != 1) {
            this.mPtzCenter = null;
        } else if (this.supportCenterClick) {
            this.mPtzCenter = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_center_single);
        } else {
            this.mPtzCenter = null;
        }
        if (this.mPtzCenter != null) {
            int width6 = (int) (((float) this.mPtzCenter.getWidth()) * this.mScale);
            int height6 = (int) (((float) this.mPtzCenter.getHeight()) * this.mScale);
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.mPtzCenter = Bitmap.createScaledBitmap(this.mPtzCenter, width6, height6, true);
            }
        }
        if (i2 == 1) {
            this.mBitmapRockerDisable = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_single);
        } else {
            this.mBitmapRockerDisable = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_bg);
        }
        int width7 = (int) (((float) this.mBitmapRockerDisable.getWidth()) * this.mScale);
        int height7 = (int) (((float) this.mBitmapRockerDisable.getHeight()) * this.mScale);
        if (Math.abs(this.mScale - 1.0f) > this.threshold) {
            this.mBitmapRockerDisable = Bitmap.createScaledBitmap(this.mBitmapRockerDisable, width7, height7, true);
        }
    }
}
