package com.mi.global.shop.newmodel.orderlist;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewOrderListResult extends BaseResult {
    @SerializedName("data")
    public NewOrderListData data;

    public static NewOrderListResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderListResult decode(ProtoReader protoReader) throws IOException {
        NewOrderListResult newOrderListResult = new NewOrderListResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newOrderListResult;
            } else if (nextTag == 1) {
                newOrderListResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newOrderListResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newOrderListResult.data = NewOrderListData.decode(protoReader);
            }
        }
    }
}
