package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;

public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new Parcelable.Creator<AppInfoTable>() {
        /* class com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable.AnonymousClass1 */

        public final AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) Assertions.checkNotNull(parcel.readString()));
        }

        public final AppInfoTable[] newArray(int i) {
            return new AppInfoTable[i];
        }
    };
    public final int controlCode;
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

    public AppInfoTable(int i, String str) {
        this.controlCode = i;
        this.url = str;
    }

    public final String toString() {
        return "Ait(controlCode=" + this.controlCode + ",url=" + this.url + ")";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.controlCode);
    }
}
