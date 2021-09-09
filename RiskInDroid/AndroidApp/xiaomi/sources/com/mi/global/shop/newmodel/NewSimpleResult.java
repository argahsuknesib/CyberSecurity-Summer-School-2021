package com.mi.global.shop.newmodel;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSimpleResult extends BaseResult {
    public static NewSimpleResult decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSimpleResult decode(ProtoReader protoReader) throws IOException {
        NewSimpleResult newSimpleResult = new NewSimpleResult();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSimpleResult;
            } else if (nextTag == 1) {
                newSimpleResult.errno = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSimpleResult.errmsg = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
