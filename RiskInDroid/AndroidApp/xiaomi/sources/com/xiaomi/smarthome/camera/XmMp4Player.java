package com.xiaomi.smarthome.camera;

import android.media.MediaPlayer;

public interface XmMp4Player {

    public interface AudioListener {
        void onAudioData(byte[] bArr, long j, int i);

        void onFinish(int i);
    }

    public interface RenderCallback {
        void onInitialed();
    }

    void changeSource(String str);

    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void openVideoPlayer(String str);

    void pause();

    void seekTo(int i);

    void setAudioListener(AudioListener audioListener);

    void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    void setRenderCallback(RenderCallback renderCallback);

    void setVolume(int i);
}
