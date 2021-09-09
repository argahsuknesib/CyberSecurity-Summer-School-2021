package _m_j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.GetOtpResult;
import com.payu.sdk.Params;
import com.xiaomi.smarthome.R;

public class bza extends byu {
    String O0000oOO;
    String O0000oOo = "";
    String O0000oo = "";
    String O0000oo0 = "";
    String O0000ooO = "";
    public GetOtpResult.GetOtpData O0000ooo = null;
    private byw O00oOooO = null;
    private DefaultRetryPolicy O00oOooo = new DefaultRetryPolicy(30000, 0, 1.0f);

    public bza(Context context, View view, boolean z) {
        super(context, view, "EMI", z);
        view.findViewById(R.id.store_card_container).setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        super.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O00000oO() {
        cbe.O000000o("pay_click", "EMI", "key", this.O0000oOo + "_" + this.O0000oo);
        ((ConfirmActivity) this.f13415O000000o).showLoading();
        Uri.Builder buildUpon = Uri.parse(cav.O000o0()).buildUpon();
        buildUpon.appendQueryParameter("id", ((ConfirmActivity) this.f13415O000000o).getconfirmOrder().f4863O000000o);
        buildUpon.appendQueryParameter("gateway", this.O0000ooO);
        buildUpon.appendQueryParameter("cardcode", this.O0000Oo.getText().toString().replace(" ", ""));
        cam cam = new cam(buildUpon.toString(), GetOtpResult.class, null, new cak<GetOtpResult>() {
            /* class _m_j.bza.AnonymousClass1 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                GetOtpResult getOtpResult = (GetOtpResult) baseResult;
                ((ConfirmActivity) bza.this.f13415O000000o).hideLoading();
                if (getOtpResult != null && getOtpResult.data != null) {
                    bza.this.O0000ooo = getOtpResult.data;
                    bza.this.O0000O0o();
                }
            }

            public final void onErrorResponse(VolleyError volleyError) {
                super.onErrorResponse(volleyError);
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                ((ConfirmActivity) bza.this.f13415O000000o).hideLoading();
            }
        });
        cam.setTag("EMICardViewWraper");
        cam.setRetryPolicy(this.O00oOooo);
        ced.f13683O000000o.add(cam);
    }

    public final void O0000O0o() {
        if (this.O00oOooO == null) {
            this.O00oOooO = new byw();
        }
        Bundle bundle = new Bundle();
        bundle.putString("card_num", this.O0000Oo.getText().toString().replace(" ", ""));
        bundle.putString("emi_code", this.O0000oOO);
        bundle.putString("terms", this.O0000oo0);
        bundle.putString("gateway", this.O0000ooO);
        bundle.putString("last_four_mobile_num", this.O0000ooo.mobileNumber);
        bundle.putString("transaction_code", this.O0000ooo.transactionCode);
        this.O00oOooO.setArguments(bundle);
        ((ConfirmActivity) this.f13415O000000o).getSupportFragmentManager().O000000o().O00000Oo(R.id.confirm_fragment_top_container, this.O00oOooO, null).O000000o((String) null).O00000o0();
    }

    /* access modifiers changed from: protected */
    public final void O00000oo() {
        Params params = new Params();
        params.put("ccnum", this.O0000Oo.getText().toString().replace(" ", ""));
        params.put("ccexpmon", String.valueOf(this.O00000oO));
        params.put("ccexpyr", String.valueOf(this.O00000o));
        params.put("ccname", this.O0000Oo0.getText().toString());
        params.put("ccvv", this.O0000O0o.getText().toString());
        params.put("bankcode", this.O0000oOO);
        bzt.O000000o(((ConfirmActivity) this.f13415O000000o).getconfirmOrder().f4863O000000o, "payu_india", "emi", (ConfirmActivity) this.f13415O000000o, PayU.PaymentMode.EMI, params, this.O0000Oo.getText().toString().replace(" ", ""), this.O0000oOo, this.O0000oo0, "", "");
    }
}
