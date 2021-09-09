package com.xiaomi.mistream;

import _m_j.ckh;
import _m_j.cki;
import _m_j.goe;
import _m_j.goq;
import _m_j.wd;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tutk.IOTC.Packet;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.ICameraPlayerListener;
import com.xiaomi.smarthome.camera.IClientExListener;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IRDTCameraPositionListener;
import com.xiaomi.smarthome.camera.IRDTListener;
import com.xiaomi.smarthome.camera.IRDTPanoramaListener;
import com.xiaomi.smarthome.camera.IRDTPictureListener;
import com.xiaomi.smarthome.camera.IRDTTimelineEventListener;
import com.xiaomi.smarthome.camera.IRDTTimelineListener;
import com.xiaomi.smarthome.camera.IRdtDataListener;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.IXmStreamClient;
import com.xiaomi.smarthome.camera.MissConfig;
import com.xiaomi.smarthome.camera.MissNetworkType;
import com.xiaomi.smarthome.camera.P2pResponse;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmStreamClient implements IXmConnectionClient, IXmStreamClient {
    static ConcurrentHashMap<String, XmStreamClient> sCacheCameraClientMap = new ConcurrentHashMap<>();
    public static LinkedHashMap<String, String> sCameraDevices = new LinkedHashMap<>(0, 0.75f, true);
    public static ConcurrentHashMap<String, String> sDelayedDisconnectDevices = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, String> sExceptionDevices = new ConcurrentHashMap<>();
    private int ThreadIndex;
    public DeviceStat deviceStat;
    private final String fullDid;
    private boolean isAllRdtDataReceived;
    public boolean isAutoAudio;
    public boolean isAutoVideo;
    volatile boolean isBigOrder;
    IClientExListener mClientListener;
    volatile int mClientStatus;
    public volatile int mConnectionSource;
    long mFirstConnect;
    volatile boolean mIsPaused;
    volatile boolean mIsStartSpeaking;
    public long mPreConnectStartTime;
    public long mPreConnectTime;
    public long mPreVideoCommandStartTime;
    public long mPreVideoReceivedTime;
    int mPwdTry;
    IRDTTimelineEventListener mRDTIimelineEventListener;
    IRDTListener mRDTListener;
    IRDTPanoramaListener mRDTPanoramaListener;
    IRDTPictureListener mRDTPictureListener;
    IRDTTimelineListener mRDTTimelineListener;
    ICameraPlayerListener mRNClientListener;
    IRDTCameraPositionListener mRdtCameraPositionListener;
    private IRdtDataListener mRdtDataListener;
    int mRetry;
    boolean mUsrExpPlanEnabled;
    public OnPreConnectCallBack onPreConnectCallBack;
    volatile boolean pwdChange;
    private int rdtCommand;
    private byte[] rdtCommandBuffer;
    private int rdtCommandOffset;
    private int rdtCommandSize;
    private int rdtCommandStatus;
    public volatile MIStream stream;

    public interface OnPreConnectCallBack {
        void onConnected(long j);

        void onError(int i, String str);

        void onReConnected();

        void onVideoReceived(long j);
    }

    /* access modifiers changed from: protected */
    public void doStopConnect() {
    }

    public void pauseRN(ICameraPlayerListener iCameraPlayerListener) {
    }

    public void reconnect() {
    }

    public boolean resume() {
        return false;
    }

    public void runInP2pThread(Runnable runnable) {
    }

    public void setCurrentDeviceUseFixedRdtChannel(boolean z) {
    }

    public void updateInfo(XmP2PInfo xmP2PInfo) {
    }

    public void useHualaiEncrypted(boolean z) {
    }

    public void wakeUpDevice(IXmConnectionClient.XmActionCallback xmActionCallback) {
    }

    public static synchronized void disconnectAll() {
        synchronized (XmStreamClient.class) {
            goq.O000000o($$Lambda$XmStreamClient$8glIjazxmEH6B0Gl4fCZM14NNE.INSTANCE);
        }
    }

    static /* synthetic */ void lambda$disconnectAll$0() {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, XmStreamClient> value : sCacheCameraClientMap.entrySet()) {
                XmStreamClient xmStreamClient = (XmStreamClient) value.getValue();
                String str = xmStreamClient.deviceStat.model + "_" + xmStreamClient.deviceStat.did;
                if (!sExceptionDevices.containsKey(str)) {
                    concurrentHashMap.put(str, xmStreamClient.deviceStat.did);
                }
            }
            Iterator<Map.Entry<String, String>> it = sDelayedDisconnectDevices.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!sExceptionDevices.containsKey(next.getKey())) {
                    concurrentHashMap.put(next.getKey(), next.getValue());
                    it.remove();
                }
            }
            Iterator it2 = concurrentHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                disconnectDevice(XmPluginHostApi.instance().getDeviceByDid((String) ((Map.Entry) it2.next()).getValue()));
                it2.remove();
            }
        } catch (Exception e) {
            cki.O00000oO("XmStreamClient", "disconnectAll:" + e.getLocalizedMessage());
        }
    }

    public static synchronized void disconnectDevice(DeviceStat deviceStat2) {
        synchronized (XmStreamClient.class) {
            if (deviceStat2 != null) {
                XmStreamClient instance = getInstance(deviceStat2, deviceStat2.did);
                if (instance != null) {
                    instance.streamStop(null);
                }
            }
        }
    }

    private static synchronized void releaseCache(String str) {
        synchronized (XmStreamClient.class) {
            try {
                sCacheCameraClientMap.remove(str);
            } catch (Exception e) {
                cki.O00000oO("XmStreamClient", "releaseCache:" + e.getLocalizedMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        return r2;
     */
    public static synchronized XmStreamClient getInstance(DeviceStat deviceStat2, String str) {
        XmStreamClient xmStreamClient;
        synchronized (XmStreamClient.class) {
            if (deviceStat2 != null) {
                if (!TextUtils.isEmpty(deviceStat2.model)) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = deviceStat2.model + "_" + str + "_" + str;
                        cki.O00000o("XmStreamClient", "mapKey:".concat(String.valueOf(str2)));
                        XmStreamClient xmStreamClient2 = sCacheCameraClientMap.get(str2);
                        if (xmStreamClient2 == null) {
                            synchronized (XmStreamClient.class) {
                                xmStreamClient = new XmStreamClient(deviceStat2, str);
                                sCacheCameraClientMap.put(str2, xmStreamClient);
                                wd.O000000o(deviceStat2.model);
                            }
                            xmStreamClient2 = xmStreamClient;
                        } else {
                            xmStreamClient2.updateInfo();
                        }
                    }
                }
            }
            return null;
        }
    }

    private XmStreamClient(DeviceStat deviceStat2, String str) {
        this.ThreadIndex = 1;
        this.mClientStatus = -1;
        this.mIsPaused = false;
        this.pwdChange = false;
        this.isBigOrder = false;
        this.mIsStartSpeaking = false;
        this.mFirstConnect = 0;
        this.mUsrExpPlanEnabled = false;
        this.mRetry = 0;
        this.mPreConnectStartTime = -1;
        this.mPreConnectTime = -1;
        this.mPreVideoCommandStartTime = -1;
        this.mPreVideoReceivedTime = -1;
        this.mConnectionSource = 1;
        this.mPwdTry = 3;
        this.rdtCommand = 0;
        this.rdtCommandSize = 0;
        this.rdtCommandStatus = 0;
        this.rdtCommandOffset = 0;
        this.isAllRdtDataReceived = false;
        this.isAutoVideo = true;
        this.isAutoAudio = false;
        this.mPwdTry = 3;
        this.deviceStat = deviceStat2;
        this.fullDid = str;
    }

    public void runInUIThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void updateInfo() {
        if (this.deviceStat != null) {
            cki.O00000o("XmStreamClient", "updateInfo:" + this.deviceStat.model + this.fullDid);
            this.pwdChange = true;
            this.mPwdTry = 3;
        }
    }

    public void setClientListener(IClientExListener iClientExListener) {
        this.mClientListener = iClientExListener;
    }

    /* access modifiers changed from: protected */
    public void doSendAudioData(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder("type:");
        sb.append(i);
        sb.append(" data length:");
        sb.append(bArr != null ? Integer.valueOf(bArr.length) : "");
        cki.O00000o("XmStreamClient", sb.toString());
        if (bArr != null && bArr.length != 0 && this.stream != null && this.stream.isCallStarted) {
            this.stream.avChannelSendAudio(bArr, i);
        }
    }

    private byte[] getTLVData(int i, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        byte[] bArr2 = new byte[(length + 8)];
        putIntData(bArr2, 0, i);
        putIntData(bArr2, 4, length);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        }
        return bArr2;
    }

    private void putIntData(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i + 2] = (byte) (i2 >>> 16);
        bArr[i + 3] = (byte) (i2 >>> 24);
    }

    public synchronized boolean isConnected() {
        return this.mClientStatus >= 2;
    }

    public void sendRdtCmd(final byte[] bArr, final IXmConnectionClient.XmActionCallback xmActionCallback) {
        try {
            cki.O00000o0("XmStreamClient", "sendRdtCmd data.length=" + bArr.length + " model=" + this.deviceStat.model);
        } catch (Exception e) {
            cki.O00000oO("XmStreamClient", e.toString());
        }
        sendRdtCmd(bArr, new IMISSListener() {
            /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass1 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
                try {
                    cki.O00000o0("XmStreamClient", "sendRdtCmd data.length=" + bArr.length + " result=" + str + " extra=" + obj + " model=" + XmStreamClient.this.deviceStat.model);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                IXmConnectionClient.XmActionCallback xmActionCallback = xmActionCallback;
                if (xmActionCallback != null) {
                    xmActionCallback.onSuccess("1", null);
                }
            }

            public void onFailed(int i, String str) {
                try {
                    cki.O00000o0("XmStreamClient", "sendRdtCmd data.length=" + bArr.length + " errorCode=" + i + " errorInfo=" + str + " model=" + XmStreamClient.this.deviceStat.model);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                IXmConnectionClient.XmActionCallback xmActionCallback = xmActionCallback;
                if (xmActionCallback != null) {
                    xmActionCallback.onFailed(i, str);
                }
            }
        });
    }

    public void sendP2pCmd(final int i, String str, final IXmConnectionClient.XmActionCallback xmActionCallback) {
        if (this.mConnectionSource == 2 && i == 258) {
            this.mPreVideoCommandStartTime = System.currentTimeMillis();
            cki.O00000o("XmStreamClient", "mPreVideoCommandStartTime:" + this.mPreVideoCommandStartTime);
        }
        try {
            cki.O00000o0("XmStreamClient", "sendP2pCmd type=" + i + " data=" + str + " model=" + this.deviceStat.model);
        } catch (Exception e) {
            cki.O00000oO("XmStreamClient", e.toString());
        }
        streamCmdMessage(i, str, new IMISSListener() {
            /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass2 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
                try {
                    cki.O00000o0("XmStreamClient", "sendP2pCmd onSuccess=" + str + " model=" + XmStreamClient.this.deviceStat.model);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                IXmConnectionClient.XmActionCallback xmActionCallback = xmActionCallback;
                if (xmActionCallback != null) {
                    xmActionCallback.onSuccess(str, null);
                }
            }

            public void onFailed(int i, String str) {
                try {
                    cki.O00000o0("XmStreamClient", "sendP2pCmd onFailed=" + i + " errorInfo=" + str + " model=" + XmStreamClient.this.deviceStat.model);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                IXmConnectionClient.XmActionCallback xmActionCallback = xmActionCallback;
                if (xmActionCallback != null) {
                    xmActionCallback.onFailed(i, str);
                }
                cki.O0000OOo("2000.1.3", "miss:" + i + ":" + i + ":" + str);
            }
        });
    }

    public void sendP2pCmd(int i, byte[] bArr, IXmConnectionClient.XmActionCallback xmActionCallback) {
        xmActionCallback.onFailed(-1, "miss firmware in android not support send byte array param");
    }

    public void setCallStatus(boolean z) {
        markCallStarted(z);
    }

    public void sendRdtCmd(byte[] bArr, boolean z, IXmConnectionClient.XmActionCallback xmActionCallback) {
        sendRdtCmd(bArr, xmActionCallback);
    }

    public boolean isConnecting() {
        return this.mClientStatus > 0;
    }

    public void release(IClientExListener iClientExListener) {
        streamStop(null);
        this.mClientListener = null;
        cki.O00000o("XmStreamClient", "release and rest listener");
        this.mClientStatus = 0;
        cki.O00000o("XmStreamClient", "release " + toString());
    }

    public void streamStart(IMISSListener iMISSListener) {
        streamStart(getNetworkType(), null, iMISSListener);
    }

    public void streamStart(MissConfig missConfig, IMISSListener iMISSListener) {
        streamStart(getNetworkType(), missConfig, iMISSListener);
    }

    public void setOnPreConnectCallBack(OnPreConnectCallBack onPreConnectCallBack2) {
        this.onPreConnectCallBack = onPreConnectCallBack2;
    }

    private void setStreamHandler() {
        this.stream.streamHandler = new IStreamHandler() {
            /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass3 */

            public void on_change_qos() {
            }

            public void on_pause_video() {
            }

            public void on_start_video(int i, int i2) {
            }

            public void on_stop_video(int i) {
            }

            public void receive_video_data(byte[] bArr, byte[] bArr2) {
                if (!(XmStreamClient.this.mClientListener == null || bArr == null || bArr2 == null)) {
                    XmStreamClient.this.mClientListener.onVideoData(bArr, bArr2);
                }
                if (!(XmStreamClient.this.mRNClientListener == null || bArr == null || bArr2 == null)) {
                    XmStreamClient.this.mRNClientListener.onVideoData(bArr, bArr2);
                }
                if (XmStreamClient.this.mPreVideoCommandStartTime > 0) {
                    XmStreamClient.this.mPreVideoReceivedTime = System.currentTimeMillis() - XmStreamClient.this.mPreVideoCommandStartTime;
                    XmStreamClient.this.mPreVideoCommandStartTime = -1;
                }
                if (XmStreamClient.this.onPreConnectCallBack != null && XmStreamClient.this.mPreVideoReceivedTime > 0 && XmStreamClient.this.mConnectionSource == 2) {
                    cki.O00000o("XmStreamClient", "mPreVideoReceivedTime:" + XmStreamClient.this.mPreVideoReceivedTime);
                    XmStreamClient.this.onPreConnectCallBack.onVideoReceived(XmStreamClient.this.mPreVideoReceivedTime);
                    XmStreamClient.this.mPreVideoReceivedTime = -1;
                }
            }

            public void receive_audio_data(byte[] bArr, byte[] bArr2) {
                if (!(XmStreamClient.this.mClientListener == null || bArr == null || bArr2 == null)) {
                    XmStreamClient.this.mClientListener.onAudioData(bArr, bArr2);
                }
                if (XmStreamClient.this.mRNClientListener != null && bArr != null && bArr2 != null) {
                    XmStreamClient.this.mRNClientListener.onAudioData(bArr, bArr2);
                }
            }

            public void receive_rdt_data(byte[] bArr) {
                XmStreamClient.this.parseRDTResponseData(bArr);
            }

            public void on_connect(int i, String str) {
                if (XmStreamClient.this.mPreConnectStartTime > 0) {
                    XmStreamClient.this.mPreConnectTime = System.currentTimeMillis() - XmStreamClient.this.mPreConnectStartTime;
                    XmStreamClient.this.mPreConnectStartTime = -1;
                }
                XmStreamClient xmStreamClient = XmStreamClient.this;
                xmStreamClient.mClientStatus = 2;
                xmStreamClient.runInUIThread(new Runnable(i, str) {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$3$nCS6TL8ErgOJzu4grHMvrb0GSgU */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        XmStreamClient.AnonymousClass3.this.lambda$on_connect$0$XmStreamClient$3(this.f$1, this.f$2);
                    }
                });
            }

            public /* synthetic */ void lambda$on_connect$0$XmStreamClient$3(int i, String str) {
                try {
                    cki.O00000o0("XmStreamClient", "miss on_connect channelId=" + i + " channelMeta=" + str + " online=" + XmStreamClient.this.deviceStat.isOnline);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                if (XmStreamClient.this.mClientListener != null) {
                    XmStreamClient.this.mClientListener.onConnected();
                }
                if (XmStreamClient.this.mRNClientListener != null) {
                    XmStreamClient.this.mRNClientListener.onConnected();
                }
                if (XmStreamClient.this.onPreConnectCallBack != null) {
                    XmStreamClient.this.onPreConnectCallBack.onConnected(XmStreamClient.this.mPreConnectTime);
                }
            }

            public void on_disconnect(int i, int i2) {
                XmStreamClient xmStreamClient = XmStreamClient.this;
                xmStreamClient.mClientStatus = 0;
                xmStreamClient.runInUIThread(new Runnable(i, i2) {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$3$mmBCvdFaZWajcJuhP2hyD0wliy4 */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        XmStreamClient.AnonymousClass3.this.lambda$on_disconnect$1$XmStreamClient$3(this.f$1, this.f$2);
                    }
                });
            }

            public /* synthetic */ void lambda$on_disconnect$1$XmStreamClient$3(int i, int i2) {
                try {
                    cki.O00000o0("XmStreamClient", "miss on_disconnect channelId=" + i + " reason=" + i2 + " online=" + XmStreamClient.this.deviceStat.isOnline);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                if (XmStreamClient.this.mClientListener != null) {
                    XmStreamClient.this.mClientListener.onDisconnectedWithCode(i2);
                }
                if (XmStreamClient.this.mRNClientListener != null) {
                    XmStreamClient.this.mRNClientListener.onDisconnectedWithCode(i2);
                }
            }

            public void on_reconnect() {
                XmStreamClient xmStreamClient = XmStreamClient.this;
                xmStreamClient.mClientStatus = 2;
                xmStreamClient.runInUIThread(new Runnable() {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$3$jJxrsN5hdJJyChrZXkarg5qIBM */

                    public final void run() {
                        XmStreamClient.AnonymousClass3.this.lambda$on_reconnect$2$XmStreamClient$3();
                    }
                });
            }

            public /* synthetic */ void lambda$on_reconnect$2$XmStreamClient$3() {
                if (XmStreamClient.this.onPreConnectCallBack != null) {
                    XmStreamClient.this.onPreConnectCallBack.onReConnected();
                }
            }

            public void on_command(int i, byte[] bArr) {
                if (XmStreamClient.this.mClientListener != null) {
                    XmStreamClient.this.mClientListener.onCtrlData(i, bArr);
                }
                if (XmStreamClient.this.mRNClientListener != null) {
                    XmStreamClient.this.mRNClientListener.onCtrlData(i, bArr);
                }
            }

            public boolean isAutoVideo() {
                return XmStreamClient.this.isAutoVideo;
            }

            public boolean isAutoAudio() {
                return XmStreamClient.this.isAutoAudio;
            }

            public void on_error(int i, String str) {
                XmStreamClient xmStreamClient = XmStreamClient.this;
                xmStreamClient.mClientStatus = 0;
                xmStreamClient.runInUIThread(new Runnable(i, str) {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$3$YsSjPWzvpS1B4NYO2SOpxZGS6BY */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        XmStreamClient.AnonymousClass3.this.lambda$on_error$3$XmStreamClient$3(this.f$1, this.f$2);
                    }
                });
            }

            public /* synthetic */ void lambda$on_error$3$XmStreamClient$3(int i, String str) {
                try {
                    cki.O00000o0("XmStreamClient", "miss on_error=" + i + " extra=" + str + " online=" + XmStreamClient.this.deviceStat.isOnline);
                } catch (Exception e) {
                    cki.O00000oO("XmStreamClient", e.toString());
                }
                if (XmStreamClient.this.mClientListener != null) {
                    XmStreamClient.this.mClientListener.onError(i, str);
                }
                if (XmStreamClient.this.mRNClientListener != null) {
                    XmStreamClient.this.mRNClientListener.onError(i, str);
                }
                if (XmStreamClient.this.onPreConnectCallBack != null) {
                    XmStreamClient.this.onPreConnectCallBack.onError(i, str);
                }
            }

            public void on_progress(int i) {
                XmStreamClient.this.runInUIThread(new Runnable(i) {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$3$cp8Q8YnCSUk360Bn31az_ZHitY */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        XmStreamClient.AnonymousClass3.this.lambda$on_progress$4$XmStreamClient$3(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$on_progress$4$XmStreamClient$3(int i) {
                if (XmStreamClient.this.mClientListener != null) {
                    XmStreamClient.this.mClientListener.onProgress(i);
                }
                if (XmStreamClient.this.mRNClientListener != null) {
                    XmStreamClient.this.mRNClientListener.onProgress(i);
                }
            }
        };
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public void streamStart(MissNetworkType missNetworkType, MissConfig missConfig, final IMISSListener iMISSListener) {
        runInUIThread(new Runnable() {
            /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$oOow0R_6KifPEwwL_hDJ6FVXv8 */

            public final void run() {
                XmStreamClient.this.lambda$streamStart$1$XmStreamClient();
            }
        });
        if (this.deviceStat == null) {
            this.mClientStatus = 0;
            if (iMISSListener != null) {
                runInUIThread(new Runnable() {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$JwJ3DxmLf652f865kX8mRt7bnYY */

                    public final void run() {
                        IMISSListener.this.onFailed(-1001, "deviceStat null");
                    }
                });
                return;
            }
            return;
        }
        try {
            if (this.stream == null) {
                synchronized (this) {
                    if (this.stream == null) {
                        this.stream = new MIStream();
                    }
                }
            }
            if (this.mClientStatus == 2) {
                runInUIThread(new Runnable(missNetworkType, iMISSListener) {
                    /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$jb4Ms09IMOUu2AkUIaocJSnDNE */
                    private final /* synthetic */ MissNetworkType f$1;
                    private final /* synthetic */ IMISSListener f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        XmStreamClient.this.lambda$streamStart$3$XmStreamClient(this.f$1, this.f$2);
                    }
                });
                if (this.isAutoVideo) {
                    streamToggleRemoteVideo(true, null);
                }
                if (this.isAutoAudio) {
                    streamToggleRemoteAudio(true, null);
                }
            } else if (this.stream != null) {
                cki.O00000o0("XmStreamClient", "streamStart:" + this.deviceStat.model + ":" + this.deviceStat.did + " online=" + this.deviceStat.isOnline);
                if (this.mClientStatus <= 0) {
                    this.stream.connect(this.deviceStat.model, this.fullDid, missNetworkType, new IStreamCallback<String>() {
                        /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass4 */

                        public void onSuccess(String str, Object obj) {
                            XmStreamClient.this.runInUIThread(new Runnable(str, obj, iMISSListener) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$4$prK3kYUscu0PRnCk2WC6SFzuV7o */
                                private final /* synthetic */ String f$1;
                                private final /* synthetic */ Object f$2;
                                private final /* synthetic */ IMISSListener f$3;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                }

                                public final void run() {
                                    XmStreamClient.AnonymousClass4.this.lambda$onSuccess$0$XmStreamClient$4(this.f$1, this.f$2, this.f$3);
                                }
                            });
                        }

                        public /* synthetic */ void lambda$onSuccess$0$XmStreamClient$4(String str, Object obj, IMISSListener iMISSListener) {
                            try {
                                cki.O00000o0("XmStreamClient", "streamStart:" + XmStreamClient.this.deviceStat.model + ":" + XmStreamClient.this.deviceStat.did + " onSuccess result=" + str + " extra=" + obj + " online=" + XmStreamClient.this.deviceStat.isOnline);
                            } catch (Exception e) {
                                cki.O00000oO("XmStreamClient", e.toString());
                            }
                            if (iMISSListener != null) {
                                iMISSListener.onSuccess(str, obj);
                            }
                            if (XmStreamClient.this.mClientListener != null) {
                                XmStreamClient.this.mClientListener.onProgress(91);
                            }
                            if (XmStreamClient.this.mRNClientListener != null) {
                                XmStreamClient.this.mRNClientListener.onProgress(91);
                            }
                        }

                        public void onFailed(int i, String str) {
                            XmStreamClient xmStreamClient = XmStreamClient.this;
                            xmStreamClient.mClientStatus = 0;
                            xmStreamClient.runInUIThread(new Runnable(i, str, iMISSListener) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$4$M939Ur70SUnFl74Q5sOEY5iLXPQ */
                                private final /* synthetic */ int f$1;
                                private final /* synthetic */ String f$2;
                                private final /* synthetic */ IMISSListener f$3;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                }

                                public final void run() {
                                    XmStreamClient.AnonymousClass4.this.lambda$onFailed$1$XmStreamClient$4(this.f$1, this.f$2, this.f$3);
                                }
                            });
                        }

                        public /* synthetic */ void lambda$onFailed$1$XmStreamClient$4(int i, String str, IMISSListener iMISSListener) {
                            try {
                                cki.O00000o0("XmStreamClient", "streamStart:" + XmStreamClient.this.deviceStat.model + ":" + XmStreamClient.this.deviceStat.did + " onFailed error=" + i + " errorInfo=" + str + " online=" + XmStreamClient.this.deviceStat.isOnline);
                            } catch (Exception e) {
                                cki.O00000oO("XmStreamClient", e.toString());
                            }
                            if (iMISSListener != null) {
                                iMISSListener.onFailed(i, str);
                            }
                            if (XmStreamClient.this.mClientListener != null) {
                                XmStreamClient.this.mClientListener.onError(i, str);
                            }
                            if (XmStreamClient.this.mRNClientListener != null) {
                                XmStreamClient.this.mRNClientListener.onError(i, str);
                            }
                            cki.O0000OOo("2000.1.1", "miss:" + i + ":" + str);
                        }

                        public void onProgress(int i) {
                            XmStreamClient.this.runInUIThread(new Runnable(iMISSListener, i) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$4$Z8JVvfoOZBeDFevqtgvZlf0FUU */
                                private final /* synthetic */ IMISSListener f$1;
                                private final /* synthetic */ int f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void run() {
                                    XmStreamClient.AnonymousClass4.this.lambda$onProgress$2$XmStreamClient$4(this.f$1, this.f$2);
                                }
                            });
                        }

                        public /* synthetic */ void lambda$onProgress$2$XmStreamClient$4(IMISSListener iMISSListener, int i) {
                            if (iMISSListener != null) {
                                iMISSListener.onProgress(i);
                            }
                            if (XmStreamClient.this.mClientListener != null) {
                                XmStreamClient.this.mClientListener.onProgress(i);
                            }
                            if (XmStreamClient.this.mRNClientListener != null) {
                                XmStreamClient.this.mRNClientListener.onProgress(i);
                            }
                        }
                    }, missConfig);
                    this.mClientStatus = 1;
                }
                setStreamHandler();
            } else {
                this.mClientStatus = 0;
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1002, "stream null");
                }
            }
        } catch (Exception e) {
            this.mClientStatus = 0;
            if (iMISSListener != null) {
                iMISSListener.onFailed(-1009, "exception");
            }
            cki.O00000oO("XmStreamClient", "exception:" + e.getLocalizedMessage());
        }
    }

    public /* synthetic */ void lambda$streamStart$1$XmStreamClient() {
        IClientExListener iClientExListener = this.mClientListener;
        if (iClientExListener != null) {
            iClientExListener.onProgress(31);
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onProgress(31);
        }
    }

    public /* synthetic */ void lambda$streamStart$3$XmStreamClient(MissNetworkType missNetworkType, IMISSListener iMISSListener) {
        try {
            cki.O00000o0("XmStreamClient", "miss mClientStatus == StatusConnected  networkTypev=" + missNetworkType.getValue());
        } catch (Exception e) {
            cki.O00000oO("XmStreamClient", e.toString());
        }
        if (iMISSListener != null) {
            iMISSListener.onSuccess("0", null);
        }
        IClientExListener iClientExListener = this.mClientListener;
        if (iClientExListener != null) {
            iClientExListener.onProgress(99);
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onProgress(99);
        }
    }

    public void streamStop(final IMISSListener iMISSListener) {
        this.mClientStatus = 0;
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    cki.O00000o("XmStreamClient", "streamStop:" + this.deviceStat.model + ":" + this.fullDid);
                    this.stream.disConnect(this.deviceStat.model, this.fullDid, new IStreamCallback<String>() {
                        /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass5 */

                        public void onSuccess(String str, Object obj) {
                            XmStreamClient.this.mClientStatus = 0;
                            IMISSListener iMISSListener = iMISSListener;
                            if (iMISSListener != null) {
                                iMISSListener.onSuccess(str, obj);
                            }
                        }

                        public void onFailed(int i, String str) {
                            XmStreamClient.this.mClientStatus = 0;
                            IMISSListener iMISSListener = iMISSListener;
                            if (iMISSListener != null) {
                                iMISSListener.onFailed(i, str);
                            }
                            cki.O0000OOo("2000.1.2", "miss:" + i + ":" + str);
                        }

                        public void onProgress(int i) {
                            IMISSListener iMISSListener = iMISSListener;
                            if (iMISSListener != null) {
                                iMISSListener.onProgress(i);
                            }
                        }
                    });
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                this.mClientStatus = 0;
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "exception:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamStartCall(IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    this.stream.speakerStart(this.deviceStat.model, this.fullDid, iMISSListener);
                    this.stream.audioStart(this.deviceStat.model, this.fullDid, null);
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamStartCall:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamStopCall(IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    this.stream.speakerStop(this.deviceStat.model, this.fullDid, iMISSListener);
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamStopCall:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamResolution(int i, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    cki.O00000o("XmStreamClient", "streamResolution ".concat(String.valueOf(i)));
                    this.stream.setResolution(this.deviceStat.model, this.fullDid, i, iMISSListener);
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamResolution:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamDirection(int i, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    this.stream.setDirection(this.deviceStat.model, this.fullDid, i, iMISSListener);
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamDirection:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamToggleAudio(boolean z, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    if (z) {
                        this.stream.audioStop(this.deviceStat.model, this.fullDid, iMISSListener);
                    } else {
                        this.stream.audioStart(this.deviceStat.model, this.fullDid, iMISSListener);
                    }
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamToggleAudio:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamSendMessage(int i, int i2, byte[] bArr, P2pResponse p2pResponse, IMISSListener iMISSListener) {
        try {
            if (this.stream != null) {
                this.stream.avChannelSendRDTData(getTLVData(i, bArr), iMISSListener);
            } else if (iMISSListener != null) {
                iMISSListener.onFailed(-1008, "stream null");
            }
        } catch (Exception e) {
            if (iMISSListener != null) {
                iMISSListener.onFailed(-1009, "exception");
            }
            cki.O00000oO("XmStreamClient", "streamSendMessage:" + e.getLocalizedMessage());
        }
    }

    public void streamRDTMessage(int i, int i2, byte[] bArr, P2pResponse p2pResponse, IMISSListener iMISSListener) {
        try {
            if (this.stream != null) {
                this.stream.avChannelSendRDTData(getTLVData(i, bArr), iMISSListener);
            } else if (iMISSListener != null) {
                iMISSListener.onFailed(-1008, "stream null");
            }
        } catch (Exception e) {
            if (iMISSListener != null) {
                iMISSListener.onFailed(-1009, "exception");
            }
            cki.O00000oO("XmStreamClient", "streamSendMessage:" + e.getLocalizedMessage());
        }
    }

    public void sendRdtCmd(byte[] bArr, IMISSListener iMISSListener) {
        try {
            if (this.stream != null) {
                this.stream.avChannelSendRDTData(bArr, iMISSListener);
            } else if (iMISSListener != null) {
                iMISSListener.onFailed(-1008, "stream null");
            }
        } catch (Exception e) {
            if (iMISSListener != null) {
                iMISSListener.onFailed(-1009, "exception");
            }
            cki.O00000oO("XmStreamClient", "streamSendMessage:" + e.getLocalizedMessage());
        }
    }

    public void streamCmdMessage(int i, String str, final IMISSListener iMISSListener) {
        if (this.stream != null) {
            this.stream.missCommandSend(i, str, new IStreamCallback<Integer>() {
                /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass6 */

                public void onSuccess(Integer num, Object obj) {
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        iMISSListener.onSuccess(String.valueOf(num), obj);
                    }
                }

                public void onFailed(int i, String str) {
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        iMISSListener.onFailed(i, str);
                    }
                }

                public void onProgress(int i) {
                    IMISSListener iMISSListener = iMISSListener;
                    if (iMISSListener != null) {
                        iMISSListener.onProgress(i);
                    }
                }
            });
        }
    }

    public void streamPlaybackSpeed(String str, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    this.stream.avPlaybackSpeed(this.deviceStat.model, this.fullDid, str, iMISSListener);
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamPlaybackSpeed:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamPlayback(String str, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    this.stream.avPlayback(this.deviceStat.model, this.fullDid, str, iMISSListener);
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamPlayback:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamToggleRemoteVideo(boolean z, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    int i = this.stream.toggleRemoteVideo(z);
                    if (iMISSListener == null) {
                        return;
                    }
                    if (i >= 0) {
                        if (z) {
                            this.mIsPaused = false;
                        } else {
                            this.mIsPaused = true;
                        }
                        iMISSListener.onSuccess(String.valueOf(i), null);
                        return;
                    }
                    iMISSListener.onFailed(i, "doStreamToggleRemoteVideo");
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamToggleRemoteVideo:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void streamToggleRemoteAudio(boolean z, IMISSListener iMISSListener) {
        if (this.deviceStat != null) {
            try {
                if (this.stream != null) {
                    int i = this.stream.toggleRemoteAudio(z);
                    if (iMISSListener == null) {
                        return;
                    }
                    if (i >= 0) {
                        iMISSListener.onSuccess(String.valueOf(i), null);
                    } else {
                        iMISSListener.onFailed(i, "doStreamToggleRemoteAudio");
                    }
                } else if (iMISSListener != null) {
                    iMISSListener.onFailed(-1008, "stream null");
                }
            } catch (Exception e) {
                if (iMISSListener != null) {
                    iMISSListener.onFailed(-1009, "exception");
                }
                cki.O00000oO("XmStreamClient", "streamToggleRemoteAudio:" + e.getLocalizedMessage());
            }
        } else if (iMISSListener != null) {
            iMISSListener.onFailed(-1001, "deviceStat null");
        }
    }

    public void setRDTTimelineListener(IRDTTimelineListener iRDTTimelineListener) {
        this.mRDTTimelineListener = iRDTTimelineListener;
    }

    public void setRDTTimelineEventListener(IRDTTimelineEventListener iRDTTimelineEventListener) {
        this.mRDTIimelineEventListener = iRDTTimelineEventListener;
    }

    public void setRDTPanoramaListener(IRDTPanoramaListener iRDTPanoramaListener) {
        this.mRDTPanoramaListener = iRDTPanoramaListener;
    }

    public void setRDTCameraPositionListener(IRDTCameraPositionListener iRDTCameraPositionListener) {
        this.mRdtCameraPositionListener = iRDTCameraPositionListener;
    }

    public void setRDTPictureListener(IRDTPictureListener iRDTPictureListener) {
        this.mRDTPictureListener = iRDTPictureListener;
    }

    public void setRDTListener(IRDTListener iRDTListener) {
        this.mRDTListener = iRDTListener;
    }

    public void setRdtDataListener(IRdtDataListener iRdtDataListener) {
        this.mRdtDataListener = iRdtDataListener;
    }

    public void streamGetDeviceInfo(IMISSListener iMISSListener) {
        if (this.stream != null) {
            this.stream.getDeviceInfo(iMISSListener);
        }
    }

    private void parseRDTDeviceInfo(byte[] bArr) {
        try {
            new String(bArr);
        } catch (Exception unused) {
        }
    }

    public void parseRDTResponseData(byte[] bArr) {
        if (bArr != null) {
            IRdtDataListener iRdtDataListener = this.mRdtDataListener;
            if (iRdtDataListener != null) {
                iRdtDataListener.onRdtDataReceived(bArr);
            }
            ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
            if (iCameraPlayerListener != null) {
                iCameraPlayerListener.onRdtDataReceived(bArr);
            }
            try {
                if (this.rdtCommandSize == 0 && this.rdtCommand == 0) {
                    this.rdtCommandBuffer = null;
                    this.rdtCommandSize = 0;
                    this.rdtCommandOffset = 0;
                    this.rdtCommandStatus = 0;
                    this.rdtCommand = 0;
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(bArr, 0, bArr2, 0, 4);
                    int byteArrayToInt = Packet.byteArrayToInt(bArr2, 0, false);
                    if (byteArrayToInt <= 0) {
                        cki.O00000oO("XmStreamClient", "command invalid:".concat(String.valueOf(byteArrayToInt)));
                        return;
                    }
                    this.rdtCommand = byteArrayToInt;
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArr, 4, bArr3, 0, 4);
                    int byteArrayToInt2 = Packet.byteArrayToInt(bArr3, 0, false);
                    if (this.rdtCommand > 0 && this.rdtCommand <= 65535 && byteArrayToInt2 > 0) {
                        if (byteArrayToInt2 < 20971520) {
                            this.rdtCommandSize = byteArrayToInt2;
                            byte[] bArr4 = new byte[4];
                            System.arraycopy(bArr, 8, bArr4, 0, 4);
                            int byteArrayToInt3 = Packet.byteArrayToInt(bArr4, 0, false);
                            this.rdtCommandStatus = byteArrayToInt3;
                            cki.O00000o("XmStreamClient", "rawDataSize:".concat(String.valueOf(byteArrayToInt2)));
                            int length = bArr.length - 12;
                            this.rdtCommandBuffer = new byte[byteArrayToInt2];
                            System.arraycopy(bArr, 12, this.rdtCommandBuffer, 0, length);
                            this.rdtCommandOffset = length;
                            if (length >= this.rdtCommandSize) {
                                this.isAllRdtDataReceived = true;
                            }
                            cki.O00000o("XmStreamClient", "receive_rdt_data command:" + byteArrayToInt + " size:" + byteArrayToInt2 + " status:" + byteArrayToInt3);
                        }
                    }
                    this.rdtCommand = 0;
                    this.rdtCommandSize = 0;
                    cki.O00000oO("XmStreamClient", "size invalid:".concat(String.valueOf(byteArrayToInt2)));
                    return;
                }
                System.arraycopy(bArr, 0, this.rdtCommandBuffer, this.rdtCommandOffset, bArr.length);
                this.rdtCommandOffset += bArr.length;
                if (this.rdtCommandOffset >= this.rdtCommandSize) {
                    cki.O00000o("XmStreamClient", "==============allRdtDataReceived==============");
                    this.isAllRdtDataReceived = true;
                }
                if (this.rdtCommand > 0 && this.rdtCommandSize > 0 && this.isAllRdtDataReceived) {
                    if (this.rdtCommand == 9) {
                        byte[] bArr5 = new byte[this.rdtCommandBuffer.length];
                        System.arraycopy(this.rdtCommandBuffer, 0, bArr5, 0, this.rdtCommandBuffer.length);
                        parseRDTDeviceInfo(bArr5);
                    } else if (this.rdtCommand == 6) {
                        if (this.mRDTTimelineListener != null) {
                            cki.O00000o("XmStreamClient", "rdtCommandBuffer:" + this.rdtCommandBuffer.length);
                            byte[] bArr6 = new byte[this.rdtCommandBuffer.length];
                            System.arraycopy(this.rdtCommandBuffer, 0, bArr6, 0, this.rdtCommandBuffer.length);
                            runInUIThread(new Runnable(bArr6) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$N0RIMYMk8Z_YmrqfD1ucxvfO424 */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    XmStreamClient.this.lambda$parseRDTResponseData$4$XmStreamClient(this.f$1);
                                }
                            });
                        }
                    } else if (this.rdtCommand == 5) {
                        if (this.mRDTPictureListener != null) {
                            byte[] bArr7 = new byte[this.rdtCommandBuffer.length];
                            System.arraycopy(this.rdtCommandBuffer, 0, bArr7, 0, this.rdtCommandBuffer.length);
                            runInUIThread(new Runnable(bArr7) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$Y38ln0H4DbiiJYtHzVBgW0ztg */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    XmStreamClient.this.lambda$parseRDTResponseData$5$XmStreamClient(this.f$1);
                                }
                            });
                        }
                    } else if (this.rdtCommand == 11) {
                        if (this.mRDTIimelineEventListener != null) {
                            byte[] bArr8 = new byte[this.rdtCommandBuffer.length];
                            System.arraycopy(this.rdtCommandBuffer, 0, bArr8, 0, this.rdtCommandBuffer.length);
                            runInUIThread(new Runnable(bArr8) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$p9Ooas_lxmpXEyxDC41MDwuVqks */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    XmStreamClient.this.lambda$parseRDTResponseData$6$XmStreamClient(this.f$1);
                                }
                            });
                        }
                    } else if (this.rdtCommand == 12) {
                        if (this.mRDTPanoramaListener != null) {
                            byte[] bArr9 = new byte[this.rdtCommandBuffer.length];
                            System.arraycopy(this.rdtCommandBuffer, 0, bArr9, 0, this.rdtCommandBuffer.length);
                            runInUIThread(new Runnable(bArr9) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$pTBRwI8NzC9tp507SrufiXa2AG8 */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    XmStreamClient.this.lambda$parseRDTResponseData$7$XmStreamClient(this.f$1);
                                }
                            });
                        }
                    } else if (this.rdtCommand == 14) {
                        if (this.mRdtCameraPositionListener != null) {
                            byte[] bArr10 = new byte[this.rdtCommandBuffer.length];
                            System.arraycopy(this.rdtCommandBuffer, 0, bArr10, 0, this.rdtCommandBuffer.length);
                            runInUIThread(new Runnable(bArr10) {
                                /* class com.xiaomi.mistream.$$Lambda$XmStreamClient$J2Ti__pwU3q5fvBppHqcXWrCNg */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    XmStreamClient.this.lambda$parseRDTResponseData$8$XmStreamClient(this.f$1);
                                }
                            });
                        }
                    } else if (this.rdtCommand == 1 && this.mRDTListener != null) {
                        byte[] bArr11 = new byte[this.rdtCommandBuffer.length];
                        System.arraycopy(this.rdtCommandBuffer, 0, bArr11, 0, this.rdtCommandBuffer.length);
                        this.mRDTListener.onRDTDataReceived(bArr11);
                    }
                    this.rdtCommandBuffer = null;
                    this.rdtCommandSize = 0;
                    this.rdtCommandOffset = 0;
                    this.rdtCommandStatus = 0;
                    this.rdtCommand = 0;
                    this.isAllRdtDataReceived = false;
                }
            } catch (Exception e) {
                cki.O00000oO("XmStreamClient", "parseRDTResponseData:" + e.getLocalizedMessage() + " rdtCommand:" + this.rdtCommand);
                this.rdtCommandBuffer = null;
                this.rdtCommandSize = 0;
                this.rdtCommandOffset = 0;
                this.rdtCommandStatus = 0;
                this.rdtCommand = 0;
                this.isAllRdtDataReceived = false;
            }
        }
    }

    public /* synthetic */ void lambda$parseRDTResponseData$4$XmStreamClient(byte[] bArr) {
        this.mRDTTimelineListener.onTimelineDataReceived(bArr);
    }

    public /* synthetic */ void lambda$parseRDTResponseData$5$XmStreamClient(byte[] bArr) {
        this.mRDTPictureListener.onPictureDataReceived(bArr);
    }

    public /* synthetic */ void lambda$parseRDTResponseData$6$XmStreamClient(byte[] bArr) {
        this.mRDTIimelineEventListener.onTimelineEventDataReceived(bArr);
    }

    public /* synthetic */ void lambda$parseRDTResponseData$7$XmStreamClient(byte[] bArr) {
        this.mRDTPanoramaListener.onPanoramaReceived(bArr);
    }

    public /* synthetic */ void lambda$parseRDTResponseData$8$XmStreamClient(byte[] bArr) {
        this.mRdtCameraPositionListener.onCameraPositionReceived(bArr);
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public void releaseRN(boolean z, ICameraPlayerListener iCameraPlayerListener) {
        releaseRN(z, iCameraPlayerListener, true);
    }

    public void releaseRN(boolean z, ICameraPlayerListener iCameraPlayerListener, boolean z2) {
        if (!z) {
            streamStop(null);
        }
        if (z2) {
            this.mRNClientListener = null;
            cki.O00000o("XmStreamClient", "release and rest listener");
        }
        this.mClientStatus = 0;
        cki.O00000o("XmStreamClient", "release " + toString());
    }

    public void sendAudioData(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            cki.O00000oO("XmStreamClient", "sendAudioData data null");
            cki.O0000OOo("2000.2.3", "miss:sendAudioData data null");
            return;
        }
        doSendAudioData(bArr, i);
    }

    public void startConnect(int i, IXmConnectionClient.XmActionCallback xmActionCallback) {
        startConnect(i, xmActionCallback, null);
    }

    private void startConnect(int i, final IXmConnectionClient.XmActionCallback xmActionCallback, MissConfig missConfig) {
        this.mConnectionSource = i;
        if (i == 2) {
            this.mPreConnectStartTime = System.currentTimeMillis();
        }
        streamStart(missConfig, new IMISSListener() {
            /* class com.xiaomi.mistream.XmStreamClient.AnonymousClass7 */

            public void onProgress(int i) {
            }

            public void onSuccess(String str, Object obj) {
                IXmConnectionClient.XmActionCallback xmActionCallback = xmActionCallback;
                if (xmActionCallback != null) {
                    xmActionCallback.onSuccess("1", null);
                }
            }

            public void onFailed(int i, String str) {
                IXmConnectionClient.XmActionCallback xmActionCallback = xmActionCallback;
                if (xmActionCallback != null) {
                    xmActionCallback.onFailed(i, str);
                }
            }
        });
    }

    public void startConnect(IXmConnectionClient.XmActionCallback xmActionCallback) {
        startConnect(1, xmActionCallback);
    }

    public void startConnect(IXmConnectionClient.XmActionCallback xmActionCallback, MissConfig missConfig) {
        startConnect(1, xmActionCallback, missConfig);
    }

    public boolean getAutoVideo() {
        return this.isAutoVideo;
    }

    public void setStreamClient(ICameraPlayerListener iCameraPlayerListener) {
        this.mRNClientListener = iCameraPlayerListener;
    }

    public void setAutoVideo(boolean z) {
        this.isAutoVideo = z;
    }

    public boolean getAutoAudio() {
        return this.isAutoAudio;
    }

    public void setAutoAudio(boolean z) {
        this.isAutoAudio = z;
    }

    public void markCallStarted(boolean z) {
        if (this.stream != null) {
            this.stream.markCallStart(z);
        }
    }

    private MissNetworkType getNetworkType() {
        MissNetworkType missNetworkType = MissNetworkType.UNKNOWN;
        if (goe.O000000o(ckh.O000000o())) {
            return MissNetworkType.WIFI;
        }
        if (goe.O00000Oo(ckh.O000000o())) {
            return MissNetworkType.MOBILE_4G;
        }
        if (goe.O00000o0(ckh.O000000o())) {
            return MissNetworkType.MOBILE_5G;
        }
        return MissNetworkType.OTHER;
    }
}
