package com.xiaomi.smarthome.library.common.widget.viewflow;

import _m_j.grq;
import _m_j.gsy;
import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Scroller;
import java.util.EnumSet;
import java.util.LinkedList;

public class ViewFlow extends AdapterView<Adapter> {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9335O000000o;
    public int O00000Oo;
    public Adapter O00000o;
    public int O00000o0;
    public int O00000oO;
    public ViewTreeObserver.OnGlobalLayoutListener O00000oo;
    Handler O0000O0o;
    private LinkedList<View> O0000OOo;
    private int O0000Oo;
    private LinkedList<View> O0000Oo0;
    private Scroller O0000OoO;
    private VelocityTracker O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private float O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private O00000o0 O0000oO;
    private boolean O0000oO0;
    private O00000Oo O0000oOO;
    private EnumSet<LazyInit> O0000oOo;
    private grq O0000oo;
    private O000000o O0000oo0;
    private int O0000ooO;
    private boolean O0000ooo;

    enum LazyInit {
        LEFT,
        RIGHT
    }

    public interface O00000Oo {
    }

    public interface O00000o0 {
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public ViewFlow(Context context) {
        super(context);
        this.O0000Oo = 2;
        this.O00000o0 = 0;
        this.O0000o = -1;
        this.O0000oO0 = true;
        this.O0000oOo = EnumSet.allOf(LazyInit.class);
        this.O0000ooO = -1;
        this.O0000ooo = false;
        this.O00000oo = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.library.common.widget.viewflow.ViewFlow.AnonymousClass1 */

            public final void onGlobalLayout() {
                ViewFlow.this.getViewTreeObserver().removeGlobalOnLayoutListener(ViewFlow.this.O00000oo);
                ViewFlow viewFlow = ViewFlow.this;
                viewFlow.setSelection(viewFlow.O00000Oo);
            }
        };
        this.O0000O0o = new Handler() {
            /* class com.xiaomi.smarthome.library.common.widget.viewflow.ViewFlow.AnonymousClass2 */

            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    ViewFlow.this.O0000O0o.removeMessages(1);
                    ViewFlow.this.O000000o();
                    ViewFlow.this.O00000o0 = 0;
                }
            }
        };
        this.O0000Oo = 3;
        O00000o0();
    }

    public ViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Oo = 2;
        this.O00000o0 = 0;
        this.O0000o = -1;
        this.O0000oO0 = true;
        this.O0000oOo = EnumSet.allOf(LazyInit.class);
        this.O0000ooO = -1;
        this.O0000ooo = false;
        this.O00000oo = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.library.common.widget.viewflow.ViewFlow.AnonymousClass1 */

            public final void onGlobalLayout() {
                ViewFlow.this.getViewTreeObserver().removeGlobalOnLayoutListener(ViewFlow.this.O00000oo);
                ViewFlow viewFlow = ViewFlow.this;
                viewFlow.setSelection(viewFlow.O00000Oo);
            }
        };
        this.O0000O0o = new Handler() {
            /* class com.xiaomi.smarthome.library.common.widget.viewflow.ViewFlow.AnonymousClass2 */

            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    ViewFlow.this.O0000O0o.removeMessages(1);
                    ViewFlow.this.O000000o();
                    ViewFlow.this.O00000o0 = 0;
                }
            }
        };
        this.O0000Oo = 3;
        O00000o0();
    }

    private void O00000o0() {
        this.O0000OOo = new LinkedList<>();
        this.O0000Oo0 = new LinkedList<>();
        this.O0000OoO = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.O0000o0 = viewConfiguration.getScaledTouchSlop();
        this.O0000o0O = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation != this.O0000ooO) {
            this.O0000ooO = configuration.orientation;
            getViewTreeObserver().addOnGlobalLayoutListener(this.O00000oo);
        }
    }

    public int getViewsCount() {
        return this.O00000o.getCount();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int widthPadding = getWidthPadding();
        int heightPadding = getHeightPadding();
        Adapter adapter = this.O00000o;
        int i5 = 0;
        if ((adapter == null ? 0 : adapter.getCount()) > 0) {
            View O00000o02 = O00000o0(0);
            measureChild(O00000o02, i, i2);
            i4 = O00000o02.getMeasuredWidth();
            i3 = O00000o02.getMeasuredHeight();
            if (Build.VERSION.SDK_INT >= 14) {
                i5 = O00000o02.getMeasuredState();
            }
            this.O0000Oo0.add(O00000o02);
        } else {
            i4 = 0;
            i3 = 0;
        }
        if (mode == Integer.MIN_VALUE) {
            size = (i4 + widthPadding) | i5;
        } else if (mode == 0) {
            size = i4 + widthPadding;
        } else if (mode == 1073741824 && size < i4 + widthPadding) {
            size |= 16777216;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = (i5 >> 16) | (i3 + heightPadding);
        } else if (mode2 == 0) {
            size2 = i3 + heightPadding;
        } else if (mode2 == 1073741824 && size2 < i3 + heightPadding) {
            size2 |= 16777216;
        }
        setMeasuredDimension(size, mode2 == 0 ? heightPadding + i3 : size2 | (-16777216 & i5));
    }

    private int getWidthPadding() {
        return getPaddingLeft() + getPaddingRight() + (getHorizontalFadingEdgeLength() * 2);
    }

    public int getChildWidth() {
        return getWidth() - getWidthPadding();
    }

    private int getHeightPadding() {
        return getPaddingTop() + getPaddingBottom();
    }

    public int getChildHeight() {
        return getHeight() - getHeightPadding();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).measure(View.MeasureSpec.makeMeasureSpec(getChildWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getChildHeight(), 1073741824));
        }
        if (this.O0000oO0) {
            this.O0000OoO.startScroll(0, 0, this.O0000o0o * getChildWidth(), 0, 0);
            this.O0000oO0 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft() + getHorizontalFadingEdgeLength();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                childAt.layout(paddingLeft, getPaddingTop(), measuredWidth, getPaddingTop() + childAt.getMeasuredHeight());
                paddingLeft = measuredWidth;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        int right;
        if (getChildCount() == 0) {
            return false;
        }
        if (this.O0000Ooo == null) {
            this.O0000Ooo = VelocityTracker.obtain();
        }
        this.O0000Ooo.addMovement(motionEvent);
        this.O0000O0o.removeMessages(1);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        if (action == 0) {
            if (!this.O0000OoO.isFinished()) {
                this.O0000OoO.abortAnimation();
            }
            this.O0000o00 = x;
            this.O00000o0 = this.O0000OoO.isFinished() ^ true ? 1 : 0;
        } else if (action == 1) {
            if (this.O00000o0 == 1) {
                VelocityTracker velocityTracker = this.O0000Ooo;
                velocityTracker.computeCurrentVelocity(1000, (float) this.O0000o0O);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 1000 && (i = this.O0000o0o) > 0) {
                    O00000Oo(i - 1);
                } else if (xVelocity >= -1000 || this.O0000o0o >= getChildCount() - 1) {
                    O000000o();
                } else {
                    O00000Oo(this.O0000o0o + 1);
                }
                VelocityTracker velocityTracker2 = this.O0000Ooo;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.O0000Ooo = null;
                }
            }
            this.O00000o0 = 0;
        } else if (action == 2) {
            int i2 = (int) (this.O0000o00 - x);
            if (Math.abs(i2) > this.O0000o0) {
                this.O00000o0 = 1;
                if (this.O0000oOO != null) {
                    O000000o((float) i2);
                }
            }
            if (this.O00000o0 == 1) {
                this.O0000o00 = x;
                int scrollX = getScrollX();
                if (i2 < 0) {
                    if (scrollX > 0) {
                        scrollBy(Math.max(-scrollX, i2), 0);
                    }
                } else if (i2 > 0 && (right = (((getChildAt(getChildCount() - 1).getRight() - getPaddingRight()) - getHorizontalFadingEdgeLength()) - scrollX) - getWidth()) > 0) {
                    scrollBy(Math.min(right, i2), 0);
                }
                return true;
            }
        } else if (action == 3) {
            this.O00000o0 = 0;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int right;
        if (getChildCount() == 0) {
            return false;
        }
        if (this.O0000Ooo == null) {
            this.O0000Ooo = VelocityTracker.obtain();
        }
        this.O0000Ooo.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        this.O0000O0o.removeMessages(1);
        if (action == 0) {
            if (!this.O0000OoO.isFinished()) {
                this.O0000OoO.abortAnimation();
            }
            this.O0000o00 = x;
            this.O00000o0 = this.O0000OoO.isFinished() ^ true ? 1 : 0;
        } else if (action == 1) {
            if (this.O00000o0 == 1) {
                VelocityTracker velocityTracker = this.O0000Ooo;
                velocityTracker.computeCurrentVelocity(1000, (float) this.O0000o0O);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 1000 && (i = this.O0000o0o) > 0) {
                    O00000Oo(i - 1);
                } else if (xVelocity >= -1000 || this.O0000o0o >= getChildCount() - 1) {
                    O000000o();
                } else {
                    O00000Oo(this.O0000o0o + 1);
                }
                VelocityTracker velocityTracker2 = this.O0000Ooo;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.O0000Ooo = null;
                }
            } else {
                O000000o();
            }
            this.O00000o0 = 0;
        } else if (action == 2) {
            int i2 = (int) (this.O0000o00 - x);
            if (Math.abs(i2) > this.O0000o0) {
                this.O00000o0 = 1;
                if (this.O0000oOO != null) {
                    O000000o((float) i2);
                }
            }
            if (this.O00000o0 == 1) {
                this.O0000o00 = x;
                int scrollX = getScrollX();
                if (i2 < 0) {
                    if (scrollX > 0) {
                        scrollBy(Math.max(-scrollX, i2), 0);
                    }
                } else if (i2 > 0 && (right = (((getChildAt(getChildCount() - 1).getRight() - getPaddingRight()) - getHorizontalFadingEdgeLength()) - scrollX) - getChildWidth()) > 0) {
                    scrollBy(Math.min(right, i2), 0);
                }
                this.O0000O0o.sendEmptyMessageDelayed(1, 200);
                return true;
            }
        } else if (action == 3) {
            O000000o();
            this.O00000o0 = 0;
        }
        return true;
    }

    private void O000000o(float f) {
        if (f > 0.0f) {
            if (this.O0000oOo.contains(LazyInit.RIGHT)) {
                this.O0000oOo.remove(LazyInit.RIGHT);
                if (this.f9335O000000o + 1 < this.O0000OOo.size()) {
                    this.O0000OOo.get(this.f9335O000000o + 1);
                }
            }
        } else if (this.O0000oOo.contains(LazyInit.LEFT)) {
            this.O0000oOo.remove(LazyInit.LEFT);
            int i = this.f9335O000000o;
            if (i > 0) {
                this.O0000OOo.get(i - 1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.O0000oo != null) {
            getChildWidth();
        }
    }

    public final void O000000o() {
        int childWidth = getChildWidth();
        O00000Oo((getScrollX() + (childWidth / 2)) / childWidth);
    }

    private void O00000Oo(int i) {
        this.O00000oO = i - this.O0000o0o;
        if (this.O0000OoO.isFinished()) {
            int max = Math.max(0, Math.min(i, getChildCount() - 1));
            this.O0000o = max;
            int childWidth = (max * getChildWidth()) - getScrollX();
            this.O0000OoO.startScroll(getScrollX(), 0, childWidth, 0, Math.abs(childWidth) * 2);
            invalidate();
        }
    }

    public void computeScroll() {
        if (this.O0000OoO.computeScrollOffset()) {
            scrollTo(this.O0000OoO.getCurrX(), this.O0000OoO.getCurrY());
            postInvalidate();
            return;
        }
        int i = this.O0000o;
        if (i != -1) {
            this.O0000o0o = Math.max(0, Math.min(i, getChildCount() - 1));
            this.O0000o = -1;
            post(new Runnable() {
                /* class com.xiaomi.smarthome.library.common.widget.viewflow.ViewFlow.AnonymousClass3 */

                public final void run() {
                    ViewFlow viewFlow = ViewFlow.this;
                    viewFlow.O000000o(viewFlow.O00000oO);
                }
            });
        }
    }

    private void O000000o(int i, boolean z) {
        this.O0000o0o = Math.max(0, Math.min(i, getChildCount() - 1));
        int childWidth = (this.O0000o0o * getChildWidth()) - this.O0000OoO.getCurrX();
        Scroller scroller = this.O0000OoO;
        scroller.startScroll(scroller.getCurrX(), this.O0000OoO.getCurrY(), childWidth, 0, 0);
        if (childWidth == 0) {
            onScrollChanged(this.O0000OoO.getCurrX() + childWidth, this.O0000OoO.getCurrY(), this.O0000OoO.getCurrX() + childWidth, this.O0000OoO.getCurrY());
        }
        if (z) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public void setOnViewSwitchListener(O00000o0 o00000o0) {
        this.O0000oO = o00000o0;
    }

    public void setOnViewLazyInitializeListener(O00000Oo o00000Oo) {
        this.O0000oOO = o00000Oo;
    }

    public Adapter getAdapter() {
        return this.O00000o;
    }

    public View getSelectedView() {
        if (this.f9335O000000o < this.O0000OOo.size()) {
            return this.O0000OOo.get(this.f9335O000000o);
        }
        return null;
    }

    public int getSelectedItemPosition() {
        return this.O00000Oo;
    }

    public void setFlowIndicator(grq grq) {
        this.O0000oo = grq;
    }

    private void O00000o() {
        while (!this.O0000OOo.isEmpty()) {
            O000000o(this.O0000OOo.remove());
        }
    }

    private void O000000o(View view) {
        if (view != null) {
            this.O0000Oo0.addFirst(view);
            detachViewFromParent(view);
        }
    }

    /* access modifiers changed from: protected */
    public View getRecycledView() {
        if (this.O0000Oo0.isEmpty()) {
            return null;
        }
        return this.O0000Oo0.remove();
    }

    public void setSelection(int i) {
        this.O0000o = -1;
        this.O0000OoO.forceFinished(true);
        if (this.O00000o != null) {
            int min = Math.min(Math.max(i, 0), this.O00000o.getCount() > 0 ? this.O00000o.getCount() - 1 : 0);
            O00000o();
            View O00000Oo2 = O00000Oo(min, true);
            this.O0000OOo.addLast(O00000Oo2);
            for (int i2 = 1; this.O0000Oo - i2 >= 0; i2++) {
                int i3 = min - i2;
                int i4 = min + i2;
                if (i3 >= 0) {
                    this.O0000OOo.addFirst(O00000Oo(i3, false));
                }
                if (i4 < this.O00000o.getCount()) {
                    this.O0000OOo.addLast(O00000Oo(i4, true));
                }
            }
            this.f9335O000000o = this.O0000OOo.indexOf(O00000Oo2);
            this.O00000Oo = min;
            requestLayout();
            O000000o(this.f9335O000000o, false);
        }
    }

    public final void O00000Oo() {
        O00000oO();
        O00000o();
        removeAllViewsInLayout();
        this.O0000oOo.addAll(EnumSet.allOf(LazyInit.class));
        for (int max = Math.max(0, this.O00000Oo - this.O0000Oo); max < Math.min(this.O00000o.getCount(), this.O00000Oo + this.O0000Oo + 1); max++) {
            this.O0000OOo.addLast(O00000Oo(max, true));
            if (max == this.O00000Oo) {
                this.f9335O000000o = this.O0000OOo.size() - 1;
                if (this.O0000oOO != null) {
                    this.O0000OOo.getLast();
                }
            }
        }
        if (this.O00000o.getCount() > 0) {
            setSelection(this.O00000Oo);
        }
        O00000oO();
        requestLayout();
    }

    public final void O000000o(int i) {
        int i2;
        int i3;
        if (i != 0) {
            if (i > 0) {
                this.O00000Oo++;
                this.f9335O000000o++;
                this.O0000oOo.remove(LazyInit.LEFT);
                this.O0000oOo.add(LazyInit.RIGHT);
                if (this.O00000Oo > this.O0000Oo) {
                    O000000o(this.O0000OOo.removeFirst());
                    this.f9335O000000o--;
                }
                int i4 = this.O00000Oo + this.O0000Oo;
                if (i4 < this.O00000o.getCount()) {
                    this.O0000OOo.addLast(O00000Oo(i4, true));
                }
            } else {
                this.O00000Oo--;
                this.f9335O000000o--;
                this.O0000oOo.add(LazyInit.LEFT);
                this.O0000oOo.remove(LazyInit.RIGHT);
                if ((this.O00000o.getCount() - 1) - this.O00000Oo > this.O0000Oo) {
                    O000000o(this.O0000OOo.removeLast());
                }
                int i5 = this.O00000Oo - this.O0000Oo;
                if (i5 >= 0) {
                    this.O0000OOo.addFirst(O00000Oo(i5, false));
                    this.f9335O000000o++;
                }
            }
            requestLayout();
            if (this.f9335O000000o >= this.O0000OOo.size()) {
                this.f9335O000000o = this.O0000OOo.size() - 1;
            }
            if (this.f9335O000000o < 0) {
                this.f9335O000000o = 0;
            }
            O000000o(this.f9335O000000o, true);
            if (this.O0000oo != null && (i3 = this.f9335O000000o) >= 0 && i3 < this.O0000OOo.size()) {
                this.O0000OOo.get(this.f9335O000000o);
            }
            if (this.O0000oO != null && (i2 = this.f9335O000000o) > 0 && i2 < this.O0000OOo.size()) {
                this.O0000OOo.get(this.f9335O000000o);
            }
            O00000oO();
        }
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getWidthPadding(), layoutParams.width), getChildMeasureSpec(i2, getHeightPadding(), layoutParams.height));
    }

    private View O000000o(View view, boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(getChildWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getChildHeight(), 1073741824));
        int i = -1;
        if (z2) {
            if (!z) {
                i = 0;
            }
            attachViewToParent(view, i, layoutParams);
        } else {
            if (!z) {
                i = 0;
            }
            addViewInLayout(view, i, layoutParams, true);
        }
        return view;
    }

    private View O00000Oo(int i, boolean z) {
        return O000000o(O00000o0(i), z, this.O0000ooo);
    }

    private View O00000o0(int i) {
        View recycledView = getRecycledView();
        View view = this.O00000o.getView(i, recycledView, this);
        if (!(view == recycledView || recycledView == null)) {
            this.O0000Oo0.add(recycledView);
        }
        this.O0000ooo = view == recycledView;
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        return view;
    }

    class O000000o extends DataSetObserver {
        public final void onInvalidated() {
        }

        O000000o() {
        }

        public final void onChanged() {
            ViewFlow viewFlow = ViewFlow.this;
            View childAt = viewFlow.getChildAt(viewFlow.f9335O000000o);
            if (childAt != null) {
                int i = 0;
                while (true) {
                    if (i >= ViewFlow.this.O00000o.getCount()) {
                        break;
                    } else if (childAt.equals(ViewFlow.this.O00000o.getItem(i))) {
                        ViewFlow.this.O00000Oo = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (ViewFlow.this.O00000Oo < 0) {
                ViewFlow.this.O00000Oo = 0;
            }
            if (ViewFlow.this.O00000Oo >= ViewFlow.this.O00000o.getCount()) {
                ViewFlow viewFlow2 = ViewFlow.this;
                viewFlow2.O00000Oo = viewFlow2.O00000o.getCount() - 1;
            }
            ViewFlow.this.O00000Oo();
        }
    }

    private void O00000oO() {
        gsy.O000000o(3, "viewflow", "Size of mLoadedViews: " + this.O0000OOo.size() + ", Size of mRecycledViews: " + this.O0000Oo0.size() + ", X: " + this.O0000OoO.getCurrX() + ", Y: " + this.O0000OoO.getCurrY());
        StringBuilder sb = new StringBuilder("IndexInAdapter: ");
        sb.append(this.O00000Oo);
        sb.append(", IndexInBuffer: ");
        sb.append(this.f9335O000000o);
        gsy.O000000o(3, "viewflow", sb.toString());
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.O00000o;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.O0000oo0);
        }
        this.O00000o = adapter;
        if (this.O00000o != null) {
            this.O0000oo0 = new O000000o();
            this.O00000o.registerDataSetObserver(this.O0000oo0);
        }
        Adapter adapter3 = this.O00000o;
        if (adapter3 != null && adapter3.getCount() != 0) {
            setSelection(0);
        }
    }
}
