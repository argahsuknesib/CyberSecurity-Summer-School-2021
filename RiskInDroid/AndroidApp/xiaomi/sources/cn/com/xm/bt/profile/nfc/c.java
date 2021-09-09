package cn.com.xm.bt.profile.nfc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.profile.b.b;
import cn.com.xm.bt.profile.b.c;
import java.io.ByteArrayOutputStream;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class c extends b {
    private static final UUID c = cn.com.xm.bt.c.c.a(17);
    private BluetoothGattCharacteristic d = null;
    private volatile d.b e = null;
    private d f = null;

    public c(cn.com.xm.bt.c.b bVar) {
        super(bVar);
    }

    public boolean a() {
        BluetoothGattService a2 = a(f3103a);
        if (a2 == null) {
            return false;
        }
        this.d = a2.getCharacteristic(c);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.d;
        if (bluetoothGattCharacteristic != null) {
            return a(bluetoothGattCharacteristic, new d.b() {
                /* class cn.com.xm.bt.profile.nfc.$$Lambda$c$goXn5PikIthgUFq1kjpOrwS7J0 */

                public final void notify(byte[] bArr) {
                    c.this.b(bArr);
                }
            });
        }
        a.a("HMBaseProfile", c + " is null!");
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(byte[] bArr) {
        d dVar;
        if (!(bArr == null || bArr.length != 2 || bArr[0] != -126 || bArr[1] == 0 || (dVar = this.f) == null)) {
            dVar.onStatusChanged(new HMNFCStatus(bArr[1] & 255));
        }
        if (this.e != null) {
            this.e.notify(bArr);
        }
    }

    public boolean b() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.d;
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        a(bluetoothGattCharacteristic);
        return false;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    private void a(d.b bVar) {
        this.e = bVar;
    }

    public int c() {
        byte[] a2;
        cn.com.xm.bt.profile.b.c a3 = a(new byte[]{1});
        if (a3 != null && (a2 = a3.a()) != null && a2.length == 2 && a2[0] == -127) {
            return a2[1] & 255;
        }
        return -1;
    }

    public int d() {
        byte[] a2;
        cn.com.xm.bt.profile.b.c a3 = a(new byte[]{2});
        if (a3 != null && (a2 = a3.a()) != null && a2.length == 2 && a2[0] == -126) {
            return a2[1] & 255;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ApduResponse a(byte[] bArr, int i, boolean z) {
        a.b("HMBaseProfile", "sendData in");
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        a.b("HMBaseProfile", "sendData origin:" + cn.com.xm.bt.c.c.a(bArr) + ",encrypt:" + z);
        byte[] a2 = a(bArr, i);
        StringBuilder sb = new StringBuilder("sendData package:");
        sb.append(cn.com.xm.bt.c.c.a(a2));
        a.b("HMBaseProfile", sb.toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b = z ? (byte) 6 : 4;
        byte b2 = z ? (byte) 5 : 3;
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        a((d.b) new d.b(byteArrayOutputStream, b, b2, atomicInteger) {
            /* class cn.com.xm.bt.profile.nfc.$$Lambda$c$Pb3AjnEflTP2jaszay_rNQTnRkk */
            private final /* synthetic */ ByteArrayOutputStream f$1;
            private final /* synthetic */ byte f$2;
            private final /* synthetic */ byte f$3;
            private final /* synthetic */ AtomicInteger f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void notify(byte[] bArr) {
                c.this.a(this.f$1, this.f$2, this.f$3, this.f$4, bArr);
            }
        });
        int length = a2.length;
        int i2 = 0;
        boolean z2 = true;
        while (length > 19) {
            byte[] bArr2 = new byte[20];
            bArr2[0] = b;
            System.arraycopy(a2, i2 * 19, bArr2, 1, 19);
            a.b("HMBaseProfile", "cmdC:" + cn.com.xm.bt.c.c.a(bArr2));
            z2 = a(this.d, bArr2);
            if (!z2) {
                break;
            }
            length -= 19;
            i2++;
        }
        if (z2 && length > 0) {
            byte[] bArr3 = new byte[(length + 1)];
            bArr3[0] = b2;
            System.arraycopy(a2, i2 * 19, bArr3, 1, length);
            a.b("HMBaseProfile", "cmdX:" + cn.com.xm.bt.c.c.a(bArr3));
            z2 = a(this.d, bArr3);
        }
        if (z2) {
            a(byteArrayOutputStream, 60000);
        }
        a((d.b) null);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        return new ApduResponse(byteArrayOutputStream.toByteArray(), atomicInteger.get());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ByteArrayOutputStream byteArrayOutputStream, byte b, byte b2, AtomicInteger atomicInteger, byte[] bArr) {
        a.a("HMBaseProfile", "HMNFCProfile notify:" + cn.com.xm.bt.c.c.a(bArr));
        byteArrayOutputStream.write(bArr, 1, bArr.length - 1);
        if (bArr[0] == (b | Byte.MIN_VALUE)) {
            return;
        }
        if (bArr[0] == (b2 | Byte.MIN_VALUE)) {
            int size = byteArrayOutputStream.size();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a.b("HMBaseProfile", "responseLen:" + size + ",responseData:" + cn.com.xm.bt.c.c.a(byteArray));
            if (size != 1 && size >= 4) {
                int i = size - 2;
                atomicInteger.set(((byteArray[size - 1] & 255) << 8) | (byteArray[i] & 255));
                byte[] bArr2 = new byte[i];
                System.arraycopy(byteArray, 0, bArr2, 0, i);
                byteArrayOutputStream.reset();
                a.b("HMBaseProfile", "realLen:" + i + ",realData:" + cn.com.xm.bt.c.c.a(bArr2));
                if (i >= atomicInteger.get()) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                } else {
                    a.b("HMBaseProfile", "wrong data length response data len:" + i + ",real data len:" + atomicInteger.get());
                }
            }
            a(byteArrayOutputStream);
            return;
        }
        byteArrayOutputStream.reset();
        a(byteArrayOutputStream);
    }

    private byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 2)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = (byte) (i & 255);
        bArr2[length + 1] = (byte) ((i >> 8) & 255);
        return bArr2;
    }

    private cn.com.xm.bt.profile.b.c a(byte[] bArr) {
        a.a("HMBaseProfile", "cmd:" + cn.com.xm.bt.c.c.a(bArr));
        cn.com.xm.bt.profile.b.c cVar = new cn.com.xm.bt.profile.b.c();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        a((d.b) new d.b(countDownLatch) {
            /* class cn.com.xm.bt.profile.nfc.$$Lambda$c$dTq0G1UZFf3cEmVvRlWDQjuVSc */
            private final /* synthetic */ CountDownLatch f$1;

            {
                this.f$1 = r2;
            }

            public final void notify(byte[] bArr) {
                c.a(c.this, this.f$1, bArr);
            }
        });
        if (a(this.d, bArr)) {
            try {
                countDownLatch.await(10000, TimeUnit.MILLISECONDS);
            } catch (Exception e2) {
                a.a("HMBaseProfile", "await exception:" + e2.getMessage());
            }
        }
        a.a("HMBaseProfile", "result:".concat(String.valueOf(cVar)));
        a((d.b) null);
        return cVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(cn.com.xm.bt.profile.b.c cVar, CountDownLatch countDownLatch, byte[] bArr) {
        a.a("HMBaseProfile", "notify:" + cn.com.xm.bt.c.c.a(bArr));
        cVar.b(bArr);
        countDownLatch.countDown();
    }
}
