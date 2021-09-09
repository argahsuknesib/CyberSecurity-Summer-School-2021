package _m_j;

import _m_j.fui;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hpr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f481O000000o = "_m_j.hpr";
    public static volatile hpr O0000o0;
    public Handler O00000Oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.hpr.AnonymousClass1 */

        public final void handleMessage(Message message) {
            String str = hpr.f481O000000o;
            gsy.O00000Oo(str, "mHandler.handleMessage" + message.what);
            int i = message.what;
            if (i == 1) {
                hob.O000000o().O000000o(ServiceApplication.getAppContext(), 30, new fsm<List<SceneApi.O000OOOo>, fso>() {
                    /* class _m_j.hpr.AnonymousClass4 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        List list = (List) obj;
                        synchronized (hpr.O0000o0) {
                            hpr.this.O0000O0o.clear();
                            hpr.this.O0000O0o.addAll(list);
                        }
                        hpr.this.O000000o(1);
                    }

                    public final void onFailure(fso fso) {
                        hpr hpr = hpr.this;
                        gsy.O00000Oo(hpr.f481O000000o, new StringBuilder("notifyFailed1").toString());
                        hpr.O00000o0 = false;
                        hpr.O00000o = false;
                        for (int i = 0; i < hpr.O0000Ooo.size(); i++) {
                            if (hpr.O0000Ooo.get(i).get() != null) {
                                ((hny) hpr.O0000Ooo.get(i).get()).onRefreshScenceFailed(1);
                            }
                        }
                        for (int i2 = 0; i2 < hpr.O0000o00.size(); i2++) {
                            hpr.O0000o00.get(i2).onRefreshScenceFailed(1);
                        }
                        hpr.O0000o00.clear();
                        if (gfr.O0000Ooo) {
                            LogType logType = LogType.GENERAL;
                            gsy.O00000o0(logType, "", "——Lite get remote error " + fso.toString());
                        }
                    }
                });
            } else if (i == 4) {
                hpr.this.O000000o(4);
            } else if (i == 12) {
                hpr hpr = hpr.this;
                if (hpr.O0000O0o == null || hpr.O0000O0o.size() == 0) {
                    hpr.O000000o(5);
                } else {
                    fcd O000000o2 = fcd.O000000o();
                    AnonymousClass2 r3 = new fsm<String, fso>() {
                        /* class _m_j.hpr.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            String str = (String) obj;
                            String str2 = hpr.f481O000000o;
                            gsy.O00000Oo(str2, "getLiteSceneOrderFromServer  " + str.toString());
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (str.contains("value")) {
                                        hpr.this.O0000Oo0.clear();
                                        JSONArray optJSONArray = jSONObject.optJSONArray("value");
                                        if (optJSONArray != null) {
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                hpr.this.O0000Oo0.add(optJSONArray.optString(i));
                                            }
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            hpr.this.O000000o(5);
                        }

                        public final void onFailure(fso fso) {
                            hpr.this.O000000o(5);
                        }
                    };
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(1);
                    fuj.O000000o().O000000o(CommonApplication.getAppContext(), 1, jSONArray, new fsm<Map<Integer, fui.O00000Oo>, fso>(1, r3, 1) {
                        /* class _m_j.fcd.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ int f16076O000000o = 1;
                        final /* synthetic */ fsm O00000Oo;
                        final /* synthetic */ int O00000o0;

                        {
                            this.O00000Oo = r3;
                            this.O00000o0 = 1;
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            Map map = (Map) obj;
                            if (map == null || map.get(Integer.valueOf(this.f16076O000000o)) == null) {
                                this.O00000Oo.onSuccess("");
                                return;
                            }
                            final int[] iArr = new int[2];
                            fuh.O000000o((fui.O00000Oo) map.get(Integer.valueOf(this.f16076O000000o)), iArr);
                            JSONArray jSONArray = new JSONArray();
                            if (iArr[1] > 0 && iArr[0] > 0) {
                                for (int i = iArr[0]; i < iArr[0] + iArr[1]; i++) {
                                    jSONArray.put(i);
                                }
                            }
                            fuj.O000000o().O000000o(CommonApplication.getAppContext(), this.O00000o0, jSONArray, new fsm<Map<Integer, fui.O00000Oo>, fso>() {
                                /* class _m_j.fcd.AnonymousClass1.AnonymousClass1 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    Map map = (Map) obj;
                                    if (map == null || map.size() <= 0) {
                                        AnonymousClass1.this.O00000Oo.onSuccess("");
                                        return;
                                    }
                                    int[] iArr = iArr;
                                    AnonymousClass1.this.O00000Oo.onSuccess(fuh.O000000o(iArr[0], iArr[1], map));
                                }

                                public final void onFailure(fso fso) {
                                    AnonymousClass1.this.O00000Oo.onFailure(fso);
                                }
                            });
                        }

                        public final void onFailure(fso fso) {
                            this.O00000Oo.onFailure(fso);
                        }
                    });
                }
            }
            super.handleMessage(message);
        }
    };
    public boolean O00000o = false;
    boolean O00000o0 = false;
    public boolean O00000oO = false;
    public HandlerThread O00000oo = new HandlerThread("lite_scene");
    public List<SceneApi.O000OOOo> O0000O0o = new ArrayList();
    public List<SceneApi.O000OOOo> O0000OOo = new ArrayList();
    public O000000o O0000Oo;
    public List<String> O0000Oo0 = new ArrayList();
    SharedPreferences O0000OoO;
    public ArrayList<WeakReference<hny>> O0000Ooo = new ArrayList<>();
    public ArrayList<hny> O0000o00 = new ArrayList<>();
    private long O0000o0O = 0;

    public class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 7) {
                if (i == 10) {
                    hpr hpr = hpr.this;
                    String str = (String) message.obj;
                    if (hpr.O0000OoO == null) {
                        String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
                        Context appContext = ServiceApplication.getAppContext();
                        hpr.O0000OoO = appContext.getSharedPreferences(O000000o2 + "lite_scene_list_cache", 0);
                    }
                    if (hpr.O0000OoO != null) {
                        SharedPreferences.Editor edit = hpr.O0000OoO.edit();
                        edit.putString("lite_scene_list", str);
                        edit.commit();
                    }
                }
            } else if (hpr.this.O000000o()) {
                hpr.this.O00000Oo.sendEmptyMessage(4);
            }
        }
    }

    private hpr() {
        this.O00000oo.start();
        this.O0000Oo = new O000000o(this.O00000oo.getLooper());
    }

    private void O00000oO() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            try {
                jSONArray.put(this.O0000O0o.get(i).O000000o());
            } catch (Exception unused) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", 1);
            jSONObject.put("lite_scene_list", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Message obtainMessage = this.O00000Oo.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = jSONObject.toString();
        this.O0000Oo.sendMessage(obtainMessage);
    }

    public final boolean O000000o() {
        if (this.O0000OoO == null) {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            Context appContext = ServiceApplication.getAppContext();
            this.O0000OoO = appContext.getSharedPreferences(O000000o2 + "lite_scene_list_cache", 0);
        }
        SharedPreferences sharedPreferences = this.O0000OoO;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("lite_scene_list", ""));
            int optInt = jSONObject.optInt("version", -1);
            if (optInt <= 0) {
                this.O0000OoO.edit().clear().commit();
                if (optInt == -1) {
                    Context appContext2 = ServiceApplication.getAppContext();
                    SharedPreferences sharedPreferences2 = appContext2.getSharedPreferences("lite_scene_order_new_sp_name_" + CoreApi.O000000o().O0000o0(), 0);
                    if (sharedPreferences2 != null) {
                        sharedPreferences2.edit().clear().commit();
                    }
                }
            }
            this.O0000OOo.clear();
            JSONArray optJSONArray = jSONObject.optJSONArray("lite_scene_list");
            if (optJSONArray == null) {
                return true;
            }
            this.O0000OOo.addAll(O000000o(optJSONArray));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static List<SceneApi.O000OOOo> O000000o(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            SceneApi.O000OOOo o000OOOo = null;
            try {
                o000OOOo = SceneApi.O000OOOo.O000000o(jSONArray.optJSONObject(i), true);
            } catch (JSONException unused) {
            }
            if (o000OOOo != null) {
                arrayList.add(o000OOOo);
            }
        }
        return arrayList;
    }

    public final void O000000o(hny hny) {
        if (hny != null) {
            for (int i = 0; i < this.O0000Ooo.size(); i++) {
                if (this.O0000Ooo.get(i).get() == hny) {
                    gsy.O00000Oo(f481O000000o, "registerLiteSceneListener return");
                    return;
                }
            }
            this.O0000Ooo.add(new WeakReference(hny));
        }
        O00000Oo();
    }

    public final void O00000Oo() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = f481O000000o;
        gsy.O00000Oo(str, "ServiceApplication.getStateNotifier().getCurrentState()" + ServiceApplication.getStateNotifier().f15923O000000o + "   mIsRefreshing  " + this.O00000o0);
        String str2 = f481O000000o;
        gsy.O00000Oo(str2, "now====" + currentTimeMillis + "   lastRefreshTime  " + this.O0000o0O + "   now - lastRefreshTime " + (currentTimeMillis - this.O0000o0O));
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            if (this.O00000o0) {
                O000000o(5);
            } else if (!this.O00000o || currentTimeMillis - this.O0000o0O >= 5000) {
                this.O00000o0 = true;
                this.O00000o = false;
                this.O0000o0O = System.currentTimeMillis();
                String str3 = f481O000000o;
                gsy.O000000o(6, str3, "Start Time - " + System.currentTimeMillis());
                this.O00000Oo.sendEmptyMessage(1);
                if (this.O0000O0o.size() == 0 && this.O0000OOo.size() == 0) {
                    this.O0000Oo.sendEmptyMessage(7);
                }
            } else {
                O000000o(5);
            }
        }
    }

    public final void O000000o(final fsm fsm) {
        try {
            gsy.O00000Oo(f481O000000o, "saveLiteSceneOrderToServer");
            fui fui = new fui();
            fui.f17181O000000o = 1;
            fui.O00000Oo = "1";
            fui.O00000o0 = new ArrayList<>();
            JSONObject O00000oo2 = O00000oo();
            JSONArray jSONArray = new JSONArray();
            fuh.O000000o(O00000oo2, jSONArray, "1");
            fuj.O000000o().O000000o(ServiceApplication.getAppContext(), jSONArray, new fsm<JSONObject, fso>() {
                /* class _m_j.hpr.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    hpr.this.O0000Oo0.clear();
                    for (int i = 0; i < hpr.this.O0000O0o.size(); i++) {
                        List<String> list = hpr.this.O0000Oo0;
                        list.add(hpr.this.O0000O0o.get(i).f11131O000000o);
                    }
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject O00000oo() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            SceneApi.O000OOOo o000OOOo = this.O0000O0o.get(i);
            if (o000OOOo instanceof SceneApi.O000OOOo) {
                jSONArray.put(o000OOOo.f11131O000000o);
            }
        }
        try {
            jSONObject.put("value", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final SceneApi.O000OOOo O000000o(String str) {
        for (SceneApi.O000OOOo next : this.O0000O0o) {
            if (TextUtils.equals(next.f11131O000000o, str)) {
                return next;
            }
        }
        return null;
    }

    public final boolean O00000Oo(String str) {
        boolean z;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.O0000O0o.size()) {
                z = false;
                break;
            } else if (TextUtils.equals(str, this.O0000O0o.get(i2).f11131O000000o)) {
                this.O0000O0o.remove(i2);
                z = true;
                break;
            } else {
                i2++;
            }
        }
        while (true) {
            if (i >= this.O0000OOo.size()) {
                break;
            } else if (TextUtils.equals(str, this.O0000OOo.get(i).f11131O000000o)) {
                this.O0000OOo.remove(i);
                break;
            } else {
                i++;
            }
        }
        return z;
    }

    public final void O000000o(String str, SceneApi.O000OOOo o000OOOo) {
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            if (TextUtils.equals(str, this.O0000O0o.get(i).f11131O000000o)) {
                this.O0000O0o.remove(i);
                this.O0000O0o.add(i, o000OOOo);
                return;
            }
        }
    }

    private void O000000o(SceneApi.O000OOOo o000OOOo) {
        this.O0000O0o.add(o000OOOo);
    }

    public final void O000000o(SceneApi.O000OOOo o000OOOo, fsm fsm) {
        O000000o(o000OOOo);
        O000000o(fsm);
    }

    public final void O00000Oo(hny hny) {
        if (hny != null) {
            for (int i = 0; i < this.O0000Ooo.size(); i++) {
                if (this.O0000Ooo.get(i).get() == hny) {
                    gsy.O00000Oo(f481O000000o, "registerLiteSceneListener return");
                    return;
                }
            }
            this.O0000Ooo.add(new WeakReference(hny));
        }
    }

    public final boolean O00000o0(hny hny) {
        if (hny == null) {
            return false;
        }
        for (int i = 0; i < this.O0000Ooo.size(); i++) {
            if (this.O0000Ooo.get(i).get() == hny) {
                this.O0000Ooo.remove(i);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final int i) {
        gsy.O00000o0(LogType.SCENE, "litescenemanager", "LiteSceneManagernotifySuccess".concat(String.valueOf(i)));
        if (i == 1) {
            this.O00000Oo.sendEmptyMessage(12);
        } else if (i == 4) {
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.hpr.AnonymousClass5 */

                public final void run() {
                    for (int i = 0; i < hpr.this.O0000Ooo.size(); i++) {
                        if (hpr.this.O0000Ooo.get(i).get() != null) {
                            ((hny) hpr.this.O0000Ooo.get(i).get()).onRefreshScenceSuccess(i);
                        }
                    }
                }
            });
        } else if (i == 5) {
            O0000O0o();
            O00000oO();
            this.O00000o = true;
            this.O00000oO = true;
            this.O00000o0 = false;
            String str = f481O000000o;
            gsy.O000000o(6, str, "End Time - " + System.currentTimeMillis());
        }
        ServiceApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.hpr.AnonymousClass6 */

            public final void run() {
                LogType logType = LogType.SCENE;
                gsy.O00000o0(logType, "litescenemanager", "LiteSceneManagernotifySuccess" + i + "----REFRESH_LASTmIsUpdateSuccess" + hpr.this.O00000o);
                for (int i = 0; i < hpr.this.O0000Ooo.size(); i++) {
                    if (hpr.this.O0000Ooo.get(i).get() != null) {
                        ((hny) hpr.this.O0000Ooo.get(i).get()).onRefreshScenceSuccess(i);
                    }
                }
                for (int i2 = 0; i2 < hpr.this.O0000o00.size(); i2++) {
                    hpr.this.O0000o00.get(i2).onRefreshScenceSuccess(i);
                }
                hpr.this.O0000o00.clear();
            }
        });
    }

    private void O0000O0o() {
        List<String> list;
        List<SceneApi.O000OOOo> list2 = this.O0000O0o;
        if (list2 != null && list2.size() != 0 && (list = this.O0000Oo0) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList(this.O0000Oo0);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                if (TextUtils.isEmpty((CharSequence) arrayList2.get(size)) || TextUtils.equals("0", (CharSequence) arrayList2.get(size))) {
                    arrayList2.remove(size);
                }
            }
            for (int i = 0; i < arrayList2.size(); i++) {
                String str = (String) arrayList2.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.O0000O0o.size()) {
                        break;
                    }
                    SceneApi.O000OOOo o000OOOo = this.O0000O0o.get(i2);
                    if (TextUtils.equals(str, o000OOOo.f11131O000000o)) {
                        arrayList.add(o000OOOo);
                        this.O0000O0o.remove(o000OOOo);
                        break;
                    }
                    i2++;
                }
            }
            this.O0000O0o.addAll(0, arrayList);
        }
    }

    public static synchronized hpr O00000o0() {
        hpr hpr;
        synchronized (hpr.class) {
            if (O0000o0 == null) {
                O0000o0 = new hpr();
            }
            hpr = O0000o0;
        }
        return hpr;
    }

    public static void O00000o() {
        gsy.O00000Oo(f481O000000o, "clear");
        hpr hpr = O0000o0;
        hpr hpr2 = new hpr();
        O0000o0 = hpr2;
        hpr2.O0000Ooo.addAll(hpr.O0000Ooo);
    }
}
