package _m_j;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

public interface iia {
    void onPageFinishedCallBack(WebView webView, String str);

    void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap);

    void onReceivedErrorCallBack(WebView webView, int i, String str, String str2);

    void onReceivedSslErrorCallBack(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str);
}
