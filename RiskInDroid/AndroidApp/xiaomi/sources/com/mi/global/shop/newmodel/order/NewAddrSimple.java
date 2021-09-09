package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewAddrSimple implements Parcelable {
    public static final Parcelable.Creator<NewAddrSimple> CREATOR = new Parcelable.Creator<NewAddrSimple>() {
        /* class com.mi.global.shop.newmodel.order.NewAddrSimple.AnonymousClass1 */

        public final NewAddrSimple createFromParcel(Parcel parcel) {
            return new NewAddrSimple(parcel);
        }

        public final NewAddrSimple[] newArray(int i) {
            return new NewAddrSimple[i];
        }
    };
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    public int describeContents() {
        return 0;
    }

    public static NewAddrSimple decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewAddrSimple decode(ProtoReader protoReader) throws IOException {
        NewAddrSimple newAddrSimple = new NewAddrSimple();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newAddrSimple;
            } else if (nextTag == 1) {
                newAddrSimple.id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newAddrSimple.name = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
    }

    public NewAddrSimple() {
    }

    protected NewAddrSimple(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
    }
}
