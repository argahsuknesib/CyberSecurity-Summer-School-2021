package _m_j;

import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONObject;

public final class flr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f16584O000000o = new Object();
    private static volatile flr O00000Oo;

    private flr() {
    }

    public static flr O000000o() {
        if (O00000Oo == null) {
            synchronized (f16584O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new flr();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(final Callback<Boolean> callback) {
        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/developer/check_developer").O000000o(), new fdh<NetResult, NetError>() {
            /* class _m_j.flr.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                String str;
                NetError netError = (NetError) error;
                LogType logType = LogType.NETWORK;
                StringBuilder sb = new StringBuilder("check developer execute, onFail ");
                if (netError != null) {
                    str = netError.O00000Oo;
                } else {
                    str = "result is empty!";
                }
                sb.append(str);
                gsy.O00000Oo(logType, "WhiteListApi", sb.toString());
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(Boolean.FALSE);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                LogType logType = LogType.NETWORK;
                StringBuilder sb = new StringBuilder("check developer execute, onSuccess ");
                sb.append(netResult != null ? netResult.toString() : "result is empty!");
                gsy.O00000Oo(logType, "WhiteListApi", sb.toString());
                if (netResult.f6731O000000o == 0) {
                    try {
                        boolean optBoolean = new JSONObject(netResult.O00000o0).optBoolean("result", false);
                        if (callback != null) {
                            callback.onSuccess(Boolean.valueOf(optBoolean));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(Boolean.FALSE);
                    }
                }
            }
        });
    }
}
