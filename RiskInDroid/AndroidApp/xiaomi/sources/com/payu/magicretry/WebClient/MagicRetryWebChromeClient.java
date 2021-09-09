package com.payu.magicretry.WebClient;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MagicRetryWebChromeClient extends WebChromeClient {
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }
}
