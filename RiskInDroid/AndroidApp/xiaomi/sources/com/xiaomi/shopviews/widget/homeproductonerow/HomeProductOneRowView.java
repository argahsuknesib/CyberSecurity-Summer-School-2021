package com.xiaomi.shopviews.widget.homeproductonerow;

import _m_j.dul;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class HomeProductOneRowView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayout.LayoutParams f3981O000000o;
    private TextView O00000Oo = ((TextView) findViewById(R.id.listitem_home_listonerow_desc));
    private TextView O00000o = ((TextView) findViewById(R.id.listitem_home_listonerow_marketprice));
    private ImageView O00000o0 = ((ImageView) findViewById(R.id.listitem_home_listonerow_image));
    private TextView O00000oO = ((TextView) findViewById(R.id.listitem_home_listonerow_name));
    private TextView O00000oo = ((TextView) findViewById(R.id.listitem_home_listonerow_price));
    private LinearLayout O0000O0o = ((LinearLayout) findViewById(R.id.listitem_home_listonerow_taglayout));

    public HomeProductOneRowView(Context context) {
        super(context);
        this.f3981O000000o = new LinearLayout.LayoutParams(-2, dul.O000000o(context, 14.0f));
        inflate(context, R.layout.listitem_home_list_one_row, this);
    }
}
