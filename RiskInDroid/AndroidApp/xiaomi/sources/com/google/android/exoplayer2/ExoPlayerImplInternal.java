package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

final class ExoPlayerImplInternal implements Handler.Callback, DefaultMediaClock.PlaybackSpeedListener, MediaSourceList.MediaSourceListInfoRefreshListener, PlayerMessage.Sender, MediaPeriod.Callback, TrackSelector.InvalidationListener {
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private final Handler eventHandler;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndex;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final MediaPeriodQueue queue = new MediaPeriodQueue();
    private boolean rebuffering;
    private long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private boolean throwWhenStuckBuffering;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector2, TrackSelectorResult trackSelectorResult, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, int i, boolean z, AnalyticsCollector analyticsCollector, Handler handler2, Clock clock2) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector2;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl2;
        this.bandwidthMeter = bandwidthMeter2;
        this.repeatMode = i;
        this.shuffleModeEnabled = z;
        this.eventHandler = handler2;
        this.clock = clock2;
        this.backBufferDurationUs = loadControl2.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl2.retainBackBufferFromKeyframe();
        this.seekParameters = SeekParameters.DEFAULT;
        this.playbackInfo = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock2);
        this.pendingMessages = new ArrayList<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector2.init(this, bandwidthMeter2);
        this.internalPlaybackThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.internalPlaybackThread.start();
        this.handler = clock2.createHandler(this.internalPlaybackThread.getLooper(), this);
        this.deliverPendingMessageAtStartPositionRequired = true;
        this.mediaSourceList = new MediaSourceList(this);
        if (analyticsCollector != null) {
            this.mediaSourceList.setAnalyticsCollector(handler2, analyticsCollector);
        }
    }

    public final void experimental_setReleaseTimeoutMs(long j) {
        this.releaseTimeoutMs = j;
    }

    public final void experimental_throwWhenStuckBuffering() {
        this.throwWhenStuckBuffering = true;
    }

    public final void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public final void setPlayWhenReady(boolean z, int i) {
        this.handler.obtainMessage(1, z ? 1 : 0, i).sendToTarget();
    }

    public final void setPauseAtEndOfWindow(boolean z) {
        this.handler.obtainMessage(23, z ? 1 : 0, 0).sendToTarget();
    }

    public final void setRepeatMode(int i) {
        this.handler.obtainMessage(11, i, 0).sendToTarget();
    }

    public final void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(12, z ? 1 : 0, 0).sendToTarget();
    }

    public final void seekTo(Timeline timeline, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    public final void setPlaybackSpeed(float f) {
        this.handler.obtainMessage(4, Float.valueOf(f)).sendToTarget();
    }

    public final void setSeekParameters(SeekParameters seekParameters2) {
        this.handler.obtainMessage(5, seekParameters2).sendToTarget();
    }

    public final void stop(boolean z) {
        this.handler.obtainMessage(6, z ? 1 : 0, 0).sendToTarget();
    }

    public final void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i, long j, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i, j)).sendToTarget();
    }

    public final void addMediaSources(int i, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L)).sendToTarget();
    }

    public final void removeMediaSources(int i, int i2, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i, i2, shuffleOrder).sendToTarget();
    }

    public final void moveMediaSources(int i, int i2, int i3, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i, i2, i3, shuffleOrder)).sendToTarget();
    }

    public final void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public final synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released) {
            if (this.internalPlaybackThread.isAlive()) {
                this.handler.obtainMessage(14, playerMessage).sendToTarget();
                return;
            }
        }
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        return;
     */
    public final synchronized void setForegroundMode(boolean z) {
        if (!this.released) {
            if (this.internalPlaybackThread.isAlive()) {
                boolean z2 = false;
                if (z) {
                    this.handler.obtainMessage(13, 1, 0).sendToTarget();
                    return;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                this.handler.obtainMessage(13, 0, 0, atomicBoolean).sendToTarget();
                while (!atomicBoolean.get()) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
    public final synchronized boolean release() {
        if (!this.released) {
            if (this.internalPlaybackThread.isAlive()) {
                this.handler.sendEmptyMessage(7);
                if (this.releaseTimeoutMs > 0) {
                    waitUntilReleased(this.releaseTimeoutMs);
                } else {
                    waitUntilReleased();
                }
                return this.released;
            }
        }
        return true;
    }

    public final Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    public final void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    public final void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public final void onPlaybackSpeedChanged(float f) {
        sendPlaybackSpeedChangedInternal(f, false);
    }

    public final boolean handleMessage(Message message) {
        ExoPlaybackException exoPlaybackException;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackSpeedInternal(((Float) message.obj).floatValue());
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, message.arg1 != 0, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackSpeed(((Float) message.obj).floatValue(), message.arg1 != 0);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Playback error", e);
            stopInternal(true, false, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            maybeNotifyPlaybackInfoChanged();
        } catch (IOException e2) {
            ExoPlaybackException createForSource = ExoPlaybackException.createForSource(e2);
            Log.e("ExoPlayerImplInternal", "Playback error", createForSource);
            stopInternal(false, false, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForSource);
            maybeNotifyPlaybackInfoChanged();
        } catch (OutOfMemoryError | RuntimeException e3) {
            if (e3 instanceof OutOfMemoryError) {
                exoPlaybackException = ExoPlaybackException.createForOutOfMemoryError((OutOfMemoryError) e3);
            } else {
                exoPlaybackException = ExoPlaybackException.createForUnexpected((RuntimeException) e3);
            }
            Log.e("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
            stopInternal(true, false, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException);
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    private synchronized void waitUntilReleased() throws InterruptedException {
        InterruptedException e = null;
        while (!this.released) {
            try {
                wait();
            } catch (InterruptedException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private synchronized void waitUntilReleased(long j) throws InterruptedException {
        long elapsedRealtime = this.clock.elapsedRealtime() + j;
        InterruptedException interruptedException = null;
        while (!this.released && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException e) {
                interruptedException = e;
            }
            j = elapsedRealtime - this.clock.elapsedRealtime();
        }
        if (interruptedException != null) {
            throw interruptedException;
        }
    }

    private void setState(int i) {
        if (this.playbackInfo.playbackState != i) {
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(i);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.eventHandler.obtainMessage(0, this.playbackInfoUpdate).sendToTarget();
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new MediaSourceList.PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder));
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList2 = this.mediaSourceList;
        if (i == -1) {
            i = mediaSourceList2.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList2.addMediaSources(i, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder));
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder));
    }

    private void removeMediaItemsInternal(int i, int i2, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i, i2, shuffleOrder));
    }

    private void mediaSourceListUpdateRequestedInternal() throws ExoPlaybackException {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline());
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder));
    }

    private void setPlayWhenReadyInternal(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z2 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i2);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z, i);
        this.rebuffering = false;
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.playbackInfo.playbackState == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean z) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z;
        if (this.queue.getReadingPeriod() != this.queue.getPlayingPeriod()) {
            seekToCurrentPosition(true);
        }
        resetPendingPauseAtEndOfPeriod();
        handleLoadingMediaPeriodChanged(false);
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, seekToPeriodPosition, this.playbackInfo.requestedContentPositionUs);
            if (z) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            long readDiscontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
            if (readDiscontinuity != -9223372036854775807L) {
                resetRendererPosition(readDiscontinuity);
                if (readDiscontinuity != this.playbackInfo.positionUs) {
                    this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, readDiscontinuity, this.playbackInfo.requestedContentPositionUs);
                    this.playbackInfoUpdate.setPositionDiscontinuity(4);
                }
            } else {
                this.rendererPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
                long periodTime = playingPeriod.toPeriodTime(this.rendererPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
            this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0136 A[LOOP:1: B:86:0x0136->B:93:0x0158, LOOP_START, PHI: r12 10  PHI: (r12v1 int) = (r12v0 int), (r12v2 int) binds: [B:85:0x0134, B:93:0x0158] A[DONT_GENERATE, DONT_INLINE]] */
    private void doSomeWork() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        int i;
        long uptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        if (this.playbackInfo.playbackState == 1 || this.playbackInfo.playbackState == 4) {
            this.handler.removeMessages(2);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(uptimeMillis, 10);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        int i2 = 0;
        if (playingPeriod.prepared) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            int i3 = 0;
            z2 = true;
            z = true;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i3 >= rendererArr.length) {
                    break;
                }
                Renderer renderer = rendererArr[i3];
                if (isRendererEnabled(renderer)) {
                    renderer.render(this.rendererPositionUs, elapsedRealtime);
                    z2 = z2 && renderer.isEnded();
                    boolean z3 = playingPeriod.sampleStreams[i3] != renderer.getStream();
                    boolean z4 = z3 || (!z3 && playingPeriod.getNext() != null && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    boolean z5 = z && z4;
                    if (!z4) {
                        renderer.maybeThrowStreamError();
                    }
                    z = z5;
                }
                i3++;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z2 = true;
            z = true;
        }
        long j = playingPeriod.info.durationUs;
        boolean z6 = z2 && playingPeriod.prepared && (j == -9223372036854775807L || j <= this.playbackInfo.positionUs);
        if (z6 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (z6 && playingPeriod.info.isFinal) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z)) {
            setState(3);
            if (shouldPlayWhenReady()) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z : !isTimelineReady())) {
            this.rebuffering = shouldPlayWhenReady();
            i = 2;
            setState(2);
            stopRenderers();
            if (this.playbackInfo.playbackState == i) {
                while (true) {
                    Renderer[] rendererArr2 = this.renderers;
                    if (i2 >= rendererArr2.length) {
                        break;
                    }
                    if (isRendererEnabled(rendererArr2[i2]) && this.renderers[i2].getStream() == playingPeriod.sampleStreams[i2]) {
                        this.renderers[i2].maybeThrowStreamError();
                    }
                    i2++;
                }
                if (this.throwWhenStuckBuffering && !this.shouldContinueLoading && this.playbackInfo.totalBufferedDurationUs < 500000 && isLoadingPossible()) {
                    throw new IllegalStateException("Playback stuck buffering and not loading");
                }
            }
            if ((!shouldPlayWhenReady() && this.playbackInfo.playbackState == 3) || this.playbackInfo.playbackState == 2) {
                scheduleNextWork(uptimeMillis, 10);
            } else if (this.enabledRendererCount != 0 || this.playbackInfo.playbackState == 4) {
                this.handler.removeMessages(2);
            } else {
                scheduleNextWork(uptimeMillis, 1000);
            }
            TraceUtil.endSection();
        }
        i = 2;
        if (this.playbackInfo.playbackState == i) {
        }
        if (!shouldPlayWhenReady()) {
        }
        if (this.enabledRendererCount != 0) {
        }
        this.handler.removeMessages(2);
        TraceUtil.endSection();
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9 A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    private void seekToInternal(SeekPosition seekPosition) throws ExoPlaybackException {
        long j;
        boolean z;
        MediaSource.MediaPeriodId mediaPeriodId;
        long j2;
        long j3;
        long j4;
        long j5;
        SeekPosition seekPosition2 = seekPosition;
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair<Object, Long> resolveSeekPosition = resolveSeekPosition(this.playbackInfo.timeline, seekPosition, true, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        boolean z2 = false;
        if (resolveSeekPosition == null) {
            Pair<MediaSource.MediaPeriodId, Long> dummyFirstMediaPeriodPosition = getDummyFirstMediaPeriodPosition(this.playbackInfo.timeline);
            mediaPeriodId = (MediaSource.MediaPeriodId) dummyFirstMediaPeriodPosition.first;
            j5 = ((Long) dummyFirstMediaPeriodPosition.second).longValue();
            z = !this.playbackInfo.timeline.isEmpty();
            j = -9223372036854775807L;
        } else {
            Object obj = resolveSeekPosition.first;
            long longValue = ((Long) resolveSeekPosition.second).longValue();
            j = seekPosition2.windowPositionUs == -9223372036854775807L ? -9223372036854775807L : longValue;
            MediaSource.MediaPeriodId resolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(this.playbackInfo.timeline, obj, longValue);
            if (resolveMediaPeriodIdForAds.isAd()) {
                this.playbackInfo.timeline.getPeriodByUid(resolveMediaPeriodIdForAds.periodUid, this.period);
                j2 = this.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAds.adGroupIndex) == resolveMediaPeriodIdForAds.adIndexInAdGroup ? this.period.getAdResumePositionUs() : 0;
                mediaPeriodId = resolveMediaPeriodIdForAds;
                z = true;
                if (!this.playbackInfo.timeline.isEmpty()) {
                    this.pendingInitialSeekPosition = seekPosition2;
                } else if (resolveSeekPosition == null) {
                    if (this.playbackInfo.playbackState != 1) {
                        setState(4);
                    }
                    resetInternal(false, true, false, false, true);
                } else {
                    if (mediaPeriodId.equals(this.playbackInfo.periodId)) {
                        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                        long adjustedSeekPositionUs = (playingPeriod == null || !playingPeriod.prepared || j2 == 0) ? j2 : playingPeriod.mediaPeriod.getAdjustedSeekPositionUs(j2, this.seekParameters);
                        long j6 = adjustedSeekPositionUs;
                        if (C.usToMs(adjustedSeekPositionUs) == C.usToMs(this.playbackInfo.positionUs) && (this.playbackInfo.playbackState == 2 || this.playbackInfo.playbackState == 3)) {
                            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, this.playbackInfo.positionUs, j);
                            if (z) {
                                this.playbackInfoUpdate.setPositionDiscontinuity(2);
                                return;
                            }
                            return;
                        }
                        j4 = j6;
                    } else {
                        j4 = j2;
                    }
                    long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, j4, this.playbackInfo.playbackState == 4);
                    if (j2 != seekToPeriodPosition) {
                        z2 = true;
                    }
                    z |= z2;
                    j3 = seekToPeriodPosition;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j);
                    if (z) {
                        this.playbackInfoUpdate.setPositionDiscontinuity(2);
                        return;
                    }
                    return;
                }
                j3 = j2;
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j);
                if (z) {
                }
            } else {
                j5 = longValue;
                mediaPeriodId = resolveMediaPeriodIdForAds;
                z = seekPosition2.windowPositionUs == -9223372036854775807L;
            }
        }
        j2 = j5;
        try {
            if (!this.playbackInfo.timeline.isEmpty()) {
            }
            j3 = j2;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j);
            if (z) {
            }
        } catch (Throwable th) {
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j2, j);
            if (z) {
                this.playbackInfoUpdate.setPositionDiscontinuity(2);
            }
            throw th;
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        if (z2 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.info.id)) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
        }
        if (z || playingPeriod != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.toRendererTime(j) < 0)) {
            for (Renderer disableRenderer : this.renderers) {
                disableRenderer(disableRenderer);
            }
            if (mediaPeriodHolder != null) {
                while (this.queue.getPlayingPeriod() != mediaPeriodHolder) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.setRendererOffset(0);
                enableRenderers();
            }
        }
        if (mediaPeriodHolder != null) {
            this.queue.removeAfter(mediaPeriodHolder);
            if (!mediaPeriodHolder.prepared) {
                mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithStartPositionUs(j);
            } else {
                if (mediaPeriodHolder.info.durationUs != -9223372036854775807L && j >= mediaPeriodHolder.info.durationUs) {
                    j = Math.max(0L, mediaPeriodHolder.info.durationUs - 1);
                }
                if (mediaPeriodHolder.hasEnabledTracks) {
                    long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j);
                    mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                    j = seekToUs;
                }
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            j = playingPeriod.toRendererTime(j);
        }
        this.rendererPositionUs = j;
        this.mediaClock.resetPosition(this.rendererPositionUs);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void setPlaybackSpeedInternal(float f) {
        this.mediaClock.setPlaybackSpeed(f);
        sendPlaybackSpeedChangedInternal(this.mediaClock.getPlaybackSpeed(), true);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters2) {
        this.seekParameters = seekParameters2;
    }

    private void setForegroundModeInternal(boolean z, AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2, boolean z3) {
        resetInternal(z || !this.foregroundMode, z2, true, z2, z2);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z3 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true, true, true, true, false);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b8, code lost:
        if (r5.equals(r1.playbackInfo.periodId) == false) goto L_0x00bd;
     */
    private void resetInternal(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Timeline timeline;
        boolean z6;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0;
        for (Renderer disableRenderer : this.renderers) {
            try {
                disableRenderer(disableRenderer);
            } catch (ExoPlaybackException | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        if (z) {
            for (Renderer reset : this.renderers) {
                try {
                    reset.reset();
                } catch (RuntimeException e2) {
                    Log.e("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.enabledRendererCount = 0;
        Timeline timeline2 = this.playbackInfo.timeline;
        ExoPlaybackException exoPlaybackException = null;
        boolean z7 = true;
        if (z4) {
            Timeline clear = this.mediaSourceList.clear(null);
            Iterator<PendingMessageInfo> it = this.pendingMessages.iterator();
            while (it.hasNext()) {
                it.next().message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
            this.nextPendingMessageIndex = 0;
            timeline = clear;
            z6 = true;
        } else {
            timeline = timeline2;
            z6 = z2;
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        long j = this.playbackInfo.positionUs;
        long j2 = shouldUseRequestedContentPosition(this.playbackInfo, this.period, this.window) ? this.playbackInfo.requestedContentPositionUs : this.playbackInfo.positionUs;
        if (z6) {
            this.pendingInitialSeekPosition = null;
            Pair<MediaSource.MediaPeriodId, Long> dummyFirstMediaPeriodPosition = getDummyFirstMediaPeriodPosition(timeline);
            mediaPeriodId = (MediaSource.MediaPeriodId) dummyFirstMediaPeriodPosition.first;
            j = ((Long) dummyFirstMediaPeriodPosition.second).longValue();
            j2 = -9223372036854775807L;
        }
        z7 = z4;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j3 = j;
        long j4 = j2;
        this.queue.clear();
        this.shouldContinueLoading = false;
        int i = this.playbackInfo.playbackState;
        if (!z5) {
            exoPlaybackException = this.playbackInfo.playbackError;
        }
        this.playbackInfo = new PlaybackInfo(timeline, mediaPeriodId2, j4, i, exoPlaybackException, false, z7 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z7 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, mediaPeriodId2, this.playbackInfo.playWhenReady, this.playbackInfo.playbackSuppressionReason, j3, 0, j3);
        if (z3) {
            this.mediaSourceList.release();
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getDummyFirstMediaPeriodPosition(Timeline timeline) {
        long j = 0;
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Timeline timeline2 = timeline;
        Pair<Object, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(timeline, periodPosition.first, 0);
        long longValue = ((Long) periodPosition.second).longValue();
        if (resolveMediaPeriodIdForAds.isAd()) {
            timeline.getPeriodByUid(resolveMediaPeriodIdForAds.periodUid, this.period);
            if (resolveMediaPeriodIdForAds.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAds.adGroupIndex)) {
                j = this.period.getAdResumePositionUs();
            }
            longValue = j;
        }
        return Pair.create(resolveMediaPeriodIdForAds, Long.valueOf(longValue));
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
        } else if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            if (resolvePendingMessagePosition(pendingMessageInfo, this.playbackInfo.timeline, this.playbackInfo.timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() == this.handler.getLooper()) {
            deliverMessage(playerMessage);
            if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage) {
        Handler handler2 = playerMessage.getHandler();
        if (!handler2.getLooper().getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
            return;
        }
        handler2.post(new Runnable(playerMessage) {
            /* class com.google.android.exoplayer2.$$Lambda$ExoPlayerImplInternal$XwFxncwlyfAWA4k618O8BNtCsr0 */
            private final /* synthetic */ PlayerMessage f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ExoPlayerImplInternal.this.lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.isCanceled()) {
            try {
                playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
            } finally {
                playerMessage.markAsProcessed(true);
            }
        }
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (!timeline.isEmpty() || !timeline2.isEmpty()) {
            for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
                if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                    this.pendingMessages.get(size).message.markAsProcessed(false);
                    this.pendingMessages.remove(size);
                }
            }
            Collections.sort(this.pendingMessages);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00a7 A[ADDED_TO_REGION, EDGE_INSN: B:72:0x00a7->B:85:0x00a7 ?: BREAK  , SYNTHETIC] */
    private void maybeTriggerPendingMessages(long j, long j2) throws ExoPlaybackException {
        PendingMessageInfo pendingMessageInfo;
        PendingMessageInfo pendingMessageInfo2;
        boolean deleteAfterDelivery;
        PendingMessageInfo pendingMessageInfo3;
        boolean isCanceled;
        if (!this.pendingMessages.isEmpty() && !this.playbackInfo.periodId.isAd()) {
            if (this.deliverPendingMessageAtStartPositionRequired) {
                j--;
                this.deliverPendingMessageAtStartPositionRequired = false;
            }
            int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
            int i = this.nextPendingMessageIndex;
            if (i > 0) {
                pendingMessageInfo = this.pendingMessages.get(i - 1);
                while (true) {
                    if (pendingMessageInfo != null && (pendingMessageInfo.resolvedPeriodIndex > indexOfPeriod || (pendingMessageInfo.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo.resolvedPeriodTimeUs > j))) {
                        this.nextPendingMessageIndex--;
                        int i2 = this.nextPendingMessageIndex;
                        if (i2 <= 0) {
                            break;
                        }
                        pendingMessageInfo = this.pendingMessages.get(i2 - 1);
                        pendingMessageInfo = this.pendingMessages.get(i2 - 1);
                    }
                }
                if (this.nextPendingMessageIndex < this.pendingMessages.size()) {
                    pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                    while (true) {
                        if (pendingMessageInfo2 == null && pendingMessageInfo2.resolvedPeriodUid != null && (pendingMessageInfo2.resolvedPeriodIndex < indexOfPeriod || (pendingMessageInfo2.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo2.resolvedPeriodTimeUs <= j))) {
                            this.nextPendingMessageIndex++;
                            if (this.nextPendingMessageIndex >= this.pendingMessages.size()) {
                                break;
                            }
                            pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                            pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                        }
                    }
                    while (pendingMessageInfo2 != null && pendingMessageInfo2.resolvedPeriodUid != null && pendingMessageInfo2.resolvedPeriodIndex == indexOfPeriod && pendingMessageInfo2.resolvedPeriodTimeUs > j && pendingMessageInfo2.resolvedPeriodTimeUs <= j2) {
                        try {
                            sendMessageToTarget(pendingMessageInfo2.message);
                            if (!deleteAfterDelivery || isCanceled) {
                                this.pendingMessages.remove(this.nextPendingMessageIndex);
                            }
                            if (this.nextPendingMessageIndex >= this.pendingMessages.size()) {
                                pendingMessageInfo3 = this.pendingMessages.get(this.nextPendingMessageIndex);
                            } else {
                                pendingMessageInfo3 = null;
                            }
                        } finally {
                            if (pendingMessageInfo2.message.getDeleteAfterDelivery() || pendingMessageInfo2.message.isCanceled()) {
                                this.pendingMessages.remove(this.nextPendingMessageIndex);
                            } else {
                                this.nextPendingMessageIndex++;
                            }
                        }
                    }
                    return;
                }
                pendingMessageInfo2 = null;
                while (true) {
                    if (pendingMessageInfo2 == null) {
                        break;
                    }
                    break;
                    pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
                }
                while (pendingMessageInfo2 != null) {
                    sendMessageToTarget(pendingMessageInfo2.message);
                    this.pendingMessages.remove(this.nextPendingMessageIndex);
                    if (this.nextPendingMessageIndex >= this.pendingMessages.size()) {
                    }
                }
            }
            pendingMessageInfo = null;
            while (true) {
                if (pendingMessageInfo != null) {
                    break;
                }
                break;
                pendingMessageInfo = this.pendingMessages.get(i2 - 1);
            }
            if (this.nextPendingMessageIndex < this.pendingMessages.size()) {
            }
            pendingMessageInfo2 = null;
            while (true) {
                if (pendingMessageInfo2 == null) {
                }
                pendingMessageInfo2 = this.pendingMessages.get(this.nextPendingMessageIndex);
            }
            while (pendingMessageInfo2 != null) {
            }
        }
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float playbackSpeed = this.mediaClock.getPlaybackSpeed();
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z = true;
        while (playingPeriod != null && playingPeriod.prepared) {
            TrackSelectorResult selectTracks = playingPeriod.selectTracks(playbackSpeed, this.playbackInfo.timeline);
            int i = 0;
            if (selectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (playingPeriod == readingPeriod) {
                    z = false;
                }
                playingPeriod = playingPeriod.getNext();
            } else {
                if (z) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long applyTrackSelection = playingPeriod2.applyTrackSelection(selectTracks, this.playbackInfo.positionUs, removeAfter, zArr);
                    MediaPeriodHolder mediaPeriodHolder = playingPeriod2;
                    this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, applyTrackSelection, this.playbackInfo.requestedContentPositionUs);
                    if (!(this.playbackInfo.playbackState == 4 || applyTrackSelection == this.playbackInfo.positionUs)) {
                        this.playbackInfoUpdate.setPositionDiscontinuity(4);
                        resetRendererPosition(applyTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        zArr2[i] = isRendererEnabled(renderer);
                        SampleStream sampleStream = mediaPeriodHolder.sampleStreams[i];
                        if (zArr2[i]) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i++;
                    }
                    enableRenderers(zArr2);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(selectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (TrackSelection trackSelection : playingPeriod.getTrackSelectorResult().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onPlaybackSpeed(f);
                }
            }
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (TrackSelection trackSelection : playingPeriod.getTrackSelectorResult().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onDiscontinuity();
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if ((loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackSpeed(), this.rebuffering)) {
            return true;
        }
        return false;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j = playingPeriod.info.durationUs;
        if (playingPeriod.prepared) {
            return j == -9223372036854775807L || this.playbackInfo.positionUs < j || !shouldPlayWhenReady();
        }
        return false;
    }

    private void maybeThrowSourceInfoRefreshError() throws IOException {
        if (this.queue.getLoadingPeriod() != null) {
            Renderer[] rendererArr = this.renderers;
            int length = rendererArr.length;
            int i = 0;
            while (i < length) {
                Renderer renderer = rendererArr[i];
                if (!isRendererEnabled(renderer) || renderer.hasReadStreamToEnd()) {
                    i++;
                } else {
                    return;
                }
            }
        }
        this.mediaSourceList.maybeThrowSourceInfoRefreshError();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011a  */
    private void handleMediaSourceListInfoRefreshed(Timeline timeline) throws ExoPlaybackException {
        Timeline timeline2;
        SeekPosition seekPosition;
        Timeline timeline3;
        long j;
        Timeline timeline4;
        Timeline timeline5 = timeline;
        PositionUpdateForPlaylistChange resolvePositionForPlaylistChange = resolvePositionForPlaylistChange(timeline, this.playbackInfo, this.pendingInitialSeekPosition, this.queue, this.repeatMode, this.shuffleModeEnabled, this.window, this.period);
        MediaSource.MediaPeriodId mediaPeriodId = resolvePositionForPlaylistChange.periodId;
        long j2 = resolvePositionForPlaylistChange.requestedContentPositionUs;
        boolean z = resolvePositionForPlaylistChange.forceBufferingState;
        long j3 = resolvePositionForPlaylistChange.periodPositionUs;
        boolean z2 = !this.playbackInfo.periodId.equals(mediaPeriodId) || j3 != this.playbackInfo.positionUs;
        SeekPosition seekPosition2 = null;
        try {
            if (resolvePositionForPlaylistChange.endPlayback) {
                try {
                    if (this.playbackInfo.playbackState != 1) {
                        setState(4);
                    }
                    resetInternal(false, false, false, false, true);
                } catch (Throwable th) {
                    th = th;
                    timeline2 = timeline;
                    seekPosition2 = null;
                    if (!z2) {
                    }
                    seekPosition = seekPosition2;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j2);
                    resetPendingPauseAtEndOfPeriod();
                    resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                    this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                    if (!timeline.isEmpty()) {
                    }
                    handleLoadingMediaPeriodChanged(false);
                    throw th;
                }
            }
            if (!z2) {
                if (!this.queue.updateQueuedPeriods(timeline, this.rendererPositionUs, getMaxRendererReadPositionUs())) {
                    seekToCurrentPosition(false);
                }
            } else if (!timeline.isEmpty()) {
                for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
                    if (playingPeriod.info.id.equals(mediaPeriodId)) {
                        Timeline timeline6 = timeline;
                        try {
                            playingPeriod.info = this.queue.getUpdatedMediaPeriodInfo(timeline6, playingPeriod.info);
                        } catch (Throwable th2) {
                            th = th2;
                            timeline2 = timeline6;
                            seekPosition2 = null;
                            if (!z2 || j2 != this.playbackInfo.requestedContentPositionUs) {
                                seekPosition = seekPosition2;
                                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j2);
                            } else {
                                seekPosition = seekPosition2;
                            }
                            resetPendingPauseAtEndOfPeriod();
                            resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
                            this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
                            if (!timeline.isEmpty()) {
                                this.pendingInitialSeekPosition = seekPosition;
                            }
                            handleLoadingMediaPeriodChanged(false);
                            throw th;
                        }
                    } else {
                        Timeline timeline7 = timeline;
                    }
                }
                timeline3 = timeline;
                j = seekToPeriodPosition(mediaPeriodId, j3, z);
                if (!z2 || j2 != this.playbackInfo.requestedContentPositionUs) {
                    timeline4 = timeline3;
                    this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j, j2);
                } else {
                    timeline4 = timeline3;
                }
                resetPendingPauseAtEndOfPeriod();
                resolvePendingMessagePositions(timeline4, this.playbackInfo.timeline);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline4);
                if (!timeline.isEmpty()) {
                    this.pendingInitialSeekPosition = null;
                }
                handleLoadingMediaPeriodChanged(false);
            }
            timeline3 = timeline;
            j = j3;
            if (!z2) {
            }
            timeline4 = timeline3;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j, j2);
            resetPendingPauseAtEndOfPeriod();
            resolvePendingMessagePositions(timeline4, this.playbackInfo.timeline);
            this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline4);
            if (!timeline.isEmpty()) {
            }
            handleLoadingMediaPeriodChanged(false);
        } catch (Throwable th3) {
            th = th3;
            timeline2 = timeline5;
            if (!z2) {
            }
            seekPosition = seekPosition2;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j3, j2);
            resetPendingPauseAtEndOfPeriod();
            resolvePendingMessagePositions(timeline2, this.playbackInfo.timeline);
            this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline2);
            if (!timeline.isEmpty()) {
            }
            handleLoadingMediaPeriodChanged(false);
            throw th;
        }
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i]) && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        if (this.playbackInfo.timeline.isEmpty() || !this.mediaSourceList.isPrepared()) {
            this.mediaSourceList.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        maybeUpdateReadingPeriod();
        maybeUpdateReadingRenderers();
        maybeUpdatePlayingPeriod();
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException, IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                maybeThrowSourceInfoRefreshError();
            } else {
                MediaPeriodHolder enqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
                enqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
                if (this.queue.getPlayingPeriod() == enqueueNextMediaPeriodHolder) {
                    resetRendererPosition(enqueueNextMediaPeriodHolder.getStartPositionRendererTime());
                }
                handleLoadingMediaPeriodChanged(false);
            }
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
            return;
        }
        maybeContinueLoading();
    }

    private void maybeUpdateReadingPeriod() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod != null) {
            int i = 0;
            if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
                if (readingPeriod.info.isFinal || this.pendingPauseAtEndOfPeriod) {
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i < rendererArr.length) {
                            Renderer renderer = rendererArr[i];
                            SampleStream sampleStream = readingPeriod.sampleStreams[i];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                                renderer.setCurrentStreamFinal();
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (hasReadingPeriodFinishedReading()) {
                if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                    TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                    MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.getTrackSelectorResult();
                    if (!advanceReadingPeriod.prepared || advanceReadingPeriod.mediaPeriod.readDiscontinuity() == -9223372036854775807L) {
                        for (int i2 = 0; i2 < this.renderers.length; i2++) {
                            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
                            boolean isRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i2);
                            if (isRendererEnabled && !this.renderers[i2].isCurrentStreamFinal()) {
                                boolean z = this.rendererCapabilities[i2].getTrackType() == 6;
                                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                                RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i2];
                                if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                                    this.renderers[i2].setCurrentStreamFinal();
                                }
                            }
                        }
                        return;
                    }
                    setAllRendererStreamsFinal();
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod != null && this.queue.getPlayingPeriod() != readingPeriod && !readingPeriod.allRenderersEnabled && replaceStreamsOrDisableRendererForTransition()) {
            enableRenderers();
        }
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                break;
            }
            Renderer renderer = rendererArr[i];
            if (isRendererEnabled(renderer)) {
                boolean z2 = renderer.getStream() != readingPeriod.sampleStreams[i];
                if (!trackSelectorResult.isRendererEnabled(i) || z2) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections.get(i)), readingPeriod.sampleStreams[i], readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            MediaPeriodHolder advancePlayingPeriod = this.queue.advancePlayingPeriod();
            this.playbackInfo = handlePositionDiscontinuity(advancePlayingPeriod.info.id, advancePlayingPeriod.info.startPositionUs, advancePlayingPeriod.info.requestedContentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity(playingPeriod.info.isLastInTimelinePeriod ? 0 : 3);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z = true;
        }
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        if (shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersEnabled) {
            return true;
        }
        return false;
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i];
            SampleStream sampleStream = readingPeriod.sampleStreams[i];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd())) {
                return false;
            }
            i++;
        }
        return false;
    }

    private void setAllRendererStreamsFinal() {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                renderer.setCurrentStreamFinal();
            }
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackSpeed(), this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                this.playbackInfo = handlePositionDiscontinuity(this.playbackInfo.periodId, loadingPeriod.info.startPositionUs, this.playbackInfo.requestedContentPositionUs);
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackSpeed(float f, boolean z) throws ExoPlaybackException {
        this.eventHandler.obtainMessage(1, z ? 1 : 0, 0, Float.valueOf(f)).sendToTarget();
        updateTrackSelectionPlaybackSpeed(f);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setOperatingRate(f);
            }
        }
    }

    private void maybeContinueLoading() {
        this.shouldContinueLoading = shouldContinueLoading();
        if (this.shouldContinueLoading) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private boolean shouldContinueLoading() {
        long j;
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        if (loadingPeriod == this.queue.getPlayingPeriod()) {
            j = loadingPeriod.toPeriodTime(this.rendererPositionUs);
        } else {
            j = loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        }
        return this.loadControl.shouldContinueLoading(j, totalBufferedDurationUs, this.mediaClock.getPlaybackSpeed());
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        if (z != this.playbackInfo.isLoading) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z);
        }
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        this.deliverPendingMessageAtStartPositionRequired = this.deliverPendingMessageAtStartPositionRequired || j != this.playbackInfo.positionUs || !mediaPeriodId.equals(this.playbackInfo.periodId);
        resetPendingPauseAtEndOfPeriod();
        TrackGroupArray trackGroupArray3 = this.playbackInfo.trackGroups;
        TrackSelectorResult trackSelectorResult3 = this.playbackInfo.trackSelectorResult;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod == null) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray2 = playingPeriod.getTrackGroups();
            }
            if (playingPeriod == null) {
                trackSelectorResult2 = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult2 = playingPeriod.getTrackSelectorResult();
            }
            trackSelectorResult = trackSelectorResult2;
            trackGroupArray = trackGroupArray2;
        } else {
            if (!mediaPeriodId.equals(this.playbackInfo.periodId)) {
                trackGroupArray3 = TrackGroupArray.EMPTY;
                trackSelectorResult3 = this.emptyTrackSelectorResult;
            }
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j, j2, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult);
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length]);
    }

    private void enableRenderers(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i = 0; i < this.renderers.length; i++) {
            if (!trackSelectorResult.isRendererEnabled(i)) {
                this.renderers[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            if (trackSelectorResult.isRendererEnabled(i2)) {
                enableRenderer(i2, zArr[i2]);
            }
        }
        readingPeriod.allRenderersEnabled = true;
    }

    private void enableRenderer(int i, boolean z) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i];
        if (!isRendererEnabled(renderer)) {
            MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z2 = readingPeriod == this.queue.getPlayingPeriod();
            TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
            Format[] formats = getFormats(trackSelectorResult.selections.get(i));
            boolean z3 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
            boolean z4 = !z && z3;
            this.enabledRendererCount++;
            renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i], this.rendererPositionUs, z4, z2, readingPeriod.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer);
            if (z3) {
                renderer.start();
            }
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        long j;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.id;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (loadingPeriod == null) {
            j = playbackInfo2.positionUs;
        } else {
            j = loadingPeriod.getBufferedPositionUs();
        }
        playbackInfo2.bufferedPositionUs = j;
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0;
        }
        return Math.max(0L, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private void sendPlaybackSpeedChangedInternal(float f, boolean z) {
        this.handler.obtainMessage(16, z ? 1 : 0, 0, Float.valueOf(f)).sendToTarget();
    }

    private boolean shouldPlayWhenReady() {
        return this.playbackInfo.playWhenReady && this.playbackInfo.playbackSuppressionReason == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0145  */
    private static PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo2, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i, boolean z, Timeline.Window window2, Timeline.Period period2) {
        long j;
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        long j2;
        MediaPeriodQueue mediaPeriodQueue2;
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAds;
        int i4;
        int firstWindowIndex;
        int i5;
        Timeline timeline2 = timeline;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        SeekPosition seekPosition2 = seekPosition;
        boolean z4 = z;
        Timeline.Period period3 = period2;
        if (timeline.isEmpty()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0, -9223372036854775807L, false, true);
        }
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo3.periodId;
        Object obj = mediaPeriodId.periodUid;
        boolean shouldUseRequestedContentPosition = shouldUseRequestedContentPosition(playbackInfo3, period3, window2);
        if (shouldUseRequestedContentPosition) {
            j = playbackInfo3.requestedContentPositionUs;
        } else {
            j = playbackInfo3.positionUs;
        }
        long j3 = j;
        boolean z5 = true;
        if (seekPosition2 != null) {
            i2 = -1;
            Pair<Object, Long> resolveSeekPosition = resolveSeekPosition(timeline, seekPosition, true, i, z, window2, period2);
            if (resolveSeekPosition == null) {
                firstWindowIndex = timeline2.getFirstWindowIndex(z4);
            } else {
                if (seekPosition2.windowPositionUs == -9223372036854775807L) {
                    i5 = timeline2.getPeriodByUid(resolveSeekPosition.first, period3).windowIndex;
                } else {
                    obj = resolveSeekPosition.first;
                    j3 = ((Long) resolveSeekPosition.second).longValue();
                    i5 = -1;
                }
                i3 = i5;
                z2 = false;
                z3 = playbackInfo3.playbackState == 4;
                if (i3 == i2) {
                    Pair<Object, Long> periodPosition = timeline.getPeriodPosition(window2, period2, i3, -9223372036854775807L);
                    obj = periodPosition.first;
                    long longValue = ((Long) periodPosition.second).longValue();
                    mediaPeriodQueue2 = mediaPeriodQueue;
                    j2 = longValue;
                    j3 = -9223372036854775807L;
                } else {
                    mediaPeriodQueue2 = mediaPeriodQueue;
                    j2 = j3;
                }
                resolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline2, obj, j2);
                if (!mediaPeriodId.periodUid.equals(obj) || mediaPeriodId.isAd() || resolveMediaPeriodIdForAds.isAd()) {
                    z5 = false;
                }
                if (z5) {
                    resolveMediaPeriodIdForAds = mediaPeriodId;
                }
                if (resolveMediaPeriodIdForAds.isAd()) {
                    if (resolveMediaPeriodIdForAds.equals(mediaPeriodId)) {
                        j2 = playbackInfo3.positionUs;
                    } else {
                        timeline2.getPeriodByUid(resolveMediaPeriodIdForAds.periodUid, period3);
                        j2 = resolveMediaPeriodIdForAds.adIndexInAdGroup == period3.getFirstAdIndexToPlay(resolveMediaPeriodIdForAds.adGroupIndex) ? period2.getAdResumePositionUs() : 0;
                    }
                }
                return new PositionUpdateForPlaylistChange(resolveMediaPeriodIdForAds, j2, j3, z3, z2);
            }
        } else {
            i2 = -1;
            if (playbackInfo3.timeline.isEmpty()) {
                i4 = timeline2.getFirstWindowIndex(z4);
            } else if (timeline2.getIndexOfPeriod(obj) == -1) {
                Object resolveSubsequentPeriod = resolveSubsequentPeriod(window2, period2, i, z, obj, playbackInfo3.timeline, timeline);
                if (resolveSubsequentPeriod == null) {
                    firstWindowIndex = timeline2.getFirstWindowIndex(z4);
                } else {
                    i4 = timeline2.getPeriodByUid(resolveSubsequentPeriod, period3).windowIndex;
                }
            } else {
                if (shouldUseRequestedContentPosition) {
                    if (j3 == -9223372036854775807L) {
                        i4 = timeline2.getPeriodByUid(obj, period3).windowIndex;
                    } else {
                        playbackInfo3.timeline.getPeriodByUid(mediaPeriodId.periodUid, period3);
                        Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window2, period2, timeline2.getPeriodByUid(obj, period3).windowIndex, j3 + period2.getPositionInWindowUs());
                        obj = periodPosition2.first;
                        j3 = ((Long) periodPosition2.second).longValue();
                    }
                }
                i3 = -1;
                z3 = false;
                z2 = false;
                if (i3 == i2) {
                }
                resolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline2, obj, j2);
                z5 = false;
                if (z5) {
                }
                if (resolveMediaPeriodIdForAds.isAd()) {
                }
                return new PositionUpdateForPlaylistChange(resolveMediaPeriodIdForAds, j2, j3, z3, z2);
            }
            i3 = i4;
            z3 = false;
            z2 = false;
            if (i3 == i2) {
            }
            resolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline2, obj, j2);
            z5 = false;
            if (z5) {
            }
            if (resolveMediaPeriodIdForAds.isAd()) {
            }
            return new PositionUpdateForPlaylistChange(resolveMediaPeriodIdForAds, j2, j3, z3, z2);
        }
        i3 = firstWindowIndex;
        z3 = false;
        z2 = true;
        if (i3 == i2) {
        }
        resolveMediaPeriodIdForAds = mediaPeriodQueue2.resolveMediaPeriodIdForAds(timeline2, obj, j2);
        z5 = false;
        if (z5) {
        }
        if (resolveMediaPeriodIdForAds.isAd()) {
        }
        return new PositionUpdateForPlaylistChange(resolveMediaPeriodIdForAds, j2, j3, z3, z2);
    }

    private static boolean shouldUseRequestedContentPosition(PlaybackInfo playbackInfo2, Timeline.Period period2, Timeline.Window window2) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
        Timeline timeline = playbackInfo2.timeline;
        return mediaPeriodId.isAd() || timeline.isEmpty() || timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, period2).windowIndex, window2).isPlaceholder;
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i, boolean z, Timeline.Window window2, Timeline.Period period2) {
        long j;
        PendingMessageInfo pendingMessageInfo2 = pendingMessageInfo;
        Timeline timeline3 = timeline;
        Timeline timeline4 = timeline2;
        Timeline.Window window3 = window2;
        Timeline.Period period3 = period2;
        if (pendingMessageInfo2.resolvedPeriodUid == null) {
            if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
                j = -9223372036854775807L;
            } else {
                j = C.msToUs(pendingMessageInfo2.message.getPositionMs());
            }
            Pair<Object, Long> resolveSeekPosition = resolveSeekPosition(timeline, new SeekPosition(pendingMessageInfo2.message.getTimeline(), pendingMessageInfo2.message.getWindowIndex(), j), false, i, z, window2, period2);
            if (resolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline3.getIndexOfPeriod(resolveSeekPosition.first), ((Long) resolveSeekPosition.second).longValue(), resolveSeekPosition.first);
            if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline3, pendingMessageInfo, window3, period3);
            }
            return true;
        }
        int indexOfPeriod = timeline3.getIndexOfPeriod(pendingMessageInfo2.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline3, pendingMessageInfo, window3, period3);
            return true;
        }
        pendingMessageInfo2.resolvedPeriodIndex = indexOfPeriod;
        timeline4.getPeriodByUid(pendingMessageInfo2.resolvedPeriodUid, period3);
        if (timeline4.getWindow(period3.windowIndex, window3).isPlaceholder) {
            long positionInWindowUs = pendingMessageInfo2.resolvedPeriodTimeUs + period2.getPositionInWindowUs();
            Pair<Object, Long> periodPosition = timeline.getPeriodPosition(window2, period2, timeline3.getPeriodByUid(pendingMessageInfo2.resolvedPeriodUid, period3).windowIndex, positionInWindowUs);
            pendingMessageInfo.setResolvedPosition(timeline3.getIndexOfPeriod(periodPosition.first), ((Long) periodPosition.second).longValue(), periodPosition.first);
        }
        return true;
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window2, Timeline.Period period2) {
        int i = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period2).windowIndex, window2).lastPeriodIndex;
        pendingMessageInfo.setResolvedPosition(i, period2.durationUs != -9223372036854775807L ? period2.durationUs - 1 : Long.MAX_VALUE, timeline.getPeriod(i, period2, true).uid);
    }

    private static Pair<Object, Long> resolveSeekPosition(Timeline timeline, SeekPosition seekPosition, boolean z, int i, boolean z2, Timeline.Window window2, Timeline.Period period2) {
        Object resolveSubsequentPeriod;
        Timeline timeline2 = timeline;
        SeekPosition seekPosition2 = seekPosition;
        Timeline.Period period3 = period2;
        Timeline timeline3 = seekPosition2.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline4 = timeline3.isEmpty() ? timeline2 : timeline3;
        try {
            Pair<Object, Long> periodPosition = timeline4.getPeriodPosition(window2, period2, seekPosition2.windowIndex, seekPosition2.windowPositionUs);
            if (timeline.equals(timeline4)) {
                return periodPosition;
            }
            if (timeline.getIndexOfPeriod(periodPosition.first) != -1) {
                timeline4.getPeriodByUid(periodPosition.first, period3);
                return timeline4.getWindow(period3.windowIndex, window2).isPlaceholder ? timeline.getPeriodPosition(window2, period2, timeline.getPeriodByUid(periodPosition.first, period3).windowIndex, seekPosition2.windowPositionUs) : periodPosition;
            }
            if (z && (resolveSubsequentPeriod = resolveSubsequentPeriod(window2, period2, i, z2, periodPosition.first, timeline4, timeline)) != null) {
                return timeline.getPeriodPosition(window2, period2, timeline.getPeriodByUid(resolveSubsequentPeriod, period3).windowIndex, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    static Object resolveSubsequentPeriod(Timeline.Window window2, Timeline.Period period2, int i, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i2 = indexOfPeriod;
        int i3 = -1;
        for (int i4 = 0; i4 < periodCount && i3 == -1; i4++) {
            i2 = timeline.getNextPeriodIndex(i2, period2, window2, i, z);
            if (i2 == -1) {
                break;
            }
            i3 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
        }
        if (i3 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i3);
    }

    private static Format[] getFormats(TrackSelection trackSelection) {
        int length = trackSelection != null ? trackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = trackSelection.getFormat(i);
        }
        return formatArr;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline2, int i, long j) {
            this.timeline = timeline2;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j;
            this.requestedContentPositionUs = j2;
            this.forceBufferingState = z;
            this.endPlayback = z2;
        }
    }

    static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public final void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }

        public final int compareTo(PendingMessageInfo pendingMessageInfo) {
            if ((this.resolvedPeriodUid == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                if (this.resolvedPeriodUid != null) {
                    return -1;
                }
                return 1;
            } else if (this.resolvedPeriodUid == null) {
                return 0;
            } else {
                int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
                if (i != 0) {
                    return i;
                }
                return Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
            }
        }
    }

    static final class MediaSourceListUpdateMessage {
        public final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        public final long positionUs;
        public final ShuffleOrder shuffleOrder;
        public final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder2, int i, long j) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder2;
            this.windowIndex = i;
            this.positionUs = j;
        }
    }

    static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i, int i2, int i3, ShuffleOrder shuffleOrder2) {
            this.fromIndex = i;
            this.toIndex = i2;
            this.newFromIndex = i3;
            this.shuffleOrder = shuffleOrder2;
        }
    }

    static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        public boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo2) {
            this.playbackInfo = playbackInfo2;
        }

        public final void incrementPendingOperationAcks(int i) {
            this.hasPendingChange |= i > 0;
            this.operationAcks += i;
        }

        public final void setPlaybackInfo(PlaybackInfo playbackInfo2) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo2;
            this.playbackInfo = playbackInfo2;
        }

        public final void setPositionDiscontinuity(int i) {
            boolean z = true;
            if (!this.positionDiscontinuity || this.discontinuityReason == 4) {
                this.hasPendingChange = true;
                this.positionDiscontinuity = true;
                this.discontinuityReason = i;
                return;
            }
            if (i != 4) {
                z = false;
            }
            Assertions.checkArgument(z);
        }

        public final void setPlayWhenReadyChangeReason(int i) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i;
        }
    }
}
