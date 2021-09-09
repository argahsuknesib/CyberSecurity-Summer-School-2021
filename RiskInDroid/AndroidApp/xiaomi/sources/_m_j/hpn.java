package _m_j;

import android.content.Intent;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.MessageCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hpn {
    private static final hpn O00000o0 = new hpn();

    /* renamed from: O000000o  reason: collision with root package name */
    private String f471O000000o = "miIO.xdel";
    private String O00000Oo = "miIO.xset";

    /* access modifiers changed from: private */
    public static /* synthetic */ String O000000o(String str) throws JSONException {
        return str;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String O00000Oo(String str) throws JSONException {
        return str;
    }

    public static hpn O000000o() {
        return O00000o0;
    }

    public final void O000000o(DeviceStat deviceStat, String str, MessageCallback messageCallback) {
        JSONArray jSONArray;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("command");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("method", null);
                        if (this.f471O000000o.equalsIgnoreCase(optString)) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("params");
                            if (optJSONArray2 != null) {
                                O000000o(optJSONArray2, deviceStat, messageCallback);
                            }
                        } else if (this.O00000Oo.equalsIgnoreCase(optString) && (jSONArray = optJSONObject.getJSONArray("params")) != null) {
                            O000000o(jSONArray.toString(), deviceStat, messageCallback);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void O000000o(JSONArray jSONArray, DeviceStat deviceStat, final MessageCallback messageCallback) {
        hpm hpm = new hpm(deviceStat);
        hpk hpk = new hpk();
        hpk.f468O000000o = 1;
        hpk.O0000Oo0 = hpm.getDid();
        hpk.O0000Oo = hpm.getModel();
        hpk.O00000o0 = this.f471O000000o;
        hpk.O00000oo = jSONArray;
        hpo.O000000o(hpk, new Callback<String>() {
            /* class _m_j.hpn.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gsy.O000000o(3, "summer", "del gateway scene>>>".concat(String.valueOf((String) obj)));
                messageCallback.onSuccess(new Intent());
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "summer", str);
                messageCallback.onFailure(i, str);
            }
        }, hpi.f467O000000o);
    }

    public final void O000000o(DeviceStat deviceStat, String str, int i, int i2, final int i3, String str2, final List<Boolean> list, final MessageCallback messageCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("data_tkn", Integer.valueOf(i));
        hashMap.put("type", str);
        hashMap.put("cur", Integer.valueOf(i2));
        hashMap.put("total", Integer.valueOf(i3));
        hashMap.put("data", str2);
        hpo.O000000o(hpj.O000000o(new hpm(deviceStat), "send_data_frame", hashMap), new Callback<String>() {
            /* class _m_j.hpn.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                list.add(Boolean.TRUE);
                if (list.size() != i3) {
                    return;
                }
                if (list.contains(Boolean.FALSE)) {
                    messageCallback.onFailure(-1, "network request error...");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("result", str);
                messageCallback.onSuccess(intent);
            }

            public final void onFailure(int i, String str) {
                list.add(Boolean.FALSE);
                if (list.size() != i3) {
                    return;
                }
                if (list.contains(Boolean.FALSE)) {
                    messageCallback.onFailure(i, str);
                } else {
                    messageCallback.onSuccess(new Intent());
                }
            }
        }, $$Lambda$hpn$6yVL87UzHk8MoQzdEx98tylGB4A.INSTANCE);
    }

    private void O000000o(String str, DeviceStat deviceStat, MessageCallback messageCallback) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        O000000o(str, 700, arrayList);
        int size = arrayList.size();
        int nextInt = new Random().nextInt(65535);
        for (int i = 0; i < size; i++) {
            O000000o(deviceStat, nextInt, i, size, (String) arrayList.get(i), arrayList2, messageCallback);
        }
    }

    private void O000000o(DeviceStat deviceStat, int i, int i2, final int i3, String str, final List<Boolean> list, final MessageCallback messageCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("data_tkn", Integer.valueOf(i));
        hashMap.put("type", "scene");
        hashMap.put("cur", Integer.valueOf(i2));
        hashMap.put("total", Integer.valueOf(i3));
        hashMap.put("data", str);
        hpo.O000000o(hpj.O000000o(new hpm(deviceStat), "send_data_frame", hashMap), new Callback<String>() {
            /* class _m_j.hpn.AnonymousClass3 */

            public final void onFailure(int i, String str) {
                list.add(Boolean.FALSE);
                if (list.size() != i3) {
                    return;
                }
                if (list.contains(Boolean.FALSE)) {
                    messageCallback.onFailure(-1, "");
                } else {
                    messageCallback.onSuccess(new Intent());
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                list.add(Boolean.TRUE);
                if (list.size() != i3) {
                    return;
                }
                if (list.contains(Boolean.FALSE)) {
                    messageCallback.onFailure(-1, "");
                } else {
                    messageCallback.onSuccess(new Intent());
                }
            }
        }, $$Lambda$hpn$gdNgP9hoThOBLPnZjV9oPY6GZzI.INSTANCE);
    }

    public final void O000000o(String str, int i, List<String> list) {
        while (str != null && i > 0) {
            if (O000000o(str, str.length()) <= i) {
                list.add(str);
                return;
            }
            i = O000000o(str, i);
            String substring = str.substring(0, i);
            str = str.substring(i);
            list.add(substring);
        }
    }

    private static int O000000o(String str, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i2 + 1;
            i3 = str.substring(i2, i4).matches("[Α-￥]") ? i3 + 3 : i3 + 1;
            if (i3 >= i) {
                return i2;
            }
            i2 = i4;
        }
        return i;
    }
}
