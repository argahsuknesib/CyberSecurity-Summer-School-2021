package _m_j;

import _m_j.fui;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fuq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static List<O000000o> f17195O000000o;
    private static volatile fuq O00000oo;
    public Map<Integer, Boolean> O00000Oo = new ConcurrentHashMap();
    public volatile AtomicBoolean O00000o = new AtomicBoolean(true);
    public Map<Integer, fso> O00000o0 = new ConcurrentHashMap();
    public Map<O000000o, fsm> O00000oO = new ConcurrentHashMap();
    private fss<ArrayList<JSONObject>> O0000O0o = new fss<ArrayList<JSONObject>>() {
        /* class _m_j.fuq.AnonymousClass1 */

        public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("result");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        arrayList.add(jSONObject2);
                    }
                }
            }
            return arrayList;
        }
    };
    private fss<fui> O0000OOo = new fss<fui>() {
        /* class _m_j.fuq.AnonymousClass2 */

        public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
            return fui.O000000o(jSONObject);
        }
    };
    private AtomicBoolean O0000Oo = new AtomicBoolean(true);
    private fss<fui.O00000Oo> O0000Oo0 = new fss<fui.O00000Oo>() {
        /* class _m_j.fuq.AnonymousClass3 */

        public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
            return fui.O00000Oo.O000000o(jSONObject);
        }
    };
    private Map<Integer, ConcurrentHashMap<String, JSONObject>> O0000OoO = new ConcurrentHashMap();
    private Handler O0000Ooo;
    private AtomicBoolean O0000o0 = new AtomicBoolean(false);
    private BroadcastReceiver O0000o00 = new BroadcastReceiver() {
        /* class _m_j.fuq.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("action_on_login_success")) {
                    gsy.O00000Oo("UserConfigCompactManager", "login status change: success");
                    if (!fuq.this.O00000o.get()) {
                        fuq.this.O00000o.set(false);
                        fuq.this.O00000Oo();
                    }
                } else if (action.equals("action_on_logout")) {
                    gsy.O00000Oo("UserConfigCompactManager", "login status change: failed");
                    fuq.this.O00000o.set(false);
                    fuq.this.O00000Oo();
                }
            }
        }
    };

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f17195O000000o = copyOnWriteArrayList;
        copyOnWriteArrayList.add(new O000000o(1, new String[]{"1", "2"}));
        f17195O000000o.add(new O000000o(0, new String[]{"0", "5", "7", "8", "20", "1000", "1001", "2001", "3001", "4000", "4001", "4002", "4003"}));
        f17195O000000o.add(new O000000o(7, new String[]{"100", "1001", "3001", "3002", "4001", "4002", "4003", "5001", "5002", "5003", "6001"}));
    }

    private fuq() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000o00, intentFilter);
    }

    public static fuq O000000o() {
        if (O00000oo == null) {
            synchronized (fuq.class) {
                if (O00000oo == null) {
                    O00000oo = new fuq();
                }
            }
        }
        return O00000oo;
    }

    public final void O00000Oo() {
        gsy.O00000Oo("UserConfigCompactManager", "reset");
        this.O0000Oo.set(true);
        this.O00000oO.clear();
        this.O0000OoO.clear();
        this.O00000Oo.clear();
        this.O0000o0.set(false);
        Handler handler = this.O0000Ooo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.O0000Ooo = null;
        }
        for (O000000o o000000o : f17195O000000o) {
            o000000o.O00000o = false;
        }
    }

    public final void O00000o0() {
        try {
            if (!this.O00000o.get()) {
                this.O00000o.set(true);
                O00000Oo();
                gsy.O00000Oo("UserConfigCompactManager", "onCreate: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"HandlerLeak"})
    private Handler O00000o() {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = new Handler(Looper.getMainLooper()) {
                /* class _m_j.fuq.AnonymousClass5 */

                public final void handleMessage(Message message) {
                    gsy.O00000Oo("UserConfigCompactManager", "release all");
                    if (message.what == 123) {
                        synchronized (fuq.this) {
                            fuq.this.O00000o.set(false);
                            if (!fuq.this.O00000oO.isEmpty()) {
                                for (O000000o next : fuq.f17195O000000o) {
                                    gsy.O00000Oo("UserConfigCompactManager", "deliver left callback : ".concat(String.valueOf(next)));
                                    fuq.this.O000000o(next.f17202O000000o, fuq.this.O00000o0.get(Integer.valueOf(next.f17202O000000o)));
                                }
                            }
                            fuq.this.O00000Oo();
                        }
                    }
                }
            };
        }
        return this.O0000Ooo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        return false;
     */
    public final synchronized boolean O000000o(Context context, int i, String[] strArr, fsm<ArrayList<fui>, fso> fsm) {
        if (this.O00000o.get()) {
            O000000o(context);
            if (O000000o(new O000000o(0, strArr), fsm)) {
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        return false;
     */
    public final synchronized boolean O000000o(Context context, int i, JSONArray jSONArray, fsm<Map<Integer, fui.O00000Oo>, fso> fsm) {
        if (this.O00000o.get()) {
            O000000o(context);
            try {
                if (O000000o(new O000000o(i, jSONArray), fsm)) {
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        return;
     */
    private synchronized void O000000o(Context context) {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            if (this.O0000Oo.get()) {
                this.O0000Oo.set(false);
                for (O000000o O000000o2 : f17195O000000o) {
                    O000000o(context, O000000o2);
                }
                gsy.O00000Oo("UserConfigCompactManager", "ready to compact");
            }
        }
    }

    private boolean O000000o(O000000o o000000o, fsm fsm) {
        for (O000000o next : f17195O000000o) {
            if (next.f17202O000000o == o000000o.f17202O000000o && next.O00000Oo.containsAll(o000000o.O00000Oo)) {
                gsy.O00000Oo("UserConfigCompactManager", "put: " + o000000o.toString());
                this.O00000oO.put(o000000o, fsm);
                O00000Oo(o000000o);
                return true;
            }
        }
        return false;
    }

    private void O00000Oo(O000000o o000000o) {
        Boolean bool = this.O00000Oo.get(Integer.valueOf(o000000o.f17202O000000o));
        if (bool == null) {
            gsy.O00000Oo("UserConfigCompactManager", "Deliver Is Not Ready, pending".concat(String.valueOf(o000000o)));
        } else if (bool.booleanValue()) {
            O000000o(o000000o.f17202O000000o, (fso) null);
        } else {
            O000000o(o000000o.f17202O000000o, this.O00000o0.get(Integer.valueOf(o000000o.f17202O000000o)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        return;
     */
    public final synchronized void O000000o(O000000o o000000o) {
        boolean z;
        if (!this.O0000o0.get()) {
            o000000o.O00000o = true;
            Iterator<O000000o> it = f17195O000000o.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().O00000o) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.O0000o0.set(true);
                gsy.O00000Oo("UserConfigCompactManager", "release after 5s ");
                O00000o().removeMessages(123);
                O00000o().sendEmptyMessageDelayed(123, 5000);
            }
        }
    }

    private fsn O000000o(Context context, final O000000o o000000o) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("component_id", o000000o.f17202O000000o);
            JSONArray jSONArray = new JSONArray();
            for (String put : o000000o.O00000Oo) {
                jSONArray.put(put);
            }
            jSONObject.put("keys", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_user_config").O000000o(arrayList).O000000o(), this.O0000O0o, Crypto.RC4, new fsm<ArrayList<JSONObject>, fso>() {
                /* class _m_j.fuq.AnonymousClass6 */

                public final /* bridge */ /* synthetic */ void onCache(Object obj) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    ArrayList arrayList = (ArrayList) obj;
                    gsy.O00000Oo("UserConfigCompactManager", "delegate request: " + o000000o);
                    gsy.O00000Oo("UserConfigCompactManager", "delegate onSuccess: " + fuq.O000000o(arrayList));
                    fuq.this.O000000o(o000000o, arrayList);
                    fuq.this.O000000o(o000000o.f17202O000000o, (fso) null);
                    fuq.this.O00000Oo.put(Integer.valueOf(o000000o.f17202O000000o), Boolean.TRUE);
                    fuq.this.O000000o(o000000o);
                }

                public final void onFailure(fso fso) {
                    gsy.O00000Oo("UserConfigCompactManager", "delegate request: " + o000000o.toString());
                    gsy.O00000Oo("UserConfigCompactManager", "delegate failed: " + fso.O00000Oo);
                    fuq.this.O000000o(o000000o.f17202O000000o, fso);
                    fuq.this.O00000Oo.put(Integer.valueOf(o000000o.f17202O000000o), Boolean.FALSE);
                    fuq.this.O00000o0.put(Integer.valueOf(o000000o.f17202O000000o), fso);
                    fuq.this.O000000o(o000000o);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            return new fsn(null);
        }
    }

    public final synchronized void O000000o(int i, fso fso) {
        ArrayList<O000000o> arrayList = new ArrayList<>();
        for (Map.Entry next : this.O00000oO.entrySet()) {
            O000000o o000000o = (O000000o) next.getKey();
            if (o000000o.f17202O000000o == i) {
                arrayList.add(o000000o);
                fsm fsm = (fsm) next.getValue();
                if (fsm == null) {
                    continue;
                } else if (fso == null) {
                    try {
                        Object O00000o02 = O00000o0(o000000o);
                        gsy.O00000Oo("UserConfigCompactManager", "real request: " + o000000o.toString());
                        gsy.O00000Oo("UserConfigCompactManager", "real response success: " + O000000o(O00000o02));
                        fsm.sendSuccessMessage(O00000o02);
                    } catch (Exception e) {
                        e.printStackTrace();
                        fsm.sendFailureMessage(new fso(-1000, e.getMessage()));
                        gsy.O00000Oo("UserConfigCompactManager", "real request: " + o000000o.toString());
                        gsy.O00000Oo("UserConfigCompactManager", "real response failed: " + e.getMessage());
                    }
                } else {
                    gsy.O00000Oo("UserConfigCompactManager", "real request: " + o000000o.toString());
                    gsy.O00000Oo("UserConfigCompactManager", "real response failed: " + fso.O00000Oo);
                    fsm.sendFailureMessage(new fso(-9999, fso.O00000Oo));
                }
            }
        }
        if (arrayList.size() != 0) {
            for (O000000o remove : arrayList) {
                this.O00000oO.remove(remove);
            }
        }
    }

    public final synchronized void O000000o(O000000o o000000o, ArrayList<JSONObject> arrayList) {
        ConcurrentMap concurrentMap;
        synchronized (this) {
            concurrentMap = this.O0000OoO.get(Integer.valueOf(o000000o.f17202O000000o));
            if (concurrentMap == null) {
                concurrentMap = new ConcurrentHashMap();
                this.O0000OoO.put(Integer.valueOf(o000000o.f17202O000000o), (ConcurrentHashMap) concurrentMap);
            }
        }
        Iterator<JSONObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            concurrentMap.put(next.optString("key"), next);
        }
    }

    private synchronized Object O00000o0(O000000o o000000o) throws JSONException {
        if (o000000o.O00000o0 == 1) {
            Map map = this.O0000OoO.get(Integer.valueOf(o000000o.f17202O000000o));
            ArrayList arrayList = new ArrayList();
            for (String next : o000000o.O00000Oo) {
                JSONObject jSONObject = (JSONObject) map.get(next);
                if (jSONObject == null) {
                    gsy.O000000o(6, "UserConfigCompactManager", "config data is null type 1 with componentId: " + o000000o.f17202O000000o + " ;key: " + next + " ;should not happened or user have never use this field.");
                } else {
                    arrayList.add(this.O0000OOo.parse(jSONObject));
                }
            }
            return arrayList;
        } else if (o000000o.O00000o0 != 2) {
            return null;
        } else {
            Map map2 = this.O0000OoO.get(Integer.valueOf(o000000o.f17202O000000o));
            if (map2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String next2 : o000000o.O00000Oo) {
                JSONObject jSONObject2 = (JSONObject) map2.get(next2);
                if (jSONObject2 == null) {
                    gsy.O000000o(6, "UserConfigCompactManager", "config data is null type 2 with componentId: " + o000000o.f17202O000000o + " ;key: " + next2 + " ; should not happened or user have never use this field.");
                } else {
                    hashMap.put(Integer.valueOf(Integer.parseInt(next2)), this.O0000Oo0.parse(jSONObject2));
                }
            }
            return hashMap;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f17202O000000o;
        Set<String> O00000Oo;
        boolean O00000o = false;
        int O00000o0;

        O000000o(int i, String[] strArr) {
            this.f17202O000000o = i;
            this.O00000Oo = new HashSet(Arrays.asList(strArr));
            this.O00000o0 = 1;
        }

        O000000o(int i, JSONArray jSONArray) throws JSONException {
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = jSONArray.getString(i2);
            }
            this.f17202O000000o = i;
            this.O00000Oo = new HashSet(Arrays.asList(strArr));
            this.O00000o0 = 2;
        }

        public final String toString() {
            return "RequestBody{componentId=" + this.f17202O000000o + ", keys=" + this.O00000Oo + ", type=" + this.O00000o0 + '}';
        }
    }

    public static String O000000o(Object obj) {
        Object obj2;
        if (obj == null) {
            return "obj is null";
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            for (Object next : (List) obj) {
                if (next != null) {
                    if (next instanceof fui) {
                        try {
                            sb.append(fui.O000000o((fui) next));
                            sb.append(" ");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            sb.append(" ");
                        }
                    } else {
                        sb.append(next.toString());
                        sb.append(" ");
                    }
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return "list is empty";
            }
            return sb.toString();
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Set keySet = map.keySet();
            StringBuilder sb2 = new StringBuilder();
            for (Object next2 : keySet) {
                if (!(next2 == null || (obj2 = map.get(next2)) == null)) {
                    if (obj2 instanceof fui.O00000Oo) {
                        sb2.append(((fui.O00000Oo) obj2).O00000o0);
                        sb2.append(" ");
                    } else {
                        sb2.append(obj2.toString());
                        sb2.append(" ");
                    }
                }
            }
            if (TextUtils.isEmpty(sb2.toString())) {
                return "map is empty";
            }
            return sb2.toString();
        } else if (TextUtils.isEmpty(obj.toString())) {
            return "obj.toString() is empty";
        } else {
            return obj.toString();
        }
    }
}
