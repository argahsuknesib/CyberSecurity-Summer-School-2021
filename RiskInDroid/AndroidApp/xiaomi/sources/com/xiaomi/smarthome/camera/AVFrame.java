package com.xiaomi.smarthome.camera;

import _m_j.gsy;
import com.google.android.exoplayer2.C;

public class AVFrame {
    public long cam_index;
    private short codec_id = 0;
    private boolean decrypt = false;
    private byte flags = -1;
    public byte[] frmData = null;
    private long frmNo = -1;
    private int frmSize = 0;
    private byte frmState = 0;
    public byte isHaveLogo;
    public byte isPlayback;
    public byte isShowTime;
    private String model = "";
    public int moveType;
    private byte onlineNum = 0;
    private int timestamp = 0;
    public int timestamp_ms;
    public byte usecount;
    private int videoHeight = 0;
    private int videoWidth = 0;

    public static int getSamplerate(byte b) {
        switch (b >>> 2) {
            case 0:
            default:
                return 8000;
            case 1:
                return 11025;
            case 2:
                return 12000;
            case 3:
                return 16000;
            case 4:
                return 22050;
            case 5:
                return 24000;
            case 6:
                return 32000;
            case 7:
                return 44100;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return 48000;
        }
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public AVFrame(byte[] bArr, byte[] bArr2, int i) {
        this.codec_id = byteArrayToShort_Little(bArr, 0);
        this.flags = bArr[2];
        this.cam_index = (long) bArr[3];
        this.onlineNum = bArr[4];
        this.timestamp = (int) byteArrayToLong_Little(bArr, 12);
        this.videoWidth = byteArrayToInt_Little(bArr, 16);
        this.videoHeight = byteArrayToInt_Little(bArr, 20);
        this.frmSize = i;
        this.frmData = bArr2;
    }

    public AVFrame(byte b, byte[] bArr, byte[] bArr2, int i, boolean z, boolean z2) {
        this.codec_id = byteArrayToShort(bArr, 0, z);
        this.flags = bArr[2];
        this.cam_index = (long) bArr[3];
        if (z2) {
            this.frmNo = (long) byteArrayToInt(bArr, 4, z);
        } else {
            this.onlineNum = bArr[4];
            this.usecount = bArr[5];
            this.frmNo = (long) byteArrayToShort(bArr, 6, z);
        }
        this.videoWidth = byteArrayToShort(bArr, 8, z);
        this.videoHeight = byteArrayToShort(bArr, 10, z);
        this.timestamp = byteArrayToInt(bArr, 12, z);
        byte b2 = bArr[16];
        this.isPlayback = (byte) (b2 & 1);
        this.isShowTime = (byte) ((b2 >> 1) & 1);
        this.isHaveLogo = (byte) ((b2 >> 2) & 1);
        this.frmState = b;
        this.frmSize = i;
        this.frmData = bArr2;
        if (bArr.length > 20) {
            this.timestamp_ms = byteArrayToInt(bArr, 20, z);
        }
        gsy.O000000o(3, "cheng", "isMiss:" + z2 + " timestamp_ms:" + this.timestamp_ms + " frameInfo[3]:" + ((int) bArr[3]));
        if (z2) {
            this.moveType = this.timestamp_ms;
        } else {
            this.moveType = bArr[3] & 255;
        }
    }

    public boolean isIFrame() {
        return (this.flags & 1) == 1;
    }

    public byte getFlags() {
        return this.flags;
    }

    public byte getFrmState() {
        return this.frmState;
    }

    public long getFrmNo() {
        return this.frmNo;
    }

    public int getFrmSize() {
        return this.frmSize;
    }

    public void setFrmSize(int i) {
        this.frmSize = i;
    }

    public byte getOnlineNum() {
        return this.onlineNum;
    }

    public short getCodecId() {
        return this.codec_id;
    }

    public int getVideoType() {
        return this.codec_id == 78 ? 1 : 2;
    }

    public int getTimeStamp() {
        return this.timestamp;
    }

    public int getTimeStampReal() {
        return this.timestamp_ms;
    }

    public boolean isPlayback() {
        return this.isPlayback != 0;
    }

    public boolean isWartTime() {
        return this.isShowTime != 0;
    }

    public boolean isHaveLogo() {
        return this.isHaveLogo != 0;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public final short byteArrayToShort(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = (bArr[i] & 255) << 8;
            i3 = bArr[i + 1] & 255;
        } else {
            i2 = bArr[i] & 255;
            i3 = (bArr[i + 1] & 255) << 8;
        }
        return (short) (i3 | i2);
    }

    public final int byteArrayToInt(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            i2 = bArr[i + 3] & 255;
        } else {
            b = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            i2 = (bArr[i + 3] & 255) << 24;
        }
        return i2 | b;
    }

    public final short byteArrayToShort_Little(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public final long byteArrayToLong_Little(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = (bArr[i + 3] & 255) << 24;
        return (long) (((bArr[i2] & 255) << 56) | i3 | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i2] & 255) << 32) | ((bArr[i2] & 255) << 40) | ((bArr[i2] & 255) << 48));
    }

    public final int byteArrayToInt_Little(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }
}
