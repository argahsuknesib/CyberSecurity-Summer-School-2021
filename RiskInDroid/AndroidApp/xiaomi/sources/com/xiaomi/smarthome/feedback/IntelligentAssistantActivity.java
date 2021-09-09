package com.xiaomi.smarthome.feedback;

import _m_j.gku;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;

public class IntelligentAssistantActivity extends BaseActivity {
    public static final String url = "https://chat.kefu.mi.com/page/index/v2?tag=cn&token=Y24jMTAwMSNjbi53ZWIubWlqaWFfYXBwI3FaVHdkS3VIc0IjaGVscENlbnRlcg==&groupId=P0&closedshow=1";

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f7419O000000o;
    private TextView O00000Oo;
    private String O00000o;
    private CommonWebView O00000o0;
    private String O00000oO;
    private int O00000oo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.intelligent_assistant_layout);
        this.O00000o = getIntent().getStringExtra("extra_model");
        this.O00000oO = getIntent().getStringExtra("did");
        this.O00000oo = getIntent().getIntExtra("extra_type", -1);
        String str = this.O00000o;
        if (str == null || str.isEmpty()) {
            finish();
        }
        this.f7419O000000o = (ImageView) findViewById(R.id.ia_return_btn);
        this.O00000Oo = (TextView) findViewById(R.id.ia_feedback_button);
        this.O00000o0 = (CommonWebView) findViewById(R.id.ia_session_wv);
        this.f7419O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.feedback.$$Lambda$IntelligentAssistantActivity$7oCwLOZUsARo3xFsZOvI2ukFVE */

            public final void onClick(View view) {
                IntelligentAssistantActivity.this.O00000Oo(view);
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.feedback.$$Lambda$IntelligentAssistantActivity$rZJ0WAK5lp_BXfDVr0WPKDfcWWU */

            public final void onClick(View view) {
                IntelligentAssistantActivity.this.O000000o(view);
            }
        });
        if (Build.VERSION.SDK_INT >= 29) {
            if (gku.O000000o(getContext())) {
                this.O00000o0.getSettings().setForceDark(2);
            } else {
                this.O00000o0.getSettings().setForceDark(0);
            }
        }
        this.O00000o0.loadUrl(url);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        try {
            WebViewRouterFactory.getWebViewHelpManager().assistActivity(this);
            WebViewRouterFactory.getWebViewHelpManager().setShouldFitSoftKeybord(true);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        this.O00000o0.O00000Oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        Intent intent = new Intent(getContext(), FeedbackActivity.class);
        intent.putExtra("extra_device_model", this.O00000o);
        if (!TextUtils.isEmpty(this.O00000oO)) {
            intent.putExtra("extra_device_did", this.O00000oO);
        }
        intent.putExtra("extra_source", 1);
        startActivity(intent);
        hxk hxk = hxi.O00000o;
        String str = this.O00000o;
        int i = this.O00000oo;
        hxk.f952O000000o.O000000o("feedback_more_click", "model", str, "type", Integer.valueOf(i));
    }
}
