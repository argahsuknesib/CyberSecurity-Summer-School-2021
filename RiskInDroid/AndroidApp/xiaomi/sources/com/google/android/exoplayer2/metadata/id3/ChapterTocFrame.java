package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        /* class com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.AnonymousClass1 */

        public final ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        public final ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    };
    public final String[] children;
    public final String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final Id3Frame[] subFrames;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.elementId = str;
        this.isRoot = z;
        this.isOrdered = z2;
        this.children = strArr;
        this.subFrames = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.elementId = (String) Util.castNonNull(parcel.readString());
        boolean z = true;
        this.isRoot = parcel.readByte() != 0;
        this.isOrdered = parcel.readByte() == 0 ? false : z;
        this.children = (String[]) Util.castNonNull(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.subFrames = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.subFrames[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final int getSubFrameCount() {
        return this.subFrames.length;
    }

    public final Id3Frame getSubFrame(int i) {
        return this.subFrames[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            return this.isRoot == chapterTocFrame.isRoot && this.isOrdered == chapterTocFrame.isOrdered && Util.areEqual(this.elementId, chapterTocFrame.elementId) && Arrays.equals(this.children, chapterTocFrame.children) && Arrays.equals(this.subFrames, chapterTocFrame.subFrames);
        }
    }

    public final int hashCode() {
        int i = ((((this.isRoot ? 1 : 0) + true) * 31) + (this.isOrdered ? 1 : 0)) * 31;
        String str = this.elementId;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.elementId);
        parcel.writeByte(this.isRoot ? (byte) 1 : 0);
        parcel.writeByte(this.isOrdered ? (byte) 1 : 0);
        parcel.writeStringArray(this.children);
        parcel.writeInt(this.subFrames.length);
        for (Id3Frame writeParcelable : this.subFrames) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
