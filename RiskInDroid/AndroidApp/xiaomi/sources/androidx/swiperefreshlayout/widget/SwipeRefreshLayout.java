package androidx.swiperefreshlayout.widget;

import _m_j.bo;
import _m_j.br;
import _m_j.bs;
import _m_j.bv;
import _m_j.cb;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;

public class SwipeRefreshLayout extends ViewGroup implements bo, bs {
    private static final int[] LAYOUT_ATTRS = {16842766};
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private O000000o mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    O00000Oo mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final br mNestedScrollingChildHelper;
    private final bv mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    CircularProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    public interface O000000o {
        boolean O000000o();
    }

    public interface O00000Oo {
        void onRefresh();
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.mScale = z;
        this.mOriginalOffsetTop = i;
        this.mSpinnerOffsetEnd = i2;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerOffsetEnd = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setSlingshotDistance(int i) {
        this.mCustomSlingshotDistance = i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.O000000o(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass1 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.mRefreshing) {
                    SwipeRefreshLayout.this.mProgress.setAlpha(255);
                    SwipeRefreshLayout.this.mProgress.start();
                    if (SwipeRefreshLayout.this.mNotify && SwipeRefreshLayout.this.mListener != null) {
                        SwipeRefreshLayout.this.mListener.onRefresh();
                    }
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    swipeRefreshLayout.mCurrentTargetOffsetTop = swipeRefreshLayout.mCircleView.getTop();
                    return;
                }
                SwipeRefreshLayout.this.reset();
            }
        };
        this.mAnimateToCorrectPosition = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass6 */

