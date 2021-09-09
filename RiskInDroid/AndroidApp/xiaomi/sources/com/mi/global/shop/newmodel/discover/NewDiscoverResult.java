package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewDiscoverResult extends BaseResult {
    @SerializedName("data")
    public NewDiscoverData data;

    public static NewDiscoverResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDiscoverResult decode(ProtoReader protoReader) throws IOException {
        NewDiscoverResult newDiscoverResult = new NewDiscoverResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newDiscoverResult;
            } else if (nextTag == 1) {
                newDiscoverResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newDiscoverResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newDiscoverResult.data = NewDiscoverData.decode(protoReader);
            }
        }
    }
}
