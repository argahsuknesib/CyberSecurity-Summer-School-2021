package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class IcyDataSource implements DataSource {
    private int bytesUntilMetadata;
    private final Listener listener;
    private final int metadataIntervalBytes;
    private final byte[] metadataLengthByteHolder;
    private final DataSource upstream;

    public interface Listener {
        void onIcyMetadata(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i, Listener listener2) {
        Assertions.checkArgument(i > 0);
        this.upstream = dataSource;
        this.metadataIntervalBytes = i;
        this.listener = listener2;
        this.metadataLengthByteHolder = new byte[1];
        this.bytesUntilMetadata = i;
    }

    public final void addTransferListener(TransferListener transferListener) {
        this.upstream.addTransferListener(transferListener);
    }

    public final long open(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.bytesUntilMetadata == 0) {
            if (!readMetadata()) {
                return -1;
            }
            this.bytesUntilMetadata = this.metadataIntervalBytes;
        }
        int read = this.upstream.read(bArr, i, Math.min(this.bytesUntilMetadata, i2));
        if (read != -1) {
            this.bytesUntilMetadata -= read;
        }
        return read;
    }

    public final Uri getUri() {
        return this.upstream.getUri();
    }

    public final Map<String, List<String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    public final void close() {
        throw new UnsupportedOperationException();
    }

    private boolean readMetadata() throws IOException {
        if (this.upstream.read(this.metadataLengthByteHolder, 0, 1) == -1) {
            return false;
        }
        int i = (this.metadataLengthByteHolder[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int read = this.upstream.read(bArr, i3, i2);
            if (read == -1) {
                return false;
            }
            i3 += read;
            i2 -= read;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.listener.onIcyMetadata(new ParsableByteArray(bArr, i));
        }
        return true;
    }
}
