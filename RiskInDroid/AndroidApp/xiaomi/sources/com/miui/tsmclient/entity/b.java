package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import java.util.List;

public class b extends CommonResponseInfo {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private List<CouponInfo> f3859a;

    public List<CouponInfo> a() {
        return this.f3859a;
    }
}
