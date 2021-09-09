package com.mi.global.shop.user;

import _m_j.byl;
import _m_j.cad;
import _m_j.cav;
import _m_j.cbb;
import _m_j.cbj;
import _m_j.cbq;
import _m_j.cbx;
import _m_j.cdy;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.order.NewListItem;
import com.mi.global.shop.newmodel.order.NewListProduct;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class OrderViewItemListViewAdapter extends ArrayAdapter<NewListProduct> {

    /* renamed from: O000000o  reason: collision with root package name */
    PopupWindow f4924O000000o;
    RecyclerView O00000Oo;
    BundleItemAdapter O00000o0;

    public int getItemViewType(int i) {
        return 1;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public static class BundleItemAdapter extends RecyclerView.O000000o<BundleItemViewHolder> {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f4928O000000o;
        ArrayList<NewListItem> O00000Oo = new ArrayList<>();

        public class BundleItemViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private BundleItemViewHolder f4930O000000o;

            public BundleItemViewHolder_ViewBinding(BundleItemViewHolder bundleItemViewHolder, View view) {
                this.f4930O000000o = bundleItemViewHolder;
                bundleItemViewHolder.bundleItemImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.bundle_item_image, "field 'bundleItemImage'", SimpleDraweeView.class);
                bundleItemViewHolder.bundleItemName = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.bundle_item_name, "field 'bundleItemName'", CustomTextView.class);
            }

            public void unbind() {
                BundleItemViewHolder bundleItemViewHolder = this.f4930O000000o;
                if (bundleItemViewHolder != null) {
                    this.f4930O000000o = null;
                    bundleItemViewHolder.bundleItemImage = null;
                    bundleItemViewHolder.bundleItemName = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            BundleItemViewHolder bundleItemViewHolder = (BundleItemViewHolder) o000OOo0;
            final NewListItem newListItem = this.O00000Oo.get(i);
            cbq.O000000o(newListItem.image_url, bundleItemViewHolder.bundleItemImage);
            bundleItemViewHolder.bundleItemName.setText(newListItem.product_name);
            bundleItemViewHolder.bundleItemImage.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.user.OrderViewItemListViewAdapter.BundleItemAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(BundleItemAdapter.this.f4928O000000o, WebActivity.class);
                    if (TextUtils.isEmpty(newListItem.jump_url)) {
                        intent.putExtra("url", cav.O00000o(newListItem.commodity_id));
                    } else {
                        intent.putExtra("url", newListItem.jump_url);
                    }
                    BundleItemAdapter.this.f4928O000000o.startActivity(intent);
                }
            });
        }

        public BundleItemAdapter(Context context) {
            this.f4928O000000o = context;
        }

        public int getItemCount() {
            return this.O00000Oo.size();
        }

        static class BundleItemViewHolder extends RecyclerView.O000OOo0 {
            @BindView(2131493043)
            SimpleDraweeView bundleItemImage;
            @BindView(2131493044)
            CustomTextView bundleItemName;

            BundleItemViewHolder(View view) {
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
            return new BundleItemViewHolder(LayoutInflater.from(this.f4928O000000o).inflate((int) R.layout.shop_order_bundle_item, viewGroup, false));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        if (((NewListProduct) obj) == null) {
            return null;
        }
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_orderview_item, (ViewGroup) null, false);
        O000000o o000000o = new O000000o();
        o000000o.f4931O000000o = inflate;
        o000000o.O00000Oo = (SimpleDraweeView) inflate.findViewById(R.id.item_image);
        o000000o.O00000o0 = (ImageView) inflate.findViewById(R.id.iv_arrow);
        o000000o.O00000oo = (CustomTextView) inflate.findViewById(R.id.item_name);
        o000000o.O00000oO = (CustomTextView) inflate.findViewById(R.id.item_desc);
        o000000o.O0000O0o = (CustomTextView) inflate.findViewById(R.id.item_dealer);
        o000000o.O00000o = (CustomTextView) inflate.findViewById(R.id.item_count);
        o000000o.O0000OOo = (LinearLayout) inflate.findViewById(R.id.item_bundle);
        inflate.setTag(o000000o);
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r5 = (com.mi.global.shop.user.OrderViewItemListViewAdapter.O000000o) r5.getTag();
     */
    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final O000000o o000000o;
        final NewListProduct newListProduct = (NewListProduct) obj;
        if (newListProduct != null && o000000o != null) {
            int O000000o2 = cdy.O000000o(50.0f);
            String str = newListProduct.image_url;
            if (!TextUtils.isEmpty(str)) {
                str = cbb.O000000o(O000000o2, O000000o2, str);
            }
            cbq.O000000o(str, o000000o.O00000Oo);
            o000000o.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.user.OrderViewItemListViewAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(OrderViewItemListViewAdapter.this.O00000o, WebActivity.class);
                    if (TextUtils.isEmpty(newListProduct.jump_url)) {
                        intent.putExtra("url", cav.O00000o(newListProduct.commodity_id));
                    } else {
                        intent.putExtra("url", newListProduct.jump_url);
                    }
                    OrderViewItemListViewAdapter.this.O00000o.startActivity(intent);
                }
            });
            o000000o.O00000oo.setText(newListProduct.product_name);
            o000000o.O00000o.setText("X" + newListProduct.product_count);
            o000000o.O00000oO.setText(cad.O00000o0() + newListProduct.price_txt);
            if (newListProduct.extentions == null || TextUtils.isEmpty(newListProduct.extentions.goods_dealer)) {
                o000000o.O0000O0o.setVisibility(8);
            } else {
                o000000o.O0000O0o.setVisibility(0);
                o000000o.O0000O0o.setText(String.format(byl.O00000oO().getString(R.string.goods_dealer), newListProduct.extentions.goods_dealer));
            }
            ViewGroup.LayoutParams layoutParams = o000000o.O0000OOo.getLayoutParams();
            layoutParams.width = cbj.O000000o.f13594O000000o.O00000o(40) - cdy.O000000o(120.0f);
            o000000o.O0000OOo.setLayoutParams(layoutParams);
            final ArrayList<NewListItem> arrayList = newListProduct.list;
            if (arrayList == null || arrayList.size() <= 0) {
                o000000o.O0000O0o.setVisibility(0);
                o000000o.O0000OOo.setVisibility(8);
            } else {
                o000000o.O0000O0o.setVisibility(8);
                o000000o.O0000OOo.setVisibility(0);
            }
            o000000o.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.user.OrderViewItemListViewAdapter.AnonymousClass2 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
                 arg types: [android.view.View, int, int, int]
                 candidates:
                  ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
                  ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
                public final void onClick(View view) {
                    if (o000000o.O0000Oo0 == 0) {
                        o000000o.O00000o0.setImageResource(R.drawable.shop_bundle_arrow_up);
                        o000000o.O0000Oo0 = 1;
                    } else {
                        o000000o.O00000o0.setImageResource(R.drawable.shop_bundle_arrow_down);
                        o000000o.O0000Oo0 = 0;
                    }
                    OrderViewItemListViewAdapter orderViewItemListViewAdapter = OrderViewItemListViewAdapter.this;
                    ArrayList arrayList = arrayList;
                    O000000o o000000o = o000000o;
                    View inflate = LayoutInflater.from(orderViewItemListViewAdapter.O00000o).inflate((int) R.layout.shop_order_bundle_pupview, (ViewGroup) null);
                    orderViewItemListViewAdapter.O00000Oo = (RecyclerView) inflate.findViewById(R.id.bundle_recycleview);
                    orderViewItemListViewAdapter.O00000Oo.setLayoutManager(new LinearLayoutManager(orderViewItemListViewAdapter.O00000o));
                    orderViewItemListViewAdapter.O00000Oo.addItemDecoration(new cbx(orderViewItemListViewAdapter.O00000o, cdy.O000000o(0.5f), orderViewItemListViewAdapter.O00000o.getResources().getColor(R.color.divider_color)));
                    orderViewItemListViewAdapter.O00000o0 = new BundleItemAdapter(orderViewItemListViewAdapter.O00000o);
                    BundleItemAdapter bundleItemAdapter = orderViewItemListViewAdapter.O00000o0;
                    if (arrayList != null) {
                        bundleItemAdapter.O00000Oo.clear();
                        bundleItemAdapter.O00000Oo.addAll(arrayList);
                        bundleItemAdapter.notifyDataSetChanged();
                    }
                    orderViewItemListViewAdapter.O00000Oo.setAdapter(orderViewItemListViewAdapter.O00000o0);
                    orderViewItemListViewAdapter.f4924O000000o = new PopupWindow(inflate, cbj.O000000o.f13594O000000o.O00000o(40) - cdy.O000000o(120.0f), -2, false);
                    orderViewItemListViewAdapter.f4924O000000o.setFocusable(true);
                    orderViewItemListViewAdapter.f4924O000000o.setOutsideTouchable(true);
                    orderViewItemListViewAdapter.f4924O000000o.setBackgroundDrawable(new BitmapDrawable());
                    orderViewItemListViewAdapter.f4924O000000o.setOnDismissListener(new PopupWindow.OnDismissListener(o000000o) {
                        /* class com.mi.global.shop.user.OrderViewItemListViewAdapter.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000000o f4927O000000o;

                        {
                            this.f4927O000000o = r2;
                        }

                        public final void onDismiss() {
                            O000000o o000000o = this.f4927O000000o;
                            o000000o.O0000Oo0 = 0;
                            o000000o.O00000o0.setImageResource(R.drawable.shop_bundle_arrow_down);
                        }
                    });
                    if (arrayList != null && arrayList.size() > 0) {
                        orderViewItemListViewAdapter.f4924O000000o.showAsDropDown(view);
                    }
                }
            });
        }
    }

    public OrderViewItemListViewAdapter(Context context) {
        super(context);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4931O000000o;
        SimpleDraweeView O00000Oo;
        CustomTextView O00000o;
        ImageView O00000o0;
        CustomTextView O00000oO;
        CustomTextView O00000oo;
        CustomTextView O0000O0o;
        LinearLayout O0000OOo;
        int O0000Oo0 = 0;

        O000000o() {
        }
    }
}
