package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPackageInfo {
    public String url;
    public int version;

    public static NewPackageInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPackageInfo decode(ProtoReader protoReader) throws IOException {
        NewPackageInfo newPackageInfo = new NewPackageInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPackageInfo;
            } else if (nextTag == 1) {
                newPackageInfo.version = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPackageInfo.url = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
