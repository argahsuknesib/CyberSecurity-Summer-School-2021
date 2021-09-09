package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSaveAddressResult extends BaseResult {
    @SerializedName("data")
    public NewSaveAddressData data;

    public static NewSaveAddressResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSaveAddressResult decode(ProtoReader protoReader) throws IOException {
        NewSaveAddressResult newSaveAddressResult = new NewSaveAddressResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSaveAddressResult;
            } else if (nextTag == 1) {
                newSaveAddressResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newSaveAddressResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSaveAddressResult.data = NewSaveAddressData.decode(protoReader);
            }
        }
    }
}
