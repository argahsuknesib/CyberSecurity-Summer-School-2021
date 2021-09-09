package com.xiaomi.smarthome.fastvideo.decoder;

import _m_j.ckh;
import _m_j.cki;
import com.xiaomi.smarthome.camera.XmMp4Record;
import java.io.File;

public class Mp4Record implements XmMp4Record {
    private int mAudioTimeOffset;
    private long mCurrentAudioTime = -1;
    private long mCurrentTime = -1;
    private String mFileName;
    private long mFirstAudioTime;
    private long mFirstTime;
    private int mFrameRate;
    private boolean mGenerateTimestamp;
    private int mHeight;
    private long mInitTimestamp;
    private long mLastAudioTime;
    private long mLastTime;
    private int mMineDuration = 1000;
    private int mPerAACDuration;
    private int mPerFrameDuration;
    private int mRecordTime;
    private XmMp4Record.IRecordTimeListener mRecordTimeListener;
    private int mSample;
    private VideoRawDataSaveHelper mVideoRawDataSaveHelper;
    private int mVideoTimeOffset;
    private int mVideoType = 1;
    private int mWidth;
    private Mp4Muxer mp4Muxer = null;

    public void startRecord(String str, int i, int i2, int i3, int i4) {
        startRecord(str, 20, i, i2, i3, i4);
    }

