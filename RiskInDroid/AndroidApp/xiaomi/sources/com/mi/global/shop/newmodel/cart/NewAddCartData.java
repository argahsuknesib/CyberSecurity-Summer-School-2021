package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewAddCartData {
    @SerializedName("cartdata")
    public NewEditCartData cartdata;
    @SerializedName("res")
    public boolean res;

    public static NewAddCartData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewAddCartData decode(ProtoReader protoReader) throws IOException {
        NewAddCartData newAddCartData = new NewAddCartData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newAddCartData;
            } else if (nextTag == 1) {
                newAddCartData.res = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newAddCartData.cartdata = NewEditCartData.decode(protoReader);
            }
        }
    }
}
