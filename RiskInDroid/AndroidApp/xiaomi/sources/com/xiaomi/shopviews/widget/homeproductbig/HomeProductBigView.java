package com.xiaomi.shopviews.widget.homeproductbig;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class HomeProductBigView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f3980O000000o = ((TextView) findViewById(R.id.listitem_home_productbigview_desc));
    private ImageView O00000Oo = ((ImageView) findViewById(R.id.listitem_home_productbigview_image));
    private TextView O00000o = ((TextView) findViewById(R.id.listitem_home_productbigview_title));
    private TextView O00000o0 = ((TextView) findViewById(R.id.listitem_home_productbigview_price));

    public HomeProductBigView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate((int) R.layout.listitem_home_product_big, this);
        setOrientation(1);
    }
}