    public void startRecord(String str, int i, int i2, int i3, int i4, int i5) {
        this.mFileName = str;
        this.mVideoType = i2;
        this.mHeight = i4;
        this.mWidth = i3;
        this.mSample = i5;
        if (-1 == i) {
            i = 20;
            this.mGenerateTimestamp = true;
        }
        this.mFrameRate = i;
        this.mPerFrameDuration = 90000 / this.mFrameRate;
        this.mPerAACDuration = 1024000 / i5;
        if (ckh.O00000oo) {
            this.mVideoRawDataSaveHelper = new VideoRawDataSaveHelper();
            this.mVideoRawDataSaveHelper.init(i, i2, i3, i4);
        }
        this.mInitTimestamp = System.currentTimeMillis();
        cki.O00000Oo("Mp4Record", "startRecord name %s frameRate:%d,videoType:%d,audioSample:%d,generateTimestamp:%b", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Boolean.valueOf(this.mGenerateTimestamp));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0105, code lost:
        return;
     */
    public synchronized void writeVideoData(byte[] bArr, int i, boolean z, int i2) {
        if (!z) {
            if (this.mp4Muxer == null) {
                return;
            }
        }
        long j = (long) (i2 * 90);
        if (this.mGenerateTimestamp) {
            j = (System.currentTimeMillis() - this.mInitTimestamp) * 90;
        }
        if (j < this.mLastTime - 90000) {
            cki.O00000o0("Mp4Record", "time check back up time:%d,lastTime:%d", Long.valueOf(j), Long.valueOf(this.mLastTime));
            this.mVideoTimeOffset = (int) (((long) this.mVideoTimeOffset) + (this.mLastTime - j) + ((long) this.mPerFrameDuration));
        }
        this.mLastTime = j;
        long j2 = j + ((long) this.mVideoTimeOffset);
        if (this.mp4Muxer == null) {
            this.mp4Muxer = new Mp4Muxer();
            if (this.mp4Muxer.initMuxer(this.mFileName, this.mFrameRate, this.mVideoType, this.mWidth, this.mHeight, this.mSample) != 0) {
                this.mp4Muxer = null;
                return;
            }
        }
        if (this.mCurrentTime != -1) {
            long j3 = j2 - this.mCurrentTime;
            if (!this.mGenerateTimestamp && (j3 <= 900 || j3 >= 90000)) {
                cki.O00000o0("Mp4Record", "time check to auto add temp:%d,time:%d", Long.valueOf(j3), Long.valueOf(j2));
                j2 = this.mCurrentTime + ((long) this.mPerFrameDuration);
            }
        } else {
            this.mFirstTime = j2;
        }
        long j4 = j2;
        cki.O000000o("Mp4Record", "writeVideoData length:%d,time:%d,firstTime:%d,isIFrame:%b", Integer.valueOf(i), Long.valueOf(j4 - this.mFirstTime), Long.valueOf(this.mFirstTime), Boolean.valueOf(z));
        this.mp4Muxer.writeVideoWithPts(bArr, i, j4 - this.mFirstTime, z);
        this.mCurrentTime = j4;
        checkUpdateTime(((int) (this.mCurrentTime - this.mFirstTime)) / 90);
        if (this.mVideoRawDataSaveHelper != null) {
            this.mVideoRawDataSaveHelper.write(bArr);
        }
    }

    public synchronized void writeAAcData(byte[] bArr, int i, int i2) {
        if (this.mp4Muxer != null) {
            long j = (long) i2;
            if (this.mGenerateTimestamp) {
                j = (long) ((int) System.currentTimeMillis());
            }
            if (j < this.mLastAudioTime - 90000) {
                this.mAudioTimeOffset = (int) (((long) this.mAudioTimeOffset) + (this.mLastAudioTime - j) + ((long) this.mPerAACDuration));
            }
            this.mLastAudioTime = j;
            long j2 = j + ((long) this.mAudioTimeOffset);
            if (this.mCurrentAudioTime != -1) {
                long j3 = j2 - this.mCurrentAudioTime;
                if (j3 <= 10 || j3 >= 500) {
                    j2 = this.mCurrentAudioTime + ((long) this.mPerAACDuration);
                }
            } else {
                this.mFirstAudioTime = j2;
            }
            this.mCurrentAudioTime = j2;
            cki.O000000o("Mp4Record", "writeAAcData length:%d,time:%d,mFirstAudioTime:%d", Integer.valueOf(i), Long.valueOf(j2 - this.mFirstAudioTime), Long.valueOf(this.mFirstAudioTime));
            this.mp4Muxer.writeAudioWithPts(bArr, i, ((long) (this.mSample / 1000)) * (j2 - this.mFirstAudioTime));
            checkUpdateTime((int) (this.mCurrentAudioTime - this.mFirstAudioTime));
        }
    }

    public synchronized void writeAAcData(byte[] bArr, int i) {
        if (this.mp4Muxer != null) {
            if (this.mCurrentAudioTime == -1) {
                this.mCurrentAudioTime = 0;
                this.mFirstAudioTime = 0;
            }
            this.mCurrentAudioTime += (long) this.mPerAACDuration;
            cki.O000000o("Mp4Record", "writeAAcData length:%d,audioTime %d", Integer.valueOf(i), Long.valueOf(this.mCurrentAudioTime));
            this.mp4Muxer.writeAudio(bArr, i);
            checkUpdateTime((int) (this.mCurrentAudioTime - this.mFirstAudioTime));
        }
    }

    public synchronized void stopRecord(XmMp4Record.IRecordListener iRecordListener) {
        if (this.mp4Muxer == null) {
            iRecordListener.onFailed(-3, "mp4Muxer == null");
            cki.O0000OOo("2000.4.1", "mp4Muxer == null");
            return;
        }
        cki.O00000o("Mp4Record", "mRecordTime:" + this.mRecordTime + ",audioTime:" + (this.mCurrentAudioTime - this.mFirstAudioTime));
        if (this.mRecordTime < this.mMineDuration) {
            this.mp4Muxer.closeFile();
            this.mp4Muxer = null;
            new File(this.mFileName).delete();
            iRecordListener.onFailed(-2, "mRecordTime < mMineDuration");
            return;
        }
        int closeFile = this.mp4Muxer.closeFile();
        this.mp4Muxer = null;
        if (closeFile == 0) {
            iRecordListener.onSuccess(this.mFileName);
        } else {
            new File(this.mFileName).delete();
            iRecordListener.onFailed(closeFile, "ret code ".concat(String.valueOf(closeFile)));
            cki.O0000OOo("2000.4.1", "ret code ".concat(String.valueOf(closeFile)));
        }
        if (this.mVideoRawDataSaveHelper != null) {
            this.mVideoRawDataSaveHelper.close();
        }
        this.mCurrentTime = -1;
    }

    private void checkUpdateTime(int i) {
        if (i > this.mRecordTime) {
            this.mRecordTime = i;
            XmMp4Record.IRecordTimeListener iRecordTimeListener = this.mRecordTimeListener;
            if (iRecordTimeListener != null) {
                iRecordTimeListener.upDateTime(this.mRecordTime);
            }
        }
    }

    public void setMineDuration(int i) {
        if (i > 0) {
            this.mMineDuration = i;
        }
    }

    public int getRecordTime() {
        return this.mRecordTime;
    }

    public void setRecordTimeListener(XmMp4Record.IRecordTimeListener iRecordTimeListener) {
        this.mRecordTimeListener = iRecordTimeListener;
    }
}
