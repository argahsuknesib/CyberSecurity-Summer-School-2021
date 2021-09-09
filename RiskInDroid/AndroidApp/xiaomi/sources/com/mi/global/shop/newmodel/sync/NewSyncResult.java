package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSyncResult extends BaseResult {
    @SerializedName("data")
    public NewSyncData data;

    public static NewSyncResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSyncResult decode(ProtoReader protoReader) throws IOException {
        NewSyncResult newSyncResult = new NewSyncResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSyncResult;
            } else if (nextTag == 1) {
                newSyncResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newSyncResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSyncResult.data = NewSyncData.decode(protoReader);
            }
        }
    }
}
