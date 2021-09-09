package com.mi.global.shop.newmodel.discover;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewShareItem {
    @SerializedName("text")
    public String text;

    public static NewShareItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewShareItem decode(ProtoReader protoReader) throws IOException {
        NewShareItem newShareItem = new NewShareItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newShareItem;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newShareItem.text = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
