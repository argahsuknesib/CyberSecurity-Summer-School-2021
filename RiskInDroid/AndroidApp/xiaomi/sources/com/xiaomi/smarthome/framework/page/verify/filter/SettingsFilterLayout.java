package com.xiaomi.smarthome.framework.page.verify.filter;

import _m_j.fwi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class SettingsFilterLayout extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<fwi> f8014O000000o = new ArrayList();
    public List<TextView> O00000Oo = new ArrayList();
    private int O00000o = 14;
    private Context O00000o0;
    private int O00000oO = R.color.scene_filter_item_fg_selector;
    private int O00000oo = R.drawable.scene_filter_item_bg_selector;
    private List<fwi> O0000O0o = new ArrayList();
    private List<TextView> O0000OOo = new ArrayList();
    private List<List<View>> O0000Oo = new ArrayList();
    private List<fwi> O0000Oo0;
    private List<Integer> O0000OoO = new ArrayList();

    public SettingsFilterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o0 = context;
    }

    public SettingsFilterLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000o0 = context;
    }

    public SettingsFilterLayout(Context context) {
        super(context);
        this.O00000o0 = context;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.O0000Oo.clear();
        this.O0000OoO.clear();
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i3 = 0;
        ArrayList arrayList2 = arrayList;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i8 = size2;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i9 = i4 + measuredWidth;
            if (i9 > size) {
                i5 = Math.max(i4, i5);
                this.O0000Oo.add(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(childAt);
                i7 += i6;
                this.O0000OoO.add(Integer.valueOf(i6));
                i6 = measuredHeight;
                arrayList2 = arrayList3;
                i4 = measuredWidth;
            } else {
                arrayList2.add(childAt);
                i6 = Math.max(i6, measuredHeight);
                i4 = i9;
            }
            if (i3 == childCount - 1) {
                int max = Math.max(i5, i4);
                i7 += i6;
                this.O0000Oo.add(arrayList2);
                this.O0000OoO.add(Integer.valueOf(i6));
                i5 = max;
            }
            i3++;
            size2 = i8;
        }
        int i10 = size2;
        if (mode != 1073741824) {
            size = i5;
        }
        if (mode2 == 1073741824) {
            i7 = i10;
        }
        setMeasuredDimension(size, i7);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.O0000Oo.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            List list = this.O0000Oo.get(i6);
            int intValue = this.O0000OoO.get(i6).intValue();
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                View view = (View) list.get(i8);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i9 = marginLayoutParams.leftMargin + i7;
                    int i10 = marginLayoutParams.topMargin + i5;
                    view.layout(i9, i10, view.getMeasuredWidth() + i9, view.getMeasuredHeight() + i10);
                    i7 += view.getMeasuredWidth() + marginLayoutParams.rightMargin + marginLayoutParams.leftMargin;
                }
            }
            i5 += intValue;
        }
    }

    public void setFlowViewData(List<fwi> list) {
        this.O0000Oo0 = list;
        for (int i = 0; i < list.size(); i++) {
            final fwi fwi = list.get(i);
            final TextView textView = new TextView(this.O00000o0);
            textView.setTextSize((float) this.O00000o);
            textView.setTextColor(this.O00000o0.getResources().getColorStateList(this.O00000oO));
            textView.setBackgroundDrawable(this.O00000o0.getResources().getDrawable(this.O00000oo));
            textView.setSingleLine(true);
            textView.setGravity(17);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            int O000000o2 = O000000o(this.O00000o0, 15.0f);
            int O000000o3 = O000000o(this.O00000o0, 8.0f);
            int O000000o4 = O000000o(this.O00000o0, 5.0f);
            textView.setPadding(O000000o2, O000000o3, O000000o2, O000000o3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.setMargins(O000000o4, O000000o4, O000000o4, O000000o4);
            textView.setLayoutParams(marginLayoutParams);
            addView(textView);
            textView.setText(fwi.f17309O000000o);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.verify.filter.SettingsFilterLayout.AnonymousClass1 */

                public final void onClick(View view) {
                    if (textView.isSelected()) {
                        textView.setSelected(false);
                        SettingsFilterLayout.this.f8014O000000o.remove(fwi);
                        SettingsFilterLayout.this.O00000Oo.remove(textView);
                    } else {
                        textView.setSelected(true);
                        SettingsFilterLayout.this.f8014O000000o.add(fwi);
                        SettingsFilterLayout.this.O00000Oo.add(textView);
                    }
                    fwi.O00000o = SettingsFilterLayout.this.f8014O000000o;
                }
            });
        }
    }

    public final void O000000o() {
        O000000o(false);
        this.O00000Oo.addAll(this.O0000OOo);
        this.f8014O000000o.addAll(this.O0000O0o);
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            this.O00000Oo.get(i).setSelected(true);
        }
    }

    public List<fwi> getSelectedLabelData() {
        this.O0000O0o.clear();
        this.O0000O0o.addAll(this.f8014O000000o);
        this.O0000OOo.clear();
        this.O0000OOo.addAll(this.O00000Oo);
        return this.f8014O000000o;
    }

    public final void O000000o(boolean z) {
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            this.O00000Oo.get(i).setSelected(false);
        }
        this.f8014O000000o.clear();
        this.O00000Oo.clear();
        if (z) {
            this.O0000O0o.clear();
            this.O0000OOo.clear();
        }
    }

    private static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
