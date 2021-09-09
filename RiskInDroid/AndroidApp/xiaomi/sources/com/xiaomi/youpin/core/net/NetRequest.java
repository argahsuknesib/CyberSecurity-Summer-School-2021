package com.xiaomi.youpin.core.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class NetRequest implements Parcelable {
    public static final Parcelable.Creator<NetRequest> CREATOR = new Parcelable.Creator<NetRequest>() {
        /* class com.xiaomi.youpin.core.net.NetRequest.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NetRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NetRequest(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f12062O000000o;
    private String O00000Oo;
    private List<KeyValuePair> O00000o;
    private List<KeyValuePair> O00000o0;

    public int describeContents() {
        return 0;
    }

    protected NetRequest(Parcel parcel) {
        this.f12062O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.createTypedArrayList(KeyValuePair.CREATOR);
        this.O00000o = parcel.createTypedArrayList(KeyValuePair.CREATOR);
    }

    public String toString() {
        return "path:" + this.O00000Oo + " method:" + this.f12062O000000o + " params:" + this.O00000o;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12062O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeTypedList(this.O00000o0);
        parcel.writeTypedList(this.O00000o);
    }
}
