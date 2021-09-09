package com.xiaomi.smarthome.uwb.api;

import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbMicoRpcPlatfrom;
import org.json.JSONObject;

public class UwbLouderSpeakerApi {
    static volatile UwbRequestApi mApi = new UwbRequestApi(CommonApplication.getAppContext());
    public static UwbConEngine.IEngineStateCallback mEngineStateCallback = new UwbConEngine.IEngineStateCallback() {
        /* class com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi.AnonymousClass1 */

        public final void onRetryKeyRetrieve() {
        }

        public final void onConnEstablished() {
            if (!UwbLouderSpeakerApi.mUwbReady) {
                UwbLogUtil.d("UwbLouderSpeakerApi", "UWBPERFORMANCE-9-mijia-card-ready:" + System.currentTimeMillis());
            }
            UwbLouderSpeakerApi.mUwbReady = true;
        }

        public final void onConnectionError(int i, String str) {
            UwbLouderSpeakerApi.mUwbReady = false;
        }

        public final void onEstablishSecurityError(int i, String str) {
            UwbLouderSpeakerApi.mUwbReady = false;
        }

        public final void onSwitchCommunication(int i, String str) {
            UwbLouderSpeakerApi.mUwbReady = false;
        }
    };
    public static volatile boolean mUwbReady = false;

    private UwbLouderSpeakerApi() {
    }

    public static boolean isUWBAvailable() {
        boolean z = UwbApi.getInstance().isEngineReady(mEngineStateCallback) && mUwbReady;
        UwbLogUtil.v("zxtUwbLouderSpeakerApi", "isUWBAvailable: ".concat(String.valueOf(z)));
        if (mApi == null) {
            synchronized (UwbLouderSpeakerApi.class) {
                if (mApi == null) {
                    mApi = new UwbRequestApi(CommonApplication.getAppContext());
                }
            }
        }
        return z;
    }

    public static void playOrPause(final boolean z) {
        try {
            mApi.request(false, new JSONObject(UwbMicoRpcPlatfrom.get().playOrPausePayload(z)), new UwbRequestApi.UwbRequestCallback() {
                /* class com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi.AnonymousClass2 */

                public final void onSuccess(JSONObject jSONObject) {
                    LogType logType = LogType.LOG_UWB;
                    StringBuilder sb = new StringBuilder("uwb ");
                    sb.append(z ? "play" : "pause");
                    sb.append(" onSuccess: ");
                    sb.append(jSONObject);
                    UwbLogUtil.writeLogOnAll(logType, "zxtUwbLouderSpeakerApi", sb.toString());
                }

                public final void onFailure(int i, String str) {
                    LogType logType = LogType.LOG_UWB;
                    StringBuilder sb = new StringBuilder("uwb ");
                    sb.append(z ? "play" : "pause");
                    sb.append(" Failure: ");
                    sb.append(str);
                    UwbLogUtil.writeLogOnAll(logType, "zxtUwbLouderSpeakerApi", sb.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setVolume(int i) {
        try {
            mApi.request(false, new JSONObject(UwbMicoRpcPlatfrom.get().setVolumePayload(i)), new UwbRequestApi.UwbRequestCallback() {
                /* class com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi.AnonymousClass3 */

                public final void onSuccess(JSONObject jSONObject) {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbLouderSpeakerApi", "uwb setVolume onSuccess: ".concat(String.valueOf(jSONObject)));
                }

                public final void onFailure(int i, String str) {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbLouderSpeakerApi", "uwb setVolume onFailure: ".concat(String.valueOf(str)));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void prev() {
        try {
            mApi.request(false, new JSONObject(UwbMicoRpcPlatfrom.get().prevPayload()), new UwbRequestApi.UwbRequestCallback() {
                /* class com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi.AnonymousClass4 */

                public final void onSuccess(JSONObject jSONObject) {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbLouderSpeakerApi", "uwb prev onSuccess: ".concat(String.valueOf(jSONObject)));
                }

                public final void onFailure(int i, String str) {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbLouderSpeakerApi", "uwb prev onFailure: ".concat(String.valueOf(str)));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void next() {
        try {
            mApi.request(false, new JSONObject(UwbMicoRpcPlatfrom.get().nextPayload()), new UwbRequestApi.UwbRequestCallback() {
                /* class com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi.AnonymousClass5 */

                public final void onSuccess(JSONObject jSONObject) {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbLouderSpeakerApi", "uwb next onSuccess: ".concat(String.valueOf(jSONObject)));
                }

                public final void onFailure(int i, String str) {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbLouderSpeakerApi", "uwb next onFailure: ".concat(String.valueOf(str)));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getProp(UwbRequestApi.UwbRequestCallback uwbRequestCallback) {
        try {
            mApi.request(false, new JSONObject(UwbMicoRpcPlatfrom.get().getPropPayload()), uwbRequestCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        mApi.destroy();
        mApi = null;
    }
}
