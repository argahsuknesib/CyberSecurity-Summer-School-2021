package _m_j;

import _m_j.imk;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.io.FileDescriptor;
import java.io.IOException;

public final class imi implements imn, Handler.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    public MediaPlayer f1465O000000o = new MediaPlayer();
    public Handler O00000Oo;
    public boolean O00000o = false;
    public int O00000o0;
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public int O0000O0o = 0;
    public int O0000OOo = 0;
    public Runnable O0000Oo = new Runnable() {
        /* class _m_j.imi.AnonymousClass7 */

        public final void run() {
            if (imi.this.O0000Oo0 != null) {
                if (imi.this.O00000o0 == 4 && !imi.this.O00000oO && !imi.this.O00000o) {
                    imk.O0000Oo0 o0000Oo0 = imi.this.O0000Oo0;
                    imi imi = imi.this;
                    o0000Oo0.O000000o(imi, imi.O00000o0());
                }
                imi.this.O00000Oo.postDelayed(imi.this.O0000Oo, 1000);
            }
        }
    };
    public imk.O0000Oo0 O0000Oo0;
    private final Handler O0000OoO;
    private final HandlerThread O0000Ooo;
    private boolean O0000o0 = false;
    private long O0000o00 = System.currentTimeMillis();
    private XMediaplayerJNI.AudioType O0000o0O = XMediaplayerJNI.AudioType.NORMAL_FILE;
    private boolean O0000o0o = false;

    public final void O000000o(float f, float f2, float f3) {
    }

    public final void O000000o(imk.O0000OOo o0000OOo) {
    }

    public final void O00000o0(String str) {
    }

    public imi() {
        this.f1465O000000o.setAudioStreamType(3);
        this.O00000Oo = new Handler(Looper.myLooper());
        this.O00000o0 = 1;
        this.O0000Ooo = new img(getClass().getSimpleName() + ":Handler");
        this.O0000Ooo.start();
        this.O0000OoO = new Handler(this.O0000Ooo.getLooper(), this);
    }

    public final int O000000o() {
        return this.O00000o0;
    }

    public final XMediaplayerJNI.AudioType O00000Oo() {
        return this.O0000o0O;
    }

    public final int O00000o0() {
        if (!this.O00000o && !this.O00000oO && !this.O00000oo && !this.O0000o0) {
            this.O0000O0o = this.f1465O000000o.getCurrentPosition();
        }
        return this.O0000O0o;
    }

    public final int O00000o() {
        int i = this.O0000OOo;
        if (i != 0) {
            return i;
        }
        if (!this.O00000o && !this.O00000oO && !this.O00000oo && !this.O0000o0) {
            this.O0000OOo = this.f1465O000000o.getDuration();
        }
        return this.O0000OOo;
    }

    public final boolean O00000oO() {
        if (this.O00000o || this.O00000oO || this.O00000oo || this.O0000o0) {
            return false;
        }
        return this.f1465O000000o.isPlaying();
    }

    public final void O00000oo() {
        this.O0000OoO.obtainMessage(3).sendToTarget();
    }

    public final void O0000O0o() {
        this.O00000oo = true;
        O000000o("prepareAsync");
        this.O0000OoO.obtainMessage(1).sendToTarget();
    }

    public final void O0000OOo() {
        O000000o("start");
        int i = this.O00000o0;
        if (i == 5 || i == 3) {
            this.O0000OoO.obtainMessage(0).sendToTarget();
        }
    }

    public final void O0000Oo0() {
        this.O0000OoO.obtainMessage(4).sendToTarget();
    }

    public final void O0000Oo() {
        O000000o("release");
        O0000Ooo();
        this.O0000o0 = true;
        Handler handler = this.O0000OoO;
        if (handler != null) {
            handler.obtainMessage(5).sendToTarget();
        }
        this.O0000Oo0 = null;
        if (this.O0000Ooo.getLooper() != null) {
            this.O0000Ooo.getLooper().quit();
            this.O0000Ooo.interrupt();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o(String str) {
        String str2 = imk.O0000o0;
        imc.O000000o(str2, (Object) (str + " nowtime:" + System.currentTimeMillis() + "long:" + (System.currentTimeMillis() - this.O0000o00)));
        this.O0000o00 = System.currentTimeMillis();
    }

    public final void O0000OoO() {
        this.O0000OOo = 0;
        if (this.O0000o0o) {
            O000000o("reset");
            this.O0000OoO.obtainMessage(7).sendToTarget();
        }
    }

    public final void O000000o(int i) {
        this.O00000o = true;
        this.O0000OoO.obtainMessage(6, Integer.valueOf(i)).sendToTarget();
    }

    public final boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.O00000o0 = 4;
                    O000000o("MSG_START start");
                    this.f1465O000000o.start();
                    O000000o("MSG_START end");
                    break;
                case 1:
                    this.O00000o0 = 2;
                    O000000o("MSG_PREPARE start");
                    this.f1465O000000o.prepareAsync();
                    O000000o("MSG_PREPARE end");
                    return true;
                case 2:
                default:
                    return false;
                case 3:
                    this.O00000o0 = 5;
                    this.f1465O000000o.pause();
                    return true;
                case 4:
                    this.O00000o0 = 6;
                    this.f1465O000000o.stop();
                    return true;
                case 5:
                    this.O00000o0 = 9;
                    O000000o("MSG_RELEASE start");
                    this.f1465O000000o.release();
                    O000000o("MSG_RELEASE end");
                    return true;
                case 6:
                    this.f1465O000000o.seekTo(((Integer) message.obj).intValue());
                    return true;
                case 7:
                    this.O00000o0 = 0;
                    O000000o("MSG_RESET start");
                    this.f1465O000000o.reset();
                    O0000Ooo();
                    O000000o("MSG_RESET end");
                    return true;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    O000000o("MSG_SET_DATA_SOURCE start");
                    if (message.obj != null) {
                        try {
                            this.f1465O000000o.setDataSource(message.obj.toString());
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (SecurityException e2) {
                            e2.printStackTrace();
                        } catch (IllegalStateException e3) {
                            e3.printStackTrace();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    O000000o("MSG_SET_DATA_SOURCE end");
                    return true;
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public final void O00000Oo(String str) {
        O000000o("setDataSource");
        this.O0000OOo = 0;
        if (str.contains("m3u8")) {
            this.O0000o0O = XMediaplayerJNI.AudioType.M3U8_FILE;
        } else {
            this.O0000o0O = XMediaplayerJNI.AudioType.NORMAL_FILE;
        }
        this.O0000o0o = true;
        this.O0000OoO.obtainMessage(8, str).sendToTarget();
    }

    public final void O000000o(final imk.O00000Oo o00000Oo) {
        this.f1465O000000o.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            /* class _m_j.imi.AnonymousClass1 */

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                imk.O00000Oo o00000Oo = o00000Oo;
                if (o00000Oo != null) {
                    o00000Oo.O000000o(i);
                }
            }
        });
    }

    public final void O000000o(final imk.O00000o0 o00000o0) {
        this.f1465O000000o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class _m_j.imi.AnonymousClass2 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                imi.this.O00000o0 = 11;
                imk.O00000o0 o00000o0 = o00000o0;
                if (o00000o0 != null) {
                    o00000o0.O000000o();
                }
            }
        });
    }

    public final void O000000o(final imk.O00000o o00000o) {
        this.f1465O000000o.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class _m_j.imi.AnonymousClass3 */

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                imi.this.O0000Ooo();
                imk.O00000o o00000o = o00000o;
                if (o00000o == null) {
                    return false;
                }
                boolean O000000o2 = o00000o.O000000o(i, i2);
                if (!O000000o2) {
                    imi.this.O00000o0 = 8;
                }
                return O000000o2;
            }
        });
    }

    public final void O0000Ooo() {
        this.O00000o = false;
        this.O00000oO = false;
        this.O00000oo = false;
        this.O0000OOo = 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o(final imk.O0000O0o o0000O0o) {
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "SMediaPlayer setOnInfoListener");
        this.f1465O000000o.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            /* class _m_j.imi.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.imc.O000000o(java.lang.String, java.lang.String):void
              _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                String str = XMediaplayerJNI.O0000o0;
                imc.O000000o(str, (Object) ("SMediaPlayer OnInfoListener:" + i + "extra:" + i2));
                if (i == 701) {
                    imi.this.O00000oO = true;
                } else if (i == 702) {
                    imi.this.O00000oO = false;
                }
                imk.O0000O0o o0000O0o = o0000O0o;
                if (o0000O0o != null) {
                    return o0000O0o.O000000o(10);
                }
                return false;
            }
        });
    }

    public final void O000000o(final imk.O0000Oo o0000Oo) {
        this.f1465O000000o.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class _m_j.imi.AnonymousClass5 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                imi.this.O000000o("onPrepared");
                imi imi = imi.this;
                imi.O00000o0 = 3;
                imi.O00000oo = false;
                imi.O0000OOo = imi.f1465O000000o.getDuration();
                imi imi2 = imi.this;
                imi2.O0000O0o = imi2.f1465O000000o.getCurrentPosition();
                imk.O0000Oo o0000Oo = o0000Oo;
                if (o0000Oo != null) {
                    o0000Oo.O000000o(imi.this);
                }
            }
        });
    }

    public final void O000000o(final imk.O0000o00 o0000o00) {
        this.f1465O000000o.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            /* class _m_j.imi.AnonymousClass6 */

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                imi.this.O00000o = false;
                imk.O0000o00 o0000o00 = o0000o00;
                if (o0000o00 != null) {
                    o0000o00.O000000o();
                }
            }
        });
    }

    public final void O000000o(imk.O0000Oo0 o0000Oo0) {
        this.O0000Oo0 = o0000Oo0;
        if (this.O0000Oo0 != null) {
            this.O00000Oo.postDelayed(this.O0000Oo, 1000);
        }
    }

    public final void O000000o(float f, float f2) {
        this.f1465O000000o.setVolume(f, f2);
    }

    public final void O000000o(FileDescriptor fileDescriptor, String str) {
        this.O0000o0o = true;
        try {
            this.f1465O000000o.setDataSource(fileDescriptor);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public final void O000000o(imu imu) {
        imj.O000000o(imu);
    }
}
