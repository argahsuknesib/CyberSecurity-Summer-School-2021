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
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.google.android.exoplayer2.C;
import com.mi.global.shop.model.cart.List;
import com.mi.global.shop.webview.WebViewHelper;
import com.mi.global.shop.widget.BaseWebView;
import com.mi.global.shop.widget.CommonButton;
import com.squareup.wire.Wire;
import com.xiaomi.smarthome.R;
import org.json.JSONObject;

public class ShoppingCartInsuranceActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected BaseWebView f4702O000000o;
    private View O00000Oo;
    private CommonButton O00000o;
    private CommonButton O00000o0;
    private String O00000oO;
    private String O00000oo;

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            ccr.O00000Oo("ShoppingCartInsuranceActivity", "onCreate, savedInstanceState:" + bundle.toString());
        }
        super.onCreate(bundle);
        try {
            O000000o((int) R.layout.shop_cart_insurance_activity);
            setTitle((int) R.string.cart_title);
            Intent intent = getIntent();
            this.O00000oO = intent.getStringExtra("cart_insurance_goodsid");
            this.O00000oo = intent.getStringExtra("cart_insurance_parentid");
            if (TextUtils.isEmpty(this.O00000oo) || TextUtils.isEmpty(this.O00000oO)) {
                ccr.O00000Oo("ShoppingCartInsuranceActivity", "id is empty");
                cec.O000000o(this, (int) R.string.shop_error_network, 0);
                setResult(0);
                finish();
                return;
            }
            this.mCartView.setVisibility(4);
            this.O00000Oo = findViewById(R.id.title_bar_home);
            this.O00000Oo.setVisibility(0);
            this.O00000Oo.setOnClickListener(this);
            this.O00000o0 = (CommonButton) findViewById(R.id.insurance_confirm);
            this.O00000o = (CommonButton) findViewById(R.id.insurance_cancel);
            this.O00000o0.setOnClickListener(this);
            this.O00000o.setOnClickListener(this);
            this.f4702O000000o = (BaseWebView) findViewById(R.id.cart_insurance_webview);
            WebViewHelper.O000000o(this.f4702O000000o);
            this.f4702O000000o.setWebViewClient(new WebViewClient());
            this.f4702O000000o.setWebChromeClient(new WebChromeClient());
            this.f4702O000000o.loadUrl(cav.O000OO());
        } catch (Exception e) {
            if (e.getMessage() == null || !e.getMessage().contains("MissingWebViewPackageException")) {
                cec.O000000o(this, getResources().getString(R.string.loading_error), 0);
            } else {
                cec.O000000o(this, getResources().getString(R.string.webview_tips_uploaing), 0);
            }
            finish();
        }
    }

    public void onResume() {
        BaseWebView baseWebView = this.f4702O000000o;
        if (baseWebView != null) {
            baseWebView.reload();
        }
        super.onResume();
    }

    public void onClick(View view) {
        try {
            if (view.getId() == R.id.title_bar_home) {
                onBackPressed();
            }
            if (view == this.O00000o) {
                setResult(0);
                finish();
            } else if (view == this.O00000o0) {
                String str = this.O00000oO;
                String str2 = this.O00000oo;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.O00000o0.setEnabled(false);
                    this.O00000o.setEnabled(false);
                    if (byl.O0000OoO()) {
                        cai cai = new cai(cav.O000000o(cav.O0000oo(), str, "", str2, ""), new Response.Listener<byte[]>() {
                            /* class com.mi.global.shop.activity.ShoppingCartInsuranceActivity.AnonymousClass1 */

                            public final /* synthetic */ void onResponse(Object obj) {
                                try {
                                    List decode = List.ADAPTER.decode((byte[]) obj);
                                    if (((Integer) Wire.get(decode.errno, List.DEFAULT_ERRNO)).intValue() != 0) {
                                        ccr.O00000Oo("ShoppingCartInsuranceActivity", "error msg:" + ((String) Wire.get(decode.errmsg, "")));
                                        return;
                                    }
                                    ShoppingCartInsuranceActivity.this.returnSuccess();
                                    ccr.O00000Oo("ShoppingCartInsuranceActivity", "Add cart Process success");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    ccr.O00000Oo("ShoppingCartInsuranceActivity", "Exception:" + e.toString());
                                    ShoppingCartInsuranceActivity.this.recoverLoad();
                                }
                            }
                        }, new Response.ErrorListener() {
                            /* class com.mi.global.shop.activity.ShoppingCartInsuranceActivity.AnonymousClass2 */

                            public final void onErrorResponse(VolleyError volleyError) {
                                byl.O0000Ooo();
                                VolleyLog.d("ShoppingCartInsuranceActivity", "Error: " + volleyError.getMessage());
                                ShoppingCartInsuranceActivity.this.recoverLoad();
                            }
                        });
                        cai.setTag("ShoppingCartInsuranceActivity");
                        ced.f13683O000000o.add(cai);
                    } else {
                        cag cag = new cag(cav.O000000o(O000000o(str, str2)), new Response.Listener<JSONObject>() {
                            /* class com.mi.global.shop.activity.ShoppingCartInsuranceActivity.AnonymousClass3 */

                            public final /* synthetic */ void onResponse(Object obj) {
                                JSONObject jSONObject = (JSONObject) obj;
                                try {
                                    if (jSONObject.getInt("errno") != 0) {
                                        ccr.O00000Oo("ShoppingCartInsuranceActivity", "errno=" + Integer.toString(jSONObject.getInt("errno")));
                                        return;
                                    }
                                    try {
                                        ShoppingCartInsuranceActivity.this.returnSuccess();
                                        ccr.O00000Oo("ShoppingCartInsuranceActivity", "Process success");
                                    } catch (Exception e) {
                                        ccr.O00000Oo("ShoppingCartInsuranceActivity", "JSON parse error");
                                        e.printStackTrace();
                                        ShoppingCartInsuranceActivity.this.recoverLoad();
                                    }
                                } catch (Exception e2) {
                                    ccr.O00000Oo("ShoppingCartInsuranceActivity", "JSON parse error");
                                    e2.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                            /* class com.mi.global.shop.activity.ShoppingCartInsuranceActivity.AnonymousClass4 */

                            public final void onErrorResponse(VolleyError volleyError) {
                                ccr.O00000Oo("ShoppingCartInsuranceActivity", "Error: " + volleyError.getMessage());
                                ShoppingCartInsuranceActivity.this.recoverLoad();
                            }
                        });
                        cag.f13515O000000o = "ShoppingCartInsuranceActivity";
                        cag.O00000Oo = new DefaultRetryPolicy(C.MSG_CUSTOM_BASE, 1, 1.0f);
                        cag.O000000o();
                    }
                    ccr.O00000Oo("ShoppingCartInsuranceActivity", "added task to request quene");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnSuccess() {
        setResult(-1);
        finish();
    }

    private static String[] O000000o(String str, String str2) {
        String[] O0000oo0 = cav.O0000oo0();
        String[] strArr = new String[O0000oo0.length];
        for (int i = 0; i < O0000oo0.length; i++) {
            strArr[i] = cav.O000000o(O0000oo0[i], str, "", str2, "");
        }
        return strArr;
    }

    public void recoverLoad() {
        this.O00000o0.setEnabled(true);
        this.O00000o.setEnabled(true);
    }
}
