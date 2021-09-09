package com.google.android.cameraview;

import android.os.Parcel;
import android.os.Parcelable;

public class Size implements Parcelable, Comparable<Size> {
    public static final Parcelable.Creator<Size> CREATOR = new Parcelable.Creator<Size>() {
        /* class com.google.android.cameraview.Size.AnonymousClass1 */

        public final Size createFromParcel(Parcel parcel) {
            return new Size(parcel.readInt(), parcel.readInt());
        }

        public final Size[] newArray(int i) {
            return new Size[i];
        }
    };
    private final int mHeight;
    private final int mWidth;

    public int describeContents() {
        return 0;
    }

    public Size(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public static Size parse(String str) {
        int indexOf = str.indexOf(120);
        if (indexOf != -1) {
            try {
                return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Malformed size: ".concat(String.valueOf(str)), e);
            }
        } else {
            throw new IllegalArgumentException("Malformed size: ".concat(String.valueOf(str)));
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.mWidth == size.mWidth && this.mHeight == size.mHeight;
        }
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public int compareTo(Size size) {
        return (this.mWidth * this.mHeight) - (size.mWidth * size.mHeight);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mHeight);
    }
}
