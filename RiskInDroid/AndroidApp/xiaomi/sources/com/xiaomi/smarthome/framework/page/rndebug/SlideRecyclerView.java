package com.xiaomi.smarthome.framework.page.rndebug;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SlideRecyclerView extends RecyclerView {

    /* renamed from: O000000o  reason: collision with root package name */
    private VelocityTracker f7931O000000o;
    private int O00000Oo;
    private Scroller O00000o;
    private Rect O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo;
    private ViewGroup O0000Oo0;
    private int O0000OoO;

    public SlideRecyclerView(Context context) {
        this(context, null);
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = ViewConfiguration.get(context).getScaledTouchSlop();
        this.O00000o = new Scroller(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (java.lang.Math.abs(r0 - r10.O00000oo) > java.lang.Math.abs(((float) r1) - r10.O0000O0o)) goto L_0x0067;
     */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        O000000o(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.O00000o.isFinished()) {
                this.O00000o.abortAnimation();
            }
            float f = (float) x;
            this.O00000oO = f;
            this.O00000oo = f;
            this.O0000O0o = (float) y;
            int findFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
            Rect rect = this.O00000o0;
            if (rect == null) {
                this.O00000o0 = new Rect();
                rect = this.O00000o0;
            }
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    i = -1;
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getVisibility() == 0) {
                    childAt.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        i = findFirstVisibleItemPosition + childCount;
                        break;
                    }
                }
                childCount--;
            }
            this.O0000Oo = i;
            int i2 = this.O0000Oo;
            if (i2 != -1) {
                ViewGroup viewGroup = this.O0000Oo0;
                this.O0000Oo0 = (ViewGroup) getChildAt(i2 - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition());
                if (!(viewGroup == null || this.O0000Oo0 == viewGroup || viewGroup.getScrollX() == 0)) {
                    viewGroup.scrollTo(0, 0);
                }
                if (this.O0000Oo0.getChildCount() == 2) {
                    this.O0000OoO = this.O0000Oo0.getChildAt(1).getWidth();
                } else {
                    this.O0000OoO = -1;
                }
            }
        } else if (action == 1) {
            O00000Oo();
        } else if (action == 2) {
            this.f7931O000000o.computeCurrentVelocity(1000);
            float xVelocity = this.f7931O000000o.getXVelocity();
            float yVelocity = this.f7931O000000o.getYVelocity();
            if (Math.abs(xVelocity) <= 600.0f || Math.abs(xVelocity) <= Math.abs(yVelocity)) {
                float f2 = (float) x;
                if (Math.abs(f2 - this.O00000oo) >= ((float) this.O00000Oo)) {
                }
            }
            this.O0000OOo = true;
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000OOo || this.O0000Oo == -1) {
            O000000o();
            O00000Oo();
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        O000000o(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.O0000OoO != -1) {
                    int scrollX = this.O0000Oo0.getScrollX();
                    this.f7931O000000o.computeCurrentVelocity(1000);
                    if (this.f7931O000000o.getXVelocity() < -600.0f) {
                        Scroller scroller = this.O00000o;
                        int i = this.O0000OoO;
                        scroller.startScroll(scrollX, 0, i - scrollX, 0, Math.abs(i - scrollX));
                    } else {
                        if (this.f7931O000000o.getXVelocity() < 600.0f) {
                            int i2 = this.O0000OoO;
                            if (scrollX >= i2 / 2) {
                                this.O00000o.startScroll(scrollX, 0, i2 - scrollX, 0, Math.abs(i2 - scrollX));
                            }
                        }
                        this.O00000o.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    }
                    invalidate();
                }
                this.O0000OoO = -1;
                this.O0000OOo = false;
                this.O0000Oo = -1;
                O00000Oo();
            } else if (action == 2 && this.O0000OoO != -1) {
                float f = this.O00000oO - x;
                if (((float) this.O0000Oo0.getScrollX()) + f <= ((float) this.O0000OoO) && ((float) this.O0000Oo0.getScrollX()) + f > 0.0f) {
                    this.O0000Oo0.scrollBy((int) f, 0);
                }
                this.O00000oO = x;
            }
        }
        return true;
    }

    private void O00000Oo() {
        VelocityTracker velocityTracker = this.f7931O000000o;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f7931O000000o.recycle();
            this.f7931O000000o = null;
        }
    }

    private void O000000o(MotionEvent motionEvent) {
        if (this.f7931O000000o == null) {
            this.f7931O000000o = VelocityTracker.obtain();
        }
        this.f7931O000000o.addMovement(motionEvent);
    }

    public void computeScroll() {
        if (this.O00000o.computeScrollOffset()) {
            this.O0000Oo0.scrollTo(this.O00000o.getCurrX(), this.O00000o.getCurrY());
            invalidate();
        }
    }

    public final void O000000o() {
        ViewGroup viewGroup = this.O0000Oo0;
        if (viewGroup != null && viewGroup.getScrollX() != 0) {
            this.O0000Oo0.scrollTo(0, 0);
        }
    }
}
