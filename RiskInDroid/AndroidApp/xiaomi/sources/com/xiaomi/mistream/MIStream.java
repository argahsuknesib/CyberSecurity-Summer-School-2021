package com.xiaomi.mistream;

import _m_j.ckg;
import _m_j.ckh;
import _m_j.cki;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.tutk.IOTC.IOTCAPIs;
import com.tutk.IOTC.Packet;
import com.tutk.P2PUtils;
import com.xiaomi.mistream.MIStream;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.MissConfig;
import com.xiaomi.smarthome.camera.MissNetworkType;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.fastvideo.decoder.AudioRawDataSaveHelper;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import org.json.JSONException;
import org.json.JSONObject;

public class MIStream {
    public static final Object sLockObj = new Object();
    private AudioRawDataSaveHelper audioRawDataSaveHelper;
    private String buildID = (Build.SERIAL + "_" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10));
    private String did;
    public boolean isAudioEnabled = false;
    public boolean isCallStarted = false;
    public boolean isSessionConnected = false;
    public boolean isSessionInit = false;
    public boolean isVideoEnabled = false;
    private int lastVideoSequence;
    private Handler mAudioSenderHandler;
    private volatile HandlerThread mAudioSenderThread;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread;
    private String model;
    private String networkType;
    public IStreamHandler streamHandler;

    private native void missClientFinish();

    private native int missClientSessionClose(String str);

    private native int missClientSessionOpen(String str, String str2, String str3, String str4, boolean z, MissConfig missConfig);

    public static native int missClientSessionPreOpen(String[] strArr);

    private native int missCmdSend(int i, String str, String str2);

    private native int missLogSetLevel(int i);

    private native int missLogSetPath(String str);

    private native int missRdtSend(byte[] bArr, int i, String str);

    public static native int missRpcProcess(int i, String str);

    private native int missSendAudioData(byte[] bArr, int i, int i2, int i3, long j, String str);

    private native int missStatisticsSet(int i, String str);

    static {
        System.loadLibrary("TUTKGlobalAPIs");
        System.loadLibrary("AVAPIs");
        System.loadLibrary("IOTCAPIs");
        System.loadLibrary("RDTAPIs");
        System.loadLibrary("sCHL");
        System.loadLibrary("PPCS_API");
        System.loadLibrary("sodiumjni");
        System.loadLibrary("miss");
        System.loadLibrary("mijia_native_log");
    }

    public MIStream() {
        StringBuilder sb = new StringBuilder("buildID:");
        sb.append(this.buildID);
        cki.O00000o0("MIStream", sb.toString());
        this.mWorkerThread = new HandlerThread("MiStream Handler");
        this.mWorkerThread.start();
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper());
    }

    private static void onMissRpcSend(final int i, byte[] bArr, byte[] bArr2) {
        String str = new String(bArr);
        String str2 = new String(bArr2);
        cki.O00000o0("MIStream", "onMissRpcSend:" + i + ":" + str + ":" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            sendCloudRequest(jSONObject.optString("did"), str, jSONObject, new Callback<JSONObject>() {
                /* class com.xiaomi.mistream.MIStream.AnonymousClass1 */

                public final void onSuccess(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        StringBuilder sb = new StringBuilder("missRpcProcess:");
                        sb.append(jSONObject != null ? jSONObject : "");
                        cki.O00000o0("MIStream", sb.toString());
                        MIStream.missRpcProcess(i, jSONObject.toString());
                    }
                }

                public final void onFailure(int i, String str) {
                    cki.O00000o0("MIStream", "onMissRpcSend failed:" + i + " errorInfo:" + str);
                    MIStream.missRpcProcess(i, String.valueOf(i));
                }
            });
        } catch (JSONException e) {
            cki.O00000o0("MIStream", "sendCloudRequest:" + e.getLocalizedMessage());
        }
    }

    private static void sendCloudRequest(String str, String str2, JSONObject jSONObject, Callback callback) {
        if (ckg.O00000Oo().O000000o() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null) {
            XmPluginHostApi.instance().callSmartHomeApi(str, str2, jSONObject, callback, Parser.DEFAULT_PARSER);
        } else if (callback != null) {
            callback.onFailure(-1000, "params invalid");
        }
    }

    private void onMissStatistics(byte[] bArr) {
        if (this.isSessionInit && bArr != null && bArr.length > 0) {
            this.mWorkerHandler.post(new Runnable(bArr) {
                /* class com.xiaomi.mistream.$$Lambda$MIStream$6xBG7SDpPJlVj7muvjjrsk5hzLk */
                private final /* synthetic */ byte[] f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MIStream.this.lambda$onMissStatistics$0$MIStream(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onMissStatistics$0$MIStream(byte[] bArr) {
        try {
            String str = new String(bArr);
            cki.O00000o0("MIStream", "onMissStatistics:".concat(str));
            MIStreamStatistic.getInstance().sendStatisticRequest(this.model, this.did, "POST", new JSONObject(str), new Callback() {
                /* class com.xiaomi.mistream.MIStream.AnonymousClass2 */

                public void onSuccess(Object obj) {
                    cki.O00000o0("MIStream", "sendStatisticRequest:".concat(String.valueOf(obj)));
                }

                public void onFailure(int i, String str) {
                    cki.O00000o0("MIStream", "sendStatisticRequest:" + i + " info:" + str);
                }
            });
        } catch (Exception e) {
            cki.O00000o0("MIStream", "onMissStatistics:" + e.getLocalizedMessage());
        }
    }

    private void onMissOnConnect() {
        cki.O00000o("MIStream", "onMissOnConnect");
        if (this.streamHandler != null) {
            runInUIThread(new Runnable() {
                /* class com.xiaomi.mistream.$$Lambda$MIStream$JsuoogGa57OcfONf1YDWQIMn8TY */

                public final void run() {
                    MIStream.this.lambda$onMissOnConnect$1$MIStream();
                }
            });
        }
        this.isSessionConnected = true;
        int i = 0;
        this.lastVideoSequence = 0;
        IStreamHandler iStreamHandler = this.streamHandler;
        if (iStreamHandler != null && iStreamHandler.isAutoVideo()) {
            try {
                JSONObject startExtra = DeviceModelManager.getStartExtra(this.model, this.did);
                if (startExtra == null) {
                    startExtra = new JSONObject();
                    startExtra.put("videoquality", 0);
                    if (this.isAudioEnabled) {
                        i = 1;
                    }
                    startExtra.put("enableaudio", i);
                    startExtra.put("imei", this.buildID);
                }
                missCommandSend(258, startExtra.toString(), new IStreamCallback<Integer>() {
                    /* class com.xiaomi.mistream.MIStream.AnonymousClass3 */

                    public void onProgress(int i) {
                    }

                    public void onSuccess(Integer num, Object obj) {
                        MIStream mIStream = MIStream.this;
                        mIStream.isVideoEnabled = true;
                        mIStream.runInUIThread(new Runnable() {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$3$PxUvCqU5d7gyjuGrVyBCsEP6rE */

                            public final void run() {
                                MIStream.AnonymousClass3.this.lambda$onSuccess$0$MIStream$3();
                            }
                        });
                    }

                    public /* synthetic */ void lambda$onSuccess$0$MIStream$3() {
                        if (MIStream.this.streamHandler != null) {
                            MIStream.this.streamHandler.on_progress(100);
                        }
                    }

                    public void onFailed(int i, String str) {
                        cki.O00000o0("MIStream", "MISS_CMD_VIDEO_START failed:".concat(String.valueOf(i)));
                        MIStream mIStream = MIStream.this;
                        mIStream.isVideoEnabled = false;
                        mIStream.runInUIThread(new Runnable(i, str) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$3$RkPBGkyX5tG9PJAm_dS5MABDOzo */
                            private final /* synthetic */ int f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                MIStream.AnonymousClass3.this.lambda$onFailed$1$MIStream$3(this.f$1, this.f$2);
                            }
                        });
                    }

                    public /* synthetic */ void lambda$onFailed$1$MIStream$3(int i, String str) {
                        if (MIStream.this.streamHandler != null) {
                            MIStream.this.streamHandler.on_error(i, str);
                        }
                    }
                });
            } catch (JSONException e) {
                cki.O00000o0("MIStream", "JSONException error:" + e.getLocalizedMessage());
            }
        }
        IStreamHandler iStreamHandler2 = this.streamHandler;
        if (iStreamHandler2 != null && iStreamHandler2.isAutoAudio()) {
            toggleRemoteAudio(true);
        }
    }

    public /* synthetic */ void lambda$onMissOnConnect$1$MIStream() {
        this.streamHandler.on_connect(0, null);
    }

    private void onMissOnDisconnect(int i) {
        cki.O00000o0("MIStream", "onMissOnDisconnect");
        IStreamHandler iStreamHandler = this.streamHandler;
        if (iStreamHandler != null) {
            iStreamHandler.on_disconnect(0, i);
        }
        this.isSessionConnected = false;
        this.isCallStarted = false;
        this.isVideoEnabled = false;
        this.isAudioEnabled = false;
    }

    private void onMissOnError(int i) {
        cki.O00000o0("MIStream", "onMissOnError:".concat(String.valueOf(i)));
        cki.O0000OOo("2000.1.4", "miss:".concat(String.valueOf(i)));
        this.isSessionConnected = false;
        this.isCallStarted = false;
        this.isVideoEnabled = false;
        this.isAudioEnabled = false;
        if (this.streamHandler != null) {
            runInUIThread(new Runnable(i) {
                /* class com.xiaomi.mistream.$$Lambda$MIStream$HHeYscbl_RzzfX1b3ElIeSQU_FI */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MIStream.this.lambda$onMissOnError$2$MIStream(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onMissOnError$2$MIStream(int i) {
        this.streamHandler.on_error(i, null);
    }

    private void onMissOnAudioData(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, long j, int i5) {
        if (bArr != null && bArr.length > 0 && this.streamHandler != null) {
            byte[] bArr3 = new byte[28];
            if (i2 == 1027) {
                bArr3[0] = -118;
            } else if (i2 == 137) {
                bArr3[0] = -119;
            } else if (i2 == 1030) {
                bArr3[0] = -120;
            }
            System.arraycopy(Packet.intToByteArray(i3, false), 0, bArr3, 4, 4);
            System.arraycopy(Packet.intToByteArray((int) j, false), 0, bArr3, 12, 4);
            System.arraycopy(Packet.intToByteArray(i5, false), 0, bArr3, 20, 4);
            System.arraycopy(Packet.intToByteArray(Packet.byteToInt(i4, 4, 3), false), 0, bArr3, 8, 4);
            System.arraycopy(Packet.shortToByteArray((short) Packet.byteToInt(i4, 2, 7), false), 0, bArr3, 16, 2);
            System.arraycopy(Packet.shortToByteArray((short) Packet.byteToInt(i4, 2, 9), false), 0, bArr3, 18, 2);
            byte b = 1;
            if (((i4 >> 11) & 1) != 1) {
                b = 0;
            }
            bArr3[25] = b;
            this.streamHandler.receive_audio_data(bArr, bArr3);
        }
    }

    private void onMissOnVideoData(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, long j, int i5, int i6) {
        byte[] bArr3 = bArr;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        long j2 = j;
        int i10 = i5;
        int i11 = i6;
        Object[] objArr = new Object[6];
        byte b = 0;
        objArr[0] = this.did;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(bArr3 != null ? bArr3.length : 0);
        objArr[4] = Integer.valueOf(i4);
        objArr[5] = Long.valueOf(j);
        cki.O000000o("MIStream", "onMissOnVideoData: did:%s,codecId:%d,sequence:%d, length:%d, flag:%d, timeStamp:%d", objArr);
        if (bArr3 != null) {
            try {
                if (bArr3.length > 0 && this.streamHandler != null) {
                    if (i7 < 1024) {
                        byte[] bArr4 = new byte[28];
                        if (i7 == 4) {
                            bArr4[0] = 78;
                        } else if (i7 == 5) {
                            bArr4[0] = 80;
                        }
                        int i12 = i9 & 3;
                        if (i12 == 0) {
                            bArr4[2] = 0;
                        } else if (i12 == 1) {
                            bArr4[2] = 1;
                        }
                        System.arraycopy(Packet.intToByteArray(i8, false), 0, bArr4, 4, 4);
                        if (!(this.lastVideoSequence == 0 || this.lastVideoSequence == i8 - 1)) {
                            cki.O00000Oo("MIStream", "onMissOnVideoData: did:%s video sequence wrong last:%d,this:%d", this.did, Integer.valueOf(this.lastVideoSequence), Integer.valueOf(i3));
                        }
                        this.lastVideoSequence = i8;
                        byte b2 = ((i9 >> 11) & 1) == 1 ? (byte) 1 : 0;
                        if (((i9 >> 13) & 1) == 1) {
                            b2 = (byte) (b2 | 2);
                        }
                        bArr4[16] = b2;
                        int i13 = (i9 >> 17) & 15;
                        if (i13 != 15) {
                            switch (i13) {
                                case 1:
                                    System.arraycopy(Packet.shortToByteArray(1920, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1080, false), 0, bArr4, 10, 2);
                                    break;
                                case 2:
                                    System.arraycopy(Packet.shortToByteArray(1280, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(720, false), 0, bArr4, 10, 2);
                                    break;
                                case 3:
                                    System.arraycopy(Packet.shortToByteArray(640, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(360, false), 0, bArr4, 10, 2);
                                    break;
                                case 4:
                                    System.arraycopy(Packet.shortToByteArray(2304, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1296, false), 0, bArr4, 10, 2);
                                    break;
                                case 5:
                                    System.arraycopy(Packet.shortToByteArray(864, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(480, false), 0, bArr4, 10, 2);
                                    break;
                                case 6:
                                    System.arraycopy(Packet.shortToByteArray(1080, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1920, false), 0, bArr4, 10, 2);
                                    break;
                                case 7:
                                    System.arraycopy(Packet.shortToByteArray(2560, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1440, false), 0, bArr4, 10, 2);
                                    break;
                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                    System.arraycopy(Packet.shortToByteArray(720, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1280, false), 0, bArr4, 10, 2);
                                    break;
                                case 9:
                                    System.arraycopy(Packet.shortToByteArray(1088, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1080, false), 0, bArr4, 10, 2);
                                    break;
                                case 10:
                                    System.arraycopy(Packet.shortToByteArray(1536, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(1536, false), 0, bArr4, 10, 2);
                                    break;
                                case 11:
                                    System.arraycopy(Packet.shortToByteArray(480, false), 0, bArr4, 8, 2);
                                    System.arraycopy(Packet.shortToByteArray(480, false), 0, bArr4, 10, 2);
                                    break;
                            }
                        } else {
                            short byteArrayToShort = Packet.byteArrayToShort(Packet.intToByteArray(i11, false), 0, false);
                            short byteArrayToShort2 = Packet.byteArrayToShort(Packet.intToByteArray(i11, false), 2, false);
                            System.arraycopy(Packet.shortToByteArray(byteArrayToShort, false), 0, bArr4, 8, 2);
                            System.arraycopy(Packet.shortToByteArray(byteArrayToShort2, false), 0, bArr4, 10, 2);
                        }
                        System.arraycopy(Packet.intToByteArray((int) j2, false), 0, bArr4, 12, 4);
                        System.arraycopy(Packet.intToByteArray(i10, false), 0, bArr4, 20, 4);
                        this.streamHandler.receive_video_data(bArr3, bArr4);
                        return;
                    }
                    byte[] bArr5 = new byte[28];
                    if (i7 == 1027) {
                        bArr5[0] = -118;
                    } else if (i7 == 1030) {
                        bArr5[0] = -120;
                    }
                    System.arraycopy(Packet.intToByteArray(i8, false), 0, bArr5, 4, 4);
                    System.arraycopy(Packet.intToByteArray((int) j2, false), 0, bArr5, 12, 4);
                    System.arraycopy(Packet.intToByteArray(i10, false), 0, bArr5, 20, 4);
                    System.arraycopy(Packet.intToByteArray(Packet.byteToInt(i9, 4, 3), false), 0, bArr5, 8, 4);
                    System.arraycopy(Packet.shortToByteArray((short) Packet.byteToInt(i9, 2, 7), false), 0, bArr5, 16, 2);
                    System.arraycopy(Packet.shortToByteArray((short) Packet.byteToInt(i9, 2, 9), false), 0, bArr5, 18, 2);
                    if (((i9 >> 11) & 1) == 1) {
                        b = 1;
                    }
                    bArr5[25] = b;
                    this.streamHandler.receive_audio_data(bArr3, bArr5);
                }
            } catch (Exception e) {
                cki.O00000o0("MIStream", "onMissOnVideoData Exception:" + e.getLocalizedMessage());
            }
        }
    }

    private void onMissOnRdtData(byte[] bArr) {
        IStreamHandler iStreamHandler = this.streamHandler;
        if (iStreamHandler != null && bArr != null && bArr.length > 0) {
            iStreamHandler.receive_rdt_data(bArr);
        }
    }

    private void onMissOnCmd(int i, byte[] bArr, byte[] bArr2) {
        runInUIThread(new Runnable(bArr, i) {
            /* class com.xiaomi.mistream.$$Lambda$MIStream$aToMwm_TQw_H9nvett5lbKachE */
            private final /* synthetic */ byte[] f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                MIStream.this.lambda$onMissOnCmd$3$MIStream(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onMissOnCmd$3$MIStream(byte[] bArr, int i) {
        IStreamHandler iStreamHandler = this.streamHandler;
        if (!(iStreamHandler == null || bArr == null || bArr.length <= 0)) {
            iStreamHandler.on_command(i, bArr);
        }
        StringBuilder sb = new StringBuilder("onMissOnCmd:");
        sb.append(i);
        sb.append(" data:");
        sb.append(bArr != null ? new String(bArr) : "");
        cki.O00000o0("MIStream", sb.toString());
    }

    private int onMissOnServerReady() {
        cki.O00000o0("MIStream", "onMissOnServerReady");
        return 0;
    }

    public String getTutkVersion() {
        int[] iArr = new int[1];
        IOTCAPIs.IOTC_Get_Version(iArr);
        int i = iArr[0];
        return String.format("%d.%d.%d.%d", Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf(i & 255));
    }

    public void connectWithMiss(String str, String str2, MissNetworkType missNetworkType, IStreamCallback<String> iStreamCallback) {
        connectWithMissConfig(str, str2, missNetworkType, iStreamCallback, null);
    }

    public void connectWithMissConfig(String str, String str2, MissNetworkType missNetworkType, IStreamCallback<String> iStreamCallback, MissConfig missConfig) {
        this.networkType = missNetworkType.getValue();
        this.model = str;
        this.did = str2;
        this.mWorkerHandler.removeCallbacksAndMessages(null);
        cki.O00000o0("MIStream", "connectWithMissConfig:" + str + " did:" + str2);
        this.mWorkerHandler.post(new Runnable(str2, str, missConfig, iStreamCallback) {
            /* class com.xiaomi.mistream.$$Lambda$MIStream$gSoi8cPX1qgugYyVnC6QPlvu1Uo */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ MissConfig f$3;
            private final /* synthetic */ IStreamCallback f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                MIStream.this.lambda$connectWithMissConfig$4$MIStream(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
    }

    public /* synthetic */ void lambda$connectWithMissConfig$4$MIStream(String str, String str2, MissConfig missConfig, IStreamCallback iStreamCallback) {
        int i;
        IStreamCallback iStreamCallback2 = iStreamCallback;
        synchronized (sLockObj) {
            this.isSessionInit = true;
            String string = ckh.O000000o().getSharedPreferences("miss_uuid_s", 4).getString("miss_uuid", null);
            if (!TextUtils.isEmpty(string)) {
                cki.O00000o0("MIStream", "uuid:".concat(String.valueOf(string)));
                missStatisticsSet(3, string);
            }
            if (P2PUtils.sInit) {
                i = missClientSessionOpen(str, str2, "android_app", this.networkType, true, missConfig);
            } else {
                i = missClientSessionOpen(str, str2, "android_app", this.networkType, false, missConfig);
            }
            cki.O00000o0("MIStream", "sInit:" + P2PUtils.sInit + " did:" + str + " model:" + str2 + " networkType:" + this.networkType + " ret:" + i);
            P2PUtils.sInit = true;
            if (iStreamCallback2 != null) {
                if (i == 0) {
                    iStreamCallback2.onSuccess(String.valueOf(i), null);
                } else {
                    cki.O00000o0("MIStream", "connectWithMiss failed:".concat(String.valueOf(i)));
                    iStreamCallback2.onFailed(i, "failed");
                }
            }
        }
    }

    public void disconnectWithMiss() {
        cki.O00000o0("MIStream", "disconnectWithMiss:" + this.did);
        this.isVideoEnabled = false;
        this.isSessionConnected = false;
        this.isSessionInit = false;
        this.mWorkerHandler.removeCallbacksAndMessages(null);
        this.mWorkerHandler.post(new Runnable() {
            /* class com.xiaomi.mistream.$$Lambda$MIStream$1D5BYdO3uEUnCEfKikQtxIFWPPw */

            public final void run() {
                MIStream.this.lambda$disconnectWithMiss$5$MIStream();
            }
        });
    }

    public /* synthetic */ void lambda$disconnectWithMiss$5$MIStream() {
        int missClientSessionClose;
        synchronized (sLockObj) {
            if (!TextUtils.isEmpty(this.did) && (missClientSessionClose = missClientSessionClose(this.did)) != 0) {
                cki.O00000o0("MIStream", "disconnectWithMiss failed:".concat(String.valueOf(missClientSessionClose)));
            }
        }
    }

    public void finishMiss() {
        this.isSessionConnected = false;
        P2PUtils.sInit = false;
        this.mWorkerHandler.post($$Lambda$MIStream$z6WFNgoKlkcAoSfPtoPJwFJwe88.INSTANCE);
    }

    static /* synthetic */ void lambda$finishMiss$6() {
        synchronized (sLockObj) {
        }
    }

    public void missCommandSend(int i, String str, IStreamCallback<Integer> iStreamCallback) {
        cki.O00000o("MIStream", "missCommandSend command:" + i + " params:" + str);
        if (this.isSessionInit) {
            if (i == 258) {
                XmStreamClient.sCameraDevices.get(this.model + "_" + this.did);
            }
            this.mWorkerHandler.post(new Runnable(i, str, iStreamCallback) {
                /* class com.xiaomi.mistream.$$Lambda$MIStream$WeqeYHCPlsOpmHWwDBDUGP4j3zY */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ IStreamCallback f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    MIStream.this.lambda$missCommandSend$7$MIStream(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    public /* synthetic */ void lambda$missCommandSend$7$MIStream(int i, String str, IStreamCallback iStreamCallback) {
        synchronized (sLockObj) {
            int missCmdSend = missCmdSend(i, str, this.did);
            if (iStreamCallback != null) {
                if (missCmdSend == 0) {
                    iStreamCallback.onSuccess(Integer.valueOf(missCmdSend), null);
                } else {
                    cki.O00000o0("MIStream", "missCommandSend failed command:" + i + " params:" + str);
                    iStreamCallback.onFailed(missCmdSend, "failed with error(s)");
                }
            }
        }
    }

    public void connect(String str, String str2, MissNetworkType missNetworkType, IStreamCallback<String> iStreamCallback) {
        connectWithMiss(str, str2, missNetworkType, iStreamCallback);
    }

    public void connect(String str, String str2, MissNetworkType missNetworkType, IStreamCallback<String> iStreamCallback, MissConfig missConfig) {
        connectWithMissConfig(str, str2, missNetworkType, iStreamCallback, missConfig);
    }

    public void disConnect(String str, String str2, IStreamCallback<String> iStreamCallback) {
        missCommandSend(259, "", null);
        missCommandSend(261, "", null);
        disconnectWithMiss();
    }

    public void speakerStart(String str, String str2, final IMISSListener iMISSListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("speakerStart", 1);
            missCommandSend(262, jSONObject.toString(), new IStreamCallback<Integer>() {
                /* class com.xiaomi.mistream.MIStream.AnonymousClass4 */

                public void onProgress(int i) {
                }

                public void onSuccess(Integer num, Object obj) {
                    MIStream mIStream = MIStream.this;
                    mIStream.isCallStarted = true;
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        mIStream.runInUIThread(new Runnable(num, obj) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$4$f59X0UiMp3fwdARp4LqC4NKtb4 */
                            private final /* synthetic */ Integer f$1;
                            private final /* synthetic */ Object f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                            }
                        });
                    }
                }

                public void onFailed(int i, String str) {
                    MIStream.this.isCallStarted = false;
                    cki.O00000o0("MIStream", "miss speakerStart failed:".concat(String.valueOf(i)));
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(i, str) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$4$tnalQyZBT7A1mNwRVs9EyRcXgoo */
                            private final /* synthetic */ int f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onFailed(this.f$1, this.f$2);
                            }
                        });
                    }
                }
            });
        } catch (JSONException unused) {
            this.isCallStarted = false;
        }
    }

    public void speakerStop(String str, String str2, final IMISSListener iMISSListener) {
        JSONObject jSONObject = new JSONObject();
        this.isCallStarted = false;
        try {
            jSONObject.put("speakerStop", 1);
            missCommandSend(264, jSONObject.toString(), new IStreamCallback<Integer>() {
                /* class com.xiaomi.mistream.MIStream.AnonymousClass5 */

                public void onProgress(int i) {
                }

                public void onSuccess(Integer num, Object obj) {
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(num, obj) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$5$sq2VcGdOLproWQZ1t9X7_l1yYkA */
                            private final /* synthetic */ Integer f$1;
                            private final /* synthetic */ Object f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                            }
                        });
                    }
                }

                public void onFailed(int i, String str) {
                    cki.O00000o0("MIStream", "miss speakerStop failed:".concat(String.valueOf(i)));
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(i, str) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$5$eqe8vOCWvB1QAkZgvm5mZTxg5I */
                            private final /* synthetic */ int f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onFailed(this.f$1, this.f$2);
                            }
                        });
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    public void getDeviceInfo(final IMISSListener iMISSListener) {
        missCommandSend(272, null, new IStreamCallback<Integer>() {
            /* class com.xiaomi.mistream.MIStream.AnonymousClass6 */

            public void onProgress(int i) {
            }

            public void onSuccess(Integer num, Object obj) {
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(num, obj) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$6$iho2ADsCvzoeAitchhVOOel6arw */
                        private final /* synthetic */ Integer f$1;
                        private final /* synthetic */ Object f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                        }
                    });
                }
            }

            public void onFailed(int i, String str) {
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(i, str) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$6$CVjfA0cWcf0reoqczNh59a09ZNc */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onFailed(this.f$1, this.f$2);
                        }
                    });
                }
            }
        });
    }

    public void setResolution(String str, String str2, int i, final IMISSListener iMISSListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("videoquality", i);
            missCommandSend(265, jSONObject.toString(), new IStreamCallback<Integer>() {
                /* class com.xiaomi.mistream.MIStream.AnonymousClass7 */

                public void onProgress(int i) {
                }

                public void onSuccess(Integer num, Object obj) {
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(num, obj) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$7$BOgk3UyaPsPnCSsB4iMTQtZAc8 */
                            private final /* synthetic */ Integer f$1;
                            private final /* synthetic */ Object f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                            }
                        });
                    }
                }

                public void onFailed(int i, String str) {
                    cki.O00000o0("MIStream", "setResolution failed:" + i + " errorInfo:" + str);
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(i, str) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$7$s7NJmV2mMXs2CrvrujKOnN1U */
                            private final /* synthetic */ int f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onFailed(this.f$1, this.f$2);
                            }
                        });
                    }
                }
            });
        } catch (JSONException e) {
            cki.O00000o0("MIStream", "JSONException:" + e.getLocalizedMessage());
        }
    }

    public void setDirection(String str, String str2, int i, final IMISSListener iMISSListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", i);
            missCommandSend(274, jSONObject.toString(), new IStreamCallback<Integer>() {
                /* class com.xiaomi.mistream.MIStream.AnonymousClass8 */

                public void onProgress(int i) {
                }

                public void onSuccess(Integer num, Object obj) {
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(num, obj) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$8$VCSLjQw5ntS9Yvx04nOOZUvUmc */
                            private final /* synthetic */ Integer f$1;
                            private final /* synthetic */ Object f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                            }
                        });
                    }
                }

                public void onFailed(int i, String str) {
                    cki.O00000o0("MIStream", "setDirection failed:" + i + " errorInfo:" + str);
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        MIStream.this.runInUIThread(new Runnable(i, str) {
                            /* class com.xiaomi.mistream.$$Lambda$MIStream$8$5F6og3bM__xeXh6RTzGF4PEr1M */
                            private final /* synthetic */ int f$1;
                            private final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IMISSListener.this.onFailed(this.f$1, this.f$2);
                            }
                        });
                    }
                }
            });
        } catch (JSONException e) {
            cki.O00000o0("MIStream", "setDirection JSONException:" + e.getLocalizedMessage());
        }
    }

    public void audioStart(String str, String str2, final IMISSListener iMISSListener) {
        this.isAudioEnabled = true;
        missCommandSend(260, "", new IStreamCallback<Integer>() {
            /* class com.xiaomi.mistream.MIStream.AnonymousClass9 */

            public void onProgress(int i) {
            }

            public void onSuccess(Integer num, Object obj) {
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(num, obj) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$9$gsXUWB_QnnGjFafhzRM1MxVhARw */
                        private final /* synthetic */ Integer f$1;
                        private final /* synthetic */ Object f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                        }
                    });
                }
            }

            public void onFailed(int i, String str) {
                cki.O00000o0("MIStream", "audioStart failed:" + i + " errorInfo:" + str);
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(i, str) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$9$mAApvUuRANX1Nz4B5enKVd0TmA4 */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onFailed(this.f$1, this.f$2);
                        }
                    });
                }
            }
        });
    }

    public void audioStop(String str, String str2, final IMISSListener iMISSListener) {
        this.isAudioEnabled = false;
        missCommandSend(261, "", new IStreamCallback<Integer>() {
            /* class com.xiaomi.mistream.MIStream.AnonymousClass10 */

            public void onProgress(int i) {
            }

            public void onSuccess(Integer num, Object obj) {
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(num, obj) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$10$vhtPOF6KwW8Hz0XW0lukJQ4HE */
                        private final /* synthetic */ Integer f$1;
                        private final /* synthetic */ Object f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                        }
                    });
                }
            }

            public void onFailed(int i, String str) {
                cki.O00000o0("MIStream", "audioStop failed:" + i + " errorInfo:" + str);
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(i, str) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$10$X2pUo665zLvezr2609iAyA31ZbM */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onFailed(this.f$1, this.f$2);
                        }
                    });
                }
            }
        });
    }

    public void avChannelSendAudio(byte[] bArr, int i) {
        if (this.isSessionInit && this.isSessionConnected && this.isCallStarted && bArr != null && bArr.length > 0 && !TextUtils.isEmpty(this.did)) {
            if (this.mAudioSenderThread == null) {
                synchronized (this) {
                    if (this.mAudioSenderThread == null) {
                        this.mAudioSenderThread = new HandlerThread("MIStream Audio Sender");
                        this.mAudioSenderThread.start();
                        this.mAudioSenderHandler = new Handler(this.mAudioSenderThread.getLooper());
                    }
                }
            }
            this.mAudioSenderHandler.post(new Runnable(i, bArr) {
                /* class com.xiaomi.mistream.$$Lambda$MIStream$W1Xu7INR6r9SNvzRzy9Nvmk_Ic */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ byte[] f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    MIStream.this.lambda$avChannelSendAudio$8$MIStream(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$avChannelSendAudio$8$MIStream(int i, byte[] bArr) {
        synchronized (sLockObj) {
            int i2 = i == 136 ? 1030 : 1027;
            try {
                if (this.audioRawDataSaveHelper != null) {
                    this.audioRawDataSaveHelper.write(bArr);
                }
                int missSendAudioData = missSendAudioData(bArr, bArr.length, 0, i2, System.currentTimeMillis(), this.did);
                if (missSendAudioData != 0) {
                    cki.O00000o0("MIStream", "missSendAudioData failed:".concat(String.valueOf(missSendAudioData)));
                    cki.O0000OOo("2000.2.3", "missSendAudioData failed:".concat(String.valueOf(missSendAudioData)));
                }
            } catch (Exception e) {
                cki.O00000o0("MIStream", "avChannelSendAudio Exception:" + e.getLocalizedMessage());
                cki.O0000OOo("2000.2.3", "avChannelSendAudio Exception:" + e.getLocalizedMessage());
            }
        }
    }

    public int avChannelSendRDTData(byte[] bArr) {
        if (!this.isSessionInit || !this.isSessionConnected || bArr == null || bArr.length <= 0 || TextUtils.isEmpty(this.did)) {
            return 0;
        }
        this.mWorkerHandler.post(new Runnable(bArr) {
            /* class com.xiaomi.mistream.$$Lambda$MIStream$n8D9QrRKsbIXIdnfBCTqjGlGEzA */
            private final /* synthetic */ byte[] f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MIStream.this.lambda$avChannelSendRDTData$9$MIStream(this.f$1);
            }
        });
        return 0;
    }

    public /* synthetic */ void lambda$avChannelSendRDTData$9$MIStream(byte[] bArr) {
        synchronized (sLockObj) {
            int missRdtSend = missRdtSend(bArr, bArr.length, this.did);
            if (missRdtSend != 0) {
                cki.O00000o0("MIStream", "avChannelSendRDTData failed:".concat(String.valueOf(missRdtSend)));
            }
        }
    }

    public void avChannelSendRDTData(byte[] bArr, IMISSListener iMISSListener) {
        if (this.isSessionInit && this.isSessionConnected && bArr != null && bArr.length > 0 && !TextUtils.isEmpty(this.did)) {
            this.mWorkerHandler.post(new Runnable(bArr, iMISSListener) {
                /* class com.xiaomi.mistream.$$Lambda$MIStream$hRhxySqTEFcedB7lbZoXRpg3Y */
                private final /* synthetic */ byte[] f$1;
                private final /* synthetic */ IMISSListener f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    MIStream.this.lambda$avChannelSendRDTData$10$MIStream(this.f$1, this.f$2);
                }
            });
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1010, "avChannelSendRDTData params invalid");
        }
    }

    public /* synthetic */ void lambda$avChannelSendRDTData$10$MIStream(byte[] bArr, IMISSListener iMISSListener) {
        synchronized (sLockObj) {
            int missRdtSend = missRdtSend(bArr, bArr.length, this.did);
            if (iMISSListener != null) {
                if (missRdtSend == 0) {
                    iMISSListener.onSuccess("0", null);
                } else {
                    cki.O00000o0("MIStream", "avChannelSendRDTData failed:".concat(String.valueOf(missRdtSend)));
                    iMISSListener.onFailed(missRdtSend, null);
                }
            }
        }
    }

    public void avPlaybackSpeed(String str, String str2, String str3, final IMISSListener iMISSListener) {
        missCommandSend(271, str3, new IStreamCallback<Integer>() {
            /* class com.xiaomi.mistream.MIStream.AnonymousClass11 */

            public void onProgress(int i) {
            }

            public void onSuccess(Integer num, Object obj) {
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(num, obj) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$11$nRq2iK9le_PAkrbTAgsWNXYYmHk */
                        private final /* synthetic */ Integer f$1;
                        private final /* synthetic */ Object f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                        }
                    });
                }
            }

            public void onFailed(int i, String str) {
                cki.O00000o0("MIStream", "avPlaybackSpeed failed:" + i + " errorInfo:" + str);
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(i, str) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$11$ssm_yvcz1R4yqtlMN98nN391qLY */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onFailed(this.f$1, this.f$2);
                        }
                    });
                }
            }
        });
    }

    public void avPlayback(String str, String str2, String str3, final IMISSListener iMISSListener) {
        missCommandSend(269, str3, new IStreamCallback<Integer>() {
            /* class com.xiaomi.mistream.MIStream.AnonymousClass12 */

            public void onProgress(int i) {
            }

            public void onSuccess(Integer num, Object obj) {
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(num, obj) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$12$DaiGLQKOl78j7Z84KQ0v_DLMQs0 */
                        private final /* synthetic */ Integer f$1;
                        private final /* synthetic */ Object f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onSuccess(String.valueOf(this.f$1), this.f$2);
                        }
                    });
                }
            }

            public void onFailed(int i, String str) {
                cki.O00000o0("MIStream", "avPlayback failed:" + i + " errorInfo:" + str);
                IMISSListener iMISSListener = iMISSListener;
                if (iMISSListener != null) {
                    MIStream.this.runInUIThread(new Runnable(i, str) {
                        /* class com.xiaomi.mistream.$$Lambda$MIStream$12$GYIa_DUiT9v1cPiQqeksMLDy6KI */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            IMISSListener.this.onFailed(this.f$1, this.f$2);
                        }
                    });
                }
            }
        });
    }

    public int toggleRemoteVideo(boolean z) {
        cki.O00000o0("MIStream", "toggleRemoteVideo:".concat(String.valueOf(z)));
        String str = "";
        if (z) {
            JSONObject startExtra = DeviceModelManager.getStartExtra(this.model, this.did);
            if (startExtra != null) {
                str = startExtra.toString();
            }
            missCommandSend(258, str, null);
            return 0;
        }
        missCommandSend(259, str, null);
        return 0;
    }

    public int toggleRemoteAudio(boolean z) {
        cki.O00000o0("MIStream", "toggleRemoteAudio:".concat(String.valueOf(z)));
        if (z) {
            missCommandSend(260, "", null);
            return 0;
        }
        missCommandSend(261, "", null);
        return 0;
    }

    public void runInUIThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void markCallStart(boolean z) {
        this.isCallStarted = z;
        if (!ckh.O0000O0o) {
            return;
        }
        if (this.isCallStarted) {
            if (this.audioRawDataSaveHelper == null) {
                this.audioRawDataSaveHelper = new AudioRawDataSaveHelper();
            }
            this.audioRawDataSaveHelper.init("g711");
            return;
        }
        AudioRawDataSaveHelper audioRawDataSaveHelper2 = this.audioRawDataSaveHelper;
        if (audioRawDataSaveHelper2 != null) {
            audioRawDataSaveHelper2.close();
            this.audioRawDataSaveHelper = null;
        }
    }
}
