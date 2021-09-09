package com.xiaomi.smarthome.printer;

import _m_j.fbs;
import androidx.annotation.Keep;
import com.xiaomi.smarthome.device.api.printer.PrinterControl;

@Keep
public class SmartPrinterRouterFactory {
    public static PrinterControl getPrinterControl() {
        return (PrinterControl) fbs.O000000o(PrinterControl.class, "com.xiaomi.smarthome.smarthome-printer.PrinterControl");
    }
}
