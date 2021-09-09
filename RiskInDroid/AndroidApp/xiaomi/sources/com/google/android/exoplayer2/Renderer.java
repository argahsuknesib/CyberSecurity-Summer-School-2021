package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Renderer extends PlayerMessage.Target {

    /* renamed from: com.google.android.exoplayer2.Renderer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setOperatingRate(Renderer renderer, float f) throws ExoPlaybackException {
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScalingMode {
    }

    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2) throws ExoPlaybackException;

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j, long j2) throws ExoPlaybackException;

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long j) throws ExoPlaybackException;

    void reset();

    void resetPosition(long j) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setIndex(int i);

    void setOperatingRate(float f) throws ExoPlaybackException;

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
