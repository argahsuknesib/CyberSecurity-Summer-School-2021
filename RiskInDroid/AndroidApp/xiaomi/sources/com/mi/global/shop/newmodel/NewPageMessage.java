package com.mi.global.shop.newmodel;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPageMessage {
    @SerializedName("icon")
    public String icon;
    @SerializedName("pagemsg")
    public String pagemsg;

    public static NewPageMessage decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPageMessage decode(ProtoReader protoReader) throws IOException {
        NewPageMessage newPageMessage = new NewPageMessage();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPageMessage;
            } else if (nextTag == 1) {
                newPageMessage.pagemsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPageMessage.icon = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
