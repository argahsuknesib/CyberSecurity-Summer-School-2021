package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame;

public abstract class Detector<T> {
    private final Object zzac = new Object();
    private Processor<T> zzad;

    public static class Detections<T> {
        private final SparseArray<T> zzae;
        private final Frame.Metadata zzaf;
        private final boolean zzag;

        public Detections(SparseArray<T> sparseArray, Frame.Metadata metadata, boolean z) {
            this.zzae = sparseArray;
            this.zzaf = metadata;
            this.zzag = z;
        }

        public boolean detectorIsOperational() {
            return this.zzag;
        }

        public SparseArray<T> getDetectedItems() {
            return this.zzae;
        }

        public Frame.Metadata getFrameMetadata() {
            return this.zzaf;
        }
    }

    public interface Processor<T> {
        void receiveDetections(Detections<T> detections);

        void release();
    }

    public abstract SparseArray<T> detect(Frame frame);

    public boolean isOperational() {
        return true;
    }

    public void receiveFrame(Frame frame) {
        Frame.Metadata metadata = new Frame.Metadata(frame.getMetadata());
        metadata.zzd();
        Detections detections = new Detections(detect(frame), metadata, isOperational());
        synchronized (this.zzac) {
            if (this.zzad != null) {
                this.zzad.receiveDetections(detections);
            } else {
                throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
            }
        }
    }

    public void release() {
        synchronized (this.zzac) {
            if (this.zzad != null) {
                this.zzad.release();
                this.zzad = null;
            }
        }
    }

    public boolean setFocus(int i) {
        return true;
    }

    public void setProcessor(Processor<T> processor) {
        synchronized (this.zzac) {
            if (this.zzad != null) {
                this.zzad.release();
            }
            this.zzad = processor;
        }
    }
}
