package com.mi.mistatistic.sdk;

import _m_j.cdh;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class MIWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    private WebViewClient f5059O000000o = new WebViewClient();

    public MIWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWebViewClient(this.f5059O000000o);
    }

    public MIWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWebViewClient(this.f5059O000000o);
    }

    public MIWebView(Context context) {
        super(context);
        setWebViewClient(this.f5059O000000o);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new O000000o(webViewClient));
    }

    class O000000o extends WebViewClient {
        private WebViewClient O00000Oo;
        private Map<String, Long> O00000o0 = new HashMap();

        public O000000o(WebViewClient webViewClient) {
            this.O00000Oo = webViewClient;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            Map<String, Long> map = this.O00000o0;
            cdh.O000000o();
            map.put(str, Long.valueOf(cdh.O00000Oo()));
        }

        public final void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
            this.O00000o0.get(str);
        }

        public final void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            this.O00000o0.get(str2);
        }

        public final void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public final void onScaleChanged(WebView webView, float f, float f2) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.O00000Oo;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }
    }
}
