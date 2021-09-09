package com.mi.global.shop.user;

import _m_j.cak;
import _m_j.cam;
import _m_j.cav;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.adapter.user.ExchangeCouponListAdapter;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.user.coupon.NewPaymentCouponResult;
import com.mi.global.shop.newmodel.user.exchangecoupon.coupon.NewExchangeCouponData;
import com.mi.global.shop.newmodel.user.exchangecoupon.coupon.NewExchangeCouponItem;
import com.mi.multimonitor.CrashReport;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;

public class ExchangeCouponActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4917O000000o = "ExchangeCouponActivity";
    private View O00000Oo;
    private ExchangeCouponListAdapter O00000o;
    private ListView O00000o0;
    private NewExchangeCouponData O00000oO;
    private ArrayList<NewExchangeCouponItem> O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private View O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    public ProgressDialog mProgressDialog;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_coupon_list);
        setTitle((int) R.string.user_exchange_coupon_title);
        this.mCartView.setVisibility(4);
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(this);
        Intent intent = getIntent();
        this.O0000O0o = intent.getStringExtra("com.mi.global.shop.extra_user_coupon_type");
        if (TextUtils.isEmpty(this.O0000O0o)) {
            ccr.O00000Oo(f4917O000000o, "mAccessType is null");
            finish();
            return;
        }
        this.O0000OOo = intent.getStringExtra("address_id");
        this.O0000Oo0 = intent.getStringExtra("coupon_id");
        this.O0000OoO = intent.getStringExtra("city_id");
        this.O00000oo = new ArrayList<>();
        this.O00000Oo = findViewById(R.id.user_no_coupon);
        this.O00000o0 = (ListView) findViewById(R.id.user_coupon_list);
        this.O00000o = new ExchangeCouponListAdapter(this, this.O0000O0o);
        if ("coupon_choose".equalsIgnoreCase(this.O0000O0o)) {
            String stringExtra = intent.getStringExtra("coupon_list");
            try {
                this.O00000oO = (NewExchangeCouponData) new Gson().fromJson("{\"exchange_coupon_list\":" + stringExtra + "}", NewExchangeCouponData.class);
                NewExchangeCouponData newExchangeCouponData = this.O00000oO;
                if (newExchangeCouponData == null || newExchangeCouponData.exchange_coupon_list == null) {
                    O00000Oo();
                    this.O0000Oo = LayoutInflater.from(this).inflate((int) R.layout.shop_unuse_coupon_item, (ViewGroup) this.O00000o0, false);
                    this.O00000o0.addHeaderView(this.O0000Oo);
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.mi.global.shop.user.ExchangeCouponActivity.AnonymousClass1 */

                        public final void onClick(View view) {
                            ExchangeCouponActivity.this.onCouponClick(null);
                        }
                    });
                } else {
                    this.O00000oo = newExchangeCouponData.exchange_coupon_list;
                    if (this.O00000oo.size() == 0) {
                        this.O00000Oo.setVisibility(0);
                    } else {
                        this.O00000o.O00000o0();
                        this.O00000o.O000000o((ArrayList) this.O00000oo);
                        if (this.O0000O0o.equalsIgnoreCase("coupon_choose")) {
                            this.O00000o0.setOnItemClickListener(this);
                        }
                    }
                    this.O0000Oo = LayoutInflater.from(this).inflate((int) R.layout.shop_unuse_coupon_item, (ViewGroup) this.O00000o0, false);
                    this.O00000o0.addHeaderView(this.O0000Oo);
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.mi.global.shop.user.ExchangeCouponActivity.AnonymousClass1 */

                        public final void onClick(View view) {
                            ExchangeCouponActivity.this.onCouponClick(null);
                        }
                    });
                }
            } catch (Exception e) {
                ccr.O00000Oo(f4917O000000o, "JSON parse error");
                e.printStackTrace();
                CrashReport.postCrash(Thread.currentThread(), e);
                O00000Oo();
            }
        }
        this.O00000o0.setAdapter((ListAdapter) this.O00000o);
    }

    private void O00000Oo() {
        cec.O000000o(this, (int) R.string.shop_error_network, 0);
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        setResult(0);
        finish();
        ccr.O00000Oo(f4917O000000o, "JSON parse error");
    }

    public void onClick(View view) {
        try {
            if (view.getId() == R.id.title_bar_back) {
                if (this.mProgressDialog != null) {
                    this.mProgressDialog.dismiss();
                }
                setResult(0);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        setResult(0);
        finish();
        super.onBackPressed();
    }

    public void onDestroy() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView == this.O00000o0 && this.O0000O0o.equalsIgnoreCase("coupon_choose")) {
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            if (itemAtPosition instanceof NewExchangeCouponItem) {
                NewExchangeCouponItem newExchangeCouponItem = (NewExchangeCouponItem) itemAtPosition;
                if (!TextUtils.isEmpty(newExchangeCouponItem.id)) {
                    onCouponClick(newExchangeCouponItem);
                }
            }
        }
    }

    public void onCouponClick(final NewExchangeCouponItem newExchangeCouponItem) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.O0000OoO);
        hashMap.put("address_id", this.O0000OOo);
        hashMap.put("payment", "55");
        hashMap.put("cardtype", "no");
        if (!TextUtils.isEmpty(this.O0000Oo0)) {
            hashMap.put("value", this.O0000Oo0);
        }
        if (newExchangeCouponItem == null) {
            str = "0";
        } else {
            str = newExchangeCouponItem.id;
        }
        hashMap.put("exchange_coupon_id", str);
        cam cam = new cam(cav.O000o(), NewPaymentCouponResult.class, hashMap, new cak<NewPaymentCouponResult>() {
            /* class com.mi.global.shop.user.ExchangeCouponActivity.AnonymousClass2 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewPaymentCouponResult newPaymentCouponResult = (NewPaymentCouponResult) baseResult;
                if (ExchangeCouponActivity.this.mProgressDialog != null) {
                    ExchangeCouponActivity.this.mProgressDialog.dismiss();
                }
                if (!(newPaymentCouponResult == null || newPaymentCouponResult.data == null)) {
                    if (newExchangeCouponItem != null && newPaymentCouponResult.data.exchange_coupon != null && newPaymentCouponResult.data.exchange_coupon.allow == 0) {
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.exchange_coupon.deny_reason)) {
                            cec.O000000o(ExchangeCouponActivity.this, newPaymentCouponResult.data.exchange_coupon.deny_reason, 0);
                        }
                        ExchangeCouponActivity.this.finish();
                        return;
                    } else if (newPaymentCouponResult.data.checkout != null) {
                        Intent intent = new Intent();
                        NewExchangeCouponItem newExchangeCouponItem = newExchangeCouponItem;
                        if (newExchangeCouponItem != null && !TextUtils.isEmpty(newExchangeCouponItem.id)) {
                            intent.putExtra("coupon_id", newExchangeCouponItem.id);
                        }
                        NewExchangeCouponItem newExchangeCouponItem2 = newExchangeCouponItem;
                        if (newExchangeCouponItem2 != null && !TextUtils.isEmpty(newExchangeCouponItem2.amount)) {
                            intent.putExtra("amount", newExchangeCouponItem.amount);
                        }
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.checkout.exchange_coupon_amount)) {
                            intent.putExtra("couponDiscountMoney", newPaymentCouponResult.data.checkout.exchange_coupon_amount);
                        }
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.checkout.shipment)) {
                            intent.putExtra("shipment", newPaymentCouponResult.data.checkout.shipment);
                        }
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.checkout.need_pay_amount)) {
                            intent.putExtra("amount", newPaymentCouponResult.data.checkout.need_pay_amount);
                        }
                        ExchangeCouponActivity.this.setResult(-1, intent);
                    }
                }
                ExchangeCouponActivity.this.finish();
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                if (ExchangeCouponActivity.this.mProgressDialog != null) {
                    ExchangeCouponActivity.this.mProgressDialog.dismiss();
                }
                ExchangeCouponActivity.this.finish();
            }
        });
        cam.setTag(f4917O000000o);
        ced.f13683O000000o.add(cam);
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(this);
            this.mProgressDialog.setMessage(getString(R.string.please_wait));
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.setCancelable(false);
        }
        this.mProgressDialog.show();
    }
}
