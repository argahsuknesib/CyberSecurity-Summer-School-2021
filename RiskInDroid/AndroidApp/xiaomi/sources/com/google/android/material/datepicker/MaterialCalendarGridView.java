package com.google.android.material.datepicker;

import _m_j.be;
import _m_j.bh;
import _m_j.cb;
import _m_j.cl;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.internal.ViewUtils;
import com.xiaomi.smarthome.R;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        cb.O000000o(this, new bh() {
            /* class com.google.android.material.datepicker.MaterialCalendarGridView.AnonymousClass1 */

            public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
                super.onInitializeAccessibilityNodeInfo(view, clVar);
                clVar.O000000o((Object) null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void setSelection(int i) {
        if (i < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i);
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    public final MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        Long item = adapter.getItem(adapter.firstPositionInMonth());
        Long item2 = adapter.getItem(adapter.lastPositionInMonth());
        for (be next : dateSelector.getSelectedRanges()) {
            if (!(next.f12896O000000o == null || next.O00000Oo == null)) {
                long longValue = ((Long) next.f12896O000000o).longValue();
                long longValue2 = ((Long) next.O00000Oo).longValue();
                if (!skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    if (longValue < item.longValue()) {
                        i2 = adapter.firstPositionInMonth();
                        if (adapter.isFirstInRow(i2)) {
                            i = 0;
                        } else if (!isLayoutRtl) {
                            i = materialCalendarGridView.getChildAt(i2 - 1).getRight();
                        } else {
                            i = materialCalendarGridView.getChildAt(i2 - 1).getLeft();
                        }
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        i2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i = horizontalMidPoint(materialCalendarGridView.getChildAt(i2));
                    }
                    if (longValue2 > item2.longValue()) {
                        i4 = Math.min(adapter.lastPositionInMonth(), getChildCount() - 1);
                        if (adapter.isLastInRow(i4)) {
                            i3 = getWidth();
                        } else if (!isLayoutRtl) {
                            i3 = materialCalendarGridView.getChildAt(i4).getRight();
                        } else {
                            i3 = materialCalendarGridView.getChildAt(i4).getLeft();
                        }
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        i4 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i3 = horizontalMidPoint(materialCalendarGridView.getChildAt(i4));
                    }
                    int itemId = (int) adapter.getItemId(i2);
                    int itemId2 = (int) adapter.getItemId(i4);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        int top = childAt.getTop() + calendarStyle.day.getTopInset();
                        int bottom = childAt.getBottom() - calendarStyle.day.getBottomInset();
                        if (!isLayoutRtl) {
                            i6 = numColumns > i2 ? 0 : i;
                            i5 = i4 > numColumns2 ? getWidth() : i3;
                        } else {
                            int i7 = i4 > numColumns2 ? 0 : i3;
                            i5 = numColumns > i2 ? getWidth() : i;
                            i6 = i7;
                        }
                        canvas.drawRect((float) i6, (float) top, (float) i5, (float) bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = adapter;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    public final void onMeasure(int i, int i2) {
        if (this.nestedScrollable) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            gainFocus(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    private void gainFocus(int i, Rect rect) {
        if (i == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    private static boolean skipMonth(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    private static int horizontalMidPoint(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }
}
