package _m_j;

import android.content.Context;
import android.view.View;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.payu.sdk.Params;
import com.xiaomi.smarthome.R;

public final class byy extends byu {
    /* access modifiers changed from: protected */
    public final void O00000oO() {
    }

    public byy(Context context, View view) {
        super(context, view, "credit/debit card", false);
        if (!PayU.O0000o00) {
            view.findViewById(R.id.store_card_container).setVisibility(8);
        }
        view.findViewById(R.id.ll_xiaomi_emi).setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public final void O00000oo() {
        Params params = new Params();
        String obj = this.O0000Oo0.getText().toString();
        if (obj.length() < 3) {
            obj = "PayU ".concat(String.valueOf(obj));
        }
        params.put("ccnum", this.O0000Oo.getText().toString().replace(" ", ""));
        params.put("ccexpmon", String.valueOf(this.O00000oO));
        params.put("ccexpyr", String.valueOf(this.O00000o));
        params.put("ccname", obj);
        params.put("ccvv", this.O0000O0o.getText().toString());
        if (this.O0000o00.isChecked()) {
            params.put("store_card", "1");
        }
        bzt.O000000o(((ConfirmActivity) this.f13415O000000o).getconfirmOrder().f4863O000000o, "payu_india", "card", (ConfirmActivity) this.f13415O000000o, PayU.PaymentMode.CC, params, this.O0000Oo.getText().toString().replace(" ", ""), "", "", "", "");
    }
}
