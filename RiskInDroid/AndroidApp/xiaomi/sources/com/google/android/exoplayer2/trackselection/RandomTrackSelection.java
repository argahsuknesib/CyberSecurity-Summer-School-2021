package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;
import java.util.Random;

public final class RandomTrackSelection extends BaseTrackSelection {
    private final Random random;
    private int selectedIndex;

    public final Object getSelectionData() {
        return null;
    }

    public final int getSelectionReason() {
        return 3;
    }

    public static final class Factory implements TrackSelection.Factory {
        private final Random random;

        public Factory() {
            this.random = new Random();
        }

        public Factory(int i) {
            this.random = new Random((long) i);
        }

        public final TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter) {
            return TrackSelectionUtil.createTrackSelectionsForDefinitions(definitionArr, new TrackSelectionUtil.AdaptiveTrackSelectionFactory() {
                /* class com.google.android.exoplayer2.trackselection.$$Lambda$RandomTrackSelection$Factory$oA6JU5wQDueGzEWqbCBPuxGVa4 */

                public final TrackSelection createAdaptiveTrackSelection(TrackSelection.Definition definition) {
                    return RandomTrackSelection.Factory.this.lambda$createTrackSelections$0$RandomTrackSelection$Factory(definition);
                }
            });
        }

        public /* synthetic */ TrackSelection lambda$createTrackSelections$0$RandomTrackSelection$Factory(TrackSelection.Definition definition) {
            return new RandomTrackSelection(definition.group, definition.tracks, this.random);
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        this.random = new Random();
        this.selectedIndex = this.random.nextInt(this.length);
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, long j) {
        this(trackGroup, iArr, new Random(j));
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, Random random2) {
        super(trackGroup, iArr);
        this.random = random2;
        this.selectedIndex = random2.nextInt(this.length);
    }

    public final void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (!isBlacklisted(i2, elapsedRealtime)) {
                i++;
            }
        }
        this.selectedIndex = this.random.nextInt(i);
        if (i != this.length) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.length; i4++) {
                if (!isBlacklisted(i4, elapsedRealtime)) {
                    int i5 = i3 + 1;
                    if (this.selectedIndex == i3) {
                        this.selectedIndex = i4;
                        return;
                    }
                    i3 = i5;
                }
            }
        }
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }
}
