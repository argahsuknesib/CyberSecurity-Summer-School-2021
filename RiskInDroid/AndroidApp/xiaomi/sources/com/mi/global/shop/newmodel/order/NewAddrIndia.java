package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewAddrIndia implements Parcelable {
    public static final Parcelable.Creator<NewAddrIndia> CREATOR = new Parcelable.Creator<NewAddrIndia>() {
        /* class com.mi.global.shop.newmodel.order.NewAddrIndia.AnonymousClass1 */

        public final NewAddrIndia createFromParcel(Parcel parcel) {
            return new NewAddrIndia(parcel);
        }

        public final NewAddrIndia[] newArray(int i) {
            return new NewAddrIndia[i];
        }
    };
    @SerializedName("addr")
    public String addr;
    @SerializedName("city")
    public String city;
    @SerializedName("landmark")
    public String landmark;

    public int describeContents() {
        return 0;
    }

    public static NewAddrIndia decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewAddrIndia decode(ProtoReader protoReader) throws IOException {
        NewAddrIndia newAddrIndia = new NewAddrIndia();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newAddrIndia;
            } else if (nextTag == 1) {
                newAddrIndia.addr = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newAddrIndia.landmark = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newAddrIndia.city = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.addr);
        parcel.writeString(this.landmark);
        parcel.writeString(this.city);
    }

    public NewAddrIndia() {
    }

    protected NewAddrIndia(Parcel parcel) {
        this.addr = parcel.readString();
        this.landmark = parcel.readString();
        this.city = parcel.readString();
    }
}
