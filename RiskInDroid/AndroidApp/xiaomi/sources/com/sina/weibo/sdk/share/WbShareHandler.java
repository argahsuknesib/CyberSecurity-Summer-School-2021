package com.sina.weibo.sdk.share;

import _m_j.dbm;
import _m_j.dbr;
import _m_j.dbt;
import _m_j.dbu;
import _m_j.dby;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;

public class WbShareHandler {
    private Activity context;
    private boolean hasRegister = false;
    private int progressColor = -1;
    private int progressId = -1;

    public boolean supportMulti() {
        return false;
    }

    public WbShareHandler(Activity activity) {
        this.context = activity;
    }

    public boolean registerApp() {
        sendBroadcast(this.context, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER", WbSdk.getAuthInfo().getAppKey(), null, null);
        this.hasRegister = true;
        return true;
    }

    private void sendBroadcast(Context context2, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent(str);
        String packageName = context2.getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0041005000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", str2);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", dbu.O000000o(dby.O000000o(context2, packageName)));
        if (!TextUtils.isEmpty(str3)) {
            intent.setPackage(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context2.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
    }

    public void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z) {
        if (!this.hasRegister) {
            throw new RuntimeException("please call WbShareHandler.registerApp(),before use share function");
        } else if (!WbSdk.isWbInstall(this.context) && z) {
        } else {
            if (z) {
                startClientShare(weiboMultiMessage);
                return;
            }
            WbAppInfo O000000o2 = dbm.O000000o(this.context).O000000o();
            if (!WbSdk.isWbInstall(this.context) || O000000o2 == null || O000000o2.getSupportVersion() <= 10000) {
                startWebShare(weiboMultiMessage);
            } else {
                startClientShare(weiboMultiMessage);
            }
        }
    }

    public void shareToStory(StoryMessage storyMessage) {
        Uri imageUri = storyMessage.getImageUri();
        Uri videoUri = storyMessage.getVideoUri();
        if ((imageUri == null || !dbr.O000000o(this.context, imageUri)) && (videoUri == null || !dbr.O00000Oo(this.context, videoUri))) {
            throw new IllegalStateException("File only can be Image or Video. ");
        }
        Intent intent = new Intent();
        intent.putExtra("_weibo_message_stroy", storyMessage);
        intent.putExtra("startActivity", this.context.getClass().getName());
        intent.putExtra("startPackage", dbm.O000000o(this.context).O000000o().getPackageName());
        intent.putExtra("progressColor", this.progressColor);
        intent.putExtra("progressId", this.progressId);
        intent.putExtra("startFlag", 0);
        intent.setClass(this.context, WbShareToStoryActivity.class);
        this.context.startActivityForResult(intent, 1);
    }

    private void startClientShare(WeiboMultiMessage weiboMultiMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        bundle.putLong("callbackId", 0);
        bundle.putAll(weiboMultiMessage.toBundle(bundle));
        Intent intent = new Intent();
        intent.setClass(this.context, WbShareTransActivity.class);
        intent.putExtra("startFlag", 0);
        intent.putExtra("startActivity", this.context.getClass().getName());
        intent.putExtra("progressColor", this.progressColor);
        intent.putExtra("progressId", this.progressId);
        intent.putExtras(bundle);
        try {
            this.context.startActivityForResult(intent, 1);
        } catch (Exception e) {
            dbt.O00000o("weibo sdk error ", e.toString());
        }
    }

    private void startWebShare(WeiboMultiMessage weiboMultiMessage) {
        dbt.O00000Oo("Share", "startWebShare");
        Intent intent = new Intent(this.context, WbShareTransActivity.class);
        String packageName = this.context.getPackageName();
        ShareWebViewRequestParam shareWebViewRequestParam = new ShareWebViewRequestParam(WbSdk.getAuthInfo(), WebRequestType.SHARE, "", "微博分享", this.context);
        shareWebViewRequestParam.O000000o(this.context);
        shareWebViewRequestParam.O0000O0o = "";
        shareWebViewRequestParam.O00000oo = packageName;
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.context);
        if (readAccessToken != null && !TextUtils.isEmpty(readAccessToken.getToken())) {
            shareWebViewRequestParam.O00000oO = readAccessToken.getToken();
        }
        shareWebViewRequestParam.O00000o0 = weiboMultiMessage;
        Bundle bundle = new Bundle();
        shareWebViewRequestParam.O00000o0(bundle);
        intent.putExtras(bundle);
        intent.putExtra("startFlag", 0);
        intent.putExtra("startActivity", this.context.getClass().getName());
        intent.putExtra("startAction", "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
        intent.putExtra("gotoActivity", "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
        this.context.startActivityForResult(intent, 1);
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.context);
    }

    public void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (wbShareCallback != null && intent != null && (extras = intent.getExtras()) != null) {
            int i = extras.getInt("_weibo_resp_errcode", -1);
            if (i == 0) {
                wbShareCallback.onWbShareSuccess();
            } else if (i == 1) {
                wbShareCallback.onWbShareCancel();
            } else if (i == 2) {
                wbShareCallback.onWbShareFail();
            }
        }
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
    }

    public void setProgressId(int i) {
        this.progressId = i;
    }
}
