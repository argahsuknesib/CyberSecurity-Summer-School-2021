package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewIndiaAddress implements Parcelable {
    public static final Parcelable.Creator<NewIndiaAddress> CREATOR = new Parcelable.Creator<NewIndiaAddress>() {
        /* class com.mi.global.shop.newmodel.user.address.NewIndiaAddress.AnonymousClass1 */

        public final NewIndiaAddress createFromParcel(Parcel parcel) {
            return new NewIndiaAddress(parcel);
        }

        public final NewIndiaAddress[] newArray(int i) {
            return new NewIndiaAddress[i];
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

    public static NewIndiaAddress decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewIndiaAddress decode(ProtoReader protoReader) throws IOException {
        NewIndiaAddress newIndiaAddress = new NewIndiaAddress();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newIndiaAddress;
            } else if (nextTag == 1) {
                newIndiaAddress.addr = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newIndiaAddress.landmark = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 3) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newIndiaAddress.city = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.addr);
        parcel.writeString(this.landmark);
        parcel.writeString(this.city);
    }

    public NewIndiaAddress() {
    }

    protected NewIndiaAddress(Parcel parcel) {
        this.addr = parcel.readString();
        this.landmark = parcel.readString();
        this.city = parcel.readString();
    }
}
