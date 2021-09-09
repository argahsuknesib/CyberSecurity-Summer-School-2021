package com.mi.global.shop.newmodel.orderlist;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewExtData {
    @SerializedName("send")
    public int send;
    @SerializedName("unpaid")
    public int unpaid;

    public static NewExtData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewExtData decode(ProtoReader protoReader) throws IOException {
        NewExtData newExtData = new NewExtData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newExtData;
            } else if (nextTag == 1) {
                newExtData.unpaid = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newExtData.send = ProtoAdapter.INT32.decode(protoReader).intValue();
            }
        }
    }
}
