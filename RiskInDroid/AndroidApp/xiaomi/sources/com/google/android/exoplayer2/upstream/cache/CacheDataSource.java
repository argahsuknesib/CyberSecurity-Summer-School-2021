package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class CacheDataSource implements DataSource {
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private DataSource currentDataSource;
    private boolean currentDataSpecLengthUnset;
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    private final EventListener eventListener;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private long readPosition;
    private DataSpec requestDataSpec;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i);

        void onCachedBytesRead(long j, long j2);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(Cache cache2, DataSource dataSource) {
        this(cache2, dataSource, 0);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, int i) {
        this(cache2, dataSource, new FileDataSource(), new CacheDataSink(cache2, 5242880), i, null);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i, EventListener eventListener2) {
        this(cache2, dataSource, dataSource2, dataSink, i, eventListener2, null);
    }

    public CacheDataSource(Cache cache2, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i, EventListener eventListener2, CacheKeyFactory cacheKeyFactory2) {
        this.cache = cache2;
        this.cacheReadDataSource = dataSource2;
        this.cacheKeyFactory = cacheKeyFactory2 == null ? CacheUtil.DEFAULT_CACHE_KEY_FACTORY : cacheKeyFactory2;
        boolean z = false;
        this.blockOnCache = (i & 1) != 0;
        this.ignoreCacheOnError = (i & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i & 4) != 0 ? true : z;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener2;
    }

    public final void addTransferListener(TransferListener transferListener) {
        this.cacheReadDataSource.addTransferListener(transferListener);
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    public final long open(DataSpec dataSpec) throws IOException {
        try {
            String buildCacheKey = this.cacheKeyFactory.buildCacheKey(dataSpec);
            this.requestDataSpec = dataSpec.buildUpon().setKey(buildCacheKey).build();
            this.actualUri = getRedirectedUriOrDefault(this.cache, buildCacheKey, this.requestDataSpec.uri);
            this.readPosition = dataSpec.position;
            int shouldIgnoreCacheForRequest = shouldIgnoreCacheForRequest(dataSpec);
            this.currentRequestIgnoresCache = shouldIgnoreCacheForRequest != -1;
            if (this.currentRequestIgnoresCache) {
                notifyCacheIgnored(shouldIgnoreCacheForRequest);
            }
            if (dataSpec.length == -1) {
                if (!this.currentRequestIgnoresCache) {
                    this.bytesRemaining = ContentMetadata.CC.getContentLength(this.cache.getContentMetadata(buildCacheKey));
                    if (this.bytesRemaining != -1) {
                        this.bytesRemaining -= dataSpec.position;
                        if (this.bytesRemaining <= 0) {
                            throw new DataSourceException(0);
                        }
                    }
                    openNextSource(false);
                    return this.bytesRemaining;
                }
            }
            this.bytesRemaining = dataSpec.length;
            openNextSource(false);
            return this.bytesRemaining;
        } catch (Throwable th) {
            handleBeforeThrow(th);
            throw th;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            if (this.readPosition >= this.checkCachePosition) {
                openNextSource(true);
            }
            int read = this.currentDataSource.read(bArr, i, i2);
            if (read != -1) {
                if (isReadingFromCache()) {
                    this.totalCachedBytesRead += (long) read;
                }
                long j = (long) read;
                this.readPosition += j;
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= j;
                }
            } else if (this.currentDataSpecLengthUnset) {
                setNoBytesRemainingAndMaybeStoreLength();
            } else {
                if (this.bytesRemaining <= 0) {
                    if (this.bytesRemaining == -1) {
                    }
                }
                closeCurrentSource();
                openNextSource(false);
                return read(bArr, i, i2);
            }
            return read;
        } catch (IOException e) {
            if (!this.currentDataSpecLengthUnset || !CacheUtil.isCausedByPositionOutOfRange(e)) {
                handleBeforeThrow(e);
                throw e;
            }
            setNoBytesRemainingAndMaybeStoreLength();
            return -1;
        } catch (Throwable th) {
            handleBeforeThrow(th);
            throw th;
        }
    }

    public final Uri getUri() {
        return this.actualUri;
    }

    public final Map<String, List<String>> getResponseHeaders() {
        if (isReadingFromUpstream()) {
            return this.upstreamDataSource.getResponseHeaders();
        }
        return Collections.emptyMap();
    }

    public final void close() throws IOException {
        this.requestDataSpec = null;
        this.actualUri = null;
        this.readPosition = 0;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (Throwable th) {
            handleBeforeThrow(th);
            throw th;
        }
    }

    private void openNextSource(boolean z) throws IOException {
        CacheSpan cacheSpan;
        DataSpec dataSpec;
        DataSource dataSource;
        long j;
        String str = this.requestDataSpec.key;
        Uri uri = null;
        if (this.currentRequestIgnoresCache) {
            cacheSpan = null;
        } else if (this.blockOnCache) {
            try {
                cacheSpan = this.cache.startReadWrite(str, this.readPosition);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpan = this.cache.startReadWriteNonBlocking(str, this.readPosition);
        }
        if (cacheSpan == null) {
            dataSource = this.upstreamDataSource;
            dataSpec = this.requestDataSpec.buildUpon().setPosition(this.readPosition).setLength(this.bytesRemaining).build();
        } else if (cacheSpan.isCached) {
            Uri fromFile = Uri.fromFile(cacheSpan.file);
            long j2 = cacheSpan.position;
            long j3 = this.readPosition - j2;
            long j4 = cacheSpan.length - j3;
            long j5 = this.bytesRemaining;
            if (j5 != -1) {
                j4 = Math.min(j4, j5);
            }
            dataSpec = this.requestDataSpec.buildUpon().setUri(fromFile).setUriPositionOffset(j2).setPosition(j3).setLength(j4).build();
            dataSource = this.cacheReadDataSource;
        } else {
            if (cacheSpan.isOpenEnded()) {
                j = this.bytesRemaining;
            } else {
                j = cacheSpan.length;
                long j6 = this.bytesRemaining;
                if (j6 != -1) {
                    j = Math.min(j, j6);
                }
            }
            dataSpec = this.requestDataSpec.buildUpon().setPosition(this.readPosition).setLength(j).build();
            dataSource = this.cacheWriteDataSource;
            if (dataSource == null) {
                dataSource = this.upstreamDataSource;
                this.cache.releaseHoleSpan(cacheSpan);
                cacheSpan = null;
            }
        }
        this.checkCachePosition = (this.currentRequestIgnoresCache || dataSource != this.upstreamDataSource) ? Long.MAX_VALUE : this.readPosition + 102400;
        if (z) {
            Assertions.checkState(isBypassingCache());
            if (dataSource != this.upstreamDataSource) {
                try {
                    closeCurrentSource();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (cacheSpan.isHoleSpan()) {
                        this.cache.releaseHoleSpan(cacheSpan);
                    }
                    throw th2;
                }
            } else {
                return;
            }
        }
        if (cacheSpan != null && cacheSpan.isHoleSpan()) {
            this.currentHoleSpan = cacheSpan;
        }
        this.currentDataSource = dataSource;
        this.currentDataSpecLengthUnset = dataSpec.length == -1;
        long open = dataSource.open(dataSpec);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (this.currentDataSpecLengthUnset && open != -1) {
            this.bytesRemaining = open;
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.readPosition + this.bytesRemaining);
        }
        if (isReadingFromUpstream()) {
            this.actualUri = this.currentDataSource.getUri();
            if (true ^ this.requestDataSpec.uri.equals(this.actualUri)) {
                uri = this.actualUri;
            }
            ContentMetadataMutations.setRedirectedUri(contentMetadataMutations, uri);
        }
        if (isWritingToCache()) {
            this.cache.applyContentMetadataMutations(str, contentMetadataMutations);
        }
    }

    private void setNoBytesRemainingAndMaybeStoreLength() throws IOException {
        this.bytesRemaining = 0;
        if (isWritingToCache()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.readPosition);
            this.cache.applyContentMetadataMutations(this.requestDataSpec.key, contentMetadataMutations);
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache2, String str, Uri uri) {
        Uri redirectedUri = ContentMetadata.CC.getRedirectedUri(cache2.getContentMetadata(str));
        return redirectedUri != null ? redirectedUri : uri;
    }

    private boolean isReadingFromUpstream() {
        return !isReadingFromCache();
    }

    private boolean isBypassingCache() {
        return this.currentDataSource == this.upstreamDataSource;
    }

    private boolean isReadingFromCache() {
        return this.currentDataSource == this.cacheReadDataSource;
    }

    private boolean isWritingToCache() {
        return this.currentDataSource == this.cacheWriteDataSource;
    }

    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.currentDataSource = null;
                this.currentDataSpecLengthUnset = false;
                CacheSpan cacheSpan = this.currentHoleSpan;
                if (cacheSpan != null) {
                    this.cache.releaseHoleSpan(cacheSpan);
                    this.currentHoleSpan = null;
                }
            }
        }
    }

    private void handleBeforeThrow(Throwable th) {
        if (isReadingFromCache() || (th instanceof Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec) {
        if (!this.ignoreCacheOnError || !this.seenCacheError) {
            return (!this.ignoreCacheForUnsetLengthRequests || dataSpec.length != -1) ? -1 : 1;
        }
        return 0;
    }

    private void notifyCacheIgnored(int i) {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null) {
            eventListener2.onCacheIgnored(i);
        }
    }

    private void notifyBytesRead() {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null && this.totalCachedBytesRead > 0) {
            eventListener2.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
            this.totalCachedBytesRead = 0;
        }
    }
}
