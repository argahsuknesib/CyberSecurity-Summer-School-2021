package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewDeliversData implements Parcelable {
    public static final Parcelable.Creator<NewDeliversData> CREATOR = new Parcelable.Creator<NewDeliversData>() {
        /* class com.mi.global.shop.newmodel.order.NewDeliversData.AnonymousClass1 */

        public final NewDeliversData createFromParcel(Parcel parcel) {
            return new NewDeliversData(parcel);
        }

        public final NewDeliversData[] newArray(int i) {
            return new NewDeliversData[i];
        }
    };
    @SerializedName("deliver_id")
    public String deliver_id;
    @SerializedName("deliver_status")
    public String deliver_status;
    @SerializedName("express")
    public NewExpress express;
    @SerializedName("express_sn")
    public String express_sn;
    @SerializedName("order_status_info")
    public NewOrderStatusInfo order_status_info;
    @SerializedName("product")
    public ArrayList<NewListProduct> product = new ArrayList<>();

    public int describeContents() {
        return 0;
    }

    public static NewDeliversData decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewDeliversData decode(ProtoReader protoReader) throws IOException {
        NewDeliversData newDeliversData = new NewDeliversData();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newDeliversData.deliver_status = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newDeliversData.deliver_id = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newDeliversData.express = NewExpress.decode(protoReader);
                        break;
                    case 4:
                        newDeliversData.express_sn = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newDeliversData.product.add(NewListProduct.decode(protoReader));
                        break;
                    case 6:
                        newDeliversData.order_status_info = NewOrderStatusInfo.decode(protoReader);
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newDeliversData;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deliver_status);
        parcel.writeString(this.deliver_id);
        parcel.writeParcelable(this.express, i);
        parcel.writeString(this.express_sn);
        parcel.writeTypedList(this.product);
        parcel.writeParcelable(this.order_status_info, i);
    }

    public NewDeliversData() {
    }

    protected NewDeliversData(Parcel parcel) {
        this.deliver_status = parcel.readString();
        this.deliver_id = parcel.readString();
        this.express = (NewExpress) parcel.readParcelable(NewExpress.class.getClassLoader());
        this.express_sn = parcel.readString();
        this.product = parcel.createTypedArrayList(NewListProduct.CREATOR);
        this.order_status_info = (NewOrderStatusInfo) parcel.readParcelable(NewOrderStatusInfo.class.getClassLoader());
    }
}
