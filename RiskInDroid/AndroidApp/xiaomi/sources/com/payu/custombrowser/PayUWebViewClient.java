package com.payu.custombrowser;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.payu.magicretry.MagicRetryFragment;
import com.payu.magicretry.WebClient.MagicRetryWebViewClient;

public class PayUWebViewClient extends MagicRetryWebViewClient {
    private Bank bank;
    private boolean loadingFinished = true;
    private String mainUrl = "";
    private boolean redirect = false;

    public PayUWebViewClient(Bank bank2, String str) {
        this.bank = bank2;
        if (Bank.keyAnalytics == null) {
            Bank.keyAnalytics = str;
        }
    }

    public PayUWebViewClient(Bank bank2, MagicRetryFragment magicRetryFragment, String str) {
        super(magicRetryFragment);
        this.bank = bank2;
        if (Bank.keyAnalytics == null) {
            Bank.keyAnalytics = str;
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.loadingFinished = false;
        Bank bank2 = this.bank;
        if (bank2 != null) {
            bank2.onPageStartedWebclient(str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.redirect) {
            this.loadingFinished = true;
        }
        if (str.equals(this.mainUrl)) {
            this.loadingFinished = true;
        }
        this.redirect = false;
        Bank bank2 = this.bank;
        if (bank2 != null) {
            bank2.onPageFinishWebclient(str);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        Bank bank2 = this.bank;
        if (bank2 != null) {
            bank2.onLoadResourse(webView, str);
        }
        super.onLoadResource(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (str2 != null && this.bank != null && Build.VERSION.SDK_INT < 23) {
            this.bank.onReceivedErrorWebClient(i, str);
        }
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        Bank bank2 = this.bank;
        if (bank2 != null) {
            bank2.onReceivedErrorWebClient(webResourceError.getErrorCode(), webResourceError.getDescription().toString());
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (Build.VERSION.SDK_INT <= 10) {
            sslErrorHandler.proceed();
        } else {
            int i = Build.VERSION.SDK_INT;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.mainUrl = str;
        if (!this.loadingFinished) {
            this.redirect = true;
        }
        this.loadingFinished = false;
        Bank bank2 = this.bank;
        if (bank2 != null) {
            bank2.onOverrideURL(str);
        }
        return false;
    }
}
