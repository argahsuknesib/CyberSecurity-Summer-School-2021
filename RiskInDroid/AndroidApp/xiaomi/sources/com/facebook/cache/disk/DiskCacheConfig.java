package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;

public class DiskCacheConfig {
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private final Context mContext;
    private final long mDefaultSizeLimit;
    private final DiskTrimmableRegistry mDiskTrimmableRegistry;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final boolean mIndexPopulateAtStartupEnabled;
    private final long mLowDiskSpaceSizeLimit;
    private final long mMinimumSizeLimit;
    private final int mVersion;

    private DiskCacheConfig(Builder builder) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        DiskTrimmableRegistry diskTrimmableRegistry;
        this.mVersion = builder.mVersion;
        this.mBaseDirectoryName = (String) Preconditions.checkNotNull(builder.mBaseDirectoryName);
        this.mBaseDirectoryPathSupplier = (Supplier) Preconditions.checkNotNull(builder.mBaseDirectoryPathSupplier);
        this.mDefaultSizeLimit = builder.mMaxCacheSize;
        this.mLowDiskSpaceSizeLimit = builder.mMaxCacheSizeOnLowDiskSpace;
        this.mMinimumSizeLimit = builder.mMaxCacheSizeOnVeryLowDiskSpace;
        this.mEntryEvictionComparatorSupplier = (EntryEvictionComparatorSupplier) Preconditions.checkNotNull(builder.mEntryEvictionComparatorSupplier);
        if (builder.mCacheErrorLogger == null) {
            cacheErrorLogger = NoOpCacheErrorLogger.getInstance();
        } else {
            cacheErrorLogger = builder.mCacheErrorLogger;
        }
        this.mCacheErrorLogger = cacheErrorLogger;
        if (builder.mCacheEventListener == null) {
            cacheEventListener = NoOpCacheEventListener.getInstance();
        } else {
            cacheEventListener = builder.mCacheEventListener;
        }
        this.mCacheEventListener = cacheEventListener;
        if (builder.mDiskTrimmableRegistry == null) {
            diskTrimmableRegistry = NoOpDiskTrimmableRegistry.getInstance();
        } else {
            diskTrimmableRegistry = builder.mDiskTrimmableRegistry;
        }
        this.mDiskTrimmableRegistry = diskTrimmableRegistry;
        this.mContext = builder.mContext;
        this.mIndexPopulateAtStartupEnabled = builder.mIndexPopulateAtStartupEnabled;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String getBaseDirectoryName() {
        return this.mBaseDirectoryName;
    }

    public Supplier<File> getBaseDirectoryPathSupplier() {
        return this.mBaseDirectoryPathSupplier;
    }

    public long getDefaultSizeLimit() {
        return this.mDefaultSizeLimit;
    }

    public long getLowDiskSpaceSizeLimit() {
        return this.mLowDiskSpaceSizeLimit;
    }

    public long getMinimumSizeLimit() {
        return this.mMinimumSizeLimit;
    }

    public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
        return this.mEntryEvictionComparatorSupplier;
    }

    public CacheErrorLogger getCacheErrorLogger() {
        return this.mCacheErrorLogger;
    }

    public CacheEventListener getCacheEventListener() {
        return this.mCacheEventListener;
    }

    public DiskTrimmableRegistry getDiskTrimmableRegistry() {
        return this.mDiskTrimmableRegistry;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean getIndexPopulateAtStartupEnabled() {
        return this.mIndexPopulateAtStartupEnabled;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public static class Builder {
        public String mBaseDirectoryName;
        public Supplier<File> mBaseDirectoryPathSupplier;
        public CacheErrorLogger mCacheErrorLogger;
        public CacheEventListener mCacheEventListener;
        public final Context mContext;
        public DiskTrimmableRegistry mDiskTrimmableRegistry;
        public EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
        public boolean mIndexPopulateAtStartupEnabled;
        public long mMaxCacheSize;
        public long mMaxCacheSizeOnLowDiskSpace;
        public long mMaxCacheSizeOnVeryLowDiskSpace;
        public int mVersion;

        private Builder(Context context) {
            this.mVersion = 1;
            this.mBaseDirectoryName = "image_cache";
            this.mMaxCacheSize = 41943040;
            this.mMaxCacheSizeOnLowDiskSpace = 10485760;
            this.mMaxCacheSizeOnVeryLowDiskSpace = 2097152;
            this.mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
            this.mContext = context;
        }

        public Builder setVersion(int i) {
            this.mVersion = i;
            return this;
        }

        public Builder setBaseDirectoryName(String str) {
            this.mBaseDirectoryName = str;
            return this;
        }

        public Builder setBaseDirectoryPath(File file) {
            this.mBaseDirectoryPathSupplier = Suppliers.of(file);
            return this;
        }

        public Builder setBaseDirectoryPathSupplier(Supplier<File> supplier) {
            this.mBaseDirectoryPathSupplier = supplier;
            return this;
        }

        public Builder setMaxCacheSize(long j) {
            this.mMaxCacheSize = j;
            return this;
        }

        public Builder setMaxCacheSizeOnLowDiskSpace(long j) {
            this.mMaxCacheSizeOnLowDiskSpace = j;
            return this;
        }

        public Builder setMaxCacheSizeOnVeryLowDiskSpace(long j) {
            this.mMaxCacheSizeOnVeryLowDiskSpace = j;
            return this;
        }

        public Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier entryEvictionComparatorSupplier) {
            this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
            return this;
        }

        public Builder setCacheErrorLogger(CacheErrorLogger cacheErrorLogger) {
            this.mCacheErrorLogger = cacheErrorLogger;
            return this;
        }

        public Builder setCacheEventListener(CacheEventListener cacheEventListener) {
            this.mCacheEventListener = cacheEventListener;
            return this;
        }

        public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry diskTrimmableRegistry) {
            this.mDiskTrimmableRegistry = diskTrimmableRegistry;
            return this;
        }

        public Builder setIndexPopulateAtStartupEnabled(boolean z) {
            this.mIndexPopulateAtStartupEnabled = z;
            return this;
        }

        public DiskCacheConfig build() {
            Preconditions.checkState((this.mBaseDirectoryPathSupplier == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mBaseDirectoryPathSupplier == null && this.mContext != null) {
                this.mBaseDirectoryPathSupplier = new Supplier<File>() {
                    /* class com.facebook.cache.disk.DiskCacheConfig.Builder.AnonymousClass1 */

                    public File get() {
                        return Builder.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new DiskCacheConfig(this);
        }
    }
}
