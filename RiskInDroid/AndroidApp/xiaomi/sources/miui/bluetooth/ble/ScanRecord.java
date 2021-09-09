package miui.bluetooth.ble;

import android.os.ParcelUuid;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class ScanRecord {
    private static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private final int mAdvertiseFlags;
    private final byte[] mBytes;
    private final String mDeviceName;
    private final SparseArray<byte[]> mManufacturerSpecificData;
    private final Map<ParcelUuid, byte[]> mServiceData;
    private final List<ParcelUuid> mServiceUuids;
    private final int mTxPowerLevel;

    public final int getAdvertiseFlags() {
        return this.mAdvertiseFlags;
    }

    public final List<ParcelUuid> getServiceUuids() {
        return this.mServiceUuids;
    }

    public final SparseArray<byte[]> getManufacturerSpecificData() {
        return this.mManufacturerSpecificData;
    }

    public final byte[] getManufacturerSpecificData(int i) {
        return this.mManufacturerSpecificData.get(i);
    }

    public final Map<ParcelUuid, byte[]> getServiceData() {
        return this.mServiceData;
    }

    public final byte[] getServiceData(ParcelUuid parcelUuid) {
        Map<ParcelUuid, byte[]> map;
        if (parcelUuid == null || (map = this.mServiceData) == null) {
            return null;
        }
        return map.get(parcelUuid);
    }

    public final int getTxPowerLevel() {
        return this.mTxPowerLevel;
    }

    public final String getDeviceName() {
        return this.mDeviceName;
    }

    public final byte[] getBytes() {
        return this.mBytes;
    }

    private ScanRecord(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.mServiceUuids = list;
        this.mManufacturerSpecificData = sparseArray;
        this.mServiceData = map;
        this.mDeviceName = str;
        this.mAdvertiseFlags = i;
        this.mTxPowerLevel = i2;
        this.mBytes = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008e A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090 A[Catch:{ Exception -> 0x0099 }] */
    public static ScanRecord parseFromBytes(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        ArrayMap arrayMap = new ArrayMap();
        String str = null;
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
                        arrayMap.put(parseUuidFrom(extractBytes(bArr, i4, 2)), extractBytes(bArr, i4 + 2, i3 - 2));
                    } else if (b4 != 255) {
                        switch (b4) {
                            case 1:
                                b = bArr[i4] & 255;
                                continue;
                            case 2:
                            case 3:
                                parseServiceUuid(bArr, i4, i3, 2, arrayList);
                                continue;
                            case 4:
                            case 5:
                                parseServiceUuid(bArr, i4, i3, 4, arrayList);
                                continue;
                            case 6:
                            case 7:
                                parseServiceUuid(bArr, i4, i3, 16, arrayList);
                                continue;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            case 9:
                                str = new String(extractBytes(bArr, i4, i3));
                                continue;
                            case 10:
                                b2 = bArr[i4];
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        sparseArray.put(((bArr[i4 + 1] & 255) << 8) + (255 & bArr[i4]), extractBytes(bArr, i4 + 2, i3 - 2));
                    }
                    i = i3 + i4;
                } else {
                    return new ScanRecord(!arrayList.isEmpty() ? null : arrayList, sparseArray, arrayMap, b, b2, str, bArr);
                }
            } catch (Exception unused) {
                Log.e("ScanRecord", "unable to parse scan record: " + Arrays.toString(bArr));
                return new ScanRecord(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        return new ScanRecord(!arrayList.isEmpty() ? null : arrayList, sparseArray, arrayMap, b, b2, str, bArr);
    }

    public final String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.mAdvertiseFlags + ", mServiceUuids=" + this.mServiceUuids + ", mManufacturerSpecificData=" + toString(this.mManufacturerSpecificData) + ", mServiceData=" + toString(this.mServiceData) + ", mTxPowerLevel=" + this.mTxPowerLevel + ", mDeviceName=" + this.mDeviceName + "]";
    }

    private static ParcelUuid parseUuidFrom(byte[] bArr) {
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
                return new ParcelUuid(new UUID(BASE_UUID.getUuid().getMostSignificantBits() + (j << 32), BASE_UUID.getUuid().getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    private static int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    static String toString(SparseArray<byte[]> sparseArray) {
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

    static <T> String toString(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = it.next().getKey();
            sb.append(key);
            sb.append("=");
            sb.append(Arrays.toString(map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
