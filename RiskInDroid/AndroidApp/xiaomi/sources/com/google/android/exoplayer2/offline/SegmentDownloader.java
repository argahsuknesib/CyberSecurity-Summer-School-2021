package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CacheDataSource dataSource;
    private final AtomicBoolean isCanceled = new AtomicBoolean();
    private final DataSpec manifestDataSpec;
    private final CacheDataSource offlineDataSource;
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList<StreamKey> streamKeys;

    /* access modifiers changed from: protected */
    public abstract M getManifest(DataSource dataSource2, DataSpec dataSpec) throws IOException;

    /* access modifiers changed from: protected */
    public abstract List<Segment> getSegments(DataSource dataSource2, M m, boolean z) throws InterruptedException, IOException;

    public static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec2) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec2;
        }

        public int compareTo(Segment segment) {
            return Util.compareLong(this.startTimeUs, segment.startTimeUs);
        }
    }

    public SegmentDownloader(Uri uri, List<StreamKey> list, DownloaderConstructorHelper downloaderConstructorHelper) {
        this.manifestDataSpec = getCompressibleDataSpec(uri);
        this.streamKeys = new ArrayList<>(list);
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.createCacheDataSource();
        this.offlineDataSource = downloaderConstructorHelper.createOfflineCacheDataSource();
        this.cacheKeyFactory = downloaderConstructorHelper.getCacheKeyFactory();
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
    }

    public final void download(Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        this.priorityTaskManager.add(-1000);
        try {
            FilterableManifest manifest = getManifest(this.dataSource, this.manifestDataSpec);
            if (!this.streamKeys.isEmpty()) {
                manifest = (FilterableManifest) manifest.copy(this.streamKeys);
            }
            List<Segment> segments = getSegments(this.dataSource, manifest, false);
            Collections.sort(segments);
            mergeSegments(segments, this.cacheKeyFactory);
            int size = segments.size();
            long j = 0;
            long j2 = 0;
            int i = 0;
            for (int size2 = segments.size() - 1; size2 >= 0; size2--) {
                Pair<Long, Long> cached = CacheUtil.getCached(segments.get(size2).dataSpec, this.cache, this.cacheKeyFactory);
                long longValue = ((Long) cached.first).longValue();
                long longValue2 = ((Long) cached.second).longValue();
                j2 += longValue2;
                if (longValue != -1) {
                    if (longValue == longValue2) {
                        i++;
                        segments.remove(size2);
                    }
                    if (j != -1) {
                        j += longValue;
                    }
                } else {
                    j = -1;
                }
            }
            ProgressNotifier progressNotifier = null;
            if (progressListener != null) {
                progressNotifier = new ProgressNotifier(progressListener, j, size, j2, i);
            }
            byte[] bArr = new byte[131072];
            for (int i2 = 0; i2 < segments.size(); i2++) {
                CacheUtil.cache(segments.get(i2).dataSpec, this.cache, this.cacheKeyFactory, this.dataSource, bArr, this.priorityTaskManager, -1000, progressNotifier, this.isCanceled, true);
                if (progressNotifier != null) {
                    progressNotifier.onSegmentDownloaded();
                }
            }
        } finally {
            this.priorityTaskManager.remove(-1000);
        }
    }

    public void cancel() {
        this.isCanceled.set(true);
    }

    public final void remove() throws InterruptedException {
        try {
            List<Segment> segments = getSegments(this.offlineDataSource, getManifest(this.offlineDataSource, this.manifestDataSpec), true);
            for (int i = 0; i < segments.size(); i++) {
                removeDataSpec(segments.get(i).dataSpec);
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            removeDataSpec(this.manifestDataSpec);
            throw th;
        }
        removeDataSpec(this.manifestDataSpec);
    }

    private void removeDataSpec(DataSpec dataSpec) {
        CacheUtil.remove(dataSpec, this.cache, this.cacheKeyFactory);
    }

    protected static DataSpec getCompressibleDataSpec(Uri uri) {
        return new DataSpec.Builder().setUri(uri).setFlags(1).build();
    }

    private static void mergeSegments(List<Segment> list, CacheKeyFactory cacheKeyFactory2) {
        Segment segment;
        HashMap hashMap = new HashMap();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Segment segment2 = list.get(i2);
            String buildCacheKey = cacheKeyFactory2.buildCacheKey(segment2.dataSpec);
            Integer num = (Integer) hashMap.get(buildCacheKey);
            if (num == null) {
                segment = null;
            } else {
                segment = list.get(num.intValue());
            }
            if (segment == null || segment2.startTimeUs > segment.startTimeUs + 20000000 || !canMergeSegments(segment.dataSpec, segment2.dataSpec)) {
                hashMap.put(buildCacheKey, Integer.valueOf(i));
                list.set(i, segment2);
                i++;
            } else {
                long j = -1;
                if (segment2.dataSpec.length != -1) {
                    j = segment.dataSpec.length + segment2.dataSpec.length;
                }
                list.set(((Integer) Assertions.checkNotNull(num)).intValue(), new Segment(segment.startTimeUs, segment.dataSpec.subrange(0, j)));
            }
        }
        Util.removeRange(list, i, list.size());
    }

    private static boolean canMergeSegments(DataSpec dataSpec, DataSpec dataSpec2) {
        return dataSpec.uri.equals(dataSpec2.uri) && dataSpec.length != -1 && dataSpec.position + dataSpec.length == dataSpec2.position && Util.areEqual(dataSpec.key, dataSpec2.key) && dataSpec.flags == dataSpec2.flags && dataSpec.httpMethod == dataSpec2.httpMethod && dataSpec.httpRequestHeaders.equals(dataSpec2.httpRequestHeaders);
    }

    static final class ProgressNotifier implements CacheUtil.ProgressListener {
        private long bytesDownloaded;
        private final long contentLength;
        private final Downloader.ProgressListener progressListener;
        private int segmentsDownloaded;
        private final int totalSegments;

        public ProgressNotifier(Downloader.ProgressListener progressListener2, long j, int i, long j2, int i2) {
            this.progressListener = progressListener2;
            this.contentLength = j;
            this.totalSegments = i;
            this.bytesDownloaded = j2;
            this.segmentsDownloaded = i2;
        }

        public final void onProgress(long j, long j2, long j3) {
            this.bytesDownloaded += j3;
            this.progressListener.onProgress(this.contentLength, this.bytesDownloaded, getPercentDownloaded());
        }

        public final void onSegmentDownloaded() {
            this.segmentsDownloaded++;
            this.progressListener.onProgress(this.contentLength, this.bytesDownloaded, getPercentDownloaded());
        }

        private float getPercentDownloaded() {
            long j = this.contentLength;
            if (j != -1 && j != 0) {
                return (((float) this.bytesDownloaded) * 100.0f) / ((float) j);
            }
            int i = this.totalSegments;
            if (i != 0) {
                return (((float) this.segmentsDownloaded) * 100.0f) / ((float) i);
            }
            return -1.0f;
        }
    }
}
