package com.xiaomi.smarthome.uwb.lib.mitv;

import _m_j.bxb;
import _m_j.bxf;
import _m_j.gsy;
import android.media.AudioRecord;
import com.xiaomi.smarthome.uwb.api.UwbMitvApi;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class UwbVoiceManager {
    public bxf mOpusEncoder;
    private AudioRecordSendThread mSendThread;

    public void release() {
        gsy.O000000o(4, "BluetoothVoiceManager", "release");
        bxf bxf = this.mOpusEncoder;
        if (bxf != null) {
            bxf.O00000Oo();
            this.mOpusEncoder = null;
        }
    }

    public void startSpeech() {
        UwbLogUtil.w("BluetoothVoiceManager", "UwbLogUtilPlus startSpeech");
        bxf bxf = this.mOpusEncoder;
        if (bxf != null) {
            bxf.O00000Oo();
            this.mOpusEncoder = null;
        }
        this.mOpusEncoder = new bxf();
        this.mOpusEncoder.f13376O000000o = 200;
        bxb.O000000o();
        this.mSendThread = new AudioRecordSendThread();
        this.mSendThread.start();
    }

    public void stopSpeech() {
        UwbLogUtil.w("BluetoothVoiceManager", "UwbLogUtilPlus stopSpeech");
        AudioRecordSendThread audioRecordSendThread = this.mSendThread;
        if (audioRecordSendThread != null) {
            audioRecordSendThread.stopRun();
        }
    }

    class AudioRecordSendThread extends Thread {
        private volatile boolean isRun = true;
        int mCount;
        AudioRecorder mRecorder;
        long mTimeSlot;

        AudioRecordSendThread() {
        }

        public void stopRun() {
            this.isRun = false;
        }

        public void run() {
            byte[] O000000o2;
            UwbLogUtil.w("AudioRecordSendThread", "UwbLogUtilPlus AudioRecordSendThread start");
            boolean z = true;
            this.isRun = true;
            this.mRecorder = new AudioRecorder();
            boolean z2 = false;
            this.mCount = 0;
            UwbMitvApi.doAiStart();
            this.mRecorder.start();
            while (true) {
                if (!this.isRun) {
                    break;
                }
                int read = this.mRecorder.read();
                UwbLogUtil.w("AudioRecordSendThread", "UwbLogUtilPlus AudioRecordSendThread read " + read + " bytes");
                if (read == -3 || read == -2) {
                    UwbLogUtil.e("AudioRecordSendThread", "UwbLogUtilPlus AudioRecordSendThread record exception!");
                    z2 = true;
                } else if (read > 0) {
                    encodeAndDoAiData(read);
                }
            }
            this.mRecorder.stop();
            if (!z2) {
                while (true) {
                    int read2 = this.mRecorder.read();
                    UwbLogUtil.w("AudioRecordSendThread", "UwbLogUtilPlus afterStop read " + read2 + " bytes");
                    if (read2 != -3 && read2 != -2) {
                        if (read2 <= 0) {
                            UwbLogUtil.e("AudioRecordSendThread", "UwbLogUtilPlus afterStop read finish!");
                            break;
                        }
                        encodeAndDoAiData(read2);
                    } else {
                        UwbLogUtil.e("AudioRecordSendThread", "UwbLogUtilPlus afterStop record exception!");
                    }
                }
            }
            z = z2;
            if (!z && (O000000o2 = UwbVoiceManager.this.mOpusEncoder.O000000o()) != null) {
                UwbLogUtil.w("AudioRecordSendThread", "UwbLogUtilPlus send last encodeBuf: " + O000000o2.length);
                UwbMitvApi.doAiData(O000000o2);
            }
            gsy.O000000o(3, "airkanuwb", "UwbMitvApi.doAiData  all count: " + this.mCount);
            UwbLogUtil.w("AudioRecordSendThread", "UwbLogUtilPlus AudioRecordSendThread end");
        }

        /* access modifiers changed from: package-private */
        public void encodeAndDoAiData(int i) {
            try {
                byte[] bArr = new byte[i];
                System.arraycopy(this.mRecorder.getBuffer(), 0, bArr, 0, i);
                gsy.O000000o(3, "airkanuwb", "aircan encode start");
                long currentTimeMillis = System.currentTimeMillis();
                byte[] O000000o2 = UwbVoiceManager.this.mOpusEncoder.O000000o(bArr);
                if (O000000o2 != null) {
                    gsy.O000000o(3, "airkanuwb", "aircan encode end " + (System.currentTimeMillis() - currentTimeMillis) + " len: " + O000000o2.length);
                    StringBuilder sb = new StringBuilder("UwbMitvApi.doAiData ");
                    sb.append(System.currentTimeMillis() - this.mTimeSlot);
                    gsy.O000000o(3, "airkanuwb", sb.toString());
                    UwbMitvApi.doAiData(O000000o2);
                    this.mTimeSlot = System.currentTimeMillis();
                    this.mCount++;
                    return;
                }
                gsy.O000000o(3, "airkanuwb", "aircan encode end " + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class AudioRecorder {
        private int mAudioFormat = 2;
        private int mAudioSource = 1;
        private byte[] mBufferBytes;
        private int mBufferSizeInBytes = 0;
        private int mChannelConfig = 16;
        private AudioRecord mRecorder;
        private int mSampleRateInHz = 16000;

        AudioRecorder() {
        }

        /* access modifiers changed from: package-private */
        public void start() {
            this.mBufferSizeInBytes = AudioRecord.getMinBufferSize(this.mSampleRateInHz, this.mChannelConfig, this.mAudioFormat);
            gsy.O000000o(4, "AudioRecordThread", "mBufferSizeInBytes = " + this.mBufferSizeInBytes);
            int i = this.mBufferSizeInBytes;
            this.mBufferBytes = new byte[i];
            this.mRecorder = new AudioRecord(this.mAudioSource, this.mSampleRateInHz, this.mChannelConfig, this.mAudioFormat, i);
            if (this.mRecorder.getState() == 1) {
                this.mRecorder.startRecording();
                gsy.O000000o(4, "AudioRecordThread", "recorder start record state=" + this.mRecorder.getState());
                return;
            }
            this.mRecorder.release();
            this.mRecorder = null;
            gsy.O000000o(6, "AudioRecordThread", "Recorder init error!");
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            AudioRecord audioRecord = this.mRecorder;
            if (audioRecord != null) {
                audioRecord.stop();
            }
        }

        /* access modifiers changed from: package-private */
        public int read() {
            AudioRecord audioRecord = this.mRecorder;
            if (audioRecord != null) {
                return audioRecord.read(this.mBufferBytes, 0, this.mBufferSizeInBytes);
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public byte[] getBuffer() {
            return this.mBufferBytes;
        }
    }
}
