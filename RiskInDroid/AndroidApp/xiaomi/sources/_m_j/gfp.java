package _m_j;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class gfp extends WebViewClient {

    /* renamed from: O000000o  reason: collision with root package name */
    private WebViewClient f17660O000000o;
    private final hla O00000Oo = new hla();

    public gfp(WebViewClient webViewClient) {
        this.f17660O000000o = webViewClient;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f17660O000000o.onReceivedError(webView, i, str, str2);
        this.O00000Oo.onReceivedError(webView, i, str, str2);
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f17660O000000o.onPageFinished(webView, str);
        this.O00000Oo.onPageFinished(webView, str);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.O00000Oo.shouldOverrideUrlLoading(webView, str) || this.f17660O000000o.shouldOverrideUrlLoading(webView, str) || super.shouldOverrideUrlLoading(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f17660O000000o.onPageStarted(webView, str, bitmap);
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onLoadResource(WebView webView, String str) {
        this.f17660O000000o.onLoadResource(webView, str);
        super.onLoadResource(webView, str);
    }

    public final void onPageCommitVisible(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f17660O000000o.onPageCommitVisible(webView, str);
        }
        super.onPageCommitVisible(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse shouldInterceptRequest;
        if (Build.VERSION.SDK_INT < 21 || (shouldInterceptRequest = this.f17660O000000o.shouldInterceptRequest(webView, webResourceRequest)) == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return shouldInterceptRequest;
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.f17660O000000o.shouldOverrideKeyEvent(webView, keyEvent) && super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.f17660O000000o.onUnhandledKeyEvent(webView, keyEvent);
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        this.f17660O000000o.onScaleChanged(webView, f, f2);
        super.onScaleChanged(webView, f, f2);
    }

    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        this.f17660O000000o.onReceivedLoginRequest(webView, str, str2, str3);
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.f17660O000000o.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }
}
