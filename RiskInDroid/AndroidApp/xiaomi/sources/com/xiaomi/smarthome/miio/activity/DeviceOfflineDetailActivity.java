package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.flk;
import _m_j.fno;
import _m_j.fqy;
import _m_j.gwg;
import _m_j.hsk;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.Locale;

public class DeviceOfflineDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private XQProgressDialog f9663O000000o;
    public String mDid;
    public String mModel;
    public SmartHomeWebView wvCommonProblem;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.activity_device_offline_detail);
        this.mModel = getIntent().getStringExtra("extra_model");
        this.mDid = getIntent().getStringExtra("did");
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.device_offline_page_title);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.DeviceOfflineDetailActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    if (DeviceOfflineDetailActivity.this.wvCommonProblem == null || !DeviceOfflineDetailActivity.this.wvCommonProblem.canGoBack()) {
                        DeviceOfflineDetailActivity.this.finish();
                    } else {
                        DeviceOfflineDetailActivity.this.wvCommonProblem.goBack();
                    }
                }
            });
        }
        this.wvCommonProblem = (SmartHomeWebView) findViewById(R.id.wv_common_problem);
        SmartHomeWebView smartHomeWebView = this.wvCommonProblem;
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        String stringExtra = getIntent().getStringExtra("arg_device_type");
        String buildUrl = buildUrl("/offlineGuide.html?model=" + this.mModel + "&locale=" + flk.O000000o(O00oOooo));
        smartHomeWebView.loadUrl(buildUrl + "&WDC=" + stringExtra);
        this.wvCommonProblem.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.miio.activity.DeviceOfflineDetailActivity.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!str.contains("home.mi.com/views/deviceReset.html?model=")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                Device O000000o2 = fno.O000000o().O000000o(DeviceOfflineDetailActivity.this.mDid);
                if (O000000o2 == null || DeviceCategory.fromPid(O000000o2.pid) != DeviceCategory.Bluetooth) {
                    fbt fbt = new fbt(DeviceOfflineDetailActivity.this, "ResetPageRoute");
                    Bundle O000000o3 = fqy.O000000o(DeviceOfflineDetailActivity.this.getIntent());
                    if (O000000o3 != null) {
                        fbt.O000000o(O000000o3);
                    }
                    fbt.O000000o("extra_model", DeviceOfflineDetailActivity.this.mModel);
                    fbt.O00000Oo(268435456);
                    fbs.O000000o(fbt);
                    return true;
                }
                XmPluginHostApi.instance().visualSecureBind(O000000o2.did);
                return true;
            }
        });
        findViewById(R.id.feedback_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.DeviceOfflineDetailActivity.AnonymousClass2 */

            public final void onClick(View view) {
                fbt fbt = new fbt(DeviceOfflineDetailActivity.this, "/userCenter/FeedbackActivity");
                fbt.O000000o("extra_device_model", DeviceOfflineDetailActivity.this.mModel);
                fbt.O000000o("extra_device_did", DeviceOfflineDetailActivity.this.mDid);
                fbt.O000000o("extra_source", 0);
                fbs.O000000o(fbt);
            }
        });
    }

    public void onContentChanged() {
        super.onContentChanged();
        gwg.O00000o(this);
    }

    public void onDestroy() {
        super.onDestroy();
        XQProgressDialog xQProgressDialog = this.f9663O000000o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public String buildUrl(String str) {
        return hsk.O00000Oo(CommonApplication.getAppContext()) + str;
    }

    public void onBackPressed() {
        SmartHomeWebView smartHomeWebView = this.wvCommonProblem;
        if (smartHomeWebView == null || !smartHomeWebView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.wvCommonProblem.goBack();
        }
    }
}
