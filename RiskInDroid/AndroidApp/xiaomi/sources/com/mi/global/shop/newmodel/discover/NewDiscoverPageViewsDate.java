package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewDiscoverPageViewsDate extends BaseResult {
    @SerializedName("common")
    public Object common;
    @SerializedName("data")
    public NewDiscoverPageViewsCountData data;
    @SerializedName("security")
    public boolean security;

    public static NewDiscoverPageViewsDate decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDiscoverPageViewsDate decode(ProtoReader protoReader) throws IOException {
        NewDiscoverPageViewsDate newDiscoverPageViewsDate = new NewDiscoverPageViewsDate();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newDiscoverPageViewsDate;
            } else if (nextTag == 1) {
                newDiscoverPageViewsDate.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newDiscoverPageViewsDate.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newDiscoverPageViewsDate.data = NewDiscoverPageViewsCountData.decode(protoReader);
            }
        }
    }
}
