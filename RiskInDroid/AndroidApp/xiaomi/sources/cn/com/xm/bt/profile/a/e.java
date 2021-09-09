package cn.com.xm.bt.profile.a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.profile.b.b;
import java.security.MessageDigest;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class e extends b implements d.b {
    private final byte c = 1;
    private final byte d = 2;
    private final byte e = 3;
    private final byte f = 4;
    private final byte g = 5;
    private final byte h = 6;
    private final UUID i = c.a(9);
    private BluetoothGattCharacteristic j = null;
    private byte[] k = null;
    private byte l = 20;
    private byte[] m = null;
    private byte n = 0;

    e(cn.com.xm.bt.c.b bVar) {
        super(bVar);
    }

    public boolean a() {
        BluetoothGattService a2 = a(b);
        if (a2 == null) {
            a2 = a(f3103a);
        }
        if (a2 == null) {
            a.a("HMBaseProfile", b + " is null!!!");
            return false;
        }
        this.j = a2.getCharacteristic(this.i);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.j;
        if (bluetoothGattCharacteristic == null) {
            a.a("HMBaseProfile", this.i + " is null!!!");
            return false;
        } else if (a(bluetoothGattCharacteristic, this)) {
            return true;
        } else {
            a.a("HMBaseProfile", "registerNotification m_CharAuth failed!!!");
            return false;
        }
    }

    public boolean b() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.j;
        return bluetoothGattCharacteristic == null || a(bluetoothGattCharacteristic);
    }

    public void notify(byte[] bArr) {
        a.a("HMBaseProfile", "notify:" + c.a(bArr));
        this.k = bArr;
        a((Object) this.j);
    }

    /* access modifiers changed from: package-private */
    public void a(byte b) {
        this.l = b;
    }

    /* access modifiers changed from: package-private */
    public void b(byte b) {
        this.n = b;
    }

    private boolean c(byte[] bArr) {
        a.b("HMBaseProfile", "key:" + c.a(bArr));
        if (bArr == null || bArr.length != 16) {
            return false;
        }
        byte[] bArr2 = new byte[18];
        bArr2[0] = 1;
        bArr2[1] = this.l;
        System.arraycopy(bArr, 0, bArr2, 2, 16);
        this.k = null;
        return f(bArr2);
    }

    public byte[] c() {
        byte b = (byte) (this.n | 2);
        cn.com.xm.bt.profile.b.c e2 = e(new byte[]{b, this.l, 2});
        if (e2 != null && e2.a(b)) {
            return e2.b();
        }
        cn.com.xm.bt.profile.b.c e3 = e(new byte[]{b, this.l});
        if (e3 == null || !e3.a(b)) {
            return null;
        }
        return e3.b();
    }

    private int d(byte[] bArr) {
        byte[] bArr2 = new byte[18];
        bArr2[0] = (byte) (this.n | 3);
        bArr2[1] = this.l;
        System.arraycopy(bArr, 0, bArr2, 2, 16);
        cn.com.xm.bt.profile.b.c e2 = e(bArr2);
        if (e2 == null) {
            return 0;
        }
        return e2.c();
    }

    private cn.com.xm.bt.profile.b.c e(byte[] bArr) {
        a.a("HMBaseProfile", "sendCommand:" + c.a(bArr));
        this.k = null;
        if (!a(this.j, bArr)) {
            a.a("HMBaseProfile", "write cmd failed!!!");
            return null;
        }
        if (this.k == null) {
            a(this.j, 30000);
        }
        return cn.com.xm.bt.profile.b.c.a(this.k);
    }

    private boolean f(byte[] bArr) {
        a.a("HMBaseProfile", "sendCommandWithNoResponse:" + c.a(bArr));
        boolean a2 = a(this.j, bArr);
        a.a("HMBaseProfile", "write cmd ret:".concat(String.valueOf(a2)));
        return a2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        a.a("HMBaseProfile", "pairWithNoResponse:".concat(String.valueOf(str)));
        byte[] c2 = c(str);
        if (c2 == null || c2.length != 16) {
            a.a("HMBaseProfile", "wrong key!!!");
            return false;
        }
        this.k = null;
        return c(c2);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        if (this.k == null) {
            a(this.j, 30000);
        }
        cn.com.xm.bt.profile.b.c a2 = cn.com.xm.bt.profile.b.c.a(this.k);
        if (a2 == null || a2.d() != 1) {
            return 0;
        }
        return a2.c();
    }

    public int b(String str) {
        a.a("HMBaseProfile", "auth:".concat(String.valueOf(str)));
        byte[] c2 = c();
        this.m = c2;
        a.b("HMBaseProfile", "random:" + c.a(c2));
        if (c2 == null || c2.length != 16) {
            a.a("HMBaseProfile", "wrong data from device!!!");
            return 0;
        }
        byte[] c3 = c(str);
        a.b("HMBaseProfile", "key:" + c.a(c3));
        if (c3 == null || c3.length != 16) {
            a.a("HMBaseProfile", "wrong key!!!");
            return 0;
        }
        byte[] b = b(c2, c3);
        a.b("HMBaseProfile", "encrypt:" + c.a(b));
        if (b != null && b.length == 16) {
            return d(b);
        }
        a.a("HMBaseProfile", "wrong chip from local encrypt!!!");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public byte[] e() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public b f() {
        byte[] a2;
        cn.com.xm.bt.profile.b.c e2 = e(new byte[]{1, this.l});
        if (e2 == null || (a2 = e2.a()) == null || a2.length < 4 || a2[0] != 16 || (a2[1] & 255) != 1 || a2[2] != -127) {
            return null;
        }
        b bVar = new b();
        if (a2.length == 4) {
            bVar.a(a2[3] & 255);
        } else if (a2.length == 20) {
            bVar.a(a2[3] & 15);
            bVar.b((a2[3] >> 4) & 15);
            byte[] bArr = new byte[16];
            System.arraycopy(a2, 4, bArr, 0, 16);
            bVar.a(bArr);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public int a(byte[] bArr) {
        a.a("HMBaseProfile", "auth:" + c.a(bArr));
        byte[] c2 = c();
        this.m = c2;
        a.b("HMBaseProfile", "random:" + c.a(c2));
        if (c2 == null || c2.length != 16) {
            a.a("HMBaseProfile", "wrong data from device!!!");
            return 0;
        }
        byte[] b = b(c2, bArr);
        a.b("HMBaseProfile", "encrypt:" + c.a(b));
        if (b != null && b.length == 16) {
            return d(b);
        }
        a.a("HMBaseProfile", "wrong chip from local encrypt!!!");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(byte[] bArr, byte[] bArr2) {
        this.k = null;
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 2)];
        boolean z = false;
        bArr3[0] = -125;
        bArr3[1] = this.l;
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 2, bArr2.length);
        if (!cn.com.xm.bt.profile.c.a.a(bArr3, 4)) {
            a.a("HMBaseProfile", "AUTH patchWrite failed!!!");
            return false;
        }
        if (this.k == null) {
            a(this.j, 5000);
        }
        cn.com.xm.bt.profile.b.c a2 = cn.com.xm.bt.profile.b.c.a(this.k);
        if (a2 != null && a2.a(bArr3[0])) {
            z = true;
        }
        this.k = null;
        return z;
    }

    static byte[] a(String str, byte[] bArr) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || bArr == null || bArr.length == 0) {
            return null;
        }
        String[] split = str.split(":");
        byte[] bArr2 = new byte[(split.length + bArr.length)];
        int i2 = 0;
        while (i2 < split.length) {
            bArr2[i2] = Integer.decode("0x" + split[i2]).byteValue();
            i2++;
        }
        System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
        return bArr2;
    }

    static byte[] b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e2) {
            a.a("HMBaseProfile", "sha256 Exception:" + e2.getMessage());
            return null;
        }
    }
}
