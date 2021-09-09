package cn.com.xm.bt.profile.b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import cn.com.xm.bt.c.b;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.d.e;

@SuppressLint({"NewApi"})
public class a extends b implements d {

    /* renamed from: a  reason: collision with root package name */
    BluetoothGattCharacteristic f3102a = null;
    private BluetoothGattCharacteristic i = null;
    private BluetoothGattCharacteristic j = null;
    private BluetoothGattCharacteristic k = null;
    private BluetoothGattCharacteristic l = null;
    private BluetoothGattCharacteristic m = null;

    /* access modifiers changed from: package-private */
    public e a(byte[] bArr) {
        return null;
    }

    public a(Context context, BluetoothDevice bluetoothDevice, d.a aVar) {
        super(context, bluetoothDevice, aVar);
    }

    public boolean o() {
        BluetoothGattService a2 = a(d);
        if (a2 != null) {
            this.i = a2.getCharacteristic(f);
            cn.com.xm.bt.a.a.a(this.i);
            this.k = a2.getCharacteristic(g);
            cn.com.xm.bt.a.a.a(this.k);
            this.j = a2.getCharacteristic(e);
            cn.com.xm.bt.a.a.a(this.j);
            this.l = a2.getCharacteristic(h);
            cn.com.xm.bt.a.a.a(this.l);
        }
        BluetoothGattService a3 = a(b);
        if (a3 == null) {
            return true;
        }
        this.m = a3.getCharacteristic(c);
        return true;
    }

    private cn.com.xm.bt.d.b s() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.m;
        if (bluetoothGattCharacteristic == null) {
            return null;
        }
        byte[] g = g(bluetoothGattCharacteristic);
        cn.com.xm.bt.a.a.a(g);
        if (g == null || (g.length != 16 && g.length != 20)) {
            return null;
        }
        cn.com.xm.bt.a.a.b("BaseProfile", "device info ret len:" + g.length);
        byte b = c.b(new byte[]{g[0], g[1], g[2], g[3], g[4], g[5], g[6]}) ^ (g[3] & 255);
        cn.com.xm.bt.a.a.b(b == (g[7] & 255));
        if (b != (g[7] & 255)) {
            cn.com.xm.bt.a.a.b("BaseProfile", "DeviceInfo CRC verification failed");
            return null;
        }
        String format = String.format("%02X%02X%02X%02X%02X%02X%02X%02X", Byte.valueOf(g[0]), Byte.valueOf(g[1]), Byte.valueOf(g[2]), Byte.valueOf(g[3]), Byte.valueOf(g[4]), Byte.valueOf(g[5]), Byte.valueOf(g[6]), Byte.valueOf(g[7]));
        int a2 = c.a(g, 8);
        int a3 = c.a(g, 12);
        if (g.length == 20) {
            return new cn.com.xm.bt.d.b(format, a2, a3, c.a(g, 16));
        }
        return new cn.com.xm.bt.d.b(format, a2, a3);
    }

    /* access modifiers changed from: package-private */
    public cn.com.xm.bt.d.c q() {
        if (this.i == null || this.k == null || this.j == null || this.l == null) {
            return null;
        }
        cn.com.xm.bt.d.c cVar = new cn.com.xm.bt.d.c();
        byte[] g = g(this.i);
        if (g != null && g.length >= 0) {
            cVar.c = new String(g);
        }
        byte[] g2 = g(this.k);
        if (g2 != null && g2.length == 8) {
            cVar.f3089a = String.format("%02X%02X%02X%02X%02X%02X%02X%02X", Byte.valueOf(g2[0]), Byte.valueOf(g2[1]), Byte.valueOf(g2[2]), Byte.valueOf(g2[3]), Byte.valueOf(g2[4]), Byte.valueOf(g2[5]), Byte.valueOf(g2[6]), Byte.valueOf(g2[7]));
        }
        byte[] g3 = g(this.j);
        if (g3 != null && g3.length > 0) {
            cVar.b = new String(g3);
        }
        byte[] g4 = g(this.l);
        if (g4 != null && g4.length == 7) {
            cn.com.xm.bt.a.a.b("BaseProfile", "pnp id:" + c.a(g4));
            cn.com.xm.bt.d.d dVar = new cn.com.xm.bt.d.d();
            dVar.b = g4[0] & 255;
            dVar.f3090a = ((g4[2] & 255) << 8) | (g4[1] & 255);
            dVar.c = ((g4[4] & 255) << 8) | (g4[3] & 255);
            dVar.d = (g4[5] & 255) | ((g4[6] & 255) << 8);
            cVar.d = dVar;
        }
        cn.com.xm.bt.a.a.a("BaseProfile", "general device info:".concat(String.valueOf(cVar)));
        return cVar;
    }

    public cn.com.xm.bt.d.b r() {
        cn.com.xm.bt.d.c q = q();
        if (q != null) {
            return new cn.com.xm.bt.d.b(q);
        }
        return s();
    }

    public boolean a(e eVar) {
        if (this.f3102a == null) {
            return false;
        }
        e t = t();
        if (t != null) {
            eVar.a(t);
        } else {
            cn.com.xm.bt.a.a.a("BaseProfile", "getRealtimeStep return null!!!");
        }
        a(this.f3102a, new d.b(eVar) {
            /* class cn.com.xm.bt.profile.b.$$Lambda$a$RAcfzjUKTdNgXz0ge21jj8nY1l4 */
            private final /* synthetic */ e f$1;

            {
                this.f$1 = r2;
            }

            public final void notify(byte[] bArr) {
                a.this.a(this.f$1, bArr);
            }
        });
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar, byte[] bArr) {
        e a2 = a(bArr);
        if (a2 != null) {
            eVar.a(a2);
            return;
        }
        cn.com.xm.bt.a.a.a("BaseProfile", "m_CharRealtimeSteps notify wrong value:" + c.a(bArr));
    }

    private e t() {
        return a(g(this.f3102a));
    }
}
