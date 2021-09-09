package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewPayOption {
    @SerializedName("enable")
    public boolean enable;
    @SerializedName("image")
    public String image;
    @SerializedName("info")
    public String info;
    @SerializedName("infotitle")
    public String infotitle;
    @SerializedName("key")
    public String key;
    @SerializedName("subOptions")
    public ArrayList<NewPayOption> subOptions = new ArrayList<>();
    @SerializedName("subtitle")
    public String subtitle;
    @SerializedName("title")
    public String title;
    @SerializedName("upioptions")
    public String upioptions;
    @SerializedName("upitype")
    public int upitype = 1;

    public static NewPayOption decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayOption decode(ProtoReader protoReader) throws IOException {
        NewPayOption newPayOption = new NewPayOption();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newPayOption.title = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newPayOption.subtitle = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newPayOption.enable = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 4:
                        newPayOption.infotitle = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newPayOption.info = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newPayOption.image = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newPayOption.key = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newPayOption.subOptions.add(decode(protoReader));
                        break;
                    case 9:
                        newPayOption.upioptions = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newPayOption.upitype = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newPayOption;
            }
        }
    }
}
