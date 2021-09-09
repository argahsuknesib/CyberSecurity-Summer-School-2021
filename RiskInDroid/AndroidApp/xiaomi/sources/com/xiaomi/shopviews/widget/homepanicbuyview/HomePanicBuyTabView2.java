package com.xiaomi.shopviews.widget.homepanicbuyview;

import _m_j.duq;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HomePanicBuyTabView2 extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    LinearLayout f3965O000000o;
    private ArrayList<HomeSectionItem> O00000Oo;
    private double O00000o;
    private SparseArray<String> O00000o0 = new SparseArray<>();
    private O000000o O00000oO;
    private View O00000oo;
    private int O0000O0o = -1;

    public interface O000000o {
        void O000000o(HomeSectionItem homeSectionItem);
    }

    public HomePanicBuyTabView2(Context context) {
        super(context);
        O000000o();
    }

    public HomePanicBuyTabView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public HomePanicBuyTabView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public HomePanicBuyTabView2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o();
    }

    private void O000000o() {
        double d = (double) duq.O000000o().O00000oo;
        Double.isNaN(d);
        this.O00000o = d / 3.5d;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f3965O000000o = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        this.f3965O000000o.setOrientation(0);
        setFillViewport(true);
    }

    private void setSelectView(View view) {
        View view2 = this.O00000oo;
        if (view2 != view) {
            if (view2 != null) {
                view2.findViewById(R.id.title_container).setBackgroundColor(getResources().getColor(R.color.white));
                this.O00000oo.findViewById(R.id.arrow_down).setVisibility(8);
            }
            view.findViewById(R.id.title_container).setBackgroundColor(getResources().getColor(R.color.panic_select_bg));
            view.findViewById(R.id.arrow_down).setVisibility(0);
            this.O00000oo = view;
        }
    }

    public void setOnItemClickListener(O000000o o000000o) {
        this.O00000oO = o000000o;
    }

    public void setSelectPosition(int i) {
        ArrayList<HomeSectionItem> arrayList = this.O00000Oo;
        if (arrayList != null && i >= 0 && i < arrayList.size() && this.O0000O0o != i) {
            this.O0000O0o = i;
            setSelectView(this.f3965O000000o.getChildAt(i));
            O000000o o000000o = this.O00000oO;
            if (o000000o != null) {
                o000000o.O000000o(this.O00000Oo.get(i));
            }
        }
    }
}
