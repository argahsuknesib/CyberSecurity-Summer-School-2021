package com.mobikwik.sdk;

import android.content.Intent;
import android.os.AsyncTask;
import android.webkit.WebView;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.utils.Network;
import java.util.HashMap;

class c extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5281a;
    final /* synthetic */ String b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ String d;
    final /* synthetic */ WebView e;
    final /* synthetic */ PGWebView f;

    c(PGWebView pGWebView, String str, String str2, HashMap hashMap, String str3, WebView webView) {
        this.f = pGWebView;
        this.f5281a = str;
        this.b = str2;
        this.c = hashMap;
        this.d = str3;
        this.e = webView;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Void... voidArr) {
        return Network.getResponseOfFormPostRequest(this.f5281a, this.b, this.c, 50000, this.d, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (!Network.validateNetworkResponse(this.f.f5275a, str, false)) {
            if (this.f.h != null && this.f.h.isShowing()) {
                this.f.h.dismiss();
            }
            this.f.a((Intent) null, SDKErrorCodes.UNEXPECTED_ERROR.getErrorCode(), SDKErrorCodes.UNEXPECTED_ERROR.getErrorDescription());
        } else if (str.startsWith("http")) {
            this.e.loadUrl(str);
        } else {
            this.e.loadDataWithBaseURL(this.f5281a, str, "text/html", "UTF-8", null);
        }
    }
}
