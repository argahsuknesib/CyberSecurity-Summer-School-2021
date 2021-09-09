package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ProgressiveDownloader implements Downloader {
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private final AtomicBoolean isCanceled = new AtomicBoolean();
    private final PriorityTaskManager priorityTaskManager;

    public ProgressiveDownloader(Uri uri, String str, DownloaderConstructorHelper downloaderConstructorHelper) {
        this.dataSpec = new DataSpec.Builder().setUri(uri).setKey(str).setFlags(4).build();
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.createCacheDataSource();
        this.cacheKeyFactory = downloaderConstructorHelper.getCacheKeyFactory();
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
    }

    public final void download(Downloader.ProgressListener progressListener) throws InterruptedException, IOException {
        this.priorityTaskManager.add(-1000);
        try {
            CacheUtil.cache(this.dataSpec, this.cache, this.cacheKeyFactory, this.dataSource, new byte[131072], this.priorityTaskManager, -1000, progressListener == null ? null : new ProgressForwarder(progressListener), this.isCanceled, true);
        } finally {
            this.priorityTaskManager.remove(-1000);
        }
    }

    public final void cancel() {
        this.isCanceled.set(true);
    }

    public final void remove() {
        CacheUtil.remove(this.dataSpec, this.cache, this.cacheKeyFactory);
    }

    static final class ProgressForwarder implements CacheUtil.ProgressListener {
        private final Downloader.ProgressListener progessListener;

        public ProgressForwarder(Downloader.ProgressListener progressListener) {
            this.progessListener = progressListener;
        }

        public final void onProgress(long j, long j2, long j3) {
            this.progessListener.onProgress(j, j2, (j == -1 || j == 0) ? -1.0f : (((float) j2) * 100.0f) / ((float) j));
        }
    }
}
