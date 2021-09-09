package _m_j;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class jau {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<ParcelUuid> f1714O000000o;
    public final String O00000Oo;
    private final int O00000o;
    public final byte[] O00000o0;
    private final SparseArray<byte[]> O00000oO;
    private final Map<ParcelUuid, byte[]> O00000oo;
    private final int O0000O0o;

    public final byte[] O000000o(int i) {
        SparseArray<byte[]> sparseArray = this.O00000oO;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public final byte[] O000000o(ParcelUuid parcelUuid) {
        Map<ParcelUuid, byte[]> map;
        if (parcelUuid == null || (map = this.O00000oo) == null) {
            return null;
        }
        return map.get(parcelUuid);
    }

    private jau(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.f1714O000000o = list;
        this.O00000oO = sparseArray;
        this.O00000oo = map;
        this.O00000Oo = str;
        this.O00000o = i;
        this.O0000O0o = i2;
        this.O00000o0 = bArr;
    }

    public static jau O000000o(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = null;
        SparseArray sparseArray = null;
        String str = null;
        HashMap hashMap = null;
        byte b = -1;
        byte b2 = -2147483648;
        while (i < bArr2.length) {
            try {
                int i2 = i + 1;
                byte b3 = bArr2[i] & 255;
                if (b3 == 0) {
                    return new jau(arrayList, sparseArray, hashMap, b, b2, str, bArr);
                }
                int i3 = b3 - 1;
                int i4 = i2 + 1;
                byte b4 = bArr2[i2] & 255;
                if (b4 != 22) {
                    if (b4 == 255) {
                        int i5 = ((bArr2[i4 + 1] & 255) << 8) + (255 & bArr2[i4]);
                        byte[] O000000o2 = O000000o(bArr2, i4 + 2, i3 - 2);
                        if (sparseArray == null) {
                            sparseArray = new SparseArray();
                        }
                        sparseArray.put(i5, O000000o2);
                    } else if (!(b4 == 32 || b4 == 33)) {
                        switch (b4) {
                            case 1:
                                b = bArr2[i4] & 255;
                                continue;
                            case 2:
                            case 3:
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                O000000o(bArr2, i4, i3, 2, arrayList);
                                continue;
                            case 4:
                            case 5:
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                O000000o(bArr2, i4, i3, 4, arrayList);
                                continue;
                            case 6:
                            case 7:
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                O000000o(bArr2, i4, i3, 16, arrayList);
                                continue;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            case 9:
                                str = new String(O000000o(bArr2, i4, i3));
                                continue;
                            case 10:
                                b2 = bArr2[i4];
                                continue;
                            default:
                                continue;
                        }
                    }
                    i = i3 + i4;
                }
                int i6 = 4;
                if (b4 != 32) {
                    i6 = b4 == 33 ? 16 : 2;
                }
                ParcelUuid O000000o3 = jaq.O000000o(O000000o(bArr2, i4, i6));
                byte[] O000000o4 = O000000o(bArr2, i4 + i6, i3 - i6);
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(O000000o3, O000000o4);
                i = i3 + i4;
            } catch (Exception unused) {
                Log.e("ScanRecord", "unable to parse scan record: " + Arrays.toString(bArr));
                return new jau(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        return new jau(arrayList, sparseArray, hashMap, b, b2, str, bArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.O00000o0, ((jau) obj).O00000o0);
    }

    public final String toString() {
        return "ScanRecord [advertiseFlags=" + this.O00000o + ", serviceUuids=" + this.f1714O000000o + ", manufacturerSpecificData=" + jap.O000000o(this.O00000oO) + ", serviceData=" + jap.O000000o(this.O00000oo) + ", txPowerLevel=" + this.O0000O0o + ", deviceName=" + this.O00000Oo + "]";
    }

    private static int O000000o(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(jaq.O000000o(O000000o(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
