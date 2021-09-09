package com.xiaomi.smarthome.family.api;

import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.gya;
import android.content.Context;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import com.xiaomi.smarthome.miio.message.p0.model.P0MessageList;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum MessageApi {
    instance;

    public final fsn getMessageTypeListV2(Context context, long j, int i, fsm<List<MessageRecordTypeList>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", j);
            jSONObject.put("limit", i);
        } catch (Exception | JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/v2/typelist").O000000o(arrayList).O000000o(), new fss<List<MessageRecordTypeList>>() {
            /* class com.xiaomi.smarthome.family.api.MessageApi.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null && gfr.O0000OOo) {
                    gsy.O00000Oo("typelist", jSONObject.toString());
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("messages");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(MessageRecordTypeList.parseMessageRecord(optJSONArray.optJSONObject(i)));
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final fsn getMessageListOfType(Context context, int i, long j, int i2, fsm<List<MessageRecordTypeList>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
            jSONObject.put("timestamp", j);
            jSONObject.put("limit", i2);
            jSONObject.put("force_read", true);
        } catch (Exception | JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/v2/list").O000000o(arrayList).O000000o(), new fss<List<MessageRecordTypeList>>() {
            /* class com.xiaomi.smarthome.family.api.MessageApi.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null && gfr.O0000OOo) {
                    gsy.O00000Oo("getMessageListByDid", jSONObject.toString());
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("messages");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(MessageRecordTypeList.parseMessageRecord(optJSONArray.optJSONObject(i)));
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final fsn getMessageListOfDevice(Context context, String str, int i, long j, int i2, fsm<List<MessageRecordTypeList>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("type", i);
            jSONObject.put("timestamp", j);
            jSONObject.put("limit", i2);
            jSONObject.put("force_read", true);
        } catch (Exception | JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/v2/list").O000000o(arrayList).O000000o(), new fss<List<MessageRecordTypeList>>() {
            /* class com.xiaomi.smarthome.family.api.MessageApi.AnonymousClass3 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null && gfr.O0000OOo) {
                    gsy.O00000Oo("getMessageListByDid", jSONObject.toString());
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("messages");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(MessageRecordTypeList.parseMessageRecord(optJSONArray.optJSONObject(i)));
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn unregisterFastConnect(Context context, String str, String str2, fsm<Boolean, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("router_did", str2);
        } catch (Exception | JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/router/cancel_config").O000000o(arrayList).O000000o(), new fss<Boolean>() {
            /* class com.xiaomi.smarthome.family.api.MessageApi.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return Boolean.TRUE;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn setDevMsgSwitch(Home home, int i, List<gya> list, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("switch", i);
            if (home != null) {
                jSONObject.put("owner_uid", home.getOwnerUid());
                jSONObject.put("home_id", Long.parseLong(home.getId()));
            }
            if (list != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    gya gya = list.get(i2);
                    if (gya != null) {
                        jSONObject2.put(gya.O00000Oo, gya.O00000oo);
                    }
                }
                jSONObject.put("device_setting", jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/mipush/set_dev_msg_switch").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn getP0MessageAlert(fsm<P0MessageList, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/get_p0_alert").O000000o(arrayList).O000000o(), new fss<P0MessageList>() {
                /* class com.xiaomi.smarthome.family.api.MessageApi.AnonymousClass5 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return P0MessageList.O000000o(jSONObject);
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
