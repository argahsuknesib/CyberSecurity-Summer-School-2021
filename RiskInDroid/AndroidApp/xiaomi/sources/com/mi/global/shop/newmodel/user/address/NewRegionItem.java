package com.mi.global.shop.newmodel.user.address;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewRegionItem implements Parcelable {
    public static final Parcelable.Creator<NewRegionItem> CREATOR = new Parcelable.Creator<NewRegionItem>() {
        /* class com.mi.global.shop.newmodel.user.address.NewRegionItem.AnonymousClass1 */

        public final NewRegionItem createFromParcel(Parcel parcel) {
            return new NewRegionItem(parcel);
        }

        public final NewRegionItem[] newArray(int i) {
            return new NewRegionItem[i];
        }
    };
    @SerializedName("can_cod")
    public int can_cod;
    @SerializedName("region_id")
    public String region_id;
    @SerializedName("region_name")
    public String region_name;
    @SerializedName("zipcode")
    public String zipcode;

    public int describeContents() {
        return 0;
    }

    public static NewRegionItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewRegionItem decode(ProtoReader protoReader) throws IOException {
        NewRegionItem newRegionItem = new NewRegionItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newRegionItem;
            } else if (nextTag == 1) {
                newRegionItem.region_id = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 2) {
                newRegionItem.region_name = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag == 3) {
                newRegionItem.zipcode = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 4) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newRegionItem.can_cod = ProtoAdapter.INT32.decode(protoReader).intValue();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.region_id);
        parcel.writeString(this.region_name);
        parcel.writeString(this.zipcode);
        parcel.writeInt(this.can_cod);
    }

    public NewRegionItem() {
    }

    protected NewRegionItem(Parcel parcel) {
        this.region_id = parcel.readString();
        this.region_name = parcel.readString();
        this.zipcode = parcel.readString();
        this.can_cod = parcel.readInt();
    }
}
