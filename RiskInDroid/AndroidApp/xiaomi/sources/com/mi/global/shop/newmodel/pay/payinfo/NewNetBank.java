package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewNetBank {
    @SerializedName("all_json")
    public String all_json;
    @SerializedName("recommend")
    public ArrayList<String> recommend = new ArrayList<>();

    public static NewNetBank decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewNetBank decode(ProtoReader protoReader) throws IOException {
        NewNetBank newNetBank = new NewNetBank();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newNetBank;
            } else if (nextTag == 1) {
                newNetBank.recommend.add(ProtoAdapter.STRING.decode(protoReader));
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newNetBank.all_json = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
