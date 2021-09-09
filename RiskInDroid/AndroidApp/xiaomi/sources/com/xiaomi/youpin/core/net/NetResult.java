package com.xiaomi.youpin.core.net;

import android.os.Parcel;
import android.os.Parcelable;

public class NetResult implements Parcelable {
    public static final Parcelable.Creator<NetResult> CREATOR = new Parcelable.Creator<NetResult>() {
        /* class com.xiaomi.youpin.core.net.NetResult.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NetResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NetResult(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12063O000000o;
    public boolean O00000Oo = false;
    public String O00000o;
    public boolean O00000o0 = true;

    public int describeContents() {
        return 0;
    }

    public NetResult() {
    }

    protected NetResult(Parcel parcel) {
        boolean z = false;
        this.f12063O000000o = parcel.readInt();
        this.O00000Oo = parcel.readByte() != 0;
        this.O00000o0 = parcel.readByte() != 0 ? true : z;
        this.O00000o = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12063O000000o);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
        parcel.writeString(this.O00000o);
    }
}
