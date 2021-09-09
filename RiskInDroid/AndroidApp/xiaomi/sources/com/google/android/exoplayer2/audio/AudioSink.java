package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

public interface AudioSink {

    public interface Listener {
        void onAudioSessionId(int i);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z);

        void onUnderrun(int i, long j, long j2);
    }

    void configure(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i);

    void flush();

    long getCurrentPositionUs(boolean z);

    @Deprecated
    PlaybackParameters getPlaybackParameters();

    float getPlaybackSpeed();

    boolean getSkipSilenceEnabled();

    boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i);

    void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

    void setListener(Listener listener);

    @Deprecated
    void setPlaybackParameters(PlaybackParameters playbackParameters);

    void setPlaybackSpeed(float f);

    void setSkipSilenceEnabled(boolean z);

    void setVolume(float f);

    boolean supportsOutput(int i, int i2);

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.audioTrackState = i;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super("AudioTrack write failed: ".concat(String.valueOf(i)));
            this.errorCode = i;
        }
    }
}
