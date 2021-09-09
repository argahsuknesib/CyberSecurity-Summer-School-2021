package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;

public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() {
        /* class com.google.android.exoplayer2.metadata.flac.VorbisComment.AnonymousClass1 */

        public final VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        public final VorbisComment[] newArray(int i) {
            return new VorbisComment[i];
        }
    };
    public final String key;
    public final String value;

    public final int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return Metadata.Entry.CC.$default$getWrappedMetadataBytes(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return Metadata.Entry.CC.$default$getWrappedMetadataFormat(this);
    }

    public VorbisComment(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    VorbisComment(Parcel parcel) {
        this.key = (String) Util.castNonNull(parcel.readString());
        this.value = (String) Util.castNonNull(parcel.readString());
    }

    public final String toString() {
        return "VC: " + this.key + "=" + this.value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            return this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value);
        }
    }

    public final int hashCode() {
        return ((this.key.hashCode() + 527) * 31) + this.value.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }
}