            public final void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.mUsingCustomStart) {
                    i = SwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(SwipeRefreshLayout.this.mOriginalOffsetTop);
                } else {
                    i = SwipeRefreshLayout.this.mSpinnerOffsetEnd;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.mFrom + ((int) (((float) (i - SwipeRefreshLayout.this.mFrom)) * f))) - SwipeRefreshLayout.this.mCircleView.getTop());
                SwipeRefreshLayout.this.mProgress.O000000o(1.0f - f);
            }
        };
        this.mAnimateToStartPosition = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass7 */

            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        this.mSpinnerOffsetEnd = (int) (displayMetrics.density * 64.0f);
        this.mTotalDragDistance = (float) this.mSpinnerOffsetEnd;
        this.mNestedScrollingParentHelper = new bv();
        this.mNestedScrollingChildHelper = new br(this);
        setNestedScrollingEnabled(true);
        int i = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mCircleViewIndex;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i3;
        }
        return i2 >= i3 ? i2 + 1 : i2;
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), -328966);
        this.mProgress = new CircularProgressDrawable(getContext());
        this.mProgress.O000000o(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    public void setOnRefreshListener(O00000Oo o00000Oo) {
        this.mListener = o00000Oo;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            return;
        }
        this.mRefreshing = z;
        if (!this.mUsingCustomStart) {
            i = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
        } else {
            i = this.mSpinnerOffsetEnd;
        }
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        this.mScaleAnimation = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass2 */

            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.mScaleAnimation.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f) {
        this.mCircleView.setScaleX(f);
        this.mCircleView.setScaleY(f);
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        this.mScaleDownAnimation = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass3 */

            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation.setDuration(150);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private Animation startAlphaAnimation(final int i, final int i2) {
        AnonymousClass4 r0 = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass4 */

            public final void applyTransformation(float f, Transformation transformation) {
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.mProgress;
                int i = i;
                circularProgressDrawable.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        r0.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r0);
        return r0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.O00000o0(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.O00000o0(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        circularProgressDrawable.f2981O000000o.O000000o(iArr);
        circularProgressDrawable.f2981O000000o.O000000o(0);
        circularProgressDrawable.invalidateSelf();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = (float) i;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            View view = this.mTarget;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.mCircleView.getMeasuredWidth();
                int measuredHeight2 = this.mCircleView.getMeasuredHeight();
                int i5 = measuredWidth / 2;
                int i6 = measuredWidth2 / 2;
                int i7 = this.mCurrentTargetOffsetTop;
                this.mCircleView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.mCircleView) {
                    this.mCircleViewIndex = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public boolean canChildScrollUp() {
        O000000o o000000o = this.mChildScrollUpCallback;
        if (o000000o != null) {
            return o000000o.O000000o();
        }
        View view = this.mTarget;
        if (!(view instanceof ListView)) {
            return view.canScrollVertically(-1);
        }
        ListView listView = (ListView) view;
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(-1);
        }
        if (listView.getChildCount() != 0) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int top = listView.getChildAt(0).getTop();
            if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
                return true;
            }
        }
        return false;
    }

    public void setOnChildScrollUpCallback(O000000o o000000o) {
        this.mChildScrollUpCallback = o000000o;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i == -1) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    startDragging(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.mInitialDownY = motionEvent.getY(findPointerIndex2);
        }
        return this.mIsBeingDragged;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) {
            View view = this.mTarget;
            if (view == null || cb.O00oOoOo(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return isEnabled() && !this.mReturningToStart && !this.mRefreshing && (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.O000000o(i, 0);
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.mTotalUnconsumed;
            if (f > 0.0f) {
                float f2 = (float) i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f - f2;
                    iArr[1] = i2;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.O000000o();
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.O000000o(0);
        this.mNestedScrollInProgress = false;
        float f = this.mTotalUnconsumed;
        if (f > 0.0f) {
            finishSpinner(f);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if (i5 < 0 && !canChildScrollUp()) {
            this.mTotalUnconsumed += (float) Math.abs(i5);
            moveSpinner(this.mTotalUnconsumed);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.O000000o(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.f13211O000000o;
    }

    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.O000000o(i, 0);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.O00000Oo(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.O000000o(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.O000000o(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.O000000o(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.O000000o(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.O000000o(f, f2);
    }

    private boolean isAnimationRunning(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
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
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    private void moveSpinner(float f) {
        this.mProgress.O000000o(true);
        float min = Math.min(1.0f, Math.abs(f / this.mTotalDragDistance));
        double d = (double) min;
        Double.isNaN(d);
        float max = (Math.max((float) (d - 0.4d), 0.0f) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.mTotalDragDistance;
        int i = this.mCustomSlingshotDistance;
        if (i <= 0) {
            i = this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
        }
        float f2 = (float) i;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f);
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f3 = ((float) (max2 - pow)) * 2.0f;
        int i2 = this.mOriginalOffsetTop + ((int) ((f2 * min) + (f2 * f3 * 2.0f)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f / this.mTotalDragDistance));
        }
        if (f < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.O00000Oo(Math.min(0.8f, max * 0.8f));
        this.mProgress.O000000o(Math.min(1.0f, max));
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        circularProgressDrawable.f2981O000000o.O0000O0o = (((max * 0.4f) - 16.0f) + (f3 * 2.0f)) * 0.5f;
        circularProgressDrawable.invalidateSelf();
        setTargetOffsetTopAndBottom(i2 - this.mCurrentTargetOffsetTop);
    }

    private void finishSpinner(float f) {
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.O00000Oo(0.0f);
        AnonymousClass5 r0 = null;
        if (!this.mScale) {
            r0 = new Animation.AnimationListener() {
                /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass5 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.mScale) {
                        SwipeRefreshLayout.this.startScaleDownAnimation(null);
                    }
                }
            };
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r0);
        this.mProgress.O000000o(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex < 0) {
                Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.mIsBeingDragged) {
                this.mIsBeingDragged = false;
                finishSpinner((motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f);
            }
            this.mActivePointerId = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex2 < 0) {
                Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            startDragging(y);
            if (this.mIsBeingDragged) {
                float f = (y - this.mInitialMotionY) * 0.5f;
                if (f <= 0.0f) {
                    return false;
                }
                moveSpinner(f);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
            }
        }
        return true;
    }

    private void startDragging(float f) {
        float f2 = this.mInitialDownY;
        int i = this.mTouchSlop;
        if (f - f2 > ((float) i) && !this.mIsBeingDragged) {
            this.mInitialMotionY = f2 + ((float) i);
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    /* access modifiers changed from: package-private */
    public void moveToStart(float f) {
        int i = this.mFrom;
        setTargetOffsetTopAndBottom((i + ((int) (((float) (this.mOriginalOffsetTop - i)) * f))) - this.mCircleView.getTop());
    }

    private void startScaleDownReturnToStartAnimation(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mStartingScale = this.mCircleView.getScaleX();
        this.mScaleDownToStartAnimation = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass8 */

            public final void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.mStartingScale + ((-SwipeRefreshLayout.this.mStartingScale) * f));
                SwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mScaleDownToStartAnimation.setDuration(150);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000Oo0(android.view.View, int):void
     arg types: [androidx.swiperefreshlayout.widget.CircleImageView, int]
     candidates:
      _m_j.cb.O0000Oo0(android.view.View, float):void
      _m_j.cb.O0000Oo0(android.view.View, int):void */
    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i) {
        this.mCircleView.bringToFront();
        cb.O0000Oo0((View) this.mCircleView, i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
