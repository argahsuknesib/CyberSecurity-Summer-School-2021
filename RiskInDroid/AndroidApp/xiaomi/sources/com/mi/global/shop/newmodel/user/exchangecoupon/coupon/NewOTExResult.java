package com.mi.global.shop.newmodel.user.exchangecoupon.coupon;

import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;

public class NewOTExResult extends BaseResult {
    @SerializedName("otex_id")
    public String otex_id;
    @SerializedName("ps")
    public String ps;
    @SerializedName("quote")
    public String quote;
    @SerializedName("quote_id")
    public String quote_id;
}
