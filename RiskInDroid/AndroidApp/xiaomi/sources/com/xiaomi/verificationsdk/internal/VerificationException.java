package com.xiaomi.verificationsdk.internal;

public class VerificationException extends Exception {
    private final int code;
    private final int dialogTipMsg;

    public VerificationException(int i, String str, int i2) {
        super(str);
        this.code = i;
        this.dialogTipMsg = i2;
    }

    public int getCode() {
        return this.code;
    }

    public int getDialogTipMsg() {
        return this.dialogTipMsg;
    }
}
