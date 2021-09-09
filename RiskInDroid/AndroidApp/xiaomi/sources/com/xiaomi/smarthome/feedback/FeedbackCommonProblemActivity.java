package com.xiaomi.smarthome.feedback;

import _m_j.fcn;
import _m_j.fju;
import _m_j.flk;
import _m_j.hsk;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebView;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import java.util.Locale;

public class FeedbackCommonProblemActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Locale f7392O000000o;
    private TextView O00000Oo;
    public String mDid;
    public TextView mFeedBackBtn;
    public String mModel;
    public int mType;
    public SmartHomeWebView wvCommonProblem;

    public void onCreate(Bundle bundle) {
        String feedbackDeviceName;
        super.onCreate(bundle);
        setContentView((int) R.layout.feedback_common_problem_layout);
        this.mModel = getIntent().getStringExtra("extra_model");
        this.mDid = getIntent().getStringExtra("did");
        String str = this.mModel;
        if (str == null || str.isEmpty()) {
            finish();
        }
        this.mType = getIntent().getIntExtra("extra_type", -1);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (!(textView == null || (feedbackDeviceName = FeedbackManager.INSTANCE.getFeedbackDeviceName(getContext(), this.mModel)) == null)) {
            textView.setText(feedbackDeviceName);
        }
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.feedback.FeedbackCommonProblemActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    if (FeedbackCommonProblemActivity.this.wvCommonProblem == null || !FeedbackCommonProblemActivity.this.wvCommonProblem.canGoBack()) {
                        FeedbackCommonProblemActivity.this.finish();
                    } else {
                        FeedbackCommonProblemActivity.this.wvCommonProblem.goBack();
                    }
                }
            });
        }
        this.wvCommonProblem = (SmartHomeWebView) findViewById(R.id.wv_common_problem);
        this.O00000Oo = (TextView) findViewById(R.id.tv_intelligent_assistant);
        this.f7392O000000o = CoreApi.O000000o().O00oOooo();
        if (this.f7392O000000o == null) {
            this.f7392O000000o = Locale.getDefault();
        }
        SmartHomeWebView smartHomeWebView = this.wvCommonProblem;
        smartHomeWebView.loadUrl(buildUrl("/views/faqQuestion.html?model=" + this.mModel + "&locale=" + flk.O000000o(this.f7392O000000o)));
        this.mFeedBackBtn = (TextView) findViewById(R.id.btn_feedback_problem);
        this.mFeedBackBtn.setText((int) R.string.feedback_problem);
        int i = 0;
        hxi.O00000o0.f957O000000o.O000000o("usual_question_list_show", "model", this.mModel, "type", Integer.valueOf(this.mType));
        TextView textView2 = this.O00000Oo;
        if (!fju.O000000o().O0000OOo()) {
            i = 8;
        }
        textView2.setVisibility(i);
        this.mFeedBackBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedbackCommonProblemActivity.AnonymousClass1 */

            public final void onClick(View view) {
                if (FeedbackCommonProblemActivity.this.mModel.equals("account")) {
                    hxi.O00000o.f952O000000o.O000000o("faq_zhanghao_detail.custom.ask.clk", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo());
                    if (flk.O000000o(FeedbackCommonProblemActivity.this.f7392O000000o).equals("zh_CN")) {
                        OperationCommonWebViewActivity.start(FeedbackCommonProblemActivity.this, "https://feedback.miui.com/layout/#/submit?moduleId=131&language=zh&showHeader=false", "");
                    } else {
                        OperationCommonWebViewActivity.start(FeedbackCommonProblemActivity.this, "https://feedback.miui.com/layout/#/submit?moduleId=131&language=en&showHeader=false", "");
                    }
                } else {
                    FeedbackCommonProblemActivity.this.mFeedBackBtn.setEnabled(false);
                    Intent intent = new Intent(FeedbackCommonProblemActivity.this.getContext(), FeedbackActivity.class);
                    intent.putExtra("extra_device_model", FeedbackCommonProblemActivity.this.mModel);
                    if (!TextUtils.isEmpty(FeedbackCommonProblemActivity.this.mDid)) {
                        intent.putExtra("extra_device_did", FeedbackCommonProblemActivity.this.mDid);
                    }
                    intent.putExtra("extra_source", 0);
                    FeedbackCommonProblemActivity.this.startActivityForResult(intent, 100);
                }
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedbackCommonProblemActivity.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent(FeedbackCommonProblemActivity.this, IntelligentAssistantActivity.class);
                intent.putExtra("extra_model", FeedbackCommonProblemActivity.this.mModel);
                intent.putExtra("did", FeedbackCommonProblemActivity.this.mDid);
                intent.putExtra("extra_type", FeedbackCommonProblemActivity.this.mType);
                FeedbackCommonProblemActivity.this.startActivity(intent);
                hxk hxk = hxi.O00000o;
                String str = FeedbackCommonProblemActivity.this.mModel;
                int i = FeedbackCommonProblemActivity.this.mType;
                hxk.f952O000000o.O000000o("smarthepler_click", "model", str, "type", Integer.valueOf(i));
            }
        });
    }

    public String buildUrl(String str) {
        return hsk.O00000Oo(ServiceApplication.getAppContext()) + str;
    }

    public void onBackPressed() {
        SmartHomeWebView smartHomeWebView = this.wvCommonProblem;
        if (smartHomeWebView == null || !smartHomeWebView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.wvCommonProblem.goBack();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 100) {
            return;
        }
        if (i2 != -1 || intent == null || !intent.getBooleanExtra("finish", false)) {
            this.mFeedBackBtn.setEnabled(true);
        } else {
            finish();
        }
    }
}
