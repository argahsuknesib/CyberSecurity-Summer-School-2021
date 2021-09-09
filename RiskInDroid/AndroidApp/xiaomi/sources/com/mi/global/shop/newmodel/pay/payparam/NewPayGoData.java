package com.mi.global.shop.newmodel.pay.payparam;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPayGoData {
    @SerializedName("ext")
    public String ext;
    @SerializedName("html")
    public String html;
    @SerializedName("params")
    public String params;

    public static NewPayGoData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayGoData decode(ProtoReader protoReader) throws IOException {
        NewPayGoData newPayGoData = new NewPayGoData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPayGoData;
            } else if (nextTag == 1) {
                newPayGoData.html = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newPayGoData.params = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPayGoData.ext = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
