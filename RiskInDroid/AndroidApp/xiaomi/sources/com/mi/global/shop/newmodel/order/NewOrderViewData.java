package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewOrderViewData implements Parcelable {
    public static final Parcelable.Creator<NewOrderViewData> CREATOR = new Parcelable.Creator<NewOrderViewData>() {
        /* class com.mi.global.shop.newmodel.order.NewOrderViewData.AnonymousClass1 */

        public final NewOrderViewData createFromParcel(Parcel parcel) {
            return new NewOrderViewData(parcel);
        }

        public final NewOrderViewData[] newArray(int i) {
            return new NewOrderViewData[i];
        }
    };
    @SerializedName("currentTime")
    public String currentTime;
    @SerializedName("delivers")
    public ArrayList<NewDeliversData> delivers = new ArrayList<>();
    @SerializedName("differenceAmount")
    public String differenceAmount;
    @SerializedName("exchange_coupon")
    public ExchangeCoupon exchange_coupon;
    @SerializedName("goodsAmt")
    public String goodsAmt;
    @SerializedName("id")
    public String id;
    @SerializedName("isGetSelf")
    public Boolean isGetSelf;
    @SerializedName("orderInfo")
    public NewOrderInfo orderInfo;
    @SerializedName("pickupAddr")
    public NewPickupAddr pickupAddr;

    public int describeContents() {
        return 0;
    }

    public static NewOrderViewData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderViewData decode(ProtoReader protoReader) throws IOException {
        NewOrderViewData newOrderViewData = new NewOrderViewData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newOrderViewData.id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newOrderViewData.delivers.add(NewDeliversData.decode(protoReader));
                        break;
                    case 3:
                        newOrderViewData.orderInfo = NewOrderInfo.decode(protoReader);
                        break;
                    case 4:
                        newOrderViewData.differenceAmount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newOrderViewData.isGetSelf = ProtoAdapter.BOOL.decode(protoReader);
                        break;
                    case 6:
                        newOrderViewData.pickupAddr = NewPickupAddr.decode(protoReader);
                        break;
                    case 7:
                        newOrderViewData.goodsAmt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newOrderViewData.currentTime = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newOrderViewData.exchange_coupon = ExchangeCoupon.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newOrderViewData;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeTypedList(this.delivers);
        parcel.writeParcelable(this.orderInfo, i);
        parcel.writeString(this.differenceAmount);
        parcel.writeValue(this.isGetSelf);
        parcel.writeParcelable(this.pickupAddr, i);
        parcel.writeString(this.goodsAmt);
        parcel.writeString(this.currentTime);
        parcel.writeParcelable(this.exchange_coupon, i);
    }

    public NewOrderViewData() {
    }

    protected NewOrderViewData(Parcel parcel) {
        this.id = parcel.readString();
        this.delivers = parcel.createTypedArrayList(NewDeliversData.CREATOR);
        this.orderInfo = (NewOrderInfo) parcel.readParcelable(NewOrderInfo.class.getClassLoader());
        this.differenceAmount = parcel.readString();
        this.isGetSelf = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.pickupAddr = (NewPickupAddr) parcel.readParcelable(NewPickupAddr.class.getClassLoader());
        this.goodsAmt = parcel.readString();
        this.currentTime = parcel.readString();
        this.exchange_coupon = (ExchangeCoupon) parcel.readParcelable(NewOrderInfo.class.getClassLoader());
    }

    public static class ExchangeCoupon implements Parcelable {
        public static final Parcelable.Creator<ExchangeCoupon> CREATOR = new Parcelable.Creator<ExchangeCoupon>() {
            /* class com.mi.global.shop.newmodel.order.NewOrderViewData.ExchangeCoupon.AnonymousClass1 */

            public final ExchangeCoupon createFromParcel(Parcel parcel) {
                return new ExchangeCoupon(parcel);
            }

            public final ExchangeCoupon[] newArray(int i) {
                return new ExchangeCoupon[i];
            }
        };
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

        public int describeContents() {
            return 0;
        }

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

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.coupon_id);
            parcel.writeString(this.brand);
            parcel.writeString(this.model);
            parcel.writeInt(this.amount);
            parcel.writeString(this.start_time);
            parcel.writeString(this.end_time);
            parcel.writeString(this.imei);
            parcel.writeString(this.image);
            parcel.writeInt(this.coupon_status);
            parcel.writeString(this.add_time);
            parcel.writeString(this.model_id);
        }

        public ExchangeCoupon() {
        }

        protected ExchangeCoupon(Parcel parcel) {
            this.coupon_id = parcel.readInt();
            this.brand = parcel.readString();
            this.model = parcel.readString();
            this.amount = parcel.readInt();
            this.start_time = parcel.readString();
            this.end_time = parcel.readString();
            this.imei = parcel.readString();
            this.image = parcel.readString();
            this.coupon_status = parcel.readInt();
            this.add_time = parcel.readString();
            this.model_id = parcel.readString();
        }
    }
}
