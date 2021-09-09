package com.mobikwik.sdk.ui.util;

import android.widget.TextView;
import com.mobikwik.sdk.ui.data.b;
import com.xiaomi.smarthome.R;

public class l {
    public static int a(String str) {
        return "visa".equalsIgnoreCase(str) ? R.drawable.visa : "mastercard".equalsIgnoreCase(str) ? R.drawable.mk_master : "maestro".equalsIgnoreCase(str) ? R.drawable.mk_maestro : "discover".equalsIgnoreCase(str) ? R.drawable.mk_discover : "diners".equalsIgnoreCase(str) ? R.drawable.mk_diners : "amex".equalsIgnoreCase(str) ? R.drawable.mk_amex : "rupay".equalsIgnoreCase(str) ? R.drawable.mk_rupay : R.drawable.mk_ic_card;
    }

    public static void a(TextView textView, String str, String str2) {
        String replace;
        b b = b.b(textView.getContext());
        if (!b.j()) {
            textView.setText((int) R.string.card_page_payto_msg_pg);
            textView.setText(textView.getText().toString().replace("@@nn@@", b.f().getMerchantName()));
            replace = textView.getText().toString().replace("@@rr@@", str);
        } else if (!b.f().isDebitWallet()) {
            textView.setText((int) R.string.card_page_payto_msg);
            replace = textView.getText().toString().replace("@payamt@", str);
        } else {
            if (str.equals(str2)) {
                textView.setText((int) R.string.add_money_wallet);
            } else {
                textView.setText((int) R.string.add_money_wallet_partial);
                textView.setText(textView.getText().toString().replace("@addamt@", str2));
            }
            textView.setText(textView.getText().toString().replace("@payamt@", str));
            replace = textView.getText().toString().replace("@mm@", b.f().getMerchantName());
        }
        textView.setText(replace);
    }
}
