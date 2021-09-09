package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class ParsingLoadable<T> implements Loader.Loadable {
    private final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    private final Parser<? extends T> parser;
    private volatile T result;
    public final int type;

    public interface Parser<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public final void cancelLoad() {
    }

    public static <T> T load(DataSource dataSource2, Parser<? extends T> parser2, Uri uri, int i) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource2, uri, i, parser2);
        parsingLoadable.load();
        return Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public static <T> T load(DataSource dataSource2, Parser<? extends T> parser2, DataSpec dataSpec2, int i) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource2, dataSpec2, i, parser2);
        parsingLoadable.load();
        return Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public ParsingLoadable(DataSource dataSource2, Uri uri, int i, Parser parser2) {
        this(dataSource2, new DataSpec.Builder().setUri(uri).setFlags(1).build(), i, parser2);
    }

    public ParsingLoadable(DataSource dataSource2, DataSpec dataSpec2, int i, Parser parser2) {
        this.dataSource = new StatsDataSource(dataSource2);
        this.dataSpec = dataSpec2;
        this.type = i;
        this.parser = parser2;
    }

    public final T getResult() {
        return this.result;
    }

    public final long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    public final Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }

    public final Map<String, List<String>> getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    public final void load() throws IOException {
        this.dataSource.resetBytesRead();
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.dataSource, this.dataSpec);
        try {
            dataSourceInputStream.open();
            this.result = this.parser.parse((Uri) Assertions.checkNotNull(this.dataSource.getUri()), dataSourceInputStream);
        } finally {
            Util.closeQuietly(dataSourceInputStream);
        }
    }
}
