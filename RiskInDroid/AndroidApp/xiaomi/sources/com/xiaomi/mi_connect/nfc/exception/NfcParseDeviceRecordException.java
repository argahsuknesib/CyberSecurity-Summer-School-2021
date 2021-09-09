package com.xiaomi.mi_connect.nfc.exception;

public class NfcParseDeviceRecordException extends Exception {
    public NfcParseDeviceRecordException(String str) {
        super("Parse Device Record Failed, Exception is ".concat(String.valueOf(str)));
    }
}
