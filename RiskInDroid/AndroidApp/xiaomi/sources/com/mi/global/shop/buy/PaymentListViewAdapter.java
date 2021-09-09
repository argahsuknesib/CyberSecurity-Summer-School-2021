package com.mi.global.shop.buy;

import _m_j.byl;
import _m_j.bzi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.SlidingButton;
import com.xiaomi.smarthome.R;

public class PaymentListViewAdapter extends ArrayAdapter<bzi.O00000Oo> implements SlidingButton.O000000o {
    public final void O000000o(SlidingButton slidingButton, boolean z) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        if (((bzi.O00000Oo) obj) == null) {
            return null;
        }
        return LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_buy_confirm_payment_method_item, (ViewGroup) null, false);
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        bzi.O00000Oo o00000Oo = (bzi.O00000Oo) obj;
        if (o00000Oo != null) {
            CustomTextView customTextView = (CustomTextView) view.findViewById(R.id.paymentmethod_name);
            view.findViewById(R.id.paymentmethod_image);
            CustomTextView customTextView2 = (CustomTextView) view.findViewById(R.id.tv_paymentmethod_long_hint);
            CustomTextView customTextView3 = (CustomTextView) view.findViewById(R.id.paymentmethod_hint);
            CustomTextView customTextView4 = (CustomTextView) view.findViewById(R.id.paymentmethod_discount);
            if (TextUtils.isEmpty(o00000Oo.O00000Oo)) {
                customTextView4.setVisibility(8);
            } else {
                customTextView4.setText(o00000Oo.O00000Oo);
                customTextView4.setVisibility(0);
            }
            customTextView.setText(o00000Oo.f13475O000000o);
            if (!byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_Cardless_EMI).equals(o00000Oo.O00000oo) || TextUtils.isEmpty(o00000Oo.O00000o0)) {
                customTextView3.setVisibility(0);
                customTextView2.setVisibility(8);
                customTextView3.setText(o00000Oo.O00000o0);
            } else {
                customTextView2.setVisibility(0);
                customTextView3.setVisibility(4);
                customTextView2.setText(o00000Oo.O00000o0);
            }
            if (o00000Oo.O0000O0o) {
                customTextView.setTextColor(Color.rgb(46, 39, 39));
            } else {
                customTextView.setTextColor(Color.rgb(176, 176, 176));
            }
        }
    }

    public PaymentListViewAdapter(Context context) {
        super(context);
    }
}
