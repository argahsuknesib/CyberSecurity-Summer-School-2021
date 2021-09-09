package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzc;
import com.google.android.gms.internal.vision.zze;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;

public final class BarcodeDetector extends Detector<Barcode> {
    private final zze zzba;

    public static class Builder {
        private Context mContext;
        private zzc zzbb = new zzc();

        public Builder(Context context) {
            this.mContext = context;
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(new zze(this.mContext, this.zzbb));
        }

        public Builder setBarcodeFormats(int i) {
            this.zzbb.zzbc = i;
            return this;
        }
    }

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(zze zze) {
        this.zzba = zze;
    }

    public final SparseArray<Barcode> detect(Frame frame) {
        Barcode[] barcodeArr;
        if (frame != null) {
            zzk zzc = zzk.zzc(frame);
            if (frame.getBitmap() != null) {
                barcodeArr = this.zzba.zza(frame.getBitmap(), zzc);
                if (barcodeArr == null) {
                    throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
                }
            } else {
                barcodeArr = this.zzba.zza(frame.getGrayscaleImageData(), zzc);
            }
            SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArr.length);
            for (Barcode barcode : barcodeArr) {
                sparseArray.append(barcode.rawValue.hashCode(), barcode);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean isOperational() {
        return this.zzba.isOperational();
    }

    public final void release() {
        super.release();
        this.zzba.zzg();
    }
}
