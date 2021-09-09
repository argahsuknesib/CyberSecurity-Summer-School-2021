package com.payu.magicretry.WebClient;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.payu.magicretry.MagicRetryFragment;

public class MerchantsWebViewClient extends MagicRetryWebViewClient {
    public MerchantsWebViewClient(MagicRetryFragment magicRetryFragment) {
        super(magicRetryFragment);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
