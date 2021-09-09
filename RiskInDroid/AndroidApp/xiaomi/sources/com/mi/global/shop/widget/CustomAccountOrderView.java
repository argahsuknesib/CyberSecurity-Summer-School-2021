package com.mi.global.shop.widget;

import _m_j.cbq;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class CustomAccountOrderView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f4950O000000o;
    private View O00000Oo;
    private SimpleDraweeView O00000o;
    private LayoutInflater O00000o0;
    private ImageView O00000oO;
    private CustomTextView O00000oo;
    private CustomTextView O0000O0o;
    private RelativeLayout O0000OOo;

    public CustomAccountOrderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    public CustomAccountOrderView(Context context) {
        super(context);
        O000000o(context);
    }

    public CustomAccountOrderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.f4950O000000o = context;
        this.O00000o0 = LayoutInflater.from(context);
        this.O00000Oo = this.O00000o0.inflate((int) R.layout.shop_custom_account_order_layout, (ViewGroup) null);
        this.O00000o = (SimpleDraweeView) this.O00000Oo.findViewById(R.id.iv_icon);
        this.O00000oO = (ImageView) this.O00000Oo.findViewById(R.id.iv_beta);
        this.O00000oo = (CustomTextView) this.O00000Oo.findViewById(R.id.tv_count);
        this.O0000O0o = (CustomTextView) this.O00000Oo.findViewById(R.id.tv_title);
        this.O0000OOo = (RelativeLayout) this.O00000Oo.findViewById(R.id.rl_item);
        addView(this.O00000Oo);
    }

    public CustomTextView getTvCount() {
        return this.O00000oo;
    }

    public void setTvCount(String str) {
        this.O00000oo.setText(str);
    }

    public SimpleDraweeView getIvIcon() {
        return this.O00000o;
    }

    public void setIvIcon(int i) {
        cbq.O000000o(i, this.O00000o);
    }

    public CustomTextView getTvTitle() {
        return this.O0000O0o;
    }

    public void setTvTitle(String str) {
        this.O0000O0o.setText(str);
    }

    public void setCountVisible(int i) {
        this.O00000oo.setVisibility(i);
    }

    public void setIvBeta(int i) {
        this.O00000oO.setImageResource(i);
    }
}
