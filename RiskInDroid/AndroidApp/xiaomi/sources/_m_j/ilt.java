package _m_j;

import android.media.AudioTrack;
import android.os.Build;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import com.ximalaya.ting.android.player.soundtouch.SoundTouch;
import com.ximalaya.ting.android.player.soundtouch.SoundTouchDataModel;

public final class ilt extends Thread {
    private static int O00000oo = 8192;
    private static int O0000O0o = 16384;
    private static int O0000OOo = -2;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile boolean f1451O000000o = false;
    public volatile AudioTrack O00000Oo;
    public byte[] O00000o;
    public Object O00000o0 = new Object();
    private XMediaplayerJNI O00000oO;
    private byte[] O0000Oo;
    private int O0000Oo0;
    private boolean O0000OoO = false;
    private volatile boolean O0000Ooo = false;
    private volatile boolean O0000o = false;
    private SoundTouch O0000o0 = null;
    private long O0000o00 = 0;
    private int O0000o0O = 0;
    private boolean O0000o0o = false;
    private float O0000oO0;

    public ilt(XMediaplayerJNI xMediaplayerJNI) {
        super("AudioTrackPlayThreadForPlayer");
        this.O00000oO = xMediaplayerJNI;
        O00000oO();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private void O00000oO() {
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "initAudioTrack");
        int minBufferSize = AudioTrack.getMinBufferSize(44100, 12, 2);
        this.O0000Oo0 = minBufferSize * 4;
        int i = O00000oo;
        if (minBufferSize < i) {
            this.O0000Oo0 = i;
        } else {
            int i2 = O0000O0o;
            if (minBufferSize > i2) {
                this.O0000Oo0 = i2;
            } else {
                this.O0000Oo0 = minBufferSize;
            }
        }
        this.O00000Oo = new AudioTrack(3, 44100, 12, 2, this.O0000Oo0, 1);
        this.O0000Oo = new byte[this.O0000Oo0];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        return;
     */
    public final synchronized void O000000o(float f, float f2, float f3) {
        if (!this.f1451O000000o) {
            if (SoundTouch.O00000Oo) {
                if (this.O0000o0 == null) {
                    this.O0000o0 = SoundTouch.O000000o();
                }
                this.O0000o0o = true;
                SoundTouch soundTouch = this.O0000o0;
                soundTouch.setTempo(soundTouch.f12235O000000o, f);
                SoundTouch soundTouch2 = this.O0000o0;
                soundTouch2.setPitchSemiTones(soundTouch2.f12235O000000o, f2);
                SoundTouch soundTouch3 = this.O0000o0;
                soundTouch3.setRate(soundTouch3.f12235O000000o, f3);
                if (f == 1.0f && f2 == 0.0f && f3 == 1.0f) {
                    this.O0000o0o = false;
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        r3 = -1;
     */
    public final void run() {
        int i;
        this.O0000OoO = true;
        while (true) {
            if (this.f1451O000000o) {
                break;
            }
            try {
                synchronized (this.O00000o0) {
                    if (!this.f1451O000000o) {
                        if (this.O00000o != null) {
                            System.arraycopy(this.O00000o, 0, this.O0000Oo, 0, this.O00000o.length);
                            i = this.O00000o.length;
                            this.O00000o = null;
                        } else {
                            i = this.O00000oO.O000000o(this.O0000Oo, this.O0000Oo.length);
                        }
                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread result0:".concat(String.valueOf(i)));
                        int i2 = -1;
                        if (i > 0) {
                            while (true) {
                                if (i >= this.O0000Oo0 || this.f1451O000000o) {
                                    break;
                                }
                                byte[] bArr = new byte[(this.O0000Oo0 - i)];
                                if (this.f1451O000000o) {
                                    break;
                                }
                                int O000000o2 = this.O00000oO.O000000o(bArr, bArr.length);
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread result1 reLength:".concat(String.valueOf(O000000o2)));
                                if (O000000o2 != O0000OOo) {
                                    if (O000000o2 != -1) {
                                        if (O000000o2 <= 0) {
                                            if (O000000o2 != 0) {
                                                break;
                                            }
                                            this.O0000Ooo = true;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread mAudioTrack wait0");
                                            this.O00000oO.O0000o0O();
                                            if (!this.O00000oO.O0000Ooo && this.O00000oO.O000000o() == 4) {
                                                this.O00000oO.O00000Oo(701);
                                            }
                                            this.O00000o0.wait(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                                            this.O0000Ooo = false;
                                        } else {
                                            System.arraycopy(bArr, 0, this.O0000Oo, i, O000000o2);
                                            i += O000000o2;
                                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread result2:".concat(String.valueOf(O000000o2)));
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    i = O0000OOo;
                                    break;
                                }
                            }
                        }
                        if (!this.f1451O000000o) {
                            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread result3:".concat(String.valueOf(i)));
                            if (i == O0000OOo) {
                                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread decode over");
                                if (this.O00000oO.O0000Ooo) {
                                    this.O00000oO.O00000Oo(702);
                                }
                                O00000oo();
                                this.O00000Oo.stop();
                                this.O00000oO.O0000o0();
                            } else {
                                if (i != -1) {
                                    if (i == 0) {
                                        this.O0000Ooo = true;
                                        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread wait");
                                        this.O00000oO.O0000o0O();
                                        if (!this.O00000oO.O0000Ooo && this.O00000oO.O000000o() == 4) {
                                            this.O00000oO.O00000Oo(701);
                                        }
                                        this.O00000o0.wait(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                                        this.O0000Ooo = false;
                                        i2 = i;
                                    } else if (i > 0) {
                                        if (this.O00000oO.O0000Ooo) {
                                            this.O00000oO.O00000Oo(702);
                                        }
                                        i2 = O000000o(this.O0000Oo, i);
                                        if (System.currentTimeMillis() - this.O0000o00 >= 1000) {
                                            this.O0000o00 = System.currentTimeMillis();
                                            String str = XMediaplayerJNI.O0000o0;
                                            imc.O000000o(str, (Object) ("AudioTrackPlayThread ttseek3:" + System.currentTimeMillis()));
                                            this.O00000oO.O0000o00();
                                        }
                                    }
                                }
                                if (i2 < 0) {
                                    this.O00000oO.O000000o(8, 1);
                                } else {
                                    while (!this.O0000o) {
                                        this.O0000Ooo = true;
                                        this.O00000o0.wait(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                                        this.O0000Ooo = false;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.O0000OoO = false;
        O00000o0();
        O0000OOo();
    }

    private void O00000oo() {
        if (this.O0000o0 != null && this.O0000o0o && this.O00000oO.O0000o00.equals(XMediaplayerJNI.AudioType.NORMAL_FILE)) {
            imc.O000000o("flushAllDataInSoundTouch 0");
            SoundTouchDataModel soundTouchDataModel = new SoundTouchDataModel();
            int O000000o2 = this.O0000o0.O000000o(soundTouchDataModel);
            byte[] bArr = soundTouchDataModel.O00000Oo;
            if (O000000o2 == 0 || bArr == null || bArr.length == 0) {
                imc.O000000o("flushAllDataInSoundTouch 1");
                return;
            }
            int i = 0;
            if (this.O00000Oo != null && this.O00000Oo.getPlayState() == 3) {
                while (O000000o2 > 0 && this.O0000o && bArr != null) {
                    if (this.O00000Oo != null && this.O00000Oo.getPlayState() == 3) {
                        int write = this.O00000Oo.write(bArr, i, O000000o2);
                        if (write <= 0) {
                            break;
                        }
                        i += write;
                        O000000o2 -= write;
                    }
                }
            }
            imc.O000000o("flushAllDataInSoundTouch 2");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private int O000000o(byte[] bArr, int i) {
        boolean z;
        int i2;
        int i3;
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread audioTrackWrite:".concat(String.valueOf(i)));
        if (this.O0000o0 == null || !this.O0000o0o || !this.O00000oO.O0000o00.equals(XMediaplayerJNI.AudioType.NORMAL_FILE)) {
            z = false;
        } else {
            SoundTouchDataModel soundTouchDataModel = new SoundTouchDataModel(bArr, i);
            i = this.O0000o0.O000000o(soundTouchDataModel);
            bArr = soundTouchDataModel.O00000Oo;
            z = true;
            if (i == 0 || bArr == null || bArr.length == 0) {
                return 0;
            }
        }
        if (this.O00000Oo != null && this.O00000Oo.getPlayState() == 3) {
            i3 = 0;
            i2 = 0;
            while (i > 0 && this.O0000o && bArr != null) {
                if (this.O00000Oo != null && this.O00000Oo.getPlayState() == 3) {
                    int write = this.O00000Oo.write(bArr, i3, i);
                    if (write <= 0) {
                        break;
                    }
                    i2 += write;
                    i3 += write;
                    i -= write;
                }
            }
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (i > 0 && !z) {
            this.O00000o = new byte[i];
            System.arraycopy(bArr, i3, this.O00000o, 0, i);
        }
        if (i2 > 0 && this.O00000oO.O0000oOo != null) {
            System.arraycopy(bArr, 0, new byte[i2], 0, i2);
        }
        return i2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        return;
     */
    public final synchronized void O000000o() {
        if (this.O00000Oo != null) {
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay0");
            if (this.O00000Oo.getPlayState() != 3) {
                O0000O0o();
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay1");
            }
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread dataReady");
            if (this.O0000Ooo) {
                synchronized (this.O00000o0) {
                    imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread notify");
                    this.O00000o0.notify();
                    this.O0000Ooo = false;
                }
            }
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay isRunning0");
            if (!this.O0000OoO) {
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay isRunning1");
                this.O0000OoO = true;
                start();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        return;
     */
    public final synchronized void O00000Oo() {
        if (this.O00000Oo != null) {
            this.O0000o = false;
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread pausePlay0");
            if (this.O00000Oo.getPlayState() == 3) {
                this.O00000Oo.pause();
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread pausePlay1");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return;
     */
    public final synchronized void O00000o0() {
        if (this.O00000Oo != null) {
            this.O0000o = false;
            imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread stopPlay0");
            if (this.O00000Oo.getPlayState() != 1) {
                this.O00000Oo.stop();
                this.O00000Oo.flush();
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread stopPlay1");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final synchronized void O00000o() {
        this.O0000o = false;
        this.f1451O000000o = true;
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread releasePlay");
        interrupt();
        if (!this.O0000OoO) {
            O0000OOo();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private synchronized void O0000O0o() {
        if (this.O00000Oo != null) {
            if (this.O00000Oo.getState() == 1 && this.O00000Oo.getPlayState() != 3) {
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay3");
                this.O00000Oo.play();
                this.O0000o = true;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay4");
            } else if (this.O00000Oo != null) {
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay5");
                this.O00000Oo.release();
                O00000oO();
                this.O00000Oo.play();
                this.O0000o = true;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay6");
            } else {
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay7");
                O00000oO();
                this.O00000Oo.play();
                this.O0000o = true;
                imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread startPlay8");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    private synchronized void O0000OOo() {
        this.O0000o = false;
        this.f1451O000000o = true;
        imc.O000000o(XMediaplayerJNI.O0000o0, (Object) "AudioTrackPlayThread audioTrackRelease");
        if (this.O00000Oo != null) {
            this.O00000Oo.release();
            this.O00000Oo = null;
        }
        this.O0000o0 = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        return;
     */
    public final synchronized void O000000o(float f) {
        this.O0000oO0 = f;
        if (this.O00000Oo != null && !this.f1451O000000o) {
            if (Build.VERSION.SDK_INT >= 21) {
                AudioTrack audioTrack = this.O00000Oo;
                if (audioTrack != null) {
                    audioTrack.setVolume(f * AudioTrack.getMaxVolume());
                }
            } else {
                AudioTrack audioTrack2 = this.O00000Oo;
                if (audioTrack2 != null) {
                    audioTrack2.setStereoVolume(AudioTrack.getMaxVolume() * f, f * AudioTrack.getMaxVolume());
                }
            }
        }
    }
}
