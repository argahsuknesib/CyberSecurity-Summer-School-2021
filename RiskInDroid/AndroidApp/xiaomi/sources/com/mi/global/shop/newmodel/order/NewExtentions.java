package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewExtentions implements Parcelable {
    public static final Parcelable.Creator<NewExtentions> CREATOR = new Parcelable.Creator<NewExtentions>() {
        /* class com.mi.global.shop.newmodel.order.NewExtentions.AnonymousClass1 */

        public final NewExtentions createFromParcel(Parcel parcel) {
            return new NewExtentions(parcel);
        }

        public final NewExtentions[] newArray(int i) {
            return new NewExtentions[i];
        }
    };
    @SerializedName("goods_dealer")
    public String goods_dealer;

    public int describeContents() {
        return 0;
    }

    public static NewExtentions decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewExtentions decode(ProtoReader protoReader) throws IOException {
        NewExtentions newExtentions = new NewExtentions();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newExtentions;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newExtentions.goods_dealer = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.goods_dealer);
    }

    public NewExtentions() {
    }

    protected NewExtentions(Parcel parcel) {
        this.goods_dealer = parcel.readString();
    }
}
