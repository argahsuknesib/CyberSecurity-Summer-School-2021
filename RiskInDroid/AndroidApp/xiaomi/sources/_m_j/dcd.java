package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;

public final class dcd extends dce {
    private boolean O00000o = false;
    private Context O00000o0;

    public dcd(dcb dcb, Context context, dci dci) {
        super(dcb, dci);
        this.O00000o0 = context;
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        dbt.O000000o("AuthWebViewClient", "shouldOverrideUrlLoading,request.getUrl()");
        return O000000o(webResourceRequest.getUrl().toString());
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dbt.O000000o("AuthWebViewClient", "shouldOverrideUrlLoading,url");
        return O000000o(str);
    }

    private boolean O000000o(String str) {
        if (str.startsWith("sms:")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("address", str.replace("sms:", ""));
                intent.setType("vnd.android-dir/mms-sms");
                this.O00000o0.startActivity(intent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        } else if (str.startsWith("sinaweibo://browser/close")) {
            if (this.f14466O000000o.f14467O000000o != null && !TextUtils.isEmpty(this.f14466O000000o.f14467O000000o.callback)) {
                String str2 = this.f14466O000000o.f14467O000000o.callback;
                dcc O000000o2 = dcc.O000000o();
                if (O000000o2.O000000o(str2) != null) {
                    O000000o2.O000000o(str2).cancel();
                }
                O000000o2.O00000Oo(str2);
            }
            return true;
        } else if (!O00000Oo(str) || TextUtils.isEmpty(dby.O000000o(str).getString("access_token"))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean O00000Oo(String str) {
        Uri parse = Uri.parse(this.f14466O000000o.f14467O000000o.authInfo.getRedirectUrl());
        Uri parse2 = Uri.parse(str);
        String host = parse.getHost();
        return !TextUtils.isEmpty(host) && host.equals(parse2.getHost());
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        dbt.O000000o("AuthWebViewClient", "onPageStarted:");
        if (this.O00000Oo != null) {
            this.O00000Oo.onPageStartedCallBack(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onPageFinished(WebView webView, String str) {
        dbt.O000000o("AuthWebViewClient", "onPageFinished:");
        super.onPageFinished(webView, str);
        if (this.O00000Oo != null) {
            this.O00000Oo.onPageFinishedCallBack(webView, str);
        }
        if (O00000Oo(str) && !this.O00000o) {
            this.O00000o = true;
            Bundle O000000o2 = dby.O000000o(str);
            String string = O000000o2.getString("error");
            String string2 = O000000o2.getString("error_code");
            String string3 = O000000o2.getString("error_description");
            WbAuthListener wbAuthListener = null;
            if (this.f14466O000000o.f14467O000000o != null && !TextUtils.isEmpty(this.f14466O000000o.f14467O000000o.callback)) {
                String str2 = this.f14466O000000o.f14467O000000o.callback;
                dcc O000000o3 = dcc.O000000o();
                WbAuthListener O000000o4 = O000000o3.O000000o(str2);
                O000000o3.O00000Oo(str2);
                wbAuthListener = O000000o4;
            }
            if (string == null && string2 == null) {
                if (wbAuthListener != null) {
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(O000000o2);
                    AccessTokenKeeper.writeAccessToken(this.O00000o0, parseAccessToken);
                    wbAuthListener.onSuccess(parseAccessToken);
                }
            } else if (wbAuthListener != null) {
                wbAuthListener.onFailure(new WbConnectErrorMessage(string2, string3));
            }
            webView.stopLoading();
            if (this.O00000Oo != null) {
                this.O00000Oo.closePage();
            }
        }
    }

    @TargetApi(24)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        dbt.O000000o("AuthWebViewClient", "onReceivedError");
        if (this.O00000Oo != null) {
            this.O00000Oo.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        dbt.O000000o("AuthWebViewClient", "onReceivedError");
        if (this.O00000Oo != null) {
            this.O00000Oo.onReceivedErrorCallBack(webView, i, str, str2);
        }
    }

    public final void O000000o() {
        super.O000000o();
        if (this.f14466O000000o.f14467O000000o != null && !TextUtils.isEmpty(this.f14466O000000o.f14467O000000o.callback)) {
            String str = this.f14466O000000o.f14467O000000o.callback;
            dcc O000000o2 = dcc.O000000o();
            if (O000000o2.O000000o(str) != null) {
                O000000o2.O000000o(str).cancel();
            }
            O000000o2.O00000Oo(str);
        }
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
