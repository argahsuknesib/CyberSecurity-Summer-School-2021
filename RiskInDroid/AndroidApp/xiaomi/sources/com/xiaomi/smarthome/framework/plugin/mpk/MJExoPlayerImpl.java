package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.cki;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.mijia.generalplayer.exo.MJExoPlayerViewP;
import com.mijia.generalplayer.exo.MJExoRenderersFactory;
import com.xiaomi.smarthome.camera.exopackage.MJExoPlayer;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.HashMap;
import java.util.Map;

public class MJExoPlayerImpl implements MJExoPlayer {
    private Context context;
    private boolean init;
    private ViewGroup mViewGroup;
    private MJExoPlayerViewP mjExoPlayerView;
    public MJExoPlayer.MJExoPlayerListener playerListener;
    private SimpleExoPlayer simpleExoPlayer;

    public MJExoPlayerImpl(Context context2, ViewGroup viewGroup, AttributeSet attributeSet, int i) {
        this.mjExoPlayerView = new MJExoPlayerViewP(context2, attributeSet, i);
        this.context = context2;
        this.mViewGroup = viewGroup;
    }

    private void init(Context context2, ViewGroup viewGroup) {
        this.simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context2, new MJExoRenderersFactory(context2), new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter())));
        this.mjExoPlayerView.setPlayer(this.simpleExoPlayer);
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.addListener(new Player.EventListener() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.MJExoPlayerImpl.AnonymousClass1 */

                public /* synthetic */ void onIsLoadingChanged(boolean z) {
                    Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
                }

                public /* synthetic */ void onIsPlayingChanged(boolean z) {
                    Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
                }

                public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                    Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
                }

                public /* synthetic */ void onPlaybackSpeedChanged(float f) {
                    Player.EventListener.CC.$default$onPlaybackSpeedChanged(this, f);
                }

                public /* synthetic */ void onPlaybackStateChanged(int i) {
                    Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
                }

                public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                    Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                }

                public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                    Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
                }

                public void onTimelineChanged(Timeline timeline, Object obj, int i) {
                    cki.O00000o("MJExoPlayerImpl", "onTimelineChanged:".concat(String.valueOf(i)));
                }

                public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                    cki.O00000o("MJExoPlayerImpl", "onTracksChanged");
                }

                public void onLoadingChanged(boolean z) {
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onLoadingChanged(z);
                    }
                    cki.O00000o("MJExoPlayerImpl", "onLoadingChanged:".concat(String.valueOf(z)));
                }

                public void onPlayerStateChanged(boolean z, int i) {
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onPlayerStateChanged(z, i);
                    }
                    cki.O00000o0("MJExoPlayerImpl", "onPlayerStateChanged: %b,%d", Boolean.valueOf(z), Integer.valueOf(i));
                }

                public void onRepeatModeChanged(int i) {
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onRepeatModeChanged(i);
                    }
                    cki.O00000o("MJExoPlayerImpl", "onRepeatModeChanged:".concat(String.valueOf(i)));
                }

                public void onShuffleModeEnabledChanged(boolean z) {
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onShuffleModeEnabledChanged(z);
                    }
                    cki.O00000o("MJExoPlayerImpl", "onShuffleModeEnabledChanged:".concat(String.valueOf(z)));
                }

                public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                    cki.O00000o("MJExoPlayerImpl", "onPlayerError:".concat(String.valueOf(exoPlaybackException)));
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onPlayerError(exoPlaybackException.type);
                    }
                }

                public void onPositionDiscontinuity(int i) {
                    cki.O00000o("MJExoPlayerImpl", "onPositionDiscontinuity:".concat(String.valueOf(i)));
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onPositionDiscontinuity(i);
                    }
                }

                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    cki.O00000o("MJExoPlayerImpl", "onPlaybackParametersChanged:" + playbackParameters.speed);
                    if (MJExoPlayerImpl.this.playerListener != null && playbackParameters != null) {
                        MJExoPlayerImpl.this.playerListener.onPlaybackParametersChanged(playbackParameters.speed);
                    }
                }

                public void onSeekProcessed() {
                    cki.O00000o("MJExoPlayerImpl", "onSeekProcessed");
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onSeekProcessed();
                    }
                }
            });
        } else {
            cki.O00000oO("MJExoPlayerImpl", "simpleExoPlayer null");
        }
        MJExoPlayerViewP mJExoPlayerViewP = this.mjExoPlayerView;
        if (mJExoPlayerViewP != null && (viewGroup instanceof FrameLayout)) {
            viewGroup.addView(mJExoPlayerViewP, -1, -1);
        }
        MJExoPlayerViewP mJExoPlayerViewP2 = this.mjExoPlayerView;
        if (!(mJExoPlayerViewP2 == null || mJExoPlayerViewP2.getVideoSurfaceView() == null)) {
            this.mjExoPlayerView.getVideoSurfaceView().setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.MJExoPlayerImpl.AnonymousClass2 */

                public void onClick(View view) {
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onVideoSurfaceViewClicked(view);
                    }
                }
            });
            this.mjExoPlayerView.getVideoSurfaceView().setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.MJExoPlayerImpl.AnonymousClass3 */

                public boolean onLongClick(View view) {
                    if (MJExoPlayerImpl.this.playerListener == null) {
                        return false;
                    }
                    MJExoPlayerImpl.this.playerListener.onVideoSurfaceViewLongClicked(view);
                    return true;
                }
            });
        }
        MJExoPlayerViewP mJExoPlayerViewP3 = this.mjExoPlayerView;
        if (mJExoPlayerViewP3 != null) {
            mJExoPlayerViewP3.setExoPlayerBridgeListener(new MJExoPlayerViewP.O00000Oo() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.MJExoPlayerImpl.AnonymousClass4 */

                public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                    cki.O00000o0("MJExoPlayerImpl", "onVideoSizeChanged width:%d,height:%d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onVideoSizeChanged(i, i2, i3, f);
                    }
                }

                public void onRenderedFirstFrame() {
                    cki.O00000o("MJExoPlayerImpl", "onRenderedFirstFrame");
                    if (MJExoPlayerImpl.this.playerListener != null) {
                        MJExoPlayerImpl.this.playerListener.onRenderedFirstFrame();
                    }
                }
            });
        }
    }

    private MediaSource buildMediaSource(Context context2, String str, Map<String, String> map) {
        if (context2 != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Uri parse = Uri.parse(str);
                    if (!TextUtils.isEmpty(parse.getScheme()) && (parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
                        return buildMediaSourceHTTP(context2, parse, map);
                    }
                    if (parse == null || !parse.getPath().endsWith(".m3u8")) {
                        return buildMediaSourceLocal(context2, parse);
                    }
                    return buildMediaSourceLocalM3U8(parse);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private HlsMediaSource buildMediaSourceHTTP(Context context2, Uri uri, Map<String, String> map) {
        DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory(Util.getUserAgent(context2, "SmartHome;Android"), new DefaultBandwidthMeter());
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                defaultHttpDataSourceFactory.setDefaultRequestProperty(((String) next.getKey()), ((String) next.getValue()));
            }
        }
        return new HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(uri);
    }

    private HlsMediaSource buildMediaSourceLocalM3U8(Uri uri) {
        return new HlsMediaSource.Factory(new FileDataSourceFactory()).createMediaSource(uri);
    }

    private MediaSource buildMediaSourceLocal(Context context2, Uri uri) {
        return new ExtractorMediaSource(uri, new DefaultDataSourceFactory(context2, "SmartHome;Android"), new DefaultExtractorsFactory(), null, null);
    }

    public void setPlayerListener(MJExoPlayer.MJExoPlayerListener mJExoPlayerListener) {
        this.playerListener = mJExoPlayerListener;
    }

    public MJExoPlayer.MJExoPlayerListener getPlayerListener() {
        return this.playerListener;
    }

    public void startPlay(String str) {
        cki.O00000o0("MJExoPlayerImpl", "startPlay:%s", str);
        HashMap hashMap = new HashMap();
        MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
        if (!this.init) {
            init(this.context, this.mViewGroup);
            this.init = true;
        }
        if (tokenInfo != null && this.mjExoPlayerView != null && this.simpleExoPlayer != null) {
            hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
            this.simpleExoPlayer.prepare(buildMediaSource(this.context, str, hashMap));
            this.simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public void pausePlay() {
        cki.O00000o("MJExoPlayerImpl", "pausePlay");
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setPlayWhenReady(false);
        }
    }

    public void stopPlay() {
        cki.O00000o("MJExoPlayerImpl", "stopPlay");
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.stop();
        }
    }

    public void resumePlay() {
        cki.O00000o("MJExoPlayerImpl", "resumePlay");
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setPlayWhenReady(true);
        }
    }

    public void seekTo(long j) {
        cki.O00000o0("MJExoPlayerImpl", "seekTo %d", Long.valueOf(j));
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.seekTo(j);
        }
    }

    public int getBufferedPercentage() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getBufferedPercentage();
        }
        return 0;
    }

    public long getBufferedPosition() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getBufferedPosition();
        }
        return 0;
    }

    public long getCurrentPosition() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getCurrentPosition();
        }
        return 0;
    }

    public long getDuration() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getDuration();
        }
        return 0;
    }

    public boolean getPlayWhenReady() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 == null) {
            return false;
        }
        boolean playWhenReady = simpleExoPlayer2.getPlayWhenReady();
        cki.O00000o0("MJExoPlayerImpl", "getPlayWhenReady:%b", Boolean.valueOf(playWhenReady));
        return playWhenReady;
    }

    public int getVideoScalingMode() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getVideoScalingMode();
        }
        return 0;
    }

    public float getVolume() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getVolume();
        }
        return 0.0f;
    }

    public void setVolume(float f) {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setVolume(f);
        }
    }

    public boolean isLoading() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.isLoading();
        }
        return false;
    }

    public void setPlayWhenReady(boolean z) {
        cki.O00000o0("MJExoPlayerImpl", "setPlayWhenReady:%b", Boolean.valueOf(z));
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setPlayWhenReady(z);
        }
    }

    public int getPlaybackState() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null) {
            return simpleExoPlayer2.getPlaybackState();
        }
        return 0;
    }

    public float getPlaybackSpeed() {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 == null || simpleExoPlayer2.getPlaybackParameters() == null) {
            return 0.0f;
        }
        return this.simpleExoPlayer.getPlaybackParameters().speed;
    }

    public void setPlaybackSpeed(float f) {
        SimpleExoPlayer simpleExoPlayer2 = this.simpleExoPlayer;
        if (simpleExoPlayer2 != null && f > 0.0f) {
            simpleExoPlayer2.setPlaybackParameters(new PlaybackParameters(f));
        }
    }

    public Bitmap snapshot() {
        MJExoPlayerViewP mJExoPlayerViewP = this.mjExoPlayerView;
        if (mJExoPlayerViewP == null || mJExoPlayerViewP.getVideoSurfaceView() == null || !(this.mjExoPlayerView.getVideoSurfaceView() instanceof TextureView)) {
            return null;
        }
        return ((TextureView) this.mjExoPlayerView.getVideoSurfaceView()).getBitmap();
    }
}
