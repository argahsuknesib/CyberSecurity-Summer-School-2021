package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCentralHeader {
    public String userCentralHeaderBg;
    public String userCentralHeaderTitleColor;

    public static NewCentralHeader decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCentralHeader decode(ProtoReader protoReader) throws IOException {
        NewCentralHeader newCentralHeader = new NewCentralHeader();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCentralHeader;
            } else if (nextTag == 1) {
                newCentralHeader.userCentralHeaderBg = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCentralHeader.userCentralHeaderTitleColor = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
