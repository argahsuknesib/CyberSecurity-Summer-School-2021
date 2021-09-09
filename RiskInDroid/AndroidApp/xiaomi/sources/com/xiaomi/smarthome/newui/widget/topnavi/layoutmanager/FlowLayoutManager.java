package com.xiaomi.smarthome.newui.widget.topnavi.layoutmanager;

import _m_j.gsy;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FlowLayoutManager extends RecyclerView.LayoutManager {
    private static final String O00000oO = "FlowLayoutManager";

    /* renamed from: O000000o  reason: collision with root package name */
    final FlowLayoutManager f10355O000000o = this;
    protected int O00000Oo;
    protected int O00000o = 0;
    protected int O00000o0;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo = 0;
    private int O0000Oo0;
    private O00000Oo O0000OoO = new O00000Oo();
    private List<O00000Oo> O0000Ooo = new ArrayList();
    private SparseArray<Rect> O0000o00 = new SparseArray<>();

    public boolean canScrollVertically() {
        return true;
    }

    public final int O000000o() {
        return this.O00000o;
    }

    public FlowLayoutManager() {
        setAutoMeasureEnabled(true);
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10356O000000o;
        View O00000Oo;
        Rect O00000o0;

        public O000000o(int i, View view, Rect rect) {
            this.f10356O000000o = i;
            this.O00000Oo = view;
            this.O00000o0 = rect;
        }
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        float f10357O000000o;
        float O00000Oo;
        List<O000000o> O00000o0 = new ArrayList();

        public O00000Oo() {
        }

        public final void O000000o(O000000o o000000o) {
            this.O00000o0.add(o000000o);
        }
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        gsy.O000000o(3, O00000oO, "onLayoutChildren");
        this.O00000o = 0;
        int i = this.O0000O0o;
        this.O0000OoO = new O00000Oo();
        this.O0000Ooo.clear();
        this.O0000o00.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(o000o0oo);
            this.O0000Oo = 0;
        } else if (getChildCount() != 0 || !o000OO0o.O0000O0o) {
            detachAndScrapAttachedViews(o000o0oo);
            if (getChildCount() == 0) {
                this.O00000Oo = getWidth();
                this.O00000o0 = getHeight();
                this.O00000oo = getPaddingLeft();
                this.O0000OOo = getPaddingRight();
                this.O0000O0o = getPaddingTop();
                this.O0000Oo0 = (this.O00000Oo - this.O00000oo) - this.O0000OOo;
            }
            int i2 = i;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < getItemCount(); i5++) {
                gsy.O000000o(3, O00000oO, "index:".concat(String.valueOf(i5)));
                View O00000Oo2 = o000o0oo.O00000Oo(i5);
                if (8 != O00000Oo2.getVisibility()) {
                    measureChildWithMargins(O00000Oo2, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(O00000Oo2);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(O00000Oo2);
                    int i6 = i3 + decoratedMeasuredWidth;
                    if (i6 <= this.O0000Oo0) {
                        int i7 = this.O00000oo + i3;
                        Rect rect = this.O0000o00.get(i5);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        rect.set(i7, i2, decoratedMeasuredWidth + i7, i2 + decoratedMeasuredHeight);
                        this.O0000o00.put(i5, rect);
                        i4 = Math.max(i4, decoratedMeasuredHeight);
                        this.O0000OoO.O000000o(new O000000o(decoratedMeasuredHeight, O00000Oo2, rect));
                        O00000Oo o00000Oo = this.O0000OoO;
                        o00000Oo.f10357O000000o = (float) i2;
                        o00000Oo.O00000Oo = (float) i4;
                        decoratedMeasuredWidth = i6;
                    } else {
                        O00000Oo();
                        i2 += i4;
                        this.O00000o += i4;
                        int i8 = this.O00000oo;
                        Rect rect2 = this.O0000o00.get(i5);
                        if (rect2 == null) {
                            rect2 = new Rect();
                        }
                        rect2.set(i8, i2, i8 + decoratedMeasuredWidth, i2 + decoratedMeasuredHeight);
                        this.O0000o00.put(i5, rect2);
                        this.O0000OoO.O000000o(new O000000o(decoratedMeasuredHeight, O00000Oo2, rect2));
                        O00000Oo o00000Oo2 = this.O0000OoO;
                        o00000Oo2.f10357O000000o = (float) i2;
                        o00000Oo2.O00000Oo = (float) decoratedMeasuredHeight;
                        i4 = decoratedMeasuredHeight;
                    }
                    if (i5 == getItemCount() - 1) {
                        O00000Oo();
                        this.O00000o += i4;
                    }
                    i3 = decoratedMeasuredWidth;
                }
            }
            this.O00000o = Math.max(this.O00000o, O00000o0());
            gsy.O000000o(3, O00000oO, "onLayoutChildren totalHeight:" + this.O00000o);
            O000000o(o000o0oo, o000OO0o);
        }
    }

    private void O00000Oo() {
        List<O000000o> list = this.O0000OoO.O00000o0;
        for (int i = 0; i < list.size(); i++) {
            O000000o o000000o = list.get(i);
            View view = o000000o.O00000Oo;
            int position = getPosition(view);
            if (((float) this.O0000o00.get(position).top) < this.O0000OoO.f10357O000000o + ((this.O0000OoO.O00000Oo - ((float) list.get(i).f10356O000000o)) / 2.0f)) {
                Rect rect = this.O0000o00.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                rect.set(this.O0000o00.get(position).left, (int) (this.O0000OoO.f10357O000000o + ((this.O0000OoO.O00000Oo - ((float) list.get(i).f10356O000000o)) / 2.0f)), this.O0000o00.get(position).right, (int) (this.O0000OoO.f10357O000000o + ((this.O0000OoO.O00000Oo - ((float) list.get(i).f10356O000000o)) / 2.0f) + ((float) getDecoratedMeasuredHeight(view))));
                this.O0000o00.put(position, rect);
                o000000o.O00000o0 = rect;
                list.set(i, o000000o);
            }
        }
        O00000Oo o00000Oo = this.O0000OoO;
        o00000Oo.O00000o0 = list;
        this.O0000Ooo.add(o00000Oo);
        this.O0000OoO = new O00000Oo();
    }

    public int scrollVerticallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        gsy.O000000o(3, "TAG", "totalHeight:" + this.O00000o);
        int i2 = this.O0000Oo;
        if (i2 + i < 0) {
            i = -i2;
        } else if (i2 + i > this.O00000o - O00000o0()) {
            i = (this.O00000o - O00000o0()) - this.O0000Oo;
        }
        this.O0000Oo += i;
        offsetChildrenVertical(-i);
        O000000o(o000o0oo, o000OO0o);
        return i;
    }

    private int O00000o0() {
        return (this.f10355O000000o.getHeight() - this.f10355O000000o.getPaddingBottom()) - this.f10355O000000o.getPaddingTop();
    }

    private void O000000o(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (!o000OO0o.O0000O0o) {
            Rect rect = new Rect(getPaddingLeft(), getPaddingTop() + this.O0000Oo, getWidth() - getPaddingRight(), this.O0000Oo + (getHeight() - getPaddingBottom()));
            for (int i = 0; i < this.O0000Ooo.size(); i++) {
                O00000Oo o00000Oo = this.O0000Ooo.get(i);
                float f = o00000Oo.f10357O000000o;
                float f2 = o00000Oo.O00000Oo + f;
                if (f >= ((float) rect.bottom) || ((float) rect.top) >= f2) {
                    List<O000000o> list = o00000Oo.O00000o0;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        removeAndRecycleView(list.get(i2).O00000Oo, o000o0oo);
                    }
                } else {
                    List<O000000o> list2 = o00000Oo.O00000o0;
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        View view = list2.get(i3).O00000Oo;
                        measureChildWithMargins(view, 0, 0);
                        addView(view);
                        Rect rect2 = list2.get(i3).O00000o0;
                        layoutDecoratedWithMargins(view, rect2.left, rect2.top - this.O0000Oo, rect2.right, rect2.bottom - this.O0000Oo);
                    }
                }
            }
        }
    }
}
