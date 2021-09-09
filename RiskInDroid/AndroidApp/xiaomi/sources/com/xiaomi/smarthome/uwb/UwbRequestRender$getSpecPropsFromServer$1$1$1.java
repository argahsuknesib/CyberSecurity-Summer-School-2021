package com.xiaomi.smarthome.uwb;

import _m_j.gsy;
import com.xiaomi.miot.localtranslatesrv.LocalTranslateManager;
import com.xiaomi.miot.localtranslatesrv.core.ProfileProperty;
import com.xiaomi.miot.localtranslatesrv.core.SpecProperty;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.translateStatus;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$getSpecPropsFromServer$1$1$1", "Lcom/xiaomi/smarthome/uwb/lib/UwbRequestApi$UwbRequestCallback;", "onFailure", "", "code", "", "msg", "", "onSuccess", "payload", "Lorg/json/JSONObject;", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$getSpecPropsFromServer$1$1$1 extends UwbRequestApi.UwbRequestCallback {
    final /* synthetic */ Device $device;
    final /* synthetic */ ObservableEmitter<PropertyParam> $it;
    final /* synthetic */ PropertyParam $itemParam;
    final /* synthetic */ ProfileProperty $profileProperty;
    final /* synthetic */ JSONObject $requestItem;
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$getSpecPropsFromServer$1$1$1(ProfileProperty profileProperty, UwbRequestRender<C, E, T> uwbRequestRender, Device device, PropertyParam propertyParam, JSONObject jSONObject, ObservableEmitter<PropertyParam> observableEmitter) {
        this.$profileProperty = profileProperty;
        this.this$0 = uwbRequestRender;
        this.$device = device;
        this.$itemParam = propertyParam;
        this.$requestItem = jSONObject;
        this.$it = observableEmitter;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void onSuccess(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        int i = -1;
        String str = null;
        if (this.$profileProperty.getStatus() == translateStatus.TRANSLATE_SUCCESS.getValue()) {
            this.$profileProperty.setValue((jSONObject == null || (optJSONArray2 = jSONObject.optJSONArray("result")) == null) ? null : optJSONArray2.opt(0));
            LocalTranslateManager localTranslateManager = this.this$0.localTranslateManager;
            Device device = this.$device;
            if (device != null) {
                str = device.did;
            }
            SpecProperty propProfileToSpec = localTranslateManager.propProfileToSpec(str, this.$profileProperty);
            this.$itemParam.setValue(propProfileToSpec.getValue());
            PropertyParam propertyParam = this.$itemParam;
            if (propProfileToSpec.getStatus() == translateStatus.TRANSLATE_SUCCESS.getValue() && this.$itemParam.getValue() != null) {
                i = 0;
            }
            propertyParam.setResultCode(i);
        } else {
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("result")) == null) {
                jSONObject2 = null;
            } else {
                jSONObject2 = optJSONArray.optJSONObject(0);
            }
            PropertyParam propertyParam2 = this.$itemParam;
            if (jSONObject2 != null) {
                i = jSONObject2.optInt("code");
            }
            propertyParam2.setResultCode(i);
            PropertyParam propertyParam3 = this.$itemParam;
            if (jSONObject2 != null) {
                str = jSONObject2.opt("value");
            }
            propertyParam3.setValue(str);
        }
        gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", "getSpecPropsFromServer onSuccess " + this.$itemParam + "  request " + this.$requestItem + " result " + jSONObject);
        this.$it.onNext(this.$itemParam);
        this.$it.onComplete();
    }

    public final void onFailure(int i, String str) {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "UwbRequestRender", "getSpecPropsFromServer onError " + this.$requestItem + ' ' + ((Object) str));
        ObservableEmitter<PropertyParam> observableEmitter = this.$it;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(' ');
        sb.append((Object) str);
        observableEmitter.tryOnError(new Exception(sb.toString()));
    }
}
