package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;

public interface AnalyticsListener {
    void onAudioAttributesChanged(EventTime eventTime, AudioAttributes audioAttributes);

    void onAudioSessionId(EventTime eventTime, int i);

    void onAudioUnderrun(EventTime eventTime, int i, long j, long j2);

    void onBandwidthEstimate(EventTime eventTime, int i, long j, long j2);

    void onDecoderDisabled(EventTime eventTime, int i, DecoderCounters decoderCounters);

    void onDecoderEnabled(EventTime eventTime, int i, DecoderCounters decoderCounters);

    void onDecoderInitialized(EventTime eventTime, int i, String str, long j);

    void onDecoderInputFormatChanged(EventTime eventTime, int i, Format format);

    void onDownstreamFormatChanged(EventTime eventTime, MediaLoadData mediaLoadData);

    void onDrmKeysLoaded(EventTime eventTime);

    void onDrmKeysRemoved(EventTime eventTime);

    void onDrmKeysRestored(EventTime eventTime);

    void onDrmSessionAcquired(EventTime eventTime);

    void onDrmSessionManagerError(EventTime eventTime, Exception exc);

    void onDrmSessionReleased(EventTime eventTime);

    void onDroppedVideoFrames(EventTime eventTime, int i, long j);

    void onIsLoadingChanged(EventTime eventTime, boolean z);

    void onIsPlayingChanged(EventTime eventTime, boolean z);

    void onLoadCanceled(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z);

