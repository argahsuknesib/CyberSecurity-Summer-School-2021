package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSubmitData {
    @SerializedName("errors")
    public String errors;
    @SerializedName("is_zero_order")
    public boolean is_zero_order;
    @SerializedName("link")
    public String link;
    @SerializedName("order_id")
    public String order_id;

    public static NewSubmitData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSubmitData decode(ProtoReader protoReader) throws IOException {
        NewSubmitData newSubmitData = new NewSubmitData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSubmitData;
            } else if (nextTag == 1) {
                newSubmitData.order_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newSubmitData.is_zero_order = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 3) {
                newSubmitData.link = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSubmitData.errors = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
