package com.mi.global.shop.newmodel.expresstrack;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewExpressTraceItem {
    @SerializedName("city")
    public String city;
    @SerializedName("time")
    public String time;
    @SerializedName("track")
    public String track;

    public static NewExpressTraceItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewExpressTraceItem decode(ProtoReader protoReader) throws IOException {
        NewExpressTraceItem newExpressTraceItem = new NewExpressTraceItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newExpressTraceItem;
            } else if (nextTag == 1) {
                newExpressTraceItem.time = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newExpressTraceItem.city = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newExpressTraceItem.track = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
