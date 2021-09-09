package com.xiaomi.mi_connect.nfc.exception;

public class NfcParseActionRecordException extends Exception {
    public NfcParseActionRecordException(String str) {
        super("Parse Action Record Failed, Exception is ".concat(String.valueOf(str)));
    }
}
