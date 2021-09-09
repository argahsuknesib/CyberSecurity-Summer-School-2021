package com.xiaomi.smarthome.uwb.lib;

import _m_j.gsy;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.IDMUwbDevice;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.idm.uwb.constant.UwbResultCode;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class UwbRequestApi {
    private final IDMUwb.UwbCallback mCallback = new IDMUwb.UwbCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.UwbRequestApi.AnonymousClass1 */

        public void onConnectionState(String str, UwbResultCode uwbResultCode) {
        }

        public void onEstablishSecurityLine(UwbResultCode uwbResultCode) {
        }

        public void onMiConnectConnectionState(UwbResultCode uwbResultCode) {
        }

        public void onScanState(UwbResultCode uwbResultCode) {
        }

        public void onScanning(List<IDMUwbDevice> list) {
        }

        public void onSendPayload(UwbResultCode uwbResultCode, int i) {
        }

        public void onSetServerSecurityKey(UwbResultCode uwbResultCode) {
        }

        public void onSwitchCommunicationType(UwbResultCode uwbResultCode) {
        }

        public void onTagOTA(UwbResultCode uwbResultCode, int i) {
        }

        public void onTagPluggedIn() {
        }

        public void onTagUnplugged() {
        }

        public void onPayloadReceived(String str, IDMUwb.Payload payload) {
            byte[] payload2 = payload.getPayload();
            if (payload2 == null || payload2.length <= 0 || payload2[0] != 74) {
                UwbLogUtil.d("UwbRequestApi", "UWBPERFORMANCE-16-mijia-card-response error:" + Arrays.toString(payload2));
                return;
            }
            int length = payload2.length - 1;
            while (payload2[length] == 0 && length > 0) {
                length--;
            }
            String str2 = new String(payload2, 1, length);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int optInt = jSONObject.optInt("id");
                UwbLogUtil.d("UwbRequestApi", "UWBPERFORMANCE-16-mijia-card-response:".concat(str2));
                UwbRequestApi.this.mHandler.post(new Runnable(optInt, jSONObject) {
                    /* class com.xiaomi.smarthome.uwb.lib.$$Lambda$UwbRequestApi$1$JKQu_dQs6Y98ossPJRTwMNA45E4 */
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ JSONObject f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        UwbRequestApi.AnonymousClass1.this.lambda$onPayloadReceived$0$UwbRequestApi$1(this.f$1, this.f$2);
                    }
                });
            } catch (JSONException e) {
                Log.e("UwbRequestApi", "onPayloadReceived " + Arrays.toString(payload2) + " " + length + str2, e);
            }
        }

        public /* synthetic */ void lambda$onPayloadReceived$0$UwbRequestApi$1(int i, JSONObject jSONObject) {
            UwbRequestApi.this.dispatchSuccess(i, jSONObject);
        }
    };
    private final SparseArray<UwbRequestCallback> mCallbackCache = new SparseArray<>();
    public final Handler mHandler;
    private final List<RequestEngineStateCallback> mWaiting = Collections.synchronizedList(new LinkedList());

    public UwbRequestApi(Context context) {
        this.mHandler = new Handler(new Handler.Callback(context) {
            /* class com.xiaomi.smarthome.uwb.lib.$$Lambda$UwbRequestApi$cPhqKHIQfdcq0j_kzUdmPrhp72U */
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final boolean handleMessage(Message message) {
                return UwbRequestApi.this.lambda$new$0$UwbRequestApi(this.f$1, message);
            }
        });
        UwbIdmManager.getInstance().addDelegateCallback(this.mCallback);
    }

    public /* synthetic */ boolean lambda$new$0$UwbRequestApi(Context context, Message message) {
        UwbLogUtil.d("UwbRequestApi", "dispatchFail uwb timeout id:" + message.what);
        dispatchFail(message.what, -3, context.getString(R.string.toast_failed_retry));
        return true;
    }

    public void dispatchFail(int i, int i2, String str) {
        RequestEngineStateCallback remove;
        UwbRequestCallback uwbRequestCallback = this.mCallbackCache.get(i);
        this.mCallbackCache.remove(i);
        synchronized (this.mWaiting) {
            remove = this.mWaiting.size() > 0 ? this.mWaiting.remove(0) : null;
        }
        request(true, remove);
        if (uwbRequestCallback != null) {
            uwbRequestCallback.sendFailure(i2, str);
        }
    }

    public void dispatchSuccess(int i, JSONObject jSONObject) {
        RequestEngineStateCallback remove;
        UwbRequestCallback uwbRequestCallback = this.mCallbackCache.get(i);
        this.mCallbackCache.remove(i);
        synchronized (this.mWaiting) {
            remove = this.mWaiting.size() > 0 ? this.mWaiting.remove(0) : null;
        }
        request(true, remove);
        if (uwbRequestCallback != null) {
            uwbRequestCallback.sendSuccess(jSONObject);
        }
    }

    public int request(boolean z, JSONObject jSONObject, UwbRequestCallback uwbRequestCallback) {
        return request(z, jSONObject, UwbConst.Target.SEND_DATA_TO_BOUND_DEVICE, uwbRequestCallback);
    }

    public int request(boolean z, JSONObject jSONObject, UwbConst.Target target, UwbRequestCallback uwbRequestCallback) {
        request(z, new RequestEngineStateCallback(jSONObject, target, uwbRequestCallback));
        return this.mCallbackCache.size() + this.mWaiting.size();
    }

    private void request(boolean z, RequestEngineStateCallback requestEngineStateCallback) {
        if (requestEngineStateCallback != null) {
            if (canRequest() || !z) {
                this.mCallbackCache.put(requestEngineStateCallback.id, requestEngineStateCallback.callback);
                UwbApi.getInstance().isEngineReady(requestEngineStateCallback);
                return;
            }
            UwbLogUtil.w("UwbRequestApi", "request added to waiting list wait:" + this.mWaiting.size() + " request:" + this.mCallbackCache.size());
            this.mWaiting.add(requestEngineStateCallback);
        }
    }

    private boolean canRequest() {
        return this.mCallbackCache.size() < 2;
    }

    public int getRequestingSize() {
        return this.mCallbackCache.size() + this.mWaiting.size();
    }

    public int generateNonce() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }

    public void destroy() {
        UwbIdmManager.getInstance().removeDelegateCallback(this.mCallback);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mCallbackCache.clear();
        this.mWaiting.clear();
    }

    public static abstract class UwbRequestCallback {
        private boolean response;

        public abstract void onFailure(int i, String str);

        public abstract void onSuccess(JSONObject jSONObject);

        public void sendSuccess(JSONObject jSONObject) {
            if (checkResponse()) {
                onSuccess(jSONObject);
            }
        }

        public void sendFailure(int i, String str) {
            if (checkResponse()) {
                onFailure(i, str);
            }
        }

        private synchronized boolean checkResponse() {
            if (this.response) {
                return false;
            }
            this.response = true;
            return true;
        }
    }

    class RequestEngineStateCallback implements UwbConEngine.IEngineStateCallback {
        public final UwbRequestCallback callback;
        private final JSONObject data;
        int id = UwbRequestApi.this.generateNonce();
        private final UwbConst.Target target;

        public void onRetryKeyRetrieve() {
        }

        public RequestEngineStateCallback(JSONObject jSONObject, UwbConst.Target target2, UwbRequestCallback uwbRequestCallback) {
            this.data = jSONObject;
            this.target = target2;
            this.callback = uwbRequestCallback;
        }

        public void onConnEstablished() {
            if (UwbApi.getInstance().getUwbConEngine() == null) {
                UwbRequestApi.this.dispatchFail(this.id, -1, "getUwbConEngine is null");
                return;
            }
            try {
                this.data.put("id", this.id);
            } catch (JSONException e) {
                Log.e("UwbRequestApi", "request", e);
            }
            UwbApi.getInstance().sendPayload(UwbConst.AppId.TAG, Type.JSON, this.data.toString(), this.target);
            UwbLogUtil.d("UwbRequestApi", "UWBPERFORMANCE-15-mijia-card-request:" + this.data);
            UwbRequestApi.this.mHandler.sendMessageDelayed(UwbRequestApi.this.mHandler.obtainMessage(this.id), 5000);
        }

        public void onConnectionError(int i, String str) {
            gsy.O000000o(4, "UwbRequestApi", "onConnectionError " + i + str);
            UwbRequestApi uwbRequestApi = UwbRequestApi.this;
            int i2 = this.id;
            uwbRequestApi.dispatchFail(i2, -1, Log.getStackTraceString(new Exception("onConnectionError " + i + str)));
        }

        public void onEstablishSecurityError(int i, String str) {
            gsy.O000000o(4, "UwbRequestApi", "onEstablishSecurityError " + i + str);
            UwbRequestApi uwbRequestApi = UwbRequestApi.this;
            int i2 = this.id;
            uwbRequestApi.dispatchFail(i2, -1, Log.getStackTraceString(new Exception("onEstablishSecurityError " + i + str)));
        }

        public void onSwitchCommunication(int i, String str) {
            gsy.O000000o(4, "UwbRequestApi", "onSwitchCommunication " + i + str);
        }
    }
}
