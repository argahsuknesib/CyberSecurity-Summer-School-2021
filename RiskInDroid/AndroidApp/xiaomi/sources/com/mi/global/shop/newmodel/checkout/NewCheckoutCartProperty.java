package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.cart.NewCartInsurance;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCheckoutCartProperty {
    @SerializedName("insurance")
    public NewCartInsurance insurance;

    public static NewCheckoutCartProperty decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCheckoutCartProperty decode(ProtoReader protoReader) throws IOException {
        NewCheckoutCartProperty newCheckoutCartProperty = new NewCheckoutCartProperty();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCheckoutCartProperty;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCheckoutCartProperty.insurance = NewCartInsurance.decode(protoReader);
            }
        }
    }
}
