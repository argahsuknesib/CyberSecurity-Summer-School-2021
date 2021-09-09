package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator<TrackGroup>() {
        /* class com.google.android.exoplayer2.source.TrackGroup.AnonymousClass1 */

        public final TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        public final TrackGroup[] newArray(int i) {
            return new TrackGroup[i];
        }
    };
    private final Format[] formats;
    private int hashCode;
    public final int length;

    public final int describeContents() {
        return 0;
    }

    public TrackGroup(Format... formatArr) {
        Assertions.checkState(formatArr.length > 0);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    TrackGroup(Parcel parcel) {
        this.length = parcel.readInt();
        this.formats = new Format[this.length];
        for (int i = 0; i < this.length; i++) {
            this.formats[i] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public final Format getFormat(int i) {
        return this.formats[i];
    }

    public final int indexOf(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.formats) + 527;
        }
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            return this.length == trackGroup.length && Arrays.equals(this.formats, trackGroup.formats);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.length);
        for (int i2 = 0; i2 < this.length; i2++) {
            parcel.writeParcelable(this.formats[i2], 0);
        }
    }
}
