package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class EventLogger implements AnalyticsListener {
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period;
    private final long startTimeMs;
    private final String tag;
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window;

    private static String getDiscontinuityReasonString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    private static String getPlayWhenReadyChangeReasonString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    private static String getPlaybackSuppressionReasonString(int i) {
        return i != 0 ? i != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE";
    }

    private static String getRepeatModeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    private static String getStateString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static String getTimelineChangeReasonString(int i) {
        return i != 0 ? i != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    private static String getTrackStatusString(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @Deprecated
    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onLoadingChanged(this, eventTime, z);
    }

    @Deprecated
    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AnalyticsListener.CC.$default$onPlayerStateChanged(this, eventTime, z, i);
    }

    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onSeekProcessed(this, eventTime);
    }

    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i, Format format) {
        AnalyticsListener.CC.$default$onVideoFrameProcessingOffset(this, eventTime, j, i, format);
    }

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = instance;
        instance.setMinimumFractionDigits(2);
        TIME_FORMAT.setMaximumFractionDigits(2);
        TIME_FORMAT.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, "EventLogger");
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector, String str) {
        this.trackSelector = mappingTrackSelector;
        this.tag = str;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.startTimeMs = SystemClock.elapsedRealtime();
    }

    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "loading", Boolean.toString(z));
    }

    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "state", getStateString(i));
    }

    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        logd(eventTime, "playWhenReady", z + ", " + getPlayWhenReadyChangeReasonString(i));
    }

    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "playbackSuppressionReason", getPlaybackSuppressionReasonString(i));
    }

    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "isPlaying", Boolean.toString(z));
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "repeatMode", getRepeatModeString(i));
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z));
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "positionDiscontinuity", getDiscontinuityReasonString(i));
    }

    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekStarted");
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", Util.formatInvariant("speed=%.2f", Float.valueOf(playbackParameters.speed)));
    }

    public void onPlaybackSpeedChanged(AnalyticsListener.EventTime eventTime, float f) {
        logd(eventTime, "playbackSpeed", Float.toString(f));
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        logd("timeline [" + getEventTimeString(eventTime) + ", periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i));
        for (int i2 = 0; i2 < Math.min(periodCount, 3); i2++) {
            eventTime.timeline.getPeriod(i2, this.period);
            logd("  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i3 = 0; i3 < Math.min(windowCount, 3); i3++) {
            eventTime.timeline.getWindow(i3, this.window);
            logd("  window [" + getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        loge(eventTime, "playerFailed", exoPlaybackException);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo.getAdaptiveSupport(int, int, boolean):int
     arg types: [int, int, int]
     candidates:
      com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo.getAdaptiveSupport(int, int, int[]):int
      com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo.getAdaptiveSupport(int, int, boolean):int */
    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        String str;
        String str2;
        MappingTrackSelector mappingTrackSelector = this.trackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector != null ? mappingTrackSelector.getCurrentMappedTrackInfo() : null;
        if (currentMappedTrackInfo == null) {
            logd(eventTime, "tracks", "[]");
            return;
        }
        logd("tracks [" + getEventTimeString(eventTime));
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        int i = 0;
        while (true) {
            str = "  ]";
            str2 = " [";
            if (i >= rendererCount) {
                break;
            }
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            TrackSelection trackSelection = trackSelectionArray.get(i);
            int i2 = rendererCount;
            if (trackGroups.length == 0) {
                logd("  " + currentMappedTrackInfo.getRendererName(i) + " []");
            } else {
                logd("  " + currentMappedTrackInfo.getRendererName(i) + str2);
                int i3 = 0;
                while (i3 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i3);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String str3 = str;
                    String adaptiveSupportString = getAdaptiveSupportString(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i, i3, false));
                    logd("    Group:" + i3 + ", adaptive_supported=" + adaptiveSupportString + str2);
                    int i4 = 0;
                    while (i4 < trackGroup.length) {
                        String trackStatusString = getTrackStatusString(trackSelection, trackGroup, i4);
                        String formatSupportString = RendererCapabilities.CC.getFormatSupportString(currentMappedTrackInfo.getTrackSupport(i, i3, i4));
                        String str4 = str2;
                        logd("      " + trackStatusString + " Track:" + i4 + ", " + Format.toLogString(trackGroup.getFormat(i4)) + ", supported=" + formatSupportString);
                        i4++;
                        str2 = str4;
                    }
                    logd("    ]");
                    i3++;
                    trackGroups = trackGroupArray2;
                    str = str3;
                }
                String str5 = str;
                if (trackSelection != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= trackSelection.length()) {
                            break;
                        }
                        Metadata metadata = trackSelection.getFormat(i5).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            printMetadata(metadata, "      ");
                            logd("    ]");
                            break;
                        }
                        i5++;
                    }
                }
                logd(str5);
            }
            i++;
            rendererCount = i2;
        }
        String str6 = str;
        String str7 = str2;
        TrackGroupArray unmappedTrackGroups = currentMappedTrackInfo.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Unmapped [");
            int i6 = 0;
            while (i6 < unmappedTrackGroups.length) {
                StringBuilder sb = new StringBuilder("    Group:");
                sb.append(i6);
                String str8 = str7;
                sb.append(str8);
                logd(sb.toString());
                TrackGroup trackGroup2 = unmappedTrackGroups.get(i6);
                for (int i7 = 0; i7 < trackGroup2.length; i7++) {
                    String trackStatusString2 = getTrackStatusString(false);
                    String formatSupportString2 = RendererCapabilities.CC.getFormatSupportString(0);
                    logd("      " + trackStatusString2 + " Track:" + i7 + ", " + Format.toLogString(trackGroup2.getFormat(i7)) + ", supported=" + formatSupportString2);
                }
                logd("    ]");
                i6++;
                str7 = str8;
            }
            logd(str6);
        }
        logd("]");
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        logd("metadata [" + getEventTimeString(eventTime));
        printMetadata(metadata, "  ");
        logd("]");
    }

    public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        logd(eventTime, "decoderEnabled", Util.getTrackTypeString(i));
    }

    public void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i) {
        logd(eventTime, "audioSessionId", Integer.toString(i));
    }

    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        logd(eventTime, "audioAttributes", audioAttributes.contentType + "," + audioAttributes.flags + "," + audioAttributes.usage + "," + audioAttributes.allowedCapturePolicy);
    }

    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        logd(eventTime, "skipSilenceEnabled", Boolean.toString(z));
    }

    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        logd(eventTime, "volume", Float.toString(f));
    }

    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        logd(eventTime, "decoderInitialized", Util.getTrackTypeString(i) + ", " + str);
    }

    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        logd(eventTime, "decoderInputFormat", Util.getTrackTypeString(i) + ", " + Format.toLogString(format));
    }

    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        logd(eventTime, "decoderDisabled", Util.getTrackTypeString(i));
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        loge(eventTime, "audioTrackUnderrun", i + ", " + j + ", " + j2 + "]", null);
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        logd(eventTime, "droppedFrames", Integer.toString(i));
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        logd(eventTime, "videoSize", i + ", " + i2);
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        logd(eventTime, "renderedFirstFrame", String.valueOf(surface));
    }

    public void onMediaPeriodCreated(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodCreated");
    }

    public void onMediaPeriodReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReleased");
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        printInternalError(eventTime, "loadError", iOException);
    }

    public void onReadingStarted(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReadingStarted");
    }

    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        logd(eventTime, "surfaceSize", i + ", " + i2);
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionAcquired");
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionReleased");
    }

    /* access modifiers changed from: protected */
    public void logd(String str) {
        Log.d(this.tag, str);
    }

    /* access modifiers changed from: protected */
    public void loge(String str) {
        Log.e(this.tag, str);
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str, null, null));
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2, null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, Throwable th) {
        loge(getEventString(eventTime, str, null, th));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        loge(getEventString(eventTime, str, str2, th));
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i = 0; i < metadata.length(); i++) {
            logd(str + metadata.get(i));
        }
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        String str3 = str + " [" + getEventTimeString(eventTime);
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String throwableString = Log.getThrowableString(th);
        if (!TextUtils.isEmpty(throwableString)) {
            str3 = str3 + "\n  " + throwableString.replace("\n", "\n  ") + 10;
        }
        return str3 + "]";
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return "eventTime=" + getTimeString(eventTime.realtimeMs - this.startTimeMs) + ", mediaPos=" + getTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    private static String getTimeString(long j) {
        return j == -9223372036854775807L ? "?" : TIME_FORMAT.format((double) (((float) j) / 1000.0f));
    }

    private static String getAdaptiveSupportString(int i, int i2) {
        if (i < 2) {
            return "N/A";
        }
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i2 == 16) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i) == -1) ? false : true);
    }
}
