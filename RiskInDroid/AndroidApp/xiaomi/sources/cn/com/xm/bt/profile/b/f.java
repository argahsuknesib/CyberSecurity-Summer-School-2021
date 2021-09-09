package cn.com.xm.bt.profile.b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.TextUtils;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.d.b;
import cn.com.xm.bt.d.e;
import cn.com.xm.bt.profile.nfc.HMAccessInfo;
import cn.com.xm.bt.profile.nfc.HMAidInfo;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class f extends a {
    private final UUID i = c.a(7);
    private final byte j = 6;
    private final byte k = 27;
    private final short l = 28;

    public f(Context context, BluetoothDevice bluetoothDevice, d.a aVar) {
        super(context, bluetoothDevice, aVar);
        a.a();
    }

    public boolean o() {
        super.o();
        BluetoothGattService a2 = a(a.b);
        a.a(a2);
        if (a2 == null) {
            a.a(a.b + " is null!");
            return false;
        }
        this.f3102a = a2.getCharacteristic(this.i);
        if (this.f3102a != null) {
            return true;
        }
        a.a(this.i + " is null!");
        return false;
    }

    public b r() {
        cn.com.xm.bt.d.c q = q();
        if (q != null) {
            return new b(q);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr) {
        if (bArr != null) {
            int i2 = 5;
            if (bArr.length >= 5) {
                boolean z = false;
                byte b = bArr[0] & 255;
                e eVar = new e((bArr[1] & 255) | ((bArr[2] & 255) << 8) | ((bArr[3] & 255) << 16) | ((bArr[4] & 255) << 24), -1);
                boolean z2 = (b & 1) == 1;
                boolean z3 = ((b >> 1) & 1) == 1;
                boolean z4 = ((b >> 2) & 1) == 1;
                if (((b >> 3) & 1) == 1) {
                    z = true;
                }
                if (z2) {
                    eVar.a((bArr[5] & 255) | ((bArr[6] & 255) << 8) | ((bArr[7] & 255) << 16) | ((bArr[8] & 255) << 24));
                    i2 = 9;
                }
                if (z3) {
                    int i3 = i2 + 1;
                    int i4 = i3 + 1;
                    byte b2 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
                    int i5 = i4 + 1;
                    eVar.b(b2 | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24));
                    i2 = i5 + 1;
                }
                if (z4 && z) {
                    eVar.a(true);
                    int i6 = i2 + 1;
                    int i7 = i6 + 1;
                    byte b3 = ((bArr[i6] & 255) << 8) | (bArr[i2] & 255);
                    int i8 = i7 + 1;
                    byte b4 = b3 | ((bArr[i7] & 255) << 16);
                    int i9 = i8 + 1;
                    eVar.c(b4 | ((bArr[i8] & 255) << 24));
                    int i10 = i9 + 1;
                    int i11 = i10 + 1;
                    eVar.d(((bArr[i11 + 1] & 255) << 24) | ((bArr[i10] & 255) << 8) | (bArr[i9] & 255) | ((bArr[i11] & 255) << 16));
                }
                return eVar;
            }
        }
        a.a("MiLiProProfile", "parseRealtimeStep failed as wrong value : " + c.a(bArr));
        return null;
    }

    public boolean a(HMAccessInfo hMAccessInfo) {
        if (hMAccessInfo == null) {
            return false;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int aidLen = hMAccessInfo.getAidLen();
            byte[] aid = hMAccessInfo.getAid();
            String name = hMAccessInfo.getName();
            byteArrayOutputStream.write(27);
            byteArrayOutputStream.write(aidLen);
            if (aidLen > 0) {
                byteArrayOutputStream.write(aid);
            }
            if (!TextUtils.isEmpty(name)) {
                byteArrayOutputStream.write(name.getBytes());
            }
            byteArrayOutputStream.write(0);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (cn.com.xm.bt.profile.c.a.a()) {
                return cn.com.xm.bt.profile.c.a.a(byteArray, 2);
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean a(HMAidInfo hMAidInfo) {
        if (hMAidInfo == null) {
            return false;
        }
        int aidLen = hMAidInfo.getAidLen();
        byte[] bArr = new byte[(aidLen + 6)];
        bArr[0] = 6;
        bArr[1] = 28;
        bArr[2] = 0;
        bArr[3] = (byte) hMAidInfo.getOp();
        bArr[4] = (byte) hMAidInfo.getType();
        bArr[5] = (byte) aidLen;
        if (aidLen > 0) {
            System.arraycopy(hMAidInfo.getAid(), 0, bArr, 6, aidLen);
        }
        if (!cn.com.xm.bt.profile.c.a.a() || !cn.com.xm.bt.profile.c.a.a(bArr, 2)) {
            return false;
        }
        return true;
    }
}
