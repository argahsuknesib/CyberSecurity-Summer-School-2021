package com.xiaovv.player;

import _m_j.ihp;
import _m_j.ihq;
import _m_j.ihr;
import _m_j.ihs;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.hs.hyfisheyepano.GLFisheyeView;
import com.hs.hyfisheyepano.OnPanoParamListener;
import com.hs.hyfisheyepano.OnPlayProgressListener;
import com.hs.hyfisheyepano.OnPlayStateListener;
import com.hs.hyfisheyepano.OnRenderListener;
import com.hs.hyfisheyepano.OnYuvDataListener;
import java.io.File;
import java.nio.ByteBuffer;

public class HSMediaPlayer {
    public static int MAX_BUFFER_SIZE = 10240;
    private static int sPlayWnd = -1;
    private Bitmap image = null;
    private long lFirstTimestamp;
    private ihp mAudioCache = new ihp();
    private O000000o mAudioPlayer = null;
    private int mCamType;
    private Context mContext;
    private int mFixType = 0;
    private boolean mFixTypeChanged = false;
    private GLFisheyeView mGLFisheyeView;
    private Handler mHandler;
    private boolean mIsCaptureEnable = false;
    private boolean mIsHWDecoding = false;
    private boolean mIsPlaying = false;
    private boolean mIsRenderEnable = false;
    private boolean mIsResume = false;
    private boolean mIsReverse = false;
    public boolean mIsSpeaking = false;
    private int mOrientation;
    private int mPanoRad = 0;
    private int mPanoX = 0;
    private int mPanoY = 0;
    public int mPlayAudioStat = 11;
    private int mPlayHandle = 0;
    public boolean mPlaySound = true;
    private int mPlayWindowIndex = -1;
    private int mPlayerIndex = 0;
    private int mSaveHeight = 0;
    private int mSaveWidth = 0;
    private int mTimeSpan = 0;
    private ByteBuffer mYUVBuffer = null;
    private byte[] mYUVData = null;
    private OnPanoParamListener onPanoParamListener;
    private OnPlayProgressListener onPlayProgressListener;
    private OnPlayStateListener onPlayStateListener;
    private OnRenderListener onRenderListener;
    private OnYuvDataListener onYuvDataListener;
    private ByteBuffer u = null;
    private ByteBuffer v = null;
    private int videoDuration;
    private int videoPosition;
    private ByteBuffer y = null;

    public static native boolean convertYUV2RGB(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2);

    public static native boolean getPanoParamBySei(byte[] bArr, int[] iArr, long[] jArr);

    static native int getScreenShotBuffer(int i, byte[] bArr, int[] iArr);

    private static native int getVideoDuration(int i, int i2);

    private static native void initJavaVM();

    private static native boolean pausePlayMP4File(int i, int i2);

    private static native boolean resumePlayMP4File(int i, int i2);

    private static native boolean seekTimeMP4File(int i, int i2, int i3, int i4);

    private static native int startPlayMP4File(Object obj, int i, String str);

    private static native boolean stopPlayMP4File(int i, int i2);

    public static native void writePanoParams(String str, int i, int i2, int i3, int i4, long j);

    public void clear() {
    }

    public void onOreintationChange(int i) {
    }

    static {
        try {
            System.loadLibrary("HSMediaPlayer");
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("HSMediaPlayer", "load lib HSMediaPlayer error " + e.toString());
        }
    }

