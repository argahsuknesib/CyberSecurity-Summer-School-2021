package com.xiaomi.miot;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class BinderParcel implements Parcelable {
    public static final Parcelable.Creator<BinderParcel> CREATOR = new Parcelable.Creator<BinderParcel>() {
        /* class com.xiaomi.miot.BinderParcel.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BinderParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BinderParcel(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public IBinder f6030O000000o;

    public int describeContents() {
        return 0;
    }

    public BinderParcel(IBinder iBinder) {
        this.f6030O000000o = iBinder;
    }

    protected BinderParcel(Parcel parcel) {
        this.f6030O000000o = parcel.readStrongBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f6030O000000o);
    }
}
