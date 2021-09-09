package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class WaveView extends View {
    private final int MSG_DRAW;
    private float mCenterY;
    public Handler mHandler;
    public boolean mIsWaveChange;
    public float mLenStep;
    private int mLevel;
    public float mNeedWaveHeight;
    private Paint mPaint;
    private Path mPath;
    private int mScreenHeight;
    private int mScreenWidth;
    public float mStep;
    private int mWaveCount;
    public float mWaveHeight;
    public float mWaveLength;
    public float offset;
    public float offset2;
    public float offset3;
    float pCenterX;
    float pCenterY;
    float pEndX;
    float pEndY;
    float pStartX;
    float pStartY;

    private int getVolInt(int i) {
        if (i < 30) {
            return 0;
        }
        if (i < 40) {
            return 1;
        }
        if (i < 50) {
            return 2;
        }
        if (i < 53) {
            return 3;
        }
        if (i < 56) {
            return 4;
        }
        if (i < 60) {
            return 5;
        }
        return i < 65 ? 6 : 7;
    }

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 0.0f;
        this.offset2 = 0.0f;
        this.offset3 = 0.0f;
        this.mWaveCount = 4;
        this.MSG_DRAW = 1001;
        this.mStep = 0.0f;
        this.mLevel = 2;
        this.mIsWaveChange = false;
        this.mNeedWaveHeight = 0.0f;
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setColor(Color.parseColor("#89aef3"));
        this.mPaint.setAntiAlias(true);
        this.mPath = new Path();
        this.mHandler = new Handler(new Handler.Callback() {
            /* class com.xiaomi.smarthome.camera.view.widget.WaveView.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                if (message.what != 1001) {
                    return true;
                }
                WaveView.this.offset += WaveView.this.mStep;
                WaveView waveView = WaveView.this;
                waveView.offset2 = waveView.offset2 + WaveView.this.mStep + 3.0f;
                WaveView waveView2 = WaveView.this;
                waveView2.offset3 = waveView2.offset3 + WaveView.this.mStep + 5.0f;
                if (WaveView.this.offset >= WaveView.this.mWaveLength * 2.0f) {
                    WaveView.this.offset = 0.0f;
                }
                if (WaveView.this.offset2 >= WaveView.this.mWaveLength * 2.0f) {
                    WaveView.this.offset2 = 0.0f;
                }
                if (WaveView.this.offset3 >= WaveView.this.mWaveLength * 2.0f) {
                    WaveView.this.offset3 = 0.0f;
                }
                if (WaveView.this.mIsWaveChange) {
                    WaveView.this.mWaveHeight += WaveView.this.mLenStep;
                    if (WaveView.this.mLenStep > 0.0f) {
                        if (WaveView.this.mWaveHeight >= WaveView.this.mNeedWaveHeight) {
                            WaveView.this.mIsWaveChange = false;
                        }
                    } else if (WaveView.this.mWaveHeight <= WaveView.this.mNeedWaveHeight) {
                        WaveView.this.mIsWaveChange = false;
                    }
                }
                WaveView.this.invalidate();
                WaveView.this.mHandler.sendEmptyMessageDelayed(1001, 20);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mCenterY = (float) (i2 / 2);
        this.mWaveLength = (float) (i / this.mWaveCount);
        this.mWaveHeight = this.mCenterY / 4.0f;
        this.mScreenHeight = i2;
        this.mScreenWidth = i;
        this.mStep = (this.mWaveLength * 2.0f) / 60.0f;
        startAnimator();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPath.reset();
        float f = ((-this.mWaveLength) * 2.0f) + this.offset;
        this.mPath.moveTo(f, this.mCenterY);
        for (int i = 0; i < this.mWaveCount + 2; i++) {
            float f2 = this.mWaveLength;
            this.pStartX = (((float) i) * f2) + f;
            float f3 = this.mCenterY;
            this.pStartY = f3;
            this.pCenterX = this.pStartX + (f2 / 2.0f);
            if (i % 2 != 0) {
                this.pCenterY = f3 + this.mWaveHeight;
            } else {
                this.pCenterY = f3 - this.mWaveHeight;
            }
            float f4 = this.pCenterX;
            this.pEndX = (this.mWaveLength / 2.0f) + f4;
            this.pEndY = this.pStartY;
            this.mPath.quadTo(f4, this.pCenterY, this.pEndX, this.pEndY);
        }
        this.mPaint.setAlpha(255);
        canvas.drawPath(this.mPath, this.mPaint);
        float f5 = ((-this.mWaveLength) * 2.0f) + this.offset2;
        this.mPath.reset();
        this.mPath.moveTo(f5, this.mCenterY);
        for (int i2 = 0; i2 < this.mWaveCount + 2; i2++) {
            float f6 = this.mWaveLength;
            this.pStartX = (((float) i2) * f6) + f5;
            float f7 = this.mCenterY;
            this.pStartY = f7;
            this.pCenterX = this.pStartX + (f6 / 2.0f);
            if (i2 % 2 != 0) {
                this.pCenterY = f7 + this.mWaveHeight;
            } else {
                this.pCenterY = f7 - this.mWaveHeight;
            }
            float f8 = this.pCenterX;
            this.pEndX = (this.mWaveLength / 2.0f) + f8;
            this.pEndY = this.pStartY;
            this.mPath.quadTo(f8, this.pCenterY, this.pEndX, this.pEndY);
        }
        this.mPaint.setAlpha(77);
        canvas.drawPath(this.mPath, this.mPaint);
        float f9 = ((-this.mWaveLength) * 2.0f) + this.offset3;
        this.mPath.reset();
        this.mPath.moveTo(f9, this.mCenterY);
        for (int i3 = 0; i3 < this.mWaveCount + 2; i3++) {
            float f10 = this.mWaveLength;
            this.pStartX = (((float) i3) * f10) + f9;
            float f11 = this.mCenterY;
            this.pStartY = f11;
            this.pCenterX = this.pStartX + (f10 / 2.0f);
            if (i3 % 2 != 0) {
                this.pCenterY = f11 + this.mWaveHeight;
            } else {
                this.pCenterY = f11 - this.mWaveHeight;
            }
            float f12 = this.pCenterX;
            this.pEndX = (this.mWaveLength / 2.0f) + f12;
            this.pEndY = this.pStartY;
            this.mPath.quadTo(f12, this.pCenterY, this.pEndX, this.pEndY);
        }
        this.mPaint.setAlpha(153);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public void startAnimator() {
        if (this.mWaveLength != 0.0f) {
            this.mHandler.sendEmptyMessage(1001);
        }
    }

    public void stopAnimator() {
        this.mHandler.removeMessages(1001);
    }

    public void setVolume(int i) {
        int volInt;
        if (!this.mIsWaveChange && this.mLevel != (volInt = getVolInt(i) + 1)) {
            this.mIsWaveChange = true;
            this.mLevel = volInt;
            this.mNeedWaveHeight = (this.mCenterY * ((float) this.mLevel)) / 8.0f;
            this.mLenStep = (this.mNeedWaveHeight - this.mWaveHeight) / 20.0f;
        }
    }
}
