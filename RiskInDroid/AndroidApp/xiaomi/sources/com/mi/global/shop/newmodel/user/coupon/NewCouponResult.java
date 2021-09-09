package com.mi.global.shop.newmodel.user.coupon;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCouponResult extends BaseResult {
    @SerializedName("data")
    public NewCouponData data;

    public static NewCouponResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCouponResult decode(ProtoReader protoReader) throws IOException {
        NewCouponResult newCouponResult = new NewCouponResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCouponResult;
            } else if (nextTag == 1) {
                newCouponResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newCouponResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCouponResult.data = NewCouponData.decode(protoReader);
            }
        }
    }
}
