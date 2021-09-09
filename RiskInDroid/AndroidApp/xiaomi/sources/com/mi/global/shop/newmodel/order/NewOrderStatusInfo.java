package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewOrderStatusInfo implements Parcelable {
    public static final Parcelable.Creator<NewOrderStatusInfo> CREATOR = new Parcelable.Creator<NewOrderStatusInfo>() {
        /* class com.mi.global.shop.newmodel.order.NewOrderStatusInfo.AnonymousClass1 */

        public final NewOrderStatusInfo createFromParcel(Parcel parcel) {
            return new NewOrderStatusInfo(parcel);
        }

        public final NewOrderStatusInfo[] newArray(int i) {
            return new NewOrderStatusInfo[i];
        }
    };
    @SerializedName("apply_refund_info")
    public String apply_refund_info;
    @SerializedName("apply_refund_status")
    public String apply_refund_status;
    @SerializedName("delivery_info")
    public String delivery_info;
    @SerializedName("info")
    public String info;
    @SerializedName("next")
    public ArrayList<String> next = new ArrayList<>();
    @SerializedName("trace")
    public ArrayList<NewTraceItem> trace = new ArrayList<>();

    public int describeContents() {
        return 0;
    }

    public static NewOrderStatusInfo decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewOrderStatusInfo decode(ProtoReader protoReader) throws IOException {
        NewOrderStatusInfo newOrderStatusInfo = new NewOrderStatusInfo();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newOrderStatusInfo.apply_refund_info = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newOrderStatusInfo.apply_refund_status = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newOrderStatusInfo.delivery_info = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newOrderStatusInfo.info = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newOrderStatusInfo.next.add(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 6:
                        newOrderStatusInfo.trace.add(NewTraceItem.decode(protoReader));
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newOrderStatusInfo;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.apply_refund_info);
        parcel.writeString(this.apply_refund_status);
        parcel.writeString(this.delivery_info);
        parcel.writeString(this.info);
        parcel.writeStringList(this.next);
        parcel.writeList(this.trace);
    }

    public NewOrderStatusInfo() {
    }

    protected NewOrderStatusInfo(Parcel parcel) {
        this.apply_refund_info = parcel.readString();
        this.apply_refund_status = parcel.readString();
        this.delivery_info = parcel.readString();
        this.info = parcel.readString();
        this.next = parcel.createStringArrayList();
        this.trace = new ArrayList<>();
        parcel.readList(this.trace, NewTraceItem.class.getClassLoader());
    }
}
