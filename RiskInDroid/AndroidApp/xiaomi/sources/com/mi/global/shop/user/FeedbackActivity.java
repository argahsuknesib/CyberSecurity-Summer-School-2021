package com.mi.global.shop.user;

import _m_j.byl;
import _m_j.cah;
import _m_j.cav;
import _m_j.cbh;
import _m_j.ccn;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import _m_j.cei;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import org.json.JSONObject;

public class FeedbackActivity extends BaseActivity implements View.OnClickListener {
    @BindView(2131493038)
    CommonButton btnSubmit;
    @BindView(2131493344)
    CustomEditTextView feedbackContent;
    @BindView(2131493345)
    CustomEditTextView feedbackInfo;

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            ccr.O00000Oo("FeedbackActivity", "onCreate, savedInstanceState:" + bundle.toString());
        }
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_user_feedback_edit_fragment);
        ButterKnife.bind(this);
        setTitle((int) R.string.user_feedback_title);
        this.mBackView.setVisibility(0);
        this.mCartView.setVisibility(8);
        initView();
    }

    public void initView() {
        this.btnSubmit.setOnClickListener(this);
        this.mForgetPwd.setText((int) R.string.custom_service);
        this.mForgetPwd.setTextColor(Color.rgb(255, 103, 0));
        this.mForgetPwd.setVisibility(0);
        this.mForgetPwd.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.user.FeedbackActivity.AnonymousClass1 */

            public final void onClick(View view) {
                String O000OO00 = cav.O000OO00();
                Intent intent = new Intent(FeedbackActivity.this, WebActivity.class);
                intent.putExtra("url", O000OO00);
                FeedbackActivity.this.startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit) {
            String trim = this.feedbackContent.getText().toString().trim();
            String trim2 = this.feedbackInfo.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                cec.O000000o(this, getString(R.string.feedback_content_cannot_empty), 3000);
            } else if (TextUtils.isEmpty(trim2)) {
                cec.O000000o(this, getString(R.string.feedback_contact_cannot_empty), 3000);
            } else {
                sendFeedback(trim, trim2);
            }
        }
    }

    public void sendFeedback(String str, String str2) {
        this.btnSubmit.setEnabled(false);
        HashMap hashMap = new HashMap();
        hashMap.put("appid", byl.O00000oo().O00000o());
        hashMap.put("content", str);
        hashMap.put("contact", str2);
        hashMap.put("appversion", Device.O0000oO);
        hashMap.put("mobileversion", Device.O00000oO);
        hashMap.put("androidversion", Device.O0000o0O);
        hashMap.put("deviceid", Device.O0000ooO);
        hashMap.put("mUserId", cei.O000000o(ccn.O0000o00().O00000Oo()));
        cah cah = new cah(1, cav.O000o000(), cbh.O000000o(cbh.O000000o(hashMap), "UTF-8"), new Response.Listener<JSONObject>() {
            /* class com.mi.global.shop.user.FeedbackActivity.AnonymousClass2 */

            public final /* synthetic */ void onResponse(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                FeedbackActivity.this.btnSubmit.setEnabled(true);
                FeedbackActivity.this.hideLoading();
                if (jSONObject == null) {
                    try {
                        ccr.O00000Oo("FeedbackActivity", "get response json null");
                        FeedbackActivity.this.showError("");
                    } catch (Exception e) {
                        ccr.O00000Oo("FeedbackActivity", "loadInfo Exception:" + e.toString());
                        e.printStackTrace();
                        FeedbackActivity.this.showError("");
                    }
                } else {
                    ccr.O00000Oo("FeedbackActivity", "get response json:" + jSONObject.toString());
                    try {
                        if (!jSONObject.has("errno") || jSONObject.getInt("errno") != 0) {
                            FeedbackActivity.this.showError(jSONObject.optString("errmsg"));
                            return;
                        }
                        ccr.O00000Oo("FeedbackActivity", "loadInfo errno = 0");
                        cec.O000000o(FeedbackActivity.this, FeedbackActivity.this.getString(R.string.user_feedback_thanks), 3000);
                        FeedbackActivity.this.finish();
                    } catch (Exception e2) {
                        ccr.O00000Oo("FeedbackActivity", "loadInfo Exception:" + e2.toString());
                        e2.printStackTrace();
                        FeedbackActivity.this.showError("");
                    }
                }
            }
        }, new Response.ErrorListener() {
            /* class com.mi.global.shop.user.FeedbackActivity.AnonymousClass3 */

            public final void onErrorResponse(VolleyError volleyError) {
                FeedbackActivity.this.hideLoading();
                FeedbackActivity.this.btnSubmit.setEnabled(true);
                ccr.O00000Oo("FeedbackActivity", "VolleyError error:" + volleyError.getMessage());
                FeedbackActivity.this.showError("");
            }
        });
        showLoading();
        cah.setTag("FeedbackActivity");
        ced.f13683O000000o.add(cah);
    }

    public void showError(String str) {
        if (TextUtils.isEmpty(str)) {
            cec.O000000o(this, getString(R.string.shop_error_network), 3000);
        } else {
            cec.O000000o(this, str, 3000);
        }
    }
}
