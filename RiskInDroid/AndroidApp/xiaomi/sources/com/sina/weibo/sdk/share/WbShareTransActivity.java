package com.sina.weibo.sdk.share;

import _m_j.dbm;
import _m_j.dbt;
import _m_j.dbu;
import _m_j.dby;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.web.view.WbSdkProgressBar;

public class WbShareTransActivity extends BaseActivity {
    private CopyResourceTask copyResourceTask;
    boolean flag = false;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        /* class com.sina.weibo.sdk.share.WbShareTransActivity.AnonymousClass1 */

        public void handleMessage(Message message) {
            super.handleMessage(message);
            WbShareTransActivity.this.sendCallback(1);
        }
    };
    public FrameLayout rootLayout;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dbt.O000000o("Share", "startShareTransActivity");
        initView();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getIntExtra("startFlag", -1) != 0) {
                finish();
            } else {
                checkSource(intent);
            }
        }
    }

    private void checkSource(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                finish();
                return;
            }
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            weiboMultiMessage.toObject(extras);
            transPicAndVideoResource(weiboMultiMessage);
        } catch (Exception unused) {
            finish();
        }
    }

    private void initView() {
        View view;
        int intExtra = getIntent().getIntExtra("progressColor", -1);
        int intExtra2 = getIntent().getIntExtra("progressId", -1);
        this.rootLayout = new FrameLayout(this);
        if (intExtra2 != -1) {
            try {
                view = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra2, (ViewGroup) null);
            } catch (Exception unused) {
                view = new WbSdkProgressBar(this);
            }
        } else {
            WbSdkProgressBar wbSdkProgressBar = new WbSdkProgressBar(this);
            if (intExtra != -1) {
                wbSdkProgressBar.setProgressColor(intExtra);
            }
            view = wbSdkProgressBar;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.rootLayout.addView(view, layoutParams);
        this.rootLayout.setBackgroundColor(855638016);
    }

    public void gotoWeiboComposer(WeiboMultiMessage weiboMultiMessage) {
        dbt.O000000o("Share", "gotoWeiboComposer");
        Intent intent = getIntent();
        this.flag = true;
        try {
            intent.putExtra("startFlag", -1);
            Intent intent2 = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
            Bundle extras = intent.getExtras();
            weiboMultiMessage.toBundle(extras);
            intent2.putExtras(extras);
            String packageName = getPackageName();
            intent2.putExtra("_weibo_sdkVersion", "0041005000");
            intent2.putExtra("_weibo_appPackage", packageName);
            intent2.putExtra("_weibo_appKey", WbSdk.getAuthInfo().getAppKey());
            intent2.putExtra("_weibo_flag", 538116905);
            intent2.putExtra("_weibo_sign", dbu.O000000o(dby.O000000o(this, packageName)));
            String stringExtra = intent.getStringExtra("gotoActivity");
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WeiboSdkWebActivity".equals(stringExtra)) {
                intent2.setClassName(this, "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
                startActivityForResult(intent2, 765);
            } else if (WbSdk.isWbInstall(this)) {
                WbAppInfo O000000o2 = dbm.O000000o(this).O000000o();
                if (O000000o2 != null) {
                    intent2.setPackage(O000000o2.getPackageName());
                }
                startActivityForResult(intent2, 765);
            } else {
                sendCallback(2);
            }
        } catch (Exception unused) {
            sendCallback(2);
        }
    }

    private void transPicAndVideoResource(WeiboMultiMessage weiboMultiMessage) {
        setContentView(this.rootLayout);
        if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
            gotoWeiboComposer(weiboMultiMessage);
            return;
        }
        CopyResourceTask copyResourceTask2 = this.copyResourceTask;
        if (copyResourceTask2 != null) {
            copyResourceTask2.cancel(true);
        }
        this.copyResourceTask = new CopyResourceTask(this, new TransResourceCallback() {
            /* class com.sina.weibo.sdk.share.WbShareTransActivity.AnonymousClass2 */

            public void onTransFinish(StoryObject storyObject) {
            }

            public void onTransFinish(TransResourceResult transResourceResult) {
                WbShareTransActivity.this.rootLayout.setVisibility(4);
                if (transResourceResult == null || !transResourceResult.transDone) {
                    WbShareTransActivity.this.sendCallback(2);
                } else {
                    WbShareTransActivity.this.gotoWeiboComposer(transResourceResult.message);
                }
            }
        });
        this.copyResourceTask.execute(weiboMultiMessage);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(0, 100);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dbt.O00000Oo("Share", "startTransActivity.onNewIntent()");
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeMessages(0);
            this.handler = null;
        }
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.remove("startFlag");
    }

    public void sendCallback(int i) {
        FrameLayout frameLayout = this.rootLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", i);
            intent.putExtras(bundle);
            setResult(-1, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeMessages(0);
            this.handler = null;
        }
        finish();
    }
}
