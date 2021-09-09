package com.mi.global.shop.newmodel.notice;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.BaseResult;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewNoticeResult extends BaseResult {
    @SerializedName("data")
    public NewNoticeData data;

    public static NewNoticeResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewNoticeResult decode(ProtoReader protoReader) throws IOException {
        NewNoticeResult newNoticeResult = new NewNoticeResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newNoticeResult;
            } else if (nextTag == 1) {
                newNoticeResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newNoticeResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newNoticeResult.data = NewNoticeData.decode(protoReader);
            }
        }
    }
}
