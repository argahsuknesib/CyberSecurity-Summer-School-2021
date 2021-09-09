package com.mi.global.shop.newmodel.ordercancel;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewRefundApplyResult extends BaseResult {
    @SerializedName("data")
    public NewRefundApplyData data;

    public static NewRefundApplyResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewRefundApplyResult decode(ProtoReader protoReader) throws IOException {
        NewRefundApplyResult newRefundApplyResult = new NewRefundApplyResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newRefundApplyResult;
            } else if (nextTag == 1) {
                newRefundApplyResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newRefundApplyResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newRefundApplyResult.data = NewRefundApplyData.decode(protoReader);
            }
        }
    }
}
