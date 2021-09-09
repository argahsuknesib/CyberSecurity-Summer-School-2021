package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class CommonFlowGroup extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f9155O000000o;
    private View O00000Oo;
    private O000000o O00000o;
    private boolean O00000o0 = true;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o = -1;
    private float O0000OOo = 66.0f;
    private O00000Oo O0000Oo0 = new O00000Oo() {
        /* class com.xiaomi.smarthome.library.common.widget.CommonFlowGroup.AnonymousClass1 */

        public final View onAddCreate(Context context) {
            return LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_add_item, (ViewGroup) null);
        }

        public final TextView onTagCreate(Context context, int i) {
            return (TextView) LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_item, (ViewGroup) null);
        }
    };

    public interface O000000o {
        void O000000o();

        void O000000o(int i);
    }

    public interface O00000Oo {
        View onAddCreate(Context context);

        TextView onTagCreate(Context context, int i);
    }

    public CommonFlowGroup(Context context) {
        super(context);
        O000000o();
    }

    public CommonFlowGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public CommonFlowGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = this.O0000Oo0.onAddCreate(getContext());
        View view = this.O00000Oo;
        if (view != null) {
            view.setContentDescription(getContext().getString(R.string.add));
            this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CommonFlowGroup$zeyr41iz9CjsxyQJgxVqLEGnrY */

                public final void onClick(View view) {
                    CommonFlowGroup.this.O00000Oo(view);
                }
            });
        }
        this.O00000oO = gri.O000000o(12.0f);
        this.O00000oo = gri.O000000o(12.0f);
        this.f9155O000000o = (getResources().getDisplayMetrics().widthPixels * 2) / 5;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public final void O000000o(Boolean bool) {
        if (this.O00000o0 != bool.booleanValue() && this.O00000Oo != null) {
            this.O00000o0 = bool.booleanValue();
            if (bool.booleanValue()) {
                addView(this.O00000Oo);
            } else {
                removeView(this.O00000Oo);
            }
        }
    }

    public void setData(List<String> list) {
        View view;
        removeAllViews();
        if (list != null) {
            int i = 0;
            for (String text : list) {
                TextView onTagCreate = this.O0000Oo0.onTagCreate(getContext(), i);
                onTagCreate.setText(text);
                onTagCreate.setTag(Integer.valueOf(i));
                onTagCreate.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.library.common.widget.$$Lambda$CommonFlowGroup$vI75lvtnoDJWc_evDH97_nzgrY */

                    public final void onClick(View view) {
                        CommonFlowGroup.this.O000000o(view);
                    }
                });
                addView(onTagCreate);
                i++;
            }
        }
        if (this.O00000o0 && (view = this.O00000Oo) != null) {
            addView(view);
        }
        requestLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        try {
            setSelectIndex(((Integer) view.getTag()).intValue());
            if (this.O00000o != null) {
                this.O00000o.O000000o(this.O0000O0o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSelectIndex() {
        return this.O0000O0o;
    }

    public void setSelectIndex(int i) {
        if (getChildCount() > i) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                getChildAt(i2).setSelected(false);
            }
            if (i < 0) {
                this.O0000O0o = i;
                return;
            }
            getChildAt(i).setSelected(true);
            this.O0000O0o = i;
        }
    }

    public void setMinWidth(float f) {
        this.O0000OOo = f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        View view = this.O00000Oo;
        int i3 = 0;
        if (view != null) {
            view.measure(0, 0);
        }
        int size = View.MeasureSpec.getSize(i);
        if (childCount > 0) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f9155O000000o, Integer.MIN_VALUE);
                    childAt.measure(makeMeasureSpec, 0);
                    if (childAt.getMeasuredWidth() < gri.O000000o(this.O0000OOo)) {
                        int O000000o2 = ((gri.O000000o(this.O0000OOo) - childAt.getMeasuredWidth()) / 2) + childAt.getPaddingLeft();
                        childAt.setPadding(O000000o2, childAt.getPaddingTop(), O000000o2, childAt.getPaddingBottom());
                        childAt.measure(makeMeasureSpec, 0);
                    }
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight() + this.O00000oo;
                    if (i5 + measuredWidth > size) {
                        i4 += measuredHeight;
                        i5 = 0;
                    }
                    i5 += measuredWidth + this.O00000oO;
                }
            }
            i3 = i4 + getChildAt(0).getMeasuredHeight() + getPaddingBottom() + getPaddingTop();
        }
        setMeasuredDimension(size, i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 <= childCount - 1; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i6 + measuredWidth > i5) {
                    i7 += this.O00000oo + measuredHeight;
                    i6 = 0;
                }
                childAt.layout(i6, getPaddingTop() + i7, measuredWidth + i6, getPaddingBottom() + i7 + measuredHeight);
                i6 += childAt.getWidth() + this.O00000oO;
            }
        }
    }

    public void setOnTagCreateListener(O00000Oo o00000Oo) {
        this.O0000Oo0 = o00000Oo;
    }

    public void setOnTagClickListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }
}
