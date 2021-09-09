package com.mi.global.shop.newmodel.share;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class AddLoyaltyTokensResult extends BaseResult {
    @SerializedName("data")
    public AddLoyaltyTokensData data;

    public static AddLoyaltyTokensResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static AddLoyaltyTokensResult decode(ProtoReader protoReader) throws IOException {
        AddLoyaltyTokensResult addLoyaltyTokensResult = new AddLoyaltyTokensResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return addLoyaltyTokensResult;
            } else if (nextTag == 1) {
                addLoyaltyTokensResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                addLoyaltyTokensResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                addLoyaltyTokensResult.data = AddLoyaltyTokensData.decode(protoReader);
            }
        }
    }
}
