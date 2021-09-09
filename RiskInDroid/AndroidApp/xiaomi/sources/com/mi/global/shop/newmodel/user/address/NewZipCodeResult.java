package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewZipCodeResult extends BaseResult {
    @SerializedName("data")
    public NewZipCodeData data;

    public static NewZipCodeResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewZipCodeResult decode(ProtoReader protoReader) throws IOException {
        NewZipCodeResult newZipCodeResult = new NewZipCodeResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newZipCodeResult;
            } else if (nextTag == 1) {
                newZipCodeResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newZipCodeResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newZipCodeResult.data = NewZipCodeData.decode(protoReader);
            }
        }
    }
}
