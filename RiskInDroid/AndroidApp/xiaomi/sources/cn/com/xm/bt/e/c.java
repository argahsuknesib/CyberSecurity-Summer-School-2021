package cn.com.xm.bt.e;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.ConditionVariable;
import cn.com.xm.bt.c.d;
import cn.com.xm.bt.d.b;
import cn.com.xm.bt.e.c;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f3096a = Executors.newSingleThreadExecutor();

    public interface a {
        void onDeviceInfoObtained(ArrayList<String> arrayList, b bVar);
    }

    public static void a(Context context, BluetoothDevice bluetoothDevice, a aVar) {
        f3096a.execute(new Runnable(context, bluetoothDevice, aVar) {
            /* class cn.com.xm.bt.e.$$Lambda$c$W9mZsoaPVzkamWdSzbE7iBaQHyA */
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ BluetoothDevice f$1;
            private final /* synthetic */ c.a f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                c.b(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, BluetoothDevice bluetoothDevice, a aVar) {
        b bVar;
        cn.com.xm.bt.a.a.a("BleScanCenter", "DeviceInfoScanner run~");
        final ConditionVariable conditionVariable = new ConditionVariable();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        cn.com.xm.bt.profile.b.a aVar2 = new cn.com.xm.bt.profile.b.a(context, bluetoothDevice, new d.a() {
            /* class cn.com.xm.bt.e.c.AnonymousClass1 */

            public final void b(BluetoothDevice bluetoothDevice) {
                cn.com.xm.bt.a.a.b("BleScanCenter", "onDeviceConnected");
            }

            public final void c(BluetoothDevice bluetoothDevice) {
                cn.com.xm.bt.a.a.b("BleScanCenter", "onDeviceDisconnected");
                conditionVariable.open();
            }

            public final void d(BluetoothDevice bluetoothDevice) {
                cn.com.xm.bt.a.a.b("BleScanCenter", "onDeviceConnectionFailed");
                conditionVariable.open();
            }

            public final void e(BluetoothDevice bluetoothDevice) {
                cn.com.xm.bt.a.a.b("BleScanCenter", "onInitializationFailed");
                conditionVariable.open();
            }

            public final void a(BluetoothDevice bluetoothDevice) {
                cn.com.xm.bt.a.a.b("BleScanCenter", "onInitializationSuccess");
                atomicBoolean.set(true);
                conditionVariable.open();
            }
        });
        aVar2.b(false);
        aVar2.a();
        conditionVariable.block(20000);
        ArrayList arrayList = new ArrayList();
        if (atomicBoolean.get()) {
            for (BluetoothGattService next : aVar2.m()) {
                cn.com.xm.bt.c.c.a(next);
                cn.com.xm.bt.a.a.b("BleScanCenter", "UUID:" + next.getUuid());
                arrayList.add(next.getUuid().toString());
            }
            bVar = aVar2.r();
            cn.com.xm.bt.a.a.b("BleScanCenter", "Device info:".concat(String.valueOf(bVar)));
        } else {
            bVar = null;
        }
        aVar2.b();
        aVar.onDeviceInfoObtained(arrayList, bVar);
    }
}
