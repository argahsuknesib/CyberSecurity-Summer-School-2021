package com.mijia.generalplayer.ijk;

import _m_j.cjy;
import _m_j.ckh;
import _m_j.cki;
import _m_j.ckl;
import _m_j.frx;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import com.xiaomi.smarthome.fastvideo.decoder.MediaCodecUtil;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static final int[] O000OOo0 = {0, 1, 2, 4, 5};
    private static final String[] O000OOoo = {"vangogh"};

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f5203O000000o;
    public int O00000Oo = 0;
    public cjy.O00000Oo O00000o = null;
    public int O00000o0 = 0;
    public IMediaPlayer O00000oO = null;
    public int O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public int O0000Oo0;
    public IMediaPlayer.OnCompletionListener O0000OoO;
    public IMediaPlayer.OnPreparedListener O0000Ooo;
    public cjy O0000o;
    public IMediaPlayer.OnErrorListener O0000o0;
    public int O0000o00;
    public IMediaPlayer.OnInfoListener O0000o0O;
    public int O0000o0o;
    public int O0000oO;
    public int O0000oO0;
    Runnable O0000oOO = new Runnable() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass1 */

        public final void run() {
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.measure(View.MeasureSpec.makeMeasureSpec(ijkVideoView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(IjkVideoView.this.getHeight(), 1073741824));
            IjkVideoView ijkVideoView2 = IjkVideoView.this;
            ijkVideoView2.layout(ijkVideoView2.getLeft(), IjkVideoView.this.getTop(), IjkVideoView.this.getRight(), IjkVideoView.this.getBottom());
        }
    };
    IMediaPlayer.OnVideoSizeChangedListener O0000oOo = new IMediaPlayer.OnVideoSizeChangedListener() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass2 */

        public final void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            IjkVideoView.this.O00000oo = iMediaPlayer.getVideoWidth();
            IjkVideoView.this.O0000O0o = iMediaPlayer.getVideoHeight();
            IjkVideoView.this.O0000oO0 = iMediaPlayer.getVideoSarNum();
            IjkVideoView.this.O0000oO = iMediaPlayer.getVideoSarDen();
            IjkVideoView.this.O00000o0();
            cki.O00000Oo("IjkVideoView", "onVideoSizeChanged size: %d:%d", Integer.valueOf(IjkVideoView.this.O00000oo), Integer.valueOf(IjkVideoView.this.O0000O0o));
            if (IjkVideoView.this.O00000oo != 0 && IjkVideoView.this.O0000O0o != 0) {
                if (IjkVideoView.this.O0000o != null) {
                    IjkVideoView.this.O0000o.O00000o0(IjkVideoView.this.O00000oo, IjkVideoView.this.O0000O0o);
                    IjkVideoView.this.O0000o.O00000o(IjkVideoView.this.O0000oO0, IjkVideoView.this.O0000oO);
                }
                if (IjkVideoView.this.f5203O000000o != null) {
                    IjkVideoView.this.f5203O000000o.O000000o(IjkVideoView.this.O00000oo, IjkVideoView.this.O0000O0o, i3, i4);
                }
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.post(ijkVideoView.O0000oOO);
                IjkVideoView.this.requestLayout();
            }
        }
    };
    cjy.O000000o O0000oo = new cjy.O000000o() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass8 */

        public final void O000000o(cjy.O00000Oo o00000Oo, int i, int i2) {
            if (o00000Oo.O000000o() != IjkVideoView.this.O0000o) {
                cki.O00000oO("IjkVideoView", "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.O0000OOo = i;
            ijkVideoView.O0000Oo0 = i2;
            boolean z = true;
            boolean z2 = ijkVideoView.O00000o0 == 3;
            if (IjkVideoView.this.O0000o.O0000O0o() && !(IjkVideoView.this.O00000oo == i && IjkVideoView.this.O0000O0o == i2)) {
                z = false;
            }
            if (IjkVideoView.this.O00000oO != null && z2 && z) {
                if (IjkVideoView.this.O0000o0o != 0) {
                    IjkVideoView ijkVideoView2 = IjkVideoView.this;
                    ijkVideoView2.seekTo(ijkVideoView2.O0000o0o);
                }
                IjkVideoView.this.start();
            }
        }

        public final void O000000o(cjy.O00000Oo o00000Oo) {
            if (o00000Oo.O000000o() != IjkVideoView.this.O0000o) {
                cki.O00000oO("IjkVideoView", "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.O00000o = o00000Oo;
            if (ijkVideoView.O00000oO != null) {
                IjkVideoView.O000000o(IjkVideoView.this.O00000oO, o00000Oo);
            } else {
                IjkVideoView.this.O00000Oo();
            }
        }

        public final void O00000Oo(cjy.O00000Oo o00000Oo) {
            if (o00000Oo.O000000o() != IjkVideoView.this.O0000o) {
                cki.O00000oO("IjkVideoView", "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.O00000o = null;
            cki.O00000o("IjkVideoView", "releaseWithoutStop");
            if (ijkVideoView.O00000oO != null) {
                ijkVideoView.O00000oO.setDisplay(null);
            }
        }
    };
    IMediaPlayer.OnPreparedListener O0000oo0 = new IMediaPlayer.OnPreparedListener() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass3 */

        public final void onPrepared(IMediaPlayer iMediaPlayer) {
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.O00000Oo = 2;
            if (ijkVideoView.O0000Ooo != null) {
                IjkVideoView.this.O0000Ooo.onPrepared(IjkVideoView.this.O00000oO);
            }
            IjkVideoView.this.O00000oo = iMediaPlayer.getVideoWidth();
            IjkVideoView.this.O0000O0o = iMediaPlayer.getVideoHeight();
            IjkVideoView.this.O00000o0();
            int i = IjkVideoView.this.O0000o0o;
            if (i != 0) {
                IjkVideoView.this.seekTo(i);
            }
            if (IjkVideoView.this.O00000oo == 0 || IjkVideoView.this.O0000O0o == 0) {
                if (IjkVideoView.this.O00000o0 == 3) {
                    IjkVideoView.this.start();
                }
            } else if (IjkVideoView.this.O0000o != null) {
                IjkVideoView.this.O0000o.O00000o0(IjkVideoView.this.O00000oo, IjkVideoView.this.O0000O0o);
                IjkVideoView.this.O0000o.O00000o(IjkVideoView.this.O0000oO0, IjkVideoView.this.O0000oO);
                if (IjkVideoView.this.f5203O000000o != null && IjkVideoView.this.O00000oo > 0 && IjkVideoView.this.O0000O0o > 0) {
                    IjkVideoView.this.f5203O000000o.O000000o(IjkVideoView.this.O00000oo, IjkVideoView.this.O0000O0o, IjkVideoView.this.O0000oO0, IjkVideoView.this.O0000oO);
                }
                if (IjkVideoView.this.O0000o.O0000O0o() && (IjkVideoView.this.O0000OOo != IjkVideoView.this.O00000oo || IjkVideoView.this.O0000Oo0 != IjkVideoView.this.O0000O0o)) {
                    return;
                }
                if (IjkVideoView.this.O00000o0 == 3) {
                    IjkVideoView.this.start();
                } else if (!IjkVideoView.this.isPlaying() && i == 0 && IjkVideoView.this.getCurrentPosition() <= 0) {
                }
            }
        }
    };
    public int O0000ooO = 2;
    private Uri O0000ooo;
    private boolean O000O00o = true;
    private boolean O000O0OO = true;
    private boolean O000O0Oo = true;
    private TextView O000O0o;
    private boolean O000O0o0;
    private boolean O000O0oO;
    private long O000O0oo;
    private IMediaPlayer.OnErrorListener O000OO = new IMediaPlayer.OnErrorListener() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass6 */

        public final boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            cki.O00000o0("IjkVideoView", "Error: " + i + "," + i2);
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.O00000Oo = -1;
            ijkVideoView.O00000o0 = -1;
            if (ijkVideoView.O0000o0 == null || IjkVideoView.this.O0000o0.onError(IjkVideoView.this.O00000oO, i, i2)) {
            }
            return true;
        }
    };
    private IMediaPlayer.OnCompletionListener O000OO00 = new IMediaPlayer.OnCompletionListener() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass4 */

        public final void onCompletion(IMediaPlayer iMediaPlayer) {
            IjkVideoView ijkVideoView = IjkVideoView.this;
            ijkVideoView.O00000Oo = 5;
            ijkVideoView.O00000o0 = 5;
            if (ijkVideoView.O0000OoO != null) {
                IjkVideoView.this.O0000OoO.onCompletion(IjkVideoView.this.O00000oO);
            }
        }
    };
    private IMediaPlayer.OnInfoListener O000OO0o = new IMediaPlayer.OnInfoListener() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass5 */

        public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (IjkVideoView.this.O0000o0O != null) {
                IjkVideoView.this.O0000o0O.onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                cki.O00000o("IjkVideoView", "MEDIA_INFO_VIDEO_RENDERING_START:");
                return true;
            } else if (i == 901) {
                cki.O00000o("IjkVideoView", "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                return true;
            } else if (i == 902) {
                cki.O00000o("IjkVideoView", "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                return true;
            } else if (i == 10001) {
                IjkVideoView.this.O0000Oo = i2;
                cki.O00000o("IjkVideoView", "MEDIA_INFO_VIDEO_ROTATION_CHANGED: ".concat(String.valueOf(i2)));
                if (IjkVideoView.this.O0000o == null) {
                    return true;
                }
                IjkVideoView.this.O0000o.setVideoRotation(i2);
                return true;
            } else if (i != 10002) {
                switch (i) {
                    case 700:
                        cki.O00000o("IjkVideoView", "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case 701:
                        cki.O00000o("IjkVideoView", "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case 702:
                        cki.O00000o("IjkVideoView", "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case 703:
                        cki.O00000o("IjkVideoView", "MEDIA_INFO_NETWORK_BANDWIDTH: ".concat(String.valueOf(i2)));
                        return true;
                    default:
                        switch (i) {
                            case 800:
                                cki.O00000o("IjkVideoView", "MEDIA_INFO_BAD_INTERLEAVING:");
                                return true;
                            case 801:
                                cki.O00000o("IjkVideoView", "MEDIA_INFO_NOT_SEEKABLE:");
                                return true;
                            case 802:
                                cki.O00000o("IjkVideoView", "MEDIA_INFO_METADATA_UPDATE:");
                                return true;
                            default:
                                return true;
                        }
                }
            } else {
                cki.O00000o("IjkVideoView", "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
        }
    };
    private IMediaPlayer.OnBufferingUpdateListener O000OOOo = new IMediaPlayer.OnBufferingUpdateListener() {
        /* class com.mijia.generalplayer.ijk.IjkVideoView.AnonymousClass7 */

        public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            IjkVideoView.this.O0000o00 = i;
        }
    };
    private int O000OOo = 0;
    private int O000OOoO = O000OOo0[0];
    private Context O00oOoOo;
    private Map<String, String> O00oOooO;
    private IMediaPlayer.OnSeekCompleteListener O00oOooo;

    public interface O000000o {
        void O000000o();

        void O000000o(int i, int i2, int i3, int i4);

        void O000000o(View view);

        void O00000Oo();
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getVideoWidth() {
        return this.O00000oo;
    }

    public int getVideoHeight() {
        return this.O0000O0o;
    }

    public IjkVideoView(Context context) {
        super(context);
        O000000o(context);
    }

    public IjkVideoView(Context context, int i) {
        super(context);
        this.O0000ooO = i;
        O000000o(context);
    }

    public IjkVideoView(Context context, byte b) {
        super(context);
        O000000o(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.O00oOoOo = context.getApplicationContext();
        this.O000O0oO = ckh.O00000oO || O00000oo();
        if (this.O000O0oO && this.O0000ooO == 2) {
            this.O0000ooO = 1;
        }
        setRender(this.O0000ooO);
        this.O00000oo = 0;
        this.O0000O0o = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O000O0o = new TextView(context);
        this.O000O0o.setTextSize(24.0f);
        this.O000O0o.setGravity(17);
        addView(this.O000O0o, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    public cjy getRenderView() {
        return this.O0000o;
    }

    public void setRenderView(cjy cjy) {
        int i;
        int i2;
        if (this.O0000o != null) {
            IMediaPlayer iMediaPlayer = this.O00000oO;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.O0000o.getView();
            this.O0000o.O00000Oo(this.O0000oo);
            this.O0000o = null;
            removeView(view);
        }
        if (cjy != null) {
            this.O0000o = cjy;
            View view2 = this.O0000o.getView();
            if (!(view2 == null || this.O0000ooO == 3)) {
                view2.setOnClickListener(new View.OnClickListener() {
                    /* class com.mijia.generalplayer.ijk.$$Lambda$IjkVideoView$m9SUoXaDo_xFh1XtAB189oCgdNI */

                    public final void onClick(View view) {
                        IjkVideoView.this.O000000o(view);
                    }
                });
            }
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            addView(view2);
            cjy.setAspectRatio(this.O000OOoO);
            int i3 = this.O00000oo;
            if (i3 > 0 && (i2 = this.O0000O0o) > 0) {
                cjy.O00000o0(i3, i2);
            }
            int i4 = this.O0000oO0;
            if (i4 > 0 && (i = this.O0000oO) > 0) {
                cjy.O00000o(i4, i);
            }
            this.O0000o.O000000o(this.O0000oo);
            this.O0000o.setVideoRotation(this.O0000Oo);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O000000o o000000o = this.f5203O000000o;
        if (o000000o != null) {
            o000000o.O000000o(view);
        }
    }

    public void setRender(int i) {
        if (i == 0) {
            cki.O00000o("IjkVideoView", "RENDER_NONE");
            setRenderView(null);
        } else if (i == 1) {
            cki.O00000o("IjkVideoView", "RENDER_SURFACE_VIEW");
            setRenderView(new SurfaceRenderView(getContext()));
        } else if (i == 2) {
            cki.O00000o("IjkVideoView", "RENDER_TEXTURE_VIEW");
            TextureRenderView textureRenderView = new TextureRenderView(getContext());
            if (this.O00000oO != null) {
                textureRenderView.getSurfaceHolder().O000000o(this.O00000oO);
                textureRenderView.O00000o0(this.O00000oO.getVideoWidth(), this.O00000oO.getVideoHeight());
                textureRenderView.O00000o(this.O00000oO.getVideoSarNum(), this.O00000oO.getVideoSarDen());
                textureRenderView.setAspectRatio(this.O000OOoO);
            }
            setRenderView(textureRenderView);
        } else if (i != 3) {
            cki.O00000oO("IjkVideoView", String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i)));
        } else {
            cki.O00000o("IjkVideoView", "RENDER_GL_SURFACE_VIEW");
            setRenderView(new GlSurfaceRenderView(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        cki.O00000o("IjkVideoView", "setVideoURI:".concat(String.valueOf(uri)));
        O000000o(uri, (Map<String, String>) null);
    }

    public final void O000000o(Uri uri, Map<String, String> map) {
        cki.O00000o("IjkVideoView", "setVideoURI with header:".concat(String.valueOf(uri)));
        this.O0000ooo = uri;
        this.O00oOooO = map;
        this.O0000o0o = 0;
        O00000Oo();
    }

    public final void O000000o() {
        cki.O00000o("IjkVideoView", "stopPlayback");
        O000000o(true);
        ((AudioManager) this.O00oOoOo.getSystemService("audio")).abandonAudioFocus(null);
    }

    @TargetApi(23)
    public final void O00000Oo() {
        cki.O00000o0("IjkVideoView", "openVideo mUri:" + this.O0000ooo);
        O000000o(false);
        if (this.O0000ooo != null && this.O00000o != null) {
            ((AudioManager) this.O00oOoOo.getSystemService("audio")).requestAudioFocus(null, 3, 1);
            try {
                if (this.O00000oO != null) {
                    this.O00000oO.stop();
                    this.O00000oO.release();
                }
                this.O00000oO = O00000oO();
                this.O00000oO.setOnPreparedListener(this.O0000oo0);
                this.O00000oO.setOnVideoSizeChangedListener(this.O0000oOo);
                this.O00000oO.setOnCompletionListener(this.O000OO00);
                this.O00000oO.setOnErrorListener(this.O000OO);
                this.O00000oO.setOnInfoListener(this.O000OO0o);
                this.O00000oO.setOnBufferingUpdateListener(this.O000OOOo);
                this.O00000oO.setOnSeekCompleteListener(this.O00oOooo);
                if (this.O000O0o0) {
                    this.O00000oO.setVolume(0.0f, 0.0f);
                }
                this.O0000o00 = 0;
                if (Build.VERSION.SDK_INT >= 14) {
                    this.O00000oO.setDataSource(this.O00oOoOo, this.O0000ooo, this.O00oOooO);
                } else {
                    this.O00000oO.setDataSource(this.O0000ooo.toString());
                }
                O000000o(this.O00000oO, this.O00000o);
                this.O00000oO.setAudioStreamType(3);
                this.O00000oO.setScreenOnWhilePlaying(true);
                this.O00000oO.prepareAsync();
                this.O00000Oo = 1;
            } catch (IOException e) {
                cki.O000000o("IjkVideoView", "Unable to open content: " + this.O0000ooo, e);
                this.O00000Oo = -1;
                this.O00000o0 = -1;
                this.O000OO.onError(this.O00000oO, 1, 0);
            } catch (IllegalArgumentException e2) {
                cki.O000000o("IjkVideoView", "Unable to open content: " + this.O0000ooo, e2);
                this.O00000Oo = -1;
                this.O00000o0 = -1;
                this.O000OO.onError(this.O00000oO, 1, 0);
            }
        }
    }

    public final void O00000o0() {
        if (this.O00000oo == 640 && this.O0000O0o == 368) {
            this.O0000O0o = 360;
        }
        if (this.O00000oo == 640 && this.O0000O0o == 384) {
            this.O0000O0o = 360;
        }
        if (this.O00000oo == 1920 && this.O0000O0o == 1088) {
            this.O0000O0o = 1080;
        }
        if (this.O00000oo == 1280) {
            this.O0000O0o = 720;
        }
        if (this.O00000oo == 2304) {
            this.O0000O0o = 1296;
        }
    }

    public void setSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.O00oOooo = onSeekCompleteListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.O0000Ooo = onPreparedListener;
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.O0000OoO = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.O0000o0 = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.O0000o0O = onInfoListener;
    }

    public static void O000000o(IMediaPlayer iMediaPlayer, cjy.O00000Oo o00000Oo) {
        if (iMediaPlayer != null) {
            if (o00000Oo == null) {
                iMediaPlayer.setDisplay(null);
            } else {
                o00000Oo.O000000o(iMediaPlayer);
            }
        }
    }

    public final void O000000o(boolean z) {
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Boolean.valueOf(this.O00000oO == null);
        cki.O00000Oo("IjkVideoView", "release clear:%b,is null:%b", objArr);
        IMediaPlayer iMediaPlayer = this.O00000oO;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
            this.O00000oO = null;
        }
        if (z) {
            this.O00000o0 = 0;
        }
        ((AudioManager) this.O00oOoOo.getSystemService("audio")).abandonAudioFocus(null);
        cki.O00000Oo("IjkVideoView", "release clear done:%b", Boolean.valueOf(z));
    }

    public void start() {
        cki.O00000o("IjkVideoView", "start");
        if (O00000o()) {
            this.O00000oO.start();
            this.O00000Oo = 3;
        }
        O000000o o000000o = this.f5203O000000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
        this.O00000o0 = 3;
    }

    public void pause() {
        cki.O00000o("IjkVideoView", "pause");
        if (O00000o() && this.O00000oO.isPlaying()) {
            this.O00000oO.pause();
            this.O00000Oo = 4;
        }
        O000000o o000000o = this.f5203O000000o;
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
        this.O00000o0 = 4;
    }

    public int getDuration() {
        IMediaPlayer iMediaPlayer = this.O00000oO;
        if (iMediaPlayer != null) {
            return (int) iMediaPlayer.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (O00000o()) {
            return Math.min((int) this.O00000oO.getCurrentPosition(), getDuration());
        }
        return 0;
    }

    public void seekTo(int i) {
        if (O00000o()) {
            this.O00000oO.seekTo((long) i);
            this.O0000o0o = 0;
            return;
        }
        this.O0000o0o = i;
    }

    public boolean isPlaying() {
        return O00000o() && this.O00000oO.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.O00000oO != null) {
            return this.O0000o00;
        }
        return 0;
    }

    private boolean O00000o() {
        int i;
        return (this.O00000oO == null || (i = this.O00000Oo) == -1 || i == 0 || i == 1) ? false : true;
    }

    public boolean canPause() {
        return this.O000O00o;
    }

    public boolean canSeekBackward() {
        return this.O000O0OO;
    }

    public boolean canSeekForward() {
        return this.O000O0Oo;
    }

    public final void O000000o(int i) {
        cjy cjy = this.O0000o;
        if (cjy != null) {
            cjy.setAspectRatio(i);
        }
        this.O000OOoO = i;
        post(this.O0000oOO);
    }

    private IMediaPlayer O00000oO() {
        if (this.O0000ooo == null) {
            return null;
        }
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        IjkMediaPlayer.native_setLogLevel(ckh.O00000o ? 2 : 5);
        ijkMediaPlayer.setOption(1, "safe", 0);
        ijkMediaPlayer.setOption(1, "protocol_whitelist", "ijkio,ijkmediadatasource, rtsp, concat,http,tcp,https,tls,file");
        if (this.O0000ooo.toString().startsWith("rtmj")) {
            ijkMediaPlayer.setOption(1, "analyzeduration", 1);
            ijkMediaPlayer.setOption(1, "probesize", 1024);
        } else if (this.O0000ooo.toString().startsWith("rtsp")) {
            ijkMediaPlayer.setOption(4, "fast", 1);
            ijkMediaPlayer.setOption(4, "max_cached_duration", 3);
            ijkMediaPlayer.setOption(4, "framedrop", 10);
            ijkMediaPlayer.setOption(4, "max-fps", 0);
            ijkMediaPlayer.setOption(4, "fps", 30);
            ijkMediaPlayer.setOption(4, "packet-buffering", 0);
            ijkMediaPlayer.setOption(4, "min-frames", 2);
            ijkMediaPlayer.setOption(4, "reconnect", 5);
            ijkMediaPlayer.setOption(1, "probesize", 200);
            ijkMediaPlayer.setOption(1, "rtsp_transport", "tcp");
            ijkMediaPlayer.setOption(1, "analyzemaxduration", 1000);
            ijkMediaPlayer.setOption(1, "flush_packets", 1);
            ijkMediaPlayer.setOption(1, "max-buffer-size", 1024);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 1);
        } else {
            ijkMediaPlayer.setOption(4, "start-on-prepared", 0);
        }
        ijkMediaPlayer.setOption(4, "enable-accurate-seek", 1);
        boolean z = !this.O000O0oO;
        cki.O00000o0("IjkVideoView", "mediacodec:".concat(String.valueOf(z ? 1 : 0)));
        long j = z ? 1 : 0;
        ijkMediaPlayer.setOption(4, "mediacodec-hevc", j);
        ijkMediaPlayer.setOption(4, "mediacodec", j);
        ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 0);
        ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1);
        ijkMediaPlayer.setOption(4, "opensles", 0);
        ijkMediaPlayer.setOption(4, "framedrop", 1);
        ijkMediaPlayer.setOption(4, "overlay-format", 842225234);
        ijkMediaPlayer.setOption(1, "http-detect-range-support", 0);
        ijkMediaPlayer.setOption(1, "dns_cache_clear", 1);
        ijkMediaPlayer.setOption(2, "skip_loop_filter", 48);
        if (!O0000O0o()) {
            return ijkMediaPlayer;
        }
        cki.O00000o("IjkVideoView", "setOption with m3u8");
        ijkMediaPlayer.setOption(4, "packet-buffering", 0);
        ijkMediaPlayer.setOption(4, "infbuf", 1);
        ijkMediaPlayer.setOption(4, "min-frames", 2);
        ijkMediaPlayer.setOption(1, "dns_cache_clear", 0);
        ijkMediaPlayer.setOption(1, "start_seek_time", this.O000O0oo);
        return ijkMediaPlayer;
    }

    private static boolean O00000oo() {
        if (frx.O000000o(new MediaCodecUtil.CodecKey(2, 2304, 1080)) == null) {
            cki.O00000oO("IjkVideoView", "not support 2K hard decoder");
            return true;
        } else if (!ckl.O000000o(O000OOoo, Build.PRODUCT)) {
            return false;
        } else {
            cki.O00000oO("IjkVideoView", "not support soft decode list");
            return true;
        }
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.O00000oO;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public final void O00000Oo(boolean z) {
        IMediaPlayer iMediaPlayer = this.O00000oO;
        if (iMediaPlayer != null) {
            if (z) {
                iMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                iMediaPlayer.setVolume(100.0f, 100.0f);
            }
        }
        this.O000O0o0 = z;
    }

    public int getState() {
        return this.O00000Oo;
    }

    public void setSpeed(int i) {
        ((IjkMediaPlayer) this.O00000oO).setSpeed((float) i);
    }

    private boolean O0000O0o() {
        String uri = this.O0000ooo.toString();
        if (!uri.contains("?") || !uri.substring(0, uri.lastIndexOf("?")).endsWith("m3u8")) {
            return false;
        }
        return true;
    }

    public void setStartSeekTime(long j) {
        this.O000O0oo = j;
    }
}
