package com.mi.global.shop.newmodel.user.exchangecoupon.coupon;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewExchangeCouponData {
    @SerializedName("exchange_coupon_list")
    public ArrayList<NewExchangeCouponItem> exchange_coupon_list = new ArrayList<>();

    public static NewExchangeCouponData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewExchangeCouponData decode(ProtoReader protoReader) throws IOException {
        NewExchangeCouponData newExchangeCouponData = new NewExchangeCouponData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newExchangeCouponData;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newExchangeCouponData.exchange_coupon_list.add(NewExchangeCouponItem.decode(protoReader));
            }
        }
    }
}
