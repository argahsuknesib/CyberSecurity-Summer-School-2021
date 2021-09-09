package com.mi.global.shop.newmodel.cart;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewCartCouponItem {
    @SerializedName("actName")
    public String actName;
    @SerializedName("actName")
    public String activity_name;
    @SerializedName("actName")
    public int coupon_num;
    @SerializedName("actName")
    public String coupon_type_name;
    @SerializedName("actName")
    public String parent_itemId;
    @SerializedName("actName")
    public int sel_status;

    public static NewCartCouponItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCartCouponItem decode(ProtoReader protoReader) throws IOException {
        NewCartCouponItem newCartCouponItem = new NewCartCouponItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newCartCouponItem.actName = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newCartCouponItem.coupon_type_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newCartCouponItem.coupon_num = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 4:
                        newCartCouponItem.parent_itemId = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newCartCouponItem.sel_status = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 6:
                        newCartCouponItem.activity_name = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newCartCouponItem;
            }
        }
    }
}
