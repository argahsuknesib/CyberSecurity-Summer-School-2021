package com.mi.global.shop.buy;

import _m_j.byl;
import _m_j.byx;
import _m_j.byz;
import _m_j.bzc;
import _m_j.bzg;
import _m_j.bzi;
import _m_j.bzj;
import _m_j.bzk;
import _m_j.bzq;
import _m_j.bzs;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cav;
import _m_j.cax;
import _m_j.cbe;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import _m_j.ee;
import _m_j.ei;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.OrderListAcitvity;
import com.mi.global.shop.activity.PayResultWebActivity;
import com.mi.global.shop.activity.SuccessAcitvity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.buy.model.BuyOrderInfo;
import com.mi.global.shop.buy.model.BuyOrderItem;
import com.mi.global.shop.buy.model.OrderPaymentInfo;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.model.SyncModel;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.mi.global.shop.newmodel.pay.payinfo.NewPayInfoData;
import com.mi.global.shop.newmodel.pay.payinfo.NewPayInfoResult;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.dialog.CustomCancelDialog;
import com.mi.multimonitor.CrashReport;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfirmActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected OrderPaymentInfo f4847O000000o = null;
    private String O00000Oo = "";
    private View O00000o;
    private bzi O00000o0;
    private HashMap<String, String> O00000oO;
    private double O00000oo = -1.0d;
    private JSONObject O0000O0o = null;
    private BuyOrderInfo O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private bzg O0000OoO = null;
    private byz O0000Ooo = null;
    private bzj O0000o = null;
    private byx O0000o0 = null;
    private bzc O0000o00 = null;
    private CardlessEMIfragment O0000o0O = null;
    private UPIFragment O0000o0o = null;
    private cax O0000oO;
    private CustomCancelDialog O0000oO0;
    public bzk codViewHelper = null;
    public ee mFragmentManager;

    public void onCreate(Bundle bundle) {
        Request request;
        if (bundle != null) {
            ccr.O00000Oo("ConfirmActivity", "onCreate, savedInstanceState:" + bundle.toString());
            this.f4847O000000o = (OrderPaymentInfo) bundle.getParcelable("orderPaymentInfo");
            this.O0000OOo = (BuyOrderInfo) bundle.getParcelable("confirmOrder");
        }
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_buy_confirm_activity);
        setTitle((int) R.string.buy_confirm_title);
        bzs.O000000o(getResources());
        this.O00000Oo = getIntent().getStringExtra("com.mi.global.shop.extra_buy_confirm_orderid");
        if (TextUtils.isEmpty(this.O00000Oo)) {
            ccr.O00000Oo("ConfirmActivity", "orderId is null");
            finish();
        }
        ccr.O00000Oo("ConfirmActivity", "get orderId:" + this.O00000Oo);
        this.mCartView.setVisibility(4);
        this.O00000o = findViewById(R.id.title_bar_home);
        this.O00000o.setVisibility(0);
        this.O00000o.setOnClickListener(this);
        this.mFragmentManager = getSupportFragmentManager();
        if (bundle != null) {
            this.O00000o0 = (bzi) this.mFragmentManager.O000000o(bzi.class.getName());
        }
        ei O000000o2 = this.mFragmentManager.O000000o();
        if (this.O00000o0 == null) {
            this.O00000o0 = new bzi();
            O000000o2.O000000o(R.id.confirm_fragment_top_container, this.O00000o0, bzi.class.getName());
        }
        O000000o2.O00000o0();
        final String[] O00000Oo2 = O00000Oo();
        AnonymousClass1 r1 = new cak<NewPayInfoResult>() {
            /* class com.mi.global.shop.buy.ConfirmActivity.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewPayInfoResult newPayInfoResult = (NewPayInfoResult) baseResult;
                if (BaseActivity.isActivityAlive(ConfirmActivity.this)) {
                    ConfirmActivity.this.hideLoading();
                    ConfirmActivity.this.handlePayInfoResult(newPayInfoResult);
                }
            }

            public final void onErrorResponse(VolleyError volleyError) {
                if (BaseActivity.isActivityAlive(ConfirmActivity.this)) {
                    if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == 302) {
                        String[] strArr = O00000Oo2;
                        if (strArr.length > 1) {
                            cam cam = new cam(strArr[1], NewPayInfoResult.class, new cak<NewPayInfoResult>() {
                                /* class com.mi.global.shop.buy.ConfirmActivity.AnonymousClass1.AnonymousClass1 */

                                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                                    NewPayInfoResult newPayInfoResult = (NewPayInfoResult) baseResult;
                                    if (BaseActivity.isActivityAlive(ConfirmActivity.this)) {
                                        ConfirmActivity.this.hideLoading();
                                        ConfirmActivity.this.handlePayInfoResult(newPayInfoResult);
                                        if (O00000Oo2[1].startsWith("https")) {
                                            SyncModel.useHttps = true;
                                        } else {
                                            SyncModel.useHttps = false;
                                        }
                                    }
                                }

                                public final void O000000o(String str) {
                                    super.O000000o(str);
                                    ConfirmActivity.this.hideLoading();
                                    ConfirmActivity.this.finish();
                                }
                            });
                            cam.setTag("ConfirmActivity");
                            ced.f13683O000000o.add(cam);
                            return;
                        }
                    }
                    super.onErrorResponse(volleyError);
                }
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                ccr.O00000Oo("ConfirmActivity", "getOrderViewInfo Exception:".concat(String.valueOf(str)));
                ConfirmActivity.this.hideLoading();
                ConfirmActivity.this.finish();
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(O00000Oo2[0], NewPayInfoResult.class, r1);
        } else {
            request = new cal(O00000Oo2[0], NewPayInfoResult.class, r1);
        }
        request.setTag("ConfirmActivity");
        ced.f13683O000000o.add(request);
        showLoading();
    }

    public String getAfterPaySuccessUrl() {
        return this.O0000Oo;
    }

    public void setAfterPaySuccessUrl(String str) {
        this.O0000Oo = str;
    }

    public void handlePayInfoResult(NewPayInfoResult newPayInfoResult) {
        bzi bzi;
        NewPageMessage newPageMessage;
        ConfirmActivity confirmActivity;
        NewPayInfoData newPayInfoData = newPayInfoResult.data;
        if (newPayInfoData == null) {
            cec.O000000o(this, getString(R.string.shop_network_unavaliable), 0);
            finish();
            return;
        }
        try {
            this.O0000O0o = new JSONObject(newPayInfoData.toJsonString());
            this.f4847O000000o = new OrderPaymentInfo(this.O0000O0o);
            JSONObject jSONObject = (JSONObject) this.O0000O0o.get("payList");
            JSONObject jSONObject2 = new JSONObject(this.O0000O0o.getString("payParamString"));
            JSONObject jSONObject3 = (JSONObject) this.O0000O0o.get("orderInfo");
            if (jSONObject3 != null) {
                jSONObject3.put("exchange_coupon", this.O0000O0o.optJSONObject("exchange_coupon"));
            }
            PayU.O00000o0 = jSONObject3;
            this.O0000OOo = new BuyOrderInfo(jSONObject3);
            try {
                this.O00000oo = Double.parseDouble(this.O0000OOo.O0000O0o);
            } catch (Exception e) {
                cec.O000000o(this, getString(R.string.shop_network_unavaliable), 3000);
                CrashReport.postCrash(Thread.currentThread(), e);
                finish();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (obj.equals("cards")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("cards");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        HashSet hashSet = new HashSet();
                        hashSet.addAll(bzs.O00000Oo);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.remove(jSONArray.get(i));
                        }
                        if (hashSet.size() != bzs.O00000Oo.size()) {
                            PayU.O0000o0 = hashSet;
                        }
                    }
                } else if (obj.equals("emi")) {
                    PayU.O00000oO = bzq.O000000o(jSONObject.getJSONArray("emi"));
                } else if (obj.equals("netbank")) {
                    PayU.O00000Oo = jSONObject.getJSONObject("netbank");
                } else if (obj.equals("wallet")) {
                    PayU.O00000o = jSONObject.getJSONObject("wallet");
                }
            }
            PayU.O0000o00 = Boolean.parseBoolean(jSONObject2.getString("supportStoreCards"));
            this.O0000Oo0 = this.O0000O0o.optString("mention_ext");
            if (!TextUtils.isEmpty(this.O0000O0o.optString("bankList"))) {
                PayU.O00000oo = new JSONObject(this.O0000O0o.optString("bankList"));
            }
            if (newPayInfoData.payOptions != null) {
                PayU.O0000O0o = bzi.O00000Oo.O000000o(newPayInfoData.payOptions);
            }
            O000000o();
            O00000o0();
            ccr.O00000Oo("ConfirmActivity", "getPaymentInfo Process success");
            if (newPayInfoData.pagemsg != null && (bzi = this.O00000o0) != null && (newPageMessage = newPayInfoData.pagemsg) != null && BaseActivity.isActivityAlive(bzi.getActivity()) && (confirmActivity = (ConfirmActivity) bzi.getActivity()) != null) {
                confirmActivity.showPageNotice(newPageMessage);
            }
        } catch (JSONException e2) {
            cec.O000000o(this, (int) R.string.shop_error_network, 0);
            e2.printStackTrace();
            CrashReport.postCrash(Thread.currentThread(), e2);
            finish();
        }
    }

    private String[] O00000Oo() {
        String[] O0000o002 = cav.O0000o00();
        String[] strArr = new String[O0000o002.length];
        for (int i = 0; i < O0000o002.length; i++) {
            ccr.O00000Oo("ConfirmActivity", "getPaymentInfo");
            Uri.Builder buildUpon = Uri.parse(O0000o002[i]).buildUpon();
            buildUpon.appendQueryParameter("order_id", this.O00000Oo);
            buildUpon.appendQueryParameter("bank", "payu_india");
            buildUpon.appendQueryParameter("security", "true");
            buildUpon.appendQueryParameter("jsontag", "true");
            buildUpon.appendQueryParameter("payparams", "0");
            if (byl.O0000OoO()) {
                buildUpon.appendQueryParameter("ot", "5");
            }
            ccr.O00000Oo("ConfirmActivity", "payment url:" + buildUpon.toString());
            strArr[i] = buildUpon.toString();
        }
        return strArr;
    }

    public BuyOrderInfo getconfirmOrder() {
        return this.O0000OOo;
    }

    public String getMention() {
        return this.O0000Oo0;
    }

    public JSONObject getData() {
        return this.O0000O0o;
    }

    public OrderPaymentInfo getOrderPaymentInfo() {
        return this.f4847O000000o;
    }

    public Intent getPaymentIntent() {
        PayU.PaymentMode[] paymentModeArr = {PayU.PaymentMode.CC, PayU.PaymentMode.DC, PayU.PaymentMode.NB, PayU.PaymentMode.EMI, PayU.PaymentMode.STORED_CARDS};
        PayU.O000000o(this);
        return PayU.O000000o(this.O00000oo, this.O00000oO, paymentModeArr);
    }

    public HashMap<String, String> getpayParam() {
        return this.O00000oO;
    }

    public void setpayParam(HashMap<String, String> hashMap) {
        this.O00000oO = hashMap;
    }

    public void onResume() {
        super.onResume();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_home) {
            onBackPressed();
            cbe.O000000o("title_back", "ConfirmActivity");
        }
    }

    public void onBackPressed() {
        String str;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        Fragment visibleFragment = getVisibleFragment();
        if (visibleFragment == null || visibleFragment.getTag() == null || !visibleFragment.getTag().equals(bzi.class.getName())) {
            if (visibleFragment != null) {
                if (visibleFragment instanceof byz) {
                    str = "credit/debit card";
                } else if (visibleFragment instanceof bzg) {
                    str = "net banking";
                } else if (visibleFragment instanceof bzc) {
                    str = "EMI";
                } else if (visibleFragment instanceof byx) {
                    str = "cash_on_delivery";
                } else if (visibleFragment instanceof UPIFragment) {
                    str = "UPI";
                } else {
                    str = visibleFragment instanceof bzj ? "wallet" : "";
                }
                if (!TextUtils.isEmpty(str)) {
                    cbe.O000000o("return_click", str);
                }
            }
            super.onBackPressed();
            return;
        }
        cbe.O000000o("return_click", "pay");
        redirectBack();
    }

    public void redirectBack() {
        CustomCancelDialog.Builder builder = new CustomCancelDialog.Builder(this);
        builder.f4982O000000o = getString(R.string.confirm_pay_hint_title);
        builder.O00000Oo = getString(R.string.confirm_pay_hint_content);
        builder.O000000o(getString(R.string.shop_yes), new DialogInterface.OnClickListener() {
            /* class com.mi.global.shop.buy.ConfirmActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (!ConfirmActivity.this.getIntent().getBooleanExtra("is_from_checkout", false)) {
                    ConfirmActivity.this.finish();
                    return;
                }
                Intent intent = new Intent(ConfirmActivity.this, OrderListAcitvity.class);
                intent.putExtra("type", 4);
                intent.putExtra("backToUserCenter", 1);
                ConfirmActivity.this.startActivity(intent);
                ConfirmActivity.this.finish();
            }
        });
        this.O0000oO0 = builder.O000000o();
        this.O0000oO0.show();
    }

    public Fragment getVisibleFragment() {
        for (Fragment next : getSupportFragmentManager().O00000oo()) {
            if (next != null && next.isVisible()) {
                return next;
            }
        }
        return null;
    }

    public void setPaymentFailedTip(Boolean bool) {
        bzi bzi = this.O00000o0;
        if (bzi != null) {
            bzi.O000000o(bool);
            new Handler().post(new Runnable() {
                /* class com.mi.global.shop.buy.ConfirmActivity.AnonymousClass3 */

                public final void run() {
                    if (!(ConfirmActivity.this.mFragmentManager.O000000o((int) R.id.confirm_fragment_top_container) instanceof bzi)) {
                        ConfirmActivity.this.getSupportFragmentManager().O00000o0();
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && !"".equals(intent)) {
            if (i != 100 || intent == null || !intent.hasExtra("result")) {
                if (i == 102) {
                    if (i2 == -1) {
                        final String stringExtra = intent.getStringExtra("tel");
                        OrderPaymentInfo orderPaymentInfo = this.f4847O000000o;
                        if (orderPaymentInfo != null) {
                            orderPaymentInfo.O00000o0 = stringExtra;
                            runOnUiThread(new Runnable() {
                                /* class com.mi.global.shop.buy.ConfirmActivity.AnonymousClass4 */

                                public final void run() {
                                    ((CustomTextView) ConfirmActivity.this.findViewById(R.id.buy_confirm_cod_phone_number_text)).setText(byl.O00000oO().getString(R.string.user_address_phoneareacode) + stringExtra);
                                }
                            });
                            return;
                        }
                        return;
                    } else if (i2 == 0) {
                        return;
                    }
                }
                if (i == 101 && intent != null && intent.hasExtra("result")) {
                    try {
                        JSONObject jSONObject = new JSONObject(intent.getStringExtra("result"));
                        if (jSONObject.optBoolean("success")) {
                            O00000o();
                            O00000oO();
                            setResult(-1, intent);
                            String optString = jSONObject.optString("url");
                            if (TextUtils.isEmpty(optString)) {
                                Intent intent2 = new Intent(this, SuccessAcitvity.class);
                                intent2.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", this.O00000Oo);
                                startActivity(intent2);
                            } else {
                                Intent intent3 = new Intent(this, WebActivity.class);
                                intent3.putExtra("url", optString);
                                intent3.putExtra("fromPaySuccess", "1");
                                startActivity(intent3);
                            }
                            finish();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.O00000o0.O000000o(Boolean.TRUE);
                    getSupportFragmentManager().O00000o0();
                } else if (i != 258) {
                    setPaymentFailedTip(Boolean.TRUE);
                } else if (i2 != -1) {
                    this.O00000o0.O000000o(Boolean.TRUE);
                    getSupportFragmentManager().O00000o0();
                } else {
                    Intent intent4 = new Intent(this, PayResultWebActivity.class);
                    HashMap<String, String> hashMap = this.O00000oO;
                    if (hashMap != null) {
                        intent4.putExtra("url", hashMap.get("url"));
                    }
                    startActivityForResult(intent4, 101);
                }
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("result"));
                    if (jSONObject2.optBoolean("success")) {
                        O00000o();
                        O00000oO();
                        setResult(-1, intent);
                        String optString2 = jSONObject2.optString("url");
                        if (TextUtils.isEmpty(optString2)) {
                            Intent intent5 = new Intent(this, SuccessAcitvity.class);
                            intent5.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", this.O00000Oo);
                            startActivity(intent5);
                        } else {
                            Intent intent6 = new Intent(this, WebActivity.class);
                            intent6.putExtra("url", optString2);
                            intent6.putExtra("fromPaySuccess", "1");
                            startActivity(intent6);
                        }
                        finish();
                        return;
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                this.O00000o0.O000000o(Boolean.TRUE);
                getSupportFragmentManager().O00000o0();
            }
        }
    }

    private void O00000o0() {
        ArrayList arrayList = new ArrayList();
        Iterator<BuyOrderItem> it = this.O0000OOo.O0000Ooo.iterator();
        while (it.hasNext()) {
            BuyOrderItem next = it.next();
            HashMap hashMap = new HashMap();
            hashMap.put("name", next.f4864O000000o);
            hashMap.put("id", next.O00000oO);
            hashMap.put("price", next.O00000o);
            hashMap.put("quantity", next.O00000oo);
            arrayList.add(hashMap);
        }
    }

    private void O00000o() {
        ArrayList arrayList = new ArrayList();
        Iterator<BuyOrderItem> it = this.O0000OOo.O0000Ooo.iterator();
        while (it.hasNext()) {
            BuyOrderItem next = it.next();
            HashMap hashMap = new HashMap();
            hashMap.put("name", next.f4864O000000o);
            hashMap.put("id", next.O00000oO);
            hashMap.put("price", next.O00000o);
            hashMap.put("quantity", next.O00000oo);
            hashMap.put("coupon", "");
            arrayList.add(hashMap);
        }
    }

    public double getAmount() {
        return this.O00000oo;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("orderPaymentInfo", this.f4847O000000o);
        bundle.putParcelable("confirmOrder", this.O0000OOo);
    }

    public void onDestroy() {
        bzk bzk = this.codViewHelper;
        if (bzk != null) {
            if (bzk.O00000o0 != null) {
                bzk.O00000o0.cancel();
            }
            bzk.O00000o = null;
            bzk.O00000oO = null;
            bzk.f13480O000000o = null;
            bzk.O00000o0 = null;
            bzk.O00000Oo = null;
        }
        hideLoading();
        cax cax = this.O0000oO;
        if (cax != null) {
            cax.O000000o();
            this.O0000oO = null;
        }
        super.onDestroy();
    }

    public void onPaymentOptionSelected(String str) {
        this.O00000o0.O000000o(Boolean.FALSE);
        ccr.O00000Oo("ConfirmActivity", "onPaymentOptionSelected:".concat(String.valueOf(str)));
        ei O000000o2 = getSupportFragmentManager().O000000o();
        if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_NetBank))) {
            if (this.O0000OoO == null) {
                this.O0000OoO = new bzg();
            }
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000OoO, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        } else if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_Cards))) {
            if (this.O0000Ooo == null) {
                this.O0000Ooo = new byz();
            }
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000Ooo, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        } else if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_EMI))) {
            if (this.O0000o00 == null) {
                this.O0000o00 = new bzc();
            }
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000o00, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        } else if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_Wallet))) {
            if (this.O0000o == null) {
                this.O0000o = new bzj();
            }
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000o, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        } else if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_COD))) {
            this.O0000o0 = new byx();
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000o0, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        } else if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_Cardless_EMI))) {
            this.O0000o0O = new CardlessEMIfragment();
            Bundle bundle = new Bundle();
            bundle.putString("order_total_extra", this.O0000OOo.O0000O0o);
            bundle.putString("order_id_extra", this.O0000OOo.f4863O000000o);
            this.O0000o0O.setArguments(bundle);
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000o0O, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        } else if (str.equals(byl.O00000oO().getString(R.string.buy_confirm_PaymentKey_UPI))) {
            this.O0000o0o = new UPIFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("order_id_extra", this.O0000OOo.f4863O000000o);
            this.O0000o0o.setArguments(bundle2);
            O000000o2.O00000Oo(R.id.confirm_fragment_top_container, this.O0000o0o, null);
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        }
    }

    private void O00000oO() {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this);
        try {
            if (this.O0000OOo != null && this.O0000OOo.O0000Ooo != null) {
                Iterator<BuyOrderItem> it = this.O0000OOo.O0000Ooo.iterator();
                while (it.hasNext()) {
                    BuyOrderItem next = it.next();
                    Bundle bundle = new Bundle();
                    bundle.putString("fb_num_items", next.O00000Oo);
                    bundle.putString("fb_content_id", next.O0000O0o);
                    bundle.putString("fb_currency", next.O00000o);
                    newLogger.logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.parseDouble(next.O00000o0), bundle);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPaytmTransactionSuccess(String str) {
        O00000o();
        O00000oO();
        if (TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this, SuccessAcitvity.class);
            intent.putExtra("com.mi.global.shop.extra_buy_confirm_orderid", this.O00000Oo);
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(this, WebActivity.class);
            intent2.putExtra("url", str);
            intent2.putExtra("fromPaySuccess", "1");
            startActivity(intent2);
        }
        finish();
    }

    public cax getCountDownUtil() {
        return this.O0000oO;
    }

    public void setCountDownUtil(cax cax) {
        this.O0000oO = cax;
    }
}
