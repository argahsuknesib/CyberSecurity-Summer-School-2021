package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hoa {
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
    public static /* synthetic */ JSONObject O0000O0o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    public static fsn O000000o(Context context, String str, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str) || TextUtils.equals("0", str)) {
            if (fsm != null) {
                fsm.onFailure(new fso(-1, "us_id is illegal"));
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("us_id", str);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/delete").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.hoa.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            if (fsm != null) {
                fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), e.getMessage()));
            }
            return new fsn(null);
        }
    }

    @Deprecated
    public static fsn O00000Oo(Context context, String str, fsm<Void, fso> fsm) {
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

    public static fsn O000000o(Context context, long j, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene_id", String.valueOf(j));
            jSONObject.put("trigger_key", "user.click");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/RunScene").O000000o(arrayList).O000000o(), $$Lambda$hoa$L5mbxnxVIApCTCZjAapOF089RLk.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O00000o0(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/GetCommonUsedSceneList").O000000o(arrayList).O000000o(), $$Lambda$hoa$S7l49olfsIiciJItGjrQJKB84t8.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O00000o(Context context, String str, fsm<List<CommonUsedScene>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/GetUncommonUsedSceneList").O000000o(arrayList).O000000o(), $$Lambda$hoa$GVkNVWSDq8VkljKBA608H6huKMM.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm) {
        int i;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (true) {
                if (list == null) {
                    i = 0;
                } else {
                    i = list.size();
                }
                if (i2 >= i) {
                    break;
                }
                JSONObject O000000o2 = list.get(i2).O000000o();
                if (O000000o2 != null) {
                    jSONArray.put(O000000o2);
                }
                i2++;
            }
            jSONObject.put("scene_list", jSONArray);
            jSONObject.put("home_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/SetCommonUsedScenes").O000000o(arrayList).O000000o(), $$Lambda$hoa$inUltOwz8_sRF8krqlYV6eeWOIM.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O00000Oo(Context context, String str, List<CommonUsedScene> list, fsm<JSONObject, fso> fsm) {
        int i;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (true) {
                if (list == null) {
                    i = 0;
                } else {
                    i = list.size();
                }
                if (i2 >= i) {
                    break;
                }
                JSONObject O00000Oo = list.get(i2).O00000Oo();
                if (O00000Oo != null) {
                    jSONArray.put(O00000Oo);
                }
                i2++;
            }
            jSONObject.put("scene_list", jSONArray);
            jSONObject.put("home_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/SetCommonUsedScenes").O000000o(arrayList).O000000o(), $$Lambda$hoa$VHMK9R8zQPbCueZhPjZRGySB5SE.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, CommonUsedScene commonUsedScene, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene_id", commonUsedScene.f11134O000000o);
            jSONObject.put("scene_name", commonUsedScene.O00000Oo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/UpdateCommonUsedSceneName").O000000o(arrayList).O000000o(), $$Lambda$hoa$2ce4ltZCl7UPSDFNNGBr585Ngmk.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O00000o0(Context context, String str, List<Long> list, fsm<JSONObject, fso> fsm) {
        int i;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (true) {
                if (list == null) {
                    i = 0;
                } else {
                    i = list.size();
                }
                if (i2 >= i) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(i2));
                jSONArray.put(sb.toString());
                i2++;
            }
            jSONObject.put("home_id", str);
            jSONObject.put("scene_ids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/appgateway/miot/appsceneservice/AppSceneService/ChangeCommonUsedSceneOrder").O000000o(arrayList).O000000o(), $$Lambda$hoa$v5LzxH8aKL5VLALUjMZxbM66UVQ.INSTANCE, Crypto.RC4, fsm);
    }

    public static fsn O00000oO(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("did", str);
            } catch (JSONException unused) {
            }
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/recom").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hoa.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }
}
