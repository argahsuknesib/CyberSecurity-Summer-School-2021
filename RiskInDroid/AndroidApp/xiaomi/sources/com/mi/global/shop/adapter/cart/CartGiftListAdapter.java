package com.mi.global.shop.adapter.cart;

import _m_j.cad;
import _m_j.cav;
import _m_j.cbb;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cdy;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.cart.NewCartGiftItem;
import com.mi.global.shop.newmodel.cart.NewCartSelectInfo;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class CartGiftListAdapter extends ArrayAdapter<NewCartGiftItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4761O000000o;
    O00000o0 O00000Oo;

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewCartGiftItem newCartGiftItem = (NewCartGiftItem) obj;
        ccr.O00000Oo("CartItemListAdapter", "Giftitem bindview");
        O00000o0 o00000o0 = (O00000o0) view.getTag();
        int O000000o2 = cdy.O000000o(50.0f);
        String str = newCartGiftItem.image_url;
        if (!TextUtils.isEmpty(str)) {
            str = cbb.O000000o(O000000o2, O000000o2, str);
        }
        cbq.O000000o(str, o00000o0.O00000Oo);
        o00000o0.O00000o.setText(newCartGiftItem.product_name);
        CustomTextView customTextView = o00000o0.O00000oo;
        customTextView.setText("X" + newCartGiftItem.num);
        if (TextUtils.isEmpty(newCartGiftItem.activity_name)) {
            o00000o0.O00000o0.setVisibility(8);
        } else {
            o00000o0.O00000o0.setVisibility(0);
            o00000o0.O00000o0.setText(newCartGiftItem.activity_name);
        }
        CustomTextView customTextView2 = o00000o0.O00000oO;
        customTextView2.setText(cad.O00000o0() + newCartGiftItem.salePrice_txt);
        if (newCartGiftItem.selecInfo == null || newCartGiftItem.selecInfo.size() <= 1) {
            o00000o0.O0000O0o.setVisibility(8);
        } else {
            o00000o0.O0000O0o.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < newCartGiftItem.selecInfo.size(); i2++) {
                if (newCartGiftItem.selecInfo.get(i2).product_name.equalsIgnoreCase(newCartGiftItem.product_name)) {
                    arrayList.add(newCartGiftItem.selecInfo.get(i2).style_value);
                }
            }
            for (int i3 = 0; i3 < newCartGiftItem.selecInfo.size(); i3++) {
                if (!newCartGiftItem.selecInfo.get(i3).is_cos && !newCartGiftItem.selecInfo.get(i3).product_name.equalsIgnoreCase(newCartGiftItem.product_name)) {
                    arrayList.add(newCartGiftItem.selecInfo.get(i3).style_value);
                }
            }
            o00000o0.O0000O0o.setAdapter((SpinnerAdapter) new android.widget.ArrayAdapter(this.f4761O000000o, (int) R.layout.shop_cart_gift_spinneritem, arrayList));
            o00000o0.O0000O0o.setOnItemSelectedListener(new O00000Oo(newCartGiftItem, this.f4761O000000o, o00000o0));
            o00000o0.O0000O0o.setSelection(0);
        }
        o00000o0.O00000Oo.setOnClickListener(new O000000o(newCartGiftItem, this.f4761O000000o));
    }

    public CartGiftListAdapter(Context context) {
        super(context);
        this.f4761O000000o = context;
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4764O000000o;
        SimpleDraweeView O00000Oo;
        CustomTextView O00000o;
        CustomTextView O00000o0;
        CustomTextView O00000oO;
        CustomTextView O00000oo;
        Spinner O0000O0o;

        O00000o0() {
        }
    }

    class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        NewCartGiftItem f4762O000000o;
        Context O00000Oo;

        public O000000o(NewCartGiftItem newCartGiftItem, Context context) {
            this.f4762O000000o = newCartGiftItem;
            this.O00000Oo = context;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
        public final void onClick(View view) {
            if (view.getId() == R.id.gift_image && !TextUtils.isEmpty(this.f4762O000000o.commodity_id)) {
                String O00000o = cav.O00000o(this.f4762O000000o.commodity_id);
                Intent intent = new Intent(this.O00000Oo, WebActivity.class);
                intent.putExtra("url", O00000o);
                intent.putExtra("cart_webview", true);
                ((ShoppingCartActivity) this.O00000Oo).startActivityForResult(intent, 23);
            }
        }
    }

    class O00000Oo implements AdapterView.OnItemSelectedListener {

        /* renamed from: O000000o  reason: collision with root package name */
        NewCartGiftItem f4763O000000o;
        Context O00000Oo;
        O00000o0 O00000o0;

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        public O00000Oo(NewCartGiftItem newCartGiftItem, Context context, O00000o0 o00000o0) {
            this.f4763O000000o = newCartGiftItem;
            this.O00000Oo = context;
            this.O00000o0 = o00000o0;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            String str;
            StringBuilder sb = new StringBuilder("item selected:");
            CustomTextView customTextView = (CustomTextView) view;
            sb.append((Object) customTextView.getText());
            ccr.O00000Oo("CartItemListAdapter", sb.toString());
            String charSequence = customTextView.getText().toString();
            int i2 = 0;
            while (i2 < this.f4763O000000o.selecInfo.size()) {
                if (!this.f4763O000000o.selecInfo.get(i2).style_value.equalsIgnoreCase(charSequence) || !this.f4763O000000o.selecInfo.get(i2).product_name.equalsIgnoreCase(this.f4763O000000o.product_name)) {
                    i2++;
                } else {
                    return;
                }
            }
            ccr.O00000Oo("CartItemListAdapter", "item selected:" + ((Object) customTextView.getText()) + "updateview");
            NewCartSelectInfo newCartSelectInfo = null;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f4763O000000o.selecInfo.size()) {
                    str = "";
                    break;
                } else if (charSequence.equalsIgnoreCase(this.f4763O000000o.selecInfo.get(i3).style_value)) {
                    newCartSelectInfo = this.f4763O000000o.selecInfo.get(i3);
                    str = this.f4763O000000o.selecInfo.get(i3).product_id + "-0-1-" + this.f4763O000000o.actId + "-2";
                    break;
                } else {
                    i3++;
                }
            }
            if (!TextUtils.isEmpty(str) && newCartSelectInfo != null) {
                ((ShoppingCartActivity) this.O00000Oo).addCartRequest(str, false);
                ((ShoppingCartActivity) this.O00000Oo).chooseGift(this.f4763O000000o, newCartSelectInfo);
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
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cart_list_gift_item, (ViewGroup) null, false);
        this.O00000Oo = new O00000o0();
        O00000o0 o00000o0 = this.O00000Oo;
        o00000o0.f4764O000000o = inflate;
        o00000o0.O00000Oo = (SimpleDraweeView) inflate.findViewById(R.id.gift_image);
        this.O00000Oo.O00000o0 = (CustomTextView) inflate.findViewById(R.id.gift_type);
        this.O00000Oo.O00000o = (CustomTextView) inflate.findViewById(R.id.gift_title);
        this.O00000Oo.O00000oO = (CustomTextView) inflate.findViewById(R.id.gift_price);
        this.O00000Oo.O00000oo = (CustomTextView) inflate.findViewById(R.id.gift_num);
        this.O00000Oo.O0000O0o = (Spinner) inflate.findViewById(R.id.gift_selection);
        inflate.setTag(this.O00000Oo);
        return inflate;
    }
}
