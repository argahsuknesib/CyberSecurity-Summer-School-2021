package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import java.util.List;

public class d extends CommonResponseInfo {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private List<DoorCardProduct> f3862a;

    public List<DoorCardProduct> a() {
        return this.f3862a;
    }
}
