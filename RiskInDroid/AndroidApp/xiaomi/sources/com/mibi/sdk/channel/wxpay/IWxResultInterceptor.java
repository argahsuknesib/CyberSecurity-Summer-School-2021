package com.mibi.sdk.channel.wxpay;

import com.tencent.mm.opensdk.modelbase.BaseResp;

public interface IWxResultInterceptor {
    boolean intercept(BaseResp baseResp);
}
