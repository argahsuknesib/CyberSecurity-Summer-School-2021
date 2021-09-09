package com.mi.global.shop.newmodel.pay.cardverify;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCardVerifyResult extends BaseResult {
    @SerializedName("data")
    public NewCardVerifyData data;

    public static NewCardVerifyResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCardVerifyResult decode(ProtoReader protoReader) throws IOException {
        NewCardVerifyResult newCardVerifyResult = new NewCardVerifyResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCardVerifyResult;
            } else if (nextTag == 1) {
                newCardVerifyResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newCardVerifyResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCardVerifyResult.data = NewCardVerifyData.decode(protoReader);
            }
        }
    }
}
