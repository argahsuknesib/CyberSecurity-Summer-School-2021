package _m_j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public abstract class dce extends WebViewClient {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dci f14466O000000o;
    protected dcb O00000Oo;

    public void O000000o() {
    }

    public void O000000o(Activity activity, String str) {
    }

    public boolean O00000Oo() {
        return false;
    }

    public dce(dcb dcb, dci dci) {
        this.O00000Oo = dcb;
        this.f14466O000000o = dci;
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        dcb dcb = this.O00000Oo;
        if (dcb != null) {
            dcb.shouldOverrideUrlLoadingCallBack(webView, webResourceRequest.getUrl().toString());
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dcb dcb = this.O00000Oo;
        if (dcb != null) {
            dcb.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        dcb dcb = this.O00000Oo;
        if (dcb != null) {
            dcb.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
}
