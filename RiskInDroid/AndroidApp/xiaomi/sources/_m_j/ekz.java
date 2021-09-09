package _m_j;

import android.annotation.TargetApi;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrinterDiscoverySession;
import android.util.Log;
import com.xiaomi.printer.MiPrintService;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.printer.PrinterControl;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class ekz extends PrinterDiscoverySession implements hma, PrinterControl.OnAddPrinterListener {

    /* renamed from: O000000o  reason: collision with root package name */
    hma f15592O000000o;
    PrinterControl.OnAddPrinterListener O00000Oo;
    private final ArrayList<hmb> O00000o;
    private final MiPrintService O00000o0;
    private hmd O00000oO = new hmd(this, this);

    public ekz(final MiPrintService miPrintService, final ArrayList<hmb> arrayList) {
        this.O00000o0 = miPrintService;
        this.O00000o = arrayList;
        if (miPrintService.f6354O000000o == null) {
            O000000o(arrayList);
        } else {
            miPrintService.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass1 */

                public final void run() {
                    ekz.O000000o((ArrayList<hmb>) arrayList);
                }
            });
        }
    }

    public static void O000000o(ArrayList<hmb> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            hmb hmb = arrayList.get(size);
            try {
                hmb.O00000o();
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final void onStartPrinterDiscovery(final List<PrinterId> list) {
        gsy.O00000Oo("MiPrinterDiscoverySession", "onStartPrinterDiscovery  ".concat(String.valueOf(list)));
        if (this.O00000o0.f6354O000000o == null) {
            O000000o();
        } else {
            this.O00000o0.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass2 */

                public final void run() {
                    ekz.this.O000000o();
                }
            });
        }
    }

    public final void O000000o() {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000o.get(size);
            try {
                MiPrintService miPrintService = this.O00000o0;
                hmd hmd = this.O00000oO;
                if (this.f15592O000000o == null) {
                    this.f15592O000000o = this;
                }
                hmb.O000000o(miPrintService, hmd, this.f15592O000000o);
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final void onStopPrinterDiscovery() {
        gsy.O00000Oo("MiPrinterDiscoverySession", "onStopPrinterDiscovery");
        if (this.O00000o0.f6354O000000o == null) {
            O00000Oo();
        } else {
            this.O00000o0.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass3 */

                public final void run() {
                    ekz.this.O00000Oo();
                }
            });
        }
    }

    public final void O00000Oo() {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000o.get(size);
            try {
                hmb.O00000oO();
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final void onValidatePrinters(final List<PrinterId> list) {
        gsy.O00000Oo("MiPrinterDiscoverySession", "onValidatePrinters  ".concat(String.valueOf(list)));
        if (this.O00000o0.f6354O000000o == null) {
            O000000o(list);
        } else {
            this.O00000o0.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass4 */

                public final void run() {
                    ekz.this.O000000o(list);
                }
            });
        }
    }

    public final void O000000o(List<PrinterId> list) {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000o.get(size);
            try {
                List<PrinterInfo> O000000o2 = hmb.O000000o();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < O000000o2.size(); i++) {
                    PrinterInfo printerInfo = O000000o2.get(size);
                    if (printerInfo != null && list.contains(printerInfo.getId())) {
                        arrayList.add(printerInfo);
                    }
                }
                hmb.O0000OOo();
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final void onStartPrinterStateTracking(final PrinterId printerId) {
        gsy.O00000Oo("MiPrinterDiscoverySession", "onStartPrinterStateTracking  ".concat(String.valueOf(printerId)));
        if (this.O00000o0.f6354O000000o == null) {
            O000000o(printerId);
        } else {
            this.O00000o0.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass5 */

                public final void run() {
                    ekz.this.O000000o(printerId);
                }
            });
        }
    }

    public final void O000000o(PrinterId printerId) {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000o.get(size);
            try {
                List<PrinterInfo> O000000o2 = hmb.O000000o();
                if (O000000o2 != null) {
                    for (PrinterInfo next : O000000o2) {
                        if (next != null && next.getId().equals(printerId)) {
                            hmb.O000000o(this.O00000oO, printerId, next);
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final void onStopPrinterStateTracking(final PrinterId printerId) {
        gsy.O00000Oo("MiPrinterDiscoverySession", "onStopPrinterStateTracking  ".concat(String.valueOf(printerId)));
        if (this.O00000o0.f6354O000000o == null) {
            O00000Oo(printerId);
        } else {
            this.O00000o0.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass6 */

                public final void run() {
                    ekz.this.O00000Oo(printerId);
                }
            });
        }
    }

    public final void O00000Oo(PrinterId printerId) {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000o.get(size);
            try {
                List<PrinterInfo> O000000o2 = hmb.O000000o();
                if (O000000o2 != null) {
                    for (PrinterInfo next : O000000o2) {
                        if (next != null && next.getId().equals(printerId)) {
                            hmb.O00000oo();
                        }
                    }
                }
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final void onDestroy() {
        gsy.O00000Oo("MiPrinterDiscoverySession", "onDestroy");
        if (this.O00000o0.f6354O000000o == null) {
            O00000o0();
        } else {
            this.O00000o0.f6354O000000o.add(new Runnable() {
                /* class _m_j.ekz.AnonymousClass7 */

                public final void run() {
                    ekz.this.O00000o0();
                }
            });
        }
    }

    public final void O00000o0() {
        for (int size = this.O00000o.size() - 1; size >= 0; size--) {
            hmb hmb = this.O00000o.get(size);
            try {
                hmb.O0000O0o();
            } catch (Throwable th) {
                Log.e("fatal", hmb.toString(), th);
            }
        }
    }

    public final ArrayList<DeviceStat> getDevice(List<String> list) {
        ArrayList<DeviceStat> arrayList = new ArrayList<>();
        List<DeviceStat> deviceList = XmPluginHostApi.instance().getDeviceList();
        if (!(deviceList == null || list == null)) {
            for (DeviceStat next : deviceList) {
                if (list.contains(next.model) && next.isOnline) {
                    arrayList.add(next);
                }
            }
        }
        gsy.O00000Oo("MiPrinterDiscoverySession", "getDevice  " + list + "  " + arrayList);
        return arrayList;
    }

    public final void onAddPrinters(List<PrinterInfo> list) {
        PrinterControl.OnAddPrinterListener onAddPrinterListener = this.O00000Oo;
        if (onAddPrinterListener != null) {
            onAddPrinterListener.onAddPrinters(list);
        }
    }
}
