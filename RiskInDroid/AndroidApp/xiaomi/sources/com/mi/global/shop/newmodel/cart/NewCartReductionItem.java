package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCartReductionItem {
    @SerializedName("actName")
    public String actName;
    @SerializedName("activity_name")
    public String activity_name;
    @SerializedName("reduceMoney")
    public String reduceMoney;
    @SerializedName("reduceMoneySingle")
    public String reduceMoneySingle;
    @SerializedName("reduceMoneySingle_txt")
    public String reduceMoneySingle_txt;
    @SerializedName("reduceMoney_txt")
    public String reduceMoney_txt;
    @SerializedName("times")
    public int times;

    public static NewCartReductionItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartReductionItem decode(ProtoReader protoReader) throws IOException {
        NewCartReductionItem newCartReductionItem = new NewCartReductionItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartReductionItem;
            } else if (nextTag == 1) {
                newCartReductionItem.actName = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newCartReductionItem.reduceMoneySingle = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newCartReductionItem.times = ProtoAdapter.INT32.decode(protoReader).intValue();
            } else if (nextTag == 4) {
                newCartReductionItem.reduceMoney = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 7) {
                newCartReductionItem.activity_name = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 8) {
                newCartReductionItem.reduceMoneySingle_txt = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 9) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCartReductionItem.reduceMoney_txt = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }
}
