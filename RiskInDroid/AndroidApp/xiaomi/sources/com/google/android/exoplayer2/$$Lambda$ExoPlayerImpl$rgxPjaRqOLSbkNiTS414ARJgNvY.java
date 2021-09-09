package com.google.android.exoplayer2;

import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$rgxPjaRqOLSbkNiTS414ARJgNvY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ExoPlayerImpl$rgxPjaRqOLSbkNiTS414ARJgNvY implements BasePlayer.ListenerInvocation {
    public static final /* synthetic */ $$Lambda$ExoPlayerImpl$rgxPjaRqOLSbkNiTS414ARJgNvY INSTANCE = new $$Lambda$ExoPlayerImpl$rgxPjaRqOLSbkNiTS414ARJgNvY();

    private /* synthetic */ $$Lambda$ExoPlayerImpl$rgxPjaRqOLSbkNiTS414ARJgNvY() {
    }

    public final void invokeListener(Player.EventListener eventListener) {
        eventListener.onPlayerError(ExoPlaybackException.createForUnexpected(new RuntimeException(new TimeoutException("Player release timed out."))));
    }
}
