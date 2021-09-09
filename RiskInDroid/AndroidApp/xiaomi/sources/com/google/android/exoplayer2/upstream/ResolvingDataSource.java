package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class ResolvingDataSource implements DataSource {
    private final Resolver resolver;
    private final DataSource upstreamDataSource;
    private boolean upstreamOpened;

    public interface Resolver {

        /* renamed from: com.google.android.exoplayer2.upstream.ResolvingDataSource$Resolver$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Uri $default$resolveReportedUri(Resolver resolver, Uri uri) {
                return uri;
            }
        }

        DataSpec resolveDataSpec(DataSpec dataSpec) throws IOException;

        Uri resolveReportedUri(Uri uri);
    }

    public static final class Factory implements DataSource.Factory {
        private final Resolver resolver;
        private final DataSource.Factory upstreamFactory;

        public Factory(DataSource.Factory factory, Resolver resolver2) {
            this.upstreamFactory = factory;
            this.resolver = resolver2;
        }

        public final ResolvingDataSource createDataSource() {
            return new ResolvingDataSource(this.upstreamFactory.createDataSource(), this.resolver);
        }
    }

    public ResolvingDataSource(DataSource dataSource, Resolver resolver2) {
        this.upstreamDataSource = dataSource;
        this.resolver = resolver2;
    }

    public final void addTransferListener(TransferListener transferListener) {
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    public final long open(DataSpec dataSpec) throws IOException {
        DataSpec resolveDataSpec = this.resolver.resolveDataSpec(dataSpec);
        this.upstreamOpened = true;
        return this.upstreamDataSource.open(resolveDataSpec);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.upstreamDataSource.read(bArr, i, i2);
    }

    public final Uri getUri() {
        Uri uri = this.upstreamDataSource.getUri();
        if (uri == null) {
            return null;
        }
        return this.resolver.resolveReportedUri(uri);
    }

    public final Map<String, List<String>> getResponseHeaders() {
        return this.upstreamDataSource.getResponseHeaders();
    }

    public final void close() throws IOException {
        if (this.upstreamOpened) {
            this.upstreamOpened = false;
            this.upstreamDataSource.close();
        }
    }
}
