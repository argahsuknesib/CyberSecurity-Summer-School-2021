package com.xiaomi.passport.ui.internal;

import _m_j.ehs;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.xiaomi.accountsdk.utils.AccountLog;

public class ScanCodeLoginFragment$2 extends WebChromeClient {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ehs f6257O000000o;

    public ScanCodeLoginFragment$2(ehs ehs) {
        this.f6257O000000o = ehs;
    }

    public void onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
        boolean O000000o2 = ehs.O000000o(webView.getUrl());
        AccountLog.i("ScanCodeLoginFragment", "onCloseWindow ".concat(String.valueOf(O000000o2)));
        this.f6257O000000o.O000000o(O000000o2);
    }
}
