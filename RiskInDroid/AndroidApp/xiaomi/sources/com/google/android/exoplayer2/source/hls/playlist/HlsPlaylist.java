package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist> {
    public final String baseUri;
    public final boolean hasIndependentSegments;
    public final List<String> tags;

    protected HlsPlaylist(String str, List<String> list, boolean z) {
        this.baseUri = str;
        this.tags = Collections.unmodifiableList(list);
        this.hasIndependentSegments = z;
    }
}
