package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPassPortInfo {
    public String errInfo;
    public boolean tokenInvalid;

    public static NewPassPortInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPassPortInfo decode(ProtoReader protoReader) throws IOException {
        NewPassPortInfo newPassPortInfo = new NewPassPortInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPassPortInfo;
            } else if (nextTag == 1) {
                newPassPortInfo.tokenInvalid = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPassPortInfo.errInfo = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
