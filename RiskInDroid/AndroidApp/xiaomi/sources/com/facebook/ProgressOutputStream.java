package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    public long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    public long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    public final GraphRequestBatch requests;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
    }

    private void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j);
        }
        this.batchProgress += j;
        long j2 = this.batchProgress;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback next : this.requests.getCallbacks()) {
                if (next instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    final GraphRequestBatch.OnProgressCallback onProgressCallback = (GraphRequestBatch.OnProgressCallback) next;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        callbackHandler.post(new Runnable() {
                            /* class com.facebook.ProgressOutputStream.AnonymousClass1 */

                            public void run() {
                                onProgressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                            }
                        });
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    /* access modifiers changed from: package-private */
    public long getBatchProgress() {
        return this.batchProgress;
    }

    /* access modifiers changed from: package-private */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        addProgress((long) i2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        addProgress(1);
    }

    public void close() throws IOException {
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
    }
}
