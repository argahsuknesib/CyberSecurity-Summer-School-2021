package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cav;
import _m_j.cbh;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.android.volley.Request;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.ordercancel.NewRefundApplyResult;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;

public class CancelOrderAcitvity extends BaseActivity {
    private static final String O00000Oo = "CancelOrderAcitvity";

    /* renamed from: O000000o  reason: collision with root package name */
    protected ArrayList<O000000o> f4591O000000o;
    private CustomEditTextView O00000o;
    private CustomEditTextView O00000o0;
    private Spinner O00000oO;
    private CustomTextView O00000oo;
    private ArrayAdapter<O000000o> O0000O0o;
    private String O0000OOo;
    public O000000o selectedReason;
    public SimpleDraweeView vcodeImage;

    public static class O000000o {
        @SerializedName("id")

        /* renamed from: O000000o  reason: collision with root package name */
        public String f4598O000000o;
        @SerializedName("desc")
        public String O00000Oo;

        public final String toString() {
            return this.O00000Oo;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000OOo = getIntent().getStringExtra("com.mi.global.shop.extra_buy_confirm_orderid");
        this.f4591O000000o = (ArrayList) new Gson().fromJson(getIntent().getStringExtra("cancel_reason"), new TypeToken<ArrayList<O000000o>>() {
            /* class com.mi.global.shop.activity.CancelOrderAcitvity.AnonymousClass1 */
        }.getType());
        if (this.f4591O000000o == null) {
            this.f4591O000000o = new ArrayList<>();
        }
        if (TextUtils.isEmpty(this.O0000OOo)) {
            cec.O000000o(this, "orderId is null", 0);
            setResult(0, null);
            finish();
        }
        O000000o((int) R.layout.shop_cancel_order);
        setTitle(getString(R.string.order_cancellation));
        this.mBackView.setVisibility(0);
        findViewById(R.id.title_bar_cart_view).setVisibility(4);
        this.O00000oO = (Spinner) findViewById(R.id.reason_spinner);
        this.O00000o0 = (CustomEditTextView) findViewById(R.id.reason_description);
        this.O00000o = (CustomEditTextView) findViewById(R.id.vcode);
        this.vcodeImage = (SimpleDraweeView) findViewById(R.id.vcode_image);
        this.O00000oo = (CustomTextView) findViewById(R.id.change_vcode_image);
        String O0000OoO = cav.O0000OoO();
        cbq.O000000o(O0000OoO, this.vcodeImage);
        ccr.O00000Oo(O00000Oo, "vcodeImgUrl ".concat(String.valueOf(O0000OoO)));
        this.O0000O0o = new ArrayAdapter<>(this, (int) R.layout.shop_cancel_order_spinneritem, this.f4591O000000o);
        this.O00000oO.setAdapter((SpinnerAdapter) this.O0000O0o);
        this.O00000oO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /* class com.mi.global.shop.activity.CancelOrderAcitvity.AnonymousClass6 */

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                CancelOrderAcitvity cancelOrderAcitvity = CancelOrderAcitvity.this;
                cancelOrderAcitvity.selectedReason = cancelOrderAcitvity.f4591O000000o.get(i);
            }
        });
        this.O00000oO.setFocusable(true);
        this.O00000oO.setFocusableInTouchMode(true);
        this.O00000oO.requestFocus();
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CancelOrderAcitvity.AnonymousClass3 */

            public final void onClick(View view) {
                cbq.O000000o(cav.O0000OoO(), CancelOrderAcitvity.this.vcodeImage);
            }
        });
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CancelOrderAcitvity.AnonymousClass4 */

            public final void onClick(View view) {
                CancelOrderAcitvity.this.setResult(0, null);
                CancelOrderAcitvity.this.finish();
            }
        });
        findViewById(R.id.confirm_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.CancelOrderAcitvity.AnonymousClass5 */

            public final void onClick(View view) {
                CancelOrderAcitvity.this.cancelOrder();
            }
        });
    }

    public void cancelOrder() {
        Request request;
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", this.O0000OOo);
        hashMap.put("authcode", this.O00000o.getText().toString());
        hashMap.put("reason", this.selectedReason.f4598O000000o);
        hashMap.put("description", this.O00000o0.getText().toString());
        AnonymousClass2 r1 = new cak<NewRefundApplyResult>() {
            /* class com.mi.global.shop.activity.CancelOrderAcitvity.AnonymousClass2 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewRefundApplyResult newRefundApplyResult = (NewRefundApplyResult) baseResult;
                CancelOrderAcitvity.this.hideLoading();
                if (newRefundApplyResult.data != null) {
                    Intent intent = new Intent();
                    intent.putExtra("order_status", newRefundApplyResult.data.order_status_info);
                    CancelOrderAcitvity.this.setResult(-1, intent);
                    CancelOrderAcitvity.this.finish();
                    return;
                }
                CancelOrderAcitvity.this.setResult(0, new Intent());
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                CancelOrderAcitvity.this.hideLoading();
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(cav.O0000Ooo(), NewRefundApplyResult.class, cbh.O000000o(hashMap), r1);
        } else {
            request = new cal(cav.O0000Ooo(), NewRefundApplyResult.class, cbh.O000000o(hashMap), r1);
        }
        request.setTag(O00000Oo);
        ced.f13683O000000o.add(request);
        showLoading();
    }

    public void onResume() {
        super.onResume();
    }
}
