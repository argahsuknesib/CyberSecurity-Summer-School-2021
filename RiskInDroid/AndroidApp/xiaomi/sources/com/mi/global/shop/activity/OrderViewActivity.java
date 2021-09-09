package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.bzt;
import _m_j.bzw;
import _m_j.cad;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cav;
import _m_j.cax;
import _m_j.cbf;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.Request;
import com.mi.global.shop.adapter.OrderProgressAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.NewSimpleResult;
import com.mi.global.shop.newmodel.order.NewDeliversData;
import com.mi.global.shop.newmodel.order.NewOrderViewData;
import com.mi.global.shop.newmodel.order.NewOrderViewResult;
import com.mi.global.shop.newmodel.order.NewTraceItem;
import com.mi.global.shop.user.OrderViewItemListViewAdapter;
import com.mi.global.shop.user.OrderViewSuborderListViewAdapter;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.global.shop.widget.dialog.CustomCancelDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class OrderViewActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f4651O000000o;
    private String O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;
    private LinearLayout O0000O0o;
    private LinearLayout O0000OOo;
    private LinearLayout O0000Oo;
    private LinearLayout O0000Oo0;
    private LinearLayout O0000OoO;
    private LinearLayout O0000Ooo;
    private CustomTextView O0000o;
    private CustomTextView O0000o0;
    private LinearLayout O0000o00;
    private CustomTextView O0000o0O;
    private CustomTextView O0000o0o;
    private CustomTextView O0000oO;
    private CustomTextView O0000oO0;
    private CustomTextView O0000oOO;
    private CustomTextView O0000oOo;
    private CustomTextView O0000oo;
    private CustomTextView O0000oo0;
    private CustomTextView O0000ooO;
    private CustomTextView O0000ooo;
    private CustomTextView O000O00o;
    private CustomTextView O000O0OO;
    private CustomTextView O000O0Oo;
    private CustomButtonView O000O0o;
    private CustomButtonView O000O0o0;
    private CustomButtonView O000O0oO;
    private OrderViewItemListViewAdapter O000O0oo;
    private NoScrollListView O000OO;
    private OrderViewSuborderListViewAdapter O000OO00;
    private NoScrollListView O000OO0o;
    private RecyclerView O000OOOo;
    private cax O000OOo;
    private OrderProgressAdapter O000OOo0;
    private CustomTextView O000OOoO;
    private CustomTextView O00oOoOo;
    private CustomTextView O00oOooO;
    private CustomTextView O00oOooo;
    public String currentTime;
    @BindView(2131493797)
    LinearLayout exchangeCouponGroup;
    @BindView(2131493796)
    CustomTextView exchangeCouponView;
    public boolean hasCancel;
    public boolean hasPay;
    public boolean hasRefund;
    @BindView(2131493674)
    LinearLayout llNotice;
    public ProgressDialog mProgressDialog;
    public ArrayList<NewDeliversData> orderViewDelivers;
    public NewOrderViewData orderViewModel;
    @BindView(2131494020)
    CustomTextView showTag;
    @BindView(2131494021)
    CustomTextView showTips;
    @BindView(2131494128)
    LinearLayout tipsShadow;

    public void onCreate(Bundle bundle) {
        Request request;
        if (bundle != null) {
            ccr.O00000Oo("OrderViewActivity", "onCreate, savedInstanceState:" + bundle.toString());
            this.orderViewModel = (NewOrderViewData) bundle.getParcelable("orderViewModel");
        }
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_orderview_activity);
        ButterKnife.bind(this);
        setTitle((int) R.string.orderview_title);
        this.O00000Oo = getIntent().getStringExtra("orderview_orderid");
        if (TextUtils.isEmpty(this.O00000Oo)) {
            ccr.O00000Oo("OrderViewActivity", "OrderId is empty");
            finish();
            return;
        }
        this.O00000o0 = this.O00000Oo.length() > 16;
        this.mCartView.setVisibility(4);
        this.f4651O000000o = findViewById(R.id.title_bar_home);
        this.f4651O000000o.setVisibility(0);
        this.f4651O000000o.setOnClickListener(this);
        this.O0000OoO = (LinearLayout) findViewById(R.id.orderview_promoteLL);
        this.O0000Ooo = (LinearLayout) findViewById(R.id.orderview_suborderLL);
        this.O0000O0o = (LinearLayout) findViewById(R.id.orderview_subtotalLL);
        this.O0000OOo = (LinearLayout) findViewById(R.id.orderview_shippingLL);
        this.O0000Oo0 = (LinearLayout) findViewById(R.id.orderview_totalLL);
        this.O0000Oo = (LinearLayout) findViewById(R.id.orderview_discountLL);
        this.O0000o00 = (LinearLayout) findViewById(R.id.orderview_itemlistrLL);
        this.O0000o0 = (CustomTextView) findViewById(R.id.orderview_status);
        this.O0000o0O = (CustomTextView) findViewById(R.id.orderview_subtotal);
        this.O0000o = (CustomTextView) findViewById(R.id.orderview_promote);
        this.O0000o0o = (CustomTextView) findViewById(R.id.orderview_shipping);
        this.O0000oO0 = (CustomTextView) findViewById(R.id.orderview_total);
        this.O0000oO = (CustomTextView) findViewById(R.id.orderview_discount);
        this.O0000oOO = (CustomTextView) findViewById(R.id.orderview_total_bottom);
        this.O0000oOo = (CustomTextView) findViewById(R.id.orderview_paywarningSpan);
        this.O0000oo0 = (CustomTextView) findViewById(R.id.orderview_paywarning);
        this.O000O0OO = (CustomTextView) findViewById(R.id.orderview_transportnum);
        this.O000O0Oo = (CustomTextView) findViewById(R.id.orderview_deliveryid);
        this.O00oOoOo = (CustomTextView) findViewById(R.id.orderview_transportcompany);
        this.O000OO0o = (NoScrollListView) findViewById(R.id.orderview_itemlist);
        this.O000OO = (NoScrollListView) findViewById(R.id.orderview_suborderlist);
        this.O0000oo = (CustomTextView) findViewById(R.id.orderview_addline1);
        this.O0000ooO = (CustomTextView) findViewById(R.id.orderview_addline2);
        this.O0000ooo = (CustomTextView) findViewById(R.id.orderview_addline3);
        this.O00oOooO = (CustomTextView) findViewById(R.id.orderview_email);
        this.O00oOooo = (CustomTextView) findViewById(R.id.orderview_orderid);
        this.O000O00o = (CustomTextView) findViewById(R.id.orderview_time);
        this.O000O0o0 = (CustomButtonView) findViewById(R.id.orderview_payBtn);
        this.O000O0o = (CustomButtonView) findViewById(R.id.orderview_cancelBtn);
        this.O000O0oO = (CustomButtonView) findViewById(R.id.orderview_tracebtn);
        this.O000OOOo = (RecyclerView) findViewById(R.id.order_progress_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.O000OOOo.setLayoutManager(linearLayoutManager);
        this.O000OOo0 = new OrderProgressAdapter(this, this);
        this.O000OOOo.setAdapter(this.O000OOo0);
        this.O000OOoO = (CustomTextView) findViewById(R.id.tv_deliver_time);
        ccr.O00000Oo("OrderViewActivity", "getOrderViewInfo url:" + O00000Oo());
        String O00000Oo2 = O00000Oo();
        AnonymousClass1 r1 = new cak<NewOrderViewResult>() {
            /* class com.mi.global.shop.activity.OrderViewActivity.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                OrderViewActivity.this.hideLoading();
                OrderViewActivity.this.orderViewModel = ((NewOrderViewResult) baseResult).data;
                OrderViewActivity orderViewActivity = OrderViewActivity.this;
                orderViewActivity.currentTime = orderViewActivity.orderViewModel.currentTime;
                OrderViewActivity orderViewActivity2 = OrderViewActivity.this;
                orderViewActivity2.orderViewDelivers = orderViewActivity2.orderViewModel.delivers;
                OrderViewActivity orderViewActivity3 = OrderViewActivity.this;
                orderViewActivity3.initStatus(orderViewActivity3.orderViewModel);
                OrderViewActivity orderViewActivity4 = OrderViewActivity.this;
                orderViewActivity4.updateView(orderViewActivity4.orderViewModel);
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                ccr.O00000Oo("OrderViewActivity", "getOrderViewInfo Exception:".concat(String.valueOf(str)));
                OrderViewActivity.this.quitwithError(str);
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(O00000Oo2, NewOrderViewResult.class, r1);
        } else {
            request = new cal(O00000Oo2, NewOrderViewResult.class, r1);
        }
        request.setTag("OrderViewActivity");
        ced.f13683O000000o.add(request);
        showLoading();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("orderViewModel", this.orderViewModel);
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        cax cax = this.O000OOo;
        if (cax != null) {
            cax.O000000o();
            this.O000OOo = null;
        }
        super.onDestroy();
    }

    public void initStatus(NewOrderViewData newOrderViewData) {
        if (newOrderViewData != null) {
            this.O00000oo = false;
            this.hasRefund = false;
            this.hasCancel = false;
            this.hasPay = false;
            this.O00000oO = false;
            this.O00000o = false;
            ArrayList<NewDeliversData> arrayList = this.orderViewDelivers;
            if (arrayList != null) {
                if (arrayList.size() == 1 && !TextUtils.isEmpty(this.orderViewDelivers.get(0).express_sn) && !this.orderViewDelivers.get(0).express_sn.equals("0")) {
                    this.O00000oO = true;
                }
                if (this.orderViewDelivers.size() > 1) {
                    this.O00000o = true;
                }
            }
            if (!(newOrderViewData.orderInfo == null || newOrderViewData.orderInfo.order_status_info == null || newOrderViewData.orderInfo.order_status_info.next == null)) {
                for (int i = 0; i < newOrderViewData.orderInfo.order_status_info.next.size(); i++) {
                    String str = newOrderViewData.orderInfo.order_status_info.next.get(i);
                    if ("PAY_MONEY".equalsIgnoreCase(str)) {
                        this.hasPay = true;
                    }
                    if ("CANCLE_ORDER".equalsIgnoreCase(str)) {
                        this.hasCancel = true;
                    }
                    if ("REFOUND_APPLY".equalsIgnoreCase(str)) {
                        this.hasRefund = true;
                    }
                }
            }
            if (newOrderViewData.orderInfo != null && !TextUtils.isEmpty(newOrderViewData.orderInfo.reduce_price_txt) && Integer.parseInt(newOrderViewData.orderInfo.reduce_price_txt.replace(",", "")) != 0) {
                this.O00000oo = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0186  */
    public void updateView(NewOrderViewData newOrderViewData) {
        ArrayList<NewDeliversData> arrayList;
        long j;
        long j2;
        long j3;
        if (newOrderViewData != null) {
            if (newOrderViewData.orderInfo.order_status_info != null) {
                this.O0000o0.setText(newOrderViewData.orderInfo.order_status_info.info);
            }
            if (newOrderViewData.exchange_coupon == null || newOrderViewData.exchange_coupon.amount == 0) {
                this.exchangeCouponGroup.setVisibility(8);
            } else {
                this.exchangeCouponGroup.setVisibility(0);
                CustomTextView customTextView = this.exchangeCouponView;
                StringBuilder sb = new StringBuilder("-");
                sb.append(cad.O00000o0());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(newOrderViewData.exchange_coupon.amount);
                sb.append(bzt.O00000Oo(sb2.toString()));
                customTextView.setText(sb.toString());
            }
            if (newOrderViewData.orderInfo != null) {
                if (newOrderViewData.orderInfo.shipment_expense_txt.trim().equals("0")) {
                    this.O0000o0o.setText(getString(R.string.orderview_freedelivery));
                } else {
                    this.O0000o0o.setText(cad.O00000o0() + newOrderViewData.orderInfo.shipment_expense_txt);
                }
                this.O0000oO0.setText(cad.O00000o0() + newOrderViewData.orderInfo.goods_amount_txt);
                this.O0000oO.setText("-" + cad.O00000o0() + newOrderViewData.orderInfo.reduce_price_txt);
                this.O0000oOO.setText(cad.O00000o0() + newOrderViewData.orderInfo.goods_amount_txt);
                if (!TextUtils.isEmpty(newOrderViewData.orderInfo.arrival_time)) {
                    this.O000OOoO.setVisibility(0);
                    this.O000OOoO.setText(Html.fromHtml(newOrderViewData.orderInfo.arrival_time));
                }
            }
            this.O0000o0O.setText(cad.O00000o0() + newOrderViewData.goodsAmt);
            if (this.O00000o0) {
                this.O0000O0o.setVisibility(8);
                this.O0000OOo.setVisibility(8);
                this.O0000OoO.setVisibility(8);
                this.O0000Oo0.setVisibility(8);
                this.O0000Oo.setVisibility(8);
            }
            if (this.hasPay) {
                this.O000O0o0.setVisibility(0);
                this.O000O0o0.setOnClickListener(this);
                if (!(newOrderViewData.orderInfo == null || newOrderViewData.orderInfo.ttl == null || TextUtils.isEmpty(this.currentTime))) {
                    try {
                        j2 = Long.parseLong(newOrderViewData.orderInfo.ttl);
                        try {
                            j = Long.parseLong(this.currentTime);
                        } catch (Exception unused) {
                            j = 0;
                            j3 = j2 - j;
                            if (j3 <= 0) {
                            }
                        }
                    } catch (Exception unused2) {
                        j2 = 0;
                        j = 0;
                        j3 = j2 - j;
                        if (j3 <= 0) {
                        }
                    }
                    j3 = j2 - j;
                    if (j3 <= 0) {
                        cec.O000000o(this, getString(R.string.expired_order), 3000);
                        finish();
                        return;
                    }
                    this.O0000oOo.setVisibility(0);
                    this.O0000oo0.setVisibility(0);
                    if (this.O000OOo == null) {
                        this.O000OOo = new cax(this, j3);
                        this.O000OOo.O000000o(this.O0000oo0, getString(R.string.expired_order));
                    }
                }
            } else {
                this.O000O0o0.setVisibility(8);
            }
            if (this.hasCancel || this.hasRefund) {
                this.O000O0o.setVisibility(0);
                this.O000O0o.setOnClickListener(this);
            } else {
                this.O000O0o.setVisibility(8);
            }
            if (this.O00000oO && (arrayList = this.orderViewDelivers) != null && arrayList.size() > 0) {
                this.O000O0oO.setVisibility(0);
                if (this.orderViewDelivers.get(0).express != null && !TextUtils.isEmpty(this.orderViewDelivers.get(0).express_sn)) {
                    this.O000O0oO.setOnClickListener(this);
                }
                this.O000O0OO.setText(this.orderViewDelivers.get(0).deliver_id);
                if (this.orderViewDelivers.get(0).express != null) {
                    this.O000O0Oo.setText(this.orderViewDelivers.get(0).express.express_sn);
                    this.O00oOoOo.setText(this.orderViewDelivers.get(0).express.express_name);
                }
            }
            if (this.O00000o) {
                this.O0000Ooo.setVisibility(0);
                this.O000OO00 = new OrderViewSuborderListViewAdapter(this);
                this.O000OO00.O00000o0();
                this.O000OO00.O000000o((ArrayList) this.orderViewDelivers);
                this.O000OO.setAdapter((ListAdapter) this.O000OO00);
                this.O000OOOo.setVisibility(8);
                this.O0000o00.setVisibility(8);
            } else {
                this.O0000Ooo.setVisibility(8);
                this.O000OOOo.setVisibility(0);
                this.O0000o00.setVisibility(0);
            }
            if (!(newOrderViewData.orderInfo == null || newOrderViewData.orderInfo.product == null)) {
                this.O000O0oo = new OrderViewItemListViewAdapter(this);
                this.O000O0oo.O00000o0();
                this.O000O0oo.O000000o((ArrayList) newOrderViewData.orderInfo.product);
                this.O000OO0o.setAdapter((ListAdapter) this.O000O0oo);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(newOrderViewData.orderInfo.consignee);
                sb3.append(" ");
                sb3.append(newOrderViewData.orderInfo.tel);
                this.O0000oo.setText(Html.fromHtml(newOrderViewData.orderInfo.consignee).toString() + "    " + Html.fromHtml(newOrderViewData.orderInfo.tel).toString());
                if (newOrderViewData.orderInfo.addr_india != null) {
                    this.O0000ooO.setText(Html.fromHtml(newOrderViewData.orderInfo.addr_india.addr + " " + newOrderViewData.orderInfo.addr_india.landmark).toString());
                    this.O0000ooo.setText(Html.fromHtml(newOrderViewData.orderInfo.zipcode + " " + newOrderViewData.orderInfo.addr_india.city + " " + newOrderViewData.orderInfo.city.name).toString());
                }
                this.O00oOooO.setText(newOrderViewData.orderInfo.email);
                this.O00oOooo.setText(newOrderViewData.orderInfo.order_id);
                this.O000O00o.setText(cad.O000000o(Long.valueOf(Long.parseLong(newOrderViewData.orderInfo.add_time) * 1000)));
            }
            if (newOrderViewData.orderInfo.order_status_info.trace != null) {
                OrderProgressAdapter orderProgressAdapter = this.O000OOo0;
                ArrayList<NewTraceItem> arrayList2 = newOrderViewData.orderInfo.order_status_info.trace;
                if (arrayList2 != null) {
                    orderProgressAdapter.f4747O000000o.clear();
                    orderProgressAdapter.f4747O000000o.addAll(arrayList2);
                    orderProgressAdapter.notifyDataSetChanged();
                }
            }
            if (!TextUtils.isEmpty(newOrderViewData.orderInfo.show_tag)) {
                this.showTag.setText(newOrderViewData.orderInfo.show_tag);
                this.showTag.setVisibility(0);
            } else {
                this.showTag.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newOrderViewData.orderInfo.show_tips)) {
                this.showTips.setText(newOrderViewData.orderInfo.show_tips);
                this.llNotice.setVisibility(0);
                this.tipsShadow.setVisibility(0);
                return;
            }
            this.llNotice.setVisibility(8);
            this.tipsShadow.setVisibility(8);
        }
    }

    private String O00000Oo() {
        Uri.Builder buildUpon = Uri.parse(cav.O000O0o0()).buildUpon();
        buildUpon.appendQueryParameter("order_id", this.O00000Oo);
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        return buildUpon.toString();
    }

    public void quitwithError(String str) {
        if (TextUtils.isEmpty(str)) {
            cec.O000000o(this, (int) R.string.shop_error_network, 0);
        } else {
            cec.O000000o(this, str, 0);
        }
        hideLoading();
        setResult(0);
        finish();
        ccr.O00000Oo("OrderViewActivity", "JSON parse error");
    }

    public void noQuitError(String str) {
        if (TextUtils.isEmpty(str)) {
            cec.O000000o(this, (int) R.string.shop_error_network, 0);
        } else {
            cec.O000000o(this, str, 0);
        }
        hideLoading();
        ccr.O00000Oo("OrderViewActivity", "JSON parse error");
    }

    public void delUnpaidOrder() {
        Request request;
        ccr.O00000Oo("OrderViewActivity", "delUnpaidOrder url:" + O00000Oo());
        String O0000o2 = cav.O0000o();
        ccr.O00000Oo("OrderViewActivity", "getPaymentInfo");
        Uri.Builder buildUpon = Uri.parse(O0000o2).buildUpon();
        buildUpon.appendQueryParameter("order_id", this.O00000Oo);
        ccr.O00000Oo("OrderViewActivity", "payment url:" + buildUpon.toString());
        String builder = buildUpon.toString();
        AnonymousClass3 r2 = new cak<NewSimpleResult>() {
            /* class com.mi.global.shop.activity.OrderViewActivity.AnonymousClass3 */

            public final void O000000o(String str) {
                super.O000000o(str);
                ccr.O00000Oo("OrderViewActivity", "delUnpaidOrder Exception:".concat(String.valueOf(str)));
                OrderViewActivity.this.noQuitError(str);
            }

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                OrderViewActivity.this.hideLoading();
                OrderViewActivity orderViewActivity = OrderViewActivity.this;
                orderViewActivity.hasPay = false;
                orderViewActivity.hasCancel = false;
                orderViewActivity.hasRefund = false;
                orderViewActivity.saveStatus(byl.O00000oO().getString(R.string.orderview_closed), null);
                OrderViewActivity orderViewActivity2 = OrderViewActivity.this;
                orderViewActivity2.updateView(orderViewActivity2.orderViewModel);
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(builder, NewSimpleResult.class, r2);
        } else {
            request = new cal(builder, NewSimpleResult.class, r2);
        }
        request.setTag("OrderViewActivity");
        ced.f13683O000000o.add(request);
        showLoading();
    }

    public void saveStatus(String str, Intent intent) {
        this.orderViewModel.orderInfo.order_status_info.info = str;
        if (intent == null) {
            intent = new Intent();
        }
        if (TextUtils.isEmpty(intent.getStringExtra("order_status"))) {
            intent.putExtra("order_status", str);
            intent.putExtra("order_haspay", this.hasPay);
            intent.putExtra("order_hascancel", this.hasCancel);
            intent.putExtra("order_hastrace", this.O00000oO);
            intent.putExtra("order_hasrefund", this.hasRefund);
        }
        setResult(-1, intent);
    }

    public void onClick(View view) {
        if (view == this.O000O0o0) {
            Intent intent = new Intent(this, ConfirmActivity.class);
            intent.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", this.O00000Oo);
            startActivityForResult(intent, 17);
        } else if (view == this.O000O0o) {
            if (this.hasPay) {
                CustomCancelDialog.Builder builder = new CustomCancelDialog.Builder(this);
                builder.f4982O000000o = getString(R.string.orderview_delpromote);
                builder.O000000o(Boolean.TRUE).O000000o(getString(R.string.orderview_confirm), new DialogInterface.OnClickListener() {
                    /* class com.mi.global.shop.activity.OrderViewActivity.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        OrderViewActivity.this.delUnpaidOrder();
                    }
                }).O000000o(getString(R.string.orderview_no));
                builder.O000000o().show();
                return;
            }
            Intent intent2 = new Intent(this, CancelOrderAcitvity.class);
            intent2.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", this.O00000Oo);
            intent2.putExtra("cancel_reason", "[{\"id\":\"101\",\"desc\":\"Not interested any more\"},{\"id\":\"102\",\"desc\":\"Mistakenly ordered a product twice\"},{\"id\":\"103\",\"desc\":\"Order delivery is delayed\"},{\"id\":\"104\",\"desc\":\"Ordered an incorrect product\"},{\"id\":\"105\",\"desc\":\"Other reasons\"}]");
            startActivityForResult(intent2, 18);
        } else if (view == this.O000O0oO) {
            Intent intent3 = new Intent(this, TrackAcitvity.class);
            intent3.putExtra("expresssn", this.orderViewDelivers.get(0).deliver_id);
            if (this.orderViewModel.orderInfo.order_status_info.trace != null && this.orderViewModel.orderInfo.order_status_info.trace.size() > 1) {
                intent3.putExtra("order_placed", this.orderViewModel.orderInfo.order_status_info.trace.get(0).time);
                intent3.putExtra("order_paid", this.orderViewModel.orderInfo.order_status_info.trace.get(1).time);
            }
            startActivity(intent3);
        } else if (view == this.f4651O000000o) {
            onBackPressed();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 18) {
            ccr.O00000Oo("OrderViewActivity", "get ordercancel result:".concat(String.valueOf(i2)));
            if (i2 == -1) {
                this.hasPay = false;
                this.hasCancel = false;
                this.hasRefund = false;
                if (intent != null) {
                    try {
                        if (!TextUtils.isEmpty(intent.getStringExtra("order_status"))) {
                            saveStatus(intent.getStringExtra("order_status"), intent);
                            updateView(this.orderViewModel);
                        }
                    } catch (Exception unused) {
                    }
                }
                saveStatus(byl.O00000oO().getString(R.string.orderview_paymentcancel), intent);
                updateView(this.orderViewModel);
            } else {
                return;
            }
        }
        if (i == 17) {
            ccr.O00000Oo("OrderViewActivity", "get confirm result:".concat(String.valueOf(i2)));
            if (i2 == -1) {
                Boolean bool = Boolean.FALSE;
                if (intent != null) {
                    bool = Boolean.valueOf(intent.getExtras().getBoolean("cod"));
                }
                if (bool.booleanValue()) {
                    saveStatus(byl.O00000oO().getString(R.string.orderview_codconfirmed), intent);
                } else {
                    saveStatus(byl.O00000oO().getString(R.string.orderview_paymentreceived), intent);
                }
                this.hasPay = false;
                updateView(this.orderViewModel);
            }
        }
    }
}
