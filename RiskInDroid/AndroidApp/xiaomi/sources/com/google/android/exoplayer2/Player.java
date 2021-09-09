package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface Player {

    public interface AudioComponent {
        void addAudioListener(AudioListener audioListener);

        void clearAuxEffectInfo();

        AudioAttributes getAudioAttributes();

        int getAudioSessionId();

        boolean getSkipSilenceEnabled();

        float getVolume();

        void removeAudioListener(AudioListener audioListener);

        @Deprecated
        void setAudioAttributes(AudioAttributes audioAttributes);

        void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

        void setAudioSessionId(int i);

        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        void setSkipSilenceEnabled(boolean z);

        void setVolume(float f);
    }

    public interface DeviceComponent {
        void addDeviceListener(DeviceListener deviceListener);

        void decreaseDeviceVolume();

        DeviceInfo getDeviceInfo();

        int getDeviceVolume();

        void increaseDeviceVolume();

        boolean isDeviceMuted();

        void removeDeviceListener(DeviceListener deviceListener);

        void setDeviceMuted(boolean z);

        void setDeviceVolume(int i);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    public interface MetadataComponent {
        void addMetadataOutput(MetadataOutput metadataOutput);

        void removeMetadataOutput(MetadataOutput metadataOutput);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface TextComponent {
        void addTextOutput(TextOutput textOutput);

        void removeTextOutput(TextOutput textOutput);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    public interface VideoComponent {
        void addVideoListener(VideoListener videoListener);

        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        void clearVideoDecoderOutputBufferRenderer();

        void clearVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer);

        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        void clearVideoSurface();

        void clearVideoSurface(Surface surface);

        void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(SurfaceView surfaceView);

        void clearVideoTextureView(TextureView textureView);

        int getVideoScalingMode();

        void removeVideoListener(VideoListener videoListener);

        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer);

        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        void setVideoScalingMode(int i);

        void setVideoSurface(Surface surface);

        void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(SurfaceView surfaceView);

        void setVideoTextureView(TextureView textureView);
    }

    void addListener(EventListener eventListener);

    void addMediaItem(int i, MediaItem mediaItem);

    void addMediaItem(MediaItem mediaItem);

    void addMediaItems(int i, List<MediaItem> list);

    void addMediaItems(List<MediaItem> list);

    void clearMediaItems();

    Looper getApplicationLooper();

    AudioComponent getAudioComponent();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    long getCurrentLiveOffset();

    Object getCurrentManifest();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Object getCurrentTag();

    Timeline getCurrentTimeline();

    TrackGroupArray getCurrentTrackGroups();

    TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    DeviceComponent getDeviceComponent();

    long getDuration();

    MetadataComponent getMetadataComponent();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    @Deprecated
    ExoPlaybackException getPlaybackError();

    @Deprecated
    PlaybackParameters getPlaybackParameters();

    float getPlaybackSpeed();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    ExoPlaybackException getPlayerError();

    int getPreviousWindowIndex();

    int getRendererCount();

    int getRendererType(int i);

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    TextComponent getTextComponent();

    long getTotalBufferedDuration();

    VideoComponent getVideoComponent();

    boolean hasNext();

    boolean hasPrevious();

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowLive();

    boolean isCurrentWindowSeekable();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    void moveMediaItem(int i, int i2);

    void moveMediaItems(int i, int i2, int i3);

    void next();

    void pause();

    void play();

    void prepare();

    void previous();

    void release();

    void removeListener(EventListener eventListener);

    void removeMediaItem(int i);

    void removeMediaItems(int i, int i2);

    void seekTo(int i, long j);

    void seekTo(long j);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i);

    void setMediaItem(MediaItem mediaItem);

    void setMediaItem(MediaItem mediaItem, long j);

    void setMediaItem(MediaItem mediaItem, boolean z);

    void setMediaItems(List<MediaItem> list);

    void setMediaItems(List<MediaItem> list, int i, long j);

    void setMediaItems(List<MediaItem> list, boolean z);

    void setPlayWhenReady(boolean z);

    @Deprecated
    void setPlaybackParameters(PlaybackParameters playbackParameters);

    void setPlaybackSpeed(float f);

    void setRepeatMode(int i);

    void setShuffleModeEnabled(boolean z);

    void stop();

    void stop(boolean z);

    public interface EventListener {
        void onIsLoadingChanged(boolean z);

        void onIsPlayingChanged(boolean z);

        @Deprecated
        void onLoadingChanged(boolean z);

        void onPlayWhenReadyChanged(boolean z, int i);

        @Deprecated
        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlaybackSpeedChanged(float f);

        void onPlaybackStateChanged(int i);

        void onPlaybackSuppressionReasonChanged(int i);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        @Deprecated
        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onTimelineChanged(Timeline timeline, int i);

        @Deprecated
        void onTimelineChanged(Timeline timeline, Object obj, int i);

        void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

        /* renamed from: com.google.android.exoplayer2.Player$EventListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onIsPlayingChanged(EventListener eventListener, boolean z) {
            }

            @Deprecated
            public static void $default$onLoadingChanged(EventListener eventListener, boolean z) {
            }

            public static void $default$onPlayWhenReadyChanged(EventListener eventListener, boolean z, int i) {
            }

            @Deprecated
            public static void $default$onPlaybackParametersChanged(EventListener eventListener, PlaybackParameters playbackParameters) {
            }

            public static void $default$onPlaybackSpeedChanged(EventListener eventListener, float f) {
            }

            public static void $default$onPlaybackStateChanged(EventListener eventListener, int i) {
            }

            public static void $default$onPlaybackSuppressionReasonChanged(EventListener eventListener, int i) {
            }

            public static void $default$onPlayerError(EventListener eventListener, ExoPlaybackException exoPlaybackException) {
            }

            @Deprecated
            public static void $default$onPlayerStateChanged(EventListener eventListener, boolean z, int i) {
            }

            public static void $default$onPositionDiscontinuity(EventListener eventListener, int i) {
            }

            public static void $default$onRepeatModeChanged(EventListener eventListener, int i) {
            }

            public static void $default$onSeekProcessed(EventListener eventListener) {
            }

            public static void $default$onShuffleModeEnabledChanged(EventListener eventListener, boolean z) {
            }

            @Deprecated
            public static void $default$onTimelineChanged(EventListener eventListener, Timeline timeline, Object obj, int i) {
            }

            public static void $default$onTracksChanged(EventListener eventListener, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            public static void $default$onTimelineChanged(EventListener _this, Timeline timeline, int i) {
                _this.onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, i);
            }

            public static void $default$onIsLoadingChanged(EventListener _this, boolean z) {
                _this.onLoadingChanged(z);
            }
        }
    }

    @Deprecated
    public static abstract class DefaultEventListener implements EventListener {
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onLoadingChanged(boolean z) {
            EventListener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        @Deprecated
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackSpeedChanged(float f) {
            EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i) {
            EventListener.CC.$default$onPlaybackStateChanged(this, i);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        @Deprecated
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i) {
            EventListener.CC.$default$onPositionDiscontinuity(this, i);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekProcessed() {
            EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        @Deprecated
        public void onTimelineChanged(Timeline timeline, Object obj) {
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        public void onTimelineChanged(Timeline timeline, int i) {
            onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, i);
        }

        public void onTimelineChanged(Timeline timeline, Object obj, int i) {
            onTimelineChanged(timeline, obj);
        }
    }
}
