package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class PinnedSectionListView extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    AbsListView.OnScrollListener f9240O000000o;
    O000000o O00000Oo;
    int O00000o;
    O000000o O00000o0;
    private final Rect O00000oO = new Rect();
    private final PointF O00000oo = new PointF();
    private int O0000O0o;
    private View O0000OOo;
    private GradientDrawable O0000Oo;
    private MotionEvent O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private final DataSetObserver O0000o0 = new DataSetObserver() {
        /* class com.xiaomi.smarthome.library.common.widget.PinnedSectionListView.AnonymousClass2 */

        public final void onChanged() {
            PinnedSectionListView.this.O00000Oo();
        }

        public final void onInvalidated() {
            PinnedSectionListView.this.O00000Oo();
        }
    };
    private final AbsListView.OnScrollListener O0000o00 = new AbsListView.OnScrollListener() {
        /* class com.xiaomi.smarthome.library.common.widget.PinnedSectionListView.AnonymousClass1 */

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (PinnedSectionListView.this.f9240O000000o != null) {
                PinnedSectionListView.this.f9240O000000o.onScrollStateChanged(absListView, i);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (PinnedSectionListView.this.f9240O000000o != null) {
                PinnedSectionListView.this.f9240O000000o.onScroll(absListView, i, i2, i3);
            }
            ListAdapter adapter = PinnedSectionListView.this.getAdapter();
            if (adapter != null && i2 != 0) {
                adapter.getItemViewType(i);
                PinnedSectionListView.O000000o(adapter);
                int O000000o2 = PinnedSectionListView.this.O000000o(i);
                if (O000000o2 >= 0) {
                    PinnedSectionListView.this.O000000o(O000000o2, i, i2);
                } else {
                    PinnedSectionListView.this.O000000o();
                }
            }
        }
    };

    public interface O00000Oo extends ListAdapter {
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f9244O000000o;
        public int O00000Oo;
        public long O00000o0;

        O000000o() {
        }
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o0();
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o0();
    }

    private void O00000o0() {
        setOnScrollListener(this.O0000o00);
        this.O0000O0o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        O000000o(true);
    }

    public void setShadowVisible(boolean z) {
        O000000o(z);
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            View view = o000000o.f9244O000000o;
            invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.O0000Ooo);
        }
    }

    private void O000000o(boolean z) {
        if (z) {
            if (this.O0000Oo == null) {
                this.O0000Oo = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0")});
                this.O0000Ooo = (int) (getResources().getDisplayMetrics().density * 8.0f);
            }
        } else if (this.O0000Oo != null) {
            this.O0000Oo = null;
            this.O0000Ooo = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            this.O00000Oo = o000000o;
            this.O00000o0 = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2, int i3) {
        if (i3 < 2) {
            O000000o();
            return;
        }
        O000000o o000000o = this.O00000o0;
        if (!(o000000o == null || o000000o.O00000Oo == i)) {
            O000000o();
        }
        if (this.O00000o0 == null) {
            O000000o o000000o2 = this.O00000Oo;
            this.O00000Oo = null;
            if (o000000o2 == null) {
                o000000o2 = new O000000o();
            }
            View view = getAdapter().getView(i, o000000o2.f9244O000000o, this);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, -2);
            }
            int mode = View.MeasureSpec.getMode(layoutParams.height);
            int size = View.MeasureSpec.getSize(layoutParams.height);
            if (mode == 0) {
                mode = 1073741824;
            }
            int height = (getHeight() - getListPaddingTop()) - getListPaddingBottom();
            if (size > height) {
                size = height;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((getWidth() - getListPaddingLeft()) - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(size, mode));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.O00000o = 0;
            o000000o2.f9244O000000o = view;
            o000000o2.O00000Oo = i;
            o000000o2.O00000o0 = getAdapter().getItemId(i);
            this.O00000o0 = o000000o2;
        }
        int i4 = i + 1;
        if (i4 < getCount()) {
            int O000000o2 = O000000o(i4, i3 - (i4 - i2));
            if (O000000o2 >= 0) {
                this.O0000OoO = getChildAt(O000000o2 - i2).getTop() - (this.O00000o0.f9244O000000o.getBottom() + getPaddingTop());
                int i5 = this.O0000OoO;
                if (i5 < 0) {
                    this.O00000o = i5;
                } else {
                    this.O00000o = 0;
                }
            } else {
                this.O00000o = 0;
                this.O0000OoO = Integer.MAX_VALUE;
            }
        }
    }

    private int O000000o(int i, int i2) {
        ListAdapter adapter = getAdapter();
        for (int i3 = 0; i3 < i2; i3++) {
            adapter.getItemViewType(i + i3);
            O000000o(adapter);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i) {
        ListAdapter adapter = getAdapter();
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            adapter.getItemViewType(sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i)));
            O000000o(adapter);
        }
        while (i >= 0) {
            adapter.getItemViewType(i);
            O000000o(adapter);
            i--;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        int firstVisiblePosition;
        int O000000o2;
        O000000o();
        ListAdapter adapter = getAdapter();
        if (adapter != null && adapter.getCount() > 0 && (O000000o2 = O000000o((firstVisiblePosition = getFirstVisiblePosition()))) != -1) {
            O000000o(O000000o2, firstVisiblePosition, getLastVisiblePosition() - firstVisiblePosition);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == this.O0000o00) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.f9240O000000o = onScrollListener;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() {
            /* class com.xiaomi.smarthome.library.common.widget.PinnedSectionListView.AnonymousClass3 */

            public final void run() {
                PinnedSectionListView.this.O00000Oo();
            }
        });
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.O0000o0);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.O0000o0);
        }
        if (adapter != listAdapter) {
            O000000o();
        }
        super.setAdapter(listAdapter);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.O00000o0 != null && ((i3 - i) - getPaddingLeft()) - getPaddingRight() != this.O00000o0.f9244O000000o.getWidth()) {
            O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i;
        super.dispatchDraw(canvas);
        if (this.O00000o0 != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.O00000o0.f9244O000000o;
            canvas.save();
            int height = view.getHeight();
            if (this.O0000Oo == null) {
                i = 0;
            } else {
                i = Math.min(this.O0000Ooo, this.O0000OoO);
            }
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, height + i + listPaddingTop);
            canvas.translate((float) listPaddingLeft, (float) (listPaddingTop + this.O00000o));
            drawChild(canvas, this.O00000o0.f9244O000000o, getDrawingTime());
            GradientDrawable gradientDrawable = this.O0000Oo;
            if (gradientDrawable != null && this.O0000OoO > 0) {
                gradientDrawable.setBounds(this.O00000o0.f9244O000000o.getLeft(), this.O00000o0.f9244O000000o.getBottom(), this.O00000o0.f9244O000000o.getRight(), this.O00000o0.f9244O000000o.getBottom() + this.O0000Ooo);
                this.O0000Oo.draw(canvas);
            }
            canvas.restore();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AdapterView.OnItemClickListener onItemClickListener;
        O000000o o000000o;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.O0000OOo == null && (o000000o = this.O00000o0) != null && O000000o(o000000o.f9244O000000o, x, y)) {
            this.O0000OOo = this.O00000o0.f9244O000000o;
            PointF pointF = this.O00000oo;
            pointF.x = x;
            pointF.y = y;
            this.O0000Oo0 = MotionEvent.obtain(motionEvent);
        }
        View view = this.O0000OOo;
        if (view == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (O000000o(view, x, y)) {
            this.O0000OOo.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            super.dispatchTouchEvent(motionEvent);
            if (!(this.O00000o0 == null || (onItemClickListener = getOnItemClickListener()) == null)) {
                View view2 = this.O00000o0.f9244O000000o;
                playSoundEffect(0);
                if (view2 != null) {
                    view2.sendAccessibilityEvent(1);
                }
                onItemClickListener.onItemClick(this, view2, this.O00000o0.O00000Oo, this.O00000o0.O00000o0);
            }
            O00000o();
        } else if (action == 3) {
            O00000o();
        } else if (action == 2 && Math.abs(y - this.O00000oo.y) > ((float) this.O0000O0o)) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.O0000OOo.dispatchTouchEvent(obtain);
            obtain.recycle();
            super.dispatchTouchEvent(this.O0000Oo0);
            super.dispatchTouchEvent(motionEvent);
            O00000o();
        }
        return true;
    }

    private boolean O000000o(View view, float f, float f2) {
        view.getHitRect(this.O00000oO);
        this.O00000oO.top += this.O00000o;
        this.O00000oO.bottom += this.O00000o + getPaddingTop();
        this.O00000oO.left += getPaddingLeft();
        this.O00000oO.right -= getPaddingRight();
        return this.O00000oO.contains((int) f, (int) f2);
    }

    private void O00000o() {
        this.O0000OOo = null;
        MotionEvent motionEvent = this.O0000Oo0;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.O0000Oo0 = null;
        }
    }

    public static boolean O000000o(ListAdapter listAdapter) {
        if (!(listAdapter instanceof HeaderViewListAdapter)) {
            return false;
        }
        ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        return false;
    }
}
