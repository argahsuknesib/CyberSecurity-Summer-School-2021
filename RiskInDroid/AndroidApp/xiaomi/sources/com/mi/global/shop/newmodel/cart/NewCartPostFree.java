package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCartPostFree {
    @SerializedName("actName")
    public String actName;
    @SerializedName("activity_name")
    public String activity_name;

    public static NewCartPostFree decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartPostFree decode(ProtoReader protoReader) throws IOException {
        NewCartPostFree newCartPostFree = new NewCartPostFree();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartPostFree;
            } else if (nextTag == 1) {
                newCartPostFree.actName = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCartPostFree.activity_name = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
