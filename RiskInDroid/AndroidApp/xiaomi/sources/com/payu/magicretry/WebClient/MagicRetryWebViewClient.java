package com.payu.magicretry.WebClient;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.payu.magicretry.Helpers.L;
import com.payu.magicretry.MagicRetryFragment;

public class MagicRetryWebViewClient extends WebViewClient {
    private MagicRetryFragment magicRetryFragment;

    public MagicRetryWebViewClient() {
    }

    public MagicRetryWebViewClient(MagicRetryFragment magicRetryFragment2) {
        this.magicRetryFragment = magicRetryFragment2;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        L.v("#### PAYU", "MagicRetryWebViewClient.java: onPageStarted: URL ".concat(String.valueOf(str)));
        super.onPageStarted(webView, str, bitmap);
        MagicRetryFragment magicRetryFragment2 = this.magicRetryFragment;
        if (magicRetryFragment2 != null) {
            magicRetryFragment2.onPageStarted(webView, str);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        L.v("#### PAYU", "MagicRetryWebViewClient.java: shouldOverrideUrlLoading: URL ".concat(String.valueOf(str)));
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        L.v("#### PAYU", "MagicRetryWebViewClient.java: onPageFinished: URL ".concat(String.valueOf(str)));
        super.onPageFinished(webView, str);
        MagicRetryFragment magicRetryFragment2 = this.magicRetryFragment;
        if (magicRetryFragment2 != null) {
            magicRetryFragment2.onPageFinished(webView, str);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message2.sendToTarget();
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        L.v("#### PAYU", "MagicRetryWebViewClient.java: onReceivedError: URL " + webView.getUrl());
        if (this.magicRetryFragment != null && webResourceRequest.isForMainFrame()) {
            this.magicRetryFragment.onReceivedError(webView, webResourceRequest.getUrl().toString());
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        L.v("#### PAYU", "MagicRetryWebViewClient.java: onReceivedError: URL " + webView.getUrl());
        MagicRetryFragment magicRetryFragment2 = this.magicRetryFragment;
        if (magicRetryFragment2 != null) {
            magicRetryFragment2.onReceivedError(webView, str2);
        }
    }
}
