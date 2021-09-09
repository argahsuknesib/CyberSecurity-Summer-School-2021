package com.mi.global.shop.newmodel.user.coupon;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewCouponItem {
    @SerializedName("additional")
    public String additional;
    @SerializedName("beginTime")
    public int beginTime;
    @SerializedName("check_res")
    public String check_res;
    @SerializedName("couponId")
    public String couponId;
    @SerializedName("couponName")
    public String couponName;
    @SerializedName("couponNameDesc")
    public String couponNameDesc;
    @SerializedName("endTime")
    public int endTime;
    @SerializedName("order_id")
    public String order_id;
    @SerializedName("stat")
    public String stat;
    @SerializedName("type")
    public String type;
    @SerializedName("type_id")
    public String type_id;
    @SerializedName("usableRange")
    public String usableRange;
    @SerializedName("use_info")
    public UseInfo useinfo;
    @SerializedName("value")
    public String value;
    @SerializedName("valueDesc")
    public String valueDesc;

    public static class UseInfo {
        @SerializedName("amount")
        public String amount;
        @SerializedName("couponDiscountMoney")
        public String couponDiscountMoney;
        @SerializedName("shipment")
        public String shipment;
    }

    public static NewCouponItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewCouponItem decode(ProtoReader protoReader) throws IOException {
        NewCouponItem newCouponItem = new NewCouponItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newCouponItem.couponId = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newCouponItem.value = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newCouponItem.beginTime = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 4:
                        newCouponItem.endTime = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 5:
                        newCouponItem.couponName = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newCouponItem.couponNameDesc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newCouponItem.stat = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newCouponItem.additional = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newCouponItem.type = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newCouponItem.type_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newCouponItem.order_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newCouponItem.valueDesc = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        newCouponItem.usableRange = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newCouponItem;
            }
        }
    }
}
