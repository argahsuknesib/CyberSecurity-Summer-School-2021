package com.xiaomi.accountsdk.request.log;

public class HttpMethod {
    public static final HttpMethod GET = new HttpMethod("GET");
    public static final HttpMethod POST = new HttpMethod("POST");
    private final String name;

    private HttpMethod(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
