package com.xiaomi.accountsdk.utils;

public class NonceCoder {
    public static String generateNonce() {
        return generateNonce(SyncServerTimeExecutor.getInstance().getCurrentServerTimeMillis());
    }

    public static String generateNonce(long j) {
        return Coder.generateNonce(j);
    }
}
