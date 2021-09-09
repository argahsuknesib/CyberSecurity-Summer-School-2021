package _m_j;

import android.content.Context;
import android.media.AudioManager;
import com.p2p.audio.AudioEngineBase;
import com.p2p.audio.AudioProcess;
import com.tutk.IAudioSender;
import com.xiaomi.aaccodec.AACDecodeEx;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import java.util.concurrent.LinkedBlockingQueue;

public final class cqg extends AudioEngineBase {

    /* renamed from: O000000o  reason: collision with root package name */
    public LinkedBlockingQueue<cqi> f14237O000000o = new LinkedBlockingQueue<>(200);
    public AudioProcess O00000Oo = null;
    public boolean O00000o;
    public IAudioSender O00000o0;
    private int O0000Ooo;
    private volatile fsg O0000o0;
    private volatile fsg O0000o00;

    public cqg(Context context, int i, String str) {
        super(context);
        this.O00000Oo = new AudioProcess(context, str);
        AudioProcess audioProcess = this.O00000Oo;
        audioProcess.O00000o0 = i;
        if ("isa.camera.hlc6".equals(audioProcess.O0000Oo0) || "chuangmi.camera.046a01".equals(audioProcess.O0000Oo0)) {
            audioProcess.O0000o00 = 640;
        } else {
            audioProcess.O0000o00 = ((i * 2) * 10) / 1000;
        }
        this.O0000Oo = context;
        this.O0000OoO = str;
        this.O00000o = "isa.camera.hlc6".equalsIgnoreCase(str);
    }

    public final void O000000o() {
        cqh.O000000o(this.O0000Oo, "audioFoucs");
    }

    public final void O00000Oo() {
        cqh.O00000Oo(this.O0000Oo, "abandonFoucs");
    }

    public final synchronized void O00000o0() {
        if (this.O0000Ooo != 1) {
            if (this.O0000Ooo == 3) {
                this.f14237O000000o.clear();
                this.O00000Oo.O000000o();
                return;
            }
            O00000oO();
            this.f14237O000000o.clear();
            this.O00000Oo.O000000o();
            if (this.O0000o0 == null) {
                this.O0000o0 = new O000000o();
                this.O0000o0.start();
            }
            this.O0000Ooo = 1;
        }
    }

    public final synchronized void O00000o() {
        if (this.O0000Ooo != 3) {
            O00000oO();
            if (this.O00000Oo != null) {
                this.O00000Oo.O00000Oo();
            }
            if (this.O0000o0 == null) {
                this.O0000o0 = new O000000o();
                this.O0000o0.start();
            }
            if (this.O0000o00 == null) {
                this.O0000o00 = new O00000Oo();
                this.O0000o00.start();
            }
            this.O0000Ooo = 3;
        }
    }

    public final synchronized void O00000oO() {
        super.O00000oO();
        this.O0000Ooo = 0;
        if (this.O00000Oo != null) {
            this.O00000Oo.O00000o0();
        }
        this.f14237O000000o.clear();
        if (this.O0000o0 != null) {
            this.O0000o0.stopThreadAsyn();
            this.O0000o0 = null;
        }
        if (this.O0000o00 != null) {
            this.O0000o00.stopThreadAsyn();
            this.O0000o00 = null;
        }
    }

    public final void O000000o(int i) {
        this.O00000Oo.O000000o(i);
    }

    public final void O00000oo() {
        AudioManager audioManager = (AudioManager) this.O0000Oo.getSystemService("audio");
        audioManager.setBluetoothScoOn(false);
        audioManager.stopBluetoothSco();
    }

