package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewOrderViewResult extends BaseResult {
    @SerializedName("data")
    public NewOrderViewData data;

    public static NewOrderViewResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderViewResult decode(ProtoReader protoReader) throws IOException {
        NewOrderViewResult newOrderViewResult = new NewOrderViewResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newOrderViewResult;
            } else if (nextTag == 1) {
                newOrderViewResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newOrderViewResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newOrderViewResult.data = NewOrderViewData.decode(protoReader);
            }
        }
    }
}
