package com.xiaomi.smarthome.uwb;

import _m_j.fax;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import _m_j.hcv;
import _m_j.hcz;
import _m_j.hdc;
import _m_j.hee;
import _m_j.hfa;
import _m_j.ixe;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$sendRequest$1$1", "Lcom/xiaomi/smarthome/uwb/lib/UwbRequestApi$UwbRequestCallback;", "onFailure", "", "code", "", "msg", "", "onSuccess", "result", "Lorg/json/JSONObject;", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$sendRequest$1$1 extends UwbRequestApi.UwbRequestCallback {
    final /* synthetic */ Ref.ObjectRef<SpecAction> $action;
    final /* synthetic */ fsm<JSONObject, fso> $callback;
    final /* synthetic */ E $cardItem;
    final /* synthetic */ Device $device;
    final /* synthetic */ T $prop;
    final /* synthetic */ Ref.ObjectRef<Object> $propValue;
    final /* synthetic */ Ref.BooleanRef $sameLast;
    final /* synthetic */ Object $value;
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$sendRequest$1$1(T t, Ref.ObjectRef<SpecAction> objectRef, Device device, fsm<JSONObject, fso> fsm, UwbRequestRender<C, E, T> uwbRequestRender, Ref.BooleanRef booleanRef, Object obj, E e, Ref.ObjectRef<Object> objectRef2) {
        this.$prop = t;
        this.$action = objectRef;
        this.$device = device;
        this.$callback = fsm;
        this.this$0 = uwbRequestRender;
        this.$sameLast = booleanRef;
        this.$value = obj;
        this.$cardItem = e;
        this.$propValue = objectRef2;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void onSuccess(JSONObject jSONObject) {
        hdc hdc;
        Boolean bool;
        gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", "sendRequest onSuccess " + ((Object) this.$prop) + ' ' + jSONObject);
        String str = null;
        if (this.$action.element != null) {
            hcz instance = hcz.getInstance();
            Device device = this.$device;
            instance.notifyPropChangedListener(device == null ? null : device.did, fax.O000000o(this.$action.element), "", System.currentTimeMillis(), (byte) 5);
            Device device2 = this.$device;
            String str2 = device2 == null ? null : device2.did;
            Spec.SpecItem[] specItemArr = new Spec.SpecItem[1];
            Spec.SpecItem specItem = this.$prop;
            specItemArr[0] = specItem instanceof Spec.SpecItem ? specItem : null;
            List<PropertyParam> O000000o2 = hfa.O000000o(str2, -1, specItemArr, null);
            fsm<JSONObject, fso> fsm = this.$callback;
            if (fsm != null) {
                fsm.sendSuccessMessage(jSONObject);
            }
            UwbRequestRender<C, E, T> uwbRequestRender = this.this$0;
            Device device3 = this.$device;
            uwbRequestRender.getSpecPropsFromServer(false, device3, O000000o2, new UwbRequestRender$sendRequest$1$1$onSuccess$1(this.$cardItem, device3, this.$prop, this.$propValue, uwbRequestRender, O000000o2));
            return;
        }
        Spec.SpecItem specItem2 = this.$prop;
        if (specItem2 instanceof Spec.SpecItem) {
            String O000000o3 = fax.O000000o(specItem2);
            if (this.$sameLast.element) {
                fsm<JSONObject, fso> fsm2 = this.$callback;
                if (fsm2 != null) {
                    fsm2.sendSuccessMessage(jSONObject);
                }
                hcz instance2 = hcz.getInstance();
                Device device4 = this.$device;
                if (device4 != null) {
                    str = device4.did;
                }
                instance2.notifyPropChangedListener(str, O000000o3, this.$value, (byte) 2);
            } else if (this.this$0.isSuccess(jSONObject)) {
                Object obj = this.$value;
                if (obj == null) {
                    bool = null;
                } else {
                    hcz instance3 = hcz.getInstance();
                    Device device5 = this.$device;
                    bool = Boolean.valueOf(obj.equals(instance3.getPropValue(device5 == null ? null : device5.did, O000000o3)));
                }
                if (ixe.O000000o(bool, Boolean.TRUE)) {
                    hcz instance4 = hcz.getInstance();
                    Device device6 = this.$device;
                    if (device6 != null) {
                        str = device6.did;
                    }
                    instance4.notifyPropChangedListener(str, O000000o3, this.$value, (byte) 2);
                }
                fsm<JSONObject, fso> fsm3 = this.$callback;
                if (fsm3 != null) {
                    fsm3.sendSuccessMessage(jSONObject);
                }
            } else {
                fsm<JSONObject, fso> fsm4 = this.$callback;
                if (fsm4 != null) {
                    if (jSONObject != null) {
                        str = jSONObject.toString();
                    }
                    fsm4.sendFailureMessage(new fso(-1, str));
                }
            }
        } else if (this.this$0.isSuccess(jSONObject)) {
            fsm<JSONObject, fso> fsm5 = this.$callback;
            if (fsm5 != null) {
                fsm5.sendSuccessMessage(jSONObject);
            }
            hcv instance5 = hcv.getInstance();
            Device device7 = this.$device;
            String str3 = device7 == null ? null : device7.did;
            E e = this.$cardItem;
            String str4 = e == null ? null : e.O00000o0;
            E e2 = this.$cardItem;
            hee hee = e2 == null ? null : e2.O00000oo;
            if (!(hee == null || (hdc = hee.O0000Oo) == null)) {
                str = hdc.O000000o(this.$value, (List<Object>) null);
            }
            instance5.notifyPropChangedListener(str3, str4, str, (byte) 2);
        } else {
            fsm<JSONObject, fso> fsm6 = this.$callback;
            if (fsm6 != null) {
                if (jSONObject != null) {
                    str = jSONObject.toString();
                }
                fsm6.sendFailureMessage(new fso(-1, str));
            }
        }
    }

    public final void onFailure(int i, String str) {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "UwbRequestRender", "sendRequest onError " + ((Object) this.$prop) + ' ' + this.$value + ' ' + i + ' ' + ((Object) str));
        fsm<JSONObject, fso> fsm = this.$callback;
        if (fsm != null) {
            fsm.sendFailureMessage(new fso(i, str));
        }
    }
}
