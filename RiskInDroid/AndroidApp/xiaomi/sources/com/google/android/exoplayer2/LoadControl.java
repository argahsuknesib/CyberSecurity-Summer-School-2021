package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;

public interface LoadControl {
    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

    boolean retainBackBufferFromKeyframe();

    @Deprecated
    boolean shouldContinueLoading(long j, float f);

    boolean shouldContinueLoading(long j, long j2, float f);

    boolean shouldStartPlayback(long j, float f, boolean z);

    /* renamed from: com.google.android.exoplayer2.LoadControl$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated
        public static boolean $default$shouldContinueLoading(LoadControl loadControl, long j, float f) {
            return false;
        }

        public static boolean $default$shouldContinueLoading(LoadControl _this, long j, long j2, float f) {
            return _this.shouldContinueLoading(j2, f);
        }
    }
}
