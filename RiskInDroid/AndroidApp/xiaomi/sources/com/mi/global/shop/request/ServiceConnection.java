package com.mi.global.shop.request;

public class ServiceConnection {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4889O000000o = "ServiceConnection";

    public enum NetworkError {
        OK,
        URL_ERROR,
        NETWORK_ERROR,
        CLIENT_ERROR,
        SERVER_ERROR,
        RESULT_ERROR,
        UNKNOWN_ERROR
    }

    public class ConnectionException extends Exception {
        private static final long serialVersionUID = 1;
        protected NetworkError mError;

        public ConnectionException(NetworkError networkError) {
            this.mError = networkError;
        }
    }
}
