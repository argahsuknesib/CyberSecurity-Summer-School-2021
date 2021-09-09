package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewDiscoverPageViewsCountData {
    @SerializedName("cnt")
    public String cnt;
    @SerializedName("is_ok")
    public boolean isOk;

    public static NewDiscoverPageViewsCountData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDiscoverPageViewsCountData decode(ProtoReader protoReader) throws IOException {
        NewDiscoverPageViewsCountData newDiscoverPageViewsCountData = new NewDiscoverPageViewsCountData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newDiscoverPageViewsCountData;
            } else if (nextTag == 1) {
                newDiscoverPageViewsCountData.cnt = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newDiscoverPageViewsCountData.isOk = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
