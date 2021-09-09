package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SsaSubtitle implements Subtitle {
    private final List<Long> cueTimesUs;
    private final List<List<Cue>> cues;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.cues = list;
        this.cueTimesUs = list2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Comparable, boolean, boolean):int
     arg types: [java.util.List<java.lang.Long>, java.lang.Long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchCeil(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Comparable, boolean, boolean):int */
    public final int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil((List) this.cueTimesUs, (Comparable) Long.valueOf(j), false, false);
        if (binarySearchCeil < this.cueTimesUs.size()) {
            return binarySearchCeil;
        }
        return -1;
    }

    public final int getEventTimeCount() {
        return this.cueTimesUs.size();
    }

    public final long getEventTime(int i) {
        boolean z = true;
        Assertions.checkArgument(i >= 0);
        if (i >= this.cueTimesUs.size()) {
            z = false;
        }
        Assertions.checkArgument(z);
        return this.cueTimesUs.get(i).longValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int
     arg types: [java.util.List<java.lang.Long>, java.lang.Long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchFloor(com.google.android.exoplayer2.util.LongArray, long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int */
    public final List<Cue> getCues(long j) {
        int binarySearchFloor = Util.binarySearchFloor((List) this.cueTimesUs, (Comparable) Long.valueOf(j), true, false);
        if (binarySearchFloor == -1) {
            return Collections.emptyList();
        }
        return this.cues.get(binarySearchFloor);
    }
}
