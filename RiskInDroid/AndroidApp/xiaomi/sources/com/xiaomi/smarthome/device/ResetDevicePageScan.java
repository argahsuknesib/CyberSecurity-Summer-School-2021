package com.xiaomi.smarthome.device;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.flk;
import _m_j.ftn;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.Locale;

public class ResetDevicePageScan extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f7022O000000o;
    private Button O00000Oo;
    private WebView O00000o0;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView((int) R.layout.choose_device_failed_page);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ResetDevicePageScan.AnonymousClass1 */

            public final void onClick(View view) {
                ResetDevicePageScan.this.onBackPressed();
            }
        });
        if (getIntent() != null) {
            this.f7022O000000o = getIntent().getStringExtra("model");
        }
        this.O00000Oo = (Button) findViewById(R.id.next_btn);
        this.O00000o0 = (WebView) findViewById(R.id.kuailian_reset_web_view);
        this.O00000o0.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.device.ResetDevicePageScan.AnonymousClass2 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        if (this.f7022O000000o != null) {
            this.O00000Oo.setText((int) R.string.smart_config_reconnect);
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(this.f7022O000000o);
            if (O00000oO != null) {
                ((TextView) findViewById(R.id.module_a_3_return_title)).setText(O00000oO.O0000Oo0());
            }
            this.O00000Oo.setVisibility(0);
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                O00oOooo = Locale.getDefault();
            }
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                StringBuilder sb = new StringBuilder("https://");
                if (O0000ooO != null) {
                    str2 = O0000ooO.f7546O000000o + ".";
                } else {
                    str2 = "";
                }
                sb.append(str2);
                sb.append("home.mi.com/views/deviceReset.html?model=");
                sb.append(this.f7022O000000o);
                sb.append("&locale=");
                sb.append(flk.O000000o(O00oOooo));
                str = sb.toString();
            } else {
                str = "https://home.mi.com/views/deviceReset.html?model=" + this.f7022O000000o + "&locale=" + flk.O000000o(O00oOooo);
            }
            this.O00000o0.loadUrl(str);
            this.O00000Oo.setText((int) R.string.kuailian_reset_text);
            this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ResetDevicePageScan.AnonymousClass3 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(ResetDevicePageScan.this, "SmartConfigMainActivity");
                    if (ResetDevicePageScan.this.getIntent() != null) {
                        fbt.O000000o("connect_source", ResetDevicePageScan.this.getIntent().getIntExtra("connect_source", 0));
                        fbt.O000000o("connect_unique", ResetDevicePageScan.this.getIntent().getStringExtra("connect_unique"));
                    }
                    fbt.O000000o("strategy_id", 5);
                    if (ResetDevicePageScan.this.getIntent() != null && ResetDevicePageScan.this.getIntent().hasExtra("key_qrcode_oob")) {
                        fbt.O000000o("key_qrcode_oob", ResetDevicePageScan.this.getIntent().getStringExtra("key_qrcode_oob"));
                    }
                    fbs.O000000o(fbt);
                    ResetDevicePageScan.this.finish();
                }
            });
        }
    }
}
