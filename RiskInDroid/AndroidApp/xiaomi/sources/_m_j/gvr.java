package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiRoomItem;
import com.xiaomi.smarthome.mibrain.roomsetting.model.XiaoAiVoiceCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class gvr {
    private static final String O00000o = "gvr";
    private static volatile gvr O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<String> f18386O000000o = new ArrayList();
    public Map<String, List<XiaoAiVoiceCategory>> O00000Oo = new ConcurrentHashMap();
    public Map<String, List<XiaoAiRoomItem>> O00000o0 = new ConcurrentHashMap();

    private gvr() {
    }

    public static gvr O000000o() {
        if (O00000oO == null) {
            synchronized (gvr.class) {
                if (O00000oO == null) {
                    O00000oO = new gvr();
                }
            }
        }
        return O00000oO;
    }

    public final void O000000o(final Room room, final fsm<List<XiaoAiRoomItem>, fso> fsm) {
        if (room != null) {
            fru.O000000o().O00000oo(room.getId(), new fsm<JSONObject, fso>() {
                /* class _m_j.gvr.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    XiaoAiRoomItem O000000o2;
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject == null) {
                        try {
                            if (fsm != null) {
                                fsm.onFailure(new fso(-1, "response is null or result is null"));
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    if (optJSONArray == null) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onFailure(new fso(-1, "result cannot cast to JSONArray"));
                            return;
                        }
                        return;
                    }
                    List list = gvr.this.O00000o0.get(gvr.O000000o(room));
                    if (list == null) {
                        list = new ArrayList();
                        gvr.this.O00000o0.put(gvr.O000000o(room), list);
                    }
                    list.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (!(optJSONObject == null || (O000000o2 = XiaoAiRoomItem.O000000o(optJSONObject)) == null || TextUtils.isEmpty(O000000o2.O00000Oo))) {
                            list.add(O000000o2);
                        }
                    }
                    fsm fsm2 = fsm;
                    if (fsm2 != null) {
                        fsm2.onSuccess(list);
                    }
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                }
            });
        } else if (fsm != null) {
            fsm.onFailure(new fso(-1, "room and did cannot be empty"));
        }
    }

    public static String O000000o(Room room) {
        if (room == null) {
            return "";
        }
        return room.getParentid() + "_" + room.getId();
    }

    public static void O000000o(fsm<List<String>, fso> fsm) {
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null && 2 == device.voiceCtrl) {
                arrayList.add(device.did);
            }
        }
        fsm.onSuccess(arrayList);
    }

    private XiaoAiVoiceCategory O000000o(String str, String str2) {
        List list;
        Map<String, List<XiaoAiVoiceCategory>> map = this.O00000Oo;
        if (map != null && !map.isEmpty()) {
            try {
                Room O00000o02 = ggb.O00000Oo().O00000o0(str);
                if (!(O00000o02 == null || (list = this.O00000Oo.get(O000000o(O00000o02))) == null)) {
                    if (!list.isEmpty()) {
                        for (int i = 0; i < list.size(); i++) {
                            XiaoAiVoiceCategory xiaoAiVoiceCategory = (XiaoAiVoiceCategory) list.get(i);
                            if (xiaoAiVoiceCategory != null && TextUtils.equals(str2, xiaoAiVoiceCategory.f9513O000000o)) {
                                return xiaoAiVoiceCategory;
                            }
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final void O000000o(List<String> list, final XiaoAiRoomItem xiaoAiRoomItem, final fsm<Void, fso> fsm) {
        fru.O000000o().O000000o(xiaoAiRoomItem.f9512O000000o, xiaoAiRoomItem.O00000Oo, xiaoAiRoomItem.O000000o(O000000o(xiaoAiRoomItem.f9512O000000o, xiaoAiRoomItem.O00000Oo)), list, xiaoAiRoomItem.O00000o, new fsm<JSONObject, fso>() {
            /* class _m_j.gvr.AnonymousClass3 */

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gvr.this.O000000o(ggb.O00000Oo().O00000o0(xiaoAiRoomItem.f9512O000000o), (fsm<List<XiaoAiRoomItem>, fso>) null);
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(null);
                }
            }
        });
    }
}
