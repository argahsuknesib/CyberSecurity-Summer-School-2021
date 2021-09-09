package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<O000000o> f9190O000000o = new ArrayList<>();

    public void setClipChildren(boolean z) {
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f9191O000000o;
        public ViewGroup O00000Oo;
        public boolean O00000o;
        public Object O00000o0;

        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public HeaderGridView(Context context) {
        super(context);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof O00000o0)) {
            ((O00000o0) adapter).O000000o(getNumColumns());
        }
    }

    public int getHeaderViewCount() {
        return this.f9190O000000o.size();
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f9190O000000o.size() > 0) {
            O00000o0 o00000o0 = new O00000o0(this.f9190O000000o, listAdapter);
            int numColumns = getNumColumns();
            if (numColumns > 1) {
                o00000o0.O000000o(numColumns);
            }
            super.setAdapter((ListAdapter) o00000o0);
            return;
        }
        super.setAdapter(listAdapter);
    }

    public class O00000Oo extends FrameLayout {
        public O00000Oo(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), View.MeasureSpec.getMode(i)), i2);
        }
    }

    public static class O00000o0 implements Filterable, WrapperListAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public final DataSetObservable f9193O000000o = new DataSetObservable();
        ArrayList<O000000o> O00000Oo;
        private final ListAdapter O00000o;
        boolean O00000o0;
        private int O00000oO = 1;
        private final boolean O00000oo;

        public O00000o0(ArrayList<O000000o> arrayList, ListAdapter listAdapter) {
            this.O00000o = listAdapter;
            this.O00000oo = listAdapter instanceof Filterable;
            if (arrayList != null) {
                this.O00000Oo = arrayList;
                this.O00000o0 = O000000o(this.O00000Oo);
                return;
            }
            throw new IllegalArgumentException("headerViewInfos cannot be null");
        }

        public final boolean isEmpty() {
            ListAdapter listAdapter = this.O00000o;
            return (listAdapter == null || listAdapter.isEmpty()) && this.O00000Oo.size() == 0;
        }

        public final void O000000o(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            } else if (this.O00000oO != i) {
                this.O00000oO = i;
                this.f9193O000000o.notifyChanged();
            }
        }

        private static boolean O000000o(ArrayList<O000000o> arrayList) {
            if (arrayList == null) {
                return true;
            }
            Iterator<O000000o> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().O00000o) {
                    return false;
                }
            }
            return true;
        }

        public final int getCount() {
            if (this.O00000o != null) {
                return (this.O00000Oo.size() * this.O00000oO) + this.O00000o.getCount();
            }
            return this.O00000Oo.size() * this.O00000oO;
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter == null) {
                return true;
            }
            if (!this.O00000o0 || !listAdapter.areAllItemsEnabled()) {
                return false;
            }
            return true;
        }

        public final boolean hasStableIds() {
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return false;
        }

        public final int getViewTypeCount() {
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount() + 1;
            }
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f9193O000000o.registerObserver(dataSetObserver);
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f9193O000000o.unregisterObserver(dataSetObserver);
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final Filter getFilter() {
            if (this.O00000oo) {
                return ((Filterable) this.O00000o).getFilter();
            }
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.O00000o;
        }

        public final boolean isEnabled(int i) {
            int size = this.O00000Oo.size();
            int i2 = this.O00000oO;
            int i3 = size * i2;
            if (i >= i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.O00000o;
                if (listAdapter == null || i4 >= listAdapter.getCount()) {
                    return false;
                }
                return this.O00000o.isEnabled(i4);
            } else if (i % i2 != 0 || !this.O00000Oo.get(i / i2).O00000o) {
                return false;
            } else {
                return true;
            }
        }

        public final Object getItem(int i) {
            int size = this.O00000Oo.size();
            int i2 = this.O00000oO;
            int i3 = size * i2;
            if (i >= i3) {
                int i4 = i - i3;
                ListAdapter listAdapter = this.O00000o;
                if (listAdapter != null && i4 < listAdapter.getCount()) {
                    return this.O00000o.getItem(i4);
                }
                throw new ArrayIndexOutOfBoundsException(i);
            } else if (i % i2 == 0) {
                return this.O00000Oo.get(i / i2).O00000o0;
            } else {
                return null;
            }
        }

        public final long getItemId(int i) {
            int i2;
            int size = this.O00000Oo.size() * this.O00000oO;
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter == null || i < size || (i2 = i - size) >= listAdapter.getCount()) {
                return -1;
            }
            return this.O00000o.getItemId(i2);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int size = this.O00000Oo.size();
            int i2 = this.O00000oO;
            int i3 = size * i2;
            if (i < i3) {
                ViewGroup viewGroup2 = this.O00000Oo.get(i / i2).O00000Oo;
                if (i % this.O00000oO == 0) {
                    return viewGroup2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(viewGroup2.getHeight());
                return view;
            }
            int i4 = i - i3;
            ListAdapter listAdapter = this.O00000o;
            if (listAdapter == null || i4 >= listAdapter.getCount()) {
                return new TextView(viewGroup.getContext());
            }
            return this.O00000o.getView(i4, view, viewGroup);
        }

        public final int getItemViewType(int i) {
            int i2;
            int size = this.O00000Oo.size();
            int i3 = this.O00000oO;
            int i4 = size * i3;
            if (i >= i4 || i % i3 == 0) {
                ListAdapter listAdapter = this.O00000o;
                if (listAdapter == null || i < i4 || (i2 = i - i4) >= listAdapter.getCount()) {
                    return -2;
                }
                return this.O00000o.getItemViewType(i2);
            }
            ListAdapter listAdapter2 = this.O00000o;
            if (listAdapter2 != null) {
                return listAdapter2.getViewTypeCount();
            }
            return 1;
        }
    }
}
