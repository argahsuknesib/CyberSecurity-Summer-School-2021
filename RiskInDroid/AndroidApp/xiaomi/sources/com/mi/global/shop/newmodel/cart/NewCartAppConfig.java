package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCartAppConfig {
    @SerializedName("discountMin")
    public String discountMin;
    @SerializedName("discountMin_txt")
    public String discountMin_txt;

    public static NewCartAppConfig decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartAppConfig decode(ProtoReader protoReader) throws IOException {
        NewCartAppConfig newCartAppConfig = new NewCartAppConfig();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartAppConfig;
            } else if (nextTag == 1) {
                newCartAppConfig.discountMin = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCartAppConfig.discountMin_txt = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
