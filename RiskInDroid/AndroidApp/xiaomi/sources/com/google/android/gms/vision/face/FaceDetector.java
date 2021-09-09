package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;

public final class FaceDetector extends Detector<Face> {
    private boolean mIsActive;
    private final Object mLock;
    private final zzc zzbm;
    private final zza zzbn;

    public static class Builder {
        private final Context mContext;
        private int zzbo = 0;
        private boolean zzbp = false;
        private int zzbq = 0;
        private boolean zzbr = true;
        private int zzbs = 0;
        private float zzbt = -1.0f;

        public Builder(Context context) {
            this.mContext = context;
        }

        public FaceDetector build() {
            com.google.android.gms.vision.face.internal.client.zzc zzc = new com.google.android.gms.vision.face.internal.client.zzc();
            zzc.mode = this.zzbs;
            zzc.zzcd = this.zzbo;
            zzc.zzce = this.zzbq;
            zzc.zzcf = this.zzbp;
            zzc.zzcg = this.zzbr;
            zzc.zzch = this.zzbt;
            return new FaceDetector(new zza(this.mContext, zzc));
        }

        public Builder setClassificationType(int i) {
            if (i == 0 || i == 1) {
                this.zzbq = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append("Invalid classification type: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setLandmarkType(int i) {
            if (i == 0 || i == 1) {
                this.zzbo = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid landmark type: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setMinFaceSize(float f) {
            if (f < 0.0f || f > 1.0f) {
                StringBuilder sb = new StringBuilder(47);
                sb.append("Invalid proportional face size: ");
                sb.append(f);
                throw new IllegalArgumentException(sb.toString());
            }
            this.zzbt = f;
            return this;
        }

        public Builder setMode(int i) {
            if (i == 0 || i == 1) {
                this.zzbs = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid mode: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setProminentFaceOnly(boolean z) {
            this.zzbp = z;
            return this;
        }

        public Builder setTrackingEnabled(boolean z) {
            this.zzbr = z;
            return this;
        }
    }

    private FaceDetector() {
        this.zzbm = new zzc();
        this.mLock = new Object();
        this.mIsActive = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zza zza) {
        this.zzbm = new zzc();
        this.mLock = new Object();
        this.mIsActive = true;
        this.zzbn = zza;
    }

    public final SparseArray<Face> detect(Frame frame) {
        Face[] zzb;
        if (frame != null) {
            ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
            synchronized (this.mLock) {
                if (this.mIsActive) {
                    zzb = this.zzbn.zzb(grayscaleImageData, zzk.zzc(frame));
                } else {
                    throw new RuntimeException("Cannot use detector after release()");
                }
            }
            HashSet hashSet = new HashSet();
            SparseArray<Face> sparseArray = new SparseArray<>(zzb.length);
            int i = 0;
            for (Face face : zzb) {
                int id = face.getId();
                i = Math.max(i, id);
                if (hashSet.contains(Integer.valueOf(id))) {
                    id = i + 1;
                    i = id;
                }
                hashSet.add(Integer.valueOf(id));
                sparseArray.append(this.zzbm.zzb(id), face);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this.mLock) {
                if (this.mIsActive) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final boolean isOperational() {
        return this.zzbn.isOperational();
    }

    public final void release() {
        super.release();
        synchronized (this.mLock) {
            if (this.mIsActive) {
                this.zzbn.zzg();
                this.mIsActive = false;
            }
        }
    }

    public final boolean setFocus(int i) {
        boolean zzd;
        int zzc = this.zzbm.zzc(i);
        synchronized (this.mLock) {
            if (this.mIsActive) {
                zzd = this.zzbn.zzd(zzc);
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        return zzd;
    }
}
