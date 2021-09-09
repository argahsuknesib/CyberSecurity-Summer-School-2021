package com.mi.global.shop.newmodel.pay.savecard;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCardsBodyResult extends BaseResult {
    @SerializedName("data")
    public NewCardsListData data;

    public static NewCardsBodyResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCardsBodyResult decode(ProtoReader protoReader) throws IOException {
        NewCardsBodyResult newCardsBodyResult = new NewCardsBodyResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCardsBodyResult;
            } else if (nextTag == 1) {
                newCardsBodyResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newCardsBodyResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCardsBodyResult.data = NewCardsListData.decode(protoReader);
            }
        }
    }
}
