package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.TreeSet;

final class CachedContent {
    private final TreeSet<SimpleCacheSpan> cachedSpans;
    public final int id;
    public final String key;
    private boolean locked;
    private DefaultContentMetadata metadata;

    public CachedContent(int i, String str) {
        this(i, str, DefaultContentMetadata.EMPTY);
    }

    public CachedContent(int i, String str, DefaultContentMetadata defaultContentMetadata) {
        this.id = i;
        this.key = str;
        this.metadata = defaultContentMetadata;
        this.cachedSpans = new TreeSet<>();
    }

    public final DefaultContentMetadata getMetadata() {
        return this.metadata;
    }

    public final boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.metadata;
        this.metadata = defaultContentMetadata.copyWithMutationsApplied(contentMetadataMutations);
        return !this.metadata.equals(defaultContentMetadata);
    }

    public final boolean isLocked() {
        return this.locked;
    }

    public final void setLocked(boolean z) {
        this.locked = z;
    }

    public final void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public final TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public final SimpleCacheSpan getSpan(long j) {
        SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j);
        SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
        if (floor != null && floor.position + floor.length > j) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
        if (ceiling == null) {
            return SimpleCacheSpan.createOpenHole(this.key, j);
        }
        return SimpleCacheSpan.createClosedHole(this.key, j, ceiling.position - j);
    }

    public final long getCachedBytesLength(long j, long j2) {
        SimpleCacheSpan span = getSpan(j);
        if (span.isHoleSpan()) {
            return -Math.min(span.isOpenEnded() ? Long.MAX_VALUE : span.length, j2);
        }
        long j3 = j + j2;
        long j4 = span.position + span.length;
        if (j4 < j3) {
            for (SimpleCacheSpan next : this.cachedSpans.tailSet(span, false)) {
                if (next.position > j4) {
                    break;
                }
                j4 = Math.max(j4, next.position + next.length);
                if (j4 >= j3) {
                    break;
                }
            }
        }
        return Math.min(j4 - j, j2);
    }

    public final SimpleCacheSpan setLastTouchTimestamp(SimpleCacheSpan simpleCacheSpan, long j, boolean z) {
        File file;
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        File file2 = simpleCacheSpan.file;
        if (z) {
            file = SimpleCacheSpan.getCacheFile(file2.getParentFile(), this.id, simpleCacheSpan.position, j);
            if (!file2.renameTo(file)) {
                Log.w("CachedContent", "Failed to rename " + file2 + " to " + file);
            }
            SimpleCacheSpan copyWithFileAndLastTouchTimestamp = simpleCacheSpan.copyWithFileAndLastTouchTimestamp(file, j);
            this.cachedSpans.add(copyWithFileAndLastTouchTimestamp);
            return copyWithFileAndLastTouchTimestamp;
        }
        file = file2;
        SimpleCacheSpan copyWithFileAndLastTouchTimestamp2 = simpleCacheSpan.copyWithFileAndLastTouchTimestamp(file, j);
        this.cachedSpans.add(copyWithFileAndLastTouchTimestamp2);
        return copyWithFileAndLastTouchTimestamp2;
    }

    public final boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public final boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        cacheSpan.file.delete();
        return true;
    }

    public final int hashCode() {
        return (((this.id * 31) + this.key.hashCode()) * 31) + this.metadata.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CachedContent cachedContent = (CachedContent) obj;
            return this.id == cachedContent.id && this.key.equals(cachedContent.key) && this.cachedSpans.equals(cachedContent.cachedSpans) && this.metadata.equals(cachedContent.metadata);
        }
    }
}
