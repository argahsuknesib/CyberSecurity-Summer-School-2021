package com.mi.global.shop.feature.search;

import _m_j.duh;
import _m_j.ny;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.base.service.LocaleService;
import com.mi.global.shop.feature.search.newmodel.SearchWordResult;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class SearchResultListAdapter extends BaseAdapter {
    private Dialog loadingDialog;
    @Autowired
    LocaleService localeService;
    private Context mContext;
    private ArrayList<SearchWordResult.DataBean> mList;
    private String mWord;

    public class TitleViewHolder_ViewBinding implements Unbinder {
        private TitleViewHolder target;

        public TitleViewHolder_ViewBinding(TitleViewHolder titleViewHolder, View view) {
            this.target = titleViewHolder;
            titleViewHolder.itemTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_title, "field 'itemTitle'", CustomTextView.class);
            titleViewHolder.itemV2 = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_item_v2, "field 'itemV2'", RelativeLayout.class);
            titleViewHolder.itemImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.iv_search_top_image, "field 'itemImage'", SimpleDraweeView.class);
            titleViewHolder.itemTitleV2 = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_top_title, "field 'itemTitleV2'", CustomTextView.class);
            titleViewHolder.itemPrice = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_top_price, "field 'itemPrice'", CustomTextView.class);
            titleViewHolder.itemOldPrice = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_top_old_price, "field 'itemOldPrice'", CustomTextView.class);
        }

        public void unbind() {
            TitleViewHolder titleViewHolder = this.target;
            if (titleViewHolder != null) {
                this.target = null;
                titleViewHolder.itemTitle = null;
                titleViewHolder.itemV2 = null;
                titleViewHolder.itemImage = null;
                titleViewHolder.itemTitleV2 = null;
                titleViewHolder.itemPrice = null;
                titleViewHolder.itemOldPrice = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SearchResultListAdapter(Context context, String str, ArrayList<SearchWordResult.DataBean> arrayList) {
        ny.O000000o();
        ny.O000000o(this);
        if (this.localeService != null) {
            this.mContext = context;
            this.mWord = str;
            this.mList = arrayList;
            return;
        }
        throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
    }

    public void setKeyWord(String str) {
        this.mWord = str;
    }

    public int getCount() {
        ArrayList<SearchWordResult.DataBean> arrayList = this.mList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        ArrayList<SearchWordResult.DataBean> arrayList = this.mList;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        if (this.mList != null) {
            return (long) i;
        }
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    @SuppressLint({"SetTextI18n"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate((int) R.layout.feature_search_search_result_item, viewGroup, false);
            view.setTag(new TitleViewHolder(view));
        }
        TitleViewHolder titleViewHolder = (TitleViewHolder) view.getTag();
        SearchWordResult.DataBean dataBean = this.mList.get(i);
        SpannableString spannableString = new SpannableString(dataBean.name);
        if (!TextUtils.isEmpty(dataBean.name) && !TextUtils.isEmpty(this.mWord) && dataBean.name.contains(this.mWord)) {
            spannableString.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.orange_red)), dataBean.name.indexOf(this.mWord), dataBean.name.indexOf(this.mWord) + this.mWord.length(), 33);
        }
        if (TextUtils.isEmpty(dataBean.image)) {
            titleViewHolder.itemTitle.setVisibility(0);
            titleViewHolder.itemV2.setVisibility(8);
            titleViewHolder.itemTitle.setText(spannableString);
        } else {
            titleViewHolder.itemTitle.setVisibility(8);
            titleViewHolder.itemV2.setVisibility(0);
            titleViewHolder.itemTitleV2.setText(spannableString);
            if (!TextUtils.isEmpty(dataBean.price)) {
                titleViewHolder.itemPrice.setVisibility(0);
                CustomTextView customTextView = titleViewHolder.itemPrice;
                customTextView.setText(this.localeService.O00000Oo() + dataBean.price);
            } else {
                titleViewHolder.itemPrice.setVisibility(8);
            }
            if (!TextUtils.isEmpty(dataBean.price_before)) {
                titleViewHolder.itemOldPrice.setVisibility(0);
                titleViewHolder.itemOldPrice.getPaint().setFlags(16);
                CustomTextView customTextView2 = titleViewHolder.itemOldPrice;
                customTextView2.setText(this.localeService.O00000Oo() + dataBean.price_before);
            } else {
                titleViewHolder.itemOldPrice.setVisibility(8);
            }
            duh.O000000o().O000000o(dataBean.image, titleViewHolder.itemImage);
        }
        return view;
    }

    static class TitleViewHolder {
        @BindView(2131493123)
        SimpleDraweeView itemImage;
        @BindView(2131493477)
        CustomTextView itemOldPrice;
        @BindView(2131493478)
        CustomTextView itemPrice;
        @BindView(2131493105)
        CustomTextView itemTitle;
        @BindView(2131493479)
        CustomTextView itemTitleV2;
        @BindView(2131493293)
        RelativeLayout itemV2;

        TitleViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public void clear() {
        ArrayList<SearchWordResult.DataBean> arrayList = this.mList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
