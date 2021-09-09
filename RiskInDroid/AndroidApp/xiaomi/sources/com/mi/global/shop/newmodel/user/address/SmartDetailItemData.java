package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.io.Serializable;

public class SmartDetailItemData implements Serializable {
    private static final long serialVersionUID = 7292237918674834442L;
    @SerializedName("address")
    public String address;
    @SerializedName("city")
    public String city;
    @SerializedName("_id")
    public String id;
    @SerializedName("isServiceable")
    public boolean isServiceable;
    @SerializedName("landmark")
    public String landmark;
    @SerializedName("postalCode")
    public String postalCode;
    @SerializedName("shortName")
    public String shortName;
    @SerializedName("state")
    public String state;

    public static SmartDetailItemData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static SmartDetailItemData decode(ProtoReader protoReader) throws IOException {
        SmartDetailItemData smartDetailItemData = new SmartDetailItemData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        smartDetailItemData.id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        smartDetailItemData.landmark = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        smartDetailItemData.isServiceable = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 4:
                        smartDetailItemData.state = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        smartDetailItemData.postalCode = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        smartDetailItemData.city = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        smartDetailItemData.address = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        smartDetailItemData.shortName = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return smartDetailItemData;
            }
        }
    }
}
