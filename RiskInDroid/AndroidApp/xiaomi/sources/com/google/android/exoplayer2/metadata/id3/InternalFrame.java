package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.InternalFrame.AnonymousClass1 */

        public final InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        public final InternalFrame[] newArray(int i) {
            return new InternalFrame[i];
        }
    };
    public final String description;
    public final String domain;
    public final String text;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    InternalFrame(Parcel parcel) {
        super("----");
        this.domain = (String) Util.castNonNull(parcel.readString());
        this.description = (String) Util.castNonNull(parcel.readString());
        this.text = (String) Util.castNonNull(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            InternalFrame internalFrame = (InternalFrame) obj;
            return Util.areEqual(this.description, internalFrame.description) && Util.areEqual(this.domain, internalFrame.domain) && Util.areEqual(this.text, internalFrame.text);
        }
    }

    public final int hashCode() {
        String str = this.domain;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final String toString() {
        return this.id + ": domain=" + this.domain + ", description=" + this.description;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }
}
