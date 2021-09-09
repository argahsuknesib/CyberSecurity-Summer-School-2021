package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPushType {
    public boolean defaultStatus;
    public String desc;
    public boolean enableclose;
    public String key;
    public String title;

    public static NewPushType decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPushType decode(ProtoReader protoReader) throws IOException {
        NewPushType newPushType = new NewPushType();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPushType;
            } else if (nextTag == 1) {
                newPushType.title = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newPushType.desc = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newPushType.key = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 4) {
                newPushType.enableclose = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPushType.defaultStatus = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            }
        }
    }
}
