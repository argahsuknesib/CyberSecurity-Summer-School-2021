package com.amap.api.services.a;

public class ch {

    /* renamed from: a  reason: collision with root package name */
    private final int f3363a;
    private int b;

    public ch() {
        this.b = 0;
        this.f3363a = 37;
        this.b = 17;
    }

    public ch a(boolean z) {
        this.b = (this.b * this.f3363a) + (z ^ true ? 1 : 0);
        return this;
    }

    public ch a(boolean[] zArr) {
        if (zArr == null) {
            this.b *= this.f3363a;
        } else {
            for (boolean a2 : zArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(byte b2) {
        this.b = (this.b * this.f3363a) + b2;
        return this;
    }

    public ch a(byte[] bArr) {
        if (bArr == null) {
            this.b *= this.f3363a;
        } else {
            for (byte a2 : bArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(char c) {
        this.b = (this.b * this.f3363a) + c;
        return this;
    }

    public ch a(char[] cArr) {
        if (cArr == null) {
            this.b *= this.f3363a;
        } else {
            for (char a2 : cArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(double d) {
        return a(Double.doubleToLongBits(d));
    }

    public ch a(double[] dArr) {
        if (dArr == null) {
            this.b *= this.f3363a;
        } else {
            for (double a2 : dArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(float f) {
        this.b = (this.b * this.f3363a) + Float.floatToIntBits(f);
        return this;
    }

    public ch a(float[] fArr) {
        if (fArr == null) {
            this.b *= this.f3363a;
        } else {
            for (float a2 : fArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(int i) {
        this.b = (this.b * this.f3363a) + i;
        return this;
    }

    public ch a(int[] iArr) {
        if (iArr == null) {
            this.b *= this.f3363a;
        } else {
            for (int a2 : iArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(long j) {
        this.b = (this.b * this.f3363a) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public ch a(long[] jArr) {
        if (jArr == null) {
            this.b *= this.f3363a;
        } else {
            for (long a2 : jArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(Object obj) {
        if (obj == null) {
            this.b *= this.f3363a;
        } else if (!obj.getClass().isArray()) {
            this.b = (this.b * this.f3363a) + obj.hashCode();
        } else if (obj instanceof long[]) {
            a((long[]) obj);
        } else if (obj instanceof int[]) {
            a((int[]) obj);
        } else if (obj instanceof short[]) {
            a((short[]) obj);
        } else if (obj instanceof char[]) {
            a((char[]) obj);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj);
        } else if (obj instanceof double[]) {
            a((double[]) obj);
        } else if (obj instanceof float[]) {
            a((float[]) obj);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj);
        } else {
            a((Object[]) obj);
        }
        return this;
    }

    public ch a(Object[] objArr) {
        if (objArr == null) {
            this.b *= this.f3363a;
        } else {
            for (Object a2 : objArr) {
                a(a2);
            }
        }
        return this;
    }

    public ch a(short s) {
        this.b = (this.b * this.f3363a) + s;
        return this;
    }

    public ch a(short[] sArr) {
        if (sArr == null) {
            this.b *= this.f3363a;
        } else {
            for (short a2 : sArr) {
                a(a2);
            }
        }
        return this;
    }

    public int a() {
        return this.b;
    }

    public int hashCode() {
        return a();
    }
}
