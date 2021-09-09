package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewCartGatherOrderInfo {
    @SerializedName("balance_price")
    public String balance_price;
    @SerializedName("goods_list")
    public ArrayList<String> goods_list = new ArrayList<>();
    @SerializedName("show_list")
    public boolean show_list;

    public static NewCartGatherOrderInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartGatherOrderInfo decode(ProtoReader protoReader) throws IOException {
        NewCartGatherOrderInfo newCartGatherOrderInfo = new NewCartGatherOrderInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartGatherOrderInfo;
            } else if (nextTag == 1) {
                newCartGatherOrderInfo.balance_price = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newCartGatherOrderInfo.show_list = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCartGatherOrderInfo.goods_list.add(ProtoAdapter.STRING.decode(protoReader));
            }
        }
    }
}
