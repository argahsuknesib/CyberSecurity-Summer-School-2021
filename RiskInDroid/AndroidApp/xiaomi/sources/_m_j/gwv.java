package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.miio.consumables.DeviceConsumble;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gwv {
    private static volatile gwv O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    public ger f18435O000000o;
    public SharedPreferences O00000Oo;
    public HashMap<String, List<DeviceConsumble>> O00000o = new HashMap<>();
    public HashMap<String, List<DeviceConsumble>> O00000o0 = new HashMap<>();
    public HashMap<String, Integer> O00000oO = new HashMap<>();
    Handler O00000oo;
    public Set<String> O0000O0o = new HashSet();
    private HandlerThread O0000Oo = new gpq("ConsumableDataManager");
    private Handler O0000Oo0;
    private BroadcastReceiver O0000OoO = new BroadcastReceiver() {
        /* class _m_j.gwv.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action_on_login_success".equals(action)) {
                gwv.this.O000000o();
            } else if ("action_on_logout".equals(action)) {
                gwv.this.O00000o0();
            }
        }
    };

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

    private gwv() {
        this.O0000Oo.start();
        this.O0000Oo0 = new Handler(this.O0000Oo.getLooper()) {
            /* class _m_j.gwv.AnonymousClass2 */

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1) {
                    String str = (String) message.obj;
                    JSONArray jSONArray = null;
                    ArrayList arrayList = new ArrayList();
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ggb.O00000Oo();
                            arrayList.add(ggb.O000000o(jSONArray.optJSONObject(i2)));
                        }
                    }
                    gwv.this.O000000o(arrayList);
                    gwv.this.O00000oo.sendEmptyMessage(1);
                } else if (i == 2) {
                    String str2 = (String) message.obj;
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split("%%%");
                        if (split.length > 0) {
                            String str3 = split[0];
                            if (str3.length() + 3 < str2.length()) {
                                String substring = str2.substring(str3.length() + 3);
                                gwv gwv = gwv.this;
                                if (!TextUtils.isEmpty(CoreApi.O000000o().O0000o0()) && !TextUtils.isEmpty(str3)) {
                                    try {
                                        String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
                                        if (!TextUtils.isEmpty(O000000o2)) {
                                            Context appContext = ServiceApplication.getAppContext();
                                            gwv.O00000Oo = appContext.getSharedPreferences(O000000o2 + str3 + "_consumable_list", 0);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    if (gwv.O00000Oo != null && !TextUtils.isEmpty(substring)) {
                                        SharedPreferences.Editor edit = gwv.O00000Oo.edit();
                                        edit.putString("consumable_cache", substring);
                                        edit.putInt("version", 1);
                                        edit.apply();
                                        gwv.O00000oo.sendEmptyMessage(2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        this.O00000oo = new Handler(Looper.getMainLooper()) {
            /* class _m_j.gwv.AnonymousClass3 */

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
                int i = message.what;
                if (i == 1) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        String id = list.get(i2).getId();
                        if (!gwv.this.O00000oO.containsKey(id)) {
                            gwv.this.O00000oO.put(id, -1);
                        }
                        if (gwv.this.O00000oO.get(list.get(i2).getId()).intValue() <= 0) {
                            gsy.O00000Oo("ConsumableData", "data from cache to mData");
                            if (gwv.this.O00000o0.containsKey(id)) {
                                gwv.this.O00000o0.get(id).clear();
                            } else {
                                gwv.this.O00000o0.put(id, new ArrayList());
                            }
                            if (gwv.this.O00000o.containsKey(id)) {
                                gwv.this.O00000o0.get(id).addAll(gwv.this.O00000o.get(id));
                            }
                            if (gwv.this.O00000oO.containsKey(id)) {
                                gwv.this.O00000oO.remove(id);
                            }
                            gwv.this.O00000oO.put(id, 0);
                        }
                    }
                } else if (i == 2) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        String id2 = list.get(i3).getId();
                        if (!gwv.this.O00000oO.containsKey(id2)) {
                            gwv.this.O00000oO.put(id2, -1);
                        }
                        if (gwv.this.O00000oO.get(id2).intValue() <= 0) {
                            gsy.O00000Oo("ConsumableData", "读缓存，有展示机会");
                            gwv.this.O000000o();
                            return;
                        }
                    }
                }
            }
        };
        O000000o();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O0000OoO, intentFilter);
    }

    public final void O000000o() {
        Message obtainMessage = this.O0000Oo0.obtainMessage();
        obtainMessage.what = 1;
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i).toJSON());
            }
        }
        obtainMessage.obj = jSONArray.toString();
        this.O0000Oo0.sendMessage(obtainMessage);
    }

    public final void O000000o(List<Home> list) {
        JSONArray optJSONArray;
        if (!list.isEmpty() && !TextUtils.isEmpty(CoreApi.O000000o().O0000o0())) {
            for (int i = 0; i < list.size(); i++) {
                String id = list.get(i).getId();
                try {
                    String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
                    if (!TextUtils.isEmpty(O000000o2)) {
                        Context appContext = ServiceApplication.getAppContext();
                        this.O00000Oo = appContext.getSharedPreferences(O000000o2 + id + "_consumable_list", 0);
                    }
                } catch (Exception unused) {
                }
                SharedPreferences sharedPreferences = this.O00000Oo;
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString("consumable_cache", "");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            if (jSONObject.has("items") && (optJSONArray = jSONObject.optJSONArray("items")) != null) {
                                if (this.O00000o.containsKey(id)) {
                                    this.O00000o.get(id).clear();
                                } else {
                                    this.O00000o.put(id, new ArrayList());
                                }
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    DeviceConsumble O000000o3 = gww.O000000o(CommonApplication.getAppContext(), optJSONArray.optJSONObject(i2));
                                    if (O000000o3 != null) {
                                        this.O00000o.get(id).add(O000000o3);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else if (this.O00000o.containsKey(id)) {
                        this.O00000o.get(id).clear();
                    } else {
                        this.O00000o.put(id, new ArrayList());
                    }
                }
            }
        }
    }

    private List<DeviceConsumble> O000000o(String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(CoreApi.O000000o().O0000o0()) && !TextUtils.isEmpty(str)) {
            try {
                String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
                if (!TextUtils.isEmpty(O000000o2)) {
                    Context appContext = ServiceApplication.getAppContext();
                    this.O00000Oo = appContext.getSharedPreferences(O000000o2 + str + "_consumable_list", 0);
                }
            } catch (Exception unused) {
            }
            SharedPreferences sharedPreferences = this.O00000Oo;
            if (sharedPreferences == null) {
                return null;
            }
            String string = sharedPreferences.getString("consumable_cache", "");
            if (TextUtils.isEmpty(string)) {
                return new ArrayList();
            }
            arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("items") && (optJSONArray = jSONObject.optJSONArray("items")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        DeviceConsumble O000000o3 = gww.O000000o(CommonApplication.getAppContext(), optJSONArray.optJSONObject(i));
                        if (O000000o3 != null) {
                            arrayList.add(O000000o3);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void O000000o(String str, List<DeviceConsumble> list) {
        if (list != null) {
            List<DeviceConsumble> O000000o2 = O000000o(str);
            if (O000000o2 != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (list.get(size).isSkipRpc) {
                        for (int i = 0; i < O000000o2.size(); i++) {
                            if (TextUtils.equals(O000000o2.get(i).did, list.get(size).did)) {
                                list.remove(size);
                                list.add(size, O000000o2.get(i));
                            }
                        }
                    }
                }
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    JSONObject O000000o3 = gww.O000000o(list.get(i2));
                    if (O000000o3 != null) {
                        jSONArray.put(O000000o3);
                    }
                }
                gsy.O00000Oo("ConsumableData", "写入缓存的大小：【 " + jSONArray.length() + " 】");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("items", jSONArray);
                    Message obtainMessage = this.O0000Oo0.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.obj = str + "%%%" + jSONObject.toString();
                    this.O0000Oo0.sendMessage(obtainMessage);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static gwv O00000Oo() {
        if (O0000OOo == null) {
            synchronized (gwv.class) {
                if (O0000OOo == null) {
                    O0000OOo = new gwv();
                }
            }
        }
        return O0000OOo;
    }

    private boolean O00000o() {
        try {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.O00000Oo = appContext.getSharedPreferences(O000000o2 + "_consumable_list", 0);
            }
        } catch (Exception unused) {
        }
        SharedPreferences sharedPreferences = this.O00000Oo;
        if (sharedPreferences == null) {
            return true;
        }
        if (System.currentTimeMillis() - sharedPreferences.getLong("timestamp", 0) >= 604800000) {
            return true;
        }
        return false;
    }

    private void O00000oO() {
        try {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.O00000Oo = appContext.getSharedPreferences(O000000o2 + "_consumable_list", 0);
            }
        } catch (Exception unused) {
        }
        SharedPreferences sharedPreferences = this.O00000Oo;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove("timestamp");
            edit.apply();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void
     arg types: [android.content.Context, java.lang.String, int, _m_j.gwv$4]
     candidates:
      _m_j.gwv.O000000o(android.content.Context, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void
      _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.gwx):void
      _m_j.gwv.O000000o(android.content.Context, java.lang.String, boolean, _m_j.fsm<org.json.JSONObject, _m_j.fso>):void */
    public final void O000000o(Context context) {
        final boolean O00000o2 = O00000o();
        if (O00000o2) {
            O00000oO();
        }
        O00000oo();
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            O000000o(context, ggb.O00000Oo().O0000OOo(), true, (fsm<JSONObject, fso>) new fsm<JSONObject, fso>() {
                /* class _m_j.gwv.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    boolean z;
                    JSONArray optJSONArray;
                    JSONObject jSONObject = (JSONObject) obj;
                    if (!jSONObject.has("items") || (optJSONArray = jSONObject.optJSONArray("items")) == null) {
                        z = false;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        z = false;
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            DeviceConsumble O000000o2 = gww.O000000o(CommonApplication.getAppContext(), optJSONArray.optJSONObject(i));
                            if (O000000o2 != null && O000000o2.consumables != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= O000000o2.consumables.size()) {
                                        break;
                                    } else if ((O000000o2.consumables.get(i2).percentage < 0.0d || O000000o2.consumables.get(i2).percentage > 5.0d) && !TextUtils.equals("LOW", O000000o2.consumables.get(i2).state)) {
                                        i2++;
                                    }
                                }
                                z = true;
                            }
                            arrayList.add(O000000o2);
                        }
                        gsy.O00000Oo("ConsumableData", "小红点请求完毕");
                        gwv.this.O000000o(ggb.O00000Oo().O0000OOo(), arrayList);
                    }
                    if (!O00000o2 || !z) {
                        if (gwv.this.f18435O000000o != null) {
                            gwv.this.f18435O000000o.O000000o("red_point_consumables", false);
                        }
                    } else if (gwv.this.f18435O000000o != null) {
                        gwv.this.f18435O000000o.O000000o("red_point_consumables", true);
                    }
                }

                public final void onFailure(fso fso) {
                    if (gwv.this.f18435O000000o != null) {
                        gwv.this.f18435O000000o.O000000o("red_point_consumables", false);
                    }
                }
            });
            return;
        }
        ger ger = this.f18435O000000o;
        if (ger != null) {
            ger.O000000o("red_point_consumables", false);
        }
    }

    private void O00000oo() {
        if (this.f18435O000000o == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("red_point_consumables");
            this.f18435O000000o = new ger(arrayList, false);
        }
    }

    private static void O000000o(Context context, String str, boolean z, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apiVersion", 2);
            Home O00000o2 = ggb.O00000Oo().O00000o(str);
            jSONObject.put("skipRpc", z);
            if (O00000o2 != null) {
                try {
                    jSONObject.put("home_id", Long.parseLong(O00000o2.getId()));
                } catch (Exception unused) {
                }
                jSONObject.put("owner_id", O00000o2.getOwnerUid());
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                Context context2 = context;
                CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/consumable_items").O000000o(arrayList).O000000o(), $$Lambda$gwv$2pLgEnzOgadWdDYM0K7G1hrgGE.INSTANCE, Crypto.RC4, fsm);
                return;
            }
            fsm.onFailure(new fso(-1, "home is null"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void O000000o(Context context, String str, String str2, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("prop", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/consume_reset").O000000o(arrayList).O000000o(), $$Lambda$gwv$CCDEiAlNzGJdRRV8NfOMkLXwW5w.INSTANCE, Crypto.RC4, fsm);
    }

    public final void O000000o(Context context, String str, String str2, gwx gwx, int i) {
        Home O00000o2;
        if (!TextUtils.isEmpty(str)) {
            String str3 = "null";
            if (i == 0) {
                StringBuilder sb = new StringBuilder("3次rpc请求，【 ");
                if (fno.O000000o().O000000o(str2) != null) {
                    str3 = fno.O000000o().O000000o(str2).name;
                }
                sb.append(str3);
                sb.append("】 数据失败!!!!!!!");
                gsy.O00000Oo("ConsumableData", sb.toString());
                this.O0000O0o.remove(str2);
                if (this.O0000O0o.size() == 0 && gwx != null) {
                    gwx.O000000o(3, str, this.O00000o0.get(str));
                    gwx.O000000o();
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (fno.O000000o().O000000o(str2) != null) {
                str3 = fno.O000000o().O000000o(str2).name;
            }
            sb2.append(str3);
            sb2.append("开始  第【 ");
            sb2.append((3 - i) + 1);
            sb2.append(" 】次 RPC请求");
            gsy.O00000Oo("ConsumableData", sb2.toString());
            final String str4 = str2;
            final int i2 = i;
            final Context context2 = context;
            final String str5 = str;
            final gwx gwx2 = gwx;
            AnonymousClass5 r3 = new fsm<JSONObject, fso>() {
                /* class _m_j.gwv.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gwx gwx;
                    DeviceConsumble O000000o2 = gww.O000000o(CommonApplication.getAppContext(), (JSONObject) obj);
                    String str = "null";
                    if (O000000o2 == null || O000000o2.isSkipRpc) {
                        StringBuilder sb = new StringBuilder("------");
                        if (fno.O000000o().O000000o(str4) != null) {
                            str = fno.O000000o().O000000o(str4).name;
                        }
                        sb.append(str);
                        sb.append("第【 ");
                        sb.append((3 - i2) + 1);
                        sb.append(" 】次 RPC请求到无效数据");
                        gsy.O00000Oo("ConsumableData", sb.toString());
                        gwv.this.O000000o(context2, str5, str4, gwx2, i2 - 1);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder("------");
                    if (fno.O000000o().O000000o(str4) != null) {
                        str = fno.O000000o().O000000o(str4).name;
                    }
                    sb2.append(str);
                    sb2.append("第【 ");
                    sb2.append((3 - i2) + 1);
                    sb2.append(" 】次 RPC请求到数据");
                    gsy.O00000Oo("ConsumableData", sb2.toString());
                    gwv.this.O000000o(str5, O000000o2);
                    gwx gwx2 = gwx2;
                    if (gwx2 != null) {
                        gwx2.O000000o(2, str5, gwv.this.O00000o0.get(str5));
                    }
                    gwv.this.O0000O0o.remove(str4);
                    if (gwv.this.O0000O0o.size() == 0 && (gwx = gwx2) != null) {
                        gwx.O000000o(3, str5, gwv.this.O00000o0.get(str5));
                        gwx2.O000000o();
                    }
                }

                public final void onFailure(fso fso) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(fno.O000000o().O000000o(str4) == null ? "null" : fno.O000000o().O000000o(str4).name);
                    sb.append("第【 ");
                    sb.append((3 - i2) + 1);
                    sb.append(" 】次 RPC请求失败！（网络等）");
                    gsy.O00000Oo("ConsumableData", sb.toString());
                    gwv.this.O000000o(context2, str5, str4, gwx2, i2 - 1);
                }
            };
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str2);
                jSONObject.put("apiVersion", 2);
                if (!TextUtils.isEmpty(str) && (O00000o2 = ggb.O00000Oo().O00000o(str)) != null) {
                    try {
                        jSONObject.put("home_id", Long.parseLong(O00000o2.getId()));
                    } catch (Exception unused) {
                    }
                    jSONObject.put("owner_id", O00000o2.getOwnerUid());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/device_consumable_items").O000000o(arrayList).O000000o(), $$Lambda$gwv$HdgkKXl3mpIrOtHr4dObVFUWoY.INSTANCE, Crypto.RC4, r3);
        }
    }

    public final void O000000o(String str, DeviceConsumble deviceConsumble) {
        if (this.O00000o0.containsKey(str)) {
            List list = this.O00000o0.get(str);
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (TextUtils.equals(((DeviceConsumble) list.get(i2)).did, deviceConsumble.did)) {
                    list.remove(i2);
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i >= 0 && i < list.size()) {
                list.add(i, deviceConsumble);
            } else if (i == list.size()) {
                list.add(deviceConsumble);
            }
        }
    }

    public final void O000000o(final Context context, final String str, boolean z, final gwx gwx) {
        this.O0000O0o.clear();
        Observable.create(new ObservableOnSubscribe(gwx, str, context, z) {
            /* class _m_j.$$Lambda$gwv$Hyd7evCJA3beg_XZxKaDVmYzeXk */
            private final /* synthetic */ gwx f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ Context f$3;
            private final /* synthetic */ boolean f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                gwv.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, observableEmitter);
            }
        }).subscribe(new Observer<String>() {
            /* class _m_j.gwv.AnonymousClass6 */

            public final void onSubscribe(Disposable disposable) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                StringBuilder sb = new StringBuilder();
                sb.append(fno.O000000o().O000000o(str) == null ? "null" : fno.O000000o().O000000o(str).name);
                sb.append(" 进入rpc请求步骤");
                gsy.O00000Oo("ConsumableData", sb.toString());
                gwv.this.O000000o(context, str, str, gwx, 3);
            }

            public final void onError(Throwable th) {
                gsy.O00000Oo("ConsumableData", "请求列表出错");
                gwx gwx = gwx;
                if (gwx != null) {
                    gwx.O000000o(th.getMessage(), str);
                    gwx.O000000o();
                }
            }

            public final void onComplete() {
                gsy.O00000Oo("ConsumableData", "refresh complete");
                gwv gwv = gwv.this;
                gwv.O000000o(str, gwv.O00000o0.get(str));
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(gwx gwx, String str, Context context, boolean z, ObservableEmitter observableEmitter) throws Exception {
        if (gwx != null) {
            List list = this.O00000o0.get(str);
            gwx.O000000o(0, str, list == null ? new ArrayList() : list);
            if (!this.O00000oO.containsKey(str)) {
                this.O00000oO.put(str, -1);
            }
            if (this.O00000oO.get(str).intValue() >= 0 && list != null && list.size() > 0) {
                gwx.O000000o();
            }
        }
        gsy.O00000Oo("ConsumableData", "URL onSubscribe()");
        final boolean z2 = z;
        final ObservableEmitter observableEmitter2 = observableEmitter;
        final String str2 = str;
        final gwx gwx2 = gwx;
        O000000o(context, str, z, new fsm<JSONObject, fso>() {
            /* class _m_j.gwv.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray optJSONArray;
                JSONObject jSONObject = (JSONObject) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONObject.has("items") && (optJSONArray = jSONObject.optJSONArray("items")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        DeviceConsumble O000000o2 = gww.O000000o(CommonApplication.getAppContext(), optJSONArray.optJSONObject(i));
                        Device O000000o3 = fno.O000000o().O000000o(O000000o2.did);
                        if (O000000o3 == null || (O000000o3 != null && O000000o3.isOnline)) {
                            O000000o2.isOnline = true;
                        } else {
                            O000000o2.isOnline = false;
                        }
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                            if (!z2 && O000000o2.isSkipRpc && O000000o2.isOnline) {
                                gwv.this.O0000O0o.add(O000000o2.did);
                                observableEmitter2.onNext(O000000o2.did);
                            }
                        }
                    }
                    if (gwv.this.O00000oO.containsKey(str2)) {
                        gwv.this.O00000oO.remove(str2);
                    }
                    gwv.this.O00000oO.put(str2, 1);
                }
                if (gwv.this.O0000O0o.size() == 0) {
                    gsy.O00000Oo("ConsumableData", "无需rpc请求");
                    if (gwv.this.O00000o0.containsKey(str2)) {
                        gwv.this.O00000o0.get(str2).clear();
                    } else {
                        gwv.this.O00000o0.put(str2, new ArrayList());
                    }
                    gwv.this.O00000o0.get(str2).addAll(arrayList);
                    observableEmitter2.onComplete();
                } else {
                    if (gwv.this.O00000o0.containsKey(str2)) {
                        gwv.this.O00000o0.get(str2).clear();
                    } else {
                        gwv.this.O00000o0.put(str2, new ArrayList());
                    }
                    List list = gwv.this.O00000o0.get(str2);
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (((DeviceConsumble) arrayList.get(size)).isSkipRpc) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                if (TextUtils.equals(((DeviceConsumble) list.get(i2)).did, ((DeviceConsumble) arrayList.get(size)).did)) {
                                    arrayList.remove(size);
                                    arrayList.add(size, list.get(i2));
                                }
                            }
                        }
                    }
                    gwv.this.O00000o0.get(str2).clear();
                    gwv.this.O00000o0.get(str2).addAll(arrayList);
                }
                gwx gwx = gwx2;
                if (gwx != null) {
                    gwx.O000000o(1, str2, gwv.this.O00000o0.get(str2));
                }
                gwx gwx2 = gwx2;
                if (gwx2 != null) {
                    gwx2.O000000o();
                }
            }

            public final void onFailure(fso fso) {
                ObservableEmitter observableEmitter = observableEmitter2;
                observableEmitter.onError(new Exception(fso.O00000Oo + " when data from 1"));
            }
        });
    }

    public final void O00000o0() {
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O0000OoO);
        this.f18435O000000o = null;
        O0000OOo = null;
    }
}
