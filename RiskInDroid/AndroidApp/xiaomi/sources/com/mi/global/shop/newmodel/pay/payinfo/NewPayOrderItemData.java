package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewPayOrderItemData {
    @SerializedName("cart_price")
    public String cart_price;
    @SerializedName("goods_id")
    public String goods_id;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("price")
    public String price;
    @SerializedName("product_count")
    public String product_count;
    @SerializedName("product_id")
    public String product_id;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("subtotal")
    public String subtotal;

    public static NewPayOrderItemData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayOrderItemData decode(ProtoReader protoReader) throws IOException {
        NewPayOrderItemData newPayOrderItemData = new NewPayOrderItemData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPayOrderItemData;
            } else if (nextTag == 1) {
                newPayOrderItemData.product_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newPayOrderItemData.goods_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 4) {
                newPayOrderItemData.product_name = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 5) {
                switch (nextTag) {
                    case 9:
                        newPayOrderItemData.product_count = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 10:
                        newPayOrderItemData.cart_price = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 11:
                        newPayOrderItemData.price = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newPayOrderItemData.subtotal = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        continue;
                }
            } else {
                newPayOrderItemData.image_url = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
