package com.xiaomi.accountsdk.account.exception;

public class HttpException extends Exception {
    public boolean isStsUrlRequestError = false;
    public final int responseCode;
    public String serviceId;

    public HttpException(int i, String str) {
        super(str);
        this.responseCode = i;
    }

    public void stsUrlRequestError(String str) {
        this.serviceId = str;
        this.isStsUrlRequestError = true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("response code: ");
        sb.append(this.responseCode);
        sb.append("\n");
        if (this.isStsUrlRequestError) {
            str = this.serviceId + " sts url request error \n";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString() + super.toString();
    }
}
