package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        /* class com.google.android.exoplayer2.metadata.icy.IcyInfo.AnonymousClass1 */

        public final IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        public final IcyInfo[] newArray(int i) {
            return new IcyInfo[i];
        }
    };
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return Metadata.Entry.CC.$default$getWrappedMetadataBytes(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return Metadata.Entry.CC.$default$getWrappedMetadataFormat(this);
    }

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.rawMetadata = bArr;
        this.title = str;
        this.url = str2;
    }

    IcyInfo(Parcel parcel) {
        this.rawMetadata = (byte[]) Assertions.checkNotNull(parcel.createByteArray());
        this.title = parcel.readString();
        this.url = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.rawMetadata, ((IcyInfo) obj).rawMetadata);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    public final String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.title, this.url, Integer.valueOf(this.rawMetadata.length));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.rawMetadata);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }
}
