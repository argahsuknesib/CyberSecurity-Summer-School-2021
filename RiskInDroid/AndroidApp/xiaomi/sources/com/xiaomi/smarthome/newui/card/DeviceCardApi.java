package com.xiaomi.smarthome.newui.card;

import _m_j.fbd;
import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.gpn;
import _m_j.gsy;
import _m_j.gzp;
import _m_j.hdc;
import _m_j.o0O0OOO0;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.device.api.spec.operation.SpecParam;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.DeviceCardApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DeviceCardApi {
    public static fsn O000000o(Context context, JSONArray jSONArray, fsm<String, fso> fsm, String str) {
        if (jSONArray != null && jSONArray.length() > 0) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("from_flag", str);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONArray.toString()));
            return gzp.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/batchgetdatas").O000000o(arrayList).O000000o(), $$Lambda$DeviceCardApi$77qxZRWDEHF5iORRiHp056Oubi0.INSTANCE, Crypto.RC4, fsm);
        } else if (fsm == null) {
            return null;
        } else {
            fsm.onFailure(new fso(-1, "param is null"));
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String O000000o(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public static fsn O000000o(Context context, List<PropertyParam> list, int i, final fsm<List<PropertyParam>, fso> fsm) {
        if (list == null || list.size() == 0) {
            fsm.onSuccess(new ArrayList());
            return null;
        } else if (list.size() <= 50) {
            return O00000Oo(context, list, i, fsm);
        } else {
            List O000000o2 = gpn.O000000o(list, 50);
            final ArrayList arrayList = new ArrayList(O000000o2.size());
            final int size = O000000o2.size();
            AnonymousClass1 r2 = new fsm<List<PropertyParam>, fso>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                AtomicInteger f10210O000000o = new AtomicInteger(size);
                ArrayList<PropertyParam> O00000Oo = new ArrayList<>();
                fso O00000o0;

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (list != null) {
                        this.O00000Oo.addAll(list);
                    }
                    if (fsm != null && this.O00000o0 == null && this.f10210O000000o.decrementAndGet() == 0) {
                        fsm.onSuccess(this.O00000Oo);
                    }
                }

                public final void onFailure(fso fso) {
                    if (fso != null) {
                        this.O00000o0 = fso;
                        fsm.onFailure(this.O00000o0);
                    }
                }
            };
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(O00000Oo(context, (List) O000000o2.get(i2), i, r2));
            }
            return new fsn<List<Device>>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.AnonymousClass2 */

                public final void cancel() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((fsn) it.next()).cancel();
                    }
                }
            };
        }
    }

    public static void O000000o(List<String> list, String str) {
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    private static fsn O00000Oo(Context context, List<PropertyParam> list, int i, fsm<List<PropertyParam>, fso> fsm) {
        int i2 = i;
        fsm<List<PropertyParam>, fso> fsm2 = fsm;
        if (list == null || list.size() == 0) {
            if (fsm2 != null) {
                fsm2.onSuccess(new ArrayList());
            }
            return new fsn(null);
        }
        ArrayList arrayList = new ArrayList();
        final JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            for (PropertyParam next : list) {
                if (!(next.getCardType() == 18) || i2 != 2) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("did", next.getDid());
                    O000000o(arrayList2, next.getDid());
                    int miid = next.getMiid();
                    if (miid != 0) {
                        jSONObject2.put("miid", miid);
                    }
                    jSONObject2.put("siid", next.getSiid());
                    jSONObject2.put("piid", next.getPiid());
                    jSONArray.put(jSONObject2);
                } else {
                    next.setResultCode(-1001);
                    arrayList3.add(next);
                }
            }
            jSONObject.put("params", jSONArray);
            jSONObject.put("datasource", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray.length() != 0 || arrayList3.size() == 0) {
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            $$Lambda$DeviceCardApi$MrZ3rlabTWc11ww4FIyBFanlNc r11 = new fss(arrayList3) {
                /* class com.xiaomi.smarthome.newui.card.$$Lambda$DeviceCardApi$MrZ3rlabTWc11ww4FIyBFanlNc */
                private final /* synthetic */ ArrayList f$0;

                {
                    this.f$0 = r1;
                }

                public final Object parse(JSONObject jSONObject) {
                    return DeviceCardApi.O000000o(this.f$0, jSONObject);
                }
            };
            NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/miotspec/prop/get").O000000o(arrayList).O000000o();
            final long currentTimeMillis = System.currentTimeMillis();
            final fsm<List<PropertyParam>, fso> fsm3 = fsm;
            final ArrayList arrayList4 = arrayList2;
            final List<PropertyParam> list2 = list;
            return gzp.O000000o().O000000o(context, O000000o2, r11, Crypto.RC4, new fsm<List<PropertyParam>, fso>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onSuccess(list);
                    }
                    fbd.O000000o().report_spec_result(currentTimeMillis, "/miotspec/prop/get", true, arrayList4.size(), arrayList4, list2.size() == 1 ? jSONObject.toString() : "", list == null ? "" : list.toString());
                }

                public final void onFailure(fso fso) {
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                    fbd.O000000o().report_spec_result(currentTimeMillis, "/miotspec/prop/get", false, arrayList4.size(), arrayList4, list2.size() == 1 ? jSONObject.toString() : "", fso == null ? "" : fso.toString());
                }
            });
        }
        if (fsm2 != null) {
            fsm2.onSuccess(arrayList3);
        }
        return new fsn(null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(ArrayList arrayList, JSONObject jSONObject) throws JSONException {
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("code", -1) == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("result");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        PropertyParam value = new PropertyParam(optJSONObject.optString("did"), optJSONObject.optInt("miid"), optJSONObject.optInt("siid"), optJSONObject.optInt("piid")).setValue(optJSONObject.opt("value"));
                        value.setTimestamp(optJSONObject.optLong("updateTime"));
                        value.setResultCode(optJSONObject.optInt("code", -1));
                        arrayList2.add(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList2;
    }

    public static String O000000o(Context context, SpecParam specParam) {
        if (specParam == null) {
            return null;
        }
        switch (specParam.getResultCode()) {
            case -704083036:
                return context.getString(R.string.spec_timeout_error);
            case -704042011:
                return context.getString(R.string.spec_offlinedevice_error);
            case -704042001:
                return context.getString(R.string.spec_nodevice_error);
            case -704030023:
                return context.getString(R.string.spec_propertywrite_error);
            case -704030013:
                return context.getString(R.string.spec_propertyread_error);
            case -704002000:
                return context.getString(R.string.spec_paraminvalid_error);
            default:
                return null;
        }
    }

    public enum SpecPropertyApi {
        instance;
        
        public Map<String, O000000o> mCacheRequest = new o0O0OOO0();

        public final void setDeviceSpecProp(Context context, final PropertyParam propertyParam, final fsm<PropertyParam, fso> fsm) {
            setDeviceSpecProp(context, Collections.singletonList(propertyParam), new fsm<List<PropertyParam>, fso>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.SpecPropertyApi.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    PropertyParam propertyParam;
                    List list = (List) obj;
                    if (fsm == null) {
                        return;
                    }
                    if (list.size() <= 0 || (propertyParam = (PropertyParam) list.get(0)) == null || propertyParam.getSiid() != propertyParam.getSiid() || propertyParam.getPiid() != propertyParam.getPiid()) {
                        fsm.onSuccess(propertyParam);
                        return;
                    }
                    propertyParam.setValue(propertyParam.getValue());
                    fsm.onSuccess(propertyParam);
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                }
            });
        }

        public final void setDeviceSpecProp(Context context, List<PropertyParam> list, fsm<List<PropertyParam>, fso> fsm) {
            List<PropertyParam> list2 = list;
            fsm<List<PropertyParam>, fso> fsm2 = fsm;
            if (list2 == null) {
                fsm2.onFailure(new fso(-1, "param is null"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            final JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            final ArrayList arrayList2 = new ArrayList();
            try {
                for (PropertyParam next : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("did", next.getDid());
                    DeviceCardApi.O000000o(arrayList2, next.getDid());
                    int miid = next.getMiid();
                    if (miid != 0) {
                        jSONObject2.put("miid", miid);
                    }
                    jSONObject2.put("siid", next.getSiid());
                    jSONObject2.put("piid", next.getPiid());
                    jSONObject2.put("value", next.getValue());
                    jSONArray.put(jSONObject2);
                }
                String jSONArray2 = jSONArray.toString();
                jSONObject.put("params", jSONArray);
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                O000000o o000000o = this.mCacheRequest.get(jSONArray2);
                if (o000000o != null) {
                    if (o000000o.O00000oO != null) {
                        o000000o.O00000oO.sendSuccessMessage(o000000o.O00000o0);
                        LogType logType = LogType.CARD;
                        gsy.O00000Oo(logType, "mijia-card", "setDeviceSpecProp pending request callback success param:" + o000000o.O00000o0);
                    }
                    o000000o.O00000o0 = list2;
                    o000000o.O00000o = context;
                    o000000o.O00000oO = fsm2;
                    return;
                }
                Context context2 = context;
                final O000000o o000000o2 = new O000000o(jSONArray2, fsm2);
                this.mCacheRequest.put(jSONArray2, o000000o2);
                $$Lambda$DeviceCardApi$SpecPropertyApi$6dnp33_vYR23MWP3DWlzpWsSpzk r15 = new fss(list2) {
                    /* class com.xiaomi.smarthome.newui.card.$$Lambda$DeviceCardApi$SpecPropertyApi$6dnp33_vYR23MWP3DWlzpWsSpzk */
                    private final /* synthetic */ List f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final Object parse(JSONObject jSONObject) {
                        return DeviceCardApi.SpecPropertyApi.lambda$setDeviceSpecProp$0(this.f$0, jSONObject);
                    }
                };
                NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/miotspec/prop/set").O000000o(arrayList).O000000o();
                final long currentTimeMillis = System.currentTimeMillis();
                final List<PropertyParam> list3 = list;
                Context context3 = context;
                gzp.O000000o().O000000o(context3, O000000o2, r15, Crypto.RC4, new fsm<List<PropertyParam>, fso>() {
                    /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.SpecPropertyApi.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        List list = (List) obj;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (o000000o2.O00000oo != null) {
                            o000000o2.O00000oo.onSuccess(list);
                        }
                        fbd.O000000o().report_spec_result(currentTimeMillis, "/miotspec/prop/set", true, arrayList2.size(), arrayList2, list3.size() == 1 ? jSONObject.toString() : "", list == null ? "" : list.toString());
                    }

                    public final void onFailure(fso fso) {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (o000000o2.O00000oo != null) {
                            o000000o2.O00000oo.onFailure(fso);
                        }
                        fbd.O000000o().report_spec_result(currentTimeMillis, "/miotspec/prop/set", false, arrayList2.size(), arrayList2, list3.size() == 1 ? jSONObject.toString() : "", fso == null ? "" : fso.toString());
                    }
                });
            } catch (Exception e) {
                fsm2.sendFailureMessage(new fso(-1, Log.getStackTraceString(e)));
            }
        }

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public final String f10220O000000o;
            public fsm<List<PropertyParam>, fso> O00000Oo;
            Context O00000o;
            List<PropertyParam> O00000o0;
            fsm<List<PropertyParam>, fso> O00000oO;
            fsm<List<PropertyParam>, fso> O00000oo = new fsm<List<PropertyParam>, fso>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.SpecPropertyApi.O000000o.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    SpecPropertyApi.instance.mCacheRequest.remove(O000000o.this.f10220O000000o);
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.onSuccess(list);
                        O000000o.this.O00000Oo = null;
                    }
                    if (O000000o.this.O00000o0 != null) {
                        SpecPropertyApi.instance.setDeviceSpecProp(O000000o.this.O00000o, O000000o.this.O00000o0, O000000o.this.O00000oO);
                    }
                }

                public final void onFailure(fso fso) {
                    SpecPropertyApi.instance.mCacheRequest.remove(O000000o.this.f10220O000000o);
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.onFailure(fso);
                        O000000o.this.O00000Oo = null;
                    }
                }
            };

            public O000000o(String str, fsm<List<PropertyParam>, fso> fsm) {
                this.f10220O000000o = str;
                this.O00000Oo = fsm;
            }
        }
    }

    public enum SpecActionApi {
        instance;
        
        public Map<String, O000000o> mCacheRequest = new o0O0OOO0();

        public final void setDeviceSpecAction(Context context, ActionParam actionParam, fsm<ActionParam, fso> fsm) {
            ActionParam actionParam2 = actionParam;
            fsm<ActionParam, fso> fsm2 = fsm;
            if (actionParam2 == null) {
                fsm2.onFailure(new fso(-1, "param is null"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            final JSONObject jSONObject = new JSONObject();
            final ArrayList arrayList2 = new ArrayList();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("did", actionParam.getDid());
                DeviceCardApi.O000000o(arrayList2, actionParam.getDid());
                int miid = actionParam.getMiid();
                if (miid != 0) {
                    jSONObject2.put("miid", miid);
                }
                jSONObject2.put("siid", actionParam.getSiid());
                jSONObject2.put("aiid", actionParam.getAiid());
                String jSONObject3 = jSONObject2.toString();
                O000000o o000000o = this.mCacheRequest.get(jSONObject3);
                if (o000000o != null) {
                    if (o000000o.O00000oO != null) {
                        o000000o.O00000oO.sendSuccessMessage(o000000o.O00000o0);
                        LogType logType = LogType.CARD;
                        gsy.O00000Oo(logType, "mijia-card", "setDeviceSpecAction pending request callback success param:" + o000000o.O00000o0);
                    }
                    o000000o.O00000o0 = actionParam2;
                    o000000o.O00000o = context;
                    o000000o.O00000oO = fsm2;
                    return;
                }
                Context context2 = context;
                final O000000o o000000o2 = new O000000o(jSONObject3, fsm2);
                this.mCacheRequest.put(jSONObject3, o000000o2);
                JSONArray jSONArray = new JSONArray();
                List<Object> in2 = actionParam.getIn();
                if (in2 != null && in2.size() > 0) {
                    for (Object put : in2) {
                        jSONArray.put(put);
                    }
                }
                jSONObject2.put("in", jSONArray);
                jSONObject.put("params", jSONObject2);
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                $$Lambda$DeviceCardApi$SpecActionApi$Z_LL240_J5P8crl4pWVZKXr_yQ r14 = $$Lambda$DeviceCardApi$SpecActionApi$Z_LL240_J5P8crl4pWVZKXr_yQ.INSTANCE;
                NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/miotspec/action").O000000o(arrayList).O000000o();
                final long currentTimeMillis = System.currentTimeMillis();
                Context context3 = context;
                gzp.O000000o().O000000o(context3, O000000o2, r14, Crypto.RC4, new fsm<ActionParam, fso>() {
                    /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.SpecActionApi.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        ActionParam actionParam = (ActionParam) obj;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (o000000o2.O00000oo != null) {
                            o000000o2.O00000oo.onSuccess(actionParam);
                        }
                        fbd.O000000o().report_spec_result(currentTimeMillis, "/miotspec/action", true, 1, arrayList2, jSONObject.toString(), actionParam == null ? "" : actionParam.toString());
                    }

                    public final void onFailure(fso fso) {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (o000000o2.O00000oo != null) {
                            o000000o2.O00000oo.onFailure(fso);
                        }
                        fbd.O000000o().report_spec_result(currentTimeMillis, "/miotspec/action", false, 1, arrayList2, jSONObject.toString(), fso == null ? "" : fso.toString());
                    }
                });
            } catch (Exception e) {
                fsm2.sendFailureMessage(new fso(-1, Log.getStackTraceString(e)));
            }
        }

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public final String f10216O000000o;
            public fsm<ActionParam, fso> O00000Oo;
            Context O00000o;
            ActionParam O00000o0;
            fsm<ActionParam, fso> O00000oO;
            fsm<ActionParam, fso> O00000oo = new fsm<ActionParam, fso>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.SpecActionApi.O000000o.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ActionParam actionParam = (ActionParam) obj;
                    SpecActionApi.instance.mCacheRequest.remove(O000000o.this.f10216O000000o);
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.onSuccess(actionParam);
                        O000000o.this.O00000Oo = null;
                    }
                    if (O000000o.this.O00000o0 != null) {
                        SpecActionApi.instance.setDeviceSpecAction(O000000o.this.O00000o, O000000o.this.O00000o0, O000000o.this.O00000oO);
                    }
                }

                public final void onFailure(fso fso) {
                    SpecActionApi.instance.mCacheRequest.remove(O000000o.this.f10216O000000o);
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.onFailure(fso);
                        O000000o.this.O00000Oo = null;
                    }
                }
            };

            public O000000o(String str, fsm<ActionParam, fso> fsm) {
                this.f10216O000000o = str;
                this.O00000Oo = fsm;
            }
        }
    }

    public enum ProfileRpcApi {
        instance;
        
        public Map<String, O000000o> mCacheRequest = new o0O0OOO0();

        public final void rpcAsync(String str, String str2, String str3, hdc hdc, Object obj, fsm<JSONObject, fso> fsm) {
            O000000o o000000o = this.mCacheRequest.get(str3);
            if (o000000o != null) {
                if (o000000o.O0000OOo != null) {
                    o000000o.O0000OOo.sendSuccessMessage(null);
                    LogType logType = LogType.CARD;
                    gsy.O00000Oo(logType, "mijia-card", "rpcAsync pending request callback success param:" + o000000o.O0000O0o);
                }
                o000000o.O00000o = str;
                o000000o.O00000oO = str2;
                o000000o.O00000oo = str3;
                o000000o.O0000O0o = hdc;
                o000000o.O00000o0 = obj;
                o000000o.O0000OOo = fsm;
                return;
            }
            O000000o o000000o2 = new O000000o(str3, fsm);
            this.mCacheRequest.put(str3, o000000o2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", fbd.O000000o().generateNonce());
                jSONObject.put("method", str3);
                jSONObject.put("params", hdc.O000000o(obj));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            fbd.O000000o().rpcAsync(str, str2, jSONObject.toString(), o000000o2.O0000Oo0);
        }

        static class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public final String f10213O000000o;
            public fsm<JSONObject, fso> O00000Oo;
            public String O00000o;
            public Object O00000o0;
            public String O00000oO;
            public String O00000oo;
            hdc O0000O0o;
            fsm<JSONObject, fso> O0000OOo;
            fsm<JSONObject, fso> O0000Oo0 = new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.newui.card.DeviceCardApi.ProfileRpcApi.O000000o.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    ProfileRpcApi.instance.mCacheRequest.remove(O000000o.this.f10213O000000o);
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.onSuccess(jSONObject);
                        O000000o.this.O00000Oo = null;
                    }
                    if (O000000o.this.O00000oo != null) {
                        ProfileRpcApi.instance.rpcAsync(O000000o.this.O00000o, O000000o.this.O00000oO, O000000o.this.O00000oo, O000000o.this.O0000O0o, O000000o.this.O00000o0, O000000o.this.O0000OOo);
                    }
                }

                public final void onFailure(fso fso) {
                    ProfileRpcApi.instance.mCacheRequest.remove(O000000o.this.f10213O000000o);
                    if (O000000o.this.O00000Oo != null) {
                        O000000o.this.O00000Oo.onFailure(fso);
                        O000000o.this.O00000Oo = null;
                    }
                }
            };

            public O000000o(String str, fsm<JSONObject, fso> fsm) {
                this.f10213O000000o = str;
                this.O00000Oo = fsm;
            }
        }
    }
}
