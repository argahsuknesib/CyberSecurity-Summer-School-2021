package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.xiaomi.smarthome.R;

public class GridTableLayout extends TableLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f9188O000000o = false;
    DataSetObserver O00000Oo;
    private int O00000o;
    private BaseAdapter O00000o0;
    private int O00000oO;
    private int O00000oo;
    private boolean O0000O0o = false;
    private int O0000OOo = -1;

    public GridTableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.horizontalSpacing, R.attr.numColumns, R.attr.verticalSpacing, R.attr.widthOrientation});
        this.O00000o = obtainStyledAttributes.getInt(1, 1);
        this.O00000oO = (int) obtainStyledAttributes.getDimension(2, 0.0f);
        this.O00000oo = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        this.O0000O0o = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        if (context.getResources().getDisplayMetrics().density < 1.8f) {
            this.O0000O0o = true;
        }
        this.O00000Oo = new DataSetObserver() {
            /* class com.xiaomi.smarthome.library.common.widget.GridTableLayout.AnonymousClass1 */

            public final void onChanged() {
                super.onChanged();
                GridTableLayout gridTableLayout = GridTableLayout.this;
                gridTableLayout.f9188O000000o = true;
                gridTableLayout.O000000o();
            }
        };
    }

    public int getNumColumn() {
        return this.O00000o;
    }

    public void setNumColumn(int i) {
        this.O00000o = i;
    }

    public float getVerticalSpacing() {
        return (float) this.O00000oO;
    }

    public void setVerticalSpacing(int i) {
        this.O00000oO = i;
    }

    public float getHorizontalSpacing() {
        return (float) this.O00000oo;
    }

    public void setHorizontalSpacing(int i) {
        this.O00000oo = i;
    }

    public GridTableLayout(Context context) {
        super(context);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        baseAdapter.registerDataSetObserver(this.O00000Oo);
        this.O00000o0 = baseAdapter;
        O000000o();
    }

    public final void O000000o() {
        boolean z;
        TableRow.LayoutParams layoutParams;
        int count = this.O00000o0.getCount();
        if (count < this.O0000OOo) {
            removeAllViews();
        }
        this.O0000OOo = count;
        Context context = getContext();
        for (int i = 0; i < count; i++) {
            int i2 = this.O00000o;
            int i3 = i % i2;
            int i4 = i / i2;
            int childCount = getChildCount();
            if ((i3 == 0 && !this.f9188O000000o) || (i3 == 0 && this.f9188O000000o && i4 >= childCount)) {
                TableRow tableRow = new TableRow(context);
                for (int i5 = 0; i5 < this.O00000o; i5++) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    if (this.O0000O0o) {
                        layoutParams = new TableRow.LayoutParams(0, -2);
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams = new TableRow.LayoutParams(-2, -2);
                        if (i3 != this.O00000o - 1) {
                            layoutParams.setMargins(0, 0, this.O00000oo, 0);
                        }
                    }
                    linearLayout.setGravity(1);
                    linearLayout.setLayoutParams(layoutParams);
                    tableRow.addView(linearLayout);
                }
                tableRow.setGravity(16);
                TableLayout.LayoutParams layoutParams2 = new TableLayout.LayoutParams(-1, -2);
                layoutParams2.setMargins(0, 0, 0, this.O00000oO);
                tableRow.setLayoutParams(layoutParams2);
                addView(tableRow);
            }
            LinearLayout linearLayout2 = (LinearLayout) ((TableRow) getChildAt(i4)).getChildAt(i3);
            View childAt = linearLayout2.getChildAt(0);
            View view = this.O00000o0.getView(i, childAt, linearLayout2);
            if (view != null && (!(z = this.f9188O000000o) || (z && childAt == null))) {
                linearLayout2.addView(view);
            }
        }
        this.f9188O000000o = false;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseAdapter baseAdapter = this.O00000o0;
        if (baseAdapter != null) {
            baseAdapter.unregisterDataSetObserver(this.O00000Oo);
            this.O00000Oo = null;
        }
    }
}
