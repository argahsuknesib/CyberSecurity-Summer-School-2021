package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.user.address.FourDeliveryData;
import com.mi.global.shop.newmodel.user.address.SmartBoxData;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewChangeAddressData {
    @SerializedName("can_exchange")
    public boolean can_exchange;
    @SerializedName("codtext")
    public String codtext;
    @SerializedName("hint")
    public String hint;
    @SerializedName("isCos")
    public boolean isCos;
    @SerializedName("pincode")
    public String pincode;
    @SerializedName("producttext")
    public String producttext;
    @SerializedName("shipmentlist")
    public ArrayList<FourDeliveryData> shipmentlist = new ArrayList<>();
    @SerializedName("smartbox")
    public SmartBoxData smartboxdata;
    @SerializedName("valid")
    public boolean valid;

    public static NewChangeAddressData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewChangeAddressData decode(ProtoReader protoReader) throws IOException {
        NewChangeAddressData newChangeAddressData = new NewChangeAddressData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newChangeAddressData.valid = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 2:
                        newChangeAddressData.codtext = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newChangeAddressData.producttext = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newChangeAddressData.isCos = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 5:
                        newChangeAddressData.shipmentlist.add(FourDeliveryData.decode(protoReader));
                        break;
                    case 6:
                        newChangeAddressData.smartboxdata = SmartBoxData.decode(protoReader);
                        break;
                    case 7:
                        newChangeAddressData.pincode = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newChangeAddressData.can_exchange = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 9:
                        newChangeAddressData.hint = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newChangeAddressData;
            }
        }
    }
}
