package com.paytm.pgsdk;

import _m_j.cqp;
import _m_j.cqq;
import _m_j.cqs;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Iterator;
import org.json.JSONObject;

@TargetApi(21)
public final class PaytmWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    public final PaytmPGActivity f5407O000000o;
    public volatile boolean O00000Oo;

    public PaytmWebView(Context context) {
        super(context);
        this.f5407O000000o = (PaytmPGActivity) context;
        setWebViewClient(new O00000Oo(this, (byte) 0));
        setWebChromeClient(new WebChromeClient() {
            /* class com.paytm.pgsdk.PaytmWebView.AnonymousClass1 */

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                cqs.O000000o("JavaScript Alert ".concat(String.valueOf(str)));
                return super.onJsAlert(webView, str, str2, jsResult);
            }
        });
        getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        addJavascriptInterface(new O000000o(this, (byte) 0), "HTMLOUT");
    }

    class O00000Oo extends WebViewClient {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(PaytmWebView paytmWebView, byte b) {
            this();
        }

        public final synchronized void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            cqs.O000000o("Page started loading ".concat(String.valueOf(str)));
            PaytmWebView.this.O000000o();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
            return;
         */
        public final synchronized void onPageFinished(WebView webView, String str) {
            try {
                super.onPageFinished(webView, str);
                cqs.O000000o("Page finished loading ".concat(String.valueOf(str)));
                PaytmWebView.this.O00000Oo();
                if (str.equalsIgnoreCase(cqp.O000000o().f14256O000000o.f14255O000000o.get("CALLBACK_URL").toString())) {
                    cqs.O000000o("Merchant specific Callback Url is finished loading. Extract data now. ");
                    PaytmWebView.this.O00000Oo = true;
                    PaytmWebView.this.loadUrl("javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);");
                } else if (str.endsWith("/CAS/Response")) {
                    cqs.O000000o("CAS Callback Url is finished loading. Extract data now. ");
                    PaytmWebView.this.loadUrl("javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);");
                }
            } catch (Exception e) {
                cqs.O000000o(e);
            }
        }

        public final synchronized void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            cqs.O000000o("Error occured while loading url ".concat(String.valueOf(str2)));
            cqs.O000000o("Error code is " + i + "Description is " + str);
            if (i == -6) {
                ((Activity) PaytmWebView.this.getContext()).finish();
                cqq cqq = cqp.O000000o().O00000oO;
                if (cqq != null) {
                    cqq.O00000o0(str);
                }
            }
        }

        public final synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            cqs.O000000o("SSL Error occured " + sslError.toString());
            cqs.O000000o("SSL Handler is ".concat(String.valueOf(sslErrorHandler)));
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    public final synchronized void O000000o() {
        try {
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                /* class com.paytm.pgsdk.PaytmWebView.AnonymousClass2 */

                public final void run() {
                    PaytmWebView.this.f5407O000000o.f5402O000000o.setVisibility(0);
                    cqs.O000000o("Progress dialog started");
                }
            });
        } catch (Exception e) {
            cqs.O000000o(e);
        }
    }

    public final synchronized void O00000Oo() {
        try {
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                /* class com.paytm.pgsdk.PaytmWebView.AnonymousClass3 */

                public final void run() {
                    PaytmWebView.this.f5407O000000o.f5402O000000o.setVisibility(8);
                    cqs.O000000o("Progress dialog ended");
                }
            });
        } catch (Exception e) {
            cqs.O000000o(e);
        }
    }

    class O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(PaytmWebView paytmWebView, byte b) {
            this();
        }

        @JavascriptInterface
        public final synchronized void processResponse(String str) {
            try {
                cqs.O000000o("Merchant Response is ".concat(String.valueOf(str)));
                O000000o(PaytmWebView.this.O000000o(str));
            } catch (Exception e) {
                cqs.O000000o(e);
            }
        }

        private synchronized void O000000o(final Bundle bundle) {
            try {
                ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new Runnable() {
                    /* class com.paytm.pgsdk.PaytmWebView.O000000o.AnonymousClass1 */

                    public final void run() {
                        try {
                            ((Activity) PaytmWebView.this.getContext()).finish();
                            cqp.O000000o().O00000oO.O000000o(bundle);
                        } catch (Exception e) {
                            cqs.O000000o(e);
                        }
                    }
                });
            } catch (Exception e) {
                cqs.O000000o(e);
            }
        }
    }

    public final synchronized Bundle O000000o(String str) {
        Bundle bundle;
        cqs.O000000o("Parsing the Merchant Response");
        bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    cqs.O000000o(next + " = " + string);
                    bundle.putString(next, string);
                }
            }
        } catch (Exception e) {
            cqs.O000000o("Error while parsing the Merchant Response");
            cqs.O000000o(e);
        }
        return bundle;
    }
}
