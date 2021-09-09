package com.xiaomi.accountsdk.account.exception;

public class AccountException extends Exception {
    public final int code;
    public final String codeDesc;
    public boolean isStsUrlRequestError;
    public String serviceId;

    public AccountException(int i, String str) {
        this(i, str, null);
    }

    public AccountException(int i, String str, Throwable th) {
        super(th);
        this.isStsUrlRequestError = false;
        this.code = i;
        this.codeDesc = str;
    }

    public void stsUrlRequestError(String str) {
        this.serviceId = str;
        this.isStsUrlRequestError = true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("server code: ");
        sb.append(this.code);
        sb.append("; desc: ");
        sb.append(this.codeDesc);
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
