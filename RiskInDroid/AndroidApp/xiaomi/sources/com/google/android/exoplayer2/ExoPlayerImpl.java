package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean foregroundMode;
    private boolean hasPendingDiscontinuity;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private final MediaSourceFactory mediaSourceFactory;
    private final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
    private boolean pauseAtEndOfMediaItems;
    private int pendingDiscontinuityReason;
    private final ArrayDeque<Runnable> pendingListenerNotifications;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private int pendingSetPlaybackSpeedAcks;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private float playbackSpeed;
    private final Renderer[] renderers;
    private int repeatMode;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;

    public final Player.AudioComponent getAudioComponent() {
        return null;
    }

    public final Player.DeviceComponent getDeviceComponent() {
        return null;
    }

    public final Player.MetadataComponent getMetadataComponent() {
        return null;
    }

    public final Player.TextComponent getTextComponent() {
        return null;
    }

    public final Player.VideoComponent getVideoComponent() {
        return null;
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector2, MediaSourceFactory mediaSourceFactory2, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        Renderer[] rendererArr2 = rendererArr;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.4] [" + Util.DEVICE_DEBUG_INFO + "]");
        Assertions.checkState(rendererArr2.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector2);
        this.mediaSourceFactory = mediaSourceFactory2;
        this.useLazyPreparation = z;
        this.repeatMode = 0;
        this.listeners = new CopyOnWriteArrayList<>();
        this.mediaSourceHolders = new ArrayList();
        this.shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);
        this.emptyTrackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr2.length], new TrackSelection[rendererArr2.length], null);
        this.period = new Timeline.Period();
        this.playbackSpeed = 1.0f;
        this.seekParameters = SeekParameters.DEFAULT;
        this.maskingWindowIndex = -1;
        this.eventHandler = new Handler(looper) {
            /* class com.google.android.exoplayer2.ExoPlayerImpl.AnonymousClass1 */

            public void handleMessage(Message message) {
                ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.playbackInfo = PlaybackInfo.createDummy(this.emptyTrackSelectorResult);
        this.pendingListenerNotifications = new ArrayDeque<>();
        if (analyticsCollector2 != null) {
            analyticsCollector2.setPlayer(this);
        }
        this.internalPlayer = new ExoPlayerImplInternal(rendererArr, trackSelector2, this.emptyTrackSelectorResult, loadControl, bandwidthMeter, this.repeatMode, this.shuffleModeEnabled, analyticsCollector, this.eventHandler, clock);
        this.internalPlayerHandler = new Handler(this.internalPlayer.getPlaybackLooper());
    }

    public final void experimental_setReleaseTimeoutMs(long j) {
        this.internalPlayer.experimental_setReleaseTimeoutMs(j);
    }

    public final void experimental_throwWhenStuckBuffering() {
        this.internalPlayer.experimental_throwWhenStuckBuffering();
    }

    public final Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public final Looper getApplicationLooper() {
        return this.eventHandler.getLooper();
    }

    public final void addListener(Player.EventListener eventListener) {
        this.listeners.addIfAbsent(new BasePlayer.ListenerHolder(eventListener));
    }

    public final void removeListener(Player.EventListener eventListener) {
        Iterator<BasePlayer.ListenerHolder> it = this.listeners.iterator();
        while (it.hasNext()) {
            BasePlayer.ListenerHolder next = it.next();
            if (next.listener.equals(eventListener)) {
                next.release();
                this.listeners.remove(next);
            }
        }
    }

    public final int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    public final int getPlaybackSuppressionReason() {
        return this.playbackInfo.playbackSuppressionReason;
    }

    @Deprecated
    public final ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    public final ExoPlaybackException getPlayerError() {
        return this.playbackInfo.playbackError;
    }

    @Deprecated
    public final void retry() {
        prepare();
    }

    public final void prepare() {
        if (this.playbackInfo.playbackState == 1) {
            PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(false, true, this.playbackInfo.timeline.isEmpty() ? 4 : 2);
            this.pendingOperationAcks++;
            this.internalPlayer.prepare();
            updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, 1, false);
        }
    }

    @Deprecated
    public final void prepare(MediaSource mediaSource) {
        setMediaSource(mediaSource);
        prepare();
    }

    @Deprecated
    public final void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        setMediaSource(mediaSource, z);
        prepare();
    }

    public final void setMediaItems(List<MediaItem> list, int i, long j) {
        setMediaSources(createMediaSources(list), i, j);
    }

    public final void setMediaSource(MediaSource mediaSource) {
        setMediaSources(Collections.singletonList(mediaSource));
    }

    public final void setMediaSource(MediaSource mediaSource, long j) {
        setMediaSources(Collections.singletonList(mediaSource), 0, j);
    }

    public final void setMediaSource(MediaSource mediaSource, boolean z) {
        setMediaSources(Collections.singletonList(mediaSource), z);
    }

    public final void setMediaSources(List<MediaSource> list) {
        setMediaSources(list, true);
    }

    public final void setMediaSources(List<MediaSource> list, boolean z) {
        setMediaSourcesInternal(list, -1, -9223372036854775807L, z);
    }

    public final void setMediaSources(List<MediaSource> list, int i, long j) {
        setMediaSourcesInternal(list, i, j, false);
    }

    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(this.mediaSourceHolders.size(), list);
    }

    public final void addMediaItems(int i, List<MediaItem> list) {
        addMediaSources(i, createMediaSources(list));
    }

    public final void addMediaSource(MediaSource mediaSource) {
        addMediaSources(Collections.singletonList(mediaSource));
    }

    public final void addMediaSource(int i, MediaSource mediaSource) {
        addMediaSources(i, Collections.singletonList(mediaSource));
    }

    public final void addMediaSources(List<MediaSource> list) {
        addMediaSources(this.mediaSourceHolders.size(), list);
    }

    public final void addMediaSources(int i, List<MediaSource> list) {
        Assertions.checkArgument(i >= 0);
        for (int i2 = 0; i2 < list.size(); i2++) {
            Assertions.checkArgument(list.get(i2) != null);
        }
        int currentWindowIndex = getCurrentWindowIndex();
        long currentPosition = getCurrentPosition();
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(i, list);
        PlaybackInfo maskTimelineAndWindowIndex = maskTimelineAndWindowIndex(currentWindowIndex, currentPosition, currentTimeline);
        this.internalPlayer.addMediaSources(i, addMediaSourceHolders, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndWindowIndex, false, 4, 0, 1, false);
    }

    public final void removeMediaItems(int i, int i2) {
        Assertions.checkArgument(i2 > i);
        removeMediaItemsInternal(i, i2);
    }

    public final void moveMediaItems(int i, int i2, int i3) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i2 <= this.mediaSourceHolders.size() && i3 >= 0);
        int currentWindowIndex = getCurrentWindowIndex();
        long currentPosition = getCurrentPosition();
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        int min = Math.min(i3, this.mediaSourceHolders.size() - (i2 - i));
        MediaSourceList.moveMediaSourceHolders(this.mediaSourceHolders, i, i2, min);
        PlaybackInfo maskTimelineAndWindowIndex = maskTimelineAndWindowIndex(currentWindowIndex, currentPosition, currentTimeline);
        this.internalPlayer.moveMediaSources(i, i2, min, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndWindowIndex, false, 4, 0, 1, false);
    }

    public final void clearMediaItems() {
        if (!this.mediaSourceHolders.isEmpty()) {
            removeMediaItemsInternal(0, this.mediaSourceHolders.size());
        }
    }

    public final void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        PlaybackInfo maskTimeline = maskTimeline();
        maskWithCurrentPosition();
        this.pendingOperationAcks++;
        this.shuffleOrder = shuffleOrder2;
        this.internalPlayer.setShuffleOrder(shuffleOrder2);
        updatePlaybackInfo(maskTimeline, false, 4, 0, 1, false);
    }

    public final void setPlayWhenReady(boolean z) {
        setPlayWhenReady(z, 0, 1);
    }

    public final void setPauseAtEndOfMediaItems(boolean z) {
        if (this.pauseAtEndOfMediaItems != z) {
            this.pauseAtEndOfMediaItems = z;
            this.internalPlayer.setPauseAtEndOfWindow(z);
        }
    }

    public final boolean getPauseAtEndOfMediaItems() {
        return this.pauseAtEndOfMediaItems;
    }

    public final void setPlayWhenReady(boolean z, int i, int i2) {
        if (this.playbackInfo.playWhenReady != z || this.playbackInfo.playbackSuppressionReason != i) {
            maskWithCurrentPosition();
            this.pendingOperationAcks++;
            PlaybackInfo copyWithPlayWhenReady = this.playbackInfo.copyWithPlayWhenReady(z, i);
            this.internalPlayer.setPlayWhenReady(z, i);
            updatePlaybackInfo(copyWithPlayWhenReady, false, 4, 0, i2, false);
        }
    }

    public final boolean getPlayWhenReady() {
        return this.playbackInfo.playWhenReady;
    }

    public final void setRepeatMode(int i) {
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.internalPlayer.setRepeatMode(i);
            notifyListeners(new BasePlayer.ListenerInvocation(i) {
                /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$13cqkhJn5EHCEgYMPoK9tX07YUc */
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onRepeatModeChanged(this.f$0);
                }
            });
        }
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    public final void setShuffleModeEnabled(boolean z) {
        if (this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            this.internalPlayer.setShuffleModeEnabled(z);
            notifyListeners(new BasePlayer.ListenerInvocation(z) {
                /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$gYGr7twRK5sa_7XIeIE3F74_uzY */
                private final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onShuffleModeEnabledChanged(this.f$0);
                }
            });
        }
    }

    public final boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public final boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public final void seekTo(int i, long j) {
        Timeline timeline = this.playbackInfo.timeline;
        if (i < 0 || (!timeline.isEmpty() && i >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i, j);
        }
        int i2 = 1;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            return;
        }
        maskWindowIndexAndPositionForSeek(timeline, i, j);
        if (getPlaybackState() != 1) {
            i2 = 2;
        }
        PlaybackInfo copyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(i2);
        this.internalPlayer.seekTo(timeline, i, C.msToUs(j));
        updatePlaybackInfo(copyWithPlaybackState, true, 1, 0, 1, true);
    }

    @Deprecated
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        setPlaybackSpeed(playbackParameters != null ? playbackParameters.speed : 1.0f);
    }

    @Deprecated
    public final PlaybackParameters getPlaybackParameters() {
        return new PlaybackParameters(this.playbackSpeed);
    }

    public final void setPlaybackSpeed(float f) {
        Assertions.checkState(f > 0.0f);
        if (this.playbackSpeed != f) {
            this.pendingSetPlaybackSpeedAcks++;
            this.playbackSpeed = f;
            PlaybackParameters playbackParameters = new PlaybackParameters(f);
            this.internalPlayer.setPlaybackSpeed(f);
            notifyListeners(new BasePlayer.ListenerInvocation(f) {
                /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$gHHZyEBklILVNcSmOG3MOvBYQks */
                private final /* synthetic */ float f$1;

                {
                    this.f$1 = r2;
                }

                public final void invokeListener(Player.EventListener eventListener) {
                    ExoPlayerImpl.lambda$setPlaybackSpeed$2(PlaybackParameters.this, this.f$1, eventListener);
                }
            });
        }
    }

    static /* synthetic */ void lambda$setPlaybackSpeed$2(PlaybackParameters playbackParameters, float f, Player.EventListener eventListener) {
        eventListener.onPlaybackParametersChanged(playbackParameters);
        eventListener.onPlaybackSpeedChanged(f);
    }

    public final float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    public final void setSeekParameters(SeekParameters seekParameters2) {
        if (seekParameters2 == null) {
            seekParameters2 = SeekParameters.DEFAULT;
        }
        if (!this.seekParameters.equals(seekParameters2)) {
            this.seekParameters = seekParameters2;
            this.internalPlayer.setSeekParameters(seekParameters2);
        }
    }

    public final SeekParameters getSeekParameters() {
        return this.seekParameters;
    }

    public final void setForegroundMode(boolean z) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            this.internalPlayer.setForegroundMode(z);
        }
    }

    public final void stop(boolean z) {
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z, z, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(z);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 0, 1, false);
    }

    public final void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.4] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        if (!this.internalPlayer.release()) {
            notifyListeners($$Lambda$ExoPlayerImpl$rgxPjaRqOLSbkNiTS414ARJgNvY.INSTANCE);
        }
        this.eventHandler.removeCallbacksAndMessages(null);
        this.playbackInfo = getResetPlaybackInfo(false, false, 1);
    }

    public final PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    public final int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
    }

    public final int getCurrentWindowIndex() {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    public final long getDuration() {
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public final long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.periodId.isAd()) {
            return C.usToMs(this.playbackInfo.positionUs);
        }
        return periodPositionUsToWindowPositionMs(this.playbackInfo.periodId, this.playbackInfo.positionUs);
    }

    public final long getBufferedPosition() {
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        if (this.playbackInfo.loadingMediaPeriodId.equals(this.playbackInfo.periodId)) {
            return C.usToMs(this.playbackInfo.bufferedPositionUs);
        }
        return getDuration();
    }

    public final long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public final boolean isPlayingAd() {
        return !shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    public final int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public final int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public final long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period);
        if (this.playbackInfo.requestedContentPositionUs == -9223372036854775807L) {
            return this.playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
        }
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.requestedContentPositionUs);
    }

    public final long getContentBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.loadingMediaPeriodId.windowSequenceNumber != this.playbackInfo.periodId.windowSequenceNumber) {
            return this.playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j = this.playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            Timeline.Period periodByUid = this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return periodPositionUsToWindowPositionMs(this.playbackInfo.loadingMediaPeriodId, j);
    }

    public final int getRendererCount() {
        return this.renderers.length;
    }

    public final int getRendererType(int i) {
        return this.renderers[i].getTrackType();
    }

    public final TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    public final TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    public final Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    /* access modifiers changed from: package-private */
    public final void handleEvent(Message message) {
        int i = message.what;
        if (i != 0) {
            boolean z = true;
            if (i == 1) {
                float floatValue = ((Float) message.obj).floatValue();
                if (message.arg1 == 0) {
                    z = false;
                }
                handlePlaybackSpeed(floatValue, z);
                return;
            }
            throw new IllegalStateException();
        }
        handlePlaybackInfo((ExoPlayerImplInternal.PlaybackInfoUpdate) message.obj);
    }

    private int getCurrentWindowIndexInternal() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        return this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    private List<MediaSource> createMediaSources(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource(list.get(i)));
        }
        return arrayList;
    }

    private void handlePlaybackSpeed(float f, boolean z) {
        if (z) {
            this.pendingSetPlaybackSpeedAcks--;
        }
        if (this.pendingSetPlaybackSpeedAcks == 0 && this.playbackSpeed != f) {
            this.playbackSpeed = f;
            notifyListeners(new BasePlayer.ListenerInvocation(f) {
                /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$wumJNkhafkkLW1bwnBRm4my2hxo */
                private final /* synthetic */ float f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(Player.EventListener eventListener) {
                    ExoPlayerImpl.lambda$handlePlaybackSpeed$4(this.f$0, eventListener);
                }
            });
        }
    }

    static /* synthetic */ void lambda$handlePlaybackSpeed$4(float f, Player.EventListener eventListener) {
        eventListener.onPlaybackParametersChanged(new PlaybackParameters(f));
        eventListener.onPlaybackSpeedChanged(f);
    }

    private void handlePlaybackInfo(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.pendingOperationAcks -= playbackInfoUpdate.operationAcks;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.hasPendingDiscontinuity = true;
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (this.pendingOperationAcks == 0) {
            if (!this.playbackInfo.timeline.isEmpty() && playbackInfoUpdate.playbackInfo.timeline.isEmpty()) {
                resetMaskingPosition();
            }
            boolean z = this.hasPendingDiscontinuity;
            this.hasPendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, z, this.pendingDiscontinuityReason, 1, this.pendingPlayWhenReadyChangeReason, false);
        }
    }

    private PlaybackInfo getResetPlaybackInfo(boolean z, boolean z2, int i) {
        if (z) {
            removeMediaSourceHolders(0, this.mediaSourceHolders.size());
            resetMaskingPosition();
        } else {
            maskWithCurrentPosition();
        }
        Timeline timeline = this.playbackInfo.timeline;
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        long j = this.playbackInfo.requestedContentPositionUs;
        long j2 = this.playbackInfo.positionUs;
        if (z) {
            timeline = Timeline.EMPTY;
            mediaPeriodId = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            j = -9223372036854775807L;
            j2 = 0;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j3 = j2;
        return new PlaybackInfo(timeline, mediaPeriodId2, j, i, z2 ? null : this.playbackInfo.playbackError, false, z ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, mediaPeriodId2, this.playbackInfo.playWhenReady, this.playbackInfo.playbackSuppressionReason, j3, 0, j3);
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, boolean z, int i, int i2, int i3, boolean z2) {
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        PlaybackInfo playbackInfo4 = playbackInfo2;
        this.playbackInfo = playbackInfo4;
        notifyListeners(new PlaybackInfoUpdate(playbackInfo4, playbackInfo3, this.listeners, this.trackSelector, z, i, i2, i3, z2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    private void setMediaSourcesInternal(List<MediaSource> list, int i, long j, boolean z) {
        int i2;
        int i3;
        List<MediaSource> list2 = list;
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            if (i6 >= list.size()) {
                break;
            }
            if (list2.get(i6) == null) {
                z2 = false;
            }
            Assertions.checkArgument(z2);
            i6++;
        }
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        long currentPosition = getCurrentPosition();
        this.pendingOperationAcks++;
        if (!this.mediaSourceHolders.isEmpty()) {
            removeMediaSourceHolders(0, this.mediaSourceHolders.size());
        }
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(0, list2);
        PlaybackInfo maskTimeline = maskTimeline();
        Timeline timeline = maskTimeline.timeline;
        if (timeline.isEmpty() || i4 < timeline.getWindowCount()) {
            long j2 = j;
            if (z) {
                i4 = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
                currentPosition = -9223372036854775807L;
            } else if (i4 == -1) {
                i2 = currentWindowIndexInternal;
                if (i2 != -1) {
                    i5 = i2;
                }
                maskWindowIndexAndPositionForSeek(timeline, i5, currentPosition);
                i3 = maskTimeline.playbackState;
                if (!(i2 == -1 || maskTimeline.playbackState == 1)) {
                    i3 = (!timeline.isEmpty() || i2 >= timeline.getWindowCount()) ? 4 : 2;
                }
                PlaybackInfo copyWithPlaybackState = maskTimeline.copyWithPlaybackState(i3);
                this.internalPlayer.setMediaSources(addMediaSourceHolders, i2, C.msToUs(currentPosition), this.shuffleOrder);
                updatePlaybackInfo(copyWithPlaybackState, false, 4, 0, 1, false);
                return;
            } else {
                currentPosition = j2;
            }
            i2 = i4;
            if (i2 != -1) {
            }
            maskWindowIndexAndPositionForSeek(timeline, i5, currentPosition);
            i3 = maskTimeline.playbackState;
            if (!timeline.isEmpty()) {
            }
            PlaybackInfo copyWithPlaybackState2 = maskTimeline.copyWithPlaybackState(i3);
            this.internalPlayer.setMediaSources(addMediaSourceHolders, i2, C.msToUs(currentPosition), this.shuffleOrder);
            updatePlaybackInfo(copyWithPlaybackState2, false, 4, 0, 1, false);
            return;
        }
        throw new IllegalSeekPositionException(timeline, i4, j);
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int i, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i2), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolders.add(i2 + i, mediaSourceHolder);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    private void removeMediaItemsInternal(int i, int i2) {
        boolean z = false;
        Assertions.checkArgument(i >= 0 && i2 >= i && i2 <= this.mediaSourceHolders.size());
        int currentWindowIndex = getCurrentWindowIndex();
        long currentPosition = getCurrentPosition();
        Timeline currentTimeline = getCurrentTimeline();
        int size = this.mediaSourceHolders.size();
        this.pendingOperationAcks++;
        removeMediaSourceHolders(i, i2);
        PlaybackInfo maskTimelineAndWindowIndex = maskTimelineAndWindowIndex(currentWindowIndex, currentPosition, currentTimeline);
        if (maskTimelineAndWindowIndex.playbackState != 1 && maskTimelineAndWindowIndex.playbackState != 4 && i < i2 && i2 == size && currentWindowIndex >= maskTimelineAndWindowIndex.timeline.getWindowCount()) {
            z = true;
        }
        if (z) {
            maskTimelineAndWindowIndex = maskTimelineAndWindowIndex.copyWithPlaybackState(4);
        }
        this.internalPlayer.removeMediaSources(i, i2, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndWindowIndex, false, 4, 0, 1, false);
    }

    private List<MediaSourceList.MediaSourceHolder> removeMediaSourceHolders(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            arrayList.add(this.mediaSourceHolders.remove(i3));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i, i2);
        return arrayList;
    }

    private PlaybackInfo maskTimeline() {
        return this.playbackInfo.copyWithTimeline(this.mediaSourceHolders.isEmpty() ? Timeline.EMPTY : new MediaSourceList.PlaylistTimeline(this.mediaSourceHolders, this.shuffleOrder));
    }

    private PlaybackInfo maskTimelineAndWindowIndex(int i, long j, Timeline timeline) {
        PlaybackInfo maskTimeline = maskTimeline();
        Timeline timeline2 = maskTimeline.timeline;
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i;
            if (!timeline2.isEmpty() && i >= timeline2.getWindowCount()) {
                maskWithDefaultPosition(timeline2);
            }
            return maskTimeline;
        }
        Object obj = ((Pair) Util.castNonNull(timeline.getPeriodPosition(this.window, this.period, i, C.msToUs(j), 0))).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            this.maskingWindowIndex = timeline2.getPeriodByUid(obj, this.period).windowIndex;
            this.maskingPeriodIndex = timeline2.getIndexOfPeriod(obj);
            this.maskingWindowPositionMs = j;
        } else {
            Object resolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, timeline2);
            if (resolveSubsequentPeriod != null) {
                this.maskingWindowIndex = timeline2.getPeriodByUid(resolveSubsequentPeriod, this.period).windowIndex;
                this.maskingPeriodIndex = timeline2.getWindow(this.maskingWindowIndex, this.window).firstPeriodIndex;
                this.maskingWindowPositionMs = this.window.getDefaultPositionMs();
            } else {
                maskWithDefaultPosition(timeline2);
            }
        }
        return maskTimeline;
    }

    private void maskWindowIndexAndPositionForSeek(Timeline timeline, int i, long j) {
        long j2;
        this.maskingWindowIndex = i;
        if (timeline.isEmpty()) {
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.maskingWindowPositionMs = j;
            this.maskingPeriodIndex = 0;
        } else if (i >= timeline.getWindowCount()) {
            maskWithDefaultPosition(timeline);
        } else {
            if (j == -9223372036854775807L) {
                j2 = timeline.getWindow(i, this.window).getDefaultPositionUs();
            } else {
                j2 = C.msToUs(j);
            }
            Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i, j2);
            this.maskingWindowPositionMs = C.usToMs(j2);
            this.maskingPeriodIndex = timeline.getIndexOfPeriod(periodPosition.first);
        }
    }

    private void maskWithCurrentPosition() {
        this.maskingWindowIndex = getCurrentWindowIndexInternal();
        this.maskingPeriodIndex = getCurrentPeriodIndex();
        this.maskingWindowPositionMs = getCurrentPosition();
    }

    private void maskWithDefaultPosition(Timeline timeline) {
        if (timeline.isEmpty()) {
            resetMaskingPosition();
            return;
        }
        this.maskingWindowIndex = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
        timeline.getWindow(this.maskingWindowIndex, this.window);
        this.maskingWindowPositionMs = this.window.getDefaultPositionMs();
        this.maskingPeriodIndex = this.window.firstPeriodIndex;
    }

    private void resetMaskingPosition() {
        this.maskingWindowIndex = -1;
        this.maskingWindowPositionMs = 0;
        this.maskingPeriodIndex = 0;
    }

    private void notifyListeners(BasePlayer.ListenerInvocation listenerInvocation) {
        notifyListeners(new Runnable(new CopyOnWriteArrayList(this.listeners), listenerInvocation) {
            /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$ATdipVpBpAusek2sNtsQ8UxATBU */
            private final /* synthetic */ CopyOnWriteArrayList f$0;
            private final /* synthetic */ BasePlayer.ListenerInvocation f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                ExoPlayerImpl.invokeAll(this.f$0, this.f$1);
            }
        });
    }

    private void notifyListeners(Runnable runnable) {
        boolean z = !this.pendingListenerNotifications.isEmpty();
        this.pendingListenerNotifications.addLast(runnable);
        if (!z) {
            while (!this.pendingListenerNotifications.isEmpty()) {
                this.pendingListenerNotifications.peekFirst().run();
                this.pendingListenerNotifications.removeFirst();
            }
        }
    }

    private long periodPositionUsToWindowPositionMs(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        long usToMs = C.usToMs(j);
        this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return usToMs + this.period.getPositionInWindowMs();
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    static final class PlaybackInfoUpdate implements Runnable {
        private final boolean isLoadingChanged;
        private final boolean isPlayingChanged;
        private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listenerSnapshot;
        private final int playWhenReadyChangeReason;
        private final boolean playWhenReadyChanged;
        private final boolean playbackErrorChanged;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateChanged;
        private final boolean playbackSuppressionReasonChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, CopyOnWriteArrayList<BasePlayer.ListenerHolder> copyOnWriteArrayList, TrackSelector trackSelector2, boolean z, int i, int i2, int i3, boolean z2) {
            this.playbackInfo = playbackInfo2;
            this.listenerSnapshot = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.trackSelector = trackSelector2;
            this.positionDiscontinuity = z;
            this.positionDiscontinuityReason = i;
            this.timelineChangeReason = i2;
            this.playWhenReadyChangeReason = i3;
            this.seekProcessed = z2;
            boolean z3 = false;
            this.playbackStateChanged = playbackInfo3.playbackState != playbackInfo2.playbackState;
            this.playbackErrorChanged = (playbackInfo3.playbackError == playbackInfo2.playbackError || playbackInfo2.playbackError == null) ? false : true;
            this.isLoadingChanged = playbackInfo3.isLoading != playbackInfo2.isLoading;
            this.timelineChanged = !playbackInfo3.timeline.equals(playbackInfo2.timeline);
            this.trackSelectorResultChanged = playbackInfo3.trackSelectorResult != playbackInfo2.trackSelectorResult;
            this.playWhenReadyChanged = playbackInfo3.playWhenReady != playbackInfo2.playWhenReady;
            this.playbackSuppressionReasonChanged = playbackInfo3.playbackSuppressionReason != playbackInfo2.playbackSuppressionReason;
            this.isPlayingChanged = isPlaying(playbackInfo3) != isPlaying(playbackInfo2) ? true : z3;
        }

        public final void run() {
            if (this.timelineChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$N_S5kRfhaRTAkH28P5luFgKnFjQ */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$0$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.positionDiscontinuity) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$I4Az_3J_Hj7UmXAv1bmtpSgxhQ */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$1$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playbackErrorChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$fI_Ao37C4zouOtNaX7xHdRfgmVc */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$2$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$fF_DLlYcEfUJHZvcXb6sZ7mPW4 */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$3$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.isLoadingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$sJrY7lA_vUJy5MdfVndTSxVTXI */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$4$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged || this.playWhenReadyChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$AYkTJomZb3BnUDA59u8cvRVoKcM */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$5$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$VZrIdBAnOuxHnRgrWdRw5XmApf8 */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$6$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playWhenReadyChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$tUn7tXLH0gigHS24TehPEnTXTJ0 */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$7$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playbackSuppressionReasonChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$s9KCl5H9b3lSkGidzs6Cl2QvWQo */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$8$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.isPlayingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() {
                    /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$ii_2faqKL2WMzOCrBBJmZAu6gs */

                    public final void invokeListener(Player.EventListener eventListener) {
                        ExoPlayerImpl.PlaybackInfoUpdate.this.lambda$run$9$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.seekProcessed) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, $$Lambda$5UFexKQkRNqmel8DaRJEnD1bDjg.INSTANCE);
            }
        }

        public /* synthetic */ void lambda$run$0$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onTimelineChanged(this.playbackInfo.timeline, this.timelineChangeReason);
        }

        public /* synthetic */ void lambda$run$1$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPositionDiscontinuity(this.positionDiscontinuityReason);
        }

        public /* synthetic */ void lambda$run$2$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlayerError(this.playbackInfo.playbackError);
        }

        public /* synthetic */ void lambda$run$3$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onTracksChanged(this.playbackInfo.trackGroups, this.playbackInfo.trackSelectorResult.selections);
        }

        public /* synthetic */ void lambda$run$4$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onIsLoadingChanged(this.playbackInfo.isLoading);
        }

        public /* synthetic */ void lambda$run$5$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlayerStateChanged(this.playbackInfo.playWhenReady, this.playbackInfo.playbackState);
        }

        public /* synthetic */ void lambda$run$6$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlaybackStateChanged(this.playbackInfo.playbackState);
        }

        public /* synthetic */ void lambda$run$7$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlayWhenReadyChanged(this.playbackInfo.playWhenReady, this.playWhenReadyChangeReason);
        }

        public /* synthetic */ void lambda$run$8$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlaybackSuppressionReasonChanged(this.playbackInfo.playbackSuppressionReason);
        }

        public /* synthetic */ void lambda$run$9$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onIsPlayingChanged(isPlaying(this.playbackInfo));
        }

        private static boolean isPlaying(PlaybackInfo playbackInfo2) {
            return playbackInfo2.playbackState == 3 && playbackInfo2.playWhenReady && playbackInfo2.playbackSuppressionReason == 0;
        }
    }

    public static void invokeAll(CopyOnWriteArrayList<BasePlayer.ListenerHolder> copyOnWriteArrayList, BasePlayer.ListenerInvocation listenerInvocation) {
        Iterator<BasePlayer.ListenerHolder> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().invoke(listenerInvocation);
        }
    }
}
