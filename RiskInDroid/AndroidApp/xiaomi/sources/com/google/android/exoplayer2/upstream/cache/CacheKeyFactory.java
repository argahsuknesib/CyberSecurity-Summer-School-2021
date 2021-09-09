package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;

public interface CacheKeyFactory {
    String buildCacheKey(DataSpec dataSpec);
}
