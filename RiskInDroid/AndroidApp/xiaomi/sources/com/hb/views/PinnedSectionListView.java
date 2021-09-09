package com.hb.views;

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
    AbsListView.OnScrollListener f4380O000000o;
    O000000o O00000Oo;
    int O00000o;
    O000000o O00000o0;
    public boolean O00000oO = true;
    private final Rect O00000oo = new Rect();
    private final PointF O0000O0o = new PointF();
    private int O0000OOo;
    private MotionEvent O0000Oo;
    private View O0000Oo0;
    private GradientDrawable O0000OoO;
    private int O0000Ooo;
    private final AbsListView.OnScrollListener O0000o0 = new AbsListView.OnScrollListener() {
        /* class com.hb.views.PinnedSectionListView.AnonymousClass1 */

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (PinnedSectionListView.this.f4380O000000o != null) {
                PinnedSectionListView.this.f4380O000000o.onScrollStateChanged(absListView, i);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (PinnedSectionListView.this.f4380O000000o != null) {
                PinnedSectionListView.this.f4380O000000o.onScroll(absListView, i, i2, i3);
            }
            ListAdapter adapter = PinnedSectionListView.this.getAdapter();
            if (adapter != null && i2 != 0) {
                if (i != 0) {
                    PinnedSectionListView.this.O00000oO = false;
                } else if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.O00000oO = true;
                } else {
                    PinnedSectionListView.this.O00000oO = false;
                }
                adapter.getItemViewType(i);
                if (!PinnedSectionListView.O000000o(adapter)) {
                    int O000000o2 = PinnedSectionListView.this.O000000o(i);
                    if (O000000o2 >= 0) {
                        PinnedSectionListView.this.O000000o(O000000o2, i, i2);
                        return;
                    }
                } else if (PinnedSectionListView.this.getChildAt(0).getTop() != PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.O000000o(i, i, i2);
                    return;
                }
                PinnedSectionListView.this.O000000o();
            }
        }
    };
    private int O0000o00;
    private final DataSetObserver O0000o0O = new DataSetObserver() {
        /* class com.hb.views.PinnedSectionListView.AnonymousClass2 */

        public final void onChanged() {
            PinnedSectionListView.this.O00000Oo();
        }

        public final void onInvalidated() {
            PinnedSectionListView.this.O00000Oo();
        }
    };

    public interface O00000Oo extends ListAdapter {
        boolean O000000o();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f4384O000000o;
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
        setOnScrollListener(this.O0000o0);
        this.O0000OOo = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        O000000o(true);
    }

    public void setShadowVisible(boolean z) {
        O000000o(z);
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            View view = o000000o.f4384O000000o;
            invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.O0000o00);
        }
    }

    private void O000000o(boolean z) {
        if (z) {
            if (this.O0000OoO == null) {
                this.O0000OoO = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0")});
                this.O0000o00 = (int) (getResources().getDisplayMetrics().density * 8.0f);
            }
        } else if (this.O0000OoO != null) {
            this.O0000OoO = null;
            this.O0000o00 = 0;
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
            View view = getAdapter().getView(i, o000000o2.f4384O000000o, this);
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
            o000000o2.f4384O000000o = view;
            o000000o2.O00000Oo = i;
            o000000o2.O00000o0 = getAdapter().getItemId(i);
            this.O00000o0 = o000000o2;
        }
        int i4 = i + 1;
        if (i4 < getCount()) {
            int O000000o2 = O000000o(i4, i3 - (i4 - i2));
            if (O000000o2 >= 0) {
                this.O0000Ooo = getChildAt(O000000o2 - i2).getTop() - (this.O00000o0.f4384O000000o.getBottom() + getPaddingTop());
                int i5 = this.O0000Ooo;
                if (i5 < 0) {
                    this.O00000o = i5;
                } else {
                    this.O00000o = 0;
                }
            } else {
                this.O00000o = 0;
                this.O0000Ooo = Integer.MAX_VALUE;
            }
        }
    }

    private int O000000o(int i, int i2) {
        ListAdapter adapter = getAdapter();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            adapter.getItemViewType(i4);
            if (O000000o(adapter)) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i) {
        ListAdapter adapter = getAdapter();
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i));
            adapter.getItemViewType(positionForSection);
            if (O000000o(adapter)) {
                return positionForSection;
            }
        }
        while (i >= 0) {
            adapter.getItemViewType(i);
            if (O000000o(adapter)) {
                return i;
            }
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
        if (onScrollListener == this.O0000o0) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.f4380O000000o = onScrollListener;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() {
            /* class com.hb.views.PinnedSectionListView.AnonymousClass3 */

            public final void run() {
                PinnedSectionListView.this.O00000Oo();
            }
        });
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            if (!(listAdapter instanceof O00000Oo)) {
                throw new IllegalArgumentException("Does your adapter implement PinnedSectionListAdapter?");
            } else if (listAdapter.getViewTypeCount() < 2) {
                throw new IllegalArgumentException("Does your adapter handle at least two types of views in getViewTypeCount() method: items and sections?");
            }
        }
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.O0000o0O);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.O0000o0O);
        }
        if (adapter != listAdapter) {
            O000000o();
        }
        super.setAdapter(listAdapter);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.O00000o0 != null && ((i3 - i) - getPaddingLeft()) - getPaddingRight() != this.O00000o0.f4384O000000o.getWidth()) {
            O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.O00000o0 != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.O00000o0.f4384O000000o;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + (this.O0000OoO == null ? 0 : Math.min(this.O0000o00, this.O0000Ooo)) + listPaddingTop);
            canvas.translate((float) listPaddingLeft, (float) (listPaddingTop + this.O00000o));
            drawChild(canvas, this.O00000o0.f4384O000000o, getDrawingTime());
            GradientDrawable gradientDrawable = this.O0000OoO;
            if (gradientDrawable != null && this.O0000Ooo > 0) {
                gradientDrawable.setBounds(this.O00000o0.f4384O000000o.getLeft(), this.O00000o0.f4384O000000o.getBottom(), this.O00000o0.f4384O000000o.getRight(), this.O00000o0.f4384O000000o.getBottom() + this.O0000o00);
                this.O0000OoO.draw(canvas);
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
        if (action == 0 && this.O0000Oo0 == null && (o000000o = this.O00000o0) != null && O000000o(o000000o.f4384O000000o, x, y)) {
            this.O0000Oo0 = this.O00000o0.f4384O000000o;
            PointF pointF = this.O0000O0o;
            pointF.x = x;
            pointF.y = y;
            this.O0000Oo = MotionEvent.obtain(motionEvent);
        }
        View view = this.O0000Oo0;
        if (view == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (O000000o(view, x, y)) {
            this.O0000Oo0.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            super.dispatchTouchEvent(motionEvent);
            if (!(this.O00000o0 == null || (onItemClickListener = getOnItemClickListener()) == null)) {
                View view2 = this.O00000o0.f4384O000000o;
                playSoundEffect(0);
                if (view2 != null) {
                    view2.sendAccessibilityEvent(1);
                }
                onItemClickListener.onItemClick(this, view2, this.O00000o0.O00000Oo, this.O00000o0.O00000o0);
            }
            O00000o();
        } else if (action == 3) {
            O00000o();
            return super.dispatchTouchEvent(motionEvent);
        } else if (action == 2 && Math.abs(y - this.O0000O0o.y) > ((float) this.O0000OOo)) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.O0000Oo0.dispatchTouchEvent(obtain);
            obtain.recycle();
            super.dispatchTouchEvent(this.O0000Oo);
            super.dispatchTouchEvent(motionEvent);
            O00000o();
        }
        return true;
    }

    private boolean O000000o(View view, float f, float f2) {
        view.getHitRect(this.O00000oo);
        this.O00000oo.top += this.O00000o;
        this.O00000oo.bottom += this.O00000o + getPaddingTop();
        this.O00000oo.left += getPaddingLeft();
        this.O00000oo.right -= getPaddingRight();
        return this.O00000oo.contains((int) f, (int) f2);
    }

    private void O00000o() {
        this.O0000Oo0 = null;
        MotionEvent motionEvent = this.O0000Oo;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.O0000Oo = null;
        }
    }

    public static boolean O000000o(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((O00000Oo) listAdapter).O000000o();
    }
}
