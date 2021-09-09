package com.mi.global.shop.newmodel.notice;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewNoticeData {
    @SerializedName("content")
    public String content;
    @SerializedName("type")
    public String type;
    @SerializedName("url")
    public String url;

    public static NewNoticeData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewNoticeData decode(ProtoReader protoReader) throws IOException {
        NewNoticeData newNoticeData = new NewNoticeData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newNoticeData;
            } else if (nextTag == 1) {
                newNoticeData.type = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newNoticeData.content = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newNoticeData.url = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
