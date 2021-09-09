package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AlarmSelectView extends View implements View.OnTouchListener {
    private final int STATUS_LIVE3;
    private final int STATUS_NONE;
    private boolean isDown;
    private IAlarmChangeListener mChangeListener;
    private float mDeviceHeight;
    private float mDeviceWidth;
    int[][] mDownItems;
    private float mHeight;
    int[][] mItems;
    private final int mLineCount;
    int[][] mOldItems;
    int[] mPainColors;
    Paint mPainLine;
    Paint mPainLive;
    private float mRatio;
    private final int mRawCount;
    private float mSpaceHeight;
    private float mSpaceWidth;
    private float mWidth;

    public interface IAlarmChangeListener {
        void onChange();
    }

    public AlarmSelectView(Context context) {
        this(context, null);
    }

    public AlarmSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AlarmSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.STATUS_NONE = 0;
        this.STATUS_LIVE3 = 3;
        this.mDeviceHeight = 1088.0f;
        this.mDeviceWidth = 1920.0f;
        this.mRatio = 0.0f;
        this.isDown = false;
        this.mWidth = 0.0f;
        this.mHeight = 0.0f;
        this.mLineCount = 8;
        this.mRawCount = 4;
        this.mOldItems = (int[][]) Array.newInstance(int.class, 4, 8);
        this.mItems = (int[][]) Array.newInstance(int.class, 4, 8);
        this.mDownItems = (int[][]) Array.newInstance(int.class, 4, 8);
        init();
    }

    private void init() {
        this.mPainColors = new int[4];
        this.mPainColors[0] = Color.argb(0, 0, 0, 0);
        this.mPainColors[1] = Color.argb(0, 122, 227, 0);
        this.mPainColors[2] = Color.argb(0, 255, 192, 0);
        this.mPainColors[3] = Color.argb(0, 226, 0, 0);
        this.mPainLine = new Paint();
        this.mPainLine.setAntiAlias(true);
        this.mPainLine.setStrokeWidth(3.0f);
        this.mPainLine.setColor(getResources().getColor(R.color.mj_color_white));
        this.mPainLine.setStyle(Paint.Style.STROKE);
        this.mPainLive = new Paint();
        this.mPainLive.setAntiAlias(true);
        this.mPainLive.setStyle(Paint.Style.FILL);
        this.mRatio = this.mDeviceWidth / this.mDeviceHeight;
        setOnTouchListener(this);
    }

    public void setSelectStatus(int[][] iArr) {
        this.mItems = iArr;
        copyArray(this.mOldItems, this.mItems);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                float f = ((float) i2) * this.mSpaceHeight;
                float f2 = ((float) i3) * this.mSpaceWidth;
                RectF rectF = new RectF();
                rectF.left = f2;
                rectF.top = f;
                rectF.bottom = f + this.mSpaceHeight;
                rectF.right = f2 + this.mSpaceWidth;
                if (this.isDown) {
                    i = this.mDownItems[i2][i3];
                } else {
                    i = this.mItems[i2][i3];
                }
                this.mPainLive.setColor(this.mPainColors[i]);
                this.mPainLive.setAlpha(102);
                canvas.drawRect(rectF, this.mPainLive);
            }
        }
        for (int i4 = 1; i4 <= 8; i4++) {
            float f3 = this.mSpaceWidth * ((float) i4);
            canvas.drawLine(f3, 0.0f, f3, this.mHeight, this.mPainLine);
        }
        for (int i5 = 1; i5 <= 4; i5++) {
            float f4 = this.mSpaceHeight * ((float) i5);
            canvas.drawLine(0.0f, f4, this.mWidth, f4, this.mPainLine);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mWidth = (float) View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        float f = this.mWidth;
        this.mHeight = f / this.mRatio;
        this.mSpaceWidth = f / 8.0f;
        float f2 = this.mHeight;
        this.mSpaceHeight = f2 / 4.0f;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) f2, mode));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.isDown = true;
            copyArray(this.mDownItems, this.mItems);
            int min = x > 0.0f ? Math.min((int) (x / this.mSpaceWidth), 7) : 0;
            int min2 = y > 0.0f ? Math.min((int) (y / this.mSpaceHeight), 3) : 0;
            int[][] iArr = this.mDownItems;
            int i = iArr[min2][min];
            if (i == 3) {
                iArr[min2][min] = 0;
            } else {
                iArr[min2][min] = i + 1;
            }
        } else if (motionEvent.getAction() == 1) {
            this.isDown = false;
            if (x < 0.0f || y < 0.0f || y > this.mHeight) {
                invalidate();
                return true;
            }
            int min3 = x > 0.0f ? Math.min((int) (x / this.mSpaceWidth), 7) : 0;
            int min4 = y > 0.0f ? Math.min((int) (y / this.mSpaceHeight), 3) : 0;
            int[][] iArr2 = this.mDownItems;
            if (iArr2[min4][min3] == this.mItems[min4][min3]) {
                int i2 = iArr2[min4][min3];
                if (i2 == 3) {
                    iArr2[min4][min3] = 0;
                } else {
                    iArr2[min4][min3] = i2 + 1;
                }
            }
            copyArray(this.mItems, this.mDownItems);
            IAlarmChangeListener iAlarmChangeListener = this.mChangeListener;
            if (iAlarmChangeListener != null) {
                iAlarmChangeListener.onChange();
            }
            invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (x < 0.0f || y < 0.0f || y > this.mHeight) {
                return true;
            }
            int min5 = x > 0.0f ? Math.min((int) (x / this.mSpaceWidth), 7) : 0;
            int min6 = y > 0.0f ? Math.min((int) (y / this.mSpaceHeight), 3) : 0;
            int[][] iArr3 = this.mDownItems;
            int i3 = iArr3[min6][min5];
            int[][] iArr4 = this.mItems;
            if (i3 == iArr4[min6][min5]) {
                int i4 = iArr4[min6][min5];
                if (i4 == 3) {
                    iArr3[min6][min5] = 0;
                } else {
                    iArr3[min6][min5] = i4 + 1;
                }
                invalidate();
            }
        } else if (motionEvent.getAction() == 3) {
            this.isDown = false;
            invalidate();
        }
        invalidate();
        return true;
    }

    private void copyArray(int[][] iArr, int[][] iArr2) {
        for (int i = 0; i < 4; i++) {
            iArr[i] = Arrays.copyOf(iArr2[i], 8);
        }
    }

    public boolean isChange() {
        if (!(this.mItems == null || this.mOldItems == null)) {
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 8; i2++) {
                    if (this.mItems[i][i2] != this.mOldItems[i][i2]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCloseAll() {
        if (this.mItems == null) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                if (this.mItems[i][i2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        copyArray(this.mItems, this.mOldItems);
        invalidate();
    }

    public int[][] getCurrentItems() {
        return this.mItems;
    }

    public void setChangeListener(IAlarmChangeListener iAlarmChangeListener) {
        this.mChangeListener = iAlarmChangeListener;
    }
}
