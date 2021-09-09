package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewActivityConfig {
    public int duration;
    public int endTime;
    public int startTime;
    public String url;

    public static NewActivityConfig decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewActivityConfig decode(ProtoReader protoReader) throws IOException {
        NewActivityConfig newActivityConfig = new NewActivityConfig();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newActivityConfig;
            } else if (nextTag == 1) {
                newActivityConfig.url = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newActivityConfig.startTime = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 3) {
                newActivityConfig.endTime = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newActivityConfig.duration = ProtoAdapter.INT32.decode(protoReader).intValue();
            }
        }
    }
}
