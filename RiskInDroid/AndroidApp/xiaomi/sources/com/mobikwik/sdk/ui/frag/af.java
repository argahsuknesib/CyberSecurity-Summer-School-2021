package com.mobikwik.sdk.ui.frag;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mobikwik.sdk.lib.model.ApplyCouponResponse;
import com.mobikwik.sdk.lib.model.GenerateOTPResponse;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletResponseCallback;
import com.xiaomi.smarthome.R;

class af implements WalletResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f5307a;
    final /* synthetic */ y b;

    af(y yVar, boolean z) {
        this.b = yVar;
        this.f5307a = z;
    }

    /* renamed from: a */
    public void onTaskCompleted(ApplyCouponResponse applyCouponResponse, GenerateOTPResponse generateOTPResponse) {
        if (this.b.d != null && this.b.d.isShowing()) {
            this.b.d.dismiss();
        }
        if (this.f5307a || Utils.isNull(applyCouponResponse.getStatusdescription())) {
            if ("SUCCESS".equals(applyCouponResponse.getStatus())) {
                int unused = this.b.i = 1;
            } else {
                int unused2 = this.b.i = 2;
            }
            String unused3 = this.b.j = applyCouponResponse.getStatusdescription();
            if (Utils.isNull(this.b.j)) {
                String unused4 = this.b.j = "Coupon Not Applied";
            }
            View findViewById = this.b.getView().findViewById(R.id.layout_promo_result_desc);
            if (findViewById != null) {
                TextView textView = (TextView) this.b.getView().findViewById(R.id.txt_promo_result_desc);
                if (this.b.i == 1) {
                    textView.setTextColor(this.b.getResources().getColor(R.color.mk_uic_header_bg));
                    ((EditText) this.b.getView().findViewById(R.id.editText_promo)).setEnabled(false);
                    Button button = (Button) this.b.getView().findViewById(R.id.btn_apply_promo);
                    button.setText("Remove");
                    button.setOnClickListener(new ag(this));
                } else if (this.b.i == 2) {
                    textView.setTextColor(this.b.getResources().getColor(R.color.mk_uic_red));
                }
                textView.setText(this.b.j);
                findViewById.setVisibility(0);
                return;
            }
            return;
        }
        this.b.h.setChecked(false);
    }

    public void onError(String str, String str2) {
        if (this.b.d != null && this.b.d.isShowing()) {
            this.b.d.dismiss();
        }
        UIFunctions.showToast(this.b.f5336a, str2);
    }
}
