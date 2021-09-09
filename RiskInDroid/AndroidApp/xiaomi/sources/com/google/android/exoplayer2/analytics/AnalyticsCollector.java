package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AnalyticsCollector implements Player.EventListener, AudioListener, AudioRendererEventListener, DrmSessionEventListener, MetadataOutput, MediaSourceEventListener, BandwidthMeter.EventListener, VideoListener, VideoRendererEventListener {
    private final Clock clock;
    private boolean isSeeking;
    private final CopyOnWriteArraySet<AnalyticsListener> listeners = new CopyOnWriteArraySet<>();
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker = new MediaPeriodQueueTracker();
    private Player player;
    private final Timeline.Window window = new Timeline.Window();

    @Deprecated
    public /* synthetic */ void onLoadingChanged(boolean z) {
        Player.EventListener.CC.$default$onLoadingChanged(this, z);
    }

    public final void onRenderedFirstFrame() {
    }

    @Deprecated
    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
    }

    public AnalyticsCollector(Clock clock2) {
        this.clock = (Clock) Assertions.checkNotNull(clock2);
    }

    public void addListener(AnalyticsListener analyticsListener) {
        this.listeners.add(analyticsListener);
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public void setPlayer(Player player2) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodInfoQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player2);
    }

    public final void notifySeekStarted() {
        if (!this.isSeeking) {
            AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
            this.isSeeking = true;
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onSeekStarted(generateCurrentPlayerMediaPeriodEventTime);
            }
        }
    }

    public final void resetForNewPlaylist() {
        for (MediaPeriodInfo mediaPeriodInfo : new ArrayList(this.mediaPeriodQueueTracker.mediaPeriodInfoQueue)) {
            onMediaPeriodReleased(mediaPeriodInfo.windowIndex, mediaPeriodInfo.mediaPeriodId);
        }
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(generateCurrentPlayerMediaPeriodEventTime, metadata);
        }
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(generateReadingMediaPeriodEventTime, 1, decoderCounters);
        }
    }

    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(generateReadingMediaPeriodEventTime, 1, str, j2);
        }
    }

    public final void onAudioInputFormatChanged(Format format) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(generateReadingMediaPeriodEventTime, 1, format);
        }
    }

    public final void onAudioSinkUnderrun(int i, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioUnderrun(generateReadingMediaPeriodEventTime, i, j, j2);
        }
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(generatePlayingMediaPeriodEventTime, 1, decoderCounters);
        }
    }

    public final void onAudioSessionId(int i) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(generateReadingMediaPeriodEventTime, i);
        }
    }

    public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAudioAttributesChanged(generateReadingMediaPeriodEventTime, audioAttributes);
        }
    }

    public void onSkipSilenceEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSkipSilenceEnabledChanged(generateReadingMediaPeriodEventTime, z);
        }
    }

    public void onVolumeChanged(float f) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(generateReadingMediaPeriodEventTime, f);
        }
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(generateReadingMediaPeriodEventTime, 2, decoderCounters);
        }
    }

    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(generateReadingMediaPeriodEventTime, 2, str, j2);
        }
    }

    public final void onVideoInputFormatChanged(Format format) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(generateReadingMediaPeriodEventTime, 2, format);
        }
    }

    public final void onDroppedFrames(int i, long j) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(generatePlayingMediaPeriodEventTime, i, j);
        }
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(generatePlayingMediaPeriodEventTime, 2, decoderCounters);
        }
    }

    public final void onRenderedFirstFrame(Surface surface) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRenderedFirstFrame(generateReadingMediaPeriodEventTime, surface);
        }
    }

    public final void onVideoFrameProcessingOffset(long j, int i, Format format) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoFrameProcessingOffset(generatePlayingMediaPeriodEventTime, j, i, format);
        }
    }

    public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(generateReadingMediaPeriodEventTime, i, i2, i3, f);
        }
    }

    public void onSurfaceSizeChanged(int i, int i2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(generateReadingMediaPeriodEventTime, i, i2);
        }
    }

    public final void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onMediaPeriodCreated(i, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(generateMediaPeriodEventTime);
        }
    }

    public final void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        if (this.mediaPeriodQueueTracker.onMediaPeriodReleased(mediaPeriodId, (Player) Assertions.checkNotNull(this.player))) {
            Iterator<AnalyticsListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onMediaPeriodReleased(generateMediaPeriodEventTime);
            }
        }
    }

    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadStarted(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCompleted(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadCanceled(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData);
        }
    }

    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z);
        }
    }

    public final void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onReadingStarted(mediaPeriodId);
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(generateMediaPeriodEventTime);
        }
    }

    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onUpstreamDiscarded(generateMediaPeriodEventTime, mediaLoadData);
        }
    }

    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(generateMediaPeriodEventTime, mediaLoadData);
        }
    }

    public final void onTimelineChanged(Timeline timeline, int i) {
        this.mediaPeriodQueueTracker.onTimelineChanged(timeline, (Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(generateCurrentPlayerMediaPeriodEventTime, i);
        }
    }

    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(generateCurrentPlayerMediaPeriodEventTime, trackGroupArray, trackSelectionArray);
        }
    }

    public final void onIsLoadingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onIsLoadingChanged(generateCurrentPlayerMediaPeriodEventTime, z);
        }
    }

    public final void onPlayerStateChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(generateCurrentPlayerMediaPeriodEventTime, z, i);
        }
    }

    public final void onPlaybackStateChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackStateChanged(generateCurrentPlayerMediaPeriodEventTime, i);
        }
    }

    public final void onPlayWhenReadyChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayWhenReadyChanged(generateCurrentPlayerMediaPeriodEventTime, z, i);
        }
    }

    public void onPlaybackSuppressionReasonChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSuppressionReasonChanged(generateCurrentPlayerMediaPeriodEventTime, i);
        }
    }

    public void onIsPlayingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onIsPlayingChanged(generateCurrentPlayerMediaPeriodEventTime, z);
        }
    }

    public final void onRepeatModeChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(generateCurrentPlayerMediaPeriodEventTime, i);
        }
    }

    public final void onShuffleModeEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeChanged(generateCurrentPlayerMediaPeriodEventTime, z);
        }
    }

    public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerError(generateCurrentPlayerMediaPeriodEventTime, exoPlaybackException);
        }
    }

    public final void onPositionDiscontinuity(int i) {
        if (i == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(generateCurrentPlayerMediaPeriodEventTime, i);
        }
    }

    @Deprecated
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackParametersChanged(generateCurrentPlayerMediaPeriodEventTime, playbackParameters);
        }
    }

    public void onPlaybackSpeedChanged(float f) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlaybackSpeedChanged(generateCurrentPlayerMediaPeriodEventTime, f);
        }
    }

    public final void onSeekProcessed() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onSeekProcessed(generateCurrentPlayerMediaPeriodEventTime);
        }
    }

    public final void onBandwidthSample(int i, long j, long j2) {
        AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onBandwidthEstimate(generateLoadingMediaPeriodEventTime, i, j, j2);
        }
    }

    public final void onDrmSessionAcquired() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionAcquired(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmKeysLoaded() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysLoaded(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmSessionManagerError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(generateReadingMediaPeriodEventTime, exc);
        }
    }

    public final void onDrmKeysRestored() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRestored(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmKeysRemoved() {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmKeysRemoved(generateReadingMediaPeriodEventTime);
        }
    }

    public final void onDrmSessionReleased() {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        Iterator<AnalyticsListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionReleased(generatePlayingMediaPeriodEventTime);
        }
    }

    /* access modifiers changed from: protected */
    public Set<AnalyticsListener> getListeners() {
        return Collections.unmodifiableSet(this.listeners);
    }

    /* access modifiers changed from: protected */
    public AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        if (timeline.isEmpty()) {
            mediaPeriodId = null;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z = true;
        boolean z2 = timeline.equals(this.player.getCurrentTimeline()) && i == this.player.getCurrentWindowIndex();
        long j = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (!(z2 && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup)) {
                z = false;
            }
            if (z) {
                j = this.player.getCurrentPosition();
            }
        } else if (z2) {
            j = this.player.getContentPosition();
        } else if (!timeline.isEmpty()) {
            j = timeline.getWindow(i, this.window).getDefaultPositionMs();
        }
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    private AnalyticsListener.EventTime generateEventTime(MediaPeriodInfo mediaPeriodInfo) {
        Assertions.checkNotNull(this.player);
        if (mediaPeriodInfo != null) {
            return generateEventTime(mediaPeriodInfo.timeline, mediaPeriodInfo.windowIndex, mediaPeriodInfo.mediaPeriodId);
        }
        int currentWindowIndex = this.player.getCurrentWindowIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentWindowIndex, null);
    }

    private AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId != null) {
            MediaPeriodInfo mediaPeriodInfo = this.mediaPeriodQueueTracker.getMediaPeriodInfo(mediaPeriodId);
            if (mediaPeriodInfo != null) {
                return generateEventTime(mediaPeriodInfo);
            }
            return generateEventTime(Timeline.EMPTY, i, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(i < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, null);
    }

    static final class MediaPeriodQueueTracker {
        private MediaPeriodInfo currentPlayerMediaPeriod;
        private final HashMap<MediaSource.MediaPeriodId, MediaPeriodInfo> mediaPeriodIdToInfo = new HashMap<>();
        public final ArrayList<MediaPeriodInfo> mediaPeriodInfoQueue = new ArrayList<>();
        private final Timeline.Period period = new Timeline.Period();
        private MediaPeriodInfo playingMediaPeriod;
        private MediaPeriodInfo readingMediaPeriod;
        private Timeline timeline = Timeline.EMPTY;

        public final MediaPeriodInfo getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public final MediaPeriodInfo getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public final MediaPeriodInfo getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public final MediaPeriodInfo getLoadingMediaPeriod() {
            if (this.mediaPeriodInfoQueue.isEmpty()) {
                return null;
            }
            ArrayList<MediaPeriodInfo> arrayList = this.mediaPeriodInfoQueue;
            return arrayList.get(arrayList.size() - 1);
        }

        public final MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodIdToInfo.get(mediaPeriodId);
        }

        public final void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findMatchingMediaPeriodInQueue(player);
        }

        public final void onTimelineChanged(Timeline timeline2, Player player) {
            for (int i = 0; i < this.mediaPeriodInfoQueue.size(); i++) {
                MediaPeriodInfo updateMediaPeriodInfoToNewTimeline = updateMediaPeriodInfoToNewTimeline(this.mediaPeriodInfoQueue.get(i), timeline2);
                this.mediaPeriodInfoQueue.set(i, updateMediaPeriodInfoToNewTimeline);
                this.mediaPeriodIdToInfo.put(updateMediaPeriodInfoToNewTimeline.mediaPeriodId, updateMediaPeriodInfoToNewTimeline);
            }
            if (!this.mediaPeriodInfoQueue.isEmpty()) {
                this.playingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
            } else {
                MediaPeriodInfo mediaPeriodInfo = this.playingMediaPeriod;
                if (mediaPeriodInfo != null) {
                    this.playingMediaPeriod = updateMediaPeriodInfoToNewTimeline(mediaPeriodInfo, timeline2);
                }
            }
            MediaPeriodInfo mediaPeriodInfo2 = this.readingMediaPeriod;
            if (mediaPeriodInfo2 != null) {
                this.readingMediaPeriod = updateMediaPeriodInfoToNewTimeline(mediaPeriodInfo2, timeline2);
            } else {
                MediaPeriodInfo mediaPeriodInfo3 = this.playingMediaPeriod;
                if (mediaPeriodInfo3 != null) {
                    this.readingMediaPeriod = mediaPeriodInfo3;
                }
            }
            this.timeline = timeline2;
            this.currentPlayerMediaPeriod = findMatchingMediaPeriodInQueue(player);
        }

        public final void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            int indexOfPeriod = this.timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
            boolean z = indexOfPeriod != -1;
            Timeline timeline2 = z ? this.timeline : Timeline.EMPTY;
            if (z) {
                i = this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex;
            }
            MediaPeriodInfo mediaPeriodInfo = new MediaPeriodInfo(mediaPeriodId, timeline2, i);
            this.mediaPeriodInfoQueue.add(mediaPeriodInfo);
            this.mediaPeriodIdToInfo.put(mediaPeriodId, mediaPeriodInfo);
            this.playingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
            if (this.currentPlayerMediaPeriod == null && isMatchingPlayingMediaPeriod(player)) {
                this.currentPlayerMediaPeriod = this.playingMediaPeriod;
            }
            if (this.mediaPeriodInfoQueue.size() == 1) {
                this.readingMediaPeriod = this.playingMediaPeriod;
            }
        }

        public final boolean onMediaPeriodReleased(MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            MediaPeriodInfo mediaPeriodInfo;
            MediaPeriodInfo remove = this.mediaPeriodIdToInfo.remove(mediaPeriodId);
            if (remove == null) {
                return false;
            }
            this.mediaPeriodInfoQueue.remove(remove);
            MediaPeriodInfo mediaPeriodInfo2 = this.readingMediaPeriod;
            if (mediaPeriodInfo2 != null && mediaPeriodId.equals(mediaPeriodInfo2.mediaPeriodId)) {
                if (this.mediaPeriodInfoQueue.isEmpty()) {
                    mediaPeriodInfo = (MediaPeriodInfo) Assertions.checkNotNull(this.playingMediaPeriod);
                } else {
                    mediaPeriodInfo = this.mediaPeriodInfoQueue.get(0);
                }
                this.readingMediaPeriod = mediaPeriodInfo;
            }
            if (!this.mediaPeriodInfoQueue.isEmpty()) {
                this.playingMediaPeriod = this.mediaPeriodInfoQueue.get(0);
            }
            if (this.currentPlayerMediaPeriod != null || !isMatchingPlayingMediaPeriod(player)) {
                return true;
            }
            this.currentPlayerMediaPeriod = this.playingMediaPeriod;
            return true;
        }

        public final void onReadingStarted(MediaSource.MediaPeriodId mediaPeriodId) {
            MediaPeriodInfo mediaPeriodInfo = this.mediaPeriodIdToInfo.get(mediaPeriodId);
            if (mediaPeriodInfo != null) {
                this.readingMediaPeriod = mediaPeriodInfo;
            }
        }

        private MediaPeriodInfo findMatchingMediaPeriodInQueue(Player player) {
            MediaPeriodInfo mediaPeriodInfo;
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, this.period).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - this.period.getPositionInWindowUs());
            for (int i = 0; i < this.mediaPeriodInfoQueue.size(); i++) {
                MediaPeriodInfo mediaPeriodInfo2 = this.mediaPeriodInfoQueue.get(i);
                if (isMatchingMediaPeriod(mediaPeriodInfo2, currentTimeline, player.getCurrentWindowIndex(), uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodInfo2;
                }
            }
            if (this.mediaPeriodInfoQueue.isEmpty() && (mediaPeriodInfo = this.playingMediaPeriod) != null) {
                if (isMatchingMediaPeriod(mediaPeriodInfo, currentTimeline, player.getCurrentWindowIndex(), uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return this.playingMediaPeriod;
                }
            }
            return null;
        }

        private boolean isMatchingPlayingMediaPeriod(Player player) {
            if (this.playingMediaPeriod == null) {
                return false;
            }
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            return isMatchingMediaPeriod(this.playingMediaPeriod, currentTimeline, player.getCurrentWindowIndex(), currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex), player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, this.period).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - this.period.getPositionInWindowUs()));
        }

        private static boolean isMatchingMediaPeriod(MediaPeriodInfo mediaPeriodInfo, Timeline timeline2, int i, Object obj, boolean z, int i2, int i3, int i4) {
            if (!mediaPeriodInfo.timeline.isEmpty() && mediaPeriodInfo.timeline.equals(timeline2) && mediaPeriodInfo.windowIndex == i && mediaPeriodInfo.mediaPeriodId.periodUid.equals(obj)) {
                if (z && mediaPeriodInfo.mediaPeriodId.adGroupIndex == i2 && mediaPeriodInfo.mediaPeriodId.adIndexInAdGroup == i3) {
                    return true;
                }
                if (!z && mediaPeriodInfo.mediaPeriodId.adGroupIndex == -1 && mediaPeriodInfo.mediaPeriodId.nextAdGroupIndex == i4) {
                    return true;
                }
                return false;
            }
            return false;
        }

        private MediaPeriodInfo updateMediaPeriodInfoToNewTimeline(MediaPeriodInfo mediaPeriodInfo, Timeline timeline2) {
            int indexOfPeriod = timeline2.getIndexOfPeriod(mediaPeriodInfo.mediaPeriodId.periodUid);
            if (indexOfPeriod == -1) {
                return mediaPeriodInfo;
            }
            return new MediaPeriodInfo(mediaPeriodInfo.mediaPeriodId, timeline2, timeline2.getPeriod(indexOfPeriod, this.period).windowIndex);
        }
    }

    static final class MediaPeriodInfo {
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final Timeline timeline;
        public final int windowIndex;

        public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId2, Timeline timeline2, int i) {
            this.mediaPeriodId = mediaPeriodId2;
            this.timeline = timeline2;
            this.windowIndex = i;
        }
    }
}
