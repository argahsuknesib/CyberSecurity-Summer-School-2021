package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.exception.AccountException;

public class InvalidResponseException extends AccountException {
    private static final long serialVersionUID = 5544530065307643635L;
    public boolean isHtmlOr302;
    private ServerError serverError;

    public InvalidResponseException(String str) {
        this(str, (Throwable) null);
    }

    public InvalidResponseException(int i, String str) {
        super(i, str);
        this.isHtmlOr302 = false;
        this.serverError = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.accountsdk.request.InvalidResponseException.<init>(java.lang.String, java.lang.Throwable, boolean):void
     arg types: [java.lang.String, java.lang.Throwable, int]
     candidates:
      com.xiaomi.accountsdk.request.InvalidResponseException.<init>(int, java.lang.String, com.xiaomi.accountsdk.account.ServerError):void
      com.xiaomi.accountsdk.request.InvalidResponseException.<init>(java.lang.String, java.lang.Throwable, boolean):void */
    public InvalidResponseException(String str, Throwable th) {
        this(str, th, false);
    }

    public InvalidResponseException(String str, Throwable th, boolean z) {
        super(-1, str, th);
        this.isHtmlOr302 = false;
        this.serverError = null;
        this.isHtmlOr302 = z;
    }

    public InvalidResponseException(ServerError serverError2) {
        super(-1, null);
        this.isHtmlOr302 = false;
        this.serverError = null;
        this.serverError = serverError2;
    }

    public InvalidResponseException(int i, String str, ServerError serverError2) {
        super(i, str);
        this.isHtmlOr302 = false;
        this.serverError = null;
        this.serverError = serverError2;
    }

    public InvalidResponseException(String str, ServerError serverError2) {
        this(str);
        this.serverError = serverError2;
    }

    public ServerError getServerError() {
        return this.serverError;
    }
}
