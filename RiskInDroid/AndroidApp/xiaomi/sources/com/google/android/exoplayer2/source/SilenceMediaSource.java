package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class SilenceMediaSource extends BaseMediaSource {
    public static final Format FORMAT = new Format.Builder().setSampleMimeType("audio/raw").setChannelCount(2).setSampleRate(44100).setPcmEncoding(2).build();
    public static final byte[] SILENCE_SAMPLE = new byte[(Util.getPcmFrameSize(2, 2) * 1024)];
    private final long durationUs;
    private final Object tag;

    public final void maybeThrowSourceInfoRefreshError() {
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
    }

    /* access modifiers changed from: protected */
    public final void releaseSourceInternal() {
    }

    public static final class Factory {
        private long durationUs;
        private Object tag;

        public final Factory setDurationUs(long j) {
            this.durationUs = j;
            return this;
        }

        public final Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public final SilenceMediaSource createMediaSource() {
            return new SilenceMediaSource(this.durationUs, this.tag);
        }
    }

    public SilenceMediaSource(long j) {
        this(j, null);
    }

    private SilenceMediaSource(long j, Object obj) {
        Assertions.checkArgument(j >= 0);
        this.durationUs = j;
        this.tag = obj;
    }

    /* access modifiers changed from: protected */
    public final void prepareSourceInternal(TransferListener transferListener) {
        refreshSourceInfo(new SinglePeriodTimeline(this.durationUs, true, false, false, null, this.tag));
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new SilenceMediaPeriod(this.durationUs);
    }

    static final class SilenceMediaPeriod implements MediaPeriod {
        private static final TrackGroupArray TRACKS = new TrackGroupArray(new TrackGroup(SilenceMediaSource.FORMAT));
        private final long durationUs;
        private final ArrayList<SampleStream> sampleStreams = new ArrayList<>();

        public final boolean continueLoading(long j) {
            return false;
        }

        public final void discardBuffer(long j, boolean z) {
        }

        public final long getBufferedPositionUs() {
            return Long.MIN_VALUE;
        }

        public final long getNextLoadPositionUs() {
            return Long.MIN_VALUE;
        }

        public /* synthetic */ List<StreamKey> getStreamKeys(List<TrackSelection> list) {
            return MediaPeriod.CC.$default$getStreamKeys(this, list);
        }

        public final boolean isLoading() {
            return false;
        }

        public final void maybeThrowPrepareError() {
        }

        public final long readDiscontinuity() {
            return -9223372036854775807L;
        }

        public final void reevaluateBuffer(long j) {
        }

        public SilenceMediaPeriod(long j) {
            this.durationUs = j;
        }

        public final void prepare(MediaPeriod.Callback callback, long j) {
            callback.onPrepared(this);
        }

        public final TrackGroupArray getTrackGroups() {
            return TRACKS;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            long constrainSeekPosition = constrainSeekPosition(j);
            for (int i = 0; i < trackSelectionArr.length; i++) {
                if (sampleStreamArr[i] != 0 && (trackSelectionArr[i] == null || !zArr[i])) {
                    this.sampleStreams.remove(sampleStreamArr[i]);
                    sampleStreamArr[i] = 0;
                }
                if (sampleStreamArr[i] == 0 && trackSelectionArr[i] != null) {
                    SilenceSampleStream silenceSampleStream = new SilenceSampleStream(this.durationUs);
                    silenceSampleStream.seekTo(constrainSeekPosition);
                    this.sampleStreams.add(silenceSampleStream);
                    sampleStreamArr[i] = silenceSampleStream;
                    zArr2[i] = true;
                }
            }
            return constrainSeekPosition;
        }

        public final long seekToUs(long j) {
            long constrainSeekPosition = constrainSeekPosition(j);
            for (int i = 0; i < this.sampleStreams.size(); i++) {
                ((SilenceSampleStream) this.sampleStreams.get(i)).seekTo(constrainSeekPosition);
            }
            return constrainSeekPosition;
        }

        public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return constrainSeekPosition(j);
        }

        private long constrainSeekPosition(long j) {
            return Util.constrainValue(j, 0, this.durationUs);
        }
    }

    static final class SilenceSampleStream implements SampleStream {
        private final long durationBytes;
        private long positionBytes;
        private boolean sentFormat;

        public final boolean isReady() {
            return true;
        }

        public final void maybeThrowError() {
        }

        public SilenceSampleStream(long j) {
            this.durationBytes = SilenceMediaSource.getAudioByteCount(j);
            seekTo(0);
        }

        public final void seekTo(long j) {
            this.positionBytes = Util.constrainValue(SilenceMediaSource.getAudioByteCount(j), 0, this.durationBytes);
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (!this.sentFormat || z) {
                formatHolder.format = SilenceMediaSource.FORMAT;
                this.sentFormat = true;
                return -5;
            }
            long j = this.durationBytes - this.positionBytes;
            if (j == 0) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            int min = (int) Math.min((long) SilenceMediaSource.SILENCE_SAMPLE.length, j);
            decoderInputBuffer.ensureSpaceForWrite(min);
            decoderInputBuffer.data.put(SilenceMediaSource.SILENCE_SAMPLE, 0, min);
            decoderInputBuffer.timeUs = SilenceMediaSource.getAudioPositionUs(this.positionBytes);
            decoderInputBuffer.addFlag(1);
            this.positionBytes += (long) min;
            return -4;
        }

        public final int skipData(long j) {
            long j2 = this.positionBytes;
            seekTo(j);
            return (int) ((this.positionBytes - j2) / ((long) SilenceMediaSource.SILENCE_SAMPLE.length));
        }
    }

    public static long getAudioByteCount(long j) {
        return ((long) Util.getPcmFrameSize(2, 2)) * ((j * 44100) / 1000000);
    }

    public static long getAudioPositionUs(long j) {
        return ((j / ((long) Util.getPcmFrameSize(2, 2))) * 1000000) / 44100;
    }
}
