package com.google.android.cameraview;

import _m_j.o0OO00o0;
import android.os.Parcel;
import android.os.Parcelable;

public class AspectRatio implements Parcelable, Comparable<AspectRatio> {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() {
        /* class com.google.android.cameraview.AspectRatio.AnonymousClass1 */

        public final AspectRatio createFromParcel(Parcel parcel) {
            return AspectRatio.of(parcel.readInt(), parcel.readInt());
        }

        public final AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    };
    private static final o0OO00o0<o0OO00o0<AspectRatio>> sCache = new o0OO00o0<>(16);
    private final int mX;
    private final int mY;

    public int describeContents() {
        return 0;
    }

    public static AspectRatio of(int i, int i2) {
        int gcd = gcd(i, i2);
        int i3 = i / gcd;
        int i4 = i2 / gcd;
        o0OO00o0 O000000o2 = sCache.O000000o(i3, null);
        if (O000000o2 == null) {
            AspectRatio aspectRatio = new AspectRatio(i3, i4);
            o0OO00o0 o0oo00o0 = new o0OO00o0();
            o0oo00o0.O00000Oo(i4, aspectRatio);
            sCache.O00000Oo(i3, o0oo00o0);
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = (AspectRatio) O000000o2.O000000o(i4, null);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio aspectRatio3 = new AspectRatio(i3, i4);
        O000000o2.O00000Oo(i4, aspectRatio3);
        return aspectRatio3;
    }

    public static AspectRatio parse(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return of(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Malformed aspect ratio: ".concat(String.valueOf(str)), e);
            }
        } else {
            throw new IllegalArgumentException("Malformed aspect ratio: ".concat(String.valueOf(str)));
        }
    }

    private AspectRatio(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public boolean matches(Size size) {
        int gcd = gcd(size.getWidth(), size.getHeight());
        return this.mX == size.getWidth() / gcd && this.mY == size.getHeight() / gcd;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatio) {
            AspectRatio aspectRatio = (AspectRatio) obj;
            return this.mX == aspectRatio.mX && this.mY == aspectRatio.mY;
        }
    }

    public String toString() {
        return this.mX + ":" + this.mY;
    }

    public float toFloat() {
        return ((float) this.mX) / ((float) this.mY);
    }

    public int hashCode() {
        int i = this.mY;
        int i2 = this.mX;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public int compareTo(AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return toFloat() - aspectRatio.toFloat() > 0.0f ? 1 : -1;
    }

    public AspectRatio inverse() {
        return of(this.mY, this.mX);
    }

    private static int gcd(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mX);
        parcel.writeInt(this.mY);
    }
}
