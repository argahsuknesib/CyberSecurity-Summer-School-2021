package com.mi.global.shop.newmodel.pay.payparam;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPayGoResult extends BaseResult {
    @SerializedName("data")
    public NewPayGoData data;

    public static NewPayGoResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayGoResult decode(ProtoReader protoReader) throws IOException {
        NewPayGoResult newPayGoResult = new NewPayGoResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPayGoResult;
            } else if (nextTag == 1) {
                newPayGoResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newPayGoResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPayGoResult.data = NewPayGoData.decode(protoReader);
            }
        }
    }
}
