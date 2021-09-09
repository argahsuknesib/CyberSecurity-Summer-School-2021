package com.xiaomi.mico.music.player.lrc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.google.android.gms.common.ConnectionResult;
import com.xiaomi.smarthome.R;

public class LrcViewImpl1 extends LrcView {
    private boolean canDrag = false;
    public boolean canScroll = true;
    private ValueAnimator mAnimator;
    private float mCurrentFraction = 0.0f;
    private int mCurrentRow = -1;
    public float mCurrentXForHighLightLrc;
    private float mFirstX;
    private float mFirstY;
    private Paint mHighlightLrcPaint;
    private int mHighlightTextSize;
    private int mLastRow = -1;
    private float mLastY;
    private float mLineSpacing;
    private Paint mNormalLrcPaint;
    private int mNormalTextSize;
    private Scroller mScroller;
    private int mTouchSlop;
    private ValueAnimator.AnimatorUpdateListener updateListener = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.xiaomi.mico.music.player.lrc.LrcViewImpl1.AnonymousClass1 */

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LrcViewImpl1.this.mCurrentXForHighLightLrc = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            LrcViewImpl1.this.invalidate();
        }
    };

    public LrcViewImpl1(Context context) {
        super(context);
    }

    public LrcViewImpl1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.hightLightTextColor, R.attr.hightLightTextSize, R.attr.lineSpacing, R.attr.normalTextColor, R.attr.normalTextSize});
        this.mNormalTextSize = obtainStyledAttributes.getDimensionPixelSize(4, context.getResources().getDimensionPixelSize(R.dimen.text_size_15));
        this.mHighlightTextSize = obtainStyledAttributes.getDimensionPixelSize(1, this.mNormalTextSize);
        this.mLineSpacing = (float) obtainStyledAttributes.getDimensionPixelSize(2, context.getResources().getDimensionPixelSize(R.dimen.music_lyric_spacing));
        int color = obtainStyledAttributes.getColor(3, context.getResources().getColor(R.color.mj_color_gray_heavy));
        int color2 = obtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.mj_color_green_normal));
        obtainStyledAttributes.recycle();
        this.mNormalLrcPaint = new Paint();
        this.mNormalLrcPaint.setColor(color);
        this.mNormalLrcPaint.setTextSize((float) this.mNormalTextSize);
        this.mNormalLrcPaint.setAntiAlias(true);
        this.mHighlightLrcPaint = new Paint();
        this.mHighlightLrcPaint.setColor(color2);
        this.mHighlightLrcPaint.setTextSize((float) this.mHighlightTextSize);
        this.mHighlightLrcPaint.setAntiAlias(true);
        this.mScroller = new Scroller(getContext());
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        scrollTo(getScrollX(), 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0072, code lost:
        if (r3 > r2) goto L_0x0076;
     */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (hasLrcRows()) {
            int i = this.mCurrentRow;
            int height = ((((int) (((float) getHeight()) / (((float) this.mNormalTextSize) + this.mLineSpacing))) + 4) - 1) / 2;
            int i2 = i - height;
            int i3 = i + height;
            int i4 = 0;
            int max = Math.max(i2, 0);
            int min = Math.min(i3, this.mLrcRows.size() - 1);
            int i5 = this.mCurrentRow;
            if (Math.max(min - i5, i5 - max) != 0) {
                if (min == 0) {
                    this.mCurrentRow = 0;
                }
                i4 = max;
                float height2 = ((float) (getHeight() / 2)) + (((float) i4) * (((float) this.mNormalTextSize) + this.mLineSpacing));
                while (i4 <= min) {
                    if (i4 == this.mCurrentRow) {
                        int i6 = this.mNormalTextSize;
                        float f = ((float) i6) + (((float) (this.mHighlightTextSize - i6)) * this.mCurrentFraction);
                        String content = ((LrcRow) this.mLrcRows.get(i4)).getContent();
                        this.mHighlightLrcPaint.setTextSize(f);
                        float measureText = this.mHighlightLrcPaint.measureText(content);
                        if (measureText > ((float) getWidth())) {
                            canvas.drawText(content, this.mCurrentXForHighLightLrc, height2, this.mHighlightLrcPaint);
                        } else {
                            canvas.drawText(content, (((float) getWidth()) - measureText) / 2.0f, height2, this.mHighlightLrcPaint);
                        }
                    } else {
                        if (i4 == this.mLastRow) {
                            int i7 = this.mHighlightTextSize;
                            this.mNormalLrcPaint.setTextSize(((float) i7) - (((float) (i7 - this.mNormalTextSize)) * this.mCurrentFraction));
                        } else {
                            this.mNormalLrcPaint.setTextSize((float) this.mNormalTextSize);
                        }
                        String content2 = ((LrcRow) this.mLrcRows.get(i4)).getContent();
                        canvas.drawText(content2, Math.max((((float) getWidth()) - this.mNormalLrcPaint.measureText(content2)) / 2.0f, 0.0f), height2, this.mNormalLrcPaint);
                    }
                    height2 += ((float) this.mNormalTextSize) + this.mLineSpacing;
                    i4++;
                }
            }
        } else if (!TextUtils.isEmpty(this.mEmptyText)) {
            this.mNormalLrcPaint.setTextSize((float) this.mNormalTextSize);
            float measureText2 = this.mNormalLrcPaint.measureText(this.mEmptyText);
            canvas.drawText(this.mEmptyText, (((float) getWidth()) - measureText2) / 2.0f, (float) (getHeight() / 2), this.mNormalLrcPaint);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        if (r10 > 0.0f) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r10 < 0.0f) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r0 != 3) goto L_0x012a;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY();
                    if (!this.canDrag) {
                        if (Math.abs(rawY - this.mFirstY) > ((float) this.mTouchSlop) && Math.abs(rawY - this.mFirstY) > Math.abs(motionEvent.getRawX() - this.mFirstX)) {
                            this.canDrag = true;
                            this.mScroller.forceFinished(true);
                            stopScrollLrc();
                            this.mCurrentFraction = 1.0f;
                        }
                        this.mLastY = rawY;
                    }
                    if (!this.canDrag || !hasLrcRows() || !this.canScroll) {
                        this.mLastY = rawY;
                    } else {
                        float f = rawY - this.mLastY;
                        if (((float) getScrollY()) - f >= 0.0f) {
                            float f2 = this.mLineSpacing;
                            if (((float) getScrollY()) - f > (((float) this.mLrcRows.size()) * (((float) this.mNormalTextSize) + f2)) - f2) {
                            }
                            scrollBy(getScrollX(), -((int) f));
                            this.mLastY = rawY;
                            seekTo(((LrcRow) this.mLrcRows.get(Math.max(Math.min((int) (((float) getScrollY()) / (((float) this.mNormalTextSize) + this.mLineSpacing)), this.mLrcRows.size() - 1), 0))).getTimeMillis(), false, false);
                            return true;
                        }
                        f /= 3.0f;
                        scrollBy(getScrollX(), -((int) f));
                        this.mLastY = rawY;
                        seekTo(((LrcRow) this.mLrcRows.get(Math.max(Math.min((int) (((float) getScrollY()) / (((float) this.mNormalTextSize) + this.mLineSpacing)), this.mLrcRows.size() - 1), 0))).getTimeMillis(), false, false);
                        return true;
                    }
                }
            } else if (!this.canDrag) {
                performClick();
            }
            if (this.canDrag) {
                this.canDrag = false;
                if (hasLrcRows()) {
                    if (getScrollY() < 0) {
                        smoothScrollTo(0, 400);
                    } else {
                        float f3 = this.mLineSpacing;
                        if (((float) getScrollY()) > (((float) this.mLrcRows.size()) * (((float) this.mNormalTextSize) + f3)) - f3) {
                            float f4 = this.mLineSpacing;
                            smoothScrollTo((int) ((((float) this.mLrcRows.size()) * (((float) this.mNormalTextSize) + f4)) - f4), 400);
                        }
                    }
                    invalidate();
                }
            }
        } else {
            this.mFirstX = motionEvent.getRawX();
            this.mFirstY = motionEvent.getRawY();
        }
        return true;
    }

    public void seekTo(int i, boolean z, boolean z2) {
        if (hasLrcRows()) {
            if ((!z || !this.canDrag) && this.mLrcRows.size() >= 2) {
                for (int size = this.mLrcRows.size() - 1; size >= 0; size--) {
                    if (i >= ((LrcRow) this.mLrcRows.get(size)).getTimeMillis()) {
                        int i2 = this.mCurrentRow;
                        if (i2 != size) {
                            this.mLastRow = i2;
                            this.mCurrentRow = size;
                            if (z2) {
                                if (!this.mScroller.isFinished()) {
                                    this.mScroller.forceFinished(true);
                                }
                                scrollTo(getScrollX(), (int) (((float) this.mCurrentRow) * (((float) this.mNormalTextSize) + this.mLineSpacing)));
                            } else {
                                smoothScrollTo((int) (((float) this.mCurrentRow) * (((float) this.mNormalTextSize) + this.mLineSpacing)), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
                            }
                            float measureText = this.mHighlightLrcPaint.measureText(((LrcRow) this.mLrcRows.get(this.mCurrentRow)).getContent());
                            if (measureText > ((float) getWidth())) {
                                float width = ((float) getWidth()) - measureText;
                                double totalTime = (double) ((LrcRow) this.mLrcRows.get(this.mCurrentRow)).getTotalTime();
                                Double.isNaN(totalTime);
                                startScrollLrc(width, (long) (totalTime * 0.6d));
                            }
                            invalidate();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    private void startScrollLrc(float f, long j) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) {
            this.mAnimator = ValueAnimator.ofFloat(0.0f, f);
            this.mAnimator.addUpdateListener(this.updateListener);
        } else {
            this.mCurrentXForHighLightLrc = 0.0f;
            valueAnimator.cancel();
            this.mAnimator.setFloatValues(0.0f, f);
        }
        this.mAnimator.setDuration(j);
        ValueAnimator valueAnimator2 = this.mAnimator;
        double d = (double) j;
        Double.isNaN(d);
        valueAnimator2.setStartDelay((long) (d * 0.3d));
        this.mAnimator.start();
    }

    private void stopScrollLrc() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mCurrentXForHighLightLrc = 0.0f;
    }

    private void smoothScrollTo(int i, int i2) {
        int scrollY = getScrollY();
        this.mScroller.startScroll(getScrollX(), scrollY, 0, i - scrollY, i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollY = getScrollY();
            int currY = this.mScroller.getCurrY();
            if (scrollY != currY && !this.canDrag) {
                scrollTo(getScrollX(), currY);
            }
            this.mCurrentFraction = (((float) this.mScroller.timePassed()) * 3.0f) / 1500.0f;
            this.mCurrentFraction = Math.min(this.mCurrentFraction, 1.0f);
            invalidate();
        }
    }
}
