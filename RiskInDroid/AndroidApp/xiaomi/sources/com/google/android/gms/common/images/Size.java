package com.google.android.gms.common.images;

import _m_j.jdn;

public final class Size {
    private final int zzps;
    private final int zzpt;

    public Size(int i, int i2) {
        this.zzps = i;
        this.zzpt = i2;
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zzi(str);
                }
            } else {
                throw zzi(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static NumberFormatException zzi(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append(jdn.f1779O000000o);
        throw new NumberFormatException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zzps == size.zzps && this.zzpt == size.zzpt;
        }
    }

    public final int getHeight() {
        return this.zzpt;
    }

    public final int getWidth() {
        return this.zzps;
    }

    public final int hashCode() {
        int i = this.zzpt;
        int i2 = this.zzps;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        int i = this.zzps;
        int i2 = this.zzpt;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
