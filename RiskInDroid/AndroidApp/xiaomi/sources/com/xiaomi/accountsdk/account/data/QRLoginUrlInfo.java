package com.xiaomi.accountsdk.account.data;

public class QRLoginUrlInfo {
    public final String loginUrl;
    public final String lp;
    public final String qr;
    public final String serviceId;

    public QRLoginUrlInfo(String str, String str2, String str3, String str4) {
        this.serviceId = str;
        this.lp = str2;
        this.loginUrl = str3;
        this.qr = str4;
    }
}
