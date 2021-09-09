package com.xiaomi.smarthome.framework.page.develop;

import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.plugin.pluginhook.config.DNSHookConfigManager;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;

public class DevPluginHookTestActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f7799O000000o;
    EditText O00000Oo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dev_plugin_hook_test_activity);
        this.f7799O000000o = (TextView) findViewById(R.id.result_tv);
        this.O00000Oo = (EditText) findViewById(R.id.url_input);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DevPluginHookTestActivity$TC_MRrLM2iTWMQqN9QQknuNIVxo */

            public final void onClick(View view) {
                DevPluginHookTestActivity.this.O00000Oo(view);
            }
        });
        findViewById(R.id.connect_test).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DevPluginHookTestActivity$lrndam34kmBLQf_PyBwECdCNEF0 */

            public final void onClick(View view) {
                DevPluginHookTestActivity.this.O000000o(view);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("是否初始化完成：" + DNSHookConfigManager.getInstance().isInited() + "\n");
        stringBuffer.append("是否启动：" + DNSHookConfigManager.getInstance().isEnabled() + "\n");
        stringBuffer.append("支持的最低app版本：" + DNSHookConfigManager.getInstance().getMinAppVer() + "\n");
        stringBuffer.append("白名单域名个数：" + DNSHookConfigManager.getInstance().getWhiteListSet().size() + "\n");
        ((TextView) findViewById(R.id.dns_hook_status)).setText(stringBuffer.toString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        try {
            gsg.O000000o(o000000o.O00000Oo(this.O00000Oo.getText().toString()).O000000o(), new gsl() {
                /* class com.xiaomi.smarthome.framework.page.develop.DevPluginHookTestActivity.AnonymousClass1 */

                public final void onSuccess(Object obj, Response response) {
                }

                public final void processResponse(Response response) {
                    try {
                        TextView textView = DevPluginHookTestActivity.this.f7799O000000o;
                        StringBuilder sb = new StringBuilder("onSuccess:response=");
                        sb.append(response == null ? null : response.body().string());
                        textView.setText(sb.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                        DevPluginHookTestActivity.this.f7799O000000o.setText("onSuccess with response.body() exception");
                    }
                }

                public final void processFailure(Call call, IOException iOException) {
                    try {
                        TextView textView = DevPluginHookTestActivity.this.f7799O000000o;
                        textView.setText("processFailure:=,e=" + iOException.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        TextView textView2 = DevPluginHookTestActivity.this.f7799O000000o;
                        textView2.setText("processFailure exception:,e=" + iOException.getMessage());
                    }
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    try {
                        TextView textView = DevPluginHookTestActivity.this.f7799O000000o;
                        StringBuilder sb = new StringBuilder("onFailure:error=");
                        sb.append(gsf);
                        sb.append(",e=");
                        sb.append(exc.getMessage());
                        sb.append(",response=");
                        sb.append(response == null ? null : response.body().string());
                        textView.setText(sb.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                        TextView textView2 = DevPluginHookTestActivity.this.f7799O000000o;
                        textView2.setText("onFailure with response.body() exception:error=" + gsf + ",e=" + exc.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            TextView textView = this.f7799O000000o;
            textView.setText("HttpApi.sendRequest异常：" + e.getMessage());
        }
    }
}
