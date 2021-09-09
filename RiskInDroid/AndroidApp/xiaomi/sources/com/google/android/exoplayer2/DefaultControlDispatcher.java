package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;

public class DefaultControlDispatcher implements ControlDispatcher {
    private long fastForwardIncrementMs;
    private long rewindIncrementMs;
    private final Timeline.Window window;

    public DefaultControlDispatcher() {
        this(15000, 5000);
    }

    public DefaultControlDispatcher(long j, long j2) {
        this.fastForwardIncrementMs = j;
        this.rewindIncrementMs = j2;
        this.window = new Timeline.Window();
    }

    public boolean dispatchSetPlayWhenReady(Player player, boolean z) {
        player.setPlayWhenReady(z);
        return true;
    }

    public boolean dispatchSeekTo(Player player, int i, long j) {
        player.seekTo(i, j);
        return true;
    }

    public boolean dispatchPrevious(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.window);
            int previousWindowIndex = player.getPreviousWindowIndex();
            if (previousWindowIndex == -1 || (player.getCurrentPosition() > 3000 && (!this.window.isDynamic || this.window.isSeekable))) {
                player.seekTo(currentWindowIndex, 0);
            } else {
                player.seekTo(previousWindowIndex, -9223372036854775807L);
            }
        }
        return true;
    }

    public boolean dispatchNext(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, -9223372036854775807L);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.window).isLive) {
                player.seekTo(currentWindowIndex, -9223372036854775807L);
            }
        }
        return true;
    }

    public boolean dispatchRewind(Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, -this.rewindIncrementMs);
        return true;
    }

    public boolean dispatchFastForward(Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, this.fastForwardIncrementMs);
        return true;
    }

    public boolean dispatchSetRepeatMode(Player player, int i) {
        player.setRepeatMode(i);
        return true;
    }

    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z) {
        player.setShuffleModeEnabled(z);
        return true;
    }

    public boolean dispatchStop(Player player, boolean z) {
        player.stop(z);
        return true;
    }

    public boolean isRewindEnabled() {
        return this.rewindIncrementMs > 0;
    }

    public boolean isFastForwardEnabled() {
        return this.fastForwardIncrementMs > 0;
    }

    public long getRewindIncrementMs() {
        return this.rewindIncrementMs;
    }

    public long getFastForwardIncrementMs() {
        return this.fastForwardIncrementMs;
    }

    @Deprecated
    public void setRewindIncrementMs(long j) {
        this.rewindIncrementMs = j;
    }

    @Deprecated
    public void setFastForwardIncrementMs(long j) {
        this.fastForwardIncrementMs = j;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    private static void seekToOffset(Player player, long j) {
        long currentPosition = player.getCurrentPosition() + j;
        long duration = player.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), Math.max(currentPosition, 0L));
    }
}
