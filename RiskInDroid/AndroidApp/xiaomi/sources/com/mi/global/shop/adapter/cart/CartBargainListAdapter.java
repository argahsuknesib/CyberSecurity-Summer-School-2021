package com.mi.global.shop.adapter.cart;

import _m_j.byl;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.mi.global.shop.activity.ShoppingCartBargainActivity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.cart.NewCartBargainItem;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CartBargainListAdapter extends ArrayAdapter<NewCartBargainItem> {
    static long O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4758O000000o;
    O00000Oo O00000Oo;

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewCartBargainItem newCartBargainItem = (NewCartBargainItem) obj;
        O00000Oo o00000Oo = (O00000Oo) view.getTag();
        o00000Oo.O00000o0.setText(newCartBargainItem.bargain_name);
        if (newCartBargainItem.checked) {
            o00000Oo.O00000Oo.setImageDrawable(byl.O00000oO().getResources().getDrawable(R.drawable.shop_bargain_box_checked));
            o00000Oo.O00000oO.setVisibility(0);
        } else {
            o00000Oo.O00000Oo.setImageDrawable(byl.O00000oO().getResources().getDrawable(R.drawable.shop_bargain_box));
            o00000Oo.O00000oO.setVisibility(8);
        }
        o00000Oo.O00000o.setOnClickListener(new O000000o(newCartBargainItem, this.O00000o));
    }

    public CartBargainListAdapter(Context context) {
        super(context);
        this.f4758O000000o = context;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4760O000000o;
        ImageView O00000Oo;
        LinearLayout O00000o;
        CustomTextView O00000o0;
        CustomTextView O00000oO;

        O00000Oo() {
        }
    }

    class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        NewCartBargainItem f4759O000000o;
        Context O00000Oo;

        public O000000o(NewCartBargainItem newCartBargainItem, Context context) {
            this.f4759O000000o = newCartBargainItem;
            this.O00000Oo = context;
        }

        public final void onClick(View view) {
            if (view.getId() != R.id.bargain_all) {
                return;
            }
            if (CartBargainListAdapter.O00000o0 == 0 || System.currentTimeMillis() - CartBargainListAdapter.O00000o0 > 4000) {
                CartBargainListAdapter.O00000o0 = System.currentTimeMillis();
                if (!this.f4759O000000o.checked && this.f4759O000000o.selectable) {
                    Intent intent = new Intent(this.O00000Oo, ShoppingCartBargainActivity.class);
                    intent.putExtra("cart_bargain", this.f4759O000000o.json_data);
                    ((ShoppingCartActivity) this.O00000Oo).startActivityForResult(intent, 20);
                } else if (this.f4759O000000o.checked || this.f4759O000000o.selectable) {
                    String barginItembyId = ((ShoppingCartActivity) this.O00000Oo).getBarginItembyId(this.f4759O000000o.bargainItemId);
                    if (!TextUtils.isEmpty(barginItembyId)) {
                        if (this.f4759O000000o.checked && !this.f4759O000000o.selectable) {
                            ((ShoppingCartActivity) this.O00000Oo).delCartRequest(barginItembyId);
                        } else if (this.f4759O000000o.checked && this.f4759O000000o.selectable) {
                            ((ShoppingCartActivity) this.O00000Oo).delCartRequest(barginItembyId);
                            Intent intent2 = new Intent(this.O00000Oo, ShoppingCartBargainActivity.class);
                            intent2.putExtra("cart_bargain", this.f4759O000000o.json_data);
                            ((ShoppingCartActivity) this.O00000Oo).startActivityForResult(intent2, 20);
                        }
                    }
                } else {
                    ((ShoppingCartActivity) this.O00000Oo).addCartRequest(this.f4759O000000o.bargainGoodsId, true);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cart_bargainitem, viewGroup, false);
        this.O00000Oo = new O00000Oo();
        O00000Oo o00000Oo = this.O00000Oo;
        o00000Oo.f4760O000000o = inflate;
        o00000Oo.O00000o0 = (CustomTextView) inflate.findViewById(R.id.bargain_title);
        this.O00000Oo.O00000Oo = (ImageView) inflate.findViewById(R.id.bargain_box);
        this.O00000Oo.O00000o = (LinearLayout) inflate.findViewById(R.id.bargain_all);
        this.O00000Oo.O00000oO = (CustomTextView) inflate.findViewById(R.id.change);
        O00000o0 = 0;
        inflate.setTag(this.O00000Oo);
        return inflate;
    }
}
