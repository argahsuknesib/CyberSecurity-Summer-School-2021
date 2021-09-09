package com.tutk;

import _m_j.cki;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.xiaomi.smarthome.camera.ICameraPlayerListener;
import com.xiaomi.smarthome.camera.IClientListener;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.MissConfig;
import com.xiaomi.smarthome.camera.P2pResponse;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CameraClient implements IXmConnectionClient, XmCameraP2p {
    static HashMap<String, CameraClient> sCacheCameraClientMap = new HashMap<>();
    private static int sClinetId;
    public int ThreadIndex;
    volatile boolean isBigOrder;
    public boolean isCanRelease;
    IClientListener mClientListener;
    volatile int mClientStatus;
    long mFirstConnect;
    volatile boolean mIsPaused;
    volatile boolean mIsStartSpeaking;
    private Handler mMainHandler;
    Handler mP2PHandler;
    private HandlerThread mP2PHandlerThread;
    int mPwdTry;
    ICameraPlayerListener mRNClientListener;
    int mRetry;
    boolean mUsrExpPlanEnabled;
    volatile boolean pwdChange;
    private Runnable releaseCallBack;

    /* access modifiers changed from: package-private */
    public abstract void cleanAudioBuff();

    /* access modifiers changed from: package-private */
    public abstract void cleanVideoBuff();

    /* access modifiers changed from: protected */
    public abstract void doConnect() throws CameraException;

    /* access modifiers changed from: protected */
    public abstract void doDirection(int i);

    /* access modifiers changed from: protected */
    public abstract void doDisConnect();

    /* access modifiers changed from: protected */
    public abstract void doPause();

    /* access modifiers changed from: protected */
    public abstract void doPlayBack(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void doResume();

    /* access modifiers changed from: protected */
    public abstract void doSendAudioData(byte[] bArr, int i);

    /* access modifiers changed from: protected */
    public abstract void doStopConnect();

    public abstract void getP2PInfo(List<Pair<String, String>> list);

    public abstract String getUid();

    /* access modifiers changed from: package-private */
    public abstract int onSpeakderStop();

    /* access modifiers changed from: package-private */
    public abstract int onSpeakerStart();

    public abstract void sendMsg(int i, int i2, byte[] bArr, P2pResponse p2pResponse);

    public abstract void sendRdtCmd(byte[] bArr, IXmConnectionClient.XmActionCallback xmActionCallback);

    public abstract void sendRdtCmd(byte[] bArr, boolean z, IXmConnectionClient.XmActionCallback xmActionCallback);

    public void setAutoVideo(boolean z) {
    }

    public void setCallStatus(boolean z) {
    }

    public static synchronized void releaseCache(String str) {
        synchronized (CameraClient.class) {
            sCacheCameraClientMap.remove(str);
        }
    }

    CameraClient(XmP2PInfo xmP2PInfo) {
        this.ThreadIndex = 1;
        this.mClientStatus = -1;
        this.isCanRelease = true;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mIsPaused = false;
        this.pwdChange = false;
        this.isBigOrder = false;
        this.mIsStartSpeaking = false;
        this.mFirstConnect = 0;
        this.mUsrExpPlanEnabled = false;
        this.mRetry = 0;
        this.mPwdTry = 0;
        this.releaseCallBack = new Runnable() {
            /* class com.tutk.CameraClient.AnonymousClass1 */

            public void run() {
                if (CameraClient.this.isCanRelease) {
                    CameraClient cameraClient = CameraClient.this;
                    cameraClient.mClientStatus = 0;
                    cameraClient.doStopConnect();
                    CameraClient.releaseCache(CameraClient.this.getUid());
                    CameraClient.this.clearHandleMessages();
                    CameraClient.this.sendEmptyMessage(2);
                    CameraClient.this.sendEmptyMessage(5);
                    CameraClient.this.mClientListener = null;
                    cki.O00000o("CameraClient", "release success " + toString());
                    return;
                }
                cki.O00000oO("CameraClient", "release fail " + toString());
            }
        };
        this.mPwdTry = 3;
    }

    /* access modifiers changed from: package-private */
    public void onConnected() {
        IClientListener iClientListener = this.mClientListener;
        if (iClientListener != null) {
            iClientListener.onConnected();
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onConnected();
        }
    }

    /* access modifiers changed from: package-private */
    public void onReceiveRdtData(byte[] bArr) {
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onRdtDataReceived(bArr);
        }
    }

    private void onDisConnected() {
        this.mMainHandler.post(new Runnable() {
            /* class com.tutk.$$Lambda$CameraClient$rKBMqul2wIuuI5l1dsdE949u0QI */

            public final void run() {
                CameraClient.this.lambda$onDisConnected$0$CameraClient();
            }
        });
    }

    public /* synthetic */ void lambda$onDisConnected$0$CameraClient() {
        IClientListener iClientListener = this.mClientListener;
        if (iClientListener != null) {
            iClientListener.onDisConnected();
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onDisConnected();
        }
    }

    /* access modifiers changed from: package-private */
    public void onProgress(int i) {
        this.mMainHandler.post(new Runnable(i) {
            /* class com.tutk.$$Lambda$CameraClient$OwHS0F0HyAksQl__LmYgJMtnGMQ */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CameraClient.this.lambda$onProgress$1$CameraClient(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onProgress$1$CameraClient(int i) {
        IClientListener iClientListener = this.mClientListener;
        if (iClientListener != null) {
            iClientListener.onProgress(i);
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onProgress(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onError(int i, String str) {
        StringBuilder sb = new StringBuilder("onError ");
        sb.append(i);
        sb.append(" :");
        String str2 = " ";
        sb.append(str == null ? str2 : str);
        cki.O00000oO("CameraClient", sb.toString());
        StringBuilder sb2 = new StringBuilder("tutk onError ");
        sb2.append(i);
        sb2.append(" :");
        if (str != null) {
            str2 = str;
        }
        sb2.append(str2);
        cki.O0000OOo("2000.1.4", sb2.toString());
        this.mFirstConnect = 0;
        this.mMainHandler.post(new Runnable(i, str) {
            /* class com.tutk.$$Lambda$CameraClient$tVlHimbw2LAnBbZseBVNNHloGc */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CameraClient.this.lambda$onError$2$CameraClient(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onError$2$CameraClient(int i, String str) {
        IClientListener iClientListener = this.mClientListener;
        if (iClientListener != null) {
            iClientListener.onError(i, str);
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onError(i, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void onRetry(int i, String str) {
        StringBuilder sb = new StringBuilder("onRetry ");
        sb.append(i);
        sb.append(" :");
        sb.append(str == null ? " " : str);
        cki.O00000o("CameraClient", sb.toString());
        this.mMainHandler.post(new Runnable(i, str) {
            /* class com.tutk.$$Lambda$CameraClient$yEx96kCTRGVoqElzsvO0T01e5e4 */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CameraClient.this.lambda$onRetry$3$CameraClient(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$onRetry$3$CameraClient(int i, String str) {
        IClientListener iClientListener = this.mClientListener;
        if (iClientListener != null) {
            iClientListener.onRetry(i, str, this.mRetry);
        }
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onRetry(i, str, this.mRetry);
        }
    }

    public void connectInner() throws CameraException {
        if (this.mClientStatus != 1) {
            doConnect();
        }
    }

    public void disConnectInner() {
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.removeMessages(6);
        }
        if (this.mClientStatus != -1) {
            doDisConnect();
            this.mClientStatus = -1;
            onDisConnected();
        }
    }

    class P2PHandler extends Handler {
        P2PHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                int i2 = message.arg1;
                if (i2 > 0) {
                    CameraClient.this.doDirection(i2);
                } else {
                    CameraClient.this.mP2PHandler.removeMessages(1);
                }
            } else if (i == 2) {
                CameraClient.this.disConnectInner();
            } else if (i != 3) {
                byte[] bArr = null;
                if (i == 5) {
                    CameraClient.this.releaseP2PThread();
                } else if (i != 11) {
                    if (i == 7) {
                        if (message.obj != null) {
                            bArr = (byte[]) message.obj;
                        }
                        if (bArr == null) {
                            CameraClient.this.doResume();
                            return;
                        } else {
                            CameraClient.this.doPlayBack(bArr);
                            return;
                        }
                    } else if (i == 8) {
                        CameraClient.this.doPause();
                        return;
                    } else if (i == 9) {
                        CameraClient.this.doResume();
                        return;
                    } else {
                        return;
                    }
                }
                int i3 = message.arg1;
                if (message.obj != null) {
                    bArr = (byte[]) message.obj;
                }
                CameraClient.this.sendIOCtrl(i3, bArr);
            } else {
                try {
                    CameraClient.this.connectInner();
                } catch (CameraException e) {
                    cki.O00000o0("CameraClient", "MSG_CONNECT", e);
                    CameraClient.this.disConnectInner();
                    CameraClient.this.onError(e.getError(), e.getMessage());
                }
            }
        }
    }

    private synchronized void initialP2PThread() {
        if (this.mP2PHandlerThread == null) {
            sClinetId++;
            this.mP2PHandlerThread = new HandlerThread("P2PClient_" + sClinetId);
            this.mP2PHandlerThread.start();
            this.mP2PHandler = new P2PHandler(this.mP2PHandlerThread.getLooper());
        }
    }

    public synchronized void releaseP2PThread() {
        if (this.mP2PHandlerThread != null) {
            cki.O00000oO("CameraClient", "releaseP2PThread");
            clearHandleMessages();
            this.mP2PHandlerThread.quit();
            this.mP2PHandlerThread = null;
            this.mP2PHandler = null;
        }
    }

    public void setClientListener(IClientListener iClientListener) {
        this.mClientListener = iClientListener;
    }

    public synchronized boolean isConnected() {
        return this.mClientStatus > 0;
    }

    public void release(boolean z, IClientListener iClientListener) {
        if (iClientListener != null) {
            if (iClientListener != this.mClientListener) {
                cki.O00000oO("CameraClient", "release but listener error");
                return;
            } else {
                this.mClientListener = null;
                cki.O00000o("CameraClient", "release and rest listener");
            }
        }
        this.isCanRelease = true;
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.removeCallbacks(this.releaseCallBack);
        }
        if (!z || !isConnected()) {
            cki.O00000o("CameraClient", "release now " + toString());
            this.mClientStatus = 0;
            Handler handler2 = this.mP2PHandler;
            if (handler2 != null) {
                handler2.post(this.releaseCallBack);
                return;
            }
            return;
        }
        cki.O00000o("CameraClient", "release " + toString());
        Handler handler3 = this.mP2PHandler;
        if (handler3 != null) {
            handler3.postDelayed(this.releaseCallBack, 10000);
        }
    }

    public void reconnect() {
        cki.O00000o("CameraClient", "reconnect");
        this.mRetry = 3;
        this.mFirstConnect = System.currentTimeMillis();
        doStopConnect();
        releaseP2PThread();
        initialP2PThread();
        sendEmptyMessage(2);
        sendEmptyMessage(3);
        onProgress(0);
    }

    /* access modifiers changed from: package-private */
    public void retryInner() {
        doStopConnect();
        releaseP2PThread();
        initialP2PThread();
        sendEmptyMessage(2);
        sendEmptyMessage(3);
        onProgress(0);
    }

    public void pause(IClientListener iClientListener) {
        IClientListener iClientListener2 = this.mClientListener;
        if (iClientListener2 == null || (iClientListener != null && iClientListener == iClientListener2)) {
            cki.O00000o("CameraClient", "pause");
            this.mIsPaused = true;
            if (this.mP2PHandler != null && isConnected()) {
                this.mP2PHandler.sendEmptyMessage(8);
                return;
            }
            return;
        }
        cki.O00000oO("CameraClient", "pause but listener error");
    }

    public void pauseRN(ICameraPlayerListener iCameraPlayerListener) {
        ICameraPlayerListener iCameraPlayerListener2 = this.mRNClientListener;
        if (iCameraPlayerListener2 == null || (iCameraPlayerListener != null && iCameraPlayerListener == iCameraPlayerListener2)) {
            cki.O00000o("CameraClient", "pause");
            this.mIsPaused = true;
            if (this.mP2PHandler != null && isConnected()) {
                this.mP2PHandler.sendEmptyMessage(8);
                return;
            }
            return;
        }
        cki.O00000oO("CameraClient", "pause but listener error");
    }

    public void releaseRN(boolean z, ICameraPlayerListener iCameraPlayerListener) {
        releaseRN(z, iCameraPlayerListener, iCameraPlayerListener != null);
    }

    public void releaseRN(boolean z, ICameraPlayerListener iCameraPlayerListener, boolean z2) {
        if (z2) {
            if (iCameraPlayerListener != this.mRNClientListener) {
                cki.O00000oO("CameraClient", "release but listener error");
                return;
            } else {
                this.mRNClientListener = null;
                cki.O00000o("CameraClient", "release and rest listener");
            }
        }
        this.isCanRelease = true;
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.removeCallbacks(this.releaseCallBack);
        }
        if (!z || !isConnected()) {
            cki.O00000o("CameraClient", "release now " + toString());
            this.mClientStatus = 0;
            Handler handler2 = this.mP2PHandler;
            if (handler2 != null) {
                handler2.post(this.releaseCallBack);
                return;
            }
            return;
        }
        cki.O00000o("CameraClient", "release " + toString());
        Handler handler3 = this.mP2PHandler;
        if (handler3 != null) {
            handler3.postDelayed(this.releaseCallBack, 10000);
        }
    }

    public boolean resume() {
        this.mIsPaused = false;
        if (this.mP2PHandler == null || !isConnected()) {
            cki.O00000o("CameraClient", "resume and connect ");
            connect();
            return false;
        }
        this.mP2PHandler.sendEmptyMessage(9);
        return true;
    }

    public void connect() {
        cki.O00000o("CameraClient", "connect");
        this.isCanRelease = false;
        this.mIsPaused = false;
        this.mRetry = 3;
        if (!isConnected()) {
            cki.O00000o("CameraClient", "not connect");
            this.mFirstConnect = System.currentTimeMillis();
            releaseP2PThread();
            initialP2PThread();
            clearHandleMessages();
            sendEmptyMessage(3);
            onProgress(0);
        } else if (this.pwdChange) {
            this.mFirstConnect = System.currentTimeMillis();
            releaseP2PThread();
            initialP2PThread();
            sendEmptyMessage(2);
            sendEmptyMessage(3);
            onProgress(0);
            cki.O00000o("CameraClient", "pwd change need retry");
        } else {
            cki.O00000o("CameraClient", "pwd change not change");
            IClientListener iClientListener = this.mClientListener;
            if (iClientListener != null) {
                iClientListener.onConnected();
            }
            ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
            if (iCameraPlayerListener != null) {
                iCameraPlayerListener.onConnected();
            }
            onProgress(90);
            sendEmptyMessage(9);
        }
    }

    public void playBack(byte[] bArr) {
        cki.O00000o("CameraClient", "playBack ");
        if (this.mP2PHandler != null) {
            if (!isConnected()) {
                initialP2PThread();
                clearHandleMessages();
                sendEmptyMessage(3);
            }
            this.mP2PHandler.removeMessages(7);
            this.mP2PHandler.obtainMessage(7, bArr).sendToTarget();
        }
    }

    public void direction(byte[] bArr) {
        cki.O00000o("CameraClient", "direction ");
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1, null);
            try {
                obtainMessage.arg1 = new JSONObject(new String(bArr)).getInt("operation");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mP2PHandler.sendMessage(obtainMessage);
        }
    }

    public void startSpeak() {
        this.mIsStartSpeaking = true;
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                /* class com.tutk.$$Lambda$CameraClient$9p_sHWvSdceTt1MmF8JA1yeO08 */

                public final void run() {
                    CameraClient.this.lambda$startSpeak$4$CameraClient();
                }
            });
        }
    }

    public /* synthetic */ void lambda$startSpeak$4$CameraClient() {
        sendIOCtrl(769, new byte[8]);
    }

    public void stopSpeak() {
        this.mIsStartSpeaking = false;
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                /* class com.tutk.$$Lambda$CameraClient$oy4FdNyNDuOgruZTNCJ8l57EuQs */

                public final void run() {
                    CameraClient.this.lambda$stopSpeak$5$CameraClient();
                }
            }, 250);
        }
    }

    public /* synthetic */ void lambda$stopSpeak$5$CameraClient() {
        if (!this.mIsStartSpeaking) {
            sendIOCtrl(768, new byte[8]);
        }
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public void sendAudioData(byte[] bArr, int i) {
        doSendAudioData(bArr, i);
    }

    /* access modifiers changed from: protected */
    public void sendEmptyMessage(int i) {
        cki.O00000o("CameraClient", "sendEmptyMessage ".concat(String.valueOf(i)));
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.sendEmptyMessage(i);
        }
    }

    public void clearHandleMessages() {
        Handler handler;
        cki.O00000o("CameraClient", "clearHandleMessages");
        for (int i = 0; i < 10 && (handler = this.mP2PHandler) != null; i++) {
            handler.removeMessages(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleAVIOCtrl(int i, byte[] bArr) {
        if (this.mClientListener != null) {
            this.mMainHandler.post(new Runnable(i, bArr) {
                /* class com.tutk.$$Lambda$CameraClient$DcPu_IFZeXSL9CL07HkdNGePWAw */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ byte[] f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CameraClient.this.lambda$handleAVIOCtrl$6$CameraClient(this.f$1, this.f$2);
                }
            });
        }
        if (this.mRNClientListener != null) {
            if (i == 61442) {
                i = 270;
            } else if (i == 61446) {
                i = 275;
            }
            this.mMainHandler.post(new Runnable(i, bArr) {
                /* class com.tutk.$$Lambda$CameraClient$9nS8ZinxUmHjf8Ce8eUTkzKmjWA */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ byte[] f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    CameraClient.this.lambda$handleAVIOCtrl$7$CameraClient(this.f$1, this.f$2);
                }
            });
        }
    }

    public /* synthetic */ void lambda$handleAVIOCtrl$6$CameraClient(int i, byte[] bArr) {
        cki.O00000o("CameraClient", "handleAVIOCtrl:".concat(String.valueOf(i)));
        IClientListener iClientListener = this.mClientListener;
        if (iClientListener != null) {
            iClientListener.onCtrlData(i, bArr);
        }
    }

    public /* synthetic */ void lambda$handleAVIOCtrl$7$CameraClient(int i, byte[] bArr) {
        cki.O00000o("CameraClient", "handleAVIOCtrl:".concat(String.valueOf(i)));
        ICameraPlayerListener iCameraPlayerListener = this.mRNClientListener;
        if (iCameraPlayerListener != null) {
            iCameraPlayerListener.onCtrlData(i, bArr);
        }
    }

    public void runInP2pThread(Runnable runnable) {
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    abstract class BaseThread extends WorkThread {
        BaseThread(String str) {
            super(str + ":" + CameraClient.this.ThreadIndex);
            CameraClient.this.ThreadIndex = CameraClient.this.ThreadIndex + 1;
        }

        /* access modifiers changed from: protected */
        public void doInitial() {
            cki.O00000o("CameraClient", "doInitial " + getName());
        }

        /* access modifiers changed from: protected */
        public void doRelease() {
            cki.O00000o("CameraClient", "doRelease " + getName());
        }

        /* access modifiers changed from: package-private */
        public int stopRun() {
            this.mIsRunning = false;
            return 0;
        }
    }

    public void playBackSpeed(byte[] bArr) {
        Handler handler = this.mP2PHandler;
        if (handler != null) {
            handler.post(new Runnable(bArr) {
                /* class com.tutk.$$Lambda$CameraClient$seVkwMNcwPz466sAjCEZUkblKLQ */
                private final /* synthetic */ byte[] f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraClient.this.lambda$playBackSpeed$8$CameraClient(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$playBackSpeed$8$CameraClient(byte[] bArr) {
        sendIOCtrl(61443, bArr);
    }

    public void setStreamClient(ICameraPlayerListener iCameraPlayerListener) {
        this.mRNClientListener = iCameraPlayerListener;
    }

    public void startConnect(int i, IXmConnectionClient.XmActionCallback xmActionCallback) {
        startConnect(xmActionCallback);
    }

    public void startConnect(IXmConnectionClient.XmActionCallback xmActionCallback, MissConfig missConfig) {
        startConnect(xmActionCallback);
    }

    public void startConnect(IXmConnectionClient.XmActionCallback xmActionCallback) {
        if (xmActionCallback != null) {
            xmActionCallback.onSuccess("1", null);
        }
        connect();
    }

    public void sendP2pCmd(int i, String str, IXmConnectionClient.XmActionCallback xmActionCallback) {
        handleP2pCmd(i, str.getBytes(), xmActionCallback);
    }

    public void sendP2pCmd(int i, byte[] bArr, IXmConnectionClient.XmActionCallback xmActionCallback) {
        handleP2pCmd(i, bArr, xmActionCallback);
    }

    public void handleP2pCmd(int i, byte[] bArr, IXmConnectionClient.XmActionCallback xmActionCallback) {
        if (i == 258) {
            i = 511;
        } else if (i == 259) {
            i = 767;
        } else if (i == 260) {
            i = 768;
        } else if (i == 261) {
            i = 769;
        } else if (i == 262) {
            i = 848;
        } else if (i == 264) {
            i = 849;
        } else if (i == 265) {
            i = 800;
        } else if (i == 269) {
            i = 61441;
        } else if (i == 271) {
            i = 61443;
        } else if (i == 274) {
            i = 61445;
        }
        runInP2pThread(new Runnable(i, xmActionCallback, bArr) {
            /* class com.tutk.$$Lambda$CameraClient$czN7EMivwLrd1xF6743T4PoUZOc */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ IXmConnectionClient.XmActionCallback f$2;
            private final /* synthetic */ byte[] f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                CameraClient.this.lambda$handleP2pCmd$9$CameraClient(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public /* synthetic */ void lambda$handleP2pCmd$9$CameraClient(int i, IXmConnectionClient.XmActionCallback xmActionCallback, byte[] bArr) {
        if (i == 767) {
            cleanVideoBuff();
        } else if (i == 769) {
            cleanAudioBuff();
        } else if (i == 848) {
            if (xmActionCallback != null) {
                xmActionCallback.onSuccess("1", null);
            }
            byte[] bArr2 = new byte[1];
            bArr2[0] = onSpeakerStart() >= 0 ? (byte) 48 : -1;
            handleAVIOCtrl(263, bArr2);
            return;
        } else if (i == 849) {
            onSpeakderStop();
            if (xmActionCallback != null) {
                xmActionCallback.onSuccess("1", null);
                return;
            }
            return;
        }
        int sendIOCtrl = sendIOCtrl(i, bArr);
        if (sendIOCtrl >= 0) {
            if (xmActionCallback != null) {
                xmActionCallback.onSuccess(String.valueOf(sendIOCtrl), null);
            }
        } else if (xmActionCallback != null) {
            xmActionCallback.onFailed(sendIOCtrl, "send p2p cmd failed");
            cki.O0000OOo("2000.1.3", "tutk:" + i + ":" + sendIOCtrl + ":send p2p cmd failed");
        }
    }
}
