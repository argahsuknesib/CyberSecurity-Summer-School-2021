package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, Player.AudioComponent, Player.DeviceComponent, Player.MetadataComponent, Player.TextComponent, Player.VideoComponent {
    private final AnalyticsCollector analyticsCollector;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    public final CopyOnWriteArraySet<AudioRendererEventListener> audioDebugListeners;
    public DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    public Format audioFormat;
    private final CopyOnWriteArraySet<AudioListener> audioListeners;
    public int audioSessionId;
    private float audioVolume;
    private final BandwidthMeter bandwidthMeter;
    private CameraMotionListener cameraMotionListener;
    private final ComponentListener componentListener;
    public List<Cue> currentCues;
    public DeviceInfo deviceInfo;
    public final CopyOnWriteArraySet<DeviceListener> deviceListeners;
    private final Handler eventHandler;
    private boolean hasNotifiedFullWrongThreadWarning;
    public boolean isPriorityTaskManagerRegistered;
    public final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private boolean ownsSurface;
    private final ExoPlayerImpl player;
    private boolean playerReleased;
    public PriorityTaskManager priorityTaskManager;
    protected final Renderer[] renderers;
    public boolean skipSilenceEnabled;
    public final StreamVolumeManager streamVolumeManager;
    public Surface surface;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    private int surfaceWidth;
    public final CopyOnWriteArraySet<TextOutput> textOutputs;
    private TextureView textureView;
    public final CopyOnWriteArraySet<VideoRendererEventListener> videoDebugListeners;
    public DecoderCounters videoDecoderCounters;
    private VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer;
    public Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> videoListeners;
    private int videoScalingMode;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    @Deprecated
    public interface VideoListener extends com.google.android.exoplayer2.video.VideoListener {
    }

    public static int getPlayWhenReadyChangeReason(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public Player.AudioComponent getAudioComponent() {
        return this;
    }

    public Player.DeviceComponent getDeviceComponent() {
        return this;
    }

    public Player.MetadataComponent getMetadataComponent() {
        return this;
    }

    public Player.TextComponent getTextComponent() {
        return this;
    }

    public Player.VideoComponent getVideoComponent() {
        return this;
    }

    public static final class Builder {
        public AnalyticsCollector analyticsCollector;
        public BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        public Clock clock;
        public final Context context;
        public LoadControl loadControl;
        public Looper looper;
        public MediaSourceFactory mediaSourceFactory;
        public final RenderersFactory renderersFactory;
        public TrackSelector trackSelector;
        public boolean useLazyPreparation;

        public Builder(Context context2) {
            this(context2, new DefaultRenderersFactory(context2));
        }

        public Builder(Context context2, RenderersFactory renderersFactory2) {
            this(context2, renderersFactory2, new DefaultTrackSelector(context2), DefaultMediaSourceFactory.newInstance(context2), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context2), Util.getLooper(), new AnalyticsCollector(Clock.DEFAULT), true, Clock.DEFAULT);
        }

        public Builder(Context context2, RenderersFactory renderersFactory2, TrackSelector trackSelector2, MediaSourceFactory mediaSourceFactory2, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, Looper looper2, AnalyticsCollector analyticsCollector2, boolean z, Clock clock2) {
            this.context = context2;
            this.renderersFactory = renderersFactory2;
            this.trackSelector = trackSelector2;
            this.mediaSourceFactory = mediaSourceFactory2;
            this.loadControl = loadControl2;
            this.bandwidthMeter = bandwidthMeter2;
            this.looper = looper2;
            this.analyticsCollector = analyticsCollector2;
            this.useLazyPreparation = z;
            this.clock = clock2;
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

        public final SimpleExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }
    }

    protected SimpleExoPlayer(Builder builder) {
        this(builder.context, builder.renderersFactory, builder.trackSelector, builder.mediaSourceFactory, builder.loadControl, builder.bandwidthMeter, builder.analyticsCollector, builder.useLazyPreparation, builder.clock, builder.looper);
    }

    protected SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter2, AnalyticsCollector analyticsCollector2, boolean z, Clock clock, Looper looper) {
        Context context2 = context;
        BandwidthMeter bandwidthMeter3 = bandwidthMeter2;
        AnalyticsCollector analyticsCollector3 = analyticsCollector2;
        this.bandwidthMeter = bandwidthMeter3;
        this.analyticsCollector = analyticsCollector3;
        this.componentListener = new ComponentListener();
        this.videoListeners = new CopyOnWriteArraySet<>();
        this.audioListeners = new CopyOnWriteArraySet<>();
        this.textOutputs = new CopyOnWriteArraySet<>();
        this.metadataOutputs = new CopyOnWriteArraySet<>();
        this.deviceListeners = new CopyOnWriteArraySet<>();
        this.videoDebugListeners = new CopyOnWriteArraySet<>();
        this.audioDebugListeners = new CopyOnWriteArraySet<>();
        Looper looper2 = looper;
        this.eventHandler = new Handler(looper2);
        Handler handler = this.eventHandler;
        ComponentListener componentListener2 = this.componentListener;
        this.renderers = renderersFactory.createRenderers(handler, componentListener2, componentListener2, componentListener2, componentListener2);
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.currentCues = Collections.emptyList();
        this.player = new ExoPlayerImpl(this.renderers, trackSelector, mediaSourceFactory, loadControl, bandwidthMeter2, analyticsCollector2, z, clock, looper2);
        analyticsCollector3.setPlayer(this.player);
        this.player.addListener(analyticsCollector3);
        this.player.addListener(this.componentListener);
        this.videoDebugListeners.add(analyticsCollector3);
        this.videoListeners.add(analyticsCollector3);
        this.audioDebugListeners.add(analyticsCollector3);
        this.audioListeners.add(analyticsCollector3);
        addMetadataOutput(analyticsCollector3);
        bandwidthMeter3.addEventListener(this.eventHandler, analyticsCollector3);
        this.audioBecomingNoisyManager = new AudioBecomingNoisyManager(context2, this.eventHandler, this.componentListener);
        this.audioFocusManager = new AudioFocusManager(context2, this.eventHandler, this.componentListener);
        this.streamVolumeManager = new StreamVolumeManager(context2, this.eventHandler, this.componentListener);
        this.wakeLockManager = new WakeLockManager(context2);
        this.wifiLockManager = new WifiLockManager(context2);
        this.deviceInfo = createDeviceInfo(this.streamVolumeManager);
    }

    public void setVideoScalingMode(int i) {
        verifyApplicationThread();
        this.videoScalingMode = i;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(4).setPayload(Integer.valueOf(i)).send();
            }
        }
    }

    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(null, false);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    public void clearVideoSurface(Surface surface2) {
        verifyApplicationThread();
        if (surface2 != null && surface2 == this.surface) {
            clearVideoSurface();
        }
    }

    public void setVideoSurface(Surface surface2) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (surface2 != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        int i = 0;
        setVideoSurfaceInternal(surface2, false);
        if (surface2 != null) {
            i = -1;
        }
        maybeNotifySurfaceSizeChanged(i, i);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (surfaceHolder2 != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.surfaceHolder = surfaceHolder2;
        if (surfaceHolder2 != null) {
            surfaceHolder2.addCallback(this.componentListener);
            Surface surface2 = surfaceHolder2.getSurface();
            if (surface2 != null && surface2.isValid()) {
                setVideoSurfaceInternal(surface2, false);
                Rect surfaceFrame = surfaceHolder2.getSurfaceFrame();
                maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
                return;
            }
        }
        setVideoSurfaceInternal(null, false);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 != null && surfaceHolder2 == this.surfaceHolder) {
            setVideoSurfaceHolder(null);
        }
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    public void setVideoTextureView(TextureView textureView2) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        if (textureView2 != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.textureView = textureView2;
        if (textureView2 == null) {
            setVideoSurfaceInternal(null, true);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        if (textureView2.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView2.setSurfaceTextureListener(this.componentListener);
        SurfaceTexture surfaceTexture = textureView2.isAvailable() ? textureView2.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            setVideoSurfaceInternal(null, true);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setVideoSurfaceInternal(new Surface(surfaceTexture), true);
        maybeNotifySurfaceSizeChanged(textureView2.getWidth(), textureView2.getHeight());
    }

    public void clearVideoTextureView(TextureView textureView2) {
        verifyApplicationThread();
        if (textureView2 != null && textureView2 == this.textureView) {
            setVideoTextureView(null);
        }
    }

    public void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer2) {
        verifyApplicationThread();
        if (videoDecoderOutputBufferRenderer2 != null) {
            clearVideoSurface();
        }
        setVideoDecoderOutputBufferRendererInternal(videoDecoderOutputBufferRenderer2);
    }

    public void clearVideoDecoderOutputBufferRenderer() {
        verifyApplicationThread();
        setVideoDecoderOutputBufferRendererInternal(null);
    }

    public void clearVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer2) {
        verifyApplicationThread();
        if (videoDecoderOutputBufferRenderer2 != null && videoDecoderOutputBufferRenderer2 == this.videoDecoderOutputBufferRenderer) {
            clearVideoDecoderOutputBufferRenderer();
        }
    }

    public void addAudioListener(AudioListener audioListener) {
        this.audioListeners.add(audioListener);
    }

    public void removeAudioListener(AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        setAudioAttributes(audioAttributes2, false);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2, boolean z) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            if (!Util.areEqual(this.audioAttributes, audioAttributes2)) {
                this.audioAttributes = audioAttributes2;
                for (Renderer renderer : this.renderers) {
                    if (renderer.getTrackType() == 1) {
                        this.player.createMessage(renderer).setType(3).setPayload(audioAttributes2).send();
                    }
                }
                this.streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(audioAttributes2.usage));
                Iterator<AudioListener> it = this.audioListeners.iterator();
                while (it.hasNext()) {
                    it.next().onAudioAttributesChanged(audioAttributes2);
                }
            }
            AudioFocusManager audioFocusManager2 = this.audioFocusManager;
            if (!z) {
                audioAttributes2 = null;
            }
            audioFocusManager2.setAudioAttributes(audioAttributes2);
            boolean playWhenReady = getPlayWhenReady();
            int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
            updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        }
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public void setAudioSessionId(int i) {
        verifyApplicationThread();
        if (this.audioSessionId != i) {
            this.audioSessionId = i;
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 1) {
                    this.player.createMessage(renderer).setType(102).setPayload(Integer.valueOf(i)).send();
                }
            }
            if (i != 0) {
                notifyAudioSessionIdSet();
            }
        }
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(5).setPayload(auxEffectInfo).send();
            }
        }
    }

    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.constrainValue(float, float, float):float
     arg types: [float, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.constrainValue(int, int, int):int
      com.google.android.exoplayer2.util.Util.constrainValue(long, long, long):long
      com.google.android.exoplayer2.util.Util.constrainValue(float, float, float):float */
    public void setVolume(float f) {
        verifyApplicationThread();
        float constrainValue = Util.constrainValue(f, 0.0f, 1.0f);
        if (this.audioVolume != constrainValue) {
            this.audioVolume = constrainValue;
            sendVolumeToRenderers();
            Iterator<AudioListener> it = this.audioListeners.iterator();
            while (it.hasNext()) {
                it.next().onVolumeChanged(constrainValue);
            }
        }
    }

    public float getVolume() {
        return this.audioVolume;
    }

    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    public void setSkipSilenceEnabled(boolean z) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled != z) {
            this.skipSilenceEnabled = z;
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 1) {
                    this.player.createMessage(renderer).setType(101).setPayload(Boolean.valueOf(z)).send();
                }
            }
            notifySkipSilenceEnabledChanged();
        }
    }

    @Deprecated
    public void setAudioStreamType(int i) {
        int audioUsageForStreamType = Util.getAudioUsageForStreamType(i);
        setAudioAttributes(new AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(Util.getAudioContentTypeForStreamType(i)).build());
    }

    @Deprecated
    public int getAudioStreamType() {
        return Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        verifyApplicationThread();
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        verifyApplicationThread();
        this.analyticsCollector.removeListener(analyticsListener);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            this.audioBecomingNoisyManager.setEnabled(z);
        }
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager2) {
        verifyApplicationThread();
        if (!Util.areEqual(this.priorityTaskManager, priorityTaskManager2)) {
            if (this.isPriorityTaskManagerRegistered) {
                ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            }
            if (priorityTaskManager2 == null || !isLoading()) {
                this.isPriorityTaskManagerRegistered = false;
            } else {
                priorityTaskManager2.add(0);
                this.isPriorityTaskManagerRegistered = true;
            }
            this.priorityTaskManager = priorityTaskManager2;
        }
    }

    @Deprecated
    public void setPlaybackParams(PlaybackParams playbackParams) {
        float f;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            f = playbackParams.getSpeed();
        } else {
            f = 1.0f;
        }
        setPlaybackSpeed(f);
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.add(videoListener);
    }

    public void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener2;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(6).setPayload(videoFrameMetadataListener2).send();
            }
        }
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener == videoFrameMetadataListener2) {
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 2) {
                    this.player.createMessage(renderer).setType(6).setPayload(null).send();
                }
            }
        }
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener2;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 5) {
                this.player.createMessage(renderer).setType(7).setPayload(cameraMotionListener2).send();
            }
        }
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        if (this.cameraMotionListener == cameraMotionListener2) {
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 5) {
                    this.player.createMessage(renderer).setType(7).setPayload(null).send();
                }
            }
        }
    }

    public boolean isSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    @Deprecated
    public void setVideoListener(VideoListener videoListener) {
        this.videoListeners.clear();
        if (videoListener != null) {
            addVideoListener(videoListener);
        }
    }

    @Deprecated
    public void clearVideoListener(VideoListener videoListener) {
        removeVideoListener(videoListener);
    }

    public void addTextOutput(TextOutput textOutput) {
        if (!this.currentCues.isEmpty()) {
            textOutput.onCues(this.currentCues);
        }
        this.textOutputs.add(textOutput);
    }

    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    @Deprecated
    public void setTextOutput(TextOutput textOutput) {
        this.textOutputs.clear();
        if (textOutput != null) {
            addTextOutput(textOutput);
        }
    }

    @Deprecated
    public void clearTextOutput(TextOutput textOutput) {
        removeTextOutput(textOutput);
    }

    public void addMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.add(metadataOutput);
    }

    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    @Deprecated
    public void setMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.retainAll(Collections.singleton(this.analyticsCollector));
        if (metadataOutput != null) {
            addMetadataOutput(metadataOutput);
        }
    }

    @Deprecated
    public void clearMetadataOutput(MetadataOutput metadataOutput) {
        removeMetadataOutput(metadataOutput);
    }

    @Deprecated
    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.retainAll(Collections.singleton(this.analyticsCollector));
        if (videoRendererEventListener != null) {
            addVideoDebugListener(videoRendererEventListener);
        }
    }

    @Deprecated
    public void addVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.add(videoRendererEventListener);
    }

    @Deprecated
    public void removeVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.remove(videoRendererEventListener);
    }

    @Deprecated
    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.retainAll(Collections.singleton(this.analyticsCollector));
        if (audioRendererEventListener != null) {
            addAudioDebugListener(audioRendererEventListener);
        }
    }

    @Deprecated
    public void addAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.add(audioRendererEventListener);
    }

    @Deprecated
    public void removeAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.remove(audioRendererEventListener);
    }

    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    public void addListener(Player.EventListener eventListener) {
        verifyApplicationThread();
        this.player.addListener(eventListener);
    }

    public void removeListener(Player.EventListener eventListener) {
        verifyApplicationThread();
        this.player.removeListener(eventListener);
    }

    public int getPlaybackState() {
        verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    @Deprecated
    public ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.player.getPlayerError();
    }

    @Deprecated
    public void retry() {
        verifyApplicationThread();
        prepare();
    }

    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        this.player.prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), z ? 0 : -1, -9223372036854775807L);
        prepare();
    }

    public void setMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list);
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list, z);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list, i, j);
    }

    public void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem);
    }

    public void setMediaItem(MediaItem mediaItem, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem, z);
    }

    public void setMediaItem(MediaItem mediaItem, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem, j);
    }

    public void setMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list);
    }

    public void setMediaSources(List<MediaSource> list, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list, z);
    }

    public void setMediaSources(List<MediaSource> list, int i, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list, i, j);
    }

    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource, z);
    }

    public void setMediaSource(MediaSource mediaSource, long j) {
        verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource, j);
    }

    public void addMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        this.player.addMediaItems(list);
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        verifyApplicationThread();
        this.player.addMediaItems(i, list);
    }

    public void addMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        this.player.addMediaItem(mediaItem);
    }

    public void addMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread();
        this.player.addMediaItem(i, mediaItem);
    }

    public void addMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(mediaSource);
    }

    public void addMediaSource(int i, MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(i, mediaSource);
    }

    public void addMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(list);
    }

    public void addMediaSources(int i, List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(i, list);
    }

    public void moveMediaItem(int i, int i2) {
        verifyApplicationThread();
        this.player.moveMediaItem(i, i2);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        this.player.moveMediaItems(i, i2, i3);
    }

    public void removeMediaItem(int i) {
        verifyApplicationThread();
        this.player.removeMediaItem(i);
    }

    public void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        this.player.removeMediaItems(i, i2);
    }

    public void clearMediaItems() {
        verifyApplicationThread();
        this.player.clearMediaItems();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        verifyApplicationThread();
        this.player.setShuffleOrder(shuffleOrder);
    }

    public void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(z, getPlaybackState());
        updatePlayWhenReady(z, updateAudioFocus, getPlayWhenReadyChangeReason(z, updateAudioFocus));
    }

    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    public void setPauseAtEndOfMediaItems(boolean z) {
        verifyApplicationThread();
        this.player.setPauseAtEndOfMediaItems(z);
    }

    public boolean getPauseAtEndOfMediaItems() {
        verifyApplicationThread();
        return this.player.getPauseAtEndOfMediaItems();
    }

    public int getRepeatMode() {
        verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    public void setRepeatMode(int i) {
        verifyApplicationThread();
        this.player.setRepeatMode(i);
    }

    public void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        this.player.setShuffleModeEnabled(z);
    }

    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    public boolean isLoading() {
        verifyApplicationThread();
        return this.player.isLoading();
    }

    public void seekTo(int i, long j) {
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(i, j);
    }

    @Deprecated
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters);
    }

    @Deprecated
    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    public void setPlaybackSpeed(float f) {
        verifyApplicationThread();
        this.player.setPlaybackSpeed(f);
    }

    public float getPlaybackSpeed() {
        verifyApplicationThread();
        return this.player.getPlaybackSpeed();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        verifyApplicationThread();
        this.player.setSeekParameters(seekParameters);
    }

    public SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    public void setForegroundMode(boolean z) {
        verifyApplicationThread();
        this.player.setForegroundMode(z);
    }

    public void stop(boolean z) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        this.player.stop(z);
        this.currentCues = Collections.emptyList();
    }

    public void release() {
        verifyApplicationThread();
        this.audioBecomingNoisyManager.setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        removeSurfaceCallbacks();
        Surface surface2 = this.surface;
        if (surface2 != null) {
            if (this.ownsSurface) {
                surface2.release();
            }
            this.surface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.bandwidthMeter.removeEventListener(this.analyticsCollector);
        this.currentCues = Collections.emptyList();
        this.playerReleased = true;
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        verifyApplicationThread();
        return this.player.createMessage(target);
    }

    public int getRendererCount() {
        verifyApplicationThread();
        return this.player.getRendererCount();
    }

    public int getRendererType(int i) {
        verifyApplicationThread();
        return this.player.getRendererType(i);
    }

    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    public long getDuration() {
        verifyApplicationThread();
        return this.player.getDuration();
    }

    public long getCurrentPosition() {
        verifyApplicationThread();
        return this.player.getCurrentPosition();
    }

    public long getBufferedPosition() {
        verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public long getContentPosition() {
        verifyApplicationThread();
        return this.player.getContentPosition();
    }

    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    @Deprecated
    public void setHandleWakeLock(boolean z) {
        setWakeMode(z ? 1 : 0);
    }

    public void setWakeMode(int i) {
        if (i == 0) {
            this.wakeLockManager.setEnabled(false);
            this.wifiLockManager.setEnabled(false);
        } else if (i == 1) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(false);
        } else if (i == 2) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(true);
        }
    }

    public void addDeviceListener(DeviceListener deviceListener) {
        this.deviceListeners.add(deviceListener);
    }

    public void removeDeviceListener(DeviceListener deviceListener) {
        this.deviceListeners.remove(deviceListener);
    }

    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    public int getDeviceVolume() {
        verifyApplicationThread();
        return this.streamVolumeManager.getVolume();
    }

    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return this.streamVolumeManager.isMuted();
    }

    public void setDeviceVolume(int i) {
        verifyApplicationThread();
        this.streamVolumeManager.setVolume(i);
    }

    public void increaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.increaseVolume();
    }

    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.decreaseVolume();
    }

    public void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        this.streamVolumeManager.setMuted(z);
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView2 = this.textureView;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() != this.componentListener) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    public void setVideoSurfaceInternal(Surface surface2, boolean z) {
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(surface2).send());
            }
        }
        Surface surface3 = this.surface;
        if (!(surface3 == null || surface3 == surface2)) {
            try {
                for (PlayerMessage blockUntilDelivered : arrayList) {
                    blockUntilDelivered.blockUntilDelivered();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface2;
        this.ownsSurface = z;
    }

    private void setVideoDecoderOutputBufferRendererInternal(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer2) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(8).setPayload(videoDecoderOutputBufferRenderer2).send();
            }
        }
        this.videoDecoderOutputBufferRenderer = videoDecoderOutputBufferRenderer2;
    }

    public void maybeNotifySurfaceSizeChanged(int i, int i2) {
        if (i != this.surfaceWidth || i2 != this.surfaceHeight) {
            this.surfaceWidth = i;
            this.surfaceHeight = i2;
            Iterator<com.google.android.exoplayer2.video.VideoListener> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                it.next().onSurfaceSizeChanged(i, i2);
            }
        }
    }

    public void sendVolumeToRenderers() {
        float volumeMultiplier = this.audioVolume * this.audioFocusManager.getVolumeMultiplier();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(2).setPayload(Float.valueOf(volumeMultiplier)).send();
            }
        }
    }

    public void notifyAudioSessionIdSet() {
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            AudioListener next = it.next();
            if (!this.audioDebugListeners.contains(next)) {
                next.onAudioSessionId(this.audioSessionId);
            }
        }
        Iterator<AudioRendererEventListener> it2 = this.audioDebugListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onAudioSessionId(this.audioSessionId);
        }
    }

    public void notifySkipSilenceEnabledChanged() {
        Iterator<AudioListener> it = this.audioListeners.iterator();
        while (it.hasNext()) {
            AudioListener next = it.next();
            if (!this.audioDebugListeners.contains(next)) {
                next.onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
            }
        }
        Iterator<AudioRendererEventListener> it2 = this.audioDebugListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        }
    }

    public void updatePlayWhenReady(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        this.player.setPlayWhenReady(z2, i3, i2);
    }

    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.wakeLockManager.setStayAwake(getPlayWhenReady());
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != getApplicationLooper()) {
            Log.w("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException());
            this.hasNotifiedFullWrongThreadWarning = true;
        }
    }

    public static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager2) {
        return new DeviceInfo(0, streamVolumeManager2.getMinVolume(), streamVolumeManager2.getMaxVolume());
    }

    final class ComponentListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioBecomingNoisyManager.EventListener, AudioFocusManager.PlayerControl, Player.EventListener, StreamVolumeManager.Listener, AudioRendererEventListener, MetadataOutput, TextOutput, VideoRendererEventListener {
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        @Deprecated
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackSpeedChanged(float f) {
            Player.EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        @Deprecated
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i) {
            Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        @Deprecated
        public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        private ComponentListener() {
        }

        public final void onVideoEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.videoDecoderCounters = decoderCounters;
            Iterator<VideoRendererEventListener> it = simpleExoPlayer.videoDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoEnabled(decoderCounters);
            }
        }

        public final void onVideoDecoderInitialized(String str, long j, long j2) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoDecoderInitialized(str, j, j2);
            }
        }

        public final void onVideoInputFormatChanged(Format format) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.videoFormat = format;
            Iterator<VideoRendererEventListener> it = simpleExoPlayer.videoDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoInputFormatChanged(format);
            }
        }

        public final void onDroppedFrames(int i, long j) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onDroppedFrames(i, j);
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Iterator<com.google.android.exoplayer2.video.VideoListener> it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.video.VideoListener next = it.next();
                if (!SimpleExoPlayer.this.videoDebugListeners.contains(next)) {
                    next.onVideoSizeChanged(i, i2, i3, f);
                }
            }
            Iterator<VideoRendererEventListener> it2 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onVideoSizeChanged(i, i2, i3, f);
            }
        }

        public final void onRenderedFirstFrame(Surface surface) {
            if (SimpleExoPlayer.this.surface == surface) {
                Iterator<com.google.android.exoplayer2.video.VideoListener> it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    it.next().onRenderedFirstFrame();
                }
            }
            Iterator<VideoRendererEventListener> it2 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onRenderedFirstFrame(surface);
            }
        }

        public final void onVideoDisabled(DecoderCounters decoderCounters) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoDisabled(decoderCounters);
            }
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.videoFormat = null;
            simpleExoPlayer.videoDecoderCounters = null;
        }

        public final void onVideoFrameProcessingOffset(long j, int i, Format format) {
            Iterator<VideoRendererEventListener> it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoFrameProcessingOffset(j, i, format);
            }
        }

        public final void onAudioEnabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.audioDecoderCounters = decoderCounters;
            Iterator<AudioRendererEventListener> it = simpleExoPlayer.audioDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioEnabled(decoderCounters);
            }
        }

        public final void onAudioSessionId(int i) {
            if (SimpleExoPlayer.this.audioSessionId != i) {
                SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
                simpleExoPlayer.audioSessionId = i;
                simpleExoPlayer.notifyAudioSessionIdSet();
            }
        }

        public final void onAudioDecoderInitialized(String str, long j, long j2) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioDecoderInitialized(str, j, j2);
            }
        }

        public final void onAudioInputFormatChanged(Format format) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.audioFormat = format;
            Iterator<AudioRendererEventListener> it = simpleExoPlayer.audioDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioInputFormatChanged(format);
            }
        }

        public final void onAudioSinkUnderrun(int i, long j, long j2) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioSinkUnderrun(i, j, j2);
            }
        }

        public final void onAudioDisabled(DecoderCounters decoderCounters) {
            Iterator<AudioRendererEventListener> it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioDisabled(decoderCounters);
            }
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.audioFormat = null;
            simpleExoPlayer.audioDecoderCounters = null;
            simpleExoPlayer.audioSessionId = 0;
        }

        public final void onSkipSilenceEnabledChanged(boolean z) {
            if (SimpleExoPlayer.this.skipSilenceEnabled != z) {
                SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
                simpleExoPlayer.skipSilenceEnabled = z;
                simpleExoPlayer.notifySkipSilenceEnabledChanged();
            }
        }

        public final void onCues(List<Cue> list) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.currentCues = list;
            Iterator<TextOutput> it = simpleExoPlayer.textOutputs.iterator();
            while (it.hasNext()) {
                it.next().onCues(list);
            }
        }

        public final void onMetadata(Metadata metadata) {
            Iterator<MetadataOutput> it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                it.next().onMetadata(metadata);
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i2, i3);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i, i2);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        public final void setVolumeMultiplier(float f) {
            SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        public final void executePlayerCommand(int i) {
            boolean playWhenReady = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.updatePlayWhenReady(playWhenReady, i, SimpleExoPlayer.getPlayWhenReadyChangeReason(playWhenReady, i));
        }

        public final void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.updatePlayWhenReady(false, -1, 3);
        }

        public final void onStreamTypeChanged(int i) {
            DeviceInfo createDeviceInfo = SimpleExoPlayer.createDeviceInfo(SimpleExoPlayer.this.streamVolumeManager);
            if (!createDeviceInfo.equals(SimpleExoPlayer.this.deviceInfo)) {
                SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
                simpleExoPlayer.deviceInfo = createDeviceInfo;
                Iterator<DeviceListener> it = simpleExoPlayer.deviceListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDeviceInfoChanged(createDeviceInfo);
                }
            }
        }

        public final void onStreamVolumeChanged(int i, boolean z) {
            Iterator<DeviceListener> it = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it.hasNext()) {
                it.next().onDeviceVolumeChanged(i, z);
            }
        }

        public final void onIsLoadingChanged(boolean z) {
            if (SimpleExoPlayer.this.priorityTaskManager == null) {
                return;
            }
            if (z && !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                SimpleExoPlayer.this.priorityTaskManager.add(0);
                SimpleExoPlayer.this.isPriorityTaskManagerRegistered = true;
            } else if (!z && SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                SimpleExoPlayer.this.priorityTaskManager.remove(0);
                SimpleExoPlayer.this.isPriorityTaskManagerRegistered = false;
            }
        }

        public final void onPlaybackStateChanged(int i) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        public final void onPlayWhenReadyChanged(boolean z, int i) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }
    }
}
