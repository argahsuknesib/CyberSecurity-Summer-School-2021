package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewOnlinePayCouponInfoData {
    @SerializedName("mention")
    public String mention;

    public static NewOnlinePayCouponInfoData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOnlinePayCouponInfoData decode(ProtoReader protoReader) throws IOException {
        NewOnlinePayCouponInfoData newOnlinePayCouponInfoData = new NewOnlinePayCouponInfoData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newOnlinePayCouponInfoData;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newOnlinePayCouponInfoData.mention = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
