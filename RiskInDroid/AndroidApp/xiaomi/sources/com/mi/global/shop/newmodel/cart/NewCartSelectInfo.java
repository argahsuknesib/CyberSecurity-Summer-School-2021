package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCartSelectInfo {
    @SerializedName("actId")
    public String actId;
    @SerializedName("commodity_id")
    public String commodity_id;
    @SerializedName("goodsId")
    public String goodsId;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("is_cos")
    public boolean is_cos;
    @SerializedName("product_id")
    public String product_id;
    @SerializedName("product_name")
    public String product_name;
    @SerializedName("salePrice")
    public String salePrice;
    @SerializedName("style_value")
    public String style_value;

    public static NewCartSelectInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartSelectInfo decode(ProtoReader protoReader) throws IOException {
        NewCartSelectInfo newCartSelectInfo = new NewCartSelectInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartSelectInfo;
            } else if (nextTag == 1) {
                newCartSelectInfo.is_cos = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag == 3) {
                newCartSelectInfo.product_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 4) {
                newCartSelectInfo.commodity_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 5) {
                newCartSelectInfo.product_name = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 6) {
                switch (nextTag) {
                    case 28:
                        newCartSelectInfo.style_value = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 29:
                        newCartSelectInfo.goodsId = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 30:
                        newCartSelectInfo.salePrice = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    case 31:
                        newCartSelectInfo.actId = ProtoAdapter.STRING.decode(protoReader);
                        continue;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        continue;
                }
            } else {
                newCartSelectInfo.image_url = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
