package com.mi.global.shop.newmodel.home;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewHomeBlockInfoDesc {
    @SerializedName("background_img")
    public String background;
    @SerializedName("button_img")
    public String mButtonImage;
    @SerializedName("button_text")
    public String mButtonText;
    @SerializedName("sort")
    public int mSort;
    @SerializedName("sub_type")
    public String mSubType;
    @SerializedName("title")
    public String mTitle;
    @SerializedName("type")
    public String mType;
    @SerializedName("show_arrow")
    public boolean show_arrow;

    public static NewHomeBlockInfoDesc decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewHomeBlockInfoDesc decode(ProtoReader protoReader) throws IOException {
        NewHomeBlockInfoDesc newHomeBlockInfoDesc = new NewHomeBlockInfoDesc();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newHomeBlockInfoDesc.mType = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newHomeBlockInfoDesc.mSubType = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newHomeBlockInfoDesc.mTitle = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newHomeBlockInfoDesc.mSort = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 5:
                        newHomeBlockInfoDesc.background = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newHomeBlockInfoDesc.mButtonImage = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newHomeBlockInfoDesc.mButtonText = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newHomeBlockInfoDesc.show_arrow = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newHomeBlockInfoDesc;
            }
        }
    }
}
