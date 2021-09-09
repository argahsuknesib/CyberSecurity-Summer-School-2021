package com.google.android.exoplayer2;

public interface ControlDispatcher {
    boolean dispatchFastForward(Player player);

    boolean dispatchNext(Player player);

    boolean dispatchPrevious(Player player);

    boolean dispatchRewind(Player player);

    boolean dispatchSeekTo(Player player, int i, long j);

    boolean dispatchSetPlayWhenReady(Player player, boolean z);

    boolean dispatchSetRepeatMode(Player player, int i);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z);

    boolean dispatchStop(Player player, boolean z);

    boolean isFastForwardEnabled();

    boolean isRewindEnabled();
}
