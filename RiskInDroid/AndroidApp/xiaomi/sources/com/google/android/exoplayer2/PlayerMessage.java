package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import java.util.concurrent.TimeoutException;

public final class PlayerMessage {
    private boolean deleteAfterDelivery = true;
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private long positionMs = -9223372036854775807L;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;

    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender2, Target target2, Timeline timeline2, int i, Handler handler2) {
        this.sender = sender2;
        this.target = target2;
        this.timeline = timeline2;
        this.handler = handler2;
        this.windowIndex = i;
    }

    public final Timeline getTimeline() {
        return this.timeline;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final PlayerMessage setType(int i) {
        Assertions.checkState(!this.isSent);
        this.type = i;
        return this;
    }

    public final int getType() {
        return this.type;
    }

    public final PlayerMessage setPayload(Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final PlayerMessage setHandler(Handler handler2) {
        Assertions.checkState(!this.isSent);
        this.handler = handler2;
        return this;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final PlayerMessage setPosition(long j) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j;
        return this;
    }

    public final PlayerMessage setPosition(int i, long j) {
        boolean z = true;
        Assertions.checkState(!this.isSent);
        if (j == -9223372036854775807L) {
            z = false;
        }
        Assertions.checkArgument(z);
        if (i < 0 || (!this.timeline.isEmpty() && i >= this.timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(this.timeline, i, j);
        }
        this.windowIndex = i;
        this.positionMs = j;
        return this;
    }

    public final int getWindowIndex() {
        return this.windowIndex;
    }

    public final PlayerMessage setDeleteAfterDelivery(boolean z) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z;
        return this;
    }

    public final boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public final PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == -9223372036854775807L) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public final synchronized PlayerMessage cancel() {
        Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public final synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public final synchronized boolean blockUntilDelivered() throws InterruptedException {
        Assertions.checkState(this.isSent);
        Assertions.checkState(this.handler.getLooper().getThread() != Thread.currentThread());
        while (!this.isProcessed) {
            wait();
        }
        return this.isDelivered;
    }

    public final synchronized boolean experimental_blockUntilDelivered(long j) throws InterruptedException, TimeoutException {
        return experimental_blockUntilDelivered(j, Clock.DEFAULT);
    }

    public final synchronized void markAsProcessed(boolean z) {
        this.isDelivered = z | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean experimental_blockUntilDelivered(long j, Clock clock) throws InterruptedException, TimeoutException {
        Assertions.checkState(this.isSent);
        Assertions.checkState(this.handler.getLooper().getThread() != Thread.currentThread());
        long elapsedRealtime = clock.elapsedRealtime() + j;
        while (!this.isProcessed && j > 0) {
            wait(j);
            j = elapsedRealtime - clock.elapsedRealtime();
        }
        if (!this.isProcessed) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.isDelivered;
    }
}
