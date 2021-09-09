package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() {
        /* class com.google.android.exoplayer2.video.ColorInfo.AnonymousClass1 */

        public final ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        public final ColorInfo[] newArray(int i) {
            return new ColorInfo[i];
        }
    };
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;

    public final int describeContents() {
        return 0;
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.colorSpace = i;
        this.colorRange = i2;
        this.colorTransfer = i3;
        this.hdrStaticInfo = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.colorSpace = parcel.readInt();
        this.colorRange = parcel.readInt();
        this.colorTransfer = parcel.readInt();
        this.hdrStaticInfo = Util.readBoolean(parcel) ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            return this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.colorSpace);
        sb.append(", ");
        sb.append(this.colorRange);
        sb.append(", ");
        sb.append(this.colorTransfer);
        sb.append(", ");
        sb.append(this.hdrStaticInfo != null);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((this.colorSpace + 527) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + Arrays.hashCode(this.hdrStaticInfo);
        }
        return this.hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.colorSpace);
        parcel.writeInt(this.colorRange);
        parcel.writeInt(this.colorTransfer);
        Util.writeBoolean(parcel, this.hdrStaticInfo != null);
        byte[] bArr = this.hdrStaticInfo;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
