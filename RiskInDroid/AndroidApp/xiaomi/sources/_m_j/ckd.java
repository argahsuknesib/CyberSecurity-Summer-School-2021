package _m_j;

import _m_j.ckb;
import android.content.Context;
import android.widget.FrameLayout;
import com.mijia.generalplayer.ijk.GlSurfaceRenderView;
import com.mijia.generalplayer.player.GeneralIjkPlayer;

public final class ckd extends cke {

    /* renamed from: O000000o  reason: collision with root package name */
    public ckf f13962O000000o;
    private ckc O0000O0o;
    private boolean O0000OOo = false;

    public ckd(Context context, FrameLayout frameLayout) {
        this.O0000O0o = new GeneralIjkPlayer(context, 3);
        frameLayout.addView(this.O0000O0o.O00000Oo(), new FrameLayout.LayoutParams(-1, -1));
        this.f13962O000000o = new ckf((GlSurfaceRenderView) this.O0000O0o.O00000o0());
        this.f13962O000000o.addMp4Player(this);
        frameLayout.post(new Runnable() {
            /* class _m_j.ckd.AnonymousClass1 */

            public final void run() {
                if (ckd.this.O00000oO != null) {
                    ckd.this.O00000oO.onInitialed();
                }
            }
        });
        this.O0000O0o.O000000o(new ckb.O00000Oo() {
            /* class _m_j.ckd.AnonymousClass2 */

            public final void onPrepared() {
                if (ckd.this.O00000o != null) {
                    ckd.this.O00000o.onPrepared(null);
                }
            }

            public final void onPlayerStateChanged(int i) {
                if (i != 2 && i == 4 && ckd.this.O00000Oo != null) {
                    cki.O00000o("GeneralXmMp4Player", "onCompletion");
                    ckd.this.O00000Oo.onCompletion(null);
                }
            }

            public final void onPlayerError(String str) {
                if (ckd.this.O00000o0 != null) {
                    ckd.this.O00000o0.onError(null, -1, -1);
                }
            }
        });
    }

    public final void changeSource(String str) {
        this.O0000O0o.O000000o(str, null);
        openVideoPlayer(str);
    }

    public final void openVideoPlayer(String str) {
        cki.O00000o("GeneralXmMp4Player", "openVideoPlayer".concat(String.valueOf(str)));
        if (!this.O0000OOo) {
            this.O0000O0o.O000000o(str, null);
            this.O0000OOo = true;
        }
        this.O0000O0o.O0000Oo0();
    }

    public final void pause() {
        this.O0000O0o.O0000OOo();
    }

    public final boolean isPlaying() {
        ckc ckc = this.O0000O0o;
        return ckc != null && ckc.O0000OoO();
    }

    public final int getDuration() {
        return (int) this.O0000O0o.O00000o();
    }

    public final void seekTo(int i) {
        this.O0000O0o.O000000o((long) i);
    }

    public final void setVolume(int i) {
        this.O0000O0o.O000000o((float) i);
    }

    public final int getCurrentPosition() {
        return (int) this.O0000O0o.O0000O0o();
    }
}
