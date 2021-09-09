package _m_j;

import android.media.MediaPlayer;
import com.xiaomi.smarthome.camera.XmMp4Player;

public abstract class cke implements XmMp4Player {
    MediaPlayer.OnCompletionListener O00000Oo = null;
    MediaPlayer.OnPreparedListener O00000o = null;
    MediaPlayer.OnErrorListener O00000o0 = null;
    XmMp4Player.RenderCallback O00000oO = null;
    XmMp4Player.AudioListener O00000oo = null;

    public void setAudioListener(XmMp4Player.AudioListener audioListener) {
        this.O00000oo = audioListener;
    }

    public void setRenderCallback(XmMp4Player.RenderCallback renderCallback) {
        this.O00000oO = renderCallback;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.O00000o = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.O00000Oo = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.O00000o0 = onErrorListener;
    }
}
