package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;

public class MultiProcessor<T> implements Detector.Processor<T> {
    /* access modifiers changed from: private */
    public int zzai;
    /* access modifiers changed from: private */
    public Factory<T> zzax;
    private SparseArray<zza> zzay;

    public static class Builder<T> {
        private MultiProcessor<T> zzaz = new MultiProcessor<>();

        public Builder(Factory<T> factory) {
            if (factory != null) {
                Factory unused = this.zzaz.zzax = factory;
                return;
            }
            throw new IllegalArgumentException("No factory supplied.");
        }

        public MultiProcessor<T> build() {
            return this.zzaz;
        }

        public Builder<T> setMaxGapFrames(int i) {
            if (i >= 0) {
                int unused = this.zzaz.zzai = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid max gap: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    class zza {
        /* access modifiers changed from: private */
        public Tracker<T> zzah;
        /* access modifiers changed from: private */
        public int zzal;

        private zza(MultiProcessor multiProcessor) {
            this.zzal = 0;
        }

        static /* synthetic */ int zzb(zza zza) {
            int i = zza.zzal;
            zza.zzal = i + 1;
            return i;
        }
    }

    private MultiProcessor() {
        this.zzay = new SparseArray<>();
        this.zzai = 3;
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            T valueAt = detectedItems.valueAt(i);
            if (this.zzay.get(keyAt) == null) {
                zza zza2 = new zza();
                Tracker unused = zza2.zzah = this.zzax.create(valueAt);
                zza2.zzah.onNewItem(keyAt, valueAt);
                this.zzay.append(keyAt, zza2);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i2 = 0; i2 < this.zzay.size(); i2++) {
            int keyAt2 = this.zzay.keyAt(i2);
            if (detectedItems2.get(keyAt2) == null) {
                zza valueAt2 = this.zzay.valueAt(i2);
                zza.zzb(valueAt2);
                if (valueAt2.zzal >= this.zzai) {
                    valueAt2.zzah.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    valueAt2.zzah.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzay.delete(intValue.intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i3 = 0; i3 < detectedItems3.size(); i3++) {
            int keyAt3 = detectedItems3.keyAt(i3);
            T valueAt3 = detectedItems3.valueAt(i3);
            zza zza3 = this.zzay.get(keyAt3);
            int unused2 = zza3.zzal = 0;
            zza3.zzah.onUpdate(detections, valueAt3);
        }
    }

    public void release() {
        for (int i = 0; i < this.zzay.size(); i++) {
            this.zzay.valueAt(i).zzah.onDone();
        }
        this.zzay.clear();
    }
}
