package com.mi.global.shop.newmodel.home;

import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;

public class HomeFlashSaleFollowResult extends BaseResult {
    @SerializedName("data")
    public FlashSaleFollowData data;

    public class FlashSaleFollowData {
        @SerializedName("followed")
        public boolean followed;
        @SerializedName("removed")
        public boolean removed;

        public FlashSaleFollowData() {
        }
    }
}
