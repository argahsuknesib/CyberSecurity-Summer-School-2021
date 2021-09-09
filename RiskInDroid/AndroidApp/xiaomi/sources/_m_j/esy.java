package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import com.xiaomi.smarthome.R;
import java.io.Closeable;

public final class esy implements MediaPlayer.OnErrorListener, Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15782O000000o = "esy";
    private final Activity O00000Oo;
    private boolean O00000o;
    private MediaPlayer O00000o0 = null;
    private boolean O00000oO;

    public esy(Activity activity) {
        this.O00000Oo = activity;
        O000000o();
    }

    public final synchronized void O000000o() {
        boolean z = true;
        if (((AudioManager) this.O00000Oo.getSystemService("audio")).getRingerMode() != 2) {
            z = false;
        }
        this.O00000o = z;
        this.O00000oO = false;
        if (this.O00000o && this.O00000o0 == null) {
            this.O00000Oo.setVolumeControlStream(3);
            this.O00000o0 = O000000o(this.O00000Oo);
        }
    }

    private MediaPlayer O000000o(Context context) {
        AssetFileDescriptor openRawResourceFd;
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            openRawResourceFd = context.getResources().openRawResourceFd(R.raw.beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setLooping(false);
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Exception e) {
            Log.w(f15782O000000o, e);
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
            throw th;
        }
    }

    public final synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.O00000Oo.finish();
        } else {
            close();
            O000000o();
        }
        return true;
    }

    public final synchronized void close() {
        if (this.O00000o0 != null) {
            this.O00000o0.release();
            this.O00000o0 = null;
        }
    }
}
