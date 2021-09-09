package _m_j;

import android.annotation.TargetApi;
import android.print.PrinterInfo;
import android.printservice.PrinterDiscoverySession;
import com.xiaomi.smarthome.device.api.printer.PrinterControl;
import java.util.List;

@TargetApi(19)
public final class hmd {

    /* renamed from: O000000o  reason: collision with root package name */
    public final PrinterDiscoverySession f19058O000000o;
    private PrinterControl.OnAddPrinterListener O00000Oo;

    public hmd(PrinterDiscoverySession printerDiscoverySession, PrinterControl.OnAddPrinterListener onAddPrinterListener) {
        this.f19058O000000o = printerDiscoverySession;
        this.O00000Oo = onAddPrinterListener;
    }

    public final void O000000o(List<PrinterInfo> list) {
        this.f19058O000000o.addPrinters(list);
    }
}
