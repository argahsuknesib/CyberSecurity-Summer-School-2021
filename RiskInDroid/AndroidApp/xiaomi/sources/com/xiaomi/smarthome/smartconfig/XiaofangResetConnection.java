package com.xiaomi.smarthome.smartconfig;

import _m_j.flk;
import _m_j.ftn;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.Locale;

public class XiaofangResetConnection extends BaseActivity {
    @BindView(6986)
    Button mButton;
    @BindView(6290)
    CheckBox mCheck;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6925)
    TextView mTitle;
    @BindView(6753)
    WebView mWebView;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView((int) R.layout.smart_config_xiaofang_reset);
        ButterKnife.bind(this);
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.smartconfig.XiaofangResetConnection.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
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
            sb.append("isa.camera.isc5");
            sb.append("&locale=");
            sb.append(flk.O000000o(O00oOooo));
            str = sb.toString();
        } else {
            str = "https://home.mi.com/views/deviceReset.html?model=" + "isa.camera.isc5" + "&locale=" + flk.O000000o(O00oOooo);
        }
        this.mWebView.loadUrl(str);
        this.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaofangResetConnection.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                XiaofangResetConnection.this.mButton.setEnabled(z);
            }
        });
        this.mButton.setEnabled(false);
        this.mButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaofangResetConnection.AnonymousClass3 */

            public final void onClick(View view) {
                XiaofangResetConnection.this.startActivity(new Intent(XiaofangResetConnection.this, XiaofangChooseConnection.class));
                XiaofangResetConnection.this.finish();
            }
        });
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.XiaofangResetConnection.AnonymousClass4 */

            public final void onClick(View view) {
                XiaofangResetConnection.this.finish();
            }
        });
    }

    public void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
    }
}
