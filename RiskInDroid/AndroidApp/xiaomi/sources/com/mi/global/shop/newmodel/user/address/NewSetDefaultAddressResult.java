package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSetDefaultAddressResult extends BaseResult {
    @SerializedName("data")
    public NewSetDefaultAddressData data;

    public static NewSetDefaultAddressResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSetDefaultAddressResult decode(ProtoReader protoReader) throws IOException {
        NewSetDefaultAddressResult newSetDefaultAddressResult = new NewSetDefaultAddressResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSetDefaultAddressResult;
            } else if (nextTag == 1) {
                newSetDefaultAddressResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newSetDefaultAddressResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSetDefaultAddressResult.data = NewSetDefaultAddressData.decode(protoReader);
            }
        }
    }
}
