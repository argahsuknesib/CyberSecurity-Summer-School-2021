package com.google.android.exoplayer2;

import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;
    private final int targetBufferBytesOverwrite;

    public /* synthetic */ boolean shouldContinueLoading(long j, long j2, float f) {
        return LoadControl.CC.$default$shouldContinueLoading(this, j, j2, f);
    }

    public static final class Builder {
        private DefaultAllocator allocator;
        private int backBufferDurationMs = 0;
        private int bufferForPlaybackAfterRebufferMs = 5000;
        private int bufferForPlaybackMs = 2500;
        private boolean createDefaultLoadControlCalled;
        private int maxBufferMs = 50000;
        private int minBufferMs = 50000;
        private boolean prioritizeTimeOverSizeThresholds = false;
        private boolean retainBackBufferFromKeyframe = false;
        private int targetBufferBytes = -1;

        public final Builder setAllocator(DefaultAllocator defaultAllocator) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.allocator = defaultAllocator;
            return this;
        }

        public final Builder setBufferDurationsMs(int i, int i2, int i3, int i4) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            DefaultLoadControl.assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(i, i3, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.assertGreaterOrEqual(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.assertGreaterOrEqual(i2, i, "maxBufferMs", "minBufferMs");
            this.minBufferMs = i;
            this.maxBufferMs = i2;
            this.bufferForPlaybackMs = i3;
            this.bufferForPlaybackAfterRebufferMs = i4;
            return this;
        }

        public final Builder setTargetBufferBytes(int i) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.targetBufferBytes = i;
            return this;
        }

        public final Builder setPrioritizeTimeOverSizeThresholds(boolean z) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.prioritizeTimeOverSizeThresholds = z;
            return this;
        }

        public final Builder setBackBuffer(int i, boolean z) {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            DefaultLoadControl.assertGreaterOrEqual(i, 0, "backBufferDurationMs", "0");
            this.backBufferDurationMs = i;
            this.retainBackBufferFromKeyframe = z;
            return this;
        }

        public final DefaultLoadControl createDefaultLoadControl() {
            Assertions.checkState(!this.createDefaultLoadControlCalled);
            this.createDefaultLoadControlCalled = true;
            if (this.allocator == null) {
                this.allocator = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(defaultAllocator, i, i2, i3, i4, i5, z, 0, false);
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i, i3, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i2, i, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i6, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator;
        this.minBufferUs = C.msToUs((long) i);
        this.maxBufferUs = C.msToUs((long) i2);
        this.bufferForPlaybackUs = C.msToUs((long) i3);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs((long) i4);
        this.targetBufferBytesOverwrite = i5;
        int i7 = this.targetBufferBytesOverwrite;
        this.targetBufferBytes = i7 == -1 ? 13107200 : i7;
        this.prioritizeTimeOverSizeThresholds = z;
        this.backBufferDurationUs = C.msToUs((long) i6);
        this.retainBackBufferFromKeyframe = z2;
    }

    public void onPrepared() {
        reset(false);
    }

    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        int i = this.targetBufferBytesOverwrite;
        if (i == -1) {
            i = calculateTargetBufferBytes(rendererArr, trackSelectionArray);
        }
        this.targetBufferBytes = i;
        this.allocator.setTargetBufferSize(this.targetBufferBytes);
    }

    public void onStopped() {
        reset(true);
    }

    public void onReleased() {
        reset(true);
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public boolean shouldContinueLoading(long j, float f) {
        boolean z = true;
        boolean z2 = this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes;
        long j2 = this.minBufferUs;
        if (f > 1.0f) {
            j2 = Math.min(Util.getMediaDurationForPlayoutDuration(j2, f), this.maxBufferUs);
        }
        if (j < Math.max(j2, 500000L)) {
            if (!this.prioritizeTimeOverSizeThresholds && z2) {
                z = false;
            }
            this.isBuffering = z;
            if (!this.isBuffering && j < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.maxBufferUs || z2) {
            this.isBuffering = false;
        }
        return this.isBuffering;
    }

    public boolean shouldStartPlayback(long j, float f, boolean z) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j, f);
        long j2 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        if (j2 <= 0 || playoutDurationForMediaDuration >= j2) {
            return true;
        }
        return !this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes;
    }

    /* access modifiers changed from: protected */
    public int calculateTargetBufferBytes(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int i = 0;
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            if (trackSelectionArray.get(i2) != null) {
                i += getDefaultBufferSize(rendererArr[i2].getTrackType());
            }
        }
        return Math.max(13107200, i);
    }

    private void reset(boolean z) {
        int i = this.targetBufferBytesOverwrite;
        if (i == -1) {
            i = 13107200;
        }
        this.targetBufferBytes = i;
        this.isBuffering = false;
        if (z) {
            this.allocator.reset();
        }
    }

    private static int getDefaultBufferSize(int i) {
        switch (i) {
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void assertGreaterOrEqual(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        Assertions.checkArgument(z, str + " cannot be less than " + str2);
    }
}
