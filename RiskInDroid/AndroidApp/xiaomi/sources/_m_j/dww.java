package _m_j;

import com.xiaomi.mi_connect.nfc.exception.NfcParseDeviceRecordException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class dww implements dws {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15011O000000o;
    public byte O00000Oo;
    private Map<Short, byte[]> O00000o;
    private byte O00000o0;

    public dww(short s, byte b, byte b2, Map<Short, byte[]> map) {
        this.O00000o = map;
        this.O00000o0 = b2;
        this.O00000Oo = b;
        this.f15011O000000o = s;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0075 */
    public final byte[] O000000o() {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4];
        System.arraycopy(dwx.O000000o((short) this.f15011O000000o), 0, bArr, 0, 2);
        bArr[2] = this.O00000o0;
        bArr[3] = this.O00000Oo;
        try {
            byteArrayOutputStream.write(bArr);
            if (this.O00000o != null) {
                for (Map.Entry next : this.O00000o.entrySet()) {
                    short shortValue = ((Short) next.getKey()).shortValue();
                    byte[] bArr2 = (byte[]) next.getValue();
                    byteArrayOutputStream.write(dwx.O000000o(shortValue));
                    byteArrayOutputStream.write(dwx.O000000o((short) bArr2.length));
                    byteArrayOutputStream.write(bArr2);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArray;
        } catch (IOException ) {
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    public final <T extends dws> T O000000o(Class<T> cls) {
        if (cls.equals(dww.class)) {
            return this;
        }
        return null;
    }

    public final byte[] O000000o(int i) {
        Map<Short, byte[]> map = this.O00000o;
        if (map == null) {
            return null;
        }
        return map.get(Short.valueOf((short) i));
    }

    public static dww O000000o(byte[] bArr) throws NfcParseDeviceRecordException {
        int i = 4;
        if (bArr.length >= 4) {
            short O000000o2 = dwx.O000000o(bArr, 0);
            if (O000000o2 <= 0 || O000000o2 >= 8) {
                throw new NfcParseDeviceRecordException("invalidate device type");
            }
            byte b = bArr[2];
            byte b2 = bArr[3];
            HashMap hashMap = null;
            if (4 < bArr.length - 1) {
                hashMap = new HashMap();
            }
            while (i < bArr.length) {
                try {
                    short O000000o3 = dwx.O000000o(bArr, i);
                    if (O000000o3 >= 19 || O000000o3 <= 0) {
                        throw new NfcParseDeviceRecordException("invalidated attribute type");
                    }
                    int i2 = i + 2;
                    int O000000o4 = dwx.O000000o(bArr, i2);
                    if (O000000o4 > 0) {
                        int i3 = i2 + 2;
                        byte[] bArr2 = new byte[O000000o4];
                        System.arraycopy(bArr, i3, bArr2, 0, O000000o4);
                        i = i3 + O000000o4;
                        hashMap.put(Short.valueOf(O000000o3), bArr2);
                    } else {
                        throw new NfcParseDeviceRecordException("invalidate attribute length");
                    }
                } catch (IndexOutOfBoundsException unused) {
                    throw new NfcParseDeviceRecordException("index out of bounds");
                }
            }
            return new dww(O000000o2, b2, b, hashMap);
        }
        throw new NfcParseDeviceRecordException("invalidate record data");
    }
}
