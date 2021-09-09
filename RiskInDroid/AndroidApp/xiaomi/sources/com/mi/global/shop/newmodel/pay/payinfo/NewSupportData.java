package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSupportData {
    @SerializedName("can_cod")
    public int can_cod;
    @SerializedName("can_onlinepay")
    public int can_onlinepay;
    @SerializedName("cod_message")
    public String cod_message;
    @SerializedName("codstatus")
    public String codstatus;

    public static NewSupportData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSupportData decode(ProtoReader protoReader) throws IOException {
        NewSupportData newSupportData = new NewSupportData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSupportData;
            } else if (nextTag == 1) {
                newSupportData.can_cod = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 2) {
                newSupportData.can_onlinepay = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 3) {
                newSupportData.codstatus = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSupportData.cod_message = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
