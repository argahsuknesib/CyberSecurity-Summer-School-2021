package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    ProgressNoopOutputStream(Handler handler) {
        this.callbackHandler = handler;
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    /* access modifiers changed from: package-private */
    public int getMaxProgress() {
        return this.batchMax;
    }

    /* access modifiers changed from: package-private */
    public Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    /* access modifiers changed from: package-private */
    public void addProgress(long j) {
        if (this.currentRequestProgress == null) {
            this.currentRequestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.progressMap.put(this.currentRequest, this.currentRequestProgress);
        }
        this.currentRequestProgress.addToMax(j);
        this.batchMax = (int) (((long) this.batchMax) + j);
    }

    public void write(byte[] bArr) {
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        addProgress((long) i2);
    }

    public void write(int i) {
        addProgress(1);
    }
}
