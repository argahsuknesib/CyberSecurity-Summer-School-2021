package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    public interface ListenerInvocation {
        void invokeListener(Player.EventListener eventListener);
    }

    public void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    public void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(Collections.singletonList(mediaItem), 0, j);
    }

    public void setMediaItem(MediaItem mediaItem, boolean z) {
        setMediaItems(Collections.singletonList(mediaItem), z);
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        setMediaItems(list, -1, -9223372036854775807L);
    }

    public void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    public void addMediaItem(int i, MediaItem mediaItem) {
        addMediaItems(i, Collections.singletonList(mediaItem));
    }

    public void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Collections.singletonList(mediaItem));
    }

    public void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    public void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    public final void play() {
        setPlayWhenReady(true);
    }

    public final void pause() {
        setPlayWhenReady(false);
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    public final void seekToDefaultPosition(int i) {
        seekTo(i, -9223372036854775807L);
    }

    public final void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    public final boolean hasPrevious() {
        return getPreviousWindowIndex() != -1;
    }

    public final void previous() {
        int previousWindowIndex = getPreviousWindowIndex();
        if (previousWindowIndex != -1) {
            seekToDefaultPosition(previousWindowIndex);
        }
    }

    public final boolean hasNext() {
        return getNextWindowIndex() != -1;
    }

    public final void next() {
        int nextWindowIndex = getNextWindowIndex();
        if (nextWindowIndex != -1) {
            seekToDefaultPosition(nextWindowIndex);
        }
    }

    public final void stop() {
        stop(false);
    }

    public final int getNextWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    public final int getPreviousWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    public final Object getCurrentTag() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).tag;
    }

    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).manifest;
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public final boolean isCurrentWindowDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    public final boolean isCurrentWindowLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isLive;
    }

    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).windowStartTimeMs != -9223372036854775807L) {
            return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
        }
        return -9223372036854775807L;
    }

    public final boolean isCurrentWindowSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public static final class ListenerHolder {
        public final Player.EventListener listener;
        private boolean released;

        public ListenerHolder(Player.EventListener eventListener) {
            this.listener = eventListener;
        }

        public final void release() {
            this.released = true;
        }

        public final void invoke(ListenerInvocation listenerInvocation) {
            if (!this.released) {
                listenerInvocation.invokeListener(this.listener);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public final int hashCode() {
            return this.listener.hashCode();
        }
    }
}
