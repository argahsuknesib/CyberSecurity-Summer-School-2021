package com.mi.global.shop.newmodel.home;

import _m_j.jax;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class ExtraScreen {
    @SerializedName("completePic")
    @Expose
    public String completePic;
    @SerializedName("directURL")
    @Expose
    public String directURL;
    @SerializedName("hintPic")
    @Expose
    public String hintPic;
    @SerializedName("partialPic")
    @Expose
    public String partialPic;
    @SerializedName("placeHolder")
    @Expose
    public String placeHolder;

    public static ExtraScreen decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static ExtraScreen decode(ProtoReader protoReader) throws IOException {
        ExtraScreen extraScreen = new ExtraScreen();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return extraScreen;
            } else if (nextTag == 1) {
                extraScreen.hintPic = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                extraScreen.partialPic = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                extraScreen.completePic = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 4) {
                extraScreen.placeHolder = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                extraScreen.directURL = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
