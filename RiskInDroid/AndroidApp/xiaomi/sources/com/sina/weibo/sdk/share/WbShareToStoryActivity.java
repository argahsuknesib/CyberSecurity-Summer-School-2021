package com.sina.weibo.sdk.share;

import _m_j.dbt;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;

public class WbShareToStoryActivity extends BaseActivity {
    private String callbackActivity;
    private View progressBar;
    private int progressColor = -1;
    private int progressId = -1;
    private FrameLayout rootLayout;
    private SaveFileTask saveFileTask;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            if (bundle != null) {
                try {
                    this.callbackActivity = bundle.getString("startActivity");
                } catch (Exception unused) {
                }
            } else {
                this.callbackActivity = intent.getStringExtra("startActivity");
            }
            if (intent.getIntExtra("startFlag", -1) != 0) {
                finish();
            } else if (TextUtils.isEmpty(this.callbackActivity)) {
                finish();
            } else {
                StoryMessage storyMessage = null;
                try {
                    storyMessage = (StoryMessage) getIntent().getParcelableExtra("_weibo_message_stroy");
                } catch (Exception unused2) {
                }
                if (storyMessage == null) {
                    setCallbackActivity(2);
                } else if (checkInfo(storyMessage)) {
                    initView();
                    gotoSave(storyMessage);
                } else {
                    setCallbackActivity(2);
                }
            }
        }
    }

    private void initView() {
        try {
            this.progressColor = getIntent().getIntExtra("progressColor", -1);
            this.progressId = getIntent().getIntExtra("progressId", -1);
        } catch (Exception unused) {
        }
        this.rootLayout = new FrameLayout(this);
        if (this.progressId != -1) {
            try {
                this.progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(this.progressId, (ViewGroup) null);
            } catch (Exception unused2) {
                this.progressBar = new WbSdkProgressBar(this);
            }
        } else {
            this.progressBar = new WbSdkProgressBar(this);
            int i = this.progressColor;
            if (i != -1) {
                ((WbSdkProgressBar) this.progressBar).setProgressColor(i);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(this.progressBar, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
        setContentView(this.rootLayout);
    }

    private boolean checkInfo(StoryMessage storyMessage) {
        return storyMessage.checkSource() && WbSdk.supportMultiImage(this);
    }

    private void gotoSave(StoryMessage storyMessage) {
        SaveFileTask saveFileTask2 = this.saveFileTask;
        if (saveFileTask2 != null) {
            saveFileTask2.cancel(true);
        }
        this.saveFileTask = new SaveFileTask(this, new TransResourceCallback() {
            /* class com.sina.weibo.sdk.share.WbShareToStoryActivity.AnonymousClass1 */

            public void onTransFinish(TransResourceResult transResourceResult) {
            }

            public void onTransFinish(StoryObject storyObject) {
                if (storyObject != null) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
                        intent.setPackage(intent.getStringExtra("startPackage"));
                        intent.putExtra("storyData", storyObject);
                        WbShareToStoryActivity.this.startActivity(intent);
                        return;
                    } catch (Exception unused) {
                    }
                }
                WbShareToStoryActivity.this.setCallbackActivity(2);
            }
        });
        this.saveFileTask.execute(storyMessage);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        int i;
        super.onNewIntent(intent);
        try {
            i = intent.getIntExtra("backType", 0);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            setCallbackActivity(1);
        } else {
            setCallbackActivity(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("startActivity", this.callbackActivity);
    }

    public void setCallbackActivity(int i) {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("_weibo_resp_errcode", i);
            setResult(-1, intent);
        } catch (Exception e) {
            dbt.O00000o("weibo sdk", e.toString());
        }
        finish();
    }
}
