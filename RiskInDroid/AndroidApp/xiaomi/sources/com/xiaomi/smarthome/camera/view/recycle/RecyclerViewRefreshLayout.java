package com.xiaomi.smarthome.camera.view.recycle;

import _m_j.cb;
import _m_j.gsy;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class RecyclerViewRefreshLayout extends ViewGroup {
    private static final int[] LAYOUT_ATTRS = {16842766};
    public CircleProgressView defaultProgressView;
    public float density;
    public boolean isProgressEnable;
    private int mActivePointerId;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    public int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private RelativeLayout mFooterRefreshViewContainer;
    private int mFooterViewHeight;
    private int mFooterViewIndex;
    private int mFooterViewWidth;
    protected int mFrom;
    private int mHeaderViewHeight;
    private int mHeaderViewIndex;
    private int mHeaderViewWidth;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    public OnPullRefreshListener mListener;
    public boolean mLoadMore;
    private int mMediumAnimationDuration;
    private int mMode;
    public boolean mNotify;
    public OnPushLoadMoreListener mOnPushLoadMoreListener;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private Animation.AnimationListener mRefreshListener;
    public boolean mRefreshing;
    private boolean mReturningToStart;
    public boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    public float mSpinnerFinalOffset;
    public float mStartingScale;
    private View mTarget;
    public HeadViewContainer mTopRefreshViewContainer;
    private float mTotalDragDistance;
    private int mTouchSlop;
    public boolean mUsingCustomStart;
    public int pushDistance;
    private boolean targetScrollWithLayout;
    public boolean usingDefaultHeader;

    public interface OnPullRefreshListener {
        void onPullDistance(int i);

        void onPullEnable(boolean z);

        void onRefresh();
    }

    public interface OnPushLoadMoreListener {
        void onLoadMore();

        void onPushDistance(int i);

        void onPushEnable(boolean z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public void updateListenerCallBack() {
        int height = this.mCurrentTargetOffsetTop + this.mTopRefreshViewContainer.getHeight();
        OnPullRefreshListener onPullRefreshListener = this.mListener;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onPullDistance(height);
        }
        if (this.usingDefaultHeader && this.isProgressEnable) {
            this.defaultProgressView.setPullDistance(height);
        }
    }

    public void setTopRefreshView(View view) {
        HeadViewContainer headViewContainer;
        if (view != null && (headViewContainer = this.mTopRefreshViewContainer) != null) {
            this.usingDefaultHeader = false;
            headViewContainer.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mHeaderViewWidth, this.mHeaderViewHeight);
            layoutParams.addRule(12);
            this.mTopRefreshViewContainer.addView(view, layoutParams);
        }
    }

    public void setFooterRefreshView(View view) {
        RelativeLayout relativeLayout;
        if (view != null && (relativeLayout = this.mFooterRefreshViewContainer) != null) {
            relativeLayout.removeAllViews();
            this.mFooterRefreshViewContainer.addView(view, new RelativeLayout.LayoutParams(this.mFooterViewWidth, this.mFooterViewHeight));
        }
    }

    public RecyclerViewRefreshLayout(Context context) {
        this(context, null);
    }

    public RecyclerViewRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 1;
        this.mRefreshing = false;
        this.mLoadMore = false;
        this.mTotalDragDistance = -1.0f;
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mHeaderViewIndex = -1;
        this.mFooterViewIndex = -1;
        this.targetScrollWithLayout = true;
        this.pushDistance = 0;
        this.defaultProgressView = null;
        this.usingDefaultHeader = false;
        this.density = 1.0f;
        this.isProgressEnable = true;
        this.mRefreshListener = new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass1 */

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                RecyclerViewRefreshLayout.this.isProgressEnable = false;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cb.O00000o0(android.view.View, float):void
             arg types: [com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout$CircleProgressView, int]
             candidates:
              _m_j.cb.O00000o0(android.view.View, int):void
              _m_j.cb.O00000o0(android.view.View, boolean):void
              _m_j.cb.O00000o0(android.view.View, float):void */
            public void onAnimationEnd(Animation animation) {
                RecyclerViewRefreshLayout recyclerViewRefreshLayout = RecyclerViewRefreshLayout.this;
                recyclerViewRefreshLayout.isProgressEnable = true;
                if (!recyclerViewRefreshLayout.mRefreshing) {
                    RecyclerViewRefreshLayout.this.mTopRefreshViewContainer.setVisibility(8);
                    if (RecyclerViewRefreshLayout.this.mScale) {
                        RecyclerViewRefreshLayout.this.setAnimationProgress(0.0f);
                    } else {
                        RecyclerViewRefreshLayout recyclerViewRefreshLayout2 = RecyclerViewRefreshLayout.this;
                        recyclerViewRefreshLayout2.setTargetOffsetTopAndBottom(recyclerViewRefreshLayout2.mOriginalOffsetTop - RecyclerViewRefreshLayout.this.mCurrentTargetOffsetTop, true);
                    }
                } else if (RecyclerViewRefreshLayout.this.mNotify) {
                    if (RecyclerViewRefreshLayout.this.usingDefaultHeader) {
                        cb.O00000o0((View) RecyclerViewRefreshLayout.this.defaultProgressView, 1.0f);
                        RecyclerViewRefreshLayout.this.defaultProgressView.setOnDraw(true);
                        new Thread(RecyclerViewRefreshLayout.this.defaultProgressView).start();
                    }
                    if (RecyclerViewRefreshLayout.this.mListener != null) {
                        RecyclerViewRefreshLayout.this.mListener.onRefresh();
                    }
                }
                RecyclerViewRefreshLayout recyclerViewRefreshLayout3 = RecyclerViewRefreshLayout.this;
                recyclerViewRefreshLayout3.mCurrentTargetOffsetTop = recyclerViewRefreshLayout3.mTopRefreshViewContainer.getTop();
                RecyclerViewRefreshLayout.this.updateListenerCallBack();
            }
        };
        this.mAnimateToCorrectPosition = new Animation() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass8 */

            public void applyTransformation(float f, Transformation transformation) {
                float f2;
                if (!RecyclerViewRefreshLayout.this.mUsingCustomStart) {
                    f2 = RecyclerViewRefreshLayout.this.mSpinnerFinalOffset - ((float) Math.abs(RecyclerViewRefreshLayout.this.mOriginalOffsetTop));
                } else {
                    f2 = RecyclerViewRefreshLayout.this.mSpinnerFinalOffset;
                }
                RecyclerViewRefreshLayout.this.setTargetOffsetTopAndBottom((RecyclerViewRefreshLayout.this.mFrom + ((int) (((float) (((int) f2) - RecyclerViewRefreshLayout.this.mFrom)) * f))) - RecyclerViewRefreshLayout.this.mTopRefreshViewContainer.getTop(), false);
            }

            public void setAnimationListener(Animation.AnimationListener animationListener) {
                super.setAnimationListener(animationListener);
            }
        };
        this.mAnimateToStartPosition = new Animation() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass9 */

            public void applyTransformation(float f, Transformation transformation) {
                RecyclerViewRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mHeaderViewWidth = defaultDisplay.getWidth();
        this.mFooterViewWidth = defaultDisplay.getWidth();
        this.mHeaderViewHeight = (int) (displayMetrics.density * 60.0f);
        this.mFooterViewHeight = (int) (displayMetrics.density * 60.0f);
        this.defaultProgressView = new CircleProgressView(getContext());
        createTopRefreshViewContainer();
        createFooterRefreshViewContainer();
        cb.O000000o((ViewGroup) this);
        this.mSpinnerFinalOffset = displayMetrics.density * 64.0f;
        this.density = displayMetrics.density;
        this.mTotalDragDistance = this.mSpinnerFinalOffset;
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        return super.onInterceptHoverEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mHeaderViewIndex < 0 && this.mFooterViewIndex < 0) {
            return i2;
        }
        if (i2 == i - 2) {
            return this.mHeaderViewIndex;
        }
        if (i2 == i - 1) {
            return this.mFooterViewIndex;
        }
        int i3 = this.mFooterViewIndex;
        int i4 = this.mHeaderViewIndex;
        if (i3 <= i4) {
            i3 = i4;
        }
        int i5 = this.mFooterViewIndex;
        int i6 = this.mHeaderViewIndex;
        if (i5 >= i6) {
            i5 = i6;
        }
        if (i2 < i5 || i2 >= i3 - 1) {
            return (i2 >= i3 || i2 == i3 + -1) ? i2 + 2 : i2;
        }
        return i2 + 1;
    }

    private void createTopRefreshViewContainer() {
        int i = this.mHeaderViewHeight;
        double d = (double) i;
        Double.isNaN(d);
        double d2 = (double) i;
        Double.isNaN(d2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (d * 0.8d), (int) (d2 * 0.8d));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.mTopRefreshViewContainer = new HeadViewContainer(getContext());
        this.mTopRefreshViewContainer.setVisibility(8);
        this.defaultProgressView.setVisibility(0);
        this.defaultProgressView.setOnDraw(false);
        this.mTopRefreshViewContainer.addView(this.defaultProgressView, layoutParams);
        addView(this.mTopRefreshViewContainer);
    }

    private void createFooterRefreshViewContainer() {
        this.mFooterRefreshViewContainer = new RelativeLayout(getContext());
        this.mFooterRefreshViewContainer.setVisibility(8);
        addView(this.mFooterRefreshViewContainer);
    }

    public void setOnPullRefreshListener(OnPullRefreshListener onPullRefreshListener) {
        this.mListener = onPullRefreshListener;
    }

    public void setHeaderViewBackgroundColor(int i) {
        this.mTopRefreshViewContainer.setBackgroundColor(i);
    }

    public void setOnPushLoadMoreListener(OnPushLoadMoreListener onPushLoadMoreListener) {
        this.mOnPushLoadMoreListener = onPushLoadMoreListener;
    }

    public void setRefreshing(boolean z) {
        float f;
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            if (this.usingDefaultHeader) {
                this.defaultProgressView.setOnDraw(false);
                return;
            }
            return;
        }
        this.mRefreshing = z;
        if (!this.mUsingCustomStart) {
            f = this.mSpinnerFinalOffset + ((float) this.mOriginalOffsetTop);
        } else {
            f = this.mSpinnerFinalOffset;
        }
        setTargetOffsetTopAndBottom(((int) f) - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mTopRefreshViewContainer.setVisibility(0);
        this.mScaleAnimation = new Animation() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass2 */

            public void applyTransformation(float f, Transformation transformation) {
                RecyclerViewRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.mScaleAnimation.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mTopRefreshViewContainer.setAnimationListener(animationListener);
        }
        this.mTopRefreshViewContainer.clearAnimation();
        this.mTopRefreshViewContainer.startAnimation(this.mScaleAnimation);
    }

    public void setAnimationProgress(float f) {
        if (!this.usingDefaultHeader) {
            f = 1.0f;
        }
        cb.O00000oo(this.mTopRefreshViewContainer, f);
        cb.O0000O0o(this.mTopRefreshViewContainer, f);
    }

    public void setRefreshing(boolean z, boolean z2) {
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

    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        this.mScaleDownAnimation = new Animation() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass3 */

            public void applyTransformation(float f, Transformation transformation) {
                RecyclerViewRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation.setDuration(150);
        this.mTopRefreshViewContainer.setAnimationListener(animationListener);
        this.mTopRefreshViewContainer.clearAnimation();
        this.mTopRefreshViewContainer.startAnimation(this.mScaleDownAnimation);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.mTopRefreshViewContainer) || childAt.equals(this.mFooterRefreshViewContainer) || !(childAt instanceof RecyclerView)) {
                    i++;
                } else {
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
            if (this.mTarget != null) {
                int height = this.mCurrentTargetOffsetTop + this.mTopRefreshViewContainer.getHeight();
                if (!this.targetScrollWithLayout) {
                    height = 0;
                }
                if (this.mTopRefreshViewContainer.getHeight() == 0) {
                    height = 0;
                }
                View view = this.mTarget;
                int paddingLeft = getPaddingLeft();
                int paddingTop = (getPaddingTop() + height) - this.pushDistance;
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.mTopRefreshViewContainer.getMeasuredWidth();
                int measuredHeight2 = this.mTopRefreshViewContainer.getMeasuredHeight();
                int i5 = measuredWidth / 2;
                int i6 = measuredWidth2 / 2;
                int i7 = this.mCurrentTargetOffsetTop;
                this.mTopRefreshViewContainer.layout(i5 - i6, i7, i6 + i5, measuredHeight2 + i7);
                int measuredWidth3 = this.mFooterRefreshViewContainer.getMeasuredWidth();
                int measuredHeight3 = this.mFooterRefreshViewContainer.getMeasuredHeight();
                int i8 = measuredWidth3 / 2;
                int i9 = this.pushDistance;
                this.mFooterRefreshViewContainer.layout(i5 - i8, measuredHeight - i9, i5 + i8, (measuredHeight + measuredHeight3) - i9);
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
            this.mTopRefreshViewContainer.measure(View.MeasureSpec.makeMeasureSpec(this.mHeaderViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeaderViewHeight, 1073741824));
            this.mFooterRefreshViewContainer.measure(View.MeasureSpec.makeMeasureSpec(this.mFooterViewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mFooterViewHeight, 1073741824));
            if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
                this.mOriginalOffsetCalculated = true;
                int i3 = -this.mTopRefreshViewContainer.getMeasuredHeight();
                this.mOriginalOffsetTop = i3;
                this.mCurrentTargetOffsetTop = i3;
                updateListenerCallBack();
            }
            this.mHeaderViewIndex = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= getChildCount()) {
                    break;
                } else if (getChildAt(i4) == this.mTopRefreshViewContainer) {
                    this.mHeaderViewIndex = i4;
                    break;
                } else {
                    i4++;
                }
            }
            this.mFooterViewIndex = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.mFooterRefreshViewContainer) {
                    this.mFooterViewIndex = i5;
                    return;
                }
            }
        }
    }

    public boolean isChildScrollToTop() {
        View view = this.mTarget;
        return Build.VERSION.SDK_INT < 14 ? view.getScrollY() <= 0 : !cb.O00000Oo(view, -1);
    }

    public boolean isChildScrollToBottom() {
        if (isChildScrollToTop()) {
            return false;
        }
        View view = this.mTarget;
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int itemCount = recyclerView.getAdapter().getItemCount();
            if (!(layoutManager instanceof LinearLayoutManager) || itemCount <= 0) {
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    int[] iArr = new int[2];
                    ((StaggeredGridLayoutManager) layoutManager).O000000o(iArr);
                    if (Math.max(iArr[0], iArr[1]) == itemCount - 1) {
                        return true;
                    }
                }
            } else if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == itemCount - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (this.mRefreshing) {
            return true;
        }
        if (!isEnabled() || this.mReturningToStart || this.mLoadMore || (!isChildScrollToTop() && !isChildScrollToBottom())) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i == -1) {
                        return false;
                    }
                    if (this.mRefreshing) {
                        return true;
                    }
                    float motionEventY = getMotionEventY(motionEvent, i);
                    if (motionEventY == -1.0f) {
                        return false;
                    }
                    if (isChildScrollToBottom()) {
                        if ((this.mMode & 2) == 0) {
                            this.mActivePointerId = -1;
                        } else if (this.mInitialMotionY - motionEventY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                            this.mIsBeingDragged = true;
                        }
                    } else if ((this.mMode & 1) == 0) {
                        this.mActivePointerId = -1;
                    } else if (motionEventY - this.mInitialMotionY > ((float) this.mTouchSlop) && !this.mIsBeingDragged) {
                        this.mIsBeingDragged = true;
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mTopRefreshViewContainer.getTop(), true);
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
            float motionEventY2 = getMotionEventY(motionEvent, this.mActivePointerId);
            if (motionEventY2 == -1.0f) {
                return false;
            }
            this.mInitialMotionY = motionEventY2;
        }
        return this.mIsBeingDragged;
    }

    public void addOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        super.addOnLayoutChangeListener(onLayoutChangeListener);
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oo(android.view.View, float):void
     arg types: [com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout$HeadViewContainer, int]
     candidates:
      _m_j.cb.O00000oo(android.view.View, int):void
      _m_j.cb.O00000oo(android.view.View, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000O0o(android.view.View, float):void
     arg types: [com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout$HeadViewContainer, int]
     candidates:
      _m_j.cb.O0000O0o(android.view.View, int):void
      _m_j.cb.O0000O0o(android.view.View, float):void */
    private boolean handlerPullTouchEvent(MotionEvent motionEvent, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    float y = (motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f;
                    if (this.mIsBeingDragged) {
                        float f = y / this.mTotalDragDistance;
                        if (f < 0.0f) {
                            return false;
                        }
                        float min = Math.min(1.0f, Math.abs(f));
                        float abs = Math.abs(y) - this.mTotalDragDistance;
                        float f2 = this.mUsingCustomStart ? this.mSpinnerFinalOffset - ((float) this.mOriginalOffsetTop) : this.mSpinnerFinalOffset;
                        double max = (double) (Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f);
                        double pow = Math.pow(max, 2.0d);
                        Double.isNaN(max);
                        int i2 = this.mOriginalOffsetTop + ((int) ((f2 * min) + (((float) (max - pow)) * 2.0f * f2 * 2.0f)));
                        if (this.mTopRefreshViewContainer.getVisibility() != 0) {
                            this.mTopRefreshViewContainer.setVisibility(0);
                        }
                        if (!this.mScale) {
                            cb.O00000oo((View) this.mTopRefreshViewContainer, 1.0f);
                            cb.O0000O0o((View) this.mTopRefreshViewContainer, 1.0f);
                        }
                        if (this.usingDefaultHeader) {
                            float f3 = y / this.mTotalDragDistance;
                            if (f3 >= 1.0f) {
                                f3 = 1.0f;
                            }
                            cb.O00000oo(this.defaultProgressView, f3);
                            cb.O0000O0o(this.defaultProgressView, f3);
                            cb.O00000o0(this.defaultProgressView, f3);
                        }
                        float f4 = this.mTotalDragDistance;
                        if (y < f4) {
                            if (this.mScale) {
                                setAnimationProgress(y / f4);
                            }
                            OnPullRefreshListener onPullRefreshListener = this.mListener;
                            if (onPullRefreshListener != null) {
                                onPullRefreshListener.onPullEnable(false);
                            }
                        } else {
                            OnPullRefreshListener onPullRefreshListener2 = this.mListener;
                            if (onPullRefreshListener2 != null) {
                                onPullRefreshListener2.onPullEnable(true);
                            }
                        }
                        setTargetOffsetTopAndBottom(i2 - this.mCurrentTargetOffsetTop, true);
                    }
                } else if (i != 3) {
                    if (i == 5) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    } else if (i == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i3 = this.mActivePointerId;
            if (i3 == -1) {
                if (i == 1) {
                    gsy.O000000o(6, "refresh ", "Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            this.mIsBeingDragged = false;
            if ((motionEvent.getY(motionEvent.findPointerIndex(i3)) - this.mInitialMotionY) * 0.5f > this.mTotalDragDistance) {
                setRefreshing(true, true);
            } else {
                this.mRefreshing = false;
                AnonymousClass4 r12 = null;
                if (!this.mScale) {
                    r12 = new Animation.AnimationListener() {
                        /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass4 */

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            if (!RecyclerViewRefreshLayout.this.mScale) {
                                RecyclerViewRefreshLayout.this.startScaleDownAnimation(null);
                            }
                        }
                    };
                }
                animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r12);
            }
            this.mActivePointerId = -1;
            return false;
        }
        this.mActivePointerId = motionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
        return true;
    }

    private boolean handlerPushTouchEvent(MotionEvent motionEvent, int i) {
        OnPushLoadMoreListener onPushLoadMoreListener;
        boolean z = false;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    float y = (this.mInitialMotionY - motionEvent.getY(findPointerIndex)) * 0.5f;
                    if (this.mIsBeingDragged) {
                        this.pushDistance = (int) y;
                        updateFooterViewPosition();
                        OnPushLoadMoreListener onPushLoadMoreListener2 = this.mOnPushLoadMoreListener;
                        if (onPushLoadMoreListener2 != null) {
                            if (this.pushDistance >= this.mFooterViewHeight) {
                                z = true;
                            }
                            onPushLoadMoreListener2.onPushEnable(z);
                        }
                    }
                } else if (i != 3) {
                    if (i == 5) {
                        this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    } else if (i == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i2 = this.mActivePointerId;
            if (i2 == -1) {
                if (i == 1) {
                    gsy.O000000o(6, "refresh", "Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            float y2 = (this.mInitialMotionY - motionEvent.getY(motionEvent.findPointerIndex(i2))) * 0.5f;
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            int i3 = this.mFooterViewHeight;
            if (y2 < ((float) i3) || this.mOnPushLoadMoreListener == null) {
                this.pushDistance = 0;
            } else {
                this.pushDistance = i3;
            }
            if (Build.VERSION.SDK_INT < 11) {
                updateFooterViewPosition();
                if (this.pushDistance == this.mFooterViewHeight && (onPushLoadMoreListener = this.mOnPushLoadMoreListener) != null) {
                    this.mLoadMore = true;
                    onPushLoadMoreListener.onLoadMore();
                }
            } else {
                animatorFooterToBottom((int) y2, this.pushDistance);
            }
            return false;
        }
        this.mActivePointerId = motionEvent.getPointerId(0);
        this.mIsBeingDragged = false;
        return true;
    }

    @TargetApi(11)
    private void animatorFooterToBottom(int i, final int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass5 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RecyclerViewRefreshLayout.this.pushDistance = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RecyclerViewRefreshLayout.this.updateFooterViewPosition();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass6 */

            public void onAnimationEnd(Animator animator) {
                if (i2 <= 0 || RecyclerViewRefreshLayout.this.mOnPushLoadMoreListener == null) {
                    RecyclerViewRefreshLayout.this.resetTargetLayout();
                    RecyclerViewRefreshLayout.this.mLoadMore = false;
                    return;
                }
                RecyclerViewRefreshLayout recyclerViewRefreshLayout = RecyclerViewRefreshLayout.this;
                recyclerViewRefreshLayout.mLoadMore = true;
                recyclerViewRefreshLayout.mOnPushLoadMoreListener.onLoadMore();
            }
        });
        ofInt.setInterpolator(this.mDecelerateInterpolator);
        ofInt.start();
    }

    public void setMode(int i) {
        this.mMode = i;
    }

    public void setLoadMore(boolean z) {
        if (!z && this.mLoadMore) {
            if (Build.VERSION.SDK_INT < 11) {
                this.mLoadMore = false;
                this.pushDistance = 0;
                updateFooterViewPosition();
                return;
            }
            animatorFooterToBottom(this.mFooterViewHeight, 0);
        }
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mTopRefreshViewContainer.setAnimationListener(animationListener);
        }
        this.mTopRefreshViewContainer.clearAnimation();
        this.mTopRefreshViewContainer.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
        } else {
            this.mFrom = i;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if (animationListener != null) {
                this.mTopRefreshViewContainer.setAnimationListener(animationListener);
            }
            this.mTopRefreshViewContainer.clearAnimation();
            this.mTopRefreshViewContainer.startAnimation(this.mAnimateToStartPosition);
        }
        resetTargetLayoutDelay(200);
    }

    public void resetTargetLayoutDelay(int i) {
        new Handler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass7 */

            public void run() {
                RecyclerViewRefreshLayout.this.resetTargetLayout();
            }
        }, (long) i);
    }

    public void resetTargetLayout() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        View view = this.mTarget;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((view.getWidth() - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((view.getHeight() - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mTopRefreshViewContainer.getMeasuredWidth();
        int i = measuredWidth / 2;
        int i2 = measuredWidth2 / 2;
        this.mTopRefreshViewContainer.layout(i - i2, -this.mTopRefreshViewContainer.getMeasuredHeight(), i2 + i, 0);
        int measuredWidth3 = this.mFooterRefreshViewContainer.getMeasuredWidth();
        int i3 = measuredWidth3 / 2;
        this.mFooterRefreshViewContainer.layout(i - i3, measuredHeight, i + i3, this.mFooterRefreshViewContainer.getMeasuredHeight() + measuredHeight);
    }

    public void moveToStart(float f) {
        int i = this.mFrom;
        setTargetOffsetTopAndBottom((i + ((int) (((float) (this.mOriginalOffsetTop - i)) * f))) - this.mTopRefreshViewContainer.getTop(), false);
    }

    private void startScaleDownReturnToStartAnimation(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mStartingScale = cb.O0000oO(this.mTopRefreshViewContainer);
        this.mScaleDownToStartAnimation = new Animation() {
            /* class com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout.AnonymousClass10 */

            public void applyTransformation(float f, Transformation transformation) {
                RecyclerViewRefreshLayout.this.setAnimationProgress(RecyclerViewRefreshLayout.this.mStartingScale + ((-RecyclerViewRefreshLayout.this.mStartingScale) * f));
                RecyclerViewRefreshLayout.this.moveToStart(f);
            }
        };
        this.mScaleDownToStartAnimation.setDuration(150);
        if (animationListener != null) {
            this.mTopRefreshViewContainer.setAnimationListener(animationListener);
        }
        this.mTopRefreshViewContainer.clearAnimation();
        this.mTopRefreshViewContainer.startAnimation(this.mScaleDownToStartAnimation);
    }

    public void setTargetOffsetTopAndBottom(int i, boolean z) {
        this.mTopRefreshViewContainer.bringToFront();
        this.mTopRefreshViewContainer.offsetTopAndBottom(i);
        this.mCurrentTargetOffsetTop = this.mTopRefreshViewContainer.getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
        updateListenerCallBack();
    }

    public void updateFooterViewPosition() {
        this.mFooterRefreshViewContainer.setVisibility(0);
        this.mFooterRefreshViewContainer.bringToFront();
        this.mFooterRefreshViewContainer.offsetTopAndBottom(-this.pushDistance);
        updatePushDistanceListener();
    }

    private void updatePushDistanceListener() {
        OnPushLoadMoreListener onPushLoadMoreListener = this.mOnPushLoadMoreListener;
        if (onPushLoadMoreListener != null) {
            onPushLoadMoreListener.onPushDistance(this.pushDistance);
        }
    }

    class HeadViewContainer extends RelativeLayout {
        private Animation.AnimationListener mListener;

        public HeadViewContainer(Context context) {
            super(context);
        }

        public void setAnimationListener(Animation.AnimationListener animationListener) {
            this.mListener = animationListener;
        }

        public void onAnimationStart() {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }
    }

    public boolean isTargetScrollWithLayout() {
        return this.targetScrollWithLayout;
    }

    public void setTargetScrollWithLayout(boolean z) {
        this.targetScrollWithLayout = z;
    }

    public class OnPullRefreshListenerAdapter implements OnPullRefreshListener {
        public void onPullDistance(int i) {
        }

        public void onPullEnable(boolean z) {
        }

        public void onRefresh() {
        }

        public OnPullRefreshListenerAdapter() {
        }
    }

    public class OnPushLoadMoreListenerAdapter implements OnPushLoadMoreListener {
        public void onLoadMore() {
        }

        public void onPushDistance(int i) {
        }

        public void onPushEnable(boolean z) {
        }

        public OnPushLoadMoreListenerAdapter() {
        }
    }

    public void setDefaultCircleProgressColor(int i) {
        if (this.usingDefaultHeader) {
            this.defaultProgressView.setProgressColor(i);
        }
    }

    public void setDefaultCircleBackgroundColor(int i) {
        if (this.usingDefaultHeader) {
            this.defaultProgressView.setCircleBackgroundColor(i);
        }
    }

    public void setDefaultCircleShadowColor(int i) {
        if (this.usingDefaultHeader) {
            this.defaultProgressView.setShadowColor(i);
        }
    }

    public class CircleProgressView extends View implements Runnable {
        private Paint bgPaint;
        private RectF bgRect = null;
        private int circleBackgroundColor = -1;
        private int height;
        private boolean isOnDraw = false;
        private boolean isRunning = false;
        private RectF ovalRect = null;
        private int progressColor = -3355444;
        private Paint progressPaint;
        private int shadowColor = -6710887;
        private int speed = 8;
        private int startAngle = 0;
        private int swipeAngle;
        private int width;

        public CircleProgressView(Context context) {
            super(context);
        }

        public CircleProgressView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(getBgRect(), 0.0f, 360.0f, false, createBgPaint());
            int i = this.startAngle;
            if ((i / 360) % 2 == 0) {
                this.swipeAngle = (i % 720) / 2;
            } else {
                this.swipeAngle = 360 - ((i % 720) / 2);
            }
            canvas.drawArc(getOvalRect(), (float) this.startAngle, (float) this.swipeAngle, false, createPaint());
        }

        private RectF getBgRect() {
            this.width = getWidth();
            this.height = getHeight();
            if (this.bgRect == null) {
                int i = (int) (RecyclerViewRefreshLayout.this.density * 2.0f);
                float f = (float) i;
                this.bgRect = new RectF(f, f, (float) (this.width - i), (float) (this.height - i));
            }
            return this.bgRect;
        }

        private RectF getOvalRect() {
            this.width = getWidth();
            this.height = getHeight();
            if (this.ovalRect == null) {
                int i = (int) (RecyclerViewRefreshLayout.this.density * 8.0f);
                float f = (float) i;
                this.ovalRect = new RectF(f, f, (float) (this.width - i), (float) (this.height - i));
            }
            return this.ovalRect;
        }

        public void setProgressColor(int i) {
            this.progressColor = i;
        }

        public void setCircleBackgroundColor(int i) {
            this.circleBackgroundColor = i;
        }

        public void setShadowColor(int i) {
            this.shadowColor = i;
        }

        private Paint createPaint() {
            if (this.progressPaint == null) {
                this.progressPaint = new Paint();
                this.progressPaint.setStrokeWidth((float) ((int) (RecyclerViewRefreshLayout.this.density * 3.0f)));
                this.progressPaint.setStyle(Paint.Style.STROKE);
                this.progressPaint.setAntiAlias(true);
            }
            this.progressPaint.setColor(this.progressColor);
            return this.progressPaint;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
         arg types: [int, int, int, int]
         candidates:
          ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
          ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
        private Paint createBgPaint() {
            if (this.bgPaint == null) {
                this.bgPaint = new Paint();
                this.bgPaint.setColor(this.circleBackgroundColor);
                this.bgPaint.setStyle(Paint.Style.FILL);
                this.bgPaint.setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    setLayerType(1, this.bgPaint);
                }
                this.bgPaint.setShadowLayer(4.0f, 0.0f, 2.0f, this.shadowColor);
            }
            return this.bgPaint;
        }

        public void setPullDistance(int i) {
            this.startAngle = i * 2;
            postInvalidate();
        }

        public void run() {
            while (this.isOnDraw) {
                this.isRunning = true;
                long currentTimeMillis = System.currentTimeMillis();
                this.startAngle += this.speed;
                postInvalidate();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 < 16) {
                    try {
                        Thread.sleep(16 - currentTimeMillis2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void setOnDraw(boolean z) {
            this.isOnDraw = z;
        }

        public void setSpeed(int i) {
            this.speed = i;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            this.isOnDraw = false;
            super.onDetachedFromWindow();
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return motionEvent.getY(findPointerIndex);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || (!isChildScrollToTop() && !isChildScrollToBottom())) {
            return false;
        }
        if (this.mRefreshing) {
            return true;
        }
        if (isChildScrollToBottom()) {
            return handlerPushTouchEvent(motionEvent, actionMasked);
        }
        return handlerPullTouchEvent(motionEvent, actionMasked);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