    public void release() {
        sPlayWnd--;
        stop();
        GLFisheyeView gLFisheyeView = this.mGLFisheyeView;
        if (gLFisheyeView != null) {
            gLFisheyeView.clean();
            this.mGLFisheyeView = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
    }

    public HSMediaPlayer(Context context) {
        this.mContext = context;
        sPlayWnd++;
        this.mPlayWindowIndex = sPlayWnd;
    }

    public GLFisheyeView getmGLFisheyeView() {
        return this.mGLFisheyeView;
    }

    public void setmGLFisheyeView(GLFisheyeView gLFisheyeView) {
        this.mGLFisheyeView = gLFisheyeView;
    }

    public void setVideoParam(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mCamType = i;
        this.mPanoX = i2;
        this.mPanoY = i3;
        this.mPanoRad = i4;
        this.mTimeSpan = i5;
        OnRenderListener onRenderListener2 = this.onRenderListener;
        if (onRenderListener2 != null) {
            onRenderListener2.onRender(i6, i7);
        }
        OnPanoParamListener onPanoParamListener2 = this.onPanoParamListener;
        if (onPanoParamListener2 != null) {
            onPanoParamListener2.onParam(i, i2, i3, i4);
        }
    }

    public void setOnPanoParamListener(OnPanoParamListener onPanoParamListener2) {
        this.onPanoParamListener = onPanoParamListener2;
    }

    public void setOnPlayProgressListener(OnPlayProgressListener onPlayProgressListener2) {
        this.onPlayProgressListener = onPlayProgressListener2;
    }

    public void setOnPlayStateListener(OnPlayStateListener onPlayStateListener2) {
        this.onPlayStateListener = onPlayStateListener2;
    }

    public void setOnRenderListener(OnRenderListener onRenderListener2) {
        this.onRenderListener = onRenderListener2;
    }

    public void setOnYuvDataListener(OnYuvDataListener onYuvDataListener2) {
        this.onYuvDataListener = onYuvDataListener2;
    }

    public void setGlFishView(GLFisheyeView gLFisheyeView) {
        this.mGLFisheyeView = gLFisheyeView;
    }

    public GLFisheyeView getGLFisheyeView() {
        return this.mGLFisheyeView;
    }

    public void pauseAudio() {
        this.mPlayAudioStat = 10;
    }

    public void playAudio() {
        this.mPlayAudioStat = 12;
    }

    public void setReverse(boolean z) {
        this.mIsReverse = z;
    }

    public void updateRenderData(int i, int i2, byte[] bArr, int i3, int i4, long j, boolean z) {
        if (this.mIsHWDecoding ^ z) {
            this.mIsHWDecoding = z;
        }
        if (!z) {
            renderYUVData(i, i2, bArr, j);
        }
    }

    public void renderYUVData(int i, int i2, byte[] bArr, long j) {
        GLFisheyeView gLFisheyeView = this.mGLFisheyeView;
        if (gLFisheyeView != null) {
            gLFisheyeView.setYUVImage(bArr, i, i2, 1);
            try {
                this.mIsCaptureEnable = true;
                if (i <= 2560 && i2 <= 1920) {
                    this.y.clear();
                    this.u.clear();
                    this.v.clear();
                    int i3 = i * i2;
                    this.y.put(bArr, 0, i3);
                    this.u.put(bArr, i3, i3 / 4);
                    this.v.put(bArr, (i3 * 5) / 4, i3 / 4);
                    this.y.flip();
                    this.u.flip();
                    this.v.flip();
                }
            } catch (Exception unused) {
                int i4 = this.mPlayerIndex;
                if (i4 == 0) {
                    this.y = ihr.O00000o0;
                    this.u = ihr.O00000o;
                    this.v = ihr.O00000oO;
                } else if (i4 == 1) {
                    this.y = ihr.O00000oo;
                    this.u = ihr.O0000O0o;
                    this.v = ihr.O0000OOo;
                } else if (i4 == 2) {
                    this.y = ihr.O0000Oo0;
                    this.u = ihr.O0000Oo;
                    this.v = ihr.O0000OoO;
                } else if (i4 != 3) {
                    this.mPlayerIndex = 0;
                    this.y = ihr.O00000o0;
                    this.u = ihr.O00000o;
                    this.v = ihr.O00000oO;
                } else {
                    this.y = ihr.O0000Ooo;
                    this.u = ihr.O0000o00;
                    this.v = ihr.O0000o0;
                }
            }
        }
    }

    public void setFixType(int i) {
        this.mFixType = i;
        this.mFixTypeChanged = true;
    }

    public void updateProgressIndex(int i, int i2) {
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.arg1 = 2;
            obtainMessage.arg2 = i2;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void SetAudioDataEx(int i, int i2, byte[] bArr) {
        if (this.mAudioCache == null) {
            this.mAudioCache = new ihp();
        }
        ihp ihp = this.mAudioCache;
        if (ihp != null) {
            ihp.O00000Oo(bArr, i2, i);
        }
    }

    public void SetAudioData(int i, int i2, byte[] bArr) {
        ihp ihp = this.mAudioCache;
        if (ihp != null) {
            ihp.O000000o(bArr, i2, i);
        }
    }

    public ihq getAudioData() {
        ihp ihp = this.mAudioCache;
        if (ihp == null || !(!ihp.f1302O000000o.isEmpty())) {
            return null;
        }
        return this.mAudioCache.O000000o();
    }

    public void DisableRender() {
        this.mIsRenderEnable = false;
    }

    public void EnableRender() {
        this.mIsRenderEnable = true;
    }

    public void GetHandler(Handler handler) {
        this.mHandler = handler;
    }

    class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        int f12120O000000o = 1;
        int O00000Oo = 8000;
        int O00000o = 2;
        int O00000o0 = 4;
        int O00000oO;
        private int O0000O0o = 2048;
        private byte[] O0000OOo;
        private int O0000Oo = 0;
        private AudioTrack O0000Oo0;
        private int O0000OoO = 0;
        private boolean O0000Ooo = false;

        public O000000o() {
        }

        public final void run() {
            this.O0000OOo = new byte[HSMediaPlayer.MAX_BUFFER_SIZE];
            this.O00000oO = AudioTrack.getMinBufferSize(this.O00000Oo, this.O00000o0, this.O00000o);
            this.O0000Oo0 = new AudioTrack(3, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO * 4, 1);
            if (this.O0000Oo0.getState() == 1) {
                this.O0000Oo0.play();
            }
            this.O0000Oo = this.O00000oO * 4;
            while (this.f12120O000000o == 1) {
                if (HSMediaPlayer.this.mPlayAudioStat == 10 || HSMediaPlayer.this.mIsSpeaking) {
                    this.O0000Oo0.stop();
                    this.O0000Ooo = true;
                } else if (this.O0000Ooo) {
                    this.O0000Oo0.play();
                    this.O0000Ooo = false;
                }
                ihq audioData = HSMediaPlayer.this.getAudioData();
                if (audioData == null || !HSMediaPlayer.this.mPlaySound || HSMediaPlayer.this.mPlayAudioStat != 12) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.O0000O0o = 0;
                    byte[] bArr = audioData.f1303O000000o;
                    if (bArr.length <= HSMediaPlayer.MAX_BUFFER_SIZE) {
                        System.arraycopy(bArr, 0, this.O0000OOo, 0, bArr.length);
                        this.O0000O0o = bArr.length;
                        if (bArr != null && this.f12120O000000o == 1) {
                            this.O0000OoO = 0;
                            while (this.f12120O000000o == 1) {
                                try {
                                    this.O0000OoO += this.O0000Oo0.write(this.O0000OOo, this.O0000OoO, this.O0000O0o - this.O0000OoO);
                                    if (this.O0000OoO >= this.O0000O0o) {
                                        break;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
            AudioTrack audioTrack = this.O0000Oo0;
            if (audioTrack != null && audioTrack.getState() == 1) {
                try {
                    this.O0000Oo0.stop();
                    this.O0000Oo0.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean SetAudioParam(boolean z) {
        int i = this.mPlayWindowIndex;
        if (i < 0 || i > 3) {
            return false;
        }
        this.mPlaySound = z;
        return true;
    }

    public int getPlayHandle() {
        return this.mPlayHandle;
    }

    public void resetZoomView() {
        GLFisheyeView gLFisheyeView = this.mGLFisheyeView;
        if (gLFisheyeView != null) {
            gLFisheyeView.resetZoomView();
        }
    }

    public void onRenderCall(byte[] bArr, int i, int i2, long j) {
        if (this.lFirstTimestamp == 0) {
            this.lFirstTimestamp = j;
        }
        if (this.videoDuration <= 0) {
            this.videoDuration = getDuration();
        }
        OnYuvDataListener onYuvDataListener2 = this.onYuvDataListener;
        if (onYuvDataListener2 != null) {
            onYuvDataListener2.onYuv(bArr, i, i2);
        }
        if (this.onPlayProgressListener != null) {
            int i3 = (int) (j - this.lFirstTimestamp);
            int i4 = this.videoPosition;
            if (i4 == 0 || i4 > i3 || i3 - i4 >= 500) {
                this.videoPosition = i3;
                this.onPlayProgressListener.onTimestamp(j);
                this.onPlayProgressListener.onProgress(i3, this.videoDuration);
            }
        }
    }

    public void onMessageCallback(int i, int i2) {
        OnPlayStateListener onPlayStateListener2;
        if (i2 == 254 && (onPlayStateListener2 = this.onPlayStateListener) != null) {
            onPlayStateListener2.onCompleted(i, i2);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            if (i2 == 1) {
                obtainMessage.what = 1010;
                obtainMessage.arg1 = 1;
                obtainMessage.arg2 = i;
                this.mHandler.sendMessage(obtainMessage);
            } else if (i2 == 2) {
                obtainMessage.what = 1010;
                obtainMessage.arg1 = 6;
                obtainMessage.arg2 = i;
                this.mHandler.sendMessage(obtainMessage);
            } else {
                obtainMessage.what = 1010;
                obtainMessage.arg1 = 0;
                obtainMessage.arg2 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
    }

    public void setmIsPlaying(boolean z) {
        this.mIsPlaying = z;
    }

    public void start(String str) {
        ihs.O000000o("HSMediaPlayer", "start: " + str + " " + this.mIsPlaying);
        if (str != null) {
            if (!new File(str).exists() && this.onPlayStateListener != null) {
                ihs.O00000Oo("HSMediaPlayer", "start: error file no exist");
                this.onPlayStateListener.onError(-1);
            }
            if (!this.mIsPlaying) {
                this.mPlaySound = true;
                this.mIsPlaying = true;
                this.lFirstTimestamp = 0;
                this.videoDuration = 0;
                this.videoPosition = 0;
                this.mIsCaptureEnable = false;
                this.mFixTypeChanged = false;
                initJavaVM();
                this.mPlayHandle = startPlayMP4File(this, this.mPlayWindowIndex, str);
                ihs.O000000o("HSMediaPlayer", "start: jni result = " + this.mPlayHandle);
                if (this.mPlayHandle > 0) {
                    O000000o o000000o = this.mAudioPlayer;
                    if (o000000o != null) {
                        o000000o.f12120O000000o = -1;
                        this.mAudioPlayer = null;
                    }
                    try {
                        this.mAudioPlayer = new O000000o();
                        this.mAudioPlayer.f12120O000000o = 1;
                        this.mAudioPlayer.start();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void stop() {
        this.mIsPlaying = false;
        this.mIsCaptureEnable = false;
        O000000o o000000o = this.mAudioPlayer;
        if (o000000o != null) {
            o000000o.f12120O000000o = -1;
            this.mAudioPlayer = null;
        }
        ihp ihp = this.mAudioCache;
        if (ihp != null) {
            ihp.O00000Oo = 0;
            if (ihp.f1302O000000o != null) {
                ihp.f1302O000000o.clear();
            }
        }
        int i = this.mPlayWindowIndex;
        if (i >= 0) {
            stopPlayMP4File(i, this.mPlayHandle);
        }
    }

    public void pause() {
        if (this.mPlaySound) {
            pauseAudio();
        }
        pausePlayMP4File(this.mPlayWindowIndex, this.mPlayHandle);
    }

    public void resume() {
        if (this.mPlaySound) {
            playAudio();
        }
        resumePlayMP4File(this.mPlayWindowIndex, this.mPlayHandle);
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public void seekTo(int i) {
        this.videoPosition = 0;
        seekTimeMP4File(this.mPlayWindowIndex, this.mPlayHandle, 0, i);
    }

    public int getDuration() {
        return (int) ((long) getVideoDuration(this.mPlayWindowIndex, this.mPlayHandle));
    }

    public Bitmap screenShot() {
        Bitmap bitmap = this.image;
        if (bitmap != null) {
            bitmap.recycle();
            this.image = null;
        }
        ihr.O00000Oo.clear();
        int[] iArr = new int[2];
        if (getScreenShotBuffer(this.mPlayWindowIndex, ihr.f1304O000000o, iArr) > 0) {
            this.image = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.RGB_565);
            this.image.copyPixelsFromBuffer(ihr.O00000Oo);
            ihr.O00000Oo.position(0);
        }
        return this.image;
    }
}
