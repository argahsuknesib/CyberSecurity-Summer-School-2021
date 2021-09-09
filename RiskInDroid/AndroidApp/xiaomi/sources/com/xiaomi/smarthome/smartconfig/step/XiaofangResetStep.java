package com.xiaomi.smarthome.smartconfig.step;

import _m_j.htr;
import _m_j.hze;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.Locale;

public class XiaofangResetStep extends SmartConfigStep {
    @BindView(6986)
    Button mButton;
    @BindView(6290)
    CheckBox mCheck;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6925)
    TextView mTitle;
    @BindView(6753)
    SmartHomeWebView mWebView;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(Context context) {
        String str;
        String str2;
        O000000o(context, (int) R.layout.smart_config_xiaofang_reset);
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.smartconfig.step.XiaofangResetStep.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        Locale globalSettingLocale = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingLocale();
        if (globalSettingLocale == null) {
            globalSettingLocale = Locale.getDefault();
        }
        String str3 = (String) htr.O000000o().O000000o("device_model");
        if (SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
            ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
            StringBuilder sb = new StringBuilder("https://");
            if (globalSettingServer != null) {
                str2 = globalSettingServer.f7546O000000o + ".";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append("home.mi.com/views/deviceReset.html?model=");
            sb.append(str3);
            sb.append("&locale=");
            sb.append(hze.O000000o(globalSettingLocale));
            str = sb.toString();
        } else {
            str = "https://home.mi.com/views/deviceReset.html?model=" + str3 + "&locale=" + hze.O000000o(globalSettingLocale);
        }
        this.mWebView.loadUrl(str);
        this.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.XiaofangResetStep.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                XiaofangResetStep.this.mButton.setEnabled(z);
            }
        });
        this.mButton.setEnabled(false);
        this.mButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.XiaofangResetStep.AnonymousClass3 */

            public final void onClick(View view) {
                XiaofangResetStep.this.O000000o(SmartConfigStep.Step.STEP_CHOOSE_WIFI);
            }
        });
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.XiaofangResetStep.AnonymousClass4 */

            public final void onClick(View view) {
                XiaofangResetStep.this.b_(false);
            }
        });
    }
}
