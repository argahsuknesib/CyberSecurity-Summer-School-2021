package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.newmodel.NewPageMessage;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewPayInfoData {
    @SerializedName("bank_list")
    public String bank_list;
    @SerializedName("exchange_coupon")
    public ExchangeCoupon exchange_coupon;
    @SerializedName("mention")
    public String mention;
    @SerializedName("mention_ext")
    public String mention_ext;
    @SerializedName("onlinepayCouponInfo")
    public NewOnlinePayCouponInfoData onlinepayCouponInfo;
    @SerializedName("orderInfo")
    public NewPayOrderInfoData orderInfo;
    @SerializedName("pagemsg")
    public NewPageMessage pagemsg;
    @SerializedName("payList")
    public NewPayList payList;
    @SerializedName("payOptions")
    public ArrayList<NewPayOption> payOptions = new ArrayList<>();
    @SerializedName("payParam")
    public NewPayParam payParam;
    @SerializedName("payParamString")
    public String payParamString;
    @SerializedName("support")
    public NewSupportData support;

    public static NewPayInfoData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayInfoData decode(ProtoReader protoReader) throws IOException {
        NewPayInfoData newPayInfoData = new NewPayInfoData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newPayInfoData.orderInfo = NewPayOrderInfoData.decode(protoReader);
                        break;
                    case 2:
                        newPayInfoData.payList = NewPayList.decode(protoReader);
                        break;
                    case 3:
                        newPayInfoData.payParam = NewPayParam.decode(protoReader);
                        break;
                    case 4:
                        newPayInfoData.support = NewSupportData.decode(protoReader);
                        break;
                    case 5:
                        newPayInfoData.mention = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newPayInfoData.onlinepayCouponInfo = NewOnlinePayCouponInfoData.decode(protoReader);
                        break;
                    case 7:
                        newPayInfoData.payParamString = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newPayInfoData.mention_ext = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newPayInfoData.bank_list = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                    case 11:
                        newPayInfoData.pagemsg = NewPageMessage.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newPayInfoData.payOptions.add(NewPayOption.decode(protoReader));
                        break;
                    case 13:
                        newPayInfoData.exchange_coupon = ExchangeCoupon.decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newPayInfoData;
            }
        }
    }

    public String toJsonString() {
        return new Gson().toJsonTree(this).getAsJsonObject().toString();
    }

    public static class ExchangeCoupon {
        @SerializedName("add_time")
        public String add_time;
        @SerializedName("amount")
        public int amount;
        @SerializedName("brand")
        public String brand;
        @SerializedName("coupon_id")
        public int coupon_id;
        @SerializedName("coupon_status")
        public int coupon_status;
        @SerializedName("end_time")
        public String end_time;
        @SerializedName("image")
        public String image;
        @SerializedName("imei")
        public String imei;
        @SerializedName("model")
        public String model;
        @SerializedName("model_id")
        public String model_id;
        @SerializedName("start_time")
        public String start_time;

        public static ExchangeCoupon decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static ExchangeCoupon decode(ProtoReader protoReader) throws IOException {
            ExchangeCoupon exchangeCoupon = new ExchangeCoupon();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            exchangeCoupon.coupon_id = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 2:
                            exchangeCoupon.brand = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 3:
                            exchangeCoupon.model = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 4:
                            exchangeCoupon.amount = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 5:
                            exchangeCoupon.start_time = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 6:
                            exchangeCoupon.end_time = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 7:
                            exchangeCoupon.imei = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            exchangeCoupon.image = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 9:
                            exchangeCoupon.coupon_status = ProtoAdapter.INT32.decode(protoReader).intValue();
                            break;
                        case 10:
                            exchangeCoupon.add_time = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 11:
                            exchangeCoupon.model_id = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        default:
                            protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return exchangeCoupon;
                }
            }
        }
    }
}
