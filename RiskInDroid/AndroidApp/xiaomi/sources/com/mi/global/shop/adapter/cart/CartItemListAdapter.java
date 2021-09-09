package com.mi.global.shop.adapter.cart;

import _m_j.byl;
import _m_j.cad;
import _m_j.cav;
import _m_j.cbb;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cdy;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.mi.global.shop.activity.ShoppingCartInsuranceActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.cart.NewCartItem;
import com.mi.global.shop.widget.AddAndSubView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EasyTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class CartItemListAdapter extends ArrayAdapter<NewCartItem> {
    public int getViewTypeCount() {
        return 2;
    }

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4771O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4771O000000o = viewHolder;
            viewHolder.item_del = (ImageView) Utils.findRequiredViewAsType(view, R.id.item_del, "field 'item_del'", ImageView.class);
            viewHolder.item_image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.item_image, "field 'item_image'", SimpleDraweeView.class);
            viewHolder.item_type = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_type, "field 'item_type'", CustomTextView.class);
            viewHolder.item_title = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_title, "field 'item_title'", CustomTextView.class);
            viewHolder.item_price = (EasyTextView) Utils.findRequiredViewAsType(view, R.id.item_price, "field 'item_price'", EasyTextView.class);
            viewHolder.item_limit = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_limit, "field 'item_limit'", CustomTextView.class);
            viewHolder.item_warning = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_warning, "field 'item_warning'", CustomTextView.class);
            viewHolder.item_dealer = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_dealer, "field 'item_dealer'", CustomTextView.class);
            viewHolder.item_warning_layout = Utils.findRequiredView(view, R.id.item_warning_layout, "field 'item_warning_layout'");
            viewHolder.item_mask = Utils.findRequiredView(view, R.id.item_mask, "field 'item_mask'");
            viewHolder.item_num = (AddAndSubView) Utils.findRequiredViewAsType(view, R.id.item_num, "field 'item_num'", AddAndSubView.class);
            viewHolder.insurance_layout = Utils.findRequiredView(view, R.id.insurance_layout, "field 'insurance_layout'");
            viewHolder.insurance_buy_layout = Utils.findRequiredView(view, R.id.insurance_buy_layout, "field 'insurance_buy_layout'");
            viewHolder.insurance_image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.insurance_image, "field 'insurance_image'", SimpleDraweeView.class);
            viewHolder.insurance_info = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_info, "field 'insurance_info'", CustomTextView.class);
            viewHolder.insurance_price = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_price, "field 'insurance_price'", CustomTextView.class);
            viewHolder.insurance_market_price = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_market_price, "field 'insurance_market_price'", CustomTextView.class);
            viewHolder.insurance_buy_btn = (ImageButton) Utils.findRequiredViewAsType(view, R.id.insurance_buy_btn, "field 'insurance_buy_btn'", ImageButton.class);
            viewHolder.insurance_item_layout = Utils.findRequiredView(view, R.id.insurance_item_layout, "field 'insurance_item_layout'");
            viewHolder.insurance_item_image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.insurance_item_image, "field 'insurance_item_image'", SimpleDraweeView.class);
            viewHolder.insurance_item_del = (ImageView) Utils.findRequiredViewAsType(view, R.id.insurance_item_del, "field 'insurance_item_del'", ImageView.class);
            viewHolder.insurance_item_title = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_item_title, "field 'insurance_item_title'", CustomTextView.class);
            viewHolder.insurance_item_price = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_item_price, "field 'insurance_item_price'", CustomTextView.class);
            viewHolder.insurance_item_dealer = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_item_dealer, "field 'insurance_item_dealer'", CustomTextView.class);
            viewHolder.insurance_item_num = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.insurance_item_num, "field 'insurance_item_num'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4771O000000o;
            if (viewHolder != null) {
                this.f4771O000000o = null;
                viewHolder.item_del = null;
                viewHolder.item_image = null;
                viewHolder.item_type = null;
                viewHolder.item_title = null;
                viewHolder.item_price = null;
                viewHolder.item_limit = null;
                viewHolder.item_warning = null;
                viewHolder.item_dealer = null;
                viewHolder.item_warning_layout = null;
                viewHolder.item_mask = null;
                viewHolder.item_num = null;
                viewHolder.insurance_layout = null;
                viewHolder.insurance_buy_layout = null;
                viewHolder.insurance_image = null;
                viewHolder.insurance_info = null;
                viewHolder.insurance_price = null;
                viewHolder.insurance_market_price = null;
                viewHolder.insurance_buy_btn = null;
                viewHolder.insurance_item_layout = null;
                viewHolder.insurance_item_image = null;
                viewHolder.insurance_item_del = null;
                viewHolder.insurance_item_title = null;
                viewHolder.insurance_item_price = null;
                viewHolder.insurance_item_dealer = null;
                viewHolder.insurance_item_num = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewCartItem newCartItem = (NewCartItem) obj;
        O00000Oo o00000Oo = new O00000Oo(newCartItem, this.O00000o);
        O000000o o000000o = new O000000o(newCartItem, this.O00000o);
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        int O000000o2 = cdy.O000000o(90.0f);
        int O000000o3 = cdy.O000000o(90.0f);
        String str = newCartItem.image_url;
        if (!TextUtils.isEmpty(str)) {
            str = cbb.O000000o(O000000o2, O000000o3, str);
        }
        cbq.O000000o(str, viewHolder.item_image);
        newCartItem.timeout = false;
        if (newCartItem.item_timeout) {
            newCartItem.timeout = true;
        }
        viewHolder.item_title.setText(newCartItem.product_name);
        if (TextUtils.isEmpty(newCartItem.item_type_name)) {
            viewHolder.item_type.setVisibility(8);
        } else {
            viewHolder.item_type.setText(newCartItem.item_type_name);
            viewHolder.item_type.setVisibility(0);
        }
        if (TextUtils.isEmpty(newCartItem.goods_dealer)) {
            viewHolder.item_dealer.setVisibility(8);
        } else {
            viewHolder.item_dealer.setText(String.format(byl.O00000oO().getString(R.string.goods_dealer), newCartItem.goods_dealer));
        }
        viewHolder.item_price.setPrize(newCartItem);
        if (newCartItem.getType.equalsIgnoreCase("seckill") || newCartItem.buy_limit == 1 || newCartItem.getType.equalsIgnoreCase("fcode")) {
            viewHolder.item_limit.setText(String.format(byl.O00000oO().getString(R.string.cart_limt), String.valueOf(newCartItem.num)));
            viewHolder.item_limit.setVisibility(0);
            viewHolder.item_num.setVisibility(8);
        } else if (newCartItem.is_cos || newCartItem.timeout || newCartItem.getType.equalsIgnoreCase("insurance")) {
            viewHolder.item_num.setVisibility(8);
            viewHolder.item_limit.setVisibility(8);
        } else {
            viewHolder.item_num.setVisibility(0);
            viewHolder.item_limit.setVisibility(8);
            viewHolder.item_num.setMax(newCartItem.buy_limit);
            viewHolder.item_num.setMin(1);
            viewHolder.item_num.setNum(newCartItem.num);
            viewHolder.item_num.setOnNumChangeListener(o00000Oo);
        }
        if (newCartItem.timeout) {
            viewHolder.item_warning_layout.setVisibility(0);
            viewHolder.item_warning.setText(byl.O00000oO().getString(R.string.cart_timeout));
            O000000o(viewHolder, Boolean.TRUE);
        } else if (newCartItem.is_cos) {
            viewHolder.item_warning_layout.setVisibility(0);
            viewHolder.item_warning.setText(byl.O00000oO().getString(R.string.cart_iscos));
            O000000o(viewHolder, Boolean.TRUE);
        } else if (newCartItem.showType.equalsIgnoreCase("bigtap")) {
            viewHolder.item_warning_layout.setVisibility(0);
            viewHolder.item_warning.setText(String.format(byl.O00000oO().getString(R.string.cart_bigtapwarning), cad.O000000o(Long.valueOf(newCartItem.cartTTL * 1000))));
            O000000o(viewHolder, Boolean.FALSE);
        } else {
            viewHolder.item_warning_layout.setVisibility(8);
            O000000o(viewHolder, Boolean.FALSE);
        }
        if (newCartItem.properties == null || newCartItem.properties.insurance == null) {
            viewHolder.insurance_layout.setVisibility(8);
        } else {
            viewHolder.insurance_layout.setVisibility(0);
            if (TextUtils.isEmpty(newCartItem.properties.insurance.itemId)) {
                viewHolder.insurance_buy_layout.setVisibility(0);
                viewHolder.insurance_item_layout.setVisibility(8);
                String str2 = newCartItem.properties.insurance.img_insurance;
                if (!TextUtils.isEmpty(str2)) {
                    str2 = cbb.O000000o(cdy.O000000o(this.O00000o, 30.0f), cdy.O000000o(this.O00000o, 30.0f), str2);
                }
                cbq.O000000o(str2, viewHolder.insurance_image);
                viewHolder.insurance_price.setText(Html.fromHtml(String.format("<font color=\"#ff6600\">%s</font>", cad.O00000o0() + " " + newCartItem.properties.insurance.price + "(" + newCartItem.properties.insurance.validperiod + ")")));
                if (TextUtils.isEmpty(newCartItem.properties.insurance.market_price) || newCartItem.properties.insurance.market_price.equals(newCartItem.properties.insurance.price)) {
                    viewHolder.insurance_market_price.setVisibility(8);
                } else {
                    viewHolder.insurance_market_price.setVisibility(0);
                    CustomTextView customTextView = viewHolder.insurance_market_price;
                    customTextView.setText(cad.O00000o0() + " " + newCartItem.properties.insurance.market_price);
                    viewHolder.insurance_market_price.getPaint().setFlags(16);
                }
                viewHolder.insurance_info.setText(newCartItem.properties.insurance.insurance_desc);
                viewHolder.insurance_buy_btn.setOnClickListener(o000000o);
            } else {
                viewHolder.insurance_buy_layout.setVisibility(8);
                viewHolder.insurance_item_layout.setVisibility(0);
                String str3 = newCartItem.properties.insurance.image_url;
                if (!TextUtils.isEmpty(str3)) {
                    str3 = cbb.O000000o(O000000o2, O000000o3, str3);
                }
                cbq.O000000o(str3, viewHolder.insurance_item_image);
                viewHolder.insurance_item_title.setText(newCartItem.properties.insurance.product_name);
                viewHolder.insurance_item_dealer.setText(String.format(byl.O00000oO().getString(R.string.goods_dealer), newCartItem.properties.insurance.goods_dealer));
                CustomTextView customTextView2 = viewHolder.insurance_item_price;
                customTextView2.setText(cad.O00000o0() + newCartItem.properties.insurance.price);
                CustomTextView customTextView3 = viewHolder.insurance_item_num;
                customTextView3.setText("X" + newCartItem.properties.insurance.num);
                viewHolder.insurance_item_del.setOnClickListener(o000000o);
            }
        }
        viewHolder.item_del.setOnClickListener(o000000o);
        viewHolder.item_image.setOnClickListener(o000000o);
    }

    public CartItemListAdapter(Context context) {
        super(context);
    }

    public final void O000000o(ArrayList<NewCartItem> arrayList) {
        if (arrayList != null) {
            this.O00000oo = true;
            Iterator<NewCartItem> it = arrayList.iterator();
            while (it.hasNext()) {
                NewCartItem next = it.next();
                if (next != null && !next.isInsurance) {
                    this.O00000oO.add(next);
                }
            }
            notifyDataSetChanged();
            return;
        }
        this.O00000oo = false;
        notifyDataSetInvalidated();
    }

    private static void O000000o(ViewHolder viewHolder, Boolean bool) {
        if (bool.booleanValue()) {
            viewHolder.item_num.setEnable(Boolean.FALSE);
            viewHolder.item_mask.setVisibility(0);
            return;
        }
        viewHolder.item_num.setEnable(Boolean.TRUE);
        viewHolder.item_mask.setVisibility(8);
    }

    public int getItemViewType(int i) {
        return (((NewCartItem) this.O00000oO.get(i)).properties == null || ((NewCartItem) this.O00000oO.get(i)).properties.insurance == null || TextUtils.isEmpty(((NewCartItem) this.O00000oO.get(i)).properties.insurance.itemId)) ? 0 : 1;
    }

    static class ViewHolder {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4770O000000o;
        @BindView(2131493480)
        ImageButton insurance_buy_btn;
        @BindView(2131493481)
        View insurance_buy_layout;
        @BindView(2131493486)
        SimpleDraweeView insurance_image;
        @BindView(2131493487)
        CustomTextView insurance_info;
        @BindView(2131493488)
        CustomTextView insurance_item_dealer;
        @BindView(2131493489)
        ImageView insurance_item_del;
        @BindView(2131493490)
        SimpleDraweeView insurance_item_image;
        @BindView(2131493491)
        View insurance_item_layout;
        @BindView(2131493492)
        CustomTextView insurance_item_num;
        @BindView(2131493493)
        CustomTextView insurance_item_price;
        @BindView(2131493494)
        CustomTextView insurance_item_title;
        @BindView(2131493495)
        View insurance_layout;
        @BindView(2131493496)
        CustomTextView insurance_market_price;
        @BindView(2131493499)
        CustomTextView insurance_price;
        @BindView(2131493509)
        CustomTextView item_dealer;
        @BindView(2131493510)
        ImageView item_del;
        @BindView(2131493513)
        SimpleDraweeView item_image;
        @BindView(2131493514)
        CustomTextView item_limit;
        @BindView(2131493516)
        View item_mask;
        @BindView(2131493518)
        AddAndSubView item_num;
        @BindView(2131493519)
        EasyTextView item_price;
        @BindView(2131493523)
        CustomTextView item_title;
        @BindView(2131493525)
        CustomTextView item_type;
        @BindView(2131493526)
        CustomTextView item_warning;
        @BindView(2131493527)
        View item_warning_layout;

        public ViewHolder(View view) {
            view.setTag(this);
            this.f4770O000000o = view;
            ButterKnife.bind(this, view);
        }
    }

    class O00000Oo implements AddAndSubView.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        NewCartItem f4769O000000o;
        Context O00000Oo;

        public O00000Oo(NewCartItem newCartItem, Context context) {
            this.f4769O000000o = newCartItem;
            this.O00000Oo = context;
        }

        public final void O000000o(int i) {
            ccr.O00000Oo("CartItemListAdapter", "item:" + this.f4769O000000o.product_name + " num:" + i);
            ((ShoppingCartActivity) this.O00000Oo).updateCartRequest(this.f4769O000000o.itemId, i);
        }
    }

    class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        NewCartItem f4768O000000o;
        Context O00000Oo;

        public O000000o(NewCartItem newCartItem, Context context) {
            this.f4768O000000o = newCartItem;
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
            if (view.getId() == R.id.item_del) {
                ccr.O00000Oo("CartItemListAdapter", "del item:" + this.f4768O000000o.product_name);
                ((ShoppingCartActivity) this.O00000Oo).delItemDialog(this.f4768O000000o.itemId);
            }
            if (view.getId() == R.id.insurance_item_del) {
                ccr.O00000Oo("CartItemListAdapter", "del item:" + this.f4768O000000o.product_name);
                if (!(this.f4768O000000o.properties == null || this.f4768O000000o.properties.insurance == null || TextUtils.isEmpty(this.f4768O000000o.properties.insurance.itemId))) {
                    ((ShoppingCartActivity) this.O00000Oo).delItemDialog(this.f4768O000000o.properties.insurance.itemId);
                }
            }
            if (view.getId() == R.id.insurance_buy_btn) {
                ccr.O00000Oo("CartItemListAdapter", "buy item:" + this.f4768O000000o.product_name);
                Intent intent = new Intent(this.O00000Oo, ShoppingCartInsuranceActivity.class);
                intent.putExtra("cart_insurance_parentid", this.f4768O000000o.itemId);
                intent.putExtra("cart_insurance_goodsid", this.f4768O000000o.properties.insurance.goods_id);
                ((ShoppingCartActivity) this.O00000Oo).startActivityForResult(intent, 21);
            }
            if (view.getId() == R.id.item_image && !TextUtils.isEmpty(this.f4768O000000o.commodity_id)) {
                Intent intent2 = new Intent(this.O00000Oo, WebActivity.class);
                if (TextUtils.isEmpty(this.f4768O000000o.jump_url)) {
                    intent2.putExtra("url", cav.O00000o(this.f4768O000000o.commodity_id));
                } else {
                    intent2.putExtra("url", this.f4768O000000o.jump_url);
                }
                intent2.putExtra("cart_webview", true);
                ((ShoppingCartActivity) this.O00000Oo).startActivityForResult(intent2, 23);
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
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cart_list_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
