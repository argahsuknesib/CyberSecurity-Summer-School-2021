package cn.com.xm.bt.c;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import cn.com.xm.bt.a.a;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.profile.b.c;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@SuppressLint({"NewApi"})
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3084a = true;
    private boolean b = false;
    private d.a c = null;

    /* access modifiers changed from: protected */
    public boolean o() {
        return true;
    }

    public /* bridge */ /* synthetic */ void a(boolean z) {
        super.a(z);
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void e() {
        a.a();
        d.a aVar = this.c;
        if (aVar != null) {
            aVar.b(d());
        }
        if (this.b) {
            c();
        }
        boolean discoverServices = i().discoverServices();
        a.a("GattPeripheral", "discoverServices return ".concat(String.valueOf(discoverServices)));
        if (!discoverServices) {
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        a.a();
        d.a aVar = this.c;
        if (aVar != null) {
            aVar.c(d());
        }
        l();
    }

    /* access modifiers changed from: protected */
    public void g() {
        a.a();
        d.a aVar = this.c;
        if (aVar != null) {
            aVar.d(d());
        }
        l();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void h() {
        a.a();
        for (BluetoothGattService a2 : i().getServices()) {
            c.a(a2);
        }
        boolean n = n();
        a.b(n);
        if (!n) {
            k();
        }
    }

    public List<BluetoothGattService> m() {
        return i().getServices();
    }

    /* access modifiers changed from: protected */
    public void c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a.a();
    }

    /* access modifiers changed from: protected */
    public void d(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a.a();
    }

    /* access modifiers changed from: protected */
    public void e(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a.a();
    }

    /* access modifiers changed from: protected */
    public void a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        a.a();
    }

    /* access modifiers changed from: protected */
    public void b(BluetoothGattDescriptor bluetoothGattDescriptor) {
        a.a();
    }

    protected b(Context context, BluetoothDevice bluetoothDevice, d.a aVar) {
        super(context, bluetoothDevice);
        a.a();
        this.c = aVar;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public final void j() {
        a.a();
        a.a("device:");
        a.a("         name: " + d().getName());
        a.a("      address: " + d().getAddress());
        switch (d().getBondState()) {
            case 10:
                a.a("   bond state: NONE");
                break;
            case 11:
                a.a("   bond state: BONDING");
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                a.a("   bond state: BONDED");
                break;
        }
        int type = d().getType();
        if (type == 0) {
            a.a("         type: UNKNOWN");
        } else if (type == 1) {
            a.a("         type: CLASSIC");
        } else if (type == 2) {
            a.a("         type: LE");
        } else if (type == 3) {
            a.a("         type: DUAL");
        }
        super.j();
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        a.a();
        super.k();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        a.a();
        p();
        super.l();
        int state = BluetoothAdapter.getDefaultAdapter().getState();
        a.e("BluetoothAdapter state:".concat(String.valueOf(state)));
        if (!this.f3084a) {
            return;
        }
        if (state == 12 || state == 11) {
            try {
                a.a("GattPeripheral", "Delay 5 second before reconnect...");
                Thread.sleep(5000);
            } catch (InterruptedException unused) {
            }
            j();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: cn.com.xm.bt.profile.c.a.a(cn.com.xm.bt.c.b, boolean):boolean
     arg types: [cn.com.xm.bt.c.b, int]
     candidates:
      cn.com.xm.bt.profile.c.a.a(byte[], int):boolean
      cn.com.xm.bt.profile.c.a.a(cn.com.xm.bt.c.b, boolean):boolean */
    public boolean n() {
        a.a();
        boolean o = o();
        a.b(o);
        if (o) {
            a.d("=================================================");
            a.d("============= INITIALIZATION SUCCESS ============");
            a.d("=================================================");
            cn.com.xm.bt.profile.c.a.a(this, true);
            d.a aVar = this.c;
            if (aVar != null) {
                aVar.a(d());
            }
            return true;
        }
        a.c("=================================================");
        a.c("============= INITIALIZATION FAILED =============");
        a.c("=================================================");
        d.a aVar2 = this.c;
        if (aVar2 == null) {
            return false;
        }
        aVar2.e(d());
        return false;
    }

    public void p() {
        a.a();
    }

    @SuppressLint({"NewApi"})
    public byte[] g(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a.a();
        a.a(bluetoothGattCharacteristic);
        if (bluetoothGattCharacteristic == null) {
            return null;
        }
        int a2 = a(bluetoothGattCharacteristic);
        a.b(a2 == 0);
        if (a2 == 0) {
            return bluetoothGattCharacteristic.getValue();
        }
        return null;
    }

    public boolean b(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        a.a();
        a.a(bluetoothGattCharacteristic);
        a.a(bArr);
        if (!(bluetoothGattCharacteristic == null || bArr == null)) {
            int a2 = a(bluetoothGattCharacteristic, bArr);
            a.b(a2 == 0);
            if (a2 == 0) {
                return true;
            }
        }
        return false;
    }

    public void b(boolean z) {
        this.f3084a = z;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public final boolean c(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        a.a("GattPeripheral", "cmd:" + c.a(bArr));
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        boolean b2 = b(bluetoothGattCharacteristic, bArr);
        a.a("GattPeripheral", "result:".concat(String.valueOf(b2)));
        return b2;
    }

    public final c a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        a.a("GattPeripheral", "cmd:" + c.a(bArr));
        if (bluetoothGattCharacteristic == null) {
            return null;
        }
        c cVar = new c();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!a(bluetoothGattCharacteristic, new d.b(countDownLatch) {
            /* class cn.com.xm.bt.c.$$Lambda$b$fBmwThoINhIKszezEYbDXOnsc */
            private final /* synthetic */ CountDownLatch f$1;

            {
                this.f$1 = r2;
            }

            public final void notify(byte[] bArr) {
                b.a(c.this, this.f$1, bArr);
            }
        })) {
            return null;
        }
        if (b(bluetoothGattCharacteristic, bArr)) {
            try {
                countDownLatch.await((long) i, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                a.a("GattPeripheral", "await exception:" + e.getMessage());
            }
        }
        b(bluetoothGattCharacteristic);
        a.a("GattPeripheral", "result:".concat(String.valueOf(cVar)));
        return cVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar, CountDownLatch countDownLatch, byte[] bArr) {
        a.a("GattPeripheral", "notify:" + c.a(bArr));
        cVar.b(bArr);
        countDownLatch.countDown();
    }
}
