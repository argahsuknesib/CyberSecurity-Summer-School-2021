package _m_j;

import android.os.Build;
import android.os.ParcelUuid;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class exp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ParcelUuid f15926O000000o = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public final SparseArray<byte[]> O00000Oo;
    private final List<ParcelUuid> O00000o;
    private final int O00000o0;
    private final Map<ParcelUuid, byte[]> O00000oO;
    private final int O00000oo;
    private final String O0000O0o;
    private final byte[] O0000OOo;

    private exp(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.O00000o = list;
        this.O00000Oo = sparseArray;
        this.O00000oO = map;
        this.O0000O0o = str;
        this.O00000o0 = i;
        this.O00000oo = i2;
        this.O0000OOo = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d A[Catch:{ Exception -> 0x00a6 }] */
    public static exp O000000o(byte[] bArr) {
        Map map;
        if (bArr == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        if (Build.VERSION.SDK_INT >= 19) {
            map = new ArrayMap();
        } else {
            map = new HashMap();
        }
        String str = null;
        Map map2 = map;
        byte b = -1;
        byte b2 = -2147483648;
        while (i < bArr.length) {
            try {
                int i2 = i + 1;
                byte b3 = bArr[i] & 255;
                if (b3 != 0) {
                    int i3 = b3 - 1;
                    int i4 = i2 + 1;
                    byte b4 = bArr[i2] & 255;
                    if (b4 == 22) {
                        map2.put(O00000Oo(O000000o(bArr, i4, 2)), O000000o(bArr, i4 + 2, i3 - 2));
                    } else if (b4 != 255) {
                        switch (b4) {
                            case 1:
                                b = bArr[i4] & 255;
                                continue;
                            case 2:
                            case 3:
                                O000000o(bArr, i4, i3, 2, arrayList);
                                continue;
                            case 4:
                            case 5:
                                O000000o(bArr, i4, i3, 4, arrayList);
                                continue;
                            case 6:
                            case 7:
                                O000000o(bArr, i4, i3, 16, arrayList);
                                continue;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            case 9:
                                str = new String(O000000o(bArr, i4, i3));
                                continue;
                            case 10:
                                b2 = bArr[i4];
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        sparseArray.put(((bArr[i4 + 1] & 255) << 8) + (255 & bArr[i4]), O000000o(bArr, i4 + 2, i3 - 2));
                    }
                    i = i3 + i4;
                } else {
                    return new exp(!arrayList.isEmpty() ? null : arrayList, sparseArray, map2, b, b2, str, bArr);
                }
            } catch (Exception unused) {
                gsy.O000000o(6, "BLEScanRecord", "unable to parse scan record: " + Arrays.toString(bArr));
                return new exp(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        return new exp(!arrayList.isEmpty() ? null : arrayList, sparseArray, map2, b, b2, str, bArr);
    }

    public final String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.O00000o0 + ", mServiceUuids=" + this.O00000o + ", mManufacturerSpecificData=" + O000000o(this.O00000Oo) + ", mServiceData=" + O000000o(this.O00000oO) + ", mTxPowerLevel=" + this.O00000oo + ", mDeviceName=" + this.O0000O0o + "]";
    }

    private static ParcelUuid O00000Oo(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - ".concat(String.valueOf(length)));
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
                }
                return new ParcelUuid(new UUID(f15926O000000o.getUuid().getMostSignificantBits() + (j << 32), f15926O000000o.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    private static int O000000o(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(O00000Oo(O000000o(bArr, i, i3)));
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

    private static String O000000o(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < sparseArray.size(); i++) {
            sb.append(sparseArray.keyAt(i));
            sb.append("=");
            sb.append(Arrays.toString(sparseArray.valueAt(i)));
        }
        sb.append('}');
        return sb.toString();
    }

    private static <T> String O000000o(Map map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = ((Map.Entry) it.next()).getKey();
            sb.append(key);
            sb.append("=");
            sb.append(Arrays.toString((byte[]) map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static boolean O000000o(UUID uuid, byte[] bArr) {
        exp O000000o2 = O000000o(bArr);
        if (!(O000000o2 == null || uuid == null)) {
            String lowerCase = uuid.toString().toLowerCase();
            List<ParcelUuid> list = O000000o2.O00000o;
            if (list != null && !list.isEmpty()) {
                for (ParcelUuid uuid2 : list) {
                    if (lowerCase.equals(uuid2.getUuid().toString().toLowerCase())) {
                        return true;
                    }
                }
            }
            Map<ParcelUuid, byte[]> map = O000000o2.O00000oO;
            if (map != null && !map.isEmpty()) {
                for (ParcelUuid uuid3 : map.keySet()) {
                    if (lowerCase.equals(uuid3.getUuid().toString().toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
