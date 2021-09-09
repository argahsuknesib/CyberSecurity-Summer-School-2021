package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;

public class j extends CommonResponseInfo {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private TransferOutOrderInfo f3872a;

    public TransferOutOrderInfo a() {
        return this.f3872a;
    }
}
