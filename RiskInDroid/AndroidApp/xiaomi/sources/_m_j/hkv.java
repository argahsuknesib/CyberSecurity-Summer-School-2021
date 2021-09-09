package _m_j;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public interface hkv {
    void onDestroy();

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedError(WebView webView, int i, String str, String str2);

    void onReceivedLoginRequest(WebView webView, String str, String str2, String str3);

    void onResume();

    boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
