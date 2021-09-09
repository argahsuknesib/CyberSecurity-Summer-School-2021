package com.mi.global.shop.webview;

import _m_j.byl;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

public class BaseWebChromeClient extends WebChromeClient {
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (str2 != null) {
            Toast.makeText(byl.O00000oO(), str2, 1).show();
        }
        jsResult.cancel();
        return true;
    }
}
