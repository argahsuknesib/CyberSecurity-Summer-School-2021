package com.xiaomi.smarthome.device.api.printer;

import android.print.PrinterInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.util.List;

public interface PrinterControl {

    public interface OnAddPrinterListener {
        void onAddPrinters(List<PrinterInfo> list);
    }

    void onCreate(DeviceStat deviceStat);

    void onDestroy();

    void onPrintJobQueued(PrintJobProxy printJobProxy);

    void onRequestCancelPrintJob(PrintJobProxy printJobProxy);

    void onStartPrinterStateTracking(OnAddPrinterListener onAddPrinterListener);

    void onStopPrinterStateTracking();
}
