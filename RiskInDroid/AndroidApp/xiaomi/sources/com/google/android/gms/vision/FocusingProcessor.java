package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;

public abstract class FocusingProcessor<T> implements Detector.Processor<T> {
    private Tracker<T> zzah;
    private int zzai = 3;
    private boolean zzaj = false;
    private int zzak;
    private int zzal = 0;
    private Detector<T> zzr;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzr = detector;
        this.zzah = tracker;
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzal == this.zzai) {
                this.zzah.onDone();
                this.zzaj = false;
            } else {
                this.zzah.onMissing(detections);
            }
            this.zzal++;
            return;
        }
        this.zzal = 0;
        if (this.zzaj) {
            T t = detectedItems.get(this.zzak);
            if (t != null) {
                this.zzah.onUpdate(detections, t);
                return;
            } else {
                this.zzah.onDone();
                this.zzaj = false;
            }
        }
        int selectFocus = selectFocus(detections);
        T t2 = detectedItems.get(selectFocus);
        if (t2 == null) {
            StringBuilder sb = new StringBuilder(35);
            sb.append("Invalid focus selected: ");
            sb.append(selectFocus);
            Log.w("FocusingProcessor", sb.toString());
            return;
        }
        this.zzaj = true;
        this.zzak = selectFocus;
        this.zzr.setFocus(this.zzak);
        this.zzah.onNewItem(this.zzak, t2);
        this.zzah.onUpdate(detections, t2);
    }

    public void release() {
        this.zzah.onDone();
    }

    public abstract int selectFocus(Detector.Detections<T> detections);

    public final void zza(int i) {
        if (i >= 0) {
            this.zzai = i;
            return;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("Invalid max gap: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
