package com.xiaomi.printer;

import _m_j.ekz;
import _m_j.fdb;
import _m_j.fno;
import _m_j.gsy;
import _m_j.hmb;
import android.annotation.TargetApi;
import android.content.pm.ApplicationInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrintJob;
import android.printservice.PrintService;
import android.printservice.PrinterDiscoverySession;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.xiaomi.printer.MiPrintService;
import com.xiaomi.smarthome.device.api.printer.PrintJobProxy;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(19)
public class MiPrintService extends PrintService {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<Runnable> f6354O000000o = new ArrayList<>();
    private ArrayList<hmb> O00000Oo = new ArrayList<>();

    public void onCreate() {
        super.onCreate();
        CoreApi.O000000o().O000000o(this, new CoreApi.O0000o0() {
            /* class com.xiaomi.printer.MiPrintService.AnonymousClass1 */

            public final void onCoreReady() {
                fno.O000000o().O000000o(new fno.O00000o() {
                    /* class com.xiaomi.printer.$$Lambda$MiPrintService$1$T4tsmYGVK7vyrpxy6cDYpzYJQPs */

                    public final void onDeviceReady(Map map) {
                        MiPrintService.AnonymousClass1.this.O000000o(map);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(Map map) {
                Iterator<Runnable> it = MiPrintService.this.f6354O000000o.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                MiPrintService.this.f6354O000000o = null;
            }
        });
        ArrayList<Runnable> arrayList = this.f6354O000000o;
        if (arrayList == null) {
            create();
        } else {
            arrayList.add(new Runnable() {
                /* class com.xiaomi.printer.MiPrintService.AnonymousClass2 */

                public final void run() {
                    MiPrintService.this.create();
                }
            });
        }
    }

    public void create() {
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            for (String next : applicationInfo.metaData.keySet()) {
                if (next != null && next.startsWith("MIPRINT_")) {
                    String string = applicationInfo.metaData.getString(next);
                    try {
                        hmb hmb = (hmb) fdb.O000000o(Class.forName(string), new Object[0]);
                        if (hmb != null) {
                            this.O00000Oo.add(hmb);
                        }
                    } catch (Exception e) {
                        Log.e("MiPrintService", "fatal".concat(String.valueOf(string)), e);
                    }
                }
            }
            gsy.O00000Oo("MiPrintService", "getDevice  " + this.O00000Oo);
        } catch (Exception e2) {
            Log.e("MiPrintService", "GET_META_DATA", e2);
        }
    }

    public void onConnected() {
        super.onConnected();
        gsy.O00000Oo("MiPrintService", "onConnected");
        ArrayList<Runnable> arrayList = this.f6354O000000o;
        if (arrayList == null) {
            connect();
        } else {
            arrayList.add(new Runnable() {
                /* class com.xiaomi.printer.MiPrintService.AnonymousClass3 */

                public final void run() {
                    MiPrintService.this.connect();
                }
            });
        }
    }

    public void connect() {
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000Oo.get(size);
            try {
                hmb.O00000Oo();
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public PrinterDiscoverySession onCreatePrinterDiscoverySession() {
        return new ekz(this, this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onRequestCancelPrintJob(final PrintJob printJob) {
        gsy.O00000Oo("MiPrintService", "onRequestCancelPrintJob  ".concat(String.valueOf(printJob)));
        ArrayList<Runnable> arrayList = this.f6354O000000o;
        if (arrayList == null) {
            onRequestCancelPrintJob(new PrintJobProxy(printJob));
        } else {
            arrayList.add(new Runnable() {
                /* class com.xiaomi.printer.MiPrintService.AnonymousClass4 */

                public final void run() {
                    MiPrintService.this.onRequestCancelPrintJob(new PrintJobProxy(printJob));
                }
            });
        }
    }

    public void onRequestCancelPrintJob(PrintJobProxy printJobProxy) {
        PrinterId printerId = printJobProxy.getInfo().getPrinterId();
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000Oo.get(size);
            try {
                List<PrinterInfo> O000000o2 = hmb.O000000o();
                if (O000000o2 != null) {
                    Iterator<PrinterInfo> it = O000000o2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            PrinterInfo next = it.next();
                            if (next != null && next.getId().equals(printerId)) {
                                hmb.O000000o(next, printJobProxy);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPrintJobQueued(final PrintJob printJob) {
        gsy.O00000Oo("MiPrintService", "onPrintJobQueued  ".concat(String.valueOf(printJob)));
        ArrayList<Runnable> arrayList = this.f6354O000000o;
        if (arrayList == null) {
            onPrintJobQueued(new PrintJobProxy(printJob));
        } else {
            arrayList.add(new Runnable() {
                /* class com.xiaomi.printer.MiPrintService.AnonymousClass5 */

                public final void run() {
                    MiPrintService.this.onPrintJobQueued(new PrintJobProxy(printJob));
                }
            });
        }
    }

    public void onPrintJobQueued(PrintJobProxy printJobProxy) {
        PrinterId printerId = printJobProxy.getInfo().getPrinterId();
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000Oo.get(size);
            try {
                List<PrinterInfo> O000000o2 = hmb.O000000o();
                if (O000000o2 != null) {
                    Iterator<PrinterInfo> it = O000000o2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            PrinterInfo next = it.next();
                            if (next != null && next.getId().equals(printerId)) {
                                hmb.O000000o(this, next, printJobProxy);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public void onDisconnected() {
        super.onDisconnected();
        gsy.O00000Oo("MiPrintService", "onDisconnected");
        ArrayList<Runnable> arrayList = this.f6354O000000o;
        if (arrayList == null) {
            disconnect();
        } else {
            arrayList.add(new Runnable() {
                /* class com.xiaomi.printer.MiPrintService.AnonymousClass6 */

                public final void run() {
                    MiPrintService.this.disconnect();
                }
            });
        }
    }

    public void disconnect() {
        for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000Oo.get(size);
            try {
                hmb.O00000o0();
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O00000Oo("MiPrintService", "onDestroy");
        this.O00000Oo.clear();
    }
}
