package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

public final class FixedTrackSelection extends BaseTrackSelection {
    private final Object data;
    private final int reason;

    public final int getSelectedIndex() {
        return 0;
    }

    public final void updateSelectedTrack(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    @Deprecated
    public static final class Factory implements TrackSelection.Factory {
        private final Object data;
        private final int reason;

        public Factory() {
            this.reason = 0;
            this.data = null;
        }

        public Factory(int i, Object obj) {
            this.reason = i;
            this.data = obj;
        }

        public final TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter) {
            return TrackSelectionUtil.createTrackSelectionsForDefinitions(definitionArr, new TrackSelectionUtil.AdaptiveTrackSelectionFactory() {
                /* class com.google.android.exoplayer2.trackselection.$$Lambda$FixedTrackSelection$Factory$dV02I3wOe22WOhap3_K4f4jI0 */

                public final TrackSelection createAdaptiveTrackSelection(TrackSelection.Definition definition) {
                    return FixedTrackSelection.Factory.this.lambda$createTrackSelections$0$FixedTrackSelection$Factory(definition);
                }
            });
        }

        public /* synthetic */ TrackSelection lambda$createTrackSelections$0$FixedTrackSelection$Factory(TrackSelection.Definition definition) {
            return new FixedTrackSelection(definition.group, definition.tracks[0], this.reason, this.data);
        }
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0, null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i, int i2, Object obj) {
        super(trackGroup, i);
        this.reason = i2;
        this.data = obj;
    }

    public final int getSelectionReason() {
        return this.reason;
    }

    public final Object getSelectionData() {
        return this.data;
    }
}
