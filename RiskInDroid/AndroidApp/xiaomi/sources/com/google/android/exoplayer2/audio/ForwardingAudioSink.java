package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioSink;
import java.nio.ByteBuffer;

public class ForwardingAudioSink implements AudioSink {
    private final AudioSink sink;

    public ForwardingAudioSink(AudioSink audioSink) {
        this.sink = audioSink;
    }

    public void setListener(AudioSink.Listener listener) {
        this.sink.setListener(listener);
    }

    public boolean supportsOutput(int i, int i2) {
        return this.sink.supportsOutput(i, i2);
    }

    public long getCurrentPositionUs(boolean z) {
        return this.sink.getCurrentPositionUs(z);
    }

    public void configure(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        this.sink.configure(i, i2, i3, i4, iArr, i5, i6);
    }

    public void play() {
        this.sink.play();
    }

    public void handleDiscontinuity() {
        this.sink.handleDiscontinuity();
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws AudioSink.InitializationException, AudioSink.WriteException {
        return this.sink.handleBuffer(byteBuffer, j, i);
    }

    public void playToEndOfStream() throws AudioSink.WriteException {
        this.sink.playToEndOfStream();
    }

    public boolean isEnded() {
        return this.sink.isEnded();
    }

    public boolean hasPendingData() {
        return this.sink.hasPendingData();
    }

    @Deprecated
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.sink.setPlaybackParameters(playbackParameters);
    }

    @Deprecated
    public PlaybackParameters getPlaybackParameters() {
        return this.sink.getPlaybackParameters();
    }

    public void setPlaybackSpeed(float f) {
        this.sink.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        return this.sink.getPlaybackSpeed();
    }

    public void setSkipSilenceEnabled(boolean z) {
        this.sink.setSkipSilenceEnabled(z);
    }

    public boolean getSkipSilenceEnabled() {
        return this.sink.getSkipSilenceEnabled();
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        this.sink.setAudioAttributes(audioAttributes);
    }

    public void setAudioSessionId(int i) {
        this.sink.setAudioSessionId(i);
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        this.sink.setAuxEffectInfo(auxEffectInfo);
    }

    public void enableTunnelingV21(int i) {
        this.sink.enableTunnelingV21(i);
    }

    public void disableTunneling() {
        this.sink.disableTunneling();
    }

    public void setVolume(float f) {
        this.sink.setVolume(f);
    }

    public void pause() {
        this.sink.pause();
    }

    public void flush() {
        this.sink.flush();
    }

    public void reset() {
        this.sink.reset();
    }
}
