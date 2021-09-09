package com.xiaomi.smarthome.camera.v4.view;

import _m_j.gsy;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView;

public class DirectionCtrlViewNewPanoram extends DirectionCtrlView {
    AttributeSet attrs;
    int defStyleAttr = 0;
    private int imageSize = 0;
    int padding = 0;

    public DirectionCtrlViewNewPanoram(Context context) {
        super(context);
    }

    public DirectionCtrlViewNewPanoram(Context context, boolean z, float f) {
        super(context);
        this.mScale = f;
        this.supportCenterClick = z;
    }

    public DirectionCtrlViewNewPanoram(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attrs = attributeSet;
    }

    public DirectionCtrlViewNewPanoram(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.attrs = attributeSet;
        this.defStyleAttr = i;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.imageSize = Math.min(i, i2);
        init(this.attrs, this.defStyleAttr);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            i3 = getPaddingRight() + getPaddingLeft() + size;
        } else {
            i3 = getPaddingLeft() + this.mBitmapRockerDisable.getWidth() + getPaddingRight();
        }
        if (mode2 == 1073741824 || mode == Integer.MIN_VALUE) {
            i4 = getPaddingBottom() + getPaddingTop() + size2;
        } else {
            i4 = getPaddingTop() + this.mBitmapRockerDisable.getHeight() + getPaddingBottom();
        }
        int min = Math.min(i3, i4);
        setMeasuredDimension(min, min);
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
            float x = motionEvent.getX() - ((float) this.padding);
            float y = motionEvent.getY() - ((float) this.padding);
            float f = x - ((float) this.mRadius);
            float f2 = y - ((float) this.mRadius);
            if (Math.sqrt((double) ((f * f) + (f2 * f2))) <= ((double) this.mRadius)) {
                if (this.supportCenterClick && x > ((float) this.mCenterEdge) && x < ((float) (this.mDiameter - this.mCenterEdge)) && y > ((float) this.mCenterEdge) && y < ((float) (this.mDiameter - this.mCenterEdge))) {
                    this.isPress = true;
                    this.direction = 0;
                    invalidate();
                } else if (x < ((float) this.mRadius) && y > x && y < ((float) this.mDiameter) - x) {
                    this.isPress = true;
                    this.direction = 1;
                    invalidate();
                } else if (y >= ((float) this.mRadius) || x >= ((float) this.mRadius) ? y < ((float) this.mDiameter) - x : y < x) {
                    this.isPress = true;
                    this.direction = 3;
                    invalidate();
                } else if (x <= ((float) this.mRadius) || y >= ((float) this.mRadius) ? y < x : y > ((float) this.mDiameter) - x) {
                    this.isPress = true;
                    this.direction = 2;
                    invalidate();
                } else if (y <= ((float) this.mRadius) || x >= ((float) this.mRadius) ? y > x : y > ((float) this.mDiameter) - x) {
                    this.isPress = true;
                    this.direction = 4;
                    invalidate();
                }
                if (!(this.direction == 0 || !this.isPress || this.mOnDirectionCtrlListener == null)) {
                    this.mOnDirectionCtrlListener.onActionDown();
                }
                if (this.direction != 0 && this.isPress) {
                    performHapticFeedback(0, 2);
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
        if (this.imageSize > 0) {
            if (!(attributeSet == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.view_scale})) == null)) {
                this.mScale = obtainStyledAttributes.getFloat(0, 1.0f);
                obtainStyledAttributes.recycle();
            }
            this.mPaint = new Paint();
            this.mPaint.setColor(-7829368);
            this.mPaint.setAntiAlias(true);
            setBackgroundColor(0);
            if (i2 == 1) {
                this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_center_new);
            } else {
                this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_bg);
            }
            int width = (int) (((float) this.bitmap.getWidth()) * this.mScale);
            int height = (int) (((float) this.bitmap.getHeight()) * this.mScale);
            int i3 = this.imageSize;
            if (i3 < height) {
                this.bitmap = Bitmap.createScaledBitmap(this.bitmap, i3, i3, true);
                width = i3;
                height = width;
            }
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.bitmap = Bitmap.createScaledBitmap(this.bitmap, width, height, true);
            }
            this.mBgWidth = this.bitmap.getWidth();
            this.padding = (this.imageSize - this.mBgWidth) / 2;
            this.mDiameter = this.mBgWidth;
            this.mRadius = this.mBgWidth / 2;
            gsy.O00000Oo("DirectionCtrlViewNew", "padding=" + this.padding);
            double d = (double) ((float) this.mDiameter);
            Double.isNaN(d);
            this.mCenterEdge = (int) (d / 2.8d);
            if (i2 == 1) {
                this.mPtzTop = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_top_new);
            } else {
                this.mPtzTop = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_up_press);
            }
            this.mPtzTop = Bitmap.createScaledBitmap(this.mPtzTop, width, height, true);
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.mPtzTop = Bitmap.createScaledBitmap(this.mPtzTop, width, height, true);
            }
            this.mArrowW = this.mPtzTop.getWidth();
            this.mArrowH = this.mPtzTop.getHeight();
            if (i2 == 1) {
                this.mPtzBottom = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bottom_new);
            } else {
                this.mPtzBottom = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_down_press);
            }
            this.mPtzBottom = Bitmap.createScaledBitmap(this.mPtzBottom, width, height, true);
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.mPtzBottom = Bitmap.createScaledBitmap(this.mPtzBottom, width, height, true);
            }
            if (i2 == 1) {
                this.mPtzLeft = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_left_new);
            } else {
                this.mPtzLeft = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_left_press);
            }
            this.mPtzLeft = Bitmap.createScaledBitmap(this.mPtzLeft, width, height, true);
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.mPtzLeft = Bitmap.createScaledBitmap(this.mPtzLeft, width, height, true);
            }
            if (i2 == 1) {
                this.mPtzRight = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_right_new);
            } else {
                this.mPtzRight = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_right_press);
            }
            this.mPtzRight = Bitmap.createScaledBitmap(this.mPtzRight, width, height, true);
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.mPtzRight = Bitmap.createScaledBitmap(this.mPtzRight, width, height, true);
            }
            if (i2 == 1) {
                this.mPtzCenter = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_center_new_pres);
            } else {
                this.mPtzCenter = null;
            }
            if (this.mPtzCenter != null) {
                width = (int) (((float) this.mPtzCenter.getWidth()) * this.mScale);
                height = (int) (((float) this.mPtzCenter.getHeight()) * this.mScale);
                this.mPtzCenter = Bitmap.createScaledBitmap(this.mPtzCenter, width, height, true);
                if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                    this.mPtzCenter = Bitmap.createScaledBitmap(this.mPtzCenter, width, height, true);
                }
            }
            if (i2 == 1) {
                this.mBitmapRockerDisable = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_center_new);
            } else {
                this.mBitmapRockerDisable = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_bg);
            }
            this.mBitmapRockerDisable = Bitmap.createScaledBitmap(this.mBitmapRockerDisable, width, height, true);
            if (Math.abs(this.mScale - 1.0f) > this.threshold) {
                this.mBitmapRockerDisable = Bitmap.createScaledBitmap(this.mBitmapRockerDisable, width, height, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void canvasOk(Canvas canvas) {
        try {
            if (this.mIsDisabled) {
                canvas.drawBitmap(this.bitmap, (float) this.padding, (float) this.padding, this.mPaint);
                if (this.isPress) {
                    int i = this.direction;
                    if (i != 0) {
                        if (i == 1) {
                            canvas.drawBitmap(this.mPtzLeft, (float) this.padding, (float) this.padding, this.mPaint);
                        } else if (i == 2) {
                            canvas.drawBitmap(this.mPtzRight, (float) this.padding, (float) this.padding, this.mPaint);
                        } else if (i == 3) {
                            canvas.drawBitmap(this.mPtzTop, (float) this.padding, (float) this.padding, this.mPaint);
                        } else if (i == 4) {
                            canvas.drawBitmap(this.mPtzBottom, (float) this.padding, (float) this.padding, this.mPaint);
                        }
                    } else if (this.mPtzCenter != null) {
                        canvas.drawBitmap(this.mPtzCenter, (float) this.padding, (float) this.padding, this.mPaint);
                    }
                }
            } else {
                canvas.drawBitmap(this.mBitmapRockerDisable, (float) this.padding, (float) this.padding, this.mPaint);
            }
            if (canvas == null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (canvas != null) {
            }
        }
    }
}
