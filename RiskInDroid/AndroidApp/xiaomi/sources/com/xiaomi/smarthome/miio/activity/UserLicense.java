package com.xiaomi.smarthome.miio.activity;

import _m_j.fju;
import _m_j.flk;
import _m_j.gpc;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.gwi;
import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import java.util.Locale;

public class UserLicense extends CommonActivity {
    public static String TYPE_USER_EXPPLANN = "userExpPlan";
    public static String TYPE_USER_EXPPLANN2 = "userExpPlanV2";
    public static String TYPE_USER_LICENSE = "userLicense";
    public static String TYPE_USER_PRIVACY = "userPrivacy";
    public static String baseUrl = "https://g.home.mi.com/views/user-terms.html?";
    public boolean call_system_browser = false;

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.user_license);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.UserLicense.AnonymousClass1 */

            public final void onClick(View view) {
                UserLicense.this.finish();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.user_license_info);
        WebView webView = (WebView) findViewById(R.id.user_license_info_web);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("type");
            textView.setText(getIntent().getStringExtra("title"));
            this.call_system_browser = getIntent().getBooleanExtra("call_system_browser", false);
            "license".equals(stringExtra);
        }
        webView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.miio.activity.UserLicense.AnonymousClass2 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                    if (TextUtils.isEmpty(str) || !str.startsWith("mailto:")) {
                        if (UserLicense.this.call_system_browser) {
                            try {
                                UserLicense.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            webView.loadUrl(str);
                        }
                        return true;
                    }
                    if (UserLicense.this.isValid()) {
                        MailTo parse = MailTo.parse(str);
                        UserLicense.this.startActivity(UserLicense.this.newEmailIntent(parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
                        webView.reload();
                        return true;
                    }
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        getWindow().addFlags(524288);
    }

    public Intent newEmailIntent(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        intent.setType("message/rfc822");
        return intent;
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void onContentChanged() {
        super.onContentChanged();
        gwg.O00000o(this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(gwc.O00000Oo(context));
    }

    public static String getUrlByTpye(String str) {
        Locale O0000O0o = fju.O000000o().O0000O0o();
        if (O0000O0o == null) {
            O0000O0o = Locale.getDefault();
        }
        String O000000o2 = flk.O000000o(O0000O0o);
        return baseUrl + "locale=" + O000000o2 + "&type=" + str;
    }

    public void onDestroy() {
        gwi.O00000Oo(this);
        super.onDestroy();
    }
}
