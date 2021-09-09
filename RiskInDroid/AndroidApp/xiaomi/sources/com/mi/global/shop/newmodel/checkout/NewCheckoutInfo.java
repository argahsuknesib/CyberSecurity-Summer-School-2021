package com.mi.global.shop.newmodel.checkout;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.user.address.FourDeliveryData;
import com.mi.global.shop.newmodel.user.address.NewAddressItem;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewCheckoutInfo {
    @SerializedName("activityDiscountMoney")
    public String activityDiscountMoney;
    @SerializedName("activityDiscountMoney_txt")
    public String activityDiscountMoneyTxt;
    @SerializedName("address")
    public NewAddressItem address;
    @SerializedName("shipmentlist")
    public ArrayList<FourDeliveryData> shipmentlist = new ArrayList<>();

    public static NewCheckoutInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCheckoutInfo decode(ProtoReader protoReader) throws IOException {
        NewCheckoutInfo newCheckoutInfo = new NewCheckoutInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCheckoutInfo;
            } else if (nextTag == 1) {
                newCheckoutInfo.address = NewAddressItem.decode(protoReader);
            } else if (nextTag == 4) {
                newCheckoutInfo.shipmentlist.add(FourDeliveryData.decode(protoReader));
            } else if (nextTag == 9) {
                newCheckoutInfo.activityDiscountMoney = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 14) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCheckoutInfo.activityDiscountMoneyTxt = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
