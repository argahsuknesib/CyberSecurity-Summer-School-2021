package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class HttpDnsModel {
    public boolean enable;
    public String hostname;
    public String ips;
    public String ttl;

    public static HttpDnsModel decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static HttpDnsModel decode(ProtoReader protoReader) throws IOException {
        HttpDnsModel httpDnsModel = new HttpDnsModel();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return httpDnsModel;
            } else if (nextTag == 1) {
                httpDnsModel.hostname = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                httpDnsModel.enable = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 3) {
                httpDnsModel.ips = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                httpDnsModel.ttl = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
