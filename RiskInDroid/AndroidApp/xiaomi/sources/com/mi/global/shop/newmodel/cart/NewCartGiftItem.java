package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewCartGiftItem {
    @SerializedName("actId")
    public String actId;
    @SerializedName("activity_name")
    public String activity_name;
    @SerializedName("commodity_id")
    public String commodity_id;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("itemId")
    public String itemId;
    @SerializedName("num")
    public int num;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("salePrice")
    public String salePrice;
    @SerializedName("salePrice_txt")
    public String salePrice_txt;
    @SerializedName("selecInfo")
    public ArrayList<NewCartSelectInfo> selecInfo = new ArrayList<>();
    @SerializedName("subtotal")
    public String subtotal;
    @SerializedName("subtotal_txt")
    public String subtotal_txt;

    public static NewCartGiftItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartGiftItem decode(ProtoReader protoReader) throws IOException {
        NewCartGiftItem newCartGiftItem = new NewCartGiftItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartGiftItem;
            } else if (nextTag == 1) {
                newCartGiftItem.itemId = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 5) {
                newCartGiftItem.num = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 12) {
                newCartGiftItem.commodity_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 23) {
                newCartGiftItem.product_name = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 27) {
                newCartGiftItem.image_url = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 18) {
                newCartGiftItem.salePrice = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 19) {
                newCartGiftItem.subtotal = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 52) {
                newCartGiftItem.selecInfo.add(NewCartSelectInfo.decode(protoReader));
            } else if (nextTag != 53) {
                switch (nextTag) {
                    case 56:
                        newCartGiftItem.activity_name = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 57:
                        newCartGiftItem.salePrice_txt = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 58:
                        newCartGiftItem.subtotal_txt = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        continue;
                }
            } else {
                newCartGiftItem.actId = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
