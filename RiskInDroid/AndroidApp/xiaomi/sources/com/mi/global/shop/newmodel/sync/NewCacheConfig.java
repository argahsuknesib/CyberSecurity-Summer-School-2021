package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCacheConfig {
    public boolean css;
    public boolean enable;
    public boolean html;
    public boolean js;

    public static NewCacheConfig decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCacheConfig decode(ProtoReader protoReader) throws IOException {
        NewCacheConfig newCacheConfig = new NewCacheConfig();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCacheConfig;
            } else if (nextTag == 1) {
                newCacheConfig.enable = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 2) {
                newCacheConfig.js = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 3) {
                newCacheConfig.css = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCacheConfig.html = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
