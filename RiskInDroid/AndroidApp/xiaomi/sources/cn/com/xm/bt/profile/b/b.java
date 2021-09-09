package cn.com.xm.bt.profile.b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.c.d;
import java.security.MessageDigest;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f3103a = c.a("FEE0");
    protected static final UUID b = c.a("FEE1");
    private cn.com.xm.bt.c.b c = null;

    protected b(cn.com.xm.bt.c.b bVar) {
        this.c = bVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000b */
    public final void a(Object obj, int i) {
        if (obj != null) {
            synchronized (obj) {
                obj.wait((long) i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        if (obj != null) {
            synchronized (obj) {
                obj.notify();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final BluetoothGattService a(UUID uuid) {
        cn.com.xm.bt.c.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        return bVar.a(uuid);
    }

    /* access modifiers changed from: protected */
    public final boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        cn.com.xm.bt.c.b bVar = this.c;
        return bVar != null && bVar.b(bluetoothGattCharacteristic, bArr);
    }

    /* access modifiers changed from: protected */
    public final boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic, d.b bVar) {
        cn.com.xm.bt.c.b bVar2 = this.c;
        return bVar2 != null && bVar2.a(bluetoothGattCharacteristic, bVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        cn.com.xm.bt.c.b bVar = this.c;
        return bVar != null && bVar.b(bluetoothGattCharacteristic);
    }

    /* access modifiers changed from: protected */
    public byte[] c(String str) {
        try {
            return MessageDigest.getInstance("MD5").digest(str.getBytes());
        } catch (Exception e) {
            a.b("HMBaseProfile", "Exception:" + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(1, secretKeySpec);
            byte[] doFinal = instance.doFinal(bArr);
            a.b("HMBaseProfile", "chip value:" + c.a(doFinal));
            return doFinal;
        } catch (Exception e) {
            a.b("HMBaseProfile", "Exception:" + e.getMessage());
            return null;
        }
    }

    public BluetoothDevice g() {
        cn.com.xm.bt.c.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        return bVar.d();
    }
}
