package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewOrderInfo implements Parcelable {
    public static final Parcelable.Creator<NewOrderInfo> CREATOR = new Parcelable.Creator<NewOrderInfo>() {
        /* class com.mi.global.shop.newmodel.order.NewOrderInfo.AnonymousClass1 */

        public final NewOrderInfo createFromParcel(Parcel parcel) {
            return new NewOrderInfo(parcel);
        }

        public final NewOrderInfo[] newArray(int i) {
            return new NewOrderInfo[i];
        }
    };
    @SerializedName("add_time")
    public String add_time;
    @SerializedName("add_time_fm")
    public String add_time_fm;
    @SerializedName("addr_india")
    public NewAddrIndia addr_india;
    @SerializedName("address")
    public String address;
    @SerializedName("arrival_time")
    public String arrival_time;
    @SerializedName("best_time")
    public String best_time;
    @SerializedName("city")
    public NewAddrSimple city;
    @SerializedName("consignee")
    public String consignee;
    @SerializedName("deliver_info")
    public NewDeliverInfo deliver_info;
    @SerializedName("distinct")
    public NewAddrSimple distinct;
    @SerializedName("email")
    public String email;
    @SerializedName("goods_amount_txt")
    public String goods_amount_txt;
    @SerializedName("invoice_title")
    public String invoice_title;
    @SerializedName("invoice_type")
    public String invoice_type;
    @SerializedName("isGetSelf")
    public boolean isGetSelf;
    @SerializedName("order_id")
    public String order_id;
    @SerializedName("order_status")
    public String order_status;
    @SerializedName("order_status_info")
    public NewOrderStatusInfo order_status_info;
    @SerializedName("pay_id")
    public String pay_id;
    @SerializedName("product")
    public ArrayList<NewListProduct> product = new ArrayList<>();
    @SerializedName("province")
    public NewAddrSimple province;
    @SerializedName("reduce_price")
    public String reduce_price;
    @SerializedName("reduce_price_txt")
    public String reduce_price_txt;
    @SerializedName("remaining_time")
    public String remaining_time;
    @SerializedName("shipment_expense_txt")
    public String shipment_expense_txt;
    @SerializedName("show_tag")
    public String show_tag;
    @SerializedName("show_tips")
    public String show_tips;
    @SerializedName("tel")
    public String tel;
    @SerializedName("ttl")
    public String ttl;
    @SerializedName("zipcode")
    public String zipcode;

    public int describeContents() {
        return 0;
    }

    public static NewOrderInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderInfo decode(ProtoReader protoReader) throws IOException {
        NewOrderInfo newOrderInfo = new NewOrderInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newOrderInfo.order_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newOrderInfo.order_status_info = NewOrderStatusInfo.decode(protoReader);
                        break;
                    case 3:
                        newOrderInfo.reduce_price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newOrderInfo.reduce_price_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newOrderInfo.shipment_expense_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newOrderInfo.goods_amount_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newOrderInfo.ttl = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newOrderInfo.product.add(NewListProduct.decode(protoReader));
                        break;
                    case 9:
                        newOrderInfo.consignee = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newOrderInfo.tel = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newOrderInfo.province = NewAddrSimple.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newOrderInfo.city = NewAddrSimple.decode(protoReader);
                        break;
                    case 13:
                        newOrderInfo.distinct = NewAddrSimple.decode(protoReader);
                        break;
                    case 14:
                        newOrderInfo.address = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newOrderInfo.zipcode = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 16:
                        newOrderInfo.best_time = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 17:
                        newOrderInfo.email = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 18:
                        newOrderInfo.invoice_type = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 19:
                        newOrderInfo.invoice_title = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 20:
                        newOrderInfo.add_time_fm = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 21:
                        newOrderInfo.deliver_info = NewDeliverInfo.decode(protoReader);
                        break;
                    case 22:
                        newOrderInfo.addr_india = NewAddrIndia.decode(protoReader);
                        break;
                    case 23:
                        newOrderInfo.pay_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 24:
                        newOrderInfo.add_time = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 25:
                        newOrderInfo.order_status = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 26:
                        newOrderInfo.isGetSelf = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    case 27:
                        newOrderInfo.remaining_time = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 28:
                        newOrderInfo.show_tag = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 29:
                        newOrderInfo.show_tips = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 30:
                        newOrderInfo.arrival_time = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newOrderInfo;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.order_id);
        parcel.writeParcelable(this.order_status_info, i);
        parcel.writeString(this.reduce_price);
        parcel.writeString(this.reduce_price_txt);
        parcel.writeString(this.shipment_expense_txt);
        parcel.writeString(this.goods_amount_txt);
        parcel.writeString(this.ttl);
        parcel.writeTypedList(this.product);
        parcel.writeString(this.consignee);
        parcel.writeString(this.tel);
        parcel.writeParcelable(this.province, i);
        parcel.writeParcelable(this.city, i);
        parcel.writeParcelable(this.distinct, i);
        parcel.writeString(this.address);
        parcel.writeString(this.zipcode);
        parcel.writeString(this.best_time);
        parcel.writeString(this.email);
        parcel.writeString(this.invoice_type);
        parcel.writeString(this.invoice_title);
        parcel.writeString(this.add_time_fm);
        parcel.writeParcelable(this.deliver_info, i);
        parcel.writeParcelable(this.addr_india, i);
        parcel.writeString(this.pay_id);
        parcel.writeString(this.add_time);
        parcel.writeString(this.order_status);
        parcel.writeByte(this.isGetSelf ? (byte) 1 : 0);
        parcel.writeString(this.remaining_time);
    }

    public NewOrderInfo() {
    }

    protected NewOrderInfo(Parcel parcel) {
        this.order_id = parcel.readString();
        this.order_status_info = (NewOrderStatusInfo) parcel.readParcelable(NewOrderStatusInfo.class.getClassLoader());
        this.reduce_price = parcel.readString();
        this.reduce_price_txt = parcel.readString();
        this.shipment_expense_txt = parcel.readString();
        this.goods_amount_txt = parcel.readString();
        this.ttl = parcel.readString();
        this.product = parcel.createTypedArrayList(NewListProduct.CREATOR);
        this.consignee = parcel.readString();
        this.tel = parcel.readString();
        this.province = (NewAddrSimple) parcel.readParcelable(NewAddrSimple.class.getClassLoader());
        this.city = (NewAddrSimple) parcel.readParcelable(NewAddrSimple.class.getClassLoader());
        this.distinct = (NewAddrSimple) parcel.readParcelable(NewAddrSimple.class.getClassLoader());
        this.address = parcel.readString();
        this.zipcode = parcel.readString();
        this.best_time = parcel.readString();
        this.email = parcel.readString();
        this.invoice_type = parcel.readString();
        this.invoice_title = parcel.readString();
        this.add_time_fm = parcel.readString();
        this.deliver_info = (NewDeliverInfo) parcel.readParcelable(NewDeliverInfo.class.getClassLoader());
        this.addr_india = (NewAddrIndia) parcel.readParcelable(NewAddrIndia.class.getClassLoader());
        this.pay_id = parcel.readString();
        this.add_time = parcel.readString();
        this.order_status = parcel.readString();
        this.isGetSelf = parcel.readByte() != 0;
        this.remaining_time = parcel.readString();
    }
}
