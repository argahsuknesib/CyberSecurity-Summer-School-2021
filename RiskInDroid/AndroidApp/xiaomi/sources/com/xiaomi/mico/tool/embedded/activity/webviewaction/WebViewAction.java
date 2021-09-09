package com.xiaomi.mico.tool.embedded.activity.webviewaction;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;

public interface WebViewAction {
    void call(Context context, WebView webView, Uri uri);

    void clear();

    String getSchema();
}
