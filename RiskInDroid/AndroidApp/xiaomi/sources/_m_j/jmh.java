package _m_j;

import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.barcode.Barcode;
import org.reactnative.barcodedetector.RNBarcodeDetector;

public final class jmh extends AsyncTask<Void, Void, SparseArray<Barcode>> {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f1957O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private RNBarcodeDetector O00000oO;
    private jmi O00000oo;
    private double O0000O0o;
    private double O0000OOo;
    private int O0000Oo;
    private jmp O0000Oo0;
    private int O0000OoO;

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.O00000oo.O000000o(this.O00000oO);
            return;
        }
        if (sparseArray.size() > 0) {
            jmi jmi = this.O00000oo;
            WritableArray createArray = Arguments.createArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                Barcode barcode = (Barcode) sparseArray.valueAt(i);
                WritableMap createMap = Arguments.createMap();
                createMap.putString("data", barcode.displayValue);
                createMap.putString("rawData", barcode.rawValue);
                createMap.putString("type", jlr.O000000o(barcode.format));
                Rect boundingBox = barcode.getBoundingBox();
                WritableMap createMap2 = Arguments.createMap();
                int i2 = boundingBox.left;
                int i3 = boundingBox.top;
                if (boundingBox.left < this.O00000Oo / 2) {
                    i2 += this.O0000Oo / 2;
                } else if (boundingBox.left > this.O00000Oo / 2) {
                    i2 -= this.O0000Oo / 2;
                }
                if (boundingBox.top < this.O00000o0 / 2) {
                    i3 += this.O0000OoO / 2;
                } else if (boundingBox.top > this.O00000o0 / 2) {
                    i3 -= this.O0000OoO / 2;
                }
                double d = (double) i2;
                double d2 = this.O0000O0o;
                Double.isNaN(d);
                createMap2.putDouble("x", d * d2);
                double d3 = (double) i3;
                double d4 = this.O0000OOo;
                Double.isNaN(d3);
                createMap2.putDouble("y", d3 * d4);
                WritableMap createMap3 = Arguments.createMap();
                double width = (double) boundingBox.width();
                double d5 = this.O0000O0o;
                Double.isNaN(width);
                createMap3.putDouble("width", width * d5);
                double height = (double) boundingBox.height();
                double d6 = this.O0000OOo;
                Double.isNaN(height);
                createMap3.putDouble("height", height * d6);
                WritableMap createMap4 = Arguments.createMap();
                createMap4.putMap("origin", createMap2);
                createMap4.putMap("size", createMap3);
                createMap.putMap("bounds", createMap4);
                createArray.pushMap(createMap);
            }
            jmi.O00000Oo(createArray);
        }
        this.O00000oo.O00000o0();
    }

    public jmh(jmi jmi, RNBarcodeDetector rNBarcodeDetector, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.f1957O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = i3;
        this.O00000oo = jmi;
        this.O00000oO = rNBarcodeDetector;
        this.O0000Oo0 = new jmp(i, i2, i3, i4);
        double d = (double) i5;
        double O000000o2 = (double) (((float) this.O0000Oo0.O000000o()) * f);
        Double.isNaN(d);
        Double.isNaN(O000000o2);
        this.O0000O0o = d / O000000o2;
        double d2 = (double) i6;
        double O00000Oo2 = (double) (((float) this.O0000Oo0.O00000Oo()) * f);
        Double.isNaN(d2);
        Double.isNaN(O00000Oo2);
        this.O0000OOo = d2 / O00000Oo2;
        this.O0000Oo = i7;
        this.O0000OoO = i8;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        RNBarcodeDetector rNBarcodeDetector;
        if (isCancelled() || this.O00000oo == null || (rNBarcodeDetector = this.O00000oO) == null || !rNBarcodeDetector.O000000o()) {
            return null;
        }
        jmu O000000o2 = jmv.O000000o(this.f1957O000000o, this.O00000Oo, this.O00000o0, this.O00000o);
        RNBarcodeDetector rNBarcodeDetector2 = this.O00000oO;
        if (!O000000o2.O00000Oo.equals(rNBarcodeDetector2.O00000oo)) {
            rNBarcodeDetector2.O00000o0();
        }
        if (rNBarcodeDetector2.O00000oO == null) {
            rNBarcodeDetector2.O00000o();
            rNBarcodeDetector2.O00000oo = O000000o2.O00000Oo;
        }
        return rNBarcodeDetector2.O00000oO.detect(O000000o2.f1965O000000o);
    }
}
