package cn.com.xm.bt.e;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.com.xm.bt.b.b;
import cn.com.xm.bt.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3092a;
    /* access modifiers changed from: private */
    public static volatile int q;
    /* access modifiers changed from: private */
    public static volatile int r;
    private static volatile int s;
    private static volatile int t;
    private final boolean b = false;
    private final BluetoothAdapter c = BluetoothAdapter.getDefaultAdapter();
    private BluetoothAdapter.LeScanCallback d = null;
    private Handler e = null;
    /* access modifiers changed from: private */
    public Context f = null;
    private final int g = 0;
    private final int h = 3000;
    private final int i = 0;
    private final int j = 1;
    private final int k = 2;
    private final int l = 3;
    private final int m = 4;
    private final int n = 5;
    /* access modifiers changed from: private */
    public volatile boolean o = false;
    /* access modifiers changed from: private */
    public final List<b> p = new ArrayList();

    static /* synthetic */ int b() {
        int i2 = q + 1;
        q = i2;
        return i2;
    }

    static /* synthetic */ int e() {
        int i2 = r + 1;
        r = i2;
        return i2;
    }

    public static void a(Context context) {
        if (f3092a == null) {
            f3092a = new a(context);
        }
    }

    public static a a() {
        return f3092a;
    }

    private a(Context context) {
        this.f = context;
        HandlerThread handlerThread = new HandlerThread("BleScanCenter");
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper()) {
            /* class cn.com.xm.bt.e.a.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: cn.com.xm.bt.e.a.a(cn.com.xm.bt.e.a, boolean):boolean
             arg types: [cn.com.xm.bt.e.a, int]
             candidates:
              cn.com.xm.bt.e.a.a(cn.com.xm.bt.e.a, android.content.Context):java.util.List
              cn.com.xm.bt.e.a.a(java.util.List<java.util.UUID>, cn.com.xm.bt.d.a):boolean
              cn.com.xm.bt.e.a.a(cn.com.xm.bt.e.a, boolean):boolean */
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 0) {
                    boolean z = true;
                    if (i == 1) {
                        cn.com.xm.bt.a.a.a("BleScanCenter", "COUNT-SCAN******MSG_STOP_SCAN:<" + a.q + "," + a.e() + ">");
                        a.this.g();
                    } else if (i == 2) {
                        cn.com.xm.bt.d.a aVar = (cn.com.xm.bt.d.a) message.obj;
                        if (aVar != null && !a.this.o) {
                            for (b bVar : a.this.p) {
                                List<UUID> b = bVar.b();
                                if (b == null || b.size() <= 0) {
                                    if (bVar.c() != null && !aVar.f3087a.getAddress().contains(bVar.c())) {
                                    }
                                } else if (!a.this.a(b, aVar)) {
                                }
                                bVar.d().a(aVar, bVar);
                            }
                        }
                    } else if (i == 3) {
                        cn.com.xm.bt.a.a.a("BleScanCenter", "COUNT-SCAN******MSG_PAUSE_SCAN:<" + a.q + "," + a.e() + ">");
                        a.this.g();
                        Message message2 = new Message();
                        message2.what = 0;
                        message2.obj = message.obj;
                        sendMessageDelayed(message2, 0);
                    } else if (i == 4) {
                        b bVar2 = (b) message.obj;
                        if (a.this.p.remove(bVar2)) {
                            bVar2.d().b(bVar2);
                        }
                        if (a.this.p.size() <= 0) {
                            boolean unused = a.this.o = true;
                            removeMessages(3);
                            removeMessages(0);
                            sendEmptyMessage(1);
                        }
                        cn.com.xm.bt.a.a.a("BleScanCenter", "COUNT-SCAN******MSG_SCAN_TIMEOUT:<" + bVar2 + ">[" + a.this.p.size() + "]");
                    } else if (i == 5) {
                        b bVar3 = (b) message.obj;
                        if (bVar3 == null || a.this.p.contains(bVar3)) {
                            cn.com.xm.bt.a.a.a("BleScanCenter", "null or exist BleScanOption,return now!!!");
                            return;
                        }
                        boolean unused2 = a.this.o = false;
                        a.this.p.add(bVar3);
                        cn.com.xm.bt.a.a.a("BleScanCenter", "COUNT-SCAN******MSG_ADD_SCAN_OPTION:<" + bVar3 + ">[" + a.this.p.size() + "]");
                        d d = bVar3.d();
                        if (d != null) {
                            d.a(bVar3);
                        }
                        if (bVar3.e()) {
                            a aVar2 = a.this;
                            List a2 = aVar2.b(aVar2.f);
                            if (a2 != null && a2.size() > 0) {
                                a aVar3 = a.this;
                                Context e = aVar3.f;
                                if (bVar3.b() == null) {
                                    z = false;
                                }
                                aVar3.a(e, a2, z);
                            }
                        }
                        removeMessages(0);
                        sendEmptyMessage(0);
                        if (bVar3.a() > 0) {
                            Message message3 = new Message();
                            message3.what = 4;
                            message3.obj = bVar3;
                            sendMessageDelayed(message3, (long) bVar3.a());
                        }
                    }
                } else {
                    cn.com.xm.bt.a.a.a("BleScanCenter", "COUNT-SCAN******MSG_START_SCAN:<" + a.b() + "," + a.r + ">");
                    if (a.this.o) {
                        cn.com.xm.bt.a.a.b("BleScanCenter", "need stop,return!!!");
                        return;
                    }
                    a.this.g();
                    a.this.f();
                    removeMessages(3);
                    sendEmptyMessageDelayed(3, 3000);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public boolean a(List<UUID> list, cn.com.xm.bt.d.a aVar) {
        for (UUID a2 : list) {
            if (aVar.a(a2)) {
                return true;
            }
        }
        return false;
    }

    public void a(b bVar) {
        cn.com.xm.bt.a.a.a("BleScanCenter", "startScan<" + bVar + ">");
        if (bVar != null) {
            Message message = new Message();
            message.what = 5;
            message.obj = bVar;
            this.e.sendMessage(message);
        }
    }

    public void b(b bVar) {
        cn.com.xm.bt.a.a.a("BleScanCenter", "stopScan<" + bVar + ">");
        if (bVar != null) {
            Message message = new Message();
            message.what = 4;
            message.obj = bVar;
            this.e.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    public List<BluetoothDevice> b(Context context) {
        HashMap hashMap = new HashMap();
        for (BluetoothDevice next : ((BluetoothManager) context.getSystemService("bluetooth")).getConnectedDevices(7)) {
            hashMap.put(next.getAddress(), next);
        }
        return new ArrayList(hashMap.values());
    }

    /* access modifiers changed from: private */
    public void a(Context context, List<BluetoothDevice> list, boolean z) {
        for (BluetoothDevice next : list) {
            cn.com.xm.bt.a.a.a("BleScanCenter", "connected device:" + next.getAddress() + " " + next.getName());
            if (!z) {
                a(next, (ArrayList<String>) null, b.VDEVICE);
            } else {
                c.a(context, next, new c.a(next) {
                    /* class cn.com.xm.bt.e.$$Lambda$a$9pZg6SuT8cTYCXHw2wTJwxHCyvg */
                    private final /* synthetic */ BluetoothDevice f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onDeviceInfoObtained(ArrayList arrayList, cn.com.xm.bt.d.b bVar) {
                        a.this.a(this.f$1, arrayList, bVar);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, ArrayList arrayList, cn.com.xm.bt.d.b bVar) {
        cn.com.xm.bt.a.a.b("BleScanCenter", "onDeviceInfoObtained:".concat(String.valueOf(bVar)));
        a(bluetoothDevice, arrayList, bVar != null ? bVar.a() : b.VDEVICE);
    }

    /* access modifiers changed from: private */
    public void f() {
        StringBuilder sb = new StringBuilder("startForNormal:");
        int i2 = s + 1;
        s = i2;
        sb.append(i2);
        cn.com.xm.bt.a.a.a("BleScanCenter", sb.toString());
        if (this.d == null) {
            this.d = new BluetoothAdapter.LeScanCallback() {
                /* class cn.com.xm.bt.e.$$Lambda$a$MGz9zLuQxARjy6rH2bohLHHrZ2g */

                public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                    a.this.a(bluetoothDevice, i, bArr);
                }
            };
        }
        try {
            this.c.startLeScan(this.d);
        } catch (Exception e2) {
            cn.com.xm.bt.a.a.a("BleScanCenter", "startLeScan exception:" + e2.getMessage());
            g();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.d != null) {
            StringBuilder sb = new StringBuilder("stopForNormal:");
            int i2 = t + 1;
            t = i2;
            sb.append(i2);
            cn.com.xm.bt.a.a.a("BleScanCenter", sb.toString());
            try {
                this.c.stopLeScan(this.d);
            } catch (Exception e2) {
                cn.com.xm.bt.a.a.a("BleScanCenter", "stopLeScan exception:" + e2.getMessage());
            } finally {
                this.d = null;
            }
        }
    }

    private void a(BluetoothDevice bluetoothDevice, ArrayList<String> arrayList, b bVar) {
        cn.com.xm.bt.d.a aVar = new cn.com.xm.bt.d.a();
        if (arrayList != null) {
            aVar.f.addAll(arrayList);
        }
        aVar.f3087a = bluetoothDevice;
        aVar.b = 0;
        aVar.o = bVar;
        a(aVar);
    }

    /* access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        cn.com.xm.bt.d.a c2 = cn.com.xm.bt.c.c.c(bArr);
        c2.f3087a = bluetoothDevice;
        c2.b = i2;
        a(c2);
    }

    private void a(cn.com.xm.bt.d.a aVar) {
        Message message = new Message();
        message.what = 2;
        message.obj = aVar;
        this.e.sendMessage(message);
    }
}
