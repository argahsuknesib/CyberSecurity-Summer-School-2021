package com.xiaomi.smarthome.feedback;

import _m_j.fsh;
import _m_j.fsi;
import _m_j.fsm;
import _m_j.fso;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class FeedbackDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f7396O000000o;
    public View mEmptyContainer;
    public View mReplyContainer;
    public TextView mReplyContent;
    public TextView mReplyTime;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.feedback_detail_layout);
        this.f7396O000000o = getIntent().getStringExtra("extra_id");
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.feedback_detail);
        }
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.feedback.FeedbackDetailActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    FeedbackDetailActivity.this.finish();
                }
            });
        }
        String str2 = this.f7396O000000o;
        if (str2 == null || str2.isEmpty()) {
            finish();
            return;
        }
        fsi.O000000o feedbackItem = FeedbackManager.INSTANCE.getFeedbackItem(this.f7396O000000o);
        if (feedbackItem == null) {
            finish();
            return;
        }
        TextView textView2 = (TextView) findViewById(R.id.feedback_title);
        TextView textView3 = (TextView) findViewById(R.id.feedback_desc);
        String feedbackDeviceName = FeedbackManager.INSTANCE.getFeedbackDeviceName(getContext(), feedbackItem.O00000o);
        if (feedbackDeviceName != null) {
            str = String.format("%s | %s", feedbackDeviceName, feedbackItem.O00000Oo);
        } else {
            str = feedbackItem.O00000Oo;
        }
        if (str != null) {
            textView3.setText(str);
        }
        if (feedbackItem.O00000oo != null) {
            textView2.setText(feedbackItem.O00000oo);
        }
        this.mReplyTime = (TextView) findViewById(R.id.feedback_reply_time);
        this.mReplyContent = (TextView) findViewById(R.id.feedback_reply_content);
        this.mReplyContainer = findViewById(R.id.feedback_reply_container);
        this.mEmptyContainer = findViewById(R.id.empty_reply_container);
        FeedbackApi.INSTANCE.getFeedbackDetail(getContext(), this.f7396O000000o, new fsm<fsh, fso>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackDetailActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                final fsh fsh = (fsh) obj;
                FeedbackDetailActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.feedback.FeedbackDetailActivity.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        FeedbackDetailActivity.this.mReplyTime.setText(fsh.O0000O0o);
                        FeedbackDetailActivity.this.mReplyContent.setText(fsh.O00000oo);
                        if (fsh.O00000oO == 1) {
                            FeedbackDetailActivity.this.mEmptyContainer.setVisibility(8);
                            FeedbackDetailActivity.this.mReplyContainer.setVisibility(0);
                            return;
                        }
                        FeedbackDetailActivity.this.mEmptyContainer.setVisibility(0);
                        FeedbackDetailActivity.this.mReplyContainer.setVisibility(8);
                    }
                });
            }

            public final void onFailure(fso fso) {
                FeedbackDetailActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.feedback.FeedbackDetailActivity.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        FeedbackDetailActivity.this.mEmptyContainer.setVisibility(0);
                        FeedbackDetailActivity.this.mReplyContainer.setVisibility(8);
                    }
                });
            }
        });
    }
}
