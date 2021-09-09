package com.mi.global.shop.widget.slide;

import _m_j.cb;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class SlideView extends RelativeLayout {
    private static String O00000oO = "SlideView";

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5051O000000o = 0;
    public int O00000Oo;
    public O000000o O00000o;
    public int O00000o0 = 2;
    private VelocityTracker O00000oo;
    private float O0000O0o;
    private final Runnable O0000OOo = new Runnable() {
        /* class com.mi.global.shop.widget.slide.SlideView.AnonymousClass1 */

        public final void run() {
            SlideView slideView = SlideView.this;
            slideView.measure(View.MeasureSpec.makeMeasureSpec(slideView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(SlideView.this.getHeight(), 1073741824));
            SlideView slideView2 = SlideView.this;
            slideView2.layout(slideView2.getLeft(), SlideView.this.getTop(), SlideView.this.getRight(), SlideView.this.getBottom());
        }
    };

    public interface O000000o {
    }

    public SlideView(Context context) {
        super(context);
    }

    public SlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public int getCurrentViewIndex() {
        return this.f5051O000000o;
    }

    public void setCurrentViewIndex(int i) {
        O00000Oo o00000Oo;
        if (this.f5051O000000o != i) {
            if (i == 0) {
                o00000Oo = new O00000Oo(-getMeasuredHeight(), 0);
            } else {
                o00000Oo = new O00000Oo(0, -getMeasuredHeight());
            }
            post(o00000Oo);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r1.getBottom() <= r0.getBottom()) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        if (r0.getScrollY() >= (r5.getHeight() - r1.getHeight())) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a8, code lost:
        if (((((float) java.lang.Math.floor((double) (((float) r0.getContentHeight()) * r0.getScale()))) - ((float) r0.getScrollY())) - ((float) r0.getHeight())) > ((float) ((int) ((r0.getContext().getResources().getDisplayMetrics().density * 1.0f) + 0.5f)))) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0101, code lost:
        if (r1.getTop() >= r0.getTop()) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0108, code lost:
        if (r0.getScrollY() == 0) goto L_0x010a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01de  */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            VelocityTracker velocityTracker = this.O00000oo;
            if (velocityTracker == null) {
                this.O00000oo = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.O00000oo.addMovement(motionEvent);
            this.O0000O0o = motionEvent.getY();
        } else if (actionMasked == 1) {
            this.O0000O0o = motionEvent.getY();
            this.O00000oo.addMovement(motionEvent);
            this.O00000oo.computeCurrentVelocity(1000);
            float yVelocity = this.O00000oo.getYVelocity();
            int i2 = this.O00000Oo;
            if (!(i2 == 0 || i2 == (-getMeasuredHeight()))) {
                if (Math.abs(yVelocity) < 500.0f) {
                    if (this.f5051O000000o == 0) {
                        if (Math.abs(this.O00000Oo) > getMeasuredHeight() / 3) {
                            this.O00000o0 = 0;
                        } else {
                            this.O00000o0 = 1;
                        }
                    } else if (Math.abs(this.O00000Oo) >= (getMeasuredHeight() / 3) * 2) {
                        this.O00000o0 = 0;
                    }
                    this.O00000oo.clear();
                    if (!(Math.abs(this.O00000Oo) == 0 || Math.abs(this.O00000Oo) == getMeasuredHeight())) {
                        i = this.O00000o0;
                        if (i == 0) {
                            post(new O00000Oo(this.O00000Oo, -getMeasuredHeight()));
                        } else if (i == 1) {
                            post(new O00000Oo(this.O00000Oo, 0));
                        }
                    }
                } else if (yVelocity < 0.0f) {
                    this.O00000o0 = 0;
                    this.O00000oo.clear();
                    i = this.O00000o0;
                    if (i == 0) {
                    }
                }
                this.O00000o0 = 1;
                this.O00000oo.clear();
                i = this.O00000o0;
                if (i == 0) {
                }
            }
        } else if (actionMasked == 2) {
            this.O00000oo.addMovement(motionEvent);
            int i3 = this.f5051O000000o;
            if (i3 == 0) {
                View childAt = getChildAt(i3);
                ViewGroup viewGroup = (ViewGroup) childAt.getParent();
                if (viewGroup != null) {
                    if (childAt instanceof AbsListView) {
                        AbsListView absListView = (AbsListView) childAt;
                        int lastVisiblePosition = absListView.getLastVisiblePosition();
                        if (lastVisiblePosition >= (absListView.getCount() - 1) - 1) {
                            View childAt2 = absListView.getChildAt(lastVisiblePosition - absListView.getFirstVisiblePosition());
                            if (childAt2 != null) {
                            }
                        }
                    } else if (childAt instanceof ScrollView) {
                        ScrollView scrollView = (ScrollView) childAt;
                        View childAt3 = scrollView.getChildAt(0);
                        if (childAt3 != null) {
                        }
                    } else if (childAt instanceof WebView) {
                        WebView webView = (WebView) childAt;
                    }
                    z2 = true;
                    if (z2) {
                        this.O00000Oo = (int) (((float) this.O00000Oo) + (motionEvent.getY() - this.O0000O0o));
                        int i4 = this.O00000Oo;
                        if (i4 > 0) {
                            this.O00000Oo = 0;
                            this.f5051O000000o = 0;
                        } else if (i4 < (-getMeasuredHeight())) {
                            this.O00000Oo = -getMeasuredHeight();
                            this.f5051O000000o = 1;
                        }
                        if (this.O00000Oo < -8) {
                            motionEvent.setAction(3);
                        }
                        this.O0000O0o = motionEvent.getY();
                        requestLayout();
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            int i5 = this.f5051O000000o;
            if (i5 == 1) {
                View childAt4 = getChildAt(i5);
                if (childAt4 instanceof AbsListView) {
                    AbsListView absListView2 = (AbsListView) childAt4;
                    if (absListView2.getFirstVisiblePosition() <= 1) {
                        View childAt5 = absListView2.getChildAt(0);
                        if (childAt5 != null) {
                        }
                    }
                    z = false;
                    if (z) {
                        this.O00000Oo = (int) (((float) this.O00000Oo) + (motionEvent.getY() - this.O0000O0o));
                        if (this.O00000Oo < (-getMeasuredHeight())) {
                            this.O00000Oo = -getMeasuredHeight();
                            this.f5051O000000o = 1;
                        } else if (this.O00000Oo > 0) {
                            this.O00000Oo = 0;
                            this.f5051O000000o = 0;
                        }
                        if (this.O00000Oo > 8 - getMeasuredHeight()) {
                            motionEvent.setAction(3);
                        }
                    }
                }
                z = true;
                if (z) {
                }
            }
            this.O0000O0o = motionEvent.getY();
            requestLayout();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.O0000OOo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (childAt != null && childAt2 != null) {
            childAt.layout(0, this.O00000Oo, getMeasuredWidth(), childAt.getMeasuredHeight() + this.O00000Oo);
            childAt2.layout(0, childAt.getMeasuredHeight() + this.O00000Oo, getMeasuredWidth(), childAt.getMeasuredHeight() + this.O00000Oo + childAt2.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    final class O00000Oo implements Runnable {
        private final Interpolator O00000Oo;
        private final int O00000o;
        private final int O00000o0;
        private final long O00000oO;
        private long O00000oo = -1;
        private int O0000O0o = -1;

        public O00000Oo(int i, int i2) {
            this.O00000o = i;
            this.O00000o0 = i2;
            this.O00000Oo = new DecelerateInterpolator();
            this.O00000oO = (long) (Math.abs(i2 - i) / 8);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [long, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(long, long):long}
         arg types: [long, int]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(float, float):float}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(long, long):long} */
        public final void run() {
            if (this.O00000oo == -1) {
                this.O00000oo = System.currentTimeMillis();
            } else {
                this.O0000O0o = this.O00000o - Math.round(((float) (this.O00000o - this.O00000o0)) * this.O00000Oo.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.O00000oo) * 1000) / this.O00000oO, 1000L), 0L)) / 1000.0f));
                SlideView slideView = SlideView.this;
                slideView.O00000Oo = this.O0000O0o;
                slideView.requestLayout();
            }
            int i = this.O00000o0;
            if (i != this.O0000O0o) {
                cb.O000000o(SlideView.this, this);
                return;
            }
            SlideView slideView2 = SlideView.this;
            slideView2.O00000o0 = 2;
            if (i == 0) {
                slideView2.f5051O000000o = 0;
            } else {
                slideView2.f5051O000000o = 1;
            }
        }
    }
}
