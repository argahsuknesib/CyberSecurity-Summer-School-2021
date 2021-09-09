package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewCartActivity {
    @SerializedName("coupons")
    public ArrayList<NewCartCouponItem> coupons = new ArrayList<>();
    @SerializedName("gift")
    public ArrayList<NewCartGiftItem> gift = new ArrayList<>();
    @SerializedName("postFree")
    public NewCartPostFree postFree;
    @SerializedName("reduction")
    public ArrayList<NewCartReductionItem> reduction = new ArrayList<>();

    public static NewCartActivity decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartActivity decode(ProtoReader protoReader) throws IOException {
        NewCartActivity newCartActivity = new NewCartActivity();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newCartActivity;
            } else if (nextTag == 1) {
                newCartActivity.gift.add(NewCartGiftItem.decode(protoReader));
            } else if (nextTag == 2) {
                newCartActivity.reduction.add(NewCartReductionItem.decode(protoReader));
            } else if (nextTag == 3) {
                newCartActivity.coupons.add(NewCartCouponItem.decode(protoReader));
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newCartActivity.postFree = NewCartPostFree.decode(protoReader);
            }
        }
    }
}
