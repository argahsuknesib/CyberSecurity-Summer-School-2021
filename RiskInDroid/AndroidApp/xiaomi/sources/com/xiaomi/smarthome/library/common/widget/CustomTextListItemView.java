package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class CustomTextListItemView extends ListItemView {
    private static int O00000Oo = 24;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private int O0000OOo = 1;
    private List<View> O0000Oo0 = new ArrayList();

    public CustomTextListItemView(Context context) {
        super(context);
        O000000o(context, null);
    }

    public CustomTextListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        int i;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.text_one, R.attr.text_two});
        this.O00000o0 = obtainStyledAttributes.getResourceId(0, -1);
        this.O00000o = obtainStyledAttributes.getResourceId(1, -1);
        if (this.O00000o0 == -1 && (i = this.O00000o) != -1) {
            this.O00000o0 = i;
            this.O00000o = -1;
        }
        this.O00000oO = gri.O000000o(context);
        setFocusable(true);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.O0000Oo0.clear();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= getChildCount()) {
                break;
            }
            if (getChildAt(i4) instanceof TextView) {
                int i5 = this.O00000o0;
                if (i5 == -1) {
                    this.O00000o0 = getChildAt(i4).getId();
                    this.O00000oo = (TextView) getChildAt(i4);
                    this.O00000oo.setSingleLine();
                    break;
                } else if (this.O00000o == -1) {
                    this.O00000o = getChildAt(i4).getId();
                    this.O0000O0o = (TextView) getChildAt(i4);
                    this.O0000O0o.setSingleLine();
                    break;
                } else {
                    if (i5 == getChildAt(i4).getId()) {
                        this.O00000oo = (TextView) getChildAt(i4);
                        this.O00000oo.setSingleLine();
                    }
                    if (this.O00000o == getChildAt(i4).getId()) {
                        this.O0000O0o = (TextView) getChildAt(i4);
                        this.O0000O0o.setSingleLine();
                    }
                }
            } else {
                this.O0000Oo0.add(getChildAt(i4));
            }
            i4++;
        }
        O00000Oo();
        TextView textView = this.O00000oo;
        if (textView != null) {
            textView.setTextSize(15.0f);
            this.O00000oo.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O00000oo.getLayoutParams();
            int measuredWidth = layoutParams.rightMargin + layoutParams.leftMargin + this.O00000oo.getMeasuredWidth();
            if (measuredWidth > this.O00000oO) {
                O000000o();
            } else {
                TextView textView2 = this.O0000O0o;
                if (textView2 != null) {
                    textView2.setTextSize(15.0f);
                    this.O0000O0o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.O0000O0o.getLayoutParams();
                    i3 = this.O0000O0o.getMeasuredWidth() + layoutParams2.rightMargin + layoutParams2.leftMargin;
                    this.O0000O0o.setMaxLines(2);
                }
                if (measuredWidth + i3 + gri.O000000o((float) O00000Oo) > this.O00000oO) {
                    O000000o();
                } else {
                    O00000Oo();
                }
            }
        }
        ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
        layoutParams3.height = getResources().getDimensionPixelSize(R.dimen.std_list_item_height_single_line);
        setLayoutParams(layoutParams3);
        requestLayout();
        getParent().requestLayout();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private void O000000o() {
        TextView textView = this.O00000oo;
        if (textView != null && this.O0000O0o != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            int[] rules = layoutParams.getRules();
            for (int i = 0; i < rules.length; i++) {
                rules[i] = 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.O0000Oo0.size(); i3++) {
                this.O0000Oo0.get(i3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                i2 += this.O0000Oo0.get(i3).getMeasuredWidth();
            }
            layoutParams.setMargins(getResources().getDimensionPixelSize(R.dimen.custom_text_item_margin_left), 0, getResources().getDimensionPixelSize(R.dimen.custom_text_item_margin_right) + i2, 0);
            layoutParams.addRule(15, 0);
            this.O00000oo.setLayoutParams(layoutParams);
            this.O0000O0o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.O0000O0o.getLayoutParams();
            int[] rules2 = layoutParams.getRules();
            for (int i4 = 0; i4 < rules2.length; i4++) {
                rules2[i4] = 0;
            }
            int measuredWidth = layoutParams2.rightMargin + layoutParams2.leftMargin + this.O0000O0o.getMeasuredWidth();
            if (measuredWidth > 0) {
                if (measuredWidth <= this.O00000oO) {
                    this.O0000OOo = 2;
                } else {
                    this.O0000OOo = 3;
                }
            }
            layoutParams2.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
            layoutParams2.addRule(15, 0);
            layoutParams2.addRule(3, this.O00000oo.getId());
            layoutParams2.addRule(9);
            this.O0000O0o.setLayoutParams(layoutParams2);
            this.O0000O0o.setTextSize(12.0f);
        }
    }

    private void O00000Oo() {
        TextView textView = this.O00000oo;
        if (textView != null && this.O0000O0o != null) {
            textView.setTextSize(15.0f);
            this.O0000O0o.setTextSize(15.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O00000oo.getLayoutParams();
            layoutParams.addRule(15);
            layoutParams.setMargins(getResources().getDimensionPixelSize(R.dimen.custom_text_item_margin_left), 0, 0, 0);
            this.O00000oo.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.O0000O0o.getLayoutParams();
            int[] rules = layoutParams2.getRules();
            for (int i = 0; i < rules.length; i++) {
                rules[i] = 0;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.O0000Oo0.size(); i3++) {
                this.O0000Oo0.get(i3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                i2 += this.O0000Oo0.get(i3).getMeasuredWidth();
            }
            layoutParams2.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.custom_text_item_margin_right) + i2, 0);
            layoutParams2.addRule(15);
            layoutParams2.addRule(9, 0);
            layoutParams2.addRule(11);
            layoutParams2.addRule(3, 0);
            this.O0000O0o.setLayoutParams(layoutParams2);
        }
    }
}
