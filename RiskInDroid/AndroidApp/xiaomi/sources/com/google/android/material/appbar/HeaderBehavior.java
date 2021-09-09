package com.google.android.material.appbar;

import _m_j.ak;
import _m_j.cb;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private int activePointerId = -1;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop = -1;
    private VelocityTracker velocityTracker;

    /* access modifiers changed from: package-private */
    public boolean canDragView(View view) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void onFlingFinished(CoordinatorLayout coordinatorLayout, View view) {
    }

    public HeaderBehavior() {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i = this.activePointerId;
            if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            this.isBeingDragged = canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            if (this.isBeingDragged) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker2;
        VelocityTracker velocityTracker3;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.lastMotionY = y;
                scroll(coordinatorLayout, v, this.lastMotionY - y, getMaxDragOffset(v), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.activePointerId = motionEvent.getPointerId(i);
                    this.lastMotionY = (int) (motionEvent.getY(i) + 0.5f);
                }
            }
            z = false;
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.isBeingDragged || z;
        }
        VelocityTracker velocityTracker4 = this.velocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEvent);
            this.velocityTracker.computeCurrentVelocity(1000);
            fling(coordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.velocityTracker.getYVelocity(this.activePointerId));
            z = true;
            this.isBeingDragged = false;
            this.activePointerId = -1;
            velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.velocityTracker = null;
            }
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
            }
            if (!this.isBeingDragged) {
            }
        }
        z = false;
        this.isBeingDragged = false;
        this.activePointerId = -1;
        velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
        }
        velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
        }
        if (!this.isBeingDragged) {
        }
    }

    /* access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int O000000o2;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (O000000o2 = ak.O000000o(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(O000000o2);
        return topAndBottomOffset - O000000o2;
    }

    /* access modifiers changed from: package-private */
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    /* access modifiers changed from: package-private */
    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: V
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    final boolean fling(androidx.coordinatorlayout.widget.CoordinatorLayout r14, V r15, int r16, int r17, float r18) {
        /*
            r13 = this;
            r0 = r13
            r1 = r15
            java.lang.Runnable r2 = r0.flingRunnable
            if (r2 == 0) goto L_0x000c
            r15.removeCallbacks(r2)
            r2 = 0
            r0.flingRunnable = r2
        L_0x000c:
            android.widget.OverScroller r2 = r0.scroller
            if (r2 != 0) goto L_0x001b
            android.widget.OverScroller r2 = new android.widget.OverScroller
            android.content.Context r3 = r15.getContext()
            r2.<init>(r3)
            r0.scroller = r2
        L_0x001b:
            android.widget.OverScroller r4 = r0.scroller
            r5 = 0
            int r6 = r13.getTopAndBottomOffset()
            r7 = 0
            int r8 = java.lang.Math.round(r18)
            r9 = 0
            r10 = 0
            r11 = r16
            r12 = r17
            r4.fling(r5, r6, r7, r8, r9, r10, r11, r12)
            android.widget.OverScroller r2 = r0.scroller
            boolean r2 = r2.computeScrollOffset()
            if (r2 == 0) goto L_0x0047
            com.google.android.material.appbar.HeaderBehavior$FlingRunnable r2 = new com.google.android.material.appbar.HeaderBehavior$FlingRunnable
            r3 = r14
            r2.<init>(r14, r15)
            r0.flingRunnable = r2
            java.lang.Runnable r2 = r0.flingRunnable
            _m_j.cb.O000000o(r15, r2)
            r1 = 1
            return r1
        L_0x0047:
            r3 = r14
            r13.onFlingFinished(r14, r15)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.fling(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, float):boolean");
    }

    /* access modifiers changed from: package-private */
    public int getMaxDragOffset(View view) {
        return -view.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRangeForDragFling(View view) {
        return view.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        public void run() {
            if (this.layout != null && HeaderBehavior.this.scroller != null) {
                if (HeaderBehavior.this.scroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    cb.O000000o(this.layout, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
            }
        }
    }
}
