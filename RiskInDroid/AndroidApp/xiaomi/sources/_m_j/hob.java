package _m_j;

import _m_j.hqb;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hob {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hob f403O000000o;
    private static final Object O00000Oo = new Object();

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private hob() {
    }

    public static hob O000000o() {
        if (f403O000000o == null) {
            synchronized (O00000Oo) {
                if (f403O000000o == null) {
                    f403O000000o = new hob();
                }
            }
        }
        return f403O000000o;
    }

    public final fsn O000000o(Context context, final SceneApi.O000OOOo o000OOOo, final fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            hpq.O000000o();
            if (hpq.O00000o0(o000OOOo.O0000O0o)) {
                o000OOOo.O0000oO0 = true;
            } else {
                o000OOOo.O0000oO0 = false;
            }
            jSONObject = o000OOOo.O000000o();
        } catch (JSONException unused) {
        }
        LogType logType = LogType.SCENE;
        gsy.O000000o(logType, "scene", "miioSceneSettingNew------------------------cmdObj.toString()---------" + jSONObject.toString());
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/editv2").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hob.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class _m_j.hob.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                GeoFenceItem O000000o2;
                JSONObject jSONObject = (JSONObject) obj;
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(jSONObject);
                }
                hod O0000OoO = hod.O0000OoO();
                SceneApi.O000OOOo o000OOOo = o000OOOo;
                if (o000OOOo != null && o000OOOo.O0000O0o != null && !o000OOOo.O0000O0o.isEmpty()) {
                    for (int i = 0; i < o000OOOo.O0000O0o.size(); i++) {
                        if ((o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) && o000OOOo.O0000O0o.get(i).O0000Oo != null) {
                            SceneApi.O000000o o000000o = o000OOOo.O0000O0o.get(i);
                            if (o000OOOo.O0000O0o.get(i).O0000Oo.O0000o0 > 0 && (O000000o2 = hnw.O000000o(o000000o.O0000Oo, o000OOOo.f11131O000000o)) != null) {
                                String O000000o3 = hpe.O000000o(fcn.O000000o().O00000Oo(), ftn.O000000o(ServiceApplication.getAppContext()).O00000Oo, "scene-".concat(String.valueOf(o000000o.O0000Oo.O0000o0)));
                                if (O0000OoO.O0000oO.containsKey(O000000o3)) {
                                    LogType logType = LogType.GENERAL;
                                    gsy.O00000o0(logType, "GEO_FENCE", "already created，update?" + o000OOOo.f11131O000000o + ", lat:" + o000000o.O0000Oo.O0000o0o + ", lon:" + o000000o.O0000Oo.O0000o);
                                }
                                hpf.O000000o().O000000o(O000000o3, O000000o2);
                            }
                        }
                    }
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }

    public static fsn O00000Oo(Context context, SceneApi.O000OOOo o000OOOo, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("us_id", o000OOOo.f11131O000000o);
            jSONObject.put("type", 1);
            jSONObject.put("status", 0);
            jSONObject.put("st_id", 15);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/setuserscene").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, final int i, final fsm<List<SceneApi.O000OOOo>, fso> fsm) {
        return O000000o(context, i, (String) null, new fsm<JSONObject, fso>() {
            /* class _m_j.hob.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (jSONObject.has(String.valueOf(i))) {
                    try {
                        SceneApi.O000OOOo O000000o2 = SceneApi.O000OOOo.O000000o(jSONObject.optJSONObject(String.valueOf(i)), i == 30);
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                        }
                        i++;
                    } catch (JSONException e) {
                        fsm.onFailure(new fso(-1, Log.getStackTraceString(e)));
                    }
                }
                int i2 = i;
                if (i2 == 15) {
                    hod O0000OoO = hod.O0000OoO();
                    String jSONObject2 = jSONObject.toString();
                    Message obtainMessage = O0000OoO.O0000o0o.obtainMessage();
                    obtainMessage.what = 8;
                    obtainMessage.obj = jSONObject2;
                    O0000OoO.O0000o0o.sendMessage(obtainMessage);
                } else if (i2 == 50) {
                    hod O0000OoO2 = hod.O0000OoO();
                    String jSONObject3 = jSONObject.toString();
                    Message obtainMessage2 = O0000OoO2.O0000o0o.obtainMessage();
                    obtainMessage2.what = 14;
                    obtainMessage2.obj = jSONObject3;
                    O0000OoO2.O0000o0o.sendMessage(obtainMessage2);
                }
                fsm.onSuccess(arrayList);
            }

            public final void onFailure(fso fso) {
                fsm.onFailure(fso);
            }
        });
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
    public static fsn O000000o(Context context, int i, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api_version", 5);
            jSONObject.put("st_id", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("did", str);
            }
            if (!TextUtils.isEmpty(null)) {
                jSONObject.put("name", (Object) null);
            }
            if (i == 8) {
                jSONObject.put("support_second", true);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/list").O000000o(arrayList).O000000o(), $$Lambda$hob$IGZDteQbbKcg4lMeEmC2XRcHJnc.INSTANCE, Crypto.RC4, fsm);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hnw.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, _m_j.hoc):void
     arg types: [com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, _m_j.hob$7]
     candidates:
      _m_j.hnw.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, android.widget.LinearLayout):int
      _m_j.hnw.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O0000O0o, java.lang.String):com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem
      _m_j.hnw.O000000o(int, int):java.lang.String
      _m_j.hnw.O000000o(android.content.Context, com.xiaomi.smarthome.scene.api.SceneApi$O000000o):java.lang.String
      _m_j.hnw.O000000o(com.facebook.drawee.view.SimpleDraweeView, com.xiaomi.smarthome.scene.api.SceneApi$O000000o):void
      _m_j.hnw.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.hnw.O000000o(com.xiaomi.smarthome.scene.api.SceneApi$O000OOOo, _m_j.hoc):void */
    public final void O000000o(SceneApi.O000OOOo o000OOOo, final fsm<Void, fso> fsm) {
        hnw.O000000o(o000OOOo, (hoc) new hoc() {
            /* class _m_j.hob.AnonymousClass7 */

            public final void O000000o(boolean z) {
                if (z) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onSuccess(null);
                        return;
                    }
                    return;
                }
                fsm fsm2 = fsm;
                if (fsm2 != null) {
                    fsm2.onFailure(null);
                }
            }

            public final void O000000o(int i, String str) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(new fso(i, str));
                }
            }
        });
    }

    @Deprecated
    public static fsn O000000o(Context context, String str, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("us_id", str);
            jSONObject.put("key", "");
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/start").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, String str2, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", str2);
            jSONObject.put("us_id", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/start").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, List<String> list, final fsm<Void, fso> fsm) {
        if (list == null || list.size() == 0) {
            fsm.onFailure(new fso(-1, "us_id is illegal"));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String next : list) {
                if (!TextUtils.isEmpty(next) && !TextUtils.equals("0", next)) {
                    jSONArray.put(next);
                }
            }
            if (jSONArray.length() == 0) {
                fsm.onFailure(new fso(-1, "us_id is illegal"));
                return null;
            }
            jSONObject.put("us_id", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/delete").O000000o(arrayList).O000000o();
            final ArrayList arrayList2 = new ArrayList();
            for (String O00000Oo2 : list) {
                arrayList2.add(hod.O0000OoO().O00000Oo(O00000Oo2));
            }
            return CoreApi.O000000o().O000000o(context, O000000o2, (fss) null, Crypto.RC4, new fsm<Void, fso>() {
                /* class _m_j.hob.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Void voidR = (Void) obj;
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onSuccess(voidR);
                    }
                    hod O0000OoO = hod.O0000OoO();
                    List list = arrayList2;
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            SceneApi.O000OOOo o000OOOo = (SceneApi.O000OOOo) list.get(i);
                            if (o000OOOo.O0000O0o != null && !o000OOOo.O0000O0o.isEmpty()) {
                                for (int i2 = 0; i2 < o000OOOo.O0000O0o.size(); i2++) {
                                    SceneApi.O000000o o000000o = ((SceneApi.O000OOOo) list.get(i)).O0000O0o.get(i2);
                                    if ((o000000o.f11121O000000o == LAUNCH_TYPE.LEAVE_FENCE || o000000o.f11121O000000o == LAUNCH_TYPE.ENTER_FENCE) && o000000o.O0000Oo != null) {
                                        long j = o000000o.O0000Oo.O0000o0;
                                        if (j > 0) {
                                            String O000000o2 = hpe.O000000o(fcn.O000000o().O00000Oo(), ftn.O000000o(ServiceApplication.getAppContext()).O00000Oo, "scene-".concat(String.valueOf(j)));
                                            O0000OoO.O0000oO.remove(O000000o2);
                                            hpf.O000000o().O000000o(O000000o2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                }
            });
        } catch (JSONException unused) {
            fsm.onFailure(new fso(-1, "us_id is illegal"));
            return null;
        }
    }

    public final fsn O000000o(String str, long j, Context context, fsm<hqb, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("did", str);
            }
            jSONObject.put("command", "history");
            jSONObject.put("limit", 100);
            if (j > 0) {
                jSONObject.put("timestamp", j);
            } else {
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            }
        } catch (JSONException unused) {
        }
        AnonymousClass9 r5 = new fss<hqb>() {
            /* class _m_j.hob.AnonymousClass9 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                hqb hqb = new hqb();
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "RemoteMiioApi", System.currentTimeMillis() + "===scene log history: " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("history");
                if (optJSONArray == null) {
                    return hqb;
                }
                hqb.O00000Oo = optJSONArray.length() >= 100;
                hqb.f518O000000o = hqb.O00000Oo.O000000o(optJSONArray);
                return hqb;
            }
        };
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/history").O000000o(arrayList).O000000o(), r5, Crypto.RC4, fsm);
    }

    public static fsn O000000o(String str, Context context, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("did", str);
            }
            jSONObject.put("command", "cleanHistory");
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/history").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, String str2, String str3, JSONObject jSONObject, JSONArray jSONArray, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("us_id", str);
            jSONObject2.put("identify", str2);
            if (str3 != null) {
                jSONObject2.put("name", str3);
            }
            jSONObject2.put("st_id", 8);
            jSONObject2.put("setting", jSONObject);
            jSONObject2.put("authed", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/edit").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.hob.AnonymousClass10 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
            return new fsn(null);
        }
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
    public final fsn O000000o(Context context, String str, String str2, fsm<JSONObject, fso> fsm, boolean z) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("st_id", 8);
            jSONObject.put("did", str);
            jSONObject.put("inc_grp", 1);
            if (z) {
                jSONObject.put("identify", str2);
            }
            jSONObject.put("support_second", true);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/grouplist").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.hob.AnonymousClass11 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
            return new fsn(null);
        }
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
    public final fsn O00000Oo(Context context, String str, String str2, fsm<JSONObject, fso> fsm, boolean z) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("st_id", 8);
            jSONObject.put("did", str);
            if (z) {
                jSONObject.put("identify", str2);
            }
            jSONObject.put("support_second", true);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/list").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.hob.AnonymousClass12 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
            return new fsn(null);
        }
    }

    public final fsn O00000Oo(Context context, String str, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str) || TextUtils.equals("0", str)) {
            fsm.onFailure(new fso(-1, "us_id is illegal"));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("us_id", str);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/delete").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.hob.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
            return new fsn(null);
        }
    }

    public final fsn O000000o(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/userrecomv2").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hob.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, long j, double d, double d2, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("command", "setUserLocationInfo");
            JSONObject jSONObject2 = new JSONObject();
            if (j > 0) {
                jSONObject2.put("po_id", j);
            }
            if (d > 0.0d && d2 > 0.0d) {
                jSONObject2.put("latitude", d);
                jSONObject2.put("longitude", d2);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("intro", str);
            }
            jSONObject.put("param", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/location").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hob.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public static void O00000o0(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("us_id", Long.parseLong(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/scene/get_sceneinfo_by_usid").O000000o(arrayList).O000000o(), $$Lambda$hob$f_5fw9ITcY7YpuKyvxn_mZ8dU.INSTANCE, Crypto.RC4, fsm);
    }
}
