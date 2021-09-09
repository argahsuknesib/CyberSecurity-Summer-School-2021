package com.mi.global.shop.adapter;

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
import com.mi.global.shop.newmodel.order.NewListProduct;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class OrderItemListAdapter extends ArrayAdapter<NewListProduct> {

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4740O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4740O000000o = viewHolder;
            viewHolder.image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.image, "field 'image'", SimpleDraweeView.class);
            viewHolder.name = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'name'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4740O000000o;
            if (viewHolder != null) {
                this.f4740O000000o = null;
                viewHolder.image = null;
                viewHolder.name = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        NewListProduct newListProduct = (NewListProduct) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        int O000000o2 = cdy.O000000o(50.0f);
        int O000000o3 = cdy.O000000o(50.0f);
        String str = newListProduct.image_url;
        if (!TextUtils.isEmpty(str)) {
            cbq.O000000o(cbb.O000000o(O000000o2, O000000o3, str), viewHolder.image);
        }
        viewHolder.name.setText(newListProduct.product_name);
    }

    public OrderItemListAdapter(Context context) {
        super(context);
    }

    static class ViewHolder {
        @BindView(2131493452)
        SimpleDraweeView image;
        @BindView(2131493728)
        CustomTextView name;

        public ViewHolder(View view) {
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
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_order_item_product_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
