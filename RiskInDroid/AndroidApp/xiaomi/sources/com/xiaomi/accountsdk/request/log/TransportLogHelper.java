package com.xiaomi.accountsdk.request.log;

public class TransportLogHelper {
    private static final String HELPER_CLASS_NAME = "com.xiaomi.accountsdk.request.log.TransportLogHelper";

    public static void logRequestStarted() {
        NetworkRequestLogger.getInstance().print(HELPER_CLASS_NAME, "Request started. ");
    }

    public static void logRequestSuccessed() {
        NetworkRequestLogger.getInstance().print(HELPER_CLASS_NAME, "Request successed. ");
    }

    public static void logRequestException(Throwable th) {
        NetworkRequestLogger.getInstance().print(HELPER_CLASS_NAME, "Request exception. ", th);
    }
}
