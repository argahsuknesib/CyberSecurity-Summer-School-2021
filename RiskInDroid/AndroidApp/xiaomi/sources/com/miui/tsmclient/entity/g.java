package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.pay.OrderInfo;

public class g extends CommonResponseInfo {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private OrderInfo f3867a;

    public OrderInfo a() {
        return this.f3867a;
    }
}
