package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCartResult extends BaseResult {
    @SerializedName("data")
    public NewCartData data;

    public static NewCartResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartResult decode(ProtoReader protoReader) throws IOException {
        NewCartResult newCartResult = new NewCartResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartResult;
            } else if (nextTag == 1) {
                newCartResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newCartResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCartResult.data = NewCartData.decode(protoReader);
            }
        }
    }
}
