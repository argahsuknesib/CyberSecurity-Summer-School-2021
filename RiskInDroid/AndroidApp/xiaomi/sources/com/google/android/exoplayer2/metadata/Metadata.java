package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        /* class com.google.android.exoplayer2.metadata.Metadata.AnonymousClass1 */

        public final Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        public final Metadata[] newArray(int i) {
            return new Metadata[i];
        }
    };
    private final Entry[] entries;

    public interface Entry extends Parcelable {

        /* renamed from: com.google.android.exoplayer2.metadata.Metadata$Entry$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static byte[] $default$getWrappedMetadataBytes(Entry entry) {
                return null;
            }

            public static Format $default$getWrappedMetadataFormat(Entry entry) {
                return null;
            }
        }

        byte[] getWrappedMetadataBytes();

        Format getWrappedMetadataFormat();
    }

    public final int describeContents() {
        return 0;
    }

    public Metadata(Entry... entryArr) {
        this.entries = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this.entries = new Entry[list.size()];
        list.toArray(this.entries);
    }

    Metadata(Parcel parcel) {
        this.entries = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.entries;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int length() {
        return this.entries.length;
    }

    public final Entry get(int i) {
        return this.entries[i];
    }

    public final Metadata copyWithAppendedEntriesFrom(Metadata metadata) {
        return metadata == null ? this : copyWithAppendedEntries(metadata.entries);
    }

    public final Metadata copyWithAppendedEntries(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        return new Metadata((Entry[]) Util.nullSafeArrayConcatenation(this.entries, entryArr));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.entries, ((Metadata) obj).entries);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    public final String toString() {
        return "entries=" + Arrays.toString(this.entries);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.entries.length);
        for (Entry writeParcelable : this.entries) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
