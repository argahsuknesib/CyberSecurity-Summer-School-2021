package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewPickupAddr implements Parcelable {
    public static final Parcelable.Creator<NewPickupAddr> CREATOR = new Parcelable.Creator<NewPickupAddr>() {
        /* class com.mi.global.shop.newmodel.order.NewPickupAddr.AnonymousClass1 */

        public final NewPickupAddr createFromParcel(Parcel parcel) {
            return new NewPickupAddr(parcel);
        }

        public final NewPickupAddr[] newArray(int i) {
            return new NewPickupAddr[i];
        }
    };
    @SerializedName("Sat")
    public String Sat;
    @SerializedName("SundayToHoliday")
    public String SundayToHoliday;
    @SerializedName("code")
    public String code;
    @SerializedName("workday")
    public String workday;

    public int describeContents() {
        return 0;
    }

    public static NewPickupAddr decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPickupAddr decode(ProtoReader protoReader) throws IOException {
        NewPickupAddr newPickupAddr = new NewPickupAddr();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newPickupAddr;
            } else if (nextTag == 1) {
                newPickupAddr.code = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newPickupAddr.workday = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newPickupAddr.Sat = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newPickupAddr.SundayToHoliday = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.code);
        parcel.writeString(this.workday);
        parcel.writeString(this.Sat);
        parcel.writeString(this.SundayToHoliday);
    }

    public NewPickupAddr() {
    }

    protected NewPickupAddr(Parcel parcel) {
        this.code = parcel.readString();
        this.workday = parcel.readString();
        this.Sat = parcel.readString();
        this.SundayToHoliday = parcel.readString();
    }
}
