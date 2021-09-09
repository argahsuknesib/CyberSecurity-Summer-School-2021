package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;

public final class StreamKey implements Parcelable, Comparable<StreamKey> {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        /* class com.google.android.exoplayer2.offline.StreamKey.AnonymousClass1 */

        public final StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        public final StreamKey[] newArray(int i) {
            return new StreamKey[i];
        }
    };
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    public final int describeContents() {
        return 0;
    }

    public StreamKey(int i, int i2) {
        this(0, i, i2);
    }

    public StreamKey(int i, int i2, int i3) {
        this.periodIndex = i;
        this.groupIndex = i2;
        this.trackIndex = i3;
    }

    StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        this.trackIndex = parcel.readInt();
    }

    public final String toString() {
        return this.periodIndex + "." + this.groupIndex + "." + this.trackIndex;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            return this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.trackIndex == streamKey.trackIndex;
        }
    }

    public final int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.trackIndex;
    }

    public final int compareTo(StreamKey streamKey) {
        int i = this.periodIndex - streamKey.periodIndex;
        if (i != 0) {
            return i;
        }
        int i2 = this.groupIndex - streamKey.groupIndex;
        return i2 == 0 ? this.trackIndex - streamKey.trackIndex : i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.trackIndex);
    }
}
