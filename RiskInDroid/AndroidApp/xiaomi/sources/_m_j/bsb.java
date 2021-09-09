package _m_j;

public final class bsb {

    /* renamed from: O000000o  reason: collision with root package name */
    int f13228O000000o;
    private final int O00000Oo;

    public bsb() {
        this.f13228O000000o = 0;
        this.O00000Oo = 37;
        this.f13228O000000o = 17;
    }

    private bsb O000000o(long j) {
        this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public final bsb O000000o(Object obj) {
        if (obj != null) {
            if (obj.getClass().isArray()) {
                int i = 0;
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    if (jArr != null) {
                        while (i < jArr.length) {
                            O000000o(jArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + iArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    if (sArr != null) {
                        while (i < sArr.length) {
                            this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + sArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    if (cArr != null) {
                        while (i < cArr.length) {
                            this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + cArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    if (bArr != null) {
                        while (i < bArr.length) {
                            this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + bArr[i];
                            i++;
                        }
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    if (dArr != null) {
                        while (i < dArr.length) {
                            O000000o(Double.doubleToLongBits(dArr[i]));
                            i++;
                        }
                    }
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    if (fArr != null) {
                        while (i < fArr.length) {
                            this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + Float.floatToIntBits(fArr[i]);
                            i++;
                        }
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    if (zArr != null) {
                        while (i < zArr.length) {
                            this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + (zArr[i] ^ true ? 1 : 0);
                            i++;
                        }
                    }
                } else {
                    O000000o((Object[]) obj);
                }
            } else {
                this.f13228O000000o = (this.f13228O000000o * this.O00000Oo) + obj.hashCode();
            }
            return this;
        }
        this.f13228O000000o *= this.O00000Oo;
        return this;
    }

    public final bsb O000000o(Object[] objArr) {
        if (objArr == null) {
            this.f13228O000000o *= this.O00000Oo;
        } else {
            for (Object O000000o2 : objArr) {
                O000000o(O000000o2);
            }
        }
        return this;
    }

    public final int hashCode() {
        return this.f13228O000000o;
    }
}
