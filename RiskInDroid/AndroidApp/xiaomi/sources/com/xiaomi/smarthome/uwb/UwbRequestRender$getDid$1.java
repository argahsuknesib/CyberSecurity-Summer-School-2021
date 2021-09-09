package com.xiaomi.smarthome.uwb;

import _m_j.ixe;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$getDid$1", "Lcom/xiaomi/smarthome/uwb/lib/UwbRequestApi$UwbRequestCallback;", "onFailure", "", "error", "", "msg", "", "onSuccess", "result", "Lorg/json/JSONObject;", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$getDid$1 extends UwbRequestApi.UwbRequestCallback {
    final /* synthetic */ Device $device;
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$getDid$1(Device device, UwbRequestRender<C, E, T> uwbRequestRender) {
        this.$device = device;
        this.this$0 = uwbRequestRender;
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
        JSONObject optJSONObject;
        String str = null;
        if (!(jSONObject == null || (optJSONObject = jSONObject.optJSONObject("p")) == null)) {
            str = optJSONObject.optString("did");
        }
        Device baseDevice = ((UwbDevice) this.$device).getBaseDevice();
        if (baseDevice != null) {
            baseDevice.did = str;
        }
        ((UwbDevice) this.$device).did = str;
        List<Runnable> list = this.this$0.mGetDidRequest.get(((UwbDevice) this.$device).getUwbDevice());
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
        }
        this.this$0.mGetDidRequest.remove(((UwbDevice) this.$device).getUwbDevice());
        UwbLogUtil.d("UwbRequestRender", ixe.O000000o("onSuccess getDid ", (Object) jSONObject));
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
        List<Runnable> list = this.this$0.mGetDidRequest.get(((UwbDevice) this.$device).getUwbDevice());
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
        }
        this.this$0.mGetDidRequest.remove(((UwbDevice) this.$device).getUwbDevice());
        UwbLogUtil.d("UwbRequestRender", ixe.O000000o("onFailure getDid ", (Object) str));
    }
}
