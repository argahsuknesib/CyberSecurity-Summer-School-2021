package _m_j;

import com.xiaomi.push.d;
import java.io.InputStream;
import java.util.Vector;

public final class elx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final byte[] f15617O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private final InputStream O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;

    public elx(InputStream inputStream) {
        this.O0000OOo = Integer.MAX_VALUE;
        this.O0000Oo = 64;
        this.O0000OoO = 67108864;
        this.f15617O000000o = new byte[4096];
        this.O00000Oo = 0;
        this.O00000o = 0;
        this.O00000oO = inputStream;
    }

    elx(byte[] bArr, int i, int i2) {
        this.O0000OOo = Integer.MAX_VALUE;
        this.O0000Oo = 64;
        this.O0000OoO = 67108864;
        this.f15617O000000o = bArr;
        this.O00000Oo = i2 + i;
        this.O00000o = i;
        this.O00000oO = null;
    }

    private boolean O000000o(boolean z) {
        int i = this.O00000o;
        int i2 = this.O00000Oo;
        if (i >= i2) {
            int i3 = this.O0000O0o;
            if (i3 + i2 != this.O0000OOo) {
                this.O0000O0o = i3 + i2;
                this.O00000o = 0;
                InputStream inputStream = this.O00000oO;
                this.O00000Oo = inputStream == null ? -1 : inputStream.read(this.f15617O000000o);
                int i4 = this.O00000Oo;
                if (i4 == 0 || i4 < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.O00000Oo + "\nThe InputStream implementation is buggy.");
                } else if (i4 == -1) {
                    this.O00000Oo = 0;
                    if (!z) {
                        return false;
                    }
                    throw d.O000000o();
                } else {
                    O0000O0o();
                    int i5 = this.O0000O0o + this.O00000Oo + this.O00000o0;
                    if (i5 <= this.O0000OoO && i5 >= 0) {
                        return true;
                    }
                    throw d.O0000OOo();
                }
            } else if (!z) {
                return false;
            } else {
                throw d.O000000o();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    private void O00000o(int i) {
        if (i >= 0) {
            int i2 = this.O0000O0o;
            int i3 = this.O00000o;
            int i4 = i2 + i3 + i;
            int i5 = this.O0000OOo;
            if (i4 <= i5) {
                int i6 = this.O00000Oo;
                if (i <= i6 - i3) {
                    this.O00000o = i3 + i;
                    return;
                }
                int i7 = i6 - i3;
                this.O0000O0o = i2 + i6;
                this.O00000o = 0;
                this.O00000Oo = 0;
                while (i7 < i) {
                    InputStream inputStream = this.O00000oO;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i - i7));
                    if (skip > 0) {
                        i7 += skip;
                        this.O0000O0o += skip;
                    } else {
                        throw d.O000000o();
                    }
                }
                return;
            }
            O00000o((i5 - i2) - i3);
            throw d.O000000o();
        }
        throw d.O00000Oo();
    }

    private byte[] O00000o0(int i) {
        if (i >= 0) {
            int i2 = this.O0000O0o;
            int i3 = this.O00000o;
            int i4 = i2 + i3 + i;
            int i5 = this.O0000OOo;
            if (i4 <= i5) {
                int i6 = this.O00000Oo;
                if (i <= i6 - i3) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f15617O000000o, i3, bArr, 0, i);
                    this.O00000o += i;
                    return bArr;
                } else if (i < 4096) {
                    byte[] bArr2 = new byte[i];
                    int i7 = i6 - i3;
                    System.arraycopy(this.f15617O000000o, i3, bArr2, 0, i7);
                    this.O00000o = this.O00000Oo;
                    while (true) {
                        O000000o(true);
                        int i8 = i - i7;
                        int i9 = this.O00000Oo;
                        if (i8 > i9) {
                            System.arraycopy(this.f15617O000000o, 0, bArr2, i7, i9);
                            int i10 = this.O00000Oo;
                            i7 += i10;
                            this.O00000o = i10;
                        } else {
                            System.arraycopy(this.f15617O000000o, 0, bArr2, i7, i8);
                            this.O00000o = i8;
                            return bArr2;
                        }
                    }
                } else {
                    this.O0000O0o = i2 + i6;
                    this.O00000o = 0;
                    this.O00000Oo = 0;
                    int i11 = i6 - i3;
                    int i12 = i - i11;
                    Vector vector = new Vector();
                    while (i12 > 0) {
                        byte[] bArr3 = new byte[Math.min(i12, 4096)];
                        int i13 = 0;
                        while (i13 < bArr3.length) {
                            InputStream inputStream = this.O00000oO;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i13, bArr3.length - i13);
                            if (read != -1) {
                                this.O0000O0o += read;
                                i13 += read;
                            } else {
                                throw d.O000000o();
                            }
                        }
                        i12 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(this.f15617O000000o, i3, bArr4, 0, i11);
                    for (int i14 = 0; i14 < vector.size(); i14++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i14);
                        System.arraycopy(bArr5, 0, bArr4, i11, bArr5.length);
                        i11 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                O00000o((i5 - i2) - i3);
                throw d.O000000o();
            }
        } else {
            throw d.O00000Oo();
        }
    }

    private void O0000O0o() {
        this.O00000Oo += this.O00000o0;
        int i = this.O0000O0o;
        int i2 = this.O00000Oo;
        int i3 = i + i2;
        int i4 = this.O0000OOo;
        if (i3 > i4) {
            this.O00000o0 = i3 - i4;
            this.O00000Oo = i2 - this.O00000o0;
            return;
        }
        this.O00000o0 = 0;
    }

    private byte O0000OOo() {
        if (this.O00000o == this.O00000Oo) {
            O000000o(true);
        }
        byte[] bArr = this.f15617O000000o;
        int i = this.O00000o;
        this.O00000o = i + 1;
        return bArr[i];
    }

    public final void O000000o(int i) {
        if (this.O00000oo != i) {
            throw d.O00000oO();
        }
    }

    public final boolean O00000Oo() {
        return O00000oO() != 0;
    }

    public final elb O00000o() {
        int O00000oO2 = O00000oO();
        int i = this.O00000Oo;
        int i2 = this.O00000o;
        if (O00000oO2 > i - i2 || O00000oO2 <= 0) {
            return elb.O000000o(O00000o0(O00000oO2));
        }
        elb O000000o2 = elb.O000000o(this.f15617O000000o, i2, O00000oO2);
        this.O00000o += O00000oO2;
        return O000000o2;
    }

    public final String O00000o0() {
        int O00000oO2 = O00000oO();
        int i = this.O00000Oo;
        int i2 = this.O00000o;
        if (O00000oO2 > i - i2 || O00000oO2 <= 0) {
            return new String(O00000o0(O00000oO2), "UTF-8");
        }
        String str = new String(this.f15617O000000o, i2, O00000oO2, "UTF-8");
        this.O00000o += O00000oO2;
        return str;
    }

    public final int O00000oO() {
        int i;
        byte O0000OOo2 = O0000OOo();
        if (O0000OOo2 >= 0) {
            return O0000OOo2;
        }
        byte b = O0000OOo2 & Byte.MAX_VALUE;
        byte O0000OOo3 = O0000OOo();
        if (O0000OOo3 >= 0) {
            i = O0000OOo3 << 7;
        } else {
            b |= (O0000OOo3 & Byte.MAX_VALUE) << 7;
            byte O0000OOo4 = O0000OOo();
            if (O0000OOo4 >= 0) {
                i = O0000OOo4 << 14;
            } else {
                b |= (O0000OOo4 & Byte.MAX_VALUE) << 14;
                byte O0000OOo5 = O0000OOo();
                if (O0000OOo5 >= 0) {
                    i = O0000OOo5 << 21;
                } else {
                    byte b2 = b | ((O0000OOo5 & Byte.MAX_VALUE) << 21);
                    byte O0000OOo6 = O0000OOo();
                    byte b3 = b2 | (O0000OOo6 << 28);
                    if (O0000OOo6 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (O0000OOo() >= 0) {
                            return b3;
                        }
                    }
                    throw d.O00000o0();
                }
            }
        }
        return b | i;
    }

    public final long O00000oo() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte O0000OOo2 = O0000OOo();
            j |= ((long) (O0000OOo2 & Byte.MAX_VALUE)) << i;
            if ((O0000OOo2 & 128) == 0) {
                return j;
            }
        }
        throw d.O00000o0();
    }

    public final int O000000o() {
        if (this.O00000o == this.O00000Oo && !O000000o(false)) {
            this.O00000oo = 0;
            return 0;
        }
        this.O00000oo = O00000oO();
        int i = this.O00000oo;
        if (i != 0) {
            return i;
        }
        throw d.O00000o();
    }

    public final boolean O00000Oo(int i) {
        int O000000o2;
        int O000000o3 = epn.O000000o(i);
        if (O000000o3 == 0) {
            O00000oO();
            return true;
        } else if (O000000o3 == 1) {
            O0000OOo();
            O0000OOo();
            O0000OOo();
            O0000OOo();
            O0000OOo();
            O0000OOo();
            O0000OOo();
            O0000OOo();
            return true;
        } else if (O000000o3 == 2) {
            O00000o(O00000oO());
            return true;
        } else if (O000000o3 == 3) {
            do {
                O000000o2 = O000000o();
                if (O000000o2 == 0) {
                    break;
                }
            } while (O00000Oo(O000000o2));
            O000000o(epn.O000000o(epn.O00000Oo(i), 4));
            return true;
        } else if (O000000o3 == 4) {
            return false;
        } else {
            if (O000000o3 == 5) {
                O0000OOo();
                O0000OOo();
                O0000OOo();
                O0000OOo();
                return true;
            }
            throw d.O00000oo();
        }
    }

    public final void O000000o(eor eor) {
        int O00000oO2 = O00000oO();
        if (this.O0000Oo0 >= this.O0000Oo) {
            throw d.O0000O0o();
        } else if (O00000oO2 >= 0) {
            int i = O00000oO2 + this.O0000O0o + this.O00000o;
            int i2 = this.O0000OOo;
            if (i <= i2) {
                this.O0000OOo = i;
                O0000O0o();
                this.O0000Oo0++;
                eor.O000000o(this);
                O000000o(0);
                this.O0000Oo0--;
                this.O0000OOo = i2;
                O0000O0o();
                return;
            }
            throw d.O000000o();
        } else {
            throw d.O00000Oo();
        }
    }
}
