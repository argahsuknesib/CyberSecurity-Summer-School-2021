package com.xiaomi.shopviews.widget.homesquarelefttextrightimage;

import _m_j.duq;
import _m_j.ewu;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class HomeSquareLeftTextRightImageView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ImageView f3988O000000o;
    private TextView O00000Oo;
    private ewu O00000o;
    private TextView O00000o0 = ((TextView) findViewById(R.id.bottom_title));
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;

    public HomeSquareLeftTextRightImageView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate((int) R.layout.listitem_left_text_right_image, this);
        ImageView imageView = (ImageView) findViewById(R.id.top_image);
        this.f3988O000000o = imageView;
        imageView.setMinimumHeight(duq.O000000o().O00000oo / 2);
        View findViewById = findViewById(R.id.layout_viewhelper_price);
        this.O00000oo = (TextView) findViewById.findViewById(R.id.tv_viewhelper_price);
        this.O0000O0o = (TextView) findViewById.findViewById(R.id.tv_viewhelper_price_qi);
        this.O00000oO = (TextView) findViewById.findViewById(R.id.tv_viewhelper_marketprice);
        this.O00000Oo = (TextView) findViewById(R.id.bottom_sub_title);
        this.O00000o = new ewu(this);
    }
}
