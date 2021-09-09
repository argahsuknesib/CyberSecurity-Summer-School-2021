package _m_j;

import _m_j.hnz;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hnz {

    public static class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        public Integer f402O000000o = null;
        public ArrayList<T> O00000Oo = new ArrayList<>();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000oO(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O0000O0o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O0000OOo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static fsn O000000o(Context context, String str, String str2, boolean z, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("max_version", "3.0");
            jSONObject.put("value_format", 1);
            jSONObject.put("home_id", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("did", str2);
            }
            jSONObject.put("limit", 10);
            jSONObject.put("page", i);
            if (z) {
                jSONObject.put("plugin", 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/GetTemplateList").O000000o(arrayList).O000000o(), $$Lambda$hnz$LFg2p63AzpNmDRZ8qLRZ4TWISi4.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", str);
            if (i > 0) {
                jSONObject.put("value_format", i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/GetTplSceneList").O000000o(arrayList).O000000o(), $$Lambda$hnz$Kl7LR3lq_j6SKjT9S8kk5nm1nvs.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, long j, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene_id", String.valueOf(j));
            if (i > 0) {
                jSONObject.put("value_format", 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/GetSceneInfo").O000000o(arrayList).O000000o(), $$Lambda$hnz$UHlhoL1UbqGwAarKQwqKNyx7I4.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, int i, String str, int i2, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("edit_from", i);
            if (i2 == 1) {
                jSONObject.put("value_format", 1);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/Edit").O000000o(arrayList).O000000o(), $$Lambda$hnz$zQBu61FqAt1ZGy5Hl8UFOUn7tdo.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/Delete").O000000o(arrayList).O000000o(), $$Lambda$hnz$9ou35lZo6JbHbG8ahUCyYXtwRI.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, long j, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene_id", String.valueOf(j));
            jSONObject.put("trigger_key", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/RunScene").O000000o(arrayList).O000000o(), $$Lambda$hnz$c_sMuAJt2OO6u1xq5uQdKC97GZA.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O00000Oo(Context context, String str, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("template_id", str);
            if (i == 1) {
                jSONObject.put("value_format", i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/GetTemplateInfo").O000000o(arrayList).O000000o(), $$Lambda$hnz$0JwAiKXV24efSS3S8JNvfBciUE.INSTANCE, Crypto.RC4, fsm);
    }

    public static Observable<O000000o<hof>> O000000o(Context context, String str, String str2, boolean z, int i) {
        gpy.O000000o(context, "tpl_scene_list").edit().clear();
        return Observable.create(new ObservableOnSubscribe(context, str, str2, z, i) {
            /* class _m_j.$$Lambda$hnz$j2iqreUzMKAMOIO6i81cTlnSEUA */
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ boolean f$3;
            private final /* synthetic */ int f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hnz.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, new fsy<JSONObject, fso>(this.f$0, this.f$4, observableEmitter) {
                    /* class _m_j.hnz.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            try {
                                Context context = r6;
                                StringBuilder sb = new StringBuilder();
                                sb.append(r10);
                                gpy.O000000o(context, "tpl_scene_list", sb.toString(), jSONObject.getJSONArray("tpl_scene_list").toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            int optInt = jSONObject.optInt("total");
                            O000000o o000000o = new O000000o();
                            JSONArray optJSONArray = jSONObject.optJSONArray("tpl_scene_list");
                            if (optJSONArray.length() > 0) {
                                o000000o.O00000Oo = hof.O000000o(optJSONArray);
                                int i = r10;
                                if (i * 10 < optInt) {
                                    o000000o.f402O000000o = Integer.valueOf(i + 1);
                                }
                            }
                            gsy.O00000Oo("RecScene", "request page " + r10 + " , " + o000000o.O00000Oo.size());
                            gsy.O00000Oo("RecScene", jSONObject.toString());
                            if (!r11.isDisposed()) {
                                r11.onNext(o000000o);
                            }
                        } else if (!r11.isDisposed()) {
                            r11.onError(new Exception("result is null"));
                        }
                    }

                    public final void onFailure(fso fso) {
                        Object obj;
                        String str;
                        StringBuilder sb = new StringBuilder("GetTemplateList： error message");
                        if (TextUtils.isEmpty(fso.O00000Oo)) {
                            obj = Integer.valueOf(fso.f17063O000000o);
                        } else {
                            obj = fso.O00000Oo;
                        }
                        sb.append(obj);
                        gsy.O00000Oo("RecScene", sb.toString());
                        if (!r11.isDisposed()) {
                            ObservableEmitter observableEmitter = r11;
                            if (TextUtils.isEmpty(fso.O00000Oo)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(fso.f17063O000000o);
                                str = sb2.toString();
                            } else {
                                str = fso.O00000Oo;
                            }
                            observableEmitter.onError(new Exception(str));
                        }
                    }
                });
            }
        }).concatMap(new Function(context, str, str2, z) {
            /* class _m_j.$$Lambda$hnz$59GgVVoGnNthw0xm5gdsdCIKN8 */
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ boolean f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object apply(Object obj) {
                return hnz.O000000o(this.f$0, this.f$1, this.f$2, this.f$3, (hnz.O000000o) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ObservableSource O000000o(Context context, String str, String str2, boolean z, O000000o o000000o) throws Exception {
        if (o000000o.f402O000000o == null) {
            return Observable.just(o000000o);
        }
        return Observable.just(o000000o).concatWith(O000000o(context, str, str2, z, o000000o.f402O000000o.intValue()));
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
    public static void O000000o(Context context, List<String> list, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("get_sub_relation", true);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/deviceinfo").O000000o(arrayList).O000000o(), $$Lambda$hnz$DzLZMRMtBjsVLlmZ5ZEWS1uD0.INSTANCE, Crypto.RC4, fsm);
    }
}
