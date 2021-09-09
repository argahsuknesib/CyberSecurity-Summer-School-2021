package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public interface ExoPlayer extends Player {
    void addMediaSource(int i, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    PlayerMessage createMessage(PlayerMessage.Target target);

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    SeekParameters getSeekParameters();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    @Deprecated
    void retry();

    void setForegroundMode(boolean z);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j);

    void setMediaSource(MediaSource mediaSource, boolean z);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i, long j);

    void setMediaSources(List<MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setSeekParameters(SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private LoadControl loadControl;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private long releaseTimeoutMs;
        private final Renderer[] renderers;
        private boolean throwWhenStuckBuffering;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;

        public Builder(Context context, Renderer... rendererArr) {
            this(rendererArr, new DefaultTrackSelector(context), DefaultMediaSourceFactory.newInstance(context), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context), Util.getLooper(), null, true, Clock.DEFAULT);
        }

        public Builder(Renderer[] rendererArr, TrackSelector trackSelector2, MediaSourceFactory mediaSourceFactory2, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, Looper looper2, AnalyticsCollector analyticsCollector2, boolean z, Clock clock2) {
            Assertions.checkArgument(rendererArr.length > 0);
            this.renderers = rendererArr;
            this.trackSelector = trackSelector2;
            this.mediaSourceFactory = mediaSourceFactory2;
            this.loadControl = loadControl2;
            this.bandwidthMeter = bandwidthMeter2;
            this.looper = looper2;
            this.analyticsCollector = analyticsCollector2;
            this.useLazyPreparation = z;
            this.clock = clock2;
        }

        public final Builder experimental_setReleaseTimeoutMs(long j) {
            this.releaseTimeoutMs = j;
            return this;
        }

        public final Builder experimental_setThrowWhenStuckBuffering(boolean z) {
            this.throwWhenStuckBuffering = z;
            return this;
        }

        public final Builder setTrackSelector(TrackSelector trackSelector2) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector2;
            return this;
        }

        public final Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory2) {
            Assertions.checkState(!this.buildCalled);
            this.mediaSourceFactory = mediaSourceFactory2;
            return this;
        }

        public final Builder setLoadControl(LoadControl loadControl2) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl2;
            return this;
        }

        public final Builder setBandwidthMeter(BandwidthMeter bandwidthMeter2) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter2;
            return this;
        }

        public final Builder setLooper(Looper looper2) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper2;
            return this;
        }

        public final Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector2) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector2;
            return this;
        }

        public final Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }

        public final Builder setClock(Clock clock2) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock2;
            return this;
        }

        public final ExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(this.renderers, this.trackSelector, this.mediaSourceFactory, this.loadControl, this.bandwidthMeter, this.analyticsCollector, this.useLazyPreparation, this.clock, this.looper);
            long j = this.releaseTimeoutMs;
            if (j > 0) {
                exoPlayerImpl.experimental_setReleaseTimeoutMs(j);
            }
            if (this.throwWhenStuckBuffering) {
                exoPlayerImpl.experimental_throwWhenStuckBuffering();
            }
            return exoPlayerImpl;
        }
    }
}
