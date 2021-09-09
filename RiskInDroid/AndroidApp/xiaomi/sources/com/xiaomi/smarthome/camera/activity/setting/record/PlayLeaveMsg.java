package com.xiaomi.smarthome.camera.activity.setting.record;

import _m_j.civ;
import _m_j.duc;
import _m_j.faf;
import _m_j.fsg;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.xiaomi.aaccodec.G711;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class PlayLeaveMsg {
    public static final String TAG = "PlayLeaveMsg";
    public DataInputStream dis;
    private int mAecLen = (((this.mRate * 2) * 10) / 1000);
    public AudioManager mAudioManager;
    private AudioPlayThread mAudioPlayThread;
    public volatile boolean mHeadSetOn = false;
    public int mRate = 8000;

    public interface PlayListener {
        void onPlaying();

        void onStop();
    }

    public PlayLeaveMsg(Context context, String str) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        civ.O000000o(TAG, "filePath=".concat(String.valueOf(str)));
        File file = new File(str);
        if (file.exists()) {
            try {
                this.dis = new DataInputStream(new FileInputStream(file));
                int available = this.dis.available();
                civ.O000000o(TAG, "total_len=".concat(String.valueOf(available)));
                String str2 = TAG;
                civ.O000000o(str2, "total_time=" + (((available * 2) / this.mRate) / 2) + "s");
            } catch (Exception e) {
                civ.O00000o0(TAG, e.toString());
            }
        }
    }

    public synchronized void startPlay(PlayListener playListener) {
        civ.O00000o0(TAG, "startPlay");
        if (this.mAudioPlayThread == null) {
            this.mAudioPlayThread = new AudioPlayThread(playListener);
            this.mAudioPlayThread.start();
        }
    }

    public synchronized void stop() {
        if (this.mAudioPlayThread != null) {
            this.mAudioPlayThread.stopThreadSyn();
            this.mAudioPlayThread = null;
        }
    }

    class AudioPlayThread extends fsg {
        byte[] audioPlayerBuffer = null;
        AudioTrack audioTrack;
        ByteBuffer mByteBuffer = null;
        faf mPlayByteDataBuffer = null;
        private PlayListener playListener;
        private int playType;

        AudioPlayThread(PlayListener playListener2) {
            super("AudioPlayThread");
            this.playListener = playListener2;
        }

        public void doInitial() {
            civ.O00000o0(PlayLeaveMsg.TAG, "AudioPlayThread doInitial");
            Process.setThreadPriority(-19);
            initPlayer();
        }

        /* access modifiers changed from: package-private */
        public void initPlayer() {
            if (this.audioTrack == null) {
                if (PlayLeaveMsg.this.mRate == 8000) {
                    this.playType = 138;
                } else {
                    this.playType = 136;
                }
                String str = PlayLeaveMsg.TAG;
                civ.O00000o0(str, "mRate " + PlayLeaveMsg.this.mRate);
                int minBufferSize = AudioTrack.getMinBufferSize(PlayLeaveMsg.this.mRate, 4, 2);
                civ.O00000o0(PlayLeaveMsg.TAG, "AudioTrack minSize:".concat(String.valueOf(minBufferSize)));
                try {
                    this.audioTrack = new AudioTrack(3, PlayLeaveMsg.this.mRate, 4, 2, minBufferSize, 1);
                    if (!PlayLeaveMsg.this.mHeadSetOn) {
                        PlayLeaveMsg.this.mAudioManager.setSpeakerphoneOn(true);
                    }
                    this.audioTrack.play();
                } catch (Exception e) {
                    civ.O00000o0(PlayLeaveMsg.TAG, "AudioTrack init".concat(String.valueOf(e)));
                    this.audioTrack = null;
                }
                faf faf = this.mPlayByteDataBuffer;
                if (faf != null) {
                    faf.O000000o();
                }
                this.mPlayByteDataBuffer = new faf();
                initBuffer(640);
                PlayListener playListener2 = this.playListener;
                if (playListener2 != null) {
                    playListener2.onPlaying();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void initBuffer(int i) {
            civ.O00000o0(PlayLeaveMsg.TAG, "sample buffer ".concat(String.valueOf(i)));
            faf faf = this.mPlayByteDataBuffer;
            if (faf != null) {
                faf.O000000o();
            }
            this.audioPlayerBuffer = new byte[i];
            ByteBuffer byteBuffer = this.mByteBuffer;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
            this.mByteBuffer = ByteBuffer.allocateDirect(i);
        }

        /* access modifiers changed from: package-private */
        public void releasePlayer() {
            AudioTrack audioTrack2 = this.audioTrack;
            if (audioTrack2 != null) {
                audioTrack2.flush();
                this.audioTrack.release();
                this.audioTrack = null;
            }
            faf faf = this.mPlayByteDataBuffer;
            if (faf != null) {
                faf.O000000o();
                this.mPlayByteDataBuffer = null;
            }
            this.audioPlayerBuffer = null;
        }

        public int doRepeatWork() throws InterruptedException {
            int i;
            if (!this.mIsRunning) {
                return 0;
            }
            try {
                if (PlayLeaveMsg.this.dis.available() > 0) {
                    byte[] bArr = new byte[320];
                    try {
                        civ.O000000o(PlayLeaveMsg.TAG, "readCount=".concat(String.valueOf(PlayLeaveMsg.this.dis.read(bArr))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    civ.O000000o(PlayLeaveMsg.TAG, "ret=".concat(String.valueOf(G711.decode(bArr, 0, 320, this.audioPlayerBuffer))));
                    this.mPlayByteDataBuffer.O00000Oo((byte[]) this.audioPlayerBuffer.clone());
                    boolean O000000o2 = this.mPlayByteDataBuffer.O000000o(this.audioPlayerBuffer);
                    civ.O000000o(PlayLeaveMsg.TAG, "hasdata=".concat(String.valueOf(O000000o2)));
                    if (O000000o2 && this.mByteBuffer != null) {
                        if (duc.O000000o()) {
                            this.mByteBuffer.clear();
                            this.mByteBuffer.put(this.audioPlayerBuffer);
                            this.mByteBuffer.rewind();
                            AudioTrack audioTrack2 = this.audioTrack;
                            ByteBuffer byteBuffer = this.mByteBuffer;
                            i = audioTrack2.write(byteBuffer, byteBuffer.capacity(), 0);
                        } else {
                            AudioTrack audioTrack3 = this.audioTrack;
                            byte[] bArr2 = this.audioPlayerBuffer;
                            i = audioTrack3.write(bArr2, 0, bArr2.length);
                        }
                        if (i != this.audioPlayerBuffer.length) {
                            civ.O00000o0(PlayLeaveMsg.TAG, "audioTrack.write size error:".concat(String.valueOf(i)));
                        } else {
                            civ.O00000o0(PlayLeaveMsg.TAG, "audioTrack.write size".concat(String.valueOf(i)));
                        }
                    }
                    return 0;
                }
                this.mIsRunning = false;
                throw new InterruptedException();
            } catch (Exception unused) {
                this.mIsRunning = false;
                throw new InterruptedException();
            }
        }

        public void doRelease() {
            PlayListener playListener2 = this.playListener;
            if (playListener2 != null) {
                playListener2.onStop();
            }
            civ.O00000o0(PlayLeaveMsg.TAG, "AudioPlayThread doRelease");
            releasePlayer();
            if (PlayLeaveMsg.this.dis != null) {
                try {
                    PlayLeaveMsg.this.dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PlayLeaveMsg.this.dis = null;
            }
        }
    }
}
