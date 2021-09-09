package com.xiaomi.smarthome.camera.activity.setting.record;

import _m_j.cid;
import _m_j.cin;
import _m_j.civ;
import _m_j.faf;
import _m_j.fsg;
import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.xiaomi.aaccodec.AACEncodeEx;
import com.xiaomi.aaccodec.G711;
import com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RecorderLeaveMsg {
    public static final String TAG = "RecorderLeaveMsg";
    private AudioRecordThread audioRecordThread;
    private Context context;
    public String filePath;
    public Handler handler;
    public int mAecLen = (((this.mRate * 2) * 10) / 1000);
    protected cid mCameraDevice;
    public int mRate = 8000;
    private int mState = 0;
    public FileOutputStream os;

    public RecorderLeaveMsg(Context context2, Handler handler2, cid cid) {
        this.context = context2;
        this.handler = handler2;
        this.mCameraDevice = cid;
    }

    public synchronized void startRecord() {
        String str = TAG;
        civ.O000000o(str, "mState = " + this.mState);
        if (this.mState != 1) {
            if (this.audioRecordThread == null) {
                this.audioRecordThread = new AudioRecordThread();
                this.audioRecordThread.start();
            }
            this.mState = 1;
        }
    }

    public synchronized void stop() {
        this.mState = 0;
        if (this.audioRecordThread != null) {
            this.audioRecordThread.stopThreadSyn();
            this.audioRecordThread = null;
        }
    }

    public synchronized boolean isRecording() {
        if (this.mState == 1) {
            return true;
        }
        return false;
    }

    class AudioRecordThread extends fsg {
        public final String TAG = AudioRecordThread.class.getSimpleName();
        private byte[] aacBuffer;
        byte[] audioRecordData;
        private ByteArrayOutputStream bos = new ByteArrayOutputStream();
        faf byteDataBuffer;
        private byte[] g711Buffer;
        AACEncodeEx mAACEncode;
        int mMiniSize;
        private AudioRecord recordInstance;
        private int totalByte;

        public AudioRecordThread() {
            super("AudioRecordThread");
            RecorderLeaveMsg.this.filePath = LeaveMsgUtil.getAudioFilePath(RecorderLeaveMsg.this.mCameraDevice.getDid(), 0);
            civ.O000000o(RecordingVoiceActivity.TAG, "AudioRecordThread  filePath=" + RecorderLeaveMsg.this.filePath);
        }

        public void doInitial() {
            civ.O00000o0(this.TAG, "AudioRecordThread doInitial");
            this.bos.reset();
            this.mAACEncode = new AACEncodeEx();
            this.mAACEncode.initial(16000, 1, 32000);
            this.aacBuffer = new byte[2048];
            this.g711Buffer = new byte[640];
            this.byteDataBuffer = new faf();
            try {
                File file = new File(RecorderLeaveMsg.this.filePath);
                RecorderLeaveMsg.this.os = new FileOutputStream(file);
            } catch (Exception e) {
                civ.O00000o0(this.TAG, e.toString());
            }
            Process.setThreadPriority(-19);
            initialRecorder();
        }

        /* access modifiers changed from: package-private */
        public void initialRecorder() {
            if (this.recordInstance == null) {
                this.mMiniSize = AudioRecord.getMinBufferSize(RecorderLeaveMsg.this.mRate, 16, 2);
                if (RecorderLeaveMsg.this.mAecLen > this.mMiniSize) {
                    this.mMiniSize = RecorderLeaveMsg.this.mAecLen;
                }
                String str = this.TAG;
                civ.O00000o0(str, "AudioRecord minisize :" + this.mMiniSize);
                this.audioRecordData = new byte[RecorderLeaveMsg.this.mAecLen];
                try {
                    this.recordInstance = new AudioRecord(7, RecorderLeaveMsg.this.mRate, 16, 2, this.mMiniSize);
                    try {
                        this.recordInstance.startRecording();
                        civ.O00000o(this.TAG, "init Record success");
                    } catch (Exception e) {
                        this.recordInstance = null;
                        String str2 = this.TAG;
                        civ.O00000o(str2, "AudioRecord initial " + e.toString());
                    }
                } catch (IllegalArgumentException e2) {
                    this.recordInstance = null;
                    int minBufferSize = AudioRecord.getMinBufferSize(RecorderLeaveMsg.this.mRate, 16, 2);
                    civ.O00000o("audio", "AudioRecord init Error  min size" + minBufferSize + "   Exception:" + e2.toString());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void releaseRecorder() {
            AudioRecord audioRecord = this.recordInstance;
            if (audioRecord != null) {
                audioRecord.release();
                this.recordInstance = null;
            }
            this.audioRecordData = null;
        }

        public int doRepeatWork() throws InterruptedException {
            AudioRecord audioRecord;
            if (this.mIsRunning && (audioRecord = this.recordInstance) != null) {
                byte[] bArr = this.audioRecordData;
                int read = audioRecord.read(bArr, 0, bArr.length);
                if (read != this.audioRecordData.length) {
                    civ.O00000o0(this.TAG, "error record:".concat(String.valueOf(read)));
                }
                if (read > 0) {
                    this.totalByte += read;
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(this.audioRecordData, 0, bArr2, 0, read);
                    this.byteDataBuffer.O00000Oo(bArr2);
                    if (RecorderLeaveMsg.this.mRate != 8000) {
                        if (this.byteDataBuffer.O000000o(this.aacBuffer)) {
                            AACEncodeEx aACEncodeEx = this.mAACEncode;
                            byte[] bArr3 = this.aacBuffer;
                            byte[] encode = aACEncodeEx.encode(bArr3, 0, bArr3.length);
                            if (encode != null) {
                                civ.O000000o(this.TAG, "aac len=" + encode.length);
                                try {
                                    byte[] bArr4 = (byte[]) encode.clone();
                                    RecorderLeaveMsg.this.os.write(bArr4, 0, bArr4.length);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else if (this.byteDataBuffer.O000000o(this.g711Buffer)) {
                        byte[] bArr5 = this.g711Buffer;
                        byte[] encode2 = G711.encode(bArr5, 0, bArr5.length);
                        if (encode2 != null) {
                            civ.O000000o(this.TAG, "g711 len=" + encode2.length);
                            try {
                                byte[] bArr6 = (byte[]) encode2.clone();
                                RecorderLeaveMsg.this.os.write(bArr6, 0, bArr6.length);
                                this.bos.write(bArr6, 0, bArr6.length);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
            return 0;
        }

        public void doRelease() {
            doCallBack();
            try {
                RecorderLeaveMsg.this.os.flush();
                RecorderLeaveMsg.this.os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            releaseRecorder();
            this.byteDataBuffer.O000000o();
            this.mAACEncode.release();
            this.mAACEncode = null;
            this.aacBuffer = null;
            this.byteDataBuffer = null;
            this.g711Buffer = null;
            civ.O00000o0(this.TAG, "AudioRecordThread doRelease");
        }

        /* access modifiers changed from: protected */
        public void doCallBack() {
            String O000000o2 = cin.O000000o(this.bos.toByteArray());
            Message obtainMessage = RecorderLeaveMsg.this.handler.obtainMessage();
            obtainMessage.what = 1000;
            obtainMessage.obj = O000000o2;
            obtainMessage.arg1 = (this.totalByte / RecorderLeaveMsg.this.mRate) / 2;
            RecorderLeaveMsg.this.handler.sendMessage(obtainMessage);
        }
    }
}
