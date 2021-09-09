package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class StatsDataSource implements DataSource {
    private long bytesRead;
    private final DataSource dataSource;
    private Uri lastOpenedUri = Uri.EMPTY;
    private Map<String, List<String>> lastResponseHeaders = Collections.emptyMap();

    public StatsDataSource(DataSource dataSource2) {
        this.dataSource = (DataSource) Assertions.checkNotNull(dataSource2);
    }

    public final void resetBytesRead() {
        this.bytesRead = 0;
    }

    public final long getBytesRead() {
        return this.bytesRead;
    }

    public final Uri getLastOpenedUri() {
        return this.lastOpenedUri;
    }

    public final Map<String, List<String>> getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public final void addTransferListener(TransferListener transferListener) {
        this.dataSource.addTransferListener(transferListener);
    }

    public final long open(DataSpec dataSpec) throws IOException {
        this.lastOpenedUri = dataSpec.uri;
        this.lastResponseHeaders = Collections.emptyMap();
        long open = this.dataSource.open(dataSpec);
        this.lastOpenedUri = (Uri) Assertions.checkNotNull(getUri());
        this.lastResponseHeaders = getResponseHeaders();
        return open;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.dataSource.read(bArr, i, i2);
        if (read != -1) {
            this.bytesRead += (long) read;
        }
        return read;
    }

    public final Uri getUri() {
        return this.dataSource.getUri();
    }

    public final Map<String, List<String>> getResponseHeaders() {
        return this.dataSource.getResponseHeaders();
    }

    public final void close() throws IOException {
        this.dataSource.close();
    }
}
