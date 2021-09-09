package com.xiaomi.smarthome.uwb.mico;

import _m_j.fdh;
import _m_j.gsy;
import _m_j.ixe;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.library.log.LogType;
import kotlin.Metadata;
import org.json.JSONObject;
import retrofit2.Response;
import rx.Subscriber;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoPlayerManager$getUwbRemoteObservable$1$1", "Lcom/xiaomi/smarthome/core/server/internal/NetCallback;", "Lcom/xiaomi/smarthome/core/entity/net/NetResult;", "Lcom/xiaomi/smarthome/core/entity/net/NetError;", "onCache", "", "result", "onFailure", "error", "onSuccess", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoPlayerManager$getUwbRemoteObservable$1$1 implements fdh<NetResult, NetError> {
    final /* synthetic */ Subscriber<? super Response<MinaResponse<Remote.Response>>> $subscriber;

    public final void onCache(NetResult netResult) {
        ixe.O00000o(netResult, "result");
    }

    UwbMicoPlayerManager$getUwbRemoteObservable$1$1(Subscriber<? super Response<MinaResponse<Remote.Response>>> subscriber) {
        this.$subscriber = subscriber;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, org.json.JSONObject]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onSuccess(NetResult netResult) {
        ixe.O00000o(netResult, "result");
        try {
            JSONObject jSONObject = new JSONObject(netResult.O00000o0);
            gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtUwbMicoPlayerManager", ixe.O000000o("ubus ", (Object) jSONObject));
            MinaResponse minaResponse = new MinaResponse();
            minaResponse.data = Remote.sGson.fromJson(jSONObject.optString("result"), Remote.Response.class);
            Response success = Response.success(minaResponse);
            if (!this.$subscriber.isUnsubscribed()) {
                this.$subscriber.onNext(success);
                this.$subscriber.onCompleted();
            }
        } catch (Exception e) {
            gsy.O000000o(LogType.LOG_UWB, "", 6, "zxtUwbMicoPlayerManager", ixe.O000000o("ubus error", (Object) netResult.O00000o0));
            e.printStackTrace();
        }
    }

    public final void onFailure(NetError netError) {
        ixe.O00000o(netError, "error");
        if (!this.$subscriber.isUnsubscribed()) {
            this.$subscriber.onError(ApiError.generateError(netError.f6718O000000o, netError.O00000Oo).toThrowable());
        }
    }
}
