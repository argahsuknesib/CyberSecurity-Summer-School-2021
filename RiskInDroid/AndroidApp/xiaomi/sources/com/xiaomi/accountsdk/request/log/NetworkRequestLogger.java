package com.xiaomi.accountsdk.request.log;

public class NetworkRequestLogger {
    private volatile LogPrinter mLogPrinter;

    public interface LogPrinter {
        void print(String str, Object... objArr);
    }

    static class InstanceSingleton {
        public static final NetworkRequestLogger sInstance = new NetworkRequestLogger();

        private InstanceSingleton() {
        }
    }

    private NetworkRequestLogger() {
    }

    public static NetworkRequestLogger getInstance() {
        return InstanceSingleton.sInstance;
    }

    public void setLogPrinter(LogPrinter logPrinter) {
        this.mLogPrinter = logPrinter;
    }

    /* access modifiers changed from: protected */
    public void print(String str, Object... objArr) {
        LogPrinter logPrinter = this.mLogPrinter;
        if (logPrinter != null) {
            logPrinter.print(str, objArr);
        }
    }
}
