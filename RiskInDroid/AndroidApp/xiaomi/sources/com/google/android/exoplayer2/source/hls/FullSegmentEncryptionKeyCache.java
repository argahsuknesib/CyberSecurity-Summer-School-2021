package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedHashMap;
import java.util.Map;

final class FullSegmentEncryptionKeyCache {
    private final LinkedHashMap<Uri, byte[]> backingMap;

    public FullSegmentEncryptionKeyCache(int i) {
        final int i2 = i;
        this.backingMap = new LinkedHashMap<Uri, byte[]>(i + 1, 1.0f, false) {
            /* class com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i2;
            }
        };
    }

    public final byte[] get(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.backingMap.get(uri);
    }

    public final byte[] put(Uri uri, byte[] bArr) {
        return this.backingMap.put(Assertions.checkNotNull(uri), Assertions.checkNotNull(bArr));
    }

    public final boolean containsUri(Uri uri) {
        return this.backingMap.containsKey(Assertions.checkNotNull(uri));
    }

    public final byte[] remove(Uri uri) {
        return this.backingMap.remove(Assertions.checkNotNull(uri));
    }
}
