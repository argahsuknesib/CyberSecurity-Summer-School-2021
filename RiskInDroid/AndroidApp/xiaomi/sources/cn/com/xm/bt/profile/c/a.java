package cn.com.xm.bt.profile.c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import cn.com.xm.bt.c.b;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.c.d;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final UUID f3106a = c.a(32);
    private static BluetoothGattCharacteristic b;
    private static b c = null;
    private static int d = 0;
    private static d.b e = null;
    private static d.b f = $$Lambda$a$FqhIrO5szbEoB8Ty6ueRFmUyM.INSTANCE;

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(byte[] bArr) {
        cn.com.xm.bt.a.a.a("HMPieceProfile", "patchWrite notify:" + c.a(bArr));
        d.b bVar = e;
        if (bVar != null) {
            bVar.notify(bArr);
        }
    }

    public static synchronized boolean a(b bVar, boolean z) {
        synchronized (a.class) {
            c = bVar;
            BluetoothGattService a2 = bVar.a(cn.com.xm.bt.profile.b.b.f3103a);
            if (a2 == null) {
                cn.com.xm.bt.a.a.a("HMPieceProfile", cn.com.xm.bt.profile.b.b.f3103a + " is null!!!");
                return false;
            }
            BluetoothGattCharacteristic characteristic = a2.getCharacteristic(f3106a);
            b = characteristic;
            if (characteristic == null) {
                cn.com.xm.bt.a.a.a("HMPieceProfile", f3106a + " is null!!!");
                return false;
            }
            byte[] g = bVar.g(b);
            cn.com.xm.bt.a.a.b("HMPieceProfile", "data:" + c.a(g));
            if (g != null && g.length == 1) {
                d = g[0] & 255;
                cn.com.xm.bt.a.a.a("HMPieceProfile", "piece profile version:" + d);
            }
            if (!z) {
                return true;
            }
            boolean a3 = bVar.a(b, f);
            return a3;
        }
    }

    public static synchronized boolean a() {
        boolean z;
        synchronized (a.class) {
            z = b != null;
        }
        return z;
    }

    public static boolean a(byte[] bArr, int i) {
        b b2 = b(bArr, i);
        cn.com.xm.bt.a.a.a("HMPieceProfile", "PieceResult:".concat(String.valueOf(b2)));
        if (b2 == null || !b2.b() || !b2.c() || b2.a() != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r1 != 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r1 = 17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6 = new byte[(r1 + 3)];
        r6[0] = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (r2 <= 1) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        r2 = -128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        r2 = -64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        r6[1] = (byte) (r13 | r2);
        r6[2] = (byte) (r7 % 255);
        java.lang.System.arraycopy(r12, r7 * 17, r6, 3, r1);
        cn.com.xm.bt.a.a.b("HMPieceProfile", "patchWrite:" + cn.com.xm.bt.c.c.a(r6));
        r12 = b(r6);
        cn.com.xm.bt.a.a.b("HMPieceProfile", "response:".concat(java.lang.String.valueOf(r12)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bc, code lost:
        if (r12 != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bf, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r12 = r12.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c4, code lost:
        if (r12 == null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c8, code lost:
        if (r12.length < 4) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        if (r12[1] != 0) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d2, code lost:
        if (r12[2] == r6[1]) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d5, code lost:
        r13 = r12[3] & 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        if (r12.length < 5) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        r5 = r12[4] & 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e3, code lost:
        if (r12.length < 7) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e5, code lost:
        r4 = (r12[5] & 255) | ((r12[6] & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f2, code lost:
        r12 = new cn.com.xm.bt.profile.c.b(r13, r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f8, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fa, code lost:
        return null;
     */
    private static synchronized b b(byte[] bArr, int i) {
        synchronized (a.class) {
            cn.com.xm.bt.a.a.b("HMPieceProfile", "patchWrite origin:" + c.a(bArr));
            int length = bArr.length;
            int i2 = length / 17;
            int i3 = length % 17;
            byte b2 = 0;
            byte b3 = 1;
            int i4 = i2 + (i3 == 0 ? 0 : 1);
            int i5 = 0;
            while (true) {
                int i6 = i4 - 1;
                if (i5 >= i6) {
                    break;
                }
                byte[] bArr2 = new byte[20];
                bArr2[0] = 0;
                bArr2[1] = (byte) ((i5 == 0 ? 0 : 64) | i);
                bArr2[2] = (byte) (i5 % 255);
                System.arraycopy(bArr, i5 * 17, bArr2, 3, 17);
                cn.com.xm.bt.a.a.b("HMPieceProfile", "patchWrite:" + c.a(bArr2));
                if (!a(bArr2)) {
                    cn.com.xm.bt.a.a.b("HMPieceProfile", "writeNoResponse failed!!!");
                    return null;
                }
                i5++;
            }
        }
    }

    private static boolean a(byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        b bVar = c;
        if (bVar == null || (bluetoothGattCharacteristic = b) == null) {
            return false;
        }
        return bVar.c(bluetoothGattCharacteristic, bArr);
    }

    private static cn.com.xm.bt.profile.b.c b(byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        b bVar = c;
        if (bVar == null || (bluetoothGattCharacteristic = b) == null) {
            return null;
        }
        if (!bVar.f(bluetoothGattCharacteristic)) {
            return c.a(b, bArr, 6000);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        cn.com.xm.bt.profile.b.c cVar = new cn.com.xm.bt.profile.b.c();
        e = new d.b(countDownLatch) {
            /* class cn.com.xm.bt.profile.c.$$Lambda$a$p2qvI1IflpgHhmDO1aqLuiupNk */
            private final /* synthetic */ CountDownLatch f$1;

            {
                this.f$1 = r2;
            }

            public final void notify(byte[] bArr) {
                a.a(cn.com.xm.bt.profile.b.c.this, this.f$1, bArr);
            }
        };
        c.c(b, bArr);
        try {
            countDownLatch.await(6000, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        return cVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(cn.com.xm.bt.profile.b.c cVar, CountDownLatch countDownLatch, byte[] bArr) {
        cVar.b(bArr);
        countDownLatch.countDown();
    }
}
