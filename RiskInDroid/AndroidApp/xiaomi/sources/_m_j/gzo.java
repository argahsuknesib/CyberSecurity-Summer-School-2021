package _m_j;

import android.util.Log;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.multikey.PowerMultikeyBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gzo {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18628O000000o;

    public final void O000000o(String str, ArrayList<PowerMultikeyBean> arrayList, fsm<String, fso> fsm) {
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<PowerMultikeyBean> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().O000000o());
            }
            jSONObject.put("members", jSONArray);
            jSONObject.put("did", str);
        } catch (JSONException e) {
            Log.e("PowerMultikeyApi", "requestInit", e);
        }
        arrayList2.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/init_membership").O000000o(arrayList2).O000000o(), new fss<String>() {
            /* class _m_j.gzo.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public final void O00000Oo(String str, ArrayList<PowerMultikeyBean> arrayList, fsm<String, fso> fsm) {
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<PowerMultikeyBean> it = arrayList.iterator();
            while (it.hasNext()) {
                PowerMultikeyBean next = it.next();
                this.f18628O000000o = true;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", Long.parseLong(next.f10066O000000o));
                } catch (NumberFormatException e) {
                    Log.e("PowerMultikeyApi", "requestUpdate", e);
                }
                jSONObject2.put("field", next.O000000o());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("update_fields", jSONArray);
            jSONObject.put("did", str);
        } catch (JSONException e2) {
            Log.e("PowerMultikeyApi", "requestUpdate", e2);
        }
        arrayList2.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/update_membership").O000000o(arrayList2).O000000o(), new fss<String>() {
            /* class _m_j.gzo.AnonymousClass3 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public static String O000000o(List<PowerMultikeyBean> list, int i) {
        int size = list.size();
        if (size == 2) {
            return CommonApplication.getAppContext().getResources().getStringArray(R.array.multikey_keyname_double)[i];
        }
        if (size == 3) {
            return CommonApplication.getAppContext().getResources().getStringArray(R.array.multikey_keyname_three)[i];
        }
        int i2 = i + 1;
        return CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.multikey_keyname_more, i2, Integer.valueOf(i2));
    }

    public static List<String> O000000o() {
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo());
        ArrayList arrayList = new ArrayList();
        for (Room name : O000000o2) {
            arrayList.add(name.getName());
        }
        return arrayList;
    }
}
