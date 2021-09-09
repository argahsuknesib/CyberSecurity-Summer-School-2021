package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.account.exception.HttpException;

public class AccessDeniedException extends HttpException {
    private static final long serialVersionUID = -5989528856775006307L;

    public AccessDeniedException(int i, String str) {
        super(i, str);
    }
}
