package com.mi.global.shop.newmodel.pay.cardverify;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCardVerifyData {
    @SerializedName("isEmiCard")
    public boolean isEmiCard;

    public static NewCardVerifyData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCardVerifyData decode(ProtoReader protoReader) throws IOException {
        NewCardVerifyData newCardVerifyData = new NewCardVerifyData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCardVerifyData;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCardVerifyData.isEmiCard = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
