package _m_j;

import _m_j.fsn;
import android.util.Log;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class frt {
    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
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
    public final fsn O000000o(final fsm<JSONObject, fso> fsm) {
        boolean z;
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                z = ServiceApplication.getApplication().isAppForeground();
            } catch (Exception unused) {
                z = true;
            }
            jSONObject.put("fg", z);
            jSONObject.put("fetch_share", true);
            jSONObject.put("fetch_share_dev", true);
            jSONObject.put("limit", 300);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            if (gfr.O0000OOo) {
                LogType logType = LogType.HOME_ROOM;
                gsy.O00000Oo(logType, "RemoteFamilyApi", "getHomeFromServer " + jSONObject.toString());
            }
            NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/gethome").O000000o(arrayList).O000000o();
            final fsn.O000000o o000000o = new fsn.O000000o();
            o000000o.O000000o(CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), O000000o2, $$Lambda$frt$P1Kl1_4X13DHvO_hiLraUW8UYs.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class _m_j.frt.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    String optString = jSONObject.optString("max_id");
                    if (jSONObject.optBoolean("has_more")) {
                        if (gfr.O0000OOo) {
                            gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getHomeFromServer onSuccess hasmore max_id:".concat(String.valueOf(optString)));
                        }
                        frt.this.O000000o(o000000o, jSONObject, frt.O000000o(jSONObject.optJSONArray("homelist")), optString, fsm);
                        return;
                    }
                    if (gfr.O0000OOo) {
                        gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getHomeFromServer onSuccess onepage");
                    }
                    fsm.onSuccess(jSONObject);
                }

                public final void onFailure(fso fso) {
                    fsm.onFailure(fso);
                    gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getMoreHomeFromServer onFailure");
                }
            }));
            return o000000o;
        } catch (Exception unused2) {
            gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getMoreHomeFromServer onFailure");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084 A[SYNTHETIC] */
    public static HashMap<String, HashMap<String, JSONArray>> O000000o(JSONArray jSONArray) {
        JSONArray optJSONArray;
        HashMap<String, HashMap<String, JSONArray>> hashMap = new HashMap<>();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    HashMap hashMap2 = new HashMap();
                    hashMap.put(optString, hashMap2);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("dids");
                    if (optJSONArray2 == null) {
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            try {
                                optJSONObject.put("dids", jSONArray2);
                                optJSONArray2 = jSONArray2;
                            } catch (JSONException e) {
                                JSONArray jSONArray3 = jSONArray2;
                                e = e;
                                optJSONArray2 = jSONArray3;
                                gsy.O000000o(6, "RemoteFamilyApi", Log.getStackTraceString(e));
                                hashMap2.put("", optJSONArray2);
                                optJSONArray = optJSONObject.optJSONArray("roomlist");
                                if (optJSONArray != null) {
                                }
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            gsy.O000000o(6, "RemoteFamilyApi", Log.getStackTraceString(e));
                            hashMap2.put("", optJSONArray2);
                            optJSONArray = optJSONObject.optJSONArray("roomlist");
                            if (optJSONArray != null) {
                            }
                        }
                    }
                    hashMap2.put("", optJSONArray2);
                    optJSONArray = optJSONObject.optJSONArray("roomlist");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("dids");
                            if (optJSONArray3 == null) {
                                try {
                                    JSONArray jSONArray4 = new JSONArray();
                                    try {
                                        optJSONObject2.put("dids", jSONArray4);
                                        optJSONArray3 = jSONArray4;
                                    } catch (JSONException e3) {
                                        JSONArray jSONArray5 = jSONArray4;
                                        e = e3;
                                        optJSONArray3 = jSONArray5;
                                        gsy.O000000o(6, "RemoteFamilyApi", Log.getStackTraceString(e));
                                        hashMap2.put(optJSONObject2.optString("id"), optJSONArray3);
                                    }
                                } catch (JSONException e4) {
                                    e = e4;
                                    gsy.O000000o(6, "RemoteFamilyApi", Log.getStackTraceString(e));
                                    hashMap2.put(optJSONObject2.optString("id"), optJSONArray3);
                                }
                            }
                            hashMap2.put(optJSONObject2.optString("id"), optJSONArray3);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public final void O000000o(fsn.O000000o o000000o, JSONObject jSONObject, HashMap<String, HashMap<String, JSONArray>> hashMap, String str, fsm<JSONObject, fso> fsm) {
        try {
            if (o000000o.f17062O000000o) {
                fsm.onFailure(new fso(-1, "canel"));
                return;
            }
            fsm<JSONObject, fso> fsm2 = fsm;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("start_id", str);
            jSONObject2.put("limit", 300);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            if (gfr.O0000OOo) {
                gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getMoreHomeFromServer request");
            }
            final HashMap<String, HashMap<String, JSONArray>> hashMap2 = hashMap;
            final fsn.O000000o o000000o2 = o000000o;
            final JSONObject jSONObject3 = jSONObject;
            final fsm<JSONObject, fso> fsm3 = fsm;
            o000000o.O000000o(CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/get_dev_room_page").O000000o(arrayList).O000000o(), $$Lambda$frt$Dd1Tx8ypOdAZfRPM4NEm6RxFOXE.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class _m_j.frt.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    JSONArray optJSONArray = jSONObject.optJSONArray("info");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                HashMap hashMap = (HashMap) hashMap2.get(optString);
                                if (hashMap != null) {
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("dids");
                                    if (optJSONArray2 != null) {
                                        JSONArray jSONArray = (JSONArray) hashMap.get("");
                                        if (jSONArray == null) {
                                            gsy.O000000o(6, "RemoteFamilyApi", "getMoreHomeFromServer firstDefaultRoomlist is null");
                                        } else {
                                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                                jSONArray.put(optJSONArray2.optString(i2));
                                            }
                                        }
                                    }
                                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("roomlist");
                                    if (optJSONArray3 != null) {
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i3);
                                            if (optJSONObject2 != null) {
                                                JSONArray optJSONArray4 = optJSONObject2.optJSONArray("dids");
                                                if (optJSONArray4 != null) {
                                                    String optString2 = optJSONObject2.optString("id");
                                                    JSONArray jSONArray2 = (JSONArray) hashMap.get(optString2);
                                                    if (jSONArray2 == null) {
                                                        gsy.O000000o(6, "RemoteFamilyApi", "getMoreHomeFromServer firstroomitem is null roomId:".concat(String.valueOf(optString2)));
                                                    } else {
                                                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                                                            jSONArray2.put(optJSONArray4.optString(i4));
                                                        }
                                                    }
                                                }
                                            } else {
                                                gsy.O000000o(6, "RemoteFamilyApi", "getMoreHomeFromServer roomitem is null");
                                            }
                                        }
                                    }
                                } else {
                                    gsy.O000000o(6, "RemoteFamilyApi", "getMoreHomeFromServer nodata homeId:".concat(String.valueOf(optString)));
                                }
                            } else {
                                gsy.O000000o(6, "RemoteFamilyApi", "getMoreHomeFromServer info contain null homedata");
                            }
                        }
                    }
                    if (jSONObject.optBoolean("has_more")) {
                        String optString3 = jSONObject.optString("max_id");
                        if (gfr.O0000OOo) {
                            gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getMoreHomeFromServer onSuccess hasmore max_id:".concat(String.valueOf(optString3)));
                        }
                        frt.this.O000000o(o000000o2, jSONObject3, hashMap2, optString3, fsm3);
                        return;
                    }
                    if (gfr.O0000OOo) {
                        gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getMoreHomeFromServer onSuccess");
                    }
                    fsm3.onSuccess(jSONObject3);
                }

                public final void onFailure(fso fso) {
                    fsm3.onFailure(fso);
                    gsy.O00000Oo(LogType.HOME_ROOM, "RemoteFamilyApi", "getMoreHomeFromServer onFailure");
                }
            }));
        } catch (Exception e) {
            gsy.O000000o(6, "RemoteFamilyApi", Log.getStackTraceString(e));
        }
    }
}
