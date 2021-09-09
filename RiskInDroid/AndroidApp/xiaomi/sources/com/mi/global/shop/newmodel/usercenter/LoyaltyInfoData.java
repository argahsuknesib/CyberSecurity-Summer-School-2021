package com.mi.global.shop.newmodel.usercenter;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class LoyaltyInfoData {
    @SerializedName("desc")
    public String desc;
    @SerializedName("micon")
    public String micon;
    @SerializedName("pcicon")
    public String pcicon;
    @SerializedName("score")
    public int score;

    public static LoyaltyInfoData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static LoyaltyInfoData decode(ProtoReader protoReader) throws IOException {
        LoyaltyInfoData loyaltyInfoData = new LoyaltyInfoData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return loyaltyInfoData;
            } else if (nextTag == 1) {
                loyaltyInfoData.score = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                loyaltyInfoData.desc = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                loyaltyInfoData.micon = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                loyaltyInfoData.pcicon = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
