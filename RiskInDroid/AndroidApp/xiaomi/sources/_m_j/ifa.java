package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ReaderException;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

public abstract class ifa extends iev {
    static final int[] O00000Oo = {1, 1, 1};
    static final int[] O00000o = {1, 1, 1, 1, 1, 1};
    static final int[] O00000o0 = {1, 1, 1, 1, 1};
    static final int[][] O00000oO = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] O00000oo = new int[20][];

    /* renamed from: O000000o  reason: collision with root package name */
    private final StringBuilder f1253O000000o = new StringBuilder(20);
    private final iez O0000O0o = new iez();
    private final ier O0000OOo = new ier();

    /* access modifiers changed from: protected */
    public abstract int O000000o(idl idl, int[] iArr, StringBuilder sb) throws NotFoundException;

    /* access modifiers changed from: package-private */
    public abstract BarcodeFormat O00000Oo();

    static {
        System.arraycopy(O00000oO, 0, O00000oo, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = O00000oO[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            O00000oo[i] = iArr2;
        }
    }

    protected ifa() {
    }

    static int[] O000000o(idl idl) throws NotFoundException {
        int[] iArr = new int[O00000Oo.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            Arrays.fill(iArr, 0, O00000Oo.length, 0);
            iArr2 = O000000o(idl, i, false, O00000Oo, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = idl.O000000o(i4, i2);
            }
            i = i3;
        }
        return iArr2;
    }

    public idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return O000000o(i, idl, O000000o(idl), map);
    }

    public idf O000000o(int i, idl idl, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        idh idh;
        int i2;
        int[] iArr2;
        boolean z;
        String str = null;
        if (map == null) {
            idh = null;
        } else {
            idh = (idh) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        if (idh != null) {
            idh.O000000o(new idg(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder sb = this.f1253O000000o;
        sb.setLength(0);
        int O000000o2 = O000000o(idl, iArr, sb);
        if (idh != null) {
            idh.O000000o(new idg((float) O000000o2, (float) i));
        }
        int[] O000000o3 = O000000o(idl, O000000o2);
        if (idh != null) {
            idh.O000000o(new idg(((float) (O000000o3[0] + O000000o3[1])) / 2.0f, (float) i));
        }
        int i3 = O000000o3[1];
        int i4 = (i3 - O000000o3[0]) + i3;
        if (i4 >= idl.O00000Oo || !idl.O000000o(i3, i4)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw FormatException.getFormatInstance();
        } else if (O000000o(sb2)) {
            BarcodeFormat O00000Oo2 = O00000Oo();
            float f = (float) i;
            idf idf = new idf(sb2, null, new idg[]{new idg(((float) (iArr[1] + iArr[0])) / 2.0f, f), new idg(((float) (O000000o3[1] + O000000o3[0])) / 2.0f, f)}, O00000Oo2);
            try {
                idf O000000o4 = this.O0000O0o.O000000o(i, idl, O000000o3[1]);
                idf.O000000o(ResultMetadataType.UPC_EAN_EXTENSION, O000000o4.f1208O000000o);
                idf.O000000o(O000000o4.O00000oO);
                idg[] idgArr = O000000o4.O00000o0;
                idg[] idgArr2 = idf.O00000o0;
                if (idgArr2 == null) {
                    idf.O00000o0 = idgArr;
                } else if (idgArr != null && idgArr.length > 0) {
                    idg[] idgArr3 = new idg[(idgArr2.length + idgArr.length)];
                    System.arraycopy(idgArr2, 0, idgArr3, 0, idgArr2.length);
                    System.arraycopy(idgArr, 0, idgArr3, idgArr2.length, idgArr.length);
                    idf.O00000o0 = idgArr3;
                }
                i2 = O000000o4.f1208O000000o.length();
            } catch (ReaderException unused) {
                i2 = 0;
            }
            if (map == null) {
                iArr2 = null;
            } else {
                iArr2 = (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (i2 == iArr2[i5]) {
                        z = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (O00000Oo2 == BarcodeFormat.EAN_13 || O00000Oo2 == BarcodeFormat.UPC_A) {
                ier ier = this.O0000OOo;
                ier.O000000o();
                int parseInt = Integer.parseInt(sb2.substring(0, 3));
                int size = ier.f1244O000000o.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    }
                    int[] iArr3 = ier.f1244O000000o.get(i6);
                    int i7 = iArr3[0];
                    if (parseInt < i7) {
                        break;
                    }
                    if (iArr3.length != 1) {
                        i7 = iArr3[1];
                    }
                    if (parseInt <= i7) {
                        str = ier.O00000Oo.get(i6);
                        break;
                    }
                    i6++;
                }
                if (str != null) {
                    idf.O000000o(ResultMetadataType.POSSIBLE_COUNTRY, str);
                }
            }
            return idf;
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[]
     arg types: [_m_j.idl, int, int, int[]]
     candidates:
      _m_j.ifa.O000000o(_m_j.idl, int[], int, int[][]):int
      _m_j.ifa.O000000o(int, _m_j.idl, int[], java.util.Map<com.xiaomi.zxing.DecodeHintType, ?>):_m_j.idf
      _m_j.ifa.O000000o(_m_j.idl, int, boolean, int[]):int[] */
    /* access modifiers changed from: package-private */
    public int[] O000000o(idl idl, int i) throws NotFoundException {
        return O000000o(idl, i, false, O00000Oo);
    }

    static int[] O000000o(idl idl, int i, boolean z, int[] iArr) throws NotFoundException {
        return O000000o(idl, i, z, iArr, new int[iArr.length]);
    }

    private static int[] O000000o(idl idl, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int length = iArr.length;
        int i2 = idl.O00000Oo;
        int O00000o2 = z ? idl.O00000o(i) : idl.O00000o0(i);
        int i3 = O00000o2;
        int i4 = 0;
        while (O00000o2 < i2) {
            boolean z2 = true;
            if (idl.O000000o(O00000o2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else if (O000000o(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i3, O00000o2};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            O00000o2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int O000000o(idl idl, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        O000000o(idl, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float O000000o2 = O000000o(iArr, iArr2[i3], 0.7f);
            if (O000000o2 < f) {
                i2 = i3;
                f = O000000o2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* access modifiers changed from: package-private */
    public boolean O000000o(String str) throws FormatException {
        int length = str.length();
        if (length != 0) {
            int i = 0;
            for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
                int charAt = str.charAt(i2) - '0';
                if (charAt < 0 || charAt > 9) {
                    throw FormatException.getFormatInstance();
                }
                i += charAt;
            }
            int i3 = i * 3;
            for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
                int charAt2 = str.charAt(i4) - '0';
                if (charAt2 < 0 || charAt2 > 9) {
                    throw FormatException.getFormatInstance();
                }
                i3 += charAt2;
            }
            if (i3 % 10 == 0) {
                return true;
            }
        }
        return false;
    }
}
