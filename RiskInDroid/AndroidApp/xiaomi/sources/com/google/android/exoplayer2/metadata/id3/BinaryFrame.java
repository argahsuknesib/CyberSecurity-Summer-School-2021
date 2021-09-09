package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.BinaryFrame.AnonymousClass1 */

        public final BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        public final BinaryFrame[] newArray(int i) {
            return new BinaryFrame[i];
        }
    };
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super((String) Util.castNonNull(parcel.readString()));
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            return this.id.equals(binaryFrame.id) && Arrays.equals(this.data, binaryFrame.data);
        }
    }

    public final int hashCode() {
        return ((this.id.hashCode() + 527) * 31) + Arrays.hashCode(this.data);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeByteArray(this.data);
    }
}
