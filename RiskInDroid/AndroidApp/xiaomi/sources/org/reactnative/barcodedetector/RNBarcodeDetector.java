package org.reactnative.barcodedetector;

import _m_j.jmp;
import android.content.Context;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class RNBarcodeDetector {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f15469O000000o = 0;
    public static int O00000Oo = 1;
    public static int O00000o = 0;
    public static int O00000o0 = 2;
    public BarcodeDetector O00000oO = null;
    public jmp O00000oo;
    private BarcodeDetector.Builder O0000O0o;
    private int O0000OOo = 0;

    public RNBarcodeDetector(Context context) {
        this.O0000O0o = new BarcodeDetector.Builder(context).setBarcodeFormats(this.O0000OOo);
    }

    public final boolean O000000o() {
        if (this.O00000oO == null) {
            O00000o();
        }
        return this.O00000oO.isOperational();
    }

    public final void O000000o(int i) {
        if (i != this.O0000OOo) {
            O00000Oo();
            this.O0000O0o.setBarcodeFormats(i);
            this.O0000OOo = i;
        }
    }

    public final void O00000Oo() {
        O00000o0();
        this.O00000oo = null;
    }

    public final void O00000o0() {
        BarcodeDetector barcodeDetector = this.O00000oO;
        if (barcodeDetector != null) {
            barcodeDetector.release();
            this.O00000oO = null;
        }
    }

    public final void O00000o() {
        this.O00000oO = this.O0000O0o.build();
    }
}
