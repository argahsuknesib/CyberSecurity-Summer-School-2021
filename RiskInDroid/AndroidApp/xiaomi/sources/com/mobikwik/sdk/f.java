package com.mobikwik.sdk;

import android.content.Intent;
import android.webkit.WebView;
import android.widget.TextView;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import java.net.URL;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebView f5284a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;
    private String d = this.f5284a.getTitle();
    private String e = this.b;

    f(e eVar, WebView webView, String str) {
        this.c = eVar;
        this.f5284a = webView;
        this.b = str;
    }

    public void run() {
        try {
            if (this.c.b.h != null && this.c.b.h.isShowing()) {
                this.c.b.h.dismiss();
            }
            this.c.b.setProgressBarIndeterminateVisibility(false);
            if (this.d != null) {
                this.c.b.f5275a.setTitle(this.d);
            }
            URL url = new URL(this.e);
            String host = url.getHost();
            String path = url.getPath();
            if (this.c.b.g) {
                if ((host.contains("mobikwik") || host.contains("test.mobikwik.com")) && path.contains("mobilePaymentResponse.do")) {
                    this.c.b.setContentView(new TextView(this.c.b));
                    try {
                        this.c.f5283a.loadUrl("javascript:window.ResponseViewer.checkStatusForMK(document.getElementsByTagName('status')[0].textContent);");
                        this.c.f5283a.loadUrl("javascript:window.ResponseViewer.showResponse(document.getElementsByTagName('amount')[0].textContent);");
                        this.c.f5283a.loadUrl("javascript:window.ResponseViewer.showResponse(document.getElementsByTagName('errorMsg')[0].textContent);");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        UIFunctions.showToastLong(this.c.b.getApplicationContext(), "Something went bad. Please try again later.");
                    }
                    Runnable unused = this.c.b.j = (Runnable) null;
                }
            }
            if (!this.c.b.g) {
                URL url2 = new URL(this.c.b.f);
                if (host.contains(url2.getHost()) && path.contains(url2.getPath())) {
                    this.c.b.setContentView(new TextView(this.c.b));
                    try {
                        this.c.f5283a.loadUrl("javascript:window.ResponseViewer.checkStatusForMerchant(document.getElementsByTagName('status')[0].textContent,document.getElementsByTagName('amount')[0].textContent,document.getElementsByTagName('orderid')[0].textContent,document.getElementsByTagName('statusMsg')[0].textContent);");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        UIFunctions.showToastLong(this.c.b.getApplicationContext(), "Something went bad. Please try again later.");
                        this.c.b.a((Intent) null, SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            this.c.b.a((Intent) null, SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
        }
        Runnable unused2 = this.c.b.j = (Runnable) null;
    }
}
