package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class SearchConf {
    @SerializedName("switch")
    public boolean switchData;

    public static SearchConf decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SearchConf decode(ProtoReader protoReader) throws IOException {
        SearchConf searchConf = new SearchConf();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return searchConf;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                searchConf.switchData = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
