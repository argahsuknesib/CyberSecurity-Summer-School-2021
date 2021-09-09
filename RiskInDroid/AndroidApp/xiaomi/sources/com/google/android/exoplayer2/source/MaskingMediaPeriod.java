package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;

public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    public final MediaSource.MediaPeriodId id;
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = -9223372036854775807L;
    private long preparePositionUs;

    public interface PrepareErrorListener {
        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public /* synthetic */ List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        return MediaPeriod.CC.$default$getStreamKeys(this, list);
    }

    public MaskingMediaPeriod(MediaSource mediaSource2, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator2, long j) {
        this.id = mediaPeriodId;
        this.allocator = allocator2;
        this.mediaSource = mediaSource2;
        this.preparePositionUs = j;
    }

    public final void setPrepareErrorListener(PrepareErrorListener prepareErrorListener) {
        this.listener = prepareErrorListener;
    }

    public final long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    public final void overridePreparePositionUs(long j) {
        this.preparePositionOverrideUs = j;
    }

    public final long getPreparePositionOverrideUs() {
        return this.preparePositionOverrideUs;
    }

    public final void createPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        long preparePositionWithOverride = getPreparePositionWithOverride(this.preparePositionUs);
        this.mediaPeriod = this.mediaSource.createPeriod(mediaPeriodId, this.allocator, preparePositionWithOverride);
        if (this.callback != null) {
            this.mediaPeriod.prepare(this, preparePositionWithOverride);
        }
    }

    public final void releasePeriod() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            this.mediaSource.releasePeriod(mediaPeriod2);
        }
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            mediaPeriod2.prepare(this, getPreparePositionWithOverride(this.preparePositionUs));
        }
    }

    public final void maybeThrowPrepareError() throws IOException {
        try {
            if (this.mediaPeriod != null) {
                this.mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e) {
            PrepareErrorListener prepareErrorListener = this.listener;
            if (prepareErrorListener == null) {
                throw e;
            } else if (!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                prepareErrorListener.onPrepareError(this.id, e);
            }
        }
    }

    public final TrackGroupArray getTrackGroups() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getTrackGroups();
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.preparePositionOverrideUs;
        if (j3 == -9223372036854775807L || j != this.preparePositionUs) {
            j2 = j;
        } else {
            this.preparePositionOverrideUs = -9223372036854775807L;
            j2 = j3;
        }
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public final void discardBuffer(long j, boolean z) {
        ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).discardBuffer(j, z);
    }

    public final long readDiscontinuity() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).readDiscontinuity();
    }

    public final long getBufferedPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getBufferedPositionUs();
    }

    public final long seekToUs(long j) {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).seekToUs(j);
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getAdjustedSeekPositionUs(j, seekParameters);
    }

    public final long getNextLoadPositionUs() {
        return ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).getNextLoadPositionUs();
    }

    public final void reevaluateBuffer(long j) {
        ((MediaPeriod) Util.castNonNull(this.mediaPeriod)).reevaluateBuffer(j);
    }

    public final boolean continueLoading(long j) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        return mediaPeriod2 != null && mediaPeriod2.continueLoading(j);
    }

    public final boolean isLoading() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        return mediaPeriod2 != null && mediaPeriod2.isLoading();
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Util.castNonNull(this.callback)).onContinueLoadingRequested(this);
    }

    public final void onPrepared(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Util.castNonNull(this.callback)).onPrepared(this);
    }

    private long getPreparePositionWithOverride(long j) {
        long j2 = this.preparePositionOverrideUs;
        return j2 != -9223372036854775807L ? j2 : j;
    }
}
