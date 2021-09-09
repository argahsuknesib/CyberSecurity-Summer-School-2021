package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {
    private final long[] eventTimesUs;
    private final Map<String, TtmlStyle> globalStyles;
    private final Map<String, String> imageMap;
    private final Map<String, TtmlRegion> regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        this.root = ttmlNode;
        this.regionMap = map2;
        this.imageMap = map3;
        this.globalStyles = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.eventTimesUs = ttmlNode.getEventTimesUs();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int
     arg types: [long[], long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int */
    public final int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j, false, false);
        if (binarySearchCeil < this.eventTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    public final int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    public final long getEventTime(int i) {
        return this.eventTimesUs[i];
    }

    /* access modifiers changed from: package-private */
    public final TtmlNode getRoot() {
        return this.root;
    }

    public final List<Cue> getCues(long j) {
        return this.root.getCues(j, this.globalStyles, this.regionMap, this.imageMap);
    }

    /* access modifiers changed from: package-private */
    public final Map<String, TtmlStyle> getGlobalStyles() {
        return this.globalStyles;
    }
}
