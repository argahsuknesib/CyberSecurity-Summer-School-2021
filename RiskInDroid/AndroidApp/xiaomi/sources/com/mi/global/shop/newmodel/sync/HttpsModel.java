package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class HttpsModel {
    public boolean api;
    public boolean file;
    public boolean page;

    public static HttpsModel decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static HttpsModel decode(ProtoReader protoReader) throws IOException {
        HttpsModel httpsModel = new HttpsModel();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return httpsModel;
            } else if (nextTag == 1) {
                httpsModel.api = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 2) {
                httpsModel.file = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                httpsModel.page = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
