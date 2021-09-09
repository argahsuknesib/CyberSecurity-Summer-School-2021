package _m_j;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public final class dcf extends dce {
    public dcf(dcb dcb, dci dci) {
        super(dcb, dci);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.O00000Oo != null) {
            this.O00000Oo.onPageStartedCallBack(webView, str, bitmap);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.O00000Oo != null) {
            this.O00000Oo.onPageFinishedCallBack(webView, str);
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.O00000Oo != null) {
            this.O00000Oo.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.O00000Oo != null) {
            this.O00000Oo.onReceivedErrorCallBack(webView, i, str, str2);
        }
    }
}
