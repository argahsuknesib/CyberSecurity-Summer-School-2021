package com.xiaomi.mico.api.model;

public class QqResponse {
    public String auth_code;
    public String encryptString;
    public String msg;
    public int ret;
    public String sdk_qr_code;
    public int sub_ret;
    public String wx_qrcode_image;

    public boolean isSuccess() {
        return this.ret == 0;
    }
}
