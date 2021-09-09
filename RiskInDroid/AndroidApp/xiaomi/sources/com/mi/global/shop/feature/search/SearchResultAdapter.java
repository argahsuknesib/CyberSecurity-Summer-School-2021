package com.mi.global.shop.feature.search;

import _m_j.byp;
import _m_j.duh;
import _m_j.ny;
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
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.base.service.LocaleService;
import com.mi.global.shop.feature.search.newmodel.SearchResult;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.O000000o<ReviewViewHolder> {
    private Context context;
    private List<SearchResult.CommodityDetailBean> data = new ArrayList();
    @Autowired
    LocaleService localeService;

    public class ReviewViewHolder_ViewBinding implements Unbinder {
        private ReviewViewHolder target;

        public ReviewViewHolder_ViewBinding(ReviewViewHolder reviewViewHolder, View view) {
            this.target = reviewViewHolder;
            reviewViewHolder.itemImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.item_image, "field 'itemImage'", SimpleDraweeView.class);
            reviewViewHolder.itemTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_title, "field 'itemTitle'", CustomTextView.class);
            reviewViewHolder.itemPrice = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_price, "field 'itemPrice'", CustomTextView.class);
            reviewViewHolder.itemPriceOrigin = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_price_origin, "field 'itemPriceOrigin'", CustomTextView.class);
        }

        public void unbind() {
            ReviewViewHolder reviewViewHolder = this.target;
            if (reviewViewHolder != null) {
                this.target = null;
                reviewViewHolder.itemImage = null;
                reviewViewHolder.itemTitle = null;
                reviewViewHolder.itemPrice = null;
                reviewViewHolder.itemPriceOrigin = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SearchResultAdapter(Context context2) {
        this.context = context2;
        ny.O000000o();
        ny.O000000o(this);
        if (this.localeService == null) {
            throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
        }
    }

    public void setData(List<SearchResult.CommodityDetailBean> list) {
        if (list != null) {
            this.data.clear();
            this.data.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void addData(ArrayList<SearchResult.CommodityDetailBean> arrayList) {
        if (arrayList != null) {
            this.data.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(ReviewViewHolder reviewViewHolder, int i) {
        final SearchResult.CommodityDetailBean commodityDetailBean = this.data.get(i);
        duh.O000000o().O000000o(commodityDetailBean.image, reviewViewHolder.itemImage);
        reviewViewHolder.itemTitle.setText(commodityDetailBean.name);
        CustomTextView customTextView = reviewViewHolder.itemPrice;
        customTextView.setText(this.localeService.O00000Oo() + commodityDetailBean.price_min);
        if (TextUtils.isEmpty(commodityDetailBean.market_price_max) || commodityDetailBean.price_min.equals(commodityDetailBean.market_price_max)) {
            reviewViewHolder.itemPriceOrigin.setVisibility(8);
        } else {
            reviewViewHolder.itemPriceOrigin.setVisibility(0);
            CustomTextView customTextView2 = reviewViewHolder.itemPriceOrigin;
            customTextView2.setText(this.localeService.O00000Oo() + commodityDetailBean.market_price_max);
            reviewViewHolder.itemPriceOrigin.getPaint().setAntiAlias(true);
            reviewViewHolder.itemPriceOrigin.getPaint().setFlags(16);
        }
        reviewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.feature.search.SearchResultAdapter.AnonymousClass1 */

            public void onClick(View view) {
                if (!TextUtils.isEmpty(commodityDetailBean.item_link)) {
                    ny.O000000o();
                    ny.O000000o("/globalShop/webActivity").withString("url", commodityDetailBean.item_link).navigation();
                    byp.O000000o(String.format("%s_click", commodityDetailBean.name), "search_landing");
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ReviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ReviewViewHolder(LayoutInflater.from(this.context).inflate((int) R.layout.feature_search_search_result__content_item, viewGroup, false));
    }

    public int getItemCount() {
        List<SearchResult.CommodityDetailBean> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    static class ReviewViewHolder extends RecyclerView.O000OOo0 {
        @BindView(2131493102)
        SimpleDraweeView itemImage;
        @BindView(2131493103)
        CustomTextView itemPrice;
        @BindView(2131493104)
        CustomTextView itemPriceOrigin;
        @BindView(2131493105)
        CustomTextView itemTitle;

        ReviewViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
