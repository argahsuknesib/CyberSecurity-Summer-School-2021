package com.mi.global.shop.newmodel.home;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewHomeBlockResult extends BaseResult {
    @SerializedName("data")
    public NewHomeBlockData data;

    public static NewHomeBlockResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewHomeBlockResult decode(ProtoReader protoReader) throws IOException {
        NewHomeBlockResult newHomeBlockResult = new NewHomeBlockResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newHomeBlockResult;
            } else if (nextTag == 1) {
                newHomeBlockResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newHomeBlockResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newHomeBlockResult.data = NewHomeBlockData.decode(protoReader);
            }
        }
    }
}
