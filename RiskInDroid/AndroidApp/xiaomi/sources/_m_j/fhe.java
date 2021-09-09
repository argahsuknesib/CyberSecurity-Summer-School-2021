package _m_j;

import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class fhe {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, O000000o> f16345O000000o = new HashMap();

    public static synchronized void O000000o(String str, byte[] bArr, BleReadResponse bleReadResponse) {
        synchronized (fhe.class) {
            byte[] O0000oo = ffr.O0000oo(str);
            if (!O000000o(str, O0000oo)) {
                O000000o(bleReadResponse, -1, (byte[]) null);
                return;
            }
            if (O0000oo != null) {
                if (O0000oo.length != 0) {
                    byte[] copyOfRange = Arrays.copyOfRange(O0000oo, 16, 32);
                    byte[] bArr2 = new byte[12];
                    System.arraycopy(Arrays.copyOfRange(O0000oo, 36, 40), 0, bArr2, 0, 4);
                    O000000o O00000Oo = O00000Oo(str);
                    short s = O00000Oo.f16346O000000o;
                    System.arraycopy(O00000Oo.O00000o0(), 0, bArr2, 8, 4);
                    byte[] O000000o2 = fir.O000000o(copyOfRange, bArr2, bArr);
                    if (O000000o2 == null) {
                        O000000o(bleReadResponse, -1, (byte[]) null);
                        return;
                    }
                    O00000Oo.O00000Oo();
                    ByteBuffer order = ByteBuffer.allocate(O000000o2.length + 2).order(ByteOrder.LITTLE_ENDIAN);
                    order.putShort((short) (65535 & s));
                    order.put(O000000o2);
                    O000000o(bleReadResponse, 0, order.array());
                    return;
                }
            }
            O000000o(bleReadResponse, -1, (byte[]) null);
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0090=Splitter:B:23:0x0090, B:27:0x0095=Splitter:B:27:0x0095} */
    public static synchronized void O00000Oo(String str, byte[] bArr, BleReadResponse bleReadResponse) {
        synchronized (fhe.class) {
            byte[] O0000oo = ffr.O0000oo(str);
            if (!O000000o(str, O0000oo)) {
                O000000o(bleReadResponse, -1, (byte[]) null);
                return;
            }
            if (bArr != null) {
                if (bArr.length > 2) {
                    if (O0000oo != null) {
                        if (O0000oo.length != 0) {
                            byte[] copyOfRange = Arrays.copyOfRange(O0000oo, 0, 16);
                            byte[] copyOfRange2 = Arrays.copyOfRange(O0000oo, 32, 36);
                            short s = (short) ((bArr[1] << 8) | (bArr[0] & 255));
                            byte[] bArr2 = new byte[(bArr.length - 2)];
                            System.arraycopy(bArr, 2, bArr2, 0, bArr.length - 2);
                            O000000o O00000Oo = O00000Oo(str);
                            int i = (O00000Oo.O00000o0 & 32768) >> 15;
                            int i2 = (32768 & s) >> 15;
                            O00000Oo.O00000o0 = s;
                            if (i != i2) {
                                O00000Oo.O00000Oo = (short) (O00000Oo.O00000Oo + 1);
                            }
                            byte[] bArr3 = new byte[12];
                            System.arraycopy(copyOfRange2, 0, bArr3, 0, 4);
                            System.arraycopy(new byte[]{(byte) (O00000Oo.O00000o0 & 255), (byte) (O00000Oo.O00000o0 >> 8), (byte) (O00000Oo.O00000Oo & 255), (byte) (O00000Oo.O00000Oo >> 8)}, 0, bArr3, 8, 4);
                            O000000o(bleReadResponse, 0, fir.O00000Oo(copyOfRange, bArr3, bArr2));
                            return;
                        }
                    }
                    O000000o(bleReadResponse, -1, (byte[]) null);
                    return;
                }
            }
            O000000o(bleReadResponse, -1, (byte[]) null);
        }
    }

    private static void O000000o(BleReadResponse bleReadResponse, int i, byte[] bArr) {
        if (bleReadResponse != null) {
            bleReadResponse.onResponse(i, bArr);
        }
    }

    private static boolean O000000o(String str, byte[] bArr) {
        if (!gnl.O00000o0(str)) {
            fte.O00000Oo(str + " is not connected");
            return false;
        } else if (bArr != null && bArr.length == 64) {
            return true;
        } else {
            fte.O00000Oo(str + " sessionKey is null or invalid");
            return false;
        }
    }

    private static O000000o O00000Oo(String str) {
        O000000o o000000o = f16345O000000o.get(str);
        if (o000000o != null) {
            return o000000o;
        }
        O000000o o000000o2 = new O000000o();
        f16345O000000o.put(str, o000000o2);
        return o000000o2;
    }

    public static void O000000o(String str) {
        O000000o o000000o = f16345O000000o.get(str);
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public short f16346O000000o;
        short O00000Oo;
        private short O00000o;
        short O00000o0;

        public final void O000000o() {
            this.O00000o = 0;
            this.f16346O000000o = 0;
            this.O00000Oo = 0;
            this.O00000o0 = 0;
        }

        public final void O00000Oo() {
            short s = this.f16346O000000o;
            int i = (s & 32768) >> 15;
            this.f16346O000000o = (short) (s + 1);
            if (i != ((this.f16346O000000o & 32768) >> 15)) {
                this.O00000o = (short) (this.O00000o + 1);
            }
        }

        public final byte[] O00000o0() {
            short s = this.f16346O000000o;
            short s2 = this.O00000o;
            return new byte[]{(byte) (s & 255), (byte) (s >> 8), (byte) (s2 & 255), (byte) (s2 >> 8)};
        }
    }
}
