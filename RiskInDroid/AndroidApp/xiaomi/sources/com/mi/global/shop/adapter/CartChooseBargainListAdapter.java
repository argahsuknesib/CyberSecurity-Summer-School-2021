package com.mi.global.shop.adapter;

import _m_j.byl;
import _m_j.cad;
import _m_j.cbb;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cdy;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.ShoppingCartBargainActivity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.model.ShoppingCartBargainModel;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class CartChooseBargainListAdapter extends ArrayAdapter<ShoppingCartBargainModel.BargainsItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4733O000000o;
    O00000Oo O00000Oo;

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        ShoppingCartBargainModel.BargainsItem bargainsItem = (ShoppingCartBargainModel.BargainsItem) obj;
        O00000Oo o00000Oo = (O00000Oo) view.getTag();
        o00000Oo.O00000o.setText(bargainsItem.bargainName);
        int O000000o2 = cdy.O000000o(50.0f);
        String str = bargainsItem.bargainImg;
        if (!TextUtils.isEmpty(str)) {
            str = cbb.O000000o(O000000o2, O000000o2, str);
        }
        cbq.O000000o(str, o00000Oo.O00000o0);
        o00000Oo.O00000oo.setText(cad.O00000o0() + " " + bargainsItem.bargainPrice_txt);
        if (bargainsItem.bargainAdapt == null || bargainsItem.bargainAdapt.size() <= 0) {
            o00000Oo.O00000oO.setVisibility(8);
        } else {
            o00000Oo.O00000oO.setVisibility(0);
            String str2 = "";
            for (int i2 = 0; i2 < bargainsItem.bargainAdapt.size(); i2++) {
                str2 = str2 + " " + bargainsItem.bargainAdapt.get(i2);
            }
            o00000Oo.O00000oO.setText(byl.O00000oO().getString(R.string.cart_bargain_compatible) + str2);
        }
        if (bargainsItem.Selected.booleanValue()) {
            o00000Oo.O00000Oo.setImageDrawable(byl.O00000oO().getResources().getDrawable(R.drawable.shop_radio_selected));
        } else {
            o00000Oo.O00000Oo.setImageDrawable(byl.O00000oO().getResources().getDrawable(R.drawable.shop_radio_unselected));
        }
        o00000Oo.O0000O0o.setOnClickListener(new O000000o(bargainsItem, this.O00000o));
    }

    public CartChooseBargainListAdapter(Context context) {
        super(context);
        this.f4733O000000o = context;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4735O000000o;
        ImageView O00000Oo;
        CustomTextView O00000o;
        SimpleDraweeView O00000o0;
        CustomTextView O00000oO;
        CustomTextView O00000oo;
        LinearLayout O0000O0o;

        O00000Oo() {
        }
    }

    class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        ShoppingCartBargainModel.BargainsItem f4734O000000o;
        Context O00000Oo;
        CartChooseBargainListAdapter O00000o;
        ArrayList<ShoppingCartBargainModel.BargainsItem> O00000o0;

        public O000000o(ShoppingCartBargainModel.BargainsItem bargainsItem, Context context) {
            this.f4734O000000o = bargainsItem;
            this.O00000Oo = context;
            ShoppingCartBargainActivity shoppingCartBargainActivity = (ShoppingCartBargainActivity) context;
            this.O00000o0 = shoppingCartBargainActivity.shoppingCartBargainModel.bargainList;
            this.O00000o = shoppingCartBargainActivity.mCartChooseBargainListAdapter;
        }

        public final void onClick(View view) {
            ccr.O00000Oo("CartChooseBargainListAdapter", "clicked:" + this.f4734O000000o.bargainName);
            if (this.O00000o0 != null && this.O00000o != null) {
                for (int i = 0; i < this.O00000o0.size(); i++) {
                    if (this.f4734O000000o.bargainName.equalsIgnoreCase(this.O00000o0.get(i).bargainName)) {
                        this.O00000o0.get(i).Selected = Boolean.TRUE;
                    } else {
                        this.O00000o0.get(i).Selected = Boolean.FALSE;
                    }
                }
                this.O00000o.notifyDataSetChanged();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cart_choosebargainitem, (ViewGroup) null, false);
        this.O00000Oo = new O00000Oo();
        O00000Oo o00000Oo = this.O00000Oo;
        o00000Oo.f4735O000000o = inflate;
        o00000Oo.O00000oO = (CustomTextView) inflate.findViewById(R.id.item_compatible);
        this.O00000Oo.O00000oo = (CustomTextView) inflate.findViewById(R.id.item_price);
        this.O00000Oo.O00000o = (CustomTextView) inflate.findViewById(R.id.item_title);
        this.O00000Oo.O00000Oo = (ImageView) inflate.findViewById(R.id.item_select);
        this.O00000Oo.O00000o0 = (SimpleDraweeView) inflate.findViewById(R.id.item_bargainimage);
        this.O00000Oo.O0000O0o = (LinearLayout) inflate.findViewById(R.id.item_all);
        inflate.setTag(this.O00000Oo);
        return inflate;
    }
}
