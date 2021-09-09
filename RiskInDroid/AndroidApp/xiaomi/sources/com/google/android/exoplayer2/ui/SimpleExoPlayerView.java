package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.exoplayer2.SimpleExoPlayer;

@Deprecated
public final class SimpleExoPlayerView extends PlayerView {
    public SimpleExoPlayerView(Context context) {
        super(context);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Deprecated
    public static void switchTargetView(SimpleExoPlayer simpleExoPlayer, SimpleExoPlayerView simpleExoPlayerView, SimpleExoPlayerView simpleExoPlayerView2) {
        PlayerView.switchTargetView(simpleExoPlayer, simpleExoPlayerView, simpleExoPlayerView2);
    }
}
