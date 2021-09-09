package com.miui.tsmclient.model;

public class BaseResponse {
    public Object[] mDatas;
    public String mMsg;
    public int mResultCode = -1;

    public BaseResponse() {
    }

    public BaseResponse(int i, Object... objArr) {
        this.mResultCode = i;
        this.mDatas = objArr;
    }

    public BaseResponse(int i, String str, Object... objArr) {
        this.mResultCode = i;
        this.mMsg = str;
        this.mDatas = objArr;
    }

    public boolean isSuccess() {
        return this.mResultCode == 0;
    }

    public boolean isNotExist() {
        return this.mResultCode == 2003;
    }
}
