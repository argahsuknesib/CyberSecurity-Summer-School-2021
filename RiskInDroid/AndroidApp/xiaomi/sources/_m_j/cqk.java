package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.google.webrtc.apm.WebRtcJni;
import com.xiaomi.mistream.ClassTransUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public final class cqk {

    /* renamed from: O000000o  reason: collision with root package name */
    WebRtcJni.WebRtcAecm f14246O000000o = null;
    public volatile int O00000Oo;
    public volatile int O00000o = 0;
    O00000Oo O00000o0;
    public volatile int O00000oO = 0;
    public AudioManager O00000oo;
    public int O0000O0o = 60;
    public String O0000OOo;
    public ConditionVariable O0000Oo = new ConditionVariable();
    public boolean O0000Oo0 = false;
    public int O0000OoO = -1;
    public int O0000Ooo = -1;
    public LinkedBlockingQueue<O000000o> O0000o = new LinkedBlockingQueue<>(15);
    public int O0000o0 = -1;
    public int O0000o00 = -1;
    public int O0000o0O;
    public LinkedBlockingQueue<O000000o> O0000o0o = new LinkedBlockingQueue<>(15);
    public Context O0000oO;
    String O0000oO0 = null;
    private final int O0000oOO = 0;
    private final int O0000oOo = 1;
    private final int O0000oo = 3;
    private final int O0000oo0 = 2;
    private int O0000ooO = 0;
    private O00000o0 O0000ooo;
    private faf O00oOooO = null;

    public cqk(Context context, String str) {
        this.O00000oo = (AudioManager) context.getSystemService("audio");
        this.O0000oO0 = str;
        if (this.O00000oo.isWiredHeadsetOn()) {
            this.O00000Oo = 2;
        } else {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || defaultAdapter.getProfileConnectionState(1) != 2) {
                this.O00000Oo = 1;
            } else {
                this.O00000Oo = 3;
            }
        }
        cki.O00000o("AudioProcess", "initAudioMode mode = " + this.O00000Oo);
        this.O0000oO = context.getApplicationContext();
    }

    public final synchronized void O000000o(int i) {
        cki.O00000o("AudioProcess", "setAudioMode mode = ".concat(String.valueOf(i)));
        if (this.O00000Oo != i) {
            this.O00000Oo = i;
            if ((this.O0000ooO & 2) == 2) {
                cki.O00000o("AudioProcess", "restart speak");
                O00000oO();
                O00000Oo();
            }
            if ((this.O0000ooO & 1) == 1 && (this.O0000ooO & 2) == 2) {
                new Handler().postDelayed(new Runnable() {
                    /* class _m_j.cqk.AnonymousClass1 */

                    public final void run() {
                        cki.O00000o("AudioProcess", "delay restart play 1000ms while calling");
                        cqk.this.O00000o();
                        cqk.this.O000000o();
                    }
                }, 800);
            }
        }
    }

    public final synchronized void O000000o() {
        cki.O00000o("AudioProcess", "startPlay");
        this.O0000ooO |= 1;
        if (this.O00000o0 == null) {
            this.O00000o0 = new O00000Oo();
            this.O00000o0.start();
        }
    }

    public final void O00000Oo() {
        cki.O00000o("AudioProcess", "startCall");
        this.O0000Oo0 = true;
        this.O0000ooO |= 2;
        this.O0000Oo.close();
        if (this.O0000ooo == null) {
            this.O0000ooo = new O00000o0();
            this.O0000ooo.start();
        }
    }

    public final synchronized void O00000o0() {
        cki.O00000o("AudioProcess", "stop");
        try {
            this.O0000Oo0 = false;
            this.O0000ooO = 0;
            this.O0000o0o.clear();
            this.O0000o.clear();
            if (this.O00000o0 != null) {
                this.O00000o0.stopThreadAsyn();
                this.O00000o0 = null;
            }
            if (this.O0000ooo != null) {
                this.O0000ooo.stopThreadSyn();
                this.O0000ooo = null;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void O00000o() {
        this.O0000ooO &= -2;
        this.O0000o0o.clear();
        if (this.O00000o0 != null) {
            this.O00000o0.stopThreadAsyn();
            this.O00000o0 = null;
        }
    }

    public final synchronized void O00000oO() {
        cki.O00000o("AudioProcess", "stop");
        try {
            this.O0000Oo0 = false;
            this.O0000ooO &= -3;
            this.O0000o.clear();
            if (this.O0000ooo != null) {
                this.O0000ooo.stopThreadSyn();
                this.O0000ooo = null;
            }
        } catch (Exception unused) {
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public byte[] f14248O000000o;
        public long O00000Oo = 0;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public int O00000oo;

        public O000000o(byte[] bArr, cql cql) {
            this.f14248O000000o = bArr;
            this.O00000Oo = cql.O00000oO;
            this.O00000o0 = cql.O00000oo;
            this.O00000o = cql.O00000Oo;
            this.O00000oO = cql.O00000o0;
            this.O00000oo = cql.O00000o;
        }

        public O000000o(byte[] bArr, long j, int i) {
            this.f14248O000000o = bArr;
            this.O00000Oo = j;
            this.O00000o0 = i;
        }
    }

    class O00000Oo extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        AudioTrack f14249O000000o;
        byte[] O00000Oo = null;
        ByteBuffer O00000o = null;
        faf O00000o0 = null;
        private int O00000oo = -1;
        private int O0000O0o = -1;
        private int O0000OOo = -1;

        O00000Oo() {
            super("AudioPlayThread");
        }

        public final void doInitial() {
            cki.O00000o("AudioProcess", "AudioPlayThread doInitial");
            Process.setThreadPriority(-19);
        }

        private void O000000o(int i) {
            cki.O00000o("AudioProcess", "sample buffer ".concat(String.valueOf(i)));
            faf faf = this.O00000o0;
            if (faf != null) {
                faf.O000000o();
            }
            this.O00000Oo = new byte[i];
            ByteBuffer byteBuffer = this.O00000o;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
            this.O00000o = ByteBuffer.allocateDirect(i);
        }

        private void O000000o() {
            AudioTrack audioTrack = this.f14249O000000o;
            if (audioTrack != null) {
                audioTrack.flush();
                this.f14249O000000o.release();
                this.f14249O000000o = null;
            }
            faf faf = this.O00000o0;
            if (faf != null) {
                faf.O000000o();
                this.O00000o0 = null;
            }
            this.O00000Oo = null;
        }

        public final int doRepeatWork() throws InterruptedException {
            int i;
            if (!this.mIsRunning) {
                return 0;
            }
            faf faf = this.O00000o0;
            if (faf == null || !faf.O000000o(this.O00000Oo) || this.O00000o == null) {
                O000000o take = cqk.this.O0000o0o.take();
                if (take != null) {
                    if (this.O00000oo == take.O00000o && this.O0000O0o == take.O00000oO && this.O0000OOo == take.O00000oo) {
                        if (this.O00000o == null) {
                            O000000o(take.f14248O000000o.length);
                        }
                        this.O00000o0.O00000Oo(take.f14248O000000o);
                    } else {
                        O000000o();
                        if (take != null && this.f14249O000000o == null) {
                            this.O00000oo = take.O00000o;
                            this.O0000O0o = take.O00000oO;
                            this.O0000OOo = take.O00000oo;
                            int i2 = this.O00000oo == 0 ? 8000 : 16000;
                            if (TextUtils.isEmpty(cqk.this.O0000OOo) || !"mijia.camera.v3".equals(cqk.this.O0000OOo)) {
                                cqk.this.f14246O000000o = new WebRtcJni.WebRtcAecm(i2, false, 2);
                            } else {
                                cqk.this.f14246O000000o = new WebRtcJni.WebRtcAecm(i2, false, 3);
                            }
                            if (cqk.this.O0000Oo0) {
                                cqk.this.O0000Oo.block(1500);
                            }
                            int minBufferSize = AudioTrack.getMinBufferSize(this.O00000oo == 0 ? 8000 : 16000, this.O0000OOo == 0 ? 4 : 12, this.O0000O0o == 0 ? 3 : 2);
                            cki.O00000o("AudioProcess", "AudioTrack minSize:" + minBufferSize + " rate " + i2);
                            if (cqk.this.O00000oo.isBluetoothScoOn() && this.O0000OOo != 0) {
                                cki.O00000o("AudioProcess", "Sco only support 8k or 16k mono split it");
                            }
                            int i3 = cqk.this.O0000Oo0 ? 0 : 3;
                            try {
                                if (cqk.this.O00000o > 0) {
                                    this.f14249O000000o = new AudioTrack(i3, this.O00000oo == 0 ? 8000 : 16000, this.O0000OOo == 0 ? 4 : 12, this.O0000O0o == 0 ? 3 : 2, minBufferSize, 1, cqk.this.O00000o);
                                } else {
                                    this.f14249O000000o = new AudioTrack(i3, this.O00000oo == 0 ? 8000 : 16000, this.O0000OOo == 0 ? 4 : 12, this.O0000O0o == 0 ? 3 : 2, minBufferSize, 1);
                                }
                                if (cqk.this.O0000Oo0) {
                                    cqk cqk = cqk.this;
                                    if (cqk.O00000Oo == 1) {
                                        cqk.O00000oo.setSpeakerphoneOn(true);
                                    } else {
                                        cqk.O00000oo.setSpeakerphoneOn(false);
                                    }
                                }
                                this.f14249O000000o.play();
                            } catch (Exception e) {
                                cki.O00000oO("AudioProcess", "AudioTrack init".concat(String.valueOf(e)));
                                this.f14249O000000o = null;
                            }
                            faf faf2 = this.O00000o0;
                            if (faf2 != null) {
                                faf2.O000000o();
                            }
                            this.O00000o0 = new faf();
                            cqk.this.O0000o0o.clear();
                        }
                        O000000o(take.f14248O000000o.length);
                    }
                }
            } else {
                if (duc.O000000o()) {
                    this.O00000o.clear();
                    this.O00000o.put(this.O00000Oo);
                    this.O00000o.rewind();
                    AudioTrack audioTrack = this.f14249O000000o;
                    ByteBuffer byteBuffer = this.O00000o;
                    i = audioTrack.write(byteBuffer, byteBuffer.capacity(), 0);
                } else {
                    AudioTrack audioTrack2 = this.f14249O000000o;
                    byte[] bArr = this.O00000Oo;
                    i = audioTrack2.write(bArr, 0, bArr.length);
                }
                if (i != this.O00000Oo.length) {
                    cki.O00000oO("AudioProcess", "audioTrack.write size error:".concat(String.valueOf(i)));
                }
            }
            return 0;
        }

        public final void doRelease() {
            cki.O00000o("AudioProcess", "AudioPlayThread doRelease");
            O000000o();
        }
    }

    class O00000o0 extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14250O000000o;
        byte[] O00000Oo;
        private AudioRecord O00000o;
        private AcousticEchoCanceler O00000oO;
        private AutomaticGainControl O00000oo;

        O00000o0() {
            super("AudioRecordThread");
        }

        public final void doInitial() {
            int i;
            cki.O00000o("AudioProcess", "AudioRecordThread doInitial");
            Process.setThreadPriority(-19);
            if (this.O00000o == null) {
                if (cqk.this.O0000Oo0) {
                    cqk.this.O00000oo.setMode(3);
                    if (3 == cqk.this.O00000Oo && !cqk.this.O00000oo.isBluetoothScoOn()) {
                        cki.O00000o("AudioProcess", "sco not ready");
                        final ConditionVariable conditionVariable = new ConditionVariable(false);
                        AnonymousClass1 r6 = new BroadcastReceiver() {
                            /* class _m_j.cqk.O00000o0.AnonymousClass1 */

                            public final void onReceive(Context context, Intent intent) {
                                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                                StringBuilder sb = new StringBuilder("sco state ");
                                sb.append(1 == intExtra);
                                sb.append(" ");
                                sb.append(intent);
                                cki.O00000o("AudioProcess", sb.toString());
                                if (1 == intExtra) {
                                    conditionVariable.open();
                                }
                            }
                        };
                        try {
                            cqk.this.O0000oO.registerReceiver(r6, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                            cqk.this.O00000oo.setBluetoothScoOn(true);
                            cqk.this.O00000oo.startBluetoothSco();
                            cki.O00000o("AudioProcess", "start sco");
                            conditionVariable.block(3000);
                        } catch (Exception e) {
                            cki.O00000o("AudioProcess", "start sco exp " + e.toString());
                        }
                        cqk.this.O0000oO.unregisterReceiver(r6);
                        if (!cqk.this.O00000oo.isBluetoothScoOn()) {
                            cki.O00000o("AudioProcess", "scoRecv start fail");
                            cqk.this.O00000oo.stopBluetoothSco();
                            cqk.this.O00000oo.setBluetoothScoOn(false);
                        } else {
                            cki.O00000o("AudioProcess", "scoRecv start success");
                            if (cqk.this.O0000o00 != 0) {
                                cki.O00000oO("AudioProcess", "SCO only support 8k or 16k mono play record may have exception");
                            }
                        }
                    }
                    i = 7;
                } else {
                    i = 1;
                }
                cqk.this.O0000o.clear();
                int i2 = 16000;
                this.f14250O000000o = AudioRecord.getMinBufferSize(cqk.this.O0000Ooo == 0 ? 8000 : 16000, cqk.this.O0000o00 == 0 ? 16 : 12, cqk.this.O0000OoO == 0 ? 3 : 2);
                if (cqk.this.O0000o0O > this.f14250O000000o) {
                    this.f14250O000000o = cqk.this.O0000o0O;
                }
                cki.O00000oO("AudioProcess", "AudioRecord mini size :" + this.f14250O000000o);
                this.O00000Oo = new byte[cqk.this.O0000o0O];
                try {
                    if (cqk.this.O0000Ooo == 0) {
                        i2 = 8000;
                    }
                    this.O00000o = new AudioRecord(i, i2, cqk.this.O0000o00 == 0 ? 16 : 12, cqk.this.O0000OoO == 0 ? 3 : 2, this.f14250O000000o);
                    if (AutomaticGainControl.isAvailable()) {
                        cki.O00000o("AudioProcess", "AutomaticGainControl.isAvailable()");
                        this.O00000oo = AutomaticGainControl.create(this.O00000o.getAudioSessionId());
                        if (this.O00000oo != null) {
                            this.O00000oo.setEnabled(true);
                        }
                    }
                    if (AcousticEchoCanceler.isAvailable()) {
                        cki.O00000o("AudioProcess", "AcousticEchoCanceler.isAvailable()");
                        this.O00000oO = AcousticEchoCanceler.create(this.O00000o.getAudioSessionId());
                        if (this.O00000oO != null) {
                            this.O00000oO.setEnabled(true);
                        }
                    }
                    try {
                        this.O00000o.startRecording();
                        if (cqk.this.O0000Oo0) {
                            cqk.this.O0000Oo.open();
                        }
                        cki.O00000o("AudioProcess", "init Record success");
                    } catch (Exception e2) {
                        this.O00000o = null;
                        cki.O00000oO("AudioProcess", "AudioRecord initial " + e2.toString());
                    }
                } catch (IllegalArgumentException e3) {
                    this.O00000o = null;
                    int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
                    cki.O00000oO("AudioProcess", "AudioRecord init Error  min size" + minBufferSize + "   Exception:" + e3.toString());
                }
            }
        }

        public final int doRepeatWork() throws InterruptedException {
            AudioRecord audioRecord;
            if (this.mIsRunning && (audioRecord = this.O00000o) != null) {
                byte[] bArr = this.O00000Oo;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (read != this.O00000Oo.length) {
                    cki.O00000oO("AudioProcess", "error record:".concat(String.valueOf(read)));
                }
                if (read > 0) {
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(this.O00000Oo, 0, bArr2, 0, read);
                    short[] bytes2Shorts = ClassTransUtils.getInstance().bytes2Shorts(bArr2);
                    long j = 0;
                    for (int i = 0; i < bytes2Shorts.length; i++) {
                        j += (long) (bytes2Shorts[i] * bytes2Shorts[i]);
                    }
                    double d = (double) j;
                    double d2 = (double) read;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    double d3 = d / d2;
                    cqk.this.O00000oO = d3 > 0.0d ? (int) (Math.log10(d3) * 10.0d) : 50;
                    if (cqk.this.O0000Oo0 && this.mIsRunning) {
                        cqk.this.O0000o.put(new O000000o(bArr2, System.currentTimeMillis(), cqk.this.O0000o0));
                    }
                }
            }
            return 0;
        }

        public final void doRelease() {
            AudioRecord audioRecord = this.O00000o;
            if (audioRecord != null) {
                audioRecord.release();
                this.O00000o = null;
            }
            this.O00000Oo = null;
            if (cqk.this.O00000oo.isBluetoothScoOn()) {
                cqk.this.O00000oo.stopBluetoothSco();
                cqk.this.O00000oo.setBluetoothScoOn(false);
            }
            AcousticEchoCanceler acousticEchoCanceler = this.O00000oO;
            if (acousticEchoCanceler != null) {
                acousticEchoCanceler.setEnabled(false);
            }
            cqk.this.O00000oo.setMode(0);
            cki.O00000o("AudioProcess", "releaseRecorder");
            AutomaticGainControl automaticGainControl = this.O00000oo;
            if (automaticGainControl != null) {
                automaticGainControl.setEnabled(false);
            }
            cki.O00000o("AudioProcess", "AudioRecordThread doRelease");
        }
    }
}
