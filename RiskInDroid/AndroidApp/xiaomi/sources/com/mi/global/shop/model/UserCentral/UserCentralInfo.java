package com.mi.global.shop.model.UserCentral;

import com.mi.global.shop.model.app.RefreshUserInfoData;
import com.squareup.wire.Wire;

public class UserCentralInfo {
    public int not_pay_order_count;
    public int not_used_coupon_count;
    public int returns_count;
    public int reviews_count;
    public int ship_count;
    public int unread;

    public static UserCentralInfo parseProtobuf(RefreshUserInfoData refreshUserInfoData) {
        if (refreshUserInfoData == null) {
            return null;
        }
        UserCentralInfo userCentralInfo = new UserCentralInfo();
        userCentralInfo.not_pay_order_count = ((Integer) Wire.get(refreshUserInfoData.not_pay_order_count, RefreshUserInfoData.DEFAULT_NOT_PAY_ORDER_COUNT)).intValue();
        userCentralInfo.not_used_coupon_count = ((Integer) Wire.get(refreshUserInfoData.not_used_coupon_count, RefreshUserInfoData.DEFAULT_NOT_USED_COUPON_COUNT)).intValue();
        userCentralInfo.ship_count = ((Integer) Wire.get(refreshUserInfoData.ship_count, RefreshUserInfoData.DEFAULT_SHIP_COUNT)).intValue();
        userCentralInfo.returns_count = ((Integer) Wire.get(refreshUserInfoData.returns_count, RefreshUserInfoData.DEFAULT_RETURNS_COUNT)).intValue();
        userCentralInfo.reviews_count = ((Integer) Wire.get(refreshUserInfoData.not_comment_item_count, RefreshUserInfoData.DEFAULT_NOT_COMMENT_ITEM_COUNT)).intValue();
        userCentralInfo.unread = 1;
        return userCentralInfo;
    }

    public void resetData() {
        this.not_pay_order_count = 0;
        this.not_used_coupon_count = 0;
        this.ship_count = 0;
        this.returns_count = 0;
        this.reviews_count = 0;
        this.unread = 0;
    }
}
