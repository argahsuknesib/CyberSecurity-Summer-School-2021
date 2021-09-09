package com.mijia.generalplayer.exo;

import _m_j.ckb;
import _m_j.ckc;
import _m_j.cki;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.mijia.generalplayer.exo.MJExoPlayerViewP;
import java.util.Map;

public class GeneralExoPlayer implements ckc {

    /* renamed from: O000000o  reason: collision with root package name */
    public SimpleExoPlayer f5189O000000o;
    public ckb.O00000Oo O00000Oo;
    int O00000o = 1;
    public boolean O00000o0;
    public boolean O00000oO = false;
    public ckb.O000000o O00000oo;
    MediaSource O0000O0o;
    private MJExoPlayerViewP O0000OOo;
    private Context O0000Oo0;

    public final void O00000Oo(long j) {
    }

    public GeneralExoPlayer(Context context) {
        this.O0000Oo0 = context;
        this.O0000OOo = new MJExoPlayerViewP(context);
        O000000o();
    }

    public final void O000000o() {
        SimpleExoPlayer simpleExoPlayer = this.f5189O000000o;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
        }
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter()));
        MJExoRenderersFactory mJExoRenderersFactory = new MJExoRenderersFactory(this.O0000Oo0);
        if (this.O00000oO) {
            mJExoRenderersFactory.f5194O000000o = true;
        }
        this.f5189O000000o = ExoPlayerFactory.newSimpleInstance(this.O0000Oo0, mJExoRenderersFactory, defaultTrackSelector);
        this.O0000OOo.setPlayer(this.f5189O000000o);
    }

    public final View O00000Oo() {
        return this.O0000OOo;
    }

    public final View O00000o0() {
        return this.O0000OOo.getVideoSurfaceView();
    }

    public final void O000000o(final ckb.O000000o o000000o) {
        this.O00000oo = o000000o;
        this.O0000OOo.setPlayerViewListener(new MJExoPlayerViewP.O00000o0() {
            /* class com.mijia.generalplayer.exo.GeneralExoPlayer.AnonymousClass1 */

            public final void O000000o(int i, int i2, int i3, float f) {
                cki.O00000o("GeneralExoPlayer", "onVideoSizeChanged:" + i + " height:" + i2);
                if (GeneralExoPlayer.this.O00000oo != null) {
                    o000000o.onVideoSizeChanged(i, i2, i3, f);
                }
            }

            public final void O000000o() {
                cki.O00000o("GeneralExoPlayer", "onRenderedFirstFrame");
                if (GeneralExoPlayer.this.O00000Oo != null) {
                    GeneralExoPlayer.this.O00000Oo.onPrepared();
                }
            }
        });
        this.O0000OOo.getVideoSurfaceView().setOnClickListener(new View.OnClickListener(o000000o) {
            /* class com.mijia.generalplayer.exo.$$Lambda$GeneralExoPlayer$acD5F8E3QnsUIJOFoh49GpvpiQ8 */
            private final /* synthetic */ ckb.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                GeneralExoPlayer.this.O000000o(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ckb.O000000o o000000o, View view) {
        if (this.O00000oo != null) {
            o000000o.onRenderViewClicked(view);
        }
    }

    public final void O000000o(float f) {
        this.f5189O000000o.setVolume(f);
    }

    public final long O00000o() {
        return this.f5189O000000o.getDuration();
    }

    public final void O000000o(long j) {
        this.f5189O000000o.seekTo(j);
    }

    public final Bitmap O00000oO() {
        if (this.O0000OOo.getVideoSurfaceView() instanceof TextureView) {
            return ((TextureView) this.O0000OOo.getVideoSurfaceView()).getBitmap();
        }
        return null;
    }

    public final void O00000oo() {
        this.f5189O000000o.setPlayWhenReady(false);
        this.f5189O000000o.stop();
    }

    public final void O000000o(String str, Map<String, String> map) {
        MediaSource mediaSource;
        Context context = this.O0000Oo0;
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getScheme()) && (parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
            DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory(Util.getUserAgent(context, "SmartHome;Android"), new DefaultBandwidthMeter());
            if (map != null && map.size() > 0) {
                for (Map.Entry next : map.entrySet()) {
                    defaultHttpDataSourceFactory.setDefaultRequestProperty(((String) next.getKey()), ((String) next.getValue()));
                }
            }
            if (parse.getPath() == null || !parse.getPath().endsWith("mp4")) {
                mediaSource = new HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(parse);
            } else {
                mediaSource = new ExtractorMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(parse);
            }
        } else if (str.endsWith("m3u8")) {
            mediaSource = new HlsMediaSource.Factory(new FileDataSourceFactory()).createMediaSource(parse);
        } else {
            mediaSource = new ExtractorMediaSource.Factory(new FileDataSourceFactory()).createMediaSource(parse);
        }
        this.O0000O0o = mediaSource;
        this.f5189O000000o.prepare(this.O0000O0o);
        this.f5189O000000o.setPlaybackParameters(new PlaybackParameters((float) this.O00000o));
    }

    public final void O000000o(int i) {
        this.O00000o = i;
        this.f5189O000000o.setPlaybackParameters(new PlaybackParameters((float) i));
    }

    public final long O0000O0o() {
        return this.f5189O000000o.getCurrentPosition();
    }

    public final void O0000OOo() {
        this.f5189O000000o.setPlayWhenReady(false);
    }

    public final void O0000Oo0() {
        this.f5189O000000o.setPlayWhenReady(true);
    }

    public final void O000000o(final ckb.O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
        this.f5189O000000o.addListener(new Player.EventListener() {
            /* class com.mijia.generalplayer.exo.GeneralExoPlayer.AnonymousClass2 */

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

            public final void onTimelineChanged(Timeline timeline, Object obj, int i) {
                cki.O00000o("GeneralExoPlayer", "onTimelineChanged:".concat(String.valueOf(i)));
            }

            public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                cki.O00000o("GeneralExoPlayer", "onTracksChanged");
            }

            public final void onLoadingChanged(boolean z) {
                o00000Oo.onLoadingChanged(z);
                cki.O00000o("GeneralExoPlayer", "onLoadingChanged:".concat(String.valueOf(z)));
            }

            public final void onPlayerStateChanged(boolean z, int i) {
                int i2;
                if (i == 1) {
                    i2 = ckb.f13961O000000o;
                } else if (i == 2) {
                    i2 = ckb.O00000Oo;
                } else if (i != 4) {
                    i2 = ckb.O00000o0;
                } else {
                    i2 = ckb.O00000o;
                }
                o00000Oo.onPlayerStateChanged(i2);
                if (GeneralExoPlayer.this.O00000o0 != z) {
                    GeneralExoPlayer generalExoPlayer = GeneralExoPlayer.this;
                    generalExoPlayer.O00000o0 = z;
                    o00000Oo.isPlayingChanged(generalExoPlayer.O00000o0);
                }
                cki.O00000o("GeneralExoPlayer", "onPlayerStateChanged:" + z + " playbackState:" + i);
            }

            public final void onRepeatModeChanged(int i) {
                cki.O00000o("GeneralExoPlayer", "onRepeatModeChanged:".concat(String.valueOf(i)));
            }

            public final void onShuffleModeEnabledChanged(boolean z) {
                cki.O00000o("GeneralExoPlayer", "onShuffleModeEnabledChanged:".concat(String.valueOf(z)));
            }

            public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
                String str;
                if (exoPlaybackException != null) {
                    str = exoPlaybackException.toString();
                    cki.O00000o("GeneralExoPlayer", "onPlayerError:" + exoPlaybackException.getLocalizedMessage() + exoPlaybackException.type + " error:" + exoPlaybackException.toString());
                } else {
                    str = null;
                }
                if (exoPlaybackException != null) {
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("source error")) {
                        long currentPosition = GeneralExoPlayer.this.f5189O000000o.getCurrentPosition() + 3000;
                        if (currentPosition < GeneralExoPlayer.this.f5189O000000o.getDuration()) {
                            GeneralExoPlayer.this.O000000o();
                            GeneralExoPlayer generalExoPlayer = GeneralExoPlayer.this;
                            if (generalExoPlayer.O0000O0o != null) {
                                generalExoPlayer.O000000o(generalExoPlayer.O00000Oo);
                                generalExoPlayer.f5189O000000o.prepare(generalExoPlayer.O0000O0o);
                                generalExoPlayer.f5189O000000o.setPlaybackParameters(new PlaybackParameters((float) generalExoPlayer.O00000o));
                                generalExoPlayer.f5189O000000o.seekTo(currentPosition);
                                generalExoPlayer.O0000Oo0();
                                return;
                            }
                            return;
                        }
                    } else if (exoPlaybackException.type != 1 || GeneralExoPlayer.this.O00000oO || !(exoPlaybackException.getRendererException() instanceof MediaCodecRenderer.DecoderInitializationException)) {
                        exoPlaybackException.printStackTrace();
                        cki.O00000oO("GeneralExoPlayer", "Exception:" + exoPlaybackException.getLocalizedMessage());
                    } else {
                        cki.O00000o("GeneralExoPlayer", "DecoderInitializationException and trans to soft decoder");
                        GeneralExoPlayer generalExoPlayer2 = GeneralExoPlayer.this;
                        generalExoPlayer2.O00000oO = true;
                        generalExoPlayer2.O000000o();
                        GeneralExoPlayer generalExoPlayer3 = GeneralExoPlayer.this;
                        if (generalExoPlayer3.O0000O0o != null) {
                            generalExoPlayer3.O000000o(generalExoPlayer3.O00000Oo);
                            generalExoPlayer3.f5189O000000o.prepare(generalExoPlayer3.O0000O0o);
                            generalExoPlayer3.f5189O000000o.setPlaybackParameters(new PlaybackParameters((float) generalExoPlayer3.O00000o));
                            generalExoPlayer3.O0000Oo0();
                        }
                    }
                }
                o00000Oo.onPlayerError(str);
            }

            public final void onPositionDiscontinuity(int i) {
                cki.O00000o("GeneralExoPlayer", "onPositionDiscontinuity:".concat(String.valueOf(i)));
            }

            public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                cki.O00000o("GeneralExoPlayer", "onPlaybackParametersChanged:" + playbackParameters.speed);
            }

            public final void onSeekProcessed() {
                cki.O00000o("GeneralExoPlayer", "onSeekProcessed");
            }
        });
    }

    public final void O0000Oo() {
        this.f5189O000000o.release();
    }

    public final boolean O0000OoO() {
        return this.O00000o0;
    }
}
