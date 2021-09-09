package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseDataSource implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList<TransferListener> listeners = new ArrayList<>(1);

    public /* synthetic */ Map<String, List<String>> getResponseHeaders() {
        return DataSource.CC.$default$getResponseHeaders(this);
    }

    protected BaseDataSource(boolean z) {
        this.isNetwork = z;
    }

    public final void addTransferListener(TransferListener transferListener) {
        if (!this.listeners.contains(transferListener)) {
            this.listeners.add(transferListener);
            this.listenerCount++;
        }
    }

    /* access modifiers changed from: protected */
    public final void transferInitializing(DataSpec dataSpec2) {
        for (int i = 0; i < this.listenerCount; i++) {
            this.listeners.get(i).onTransferInitializing(this, dataSpec2, this.isNetwork);
        }
    }

    /* access modifiers changed from: protected */
    public final void transferStarted(DataSpec dataSpec2) {
        this.dataSpec = dataSpec2;
        for (int i = 0; i < this.listenerCount; i++) {
            this.listeners.get(i).onTransferStart(this, dataSpec2, this.isNetwork);
        }
    }

    /* access modifiers changed from: protected */
    public final void bytesTransferred(int i) {
        DataSpec dataSpec2 = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i2 = 0; i2 < this.listenerCount; i2++) {
            this.listeners.get(i2).onBytesTransferred(this, dataSpec2, this.isNetwork, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void transferEnded() {
        DataSpec dataSpec2 = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i = 0; i < this.listenerCount; i++) {
            this.listeners.get(i).onTransferEnd(this, dataSpec2, this.isNetwork);
        }
        this.dataSpec = null;
    }
}
