package _m_j;

import android.content.Context;
import android.util.Log;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.infrared.bean.IRFunctionType;
import com.xiaomi.smarthome.infrared.bean.IRType;
import com.xiaomi.smarthome.infrared.bean.InfraredControllerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class gjc {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f17826O000000o;
    private ArrayList<fsn> O00000Oo = new ArrayList<>();

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|16|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004b */
    public final void O000000o(DeviceStat deviceStat, Map<String, InfraredControllerInfo> map, fsm<giy, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, InfraredControllerInfo> value : map.entrySet()) {
                InfraredControllerInfo infraredControllerInfo = (InfraredControllerInfo) value.getValue();
                IRFunctionType iRFunctionType = infraredControllerInfo.O0000O0o;
                IRType iRType = infraredControllerInfo.O00000o;
                if (iRFunctionType != IRFunctionType.STUDY) {
                    jSONObject.put("controller_id", Integer.parseInt(infraredControllerInfo.O00000oo));
                }
                if (iRType == IRType.STB) {
                    jSONObject.put("lineup_id", infraredControllerInfo.O0000Oo0);
                }
                String str = infraredControllerInfo.O00000o0;
                if (str != null) {
                    jSONObject.put("brand_id", Integer.parseInt(str));
                    jSONObject.put("brand_id", str);
                }
                jSONObject.put("parent_id", deviceStat.did);
                jSONObject.put("category", infraredControllerInfo.O00000o.value());
                jSONObject.put("name", infraredControllerInfo.f9040O000000o);
            }
        } catch (Throwable th) {
            Log.e("InifraredRequestApi", "requestCreateIR", th);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/irdevice/controller/add").O000000o(arrayList).O000000o();
        O000000o o000000o = new O000000o(fsm);
        O000000o(CoreApi.O000000o().O000000o(this.f17826O000000o, O000000o2, new fss<giy>() {
            /* class _m_j.gjc.AnonymousClass13 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return giy.O000000o(jSONObject);
            }
        }, Crypto.RC4, o000000o), o000000o);
    }

    public final void O000000o(fsn fsn, O000000o o000000o) {
        o000000o.O000000o(this.O00000Oo, fsn);
        this.O00000Oo.add(fsn);
    }

    public final void O000000o() {
        Iterator<fsn> it = this.O00000Oo.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.f17826O000000o = null;
    }

    public static class O000000o<R, E extends fso> extends fsm<R, E> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final fsm<R, E> f17840O000000o;
        private fsn O00000Oo;
        private ArrayList<fsn> O00000o0;

        public O000000o(fsm<R, E> fsm) {
            this.f17840O000000o = fsm;
        }

        public final void O000000o(ArrayList<fsn> arrayList, fsn fsn) {
            this.O00000o0 = arrayList;
            this.O00000Oo = fsn;
        }

        public final void onSuccess(R r) {
            this.O00000o0.remove(this.O00000Oo);
            fsm<R, E> fsm = this.f17840O000000o;
            if (fsm != null) {
                fsm.onSuccess(r);
            }
        }

        public final void onFailure(E e) {
            this.O00000o0.remove(this.O00000Oo);
            fsm<R, E> fsm = this.f17840O000000o;
            if (fsm != null) {
                fsm.onFailure(e);
            }
        }
    }
}
