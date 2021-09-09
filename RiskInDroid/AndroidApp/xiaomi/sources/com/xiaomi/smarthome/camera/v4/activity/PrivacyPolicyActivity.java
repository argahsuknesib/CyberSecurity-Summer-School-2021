package com.xiaomi.smarthome.camera.v4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.v4.utils.Util;
import java.util.Locale;

public class PrivacyPolicyActivity extends CameraBaseActivity {
    WebView webView;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_prolicy);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("pagetype", 0);
        if (intExtra == 0) {
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        findViewById(R.id.title_bar_more).setVisibility(8);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.PrivacyPolicyActivity.AnonymousClass1 */

            public void onClick(View view) {
                PrivacyPolicyActivity.this.finish();
            }
        });
        this.webView = (WebView) findViewById(R.id.webView);
        this.webView.requestFocus();
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setAppCacheEnabled(false);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.PrivacyPolicyActivity.AnonymousClass2 */

            public boolean onLongClick(View view) {
                return true;
            }
        });
        if (intExtra == 3) {
            textView.setText((int) R.string.privacy_content);
            Locale locale = getResources().getConfiguration().locale;
            String language = locale != null ? locale.getLanguage() : "";
            if (!TextUtils.isEmpty(language) && language.equals("de")) {
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy_eu);
            } else if (!TextUtils.isEmpty(language) && language.equals("us")) {
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy_us);
            } else if (!TextUtils.isEmpty(language) && language.equals("sg")) {
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy_eu);
            } else if (!TextUtils.isEmpty(language) && language.equals("tw")) {
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy_eu);
            } else if (!TextUtils.isEmpty(language) && language.equals("hk")) {
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy_eu);
            } else if (TextUtils.isEmpty(language) || !language.equals("in")) {
                if (!TextUtils.isEmpty(language)) {
                    language.equals("zh");
                }
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy);
            } else {
                str = Util.getRawTxt2(getResources(), R.raw.camera_v4_privacy_eu);
            }
            this.webView.loadData(str, "text/html;charset=UTF-8", null);
        }
    }
}
