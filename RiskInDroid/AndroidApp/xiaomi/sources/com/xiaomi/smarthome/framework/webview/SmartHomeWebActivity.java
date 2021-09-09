package com.xiaomi.smarthome.framework.webview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class SmartHomeWebActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f8796O000000o;
    String O00000Oo;
    SmartHomeWebView O00000o;
    TextView O00000o0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_web_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.webview.SmartHomeWebActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SmartHomeWebActivity.this.finish();
            }
        });
        this.O00000o0 = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        this.O00000o = (SmartHomeWebView) findViewById(R.id.webview);
        this.f8796O000000o = getIntent().getStringExtra("url");
        this.O00000Oo = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            this.O00000o0.setText(this.O00000Oo);
        }
        if (TextUtils.isEmpty(this.f8796O000000o)) {
            finish();
        } else {
            this.O00000o.loadUrl(this.f8796O000000o);
        }
    }

    public void onResume() {
        super.onResume();
        SmartHomeWebView smartHomeWebView = this.O00000o;
        if (smartHomeWebView != null) {
            smartHomeWebView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        SmartHomeWebView smartHomeWebView = this.O00000o;
        if (smartHomeWebView != null) {
            smartHomeWebView.onPause();
        }
    }
}
