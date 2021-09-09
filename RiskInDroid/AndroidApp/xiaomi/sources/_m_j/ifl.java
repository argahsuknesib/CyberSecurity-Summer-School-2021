package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ifl extends ifc {
    private static final int[] O0000O0o = {7, 5, 4, 3, 1};
    private static final int[] O0000OOo = {4, 20, 52, 104, 204};
    private static final int[][] O0000Oo = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[] O0000Oo0 = {0, 348, 1388, 2948, 3988};
    private static final int[][] O0000OoO = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, NotificationCompat.FLAG_HIGH_PRIORITY, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] O0000Ooo = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<ifk> O0000o0 = new ArrayList();
    private final List<ifj> O0000o00 = new ArrayList(11);
    private final int[] O0000o0O = new int[2];
    private boolean O0000o0o;

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.O0000o00.clear();
        this.O0000o0o = false;
        try {
            return O000000o(O000000o(i, idl));
        } catch (NotFoundException unused) {
            this.O0000o00.clear();
            this.O0000o0o = true;
            return O000000o(O000000o(i, idl));
        }
    }

    public final void O000000o() {
        this.O0000o00.clear();
        this.O0000o0.clear();
    }

    private List<ifj> O000000o(int i, idl idl) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        while (true) {
            try {
                this.O0000o00.add(O000000o(idl, this.O0000o00, i));
            } catch (NotFoundException e) {
                if (this.O0000o00.isEmpty()) {
                    throw e;
                } else if (O00000Oo()) {
                    return this.O0000o00;
                } else {
                    boolean z7 = !this.O0000o0.isEmpty();
                    int i2 = 0;
                    boolean z8 = false;
                    while (true) {
                        if (i2 >= this.O0000o0.size()) {
                            z = false;
                            break;
                        }
                        ifk ifk = this.O0000o0.get(i2);
                        if (ifk.O00000Oo > i) {
                            z = ifk.O000000o(this.O0000o00);
                            break;
                        }
                        z8 = ifk.O000000o(this.O0000o00);
                        i2++;
                    }
                    if (!z && !z8) {
                        List<ifj> list = this.O0000o00;
                        Iterator<T> it = this.O0000o0.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            ifk ifk2 = (ifk) it.next();
                            Iterator<T> it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z5 = true;
                                    continue;
                                    break;
                                }
                                ifj ifj = (ifj) it2.next();
                                Iterator<ifj> it3 = ifk2.f1259O000000o.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        if (ifj.equals(it3.next())) {
                                            z6 = true;
                                            continue;
                                            break;
                                        }
                                    } else {
                                        z6 = false;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z6) {
                                    z5 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (z5) {
                                z2 = true;
                                break;
                            }
                        }
                        if (!z2) {
                            this.O0000o0.add(i2, new ifk(this.O0000o00, i, false));
                            List<ifj> list2 = this.O0000o00;
                            Iterator<ifk> it4 = this.O0000o0.iterator();
                            while (it4.hasNext()) {
                                ifk next = it4.next();
                                if (next.f1259O000000o.size() != list2.size()) {
                                    Iterator<ifj> it5 = next.f1259O000000o.iterator();
                                    while (true) {
                                        if (!it5.hasNext()) {
                                            z3 = true;
                                            break;
                                        }
                                        ifj next2 = it5.next();
                                        Iterator<ifj> it6 = list2.iterator();
                                        while (true) {
                                            if (it6.hasNext()) {
                                                if (next2.equals(it6.next())) {
                                                    z4 = true;
                                                    continue;
                                                    break;
                                                }
                                            } else {
                                                z4 = false;
                                                continue;
                                                break;
                                            }
                                        }
                                        if (!z4) {
                                            z3 = false;
                                            break;
                                        }
                                    }
                                    if (z3) {
                                        it4.remove();
                                    }
                                }
                            }
                        }
                    }
                    if (z7) {
                        List<ifj> O000000o2 = O000000o(false);
                        if (O000000o2 != null) {
                            return O000000o2;
                        }
                        List<ifj> O000000o3 = O000000o(true);
                        if (O000000o3 != null) {
                            return O000000o3;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    private List<ifj> O000000o(boolean z) {
        List<ifj> list = null;
        if (this.O0000o0.size() > 25) {
            this.O0000o0.clear();
            return null;
        }
        this.O0000o00.clear();
        if (z) {
            Collections.reverse(this.O0000o0);
        }
        try {
            list = O000000o(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.O0000o0);
        }
        return list;
    }

    private List<ifj> O000000o(List<ifk> list, int i) throws NotFoundException {
        boolean z;
        while (i < this.O0000o0.size()) {
            ifk ifk = this.O0000o0.get(i);
            this.O0000o00.clear();
            for (ifk ifk2 : list) {
                this.O0000o00.addAll(ifk2.f1259O000000o);
            }
            this.O0000o00.addAll(ifk.f1259O000000o);
            List<ifj> list2 = this.O0000o00;
            int[][] iArr = O0000Ooo;
            int length = iArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i2];
                if (list2.size() <= iArr2.length) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list2.size()) {
                            z = true;
                            break;
                        } else if (list2.get(i3).O00000o0.f1257O000000o != iArr2[i3]) {
                            z = false;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
                i2++;
            }
            if (!z2) {
                i++;
            } else if (O00000Oo()) {
                return this.O0000o00;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(ifk);
                try {
                    return O000000o(arrayList, i + 1);
                } catch (NotFoundException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static idf O000000o(List<ifj> list) throws NotFoundException, FormatException {
        String O000000o2 = ifv.O000000o(ifi.O000000o(list)).O000000o();
        idg[] idgArr = list.get(0).O00000o0.O00000o0;
        idg[] idgArr2 = list.get(list.size() - 1).O00000o0.O00000o0;
        return new idf(O000000o2, null, new idg[]{idgArr[0], idgArr[1], idgArr2[0], idgArr2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean O00000Oo() {
        ifj ifj = this.O0000o00.get(0);
        ifd ifd = ifj.f1258O000000o;
        ifd ifd2 = ifj.O00000Oo;
        if (ifd2 == null) {
            return false;
        }
        int i = ifd2.O00000Oo;
        int i2 = 2;
        for (int i3 = 1; i3 < this.O0000o00.size(); i3++) {
            ifj ifj2 = this.O0000o00.get(i3);
            i += ifj2.f1258O000000o.O00000Oo;
            i2++;
            ifd ifd3 = ifj2.O00000Oo;
            if (ifd3 != null) {
                i += ifd3.O00000Oo;
                i2++;
            }
        }
        if (((i2 - 4) * 211) + (i % 211) == ifd.f1256O000000o) {
            return true;
        }
        return false;
    }

    private ifj O000000o(idl idl, List<ifj> list, int i) throws NotFoundException {
        ife O000000o2;
        ifd ifd;
        idl idl2 = idl;
        List<ifj> list2 = list;
        boolean z = true;
        boolean z2 = list.size() % 2 == 0;
        if (this.O0000o0o) {
            z2 = !z2;
        }
        int i2 = -1;
        boolean z3 = true;
        do {
            int[] iArr = this.f1255O000000o;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i3 = idl2.O00000Oo;
            int i4 = i2 >= 0 ? i2 : list.isEmpty() ? 0 : list2.get(list.size() - 1).O00000o0.O00000Oo[1];
            boolean z4 = list.size() % 2 != 0;
            if (this.O0000o0o) {
                z4 = !z4;
            }
            boolean z5 = false;
            while (i4 < i3) {
                z5 = !idl2.O000000o(i4);
                if (!z5) {
                    break;
                }
                i4++;
            }
            int i5 = i4;
            int i6 = 0;
            while (i4 < i3) {
                if (idl2.O000000o(i4) ^ z5) {
                    iArr[i6] = iArr[i6] + 1;
                } else {
                    if (i6 == 3) {
                        if (z4) {
                            O00000Oo(iArr);
                        }
                        if (O000000o(iArr)) {
                            int[] iArr2 = this.O0000o0O;
                            iArr2[0] = i5;
                            iArr2[1] = i4;
                            O000000o2 = O000000o(idl2, i, z2);
                            if (O000000o2 == null) {
                                int i7 = this.O0000o0O[0];
                                if (idl2.O000000o(i7)) {
                                    i2 = idl2.O00000o0(idl2.O00000o(i7));
                                    continue;
                                } else {
                                    i2 = idl2.O00000o(idl2.O00000o0(i7));
                                    continue;
                                }
                            } else {
                                z3 = false;
                                continue;
                            }
                        } else {
                            if (z4) {
                                O00000Oo(iArr);
                            }
                            i5 += iArr[0] + iArr[1];
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = 0;
                            iArr[3] = 0;
                            i6--;
                        }
                    } else {
                        i6++;
                    }
                    iArr[i6] = 1;
                    z5 = !z5;
                }
                i4++;
            }
            throw NotFoundException.getNotFoundInstance();
        } while (z3);
        ifd O000000o3 = O000000o(idl2, O000000o2, z2, true);
        if (!list.isEmpty()) {
            if (list2.get(list.size() - 1).O00000Oo != null) {
                z = false;
            }
            if (z) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        try {
            ifd = O000000o(idl2, O000000o2, z2, false);
        } catch (NotFoundException unused) {
            ifd = null;
        }
        return new ifj(O000000o3, ifd, O000000o2);
    }

    private static void O00000Oo(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private ife O000000o(idl idl, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.O0000o0O[0] - 1;
            while (i5 >= 0 && !idl.O000000o(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.O0000o0O;
            i3 = iArr[1];
            i4 = i6;
            i2 = iArr[0] - i6;
        } else {
            int[] iArr2 = this.O0000o0O;
            int i7 = iArr2[0];
            int O00000o = idl.O00000o(iArr2[1] + 1);
            i2 = O00000o - this.O0000o0O[1];
            i3 = O00000o;
            i4 = i7;
        }
        int[] iArr3 = this.f1255O000000o;
        System.arraycopy(iArr3, 0, iArr3, 1, iArr3.length - 1);
        iArr3[0] = i2;
        try {
            return new ife(O000000o(iArr3, O0000Oo), new int[]{i4, i3}, i4, i3, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private ifd O000000o(idl idl, ife ife, boolean z, boolean z2) throws NotFoundException {
        idl idl2 = idl;
        ife ife2 = ife;
        int[] iArr = this.O00000Oo;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
        if (z2) {
            O00000Oo(idl2, ife2.O00000Oo[0], iArr);
        } else {
            O000000o(idl2, ife2.O00000Oo[1], iArr);
            int i = 0;
            for (int length = iArr.length - 1; i < length; length--) {
                int i2 = iArr[i];
                iArr[i] = iArr[length];
                iArr[length] = i2;
                i++;
            }
        }
        float O000000o2 = ((float) idw.O000000o(iArr)) / 17.0f;
        float f = ((float) (ife2.O00000Oo[1] - ife2.O00000Oo[0])) / 15.0f;
        if (Math.abs(O000000o2 - f) / f <= 0.3f) {
            int[] iArr2 = this.O00000oO;
            int[] iArr3 = this.O00000oo;
            float[] fArr = this.O00000o0;
            float[] fArr2 = this.O00000o;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                float f2 = (((float) iArr[i3]) * 1.0f) / O000000o2;
                int i4 = (int) (0.5f + f2);
                if (i4 <= 0) {
                    if (f2 >= 0.3f) {
                        i4 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i4 > 8) {
                    if (f2 <= 8.7f) {
                        i4 = 8;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i5 = i3 / 2;
                if ((i3 & 1) == 0) {
                    iArr2[i5] = i4;
                    fArr[i5] = f2 - ((float) i4);
                } else {
                    iArr3[i5] = i4;
                    fArr2[i5] = f2 - ((float) i4);
                }
            }
            O00000o0();
            int i6 = (((ife2.f1257O000000o * 4) + (z ? 0 : 2)) + (z2 ^ true ? 1 : 0)) - 1;
            int i7 = 0;
            int i8 = 0;
            for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
                if (O000000o(ife, z, z2)) {
                    i7 += iArr2[length2] * O0000OoO[i6][length2 * 2];
                }
                i8 += iArr2[length2];
            }
            int i9 = 0;
            for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
                if (O000000o(ife, z, z2)) {
                    i9 += iArr3[length3] * O0000OoO[i6][(length3 * 2) + 1];
                }
            }
            int i10 = i7 + i9;
            if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i11 = (13 - i8) / 2;
            int i12 = O0000O0o[i11];
            return new ifd((ifh.O000000o(iArr2, i12, true) * O0000OOo[i11]) + ifh.O000000o(iArr3, 9 - i12, false) + O0000Oo0[i11], i10);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean O000000o(ife ife, boolean z, boolean z2) {
        return ife.f1257O000000o != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    private void O00000o0() throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        int O000000o2 = idw.O000000o(this.O00000oO);
        int O000000o3 = idw.O000000o(this.O00000oo);
        int i = (O000000o2 + O000000o3) - 17;
        boolean z4 = false;
        boolean z5 = (O000000o2 & 1) == 1;
        boolean z6 = (O000000o3 & 1) == 0;
        if (O000000o2 > 13) {
            z2 = false;
            z = true;
        } else {
            z2 = O000000o2 < 4;
            z = false;
        }
        if (O000000o3 > 13) {
            z3 = true;
        } else {
            if (O000000o3 < 4) {
                z4 = true;
            }
            z3 = false;
        }
        if (i != 1) {
            if (i == -1) {
                if (z5) {
                    if (z6) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (z6) {
                    z4 = true;
                    if (z2) {
                    }
                    if (z) {
                    }
                    if (z4) {
                    }
                    if (z3) {
                    }
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (i != 0) {
                throw NotFoundException.getNotFoundInstance();
            } else if (!z5) {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z2) {
                }
                if (z) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else if (!z6) {
                throw NotFoundException.getNotFoundInstance();
            } else if (O000000o2 < O000000o3) {
                z3 = true;
            } else {
                z4 = true;
            }
            z2 = true;
            if (z2) {
            }
            if (z) {
            }
            if (z4) {
            }
            if (z3) {
            }
        } else if (z5) {
            if (z6) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (z6) {
            z3 = true;
            if (z2) {
                if (!z) {
                    O000000o(this.O00000oO, this.O00000o0);
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z) {
                O00000Oo(this.O00000oO, this.O00000o0);
            }
            if (z4) {
                if (!z3) {
                    O000000o(this.O00000oo, this.O00000o0);
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z3) {
                O00000Oo(this.O00000oo, this.O00000o);
                return;
            }
            return;
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
        z = true;
        if (z2) {
        }
        if (z) {
        }
        if (z4) {
        }
        if (z3) {
        }
    }
}
