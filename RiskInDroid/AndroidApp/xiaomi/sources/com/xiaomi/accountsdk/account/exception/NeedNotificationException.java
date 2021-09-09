package com.xiaomi.accountsdk.account.exception;

import com.xiaomi.accountsdk.request.SimpleRequest;

public class NeedNotificationException extends Exception {
    private static final long serialVersionUID = 1;
    private final SimpleRequest.StringContent loginContent;
    private final String notificationUrl;
    private final String userId;

    public NeedNotificationException(String str, String str2) {
        this(str, str2, null);
    }

    public NeedNotificationException(String str, String str2, SimpleRequest.StringContent stringContent) {
        this.userId = str;
        this.notificationUrl = str2;
        this.loginContent = stringContent;
    }

    public String getNotificationUrl() {
        return this.notificationUrl;
    }

    public String getUserId() {
        return this.userId;
    }

    public SimpleRequest.StringContent getLoginContent() {
        return this.loginContent;
    }
}
