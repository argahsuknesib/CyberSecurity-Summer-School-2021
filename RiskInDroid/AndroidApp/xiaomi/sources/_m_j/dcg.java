package _m_j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public final class dcg extends dce {
    private boolean O00000o = false;
    private Activity O00000o0;

    public dcg(Activity activity, dcb dcb, dci dci) {
        super(dcb, dci);
        this.O00000o0 = activity;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.O00000Oo != null) {
            this.O00000Oo.onPageStartedCallBack(webView, str, bitmap);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.O00000Oo != null) {
            this.O00000Oo.onPageFinishedCallBack(webView, str);
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.O00000Oo != null) {
            this.O00000Oo.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.O00000Oo != null) {
            this.O00000Oo.onReceivedErrorCallBack(webView, i, str, str2);
        }
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return O000000o(webResourceRequest.getUrl().toString());
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.O00000Oo != null) {
            this.O00000Oo.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        return O000000o(str);
    }

    private boolean O000000o(String str) {
        if (!str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle O000000o2 = dbz.O000000o(str);
        if (this.f14466O000000o.f14467O000000o != null && !TextUtils.isEmpty(this.f14466O000000o.f14467O000000o.callback)) {
            String str2 = this.f14466O000000o.f14467O000000o.callback;
            dcc O000000o3 = dcc.O000000o();
            if (O000000o3.O000000o(str2) != null && !O000000o2.isEmpty()) {
                O000000o3.O00000Oo(str2);
            }
        }
        String string = O000000o2.getString("code");
        String string2 = O000000o2.getString("msg");
        if (TextUtils.isEmpty(string)) {
            O000000o(this.O00000o0);
        } else if (!"0".equals(string)) {
            O000000o(this.O00000o0, 2, string2);
        } else {
            O00000Oo(this.O00000o0);
        }
        if (this.O00000Oo == null) {
            return true;
        }
        this.O00000Oo.closePage();
        return true;
    }

    private void O000000o(Activity activity, int i, String str) {
        dbt.O00000Oo("Share", "WebActivity.sendSdkResponse,errCode:" + i + ",errMsg:" + str);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null && !this.O00000o) {
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
            String string = extras.getString("packageName");
            intent.setFlags(131072);
            intent.setPackage(string);
            intent.putExtras(extras);
            intent.putExtra("_weibo_appPackage", activity.getPackageName());
            intent.putExtra("_weibo_resp_errcode", i);
            intent.putExtra("_weibo_resp_errstr", str);
            try {
                activity.startActivityForResult(intent, 765);
            } catch (ActivityNotFoundException unused) {
            }
            this.O00000o = true;
        }
    }

    private void O000000o(Activity activity) {
        O000000o(activity, 1, "send cancel!!!");
    }

    private void O00000Oo(Activity activity) {
        O000000o(activity, 0, "send ok!!!");
    }

    public final void O000000o(Activity activity, String str) {
        super.O000000o(activity, str);
        O000000o(activity, 2, str);
    }

    public final void O000000o() {
        super.O000000o();
        O000000o(this.O00000o0);
    }

    public final boolean O00000Oo() {
        O000000o();
        if (this.O00000Oo == null) {
            return true;
        }
        this.O00000Oo.closePage();
        return true;
    }
}
