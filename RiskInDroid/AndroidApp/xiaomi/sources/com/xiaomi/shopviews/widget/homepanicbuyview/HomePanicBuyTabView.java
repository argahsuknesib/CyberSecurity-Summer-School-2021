package com.xiaomi.shopviews.widget.homepanicbuyview;

import _m_j.duq;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.xiaomi.shopviews.model.HomeSectionItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HomePanicBuyTabView extends HorizontalScrollView {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayout f3964O000000o;
    private ArrayList<HomeSectionItem> O00000Oo;
    private O000000o O00000o;
    private double O00000o0;
    private View O00000oO;
    private int O00000oo = -1;

    public interface O000000o {
        void O000000o(HomeSectionItem homeSectionItem);
    }

    public HomePanicBuyTabView(Context context) {
        super(context);
        O000000o();
    }

    public HomePanicBuyTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public HomePanicBuyTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public HomePanicBuyTabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o();
    }

    private void O000000o() {
        double d = (double) duq.O000000o().O00000oo;
        Double.isNaN(d);
        this.O00000o0 = d / 4.5d;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f3964O000000o = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        this.f3964O000000o.setOrientation(0);
        setFillViewport(true);
    }

    private void setSelectView(View view) {
        View view2 = this.O00000oO;
        if (view2 != view) {
            if (view2 != null) {
                view2.setBackgroundResource(R.drawable.panic_buy_tab_button_normal);
            }
            view.setBackgroundResource(R.drawable.panic_buy_tab_button_pressed);
            this.O00000oO = view;
        }
    }

    public void setOnItemClickListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void setSelectPosition(int i) {
        ArrayList<HomeSectionItem> arrayList = this.O00000Oo;
        if (arrayList != null && i >= 0 && i < arrayList.size() && this.O00000oo != i) {
            this.O00000oo = i;
            setSelectView(this.f3964O000000o.getChildAt(i));
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O000000o(this.O00000Oo.get(i));
            }
        }
    }
}
