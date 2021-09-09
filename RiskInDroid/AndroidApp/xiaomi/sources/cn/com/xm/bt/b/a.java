package cn.com.xm.bt.b;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.com.xm.bt.c.c;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.e.b;
import cn.com.xm.bt.profile.a.f;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
public abstract class a implements d.a, cn.com.xm.bt.e.d, f {

    /* renamed from: a  reason: collision with root package name */
    Context f3075a;
    BluetoothDevice b;
    cn.com.xm.bt.profile.b.a c;
    private boolean d;
    private final boolean e;
    private e f;
    private final Object g;
    private C0013a h;
    /* access modifiers changed from: private */
    public cn.com.xm.bt.profile.a.a i;
    private Handler j;
    private cn.com.xm.bt.e.b k;
    private final AtomicBoolean l;
    private final AtomicBoolean m;
    private f n;
    private BroadcastReceiver o;

    /* renamed from: cn.com.xm.bt.b.a$a  reason: collision with other inner class name */
    enum C0013a {
        UNKNOWN,
        CONNECTING,
        DISCONNECTED,
        CONNECTED
    }

    enum b {
        UNKNOWN,
        INIT_SUCCESS,
        INIT_FAILED,
        GATT_CONNECTING,
        GATT_CONNECTED,
        GATT_CONNECT_FAILED,
        GATT_DISCONNECT,
        AUTH_FAILED,
        AUTH_SUCCESS,
        CONNECTING_TIMEOUT
    }

    /* access modifiers changed from: package-private */
    public boolean a(cn.com.xm.bt.profile.a.a aVar, f fVar) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract cn.com.xm.bt.profile.b.a b();

    /* access modifiers changed from: protected */
    public abstract c c();

