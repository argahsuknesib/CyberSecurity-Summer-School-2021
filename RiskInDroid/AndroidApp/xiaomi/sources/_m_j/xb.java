package _m_j;

import com.drew.imaging.tiff.TiffProcessingException;
import com.drew.lang.Rational;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class xb {
    private static int O000000o(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public static void O000000o(xj xjVar, xa xaVar, int i) throws TiffProcessingException, IOException {
        short O00000oo = xjVar.O00000oo(i);
        if (O00000oo == 19789) {
            xjVar.f2594O000000o = true;
        } else if (O00000oo == 18761) {
            xjVar.f2594O000000o = false;
        } else {
            throw new TiffProcessingException("Unclear distinction between Motorola/Intel byte ordering: ".concat(String.valueOf((int) O00000oo)));
        }
        int i2 = i + 2;
        xaVar.O000000o(xjVar.O00000oO(i2));
        int O0000Oo0 = xjVar.O0000Oo0(i + 4) + i;
        if (((long) O0000Oo0) >= xjVar.O000000o() - 1) {
            xaVar.O000000o("First IFD offset is beyond the end of the TIFF data segment -- trying default offset");
            O0000Oo0 = i2 + 2 + 4;
        }
        O000000o(xaVar, xjVar, new HashSet(), O0000Oo0, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0112 A[SYNTHETIC, Splitter:B:60:0x0112] */
    public static void O000000o(xa xaVar, xj xjVar, Set<Integer> set, int i, int i2) throws IOException {
        Boolean bool;
        int i3;
        int i4;
        long j;
        long j2;
        boolean z;
        xa xaVar2 = xaVar;
        xj xjVar2 = xjVar;
        Set<Integer> set2 = set;
        int i5 = i;
        int i6 = i2;
        Boolean bool2 = null;
        try {
            if (set2.contains(Integer.valueOf(i))) {
                xaVar.O00000Oo();
                return;
            }
            set2.add(Integer.valueOf(i));
            if (((long) i5) < xjVar.O000000o()) {
                if (i5 >= 0) {
                    int O00000oO = xjVar2.O00000oO(i5);
                    if (O00000oO > 255 && (O00000oO & 255) == 0) {
                        bool2 = Boolean.valueOf(xjVar2.f2594O000000o);
                        O00000oO >>= 8;
                        xjVar2.f2594O000000o = !xjVar2.f2594O000000o;
                    }
                    Boolean bool3 = bool2;
                    int i7 = O00000oO;
                    int i8 = 2;
                    try {
                        if (((long) ((i7 * 12) + 2 + 4 + i5)) > xjVar.O000000o()) {
                            xaVar2.O00000Oo("Illegally sized IFD");
                            xaVar.O00000Oo();
                            if (bool3 != null) {
                                xjVar2.f2594O000000o = bool3.booleanValue();
                                return;
                            }
                            return;
                        }
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < i7) {
                            int O000000o2 = O000000o(i5, i9);
                            int O00000oO2 = xjVar2.O00000oO(O000000o2);
                            int O00000oO3 = xjVar2.O00000oO(O000000o2 + 2);
                            wz O000000o3 = wz.O000000o(O00000oO3);
                            long O0000OOo = xjVar2.O0000OOo(O000000o2 + 4);
                            if (O000000o3 == null) {
                                Long O000000o4 = xaVar2.O000000o(O00000oO3, O0000OOo);
                                if (O000000o4 == null) {
                                    Object[] objArr = new Object[i8];
                                    objArr[0] = Integer.valueOf(O00000oO3);
                                    objArr[1] = Integer.valueOf(O00000oO2);
                                    xaVar2.O00000Oo(String.format("Invalid TIFF tag format code %d for tag 0x%04X", objArr));
                                    int i11 = i10 + 1;
                                    if (i11 > 5) {
                                        xaVar2.O00000Oo("Stopping processing as too many errors seen in TIFF IFD");
                                        xaVar.O00000Oo();
                                        if (bool3 != null) {
                                            xjVar2.f2594O000000o = bool3.booleanValue();
                                            return;
                                        }
                                        return;
                                    }
                                    i10 = i11;
                                } else {
                                    j = O000000o4.longValue();
                                    if (j <= 4) {
                                        long O0000OOo2 = xjVar2.O0000OOo(O000000o2 + 8);
                                        if (O0000OOo2 + j > xjVar.O000000o()) {
                                            xaVar2.O00000Oo("Illegal TIFF tag pointer offset");
                                        } else {
                                            i3 = i7;
                                            bool = bool3;
                                            j2 = ((long) i6) + O0000OOo2;
                                        }
                                    } else {
                                        i3 = i7;
                                        bool = bool3;
                                        j2 = (long) (O000000o2 + 8);
                                    }
                                    if (j2 >= 0) {
                                        try {
                                            if (j2 <= xjVar.O000000o()) {
                                                if (j >= 0) {
                                                    if (j2 + j <= xjVar.O000000o()) {
                                                        if (j == 4 * O0000OOo) {
                                                            i4 = i9;
                                                            z = false;
                                                            for (int i12 = 0; ((long) i12) < O0000OOo; i12++) {
                                                                if (xaVar2.O00000Oo(O00000oO2)) {
                                                                    O000000o(xaVar2, xjVar2, set2, xjVar2.O0000Oo0((int) (((long) (i12 * 4)) + j2)) + i6, i6);
                                                                    z = true;
                                                                }
                                                            }
                                                        } else {
                                                            i4 = i9;
                                                            z = false;
                                                        }
                                                        if (!z) {
                                                            int i13 = (int) j2;
                                                            int i14 = O00000oO3;
                                                            int i15 = O00000oO2;
                                                            if (!xaVar.O000000o(i13, set, i2, xjVar, i15, (int) j)) {
                                                                O000000o(xaVar, i15, i13, (int) O0000OOo, i14, xjVar);
                                                            }
                                                            i9 = i4 + 1;
                                                            i7 = i3;
                                                            bool3 = bool;
                                                            i8 = 2;
                                                        }
                                                        i9 = i4 + 1;
                                                        i7 = i3;
                                                        bool3 = bool;
                                                        i8 = 2;
                                                    }
                                                }
                                                i4 = i9;
                                                xaVar2.O00000Oo("Illegal number of bytes for TIFF tag data: ".concat(String.valueOf(j)));
                                                i9 = i4 + 1;
                                                i7 = i3;
                                                bool3 = bool;
                                                i8 = 2;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            xaVar.O00000Oo();
                                            if (bool != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    i4 = i9;
                                    xaVar2.O00000Oo("Illegal TIFF tag pointer offset");
                                    i9 = i4 + 1;
                                    i7 = i3;
                                    bool3 = bool;
                                    i8 = 2;
                                }
                            } else {
                                j = ((long) O000000o3.O0000o00) * O0000OOo;
                                if (j <= 4) {
                                }
                                if (j2 >= 0) {
                                }
                                i4 = i9;
                                xaVar2.O00000Oo("Illegal TIFF tag pointer offset");
                                i9 = i4 + 1;
                                i7 = i3;
                                bool3 = bool;
                                i8 = 2;
                            }
                            i4 = i9;
                            i3 = i7;
                            bool = bool3;
                            i9 = i4 + 1;
                            i7 = i3;
                            bool3 = bool;
                            i8 = 2;
                        }
                        bool = bool3;
                        int O0000Oo0 = xjVar2.O0000Oo0(O000000o(i5, i7));
                        if (O0000Oo0 != 0) {
                            int i16 = O0000Oo0 + i6;
                            if (((long) i16) >= xjVar.O000000o()) {
                                xaVar.O00000Oo();
                                if (bool != null) {
                                    xjVar2.f2594O000000o = bool.booleanValue();
                                    return;
                                }
                                return;
                            } else if (i16 < i5) {
                                xaVar.O00000Oo();
                                if (bool != null) {
                                    xjVar2.f2594O000000o = bool.booleanValue();
                                    return;
                                }
                                return;
                            } else if (xaVar.O000000o()) {
                                O000000o(xaVar2, xjVar2, set2, i16, i6);
                            }
                        }
                        xaVar.O00000Oo();
                        if (bool != null) {
                            xjVar2.f2594O000000o = bool.booleanValue();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        bool = bool3;
                        xaVar.O00000Oo();
                        if (bool != null) {
                        }
                        throw th;
                    }
                }
            }
            xaVar2.O00000Oo("Ignored IFD marked to start outside data segment");
            xaVar.O00000Oo();
        } catch (Throwable th3) {
            th = th3;
            bool = null;
            xaVar.O00000Oo();
            if (bool != null) {
                xjVar2.f2594O000000o = bool.booleanValue();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xa.O000000o(int, int):void
     arg types: [int, short]
     candidates:
      _m_j.xa.O000000o(int, long):java.lang.Long
      _m_j.xa.O000000o(int, byte):void
      _m_j.xa.O000000o(int, double):void
      _m_j.xa.O000000o(int, float):void
      _m_j.xa.O000000o(int, _m_j.xv):void
      _m_j.xa.O000000o(int, com.drew.lang.Rational):void
      _m_j.xa.O000000o(int, short):void
      _m_j.xa.O000000o(int, byte[]):void
      _m_j.xa.O000000o(int, double[]):void
      _m_j.xa.O000000o(int, float[]):void
      _m_j.xa.O000000o(int, int[]):void
      _m_j.xa.O000000o(int, long[]):void
      _m_j.xa.O000000o(int, com.drew.lang.Rational[]):void
      _m_j.xa.O000000o(int, short[]):void
      _m_j.xa.O000000o(int, int):void */
    private static void O000000o(xa xaVar, int i, int i2, int i3, int i4, xj xjVar) throws IOException {
        int i5 = 0;
        switch (i4) {
            case 1:
                if (i3 == 1) {
                    xaVar.O000000o(i, xjVar.O00000o0(i2));
                    return;
                }
                short[] sArr = new short[i3];
                while (i5 < i3) {
                    sArr[i5] = xjVar.O00000o0(i2 + i5);
                    i5++;
                }
                xaVar.O000000o(i, sArr);
                return;
            case 2:
                xaVar.O000000o(i, new xv(xjVar.O00000o(i2, i3), null));
                return;
            case 3:
                if (i3 == 1) {
                    xaVar.O00000Oo(i, xjVar.O00000oO(i2));
                    return;
                }
                int[] iArr = new int[i3];
                while (i5 < i3) {
                    iArr[i5] = xjVar.O00000oO((i5 * 2) + i2);
                    i5++;
                }
                xaVar.O000000o(i, iArr);
                return;
            case 4:
                if (i3 == 1) {
                    xaVar.O00000Oo(i, xjVar.O0000OOo(i2));
                    return;
                }
                long[] jArr = new long[i3];
                while (i5 < i3) {
                    jArr[i5] = xjVar.O0000OOo((i5 * 4) + i2);
                    i5++;
                }
                xaVar.O000000o(i, jArr);
                return;
            case 5:
                if (i3 == 1) {
                    xaVar.O000000o(i, new Rational(xjVar.O0000OOo(i2), xjVar.O0000OOo(i2 + 4)));
                    return;
                } else if (i3 > 1) {
                    Rational[] rationalArr = new Rational[i3];
                    while (i5 < i3) {
                        int i6 = i5 * 8;
                        rationalArr[i5] = new Rational(xjVar.O0000OOo(i2 + i6), xjVar.O0000OOo(i2 + 4 + i6));
                        i5++;
                    }
                    xaVar.O000000o(i, rationalArr);
                    return;
                } else {
                    return;
                }
            case 6:
                if (i3 == 1) {
                    xaVar.O000000o(i, xjVar.O00000o(i2));
                    return;
                }
                byte[] bArr = new byte[i3];
                while (i5 < i3) {
                    bArr[i5] = xjVar.O00000o(i2 + i5);
                    i5++;
                }
                xaVar.O00000Oo(i, bArr);
                return;
            case 7:
                xaVar.O000000o(i, xjVar.O00000o0(i2, i3));
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                if (i3 == 1) {
                    xaVar.O000000o(i, (int) xjVar.O00000oo(i2));
                    return;
                }
                short[] sArr2 = new short[i3];
                while (i5 < i3) {
                    sArr2[i5] = xjVar.O00000oo((i5 * 2) + i2);
                    i5++;
                }
                xaVar.O00000Oo(i, sArr2);
                return;
            case 9:
                if (i3 == 1) {
                    xaVar.O00000o0(i, xjVar.O0000Oo0(i2));
                    return;
                }
                int[] iArr2 = new int[i3];
                while (i5 < i3) {
                    iArr2[i5] = xjVar.O0000Oo0((i5 * 4) + i2);
                    i5++;
                }
                xaVar.O00000Oo(i, iArr2);
                return;
            case 10:
                if (i3 == 1) {
                    xaVar.O000000o(i, new Rational((long) xjVar.O0000Oo0(i2), (long) xjVar.O0000Oo0(i2 + 4)));
                    return;
                } else if (i3 > 1) {
                    Rational[] rationalArr2 = new Rational[i3];
                    while (i5 < i3) {
                        int i7 = i5 * 8;
                        rationalArr2[i5] = new Rational((long) xjVar.O0000Oo0(i2 + i7), (long) xjVar.O0000Oo0(i2 + 4 + i7));
                        i5++;
                    }
                    xaVar.O000000o(i, rationalArr2);
                    return;
                } else {
                    return;
                }
            case 11:
                if (i3 == 1) {
                    xaVar.O000000o(i, xjVar.O0000Ooo(i2));
                    return;
                }
                float[] fArr = new float[i3];
                while (i5 < i3) {
                    fArr[i5] = xjVar.O0000Ooo((i5 * 4) + i2);
                    i5++;
                }
                xaVar.O000000o(i, fArr);
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                if (i3 == 1) {
                    xaVar.O000000o(i, xjVar.O0000o00(i2));
                    return;
                }
                double[] dArr = new double[i3];
                while (i5 < i3) {
                    dArr[i5] = xjVar.O0000o00((i5 * 4) + i2);
                    i5++;
                }
                xaVar.O000000o(i, dArr);
                return;
            default:
                xaVar.O00000Oo(String.format("Invalid TIFF tag format code %d for tag 0x%04X", Integer.valueOf(i4), Integer.valueOf(i)));
                return;
        }
    }
}
