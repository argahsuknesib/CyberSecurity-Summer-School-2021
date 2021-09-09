package com.mi.global.shop.newmodel.expresstrack;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewExpressInfoData {
    @SerializedName("expressInfo")
    public NewExpressInnerData expressInfo;

    public static NewExpressInfoData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewExpressInfoData decode(ProtoReader protoReader) throws IOException {
        NewExpressInfoData newExpressInfoData = new NewExpressInfoData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newExpressInfoData;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newExpressInfoData.expressInfo = NewExpressInnerData.decode(protoReader);
            }
        }
    }
}
