package com.shockwave.pdfium.util;

public class Size {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f5609O000000o;
    public final int O00000Oo;

    public Size(int i, int i2) {
        this.f5609O000000o = i;
        this.O00000Oo = i2;
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
            return this.f5609O000000o == size.f5609O000000o && this.O00000Oo == size.O00000Oo;
        }
    }

    public String toString() {
        return this.f5609O000000o + "x" + this.O00000Oo;
    }

    public int hashCode() {
        int i = this.O00000Oo;
        int i2 = this.f5609O000000o;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
