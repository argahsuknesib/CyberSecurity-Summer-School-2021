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

public class NewDeliverInfo implements Parcelable {
    public static final Parcelable.Creator<NewDeliverInfo> CREATOR = new Parcelable.Creator<NewDeliverInfo>() {
        /* class com.mi.global.shop.newmodel.order.NewDeliverInfo.AnonymousClass1 */

        public final NewDeliverInfo createFromParcel(Parcel parcel) {
            return new NewDeliverInfo(parcel);
        }

        public final NewDeliverInfo[] newArray(int i) {
            return new NewDeliverInfo[i];
        }
    };
    @SerializedName("goods_amount_txt")
    public String deliver_id;
    @SerializedName("goods_amount_txt")
    public NewExpress express;
    @SerializedName("goods_amount_txt")
    public String express_sn;
    @SerializedName("goods_amount_txt")
    public String goods_amount_txt;
    @SerializedName("order_id")
    public String order_id;
    @SerializedName("order_status_info")
    public NewOrderStatusInfo order_status_info;
    @SerializedName("goods_amount_txt")
    public ArrayList<NewListProduct> product = new ArrayList<>();
    @SerializedName("reduce_price")
    public String reduce_price;
    @SerializedName("reduce_price_txt")
    public String reduce_price_txt;
    @SerializedName("shipment_expense_txt")
    public String shipment_expense_txt;

    public int describeContents() {
        return 0;
    }

    public static NewDeliverInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDeliverInfo decode(ProtoReader protoReader) throws IOException {
        NewDeliverInfo newDeliverInfo = new NewDeliverInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newDeliverInfo.order_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newDeliverInfo.order_status_info = NewOrderStatusInfo.decode(protoReader);
                        break;
                    case 3:
                        newDeliverInfo.reduce_price = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newDeliverInfo.reduce_price_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newDeliverInfo.shipment_expense_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newDeliverInfo.goods_amount_txt = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newDeliverInfo.product.add(NewListProduct.decode(protoReader));
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newDeliverInfo.deliver_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newDeliverInfo.express_sn = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newDeliverInfo.express = NewExpress.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newDeliverInfo;
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
        parcel.writeTypedList(this.product);
        parcel.writeString(this.deliver_id);
        parcel.writeString(this.express_sn);
        parcel.writeParcelable(this.express, i);
    }

    public NewDeliverInfo() {
    }

    protected NewDeliverInfo(Parcel parcel) {
        this.order_id = parcel.readString();
        this.order_status_info = (NewOrderStatusInfo) parcel.readParcelable(NewOrderStatusInfo.class.getClassLoader());
        this.reduce_price = parcel.readString();
        this.reduce_price_txt = parcel.readString();
        this.shipment_expense_txt = parcel.readString();
        this.goods_amount_txt = parcel.readString();
        this.product = parcel.createTypedArrayList(NewListProduct.CREATOR);
        this.deliver_id = parcel.readString();
        this.express_sn = parcel.readString();
        this.express = (NewExpress) parcel.readParcelable(NewExpress.class.getClassLoader());
    }
}
