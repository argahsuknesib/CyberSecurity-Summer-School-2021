package com.xiaomi.smarthome.uwb.mico;

import _m_j.gsy;
import _m_j.ixe;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel$1$onNext$1", "Lcom/xiaomi/smarthome/uwb/lib/UwbRequestApi$UwbRequestCallback;", "onFailure", "", "error", "", "msg", "", "onSuccess", "result", "Lorg/json/JSONObject;", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoPlayerViewModel$1$onNext$1 extends UwbRequestApi.UwbRequestCallback {
    UwbMicoPlayerViewModel$1$onNext$1() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, org.json.JSONObject]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onSuccess(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONObject optJSONObject;
        gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", ixe.O000000o("uwb getProp onSuccess: ", (Object) jSONObject));
        Integer num = null;
        if (jSONObject == null) {
            jSONArray = null;
        } else {
            jSONArray = jSONObject.optJSONArray("result");
        }
        if (jSONArray != null) {
            jSONArray2 = jSONObject.optJSONArray("result");
        } else {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
                jSONArray3 = null;
            } else {
                jSONArray3 = optJSONObject.optJSONArray("result");
            }
            if (jSONArray3 != null) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                jSONArray2 = optJSONObject2 == null ? null : optJSONObject2.optJSONArray("result");
            } else {
                return;
            }
        }
        if (jSONArray2 != null) {
            num = Integer.valueOf(jSONArray2.length());
        }
        if (num != null && num.intValue() == 2) {
            UwbMicoPlayerManager.INSTANCE.getUwbLiveData().postValue(new BaseControl(jSONArray2.optInt(1), jSONArray2.optInt(0)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onFailure(int i, String str) {
        gsy.O000000o(LogType.LOG_UWB, "", 6, "zxtUwbMicoPlayerViewModel", ixe.O000000o("uwb getProp onFailure: ", (Object) str));
        ToastUtil.showToastDebug("uwb getProp failure " + i + ' ' + ((Object) str));
    }
}
