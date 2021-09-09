package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.bzw;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cav;
import _m_j.cbf;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.volley.Request;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.OrderListAdapter;
import com.mi.global.shop.adapter.util.AutoLoadArrayAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.mi.global.shop.newmodel.NewSimpleResult;
import com.mi.global.shop.newmodel.orderlist.NewOrderListData;
import com.mi.global.shop.newmodel.orderlist.NewOrderListItem;
import com.mi.global.shop.newmodel.orderlist.NewOrderListResult;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.dialog.CustomCancelDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderListAcitvity extends BaseActivity {
    private static final String O00000o0 = "OrderListAcitvity";

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f4644O000000o = Integer.MAX_VALUE;
    protected NewOrderListItem O00000Oo;
    private int O00000o;
    private List<NewOrderListItem> O00000oO = new ArrayList();
    private ListView O00000oo;
    private CustomTextView O0000O0o;
    private View O0000OOo;
    public OrderListAdapter adapter;
    public ProgressDialog mProgressDialog;
    public int page = 1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_order_list);
        this.mCartView.setVisibility(8);
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.OrderListAcitvity.AnonymousClass1 */

            public final void onClick(View view) {
                OrderListAcitvity.this.onBackPressed();
            }
        });
        this.O00000o = getIntent().getIntExtra("type", 1);
        int i = this.O00000o;
        if (i == 0) {
            setTitle(getString(R.string.account_all_orders));
            this.mForgetPwd.setText((int) R.string.closed_orders);
            this.mForgetPwd.setVisibility(0);
            this.mForgetPwd.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.activity.OrderListAcitvity.AnonymousClass2 */

                public final void onClick(View view) {
                    Intent intent = new Intent(OrderListAcitvity.this, OrderListAcitvity.class);
                    intent.putExtra("type", 2);
                    OrderListAcitvity.this.startActivity(intent);
                }
            });
        } else if (i == 1) {
            setTitle(getString(R.string.account_my_openoder_default));
        } else if (i == 2) {
            setTitle(getString(R.string.closed_orders));
        } else if (i == 3) {
            setTitle(getString(R.string.returns));
        } else if (i == 4) {
            setTitle(getString(R.string.account_awaiting_payment_orders));
        } else if (i == 5) {
            setTitle(getString(R.string.account_shipping_orders));
        }
        this.O0000O0o = (CustomTextView) findViewById(R.id.no_orders_txt);
        this.O00000oo = (ListView) findViewById(R.id.orderItemList);
        this.adapter = new OrderListAdapter(this);
        this.O00000oo.setAdapter((ListAdapter) this.adapter);
        this.adapter.f4828O000000o = new AutoLoadArrayAdapter.O000000o() {
            /* class com.mi.global.shop.activity.OrderListAcitvity.AnonymousClass3 */

            public final void O000000o() {
                OrderListAcitvity.this.loadData();
            }
        };
        this.adapter.O000000o(AutoLoadArrayAdapter.LoadMoreStatus.loading);
        loadData();
    }

    public void startOrderViewActivity(NewOrderListItem newOrderListItem) {
        if (newOrderListItem != null) {
            Intent intent = new Intent(this, OrderViewActivity.class);
            intent.putExtra("orderview_orderid", newOrderListItem.order_id);
            startActivityForResult(intent, 19);
            this.O00000Oo = newOrderListItem;
        }
    }

    public void onBackPressed() {
        getIntent().getIntExtra("backToUserCenter", 0);
        super.onBackPressed();
    }

    public void parseUserOderList(NewOrderListResult newOrderListResult) {
        if (newOrderListResult != null) {
            NewOrderListData newOrderListData = newOrderListResult.data;
            if (!(newOrderListData == null || newOrderListData.order_list == null)) {
                Iterator<NewOrderListItem> it = newOrderListResult.data.order_list.iterator();
                while (it.hasNext()) {
                    NewOrderListItem next = it.next();
                    if (!(next.order_status_info == null || next.order_status_info.next == null)) {
                        Iterator<String> it2 = next.order_status_info.next.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            if ("PAY_MONEY".equalsIgnoreCase(next2)) {
                                next.hasPay = true;
                            }
                            if ("CANCLE_ORDER".equalsIgnoreCase(next2)) {
                                next.hasCancel = true;
                            }
                            if ("REFOUND_APPLY".equalsIgnoreCase(next2)) {
                                next.hasRefund = true;
                            }
                        }
                    }
                    if (next.delivers != null && next.delivers.size() > 1) {
                        next.hasTrace = true;
                        if (next.delivers.size() > 1) {
                            next.hasSuborder = true;
                        }
                    }
                    this.O00000oO.add(next);
                }
                this.page++;
                this.f4644O000000o = newOrderListData.total_pages;
            }
            if (this.page <= this.f4644O000000o) {
                this.adapter.O000000o(AutoLoadArrayAdapter.LoadMoreStatus.idle);
            } else {
                this.adapter.O000000o(AutoLoadArrayAdapter.LoadMoreStatus.disable);
            }
            if (this.O00000oO.size() == 0) {
                this.O0000O0o.setVisibility(0);
                if (getString(R.string.account_all_orders).equals(getTitle())) {
                    this.O0000O0o.setText(getString(R.string.no_all_orders));
                } else if (getString(R.string.closed_orders).equals(getTitle())) {
                    this.O0000O0o.setText(getString(R.string.no_closed_orders));
                } else {
                    this.O0000O0o.setText(getString(R.string.no_orders, new Object[]{getTitle().toString().toLowerCase()}));
                }
            } else {
                this.O0000O0o.setVisibility(8);
                this.adapter.O000000o(this.O00000oO);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void initNoticeHeaderView(NewPageMessage newPageMessage) {
        if (newPageMessage != null && !TextUtils.isEmpty(newPageMessage.pagemsg)) {
            this.O00000oo.setAdapter((ListAdapter) null);
            if (this.O0000OOo == null) {
                this.O0000OOo = LayoutInflater.from(this).inflate((int) R.layout.shop_notice_layout, (ViewGroup) this.O00000oo, false);
                this.O00000oo.addHeaderView(this.O0000OOo);
            }
            this.O0000OOo.setVisibility(0);
            ((CustomTextView) this.O0000OOo.findViewById(R.id.notice_text)).setText(newPageMessage.pagemsg);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) this.O0000OOo.findViewById(R.id.notice_icon);
            if (TextUtils.isEmpty(newPageMessage.icon)) {
                simpleDraweeView.setVisibility(8);
            } else {
                simpleDraweeView.setVisibility(0);
                cbq.O000000o(newPageMessage.icon, simpleDraweeView);
            }
            this.O00000oo.setAdapter((ListAdapter) this.adapter);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void cancelOrder(final NewOrderListItem newOrderListItem) {
        if (newOrderListItem != null) {
            this.O00000Oo = newOrderListItem;
            if (newOrderListItem.hasPay) {
                CustomCancelDialog.Builder builder = new CustomCancelDialog.Builder(this);
                builder.f4982O000000o = getString(R.string.orderview_delpromote);
                builder.O000000o(Boolean.TRUE).O000000o(getString(R.string.orderview_confirm), new DialogInterface.OnClickListener() {
                    /* class com.mi.global.shop.activity.OrderListAcitvity.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        OrderListAcitvity.this.delUnpaidOrder(newOrderListItem.order_id);
                    }
                }).O000000o(getString(R.string.orderview_no));
                builder.O000000o().show();
                return;
            }
            Intent intent = new Intent(this, CancelOrderAcitvity.class);
            intent.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", newOrderListItem.order_id);
            intent.putExtra("cancel_reason", "[{\"id\":\"101\",\"desc\":\"Not interested any more\"},{\"id\":\"102\",\"desc\":\"Mistakenly ordered a product twice\"},{\"id\":\"103\",\"desc\":\"Order delivery is delayed\"},{\"id\":\"104\",\"desc\":\"Ordered an incorrect product\"},{\"id\":\"105\",\"desc\":\"Other reasons\"}]");
            startActivityForResult(intent, 18);
        }
    }

    public void payOrder(NewOrderListItem newOrderListItem) {
        if (newOrderListItem != null) {
            Intent intent = new Intent(this, ConfirmActivity.class);
            intent.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", newOrderListItem.order_id);
            startActivityForResult(intent, 17);
            this.O00000Oo = newOrderListItem;
        }
    }

    public void traceOrder(NewOrderListItem newOrderListItem) {
        if (newOrderListItem != null && newOrderListItem.delivers != null && newOrderListItem.delivers.size() != 0) {
            if (newOrderListItem.delivers.size() > 1) {
                startOrderViewActivity(newOrderListItem);
                return;
            }
            Intent intent = new Intent(this, TrackAcitvity.class);
            intent.putExtra("expresssn", newOrderListItem.delivers.get(0).deliver_id);
            if (newOrderListItem.order_status_info.trace != null && newOrderListItem.order_status_info.trace.size() > 1) {
                intent.putExtra("order_placed", newOrderListItem.order_status_info.trace.get(0).time);
                intent.putExtra("order_paid", newOrderListItem.order_status_info.trace.get(1).time);
            }
            startActivity(intent);
            this.O00000Oo = newOrderListItem;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        NewOrderListItem newOrderListItem;
        NewOrderListItem newOrderListItem2;
        boolean z = false;
        switch (i) {
            case 17:
                if (i2 == -1 && (newOrderListItem = this.O00000Oo) != null) {
                    newOrderListItem.hasPay = false;
                    if (intent != null) {
                        z = intent.getExtras().getBoolean("cod");
                    }
                    if (z) {
                        this.O00000Oo.order_status_info.info = getString(R.string.orderview_codconfirmed);
                    } else {
                        this.O00000Oo.order_status_info.info = getString(R.string.orderview_paymentreceived);
                    }
                    this.adapter.notifyDataSetChanged();
                    return;
                }
                return;
            case 18:
                if (i2 == -1 && (newOrderListItem2 = this.O00000Oo) != null) {
                    newOrderListItem2.hasPay = false;
                    newOrderListItem2.hasCancel = false;
                    newOrderListItem2.hasRefund = false;
                    String str = null;
                    if (intent != null) {
                        str = intent.getStringExtra("order_status");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getString(R.string.orderview_paymentcancel);
                    }
                    this.O00000Oo.order_status_info.info = str;
                    this.adapter.notifyDataSetChanged();
                    return;
                }
                return;
            case 19:
                if (i2 == -1 && this.O00000Oo != null && intent != null && !TextUtils.isEmpty(intent.getStringExtra("order_status"))) {
                    this.O00000Oo.order_status_info.info = intent.getStringExtra("order_status");
                    this.O00000Oo.hasPay = intent.getBooleanExtra("order_haspay", false);
                    this.O00000Oo.hasCancel = intent.getBooleanExtra("order_hascancel", false);
                    this.O00000Oo.hasRefund = intent.getBooleanExtra("order_hasrefund", false);
                    this.O00000Oo.hasTrace = intent.getBooleanExtra("order_hastrace", false);
                    this.adapter.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }

    public void loadData() {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O000000o(this.O00000o)).buildUpon();
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        buildUpon.appendQueryParameter("r", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.page);
        buildUpon.appendQueryParameter("page", sb2.toString());
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        String builder = buildUpon.toString();
        AnonymousClass4 r1 = new cak<NewOrderListResult>() {
            /* class com.mi.global.shop.activity.OrderListAcitvity.AnonymousClass4 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewOrderListResult newOrderListResult = (NewOrderListResult) baseResult;
                if (OrderListAcitvity.this.page == 1 && newOrderListResult.data != null) {
                    OrderListAcitvity.this.initNoticeHeaderView(newOrderListResult.data.pagemsg);
                }
                OrderListAcitvity.this.parseUserOderList(newOrderListResult);
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                cec.O000000o(OrderListAcitvity.this, str, 0);
                OrderListAcitvity.this.adapter.O000000o(AutoLoadArrayAdapter.LoadMoreStatus.error);
                if (OrderListAcitvity.this.page == 1) {
                    OrderListAcitvity.this.setResult(0, new Intent());
                    OrderListAcitvity.this.finish();
                }
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(builder, NewOrderListResult.class, r1);
        } else {
            request = new cal(builder, NewOrderListResult.class, r1);
        }
        request.setTag(O00000o0);
        ced.f13683O000000o.add(request);
    }

    public void delUnpaidOrder(String str) {
        Request request;
        String O0000o = cav.O0000o();
        ccr.O00000Oo(O00000o0, "getPaymentInfo");
        Uri.Builder buildUpon = Uri.parse(O0000o).buildUpon();
        buildUpon.appendQueryParameter("order_id", str);
        String str2 = O00000o0;
        ccr.O00000Oo(str2, "payment url:" + buildUpon.toString());
        String builder = buildUpon.toString();
        AnonymousClass5 r0 = new cak<NewSimpleResult>() {
            /* class com.mi.global.shop.activity.OrderListAcitvity.AnonymousClass5 */

            public final void O000000o(String str) {
                super.O000000o(str);
                OrderListAcitvity.this.hideLoading();
            }

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                OrderListAcitvity.this.hideLoading();
                if (OrderListAcitvity.this.O00000Oo != null) {
                    OrderListAcitvity.this.O00000Oo.order_status_info.info = OrderListAcitvity.this.getString(R.string.orderview_closed);
                    OrderListAcitvity.this.O00000Oo.hasPay = false;
                    OrderListAcitvity.this.O00000Oo.hasCancel = false;
                    OrderListAcitvity.this.O00000Oo.hasRefund = false;
                    OrderListAcitvity.this.adapter.notifyDataSetChanged();
                }
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(builder, NewSimpleResult.class, r0);
        } else {
            request = new cal(builder, NewSimpleResult.class, r0);
        }
        request.setTag(O00000o0);
        ced.f13683O000000o.add(request);
        showLoading();
    }
}
