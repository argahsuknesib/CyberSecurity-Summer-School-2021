package _m_j;

import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class gxy extends gvq<List<gya>> {
    public static String O00000Oo = "gxy";
    public fg<Integer> O00000o0 = new fg<>();

    public final void O000000o(String str, final boolean z) {
        final Home O00000o = ggb.O00000Oo().O00000o(str);
        ArrayList arrayList = new ArrayList();
        if (z) {
            gge.O000000o();
            arrayList.addAll(gge.O00000oo());
        } else if (!(O00000o == null || O00000o.getDefDids() == null)) {
            arrayList.addAll(O00000o.getDefDids());
        }
        fru.O000000o().O000000o(z ? null : O00000o, "", arrayList, new fsm<JSONObject, fso>() {
            /* class _m_j.gxy.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                LogType logType = LogType.PUSH;
                String str = gxy.O00000Oo;
                gsy.O00000Oo(logType, str, "getMiPushDeviceSwitch: " + jSONObject.toString());
                ArrayList arrayList = new ArrayList();
                try {
                    gxy.this.O00000o0.setValue(Integer.valueOf(jSONObject.optInt("switch")));
                    JSONArray optJSONArray = jSONObject.optJSONArray("device_setting");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        gya gya = new gya();
                        gya.O00000Oo = optJSONObject.optString("did");
                        gya.O00000o0 = optJSONObject.optString("name");
                        gya.O00000o = optJSONObject.optString("roomid");
                        gya.O00000oO = optJSONObject.optString("model");
                        gya.O00000oo = Integer.valueOf(optJSONObject.optInt("status"));
                        if (!(z || O00000o == null || O00000o.getRoomList() == null)) {
                            List<Room> roomList = O00000o.getRoomList();
                            Room O00000o02 = ggb.O00000Oo().O00000o0(gya.O00000o);
                            if (O00000o02 != null) {
                                gya.O0000OOo = roomList.indexOf(O00000o02);
                                gya.O0000Oo0 = O00000o02.getDids().indexOf(gya.O00000Oo);
                            }
                        }
                        arrayList.add(gya);
                    }
                    Collections.sort(arrayList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gxy.this.f18385O000000o.postValue(arrayList);
            }

            public final void onFailure(fso fso) {
                gxy.this.f18385O000000o.postValue(new ArrayList());
                LogType logType = LogType.PUSH;
                String str = gxy.O00000Oo;
                gsy.O00000Oo(logType, str, "getMiPushDeviceSwitch: " + fso.toString());
            }
        }, (JSONObject) null);
    }
}
