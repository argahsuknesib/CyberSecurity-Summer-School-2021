package _m_j;

import com.xiaomi.mi_connect.nfc.exception.NfcParseActionRecordException;
import com.xiaomi.mi_connect.nfc.exception.NfcParseDeviceRecordException;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dwv implements dwr {
    private static final List<Byte> O0000O0o = Arrays.asList((byte) 1, (byte) 2);

    /* renamed from: O000000o  reason: collision with root package name */
    public byte f15009O000000o;
    private byte O00000Oo;
    private int O00000o;
    private byte O00000o0;
    private byte O00000oO;
    private Map<Byte, List<dws>> O00000oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        byte f15010O000000o = 1;
        byte O00000Oo = 0;
        byte O00000o = 0;
        int O00000o0 = 0;
        private Map<Byte, List<dws>> O00000oO = new HashMap();

        public final O000000o O000000o(byte b, dws dws) {
            List list = this.O00000oO.get(Byte.valueOf(b));
            if (list == null) {
                list = new ArrayList();
                this.O00000oO.put(Byte.valueOf(b), list);
            }
            list.add(dws);
            return this;
        }

        public final dwv O000000o() throws NfcTagDataCorruptException {
            int i = 0;
            for (List<dws> size : this.O00000oO.values()) {
                i += size.size();
            }
            if (i <= 127) {
                if (this.O00000o0 <= 0) {
                    this.O00000o0 = (int) (System.currentTimeMillis() / 1000);
                }
                return new dwv(this.f15010O000000o, this.O00000Oo, this.O00000o0, this.O00000o, (byte) i, this.O00000oO);
            }
            throw new NfcTagDataCorruptException("too much records");
        }
    }

    public dwv(byte b, byte b2, int i, byte b3, byte b4, Map<Byte, List<dws>> map) {
        this.O00000Oo = b;
        this.O00000o0 = b2;
        this.O00000o = i;
        this.O00000oO = b3;
        this.f15009O000000o = b4;
        this.O00000oo = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0083, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        r7 = r3;
        r3 = r2;
        r2 = r7;
     */
    public final byte[] O000000o() {
        Throwable th;
        Throwable th2;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.put(this.O00000Oo);
            allocate.put(this.O00000o0);
            allocate.putInt(this.O00000o);
            allocate.put(this.O00000oO);
            allocate.put(this.f15009O000000o);
            byteArrayOutputStream.write(allocate.array());
            if (this.O00000oo != null) {
                for (Byte byteValue : O0000O0o) {
                    byte byteValue2 = byteValue.byteValue();
                    List<dws> list = this.O00000oo.get(Byte.valueOf(byteValue2));
                    if (list != null) {
                        for (dws O000000o2 : list) {
                            byteArrayOutputStream.write(byteValue2);
                            byte[] O000000o3 = O000000o2.O000000o();
                            byteArrayOutputStream.write(dwx.O000000o((short) (O000000o3.length + 3)));
                            byteArrayOutputStream.write(O000000o3);
                        }
                    }
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
            throw th2;
            if (th != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
            } else {
                byteArrayOutputStream.close();
            }
            throw th2;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static dwv O000000o(byte[] bArr) throws NfcTagDataCorruptException {
        int i;
        try {
            O000000o o000000o = new O000000o();
            o000000o.f15010O000000o = bArr[0];
            o000000o.O00000Oo = bArr[1];
            if (6 > bArr.length) {
                i = 0;
            } else {
                i = ByteBuffer.wrap(bArr, 2, 4).getInt();
            }
            o000000o.O00000o0 = i;
            o000000o.O00000o = (byte) (bArr[6] | o000000o.O00000o);
            int i2 = 8;
            int i3 = bArr[7];
            while (i3 > 0) {
                byte b = bArr[i2];
                int O000000o2 = dwx.O000000o(bArr, i2 + 1);
                if (O000000o2 >= 3) {
                    int i4 = O000000o2 - 3;
                    if (i4 > 0) {
                        byte[] bArr2 = new byte[i4];
                        System.arraycopy(bArr, i2 + 3, bArr2, 0, i4);
                        if (b == 1) {
                            o000000o.O000000o((byte) 1, dww.O000000o(bArr2));
                        } else if (b == 2) {
                            o000000o.O000000o((byte) 2, dwt.O000000o(bArr2));
                        } else {
                            throw new NfcTagDataCorruptException("unsupported record type");
                        }
                    }
                    i2 += O000000o2;
                    i3--;
                } else {
                    throw new NfcTagDataCorruptException("invalid data offset");
                }
            }
            return o000000o.O000000o();
        } catch (IndexOutOfBoundsException unused) {
            throw new NfcTagDataCorruptException("invalidate data");
        } catch (NfcParseActionRecordException e) {
            throw new NfcTagDataCorruptException("invalidate action data:" + e.getMessage());
        } catch (NfcParseDeviceRecordException e2) {
            throw new NfcTagDataCorruptException("invalidate device data:" + e2.getMessage());
        }
    }

    public final List<dws> O000000o(byte b) {
        Map<Byte, List<dws>> map = this.O00000oo;
        if (map == null) {
            return null;
        }
        return map.get(Byte.valueOf(b));
    }
}
