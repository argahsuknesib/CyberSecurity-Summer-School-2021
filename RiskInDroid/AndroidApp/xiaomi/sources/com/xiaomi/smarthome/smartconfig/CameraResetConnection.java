package com.xiaomi.smarthome.smartconfig;

import _m_j.ftn;
import _m_j.hxi;
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

public class CameraResetConnection extends BaseActivity {
    @BindView(6986)
    Button mButton;
    @BindView(6290)
    CheckBox mCheck;
    public String mModel;
    @BindView(6920)
    View mReturnBtn;
    @BindView(6925)
    TextView mTitle;
    @BindView(7419)
    TextView mTvDesc;
    @BindView(6753)
    WebView mWebView;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView((int) R.layout.smart_config_camera_reset);
        ButterKnife.bind(this);
        this.mWebView.setWebViewClient(new WebViewClient() {
            /* class com.xiaomi.smarthome.smartconfig.CameraResetConnection.AnonymousClass1 */

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        this.mTitle.setText((int) R.string.camera_connect_guide);
        TextView textView = this.mTvDesc;
        if (textView != null) {
            textView.setText((int) R.string.camera_step12_desc);
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        this.mModel = getIntent().getStringExtra("model");
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
            sb.append(this.mModel);
            sb.append("&locale=");
            sb.append(O00oOooo.toString());
            str = sb.toString();
        } else {
            str = "https://home.mi.com/views/deviceReset.html?model=" + this.mModel + "&locale=" + O00oOooo.toString();
        }
        this.mWebView.loadUrl(str);
        this.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraResetConnection.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraResetConnection.this.mButton.setEnabled(z);
                if (z) {
                    hxi.O00000o.O0000o00(CameraResetConnection.this.mModel);
                }
            }
        });
        this.mButton.setEnabled(false);
        this.mButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraResetConnection.AnonymousClass3 */

            public final void onClick(View view) {
                hxi.O00000o.O0000o0(CameraResetConnection.this.mModel);
                Intent intent = new Intent(CameraResetConnection.this, CameraApChooseConnection.class);
                intent.putExtra("model", CameraResetConnection.this.mModel);
                CameraResetConnection.this.startActivity(intent);
                CameraResetConnection.this.finish();
            }
        });
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraResetConnection.AnonymousClass4 */

            public final void onClick(View view) {
                CameraResetConnection.this.finish();
            }
        });
        hxi.O00000o0.O000000o(this.mModel);
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
