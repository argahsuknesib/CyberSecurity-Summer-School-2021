package _m_j;

import com.google.android.exoplayer2.C;
import com.tencent.bugly.proguard.g;
import com.tencent.bugly.proguard.k;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class dhq {

    /* renamed from: O000000o  reason: collision with root package name */
    String f14643O000000o = "GBK";
    private ByteBuffer O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public byte f14644O000000o;
        public int O00000Oo;
    }

    public dhq() {
    }

    public dhq(byte[] bArr) {
        this.O00000Oo = ByteBuffer.wrap(bArr);
    }

    public dhq(byte[] bArr, byte b) {
        this.O00000Oo = ByteBuffer.wrap(bArr);
        this.O00000Oo.position(4);
    }

    public final void O000000o(byte[] bArr) {
        ByteBuffer byteBuffer = this.O00000Oo;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.O00000Oo = ByteBuffer.wrap(bArr);
    }

    private static int O000000o(O000000o o000000o, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        o000000o.f14644O000000o = (byte) (b & 15);
        o000000o.O00000Oo = (b & 240) >> 4;
        if (o000000o.O00000Oo != 15) {
            return 1;
        }
        o000000o.O00000Oo = byteBuffer.get();
        return 2;
    }

    private boolean O000000o(int i) {
        try {
            O000000o o000000o = new O000000o();
            while (true) {
                int O000000o2 = O000000o(o000000o, this.O00000Oo.duplicate());
                if (i <= o000000o.O00000Oo) {
                    break;
                } else if (o000000o.f14644O000000o == 11) {
                    break;
                } else {
                    this.O00000Oo.position(this.O00000Oo.position() + O000000o2);
                    O000000o(o000000o.f14644O000000o);
                }
            }
            if (i == o000000o.O00000Oo) {
                return true;
            }
            return false;
        } catch (g | BufferUnderflowException unused) {
        }
    }

    private void O000000o() {
        O000000o o000000o = new O000000o();
        do {
            O000000o(o000000o, this.O00000Oo);
            O000000o(o000000o.f14644O000000o);
        } while (o000000o.f14644O000000o != 11);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    private void O000000o(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                ByteBuffer byteBuffer = this.O00000Oo;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.O00000Oo;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.O00000Oo;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.O00000Oo;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.O00000Oo;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.O00000Oo;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.O00000Oo.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                ByteBuffer byteBuffer7 = this.O00000Oo;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.O00000Oo.getInt();
                ByteBuffer byteBuffer8 = this.O00000Oo;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                int O000000o2 = O000000o(0, 0, true);
                while (i < (O000000o2 << 1)) {
                    O000000o o000000o = new O000000o();
                    O000000o(o000000o, this.O00000Oo);
                    O000000o(o000000o.f14644O000000o);
                    i++;
                }
                return;
            case 9:
                int O000000o3 = O000000o(0, 0, true);
                while (i < O000000o3) {
                    O000000o o000000o2 = new O000000o();
                    O000000o(o000000o2, this.O00000Oo);
                    O000000o(o000000o2.f14644O000000o);
                    i++;
                }
                return;
            case 10:
                O000000o();
                return;
            case 11:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return;
            case 13:
                O000000o o000000o3 = new O000000o();
                O000000o(o000000o3, this.O00000Oo);
                if (o000000o3.f14644O000000o == 0) {
                    int O000000o4 = O000000o(0, 0, true);
                    ByteBuffer byteBuffer9 = this.O00000Oo;
                    byteBuffer9.position(byteBuffer9.position() + O000000o4);
                    return;
                }
                throw new g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) o000000o3.f14644O000000o));
            default:
                throw new g("invalid type.");
        }
    }

    public final boolean O000000o(int i, boolean z) {
        return O000000o((byte) 0, i, z) != 0;
    }

    public final byte O000000o(byte b, int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b2 = o000000o.f14644O000000o;
            if (b2 == 0) {
                return this.O00000Oo.get();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return b;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final short O000000o(short s, int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 0) {
                return (short) this.O00000Oo.get();
            }
            if (b == 1) {
                return this.O00000Oo.getShort();
            }
            if (b == 12) {
                return 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final int O000000o(int i, int i2, boolean z) {
        if (O000000o(i2)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 0) {
                return this.O00000Oo.get();
            }
            if (b == 1) {
                return this.O00000Oo.getShort();
            }
            if (b == 2) {
                return this.O00000Oo.getInt();
            }
            if (b == 12) {
                return 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final long O000000o(long j, int i, boolean z) {
        int i2;
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 0) {
                i2 = this.O00000Oo.get();
            } else if (b == 1) {
                i2 = this.O00000Oo.getShort();
            } else if (b == 2) {
                i2 = this.O00000Oo.getInt();
            } else if (b == 3) {
                return this.O00000Oo.getLong();
            } else {
                if (b == 12) {
                    return 0;
                }
                throw new g("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new g("require field not exist.");
        }
    }

    private float O000000o(float f, int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 4) {
                return this.O00000Oo.getFloat();
            }
            if (b == 12) {
                return 0.0f;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new g("require field not exist.");
        }
    }

    private double O000000o(double d, int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 4) {
                return (double) this.O00000Oo.getFloat();
            }
            if (b == 5) {
                return this.O00000Oo.getDouble();
            }
            if (b == 12) {
                return 0.0d;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return d;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final String O00000Oo(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 6) {
                int i2 = this.O00000Oo.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.O00000Oo.get(bArr);
                try {
                    return new String(bArr, this.f14643O000000o);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b == 7) {
                int i3 = this.O00000Oo.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new g("String too long: ".concat(String.valueOf(i3)));
                }
                byte[] bArr2 = new byte[i3];
                this.O00000Oo.get(bArr2);
                try {
                    return new String(bArr2, this.f14643O000000o);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final <K, V> HashMap<K, V> O000000o(Map<K, V> map) {
        return (HashMap) O000000o(new HashMap(), map, 0, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
     arg types: [java.lang.Object, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object */
    private <K, V> Map<K, V> O000000o(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry next = map2.entrySet().iterator().next();
        Object key = next.getKey();
        Object value = next.getValue();
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 8) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        map.put(O000000o(key, 0, true), O000000o(value, 1, true));
                    }
                } else {
                    throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
                }
            } else {
                throw new g("type mismatch.");
            }
        } else if (z) {
            throw new g("require field not exist.");
        }
        return map;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    private boolean[] O00000o(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    boolean[] zArr = new boolean[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        zArr[i2] = O000000o((byte) 0, 0, true) != 0;
                    }
                    return zArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(byte, int, boolean):byte
     arg types: [byte, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(byte, int, boolean):byte */
    public final byte[] O00000o0(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            byte b = o000000o.f14644O000000o;
            if (b == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    byte[] bArr = new byte[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        bArr[i2] = O000000o(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            } else if (b == 13) {
                O000000o o000000o2 = new O000000o();
                O000000o(o000000o2, this.O00000Oo);
                if (o000000o2.f14644O000000o == 0) {
                    int O000000o3 = O000000o(0, 0, true);
                    if (O000000o3 >= 0) {
                        byte[] bArr2 = new byte[O000000o3];
                        this.O00000Oo.get(bArr2);
                        return bArr2;
                    }
                    throw new g("invalid size, tag: " + i + ", type: " + ((int) o000000o.f14644O000000o) + ", " + ((int) o000000o2.f14644O000000o) + ", size: " + O000000o3);
                }
                throw new g("type mismatch, tag: " + i + ", type: " + ((int) o000000o.f14644O000000o) + ", " + ((int) o000000o2.f14644O000000o));
            } else {
                throw new g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(short, int, boolean):short
     arg types: [short, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short */
    private short[] O00000oO(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    short[] sArr = new short[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        sArr[i2] = O000000o(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    private int[] O00000oo(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    int[] iArr = new int[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        iArr[i2] = O000000o(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(long, int, boolean):long
     arg types: [long, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(long, int, boolean):long */
    private long[] O0000O0o(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    long[] jArr = new long[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        jArr[i2] = O000000o(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(float, int, boolean):float
     arg types: [float, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(float, int, boolean):float */
    private float[] O0000OOo(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    float[] fArr = new float[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        fArr[i2] = O000000o(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(double, int, boolean):double
     arg types: [double, int, int]
     candidates:
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(double, int, boolean):double */
    private double[] O0000Oo0(int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    double[] dArr = new double[O000000o2];
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        dArr[i2] = O000000o(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private <T> T[] O000000o(Object[] objArr, int i, boolean z) {
        if (objArr != null && objArr.length != 0) {
            return O00000Oo(objArr[0], i, z);
        }
        throw new g("unable to get type of key and value.");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(int, int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
     arg types: [T, int, int]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object */
    private <T> T[] O00000Oo(T t, int i, boolean z) {
        if (O000000o(i)) {
            O000000o o000000o = new O000000o();
            O000000o(o000000o, this.O00000Oo);
            if (o000000o.f14644O000000o == 9) {
                int O000000o2 = O000000o(0, 0, true);
                if (O000000o2 >= 0) {
                    T[] tArr = (Object[]) Array.newInstance(t.getClass(), O000000o2);
                    for (int i2 = 0; i2 < O000000o2; i2++) {
                        tArr[i2] = O000000o((Object) t, 0, true);
                    }
                    return tArr;
                }
                throw new g("size invalid: ".concat(String.valueOf(O000000o2)));
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final k O000000o(k kVar, int i, boolean z) {
        if (O000000o(i)) {
            try {
                k kVar2 = (k) kVar.getClass().newInstance();
                O000000o o000000o = new O000000o();
                O000000o(o000000o, this.O00000Oo);
                if (o000000o.f14644O000000o == 10) {
                    kVar2.O000000o(this);
                    O000000o();
                    return kVar2;
                }
                throw new g("type mismatch.");
            } catch (Exception e) {
                throw new g(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(short, int, boolean):short
     arg types: [int, int, boolean]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(long, int, boolean):long
     arg types: [int, int, boolean]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(long, int, boolean):long */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(float, int, boolean):float
     arg types: [int, int, boolean]
     candidates:
      _m_j.dhq.O000000o(double, int, boolean):double
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(float, int, boolean):float */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dhq.O000000o(double, int, boolean):double
     arg types: [int, int, boolean]
     candidates:
      _m_j.dhq.O000000o(float, int, boolean):float
      _m_j.dhq.O000000o(java.lang.Object[], int, boolean):T[]
      _m_j.dhq.O000000o(byte, int, boolean):byte
      _m_j.dhq.O000000o(int, int, boolean):int
      _m_j.dhq.O000000o(long, int, boolean):long
      _m_j.dhq.O000000o(com.tencent.bugly.proguard.k, int, boolean):com.tencent.bugly.proguard.k
      _m_j.dhq.O000000o(java.lang.Object, int, boolean):java.lang.Object
      _m_j.dhq.O000000o(short, int, boolean):short
      _m_j.dhq.O000000o(double, int, boolean):double */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <T> Object O000000o(Object obj, int i, boolean z) {
        ? r1 = 0;
        if (obj instanceof Byte) {
            return Byte.valueOf(O000000o((byte) 0, i, z));
        }
        if (obj instanceof Boolean) {
            if (O000000o((byte) 0, i, z) != 0) {
                r1 = 1;
            }
            return Boolean.valueOf((boolean) r1);
        } else if (obj instanceof Short) {
            return Short.valueOf(O000000o((short) 0, i, z));
        } else {
            if (obj instanceof Integer) {
                return Integer.valueOf(O000000o(0, i, z));
            }
            if (obj instanceof Long) {
                return Long.valueOf(O000000o(0L, i, z));
            }
            if (obj instanceof Float) {
                return Float.valueOf(O000000o(0.0f, i, z));
            }
            if (obj instanceof Double) {
                return Double.valueOf(O000000o(0.0d, i, z));
            }
            if (obj instanceof String) {
                return String.valueOf(O00000Oo(i, z));
            }
            if (obj instanceof Map) {
                return (HashMap) O000000o(new HashMap(), (Map) obj, i, z);
            } else if (obj instanceof List) {
                List list = (List) obj;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] O00000Oo2 = O00000Oo(list.get(0), i, z);
                if (O00000Oo2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (r1 < O00000Oo2.length) {
                    arrayList.add(O00000Oo2[r1]);
                    r1++;
                }
                return arrayList;
            } else if (obj instanceof k) {
                return O000000o((k) obj, i, z);
            } else {
                if (!obj.getClass().isArray()) {
                    throw new g("read object error: unsupport type.");
                } else if ((obj instanceof byte[]) || (obj instanceof Byte[])) {
                    return O00000o0(i, z);
                } else {
                    if (obj instanceof boolean[]) {
                        return O00000o(i, z);
                    }
                    if (obj instanceof short[]) {
                        return O00000oO(i, z);
                    }
                    if (obj instanceof int[]) {
                        return O00000oo(i, z);
                    }
                    if (obj instanceof long[]) {
                        return O0000O0o(i, z);
                    }
                    if (obj instanceof float[]) {
                        return O0000OOo(i, z);
                    }
                    if (obj instanceof double[]) {
                        return O0000Oo0(i, z);
                    }
                    return O000000o((Object[]) obj, i, z);
                }
            }
        }
    }
}
