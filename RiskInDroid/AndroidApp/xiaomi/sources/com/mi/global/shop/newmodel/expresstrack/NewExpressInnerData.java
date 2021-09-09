package com.mi.global.shop.newmodel.expresstrack;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewExpressInnerData {
    @SerializedName("express_id")
    public String express_id;
    @SerializedName("express_name")
    public String express_name;
    @SerializedName("express_sn")
    public String express_sn;
    @SerializedName("express_trace")
    public ArrayList<NewExpressTraceItem> express_trace = new ArrayList<>();

    public static NewExpressInnerData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewExpressInnerData decode(ProtoReader protoReader) throws IOException {
        NewExpressInnerData newExpressInnerData = new NewExpressInnerData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newExpressInnerData;
            } else if (nextTag == 1) {
                newExpressInnerData.express_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newExpressInnerData.express_name = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newExpressInnerData.express_sn = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newExpressInnerData.express_trace.add(NewExpressTraceItem.decode(protoReader));
            }
        }
    }
}
