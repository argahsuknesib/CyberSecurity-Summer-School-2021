package com.mi.global.shop.newmodel.ordercancel;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewRefundApplyData {
    @SerializedName("order_status_info")
    public String order_status_info;

    public static NewRefundApplyData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewRefundApplyData decode(ProtoReader protoReader) throws IOException {
        NewRefundApplyData newRefundApplyData = new NewRefundApplyData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newRefundApplyData;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newRefundApplyData.order_status_info = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
