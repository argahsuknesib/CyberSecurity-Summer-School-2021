package com.mi.global.shop.newmodel.usercenter;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewUserInfoResult extends BaseResult {
    @SerializedName("data")
    public NewUserInfoData data;

    public static NewUserInfoResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewUserInfoResult decode(ProtoReader protoReader) throws IOException {
        NewUserInfoResult newUserInfoResult = new NewUserInfoResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newUserInfoResult;
            } else if (nextTag == 1) {
                newUserInfoResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newUserInfoResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newUserInfoResult.data = NewUserInfoData.decode(protoReader);
            }
        }
    }
}
