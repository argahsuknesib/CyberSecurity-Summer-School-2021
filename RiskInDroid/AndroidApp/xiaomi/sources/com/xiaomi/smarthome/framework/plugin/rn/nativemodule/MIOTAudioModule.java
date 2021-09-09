package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.dxx;
import _m_j.fyc;
import _m_j.fye;
import _m_j.fyf;
import _m_j.gbi;
import _m_j.gbq;
import _m_j.gbu;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.camera.audioprocess.ByteDataBufferCopy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class MIOTAudioModule extends MIOTBaseJavaModule {
    public byte[] audioPlayerBuffer;
    public ByteDataBufferCopy byteDataBuffer;
    public byte[] g711Buffer;
    private String mAudioPlayerUid = "";
    public AudioRecord mAudioRecord = null;
    public AudioTrack mAudioTrack;
    public ByteBuffer mByteBuffer;
    public Handler mHandler = null;
    public volatile boolean mIsAudioRecording = false;
    public boolean mIsAudioTrackPlaying = false;
    private boolean mIsMediaRecording = false;
    public MediaPlayer mMediaPlayer = new MediaPlayer();
    private MediaRecorder mMediaRecorder = null;
    public ByteDataBufferCopy mPlayByteDataBuffer;
    public boolean mShouldSendPlayerTime = false;

    public String getName() {
        return "MIOTAudio";
    }

    public MIOTAudioModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void initHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (MIOTAudioModule.this.mShouldSendPlayerTime && message.what == 1 && MIOTAudioModule.this.mMediaPlayer != null) {
                        try {
                            if (MIOTAudioModule.this.mMediaPlayer.isPlaying()) {
                                WritableMap createMap = Arguments.createMap();
                                createMap.putInt("currentTime", MIOTAudioModule.this.mMediaPlayer.getCurrentPosition() / 1000);
                                MIOTAudioModule.this.sendPlayerEventToJs(createMap, "updateAudioPlayerTime_36621");
                                MIOTAudioModule.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                            }
                        } catch (IllegalStateException e) {
                            fyc.O000000o("MIOTAudioModule", "sendPlayerEventToJs error:", e);
                        }
                    }
                }
            };
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("isAbleToRecord", Boolean.valueOf(getReactApplicationContext().checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0));
        return hashMap;
    }

    @ReactMethod
    public void startRecord(String str, ReadableMap readableMap, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, "audioName is empty...");
        } else if ("audioRecord".equals(fyf.O000000o(readableMap, "RecordType", "mediaRecord"))) {
            try {
                startAudioRecord(str, readableMap);
                callback.invoke(Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
                callback.invoke(Boolean.FALSE, e.toString());
            }
        } else {
            try {
                startMediaRecorder(str, readableMap);
                callback.invoke(Boolean.TRUE);
            } catch (Exception e2) {
                e2.printStackTrace();
                callback.invoke(Boolean.FALSE, e2.toString());
            }
        }
    }

    @ReactMethod
    public void stopRecord(Callback callback) {
        try {
            stopMediaRecorder();
            stopAudioRecord();
            callback.invoke(Boolean.TRUE);
        } catch (Exception e) {
            callback.invoke(Boolean.FALSE, e.toString());
        }
    }

    @ReactMethod
    public void getRecordingPeakPower(Callback callback) {
        int i;
        if (callback != null) {
            MediaRecorder mediaRecorder = this.mMediaRecorder;
            if (mediaRecorder == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "MediaRecorder is not init..."));
            } else if (!this.mIsMediaRecording) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "MediaRecorder is not recording..."));
            } else {
                try {
                    i = mediaRecorder.getMaxAmplitude();
                } catch (IllegalStateException e) {
                    gbu.O00000Oo(e.toString());
                    i = 0;
                }
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, Integer.valueOf(i)));
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0189, code lost:
        if (r2.equals("audioQualityHigh") != false) goto L_0x01e9;
     */
    private void startMediaRecorder(String str, ReadableMap readableMap) throws Exception {
        char c;
        boolean z;
        ReadableMap readableMap2 = readableMap;
        String pathName = getPathName(str);
        fyc.O00000Oo("ReactNativeJS", "录音路径".concat(String.valueOf(pathName)));
        File file = new File(pathName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try {
            stopMediaRecorder();
        } catch (Throwable th) {
            fyc.O00000o("ReactNativeJS", Log.getStackTraceString(th));
        }
        this.mMediaRecorder = new MediaRecorder();
        this.mMediaRecorder.setAudioSource(1);
        int O000000o2 = fyf.O000000o(readableMap2, "AVSampleRateKey", 0);
        int O000000o3 = fyf.O000000o(readableMap2, "AVNumberOfChannelsKey", 0);
        int O000000o4 = fyf.O000000o(readableMap2, "AVLinearPCMBitDepthKey", 0);
        String O000000o5 = fyf.O000000o(readableMap2, "AVFormatIDKey", "");
        String O000000o6 = fyf.O000000o(readableMap2, "AVEncoderAudioQualityKey", "");
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (O000000o2 == 0) {
            O000000o2 = 44100;
        }
        mediaRecorder.setAudioSamplingRate(O000000o2);
        MediaRecorder mediaRecorder2 = this.mMediaRecorder;
        if (O000000o4 == 0) {
            O000000o4 = 16;
        }
        mediaRecorder2.setAudioEncodingBitRate(O000000o4);
        MediaRecorder mediaRecorder3 = this.mMediaRecorder;
        if (O000000o3 == 0) {
            O000000o3 = 2;
        }
        mediaRecorder3.setAudioChannels(O000000o3);
        char c2 = 6;
        switch (O000000o5.hashCode()) {
            case -1186453540:
                if (O000000o5.equals("audioFormat60958AC3")) {
                    c = 13;
                    break;
                }
                c = 65535;
                break;
            case -1061120799:
                if (O000000o5.equals("audioFormatMPEG4AAC")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -853164747:
                if (O000000o5.equals("MPEG4CELP")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -852999096:
                if (O000000o5.equals("MPEG4HVXC")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -295359931:
                if (O000000o5.equals("audioFormatMPEG4TwinVQ")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 64593:
                if (O000000o5.equals("AC3")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 64934:
                if (O000000o5.equals("AMR")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 739019185:
                if (O000000o5.equals("audioFormatAMR_WB")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 955522415:
                if (O000000o5.equals("60958AC3")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 981198802:
                if (O000000o5.equals("MPEG4TwinVQ")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1080855156:
                if (O000000o5.equals("MPEG4AAC")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 1465057384:
                if (O000000o5.equals("audioFormatMPEG4CELP")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1465223035:
                if (O000000o5.equals("audioFormatMPEG4HVXC")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1934542852:
                if (O000000o5.equals("AMR_WB")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2036425156:
                if (O000000o5.equals("audioFormatAC3")) {
                    c = 12;
                    break;
                }
                c = 65535;
                break;
            case 2036425497:
                if (O000000o5.equals("audioFormatAMR")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                this.mMediaRecorder.setOutputFormat(3);
                this.mMediaRecorder.setAudioEncoder(1);
                z = true;
                break;
            case 2:
            case 3:
                this.mMediaRecorder.setOutputFormat(4);
                this.mMediaRecorder.setAudioEncoder(2);
                z = true;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case 11:
                this.mMediaRecorder.setOutputFormat(2);
                z = false;
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mMediaRecorder.setOutputFormat(6);
                } else {
                    this.mMediaRecorder.setOutputFormat(0);
                }
                z = false;
                break;
            default:
                this.mMediaRecorder.setOutputFormat(0);
                z = false;
                break;
        }
        if (!z) {
            switch (O000000o6.hashCode()) {
                case -1994163307:
                    if (O000000o6.equals("Medium")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1636599221:
                    if (O000000o6.equals("audioQualityLow")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1636598693:
                    if (O000000o6.equals("audioQualityMax")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1636598455:
                    if (O000000o6.equals("audioQualityMin")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 76596:
                    if (O000000o6.equals("Low")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77124:
                    if (O000000o6.equals("Max")) {
                        c2 = 9;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77362:
                    if (O000000o6.equals("Min")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2249154:
                    if (O000000o6.equals("High")) {
                        c2 = 8;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 560283934:
                    if (O000000o6.equals("audioQualityMedium")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 804906379:
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    this.mMediaRecorder.setAudioEncoder(3);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.mMediaRecorder.setAudioEncoder(5);
                    } else {
                        this.mMediaRecorder.setAudioEncoder(3);
                    }
                case 6:
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                case 9:
                    if (Build.VERSION.SDK_INT < 16) {
                        this.mMediaRecorder.setAudioEncoder(3);
                        break;
                    } else {
                        this.mMediaRecorder.setAudioEncoder(4);
                        break;
                    }
                default:
                    this.mMediaRecorder.setAudioEncoder(0);
                    break;
            }
        }
        this.mMediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass2 */

            public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                fyc.O00000o("ReactNativeJS", "startMediaRecorder,MediaRecorder get error: what=" + i + ",extra:" + i2);
            }
        });
        this.mMediaRecorder.setOutputFile(file.getAbsolutePath());
        this.mMediaRecorder.prepare();
        this.mMediaRecorder.start();
        this.mIsMediaRecording = true;
    }

    private void stopMediaRecorder() throws Exception {
        if (this.mMediaRecorder != null) {
            gbu.O000000o("MIOTAudioModule  MediaRecorder will stop...");
            this.mMediaRecorder.stop();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
        }
        this.mIsMediaRecording = false;
    }

    private void startAudioRecord(String str, ReadableMap readableMap) throws Exception {
        final String pathName = getPathName(str);
        fyc.O00000Oo("ReactNativeJS", "录音路径".concat(String.valueOf(pathName)));
        File file = new File(pathName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try {
            stopAudioRecord();
        } catch (Throwable th) {
            fyc.O00000o("ReactNativeJS", Log.getStackTraceString(th));
        }
        int O000000o2 = fyf.O000000o(readableMap, "AVSampleRateKey", 0);
        int O000000o3 = fyf.O000000o(readableMap, "AVNumberOfChannelsKey", 0);
        int O000000o4 = fyf.O000000o(readableMap, "AVLinearPCMBitDepthKey", 0);
        final String O000000o5 = fyf.O000000o(readableMap, "AVFormatIDKey", "");
        int i = O000000o2 == 0 ? 44100 : O000000o2;
        if (O000000o4 == 0) {
            O000000o4 = 16;
        }
        if (O000000o3 == 0) {
            O000000o3 = 2;
        }
        int i2 = ((i * 2) * 10) / 1000;
        int i3 = O000000o3 == 1 ? 16 : 12;
        int i4 = O000000o4 == 16 ? 2 : 3;
        int minBufferSize = AudioRecord.getMinBufferSize(i, i3, i4);
        if (TextUtils.equals(O000000o5, "G711") && minBufferSize < i2) {
            minBufferSize = i2;
        }
        this.mAudioRecord = new AudioRecord(1, i, i3, i4, minBufferSize);
        final int i5 = i2;
        final int i6 = minBufferSize;
        new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass3 */

            /* JADX WARNING: Removed duplicated region for block: B:40:0x00f2 A[SYNTHETIC, Splitter:B:40:0x00f2] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x0100 A[SYNTHETIC, Splitter:B:46:0x0100] */
            /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            public final void run() {
                byte[] bArr;
                byte[] encodeG711;
                DataOutputStream dataOutputStream = null;
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathName)));
                    try {
                        if (TextUtils.equals(O000000o5, "G711")) {
                            bArr = new byte[i5];
                        } else {
                            bArr = new byte[i6];
                        }
                        MIOTAudioModule.this.mAudioRecord.startRecording();
                        MIOTAudioModule.this.mIsAudioRecording = true;
                        MIOTAudioModule.this.g711Buffer = new byte[640];
                        MIOTAudioModule.this.byteDataBuffer = new ByteDataBufferCopy();
                        while (MIOTAudioModule.this.mIsAudioRecording) {
                            int read = MIOTAudioModule.this.mAudioRecord.read(bArr, 0, bArr.length);
                            if (TextUtils.equals(O000000o5, "G711")) {
                                byte[] bArr2 = new byte[read];
                                System.arraycopy(bArr, 0, bArr2, 0, read);
                                MIOTAudioModule.this.byteDataBuffer.put(bArr2);
                                if (MIOTAudioModule.this.byteDataBuffer.take(MIOTAudioModule.this.g711Buffer) && (encodeG711 = CameraRouterFactory.getRNCameraApi().encodeG711(MIOTAudioModule.this.g711Buffer, 0, MIOTAudioModule.this.g711Buffer.length)) != null) {
                                    try {
                                        byte[] bArr3 = (byte[]) encodeG711.clone();
                                        dataOutputStream2.write(bArr3, 0, bArr3.length);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                dataOutputStream2.write(bArr, 0, read);
                            }
                            gbu.O000000o(Thread.currentThread().getName() + "  录制中....");
                        }
                        gbu.O000000o(Thread.currentThread().getName() + "  录制结束....");
                        MIOTAudioModule.this.stopAudioRecord();
                        try {
                            dataOutputStream2.flush();
                            dataOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        dataOutputStream = dataOutputStream2;
                        try {
                            e.printStackTrace();
                            if (dataOutputStream == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            dataOutputStream2 = dataOutputStream;
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.flush();
                                    dataOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataOutputStream2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    if (dataOutputStream == null) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public synchronized void stopAudioRecord() throws Exception {
        gbu.O000000o(Thread.currentThread().getName() + "  stopAudioRecord...mIsAudioRecording=" + this.mIsAudioRecording);
        this.mIsAudioRecording = false;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        if (this.byteDataBuffer != null) {
            this.byteDataBuffer.clear();
            this.byteDataBuffer = null;
        }
        this.g711Buffer = null;
    }

    @ReactMethod
    public void startPlay(String str, ReadableMap readableMap, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, "audio player path is empty...");
        } else if ("audioTrack".equals(fyf.O000000o(readableMap, "playerType", "mediaPlayer"))) {
            startAudioTrack(str, readableMap, callback);
        } else {
            startMediaPlayer(str, readableMap, callback);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1 A[Catch:{ Exception -> 0x00dd }] */
    private void startMediaPlayer(String str, ReadableMap readableMap, Callback callback) {
        String str2;
        boolean z;
        AudioManager audioManager;
        initHandler();
        if (str != null) {
            try {
                if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtsp://")) {
                    str2 = str;
                    if (readableMap != null) {
                        z = false;
                    } else {
                        z = readableMap.hasKey("updateAudioPlayerTimeInterval");
                    }
                    this.mShouldSendPlayerTime = z;
                    this.mAudioPlayerUid = fyf.O000000o(readableMap, "audioPlayerUid", "");
                    if (!TextUtils.isEmpty(str2) || str2.startsWith("http://") || str2.startsWith("https://") || str2.startsWith("rtsp://") || gbi.O00000Oo(str2)) {
                        if (this.mMediaPlayer != null) {
                            this.mMediaPlayer = new MediaPlayer();
                        } else {
                            this.mMediaPlayer.reset();
                        }
                        this.mMediaPlayer.setDataSource(str2);
                        this.mMediaPlayer.setAudioStreamType(3);
                        audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
                        if (audioManager.getStreamMaxVolume(3) < 10) {
                            audioManager.setStreamVolume(3, 10, 4);
                        }
                        this.mMediaPlayer.setLooping(false);
                        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass4 */

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                MIOTAudioModule.this.stopPlay(null);
                                MIOTAudioModule.this.sendPlayerEventToJs(Arguments.createMap(), "audioPlayerDidFinishPlaying_36621");
                            }
                        });
                        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass5 */

                            public final void onPrepared(MediaPlayer mediaPlayer) {
                                MIOTAudioModule mIOTAudioModule = MIOTAudioModule.this;
                                mIOTAudioModule.mMediaPlayer = mediaPlayer;
                                mIOTAudioModule.mMediaPlayer.start();
                                if (MIOTAudioModule.this.mShouldSendPlayerTime) {
                                    MIOTAudioModule.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                                }
                                MIOTAudioModule.this.sendPlayerEventToJs(Arguments.createMap(), "audioPlayerDidStartPlaying_36621");
                            }
                        });
                        this.mMediaPlayer.prepareAsync();
                        callback.invoke(Boolean.TRUE);
                    }
                    gbu.O00000o("startMediaPlayer, audio file not exist: aPath=" + str + ", pathName=" + str2);
                    callback.invoke(Boolean.FALSE, "audio file not exist");
                    return;
                }
            } catch (Exception e) {
                callback.invoke(Boolean.FALSE, Log.getStackTraceString(e));
                return;
            }
        }
        str2 = getPathName(str);
        if (readableMap != null) {
        }
        this.mShouldSendPlayerTime = z;
        this.mAudioPlayerUid = fyf.O000000o(readableMap, "audioPlayerUid", "");
        if (!TextUtils.isEmpty(str2)) {
        }
        if (this.mMediaPlayer != null) {
        }
        this.mMediaPlayer.setDataSource(str2);
        this.mMediaPlayer.setAudioStreamType(3);
        audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
        if (audioManager.getStreamMaxVolume(3) < 10) {
        }
        this.mMediaPlayer.setLooping(false);
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass4 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                MIOTAudioModule.this.stopPlay(null);
                MIOTAudioModule.this.sendPlayerEventToJs(Arguments.createMap(), "audioPlayerDidFinishPlaying_36621");
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass5 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                MIOTAudioModule mIOTAudioModule = MIOTAudioModule.this;
                mIOTAudioModule.mMediaPlayer = mediaPlayer;
                mIOTAudioModule.mMediaPlayer.start();
                if (MIOTAudioModule.this.mShouldSendPlayerTime) {
                    MIOTAudioModule.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                }
                MIOTAudioModule.this.sendPlayerEventToJs(Arguments.createMap(), "audioPlayerDidStartPlaying_36621");
            }
        });
        this.mMediaPlayer.prepareAsync();
        callback.invoke(Boolean.TRUE);
    }

    private void startAudioTrack(String str, ReadableMap readableMap, Callback callback) {
        String str2 = str;
        ReadableMap readableMap2 = readableMap;
        Callback callback2 = callback;
        int i = 2;
        if (TextUtils.isEmpty(str)) {
            callback2.invoke(Boolean.FALSE, "audio path is empty...");
            return;
        }
        Boolean valueOf = Boolean.valueOf(str2.startsWith("http://") || str2.startsWith("https://"));
        if (!valueOf.booleanValue() && !str2.startsWith("rtsp://")) {
            str2 = getPathName(str);
        }
        String str3 = str2;
        if (this.mAudioTrack != null) {
            try {
                stopAudioTrack();
            } catch (Exception unused) {
            }
        }
        this.mAudioPlayerUid = fyf.O000000o(readableMap2, "audioPlayerUid", "");
        int O000000o2 = fyf.O000000o(readableMap2, "AVSampleRateKey", 0);
        int O000000o3 = fyf.O000000o(readableMap2, "AVNumberOfChannelsKey", 0);
        int O000000o4 = fyf.O000000o(readableMap2, "AVLinearPCMBitDepthKey", 0);
        int i2 = O000000o2 == 0 ? 44100 : O000000o2;
        if (O000000o4 == 0) {
            O000000o4 = 16;
        }
        if (O000000o3 == 0) {
            O000000o3 = 2;
        }
        String O000000o5 = fyf.O000000o(readableMap2, "AVFormatIDKey", "");
        int i3 = O000000o3 == 1 ? 4 : 12;
        if (O000000o4 != 16) {
            i = 3;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i);
        this.mAudioTrack = new AudioTrack(3, i2, i3, i, minBufferSize, 1);
        ByteDataBufferCopy byteDataBufferCopy = this.mPlayByteDataBuffer;
        if (byteDataBufferCopy != null) {
            byteDataBufferCopy.clear();
            this.mPlayByteDataBuffer = null;
        }
        initBuffer(640);
        this.mPlayByteDataBuffer = new ByteDataBufferCopy();
        this.mIsAudioTrackPlaying = true;
        this.mAudioTrack.play();
        callback2.invoke(Boolean.TRUE);
        final Boolean bool = valueOf;
        final String str4 = str3;
        final String str5 = O000000o5;
        final int i4 = minBufferSize;
        new Thread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass6 */

            public final void run() {
                int i;
                DataInputStream dataInputStream = null;
                try {
                    if (bool.booleanValue()) {
                        URL url = new URL(str4);
                        dxx.O000000o();
                        dataInputStream = new DataInputStream(new BufferedInputStream(dxx.O000000o(url).getInputStream()));
                    } else {
                        dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(str4)));
                    }
                    if (TextUtils.equals(str5, "G711")) {
                        i = 320;
                    } else {
                        i = i4;
                    }
                    byte[] bArr = new byte[i];
                    int read = dataInputStream.read(bArr);
                    if (MIOTAudioModule.this.mIsAudioTrackPlaying && read > 0) {
                        MIOTAudioModule.this.sendPlayerEventToJs(Arguments.createMap(), "audioPlayerDidStartPlaying_36621");
                    }
                    gbu.O000000o(Thread.currentThread().getName() + "  开始播放   readCount=" + read);
                    while (MIOTAudioModule.this.mIsAudioTrackPlaying && read > 0) {
                        if (TextUtils.equals(str5, "G711")) {
                            CameraRouterFactory.getRNCameraApi().decodeG711(bArr, 0, bArr.length, MIOTAudioModule.this.audioPlayerBuffer);
                            MIOTAudioModule.this.mPlayByteDataBuffer.put((byte[]) MIOTAudioModule.this.audioPlayerBuffer.clone());
                            if (MIOTAudioModule.this.mPlayByteDataBuffer.take(MIOTAudioModule.this.audioPlayerBuffer) && MIOTAudioModule.this.mByteBuffer != null) {
                                if (MIOTAudioModule.runningOnLollipopOrHigher()) {
                                    MIOTAudioModule.this.mByteBuffer.clear();
                                    MIOTAudioModule.this.mByteBuffer.put(MIOTAudioModule.this.audioPlayerBuffer);
                                    MIOTAudioModule.this.mByteBuffer.rewind();
                                    MIOTAudioModule.this.mAudioTrack.write(MIOTAudioModule.this.mByteBuffer, MIOTAudioModule.this.mByteBuffer.capacity(), 0);
                                } else {
                                    MIOTAudioModule.this.mAudioTrack.write(MIOTAudioModule.this.audioPlayerBuffer, 0, MIOTAudioModule.this.audioPlayerBuffer.length);
                                }
                                gbu.O000000o(Thread.currentThread().getName() + "  播放   readCount=" + read);
                            }
                        } else {
                            MIOTAudioModule.this.mAudioTrack.write(bArr, 0, read);
                            gbu.O000000o(Thread.currentThread().getName() + "  播放   readCount=" + read);
                        }
                        read = dataInputStream.read(bArr);
                    }
                    if (read <= 0) {
                        MIOTAudioModule.this.sendPlayerEventToJs(Arguments.createMap(), "audioPlayerDidFinishPlaying_36621");
                    }
                    gbu.O000000o(Thread.currentThread().getName() + "  停止播放   readCount=" + read);
                    MIOTAudioModule.this.stopAudioTrack();
                    try {
                        dataInputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Throwable th) {
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
        }).start();
    }

    public static boolean runningOnLollipopOrHigher() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: package-private */
    public void initBuffer(int i) {
        ByteDataBufferCopy byteDataBufferCopy = this.mPlayByteDataBuffer;
        if (byteDataBufferCopy != null) {
            byteDataBufferCopy.clear();
        }
        this.audioPlayerBuffer = new byte[i];
        ByteBuffer byteBuffer = this.mByteBuffer;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.mByteBuffer = ByteBuffer.allocateDirect(i);
    }

    @ReactMethod
    public void stopPlay(Callback callback) {
        try {
            stopMediaPlayer();
            stopAudioTrack();
            if (callback != null) {
                callback.invoke(Boolean.TRUE);
            }
        } catch (Exception e) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE, Log.getStackTraceString(e));
            }
        }
    }

    private void stopMediaPlayer() throws Exception {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public synchronized void stopAudioTrack() throws Exception {
        gbu.O000000o(Thread.currentThread().getName() + "  stopPlayTrack...");
        this.mIsAudioTrackPlaying = false;
        if (this.mAudioTrack != null) {
            if (this.mAudioTrack.getPlayState() == 3) {
                this.mAudioTrack.flush();
                this.mAudioTrack.stop();
            }
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
        if (this.mPlayByteDataBuffer != null) {
            this.mPlayByteDataBuffer.clear();
            this.mPlayByteDataBuffer = null;
        }
        this.audioPlayerBuffer = null;
        if (this.mByteBuffer != null) {
            this.mByteBuffer.clear();
            this.mByteBuffer = null;
        }
    }

    public void sendPlayerEventToJs(WritableMap writableMap, String str) {
        if (writableMap == null) {
            writableMap = Arguments.createMap();
        }
        writableMap.putString("audioPlayerUid", this.mAudioPlayerUid);
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            gbu.O000000o("MIOTAudio send event  ".concat(String.valueOf(str)));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
            return;
        }
        gbu.O00000Oo("MIOTAudio reactContext is null ...");
    }

    private String getPathName(String str) {
        if (str == null) {
            return getFilesPath() + File.separator + "defaultname";
        } else if (str.startsWith("file://")) {
            return str.substring(7);
        } else {
            if (str.startsWith(File.separator)) {
                return str;
            }
            return getFilesPath() + File.separator + str;
        }
    }

    @ReactMethod
    public void wavToAmr(String str, String str2, final Callback callback) {
        try {
            final fye fye = new fye();
            fye.f17404O000000o = "audio/amr-wb";
            fye.O000000o(getPathName(str), getPathName(str2));
            fye.O000000o();
            fye.O00000Oo();
            fye.O0000o00 = new fye.O00000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass7 */

                public final void O000000o() {
                    fye.O00000o();
                    callback.invoke(Boolean.TRUE);
                }
            };
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    @ReactMethod
    public void amrToWav(String str, String str2, final Callback callback) {
        try {
            final fye fye = new fye();
            fye.f17404O000000o = "audio/x-wav";
            fye.O000000o(getPathName(str), getPathName(str2));
            fye.O000000o();
            fye.O00000Oo();
            fye.O0000o00 = new fye.O00000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTAudioModule.AnonymousClass8 */

                public final void O000000o() {
                    fye.O00000o();
                    callback.invoke(Boolean.TRUE);
                }
            };
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, Log.getStackTraceString(th));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0006 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0009 */
    public void onCatalystInstanceDestroy() {
        stopMediaPlayer();
        stopAudioTrack();
        stopMediaRecorder();
        stopAudioRecord();
    }
}