    void onLoadStarted(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    @Deprecated
    void onLoadingChanged(EventTime eventTime, boolean z);

    void onMediaPeriodCreated(EventTime eventTime);

    void onMediaPeriodReleased(EventTime eventTime);

    void onMetadata(EventTime eventTime, Metadata metadata);

    void onPlayWhenReadyChanged(EventTime eventTime, boolean z, int i);

    @Deprecated
    void onPlaybackParametersChanged(EventTime eventTime, PlaybackParameters playbackParameters);

    void onPlaybackSpeedChanged(EventTime eventTime, float f);

    void onPlaybackStateChanged(EventTime eventTime, int i);

    void onPlaybackSuppressionReasonChanged(EventTime eventTime, int i);

    void onPlayerError(EventTime eventTime, ExoPlaybackException exoPlaybackException);

    @Deprecated
    void onPlayerStateChanged(EventTime eventTime, boolean z, int i);

    void onPositionDiscontinuity(EventTime eventTime, int i);

    void onReadingStarted(EventTime eventTime);

    void onRenderedFirstFrame(EventTime eventTime, Surface surface);

    void onRepeatModeChanged(EventTime eventTime, int i);

    void onSeekProcessed(EventTime eventTime);

    void onSeekStarted(EventTime eventTime);

    void onShuffleModeChanged(EventTime eventTime, boolean z);

    void onSkipSilenceEnabledChanged(EventTime eventTime, boolean z);

    void onSurfaceSizeChanged(EventTime eventTime, int i, int i2);

    void onTimelineChanged(EventTime eventTime, int i);

    void onTracksChanged(EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

    void onUpstreamDiscarded(EventTime eventTime, MediaLoadData mediaLoadData);

    void onVideoFrameProcessingOffset(EventTime eventTime, long j, int i, Format format);

    void onVideoSizeChanged(EventTime eventTime, int i, int i2, int i3, float f);

    void onVolumeChanged(EventTime eventTime, float f);

    public static final class EventTime {
        public final long currentPlaybackPositionMs;
        public final long eventPlaybackPositionMs;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final long realtimeMs;
        public final Timeline timeline;
        public final long totalBufferedDurationMs;
        public final int windowIndex;

        public EventTime(long j, Timeline timeline2, int i, MediaSource.MediaPeriodId mediaPeriodId2, long j2, long j3, long j4) {
            this.realtimeMs = j;
            this.timeline = timeline2;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId2;
            this.eventPlaybackPositionMs = j2;
            this.currentPlaybackPositionMs = j3;
            this.totalBufferedDurationMs = j4;
        }
    }

    /* renamed from: com.google.android.exoplayer2.analytics.AnalyticsListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAudioAttributesChanged(AnalyticsListener analyticsListener, EventTime eventTime, AudioAttributes audioAttributes) {
        }

        public static void $default$onAudioSessionId(AnalyticsListener analyticsListener, EventTime eventTime, int i) {
        }

        public static void $default$onAudioUnderrun(AnalyticsListener analyticsListener, EventTime eventTime, int i, long j, long j2) {
        }

        public static void $default$onBandwidthEstimate(AnalyticsListener analyticsListener, EventTime eventTime, int i, long j, long j2) {
        }

        public static void $default$onDecoderDisabled(AnalyticsListener analyticsListener, EventTime eventTime, int i, DecoderCounters decoderCounters) {
        }

        public static void $default$onDecoderEnabled(AnalyticsListener analyticsListener, EventTime eventTime, int i, DecoderCounters decoderCounters) {
        }

        public static void $default$onDecoderInitialized(AnalyticsListener analyticsListener, EventTime eventTime, int i, String str, long j) {
        }

        public static void $default$onDecoderInputFormatChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i, Format format) {
        }

        public static void $default$onDownstreamFormatChanged(AnalyticsListener analyticsListener, EventTime eventTime, MediaLoadData mediaLoadData) {
        }

        public static void $default$onDrmKeysLoaded(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onDrmKeysRemoved(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onDrmKeysRestored(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onDrmSessionAcquired(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onDrmSessionManagerError(AnalyticsListener analyticsListener, EventTime eventTime, Exception exc) {
        }

        public static void $default$onDrmSessionReleased(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onDroppedVideoFrames(AnalyticsListener analyticsListener, EventTime eventTime, int i, long j) {
        }

        public static void $default$onIsPlayingChanged(AnalyticsListener analyticsListener, EventTime eventTime, boolean z) {
        }

        public static void $default$onLoadCanceled(AnalyticsListener analyticsListener, EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        }

        public static void $default$onLoadCompleted(AnalyticsListener analyticsListener, EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        }

        public static void $default$onLoadError(AnalyticsListener analyticsListener, EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        }

        public static void $default$onLoadStarted(AnalyticsListener analyticsListener, EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        }

        @Deprecated
        public static void $default$onLoadingChanged(AnalyticsListener analyticsListener, EventTime eventTime, boolean z) {
        }

        public static void $default$onMediaPeriodCreated(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onMediaPeriodReleased(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onMetadata(AnalyticsListener analyticsListener, EventTime eventTime, Metadata metadata) {
        }

        public static void $default$onPlayWhenReadyChanged(AnalyticsListener analyticsListener, EventTime eventTime, boolean z, int i) {
        }

        @Deprecated
        public static void $default$onPlaybackParametersChanged(AnalyticsListener analyticsListener, EventTime eventTime, PlaybackParameters playbackParameters) {
        }

        public static void $default$onPlaybackSpeedChanged(AnalyticsListener analyticsListener, EventTime eventTime, float f) {
        }

        public static void $default$onPlaybackStateChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i) {
        }

        public static void $default$onPlaybackSuppressionReasonChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i) {
        }

        public static void $default$onPlayerError(AnalyticsListener analyticsListener, EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        }

        @Deprecated
        public static void $default$onPlayerStateChanged(AnalyticsListener analyticsListener, EventTime eventTime, boolean z, int i) {
        }

        public static void $default$onPositionDiscontinuity(AnalyticsListener analyticsListener, EventTime eventTime, int i) {
        }

        public static void $default$onReadingStarted(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onRenderedFirstFrame(AnalyticsListener analyticsListener, EventTime eventTime, Surface surface) {
        }

        public static void $default$onRepeatModeChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i) {
        }

        public static void $default$onSeekProcessed(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onSeekStarted(AnalyticsListener analyticsListener, EventTime eventTime) {
        }

        public static void $default$onShuffleModeChanged(AnalyticsListener analyticsListener, EventTime eventTime, boolean z) {
        }

        public static void $default$onSkipSilenceEnabledChanged(AnalyticsListener analyticsListener, EventTime eventTime, boolean z) {
        }

        public static void $default$onSurfaceSizeChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i, int i2) {
        }

        public static void $default$onTimelineChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i) {
        }

        public static void $default$onTracksChanged(AnalyticsListener analyticsListener, EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        }

        public static void $default$onUpstreamDiscarded(AnalyticsListener analyticsListener, EventTime eventTime, MediaLoadData mediaLoadData) {
        }

        public static void $default$onVideoFrameProcessingOffset(AnalyticsListener analyticsListener, EventTime eventTime, long j, int i, Format format) {
        }

        public static void $default$onVideoSizeChanged(AnalyticsListener analyticsListener, EventTime eventTime, int i, int i2, int i3, float f) {
        }

        public static void $default$onVolumeChanged(AnalyticsListener analyticsListener, EventTime eventTime, float f) {
        }

        public static void $default$onIsLoadingChanged(AnalyticsListener _this, EventTime eventTime, boolean z) {
            _this.onLoadingChanged(eventTime, z);
        }
    }
}
