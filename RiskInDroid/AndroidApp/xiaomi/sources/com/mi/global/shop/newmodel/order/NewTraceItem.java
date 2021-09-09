package com.mi.global.shop.newmodel.order;

import _m_j.jax;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class NewTraceItem implements Parcelable {
    public static final Parcelable.Creator<NewTraceItem> CREATOR = new Parcelable.Creator<NewTraceItem>() {
        /* class com.mi.global.shop.newmodel.order.NewTraceItem.AnonymousClass1 */

        public final NewTraceItem createFromParcel(Parcel parcel) {
            return new NewTraceItem(parcel);
        }

        public final NewTraceItem[] newArray(int i) {
            return new NewTraceItem[i];
        }
    };
    @SerializedName("text")
    public String text;
    @SerializedName("time")
    public String time;

    public int describeContents() {
        return 0;
    }

    public static NewTraceItem decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewTraceItem decode(ProtoReader protoReader) throws IOException {
        NewTraceItem newTraceItem = new NewTraceItem();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return newTraceItem;
            } else if (nextTag == 1) {
                newTraceItem.text = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                newTraceItem.time = ProtoAdapter.STRING.decode(protoReader);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
        parcel.writeString(this.time);
    }

    public NewTraceItem() {
    }

    protected NewTraceItem(Parcel parcel) {
        this.text = parcel.readString();
        this.time = parcel.readString();
    }
}
