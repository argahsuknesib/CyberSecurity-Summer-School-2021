package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public final class CachedRegionTracker implements Cache.Listener {
    private final Cache cache;
    private final String cacheKey;
    private final ChunkIndex chunkIndex;
    private final Region lookupRegion = new Region(0, 0);
    private final TreeSet<Region> regions = new TreeSet<>();

    public final void onSpanTouched(Cache cache2, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public CachedRegionTracker(Cache cache2, String str, ChunkIndex chunkIndex2) {
        this.cache = cache2;
        this.cacheKey = str;
        this.chunkIndex = chunkIndex2;
        synchronized (this) {
            Iterator<CacheSpan> descendingIterator = cache2.addListener(str, this).descendingIterator();
            while (descendingIterator.hasNext()) {
                mergeSpan(descendingIterator.next());
            }
        }
    }

    public final void release() {
        this.cache.removeListener(this.cacheKey, this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        return -1;
     */
    public final synchronized int getRegionEndTimeMs(long j) {
        this.lookupRegion.startOffset = j;
        Region floor = this.regions.floor(this.lookupRegion);
        if (floor != null && j <= floor.endOffset) {
            if (floor.endOffsetIndex != -1) {
                int i = floor.endOffsetIndex;
                if (i == this.chunkIndex.length - 1) {
                    if (floor.endOffset == this.chunkIndex.offsets[i] + ((long) this.chunkIndex.sizes[i])) {
                        return -2;
                    }
                }
                return (int) ((this.chunkIndex.timesUs[i] + ((this.chunkIndex.durationsUs[i] * (floor.endOffset - this.chunkIndex.offsets[i])) / ((long) this.chunkIndex.sizes[i]))) / 1000);
            }
        }
    }

    public final synchronized void onSpanAdded(Cache cache2, CacheSpan cacheSpan) {
        mergeSpan(cacheSpan);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        return;
     */
    public final synchronized void onSpanRemoved(Cache cache2, CacheSpan cacheSpan) {
        Region region = new Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
        Region floor = this.regions.floor(region);
        if (floor == null) {
            Log.e("CachedRegionTracker", "Removed a span we were not aware of");
            return;
        }
        this.regions.remove(floor);
        if (floor.startOffset < region.startOffset) {
            Region region2 = new Region(floor.startOffset, region.startOffset);
            int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region2.endOffset);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region2.endOffsetIndex = binarySearch;
            this.regions.add(region2);
        }
        if (floor.endOffset > region.endOffset) {
            Region region3 = new Region(region.endOffset + 1, floor.endOffset);
            region3.endOffsetIndex = floor.endOffsetIndex;
            this.regions.add(region3);
        }
    }

    private void mergeSpan(CacheSpan cacheSpan) {
        Region region = new Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
        Region floor = this.regions.floor(region);
        Region ceiling = this.regions.ceiling(region);
        boolean regionsConnect = regionsConnect(floor, region);
        if (regionsConnect(region, ceiling)) {
            if (regionsConnect) {
                floor.endOffset = ceiling.endOffset;
                floor.endOffsetIndex = ceiling.endOffsetIndex;
            } else {
                region.endOffset = ceiling.endOffset;
                region.endOffsetIndex = ceiling.endOffsetIndex;
                this.regions.add(region);
            }
            this.regions.remove(ceiling);
        } else if (regionsConnect) {
            floor.endOffset = region.endOffset;
            int i = floor.endOffsetIndex;
            while (i < this.chunkIndex.length - 1) {
                int i2 = i + 1;
                if (this.chunkIndex.offsets[i2] > floor.endOffset) {
                    break;
                }
                i = i2;
            }
            floor.endOffsetIndex = i;
        } else {
            int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region.endOffset);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region.endOffsetIndex = binarySearch;
            this.regions.add(region);
        }
    }

    private boolean regionsConnect(Region region, Region region2) {
        return (region == null || region2 == null || region.endOffset != region2.startOffset) ? false : true;
    }

    static class Region implements Comparable<Region> {
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long j, long j2) {
            this.startOffset = j;
            this.endOffset = j2;
        }

        public int compareTo(Region region) {
            return Util.compareLong(this.startOffset, region.startOffset);
        }
    }
}
