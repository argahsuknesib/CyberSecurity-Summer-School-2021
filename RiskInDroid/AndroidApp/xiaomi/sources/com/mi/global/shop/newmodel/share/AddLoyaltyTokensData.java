package com.mi.global.shop.newmodel.share;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class AddLoyaltyTokensData {
    @SerializedName("miTokens")
    public long miTokens;
    @SerializedName("msg")
    public String msg;

    public static AddLoyaltyTokensData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static AddLoyaltyTokensData decode(ProtoReader protoReader) throws IOException {
        AddLoyaltyTokensData addLoyaltyTokensData = new AddLoyaltyTokensData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return addLoyaltyTokensData;
            } else if (nextTag == 1) {
                addLoyaltyTokensData.miTokens = ProtoAdapter.INT64.decode(protoReader).longValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                addLoyaltyTokensData.msg = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
