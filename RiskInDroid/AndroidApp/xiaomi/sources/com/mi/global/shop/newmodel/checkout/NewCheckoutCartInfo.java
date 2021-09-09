package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewCheckoutCartInfo {
    @SerializedName("activityDiscountMoney")
    public String activityDiscountMoney;
    @SerializedName("items")
    public ArrayList<NewCheckoutCartItem> items = new ArrayList<>();
    @SerializedName("productMoney")
    public String productMoney;
    @SerializedName("productMoney_txt")
    public String productMoney_txt;

    public static NewCheckoutCartInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCheckoutCartInfo decode(ProtoReader protoReader) throws IOException {
        NewCheckoutCartInfo newCheckoutCartInfo = new NewCheckoutCartInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCheckoutCartInfo;
            } else if (nextTag == 1) {
                newCheckoutCartInfo.items.add(NewCheckoutCartItem.decode(protoReader));
            } else if (nextTag == 2) {
                newCheckoutCartInfo.productMoney = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newCheckoutCartInfo.activityDiscountMoney = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCheckoutCartInfo.productMoney_txt = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
