package com.mi.global.shop.adapter.home;

import _m_j.cbq;
import _m_j.ccd;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class HomePhoneListAdapter extends RecyclerView.O000000o<ProductViewHolder> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4814O000000o;
    List<NewHomeBlockInfoItem> O00000Oo = new ArrayList();

    public class ProductViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ProductViewHolder f4816O000000o;

        public ProductViewHolder_ViewBinding(ProductViewHolder productViewHolder, View view) {
            this.f4816O000000o = productViewHolder;
            productViewHolder.productName = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.product_name, "field 'productName'", CustomTextView.class);
            productViewHolder.productImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.product_image, "field 'productImage'", SimpleDraweeView.class);
        }

        public void unbind() {
            ProductViewHolder productViewHolder = this.f4816O000000o;
            if (productViewHolder != null) {
                this.f4816O000000o = null;
                productViewHolder.productName = null;
                productViewHolder.productImage = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ProductViewHolder productViewHolder = (ProductViewHolder) o000OOo0;
        final NewHomeBlockInfoItem newHomeBlockInfoItem = this.O00000Oo.get(i);
        productViewHolder.productName.setText(newHomeBlockInfoItem.mProductName);
        productViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.adapter.home.HomePhoneListAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                ccd.O000000o(HomePhoneListAdapter.this.f4814O000000o, newHomeBlockInfoItem);
            }
        });
        ccd.O000000o(newHomeBlockInfoItem);
        String imageUrl = newHomeBlockInfoItem.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl) && !imageUrl.equals(productViewHolder.productImage.getTag())) {
            productViewHolder.productImage.setTag(imageUrl);
            cbq.O000000o(imageUrl, productViewHolder.productImage);
        }
    }

    public HomePhoneListAdapter(Context context) {
        this.f4814O000000o = context;
    }

    public int getItemCount() {
        return this.O00000Oo.size();
    }

    static class ProductViewHolder extends RecyclerView.O000OOo0 {
        @BindView(2131493887)
        SimpleDraweeView productImage;
        @BindView(2131493893)
        CustomTextView productName;

        ProductViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProductViewHolder(LayoutInflater.from(this.f4814O000000o).inflate((int) R.layout.shop_phone_list_item, viewGroup, false));
    }
}
