package com.mi.global.shop.adapter.home;

import _m_j.cbb;
import _m_j.cbj;
import _m_j.cbq;
import _m_j.ccd;
import _m_j.ccr;
import _m_j.cef;
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
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EasyTextView;
import com.xiaomi.smarthome.R;

public class HomeGridAdapter extends ArrayAdapter<NewHomeBlockInfoItem> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4784O000000o = "HomeGridAdapter";
    private Context O00000Oo;

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4786O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4786O000000o = viewHolder;
            viewHolder.image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.home_product_item_image, "field 'image'", SimpleDraweeView.class);
            viewHolder.name = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.home_product_item_name, "field 'name'", CustomTextView.class);
            viewHolder.price = (EasyTextView) Utils.findRequiredViewAsType(view, R.id.home_product_item_price, "field 'price'", EasyTextView.class);
            viewHolder.iconImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.icon_image, "field 'iconImage'", SimpleDraweeView.class);
            viewHolder.iconText = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.icon_text, "field 'iconText'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4786O000000o;
            if (viewHolder != null) {
                this.f4786O000000o = null;
                viewHolder.image = null;
                viewHolder.name = null;
                viewHolder.price = null;
                viewHolder.iconImage = null;
                viewHolder.iconText = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final NewHomeBlockInfoItem newHomeBlockInfoItem = (NewHomeBlockInfoItem) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (newHomeBlockInfoItem != null) {
            int i2 = cef.O000000o().f13684O000000o / 2;
            String imageUrl = newHomeBlockInfoItem.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                imageUrl = cbb.O000000o(i2, 99999, newHomeBlockInfoItem.getImageUrl());
            }
            ccr.O00000Oo(f4784O000000o, "image url=".concat(String.valueOf(imageUrl)));
            cbq.O000000o(imageUrl, viewHolder.image);
            viewHolder.name.setText(newHomeBlockInfoItem.mProductName);
            viewHolder.price.setPrize(newHomeBlockInfoItem);
            if (TextUtils.isEmpty(newHomeBlockInfoItem.mIconImg)) {
                viewHolder.iconImage.setVisibility(8);
            } else {
                viewHolder.iconImage.setVisibility(0);
                cbq.O000000o(newHomeBlockInfoItem.mIconImg, viewHolder.iconImage);
            }
            if (TextUtils.isEmpty(newHomeBlockInfoItem.mIconContent)) {
                viewHolder.iconText.setVisibility(8);
            } else {
                viewHolder.iconText.setVisibility(0);
                viewHolder.iconText.setText(newHomeBlockInfoItem.mIconContent);
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.adapter.home.HomeGridAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                HomeGridAdapter homeGridAdapter = HomeGridAdapter.this;
                ccd.O000000o(homeGridAdapter.O00000o, newHomeBlockInfoItem);
            }
        });
        ccd.O000000o(newHomeBlockInfoItem);
    }

    public HomeGridAdapter(Context context) {
        super(context);
        this.O00000Oo = context;
    }

    static class ViewHolder {
        @BindView(2131493439)
        SimpleDraweeView iconImage;
        @BindView(2131493443)
        CustomTextView iconText;
        @BindView(2131493420)
        SimpleDraweeView image;
        @BindView(2131493421)
        CustomTextView name;
        @BindView(2131493422)
        EasyTextView price;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            this.image.getLayoutParams().width = cbj.O000000o.f13594O000000o.O00000o0(13);
            this.image.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(14);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_home_hot_product_item_view, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
