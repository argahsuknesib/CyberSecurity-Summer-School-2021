package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewChangeAddressResult extends BaseResult {
    @SerializedName("data")
    public NewChangeAddressData data;

    public static NewChangeAddressResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewChangeAddressResult decode(ProtoReader protoReader) throws IOException {
        NewChangeAddressResult newChangeAddressResult = new NewChangeAddressResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newChangeAddressResult;
            } else if (nextTag == 1) {
                newChangeAddressResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newChangeAddressResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newChangeAddressResult.data = NewChangeAddressData.decode(protoReader);
            }
        }
    }
}
