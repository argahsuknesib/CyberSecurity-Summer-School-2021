package com.qti.wwandbprovider;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.qti.wwandbreceiver.BSInfo;

public final class BSObsLocationData implements Parcelable {
    public static final Parcelable.Creator<BSObsLocationData> CREATOR = new Parcelable.Creator<BSObsLocationData>() {
        /* class com.qti.wwandbprovider.BSObsLocationData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BSObsLocationData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BSObsLocationData(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public Location f5462O000000o;
    public BSInfo O00000Oo;
    public int O00000o0;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ BSObsLocationData(Parcel parcel, byte b) {
        this(parcel);
    }

    public BSObsLocationData() {
    }

    private BSObsLocationData(Parcel parcel) {
        BSInfo bSInfo = null;
        this.f5462O000000o = parcel.readByte() == 1 ? (Location) Location.CREATOR.createFromParcel(parcel) : null;
        this.O00000Oo = parcel.readByte() == 1 ? BSInfo.CREATOR.createFromParcel(parcel) : bSInfo;
        this.O00000o0 = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeByte((byte) (this.f5462O000000o != null ? 1 : 0));
        Location location = this.f5462O000000o;
        if (location != null) {
            location.writeToParcel(parcel, i);
        }
        if (this.O00000Oo == null) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        BSInfo bSInfo = this.O00000Oo;
        if (bSInfo != null) {
            bSInfo.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.O00000o0);
    }
}
