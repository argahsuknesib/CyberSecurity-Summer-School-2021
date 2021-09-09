package _m_j;

import android.media.MediaPlayer;

public final class eze {

    /* renamed from: O000000o  reason: collision with root package name */
    public MediaPlayer f15973O000000o;
    public long O00000Oo;
    public long O00000o0;

    public final void O000000o() {
        MediaPlayer mediaPlayer = this.f15973O000000o;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f15973O000000o = null;
        }
        this.O00000o0 = (this.O00000o0 + System.currentTimeMillis()) - this.O00000Oo;
    }
}
