package com.xiaomi.smarthome;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.hsk;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class FaqActivity extends BaseActivity {
    private static String O00000Oo = "/product/ap_reset.html";

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4014O000000o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4014O000000o = this;
        setContentView((int) R.layout.faq_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.FaqActivity.AnonymousClass1 */

            public final void onClick(View view) {
                FaqActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.about_faq);
        getKuailianErrorText(this, getString(R.string.camera_serach_no_device_blue), (TextView) findViewById(R.id.blue_camera_reset_textview), 18, 20, null);
        getKuailianErrorText(this, getString(R.string.plug_serach_no_device_blue), (TextView) findViewById(R.id.blue_plug_reset_textview), 17, 19, null);
        getKuailianErrorText(this, getString(R.string.air_serach_no_device_green_2), (TextView) findViewById(R.id.green_airpurifier_reset_textview), 11, 13, buildUrl(O00000Oo));
        findViewById(R.id.camera_help_bar).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.FaqActivity.AnonymousClass2 */

            public final void onClick(View view) {
                View findViewById = FaqActivity.this.findViewById(R.id.camera_help_content);
                if (findViewById.getVisibility() == 0) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
        });
        findViewById(R.id.plug_help_bar).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.FaqActivity.AnonymousClass3 */

            public final void onClick(View view) {
                View findViewById = FaqActivity.this.findViewById(R.id.plug_help_content);
                if (findViewById.getVisibility() == 0) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
        });
        findViewById(R.id.airpurifier_help_bar).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.FaqActivity.AnonymousClass4 */

            public final void onClick(View view) {
                View findViewById = FaqActivity.this.findViewById(R.id.airpurifier_help_content);
                if (findViewById.getVisibility() == 0) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
        });
    }

    public String buildUrl(String str) {
        return hsk.O00000Oo(CommonApplication.getAppContext()) + str;
    }

    public static void getKuailianErrorText(final Context context, String str, TextView textView, int i, int i2, final String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.mj_color_gray_light)), 0, i, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-16776961), i, i2, 33);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.FaqActivity.AnonymousClass5 */

            public final void onClick(View view) {
                fbt fbt = new fbt(context, "WebShellActivity");
                String str = str2;
                if (str != null) {
                    fbt.O000000o("url", str);
                } else {
                    fbt.O000000o("url", "https://io.mi.com/device/reset");
                }
                fbs.O000000o(fbt);
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, i, i2, 33);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
