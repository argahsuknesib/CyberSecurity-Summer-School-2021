package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.bzw;
import _m_j.cad;
import _m_j.cak;
import _m_j.cam;
import _m_j.cas;
import _m_j.cav;
import _m_j.cbe;
import _m_j.cbf;
import _m_j.cbm;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;
import com.facebook.appevents.AppEventsLogger;
import com.google.gson.Gson;
import com.mi.global.shop.adapter.checkout.CheckoutListAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.model.SyncModel;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.checkout.NewChangeAddressData;
import com.mi.global.shop.newmodel.checkout.NewChangeAddressResult;
import com.mi.global.shop.newmodel.checkout.NewCheckoutCartItem;
import com.mi.global.shop.newmodel.checkout.NewCheckoutData;
import com.mi.global.shop.newmodel.checkout.NewCheckoutResult;
import com.mi.global.shop.newmodel.checkout.NewSubmitData;
import com.mi.global.shop.newmodel.checkout.NewSubmitResult;
import com.mi.global.shop.newmodel.user.address.FourDeliveryData;
import com.mi.global.shop.newmodel.user.address.SmartBoxData;
import com.mi.global.shop.newmodel.user.address.SmartDetailItemData;
import com.mi.global.shop.newmodel.user.coupon.NewCouponData;
import com.mi.global.shop.newmodel.user.coupon.NewCouponItem;
import com.mi.global.shop.newmodel.user.coupon.NewPaymentCouponResult;
import com.mi.global.shop.user.AddressListActivity;
import com.mi.global.shop.user.CouponActivity;
import com.mi.global.shop.user.ExchangeCouponActivity;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.global.shop.widget.dialog.CustomCloseDialog;
import com.mi.multimonitor.CrashReport;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CheckoutActivity extends BaseActivity {
    public static String GST_CODE_S = "gst_code_s";
    public static final String TAG = "CheckoutActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f4599O000000o;
    String O00000Oo = "";
    String O00000o = "";
    String O00000o0 = "";
    String O00000oO = "0";
    String O00000oo = "";
    DefaultRetryPolicy O0000O0o = new DefaultRetryPolicy(15000, 1, 1.0f);
    private boolean O0000OOo = true;
    private float O0000Oo = Float.MAX_VALUE;
    private boolean O0000Oo0 = true;
    private float O0000OoO = Float.MAX_VALUE;
    private float O0000Ooo;
    private final String O0000o = "54";
    private String O0000o0;
    private String O0000o00;
    private boolean O0000o0O = false;
    private int O0000o0o = 0;
    @BindView(2131492930)
    View addAddressView;
    @BindView(2131492934)
    View addressContent;
    @BindView(2131492935)
    CustomTextView addressErrorTextView;
    @BindView(2131492940)
    View addressMarkView;
    @BindView(2131492932)
    CustomTextView addressTextView;
    @BindView(2131492943)
    View addressTipLayout;
    @BindView(2131492936)
    View addressView;
    public String addressid;
    @BindView(2131492998)
    CustomTextView bottomTotalTextView;
    public boolean can_exchange;
    public String cityId;
    @BindView(2131492871)
    CustomTextView codNotAvailableTextView;
    @BindView(2131493199)
    CustomTextView consigneeTextView;
    public String couponId;
    @BindView(2131493164)
    CustomTextView couponTextView;
    public String couponType;
    @BindView(2131493216)
    View couponView;
    @BindView(2131494206)
    TextView deliveryNameTextView;
    @BindView(2131493260)
    CustomTextView deliveryNotice;
    public int delivery_mode;
    @BindView(2131494340)
    View dividerView;
    public String exchangeCouponId;
    @BindView(2131493165)
    CustomTextView exchangeCouponTextView;
    @BindView(2131493330)
    View exchangeCouponView;
    public FourDeliveryData fourDeliveryData;
    @BindView(2131494010)
    View fourDeliveryRelativeLayout;
    @BindView(2131493964)
    RelativeLayout gstRelativeLayout;
    @BindView(2131493229)
    CustomTextView gstTextView;
    public String gst_code = "";
    @BindView(2131493691)
    View loadingView;
    public CustomCloseDialog mExchangeInvalidDialog;
    public ProgressDialog mProgressDialog;
    public NewCheckoutData model;
    @BindView(2131493746)
    View noticeContainer;
    @BindView(2131493863)
    CustomTextView phoneTextView;
    @BindView(2131493871)
    CustomButtonView placeOrderButton;
    @BindView(2131493166)
    CustomTextView promoteTextView;
    @BindView(2131493907)
    View promoteView;
    @BindView(2131493214)
    CustomTextView selectCouponTextView;
    @BindView(2131494005)
    View selectCouponView;
    @BindView(2131494007)
    CustomTextView selectExchangeCouponTextView;
    @BindView(2131494009)
    CustomTextView selectExchangeCouponTitleView;
    @BindView(2131494008)
    View selectExchangeCouponView;
    @BindView(2131493167)
    CustomTextView shipTextView;
    public SmartBoxData smartBoxData;
    public String smartbox_id = "";
    @BindView(2131493168)
    CustomTextView subtotalTextView;
    @BindView(2131493169)
    CustomTextView totalTextView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_checkout);
        ButterKnife.bind(this);
        setTitle(getString(R.string.checkout_title));
        this.mBackView.setVisibility(0);
        this.mCartView.setVisibility(4);
        this.addressView.setFocusable(true);
        this.addressView.setFocusableInTouchMode(true);
        this.O0000o0o = getIntent().getIntExtra("one_click_extra", 0);
        this.loadingView.setVisibility(0);
        String[] O0000o02 = cav.O0000o0();
        final String[] strArr = new String[O0000o02.length];
        for (int i = 0; i < O0000o02.length; i++) {
            Uri.Builder buildUpon = Uri.parse(O0000o02[i]).buildUpon();
            buildUpon.appendQueryParameter("jsontag", "true");
            buildUpon.appendQueryParameter("security", "true");
            if (this.O0000o0o == 1) {
                buildUpon.appendQueryParameter("oneclick", "1");
            }
            if (bzw.O000000o()) {
                buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
            }
            appendOriginalUrl(buildUpon, this);
            if (byl.O0000OoO()) {
                buildUpon.appendQueryParameter("ot", "5");
            }
            strArr[i] = buildUpon.toString();
        }
        cam cam = new cam(strArr[0], NewCheckoutResult.class, new cak<NewCheckoutResult>() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                CheckoutActivity.this.updateData((NewCheckoutResult) baseResult);
            }

            public final void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == 302) {
                    String[] strArr = strArr;
                    if (strArr.length > 1) {
                        cam cam = new cam(strArr[1], NewCheckoutResult.class, new cak<NewCheckoutResult>() {
                            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                                CheckoutActivity.this.updateData((NewCheckoutResult) baseResult);
                                if (strArr[1].startsWith("https")) {
                                    SyncModel.useHttps = true;
                                } else {
                                    SyncModel.useHttps = false;
                                }
                            }

                            public final void O000000o(String str) {
                                super.O000000o(str);
                                CheckoutActivity.this.finish();
                            }
                        });
                        cam.setTag(CheckoutActivity.TAG);
                        ced.f13683O000000o.add(cam);
                        return;
                    }
                }
                super.onErrorResponse(volleyError);
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                CheckoutActivity.this.finish();
            }
        });
        cam.setTag(TAG);
        ced.f13683O000000o.add(cam);
    }

    public void onResume() {
        super.onResume();
    }

    public void updateData(NewCheckoutResult newCheckoutResult) {
        String str;
        this.model = newCheckoutResult.data;
        this.O00000o = newCheckoutResult.data.checkoutInfo.address.zipcode;
        this.loadingView.setVisibility(8);
        this.O0000Ooo = cas.O000000o(this.model.totalpay, 0.0f);
        if (this.model.checkoutInfo == null || this.model.checkoutInfo.address == null || TextUtils.isEmpty(this.model.checkoutInfo.address.address_id)) {
            this.O0000o0O = true;
            this.addAddressView.setVisibility(0);
            this.addressContent.setVisibility(8);
            this.addressMarkView.setVisibility(8);
            this.placeOrderButton.setEnabled(false);
        } else {
            this.addressid = this.model.checkoutInfo.address.address_id;
            if (this.model.checkoutInfo.address.city != null) {
                this.cityId = this.model.checkoutInfo.address.city.id;
            }
            O000000o(this.O0000Ooo, this.addressid);
            this.consigneeTextView.setText(this.model.checkoutInfo.address.consignee);
            this.phoneTextView.setText(getString(R.string.buy_confirm_COD_phonezone) + " " + this.model.checkoutInfo.address.tel);
            String str2 = this.model.checkoutInfo.address.address;
            String str3 = this.model.checkoutInfo.address.zipcode;
            String str4 = this.model.checkoutInfo.address.city != null ? this.model.checkoutInfo.address.city.name : "";
            String[] split = Html.fromHtml(str2).toString().split("\\[\\-addr\\-\\]");
            if (split.length >= 3) {
                str = split[1] + " " + split[2] + "\n" + str3 + " " + split[0] + " " + str4;
            } else if (split.length == 2) {
                str = split[1] + "\n" + str3 + " " + split[0] + " " + str4;
            } else {
                str = str3 + " " + split[0] + " " + str4;
            }
            this.addressTextView.setText(str);
            this.O0000OOo = this.model.checkoutInfo.address.is_invalid == 0;
            this.O0000Oo0 = this.model.checkoutInfo.address.can_cod == 1;
            if (cad.O00000o()) {
                this.O0000Oo = cas.O000000o(this.model.checkoutInfo.address.limit, Float.MAX_VALUE);
                this.O0000OoO = cas.O000000o(this.model.checkoutInfo.address.limit_cod, Float.MAX_VALUE);
            }
            O00000o0();
        }
        if (this.model.exchange_coupon_count <= 0) {
            this.selectExchangeCouponView.setVisibility(8);
        } else {
            this.selectExchangeCouponTextView.setText(getString(R.string.select_from_n_coupons));
        }
        CheckoutListAdapter checkoutListAdapter = new CheckoutListAdapter(this);
        ((NoScrollListView) findViewById(R.id.cartItemList)).setAdapter((ListAdapter) checkoutListAdapter);
        if (this.model.cartInfo != null) {
            checkoutListAdapter.O000000o((List<NewCheckoutCartItem>) this.model.cartInfo.items);
            this.subtotalTextView.setText(this.model.currency + this.model.cartInfo.productMoney);
        }
        if (this.model.couponsCount <= 0) {
            this.selectCouponView.setVisibility(8);
        } else {
            NewCouponData O000000o2 = O000000o(this.model.couponList);
            if (!(O000000o2 == null || O000000o2.coupons == null || O000000o2.coupons.size() <= 0)) {
                NewCouponItem newCouponItem = O000000o2.coupons.get(0);
                this.model.totalPayTxt = newCouponItem.useinfo.amount;
                this.model.shipmentExpense = newCouponItem.useinfo.shipment;
                this.selectCouponTextView.setText(newCouponItem.couponName);
                this.couponView.setVisibility(0);
                this.couponTextView.setText("-" + this.model.currency + newCouponItem.useinfo.couponDiscountMoney);
                this.couponId = newCouponItem.couponId;
                this.couponType = newCouponItem.type;
            }
        }
        if (this.model.couponsCount <= 0 && this.model.exchange_coupon_count <= 0) {
            this.dividerView.setVisibility(8);
        }
        if (cas.O000000o(this.model.shipmentExpense, 0.0f) <= 0.0f) {
            this.shipTextView.setText((int) R.string.free);
        } else {
            this.shipTextView.setText(this.model.currency + this.model.shipmentExpenseTxt);
        }
        if (this.model.checkoutInfo != null && cas.O000000o(this.model.checkoutInfo.activityDiscountMoney, 0.0f) > 0.0f) {
            this.promoteView.setVisibility(0);
            this.promoteTextView.setText("-" + this.model.currency + this.model.checkoutInfo.activityDiscountMoneyTxt);
        }
        this.totalTextView.setText(this.model.currency + this.model.totalPayTxt);
        this.bottomTotalTextView.setText("Total  " + this.model.currency + this.model.totalPayTxt);
        this.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass4 */

            public final void onClick(View view) {
                Boolean bool;
                CheckoutActivity checkoutActivity = CheckoutActivity.this;
                if (TextUtils.isEmpty(checkoutActivity.addressid)) {
                    cec.O000000o(checkoutActivity, (int) R.string.user_address_empty, 0);
                    bool = Boolean.FALSE;
                } else {
                    bool = Boolean.TRUE;
                }
                if (bool.booleanValue()) {
                    HashMap hashMap = new HashMap();
                    String str = "";
                    hashMap.put("Checkout[best_time]", str);
                    hashMap.put("Checkout[invoice_type]", str);
                    hashMap.put("Checkout[invoice_title]", str);
                    hashMap.put("Checkout[email]", str);
                    hashMap.put("Checkout[is_donate]", str);
                    hashMap.put("Checkout[couponsValue]", TextUtils.isEmpty(checkoutActivity.couponId) ? str : checkoutActivity.couponId);
                    hashMap.put("Checkout[couponsType]", TextUtils.isEmpty(checkoutActivity.couponId) ? "0" : "2");
                    hashMap.put("Checkout[address_id]", checkoutActivity.addressid);
                    hashMap.put("Checkout[authcode]", str);
                    hashMap.put("Checkout[shipment_id]", checkoutActivity.O00000oO);
                    hashMap.put("Checkout[invoice_company_code]", checkoutActivity.gst_code);
                    hashMap.put("Checkout[smartbox_id]", checkoutActivity.smartbox_id);
                    hashMap.put("Checkout[address]", checkoutActivity.O00000oo);
                    hashMap.put("Checkout[zipcode]", checkoutActivity.O00000o);
                    hashMap.put("Checkout[city]", checkoutActivity.O00000Oo);
                    hashMap.put("Checkout[landmark]", checkoutActivity.O00000o0);
                    if (!TextUtils.isEmpty(checkoutActivity.exchangeCouponId)) {
                        str = checkoutActivity.exchangeCouponId;
                    }
                    hashMap.put("Checkout[exchange_voucher_id]", str);
                    String[] O00000Oo = checkoutActivity.O00000Oo();
                    cam cam = new cam(O00000Oo[0], NewSubmitResult.class, hashMap, new cak<NewSubmitResult>(O00000Oo, hashMap) {
                        /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass10 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ String[] f4602O000000o;
                        final /* synthetic */ Map O00000Oo;

                        {
                            this.f4602O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final /* bridge */ /* synthetic */ void O000000o(BaseResult baseResult) {
                            CheckoutActivity.this.O000000o((NewSubmitResult) baseResult);
                        }

                        public final void onErrorResponse(VolleyError volleyError) {
                            if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == 302) {
                                String[] strArr = this.f4602O000000o;
                                if (strArr.length > 1) {
                                    cam cam = new cam(strArr[1], NewSubmitResult.class, this.O00000Oo, new cak<NewSubmitResult>() {
                                        /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass10.AnonymousClass1 */

                                        public final /* synthetic */ void O000000o(BaseResult baseResult) {
                                            CheckoutActivity.this.O000000o((NewSubmitResult) baseResult);
                                            if (AnonymousClass10.this.f4602O000000o[1].startsWith("https")) {
                                                SyncModel.useHttps = true;
                                            } else {
                                                SyncModel.useHttps = false;
                                            }
                                        }

                                        public final void O000000o(String str) {
                                            super.O000000o(str);
                                            if (CheckoutActivity.this.mProgressDialog != null) {
                                                CheckoutActivity.this.mProgressDialog.dismiss();
                                            }
                                            CheckoutActivity.this.finish();
                                        }
                                    });
                                    cam.setTag(CheckoutActivity.TAG);
                                    ced.f13683O000000o.add(cam);
                                    return;
                                }
                            }
                            super.onErrorResponse(volleyError);
                        }

                        public final void O000000o(String str) {
                            super.O000000o(str);
                            if (CheckoutActivity.this.mProgressDialog != null) {
                                CheckoutActivity.this.mProgressDialog.dismiss();
                            }
                            CheckoutActivity.this.finish();
                        }
                    });
                    cam.setTag(CheckoutActivity.TAG);
                    cam.setRetryPolicy(checkoutActivity.O0000O0o);
                    ced.f13683O000000o.add(cam);
                    if (checkoutActivity.mProgressDialog == null) {
                        checkoutActivity.mProgressDialog = new ProgressDialog(checkoutActivity);
                        checkoutActivity.mProgressDialog.setMessage(checkoutActivity.getString(R.string.please_wait));
                        checkoutActivity.mProgressDialog.setIndeterminate(true);
                        checkoutActivity.mProgressDialog.setCancelable(false);
                    }
                    checkoutActivity.mProgressDialog.show();
                }
            }
        });
        this.addressView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass5 */

            public final void onClick(View view) {
                CheckoutActivity.this.chooseAddress();
            }
        });
        this.selectCouponView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass6 */

            public final void onClick(View view) {
                Intent intent = new Intent(CheckoutActivity.this, CouponActivity.class);
                intent.putExtra("com.mi.global.shop.extra_user_coupon_type", "coupon_choose");
                if (!TextUtils.isEmpty(CheckoutActivity.this.model.couponList)) {
                    intent.putExtra("coupon_list", CheckoutActivity.this.model.couponList);
                }
                if (!TextUtils.isEmpty(CheckoutActivity.this.addressid)) {
                    intent.putExtra("address_id", CheckoutActivity.this.addressid);
                }
                if (!TextUtils.isEmpty(CheckoutActivity.this.cityId)) {
                    intent.putExtra("city_id", CheckoutActivity.this.cityId);
                }
                if (!TextUtils.isEmpty(CheckoutActivity.this.exchangeCouponId)) {
                    intent.putExtra("coupon_id", CheckoutActivity.this.exchangeCouponId);
                }
                CheckoutActivity.this.startActivityForResult(intent, 8);
            }
        });
        this.selectExchangeCouponView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass7 */

            public final void onClick(View view) {
                if (CheckoutActivity.this.model != null && !TextUtils.isEmpty(CheckoutActivity.this.model.exchange_deny_reason)) {
                    CheckoutActivity checkoutActivity = CheckoutActivity.this;
                    checkoutActivity.handleExchangeInvalid(checkoutActivity.model.exchange_deny_reason);
                } else if (!CheckoutActivity.this.can_exchange) {
                    CheckoutActivity checkoutActivity2 = CheckoutActivity.this;
                    checkoutActivity2.handleExchangeInvalid(checkoutActivity2.getString(R.string.exchange_coupon_invalid_by_pin_code_dialog_title));
                } else if (CheckoutActivity.this.delivery_mode == 1) {
                    CheckoutActivity checkoutActivity3 = CheckoutActivity.this;
                    checkoutActivity3.handleExchangeInvalid(checkoutActivity3.getString(R.string.exchange_coupon_invalid_by_delivery_dialog_title));
                } else if (CheckoutActivity.this.delivery_mode == 2) {
                    CheckoutActivity checkoutActivity4 = CheckoutActivity.this;
                    checkoutActivity4.handleExchangeInvalid(checkoutActivity4.getString(R.string.exchange_coupon_invalid_by_smart_box_dialog_title));
                } else {
                    Intent intent = new Intent(CheckoutActivity.this, ExchangeCouponActivity.class);
                    intent.putExtra("com.mi.global.shop.extra_user_coupon_type", "coupon_choose");
                    if (!TextUtils.isEmpty(CheckoutActivity.this.model.exchange_coupon_list)) {
                        intent.putExtra("coupon_list", CheckoutActivity.this.model.exchange_coupon_list);
                    }
                    if (!TextUtils.isEmpty(CheckoutActivity.this.addressid)) {
                        intent.putExtra("address_id", CheckoutActivity.this.addressid);
                    }
                    if (!TextUtils.isEmpty(CheckoutActivity.this.cityId)) {
                        intent.putExtra("city_id", CheckoutActivity.this.cityId);
                    }
                    if (!TextUtils.isEmpty(CheckoutActivity.this.couponId)) {
                        intent.putExtra("coupon_id", CheckoutActivity.this.couponId);
                    }
                    if (!TextUtils.isEmpty(CheckoutActivity.this.couponType)) {
                        intent.putExtra("type", CheckoutActivity.this.couponType);
                    }
                    CheckoutActivity.this.startActivityForResult(intent, 26);
                }
            }
        });
        if (this.model.checkoutInfo != null && this.model.checkoutInfo.shipmentlist != null) {
            int i = 0;
            while (true) {
                if (i < this.model.checkoutInfo.shipmentlist.size()) {
                    if (!TextUtils.isEmpty(this.model.checkoutInfo.shipmentlist.get(i).shipment_id) && "54".equals(this.model.checkoutInfo.shipmentlist.get(i).shipment_id)) {
                        this.fourDeliveryData = this.model.checkoutInfo.shipmentlist.get(i);
                        break;
                    }
                    if (i == this.model.checkoutInfo.shipmentlist.size() - 1) {
                        this.fourDeliveryData = null;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        this.fourDeliveryRelativeLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass8 */

            public final void onClick(View view) {
                Intent intent = new Intent(CheckoutActivity.this, DeliveryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("mode", CheckoutActivity.this.delivery_mode);
                if (CheckoutActivity.this.smartBoxData != null) {
                    bundle.putSerializable("delivery_smart", CheckoutActivity.this.smartBoxData);
                }
                if (CheckoutActivity.this.fourDeliveryData != null) {
                    bundle.putSerializable("delivery_fourhour", CheckoutActivity.this.fourDeliveryData);
                    bundle.putString("currency", CheckoutActivity.this.model.currency);
                }
                if (!TextUtils.isEmpty(CheckoutActivity.this.smartbox_id)) {
                    bundle.putString("smartbox_id", CheckoutActivity.this.smartbox_id);
                }
                if (!TextUtils.isEmpty(CheckoutActivity.this.exchangeCouponId)) {
                    bundle.putString("coupon_id", CheckoutActivity.this.exchangeCouponId);
                }
                intent.putExtras(bundle);
                CheckoutActivity.this.startActivityForResult(intent, 25);
            }
        });
        if (this.model.gstin) {
            this.gstRelativeLayout.setVisibility(0);
            this.gstTextView.setText(this.gst_code);
        } else {
            this.gstRelativeLayout.setVisibility(8);
        }
        if (this.gstRelativeLayout.getVisibility() == 0) {
            this.gstRelativeLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass9 */

                public final void onClick(View view) {
                    Intent intent = new Intent(CheckoutActivity.this, GSTActivity.class);
                    intent.putExtra(CheckoutActivity.GST_CODE_S, CheckoutActivity.this.gst_code);
                    CheckoutActivity.this.startActivityForResult(intent, 24);
                }
            });
        }
        NewCheckoutData newCheckoutData = this.model;
        if (newCheckoutData != null) {
            showPageNotice(newCheckoutData.pagemsg);
            if (!TextUtils.isEmpty(this.model.addressList)) {
                this.O0000o00 = this.model.addressList;
            }
            this.O0000o0 = new Gson().toJson(this.model.region);
            if (TextUtils.isEmpty(this.model.addressList) || this.model.addressList.equalsIgnoreCase("[]")) {
                chooseAddress();
            }
        }
    }

    public void handleExchangeInvalid(String str) {
        if (this.model.exchange_coupon_count >= 0) {
            CustomCloseDialog.Builder builder = new CustomCloseDialog.Builder(this);
            builder.O00000Oo = str;
            builder.O000000o(Boolean.TRUE);
            this.mExchangeInvalidDialog = builder.O000000o();
            if (!this.mExchangeInvalidDialog.isShowing()) {
                this.mExchangeInvalidDialog.show();
            }
        }
    }

    private void O000000o(float f, String str) {
        Uri.Builder buildUpon = Uri.parse(cav.O000OoO()).buildUpon();
        buildUpon.appendQueryParameter("totalpay", String.valueOf(f));
        buildUpon.appendQueryParameter("addressid", str);
        if (this.O0000o0o == 1) {
            buildUpon.appendQueryParameter("oneclick", "1");
        }
        cam cam = new cam(buildUpon.toString(), NewChangeAddressResult.class, new cak<NewChangeAddressResult>() {
            /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass3 */

            public final void O000000o(String str) {
            }

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                CheckoutActivity.this.updateAddressView(((NewChangeAddressResult) baseResult).data);
            }
        });
        cam.setTag(TAG);
        ced.f13683O000000o.add(cam);
    }

    /* access modifiers changed from: package-private */
    public final String[] O00000Oo() {
        String[] O0000o0O2 = cav.O0000o0O();
        String[] strArr = new String[O0000o0O2.length];
        for (int i = 0; i < O0000o0O2.length; i++) {
            Uri.Builder buildUpon = Uri.parse(O0000o0O2[i]).buildUpon();
            buildUpon.appendQueryParameter("jsontag", "true");
            buildUpon.appendQueryParameter("security", "true");
            if (this.O0000o0o == 1) {
                buildUpon.appendQueryParameter("oneclick", "1");
            }
            if (byl.O0000OoO()) {
                buildUpon.appendQueryParameter("ot", "5");
            }
            strArr[i] = buildUpon.toString();
        }
        return strArr;
    }

    public void chooseAddress() {
        Intent intent = new Intent(this, AddressListActivity.class);
        intent.putExtra("com.mi.global.shop.extra_user_address_type", "address_choose");
        if (!TextUtils.isEmpty(this.addressid)) {
            intent.putExtra("address_id", this.addressid);
        }
        if (!TextUtils.isEmpty(this.O0000o00)) {
            intent.putExtra("address_list", this.O0000o00);
        }
        if (!TextUtils.isEmpty(this.O0000o0)) {
            intent.putExtra("region_list", this.O0000o0);
        }
        startActivityForResult(intent, 1);
    }

    private void O00000o0() {
        this.addressTipLayout.setVisibility(8);
        if (!this.O0000Oo0) {
            this.addressTipLayout.setVisibility(0);
            this.codNotAvailableTextView.setVisibility(0);
        } else {
            this.codNotAvailableTextView.setVisibility(8);
        }
        if (!this.O0000OOo) {
            this.addressTipLayout.setVisibility(0);
            this.addressMarkView.setVisibility(0);
            this.addressErrorTextView.setVisibility(0);
            this.addressErrorTextView.setText((int) R.string.invalid_address);
            this.placeOrderButton.setEnabled(false);
            return;
        }
        float f = this.O0000Ooo;
        if (f <= this.O0000Oo || f > this.O0000OoO) {
            float f2 = this.O0000Ooo;
            if (f2 <= this.O0000OoO || f2 > this.O0000Oo) {
                float f3 = this.O0000Ooo;
                if (f3 <= this.O0000Oo || f3 <= this.O0000OoO) {
                    this.addressMarkView.setVisibility(8);
                    this.addressErrorTextView.setVisibility(8);
                    this.placeOrderButton.setEnabled(true);
                    return;
                }
                this.addressTipLayout.setVisibility(0);
                this.addressMarkView.setVisibility(0);
                this.addressErrorTextView.setVisibility(0);
                CustomTextView customTextView = this.addressErrorTextView;
                customTextView.setText(getString(R.string.no_devivery_address, new Object[]{this.model.currency + Math.max(this.O0000Oo, this.O0000OoO)}));
                this.placeOrderButton.setEnabled(false);
                return;
            }
            this.addressTipLayout.setVisibility(0);
            this.addressMarkView.setVisibility(8);
            this.addressErrorTextView.setVisibility(0);
            CustomTextView customTextView2 = this.addressErrorTextView;
            customTextView2.setText(getString(R.string.no_COD_limit_address, new Object[]{this.model.currency + this.O0000OoO}));
            this.placeOrderButton.setEnabled(true);
            return;
        }
        this.addressTipLayout.setVisibility(0);
        this.addressMarkView.setVisibility(8);
        this.addressErrorTextView.setVisibility(0);
        CustomTextView customTextView3 = this.addressErrorTextView;
        customTextView3.setText(getString(R.string.no_prepayment_address, new Object[]{this.model.currency + this.O0000Oo}));
        this.placeOrderButton.setEnabled(true);
    }

    public void updateAddressView(NewChangeAddressData newChangeAddressData) {
        if (newChangeAddressData != null) {
            if (newChangeAddressData.valid) {
                this.addressMarkView.setVisibility(8);
                if (newChangeAddressData.isCos) {
                    this.placeOrderButton.setEnabled(false);
                } else {
                    this.placeOrderButton.setEnabled(true);
                }
            } else {
                this.addressMarkView.setVisibility(0);
                this.placeOrderButton.setEnabled(false);
            }
            this.addressTipLayout.setVisibility(8);
            if (TextUtils.isEmpty(newChangeAddressData.codtext)) {
                this.codNotAvailableTextView.setVisibility(8);
            } else {
                this.addressTipLayout.setVisibility(0);
                this.codNotAvailableTextView.setVisibility(0);
                this.codNotAvailableTextView.setText(newChangeAddressData.codtext);
            }
            if (TextUtils.isEmpty(newChangeAddressData.producttext)) {
                this.addressErrorTextView.setVisibility(8);
            } else {
                this.addressTipLayout.setVisibility(0);
                this.addressErrorTextView.setVisibility(0);
                this.addressErrorTextView.setText(newChangeAddressData.producttext);
            }
            if (newChangeAddressData.shipmentlist != null) {
                int i = 0;
                while (true) {
                    if (i < newChangeAddressData.shipmentlist.size()) {
                        if (!TextUtils.isEmpty(newChangeAddressData.shipmentlist.get(i).shipment_id) && "54".equals(newChangeAddressData.shipmentlist.get(i).shipment_id)) {
                            this.fourDeliveryData = newChangeAddressData.shipmentlist.get(i);
                            break;
                        }
                        if (i == newChangeAddressData.shipmentlist.size() - 1) {
                            this.fourDeliveryData = null;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                this.fourDeliveryData = null;
            }
            if (!TextUtils.isEmpty(newChangeAddressData.hint)) {
                this.deliveryNotice.setText(newChangeAddressData.hint);
                this.noticeContainer.setVisibility(0);
                this.smartBoxData = newChangeAddressData.smartboxdata;
            } else {
                this.noticeContainer.setVisibility(8);
                this.smartBoxData = null;
            }
            this.can_exchange = newChangeAddressData.can_exchange;
            if (!this.can_exchange) {
                O00000o();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: protected */
    public final void O000000o(NewSubmitResult newSubmitResult) {
        this.gst_code = "";
        NewSubmitData newSubmitData = newSubmitResult.data;
        if (newSubmitData != null) {
            ccr.O00000Oo(TAG, "recordCheckoutEvent start");
            AppEventsLogger newLogger = AppEventsLogger.newLogger(this);
            try {
                if (!(this.model == null || this.model.cartInfo == null || this.model.cartInfo.items == null)) {
                    Iterator<NewCheckoutCartItem> it = this.model.cartInfo.items.iterator();
                    while (it.hasNext()) {
                        NewCheckoutCartItem next = it.next();
                        Bundle bundle = new Bundle();
                        bundle.putString("fb_num_items", String.valueOf(next.num));
                        bundle.putString("fb_content_id", next.goodsId);
                        bundle.putString("fb_currency", next.price);
                        newLogger.logEvent("fb_mobile_initiated_checkout", Double.parseDouble(this.model.totalpay), bundle);
                        ccr.O00000Oo(TAG, "recordCheckoutEvent finished");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4599O000000o = newSubmitData.order_id;
            cbe.O000000o("order", TAG, "", "order_id", this.f4599O000000o);
            String str = newSubmitData.link;
            boolean z = newSubmitData.is_zero_order;
            String replaceAll = str.replaceAll("\\/", "/");
            String substring = replaceAll.substring(replaceAll.indexOf("/in/buy/confirm?id=") + 19);
            if (substring.indexOf(38) >= 0) {
                substring = substring.substring(0, substring.indexOf(38));
            }
            if (cad.O00000o()) {
                if (z) {
                    Intent intent = new Intent(this, OrderViewActivity.class);
                    intent.putExtra("orderview_orderid", this.f4599O000000o);
                    startActivity(intent);
                    setResult(-1, new Intent());
                    finish();
                } else {
                    this.f4599O000000o = substring;
                    Intent intent2 = new Intent(this, ConfirmActivity.class);
                    intent2.putExtra("is_from_checkout", true);
                    intent2.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", this.f4599O000000o);
                    startActivity(intent2);
                    setResult(-1, new Intent());
                    finish();
                }
                updateShoppingCart(0);
                return;
            }
            Intent intent3 = new Intent();
            intent3.putExtra("url", replaceAll);
            setResult(-1, intent3);
            finish();
        }
    }

    public void onDestroy() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        if (i3 == 1) {
            String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_address", "");
            if (!TextUtils.isEmpty(O00000Oo2)) {
                this.O0000o00 = O00000Oo2;
            }
            if (i4 == -1) {
                if (this.O0000o0O) {
                    this.O0000o0O = false;
                    this.addAddressView.setVisibility(8);
                    this.addressContent.setVisibility(0);
                }
                String str = this.addressid;
                this.addressid = intent2.getStringExtra("address_id");
                this.cityId = intent2.getStringExtra("city_id");
                if (TextUtils.isEmpty(this.addressid) || !this.addressid.equals(str)) {
                    this.noticeContainer.setVisibility(8);
                    this.smartBoxData = null;
                    this.fourDeliveryData = null;
                    this.deliveryNameTextView.setText("Home Delivery");
                    this.O00000oO = "0";
                    this.smartbox_id = "";
                    this.O00000oo = "";
                    this.O00000Oo = "";
                    this.O00000o0 = "";
                    this.delivery_mode = 0;
                }
                O000000o(this.O0000Ooo, this.addressid);
                this.O00000o = intent2.getStringExtra("zipcode");
                this.consigneeTextView.setText(intent2.getStringExtra("name"));
                this.phoneTextView.setText(getString(R.string.buy_confirm_COD_phonezone) + " " + intent2.getStringExtra("tel"));
                String stringExtra = intent2.getStringExtra("address");
                String stringExtra2 = intent2.getStringExtra("zipcode");
                String stringExtra3 = intent2.getStringExtra("city");
                String stringExtra4 = intent2.getStringExtra("landmark");
                String stringExtra5 = intent2.getStringExtra("state");
                if (!TextUtils.isEmpty(stringExtra4)) {
                    stringExtra = stringExtra + "  " + stringExtra4;
                }
                if (!TextUtils.isEmpty(stringExtra3)) {
                    stringExtra2 = stringExtra2 + "  " + stringExtra3;
                }
                if (!TextUtils.isEmpty(stringExtra5)) {
                    stringExtra2 = stringExtra2 + "  " + stringExtra5;
                }
                this.addressTextView.setText(stringExtra + "\n" + stringExtra2);
                this.O0000OOo = "0".equals(intent2.getStringExtra("is_invalid"));
                this.O0000Oo0 = "1".equals(intent2.getStringExtra("can_cod"));
                this.O0000Oo = cas.O000000o(intent2.getStringExtra("limit"), Float.MAX_VALUE);
                this.O0000OoO = cas.O000000o(intent2.getStringExtra("limit_cod"), Float.MAX_VALUE);
                O00000o0();
            }
        } else if (i3 != 8) {
            switch (i3) {
                case 24:
                    if (i4 == -1) {
                        this.gst_code = intent2.getStringExtra(GST_CODE_S);
                        if (this.gst_code == null) {
                            this.gst_code = "";
                        }
                        CustomTextView customTextView = this.gstTextView;
                        if (customTextView != null) {
                            customTextView.setText(this.gst_code);
                            return;
                        }
                        return;
                    }
                    return;
                case 25:
                    if (i4 == -1) {
                        this.smartbox_id = "";
                        this.O00000oo = "";
                        this.O00000Oo = "";
                        this.O00000o0 = "";
                        this.delivery_mode = intent2.getIntExtra("mode", 0);
                        int i5 = this.delivery_mode;
                        if (i5 == 1) {
                            this.deliveryNameTextView.setText("Express Delivery");
                            this.O00000oO = "54";
                            O00000o();
                            return;
                        } else if (i5 == 2) {
                            SmartDetailItemData smartDetailItemData = (SmartDetailItemData) intent2.getSerializableExtra("smart_selected");
                            this.deliveryNameTextView.setText(smartDetailItemData.shortName);
                            this.O00000oO = "6";
                            this.smartbox_id = smartDetailItemData.id;
                            this.O00000oo = smartDetailItemData.address;
                            this.O00000Oo = smartDetailItemData.city;
                            this.O00000o0 = smartDetailItemData.shortName;
                            O00000o();
                            return;
                        } else {
                            this.deliveryNameTextView.setText("Home Delivery");
                            this.O00000oO = "0";
                            return;
                        }
                    } else {
                        return;
                    }
                case 26:
                    if (i4 == -1 && intent2 != null) {
                        this.exchangeCouponId = intent2.getStringExtra("coupon_id");
                        if (!TextUtils.isEmpty(this.exchangeCouponId)) {
                            this.selectExchangeCouponTextView.setText(getString(R.string.user_exchange_coupon_item_title) + " " + this.model.currency + intent2.getStringExtra("couponDiscountMoney"));
                            this.exchangeCouponView.setVisibility(0);
                            this.exchangeCouponTextView.setText("-" + this.model.currency + intent2.getStringExtra("couponDiscountMoney"));
                        } else {
                            this.selectExchangeCouponTextView.setText(getString(R.string.select_from_n_coupons));
                            this.exchangeCouponView.setVisibility(8);
                        }
                        String stringExtra6 = intent2.getStringExtra("shipment");
                        if (cas.O000000o(stringExtra6, 0.0f) <= 0.0f) {
                            this.shipTextView.setText((int) R.string.free);
                        } else if (this.model != null) {
                            this.shipTextView.setText(this.model.currency + stringExtra6);
                        } else {
                            return;
                        }
                        this.totalTextView.setText(this.model.currency + intent2.getStringExtra("amount"));
                        this.bottomTotalTextView.setText(this.model.currency + intent2.getStringExtra("amount"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i4 == -1 && intent2 != null) {
            this.couponId = intent2.getStringExtra("coupon_id");
            this.couponType = intent2.getStringExtra("type");
            if (!TextUtils.isEmpty(this.couponId)) {
                this.couponView.setVisibility(0);
                this.selectCouponTextView.setText(intent2.getStringExtra("name"));
            } else {
                this.selectCouponTextView.setText(getString(R.string.select_from_n_coupons));
                this.couponView.setVisibility(8);
            }
            String stringExtra7 = intent2.getStringExtra("shipment");
            if (cas.O000000o(stringExtra7, 0.0f) <= 0.0f) {
                this.shipTextView.setText((int) R.string.free);
            } else if (this.model != null) {
                this.shipTextView.setText(this.model.currency + stringExtra7);
            } else {
                return;
            }
            this.couponTextView.setText("-" + this.model.currency + intent2.getStringExtra("couponDiscountMoney"));
            this.totalTextView.setText(this.model.currency + intent2.getStringExtra("amount"));
            this.bottomTotalTextView.setText(this.model.currency + intent2.getStringExtra("amount"));
        }
    }

    private void O00000o() {
        if (!TextUtils.isEmpty(this.exchangeCouponId)) {
            HashMap hashMap = new HashMap(6);
            hashMap.put("id", this.cityId);
            hashMap.put("address_id", this.addressid);
            hashMap.put("payment", "55");
            hashMap.put("cardtype", "no");
            if (!TextUtils.isEmpty(this.couponId)) {
                hashMap.put("value", this.couponId);
            }
            hashMap.put("exchange_coupon_id", "0");
            cam cam = new cam(cav.O000o(), NewPaymentCouponResult.class, hashMap, new cak<NewPaymentCouponResult>() {
                /* class com.mi.global.shop.activity.CheckoutActivity.AnonymousClass2 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewPaymentCouponResult newPaymentCouponResult = (NewPaymentCouponResult) baseResult;
                    if (newPaymentCouponResult != null && newPaymentCouponResult.data != null && newPaymentCouponResult.data.checkout != null) {
                        CheckoutActivity checkoutActivity = CheckoutActivity.this;
                        checkoutActivity.exchangeCouponId = null;
                        checkoutActivity.selectExchangeCouponTextView.setText(CheckoutActivity.this.getString(R.string.select_from_n_coupons));
                        CheckoutActivity.this.exchangeCouponView.setVisibility(8);
                        String str = newPaymentCouponResult.data.checkout.shipment;
                        if (cas.O000000o(newPaymentCouponResult.data.checkout.shipment, 0.0f) <= 0.0f) {
                            CheckoutActivity.this.shipTextView.setText((int) R.string.free);
                        } else if (CheckoutActivity.this.model != null) {
                            CustomTextView customTextView = CheckoutActivity.this.shipTextView;
                            customTextView.setText(CheckoutActivity.this.model.currency + str);
                        }
                        CustomTextView customTextView2 = CheckoutActivity.this.totalTextView;
                        customTextView2.setText(CheckoutActivity.this.model.currency + newPaymentCouponResult.data.checkout.need_pay_amount);
                        CustomTextView customTextView3 = CheckoutActivity.this.bottomTotalTextView;
                        customTextView3.setText(CheckoutActivity.this.model.currency + newPaymentCouponResult.data.checkout.need_pay_amount);
                    }
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                }
            });
            cam.setTag(TAG);
            ced.f13683O000000o.add(cam);
        }
    }

    private static NewCouponData O000000o(String str) {
        try {
            return (NewCouponData) new Gson().fromJson("{\"coupons\":" + str + "}", NewCouponData.class);
        } catch (Exception e) {
            ccr.O00000Oo(TAG, "JSON parse error");
            e.printStackTrace();
            CrashReport.postCrash(Thread.currentThread(), e);
            return null;
        }
    }
}
