package _m_j;

import _m_j.hgt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gzz extends fm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f18676O000000o = "HomeEnvInfoViewModel";
    public static int O00000Oo = 43200;
    public static List<String> O0000O0o = Arrays.asList(CommonApplication.getAppContext().getResources().getStringArray(R.array.home_env_type));
    public BroadcastReceiver O00000o;
    SharedPreferences O00000o0;
    public AtomicBoolean O00000oO = new AtomicBoolean(false);
    AtomicBoolean O00000oo = new AtomicBoolean(false);
    public HashMap<String, List<O000000o>> O0000OOo = new HashMap<>();
    public fg<Map<String, hgt>> O0000Oo = new fg<>();
    HashMap<String, List<O000000o>> O0000Oo0 = new HashMap<>();
    public fg<Map<String, hgu>> O0000OoO = new fg<>();
    public fg<Map<String, List<hgr>>> O0000Ooo = new fg<>();

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18681O000000o;
        String O00000Oo;
        int O00000o = 0;
        List<hgt.O000000o> O00000o0 = new ArrayList();

        public O000000o(String str, String str2, List<hgt.O000000o> list) {
            this.f18681O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0.clear();
            this.O00000o0.addAll(list);
        }
    }

    public final fg<Map<String, hgt>> O000000o() {
        if (this.O0000Oo.getValue() == null) {
            O000000o(ggb.O00000Oo().O0000OOo());
        }
        return this.O0000Oo;
    }

    public final fg<Map<String, hgu>> O00000Oo() {
        if (this.O0000OoO.getValue() == null) {
            O000000o(ggb.O00000Oo().O0000OOo());
        }
        return this.O0000OoO;
    }

    public final fg<Map<String, List<hgr>>> O00000o0() {
        if (this.O0000Ooo.getValue() == null) {
            O000000o(ggb.O00000Oo().O0000OOo());
        }
        return this.O0000Ooo;
    }

    public final void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = f18676O000000o;
            gsy.O00000Oo(str2, "home id is null!" + System.currentTimeMillis());
            if (this.O00000o == null) {
                this.O00000o = new O00000Oo();
                ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O00000o, new IntentFilter("home_room_updated"));
                return;
            }
            return;
        }
        if (this.O00000o != null) {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O00000o);
        }
        O0000O0o(str);
        O00000oo(str);
        O00000oO(str);
    }

    private void O00000oO(final String str) {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            hgs.O000000o().O000000o(str, new fsm<JSONObject, fso>() {
                /* class _m_j.gzz.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null && !jSONObject.isNull("result")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("result");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            hgr O000000o2 = hgr.O000000o(optJSONArray.optJSONObject(i));
                            if (!TextUtils.isEmpty(O000000o2.f18915O000000o) && !TextUtils.isEmpty(O000000o2.O00000Oo)) {
                                arrayList.add(O000000o2);
                            }
                        }
                        Map value = gzz.this.O0000Ooo.getValue();
                        if (value == null) {
                            value = new HashMap();
                        }
                        value.put(str, arrayList);
                        gzz.this.O0000Ooo.postValue(value);
                        gzz gzz = gzz.this;
                        String str = str;
                        if (gzz.O00000o0 == null) {
                            gzz.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
                        }
                        if (jSONObject != null) {
                            SharedPreferences.Editor edit = gzz.O00000o0.edit();
                            edit.putString(str + "env_device", jSONObject.toString()).apply();
                        }
                    }
                    gsy.O00000Oo(gzz.f18676O000000o, "loadDefaultEnvDeviceFromServer succ: ".concat(String.valueOf(jSONObject)));
                }

                public final void onFailure(fso fso) {
                    String str = gzz.f18676O000000o;
                    gsy.O00000Oo(str, "loadDefaultEnvDeviceFromServer err " + fso.O00000Oo);
                }
            });
        }
    }

    private void O00000oo(final String str) {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            hgs.O000000o().O00000Oo(str, ((int) (System.currentTimeMillis() / 1000)) - O00000Oo, O0000O0o, new fsm<JSONObject, fso>() {
                /* class _m_j.gzz.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    hgu hgu;
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        Map value = gzz.this.O0000OoO.getValue();
                        if (value == null) {
                            value = new HashMap();
                        }
                        value.put(str, hgu.O000000o(jSONObject));
                        gzz.this.O0000OoO.postValue(value);
                        gzz gzz = gzz.this;
                        String str = str;
                        if (gzz.O00000o0 == null) {
                            gzz.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
                        }
                        Map value2 = gzz.O0000OoO.getValue();
                        if (!(value2 == null || (hgu = (hgu) value2.get(str)) == null)) {
                            SharedPreferences.Editor edit = gzz.O00000o0.edit();
                            edit.putString(str + "top_data", hgu.O000000o().toString()).apply();
                        }
                        gsy.O00000Oo(gzz.f18676O000000o, "loadTopWidgetInfoFromServer succ: ".concat(String.valueOf(jSONObject)));
                    }
                }

                public final void onFailure(fso fso) {
                    Map value = gzz.this.O0000OoO.getValue();
                    if (value == null) {
                        value = new HashMap();
                    }
                    value.put(str, new hgu());
                    gzz.this.O0000OoO.postValue(value);
                    String str = gzz.f18676O000000o;
                    gsy.O00000Oo(str, "loadTopWidgetInfoFromServer err " + fso.O00000Oo);
                }
            });
        }
    }

    private void O0000O0o(final String str) {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4 && !this.O00000oO.getAndSet(true)) {
            hgs.O000000o().O000000o(str, ((int) (System.currentTimeMillis() / 1000)) - O00000Oo, O0000O0o, new fsm<hgt, fso>() {
                /* class _m_j.gzz.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    hgt hgt;
                    hgt hgt2 = (hgt) obj;
                    if (hgt2 != null) {
                        Map value = gzz.this.O0000Oo.getValue();
                        hgt2.O000000o();
                        gzz.this.O000000o(str, hgt2);
                        gzz.this.O00000Oo(str, hgt2);
                        if (value == null) {
                            value = new HashMap();
                        }
                        value.put(str, hgt2);
                        gzz.this.O0000Oo.postValue(value);
                        gzz gzz = gzz.this;
                        String str = str;
                        if (gzz.O00000o0 == null) {
                            gzz.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
                        }
                        Map value2 = gzz.O0000Oo.getValue();
                        if (!(value2 == null || (hgt = (hgt) value2.get(str)) == null)) {
                            SharedPreferences.Editor edit = gzz.O00000o0.edit();
                            edit.putString(str + "env_data", hgt.O00000Oo().toString()).apply();
                        }
                        String str2 = gzz.f18676O000000o;
                        gsy.O00000Oo(str2, "getDeviceDescription onSuccess " + hgt2.f18921O000000o.size() + " " + gzz.this.O0000OOo.size());
                    }
                    gzz.this.O00000oO.set(false);
                }

                public final void onFailure(fso fso) {
                    gzz.this.O00000oO.set(false);
                    String str = gzz.f18676O000000o;
                    gsy.O00000Oo(str, "getDeviceDescription err " + fso.O00000Oo);
                }
            });
        }
    }

    public final void O00000Oo(String str) {
        Map value = this.O0000Oo.getValue();
        if ((value == null || value.get(str) == null || ((hgt) value.get(str)).f18921O000000o == null || ((hgt) value.get(str)).f18921O000000o.isEmpty()) && !this.O00000oo.get()) {
            O0000OOo(str);
            O0000Oo0(str);
            this.O00000oo.set(true);
        }
    }

    public final void O000000o(String str, hgt hgt) {
        ArrayList arrayList = new ArrayList();
        Home O00000o2 = ggb.O00000Oo().O00000o(str);
        if (O00000o2 != null) {
            if (hgt == null || hgt.f18921O000000o == null || hgt.f18921O000000o.isEmpty()) {
                this.O0000OOo.put(str, arrayList);
                return;
            }
            HashMap hashMap = new HashMap();
            List<hgt.O000000o> list = hgt.f18921O000000o;
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= list.size()) {
                    break;
                }
                hgt.O000000o o000000o = list.get(i);
                if (fno.O000000o().O000000o(o000000o.O00000Oo) != null) {
                    if (TextUtils.isEmpty(o000000o.O0000OOo) || TextUtils.equals(o000000o.O0000OOo, "mijia.roomid.default")) {
                        o000000o.O0000OOo = "mijia.roomid.default";
                    } else {
                        Room O00000o02 = ggb.O00000Oo().O00000o0(o000000o.O0000OOo);
                        if (O00000o02 == null || !TextUtils.equals(O00000o02.getParentid(), str)) {
                            z = false;
                        }
                    }
                    if (z) {
                        List list2 = (List) hashMap.get(o000000o.O0000OOo);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            hashMap.put(o000000o.O0000OOo, list2);
                        }
                        list2.add(o000000o);
                    }
                }
                i++;
            }
            if (hashMap.isEmpty()) {
                this.O0000OOo.put(str, arrayList);
                return;
            }
            for (List sort : hashMap.values()) {
                Collections.sort(sort, $$Lambda$gzz$G5ffCf5ELZ4ZHfyYNljKL6sr1VM.INSTANCE);
            }
            List<Room> O000000o2 = ggb.O00000Oo().O000000o(str);
            if (O000000o2 != null && !O000000o2.isEmpty()) {
                for (int i2 = 0; i2 < O000000o2.size(); i2++) {
                    Room room = O000000o2.get(i2);
                    List list3 = (List) hashMap.get(room.getId());
                    if (list3 != null && !list3.isEmpty()) {
                        arrayList.add(new O000000o(room.getName(), room.getId(), list3));
                    }
                }
            }
            List list4 = (List) hashMap.get("mijia.roomid.default");
            if (list4 != null && !list4.isEmpty()) {
                arrayList.add(new O000000o(ServiceApplication.getAppContext().getResources().getString(R.string.default_room), "mijia.roomid.default", list4));
            }
            if (!arrayList.isEmpty()) {
                if (O00000o2.isOwner()) {
                    O000000o o000000o2 = new O000000o("", "", new ArrayList());
                    o000000o2.O00000o = 1;
                    arrayList.add(o000000o2);
                }
                this.O0000OOo.put(str, arrayList);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O000000o(hgt.O000000o o000000o, hgt.O000000o o000000o2) {
        return O0000O0o.indexOf(o000000o.O0000O0o) - O0000O0o.indexOf(o000000o2.O0000O0o);
    }

    public final void O00000Oo(String str, hgt hgt) {
        ArrayList arrayList = new ArrayList();
        if (ggb.O00000Oo().O00000o(str) != null) {
            if (hgt == null || hgt.f18921O000000o == null || hgt.f18921O000000o.isEmpty()) {
                this.O0000Oo0.put(str, arrayList);
                return;
            }
            HashMap hashMap = new HashMap();
            List<hgt.O000000o> list = hgt.f18921O000000o;
            for (int i = 0; i < list.size(); i++) {
                hgt.O000000o o000000o = list.get(i);
                if (fno.O000000o().O000000o(o000000o.O00000Oo) != null) {
                    boolean z = true;
                    if (TextUtils.isEmpty(o000000o.O0000OOo) || TextUtils.equals(o000000o.O0000OOo, "mijia.roomid.default")) {
                        o000000o.O0000OOo = "mijia.roomid.default";
                    } else {
                        Room O00000o02 = ggb.O00000Oo().O00000o0(o000000o.O0000OOo);
                        if (O00000o02 == null || !TextUtils.equals(O00000o02.getParentid(), str)) {
                            z = false;
                        }
                    }
                    if (z) {
                        List list2 = (List) hashMap.get(o000000o.O0000O0o);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            hashMap.put(o000000o.O0000O0o, list2);
                        }
                        list2.add(o000000o);
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                ArrayList<String> arrayList2 = new ArrayList<>(hashMap.keySet());
                Collections.sort(arrayList2, $$Lambda$gzz$EYQlJi6WnKYX8fE67IVQhKuxiYU.INSTANCE);
                List<Room> O000000o2 = ggb.O00000Oo().O000000o(str);
                if (O000000o2 != null) {
                    List asList = Arrays.asList(ServiceApplication.getAppContext().getResources().getStringArray(R.array.home_env_type_desc));
                    for (String str2 : arrayList2) {
                        List<hgt.O000000o> list3 = (List) hashMap.get(str2);
                        Collections.sort(list3, new Comparator(O000000o2) {
                            /* class _m_j.$$Lambda$gzz$RvVto5euYcSXWyyyCBUhe730Cg */
                            private final /* synthetic */ List f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final int compare(Object obj, Object obj2) {
                                return gzz.O000000o(this.f$0, (hgt.O000000o) obj, (hgt.O000000o) obj2);
                            }
                        });
                        if (list3 != null && !list3.isEmpty()) {
                            ArrayList arrayList3 = new ArrayList();
                            for (hgt.O000000o o000000o2 : list3) {
                                if (!fno.O000000o().O000000o(o000000o2.O00000Oo).isOnline) {
                                    arrayList3.add(o000000o2);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                list3.removeAll(arrayList3);
                                list3.addAll(arrayList3);
                            }
                            int indexOf = O0000O0o.indexOf(str2);
                            arrayList.add(new O000000o((indexOf < 0 || indexOf >= asList.size()) ? "err" : (String) asList.get(indexOf), str2, list3));
                        }
                    }
                }
                this.O0000Oo0.put(str, arrayList);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O000000o(String str, String str2) {
        return O0000O0o.indexOf(str) - O0000O0o.indexOf(str2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O000000o(List list, hgt.O000000o o000000o, hgt.O000000o o000000o2) {
        Room O00000o02 = ggb.O00000Oo().O00000o0(o000000o.O0000OOo);
        Room O00000o03 = ggb.O00000Oo().O00000o0(o000000o2.O0000OOo);
        return (O00000o02 != null ? list.indexOf(O00000o02) : list.size()) - (O00000o03 != null ? list.indexOf(O00000o03) : list.size());
    }

    public final List<O000000o> O00000o0(String str) {
        return this.O0000OOo.get(str);
    }

    public final List<O000000o> O00000o(String str) {
        return this.O0000Oo0.get(str);
    }

    private void O0000OOo(String str) {
        if (this.O00000o0 == null) {
            this.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
        }
        try {
            SharedPreferences sharedPreferences = this.O00000o0;
            String string = sharedPreferences.getString(str + "env_data", "");
            if (string != null) {
                if (!string.isEmpty()) {
                    hgt O000000o2 = hgt.O000000o(new JSONObject(string));
                    if (O000000o2 != null) {
                        O000000o2.O000000o();
                        O000000o(str, O000000o2);
                        O00000Oo(str, O000000o2);
                        Map value = this.O0000Oo.getValue();
                        if (value == null) {
                            value = new HashMap();
                        }
                        value.put(str, O000000o2);
                        this.O0000Oo.postValue(value);
                        String str2 = f18676O000000o;
                        gsy.O00000Oo(str2, "readEnvInfoCache onSuccess " + O000000o2.f18921O000000o.size() + " " + this.O0000OOo.size());
                        return;
                    }
                    return;
                }
            }
            gsy.O00000Oo(f18676O000000o, "readEnvInfoCache: empty!");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void O0000Oo0(String str) {
        if (this.O00000o0 == null) {
            this.O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("home_env_info", 0);
        }
        try {
            SharedPreferences sharedPreferences = this.O00000o0;
            String string = sharedPreferences.getString(str + "env_device", "");
            if (TextUtils.isEmpty(string)) {
                gsy.O00000Oo(f18676O000000o, "readDefaultEnvDeviceCache: empty!");
                return;
            }
            JSONObject jSONObject = new JSONObject(string);
            if (!jSONObject.isNull("result")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hgr O000000o2 = hgr.O000000o(optJSONArray.optJSONObject(i));
                    if (!TextUtils.isEmpty(O000000o2.f18915O000000o) && !TextUtils.isEmpty(O000000o2.O00000Oo)) {
                        arrayList.add(O000000o2);
                    }
                }
                Map value = this.O0000Ooo.getValue();
                if (value == null) {
                    value = new HashMap();
                }
                value.put(str, arrayList);
                this.O0000Ooo.postValue(value);
            }
            gsy.O00000Oo(f18676O000000o, "readDefaultEnvDeviceCache : ".concat(String.valueOf(string)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class O00000Oo extends BroadcastReceiver {
        O00000Oo() {
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("operation");
            int intExtra = intent.getIntExtra("result_code", -1);
            if (TextUtils.equals(action, "home_room_updated") && TextUtils.equals("home_room_sync", stringExtra) && intExtra == ErrorCode.SUCCESS.getCode() && !TextUtils.isEmpty(ggb.O00000Oo().O0000OOo())) {
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(gzz.this.O00000o);
                gzz.this.O00000o = null;
                String str = gzz.f18676O000000o;
                gsy.O00000Oo(str, "home id is ready!" + System.currentTimeMillis());
                gzz.this.O000000o(ggb.O00000Oo().O0000OOo());
            }
        }
    }
}
