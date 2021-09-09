package com.xiaomi.shopviews.widget.homeproduct2type4container;

import _m_j.duo;
import _m_j.duq;
import _m_j.ewy;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;

public class HomeProduct2ItemType4ChildView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ImageView f3978O000000o = ((ImageView) findViewById(R.id.listitem_home_product2view_type5_image));
    private ewy O00000Oo;

    public HomeProduct2ItemType4ChildView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate((int) R.layout.listitem_home_product2view_type5, this);
        duo.O000000o O000000o2 = duo.O000000o(duq.O000000o().O00000oo, 537, 303);
        int i = O000000o2.O00000Oo;
        int i2 = O000000o2.f14953O000000o;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3978O000000o.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(14);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        this.f3978O000000o.setLayoutParams(layoutParams);
        this.O00000Oo = new ewy(this);
    }
}
