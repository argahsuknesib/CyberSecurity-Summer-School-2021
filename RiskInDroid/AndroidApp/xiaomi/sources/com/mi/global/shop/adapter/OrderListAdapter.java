package com.mi.global.shop.adapter;

import _m_j.cad;
import _m_j.cas;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.activity.OrderListAcitvity;
import com.mi.global.shop.adapter.util.AutoLoadArrayAdapter;
import com.mi.global.shop.newmodel.orderlist.NewOrderListItem;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class OrderListAdapter extends AutoLoadArrayAdapter<NewOrderListItem> {

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4746O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4746O000000o = viewHolder;
            viewHolder.tag = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tag, "field 'tag'", CustomTextView.class);
            viewHolder.time = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.time, "field 'time'", CustomTextView.class);
            viewHolder.packageNum = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.package_num, "field 'packageNum'", CustomTextView.class);
            viewHolder.status = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.status, "field 'status'", CustomTextView.class);
            viewHolder.tip = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tip, "field 'tip'", CustomTextView.class);
            viewHolder.tipDivider = Utils.findRequiredView(view, R.id.tip_divider, "field 'tipDivider'");
            viewHolder.orderItemListView = (NoScrollListView) Utils.findRequiredViewAsType(view, R.id.order_item_list, "field 'orderItemListView'", NoScrollListView.class);
            viewHolder.totalPrice = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.total_price, "field 'totalPrice'", CustomTextView.class);
            viewHolder.cancelBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.cancel_btn, "field 'cancelBtn'", CustomButtonView.class);
            viewHolder.payBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.pay_btn, "field 'payBtn'", CustomButtonView.class);
            viewHolder.traceBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.trace_btn, "field 'traceBtn'", CustomButtonView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4746O000000o;
            if (viewHolder != null) {
                this.f4746O000000o = null;
                viewHolder.tag = null;
                viewHolder.time = null;
                viewHolder.packageNum = null;
                viewHolder.status = null;
                viewHolder.tip = null;
                viewHolder.tipDivider = null;
                viewHolder.orderItemListView = null;
                viewHolder.totalPrice = null;
                viewHolder.cancelBtn = null;
                viewHolder.payBtn = null;
                viewHolder.traceBtn = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final NewOrderListItem newOrderListItem = (NewOrderListItem) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.time.setText(cad.O000000o(Long.valueOf(cas.O000000o(newOrderListItem.add_time) * 1000)));
        viewHolder.status.setText(newOrderListItem.order_status_info.info);
        CustomTextView customTextView = viewHolder.totalPrice;
        customTextView.setText("Total  " + cad.O00000o0() + newOrderListItem.goods_amount);
        if (TextUtils.isEmpty(newOrderListItem.show_tag)) {
            viewHolder.tag.setVisibility(8);
        } else {
            viewHolder.tag.setVisibility(0);
            viewHolder.tag.setText(newOrderListItem.show_tag);
        }
        if (TextUtils.isEmpty(newOrderListItem.show_tips)) {
            viewHolder.tip.setVisibility(8);
            viewHolder.tipDivider.setVisibility(8);
        } else {
            viewHolder.tip.setVisibility(0);
            viewHolder.tipDivider.setVisibility(0);
            viewHolder.tip.setText(newOrderListItem.show_tips);
        }
        if (Build.VERSION.SDK_INT > 23) {
            OrderItemListAdapter orderItemListAdapter = new OrderItemListAdapter(view.getContext());
            viewHolder.orderItemListView.setAdapter((ListAdapter) orderItemListAdapter);
            orderItemListAdapter.O000000o((List) newOrderListItem.product);
        } else {
            viewHolder.f4745O000000o.O000000o((List) newOrderListItem.product);
        }
        if (newOrderListItem.hasPay) {
            viewHolder.payBtn.setVisibility(0);
            viewHolder.payBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.OrderListAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    if (OrderListAdapter.this.O00000o instanceof OrderListAcitvity) {
                        ((OrderListAcitvity) OrderListAdapter.this.O00000o).payOrder(newOrderListItem);
                    }
                }
            });
        } else {
            viewHolder.payBtn.setVisibility(8);
        }
        viewHolder.cancelBtn.setVisibility(8);
        if (newOrderListItem.hasTrace) {
            viewHolder.traceBtn.setVisibility(0);
            viewHolder.traceBtn.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.OrderListAdapter.AnonymousClass2 */

                public final void onClick(View view) {
                    if (OrderListAdapter.this.O00000o instanceof OrderListAcitvity) {
                        ((OrderListAcitvity) OrderListAdapter.this.O00000o).traceOrder(newOrderListItem);
                    }
                }
            });
            if (newOrderListItem.hasSuborder) {
                viewHolder.traceBtn.setText((int) R.string.order_item_view_detail);
                viewHolder.packageNum.setVisibility(0);
                viewHolder.packageNum.setText(String.format(this.O00000o.getString(R.string.order_item_packages), Integer.valueOf(newOrderListItem.delivers.size())));
            } else {
                viewHolder.traceBtn.setText((int) R.string.order_item_track);
                viewHolder.packageNum.setVisibility(8);
            }
        } else {
            viewHolder.traceBtn.setVisibility(8);
            viewHolder.packageNum.setVisibility(8);
        }
        viewHolder.orderItemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.mi.global.shop.adapter.OrderListAdapter.AnonymousClass3 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (OrderListAdapter.this.O00000o instanceof OrderListAcitvity) {
                    ((OrderListAcitvity) OrderListAdapter.this.O00000o).startOrderViewActivity(newOrderListItem);
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.adapter.OrderListAdapter.AnonymousClass4 */

            public final void onClick(View view) {
                if (OrderListAdapter.this.O00000o instanceof OrderListAcitvity) {
                    ((OrderListAcitvity) OrderListAdapter.this.O00000o).startOrderViewActivity(newOrderListItem);
                }
            }
        });
    }

    public OrderListAdapter(Context context) {
        super(context);
    }

    static class ViewHolder {

        /* renamed from: O000000o  reason: collision with root package name */
        OrderItemListAdapter f4745O000000o;
        @BindView(2131493097)
        CustomButtonView cancelBtn;
        @BindView(2131493765)
        NoScrollListView orderItemListView;
        @BindView(2131493829)
        CustomTextView packageNum;
        @BindView(2131493849)
        CustomButtonView payBtn;
        @BindView(2131494057)
        CustomTextView status;
        @BindView(2131494080)
        CustomTextView tag;
        @BindView(2131494122)
        CustomTextView time;
        @BindView(2131494126)
        CustomTextView tip;
        @BindView(2131494127)
        View tipDivider;
        @BindView(2131494158)
        CustomTextView totalPrice;
        @BindView(2131494162)
        CustomButtonView traceBtn;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            this.f4745O000000o = new OrderItemListAdapter(view.getContext());
            this.orderItemListView.setAdapter((ListAdapter) this.f4745O000000o);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_order_list_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
