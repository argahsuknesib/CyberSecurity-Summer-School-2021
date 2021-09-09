package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import java.util.List;

public class RechargeOrderResponseInfo extends CommonResponseInfo {
    @SerializedName("data")
    private List<RechargeOrderInfo> mRechargeOrderInfoList;

    public List<RechargeOrderInfo> getRechargeOrderInfoList() {
        return this.mRechargeOrderInfoList;
    }
}
