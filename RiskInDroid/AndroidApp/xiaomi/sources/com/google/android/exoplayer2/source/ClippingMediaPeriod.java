package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;

public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    long startUs;

    public /* synthetic */ List<StreamKey> getStreamKeys(List<TrackSelection> list) {
        return MediaPeriod.CC.$default$getStreamKeys(this, list);
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod2, boolean z, long j, long j2) {
        this.mediaPeriod = mediaPeriod2;
        this.pendingInitialDiscontinuityPositionUs = z ? j : -9223372036854775807L;
        this.startUs = j;
        this.endUs = j2;
    }

    public final void updateClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.mediaPeriod.prepare(this, j);
    }

    public final void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        if (r2 > r4) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr2.length];
        SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr2.length) {
                break;
            }
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            clippingSampleStreamArr[i] = (ClippingSampleStream) sampleStreamArr2[i];
            if (clippingSampleStreamArr[i] != null) {
                sampleStream = clippingSampleStreamArr[i].childStream;
            }
            sampleStreamArr3[i] = sampleStream;
            i++;
        }
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr3, zArr2, j);
        if (isPendingInitialDiscontinuity()) {
            long j3 = this.startUs;
            if (j == j3 && shouldKeepInitialDiscontinuity(j3, trackSelectionArr)) {
                j2 = selectTracks;
                this.pendingInitialDiscontinuityPositionUs = j2;
                if (selectTracks != j) {
                    if (selectTracks >= this.startUs) {
                        long j4 = this.endUs;
                        if (j4 != Long.MIN_VALUE) {
                        }
                    }
                    z = false;
                    Assertions.checkState(z);
                    for (int i2 = 0; i2 < sampleStreamArr2.length; i2++) {
                        if (sampleStreamArr3[i2] == null) {
                            this.sampleStreams[i2] = null;
                        } else {
                            ClippingSampleStream[] clippingSampleStreamArr2 = this.sampleStreams;
                            if (clippingSampleStreamArr2[i2] == null || clippingSampleStreamArr2[i2].childStream != sampleStreamArr3[i2]) {
                                this.sampleStreams[i2] = new ClippingSampleStream(sampleStreamArr3[i2]);
                            }
                        }
                        sampleStreamArr2[i2] = this.sampleStreams[i2];
                    }
                    return selectTracks;
                }
                z = true;
                Assertions.checkState(z);
                while (i2 < sampleStreamArr2.length) {
                }
                return selectTracks;
            }
        }
        j2 = -9223372036854775807L;
        this.pendingInitialDiscontinuityPositionUs = j2;
        if (selectTracks != j) {
        }
        z = true;
        Assertions.checkState(z);
        while (i2 < sampleStreamArr2.length) {
        }
        return selectTracks;
    }

    public final void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    public final void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    public final long readDiscontinuity() {
        if (isPendingInitialDiscontinuity()) {
            long j = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
            long readDiscontinuity = readDiscontinuity();
            return readDiscontinuity != -9223372036854775807L ? readDiscontinuity : j;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        Assertions.checkState(readDiscontinuity2 >= this.startUs);
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && readDiscontinuity2 > j2) {
            z = false;
        }
        Assertions.checkState(z);
        return readDiscontinuity2;
    }

    public final long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    public final long seekToUs(long j) {
        this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
        boolean z = false;
        for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
            if (clippingSampleStream != null) {
                clippingSampleStream.clearSentEos();
            }
        }
        long seekToUs = this.mediaPeriod.seekToUs(j);
        if (seekToUs != j) {
            if (seekToUs >= this.startUs) {
                long j2 = this.endUs;
                if (j2 != Long.MIN_VALUE) {
                }
            }
            Assertions.checkState(z);
            return seekToUs;
        }
        z = true;
        Assertions.checkState(z);
        return seekToUs;
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.startUs;
        if (j == j2) {
            return j2;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, clipSeekParameters(j, seekParameters));
    }

    public final long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    public final boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(j);
    }

    public final boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    public final void onPrepared(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L;
    }

    private SeekParameters clipSeekParameters(long j, SeekParameters seekParameters) {
        long constrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0, j - this.startUs);
        long j2 = seekParameters.toleranceAfterUs;
        long j3 = this.endUs;
        long constrainValue2 = Util.constrainValue(j2, 0, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (constrainValue == seekParameters.toleranceBeforeUs && constrainValue2 == seekParameters.toleranceAfterUs) {
            return seekParameters;
        }
        return new SeekParameters(constrainValue, constrainValue2);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j, TrackSelection[] trackSelectionArr) {
        if (j != 0) {
            for (TrackSelection trackSelection : trackSelectionArr) {
                if (trackSelection != null && !MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType)) {
                    return true;
                }
            }
        }
        return false;
    }

    final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public final void clearSentEos() {
            this.sentEos = false;
        }

        public final boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        public final void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.childStream.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -5) {
                Format format = (Format) Assertions.checkNotNull(formatHolder.format);
                if (!(format.encoderDelay == 0 && format.encoderPadding == 0)) {
                    int i = 0;
                    int i2 = ClippingMediaPeriod.this.startUs != 0 ? 0 : format.encoderDelay;
                    if (ClippingMediaPeriod.this.endUs == Long.MIN_VALUE) {
                        i = format.encoderPadding;
                    }
                    formatHolder.format = format.buildUpon().setEncoderDelay(i2).setEncoderPadding(i).build();
                }
                return -5;
            } else if (ClippingMediaPeriod.this.endUs == Long.MIN_VALUE || ((readData != -4 || decoderInputBuffer.timeUs < ClippingMediaPeriod.this.endUs) && (readData != -3 || ClippingMediaPeriod.this.getBufferedPositionUs() != Long.MIN_VALUE || decoderInputBuffer.waitingForKeys))) {
                return readData;
            } else {
                decoderInputBuffer.clear();
                decoderInputBuffer.setFlags(4);
                this.sentEos = true;
                return -4;
            }
        }

        public final int skipData(long j) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j);
        }
    }
}
