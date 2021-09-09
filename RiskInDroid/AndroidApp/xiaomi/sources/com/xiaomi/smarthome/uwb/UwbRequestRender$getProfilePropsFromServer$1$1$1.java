package com.xiaomi.smarthome.uwb;

import _m_j.gsy;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$getProfilePropsFromServer$1$1$1", "Lcom/xiaomi/smarthome/uwb/lib/UwbRequestApi$UwbRequestCallback;", "onFailure", "", "code", "", "msg", "", "onSuccess", "result", "Lorg/json/JSONObject;", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$getProfilePropsFromServer$1$1$1 extends UwbRequestApi.UwbRequestCallback {
    final /* synthetic */ ObservableEmitter<JSONObject> $it;
    final /* synthetic */ JSONObject $requestItem;

    UwbRequestRender$getProfilePropsFromServer$1$1$1(JSONObject jSONObject, ObservableEmitter<JSONObject> observableEmitter) {
        this.$requestItem = jSONObject;
        this.$it = observableEmitter;
    }

    public final void onSuccess(JSONObject jSONObject) {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "UwbRequestRender", "getProfilePropsFromServer onsuccess " + this.$requestItem + " result " + jSONObject);
        ObservableEmitter<JSONObject> observableEmitter = this.$it;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        observableEmitter.onNext(jSONObject);
        this.$it.onComplete();
    }

    public final void onFailure(int i, String str) {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "UwbRequestRender", "getProfilePropsFromServer onError " + this.$requestItem + ' ' + ((Object) str));
        ObservableEmitter<JSONObject> observableEmitter = this.$it;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(' ');
        sb.append((Object) str);
        observableEmitter.tryOnError(new Exception(sb.toString()));
    }
}