    public final void O000000o(byte[] bArr, long j, int i) {
        if (this.O0000Ooo != 0) {
            if (i == 138) {
                i = 1027;
            } else if (i == 136) {
                i = 1030;
            } else if (i == 140) {
                i = 1024;
            }
            cqi cqi = new cqi();
            cqi.f14241O000000o = bArr;
            cqi.O00000o0 = j;
            cqi.O00000Oo = i;
            try {
                this.f14237O000000o.put(cqi);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O0000O0o() {
        this.f14237O000000o.clear();
        AudioProcess audioProcess = this.O00000Oo;
        if (audioProcess != null) {
            audioProcess.O0000o.clear();
        }
    }

    class O000000o extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        byte[] f14238O000000o;
        AACDecodeEx O00000Oo;

        public O000000o() {
            super("AudioDecodeThread");
        }

        public final int doRepeatWork() throws InterruptedException {
            int i;
            try {
                cki.O00000o("AudioEngine", "mAudioFrameQueue==" + cqg.this.f14237O000000o.size());
                cqi take = cqg.this.f14237O000000o.take();
                if (take != null && this.mIsRunning) {
                    if (take.O00000Oo != 1030) {
                        i = G711.decode(take.f14241O000000o, 0, take.f14241O000000o.length, this.f14238O000000o);
                    } else {
                        i = this.O00000Oo.decode(take.f14241O000000o, 0, take.f14241O000000o.length, this.f14238O000000o, this.f14238O000000o.length);
                    }
                    if (i > 0 && this.mIsRunning) {
                        byte[] bArr = new byte[i];
                        System.arraycopy(this.f14238O000000o, 0, bArr, 0, i);
                        AudioProcess.O000000o o000000o = new AudioProcess.O000000o(bArr, take.O00000o0, take.O00000Oo);
                        if (cqg.this.O00000Oo != null) {
                            AudioProcess audioProcess = cqg.this.O00000Oo;
                            if (audioProcess.O00000o != null && audioProcess.O00000o.isRunning()) {
                                if (audioProcess.O0000o.size() > 10) {
                                    audioProcess.O0000o.clear();
                                }
                                audioProcess.O0000o.put(o000000o);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }

        public final void doInitial() {
            this.f14238O000000o = new byte[10240];
            this.O00000Oo = new AACDecodeEx();
            this.O00000Oo.initial();
        }

        public final void doRelease() {
            try {
                this.f14238O000000o = null;
                this.O00000Oo.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class O00000Oo extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        AACEncodeEx f14239O000000o;
        faf O00000Oo;
        private byte[] O00000o;
        private byte[] O00000oO;

        O00000Oo() {
            super("AudioEncodeSendThread");
        }

        public final int doRepeatWork() throws InterruptedException {
            if (!this.mIsRunning) {
                return 0;
            }
            AudioProcess.O000000o o000000o = null;
            if (cqg.this.O00000Oo != null) {
                o000000o = cqg.this.O00000Oo.O0000oO0.take();
            }
            if (!(o000000o == null || o000000o.f5398O000000o == null)) {
                byte[] bArr = new byte[o000000o.f5398O000000o.length];
                cqg.this.O000000o(o000000o.f5398O000000o, bArr, (float) cqg.this.O0000OOo);
                if (cqg.this.O00000o0 != null) {
                    this.O00000Oo.O00000Oo(bArr);
                    if (o000000o.O00000o0 == 1030) {
                        if (this.O00000Oo.O000000o(this.O00000o)) {
                            AACEncodeEx aACEncodeEx = this.f14239O000000o;
                            byte[] bArr2 = this.O00000o;
                            byte[] encode = aACEncodeEx.encode(bArr2, 0, bArr2.length);
                            if (encode != null) {
                                cqg.this.O00000o0.onSendAudio(encode, 136);
                            }
                        }
                    } else if (cqg.this.O00000o) {
                        cki.O00000o("AudioEngine", "decode AUDIO_CODEC_PCM audioFrame.data=" + o000000o.f5398O000000o.length);
                        cqg.this.O00000o0.onSendAudio(o000000o.f5398O000000o, 1024);
                    } else if (this.O00000Oo.O000000o(this.O00000oO)) {
                        byte[] bArr3 = this.O00000oO;
                        byte[] encode2 = G711.encode(bArr3, 0, bArr3.length);
                        if (encode2 != null) {
                            cqg.this.O00000o0.onSendAudio(encode2, 138);
                        }
                    }
                }
            }
            return 0;
        }

        public final void doInitial() {
            this.f14239O000000o = new AACEncodeEx();
            this.f14239O000000o.initial(16000, 1, 32000);
            this.O00000o = new byte[2048];
            this.O00000oO = new byte[1280];
            this.O00000Oo = new faf();
        }

        public final void doRelease() {
            AACEncodeEx aACEncodeEx = this.f14239O000000o;
            if (aACEncodeEx != null) {
                aACEncodeEx.release();
                this.f14239O000000o = null;
            }
            this.O00000o = null;
            this.O00000Oo.O000000o();
            this.O00000oO = null;
            this.O00000Oo = null;
        }
    }
}
