package com.xiaomi.smarthome.camera.v4.view;

import _m_j.cki;
import _m_j.gpc;
import _m_j.gsy;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity;

public class MIDrawerLayout2 extends RelativeLayout {
    public static final String TAG = "MIDrawerLayout2";
    public static boolean isShowFace = false;
    private boolean closed;
    float distance;
    float downY;
    int duration;
    int endTopMargin;
    float endY;
    private boolean firstSizeChange;
    int flag;
    private int halfImageParentHeight;
    RelativeLayout imageParent;
    FrameLayout.LayoutParams imageParent_Params;
    int itemHeight;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private VelocityTracker mVelocityTracker;
    int marginBottom40dp;
    public MyScrollView myScrollView;
    LinearLayout.LayoutParams myScrollView_layoutParams;
    public boolean needIntercept;
    float scrollY;
    int startTopMargin;
    float startY;
    private int state;
    private StateChangedListener stateChangedListener;
    LinearLayout title;
    LinearLayout.LayoutParams title_Params;
    int titlestartWidth;
    boolean touchUp;

    public interface StateChangedListener {
        void onClosed(boolean z);
    }

    public boolean isClosed() {
        return this.closed;
    }

    public MIDrawerLayout2(Context context) {
        this(context, null);
    }

    public MIDrawerLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MIDrawerLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.closed = true;
        this.itemHeight = 0;
        this.marginBottom40dp = 0;
        this.needIntercept = false;
        this.firstSizeChange = true;
        this.startY = 0.0f;
        this.endY = 0.0f;
        this.downY = 0.0f;
        this.scrollY = 0.0f;
        this.distance = 0.0f;
        this.touchUp = true;
        this.state = 0;
        this.flag = 0;
        this.duration = 200;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        gsy.O000000o(3, TAG, "onFinishInflate");
        super.onFinishInflate();
        this.marginBottom40dp = gpc.O000000o(getContext(), 40.0f);
        this.title = (LinearLayout) ((LinearLayout) getChildAt(1)).getChildAt(0);
        this.title_Params = (LinearLayout.LayoutParams) this.title.getLayoutParams();
        this.myScrollView = (MyScrollView) ((LinearLayout) getChildAt(0)).getChildAt(1);
        this.myScrollView_layoutParams = (LinearLayout.LayoutParams) this.myScrollView.getLayoutParams();
        this.imageParent = (RelativeLayout) ((FrameLayout) ((LinearLayout) getChildAt(1)).getChildAt(1)).getChildAt(0);
        this.imageParent_Params = (FrameLayout.LayoutParams) this.imageParent.getLayoutParams();
    }

    private void init() {
        String str = TAG;
        gsy.O000000o(3, str, "init() closed=" + this.closed);
        this.halfImageParentHeight = this.imageParent.getMeasuredHeight() / 2;
        String str2 = TAG;
        gsy.O000000o(3, str2, "halfImageParentHeight=" + this.halfImageParentHeight);
        LinearLayout linearLayout = (LinearLayout) ((FrameLayout) this.myScrollView.getChildAt(0)).getChildAt(0);
        double measuredHeight = (double) this.myScrollView.getMeasuredHeight();
        Double.isNaN(measuredHeight);
        this.itemHeight = (int) (measuredHeight / 3.1d);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.height = this.itemHeight;
            childAt.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.needIntercept) {
            return true;
        }
        return onInterceptTouchEvent;
    }

    public void toggleDrawer() {
        String str = TAG;
        gsy.O000000o(3, str, "closed=" + this.closed);
        if (this.closed) {
            startAnimation(-1000.0f, true);
        } else {
            startAnimation(1000.0f, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.firstSizeChange) {
            this.closed = CameraPlayerNewActivity.drawerClosed;
        }
        this.firstSizeChange = false;
        String str = TAG;
        cki.O00000o(str, "onSizeChanged closed=" + this.closed);
        String str2 = TAG;
        gsy.O000000o(3, str2, "onSizeChanged = " + i + "--" + i2);
        if (i <= gpc.O00000Oo(getContext())) {
            init();
            if (this.closed) {
                this.imageParent_Params.topMargin = 0;
            } else {
                this.imageParent_Params.topMargin = -this.imageParent.getMeasuredHeight();
            }
            doSetHeight();
            onClosed(this.closed);
            requestLayout();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r0 != 3) goto L_0x0086;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.endY = motionEvent.getY();
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(500);
                startAnimation(velocityTracker.getYVelocity(), false);
                this.needIntercept = false;
            } else if (action == 2) {
                this.scrollY = motionEvent.getY();
                this.distance = this.scrollY - this.downY;
                float f = this.distance;
                if (f != 0.0f) {
                    if (f > 30.0f) {
                        this.distance = 30.0f;
                    } else if (f < -30.0f) {
                        this.distance = -30.0f;
                    }
                    this.downY = this.scrollY;
                    FrameLayout.LayoutParams layoutParams = this.imageParent_Params;
                    layoutParams.topMargin = (int) (((float) layoutParams.topMargin) + this.distance);
                    doSetHeight();
                    this.touchUp = false;
                }
            }
            this.touchUp = true;
        } else {
            this.needIntercept = false;
            this.downY = motionEvent.getY();
            float f2 = this.downY;
            this.startY = f2;
            this.scrollY = f2;
            this.touchUp = false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0080  */
    public void doSetHeight() {
        if (this.imageParent_Params.topMargin >= 0) {
            this.imageParent_Params.topMargin = 0;
            this.closed = true;
            this.myScrollView.dealWith = false;
            this.state = 0;
        } else if ((-this.imageParent_Params.topMargin) >= this.imageParent.getMeasuredHeight()) {
            this.imageParent_Params.topMargin = -this.imageParent.getMeasuredHeight();
            this.closed = false;
            this.myScrollView.dealWith = true;
            this.title.setBackgroundResource(R.drawable.camera_home_bg_new);
            this.myScrollView.getBackground().setAlpha((int) ((1.0f - (((float) (-this.imageParent_Params.topMargin)) / ((float) this.imageParent.getMeasuredHeight()))) * 200.0f));
            FrameLayout.LayoutParams layoutParams = this.imageParent_Params;
            layoutParams.bottomMargin = (-layoutParams.topMargin) + this.marginBottom40dp;
            this.imageParent.setLayoutParams(this.imageParent_Params);
            if (this.touchUp) {
                onClosed(this.closed);
                return;
            }
            return;
        }
        this.title.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.myScrollView.getBackground().setAlpha((int) ((1.0f - (((float) (-this.imageParent_Params.topMargin)) / ((float) this.imageParent.getMeasuredHeight()))) * 200.0f));
        FrameLayout.LayoutParams layoutParams2 = this.imageParent_Params;
        layoutParams2.bottomMargin = (-layoutParams2.topMargin) + this.marginBottom40dp;
        this.imageParent.setLayoutParams(this.imageParent_Params);
        if (this.touchUp) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    private void startAnimation(float f, boolean z) {
        int i;
        this.startTopMargin = this.imageParent_Params.topMargin;
        this.titlestartWidth = this.title.getMeasuredWidth();
        if (f > 100.0f || (((i = this.startTopMargin) != 0 && (-i) < this.imageParent.getMeasuredHeight()) || z)) {
            if (Math.abs(f) < 250.0f) {
                if ((-this.startTopMargin) >= this.imageParent.getMeasuredHeight() / 2) {
                    this.flag = -1;
                    if (this.flag < 0) {
                        this.closed = false;
                        this.endTopMargin = this.imageParent.getMeasuredHeight();
                        this.myScrollView.dealWith = true;
                    } else {
                        this.closed = true;
                        this.endTopMargin = this.imageParent.getMeasuredHeight();
                        this.myScrollView.dealWith = false;
                    }
                    String str = TAG;
                    gsy.O000000o(3, str, "flag=" + this.flag);
                    String str2 = TAG;
                    gsy.O000000o(3, str2, "startTopMargin=" + this.startTopMargin);
                    String str3 = TAG;
                    gsy.O000000o(3, str3, "endTopMargin=" + this.endTopMargin);
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration((long) this.duration);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.xiaomi.smarthome.camera.v4.view.MIDrawerLayout2.AnonymousClass1 */

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            MIDrawerLayout2.this.imageParent_Params.topMargin = (int) (((float) MIDrawerLayout2.this.startTopMargin) + (((float) MIDrawerLayout2.this.flag) * floatValue * ((float) MIDrawerLayout2.this.endTopMargin)));
                            MIDrawerLayout2.this.doSetHeight();
                        }
                    });
                    onClosed(this.closed);
                    ofFloat.start();
                }
            } else if (f < 0.0f) {
                this.flag = -1;
                if (this.flag < 0) {
                }
                String str4 = TAG;
                gsy.O000000o(3, str4, "flag=" + this.flag);
                String str22 = TAG;
                gsy.O000000o(3, str22, "startTopMargin=" + this.startTopMargin);
                String str32 = TAG;
                gsy.O000000o(3, str32, "endTopMargin=" + this.endTopMargin);
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat2.setDuration((long) this.duration);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.xiaomi.smarthome.camera.v4.view.MIDrawerLayout2.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        MIDrawerLayout2.this.imageParent_Params.topMargin = (int) (((float) MIDrawerLayout2.this.startTopMargin) + (((float) MIDrawerLayout2.this.flag) * floatValue * ((float) MIDrawerLayout2.this.endTopMargin)));
                        MIDrawerLayout2.this.doSetHeight();
                    }
                });
                onClosed(this.closed);
                ofFloat2.start();
            }
            this.flag = 1;
            if (this.flag < 0) {
            }
            String str42 = TAG;
            gsy.O000000o(3, str42, "flag=" + this.flag);
            String str222 = TAG;
            gsy.O000000o(3, str222, "startTopMargin=" + this.startTopMargin);
            String str322 = TAG;
            gsy.O000000o(3, str322, "endTopMargin=" + this.endTopMargin);
            ValueAnimator ofFloat22 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat22.setDuration((long) this.duration);
            ofFloat22.setInterpolator(new LinearInterpolator());
            ofFloat22.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.xiaomi.smarthome.camera.v4.view.MIDrawerLayout2.AnonymousClass1 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MIDrawerLayout2.this.imageParent_Params.topMargin = (int) (((float) MIDrawerLayout2.this.startTopMargin) + (((float) MIDrawerLayout2.this.flag) * floatValue * ((float) MIDrawerLayout2.this.endTopMargin)));
                    MIDrawerLayout2.this.doSetHeight();
                }
            });
            onClosed(this.closed);
            ofFloat22.start();
        }
    }

    public void setStateChangedListener(StateChangedListener stateChangedListener2) {
        this.stateChangedListener = stateChangedListener2;
    }

    public void onClosed(boolean z) {
        StateChangedListener stateChangedListener2 = this.stateChangedListener;
        if (stateChangedListener2 != null) {
            stateChangedListener2.onClosed(z);
        }
    }
}
