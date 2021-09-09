package _m_j;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.print.PrinterInfo;
import android.printservice.PrinterDiscoverySession;
import com.google.android.exoplayer2.C;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.printer.MiPrintService;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.printer.PrintJobProxy;
import com.xiaomi.smarthome.device.api.printer.PrinterControl;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@RouterService
public class ela implements hma, Handler.Callback, PrinterControl {
    private DeviceStat device;
    private final Handler handler = new Handler(Looper.getMainLooper(), this);
    private PrinterControl.OnAddPrinterListener listener;
    private final MiPrintService miPrintService = new MiPrintService();
    private ekz printerDiscoverySession;
    private PrinterInfo printerInfo;

    public void onCreate(DeviceStat deviceStat) {
        this.device = deviceStat;
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.handler.sendMessage(obtain);
        Message obtain2 = Message.obtain();
        obtain2.what = 2;
        this.handler.sendMessage(obtain2);
        Message obtain3 = Message.obtain();
        obtain3.what = 3;
        this.handler.sendMessage(obtain3);
        Message obtain4 = Message.obtain();
        obtain4.what = 4;
        this.handler.sendMessage(obtain4);
    }

    public void onDestroy() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.handler.sendMessage(obtain);
        Message obtain2 = Message.obtain();
        obtain2.what = 10;
        this.handler.sendMessage(obtain2);
        Message obtain3 = Message.obtain();
        obtain3.what = 12;
        this.handler.sendMessage(obtain3);
        Message obtain4 = Message.obtain();
        obtain4.what = 11;
        this.handler.sendMessage(obtain4);
    }

    public void onStartPrinterStateTracking(PrinterControl.OnAddPrinterListener onAddPrinterListener) {
        this.listener = onAddPrinterListener;
        Message obtain = Message.obtain();
        obtain.what = 6;
        this.handler.sendMessage(obtain);
    }

    public void onStopPrinterStateTracking() {
        Message obtain = Message.obtain();
        obtain.what = 7;
        this.handler.sendMessage(obtain);
    }

    public void onPrintJobQueued(PrintJobProxy printJobProxy) {
        Message obtain = Message.obtain();
        obtain.what = 9;
        obtain.obj = printJobProxy;
        this.handler.sendMessage(obtain);
    }

    public void onRequestCancelPrintJob(PrintJobProxy printJobProxy) {
        Message obtain = Message.obtain();
        obtain.obj = printJobProxy;
        obtain.what = 8;
        this.handler.sendMessage(obtain);
    }

    @TargetApi(19)
    public boolean handleMessage(Message message) {
        PrinterInfo printerInfo2;
        PrinterInfo printerInfo3;
        switch (message.what) {
            case 1:
                this.miPrintService.onCreate();
                return true;
            case 2:
                this.miPrintService.onConnected();
                return true;
            case 3:
                PrinterDiscoverySession onCreatePrinterDiscoverySession = this.miPrintService.onCreatePrinterDiscoverySession();
                if (!(onCreatePrinterDiscoverySession instanceof ekz)) {
                    return true;
                }
                this.printerDiscoverySession = (ekz) onCreatePrinterDiscoverySession;
                this.printerDiscoverySession.f15592O000000o = this;
                return true;
            case 4:
                ekz ekz = this.printerDiscoverySession;
                if (ekz == null) {
                    return true;
                }
                ekz.onStartPrinterDiscovery(new ArrayList());
                List<PrinterInfo> printers = this.printerDiscoverySession.getPrinters();
                if (printers == null || printers.size() <= 0) {
                    return true;
                }
                this.printerInfo = printers.get(0);
                return true;
            case 5:
                ekz ekz2 = this.printerDiscoverySession;
                if (ekz2 == null) {
                    return true;
                }
                ekz2.onStopPrinterDiscovery();
                return true;
            case 6:
                ekz ekz3 = this.printerDiscoverySession;
                if (ekz3 == null || (printerInfo2 = this.printerInfo) == null) {
                    return true;
                }
                ekz3.onStartPrinterStateTracking(printerInfo2.getId());
                this.printerDiscoverySession.O00000Oo = this.listener;
                return true;
            case 7:
                ekz ekz4 = this.printerDiscoverySession;
                if (ekz4 == null || (printerInfo3 = this.printerInfo) == null) {
                    return true;
                }
                ekz4.onStopPrinterStateTracking(printerInfo3.getId());
                this.printerDiscoverySession.O00000Oo = null;
                return true;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                this.miPrintService.onRequestCancelPrintJob((PrintJobProxy) message.obj);
                return true;
            case 9:
                this.miPrintService.onPrintJobQueued((PrintJobProxy) message.obj);
                return true;
            case 10:
                ekz ekz5 = this.printerDiscoverySession;
                if (ekz5 == null) {
                    return true;
                }
                ekz5.onDestroy();
                return true;
            case 11:
                this.miPrintService.onDestroy();
                return true;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                this.miPrintService.onDisconnected();
                return true;
            default:
                return true;
        }
    }

    public ArrayList<DeviceStat> getDevice(List<String> list) {
        DeviceStat deviceStat = this.device;
        if (deviceStat == null || list.indexOf(deviceStat.model) < 0) {
            return null;
        }
        ArrayList<DeviceStat> arrayList = new ArrayList<>();
        arrayList.add(this.device);
        return arrayList;
    }
}
