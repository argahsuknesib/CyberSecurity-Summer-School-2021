package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.io.Serializable;

public class FourDeliveryData implements Serializable {
    private static final long serialVersionUID = -2536049100149882328L;
    @SerializedName("amount")
    public String amount;
    @SerializedName("basic_amount")
    public String basic_amount;
    @SerializedName("brief")
    public String brief;
    @SerializedName("checked")
    public boolean checked;
    @SerializedName("description")
    public String description;
    @SerializedName("no_amount")
    public String no_amount;
    @SerializedName("shipment_id")
    public String shipment_id;
    @SerializedName("title")
    public String title;

    public static FourDeliveryData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static FourDeliveryData decode(ProtoReader protoReader) throws IOException {
        FourDeliveryData fourDeliveryData = new FourDeliveryData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        fourDeliveryData.shipment_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        fourDeliveryData.brief = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        fourDeliveryData.amount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        fourDeliveryData.basic_amount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        fourDeliveryData.checked = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 6:
                        fourDeliveryData.description = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        fourDeliveryData.no_amount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        fourDeliveryData.title = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return fourDeliveryData;
            }
        }
    }
}
