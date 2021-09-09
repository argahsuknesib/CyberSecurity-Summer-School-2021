package com.xiaomi.smarthome.wificonfig;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;

public class CameraBarcodeHelpActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f11971O000000o;
    private View O00000Oo;
    private Button O00000o;
    private Button O00000o0;
    private SmartHomeWebView O00000oO;
    private String O00000oo;
    private String O0000O0o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_camera_gen_barcode_help);
        this.f11971O000000o = findViewById(R.id.original_help);
        this.O00000Oo = findViewById(R.id.camera_faq);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeHelpActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CameraBarcodeHelpActivity.this.finish();
            }
        });
        this.O0000O0o = getIntent().getStringExtra("model");
        this.O00000oo = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(this.O0000O0o)) {
            this.f11971O000000o.setVisibility(8);
            this.O00000Oo.setVisibility(0);
            this.O00000o0 = (Button) findViewById(R.id.retry);
            this.O00000o = (Button) findViewById(R.id.use_other);
            this.O00000oO = (SmartHomeWebView) findViewById(R.id.webview);
            SmartHomeWebView smartHomeWebView = this.O00000oO;
            String str = this.O00000oo;
            if (str == null) {
                str = "/views/faqDetail.html?question=" + getString(R.string.param_camera_nothing_heard);
            }
            smartHomeWebView.loadUrl(buildUrl(str));
            this.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeHelpActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    CameraBarcodeHelpActivity.this.finish();
                }
            });
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeHelpActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    CameraBarcodeHelpActivity.this.finish();
                }
            });
        }
        findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeHelpActivity.AnonymousClass2 */

            public final void onClick(View view) {
                CameraBarcodeHelpActivity.this.finish();
            }
        });
    }

    public String buildUrl(String str) {
        return SmartConfigRouterFactory.getSmartConfigManager().buildHomeMIHost(this) + str;
    }

    public void onBackPressed() {
        SmartHomeWebView smartHomeWebView = this.O00000oO;
        if (smartHomeWebView == null || !smartHomeWebView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.O00000oO.goBack();
        }
    }
}
