package com.xiaomi.smarthome.core.entity.globaldynamicsetting;

import android.os.Parcel;
import android.os.Parcelable;

public class CTAInfo implements Parcelable {
    public static final Parcelable.Creator<CTAInfo> CREATOR = new Parcelable.Creator<CTAInfo>() {
        /* class com.xiaomi.smarthome.core.entity.globaldynamicsetting.CTAInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CTAInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CTAInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f6727O000000o;
    private boolean O00000Oo;

    public int describeContents() {
        return 0;
    }

    public CTAInfo() {
    }

    protected CTAInfo(Parcel parcel) {
        boolean z = true;
        this.f6727O000000o = parcel.readByte() != 0;
        this.O00000Oo = parcel.readByte() == 0 ? false : z;
    }

    public final synchronized void O000000o(boolean z) {
        this.f6727O000000o = z;
    }

    public final synchronized void O00000Oo(boolean z) {
        this.O00000Oo = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f6727O000000o ? (byte) 1 : 0);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
    }
}
