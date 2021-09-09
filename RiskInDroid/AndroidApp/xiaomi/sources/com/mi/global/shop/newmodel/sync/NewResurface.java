package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewResurface {
    public int duration;
    public int endtime;
    public String md5;
    public int starttime;
    public boolean switch_;
    public String theme;
    public String url;

    public static NewResurface decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewResurface decode(ProtoReader protoReader) throws IOException {
        NewResurface newResurface = new NewResurface();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newResurface.switch_ = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 2:
                        newResurface.starttime = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 3:
                        newResurface.endtime = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 4:
                        newResurface.url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newResurface.md5 = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newResurface.theme = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newResurface.duration = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newResurface;
            }
        }
    }
}
