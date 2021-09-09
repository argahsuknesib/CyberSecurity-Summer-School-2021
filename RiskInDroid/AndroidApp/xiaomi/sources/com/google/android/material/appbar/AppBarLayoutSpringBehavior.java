package com.google.android.material.appbar;

import _m_j.cb;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.hzf;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.widget.MainPageAppBarLayout;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyViewPager;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayoutSpringBehavior extends AppBarLayout.Behavior {
    private static final String TAG = "AppBarLayoutSpringBehavior";
    int collapseHeight = 0;
    private ValueAnimator mAnimateBackAnimator;
    private MainPageAppBarLayout mAppBarLayout;
    private boolean mChildPosAlignedInCollapseMode = false;
    private int mContentHeight = 0;
    public boolean mHapticFeedback;
    private float mIsFling = 0.0f;
    public boolean mIsNormalScrollEnabled = true;
    private boolean mIsPullToRefreshEnabled = true;
    public int mOffset = 0;
    private ValueAnimator mOffsetAnimator;
    private float mOffsetSpring;
    private int mPreHeadHeight;
    private List<PullToRefreshCallback> mPullToRefreshCallbacks = new ArrayList();
    private Animator mRunningAnimator = null;
    private List<SpringOffsetCallback> mSpringOffsetCallbacks;
    private ValueAnimator mSpringRecoverAnimator;
    public int mState = 0;
    private MyViewPager mViewPager;

    public interface PullToRefreshCallback {
        void onComplete();

        void onDrag(int i, boolean z);

        void onOffsetChanged(int i);

        void onRefresh();
    }

    public interface SpringOffsetCallback {
        void springCallback(int i);
    }

    private static boolean checkFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public AppBarLayoutSpringBehavior() {
    }

    public AppBarLayoutSpringBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z = (i & 2) != 0 && appBarLayout.hasScrollableChildren();
        if (z && (valueAnimator2 = this.mOffsetAnimator) != null) {
            valueAnimator2.cancel();
        }
        if (z && (valueAnimator = this.mSpringRecoverAnimator) != null && valueAnimator.isRunning()) {
            this.mSpringRecoverAnimator.cancel();
        }
        ValueAnimator valueAnimator3 = this.mAnimateBackAnimator;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            this.mAnimateBackAnimator.cancel();
        }
        return z;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        gsy.O00000Oo(TAG, "onStartNestedScroll");
        boolean z = (i & 2) != 0 && appBarLayout.hasScrollableChildren();
        if (z && (valueAnimator2 = this.mOffsetAnimator) != null) {
            valueAnimator2.cancel();
        }
        if (z && (valueAnimator = this.mSpringRecoverAnimator) != null && valueAnimator.isRunning()) {
            this.mSpringRecoverAnimator.cancel();
        }
        ValueAnimator valueAnimator3 = this.mAnimateBackAnimator;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            this.mAnimateBackAnimator.cancel();
        }
        return z;
    }

    public void onStopNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, View view, int i) {
        String str = TAG;
        gsy.O00000Oo(str, "onStopNestedScroll mIsFling=" + this.mIsFling + ",mOffsetSpring=" + this.mOffsetSpring + ",mOffset=" + this.mOffset + ",abl.getHeight=" + appBarLayout.getHeight() + ",mContentHeight=" + this.mContentHeight);
        if (this.mOffset >= 0 || this.mIsNormalScrollEnabled || appBarLayout.getHeight() != this.mContentHeight) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
            if (this.mIsFling == 0.0f || this.mOffsetSpring > 0.0f || this.mOffset < 0) {
                checkShouldSpringRecover(coordinatorLayout, appBarLayout);
            } else if ((appBarLayout instanceof MainPageAppBarLayout) && ((MainPageAppBarLayout) appBarLayout).O0000Oo0) {
                this.mIsFling = 0.0f;
                return;
            } else if (((float) this.mOffset) <= 300.0f) {
                refreshComplete(coordinatorLayout, appBarLayout);
            } else if (((float) appBarLayout.getHeight()) < ((float) this.mContentHeight) + 300.0f || !this.mIsPullToRefreshEnabled || this.mPullToRefreshCallbacks.size() <= 0) {
                refreshComplete(coordinatorLayout, appBarLayout);
            } else {
                doCallbackRefresh();
            }
            this.mIsFling = 0.0f;
            return;
        }
        Animator animator = this.mRunningAnimator;
        if (animator == null || !animator.isRunning()) {
            ValueAnimator valueAnimator = this.mAnimateBackAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mAnimateBackAnimator.cancel();
            }
            this.mAnimateBackAnimator = ValueAnimator.ofInt(new int[0]);
            ValueAnimator valueAnimator2 = this.mAnimateBackAnimator;
            this.mRunningAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(new DecelerateInterpolator());
            this.mAnimateBackAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass1 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppBarLayoutSpringBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            CommonApplication.getAppContext().getResources().getDimensionPixelSize(R.dimen.titlebar_height);
            gpc.O000000o(20.0f);
            this.mAnimateBackAnimator.setIntValues(this.mOffset, 0);
            this.mAnimateBackAnimator.addListener(new Animator.AnimatorListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass2 */

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    AppBarLayoutSpringBehavior.this.mOffset = 0;
                }
            });
            this.mAnimateBackAnimator.setDuration(200L);
            this.mAnimateBackAnimator.start();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):void
     arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View]
     candidates:
      com.google.android.material.appbar.AppBarLayoutSpringBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View):void
      androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):void */
    public void onStopNestedScroll(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, View view) {
        if (this.mOffset >= 0 || this.mIsNormalScrollEnabled || appBarLayout.getHeight() != this.mContentHeight) {
            super.onStopNestedScroll(coordinatorLayout, (View) appBarLayout, view);
            if (this.mIsFling == 0.0f || this.mOffsetSpring > 0.0f || this.mOffset < 0) {
                checkShouldSpringRecover(coordinatorLayout, appBarLayout);
            } else if ((appBarLayout instanceof MainPageAppBarLayout) && ((MainPageAppBarLayout) appBarLayout).O0000Oo0) {
                this.mIsFling = 0.0f;
                return;
            } else if (((float) this.mOffset) <= 300.0f) {
                refreshComplete(coordinatorLayout, appBarLayout);
            } else if (((float) appBarLayout.getHeight()) < ((float) this.mContentHeight) + 300.0f || !this.mIsPullToRefreshEnabled || this.mPullToRefreshCallbacks.size() <= 0) {
                refreshComplete(coordinatorLayout, appBarLayout);
            } else {
                doCallbackRefresh();
            }
            this.mIsFling = 0.0f;
            return;
        }
        Animator animator = this.mRunningAnimator;
        if (animator == null || !animator.isRunning()) {
            ValueAnimator valueAnimator = this.mAnimateBackAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mAnimateBackAnimator.cancel();
            }
            this.mAnimateBackAnimator = ValueAnimator.ofInt(new int[0]);
            ValueAnimator valueAnimator2 = this.mAnimateBackAnimator;
            this.mRunningAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(new DecelerateInterpolator());
            this.mAnimateBackAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass3 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppBarLayoutSpringBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            CommonApplication.getAppContext().getResources().getDimensionPixelSize(R.dimen.titlebar_height);
            gpc.O000000o(20.0f);
            this.mAnimateBackAnimator.setIntValues(this.mOffset, 0);
            this.mAnimateBackAnimator.addListener(new Animator.AnimatorListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass4 */

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    AppBarLayoutSpringBehavior.this.mOffset = 0;
                }
            });
            this.mAnimateBackAnimator.setDuration(200L);
            this.mAnimateBackAnimator.start();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, float, float):boolean
     arg types: [androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, float, float]
     candidates:
      com.google.android.material.appbar.AppBarLayoutSpringBehavior.onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, float, float):boolean
      androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.onNestedPreFling(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, float, float):boolean */
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        this.mIsFling = f2;
        if (((MainPageAppBarLayout) appBarLayout).O0000Oo0) {
            return super.onNestedPreFling(coordinatorLayout, (View) appBarLayout, view, f, f2);
        }
        return true;
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
        if (!z) {
            return fling(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
        } else if (f2 < 0.0f) {
            return false;
        } else {
            if (this.mOffsetSpring <= 0.0f) {
                int dimensionPixelSize = (this.mContentHeight - CommonApplication.getAppContext().getResources().getDimensionPixelSize(R.dimen.titlebar_height)) - gpc.O000000o(20.0f);
                if (Math.abs(-appBarLayout.getUpNestedPreScrollRange()) > Math.abs(dimensionPixelSize * 3)) {
                    animateOffsetTo(coordinatorLayout, appBarLayout, getTopBottomOffsetForScrollingSibling() - dimensionPixelSize, f2);
                    return true;
                }
                getTopBottomOffsetForScrollingSibling();
                checkShouldSpringRecover(coordinatorLayout, appBarLayout);
                return true;
            }
            int dimensionPixelSize2 = (this.mContentHeight - CommonApplication.getAppContext().getResources().getDimensionPixelSize(R.dimen.titlebar_height)) - gpc.O000000o(20.0f);
            if (Math.abs(-appBarLayout.getUpNestedPreScrollRange()) > Math.abs(dimensionPixelSize2 * 3)) {
                animateOffsetTo(coordinatorLayout, appBarLayout, getTopBottomOffsetForScrollingSibling() - dimensionPixelSize2, f2);
                return true;
            }
            getTopBottomOffsetForScrollingSibling();
            refreshComplete(coordinatorLayout, appBarLayout);
            return true;
        }
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        this.mPreHeadHeight = i;
    }

    private void checkShouldSpringRecover(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
        if (this.mOffset > 0 && this.mOffsetSpring == 0.0f) {
            setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
        } else if (this.mOffsetSpring > 0.0f) {
            animateRecoverBySpring(coordinatorLayout, appBarLayout);
        } else if (!(appBarLayout instanceof MainPageAppBarLayout) || !((MainPageAppBarLayout) appBarLayout).O0000Oo0) {
            Animator animator = this.mRunningAnimator;
            if (animator == null || !animator.isRunning()) {
                ValueAnimator valueAnimator = this.mAnimateBackAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.mAnimateBackAnimator.cancel();
                }
                this.mAnimateBackAnimator = ValueAnimator.ofInt(new int[0]);
                ValueAnimator valueAnimator2 = this.mAnimateBackAnimator;
                this.mRunningAnimator = valueAnimator2;
                valueAnimator2.setInterpolator(new DecelerateInterpolator());
                this.mAnimateBackAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass5 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppBarLayoutSpringBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                int topAndBottomOffset = getTopAndBottomOffset();
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                final boolean z = Math.abs(topAndBottomOffset) < Math.abs(totalScrollRange / 2);
                if (z) {
                    this.mAnimateBackAnimator.setIntValues(topAndBottomOffset, 0);
                } else {
                    this.mAnimateBackAnimator.setIntValues(topAndBottomOffset, -totalScrollRange);
                }
                this.mAnimateBackAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass6 */

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (z) {
                            AppBarLayoutSpringBehavior.this.mOffset = 0;
                        }
                    }
                });
                this.mAnimateBackAnimator.setDuration(200L);
                gsy.O00000Oo(TAG, "animation start 260");
                this.mAnimateBackAnimator.start();
            }
        }
    }

    public void addPullToRefreshCallback(PullToRefreshCallback pullToRefreshCallback) {
        if (!this.mPullToRefreshCallbacks.contains(pullToRefreshCallback)) {
            this.mPullToRefreshCallbacks.add(pullToRefreshCallback);
        }
    }

    private void doCallbackDrag(int i, boolean z) {
        for (PullToRefreshCallback onDrag : this.mPullToRefreshCallbacks) {
            onDrag.onDrag(i, z);
        }
    }

    private void doCallbackComplete() {
        for (PullToRefreshCallback onComplete : this.mPullToRefreshCallbacks) {
            onComplete.onComplete();
        }
    }

    private void doCallbackRefresh() {
        for (PullToRefreshCallback onRefresh : this.mPullToRefreshCallbacks) {
            onRefresh.onRefresh();
        }
    }

    private void doCallbackOnOffsetChanged(int i) {
        for (PullToRefreshCallback onOffsetChanged : this.mPullToRefreshCallbacks) {
            onOffsetChanged.onOffsetChanged(i);
        }
    }

    public void collapse(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        if (this.mIsNormalScrollEnabled) {
            setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
        }
    }

    public void expand(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
    }

    public void refreshComplete(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
        gsy.O00000Oo(TAG, "refreshComplete");
        this.mState = 3;
        ValueAnimator valueAnimator = this.mSpringRecoverAnimator;
        if (valueAnimator == null) {
            this.mSpringRecoverAnimator = new ValueAnimator();
            this.mSpringRecoverAnimator.setDuration(200L);
            this.mSpringRecoverAnimator.setInterpolator(new DecelerateInterpolator());
            this.mSpringRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass7 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppBarLayoutSpringBehavior.this.updateSpringHeaderHeight(coordinatorLayout, appBarLayout, (float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.mSpringRecoverAnimator.addListener(new Animator.AnimatorListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass8 */

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    AppBarLayoutSpringBehavior appBarLayoutSpringBehavior = AppBarLayoutSpringBehavior.this;
                    appBarLayoutSpringBehavior.mState = 0;
                    appBarLayoutSpringBehavior.mHapticFeedback = false;
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.mSpringRecoverAnimator.cancel();
        }
        Animator animator = this.mRunningAnimator;
        if (animator == null || !animator.isRunning()) {
            this.mRunningAnimator = this.mSpringRecoverAnimator;
            if (Integer.compare((int) this.mOffsetSpring, 0) != 0) {
                gsy.O00000Oo(TAG, "animation start 330");
                this.mSpringRecoverAnimator.setIntValues((int) this.mOffsetSpring, 0);
                this.mSpringRecoverAnimator.start();
            }
            if (this.mIsPullToRefreshEnabled && this.mPullToRefreshCallbacks.size() > 0) {
                doCallbackComplete();
            }
        }
    }

    private void processPullRefresh(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        String str = TAG;
        gsy.O00000Oo(str, "processPullRefresh mOffsetSpring=" + this.mOffsetSpring + ",mOffset=" + this.mOffset);
        float f = this.mOffsetSpring;
        if (f < 150.0f) {
            refreshComplete(coordinatorLayout, appBarLayout);
        } else if (f < 300.0f) {
            this.mState = 2;
            if (this.mIsPullToRefreshEnabled && this.mPullToRefreshCallbacks.size() > 0) {
                doCallbackRefresh();
            }
        } else {
            this.mState = 2;
            if (this.mIsPullToRefreshEnabled && this.mPullToRefreshCallbacks.size() > 0) {
                doCallbackRefresh();
            }
        }
    }

    private void animateToNormalExpand(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, Animator.AnimatorListener animatorListener) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (topBottomOffsetForScrollingSibling != 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(topBottomOffsetForScrollingSibling, 0);
            Animator animator = this.mRunningAnimator;
            if (animator == null || !animator.isRunning()) {
                this.mRunningAnimator = ofInt;
                ofInt.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass9 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppBarLayoutSpringBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                ofInt.addListener(animatorListener);
                ofInt.setDuration((long) Math.min(200, 600));
                gsy.O00000Oo(TAG, "animation start 376");
                ofInt.start();
            }
        } else if (animatorListener != null) {
            animatorListener.onAnimationEnd(null);
        }
    }

    private void animateRecoverBySpring(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout) {
        String str = TAG;
        gsy.O00000Oo(str, "animateRecoverBySpring mOffsetSpring=" + this.mOffsetSpring + ",mOffset=" + this.mOffset);
        if (this.mIsPullToRefreshEnabled) {
            processPullRefresh(coordinatorLayout, appBarLayout);
            return;
        }
        ValueAnimator valueAnimator = this.mSpringRecoverAnimator;
        if (valueAnimator == null) {
            this.mSpringRecoverAnimator = new ValueAnimator();
            this.mSpringRecoverAnimator.setDuration(200L);
            this.mSpringRecoverAnimator.setInterpolator(new DecelerateInterpolator());
            this.mSpringRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass10 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppBarLayoutSpringBehavior.this.updateSpringHeaderHeight(coordinatorLayout, appBarLayout, (float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.mSpringRecoverAnimator.cancel();
        }
        Animator animator = this.mRunningAnimator;
        if (animator == null || !animator.isRunning()) {
            ValueAnimator valueAnimator2 = this.mSpringRecoverAnimator;
            this.mRunningAnimator = valueAnimator2;
            valueAnimator2.setIntValues((int) this.mOffsetSpring, 0);
            gsy.O00000Oo(TAG, "animation start 401");
            this.mSpringRecoverAnimator.start();
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        if (this.collapseHeight == 0 && appBarLayout.getChildAt(0) != null) {
            this.collapseHeight = gpc.O000000o(65.0f);
        }
        return onLayoutChild;
    }

    /* access modifiers changed from: package-private */
    public int getHeaderExpandedHeight(AppBarLayout appBarLayout) {
        int childCount = appBarLayout.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = appBarLayout.getChildAt(i2);
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            childAt.getMeasuredHeight();
            int i3 = layoutParams.topMargin;
            int i4 = layoutParams.bottomMargin;
            i = childAt.getBottom();
        }
        return Math.max(0, i);
    }

    /* access modifiers changed from: package-private */
    public void onFlingFinished(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        gsy.O00000Oo(TAG, "onFlingFinished");
        animateRecoverBySpring(coordinatorLayout, appBarLayout);
    }

    private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        gsy.O00000Oo(TAG, "snapToChildIfNeeded");
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        int childIndexOnOffset = getChildIndexOnOffset(appBarLayout, topBottomOffsetForScrollingSibling);
        if (childIndexOnOffset >= 0) {
            View childAt = appBarLayout.getChildAt(childIndexOnOffset);
            int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
            if ((scrollFlags & 17) == 17) {
                int i = -childAt.getTop();
                int i2 = -childAt.getBottom();
                if (childIndexOnOffset == appBarLayout.getChildCount() - 1) {
                    i2 += appBarLayout.getTopInset();
                }
                if (checkFlag(scrollFlags, 2)) {
                    i2 += cb.O0000o0o(childAt);
                } else if (checkFlag(scrollFlags, 5)) {
                    int O0000o0o = cb.O0000o0o(childAt) + i2;
                    if (topBottomOffsetForScrollingSibling < O0000o0o) {
                        i = O0000o0o;
                    } else {
                        i2 = O0000o0o;
                    }
                }
                if (topBottomOffsetForScrollingSibling < (i2 + i) / 2) {
                    i = i2;
                }
                animateOffsetTo(coordinatorLayout, appBarLayout, constrain(i, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
            }
        }
    }

    private void animateOffsetTo(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
        int i2;
        gsy.O00000Oo(TAG, "animateOffsetTo");
        int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
        float abs2 = Math.abs(f);
        if (abs2 > 0.0f) {
            i2 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
        } else {
            i2 = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
        }
        animateOffsetWithDuration(coordinatorLayout, appBarLayout, i, i2);
    }

    private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
        gsy.O00000Oo(TAG, "animateOffsetWithDuration");
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (topBottomOffsetForScrollingSibling == i) {
            ValueAnimator valueAnimator = this.mOffsetAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mOffsetAnimator.cancel();
                return;
            }
            return;
        }
        ValueAnimator valueAnimator2 = this.mOffsetAnimator;
        if (valueAnimator2 == null) {
            this.mOffsetAnimator = new ValueAnimator();
            this.mOffsetAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass11 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppBarLayoutSpringBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimator2.cancel();
        }
        Animator animator = this.mRunningAnimator;
        if (animator == null || !animator.isRunning()) {
            ValueAnimator valueAnimator3 = this.mOffsetAnimator;
            this.mRunningAnimator = valueAnimator3;
            valueAnimator3.setDuration((long) Math.min(i2, 600));
            this.mOffsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            String str = TAG;
            gsy.O00000Oo(str, "animation start 526 currentOffset=" + topBottomOffsetForScrollingSibling + ",offset=" + i);
            this.mOffsetAnimator.start();
        }
    }

    private int getChildIndexOnOffset(AppBarLayout appBarLayout, int i) {
        int childCount = appBarLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = appBarLayout.getChildAt(i2);
            int i3 = -i;
            if (childAt.getTop() <= i3 && childAt.getBottom() >= i3) {
                return i2;
            }
        }
        return -1;
    }

    public void setPullToRefreshEnabled(boolean z) {
        this.mIsPullToRefreshEnabled = z;
    }

    public void setNormalScrollEnable(boolean z, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        if (!z) {
            animateToNormalExpand(coordinatorLayout, appBarLayout, new Animator.AnimatorListener() {
                /* class com.google.android.material.appbar.AppBarLayoutSpringBehavior.AnonymousClass12 */

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    AppBarLayoutSpringBehavior.this.mIsNormalScrollEnabled = false;
                }
            });
        } else {
            this.mIsNormalScrollEnabled = true;
        }
    }

    public boolean setTopAndBottomOffset(int i) {
        return super.setTopAndBottomOffset(i);
    }

    /* access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
        int i4;
        int i5;
        this.mOffset = i;
        String str = TAG;
        gsy.O00000Oo(str, "setHeaderTopBottomOffset mOffset=" + this.mOffset);
        boolean z = false;
        if (this.mIsPullToRefreshEnabled && this.mState == 2 && i > 0) {
            return 0;
        }
        if (this.mOffsetSpring <= 0.0f) {
            this.mState = 0;
            this.mHapticFeedback = false;
        } else {
            this.mState = 1;
        }
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (this.mOffsetSpring == 0.0f || i >= 0) {
            i5 = i;
            i4 = 0;
        } else {
            String str2 = TAG;
            gsy.O00000Oo(str2, "setHeaderTopBottomOffset1 mOffsetSpring=" + this.mOffsetSpring + ",originNew=" + i);
            int i6 = (int) (this.mOffsetSpring + ((float) i));
            if (i6 < 0) {
                i6 = 0;
                i5 = 0;
            } else {
                i5 = i;
            }
            updateSpringOffsetByscroll(coordinatorLayout, appBarLayout, (float) i6);
            i4 = getTopBottomOffsetForScrollingSibling() - i;
            if (i6 >= 0) {
                if (this.mIsPullToRefreshEnabled && this.mPullToRefreshCallbacks.size() > 0) {
                    float f = this.mOffsetSpring;
                    int i7 = (int) f;
                    if (f >= 150.0f) {
                        z = true;
                    }
                    doCallbackDrag(i7, z);
                }
                coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                return i4;
            }
        }
        if (this.mOffsetSpring <= 0.0f || appBarLayout.getHeight() < this.mPreHeadHeight || i5 <= 0) {
            if (i2 != 0 && topBottomOffsetForScrollingSibling >= i2 && topBottomOffsetForScrollingSibling <= i3) {
                int constrain = constrain(i5, i2, i3);
                if (topBottomOffsetForScrollingSibling != constrain) {
                    setTopAndBottomOffset(appBarLayout.hasChildWithInterpolator() ? interpolateOffset(appBarLayout, constrain) : constrain);
                    i4 = topBottomOffsetForScrollingSibling - constrain;
                    appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, constrain, constrain < topBottomOffsetForScrollingSibling ? -1 : 1);
                } else if (!(topBottomOffsetForScrollingSibling == i2 || i == 0)) {
                    String str3 = TAG;
                    gsy.O00000Oo(str3, "setHeaderTopBottomOffset3 mOffsetSpring=" + this.mOffsetSpring + ",originNew=" + i);
                    updateSpringOffsetByscroll(coordinatorLayout, appBarLayout, this.mOffsetSpring + ((float) (i / 3)));
                    i4 = getTopBottomOffsetForScrollingSibling() - i;
                }
            }
            if (!(appBarLayout instanceof MainPageAppBarLayout)) {
                coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                this.mChildPosAlignedInCollapseMode = false;
            } else if (!((MainPageAppBarLayout) appBarLayout).O0000Oo0) {
                coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                this.mChildPosAlignedInCollapseMode = false;
            } else if (!this.mChildPosAlignedInCollapseMode) {
                coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                appBarLayout.onOffsetChanged(getTopAndBottomOffset());
                this.mChildPosAlignedInCollapseMode = true;
            }
            return i4;
        }
        String str4 = TAG;
        gsy.O00000Oo(str4, "setHeaderTopBottomOffset2 mOffsetSpring=" + this.mOffsetSpring + ",originNew=" + i5);
        updateSpringOffsetByscroll(coordinatorLayout, appBarLayout, this.mOffsetSpring + (((float) i5) / 3.0f));
        int topBottomOffsetForScrollingSibling2 = getTopBottomOffsetForScrollingSibling() - i5;
        if (this.mIsPullToRefreshEnabled && this.mPullToRefreshCallbacks.size() > 0) {
            float f2 = this.mOffsetSpring;
            int i8 = (int) f2;
            if (f2 >= 150.0f) {
                z = true;
            }
            doCallbackDrag(i8, z);
        }
        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
        appBarLayout.onOffsetChanged(getTopAndBottomOffset());
        return topBottomOffsetForScrollingSibling2;
    }

    private int interpolateOffset(AppBarLayout appBarLayout, int i) {
        gsy.O00000Oo(TAG, "interpolateOffset");
        int abs = Math.abs(i);
        int childCount = appBarLayout.getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = appBarLayout.getChildAt(i3);
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                i3++;
            } else if (scrollInterpolator != null) {
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    i2 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                    if ((scrollFlags & 2) != 0) {
                        i2 -= cb.O0000o0o(childAt);
                    }
                }
                if (cb.O0000ooo(childAt)) {
                    i2 -= appBarLayout.getTopInset();
                }
                if (i2 > 0) {
                    float f = (float) i2;
                    return Integer.signum(i) * (childAt.getTop() + Math.round(f * scrollInterpolator.getInterpolation(((float) (abs - childAt.getTop())) / f)));
                }
            }
        }
        return i;
    }

    private void updateAppBarLayoutDrawableState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
        gsy.O00000Oo(TAG, "updateAppBarLayoutDrawableState");
        View appBarChildOnOffset = getAppBarChildOnOffset(appBarLayout, i);
        if (appBarChildOnOffset != null) {
            int scrollFlags = ((AppBarLayout.LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
            boolean z = false;
            if ((scrollFlags & 1) != 0) {
                int O0000o0o = cb.O0000o0o(appBarChildOnOffset);
                if (i2 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i) < (appBarChildOnOffset.getBottom() - O0000o0o) - appBarLayout.getTopInset()) : (-i) >= (appBarChildOnOffset.getBottom() - O0000o0o) - appBarLayout.getTopInset()) {
                    z = true;
                }
            }
            if (appBarLayout.setLiftedState(z) && Build.VERSION.SDK_INT >= 11 && shouldJumpElevationState(coordinatorLayout, appBarLayout)) {
                appBarLayout.jumpDrawablesToCurrentState();
            }
        }
    }

    private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        gsy.O00000Oo(TAG, "shouldJumpElevationState");
        List<View> dependents = coordinatorLayout.getDependents(appBarLayout);
        int size = dependents.size();
        int i = 0;
        while (i < size) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.O00000o) dependents.get(i).getLayoutParams()).f2811O000000o;
            if (!(behavior instanceof AppBarLayout.ScrollingViewBehavior)) {
                i++;
            } else if (((AppBarLayout.ScrollingViewBehavior) behavior).getOverlayTop() != 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i) {
        int abs = Math.abs(i);
        int childCount = appBarLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = appBarLayout.getChildAt(i2);
            if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private void updateSpringOffsetByscroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, float f) {
        gsy.O00000Oo(TAG, "updateSpringOffsetByscroll");
        ValueAnimator valueAnimator = this.mSpringRecoverAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mSpringRecoverAnimator.cancel();
        }
        updateSpringHeaderHeight(coordinatorLayout, appBarLayout, f);
    }

    public void updateSpringHeaderHeight(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, float f) {
        String str = TAG;
        gsy.O00000Oo(str, "updateSpringHeaderHeight " + f + ",mOffset=" + this.mOffset);
        if (appBarLayout.getHeight() >= this.mPreHeadHeight && f >= 0.0f) {
            List<SpringOffsetCallback> list = this.mSpringOffsetCallbacks;
            if (list != null) {
                for (SpringOffsetCallback springCallback : list) {
                    springCallback.springCallback((int) f);
                }
            }
            String str2 = TAG;
            gsy.O00000Oo(str2, "updateSpringHeaderHeight mPreHeadHeight=" + this.mPreHeadHeight + ",appBarLayout.getHeight()=" + appBarLayout.getHeight());
            this.mOffsetSpring = f;
            if (this.mOffsetSpring > 150.0f) {
                if (!this.mHapticFeedback) {
                    hzf.O000000o(coordinatorLayout);
                }
                this.mHapticFeedback = true;
            }
            CoordinatorLayout.O00000o o00000o = (CoordinatorLayout.O00000o) appBarLayout.getLayoutParams();
            o00000o.height = (int) (((float) this.mPreHeadHeight) + f);
            appBarLayout.setLayoutParams(o00000o);
            coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
            doCallbackOnOffsetChanged((int) f);
        }
    }

    public int getOffsetSpring() {
        return (int) this.mOffsetSpring;
    }

    public void addSpringOffsetCallback(SpringOffsetCallback springOffsetCallback) {
        if (this.mSpringOffsetCallbacks == null) {
            this.mSpringOffsetCallbacks = new ArrayList();
        }
        if (springOffsetCallback != null && !this.mSpringOffsetCallbacks.contains(springOffsetCallback)) {
            this.mSpringOffsetCallbacks.add(springOffsetCallback);
        }
    }

    public void removeSpringOffsetCallback(SpringOffsetCallback springOffsetCallback) {
        List<SpringOffsetCallback> list;
        if (springOffsetCallback != null && (list = this.mSpringOffsetCallbacks) != null) {
            list.remove(springOffsetCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isOffsetAnimatorRunning() {
        ValueAnimator valueAnimator = this.mOffsetAnimator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return super.getTopBottomOffsetForScrollingSibling();
    }
}
