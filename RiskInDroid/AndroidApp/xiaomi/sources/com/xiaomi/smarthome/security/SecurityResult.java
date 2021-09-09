package com.xiaomi.smarthome.security;

public class SecurityResult {
    public int code;
    public String message;

    public SecurityResult(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public boolean isSuccess() {
        return this.code == 0;
    }

    public String toString() {
        return "SecurityResult{code=" + this.code + ", message='" + this.message + '\'' + '}';
    }
}
