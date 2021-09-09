package com.mi.global.shop.adapter.cart;

import _m_j.cbb;
import _m_j.cbq;
import _m_j.cdy;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.cart.NewCartItem;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class CartInvalidItemListAdapter extends ArrayAdapter<NewCartItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4765O000000o = "CartInvalidItemListAdapter";

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4767O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4767O000000o = viewHolder;
            viewHolder.item_image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.item_image, "field 'item_image'", SimpleDraweeView.class);
            viewHolder.item_title = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_title, "field 'item_title'", CustomTextView.class);
            viewHolder.item_num = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_num, "field 'item_num'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4767O000000o;
            if (viewHolder != null) {
                this.f4767O000000o = null;
                viewHolder.item_image = null;
                viewHolder.item_title = null;
                viewHolder.item_num = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewCartItem newCartItem = (NewCartItem) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        int O000000o2 = cdy.O000000o(40.0f);
        int O000000o3 = cdy.O000000o(40.0f);
        String str = newCartItem.image_url;
        if (!TextUtils.isEmpty(str)) {
            str = cbb.O000000o(O000000o2, O000000o3, str);
        }
        cbq.O000000o(str, viewHolder.item_image);
        viewHolder.item_title.setText(newCartItem.product_name);
        CustomTextView customTextView = viewHolder.item_num;
        customTextView.setText("X" + newCartItem.num);
    }

    public CartInvalidItemListAdapter(Context context) {
        super(context);
    }

    static class ViewHolder {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4766O000000o;
        @BindView(2131493513)
        SimpleDraweeView item_image;
        @BindView(2131493518)
        CustomTextView item_num;
        @BindView(2131493523)
        CustomTextView item_title;

        public ViewHolder(View view) {
            view.setTag(this);
            this.f4766O000000o = view;
            ButterKnife.bind(this, view);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cart_list_invalid_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
