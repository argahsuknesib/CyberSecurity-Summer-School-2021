package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewUpData {
    @SerializedName("num")
    public long num;
    @SerializedName("res")
    public boolean res;

    public static NewUpData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewUpData decode(ProtoReader protoReader) throws IOException {
        NewUpData newUpData = new NewUpData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newUpData;
            } else if (nextTag == 1) {
                newUpData.res = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newUpData.num = ProtoAdapter.INT64.decode(protoReader).longValue();
            }
        }
    }
}
