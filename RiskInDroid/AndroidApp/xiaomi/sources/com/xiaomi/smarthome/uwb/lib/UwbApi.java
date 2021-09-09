package com.xiaomi.smarthome.uwb.lib;

import android.util.Log;
import android.util.Pair;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbDataListener;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.processor.engine.IEngineSpecificKeyRetriever;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia;
import com.xiaomi.smarthome.uwb.lib.protocol.UwbDataGenerator;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class UwbApi {
    private static volatile UwbApi sInstance;
    public List<UwbConEngine.IEngineStateCallback> mCallbacks = new ArrayList();
    UwbConEngine.IEngineStateCallback mEngineCallback = new UwbConEngine.IEngineStateCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.UwbApi.AnonymousClass1 */

        public void onRetryKeyRetrieve() {
        }

        public void onConnEstablished() {
            UwbLogUtil.w("Mijia-UWB-UwbApi", "UwbLogUtilPlus onConnEstablished");
            ArrayList<UwbConEngine.IEngineStateCallback> arrayList = new ArrayList<>();
            synchronized (UwbApi.this.mCallbacks) {
                UwbApi.this.mState = 1;
                if (!UwbApi.this.mCallbacks.isEmpty()) {
                    arrayList = new ArrayList<>(UwbApi.this.mCallbacks);
                }
            }
            UwbLogUtil.d("Mijia-UWB-UwbApi", "onConnEstablished in:" + arrayList.size() + " callbacks");
            for (UwbConEngine.IEngineStateCallback iEngineStateCallback : arrayList) {
                if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                    UwbLogUtil.d("Mijia-UWB-UwbApi", "onConnEstablished will be called for ".concat(String.valueOf(iEngineStateCallback)));
                }
                try {
                    iEngineStateCallback.onConnEstablished();
                } catch (Throwable th) {
                    Log.e("Mijia-UWB-UwbApi", "onConnEstablished", th);
                }
            }
        }

        public void onConnectionError(int i, String str) {
            ArrayList<UwbConEngine.IEngineStateCallback> arrayList = new ArrayList<>();
            synchronized (UwbApi.this.mCallbacks) {
                UwbApi.this.mState = 2;
                UwbApi.this.mError = i;
                if (!UwbApi.this.mCallbacks.isEmpty()) {
                    arrayList = new ArrayList<>(UwbApi.this.mCallbacks);
                }
            }
            for (UwbConEngine.IEngineStateCallback onConnectionError : arrayList) {
                onConnectionError.onConnectionError(UwbApi.this.mError, "");
            }
        }

        public void onEstablishSecurityError(int i, String str) {
            ArrayList<UwbConEngine.IEngineStateCallback> arrayList = new ArrayList<>();
            synchronized (UwbApi.this.mCallbacks) {
                UwbApi.this.mState = 2;
                UwbApi.this.mError = i;
                if (!UwbApi.this.mCallbacks.isEmpty()) {
                    arrayList = new ArrayList<>(UwbApi.this.mCallbacks);
                }
            }
            for (UwbConEngine.IEngineStateCallback onEstablishSecurityError : arrayList) {
                onEstablishSecurityError.onEstablishSecurityError(UwbApi.this.mError, "");
            }
        }

        public void onSwitchCommunication(int i, String str) {
            ArrayList<UwbConEngine.IEngineStateCallback> arrayList = new ArrayList<>();
            synchronized (UwbApi.this.mCallbacks) {
                if (!UwbApi.this.mCallbacks.isEmpty()) {
                    arrayList = new ArrayList<>(UwbApi.this.mCallbacks);
                }
            }
            for (UwbConEngine.IEngineStateCallback onSwitchCommunication : arrayList) {
                onSwitchCommunication.onSwitchCommunication(i, str);
            }
        }
    };
    public int mError = 0;
    private Map<String, PayloadCallbackConfig> mPayloadCallbacks = new ConcurrentHashMap();
    public volatile int mState = 0;
    private UwbDataListener mUWBDataListener = new UwbDataListener() {
        /* class com.xiaomi.smarthome.uwb.lib.UwbApi.AnonymousClass2 */

        public void onConnectionState(String str, int i) {
        }

        public void onSendPayload(int i) {
        }

        public void onPayloadReceived(Payload payload) {
            UwbApi.this.checkResponsePayload(payload.getData());
        }
    };
    private volatile UwbConEngine mUwbConEngine = null;
    private long timestamp = 0;

    public interface PayloadCallback {
        void onError(int i, String str);

        void onEstablishSecurityLine(int i);

        void onPayloadReceived(JSONObject jSONObject);
    }

    private void registerPayloadCallback(PayloadCallback payloadCallback) {
    }

    private UwbApi() {
    }

    public static UwbApi getInstance() {
        if (sInstance == null) {
            synchronized (UwbApi.class) {
                if (sInstance == null) {
                    sInstance = new UwbApi();
                }
            }
        }
        return sInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0047, code lost:
        if (r5.mState != 1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        return false;
     */
    public boolean isEngineReady(UwbConEngine.IEngineStateCallback iEngineStateCallback) {
        UwbLogUtil.d("Mijia-UWB-UwbApi", "isEngineReady");
        if (iEngineStateCallback == null) {
            return this.mState == 1;
        }
        if (this.mState == 1) {
            iEngineStateCallback.onConnEstablished();
            return true;
        } else if (this.mState == 2) {
            iEngineStateCallback.onConnectionError(this.mError, "");
            return false;
        } else {
            synchronized (this.mCallbacks) {
                if (this.mState == 1) {
                    iEngineStateCallback.onConnEstablished();
                    return true;
                } else if (this.mState == 2) {
                    iEngineStateCallback.onConnectionError(this.mError, "");
                    return false;
                } else {
                    this.mCallbacks.add(iEngineStateCallback);
                }
            }
        }
    }

    public int createNewEngine(UwbScanDevice uwbScanDevice) {
        UwbLogUtil.d("Mijia-UWB-UwbApi", "createNewEngine1 in");
        return createNewEngine(uwbScanDevice, null);
    }

    public int createNewEngine(UwbScanDevice uwbScanDevice, IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever) {
        UwbLogUtil.d("Mijia-UWB-UwbApi", "createNewEngine2 in " + (System.currentTimeMillis() - this.timestamp));
        if (System.currentTimeMillis() - this.timestamp < 2000) {
            UwbLogUtil.e("Mijia-UWB-UwbApi", "too frequent to create engine");
            return -2;
        }
        this.timestamp = System.currentTimeMillis();
        this.mState = 0;
        this.mError = 0;
        UwbConEngine uwbConEngine = this.mUwbConEngine;
        if (uwbConEngine != null && !uwbConEngine.isDestroyed() && !uwbConEngine.isSameUwbAddress(uwbScanDevice)) {
            uwbConEngine.destroy(false);
        }
        UwbLogUtil.w("Mijia-UWB-UwbApi", "UwbLogUtilPlus createNewEngine MODE_MIJIA");
        this.mUwbConEngine = new UwbConnEngineMijia(uwbScanDevice, this.mEngineCallback, iEngineSpecificKeyRetriever);
        this.mUwbConEngine.setupUwb();
        return 0;
    }

    public void destroy() {
        UwbLogUtil.w("Mijia-UWB-UwbApi", "UwbLogUtilPlus destroy mUwbConEngine =null");
        UwbConEngine uwbConEngine = this.mUwbConEngine;
        this.mUwbConEngine = null;
        if (uwbConEngine != null) {
            uwbConEngine.destroy(true);
            this.mCallbacks.clear();
        }
    }

    public boolean isIdmAvailable() {
        return UwbIdmManager.getInstance().isUwbValid();
    }

    public boolean isIdmUsable() {
        return isIdmAvailable() && this.mUwbConEngine != null && this.mUwbConEngine.isUwbSetup();
    }

    public UwbScanDevice getUwbDevice() {
        return this.mUwbConEngine.getUwbDevice();
    }

    public int sendPayload(UwbConst.AppId appId, Type type, String str, UwbConst.Target target) {
        if (this.mUwbConEngine != null) {
            return this.mUwbConEngine.sendPayload(UwbDataGenerator.toPayload(appId, type, str, target));
        }
        UwbLogUtil.e("Mijia-UWB-UwbApi", "sendPayload engine is null, return -1");
        return -1;
    }

    public void switchCommunicationType() {
        if (this.mUwbConEngine != null) {
            this.mUwbConEngine.switchCommunicationType();
        }
    }

    public int sendPayload(UwbConst.AppId appId, Type type, byte[] bArr, UwbConst.Target target) {
        if (this.mUwbConEngine == null) {
            return -1;
        }
        return this.mUwbConEngine.sendPayload(new Payload(appId, type, bArr, target));
    }

    public int sendPayload(UwbConst.AppId appId, Type type, byte[] bArr, UwbConst.Target target, boolean z) {
        if (this.mUwbConEngine == null) {
            return -1;
        }
        return this.mUwbConEngine.sendPayload(new Payload(appId, type, bArr, target), z);
    }

    public void sendPayload(UwbConst.AppId appId, Type type, JSONObject jSONObject, UwbConst.Target target, PayloadCallback payloadCallback) {
        try {
            Pair<String, JSONObject> wrapWithIdHeader = UwbDataGenerator.wrapWithIdHeader(jSONObject);
            if (wrapWithIdHeader == null) {
                payloadCallback.onError(-1, "wrapWithIdHeader fail");
                return;
            }
            this.mUwbConEngine.sendPayload(UwbDataGenerator.toPayload(appId, type, ((JSONObject) wrapWithIdHeader.second).toString(), target));
            PayloadCallbackConfig payloadCallbackConfig = new PayloadCallbackConfig();
            payloadCallbackConfig.callback = payloadCallback;
            payloadCallbackConfig.startTime = System.currentTimeMillis();
            synchronized (this.mPayloadCallbacks) {
                if (this.mPayloadCallbacks.isEmpty()) {
                    UwbIdmManager.getInstance().addUWBDataListener(this.mUWBDataListener);
                }
                this.mPayloadCallbacks.put(wrapWithIdHeader.first, payloadCallbackConfig);
            }
        } catch (Exception e) {
            e.printStackTrace();
            UwbLogUtil.e("Mijia-UWB-UwbApi", "sendPayload exception:" + e.getMessage());
        }
    }

    public void establishSecurityLine(String str, int i, String str2) {
        UwbLogUtil.w("Mijia-UWB-UwbApi", "UwbLogUtilPlus establishSecurityLine: " + str + " uid: " + str2 + " type: " + i);
        try {
            this.mUwbConEngine.establishSecurityLine(str, i, str2);
        } catch (Exception e) {
            e.printStackTrace();
            UwbLogUtil.e("Mijia-UWB-UwbApi", "sendPayload exception:" + e.getMessage());
        }
    }

    public void checkResponsePayload(byte[] bArr) {
        PayloadCallbackConfig remove;
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null && optJSONObject.has("id")) {
                String string = optJSONObject.getString("id");
                synchronized (this.mPayloadCallbacks) {
                    remove = this.mPayloadCallbacks.remove(string);
                    if (this.mPayloadCallbacks.isEmpty()) {
                        UwbIdmManager.getInstance().removeUWBDataListener(this.mUWBDataListener);
                    }
                }
                if (remove == null) {
                    return;
                }
                if (remove.callback != null) {
                    remove.callback.onPayloadReceived(jSONObject.optJSONObject("data"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UwbConEngine getUwbConEngine() {
        return this.mUwbConEngine;
    }

    static class PayloadCallbackConfig {
        PayloadCallback callback;
        long startTime;

        private PayloadCallbackConfig() {
        }
    }
}
