package com.mi.global.shop.activity;

import _m_j.cbe;
import _m_j.cec;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.mi.global.shop.user.FeedbackActivity;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class SuccessAcitvity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private CustomTextView f4707O000000o;
    private CustomTextView O00000Oo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_success);
        setTitle(getString(R.string.success_payment));
        this.mBackView.setVisibility(0);
        findViewById(R.id.title_bar_cart_view).setVisibility(4);
        this.f4707O000000o = (CustomTextView) findViewById(R.id.payment_success_title_txt);
        this.O00000Oo = (CustomTextView) findViewById(R.id.payment_success_message_txt);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("payment_type");
        if ("cod_by_img".equals(stringExtra)) {
            this.f4707O000000o.setText((int) R.string.cod_img_payment_success_title);
            this.O00000Oo.setText((int) R.string.cod_img_payment_success_message);
        } else if ("cod_by_sms".equals(stringExtra)) {
            this.f4707O000000o.setText((int) R.string.cod_sms_payment_success_title);
            this.O00000Oo.setText((int) R.string.cod_sms_payment_success_message);
        }
        ((CustomTextView) findViewById(R.id.order_id_txt)).setText(intent.getStringExtra("com.mi.global.shop.extra_buy_confirm_orderid"));
        findViewById(R.id.order_details_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.SuccessAcitvity.AnonymousClass1 */

            public final void onClick(View view) {
                SuccessAcitvity.this.finish();
            }
        });
        findViewById(R.id.back_to_home_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.SuccessAcitvity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final void onClick(View view) {
                Intent intent = new Intent(SuccessAcitvity.this, MainTabActivity.class);
                intent.setFlags(67108864);
                intent.putExtra("switch_home_page", true);
                SuccessAcitvity.this.startActivity(intent);
            }
        });
        findViewById(R.id.could_be_better_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.SuccessAcitvity.AnonymousClass3 */

            public final void onClick(View view) {
                SuccessAcitvity.this.startActivity(new Intent(SuccessAcitvity.this, FeedbackActivity.class));
                SuccessAcitvity.this.finish();
            }
        });
        findViewById(R.id.love_it_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.SuccessAcitvity.AnonymousClass4 */

            public final void onClick(View view) {
                cbe.O000000o("click_enter_market", SuccessAcitvity.class.getSimpleName());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + SuccessAcitvity.this.getPackageName()));
                if (intent.resolveActivity(SuccessAcitvity.this.getPackageManager()) != null) {
                    SuccessAcitvity.this.startActivity(intent);
                } else {
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + SuccessAcitvity.this.getPackageName()));
                    if (intent.resolveActivity(SuccessAcitvity.this.getPackageManager()) != null) {
                        SuccessAcitvity.this.startActivity(intent);
                    } else {
                        cec.O000000o(SuccessAcitvity.this, (int) R.string.no_market_and_brower, 0);
                    }
                }
                SuccessAcitvity.this.finish();
            }
        });
    }

    public void onResume() {
        super.onResume();
    }
}
