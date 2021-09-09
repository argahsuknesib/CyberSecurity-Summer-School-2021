package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cag;
import _m_j.cai;
import _m_j.cav;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.google.android.exoplayer2.C;
import com.google.gson.Gson;
import com.mi.global.shop.adapter.CartChooseBargainListAdapter;
import com.mi.global.shop.model.ShoppingCartBargainModel;
import com.mi.global.shop.model.cart.List;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.multimonitor.CrashReport;
import com.squareup.wire.Wire;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import org.json.JSONObject;

public class ShoppingCartBargainActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f4697O000000o;
    private CommonButton O00000Oo;
    private NoScrollListView O00000o;
    private CommonButton O00000o0;
    private CustomTextView O00000oO;
    public CartChooseBargainListAdapter mCartChooseBargainListAdapter;
    public ShoppingCartBargainModel shoppingCartBargainModel;

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            ccr.O00000Oo("ShoppingCartBargainActivity", "onCreate, savedInstanceState:" + bundle.toString());
        }
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_cart_bargain_activity);
        setTitle((int) R.string.cart_title);
        String stringExtra = getIntent().getStringExtra("cart_bargain");
        if (TextUtils.isEmpty(stringExtra)) {
            ccr.O00000Oo("ShoppingCartBargainActivity", "jsondata is empty");
            quitwithError();
            return;
        }
        ccr.O00000Oo("ShoppingCartBargainActivity", "get jsondata:".concat(String.valueOf(stringExtra)));
        this.mCartView.setVisibility(4);
        this.f4697O000000o = findViewById(R.id.title_bar_home);
        this.f4697O000000o.setVisibility(0);
        this.f4697O000000o.setOnClickListener(this);
        this.O00000o = (NoScrollListView) findViewById(R.id.bargain_list);
        this.O00000oO = (CustomTextView) findViewById(R.id.bargain_select);
        this.O00000Oo = (CommonButton) findViewById(R.id.bargain_add);
        this.O00000o0 = (CommonButton) findViewById(R.id.bargain_back);
        this.O00000Oo.setOnClickListener(this);
        this.O00000o0.setOnClickListener(this);
        ccr.O00000Oo("ShoppingCartBargainActivity", "getBargainInfo, json:".concat(String.valueOf(stringExtra)));
        try {
            this.shoppingCartBargainModel = (ShoppingCartBargainModel) new Gson().fromJson(stringExtra.toString(), ShoppingCartBargainModel.class);
            O000000o(this.shoppingCartBargainModel);
        } catch (Exception e) {
            e.printStackTrace();
            CrashReport.postCrash(Thread.currentThread(), e);
            quitwithError();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void returnSuccess() {
        setResult(-1, new Intent());
        finish();
    }

    private void O000000o(ShoppingCartBargainModel shoppingCartBargainModel2) {
        if (shoppingCartBargainModel2 == null || shoppingCartBargainModel2.bargainList == null || shoppingCartBargainModel2.bargainList.size() <= 0) {
            quitwithError();
            return;
        }
        ccr.O00000Oo("ShoppingCartBargainActivity", "model not null, updateview");
        this.O00000oO.setText(String.format(byl.O00000oO().getString(R.string.cart_bargain_select), shoppingCartBargainModel2.bargainNum));
        ArrayList<ShoppingCartBargainModel.BargainsItem> arrayList = shoppingCartBargainModel2.bargainList;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                arrayList.get(i).Selected = Boolean.TRUE;
            } else {
                arrayList.get(i).Selected = Boolean.FALSE;
            }
        }
        this.mCartChooseBargainListAdapter = new CartChooseBargainListAdapter(this);
        this.mCartChooseBargainListAdapter.O00000o0();
        this.mCartChooseBargainListAdapter.O000000o((ArrayList) arrayList);
        this.O00000o.setAdapter((ListAdapter) this.mCartChooseBargainListAdapter);
    }

    public void quitwithError() {
        quitwithError(getString(R.string.shop_error_network));
    }

    public void quitwithError(String str) {
        cec.O000000o(this, str, 0);
        this.O00000Oo.setEnabled(true);
        this.O00000o0.setEnabled(true);
        setResult(0);
        finish();
        ccr.O00000Oo("ShoppingCartBargainActivity", "JSON parse error");
    }

    public void onClick(View view) {
        try {
            if (view.getId() == R.id.title_bar_home) {
                onBackPressed();
            }
            if (view == this.O00000o0) {
                ccr.O00000Oo("ShoppingCartBargainActivity", "backBTn clicked");
                setResult(0);
                finish();
            } else if (view == this.O00000Oo && this.shoppingCartBargainModel != null && this.shoppingCartBargainModel.bargainList != null) {
                if (this.shoppingCartBargainModel.bargainList.size() != 0) {
                    ShoppingCartBargainModel.BargainsItem bargainsItem = null;
                    int i = 0;
                    while (true) {
                        if (i >= this.shoppingCartBargainModel.bargainList.size()) {
                            break;
                        } else if (this.shoppingCartBargainModel.bargainList.get(i).Selected.booleanValue()) {
                            bargainsItem = this.shoppingCartBargainModel.bargainList.get(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (bargainsItem != null) {
                        String str = bargainsItem.bargainGoodsId;
                        if (!TextUtils.isEmpty(str)) {
                            this.O00000Oo.setEnabled(false);
                            this.O00000o0.setEnabled(false);
                            if (byl.O0000OoO()) {
                                cai cai = new cai(cav.O000000o(cav.O0000oo(), str, "", "", ""), new Response.Listener<byte[]>() {
                                    /* class com.mi.global.shop.activity.ShoppingCartBargainActivity.AnonymousClass1 */

                                    public final /* synthetic */ void onResponse(Object obj) {
                                        try {
                                            List decode = List.ADAPTER.decode((byte[]) obj);
                                            if (((Integer) Wire.get(decode.errno, List.DEFAULT_ERRNO)).intValue() != 0) {
                                                ccr.O00000Oo("ShoppingCartBargainActivity", "error msg:" + ((String) Wire.get(decode.errmsg, "")));
                                                ShoppingCartBargainActivity.this.quitwithError((String) Wire.get(decode.errmsg, ""));
                                                return;
                                            }
                                            ShoppingCartBargainActivity.this.returnSuccess();
                                            ccr.O00000Oo("ShoppingCartBargainActivity", "Add cart Process success");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            ccr.O00000Oo("ShoppingCartBargainActivity", "Exception:" + e.toString());
                                            CrashReport.postCrash(Thread.currentThread(), e);
                                            ShoppingCartBargainActivity.this.quitwithError();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                                    /* class com.mi.global.shop.activity.ShoppingCartBargainActivity.AnonymousClass2 */

                                    public final void onErrorResponse(VolleyError volleyError) {
                                        VolleyLog.d("ShoppingCartBargainActivity", "Error: " + volleyError.getMessage());
                                        ShoppingCartBargainActivity.this.quitwithError();
                                    }
                                });
                                cai.setTag("ShoppingCartBargainActivity");
                                ced.f13683O000000o.add(cai);
                            } else {
                                cag cag = new cag(cav.O000000o(O000000o(str)), new Response.Listener<JSONObject>() {
                                    /* class com.mi.global.shop.activity.ShoppingCartBargainActivity.AnonymousClass3 */

                                    public final /* synthetic */ void onResponse(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        try {
                                            if (jSONObject.getInt("errno") != 0) {
                                                ccr.O00000Oo("ShoppingCartBargainActivity", "errno=" + Integer.toString(jSONObject.getInt("errno")));
                                                ShoppingCartBargainActivity.this.quitwithError();
                                                return;
                                            }
                                            try {
                                                ShoppingCartBargainActivity.this.returnSuccess();
                                                ccr.O00000Oo("ShoppingCartBargainActivity", "Process success");
                                            } catch (Exception e) {
                                                ccr.O00000Oo("ShoppingCartBargainActivity", "JSON parse error");
                                                e.printStackTrace();
                                                CrashReport.postCrash(Thread.currentThread(), e);
                                                ShoppingCartBargainActivity.this.quitwithError();
                                            }
                                        } catch (Exception e2) {
                                            ccr.O00000Oo("ShoppingCartBargainActivity", "JSON parse error");
                                            e2.printStackTrace();
                                            CrashReport.postCrash(Thread.currentThread(), e2);
                                            ShoppingCartBargainActivity.this.quitwithError();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                                    /* class com.mi.global.shop.activity.ShoppingCartBargainActivity.AnonymousClass4 */

                                    public final void onErrorResponse(VolleyError volleyError) {
                                        ccr.O00000Oo("ShoppingCartBargainActivity", "Error: " + volleyError.getMessage());
                                        ShoppingCartBargainActivity.this.quitwithError();
                                    }
                                });
                                cag.f13515O000000o = "ShoppingCartBargainActivity";
                                cag.O00000Oo = new DefaultRetryPolicy(C.MSG_CUSTOM_BASE, 1, 1.0f);
                                cag.O000000o();
                            }
                            ccr.O00000Oo("ShoppingCartBargainActivity", "added task to request quene");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] O000000o(String str) {
        String[] O0000oo0 = cav.O0000oo0();
        String[] strArr = new String[O0000oo0.length];
        for (int i = 0; i < O0000oo0.length; i++) {
            strArr[i] = cav.O000000o(O0000oo0[i], str, "", "", "");
        }
        return strArr;
    }
}
