package com.mobikwik.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.exoplayer2.C;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.utils.Utils;

class e extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebView f5283a;
    final /* synthetic */ PGWebView b;

    e(PGWebView pGWebView, WebView webView) {
        this.b = pGWebView;
        this.f5283a = webView;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(this.f5283a, str);
        Utils.print(" onPageFinished ".concat(String.valueOf(str)));
        f fVar = new f(this, webView, str);
        if (this.b.i) {
            fVar.run();
        } else {
            Runnable unused = this.b.j = fVar;
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(this.f5283a, str, bitmap);
        Utils.print("onPageStarted ".concat(String.valueOf(str)));
        if (this.b.i) {
            this.b.h.show();
            this.b.setProgressBarIndeterminateVisibility(true);
            return;
        }
        Log.i("Payment Gateway", "activity not running");
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Log.e("ZAAKPAY", "Error " + i + ": " + str + " \n" + str2);
        String errorCode = SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode();
        String errorDescription = SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription();
        if (i == -8) {
            errorCode = SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode();
            errorDescription = "Connection timed out";
        } else if (i == -6 || i == -2) {
            errorCode = SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode();
            errorDescription = SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription();
        }
        this.b.a((Intent) null, errorCode, errorDescription);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        String sslError2 = sslError.toString();
        if (Build.VERSION.SDK_INT >= 14) {
            str = sslError.getUrl();
            Log.e("ZAAKPAY", "SSL Error URL:".concat(String.valueOf(str)));
        } else {
            str = null;
        }
        Log.e("ZAAKPAY", sslError2);
        if (str != null && (str.startsWith("https://soc.indusguard.com/img/") || str.startsWith("https://forms.deutschebank.co.in/") || str.startsWith("https://monstat.com/idbi.png"))) {
            Log.d("ZAAKPAY", "SSL Error ignored on URL ".concat(String.valueOf(str)));
            sslErrorHandler.proceed();
        } else if (Build.VERSION.SDK_INT > 7) {
            sslErrorHandler.cancel();
            this.b.a((Intent) null, SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
        }
    }
}
