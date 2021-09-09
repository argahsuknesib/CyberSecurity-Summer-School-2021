package com.payu.custombrowser.bean;

import com.payu.custombrowser.PayUCustomBrowserCallback;

public enum CustomBrowserData {
    SINGLETON;
    
    private PayUCustomBrowserCallback payuCustomBrowserCallback;

    public final PayUCustomBrowserCallback getPayuCustomBrowserCallback() {
        return this.payuCustomBrowserCallback;
    }

    public final void setPayuCustomBrowserCallback(PayUCustomBrowserCallback payUCustomBrowserCallback) {
        this.payuCustomBrowserCallback = payUCustomBrowserCallback;
    }
}
