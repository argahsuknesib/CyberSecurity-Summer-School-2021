package com.tutk;

import _m_j.bat;
import _m_j.bau;
import _m_j.bav;
import _m_j.baw;
import _m_j.bax;
import _m_j.cki;
import _m_j.jgt;
import _m_j.jgu;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.tutk.CameraClient;
import com.tutk.IOTC.AVAPIs;
import com.tutk.IOTC.IOTCAPIs;
import com.tutk.IOTC.Packet;
import com.tutk.IOTC.RDTAPIs;
import com.tutk.IOTC.St_RDT_Status;
import com.tutk.IOTC.St_SInfo;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.P2pResponse;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class TuTkClient extends CameraClient {
    public static volatile long mConnect_Cache;
    public static volatile long mConnect_Client;
    public static volatile long mConnect_Iotc;
    public static volatile long mConnect_Public_Key;
    public static volatile long mConnect_Start;
    private static String[] sP2P_MODE = {"P2P", "Relay", "Lan"};
    private final int CAMERA_TYPE = 4;
    public final int FRAME_INFO_SIZE;
    private final int IOTYPE_USER_DEFINED_START = 256;
    public boolean isUseHualaiEncrypted;
    public int mAVClientIndex = -1;
    private AVIOCtrlReceiveThread mAVIOCtrlReceiveThread = null;
    private volatile int mAVServerIndex = -1;
    private AudioReceiveThread mAudioReceiveThread = null;
    private final int[] mIoType = new int[1];
    private volatile int mLocalSessionId = -1;
    private int mNumber = 0;
    public P2PInfoImp mP2PInfo;
    private volatile int mQuality = 0;
    public int mRDTIndex = -1;
    private RDTReceiveThread mRDTReceiveThread = null;
    public RDTDataReceiveThread mRdtDataReceiveThread;
    private final byte[] mRecDataBuff = new byte[1024];
    public volatile int mSessionId = -1;
    private VideoReceiveThread mVideoReceiveThread = null;
    private St_SInfo m_stSInfo = new St_SInfo();
    public boolean useFixedRdtChannel;
    public int videoBlockTimes = 0;

    private TuTkClient(P2PInfoImp p2PInfoImp) {
        super(p2PInfoImp);
        this.mP2PInfo = p2PInfoImp;
        if (DeviceModelManager.getInstance().isHualaiQF(this.mP2PInfo.getModel())) {
            this.FRAME_INFO_SIZE = 1024;
        } else {
            this.FRAME_INFO_SIZE = p2PInfoImp.mFrameInfoSize;
        }
        if (!TextUtils.isEmpty(p2PInfoImp.getDid())) {
            this.mUsrExpPlanEnabled = XmPluginHostApi.instance().isUsrExpPlanEnabled(p2PInfoImp.getDid());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        return null;
     */
    public static synchronized CameraClient getCameraClient(XmP2PInfo xmP2PInfo) {
        synchronized (TuTkClient.class) {
            if (xmP2PInfo != null) {
                if (!TextUtils.isEmpty(xmP2PInfo.getUid())) {
                    if (!(xmP2PInfo instanceof P2PInfoImp)) {
                        return null;
                    }
                    CameraClient cameraClient = (CameraClient) sCacheCameraClientMap.get(xmP2PInfo.getUid());
                    if (cameraClient == null) {
                        cameraClient = new TuTkClient((P2PInfoImp) xmP2PInfo);
                        sCacheCameraClientMap.put(xmP2PInfo.getUid(), cameraClient);
                    } else {
                        cameraClient.updateInfo(xmP2PInfo);
                    }
                }
            }
        }
    }

    public void updateInfo(XmP2PInfo xmP2PInfo) {
        if (xmP2PInfo instanceof P2PInfoImp) {
            P2PInfoImp p2PInfoImp = (P2PInfoImp) xmP2PInfo;
            P2PInfoImp p2PInfoImp2 = this.mP2PInfo;
            if (p2PInfoImp2 == null || !p2PInfoImp2.getPwd().equals(xmP2PInfo.getPwd()) || !this.mP2PInfo.mRemoteKey.equals(p2PInfoImp.mRemoteKey)) {
                cki.O00000Oo("CameraClient", "updateInfo ");
                this.pwdChange = true;
                this.mPwdTry = 3;
                this.mP2PInfo = p2PInfoImp;
                if (isConnected()) {
                    cki.O00000Oo("CameraClient", "updateInfo connect");
                    reconnect();
                    return;
                }
                return;
            }
            this.mP2PInfo.setOnLine(xmP2PInfo.getOnLine());
        }
    }

    public String getUid() {
        P2PInfoImp p2PInfoImp = this.mP2PInfo;
        return p2PInfoImp == null ? "" : p2PInfoImp.getUid();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0127  */
    public void doConnect() throws CameraException {
        String str;
        int i;
        cki.O00000o0("CameraClient", "doConnect " + toString());
        onProgress(5);
        P2PUtils.initial();
        onProgress(10);
        int IOTC_Get_SessionID = IOTCAPIs.IOTC_Get_SessionID();
        if (IOTC_Get_SessionID >= 0) {
            this.mLocalSessionId = IOTC_Get_SessionID;
            onProgress(20);
            mConnect_Iotc = System.currentTimeMillis();
            cki.O00000o0("CameraClient", "TuTkClient IOTC_Connect ".concat(String.valueOf(IOTC_Get_SessionID)));
            this.mSessionId = IOTCAPIs.IOTC_Connect_ByUID_Parallel(this.mP2PInfo.getUid(), IOTC_Get_SessionID);
            if (this.mSessionId >= 0) {
                onProgress(30);
                cki.O00000o0("CameraClient", "TuTkClient Free_Channel");
                int IOTC_Session_Get_Free_Channel = IOTCAPIs.IOTC_Session_Get_Free_Channel(this.mSessionId);
                if (IOTC_Session_Get_Free_Channel >= 0) {
                    int[] iArr = new int[1];
                    int[] iArr2 = new int[1];
                    cki.O00000o0("CameraClient", "TuTkClient avClientStart2");
                    String str2 = this.mP2PInfo.mAccount;
                    if (this.mP2PInfo.mShareKey != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jgu jgu = jgt.O00000Oo;
                            jSONObject.put("public_key", jgu.O000000o(this.mP2PInfo.mPublicKey));
                            jSONObject.put("sign", this.mP2PInfo.mRemoteSing);
                            jSONObject.put("account", str2);
                            str = jSONObject.toString();
                        } catch (JSONException e) {
                            cki.O00000o0("CameraClient", "avClientStart2 " + e.toString());
                        }
                        this.pwdChange = false;
                        onProgress(40);
                        mConnect_Client = System.currentTimeMillis();
                        this.mAVClientIndex = AVAPIs.avClientStart2(this.mSessionId, str, this.mP2PInfo.getPwd(), 10, iArr2, 0, iArr);
                        i = this.mAVClientIndex;
                        if (i < 0) {
                            onProgress(50);
                            AVIOCtrlReceiveThread aVIOCtrlReceiveThread = this.mAVIOCtrlReceiveThread;
                            if (aVIOCtrlReceiveThread != null) {
                                aVIOCtrlReceiveThread.stopThreadAsyn();
                            }
                            this.mAVIOCtrlReceiveThread = new AVIOCtrlReceiveThread();
                            this.mAVIOCtrlReceiveThread.start();
                            this.mRDTReceiveThread = new RDTReceiveThread();
                            this.mRDTReceiveThread.start();
                            onProgress(60);
                            this.mAudioReceiveThread = new AudioReceiveThread();
                            this.mAudioReceiveThread.start();
                            this.mVideoReceiveThread = new VideoReceiveThread();
                            this.mVideoReceiveThread.start();
                            onProgress(70);
                            this.mClientStatus = 1;
                            onConnected();
                            return;
                        }
                        throw new CameraException(i, getErrorInfo(i));
                    }
                    str = str2;
                    this.pwdChange = false;
                    onProgress(40);
                    mConnect_Client = System.currentTimeMillis();
                    this.mAVClientIndex = AVAPIs.avClientStart2(this.mSessionId, str, this.mP2PInfo.getPwd(), 10, iArr2, 0, iArr);
                    i = this.mAVClientIndex;
                    if (i < 0) {
                    }
                } else {
                    throw new CameraException(IOTC_Session_Get_Free_Channel, getErrorInfo(IOTC_Session_Get_Free_Channel));
                }
            } else {
                throw new CameraException(this.mSessionId, getErrorInfo(this.mSessionId));
            }
        } else {
            throw new CameraException(IOTC_Get_SessionID, getErrorInfo(IOTC_Get_SessionID));
        }
    }

    public int sendIOCtrl(int i, byte[] bArr) {
        if (this.mP2PHandler == null) {
            return -1;
        }
        try {
            if (Looper.myLooper() != this.mP2PHandler.getLooper()) {
                Message obtain = Message.obtain();
                obtain.what = 11;
                obtain.arg1 = i;
                obtain.obj = bArr;
                this.mP2PHandler.sendMessage(obtain);
                cki.O00000oO("CameraClient", "sendIOCtrl not in p2p Thread");
                return 0;
            }
            cki.O00000oo("CameraClient", "TuTkClient sendIOCtrl :".concat(String.valueOf(i)));
            if (this.mAVClientIndex < 0) {
                cki.O00000oO("CameraClient", "sendIOCtrl mAVClientIndex:".concat(String.valueOf(i)));
                return -2;
            }
            if (bArr == null) {
                bArr = new byte[8];
            }
            int avSendIOCtrl = AVAPIs.avSendIOCtrl(this.mAVClientIndex, i, bArr, bArr.length);
            cki.O00000oo("CameraClient", "endIOCtrl :" + i + " ret: " + avSendIOCtrl);
            return avSendIOCtrl;
        } catch (Exception e) {
            cki.O00000oO("CameraClient", "sendIOCtrl Exception:" + e.getLocalizedMessage());
            return -3;
        }
    }

    public void setQuality(int i) {
        if (i != this.mQuality && isConnected()) {
            JSONObject jSONObject = new JSONObject();
            byte[] bArr = null;
            try {
                jSONObject.put("videoquality", i);
                bArr = jSONObject.toString().getBytes(Charset.forName("UTF-8"));
            } catch (JSONException unused) {
                cki.O00000o0("CameraClient", "quality fail ");
            }
            if (bArr != null) {
                this.mP2PHandler.post(new Runnable(bArr) {
                    /* class com.tutk.$$Lambda$TuTkClient$yJ69F1P7cJc2XSuao6TYhOUC69U */
                    private final /* synthetic */ byte[] f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        TuTkClient.this.lambda$setQuality$0$TuTkClient(this.f$1);
                    }
                });
            } else {
                return;
            }
        }
        this.mQuality = i;
    }

    public /* synthetic */ void lambda$setQuality$0$TuTkClient(byte[] bArr) {
        sendIOCtrl(800, bArr);
    }

    /* access modifiers changed from: protected */
    public void doSendAudioData(byte[] bArr, int i) {
        int i2;
        if (bArr != null && bArr.length != 0) {
            if (this.mAVServerIndex >= 0) {
                this.mNumber += 20;
                byte[] parseContent = parseContent((short) i, (byte) 2, (byte) 0, (byte) 0, this.mNumber, this.isBigOrder);
                P2PInfoImp p2PInfoImp = this.mP2PInfo;
                if (p2PInfoImp == null || !p2PInfoImp.isIPC009AudioFullEncryption) {
                    i2 = AVAPIs.avSendAudioData(this.mAVServerIndex, bArr, bArr.length, parseContent, parseContent.length);
                } else {
                    byte[] encryptAudio = DecryptUtil.encryptAudio(bArr, this.mP2PInfo.mShareKey);
                    i2 = AVAPIs.avSendAudioData(this.mAVServerIndex, encryptAudio, encryptAudio.length, parseContent, parseContent.length);
                }
                if (i2 < 0) {
                    cki.O00000o0("CameraClient", "TuTkClient avSendAudioData error:" + getErrorInfo(i2));
                }
            } else if (this.mRNClientListener == null) {
                this.mP2PHandler.post(new Runnable() {
                    /* class com.tutk.$$Lambda$TuTkClient$6aDJO69ss9ZpkScpsdulEmSUF5U */

                    public final void run() {
                        TuTkClient.this.lambda$doSendAudioData$1$TuTkClient();
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$doSendAudioData$1$TuTkClient() {
        if (this.mAVServerIndex <= 0) {
            int IOTC_Session_Get_Free_Channel = IOTCAPIs.IOTC_Session_Get_Free_Channel(this.mSessionId);
            if (IOTC_Session_Get_Free_Channel < 0) {
                cki.O00000Oo("CameraClient", "speak start no channle");
                return;
            }
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray(IOTC_Session_Get_Free_Channel, this.isBigOrder), 0, bArr, 0, 4);
            int sendIOCtrl = sendIOCtrl(848, bArr);
            if (sendIOCtrl < 0) {
                cki.O00000Oo("CameraClient", "speak start fail ".concat(String.valueOf(sendIOCtrl)));
            }
            cki.O00000oO("CameraClient", "speak start ".concat(String.valueOf(IOTC_Session_Get_Free_Channel)));
            this.mAVServerIndex = AVAPIs.avServStart2(this.mSessionId, null, null, 10, 0, IOTC_Session_Get_Free_Channel);
            if (this.mAVServerIndex < 0) {
                cki.O00000oO("CameraClient", "speak start fail:" + this.mAVServerIndex + " channel:" + IOTC_Session_Get_Free_Channel);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doPause() {
        if (!DeviceModelManager.getInstance().isHualaiCamera(this.mP2PInfo.getModel())) {
            sendIOCtrl(767, new byte[8]);
            sendIOCtrl(769, new byte[8]);
        }
        int i = this.mAVClientIndex;
        if (i >= 0) {
            AVAPIs.avClientCleanVideoBuf(i);
            AVAPIs.avClientCleanAudioBuf(this.mAVClientIndex);
        }
        if (this.mClientListener != null) {
            this.mClientListener.onPause();
        }
        if (this.mRNClientListener != null) {
            this.mRNClientListener.onPause();
        }
        if (this.videoBlockTimes > 0) {
            this.videoBlockTimes = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void doResume() {
        cki.O00000oo("CameraClient", "doResume ");
        this.videoBlockTimes = 0;
        if (!isConnected()) {
            this.mRetry = 0;
            this.mFirstConnect = 0;
            retryInner();
            return;
        }
        onProgress(70);
        mConnect_Start = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("videoquality", this.mQuality);
            jSONObject.put("enableaudio", 1);
            byte[] bytes = jSONObject.toString().getBytes(Charset.forName("UTF-8"));
            if (DeviceModelManager.getInstance().isHongShiCamera(this.mP2PInfo.getModel())) {
                byte[] bArr = new byte[8];
                bArr[0] = 1;
                bArr[4] = 1;
                sendIOCtrl(511, bArr);
                sendIOCtrl(768, bArr);
            } else if (!DeviceModelManager.getInstance().isHualaiCamera(this.mP2PInfo.getModel())) {
                sendIOCtrl(511, bytes);
            }
            if (DeviceModelManager.getInstance().isCameraNeedSendAudioCmd(this.mP2PInfo.getModel())) {
                cki.O00000oo("CameraClient", "open audio for DoorRing device.");
                sendIOCtrl(768, new byte[8]);
            }
        } catch (JSONException e) {
            cki.O00000oo("CameraClient", "json error:" + e.getLocalizedMessage());
        }
        onProgress(90);
        if (this.mClientListener != null) {
            this.mClientListener.onResume();
        }
        if (this.mRNClientListener != null) {
            this.mRNClientListener.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void doPlayBack(byte[] bArr) {
        if (!isConnected()) {
            try {
                doConnect();
            } catch (CameraException e) {
                e.printStackTrace();
            }
        } else if (isPaused()) {
            this.mIsPaused = false;
            sendIOCtrl(768, new byte[8]);
        }
        sendIOCtrl(61441, bArr);
    }

    /* access modifiers changed from: protected */
    public void doDirection(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", i);
            sendIOCtrl(61445, jSONObject.toString().getBytes(Charset.forName("UTF-8")));
        } catch (JSONException e) {
            cki.O00000oo("CameraClient", "JSONException:" + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onError(int i, String str) {
        super.onError(i, str);
    }

    public void getP2PInfo(List<Pair<String, String>> list) {
        if (list != null && this.mSessionId >= 0 && IOTCAPIs.IOTC_Session_Check(this.mSessionId, this.m_stSInfo) == 0) {
            list.add(new Pair("P2P_UID", new String(this.m_stSInfo.UID)));
            byte b = this.m_stSInfo.Mode;
            String[] strArr = sP2P_MODE;
            if (b < strArr.length) {
                list.add(new Pair("P2P_Mode", strArr[this.m_stSInfo.Mode]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doStopConnect() {
        if (this.mLocalSessionId >= 0) {
            IOTCAPIs.IOTC_Connect_Stop_BySID(this.mLocalSessionId);
            cki.O00000o0("CameraClient", "doStopConnect " + this.mLocalSessionId);
        }
    }

    public void sendRdtCmd(byte[] bArr, final IXmConnectionClient.XmActionCallback xmActionCallback) {
        if (!isConnected() || this.mRDTReceiveThread == null) {
            xmActionCallback.onFailed(-1, "");
            return;
        }
        this.mRDTReceiveThread.sendMessage(new P2PMessage(bArr, new P2pResponse() {
            /* class com.tutk.TuTkClient.AnonymousClass1 */

            public void onResponse(int i, byte[] bArr) {
                xmActionCallback.onSuccess(String.valueOf(i), null);
            }

            public void onError(int i) {
                xmActionCallback.onFailed(i, "");
            }
        }));
    }

    public void sendRdtCmd(byte[] bArr, boolean z, final IXmConnectionClient.XmActionCallback xmActionCallback) {
        if (!isConnected() || this.mRDTReceiveThread == null) {
            xmActionCallback.onFailed(-1, "");
            return;
        }
        this.mRDTReceiveThread.sendMessage(new P2PMessage(bArr, new P2pResponse() {
            /* class com.tutk.TuTkClient.AnonymousClass2 */

            public void onResponse(int i, byte[] bArr) {
                xmActionCallback.onSuccess(String.valueOf(i), null);
            }

            public void onError(int i) {
                xmActionCallback.onFailed(i, "");
            }
        }, z));
    }

    public void useHualaiEncrypted(boolean z) {
        this.isUseHualaiEncrypted = z;
    }

    public void setCurrentDeviceUseFixedRdtChannel(boolean z) {
        this.useFixedRdtChannel = z;
    }

    /* access modifiers changed from: package-private */
    public void cleanAudioBuff() {
        AVAPIs.avClientCleanAudioBuf(this.mAVClientIndex);
    }

    /* access modifiers changed from: package-private */
    public void cleanVideoBuff() {
        AVAPIs.avClientCleanVideoBuf(this.mAVClientIndex);
    }

    /* access modifiers changed from: package-private */
    public int onSpeakerStart() {
        if (this.mAVServerIndex >= 0) {
            return 1;
        }
        if (DeviceModelManager.getInstance().isHualaiCamera(this.mP2PInfo.getModel())) {
            int sendIOCtrl = sendIOCtrl(256, K2001_openAndCloseCameraChannelRequest(1234, 3, 1, 4));
            if (sendIOCtrl < 0) {
                cki.O00000o0("CameraClient", "speak start fail ".concat(String.valueOf(sendIOCtrl)));
            }
            cki.O00000o0("CameraClient", "speak start ".concat(String.valueOf(sendIOCtrl)));
            this.mAVServerIndex = AVAPIs.avServStart2(this.mSessionId, null, null, 10, 0, 1);
            if (this.mAVServerIndex < 0) {
                cki.O00000o0("CameraClient", "speak start fail:" + this.mAVServerIndex + " channel:" + sendIOCtrl);
            }
            return this.mAVServerIndex;
        }
        int IOTC_Session_Get_Free_Channel = IOTCAPIs.IOTC_Session_Get_Free_Channel(this.mSessionId);
        if (IOTC_Session_Get_Free_Channel < 0) {
            cki.O00000o0("CameraClient", "speak start no channel");
            return IOTC_Session_Get_Free_Channel;
        }
        byte[] bArr = new byte[8];
        System.arraycopy(Packet.intToByteArray(IOTC_Session_Get_Free_Channel, this.isBigOrder), 0, bArr, 0, 4);
        int sendIOCtrl2 = sendIOCtrl(848, bArr);
        if (sendIOCtrl2 < 0) {
            cki.O00000o0("CameraClient", "speak start fail ".concat(String.valueOf(sendIOCtrl2)));
            return sendIOCtrl2;
        }
        cki.O00000o0("CameraClient", "speak start ".concat(String.valueOf(IOTC_Session_Get_Free_Channel)));
        this.mAVServerIndex = AVAPIs.avServStart2(this.mSessionId, null, null, 10, 0, IOTC_Session_Get_Free_Channel);
        if (this.mAVServerIndex < 0) {
            cki.O00000o0("CameraClient", "speak start fail:" + this.mAVServerIndex + " channel:" + IOTC_Session_Get_Free_Channel);
        }
        return this.mAVServerIndex;
    }

    /* access modifiers changed from: package-private */
    public int onSpeakderStop() {
        if (this.mAVServerIndex >= 0) {
            if (DeviceModelManager.getInstance().isHualaiCamera(this.mP2PInfo.getModel())) {
                int sendIOCtrl = sendIOCtrl(256, K2001_openAndCloseCameraChannelRequest(1234, 3, 2, 4));
                if (sendIOCtrl < 0) {
                    cki.O00000o0("CameraClient", "hualai speak stop fail ".concat(String.valueOf(sendIOCtrl)));
                }
                cki.O00000o0("CameraClient", "hualai speak stop ".concat(String.valueOf(sendIOCtrl)));
                AVAPIs.avServStop(this.mAVServerIndex);
                this.mAVServerIndex = -1;
                return 0;
            }
            sendIOCtrl(849, null);
            AVAPIs.avServStop(this.mAVServerIndex);
            this.mAVServerIndex = -1;
        }
        return 0;
    }

    public void sendMsg(int i, int i2, byte[] bArr, P2pResponse p2pResponse) {
        RDTReceiveThread rDTReceiveThread;
        if (isConnected() && (rDTReceiveThread = this.mRDTReceiveThread) != null) {
            rDTReceiveThread.sendMessage(new P2PMessage(i, i2, bArr, p2pResponse));
        } else if (p2pResponse != null) {
            p2pResponse.onError(-1);
        }
    }

    /* access modifiers changed from: protected */
    public void doDisConnect() {
        cki.O00000o0("CameraClient", "doDisConnect " + toString());
        RDTReceiveThread rDTReceiveThread = this.mRDTReceiveThread;
        if (rDTReceiveThread != null) {
            rDTReceiveThread.stopThreadAsyn();
            this.mRDTReceiveThread = null;
        }
        RDTDataReceiveThread rDTDataReceiveThread = this.mRdtDataReceiveThread;
        if (rDTDataReceiveThread != null) {
            rDTDataReceiveThread.stopThreadAsyn();
            this.mRdtDataReceiveThread = null;
        }
        AVIOCtrlReceiveThread aVIOCtrlReceiveThread = this.mAVIOCtrlReceiveThread;
        if (aVIOCtrlReceiveThread != null) {
            aVIOCtrlReceiveThread.stopThreadAsyn();
            this.mAVIOCtrlReceiveThread = null;
        }
        AudioReceiveThread audioReceiveThread = this.mAudioReceiveThread;
        if (audioReceiveThread != null) {
            audioReceiveThread.stopThreadAsyn();
            this.mAudioReceiveThread = null;
        }
        VideoReceiveThread videoReceiveThread = this.mVideoReceiveThread;
        if (videoReceiveThread != null) {
            videoReceiveThread.stopThreadAsyn();
            this.mVideoReceiveThread = null;
        }
        int i = this.mRDTIndex;
        if (i >= 0) {
            RDTAPIs.RDT_Abort(i);
            sendIOCtrl(513, new byte[8]);
            int RDT_Destroy = RDTAPIs.RDT_Destroy(this.mRDTIndex);
            if (RDT_Destroy < 0) {
                cki.O00000o0("CameraClient", "RDT_Destroy ".concat(String.valueOf(RDT_Destroy)));
            }
            this.mRDTIndex = -1;
        }
        if (this.mAVServerIndex >= 0) {
            AVAPIs.avServStop(this.mAVServerIndex);
            AVAPIs.avServExit(this.mSessionId, this.mAVServerIndex);
            this.mAVServerIndex = -1;
        }
        int i2 = this.mAVClientIndex;
        if (i2 >= 0) {
            AVAPIs.avClientStop(i2);
            AVAPIs.avClientExit(this.mSessionId, this.mAVClientIndex);
            this.mAVClientIndex = -1;
        }
        if (this.mSessionId >= 0) {
            IOTCAPIs.IOTC_Session_Close(this.mSessionId);
            cki.O00000o0("CameraClient", "Session_Close " + this.mSessionId);
        }
    }

    public static byte[] copyByteData(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 + i > bArr.length) {
            return null;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    class AVIOCtrlReceiveThread extends CameraClient.BaseThread {
        int[] ioType = new int[1];
        byte[] recData = new byte[2048];

        AVIOCtrlReceiveThread() {
            super("AVIOCtrlReceive");
        }

        /* access modifiers changed from: protected */
        public int doRepeatWork() {
            if (TuTkClient.this.mAVClientIndex < 0) {
                cki.O00000o0("CameraClient", "TuTkClient avRecvIOCtrl mAVClientIndex < 0");
                return stopRun();
            }
            int i = TuTkClient.this.mAVClientIndex;
            int[] iArr = this.ioType;
            byte[] bArr = this.recData;
            int avRecvIOCtrl = AVAPIs.avRecvIOCtrl(i, iArr, bArr, bArr.length, 1000);
            if (avRecvIOCtrl >= 0) {
                TuTkClient.this.handleAVIOCtrl(this.ioType[0], TuTkClient.copyByteData(this.recData, 0, avRecvIOCtrl));
            } else if (avRecvIOCtrl != -20011) {
                cki.O00000o0("CameraClient", "TuTkClient avRecvIOCtrl" + TuTkClient.getErrorInfo(avRecvIOCtrl));
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (avRecvIOCtrl == -20019 || avRecvIOCtrl == -20010 || avRecvIOCtrl == -20016 || avRecvIOCtrl == -20015) {
                stopRun();
                if (TuTkClient.this.mIsPaused) {
                    TuTkClient.this.release(true, null);
                } else {
                    TuTkClient tuTkClient = TuTkClient.this;
                    tuTkClient.mRetry = 0;
                    tuTkClient.mFirstConnect = 0;
                    tuTkClient.retryInner();
                }
            }
            return 0;
        }
    }

    class AudioReceiveThread extends CameraClient.BaseThread {
        byte[] frameData = new byte[2048];
        byte[] frameInfo = new byte[TuTkClient.this.FRAME_INFO_SIZE];

        AudioReceiveThread() {
            super("AudioReceive");
        }

        public synchronized void start() {
            super.start();
            if (TuTkClient.this.mAVClientIndex > 0) {
                AVAPIs.avClientCleanAudioBuf(TuTkClient.this.mAVClientIndex);
            }
        }

        /* access modifiers changed from: protected */
        public void doRelease() {
            super.doRelease();
            this.frameData = null;
            this.frameInfo = null;
        }

        /* access modifiers changed from: protected */
        public int doRepeatWork() {
            byte[] bArr;
            boolean z;
            String str;
            if (TuTkClient.this.mAVClientIndex < 0) {
                cki.O00000o0("CameraClient", "TuTkClient avRecvAudioData mAVClientIndex < 0");
                return stopRun();
            } else if (TuTkClient.this.mIsPaused) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            } else if (DeviceModelManager.getInstance().isLvmiAQ1(TuTkClient.this.mP2PInfo.getModel()) && AVAPIs.avCheckAudioBuf(TuTkClient.this.mAVClientIndex) < 0) {
                return 0;
            } else {
                byte[] bArr2 = TuTkClient.this.mP2PInfo.mShareKey;
                if (DeviceModelManager.getInstance().isHualaiCamera(TuTkClient.this.mP2PInfo.getModel())) {
                    z = TuTkClient.this.isUseHualaiEncrypted;
                    bArr = TuTkClient.this.mP2PInfo.mHualaiShareKey;
                } else {
                    bArr = bArr2;
                    z = true;
                }
                int[] iArr = new int[1];
                AVAPIs.avCheckAudioBuf(TuTkClient.this.mAVClientIndex);
                boolean z2 = bArr == null ? false : z;
                if (TuTkClient.this.mP2PInfo.getDid() == null) {
                    str = "temp_" + TuTkClient.this.mP2PInfo.hashCode();
                } else {
                    str = TuTkClient.this.mP2PInfo.getDid();
                }
                int[] avRecvAudioData2 = AVAPIs.avRecvAudioData2(TuTkClient.this.mAVClientIndex, this.frameData, 2048, this.frameInfo, 2048, iArr, bArr, str, z2);
                if (avRecvAudioData2 == null) {
                    cki.O00000oO("CameraClient", "TuTkClient avRecvAudioData2 result is null");
                    return 0;
                }
                int i = avRecvAudioData2[0];
                if (i > 0) {
                    if (this.frameData == null) {
                        return 0;
                    }
                    if (!TuTkClient.this.mIsStartSpeaking) {
                        byte[] copyByteData = TuTkClient.copyByteData(this.frameData, avRecvAudioData2[1], i - avRecvAudioData2[1]);
                        if (TuTkClient.this.mClientListener != null) {
                            TuTkClient.this.mClientListener.onAudioData(copyByteData, this.frameInfo);
                        }
                        if (TuTkClient.this.mRNClientListener != null) {
                            byte[] bArr3 = this.frameInfo;
                            TuTkClient.this.extractAudioInfo(bArr3[2], bArr3);
                            short byteArrayToShort = Packet.byteArrayToShort(this.frameInfo, 0, TuTkClient.this.isBigOrder);
                            if (byteArrayToShort == 1) {
                                System.arraycopy(Packet.shortToByteArray(1027, false), 0, this.frameInfo, 0, 2);
                            } else if (byteArrayToShort == 140) {
                                System.arraycopy(Packet.shortToByteArray(1024, false), 0, this.frameInfo, 0, 2);
                            } else if (byteArrayToShort == 143) {
                                System.arraycopy(Packet.shortToByteArray(1027, false), 0, this.frameInfo, 0, 2);
                            } else if (byteArrayToShort == 138) {
                                System.arraycopy(Packet.shortToByteArray(1027, false), 0, this.frameInfo, 0, 2);
                            } else if (byteArrayToShort == 136) {
                                System.arraycopy(Packet.shortToByteArray(1030, false), 0, this.frameInfo, 0, 2);
                            }
                            TuTkClient.this.mRNClientListener.onAudioData(copyByteData, this.frameInfo);
                        }
                    }
                } else if (i != -20012) {
                    cki.O00000o0("CameraClient", "TuTkClient avRecvAudioData" + TuTkClient.getErrorInfo(i));
                }
                if (i == -20012) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException unused) {
                        Thread.interrupted();
                    }
                    return 0;
                } else if (i == -20010 || i == -20016 || i == -20015) {
                    return stopRun();
                } else {
                    return 0;
                }
            }
        }
    }

    public void extractAudioInfo(byte b, byte[] bArr) {
        if (b >= 0 && bArr.length >= 20) {
            System.arraycopy(Packet.intToByteArray((short) Packet.byteToInt(b, 4, 2), false), 0, bArr, 8, 4);
            System.arraycopy(Packet.shortToByteArray((short) Packet.byteToInt(b, 1, 1), false), 0, bArr, 16, 2);
            System.arraycopy(Packet.shortToByteArray((short) Packet.byteToInt(b, 1, 0), false), 0, bArr, 18, 2);
        }
    }

    class VideoReceiveThread extends CameraClient.BaseThread {
        byte[] frameInfo = new byte[TuTkClient.this.FRAME_INFO_SIZE];
        long mLastSuccessVideoFrameTime;
        int[] outFrmInfoBufSize = new int[1];
        int[] outFrmSize = new int[1];
        int[] pFrmInfoBuf = new int[1];
        long validDelayTime;
        byte[] videoBuffer = new byte[ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES];

        VideoReceiveThread() {
            super("VideoReceive");
        }

        public synchronized void start() {
            super.start();
            this.mLastSuccessVideoFrameTime = 0;
            if (TuTkClient.this.mAVClientIndex >= 0) {
                AVAPIs.avClientCleanVideoBuf(TuTkClient.this.mAVClientIndex);
            }
        }

        /* access modifiers changed from: protected */
        public void doRelease() {
            super.doRelease();
            this.frameInfo = null;
            this.videoBuffer = null;
            this.outFrmSize = null;
            this.pFrmInfoBuf = null;
            this.outFrmInfoBufSize = null;
        }

        /* access modifiers changed from: package-private */
        public int stopRun() {
            this.mLastSuccessVideoFrameTime = 0;
            return super.stopRun();
        }

        /* access modifiers changed from: protected */
        public int doRepeatWork() {
            boolean z;
            boolean z2;
            byte[] bArr;
            String str;
            if (TuTkClient.this.mAVClientIndex < 0) {
                cki.O00000o0("CameraClient", "TuTkClient videoReceive mAVClientIndex < 0");
                return stopRun();
            } else if (TuTkClient.this.mIsPaused) {
                this.mLastSuccessVideoFrameTime = 0;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            } else {
                int[] iArr = new int[1];
                byte[] bArr2 = TuTkClient.this.mP2PInfo.mShareKey;
                if (DeviceModelManager.getInstance().isHualaiCamera(TuTkClient.this.mP2PInfo.getModel())) {
                    z = TuTkClient.this.isUseHualaiEncrypted;
                    bArr2 = TuTkClient.this.mP2PInfo.mHualaiShareKey;
                } else {
                    z = true;
                }
                if (bArr2 == null) {
                    bArr = new byte[1];
                    z2 = false;
                } else {
                    bArr = bArr2;
                    z2 = z;
                }
                boolean z3 = TuTkClient.this.mP2PInfo != null && TuTkClient.this.mP2PInfo.isIPC009VideoFullEncryption;
                if (TuTkClient.this.mP2PInfo.getDid() == null) {
                    str = "temp_" + TuTkClient.this.mP2PInfo.hashCode();
                } else {
                    str = TuTkClient.this.mP2PInfo.getDid();
                }
                int[] avRecvFrameData3 = AVAPIs.avRecvFrameData3(TuTkClient.this.mAVClientIndex, this.videoBuffer, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, this.outFrmSize, this.pFrmInfoBuf, this.frameInfo, TuTkClient.this.FRAME_INFO_SIZE, this.outFrmInfoBufSize, iArr, bArr, str, z3, z2, DeviceConstant.isYunDingSpecial(TuTkClient.this.mP2PInfo.getModel()) ? 48 : 0);
                if (avRecvFrameData3 == null) {
                    cki.O00000o0("CameraClient", "TuTkClient avRecvFrameData3 result is null");
                    return 0;
                }
                int i = avRecvFrameData3[0];
                if (i > 0) {
                    byte[] copyByteData = TuTkClient.copyByteData(this.videoBuffer, avRecvFrameData3[1], i - avRecvFrameData3[1]);
                    if (i > 1048576) {
                        cki.O00000o0("CameraClient", "recv video frame too big to recv:".concat(String.valueOf(i)));
                        return 0;
                    }
                    if (!(copyByteData == null || (TuTkClient.this.mClientListener == null && TuTkClient.this.mRNClientListener == null))) {
                        short byteArrayToShort = Packet.byteArrayToShort(this.frameInfo, 0, TuTkClient.this.isBigOrder);
                        cki.O000000o("CameraClient", "avRecvFrameData code_id:%d,length:%d", Integer.valueOf(byteArrayToShort), Integer.valueOf(copyByteData.length));
                        if (byteArrayToShort == 138 || byteArrayToShort == 136 || byteArrayToShort == 1) {
                            if (TuTkClient.this.mClientListener != null) {
                                TuTkClient.this.mClientListener.onAudioData(copyByteData, this.frameInfo);
                            }
                            if (TuTkClient.this.mRNClientListener != null) {
                                byte[] bArr3 = this.frameInfo;
                                TuTkClient.this.extractAudioInfo(bArr3[2], bArr3);
                                if (byteArrayToShort == 1) {
                                    System.arraycopy(Packet.shortToByteArray(1027, false), 0, this.frameInfo, 0, 2);
                                } else if (byteArrayToShort == 138) {
                                    System.arraycopy(Packet.shortToByteArray(1027, false), 0, this.frameInfo, 0, 2);
                                } else if (byteArrayToShort == 136) {
                                    System.arraycopy(Packet.shortToByteArray(1030, false), 0, this.frameInfo, 0, 2);
                                }
                                TuTkClient.this.mRNClientListener.onAudioData(copyByteData, this.frameInfo);
                            }
                        } else {
                            this.mLastSuccessVideoFrameTime = System.currentTimeMillis();
                            if (TuTkClient.this.mClientListener != null) {
                                TuTkClient.this.mClientListener.onVideoData(copyByteData, this.frameInfo);
                            }
                            if (TuTkClient.this.mRNClientListener != null) {
                                TuTkClient.this.mRNClientListener.onVideoData(copyByteData, this.frameInfo);
                            }
                            if (TuTkClient.this.mFirstConnect != 0) {
                                long currentTimeMillis = System.currentTimeMillis() - TuTkClient.this.mFirstConnect;
                                TuTkClient.this.mFirstConnect = 0;
                                if (currentTimeMillis > 0 && currentTimeMillis < 120000) {
                                    ArrayList<Pair> arrayList = new ArrayList<>();
                                    TuTkClient.this.getP2PInfo(arrayList);
                                    for (Pair pair : arrayList) {
                                        if (((String) pair.first).equals("P2P_Mode")) {
                                            Object obj = pair.second;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return 0;
                }
                cki.O00000Oo("CameraClient", "TuTkClient VideoReceive: " + TuTkClient.getErrorInfo(i));
                if (i == -20012) {
                    long currentTimeMillis2 = this.mLastSuccessVideoFrameTime > 0 ? System.currentTimeMillis() - this.mLastSuccessVideoFrameTime : 0;
                    logAVBlock(currentTimeMillis2);
                    if (currentTimeMillis2 > DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                        cki.O00000oO("CameraClient", "logAVBlock: ");
                        AVAPIs.avClientCleanVideoBuf(TuTkClient.this.mAVClientIndex);
                        stopRun();
                        TuTkClient tuTkClient = TuTkClient.this;
                        tuTkClient.mRetry = 0;
                        tuTkClient.mFirstConnect = 0;
                        tuTkClient.retryInner();
                    }
                    try {
                        Thread.sleep(5);
                        return 0;
                    } catch (InterruptedException unused) {
                        this.mLastSuccessVideoFrameTime = 0;
                        Thread.interrupted();
                        return 0;
                    }
                } else if (i == -20010 || i == -20016 || i == -20015) {
                    return stopRun();
                } else {
                    return 0;
                }
            }
        }

        private void logAVBlock(long j) {
            long j2 = this.validDelayTime;
            if (j > j2) {
                this.validDelayTime = j;
            } else if (j2 > 3000) {
                TuTkClient.this.videoBlockTimes++;
                cki.O00000o0("CameraClient", "validDelayTime:" + this.validDelayTime);
                this.validDelayTime = 0;
            }
        }
    }

    class RDTDataReceiveThread extends CameraClient.BaseThread {
        byte[] mRecvBuf = new byte[2048];
        St_RDT_Status mSt_RDT_Status = new St_RDT_Status();

        RDTDataReceiveThread() {
            super("RDTDataReceiveThread");
        }

        /* access modifiers changed from: protected */
        public int doRepeatWork() throws InterruptedException {
            if (TuTkClient.this.mRDTIndex < 0) {
                cki.O00000o0("CameraClient", "RDT_Create:" + TuTkClient.getErrorInfo(TuTkClient.this.mRDTIndex));
                return TuTkClient.this.mRDTIndex;
            }
            int RDT_Read = RDTAPIs.RDT_Read(TuTkClient.this.mRDTIndex, this.mRecvBuf, 2048, 5000);
            if (!this.mIsRunning) {
                cki.O00000o0("CameraClient", "RDT_Read mRDTIndex < 0");
                stopRun();
                return -1;
            } else if (RDT_Read <= 0) {
                cki.O00000o0("CameraClient", "RDT_Read:" + TuTkClient.getErrorInfo(RDT_Read));
                return RDT_Read;
            } else {
                TuTkClient.this.onReceiveRdtData(TuTkClient.copyByteData(this.mRecvBuf, 0, RDT_Read));
                return 0;
            }
        }
    }

    class RDTReceiveThread extends CameraClient.BaseThread {
        public ConditionVariable mConditionVariable = new ConditionVariable();
        byte[] mRecvBuf = new byte[2048];
        St_RDT_Status mSt_RDT_Status = new St_RDT_Status();
        LinkedBlockingQueue<P2PMessage> messagePriorityQueue = new LinkedBlockingQueue<>(40);
        private int rdtParam = 10;

        RDTReceiveThread() {
            super("RDTReceive");
        }

        /* access modifiers changed from: package-private */
        public void sendMessage(P2PMessage p2PMessage) {
            if (!this.mIsRunning) {
                handleMessageError(p2PMessage, -1);
                return;
            }
            cki.O00000Oo("CameraClient", "send msg " + p2PMessage.reqId);
            if (this.messagePriorityQueue.size() >= 40) {
                cki.O00000o0("CameraClient", "send msg but full " + p2PMessage.reqId);
                p2PMessage.resp.onError(-3);
            } else if (!this.messagePriorityQueue.add(p2PMessage)) {
                handleMessageError(p2PMessage, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int stopRun() {
            int stopRun = super.stopRun();
            P2PMessage poll = this.messagePriorityQueue.poll();
            while (poll != null) {
                handleMessageError(poll, -1);
                poll = this.messagePriorityQueue.poll();
            }
            return stopRun;
        }

        /* access modifiers changed from: protected */
        public void doRelease() {
            super.doRelease();
            this.mConditionVariable.open();
            this.messagePriorityQueue.clear();
        }

        /* access modifiers changed from: protected */
        public int doRepeatWork() throws InterruptedException {
            P2PMessage take = this.messagePriorityQueue.take();
            if (!this.mIsRunning) {
                cki.O00000o0("CameraClient", "TuTkClient RDT_Read mRDTIndex < 0");
                handleMessageError(take, -1);
                return stopRun();
            }
            if (take != null) {
                if (!TuTkClient.this.isConnected()) {
                    handleMessageError(take, -1);
                    return 0;
                } else if (TuTkClient.this.mSessionId < 0) {
                    cki.O00000o0("CameraClient", "RDT mSessionId <0");
                    handleMessageError(take, TuTkClient.this.mRDTIndex);
                    return 0;
                } else if (TuTkClient.this.mRDTIndex < 0) {
                    createRDT(take);
                    return 0;
                } else {
                    handleMessage(take);
                }
            }
            return 0;
        }

        private void handleMessageError(P2PMessage p2PMessage, int i) {
            if (p2PMessage != null && p2PMessage.resp != null) {
                p2PMessage.resp.onError(i);
            }
        }

        private void checkRDTStatus() {
            if (TuTkClient.this.mRDTIndex >= 0) {
                RDTAPIs.RDT_Status_Check(TuTkClient.this.mRDTIndex, this.mSt_RDT_Status);
                if (this.mSt_RDT_Status.Timeout > this.mSt_RDT_Status.TimeoutThreshold) {
                    cki.O00000o0("CameraClient", "RDT_Check timeout abort");
                    RDTAPIs.RDT_Abort(TuTkClient.this.mRDTIndex);
                } else if (TuTkClient.this.mRDTIndex >= 0) {
                    while (this.mSt_RDT_Status.BufSizeInRecvQueue > 0) {
                        RDTAPIs.RDT_Read(TuTkClient.this.mRDTIndex, this.mRecvBuf, 2048, 5000);
                        RDTAPIs.RDT_Status_Check(TuTkClient.this.mRDTIndex, this.mSt_RDT_Status);
                        if (!this.mIsRunning) {
                            return;
                        }
                    }
                }
            }
        }

        private void createRDT(P2PMessage p2PMessage) {
            int i;
            byte[] bArr;
            final boolean[] zArr = new boolean[1];
            if (TuTkClient.this.useFixedRdtChannel) {
                i = 28;
                this.rdtParam++;
                if (this.rdtParam > 100) {
                    this.rdtParam = 20;
                }
                bArr = null;
            } else {
                i = IOTCAPIs.IOTC_Session_Get_Free_Channel(TuTkClient.this.mSessionId);
                JSONObject jSONObject = new JSONObject();
                zArr[0] = false;
                try {
                    jSONObject.put("channel", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bArr = jSONObject.toString().getBytes(Charset.forName("UTF-8"));
            }
            this.mConditionVariable.close();
            TuTkClient.this.sendIoMessage(512, bArr, new P2pResponse() {
                /* class com.tutk.TuTkClient.RDTReceiveThread.AnonymousClass1 */

                public void onResponse(int i, byte[] bArr) {
                    cki.O00000Oo("CameraClient", "RDT_Create: IO Message ".concat(String.valueOf(i)));
                    zArr[0] = true;
                    RDTReceiveThread.this.mConditionVariable.open();
                }

                public void onError(int i) {
                    cki.O00000o0("CameraClient", "RDT_Create: IO Message ".concat(String.valueOf(i)));
                    if (i == 0) {
                        zArr[0] = true;
                    }
                    RDTReceiveThread.this.mConditionVariable.open();
                }
            });
            this.mConditionVariable.block(3000);
            if (zArr[0]) {
                TuTkClient tuTkClient = TuTkClient.this;
                tuTkClient.mRDTIndex = RDTAPIs.RDT_Create(tuTkClient.mSessionId, C.MSG_CUSTOM_BASE, i);
                cki.O00000Oo("CameraClient", "RDT_Create:" + TuTkClient.this.mRDTIndex + " channel " + i);
                if (TuTkClient.this.mRDTIndex < 0) {
                    cki.O00000o0("CameraClient", "RDT_Create fail:" + TuTkClient.this.mRDTIndex);
                    handleMessageError(p2PMessage, TuTkClient.this.mRDTIndex);
                    return;
                }
                handleMessage(p2PMessage);
                return;
            }
            cki.O00000o0("CameraClient", "RDT_Create: but IO fial ");
            handleMessageError(p2PMessage, TuTkClient.this.mRDTIndex);
        }

        private void handleMessage(P2PMessage p2PMessage) {
            byte[] bArr;
            cki.O00000o0("CameraClient", "take " + p2PMessage.reqId + " isPureRdtMessage:" + p2PMessage.isPureData);
            if (TuTkClient.this.mRDTIndex < 0) {
                cki.O00000o0("CameraClient", "RDT_Create:" + TuTkClient.getErrorInfo(TuTkClient.this.mRDTIndex));
                handleMessageError(p2PMessage, TuTkClient.this.mRDTIndex);
            }
            checkRDTStatus();
            if (p2PMessage.isPureData) {
                bArr = p2PMessage.data;
            } else {
                bArr = getTLVData(p2PMessage.reqId, p2PMessage.data);
            }
            int RDT_Write = RDTAPIs.RDT_Write(TuTkClient.this.mRDTIndex, bArr, bArr.length);
            if (!this.mIsRunning) {
                cki.O00000o0("CameraClient", "TuTkClient RDT_Write mRDTIndex < 0");
                handleMessageError(p2PMessage, -1);
                stopRun();
            }
            if (RDT_Write == bArr.length) {
                receiverData(p2PMessage);
            } else if (RDT_Write > 0) {
                cki.O00000o0("CameraClient", "RDT_Write data not equal data.length");
                if (p2PMessage.resp != null) {
                    p2PMessage.resp.onError(-1);
                }
            } else {
                cki.O00000o0("CameraClient", "RDT_Write error" + TuTkClient.getErrorInfo(RDT_Write));
                if (p2PMessage.resp != null) {
                    p2PMessage.resp.onError(RDT_Write);
                }
            }
        }

        private int readData(P2PMessage p2PMessage) {
            int i = 3;
            while (TuTkClient.this.mRDTIndex >= 0) {
                int RDT_Read = RDTAPIs.RDT_Read(TuTkClient.this.mRDTIndex, this.mRecvBuf, 2048, 5000);
                if (!this.mIsRunning) {
                    cki.O00000o0("CameraClient", "RDT_Read mRDTIndex < 0");
                    handleMessageError(p2PMessage, -1);
                    stopRun();
                    return -1;
                }
                if (RDT_Read == -10007) {
                    cki.O00000o0("CameraClient", "RDT_Read timeout retry:".concat(String.valueOf(i)));
                    i--;
                    if (i == 0) {
                        RDTAPIs.RDT_Abort(TuTkClient.this.mRDTIndex);
                        TuTkClient.this.mRDTIndex = -1;
                    }
                }
                return RDT_Read;
            }
            cki.O00000o0("CameraClient", "RDT_Create:" + TuTkClient.getErrorInfo(TuTkClient.this.mRDTIndex));
            handleMessageError(p2PMessage, TuTkClient.this.mRDTIndex);
            return TuTkClient.this.mRDTIndex;
        }

        private void receiverData(P2PMessage p2PMessage) {
            if (p2PMessage.isPureData) {
                if (!(p2PMessage == null || p2PMessage.resp == null)) {
                    p2PMessage.resp.onResponse(1, null);
                }
                handlePureRdtMessage(p2PMessage);
                return;
            }
            cki.O00000Oo("CameraClient", "receiverData:" + p2PMessage.reqId);
            int readData = readData(p2PMessage);
            if (readData > 0) {
                int byteArrayToInt = Packet.byteArrayToInt(this.mRecvBuf, 0, TuTkClient.this.isBigOrder);
                cki.O00000Oo("CameraClient", "RDT_Read command:".concat(String.valueOf(byteArrayToInt)));
                if (byteArrayToInt != p2PMessage.reqId) {
                    cki.O00000oO("CameraClient", "TuTkClient RDT_Read command!=p2PMessage.resId");
                    return;
                }
                int byteArrayToInt2 = Packet.byteArrayToInt(this.mRecvBuf, 4, TuTkClient.this.isBigOrder);
                cki.O00000Oo("CameraClient", "RDT_Read length:".concat(String.valueOf(byteArrayToInt2)));
                int byteArrayToInt3 = Packet.byteArrayToInt(this.mRecvBuf, 8, TuTkClient.this.isBigOrder);
                byte[] copyByteData = TuTkClient.copyByteData(this.mRecvBuf, 12, readData - 12);
                if (byteArrayToInt3 != 0 || copyByteData == null || byteArrayToInt2 < 0) {
                    if (byteArrayToInt3 == 0) {
                        byteArrayToInt3 = -1;
                    }
                    handleMessageError(p2PMessage, byteArrayToInt3);
                } else if (byteArrayToInt2 == 0) {
                    p2PMessage.resp.onResponse(0, null);
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(2048);
                    allocate.put(copyByteData);
                    int length = copyByteData.length;
                    while (true) {
                        byteArrayToInt2 -= length;
                        while (byteArrayToInt2 > 0) {
                            int readData2 = readData(p2PMessage);
                            if (readData2 > 0) {
                                int remaining = allocate.remaining();
                                if (remaining < readData2) {
                                    byte[] copyByteData2 = TuTkClient.copyByteData(this.mRecvBuf, 0, readData2);
                                    if (copyByteData2 == null) {
                                        handleMessageError(p2PMessage, -1);
                                        return;
                                    }
                                    allocate.put(copyByteData2, 0, remaining);
                                    allocate.flip();
                                    if (p2PMessage.resp != null) {
                                        int i = byteArrayToInt2 > 0 ? byteArrayToInt2 - remaining : byteArrayToInt2;
                                        byte[] bArr = new byte[allocate.remaining()];
                                        allocate.get(bArr);
                                        p2PMessage.resp.onResponse(i, bArr);
                                        allocate.clear();
                                        allocate.put(copyByteData2, remaining, readData2 - remaining);
                                    }
                                    if (byteArrayToInt2 > 0) {
                                        length = copyByteData2.length;
                                    }
                                } else {
                                    byte[] copyByteData3 = TuTkClient.copyByteData(this.mRecvBuf, 0, readData2);
                                    if (copyByteData3 == null) {
                                        handleMessageError(p2PMessage, -1);
                                        return;
                                    }
                                    if (byteArrayToInt2 > 0) {
                                        byteArrayToInt2 -= copyByteData3.length;
                                    }
                                    allocate.put(copyByteData3);
                                }
                            } else {
                                cki.O00000o0("CameraClient", "TuTkClient RDT_Read In" + TuTkClient.getErrorInfo(readData2));
                                handleMessageError(p2PMessage, readData2);
                                return;
                            }
                        }
                        allocate.flip();
                        if (p2PMessage.resp != null) {
                            byte[] bArr2 = new byte[allocate.remaining()];
                            allocate.get(bArr2);
                            p2PMessage.resp.onResponse(0, bArr2);
                            allocate.clear();
                            return;
                        }
                        return;
                    }
                }
            } else {
                cki.O00000o0("CameraClient", "TuTkClient RDT_Read" + TuTkClient.getErrorInfo(readData));
                handleMessageError(p2PMessage, readData);
            }
        }

        private void handlePureRdtMessage(P2PMessage p2PMessage) {
            if (TuTkClient.this.mRdtDataReceiveThread == null) {
                TuTkClient tuTkClient = TuTkClient.this;
                tuTkClient.mRdtDataReceiveThread = new RDTDataReceiveThread();
                TuTkClient.this.mRdtDataReceiveThread.start();
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
    }

    public static String getErrorInfo(int i) {
        return " error:".concat(String.valueOf(i));
    }

    public void sendIoMessage(int i, byte[] bArr, P2pResponse p2pResponse) {
        if (!isConnected()) {
            cki.O00000o0("CameraClient", "send msg but  not connect");
            if (p2pResponse != null) {
                p2pResponse.onError(-2);
            }
        } else if (this.mP2PHandler == null) {
            cki.O00000o0("CameraClient", "send msg but   mP2PHandler null");
            if (p2pResponse != null) {
                p2pResponse.onError(-2);
            }
        } else {
            this.mP2PHandler.post(new Runnable(i, bArr, p2pResponse) {
                /* class com.tutk.$$Lambda$TuTkClient$u8m1zoQkl7ZqIU9tBkRk6ye81nk */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ byte[] f$2;
                private final /* synthetic */ P2pResponse f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    TuTkClient.this.lambda$sendIoMessage$2$TuTkClient(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    public /* synthetic */ void lambda$sendIoMessage$2$TuTkClient(int i, byte[] bArr, P2pResponse p2pResponse) {
        int sendIOCtrl = sendIOCtrl(i, bArr);
        if (p2pResponse != null) {
            p2pResponse.onError(sendIOCtrl);
        }
    }

    private byte[] K2001_openAndCloseCameraChannelRequest(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[6];
        bat.O000000o(bArr, 0, bat.O000000o(i), 0, 3);
        bArr[4] = (byte) i2;
        bArr[5] = (byte) i3;
        return baw.O000000o(2001, bArr, i4);
    }

    private static byte[] parseContent(short s, byte b, byte b2, byte b3, int i, boolean z) {
        byte[] bArr = new byte[16];
        System.arraycopy(Packet.shortToByteArray(s, z), 0, bArr, 0, 2);
        bArr[2] = b;
        bArr[3] = b2;
        bArr[4] = b3;
        System.arraycopy(Packet.intToByteArray(i, z), 0, bArr, 12, 4);
        return bArr;
    }

    private void doAuthorise() throws CameraException {
        cki.O00000Oo("CameraClient", "doAuthorise() called");
        byte[] syncSendIOMessage = syncSendIOMessage(256, 256, baw.O000000o(190, null, 4));
        bau bau = new bau();
        bav O000000o2 = bau.O000000o(syncSendIOMessage);
        if (O000000o2.f12756O000000o == 191) {
            byte[] handleMsg191 = handleMsg191(O000000o2);
            if (handleMsg191 != null) {
                bav O000000o3 = bau.O000000o(syncSendIOMessage(256, 256, handleMsg191));
                if (O000000o3.f12756O000000o != 193) {
                    throw new CameraException(-192, "Message 193 response is expect");
                } else if (handleMsg193(O000000o3)) {
                    cki.O00000Oo("CameraClient", "doAuthorise: succeed");
                } else {
                    throw new CameraException(-193, "handle message 193 failed, Channel verify failed");
                }
            } else {
                throw new CameraException(-191, "handle message 191 error");
            }
        } else {
            throw new CameraException(-191, "Message 191 response is expect");
        }
    }

    public void wakeUpDevice(IXmConnectionClient.XmActionCallback xmActionCallback) {
        runInP2pThread(new Runnable(xmActionCallback) {
            /* class com.tutk.$$Lambda$TuTkClient$ULbN3ZbZodUgwwG1Fs_Pn5S6s0 */
            private final /* synthetic */ IXmConnectionClient.XmActionCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                TuTkClient.this.lambda$wakeUpDevice$3$TuTkClient(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$wakeUpDevice$3$TuTkClient(IXmConnectionClient.XmActionCallback xmActionCallback) {
        int IOTC_WakeUp_WakeDevice = IOTCAPIs.IOTC_WakeUp_WakeDevice(getUid());
        if (IOTC_WakeUp_WakeDevice != 0) {
            if (xmActionCallback != null) {
                xmActionCallback.onFailed(IOTC_WakeUp_WakeDevice, "");
            }
        } else if (xmActionCallback != null) {
            xmActionCallback.onSuccess(String.valueOf(IOTC_WakeUp_WakeDevice), "");
        }
    }

    private byte[] syncSendIOMessage(int i, int i2, byte[] bArr) throws CameraException {
        int sendIOCtrl = sendIOCtrl(i, bArr);
        if (sendIOCtrl == 0) {
            int i3 = -20012;
            do {
                try {
                    Thread.sleep(200);
                    int i4 = this.mAVClientIndex;
                    int[] iArr = this.mIoType;
                    byte[] bArr2 = this.mRecDataBuff;
                    i3 = AVAPIs.avRecvIOCtrl(i4, iArr, bArr2, bArr2.length, 0);
                } catch (InterruptedException unused) {
                }
            } while (i3 == -20012);
            if (i3 < 0 || this.mIoType[0] != i2) {
                throw new CameraException(i3, "avRecvIOCtrl error");
            }
            byte[] bArr3 = new byte[i3];
            System.arraycopy(this.mRecDataBuff, 0, bArr3, 0, i3);
            return bArr3;
        }
        throw new CameraException(sendIOCtrl, "doSendIOContrl error");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0084 A[SYNTHETIC, Splitter:B:20:0x0084] */
    private byte[] handleMsg191(bav bav) {
        String str;
        cki.O00000Oo("CameraClient", "handleMsg191() called with: info = [" + bav + "]");
        byte[] bArr = bav.O00000o;
        byte[] bArr2 = null;
        if (bArr != null && bArr.length >= 17 && (bArr[0] == 1 || bArr[0] == 3)) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, 1, bArr3, 0, 16);
            String pwd = this.mP2PInfo.getPwd();
            this.mP2PInfo.getUid();
            if (DeviceModelManager.getInstance().isNeedFixedUid(this.mP2PInfo.getDid())) {
                pwd = DeviceModelManager.getInstance().getHualaiFixedEnr();
            }
            if (bArr[0] == 3) {
                if (pwd.length() >= 16) {
                    str = pwd.substring(0, 16);
                    cki.O00000Oo("CameraClient", " protocolControl 191 使用R'验证 R'=".concat(String.valueOf(str)));
                    if (!str.equals("")) {
                        try {
                            bArr2 = bat.O00000oO(bax.O000000o(bat.O00000oO(bArr3), bat.O00000oO(str.getBytes())));
                        } catch (Exception e) {
                            cki.O00000Oo("CameraClient", "handleMsg191: " + e.getLocalizedMessage());
                        }
                        byte[] k192_connectAuth = k192_connectAuth(bArr2, 4, String.valueOf(new Random(System.currentTimeMillis()).nextInt(1000)), true, true, true);
                        cki.O00000Oo("CameraClient", "protocolControl send command 192 data:" + bat.O00000o(k192_connectAuth));
                        return k192_connectAuth;
                    }
                } else {
                    cki.O00000Oo("CameraClient", " protocolControl 191 cameraSecretk <16");
                }
            }
            str = "FFFFFFFFFFFFFFFF";
            if (!str.equals("")) {
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [byte[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private byte[] k192_connectAuth(byte[] bArr, int i, String str, boolean z, boolean z2, boolean z3) {
        cki.O00000Oo("CameraClient", "k192_connectAuth:");
        if (bArr.length != 16) {
            cki.O00000oO("CameraClient", " k192_connectAuth r2 is null");
            return null;
        }
        ? r1 = new byte[23];
        if (str.length() < 4) {
            str = str + "1234";
        }
        bat.O000000o(r1, 0, bArr, 0, 15);
        bat.O000000o(r1, 16, str.getBytes(), 0, 3);
        r1[20] = z ? (byte) 1 : 0;
        r1[21] = z2 ? (byte) 1 : 0;
        r1[22] = z3 ? (byte) 1 : 0;
        cki.O00000Oo("CameraClient", " k192_connectAuth data=" + bat.O00000o(r1));
        return baw.O000000o(192, r1, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    private boolean handleMsg193(bav bav) {
        String str;
        cki.O00000Oo("CameraClient", "handleMsg193() called with: info = [" + bav + "]");
        byte[] bArr = bav.O00000o;
        if (bArr == null) {
            cki.O00000oO("CameraClient", "handleMsg193: ProtocolText is null");
            return false;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(new String(bArr)).nextValue();
            String string = jSONObject.getString("ConnectionRes");
            if (!TextUtils.isEmpty(string)) {
                if (string.equalsIgnoreCase("1")) {
                    str = jSONObject.getString("CameraInfo");
                    if (!TextUtils.isEmpty(str)) {
                        cki.O00000oO("CameraClient", "protocolControl command 193 cameraInfoString is null");
                        return false;
                    }
                    if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase("1")) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) new JSONTokener(str).nextValue();
                            jSONObject2.getString("iCameraVideoParm");
                            try {
                                JSONObject jSONObject3 = (JSONObject) new JSONTokener(jSONObject2.getString("ChannelResquestResult")).nextValue();
                                String string2 = jSONObject3.getString("controlchannelres");
                                String string3 = jSONObject3.getString("videochannelres");
                                String string4 = jSONObject3.getString("audiochannelres");
                                if ("1".equals(string2) && "1".equals(string3) && "1".equals(string4)) {
                                    cki.O00000Oo("CameraClient", "handleMsg193: CONNECT_CAMERA_SUCCESS");
                                    return true;
                                }
                            } catch (Exception e) {
                                cki.O00000oO("CameraClient", "handleMsg193: " + e.getLocalizedMessage());
                            }
                        } catch (Exception e2) {
                            cki.O00000oO("CameraClient", "handleMsg193: " + e2.getLocalizedMessage());
                        }
                    }
                    return false;
                }
            }
            str = "";
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (Exception e3) {
            cki.O00000oO("CameraClient", "handleMsg193: " + e3.getLocalizedMessage());
            return false;
        }
    }
}
