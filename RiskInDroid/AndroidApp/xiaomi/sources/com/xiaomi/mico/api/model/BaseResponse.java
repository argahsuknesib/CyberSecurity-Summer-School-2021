package com.xiaomi.mico.api.model;

public class BaseResponse {
    public int code;
    public String message;

    public boolean isSuccess() {
        return this.code == 0;
    }
}
