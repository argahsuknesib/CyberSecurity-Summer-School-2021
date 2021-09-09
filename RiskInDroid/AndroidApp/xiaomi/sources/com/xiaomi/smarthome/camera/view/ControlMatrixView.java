package com.xiaomi.smarthome.camera.view;

import _m_j.gsy;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

public class ControlMatrixView extends RelativeLayout {
    private static float FACTOR_MAX = 2.0f;
    private static float FACTOR_MIN = 1.0f;
    private long mBackTime = 200;
    private float mFactor = 1.0f;
    private PointF mFirstTouchPoint;
    private float mHeight;
    private float mLastDst;
    private PointF mLastPoint;
    private ClickListener mListener;
    private Matrix mMatrix;
    private PointF mMidPoint;
    public float mTotalTranslateX;
    public float mTotalTranslateY;
    private long mTouchDownTime;
    private int mTouchMode = -1;
    private float mWidth;

    public interface ClickListener {
        void onClick();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public ControlMatrixView(Context context) {
        super(context);
        init();
    }

    public ControlMatrixView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ControlMatrixView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setListener(ClickListener clickListener) {
        this.mListener = clickListener;
    }

    private void init() {
        this.mMatrix = new Matrix();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mWidth = (float) getMeasuredWidth();
        this.mHeight = (float) getMeasuredHeight();
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.concat(this.mMatrix);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastPoint = new PointF(motionEvent.getX(), motionEvent.getY());
            this.mTouchDownTime = System.currentTimeMillis();
            this.mFirstTouchPoint = this.mLastPoint;
        } else if (action == 1) {
            this.mTouchMode = -1;
            if (System.currentTimeMillis() - this.mTouchDownTime > 300 || Math.abs(motionEvent.getX() - this.mFirstTouchPoint.x) > 10.0f || Math.abs(motionEvent.getY() - this.mFirstTouchPoint.y) > 10.0f) {
                float f = ((this.mFactor - 1.0f) * this.mWidth) / 2.0f;
                if (Math.abs(this.mTotalTranslateX) > f) {
                    float[] fArr = new float[2];
                    float f2 = this.mTotalTranslateX;
                    fArr[0] = f2;
                    if (f2 <= 0.0f) {
                        f = -f;
                    }
                    fArr[1] = f;
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
                    ofFloat.setDuration(this.mBackTime);
                    ofFloat.setInterpolator(new AccelerateInterpolator());
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.xiaomi.smarthome.camera.view.ControlMatrixView.AnonymousClass1 */

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            ControlMatrixView controlMatrixView = ControlMatrixView.this;
                            controlMatrixView.postTranslateDst(floatValue - controlMatrixView.mTotalTranslateX, 0.0f);
                            ControlMatrixView controlMatrixView2 = ControlMatrixView.this;
                            controlMatrixView2.mTotalTranslateX = floatValue;
                            controlMatrixView2.postInvalidate();
                        }
                    });
                    ofFloat.start();
                }
                float f3 = ((this.mFactor - 1.0f) * this.mHeight) / 2.0f;
                if (Math.abs(this.mTotalTranslateY) > f3) {
                    float[] fArr2 = new float[2];
                    float f4 = this.mTotalTranslateY;
                    fArr2[0] = f4;
                    if (f4 <= 0.0f) {
                        f3 = -f3;
                    }
                    fArr2[1] = f3;
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(fArr2);
                    ofFloat2.setDuration(this.mBackTime);
                    ofFloat2.setInterpolator(new AccelerateInterpolator());
                    ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.xiaomi.smarthome.camera.view.ControlMatrixView.AnonymousClass2 */

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            ControlMatrixView controlMatrixView = ControlMatrixView.this;
                            controlMatrixView.postTranslateDst(0.0f, floatValue - controlMatrixView.mTotalTranslateY);
                            ControlMatrixView controlMatrixView2 = ControlMatrixView.this;
                            controlMatrixView2.mTotalTranslateY = floatValue;
                            controlMatrixView2.postInvalidate();
                        }
                    });
                    ofFloat2.start();
                }
            } else {
                ClickListener clickListener = this.mListener;
                if (clickListener != null) {
                    clickListener.onClick();
                }
            }
        } else if (action != 2) {
            if (action == 261) {
                this.mTouchMode = 1;
                this.mLastDst = getDistanceBetweenTwoPoint(motionEvent);
                this.mMidPoint = getMidPointBetweenTwoPoint(motionEvent);
            }
        } else if (this.mTouchMode == -1 && (Math.abs(motionEvent.getX() - this.mFirstTouchPoint.x) > 10.0f || Math.abs(motionEvent.getY() - this.mFirstTouchPoint.y) > 10.0f)) {
            this.mTouchMode = 0;
        }
        return true;
    }

    private void postTranslateMotionEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.mLastPoint.x;
        float y = motionEvent.getY() - this.mLastPoint.y;
        this.mLastPoint = new PointF(motionEvent.getX(), motionEvent.getY());
        gsy.O000000o(4, "ControlMatrix", "per dst:" + x + "-" + y);
        gsy.O000000o(4, "ControlMatrix", "X-Y:" + motionEvent.getX() + "-" + motionEvent.getY());
        gsy.O000000o(4, "ControlMatrix", "X-Y:" + getX() + "-" + getY());
        this.mMatrix.postTranslate(x, y);
        this.mTotalTranslateX = this.mTotalTranslateX + x;
        this.mTotalTranslateY = this.mTotalTranslateY + y;
        gsy.O000000o(4, "ControlMatrix", "total dst:" + this.mTotalTranslateX + "-" + this.mTotalTranslateY);
        postInvalidate();
    }

    public void postTranslateDst(float f, float f2) {
        this.mMatrix.postTranslate(f, f2);
    }

    private void setTranslate(float f, float f2) {
        this.mMatrix.setTranslate(f, f2);
    }

    private void postScaleMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            float distanceBetweenTwoPoint = getDistanceBetweenTwoPoint(motionEvent);
            float f = distanceBetweenTwoPoint / this.mLastDst;
            this.mLastDst = distanceBetweenTwoPoint;
            gsy.O000000o(4, "scale", f + " - " + motionEvent.getPointerCount());
            StringBuilder sb = new StringBuilder();
            sb.append(this.mFactor);
            gsy.O000000o(4, "mFactor", sb.toString());
            float f2 = this.mFactor * f;
            if (f2 >= FACTOR_MIN && f2 <= FACTOR_MAX) {
                this.mFactor = f2;
                this.mMatrix.postScale(f, f, (this.mWidth / 2.0f) + this.mTotalTranslateX, (this.mHeight / 2.0f) + this.mTotalTranslateY);
                postInvalidate();
            }
        }
    }

    private void setScale(float f) {
        this.mMatrix.setScale(f, f, this.mWidth / 2.0f, this.mHeight / 2.0f);
    }

    private float getDistanceBetweenTwoPoint(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return 1.0f;
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private PointF getMidPointBetweenTwoPoint(MotionEvent motionEvent) {
        return new PointF(motionEvent.getX(1) + (motionEvent.getX(0) / 2.0f), (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f);
    }
}
