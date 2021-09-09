package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewAddressData {
    @SerializedName("list")
    public ArrayList<NewAddressItem> list = new ArrayList<>();
    @SerializedName("list")
    public ArrayList<NewRegionItem> region = new ArrayList<>();

    public static NewAddressData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewAddressData decode(ProtoReader protoReader) throws IOException {
        NewAddressData newAddressData = new NewAddressData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newAddressData;
            } else if (nextTag == 1) {
                newAddressData.list.add(NewAddressItem.decode(protoReader));
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newAddressData.region.add(NewRegionItem.decode(protoReader));
            }
        }
    }
}
