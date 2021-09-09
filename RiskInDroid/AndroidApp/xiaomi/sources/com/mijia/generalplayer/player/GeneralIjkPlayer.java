package com.mijia.generalplayer.player;

import _m_j.ckb;
import _m_j.ckc;
import _m_j.cki;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.mijia.generalplayer.ijk.IjkVideoView;
import com.mijia.generalplayer.ijk.TextureRenderView;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class GeneralIjkPlayer implements ckc, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public ckb.O000000o f5218O000000o;
    public ckb.O00000Oo O00000Oo;
    private IjkVideoView.O000000o O00000o;
    private IjkVideoView O00000o0;

    public GeneralIjkPlayer(Context context) {
        this(context, 2);
    }

    public GeneralIjkPlayer(Context context, int i) {
        this.O00000o = new IjkVideoView.O000000o() {
            /* class com.mijia.generalplayer.player.GeneralIjkPlayer.AnonymousClass1 */

            public final void O000000o(int i, int i2, int i3, int i4) {
                if (GeneralIjkPlayer.this.f5218O000000o != null) {
                    GeneralIjkPlayer.this.f5218O000000o.onVideoSizeChanged(i, i2, i3, (float) i4);
                }
            }

            public final void O000000o(View view) {
                if (GeneralIjkPlayer.this.f5218O000000o != null) {
                    GeneralIjkPlayer.this.f5218O000000o.onRenderViewClicked(view);
                }
            }

            public final void O000000o() {
                if (GeneralIjkPlayer.this.O00000Oo != null) {
                    GeneralIjkPlayer.this.O00000Oo.isPlayingChanged(true);
                }
            }

            public final void O00000Oo() {
                if (GeneralIjkPlayer.this.O00000Oo != null) {
                    GeneralIjkPlayer.this.O00000Oo.isPlayingChanged(false);
                }
            }
        };
        this.O00000o0 = new IjkVideoView(context, i);
        this.O00000o0.setOnInfoListener(this);
        this.O00000o0.setOnErrorListener(this);
        this.O00000o0.setOnCompletionListener(this);
        this.O00000o0.setOnPreparedListener(this);
        this.O00000o0.f5203O000000o = this.O00000o;
    }

    public final View O00000Oo() {
        return this.O00000o0;
    }

    public final View O00000o0() {
        return this.O00000o0.getRenderView().getView();
    }

    public final void O000000o(ckb.O000000o o000000o) {
        this.f5218O000000o = o000000o;
    }

    public final void O000000o(float f) {
        this.O00000o0.O00000Oo(f == 0.0f);
    }

    public final long O00000o() {
        return (long) this.O00000o0.getDuration();
    }

    public final void O000000o(long j) {
        this.O00000o0.seekTo((int) j);
    }

    public final Bitmap O00000oO() {
        IjkVideoView ijkVideoView = this.O00000o0;
        if (ijkVideoView.O0000o == null || !(ijkVideoView.O0000o instanceof TextureRenderView)) {
            return null;
        }
        return ((TextureRenderView) ijkVideoView.O0000o.getView()).getBitmap();
    }

    public final void O00000oo() {
        this.O00000o0.O000000o();
    }

    public final void O000000o(String str, Map<String, String> map) {
        this.O00000o0.O000000o(Uri.parse(str), map);
    }

    public final void O000000o(int i) {
        this.O00000o0.setSpeed(i);
    }

    public final long O0000O0o() {
        return (long) this.O00000o0.getCurrentPosition();
    }

    public final void O0000OOo() {
        this.O00000o0.pause();
    }

    public final void O0000Oo0() {
        this.O00000o0.start();
    }

    public final void O000000o(ckb.O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    public final void O0000Oo() {
        this.O00000o0.O000000o(true);
    }

    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
        if (i != 3) {
            if (i == 10002) {
                cki.O00000o("GeneralIjkPlayer", "MEDIA_INFO_AUDIO_RENDERING_START");
            } else if (i != 10008) {
                if (i == 701) {
                    cki.O00000o("GeneralIjkPlayer", "MEDIA_INFO_BUFFERING_START");
                    ckb.O00000Oo o00000Oo = this.O00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onLoadingChanged(true);
                    }
                } else if (i == 702) {
                    cki.O00000o("GeneralIjkPlayer", "MEDIA_INFO_BUFFERING_END");
                    ckb.O00000Oo o00000Oo2 = this.O00000Oo;
                    if (o00000Oo2 != null) {
                        o00000Oo2.onLoadingChanged(false);
                    }
                }
            }
            return false;
        }
        ckb.O00000Oo o00000Oo3 = this.O00000Oo;
        if (o00000Oo3 != null) {
            o00000Oo3.onPlayerStateChanged(ckb.O00000o0);
        }
        cki.O00000o("GeneralIjkPlayer", "MEDIA_INFO_VIDEO_RENDERING_START");
        return false;
    }

    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
        cki.O00000oO("GeneralIjkPlayer", "onError" + i + ":" + i2);
        cki.O0000OOo("2000.6.1", "onError" + i + ":" + i2);
        ckb.O00000Oo o00000Oo = this.O00000Oo;
        if (o00000Oo == null) {
            return false;
        }
        o00000Oo.onPlayerError("GeneralIjkPlayer" + i + ":" + i2);
        return false;
    }

    public void onCompletion(IMediaPlayer iMediaPlayer) {
        ckb.O00000Oo o00000Oo = this.O00000Oo;
        if (o00000Oo != null) {
            o00000Oo.onPlayerStateChanged(ckb.O00000o);
        }
    }

    public void onPrepared(IMediaPlayer iMediaPlayer) {
        ckb.O00000Oo o00000Oo = this.O00000Oo;
        if (o00000Oo != null) {
            o00000Oo.onPrepared();
        }
        ckb.O00000Oo o00000Oo2 = this.O00000Oo;
        if (o00000Oo2 != null) {
            o00000Oo2.isPlayingChanged(true);
        }
    }

    public final boolean O0000OoO() {
        return this.O00000o0.isPlaying();
    }

    public final void O00000Oo(long j) {
        this.O00000o0.setStartSeekTime(j);
    }
}
