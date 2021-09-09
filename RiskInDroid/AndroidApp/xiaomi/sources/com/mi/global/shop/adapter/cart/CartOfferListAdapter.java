package com.mi.global.shop.adapter.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CartOfferListAdapter extends ArrayAdapter<String> {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4772O000000o;
    O000000o O00000Oo;

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        ((O000000o) view.getTag()).O00000Oo.setText((String) obj);
    }

    public CartOfferListAdapter(Context context) {
        super(context);
        this.f4772O000000o = context;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4773O000000o;
        CustomTextView O00000Oo;

        O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cart_offeritem, viewGroup, false);
        this.O00000Oo = new O000000o();
        O000000o o000000o = this.O00000Oo;
        o000000o.f4773O000000o = inflate;
        o000000o.O00000Oo = (CustomTextView) inflate.findViewById(R.id.offer_title);
        inflate.setTag(this.O00000Oo);
        return inflate;
    }
}
