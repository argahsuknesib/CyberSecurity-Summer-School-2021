package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.PrivFrame.AnonymousClass1 */

        public final PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        public final PrivFrame[] newArray(int i) {
            return new PrivFrame[i];
        }
    };
    public final String owner;
    public final byte[] privateData;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.owner = str;
        this.privateData = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.owner = (String) Util.castNonNull(parcel.readString());
        this.privateData = (byte[]) Util.castNonNull(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PrivFrame privFrame = (PrivFrame) obj;
            return Util.areEqual(this.owner, privFrame.owner) && Arrays.equals(this.privateData, privFrame.privateData);
        }
    }

    public final int hashCode() {
        String str = this.owner;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.privateData);
    }

    public final String toString() {
        return this.id + ": owner=" + this.owner;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.privateData);
    }
}
