package com.p2p.audio;

import _m_j.cki;
import _m_j.duc;
import _m_j.faf;
import _m_j.fsg;
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
import android.os.Process;
import android.text.TextUtils;
import com.google.webrtc.apm.WebRtcJni;
import com.xiaomi.mistream.ClassTransUtils;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public class AudioProcess {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f5397O000000o;
    public volatile int O00000Oo;
    public O00000Oo O00000o;
    public int O00000o0;
    public volatile int O00000oO = 0;
    public volatile int O00000oo = 0;
    public AudioManager O0000O0o;
    public int O0000OOo = 120;
    WebRtcJni.WebRtcAecm O0000Oo = null;
    public String O0000Oo0;
    public boolean O0000OoO = false;
    public ConditionVariable O0000Ooo = new ConditionVariable();
    public LinkedBlockingQueue<O000000o> O0000o = new LinkedBlockingQueue<>(15);
    public int O0000o0 = 18;
    public int O0000o00;
    public boolean O0000o0O = false;
    public boolean O0000o0o = true;
    public faf O0000oO = null;
    public LinkedBlockingQueue<O000000o> O0000oO0 = new LinkedBlockingQueue<>(15);
    private int O0000oOO = 0;
    private final int O0000oOo = 0;
    private final int O0000oo = 2;
    private final int O0000oo0 = 1;
    private final int O0000ooO = 3;
    private O00000o0 O0000ooo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public byte[] f5398O000000o;
        public long O00000Oo = 0;
        public int O00000o0;

        public O000000o(byte[] bArr, long j, int i) {
            this.f5398O000000o = bArr;
            this.O00000Oo = j;
            this.O00000o0 = i;
        }
    }

    public AudioProcess(Context context) {
        this.O0000O0o = (AudioManager) context.getSystemService("audio");
        O00000o();
    }

    public AudioProcess(Context context, String str) {
        this.O0000Oo0 = str;
        this.O0000O0o = (AudioManager) context.getSystemService("audio");
        O00000o();
        this.f5397O000000o = context.getApplicationContext();
    }

    public final synchronized void O000000o(int i) {
        cki.O00000o("AudioProcess", "setAudioMode mode = ".concat(String.valueOf(i)));
        if (this.O00000Oo != i) {
            this.O00000Oo = i;
            if (this.O0000oOO == 3) {
                O00000o0();
                O00000Oo();
            }
        }
    }

    private void O00000o() {
        if (TextUtils.isEmpty(this.O0000Oo0) || !"mijia.camera.v3".equals(this.O0000Oo0)) {
            this.O0000Oo = new WebRtcJni.WebRtcAecm(this.O00000o0, false, 2);
        } else {
            this.O0000Oo = new WebRtcJni.WebRtcAecm(this.O00000o0, false, 3);
        }
        if (this.O0000O0o.isWiredHeadsetOn()) {
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
    }

    public final synchronized void O000000o() {
        cki.O00000o("AudioProcess", "startPlay");
        this.O0000oOO = 1;
        if (this.O00000o == null) {
            this.O00000o = new O00000Oo();
            this.O00000o.start();
        }
    }

    public final void O00000Oo() {
        O00000o0();
        cki.O00000o("AudioProcess", "startCall");
        if (this.O00000Oo == 1) {
            this.O0000O0o.setSpeakerphoneOn(true);
        }
        this.O0000OoO = true;
        this.O0000oOO = 3;
        this.O0000Ooo.close();
        if (this.O0000ooo == null) {
            this.O0000ooo = new O00000o0();
            this.O0000ooo.start();
        }
        if (this.O00000o == null) {
            this.O00000o = new O00000Oo();
            this.O00000o.start();
        }
    }

    public final synchronized void O00000o0() {
        cki.O00000o("AudioProcess", "stop");
        try {
            if (this.O0000OoO) {
                this.O0000O0o.setSpeakerphoneOn(false);
            }
            this.O0000OoO = false;
            this.O0000oOO = 0;
            this.O0000o.clear();
            this.O0000oO0.clear();
            if (this.O00000o != null) {
                this.O00000o.stopThreadAsyn();
                this.O00000o = null;
            }
            if (this.O0000ooo != null) {
                this.O0000ooo.stopThreadAsyn();
                this.O0000ooo = null;
            }
        } catch (Exception unused) {
        }
    }

    public class O00000Oo extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        AudioTrack f5399O000000o;
        byte[] O00000Oo = null;
        ByteBuffer O00000o = null;
        faf O00000o0 = null;
        private int O00000oo;

        O00000Oo() {
            super("AudioPlayThread");
        }

        public final void doInitial() {
            cki.O00000o("AudioProcess", "AudioPlayThread doInitial");
            Process.setThreadPriority(-19);
            O000000o();
        }

        private void O000000o() {
            if (this.f5399O000000o == null) {
                if (AudioProcess.this.O00000o0 == 8000) {
                    this.O00000oo = 1027;
                } else {
                    this.O00000oo = 1030;
                }
                if (!TextUtils.isEmpty(AudioProcess.this.O0000Oo0) && ("chuangmi.camera.ipc019".equals(AudioProcess.this.O0000Oo0) || DeviceConstant.isG711(AudioProcess.this.O0000Oo0))) {
                    this.O00000oo = 1027;
                }
                if (AudioProcess.this.O0000OoO) {
                    AudioProcess.this.O0000Ooo.block(1500);
                }
                int minBufferSize = AudioTrack.getMinBufferSize(AudioProcess.this.O00000o0, 4, 2);
                cki.O00000o("AudioProcess", "AudioTrack minSize:" + minBufferSize + " rate " + AudioProcess.this.O00000o0);
                int i = AudioProcess.this.O0000OoO ? 0 : 3;
                try {
                    if (AudioProcess.this.O00000oO > 0) {
                        this.f5399O000000o = new AudioTrack(i, AudioProcess.this.O00000o0, 4, 2, minBufferSize, 1, AudioProcess.this.O00000oO);
                    } else {
                        this.f5399O000000o = new AudioTrack(i, AudioProcess.this.O00000o0, 4, 2, minBufferSize, 1);
                    }
                    if (AudioProcess.this.O0000OoO) {
                        O00000Oo();
                    }
                    this.f5399O000000o.play();
                } catch (Exception e) {
                    cki.O00000oO("AudioProcess", "AudioTrack init".concat(String.valueOf(e)));
                    this.f5399O000000o = null;
                }
                faf faf = this.O00000o0;
                if (faf != null) {
                    faf.O000000o();
                }
                this.O00000o0 = new faf();
                AudioProcess.this.O0000o.clear();
            }
        }

        private void O00000Oo() {
            if (AudioProcess.this.O00000Oo == 1) {
                AudioProcess.this.O0000O0o.setSpeakerphoneOn(true);
            } else {
                AudioProcess.this.O0000O0o.setSpeakerphoneOn(false);
            }
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

        private void O00000o0() {
            AudioTrack audioTrack = this.f5399O000000o;
            if (audioTrack != null) {
                audioTrack.flush();
                this.f5399O000000o.release();
                this.f5399O000000o = null;
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
            O000000o take;
            int i2;
            if (!this.mIsRunning) {
                return 0;
            }
            int i3 = 16000;
            int i4 = 8000;
            if (!AudioProcess.this.O0000o0O || !"isa.camera.hlc6".equals(AudioProcess.this.O0000Oo0)) {
                if (!this.O00000o0.O000000o(this.O00000Oo) || this.O00000o == null) {
                    O000000o take2 = AudioProcess.this.O0000o.take();
                    if (take2 != null) {
                        if (take2.O00000o0 <= 0 || this.O00000oo == take2.O00000o0) {
                            if (this.O00000o == null) {
                                O000000o(take2.f5398O000000o.length);
                            }
                            this.O00000o0.O00000Oo(take2.f5398O000000o);
                        } else {
                            O00000o0();
                            AudioProcess audioProcess = AudioProcess.this;
                            if (take2.O00000o0 == 1030) {
                                i4 = 16000;
                            }
                            audioProcess.O00000o0 = i4;
                            if (!TextUtils.isEmpty(AudioProcess.this.O0000Oo0) && ("chuangmi.camera.ipc019".equals(AudioProcess.this.O0000Oo0) || DeviceConstant.is16K(AudioProcess.this.O0000Oo0))) {
                                AudioProcess.this.O00000o0 = 16000;
                            }
                            cki.O00000o("AudioProcess", "change type " + AudioProcess.this.O00000o0 + " " + take2.O00000o0 + " buffer " + take2.f5398O000000o.length);
                            O000000o();
                            O000000o(take2.f5398O000000o.length);
                        }
                    }
                } else {
                    if (duc.O000000o()) {
                        this.O00000o.clear();
                        this.O00000o.put(this.O00000Oo);
                        this.O00000o.rewind();
                        AudioTrack audioTrack = this.f5399O000000o;
                        ByteBuffer byteBuffer = this.O00000o;
                        i = audioTrack.write(byteBuffer, byteBuffer.capacity(), 0);
                    } else {
                        AudioTrack audioTrack2 = this.f5399O000000o;
                        byte[] bArr = this.O00000Oo;
                        i = audioTrack2.write(bArr, 0, bArr.length);
                    }
                    if (i != this.O00000Oo.length) {
                        cki.O00000oO("AudioProcess", "audioTrack.write size error:".concat(String.valueOf(i)));
                    }
                }
                return 0;
            }
            if (this.O00000o0.O00000Oo() >= AudioProcess.this.O0000o0) {
                if (!this.O00000o0.O000000o(this.O00000Oo) || this.O00000o == null) {
                    try {
                        O000000o take3 = AudioProcess.this.O0000o.take();
                        if (take3 != null) {
                            if (take3.O00000o0 <= 0 || this.O00000oo == take3.O00000o0) {
                                if (this.O00000o == null) {
                                    O000000o(take3.f5398O000000o.length);
                                }
                                this.O00000o0.O00000Oo(take3.f5398O000000o);
                            } else {
                                O00000o0();
                                AudioProcess.this.O00000o0 = take3.O00000o0 == 1030 ? 16000 : 8000;
                                if (AudioProcess.this.O00000o0 == 8000) {
                                    AudioProcess.this.O00000o0 = 8000;
                                }
                                O000000o();
                                O000000o(take3.f5398O000000o.length);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        cki.O00000o("AudioProcess", "e==" + e.getMessage());
                    }
                } else {
                    AudioProcess audioProcess2 = AudioProcess.this;
                    audioProcess2.O0000o0 = 0;
                    WebRtcJni.WebRtcAecm webRtcAecm = audioProcess2.O0000Oo;
                    byte[] bArr2 = this.O00000Oo;
                    webRtcAecm.bufferFarendBytes(bArr2, bArr2.length / 2);
                    if (duc.O000000o()) {
                        this.O00000o.clear();
                        this.O00000o.put(this.O00000Oo);
                        this.O00000o.rewind();
                        AudioTrack audioTrack3 = this.f5399O000000o;
                        ByteBuffer byteBuffer2 = this.O00000o;
                        i2 = audioTrack3.write(byteBuffer2, byteBuffer2.capacity(), 0);
                    } else {
                        AudioTrack audioTrack4 = this.f5399O000000o;
                        byte[] bArr3 = this.O00000Oo;
                        i2 = audioTrack4.write(bArr3, 0, bArr3.length);
                    }
                    if (i2 != this.O00000Oo.length) {
                        cki.O00000o("AudioProcess", "audioTrack.write size error:".concat(String.valueOf(i2)));
                    }
                }
            }
            try {
                if (AudioProcess.this.O0000o.size() > 0 && (take = AudioProcess.this.O0000o.take()) != null) {
                    if (take.O00000o0 <= 0 || this.O00000oo == take.O00000o0) {
                        if (this.O00000o == null) {
                            O000000o(take.f5398O000000o.length);
                        }
                        this.O00000o0.O00000Oo(take.f5398O000000o);
                    } else {
                        O00000o0();
                        AudioProcess audioProcess3 = AudioProcess.this;
                        if (take.O00000o0 != 1030) {
                            i3 = 8000;
                        }
                        audioProcess3.O00000o0 = i3;
                        if (AudioProcess.this.O00000o0 == 8000) {
                            AudioProcess.this.O00000o0 = 8000;
                        }
                        O000000o();
                        O000000o(take.f5398O000000o.length);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                cki.O00000o("AudioProcess", "e==" + e2.getMessage());
            }
            return 0;
        }

        public final void doRelease() {
            cki.O00000o("AudioProcess", "AudioPlayThread doRelease");
            O00000o0();
        }
    }

    class O00000o0 extends fsg {

        /* renamed from: O000000o  reason: collision with root package name */
        int f5400O000000o;
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
                if (AudioProcess.this.O0000OoO) {
                    AudioProcess.this.O0000O0o.setMode(3);
                    if (3 == AudioProcess.this.O00000Oo && !AudioProcess.this.O0000O0o.isBluetoothScoOn()) {
                        cki.O00000o("AudioProcess", "sco not ready");
                        final ConditionVariable conditionVariable = new ConditionVariable(false);
                        AnonymousClass1 r5 = new BroadcastReceiver() {
                            /* class com.p2p.audio.AudioProcess.O00000o0.AnonymousClass1 */

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
                            AudioProcess.this.f5397O000000o.registerReceiver(r5, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                            AudioProcess.this.O0000O0o.setBluetoothScoOn(true);
                            AudioProcess.this.O0000O0o.startBluetoothSco();
                            cki.O00000o("AudioProcess", "start sco");
                            conditionVariable.block(3000);
                        } catch (Exception e) {
                            cki.O00000o("AudioProcess", "start sco exp " + e.toString());
                        }
                        AudioProcess.this.f5397O000000o.unregisterReceiver(r5);
                        if (!AudioProcess.this.O0000O0o.isBluetoothScoOn()) {
                            cki.O00000o("AudioProcess", "scoRecv start fail");
                            AudioProcess.this.O0000O0o.stopBluetoothSco();
                            AudioProcess.this.O0000O0o.setBluetoothScoOn(false);
                        } else {
                            cki.O00000o("AudioProcess", "scoRecv start success");
                            cki.O00000oO("AudioProcess", "SCO only support 8k or 16k mono play record may have exception");
                        }
                    }
                    i = 7;
                } else {
                    i = 1;
                }
                AudioProcess.this.O0000oO0.clear();
                this.f5400O000000o = AudioRecord.getMinBufferSize(AudioProcess.this.O00000o0, 16, 2);
                if (AudioProcess.this.O0000o00 > this.f5400O000000o) {
                    this.f5400O000000o = AudioProcess.this.O0000o00;
                }
                cki.O00000oO("AudioProcess", "AudioRecord mini size :" + this.f5400O000000o);
                this.O00000Oo = new byte[AudioProcess.this.O0000o00];
                try {
                    this.O00000o = new AudioRecord(i, AudioProcess.this.O00000o0, 16, 2, this.f5400O000000o);
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
                        if (AudioProcess.this.O0000OoO) {
                            AudioProcess.this.O0000Ooo.open();
                        }
                        cki.O00000o("AudioProcess", "init Record success");
                    } catch (Exception e2) {
                        this.O00000o = null;
                        cki.O00000oO("AudioProcess", "AudioRecord initial " + e2.toString());
                    }
                } catch (IllegalArgumentException e3) {
                    this.O00000o = null;
                    int minBufferSize = AudioRecord.getMinBufferSize(AudioProcess.this.O00000o0, 16, 2);
                    cki.O00000oO("AudioProcess", "AudioRecord init Error  min size" + minBufferSize + "   Exception:" + e3.toString());
                }
            }
        }

        public final int doRepeatWork() throws InterruptedException {
            AudioRecord audioRecord;
            O000000o o000000o;
            O000000o o000000o2;
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
                    AudioProcess.this.O00000oo = d3 > 0.0d ? (int) (Math.log10(d3) * 10.0d) : 50;
                    if (AudioProcess.this.O0000OoO && this.mIsRunning) {
                        int i2 = 1027;
                        if (AudioProcess.this.O0000Oo == null || !AudioProcess.this.O0000o0o) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (TextUtils.isEmpty(AudioProcess.this.O0000Oo0) || (!"chuangmi.camera.ipc019".equals(AudioProcess.this.O0000Oo0) && !DeviceConstant.isG711(AudioProcess.this.O0000Oo0))) {
                                o000000o = new O000000o(bArr2, currentTimeMillis, 1027);
                            } else {
                                o000000o = new O000000o(bArr2, currentTimeMillis, 1027);
                            }
                            AudioProcess.this.O0000oO0.put(o000000o);
                        } else {
                            short[] process = AudioProcess.this.O0000Oo.process(bytes2Shorts, null, bytes2Shorts.length, AudioProcess.this.O0000OOo);
                            if (process != null) {
                                bArr2 = ClassTransUtils.getInstance().shorts2Bytes(process);
                            } else {
                                cki.O00000oO("AudioProcess", "aecOutShorts null");
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (TextUtils.isEmpty(AudioProcess.this.O0000Oo0) || (!"chuangmi.camera.ipc019".equals(AudioProcess.this.O0000Oo0) && !DeviceConstant.isG711(AudioProcess.this.O0000Oo0))) {
                                if (AudioProcess.this.O00000o0 != 8000) {
                                    i2 = 1030;
                                }
                                o000000o2 = new O000000o(bArr2, currentTimeMillis2, i2);
                            } else {
                                o000000o2 = new O000000o(bArr2, currentTimeMillis2, 1027);
                            }
                            AudioProcess.this.O0000oO0.put(o000000o2);
                        }
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
            if (AudioProcess.this.O0000O0o != null) {
                AudioProcess.this.O0000O0o.setMode(0);
                if (AudioProcess.this.O0000O0o.isBluetoothScoOn()) {
                    AudioProcess.this.O0000O0o.stopBluetoothSco();
                    AudioProcess.this.O0000O0o.setBluetoothScoOn(false);
                }
            }
            AcousticEchoCanceler acousticEchoCanceler = this.O00000oO;
            if (acousticEchoCanceler != null) {
                acousticEchoCanceler.setEnabled(false);
            }
            AutomaticGainControl automaticGainControl = this.O00000oo;
            if (automaticGainControl != null) {
                automaticGainControl.setEnabled(false);
            }
            cki.O00000o("AudioProcess", "releaseRecorder");
            cki.O00000o("AudioProcess", "AudioRecordThread doRelease");
        }
    }
}
