package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;

public abstract class Id3Frame implements Metadata.Entry {
    public final String id;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return Metadata.Entry.CC.$default$getWrappedMetadataBytes(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return Metadata.Entry.CC.$default$getWrappedMetadataFormat(this);
    }

    public Id3Frame(String str) {
        this.id = str;
    }

    public String toString() {
        return this.id;
    }
}
