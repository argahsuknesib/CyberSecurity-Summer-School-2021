package in.srain.cube.views.ptr.indicator;

public class PtrTensionIndicator extends PtrIndicator {
    private float DRAG_RATE = 0.5f;
    private float mCurrentDragPercent;
    private float mDownPos;
    private float mDownY;
    private float mOneHeight = 0.0f;
    private float mReleasePercent = -1.0f;
    private int mReleasePos;

    public void onPressDown(float f, float f2) {
        super.onPressDown(f, f2);
        this.mDownY = f2;
        this.mDownPos = (float) getCurrentPosY();
    }

    public void onRelease() {
        super.onRelease();
        this.mReleasePos = getCurrentPosY();
        this.mReleasePercent = this.mCurrentDragPercent;
    }

    public void onUIRefreshComplete() {
        this.mReleasePos = getCurrentPosY();
        this.mReleasePercent = getOverDragPercent();
    }

    public void setHeaderHeight(int i) {
        super.setHeaderHeight(i);
        this.mOneHeight = (((float) i) * 4.0f) / 5.0f;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* access modifiers changed from: protected */
    public void processOnMove(float f, float f2, float f3, float f4) {
        float f5 = this.mDownY;
        if (f2 < f5) {
            super.processOnMove(f, f2, f3, f4);
            return;
        }
        float f6 = ((f2 - f5) * this.DRAG_RATE) + this.mDownPos;
        float f7 = f6 / this.mOneHeight;
        if (f7 < 0.0f) {
            setOffset(f3, 0.0f);
            return;
        }
        this.mCurrentDragPercent = f7;
        float min = Math.min(1.0f, Math.abs(f7));
        float f8 = this.mOneHeight;
        double max = (double) (Math.max(0.0f, Math.min(f6 - f8, f8 * 2.0f) / this.mOneHeight) / 4.0f);
        double pow = Math.pow(max, 2.0d);
        Double.isNaN(max);
        float f9 = this.mOneHeight;
        setOffset(f, (float) (((int) ((f9 * min) + (((((float) (max - pow)) * 2.0f) * f9) / 2.0f))) - getCurrentPosY()));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    private float offsetToTarget(float f) {
        float f2 = f / this.mOneHeight;
        this.mCurrentDragPercent = f2;
        Math.min(1.0f, Math.abs(f2));
        float f3 = this.mOneHeight;
        Math.pow((double) (Math.max(0.0f, Math.min(f - f3, f3 * 2.0f) / this.mOneHeight) / 4.0f), 2.0d);
        return 0.0f;
    }

    public int getOffsetToKeepHeaderWhileLoading() {
        return getOffsetToRefresh();
    }

    public int getOffsetToRefresh() {
        return (int) this.mOneHeight;
    }

    public float getOverDragPercent() {
        if (isUnderTouch()) {
            return this.mCurrentDragPercent;
        }
        float f = this.mReleasePercent;
        if (f <= 0.0f) {
            return (((float) getCurrentPosY()) * 1.0f) / ((float) getOffsetToKeepHeaderWhileLoading());
        }
        return (f * ((float) getCurrentPosY())) / ((float) this.mReleasePos);
    }
}
