package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;
import java.util.ArrayList;

public class StoreHouseHeader extends View implements PtrUIHandler {
    private AniController mAniController = new AniController();
    private float mBarDarkAlpha = 0.4f;
    private int mDrawZoneHeight = 0;
    private int mDrawZoneWidth = 0;
    private int mDropHeight = -1;
    public float mFromAlpha = 1.0f;
    private int mHorizontalRandomness = -1;
    private float mInternalAnimationFactor = 0.7f;
    private boolean mIsInLoading = false;
    public ArrayList<StoreHouseBarItem> mItemList = new ArrayList<>();
    private int mLineWidth = -1;
    public int mLoadingAniDuration = 1000;
    public int mLoadingAniItemDuration = 400;
    public int mLoadingAniSegDuration = 1000;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private float mProgress = 0.0f;
    private float mScale = 1.0f;
    private int mTextColor = -1;
    public float mToAlpha = 0.4f;
    private Transformation mTransformation = new Transformation();

    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
    }

    public StoreHouseHeader(Context context) {
        super(context);
        initView();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        PtrLocalDisplay.init(getContext());
        this.mLineWidth = PtrLocalDisplay.dp2px(1.0f);
        this.mDropHeight = PtrLocalDisplay.dp2px(40.0f);
        this.mHorizontalRandomness = PtrLocalDisplay.SCREEN_WIDTH_PIXELS / 2;
    }

    private void setProgress(float f) {
        this.mProgress = f;
    }

    public int getLoadingAniDuration() {
        return this.mLoadingAniDuration;
    }

    public void setLoadingAniDuration(int i) {
        this.mLoadingAniDuration = i;
        this.mLoadingAniSegDuration = i;
    }

    public StoreHouseHeader setLineWidth(int i) {
        this.mLineWidth = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setLineWidth(i);
        }
        return this;
    }

    public StoreHouseHeader setTextColor(int i) {
        this.mTextColor = i;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            this.mItemList.get(i2).setColor(i);
        }
        return this;
    }

    public StoreHouseHeader setDropHeight(int i) {
        this.mDropHeight = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.mDrawZoneHeight + getBottomOffset(), 1073741824));
        this.mOffsetX = (getMeasuredWidth() - this.mDrawZoneWidth) / 2;
        this.mOffsetY = getTopOffset();
        this.mDropHeight = getTopOffset();
    }

    private int getTopOffset() {
        return getPaddingTop() + PtrLocalDisplay.dp2px(10.0f);
    }

    private int getBottomOffset() {
        return getPaddingBottom() + PtrLocalDisplay.dp2px(10.0f);
    }

    public void initWithString(String str) {
        initWithString(str, 25);
    }

    public void initWithString(String str, int i) {
        initWithPointList(StoreHousePath.getPath(str, ((float) i) * 0.01f, 14));
    }

    public void initWithStringArray(int i) {
        String[] stringArray = getResources().getStringArray(i);
        ArrayList arrayList = new ArrayList();
        for (String split : stringArray) {
            String[] split2 = split.split(",");
            float[] fArr = new float[4];
            for (int i2 = 0; i2 < 4; i2++) {
                fArr[i2] = Float.parseFloat(split2[i2]);
            }
            arrayList.add(fArr);
        }
        initWithPointList(arrayList);
    }

    public float getScale() {
        return this.mScale;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public void initWithPointList(ArrayList<float[]> arrayList) {
        boolean z = this.mItemList.size() > 0;
        this.mItemList.clear();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < arrayList.size()) {
            float[] fArr = arrayList.get(i);
            PointF pointF = new PointF(((float) PtrLocalDisplay.dp2px(fArr[0])) * this.mScale, ((float) PtrLocalDisplay.dp2px(fArr[1])) * this.mScale);
            PointF pointF2 = new PointF(((float) PtrLocalDisplay.dp2px(fArr[2])) * this.mScale, ((float) PtrLocalDisplay.dp2px(fArr[3])) * this.mScale);
            float max = Math.max(Math.max(f, pointF.x), pointF2.x);
            float max2 = Math.max(Math.max(f2, pointF.y), pointF2.y);
            StoreHouseBarItem storeHouseBarItem = new StoreHouseBarItem(i, pointF, pointF2, this.mTextColor, this.mLineWidth);
            storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
            this.mItemList.add(storeHouseBarItem);
            i++;
            f = max;
            f2 = max2;
        }
        this.mDrawZoneWidth = (int) Math.ceil((double) f);
        this.mDrawZoneHeight = (int) Math.ceil((double) f2);
        if (z) {
            requestLayout();
        }
    }

    private void beginLoading() {
        this.mIsInLoading = true;
        this.mAniController.start();
        invalidate();
    }

    private void loadFinish() {
        this.mIsInLoading = false;
        this.mAniController.stop();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.mProgress;
        int save = canvas.save();
        int size = this.mItemList.size();
        for (int i = 0; i < size; i++) {
            canvas.save();
            StoreHouseBarItem storeHouseBarItem = this.mItemList.get(i);
            float f2 = ((float) this.mOffsetX) + storeHouseBarItem.midPoint.x;
            float f3 = ((float) this.mOffsetY) + storeHouseBarItem.midPoint.y;
            if (this.mIsInLoading) {
                storeHouseBarItem.getTransformation(getDrawingTime(), this.mTransformation);
                canvas.translate(f2, f3);
            } else {
                float f4 = 0.0f;
                if (f == 0.0f) {
                    storeHouseBarItem.resetPosition(this.mHorizontalRandomness);
                } else {
                    float f5 = this.mInternalAnimationFactor;
                    float f6 = ((1.0f - f5) * ((float) i)) / ((float) size);
                    float f7 = (1.0f - f5) - f6;
                    if (f == 1.0f || f >= 1.0f - f7) {
                        canvas.translate(f2, f3);
                        storeHouseBarItem.setAlpha(this.mBarDarkAlpha);
                    } else {
                        if (f > f6) {
                            f4 = Math.min(1.0f, (f - f6) / f5);
                        }
                        float f8 = 1.0f - f4;
                        float f9 = f2 + (storeHouseBarItem.translationX * f8);
                        float f10 = f3 + (((float) (-this.mDropHeight)) * f8);
                        Matrix matrix = new Matrix();
                        matrix.postRotate(360.0f * f4);
                        matrix.postScale(f4, f4);
                        matrix.postTranslate(f9, f10);
                        storeHouseBarItem.setAlpha(this.mBarDarkAlpha * f4);
                        canvas.concat(matrix);
                    }
                }
            }
            storeHouseBarItem.draw(canvas);
            canvas.restore();
        }
        if (this.mIsInLoading) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        loadFinish();
        for (int i = 0; i < this.mItemList.size(); i++) {
            this.mItemList.get(i).resetPosition(this.mHorizontalRandomness);
        }
    }

    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        beginLoading();
    }

    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        loadFinish();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
        setProgress(Math.min(1.0f, ptrIndicator.getCurrentPercent()));
        invalidate();
    }

    class AniController implements Runnable {
        private int mCountPerSeg;
        private int mInterval;
        private boolean mRunning;
        private int mSegCount;
        private int mTick;

        private AniController() {
            this.mTick = 0;
            this.mCountPerSeg = 0;
            this.mSegCount = 0;
            this.mInterval = 0;
            this.mRunning = true;
        }

        public void start() {
            this.mRunning = true;
            this.mTick = 0;
            this.mInterval = StoreHouseHeader.this.mLoadingAniDuration / StoreHouseHeader.this.mItemList.size();
            this.mCountPerSeg = StoreHouseHeader.this.mLoadingAniSegDuration / this.mInterval;
            this.mSegCount = (StoreHouseHeader.this.mItemList.size() / this.mCountPerSeg) + 1;
            run();
        }

        public void run() {
            int i = this.mTick % this.mCountPerSeg;
            for (int i2 = 0; i2 < this.mSegCount; i2++) {
                int i3 = (this.mCountPerSeg * i2) + i;
                if (i3 <= this.mTick) {
                    StoreHouseBarItem storeHouseBarItem = StoreHouseHeader.this.mItemList.get(i3 % StoreHouseHeader.this.mItemList.size());
                    storeHouseBarItem.setFillAfter(false);
                    storeHouseBarItem.setFillEnabled(true);
                    storeHouseBarItem.setFillBefore(false);
                    storeHouseBarItem.setDuration((long) StoreHouseHeader.this.mLoadingAniItemDuration);
                    storeHouseBarItem.start(StoreHouseHeader.this.mFromAlpha, StoreHouseHeader.this.mToAlpha);
                }
            }
            this.mTick++;
            if (this.mRunning) {
                StoreHouseHeader.this.postDelayed(this, (long) this.mInterval);
            }
        }

        public void stop() {
            this.mRunning = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }
    }
}
