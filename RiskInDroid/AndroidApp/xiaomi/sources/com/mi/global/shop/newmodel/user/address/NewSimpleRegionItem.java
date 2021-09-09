package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewSimpleRegionItem implements Parcelable {
    public static final Parcelable.Creator<NewSimpleRegionItem> CREATOR = new Parcelable.Creator<NewSimpleRegionItem>() {
        /* class com.mi.global.shop.newmodel.user.address.NewSimpleRegionItem.AnonymousClass1 */

        public final NewSimpleRegionItem createFromParcel(Parcel parcel) {
            return new NewSimpleRegionItem(parcel);
        }

        public final NewSimpleRegionItem[] newArray(int i) {
            return new NewSimpleRegionItem[i];
        }
    };
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    public int describeContents() {
        return 0;
    }

    public static NewSimpleRegionItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewSimpleRegionItem decode(ProtoReader protoReader) throws IOException {
        NewSimpleRegionItem newSimpleRegionItem = new NewSimpleRegionItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newSimpleRegionItem;
            } else if (nextTag == 1) {
                newSimpleRegionItem.id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newSimpleRegionItem.name = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
    }

    public NewSimpleRegionItem() {
    }

    protected NewSimpleRegionItem(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
    }
}
