package com.xiaomi.smarthome.camera.exopackage;

import android.graphics.Bitmap;
import android.view.View;

public interface MJExoPlayer {

    public interface MJExoPlayerListener {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(float f);

        void onPlayerError(int i);

        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i);

        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onVideoSizeChanged(int i, int i2, int i3, float f);

        void onVideoSurfaceViewClicked(View view);

        void onVideoSurfaceViewLongClicked(View view);
    }

    int getBufferedPercentage();

    long getBufferedPosition();

    long getCurrentPosition();

    long getDuration();

    boolean getPlayWhenReady();

    float getPlaybackSpeed();

    int getPlaybackState();

    MJExoPlayerListener getPlayerListener();

    int getVideoScalingMode();

    float getVolume();

    boolean isLoading();

    void pausePlay();

    void resumePlay();

    void seekTo(long j);

    void setPlayWhenReady(boolean z);

    void setPlaybackSpeed(float f);

    void setPlayerListener(MJExoPlayerListener mJExoPlayerListener);

    void setVolume(float f);

    Bitmap snapshot();

    void startPlay(String str);

    void stopPlay();
}
