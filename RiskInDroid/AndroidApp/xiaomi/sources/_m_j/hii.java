package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hii {
    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    public static void O000000o(Context context, JSONObject jSONObject, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/nfctag/run_scene").O000000o(arrayList).O000000o(), $$Lambda$hii$wbn9s1jEAQ1kon2H7LxDv2L2VzQ.INSTANCE, Crypto.RC4, fsm);
    }

    public static void O000000o(Context context, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/delete").O000000o(arrayList).O000000o(), $$Lambda$hii$HUA6pBdyo9NRKcaXF0vK5qDtkBg.INSTANCE, Crypto.RC4, (fsm) null);
    }

    public static void O000000o(Context context, List<String> list, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
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
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/nfctag/get_device_connect_info").O000000o(arrayList).O000000o(), $$Lambda$hii$0uQhwGGGB0Nr9oNPvOZotiuGlk.INSTANCE, Crypto.RC4, fsm);
    }
}