    a(Context context, BluetoothDevice bluetoothDevice) {
        this.f3075a = null;
        this.b = null;
        this.c = null;
        this.d = true;
        this.e = false;
        this.f = null;
        this.g = new Object();
        this.h = C0013a.UNKNOWN;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new AtomicBoolean(false);
        this.m = new AtomicBoolean(true);
        this.n = null;
        this.o = new BroadcastReceiver() {
            /* class cn.com.xm.bt.b.a.AnonymousClass1 */

            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                cn.com.xm.bt.a.a.a("HMBaseBleDevice", "action:".concat(String.valueOf(action)));
                if (!TextUtils.isEmpty(action) && action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                    if (intExtra == 10) {
                        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "#Broadcast# Bluetooth OFF.");
                        a.this.i();
                    } else if (intExtra == 12) {
                        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "#Broadcast# Bluetooth ON.");
                        a.this.h();
                    }
                }
            }
        };
        this.b = bluetoothDevice;
        this.f3075a = context.getApplicationContext();
        this.m.set(c.a());
        cn.com.xm.bt.e.a.a(this.f3075a);
        HandlerThread handlerThread = new HandlerThread("HMBaseBleDevice");
        handlerThread.start();
        this.j = new Handler(handlerThread.getLooper()) {
            /* class cn.com.xm.bt.b.a.AnonymousClass2 */

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    a.this.a((b) message.obj);
                } else if (i == 1) {
                    a aVar = a.this;
                    aVar.b(aVar.a(aVar.i, a.this) ? b.AUTH_SUCCESS : b.AUTH_FAILED);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.f3075a.registerReceiver(this.o, intentFilter);
        this.k = new b.a().a(this).a(false).a(this.b.getAddress()).a(30000).a();
    }

    /* access modifiers changed from: private */
    public void h() {
        this.m.getAndSet(true);
        m();
    }

    /* access modifiers changed from: private */
    public void i() {
        this.m.getAndSet(false);
        n();
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == b.INIT_FAILED || bVar == b.GATT_CONNECT_FAILED || bVar == b.GATT_DISCONNECT || bVar == b.AUTH_FAILED) {
            if (!this.d) {
                j();
            } else {
                k();
            }
        } else if (bVar == b.GATT_CONNECTING || bVar == b.GATT_CONNECTED || bVar == b.INIT_SUCCESS) {
            k();
        } else if (bVar == b.AUTH_SUCCESS) {
            try {
                a();
            } catch (Exception e2) {
                cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onDeviceConnected exception:" + e2.getMessage());
            }
        } else if (bVar == b.CONNECTING_TIMEOUT) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return;
     */
    public void a() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onDeviceConnected");
        p();
        synchronized (this.g) {
            if (this.h != C0013a.CONNECTED) {
                this.h = C0013a.CONNECTED;
                if (this.f != null) {
                    this.f.onDeviceConnected(this.b, c());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return;
     */
    private void j() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onDeviceDisconnected");
        p();
        synchronized (this.g) {
            if (this.h != C0013a.DISCONNECTED) {
                this.h = C0013a.DISCONNECTED;
                if (this.f != null) {
                    this.f.onDeviceDisconnected(this.b, c());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return;
     */
    private void k() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onDeviceConnecting");
        o();
        synchronized (this.g) {
            if (this.h != C0013a.CONNECTING) {
                this.h = C0013a.CONNECTING;
                if (this.f != null) {
                    this.f.onDeviceConnecting(this.b, c());
                }
            }
        }
    }

    private void l() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onDeviceConnectingTimeout:" + this.b.getAddress());
        e eVar = this.f;
        if (eVar != null) {
            eVar.onDeviceConnectingTimeout(this.b, c());
        }
    }

    a(Context context, String str) {
        this(context, BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str));
    }

    private synchronized void m() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "connect:" + this.c);
        if (!this.m.get()) {
            cn.com.xm.bt.a.a.a("HMBaseBleDevice", "return as bluetooth disable~");
            return;
        }
        if (!this.l.get()) {
            if (this.c == null) {
                if (!a(this.b.getAddress())) {
                    if (this.b.getType() == 0) {
                        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "Scan device for profile~");
                        cn.com.xm.bt.e.a.a().a(this.k);
                        b(b.GATT_CONNECTING);
                        return;
                    }
                }
                cn.com.xm.bt.a.a.a("HMBaseBleDevice", "Create profile for connect~");
                this.c = b();
                this.c.b(this.d);
                this.c.c(false);
                this.c.a();
                b(b.GATT_CONNECTING);
                return;
            }
        }
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "return as has destory~");
    }

    private boolean a(String str) {
        List<BluetoothDevice> a2 = a(this.f3075a);
        if (!(a2 == null || a2.size() == 0)) {
            for (BluetoothDevice address : a2) {
                if (address.getAddress().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<BluetoothDevice> a(Context context) {
        List<BluetoothDevice> connectedDevices = ((BluetoothManager) context.getSystemService("bluetooth")).getConnectedDevices(7);
        for (BluetoothDevice next : connectedDevices) {
            cn.com.xm.bt.a.a.a("HMBaseBleDevice", "connected device:" + next.getAddress() + " " + next.getName());
        }
        return connectedDevices;
    }

    private synchronized void n() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "disconnect:" + this.c);
        cn.com.xm.bt.e.a.a().b(this.k);
        if (this.c != null) {
            this.c.b();
            this.c = null;
        }
    }

    public void a(BluetoothDevice bluetoothDevice) {
        b(b.INIT_SUCCESS);
        Handler handler = this.j;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void b(BluetoothDevice bluetoothDevice) {
        b(b.GATT_CONNECTED);
    }

    public void c(BluetoothDevice bluetoothDevice) {
        b(b.GATT_DISCONNECT);
    }

    public void d(BluetoothDevice bluetoothDevice) {
        b(b.GATT_CONNECT_FAILED);
    }

    public void e(BluetoothDevice bluetoothDevice) {
        b(b.INIT_FAILED);
    }

    public void onAuthentication(cn.com.xm.bt.profile.a.c cVar) {
        f fVar = this.n;
        if (fVar != null) {
            fVar.onAuthentication(cVar);
        }
    }

    public byte[] onGetSignData(byte[] bArr, byte[] bArr2, int i2) {
        f fVar = this.n;
        if (fVar != null) {
            return fVar.onGetSignData(bArr, bArr2, i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void b(b bVar) {
        if (this.j != null) {
            Message message = new Message();
            message.what = 0;
            message.obj = bVar;
            this.j.sendMessage(message);
        }
    }

    private void o() {
        Handler handler = this.j;
        if (handler != null && !handler.hasMessages(0, b.CONNECTING_TIMEOUT)) {
            Message message = new Message();
            message.what = 0;
            message.obj = b.CONNECTING_TIMEOUT;
            this.j.sendMessageDelayed(message, 60000);
        }
    }

    private void p() {
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(b.CONNECTING_TIMEOUT);
        }
    }

    public final void a(cn.com.xm.bt.e.b bVar) {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onScanStart:".concat(String.valueOf(bVar)));
    }

    public final void a(cn.com.xm.bt.d.a aVar, cn.com.xm.bt.e.b bVar) {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onScanedDevice:".concat(String.valueOf(aVar)));
        if (aVar.f3087a.getAddress().equals(this.b.getAddress())) {
            cn.com.xm.bt.e.a.a().b(this.k);
            m();
        }
    }

    public final void b(cn.com.xm.bt.e.b bVar) {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "onScanStop:".concat(String.valueOf(bVar)));
        m();
    }

    public void a(boolean z) {
        this.d = z;
        cn.com.xm.bt.profile.b.a aVar = this.c;
        if (aVar != null) {
            aVar.b(this.d);
        }
    }

    public void a(cn.com.xm.bt.profile.a.a aVar) {
        this.i = aVar;
    }

    public cn.com.xm.bt.profile.a.a d() {
        return this.i;
    }

    public void a(e eVar) {
        this.f = eVar;
    }

    public void a(f fVar) {
        this.n = fVar;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        boolean z;
        synchronized (this.g) {
            z = this.c != null && this.h == C0013a.CONNECTED;
        }
        return z;
    }

    public void f() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "create:".concat(String.valueOf(this)));
        m();
    }

    public void g() {
        cn.com.xm.bt.a.a.a("HMBaseBleDevice", "destory:".concat(String.valueOf(this)));
        this.l.set(true);
        n();
        BroadcastReceiver broadcastReceiver = this.o;
        if (broadcastReceiver != null) {
            this.f3075a.unregisterReceiver(broadcastReceiver);
            this.o = null;
        }
        this.f = null;
    }
}
