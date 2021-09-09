package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewEmi {
    @SerializedName("enable")
    public boolean enable;
    @SerializedName("gateway")
    public String gateway;
    @SerializedName("img")
    public String img;
    @SerializedName("key")
    public String key;
    @SerializedName("min")
    public int min;
    @SerializedName("name")
    public String name;
    @SerializedName("rate")
    public ArrayList<NewEmiRate> rate = new ArrayList<>();
    @SerializedName("reason")
    public String reason;
    @SerializedName("tips")
    public String tips;

    public static NewEmi decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewEmi decode(ProtoReader protoReader) throws IOException {
        NewEmi newEmi = new NewEmi();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newEmi.min = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 2:
                        newEmi.key = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newEmi.name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newEmi.enable = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 5:
                        newEmi.img = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newEmi.rate.add(NewEmiRate.decode(protoReader));
                        break;
                    case 7:
                        newEmi.tips = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newEmi.gateway = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newEmi.reason = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newEmi;
            }
        }
    }
}
