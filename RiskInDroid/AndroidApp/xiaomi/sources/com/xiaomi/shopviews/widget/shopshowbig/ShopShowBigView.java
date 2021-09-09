package com.xiaomi.shopviews.widget.shopshowbig;

import _m_j.duh;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class ShopShowBigView extends ConstraintLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f3991O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;

    public ShopShowBigView(Context context) {
        this(context, null, 0);
    }

    public ShopShowBigView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShopShowBigView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflate(getContext(), R.layout.shopview_shop_show_big, this);
        this.f3991O000000o = (ImageView) findViewById(R.id.iv);
        this.O00000Oo = (TextView) findViewById(R.id.tv_discount);
        this.O00000o0 = (TextView) findViewById(R.id.tv_title);
        this.O00000o = (TextView) findViewById(R.id.tv_description);
        this.O00000oo = (TextView) findViewById(R.id.tv_currency);
        this.O00000oO = (TextView) findViewById(R.id.tv_price);
        this.O0000O0o = (TextView) findViewById(R.id.tv_price_origin);
        this.O0000OOo = (TextView) findViewById(R.id.tv_buy);
    }

    public void setImage(String str) {
        duh.O000000o().O000000o(str, this.f3991O000000o);
    }

    public void setImage(int i) {
        duh.O000000o().O000000o(i, this.f3991O000000o);
    }

    public void setOffText(String str) {
        this.O00000Oo.setText(str);
    }

    public void setOffText(int i) {
        this.O00000Oo.setText(i);
    }

    public void setTitle(String str) {
        this.O00000o0.setText(str);
    }

    public void setTitle(int i) {
        this.O00000o0.setText(i);
    }

    public void setDescription(String str) {
        this.O00000o.setText(str);
    }

    public void setDescription(int i) {
        this.O00000o.setText(i);
    }

    public void setCurrency(String str) {
        this.O00000oo.setText(str);
    }

    public void setCurrency(int i) {
        this.O00000oo.setText(i);
    }

    public void setPrice(String str) {
        this.O00000oO.setText(str);
    }

    public void setPrice(int i) {
        this.O00000oO.setText(i);
    }

    public void setPriceOrigin(String str) {
        this.O0000O0o.setText(str);
    }

    public void setPriceOrigin(int i) {
        this.O0000O0o.setText(i);
    }

    public void setBuy(String str) {
        this.O0000OOo.setText(str);
    }

    public void setBuy(int i) {
        this.O0000OOo.setText(i);
    }
}
