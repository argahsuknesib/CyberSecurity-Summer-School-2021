package _m_j;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;

public final class iki {

    /* renamed from: O000000o  reason: collision with root package name */
    public MediaPlayer f1386O000000o;
    public MediaPlayer.OnCompletionListener O00000Oo;
    public int O00000o = -1;
    public O000000o O00000o0;
    Advertis O00000oO;
    AudioManager O00000oo;
    private int O0000O0o = 3;
    private float O0000OOo = 1.0f;
    private boolean O0000Oo = false;
    private float O0000Oo0 = 1.0f;

    public interface O000000o {
    }

    public iki() {
        O000000o();
    }

    public final void O000000o(float f, float f2) {
        this.O0000OOo = f;
        this.O0000Oo0 = f2;
        if (this.O00000o != -1) {
            this.f1386O000000o.setVolume(this.O0000OOo, this.O0000Oo0);
        }
    }

    public final void O000000o() {
        try {
            if (this.f1386O000000o == null) {
                this.f1386O000000o = new MediaPlayer();
                this.O00000o = 0;
                this.f1386O000000o.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    /* class _m_j.iki.AnonymousClass1 */

                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        iki.this.O00000o = -1;
                        return true;
                    }
                });
                this.f1386O000000o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    /* class _m_j.iki.AnonymousClass2 */

                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        iki iki = iki.this;
                        iki.O00000o = 5;
                        if (iki.O00000Oo != null) {
                            iki.this.O00000Oo.onCompletion(mediaPlayer);
                        }
                    }
                });
            }
            if (this.O00000o == 2) {
                this.f1386O000000o.stop();
                this.O00000o = 4;
            }
            this.f1386O000000o.reset();
            this.f1386O000000o.setLooping(this.O0000Oo);
            this.f1386O000000o.setVolume(this.O0000OOo, this.O0000Oo0);
            this.O00000o = 0;
        } catch (Exception e) {
            e.printStackTrace();
            this.O00000o = -1;
        }
    }

    public final void O00000Oo() {
        ilk.O000000o("AD stopPlay 0:" + System.currentTimeMillis());
        try {
            if (this.O00000o == 2) {
                this.f1386O000000o.stop();
                this.O00000o = 4;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.O00000o = -1;
        }
        this.O00000oO = null;
    }
}
