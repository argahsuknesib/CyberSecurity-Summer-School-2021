package com.payu.custombrowser;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class PayUWebChromeClient extends WebChromeClient {
    private Bank mBank;
    private boolean mPageDone = false;

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return false;
    }

    public PayUWebChromeClient(Bank bank) {
        this.mBank = bank;
    }

    public void onProgressChanged(WebView webView, int i) {
        Bank bank = this.mBank;
        if (bank != null) {
            if (!this.mPageDone && i < 100) {
                this.mPageDone = true;
                bank.onPageStarted();
            } else if (i == 100) {
                this.mBank.onPageStarted();
                this.mPageDone = false;
                this.mBank.onPageFinished();
            }
            this.mBank.onProgressChanged(i);
        }
    }
}
