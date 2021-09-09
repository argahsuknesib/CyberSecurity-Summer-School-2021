package no.nordicsemi.android.dfu;

import android.os.SystemClock;

class DfuProgressInfo {
    private int bytesReceived;
    private int bytesSent;
    private int currentPart;
    private int imageSizeInBytes;
    private int initialBytesSent;
    private int lastBytesSent;
    private long lastProgressTime;
    private final ProgressListener mListener;
    private int maxObjectSizeInBytes;
    private int progress;
    private long timeStart;
    private int totalParts;

    interface ProgressListener {
        void updateProgressNotification();
    }

    DfuProgressInfo(ProgressListener progressListener) {
        this.mListener = progressListener;
    }

    /* access modifiers changed from: package-private */
    public DfuProgressInfo init(int i, int i2, int i3) {
        this.imageSizeInBytes = i;
        this.maxObjectSizeInBytes = Integer.MAX_VALUE;
        this.currentPart = i2;
        this.totalParts = i3;
        return this;
    }

    /* access modifiers changed from: package-private */
    public DfuProgressInfo setTotalPart(int i) {
        this.totalParts = i;
        return this;
    }

    public void setProgress(int i) {
        this.progress = i;
        this.mListener.updateProgressNotification();
    }

    /* access modifiers changed from: package-private */
    public void setBytesSent(int i) {
        if (this.timeStart == 0) {
            this.timeStart = SystemClock.elapsedRealtime();
            this.initialBytesSent = i;
        }
        this.bytesSent = i;
        this.progress = (int) ((((float) i) * 100.0f) / ((float) this.imageSizeInBytes));
        this.mListener.updateProgressNotification();
    }

    /* access modifiers changed from: package-private */
    public void addBytesSent(int i) {
        setBytesSent(this.bytesSent + i);
    }

    /* access modifiers changed from: package-private */
    public void setBytesReceived(int i) {
        this.bytesReceived = i;
    }

    /* access modifiers changed from: package-private */
    public void setMaxObjectSizeInBytes(int i) {
        this.maxObjectSizeInBytes = i;
    }

    /* access modifiers changed from: package-private */
    public boolean isComplete() {
        return this.bytesSent == this.imageSizeInBytes;
    }

    /* access modifiers changed from: package-private */
    public boolean isObjectComplete() {
        return this.bytesSent % this.maxObjectSizeInBytes == 0;
    }

    /* access modifiers changed from: package-private */
    public int getAvailableObjectSizeIsBytes() {
        int i = this.imageSizeInBytes;
        int i2 = this.bytesSent;
        int i3 = this.maxObjectSizeInBytes;
        return Math.min(i - i2, i3 - (i2 % i3));
    }

    /* access modifiers changed from: package-private */
    public int getProgress() {
        return this.progress;
    }

    /* access modifiers changed from: package-private */
    public int getBytesSent() {
        return this.bytesSent;
    }

    /* access modifiers changed from: package-private */
    public int getBytesReceived() {
        return this.bytesReceived;
    }

    /* access modifiers changed from: package-private */
    public int getImageSizeInBytes() {
        return this.imageSizeInBytes;
    }

    /* access modifiers changed from: package-private */
    public float getSpeed() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        float f = elapsedRealtime - this.timeStart != 0 ? ((float) (this.bytesSent - this.lastBytesSent)) / ((float) (elapsedRealtime - this.lastProgressTime)) : 0.0f;
        this.lastProgressTime = elapsedRealtime;
        this.lastBytesSent = this.bytesSent;
        return f;
    }

    /* access modifiers changed from: package-private */
    public float getAverageSpeed() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.timeStart;
        if (elapsedRealtime - j != 0) {
            return ((float) (this.bytesSent - this.initialBytesSent)) / ((float) (elapsedRealtime - j));
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getCurrentPart() {
        return this.currentPart;
    }

    /* access modifiers changed from: package-private */
    public int getTotalParts() {
        return this.totalParts;
    }

    /* access modifiers changed from: package-private */
    public boolean isLastPart() {
        return this.currentPart == this.totalParts;
    }
}
