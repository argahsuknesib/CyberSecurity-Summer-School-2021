package com.mi.global.shop.user;

import _m_j.byl;
import _m_j.bzs;
import _m_j.cak;
import _m_j.cal;
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
import com.android.volley.Request;
import com.google.gson.Gson;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.adapter.user.CouponListAdapter;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.user.coupon.NewCouponData;
import com.mi.global.shop.newmodel.user.coupon.NewCouponItem;
import com.mi.global.shop.newmodel.user.coupon.NewCouponResult;
import com.mi.global.shop.newmodel.user.coupon.NewPaymentCouponResult;
import com.mi.multimonitor.CrashReport;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;

public class CouponActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4913O000000o = "CouponActivity";
    private View O00000Oo;
    private CouponListAdapter O00000o;
    private ListView O00000o0;
    private NewCouponData O00000oO;
    private ArrayList<NewCouponItem> O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private View O0000OoO;
    public ProgressDialog mProgressDialog;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        Request request;
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_coupon_list);
        setTitle((int) R.string.user_coupon_title);
        this.mCartView.setVisibility(4);
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(this);
        Intent intent = getIntent();
        this.O0000O0o = intent.getStringExtra("com.mi.global.shop.extra_user_coupon_type");
        if (TextUtils.isEmpty(this.O0000O0o)) {
            ccr.O00000Oo(f4913O000000o, "accessType is null");
            finish();
            return;
        }
        this.O0000OOo = intent.getStringExtra("address_id");
        this.O0000Oo0 = intent.getStringExtra("city_id");
        this.O0000Oo = intent.getStringExtra("coupon_id");
        bzs.O000000o(getResources());
        this.O00000oo = new ArrayList<>();
        this.O00000Oo = findViewById(R.id.user_no_coupon);
        this.O00000o0 = (ListView) findViewById(R.id.user_coupon_list);
        this.O00000o = new CouponListAdapter(this, this.O0000O0o);
        if ("coupon_manage".equalsIgnoreCase(this.O0000O0o)) {
            AnonymousClass2 r1 = new cak<NewCouponResult>() {
                /* class com.mi.global.shop.user.CouponActivity.AnonymousClass2 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewCouponResult newCouponResult = (NewCouponResult) baseResult;
                    if (CouponActivity.this.mProgressDialog != null) {
                        CouponActivity.this.mProgressDialog.dismiss();
                    }
                    CouponActivity.this.updateUi(newCouponResult.data);
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    if (CouponActivity.this.mProgressDialog != null) {
                        CouponActivity.this.mProgressDialog.dismiss();
                    }
                    CouponActivity.this.finish();
                }
            };
            String O000O0o = cav.O000O0o();
            if (byl.O0000OoO()) {
                request = new cam(O000O0o, NewCouponResult.class, r1);
            } else {
                request = new cal(O000O0o, NewCouponResult.class, r1);
            }
            request.setTag(f4913O000000o);
            ced.f13683O000000o.add(request);
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(this);
                this.mProgressDialog.setMessage(getString(R.string.please_wait));
                this.mProgressDialog.setIndeterminate(true);
                this.mProgressDialog.setCancelable(false);
            }
            this.mProgressDialog.show();
        }
        if ("coupon_choose".equalsIgnoreCase(this.O0000O0o)) {
            String stringExtra = intent.getStringExtra("coupon_list");
            try {
                this.O00000oO = (NewCouponData) new Gson().fromJson("{\"coupons\":" + stringExtra + "}", NewCouponData.class);
                updateUi(this.O00000oO);
            } catch (Exception e) {
                ccr.O00000Oo(f4913O000000o, "JSON parse error");
                e.printStackTrace();
                CrashReport.postCrash(Thread.currentThread(), e);
                O00000Oo();
            }
            this.O0000OoO = LayoutInflater.from(this).inflate((int) R.layout.shop_unuse_coupon_item, (ViewGroup) this.O00000o0, false);
            this.O00000o0.addHeaderView(this.O0000OoO);
            this.O0000OoO.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.user.CouponActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    CouponActivity.this.onCouponClick(null);
                }
            });
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
        ccr.O00000Oo(f4913O000000o, "JSON parse error");
    }

    public void updateUi(NewCouponData newCouponData) {
        if (newCouponData == null || newCouponData.coupons == null) {
            O00000Oo();
            return;
        }
        String str = f4913O000000o;
        ccr.O00000Oo(str, "model length:" + newCouponData.coupons.size());
        this.O00000oo = newCouponData.coupons;
        if (this.O00000oo.size() == 0) {
            this.O00000Oo.setVisibility(0);
            return;
        }
        this.O00000o.O00000o0();
        this.O00000o.O000000o((ArrayList) this.O00000oo);
        if (this.O0000O0o.equalsIgnoreCase("coupon_choose")) {
            this.O00000o0.setOnItemClickListener(this);
        }
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
            if (itemAtPosition instanceof NewCouponItem) {
                NewCouponItem newCouponItem = (NewCouponItem) itemAtPosition;
                if (!TextUtils.isEmpty(newCouponItem.couponId)) {
                    onCouponClick(newCouponItem);
                }
            }
        }
    }

    public void onCouponClick(final NewCouponItem newCouponItem) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.O0000Oo0);
        hashMap.put("address_id", this.O0000OOo);
        hashMap.put("payment", "55");
        hashMap.put("cardtype", "no");
        if (newCouponItem == null) {
            str = "0";
        } else {
            str = newCouponItem.couponId;
        }
        hashMap.put("value", str);
        if (!TextUtils.isEmpty(this.O0000Oo)) {
            hashMap.put("exchange_coupon_id", this.O0000Oo);
        }
        cam cam = new cam(cav.O000o(), NewPaymentCouponResult.class, hashMap, new cak<NewPaymentCouponResult>() {
            /* class com.mi.global.shop.user.CouponActivity.AnonymousClass3 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewPaymentCouponResult newPaymentCouponResult = (NewPaymentCouponResult) baseResult;
                if (CouponActivity.this.mProgressDialog != null) {
                    CouponActivity.this.mProgressDialog.dismiss();
                }
                if (!(newPaymentCouponResult == null || newPaymentCouponResult.data == null)) {
                    if (newPaymentCouponResult.data.coupon != null && "refuse".equals(newPaymentCouponResult.data.coupon.result)) {
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.coupon.reason)) {
                            cec.O000000o(CouponActivity.this, newPaymentCouponResult.data.coupon.reason, 0);
                        }
                        CouponActivity.this.finish();
                        return;
                    } else if (newPaymentCouponResult.data.checkout != null) {
                        Intent intent = new Intent();
                        NewCouponItem newCouponItem = newCouponItem;
                        if (newCouponItem != null && !TextUtils.isEmpty(newCouponItem.couponId)) {
                            intent.putExtra("coupon_id", newCouponItem.couponId);
                        }
                        NewCouponItem newCouponItem2 = newCouponItem;
                        if (newCouponItem2 != null && !TextUtils.isEmpty(newCouponItem2.type)) {
                            intent.putExtra("type", newCouponItem.type);
                        }
                        NewCouponItem newCouponItem3 = newCouponItem;
                        if (newCouponItem3 != null && !TextUtils.isEmpty(newCouponItem3.couponName)) {
                            intent.putExtra("name", newCouponItem.couponName);
                        }
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.checkout.couponDiscountMoney)) {
                            intent.putExtra("couponDiscountMoney", newPaymentCouponResult.data.checkout.couponDiscountMoney);
                        }
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.checkout.shipment)) {
                            intent.putExtra("shipment", newPaymentCouponResult.data.checkout.shipment);
                        }
                        if (!TextUtils.isEmpty(newPaymentCouponResult.data.checkout.need_pay_amount)) {
                            intent.putExtra("amount", newPaymentCouponResult.data.checkout.need_pay_amount);
                        }
                        CouponActivity.this.setResult(-1, intent);
                    }
                }
                CouponActivity.this.finish();
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                if (CouponActivity.this.mProgressDialog != null) {
                    CouponActivity.this.mProgressDialog.dismiss();
                }
                CouponActivity.this.finish();
            }
        });
        cam.setTag(f4913O000000o);
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
