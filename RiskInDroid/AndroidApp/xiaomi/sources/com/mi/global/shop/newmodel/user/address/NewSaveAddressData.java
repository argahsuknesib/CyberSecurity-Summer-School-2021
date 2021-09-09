package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSaveAddressData {
    @SerializedName("addinfo")
    public NewAddressItem addinfo;
    @SerializedName("errors")
    public String errors;
    @SerializedName("result")
    public String result;

    public static NewSaveAddressData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSaveAddressData decode(ProtoReader protoReader) throws IOException {
        NewSaveAddressData newSaveAddressData = new NewSaveAddressData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSaveAddressData;
            } else if (nextTag == 1) {
                newSaveAddressData.errors = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newSaveAddressData.result = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSaveAddressData.addinfo = NewAddressItem.decode(protoReader);
            }
        }
    }
}
