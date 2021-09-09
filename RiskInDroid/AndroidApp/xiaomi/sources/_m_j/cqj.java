package _m_j;

import _m_j.bwz;
import _m_j.cqk;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.madv.soundtouch.SoundTouch;
import com.p2p.audio.AudioEngineBase;
import com.tutk.IAudioSender;
import com.xiaomi.aaccodec.AACDecodeEx;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public final class cqj extends AudioEngineBase {

    /* renamed from: O000000o  reason: collision with root package name */
    public cqk f14242O000000o = null;
    public LinkedBlockingQueue<cql> O00000Oo;
    public bwz O00000o;
    public IAudioSender O00000o0;
    private int O0000Ooo;
    private volatile fsg O0000o0;
    private volatile fsg O0000o00;

    public cqj(Context context, String str) {
        super(context);
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("chuangmi.camera.039a01")) {
            this.O0000OOo = 1.0d;
        }
        this.O00000Oo = new LinkedBlockingQueue<>(200);
        this.f14242O000000o = new cqk(context, str);
        this.O0000OoO = str;
    }

    public final synchronized void O000000o() {
        if (this.O0000Ooo != 1) {
            if (this.O0000o0 != null) {
                this.O0000o0.stopThreadAsyn();
                this.O0000o0 = null;
            }
            if (this.f14242O000000o != null) {
                this.f14242O000000o.O00000o();
            }
            this.O00000Oo.clear();
            this.f14242O000000o.O000000o();
            if (this.O0000o0 == null) {
                this.O0000o0 = new O000000o();
                this.O0000o0.start();
            }
            cqh.O000000o(this.O0000Oo, "audioFoucs");
            this.O0000Ooo = 1;
            cqh.O000000o(this.O0000Oo, "focus audio");
        }
    }

    public final synchronized void O00000Oo() {
        if (this.O0000Ooo != 3) {
            boolean z = this.O0000o0 != null;
            if (this.O0000o00 != null) {
                this.O0000o00.stopThreadAsyn();
                this.O0000o00 = null;
            }
            if (this.f14242O000000o != null) {
                this.f14242O000000o.O00000oO();
                if (z) {
                    this.f14242O000000o.O00000o();
                }
            }
            if (this.f14242O000000o != null) {
                this.f14242O000000o.O00000Oo();
                if (z) {
                    this.f14242O000000o.O000000o();
                }
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
        if (this.f14242O000000o != null) {
            this.f14242O000000o.O00000o0();
        }
        this.O00000Oo.clear();
        if (this.O0000o0 != null) {
            this.O0000o0.stopThreadAsyn();
            this.O0000o0 = null;
        }
        if (this.O0000o00 != null) {
            this.O0000o00.stopThreadAsyn();
            this.O0000o00 = null;
        }
        cqh.O00000Oo(this.O0000Oo, "abandon audio");
    }

    public final void O000000o(byte[] bArr, long j, int i, int i2, short s, short s2) {
        if (this.O0000Ooo != 0) {
            if (i == 138) {
                i = 1027;
            } else if (i == 136) {
                i = 1030;
            } else if (i == 140) {
                i = 1024;
            }
            cql cql = new cql();
            cql.f14252O000000o = bArr;
            cql.O00000oO = j;
            cql.O00000Oo = i2;
            cql.O00000o = s2;
            cql.O00000o0 = s;
            if (TextUtils.equals("chuangmi.gateway.ipc011", this.O0000OoO)) {
                cql.O00000o0 = 1;
            }
            cql.O00000oo = i;
            if (this.O00000Oo.size() > 150) {
                cki.O00000o("AudioEngineNew", "playAudio is full");
                return;
            }
            try {
                this.O00000Oo.put(cql);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        if (TextUtils.equals("chuangmi.gateway.ipc011", this.O0000OoO)) {
            i2 = 1;
        }
        cqk cqk = this.f14242O000000o;
        cqk.O0000OoO = i2;
        cqk.O0000Ooo = i;
        cqk.O0000o00 = i3;
        cqk.O0000o0 = i4;
        int i5 = i == 0 ? 8000 : 16000;
        if (DeviceModelManager.getInstance().isHualaiCamera(cqk.O0000oO0)) {
            cqk.O0000o0O = 640;
        } else {
            cqk.O0000o0O = ((i5 * 2) * 10) / 1000;
        }
    }

    public final void O00000o0() {
        cqk cqk;
        boolean z = this.O0000o0 != null;
        cqk cqk2 = this.f14242O000000o;
        if (cqk2 != null) {
            cqk2.O00000oO();
            if (z) {
                this.f14242O000000o.O00000o();
            }
        }
        if (this.O0000o00 != null) {
            this.O0000o00.stopThreadAsyn();
            this.O0000o00 = null;
        }
        if (z && (cqk = this.f14242O000000o) != null) {
            cqk.O000000o();
        }
        if (z) {
            this.O0000Ooo = 1;
        } else {
            this.O0000Ooo = 0;
        }
    }

    public final void O00000o() {
        AudioManager audioManager = (AudioManager) this.O0000Oo.getSystemService("audio");
        audioManager.setBluetoothScoOn(false);
        audioManager.stopBluetoothSco();
    }

    public final void O00000oo() {
        cqk cqk = this.f14242O000000o;
        if (cqk != null) {
            cqk.O00000o();
        }
        if (this.O0000o0 != null) {
            this.O0000o0.stopThreadAsyn();
            this.O0000o0 = null;
        }
        if (this.O0000o00 != null) {
            this.O0000Ooo = 3;
        } else {
            this.O0000Ooo = 0;
        }
        cqh.O00000Oo(this.O0000Oo, "abandon audio");
    }

    class O000000o extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        byte[] f14243O000000o;
        AACDecodeEx O00000Oo;

        public O000000o() {
            super("AudioDecodeThread");
        }

        public final int doRepeatWork() throws InterruptedException {
            int i;
            try {
                cki.O00000o("Audio", "mAudioFrameQueue==" + cqj.this.O00000Oo.size());
                cql take = cqj.this.O00000Oo.take();
                if (take != null && this.mIsRunning) {
                    if (take.O00000oo == 1027) {
                        i = G711.decode(take.f14252O000000o, 0, take.f14252O000000o.length, this.f14243O000000o);
                    } else if (take.O00000oo == 1030) {
                        i = this.O00000Oo.decode(take.f14252O000000o, 0, take.f14252O000000o.length, this.f14243O000000o, this.f14243O000000o.length);
                    } else if (take.O00000oo == 1024) {
                        i = 640;
                        this.f14243O000000o = take.f14252O000000o;
                    } else {
                        i = 0;
                    }
                    if (i > 0 && this.mIsRunning) {
                        byte[] bArr = new byte[i];
                        System.arraycopy(this.f14243O000000o, 0, bArr, 0, i);
                        cqk.O000000o o000000o = new cqk.O000000o(bArr, take);
                        if (cqj.this.f14242O000000o != null) {
                            cqk cqk = cqj.this.f14242O000000o;
                            if (cqk.O00000o0 != null && cqk.O00000o0.isRunning()) {
                                if (cqk.O0000o0o.size() > 10) {
                                    cqk.O0000o0o.clear();
                                }
                                cqk.O0000o0o.put(o000000o);
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
            this.f14243O000000o = new byte[10240];
            this.O00000Oo = new AACDecodeEx();
            this.O00000Oo.initial();
        }

        public final void doRelease() {
            try {
                this.f14243O000000o = null;
                this.O00000Oo.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class O00000Oo extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        AACEncodeEx f14244O000000o;
        faf O00000Oo;
        private byte[] O00000o;
        private byte[] O00000oO;
        private int O00000oo;

        O00000Oo() {
            super("AudioEncodeSendThread");
            if ("mijia.camera.v1".equals(cqj.this.O0000OoO)) {
                this.O00000oo = 1;
            } else {
                this.O00000oo = 138;
            }
        }

        public final int doRepeatWork() throws InterruptedException {
            int receiveSamples;
            if (!this.mIsRunning) {
                return 0;
            }
            final cqk.O000000o o000000o = null;
            if (cqj.this.f14242O000000o != null) {
                o000000o = cqj.this.f14242O000000o.O0000o.take();
            }
            if (!(o000000o == null || o000000o.f14248O000000o == null || cqj.this.O00000o0 == null)) {
                if (cqj.this.O00000o == null || !cqj.this.O00000o.O00000o0) {
                    O000000o(o000000o);
                } else {
                    bwz bwz = cqj.this.O00000o;
                    AnonymousClass1 r3 = new bwz.O000000o() {
                        /* class _m_j.cqj.O00000Oo.AnonymousClass1 */

                        public final void O000000o(byte[] bArr) {
                            cqk.O000000o o000000o = o000000o;
                            o000000o.f14248O000000o = bArr;
                            O00000Oo.this.O000000o(o000000o);
                        }
                    };
                    if (bwz.O00000o0) {
                        SoundTouch soundTouch = bwz.O00000Oo;
                        soundTouch.putSamples(soundTouch.f4548O000000o, o000000o.f14248O000000o, o000000o.f14248O000000o.length);
                        int length = o000000o.f14248O000000o.length;
                        do {
                            SoundTouch soundTouch2 = bwz.O00000Oo;
                            receiveSamples = soundTouch2.receiveSamples(soundTouch2.f4548O000000o, bwz.O00000o, length - bwz.O00000oo);
                            if (receiveSamples > 0) {
                                System.arraycopy(bwz.O00000o, 0, bwz.O00000oO, bwz.O00000oo, receiveSamples);
                                bwz.O00000oo += receiveSamples;
                                if (bwz.O00000oo == length) {
                                    byte[] bArr = new byte[length];
                                    System.arraycopy(bwz.O00000oO, 0, bArr, 0, length);
                                    bwz.O00000oo = 0;
                                    Arrays.fill(bwz.O00000oO, 0, bwz.O00000oO.length, (byte) 0);
                                    r3.O000000o(bArr);
                                    continue;
                                } else {
                                    cki.O00000o("SoundTransformer", "lose=====");
                                    continue;
                                }
                            }
                        } while (receiveSamples > 0);
                    }
                    return 0;
                }
            }
            return 0;
        }

        public final void O000000o(cqk.O000000o o000000o) {
            if (o000000o != null && o000000o.f14248O000000o != null) {
                if (o000000o.O00000o0 == 1030 || o000000o.O00000o0 == 1027) {
                    byte[] bArr = new byte[o000000o.f14248O000000o.length];
                    cqj.this.O000000o(o000000o.f14248O000000o, bArr, (float) cqj.this.O0000OOo);
                    this.O00000Oo.O00000Oo(bArr);
                }
                if (o000000o.O00000o0 == 1030) {
                    if (this.O00000Oo.O000000o(this.O00000o)) {
                        AACEncodeEx aACEncodeEx = this.f14244O000000o;
                        byte[] bArr2 = this.O00000o;
                        byte[] encode = aACEncodeEx.encode(bArr2, 0, bArr2.length);
                        if (encode != null) {
                            cqj.this.O00000o0.onSendAudio(encode, 136);
                        }
                    }
                } else if (o000000o.O00000o0 == 1027) {
                    if (this.O00000Oo.O000000o(this.O00000oO)) {
                        byte[] bArr3 = this.O00000oO;
                        byte[] encode2 = G711.encode(bArr3, 0, bArr3.length);
                        if (encode2 != null) {
                            cqj.this.O00000o0.onSendAudio(encode2, this.O00000oo);
                        }
                    }
                } else if (o000000o.O00000o0 == 1024) {
                    cqj.this.O00000o0.onSendAudio(o000000o.f14248O000000o, this.O00000oo);
                }
            }
        }

        public final void doInitial() {
            this.f14244O000000o = new AACEncodeEx();
            this.f14244O000000o.initial(16000, 1, 32000);
            this.O00000o = new byte[2048];
            if (TextUtils.equals(cqj.this.O0000OoO, "loock.cateye.v02")) {
                this.O00000oO = new byte[960];
            } else {
                this.O00000oO = new byte[1280];
            }
            this.O00000Oo = new faf();
        }

        public final void doRelease() {
            AACEncodeEx aACEncodeEx = this.f14244O000000o;
            if (aACEncodeEx != null) {
                aACEncodeEx.release();
                this.f14244O000000o = null;
            }
            this.O00000o = null;
            this.O00000Oo.O000000o();
            this.O00000oO = null;
            this.O00000Oo = null;
        }
    }
}
