package com.xiaomi.smarthome.camera.activity.local;

import _m_j.civ;
import _m_j.cqi;
import _m_j.faf;
import _m_j.fsg;
import android.app.Activity;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import com.xiaomi.aaccodec.AACDecodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.smarthome.camera.XmMp4Player;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public class LocalAudioPlay implements XmMp4Player.AudioListener {
    private Activity mActivity = null;
    public LinkedBlockingQueue<cqi> mAudioFrameQueue = new LinkedBlockingQueue<>(60);
    private AudioDecodeThread mDecoder;
    private Handler mHandler = null;
    public volatile boolean mIsRung = false;
    private AudioPlayThread mPlay;
    public LinkedBlockingQueue<cqi> mPlayAudioFrameQueue = new LinkedBlockingQueue<>(15);

    public LocalAudioPlay(Activity activity) {
        this.mActivity = activity;
        this.mHandler = new Handler(this.mActivity.getMainLooper());
    }

    public void start() {
        stop();
        this.mIsRung = true;
        this.mPlay = new AudioPlayThread();
        this.mDecoder = new AudioDecodeThread();
        this.mPlay.start();
        this.mDecoder.start();
    }

    public void stop() {
        this.mPlayAudioFrameQueue.clear();
        this.mAudioFrameQueue.clear();
        AudioPlayThread audioPlayThread = this.mPlay;
        if (audioPlayThread != null) {
            audioPlayThread.stopThreadAsyn();
            this.mPlay = null;
        }
        AudioDecodeThread audioDecodeThread = this.mDecoder;
        if (audioDecodeThread != null) {
            audioDecodeThread.stopThreadAsyn();
            this.mDecoder = null;
        }
    }

    public void release() {
        stop();
        this.mHandler = null;
        this.mActivity = null;
    }

    public void onAudioData(byte[] bArr, long j, int i) {
        Handler handler;
        if (!this.mIsRung && (handler = this.mHandler) != null) {
            handler.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAudioPlay.AnonymousClass1 */

                public void run() {
                    LocalAudioPlay.this.start();
                }
            });
        }
        try {
            this.mAudioFrameQueue.put(new cqi(bArr, j, i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onFinish(int i) {
        Handler handler;
        if (this.mIsRung && (handler = this.mHandler) != null) {
            handler.post(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.local.LocalAudioPlay.AnonymousClass2 */

                public void run() {
                    LocalAudioPlay.this.stop();
                }
            });
        }
    }

    class AudioDecodeThread extends fsg {
        byte[] audioPlayerBuffer;
        AACDecodeEx mAACDecode;

        public AudioDecodeThread() {
            super("AudioDecodeThread");
        }

        public int doRepeatWork() throws InterruptedException {
            int i;
            if (!LocalAudioPlay.this.mIsRung) {
                Thread.sleep(100);
                return 0;
            }
            cqi take = LocalAudioPlay.this.mAudioFrameQueue.take();
            if (take != null && this.mIsRunning) {
                if (take.O00000Oo != 136) {
                    i = G711.decode(take.f14241O000000o, 0, take.f14241O000000o.length, this.audioPlayerBuffer);
                } else {
                    AACDecodeEx aACDecodeEx = this.mAACDecode;
                    byte[] bArr = take.f14241O000000o;
                    int length = take.f14241O000000o.length;
                    byte[] bArr2 = this.audioPlayerBuffer;
                    i = aACDecodeEx.decode(bArr, 0, length, bArr2, bArr2.length);
                    take.O00000Oo = 136;
                }
                if (i > 0 && this.mIsRunning) {
                    byte[] bArr3 = new byte[i];
                    System.arraycopy(this.audioPlayerBuffer, 0, bArr3, 0, i);
                    LocalAudioPlay.this.mPlayAudioFrameQueue.put(new cqi(bArr3, take.O00000o0, take.O00000Oo));
                }
            }
            return 0;
        }

        public void doInitial() {
            this.audioPlayerBuffer = new byte[10240];
            this.mAACDecode = new AACDecodeEx();
            this.mAACDecode.initial();
        }

        public void doRelease() {
            this.audioPlayerBuffer = null;
            this.mAACDecode.release();
        }
    }

    class AudioPlayThread extends fsg {
        byte[] audioPlayerBuffer = null;
        AudioTrack audioTrack;
        ByteBuffer mByteBuffer = null;
        faf mPlayByteDataBuffer = null;

        public AudioPlayThread() {
            super("local_play_audio");
        }

        public int doRepeatWork() throws InterruptedException {
            int i;
            if (!LocalAudioPlay.this.mIsRung) {
                Thread.sleep(100);
                return 0;
            }
            if (!this.mPlayByteDataBuffer.O000000o(this.audioPlayerBuffer) || this.mByteBuffer == null) {
                cqi take = LocalAudioPlay.this.mPlayAudioFrameQueue.take();
                if (take != null) {
                    if (this.mByteBuffer == null) {
                        initBuffer(take.f14241O000000o.length);
                    }
                    this.mPlayByteDataBuffer.O00000Oo(take.f14241O000000o);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mByteBuffer.clear();
                    this.mByteBuffer.put(this.audioPlayerBuffer);
                    this.mByteBuffer.rewind();
                    AudioTrack audioTrack2 = this.audioTrack;
                    ByteBuffer byteBuffer = this.mByteBuffer;
                    i = audioTrack2.write(byteBuffer, byteBuffer.capacity(), 0);
                } else {
                    AudioTrack audioTrack3 = this.audioTrack;
                    byte[] bArr = this.audioPlayerBuffer;
                    i = audioTrack3.write(bArr, 0, bArr.length);
                }
                if (i != this.audioPlayerBuffer.length) {
                    civ.O00000o0("audio", "audioTrack.write size error:".concat(String.valueOf(i)));
                }
            }
            return 0;
        }

        public void doInitial() {
            try {
                this.audioTrack = new AudioTrack(3, 8000, 4, 2, AudioTrack.getMinBufferSize(8000, 4, 2), 1);
                this.audioTrack.play();
                if (this.mPlayByteDataBuffer != null) {
                    this.mPlayByteDataBuffer.O000000o();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mPlayByteDataBuffer = new faf();
            LocalAudioPlay.this.mPlayAudioFrameQueue.clear();
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

        public void doRelease() {
            releasePlayer();
        }

        /* access modifiers changed from: package-private */
        public void initBuffer(int i) {
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
    }
}
