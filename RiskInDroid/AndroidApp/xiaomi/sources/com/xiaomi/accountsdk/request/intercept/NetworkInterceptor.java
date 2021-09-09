package com.xiaomi.accountsdk.request.intercept;

public class NetworkInterceptor {

    static class Holder {
        public static volatile NetworkInterceptCallback sInstance = new EmptyNetworkInterceptCallback();

        private Holder() {
        }
    }

    public static void set(NetworkInterceptCallback networkInterceptCallback) {
        Holder.sInstance = networkInterceptCallback;
    }

    public static NetworkInterceptCallback get() {
        return Holder.sInstance;
    }
}
