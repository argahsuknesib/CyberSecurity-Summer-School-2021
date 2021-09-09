package com.mi.global.shop.newmodel.sync;

import _m_j.jax;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewStartPage {
    public int duration;
    public int endTime;
    public String gif;
    public String img;
    public String openType;
    public int startTime;
    public String url;

    public static NewStartPage decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewStartPage decode(ProtoReader protoReader) throws IOException {
        NewStartPage newStartPage = new NewStartPage();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newStartPage.startTime = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 2:
                        newStartPage.endTime = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 3:
                        newStartPage.url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newStartPage.img = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newStartPage.duration = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 6:
                        newStartPage.openType = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newStartPage.gif = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newStartPage;
            }
        }
    }
}
