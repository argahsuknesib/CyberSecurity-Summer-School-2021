package com.xiaomi.mico.api;

public class ApiError {
    public static final ApiError APP_SDCARD_BUSY = generateError(500, "sdcard busy");
    public static final ApiError HTTP_CODE_4XX = generateError(10005, "Bad Request");
    public static final ApiError HTTP_CODE_5XX = generateError(10006, "Internal Server Error");
    public static final ApiError HTTP_CODE_OTHER = generateError(10007, "Other Http Error Code");
    public static final ApiError HTTP_ENGINE_EXCEPTION = generateError(10003, "Http Engine Exception");
    public static final ApiError HTTP_TIMEOUT = generateError(10004, "Http Timeout");
    public static final ApiError TOKEN_INSUFFICIENT = generateError(10001, "Token Insufficiency");
    public static final ApiError TOKEN_INVALID = generateError(10002, "Token Insufficiency");
    private int mCode;
    private String mMessage;

    public static ApiError generateError(int i, String str) {
        return new ApiError(i, str);
    }

    private ApiError(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof ApiError) && ((ApiError) obj).mCode == this.mCode;
        }
        return true;
    }

    public String toString() {
        return "ApiError: code=" + this.mCode + ", message=" + this.mMessage;
    }

    public ApiErrorException toThrowable() {
        return new ApiErrorException(this);
    }

    public class ApiErrorException extends Throwable {
        private static final long serialVersionUID = 2776063826285560392L;
        private final ApiError apiError;

        ApiErrorException(ApiError apiError2) {
            this.apiError = apiError2;
        }

        public ApiError getApiError() {
            return this.apiError;
        }

        public int getCode() {
            return this.apiError.getCode();
        }

        public String getMessage() {
            return this.apiError.getMessage();
        }
    }
}
