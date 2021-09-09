package _m_j;

import _m_j.hod;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hod {
    public static int O0000o = 60;
    public static hod O00oOooO;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<SceneApi.O000OOOo> f416O000000o = new ArrayList();
    public List<SceneApi.O000OOOo> O00000Oo = new ArrayList();
    public Handler O00000o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.hod.AnonymousClass9 */

        public final void handleMessage(Message message) {
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "scene", "SceneManager mHandler handleMessage  msg.what: " + message.what);
            int i = message.what;
            if (i == 1) {
                hod.this.O00000oO();
            } else if (i == 12) {
                hod.this.O00000o0(12);
            } else if (i == 4) {
                hod.this.O00000o0(4);
            } else if (i == 5) {
                hod hod = hod.this;
                hod.O00000oO = false;
                hod.O00000o0(5);
            } else if (i == 6) {
                hod.this.O0000Oo0();
            }
            super.handleMessage(message);
        }
    };
    public List<SceneApi.O000OOOo> O00000o0 = new ArrayList();
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    public boolean O0000OOo = false;
    public long O0000Oo = 0;
    public boolean O0000Oo0 = false;
    public Map<String, CommonSceneOnline> O0000OoO = new HashMap();
    public HandlerThread O0000Ooo = new gpq("scene");
    public List<SceneApi.O000OOOo> O0000o0 = new ArrayList();
    public List<SceneApi.O000OOOo> O0000o00 = new ArrayList();
    public Map<String, O000000o> O0000o0O = new HashMap();
    public O00000Oo O0000o0o;
    Map<String, SceneApi.O000OOOo> O0000oO = new HashMap();
    public Comparator<SceneApi.O000OOOo> O0000oO0 = new Comparator<SceneApi.O000OOOo>() {
        /* class _m_j.hod.AnonymousClass1 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            SceneApi.O000OOOo o000OOOo = (SceneApi.O000OOOo) obj;
            SceneApi.O000OOOo o000OOOo2 = (SceneApi.O000OOOo) obj2;
            if (o000OOOo == null || o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() == 0 || o000OOOo.O0000O0o.get(0).O00000Oo == null || o000OOOo.O0000O0o.get(0).O00000Oo.f11124O000000o == null || o000OOOo2 == null || o000OOOo2.O0000O0o == null || o000OOOo2.O0000O0o.size() == 0 || o000OOOo2.O0000O0o.get(0).O00000Oo == null || o000OOOo2.O0000O0o.get(0).O00000Oo.f11124O000000o == null) {
                return 1;
            }
            return o000OOOo.O0000O0o.get(0).O00000Oo.f11124O000000o.O000000o(o000OOOo2.O0000O0o.get(0).O00000Oo.f11124O000000o);
        }
    };
    public Map<String, hqr> O0000oOO = new HashMap();
    public long O0000oOo = 0;
    CoreApi.O0000o0 O0000oo = new CoreApi.O0000o0() {
        /* class _m_j.hod.AnonymousClass11 */

        public final void onCoreReady() {
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "scene", "SceneManager ----------onCoreReady " + hod.this.O00000oO);
            if (!hod.this.O00000oO) {
                if (!hod.this.O00000oo || System.currentTimeMillis() - hod.this.O0000oOo >= 5000) {
                    hod hod = hod.this;
                    hod.O00000oO = true;
                    hod.O0000Oo0 = false;
                    hod.O00000oO();
                    return;
                }
                hod.this.O00000o0(5);
            }
        }
    };
    CoreApi.O0000o0 O0000oo0 = new CoreApi.O0000o0() {
        /* class _m_j.hod.AnonymousClass10 */

        public final void onCoreReady() {
            hod.this.O0000OOo();
        }
    };
    public List<hqr> O0000ooO = new ArrayList();
    public long O0000ooo = 0;
    private List<SceneApi.O000OOOo> O000O00o = new ArrayList();
    private HashMap<Integer, List<Integer>> O000O0OO = new HashMap<>();
    private HashMap<Integer, List<Integer>> O000O0Oo = new HashMap<>();
    private boolean O000O0o = true;
    private SharedPreferences O000O0o0;
    private ArrayList<WeakReference<hny>> O000O0oO = new ArrayList<>();
    private ArrayList<hny> O000O0oo = new ArrayList<>();
    private volatile long O00oOoOo = 0;
    private List<SceneApi.O000OOOo> O00oOooo = new ArrayList();

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private void O000000o(List<SceneApi.O000OOOo> list, List<hqr> list2) {
        int i;
        GeoFenceItem O000000o2;
        if (!hpf.O000000o().O00000o0()) {
            gsy.O00000Oo(LogType.GENERAL, "Scenemanager", "has geofence，but not support");
            return;
        }
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (true) {
            if (list == null) {
                i = 0;
            } else {
                i = list.size();
            }
            if (i2 >= i) {
                break;
            }
            SceneApi.O000OOOo o000OOOo = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < ((o000OOOo == null || o000OOOo.O0000O0o == null) ? 0 : o000OOOo.O0000O0o.size())) {
                    SceneApi.O0000O0o o0000O0o = o000OOOo.O0000O0o.get(i3).O0000Oo;
                    if (o0000O0o != null && !TextUtils.isEmpty(o0000O0o.O0000o0O) && o0000O0o.O0000o0 > 0 && (O000000o2 = hnw.O000000o(o0000O0o, o000OOOo.O00000Oo)) != null) {
                        String O00000Oo2 = fcn.O000000o().O00000Oo();
                        String str = ftn.O000000o(ServiceApplication.getAppContext()).O00000Oo;
                        String O000000o3 = hpe.O000000o(O00000Oo2, str, "scene-" + o0000O0o.O0000o0);
                        this.O0000oO.put(O000000o3, o000OOOo);
                        hashMap.put(O000000o3, O000000o2);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            i2++;
        }
        for (int i4 = 0; i4 < list2.size(); i4++) {
            hqr hqr = list2.get(i4);
            GeoFenceItem O000000o4 = hnw.O000000o(hqr.O00000Oo, hqr.O00000o, hqr.O00000o0, hqr.f528O000000o);
            if (O000000o4 != null) {
                String O00000Oo3 = fcn.O000000o().O00000Oo();
                String str2 = ftn.O000000o(ServiceApplication.getAppContext()).O00000Oo;
                String O000000o5 = hpe.O000000o(O00000Oo3, str2, "specScene-" + hqr.f528O000000o);
                this.O0000oOO.put(O000000o5, hqr);
                hashMap.put(O000000o5, O000000o4);
            }
        }
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "Scenemanager", "sync fence items size： " + hashMap.size());
        if (!hashMap.isEmpty()) {
            hpf.O000000o().O000000o(hashMap);
            gsy.O00000Oo(LogType.GENERAL, "Scenemanager", "sync fence item end");
        }
    }

    public final void O000000o(String str, String str2, SceneApi.O000OOOo o000OOOo, fsm fsm, int i, int[] iArr, long j, long j2) {
        fsm fsm2 = fsm;
        int i2 = i;
        final long currentTimeMillis = System.currentTimeMillis();
        LogType logType = LogType.GENERAL;
        StringBuilder sb = new StringBuilder("start scene start retry(");
        sb.append(i2);
        sb.append(") at ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(currentTimeMillis / 1000);
        sb.append(goz.O000000o(sb2.toString()));
        gsy.O00000Oo(logType, "GEO_FENCE", sb.toString());
        if (i2 > 1) {
            hob.O000000o();
            Context appContext = ServiceApplication.getAppContext();
            final SceneApi.O000OOOo o000OOOo2 = o000OOOo;
            String str3 = o000OOOo2.f11131O000000o;
            final String str4 = str;
            final String str5 = str2;
            final long j3 = j;
            final fsm fsm3 = fsm;
            final int i3 = i;
            final int[] iArr2 = iArr;
            Context context = appContext;
            AnonymousClass8 r14 = r0;
            final long j4 = j2;
            AnonymousClass8 r0 = new fsm<Void, fso>() {
                /* class _m_j.hod.AnonymousClass8 */

                public final void onFailure(fso fso) {
                    if (gfr.O0000OOo || gfr.O0000Ooo) {
                        LogType logType = LogType.GENERAL;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append("onTrigger,scene start fail---");
                        sb.append(o000OOOo2.f11131O000000o);
                        sb.append("****");
                        sb.append(fso.f17063O000000o);
                        sb.append("****");
                        sb.append(TextUtils.isEmpty(fso.O00000Oo) ? "error null" : fso.O00000Oo);
                        sb.append(" at ");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(currentTimeMillis / 1000);
                        sb.append(goz.O000000o(sb2.toString()));
                        sb.append("----");
                        sb.append(j3);
                        gsy.O00000Oo(logType, "GEO_FENCE", sb.toString());
                    } else {
                        gsy.O00000Oo(LogType.GENERAL, "GEO_FENCE", str4 + "onTrigger,scene start fail-------" + j3);
                    }
                    int i = i3 - 1;
                    hod.this.O00000o.postDelayed(new Runnable(str4, str5, o000OOOo2, fsm3, i, iArr2, j3, j4) {
                        /* class _m_j.$$Lambda$hod$8$Ylt8vqF67x8i4vkEf1e8NwlgLMo */
                        private final /* synthetic */ String f$1;
                        private final /* synthetic */ String f$2;
                        private final /* synthetic */ SceneApi.O000OOOo f$3;
                        private final /* synthetic */ fsm f$4;
                        private final /* synthetic */ int f$5;
                        private final /* synthetic */ int[] f$6;
                        private final /* synthetic */ long f$7;
                        private final /* synthetic */ long f$8;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                            this.f$6 = r7;
                            this.f$7 = r8;
                            this.f$8 = r10;
                        }

                        public final void run() {
                            hod.AnonymousClass8.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8);
                        }
                    }, (long) (iArr2[i] * 1000));
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str, String str2, SceneApi.O000OOOo o000OOOo, fsm fsm, int i, int[] iArr, long j, long j2) {
                    hod.this.O000000o(str, str2, o000OOOo, fsm, i, iArr, j, j2);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (gfr.O0000OOo || gfr.O0000Ooo) {
                        LogType logType = LogType.GENERAL;
                        gsy.O00000Oo(logType, "GEO_FENCE", str4 + "onTrigger,scene start success---" + o000OOOo2.f11131O000000o + "----" + str5 + "----" + j3);
                    } else {
                        LogType logType2 = LogType.GENERAL;
                        gsy.O00000Oo(logType2, "GEO_FENCE", str4 + "onTrigger,scene start success-------" + j3);
                    }
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onSuccess(null);
                    }
                }
            };
            hob.O000000o(context, str3, str, r14);
        } else if (fsm2 != null) {
            fsm2.onFailure(new fso(-9999, "retry exit"));
        }
    }

    public class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "scene", "SceneManager  WorkerHandler handleMessage  msg.what: " + message.what);
            int i = message.what;
            if (i != 7) {
                if (i == 8) {
                    hod.this.O000000o("scene_list", (String) message.obj);
                    hod hod = hod.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    hod.O000000o("scene_list_timestamp", sb.toString());
                } else if (i != 13) {
                    if (i == 14) {
                        hod.this.O000000o("voice_scene_list", (String) message.obj);
                    }
                } else if (hod.this.O00000Oo()) {
                    hod.this.O00000o.sendEmptyMessage(4);
                }
            } else if (hod.this.O000000o()) {
                hod.this.O00000o.sendEmptyMessage(4);
            }
        }
    }

    private hod() {
        this.O0000Ooo.start();
        this.O0000o0o = new O00000Oo(this.O0000Ooo.getLooper());
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            hif.O000000o();
        }
    }

    public final boolean O000000o() {
        if (this.O000O0o0 == null) {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.O000O0o0 = appContext.getSharedPreferences(O000000o2 + "scene_list_cache", 0);
            }
        }
        SharedPreferences sharedPreferences = this.O000O0o0;
        if (sharedPreferences == null) {
            return false;
        }
        String string = sharedPreferences.getString("scene_list", "");
        try {
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            List<SceneApi.O000OOOo> O00000Oo2 = O00000Oo(new JSONObject(string));
            this.O0000o00.clear();
            for (int i = 0; i < O00000Oo2.size(); i++) {
                if (!O000000o(O00000Oo2.get(i).O0000O0o)) {
                    this.O0000o00.add(O00000Oo2.get(i));
                }
            }
            String string2 = this.O000O0o0.getString("scene_list_timestamp", "");
            if (TextUtils.isEmpty(string2)) {
                return true;
            }
            try {
                this.O00oOoOo = Long.parseLong(string2);
                return true;
            } catch (Exception unused) {
                this.O00oOoOo = 0;
                return true;
            }
        } catch (JSONException unused2) {
            return false;
        }
    }

    public final boolean O00000Oo() {
        if (this.O000O0o0 == null) {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.O000O0o0 = appContext.getSharedPreferences(O000000o2 + "scene_list_cache", 0);
            }
        }
        SharedPreferences sharedPreferences = this.O000O0o0;
        if (sharedPreferences == null) {
            return false;
        }
        String string = sharedPreferences.getString("voice_scene_list", "");
        try {
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            List<SceneApi.O000OOOo> O00000Oo2 = O00000Oo(new JSONObject(string));
            this.O0000o0.clear();
            CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
            for (int i = 0; i < O00000Oo2.size(); i++) {
                if (!(O00000Oo2.get(i).O0000O0o == null || O00000Oo2.get(i).O0000O0o.size() <= 0 || O00000Oo2.get(i).O0000O0o.get(0).O00000Oo == null || O00000Oo2.get(i).O0000O0o.get(0).O00000Oo.f11124O000000o == null || !O000000o(corntabParam, O00000Oo2.get(i).O0000O0o.get(0).O00000Oo.f11124O000000o))) {
                    this.O0000o0.add(O00000Oo2.get(i));
                }
            }
            Collections.sort(this.O0000o0, this.O0000oO0);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public final void O000000o(String str, String str2) {
        if (this.O000O0o0 == null) {
            String O000000o2 = grv.O000000o(CoreApi.O000000o().O0000o0());
            if (!TextUtils.isEmpty(O000000o2)) {
                Context appContext = ServiceApplication.getAppContext();
                this.O000O0o0 = appContext.getSharedPreferences(O000000o2 + "scene_list_cache", 0);
            }
        }
        SharedPreferences sharedPreferences = this.O000O0o0;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    private static List<SceneApi.O000OOOo> O00000Oo(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; jSONObject.has(String.valueOf(i)); i++) {
            SceneApi.O000OOOo o000OOOo = null;
            try {
                o000OOOo = SceneApi.O000OOOo.O000000o(jSONObject.optJSONObject(String.valueOf(i)), false);
            } catch (JSONException unused) {
            }
            if (o000OOOo != null) {
                arrayList.add(o000OOOo);
            }
        }
        return arrayList;
    }

    public final void O00000o0() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            if (CoreApi.O000000o().O0000O0o()) {
                this.O0000oo0.onCoreReady();
            } else {
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), this.O0000oo0);
            }
        }
    }

    public final void O00000o() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            if (!this.O00000oo) {
                this.O0000o0o.sendEmptyMessage(7);
            }
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "scene", "SceneManager ----------updateScene --------------callbackmScenes.size()" + this.f416O000000o.size() + this.O00000oO);
            if (CoreApi.O000000o().O0000O0o()) {
                this.O0000oo.onCoreReady();
            } else {
                CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), this.O0000oo);
            }
        } else {
            this.O00000o.sendEmptyMessage(5);
        }
    }

    public final void O000000o(hny hny) {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            if (hny != null) {
                this.O000O0oo.add(hny);
            }
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "scene", "SceneManager ----------updateScene --------------callbackmScenes.size()" + this.f416O000000o.size() + this.O00000oO);
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                if (!this.O00000oo) {
                    this.O0000o0o.sendEmptyMessage(7);
                }
                if (!this.O00000oO) {
                    this.O00000oO = true;
                    this.O0000Oo0 = false;
                    O00000oO();
                    return;
                }
                return;
            }
            this.O00000o.sendEmptyMessage(5);
        }
    }

    public final void O00000oO() {
        this.O0000ooO.clear();
        O0000o0();
    }

    private void O0000o0() {
        hob.O000000o().O000000o(ServiceApplication.getAppContext(), 15, new fsm<List<SceneApi.O000OOOo>, fso>() {
            /* class _m_j.hod.AnonymousClass12 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                synchronized (hod.O0000OoO()) {
                    hod.this.O0000oOo = System.currentTimeMillis();
                    hod.this.f416O000000o.clear();
                    for (int i = 0; i < list.size(); i++) {
                        if (!hod.O000000o(((SceneApi.O000OOOo) list.get(i)).O0000O0o)) {
                            hod.this.f416O000000o.add(list.get(i));
                        }
                    }
                    hod.this.O0000Oo();
                }
                hod hod = hod.this;
                hod.O00000oo = true;
                hod.O0000Oo = System.currentTimeMillis();
                hod.this.O00000o0(1);
                hod.this.O00000oo();
            }

            public final void onFailure(fso fso) {
                if (gfr.O0000Ooo) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000o0(logType, "", "——Auto get remote error " + fso.toString());
                }
                hod.this.O00000o(1);
                hod.this.O00000oo();
            }
        });
    }

    public final void O00000oo() {
        LogType logType = LogType.SCENE;
        gsy.O00000Oo(logType, "GEO_FENCE", "geospecscene size" + this.O0000ooO.size());
        O000000o(this.f416O000000o, this.O0000ooO);
    }

    public final void O0000O0o() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            if (!this.O0000O0o) {
                this.O0000o0o.sendEmptyMessage(13);
            }
            hob.O000000o().O000000o(ServiceApplication.getAppContext(), 50, new fsm<List<SceneApi.O000OOOo>, fso>() {
                /* class _m_j.hod.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    hod.this.O0000O0o = true;
                    synchronized (hod.O0000OoO()) {
                        hod.this.O00000Oo.clear();
                        if (list != null) {
                            CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
                            if (gfr.f17662O000000o) {
                                gqg.O00000Oo("展示" + corntabParam.O00000oO + "月" + corntabParam.O00000o + "日" + corntabParam.O00000o0 + "点" + corntabParam.O00000Oo + "分" + corntabParam.f11160O000000o + "秒之后的");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                if (!(((SceneApi.O000OOOo) list.get(i)).O0000O0o == null || ((SceneApi.O000OOOo) list.get(i)).O0000O0o.size() <= 0 || ((SceneApi.O000OOOo) list.get(i)).O0000O0o.get(0).O00000Oo == null || ((SceneApi.O000OOOo) list.get(i)).O0000O0o.get(0).O00000Oo.f11124O000000o == null || !hod.O000000o(corntabParam, ((SceneApi.O000OOOo) list.get(i)).O0000O0o.get(0).O00000Oo.f11124O000000o))) {
                                    hod.this.O00000Oo.add(list.get(i));
                                }
                            }
                            Collections.sort(hod.this.O00000Oo, hod.this.O0000oO0);
                        }
                    }
                    hod.this.O00000o.sendEmptyMessage(12);
                }

                public final void onFailure(fso fso) {
                    hod.this.O00000o(1);
                    if (gfr.O0000Ooo) {
                        LogType logType = LogType.GENERAL;
                        gsy.O00000o0(logType, "", "——Voice get remote error " + fso.toString());
                    }
                }
            });
            return;
        }
        this.O00000o.sendEmptyMessage(12);
    }

    public static boolean O000000o(List<SceneApi.O000000o> list) {
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (LAUNCH_TYPE.PHONE_SMS.equals(list.get(i).f11121O000000o) || LAUNCH_TYPE.PHONE_CALL.equals(list.get(i).f11121O000000o)) {
                return true;
            }
        }
        return false;
    }

    public final void O000000o(JSONObject jSONObject) {
        this.O000O0OO.clear();
        this.O000O0Oo.clear();
        JSONArray optJSONArray = jSONObject.optJSONArray("filterInfo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("tr_id");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("launch");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    arrayList.add(Integer.valueOf(optJSONArray2.optInt(i2)));
                }
                this.O000O0OO.put(Integer.valueOf(optInt), arrayList);
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("action_list");
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i3)));
                }
                this.O000O0Oo.put(Integer.valueOf(optInt), arrayList2);
            }
        }
    }

    public final List<Integer> O000000o(int i) {
        return this.O000O0OO.get(Integer.valueOf(i));
    }

    public final List<Integer> O00000Oo(int i) {
        return this.O000O0Oo.get(Integer.valueOf(i));
    }

    public static boolean O000000o(SceneApi.O000OOOo o000OOOo) {
        return o000OOOo != null && o000OOOo.O00000o == 151;
    }

    public static boolean O00000Oo(SceneApi.O000OOOo o000OOOo) {
        return o000OOOo != null && o000OOOo.O00000o == 152;
    }

    public static boolean O000000o(RecommendSceneItem recommendSceneItem) {
        return recommendSceneItem != null && recommendSceneItem.mRecommId == 151;
    }

    public final CommonSceneOnline O00000Oo(String str, String str2) {
        Map<String, CommonSceneOnline> map = this.O0000OoO;
        return map.get(str + str2);
    }

    /* access modifiers changed from: package-private */
    public final void O0000OOo() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            new AppConfigHelper(ServiceApplication.getAppContext()).O000000o("scene_degree_config", "1", "zh", null, new AppConfigHelper.O000000o() {
                /* class _m_j.hod.AnonymousClass5 */

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                }

                /* renamed from: O000000o */
                public final void onSuccess(String str, Response response) {
                    hod.this.O00000o(str);
                }
            });
            Map<String, CommonSceneOnline> map = this.O0000OoO;
            if (map == null || map.size() <= 0 || System.currentTimeMillis() - this.O0000ooo >= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                O000000o("/scene/tplv2", new HashMap(), null, new fsm<Map<String, CommonSceneOnline>, fso>() {
                    /* class _m_j.hod.AnonymousClass3 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        hod.this.O0000ooo = System.currentTimeMillis();
                        hod.this.O0000OoO.clear();
                        hod.this.O0000OoO.putAll((Map) obj);
                        hod.this.O00000o0(6);
                    }

                    public final void onFailure(fso fso) {
                        hod.this.O00000o(6);
                    }
                });
            } else {
                O00000o0(6);
            }
        }
    }

    public final void O000000o(String str, final Map<String, CommonSceneOnline> map, String str2, final fsm<Map<String, CommonSceneOnline>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        if (str2 != null) {
            try {
                jSONObject.put("start_did", str2);
            } catch (JSONException e) {
                gsy.O000000o(6, "SceneManager", Log.getStackTraceString(e));
            }
        }
        jSONObject.put("limit", 300);
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo(str).O000000o(arrayList).O000000o(), $$Lambda$hod$8hGHoI2LmeIMc8LzBbaMBacPJGo.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class _m_j.hod.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray optJSONArray;
                JSONArray optJSONArray2;
                CommonSceneOnline commonSceneOnline;
                int i;
                JSONObject jSONObject;
                JSONArray jSONArray;
                String str;
                String str2;
                String str3;
                JSONObject optJSONObject;
                int optInt;
                JSONObject optJSONObject2;
                String str4;
                String str5;
                String str6;
                String str7;
                int i2;
                ArrayList<CommonSceneOnline.O00000Oo> arrayList;
                String str8;
                String str9;
                String str10;
                String str11;
                String str12;
                JSONObject optJSONObject3;
                AnonymousClass4 r0 = this;
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2.has("max_action_num")) {
                    int optInt2 = jSONObject2.optInt("max_action_num");
                    hod.O0000o = optInt2;
                    if (optInt2 <= 0) {
                        hod.O0000o = 60;
                    }
                }
                if (jSONObject2.has("tpl") && (optJSONArray2 = jSONObject2.optJSONArray("tpl")) != null) {
                    int i3 = 0;
                    while (i3 < optJSONArray2.length()) {
                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i3);
                        CommonSceneOnline commonSceneOnline2 = new CommonSceneOnline();
                        commonSceneOnline2.f10655O000000o = optJSONObject4.optString("model");
                        commonSceneOnline2.O00000Oo = optJSONObject4.optString("did");
                        commonSceneOnline2.O00000o0 = optJSONObject4.optString("ptName");
                        String str13 = "value";
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject(str13);
                        if (optJSONObject5 != null) {
                            String str14 = "id";
                            String str15 = "groupInfo";
                            String str16 = "attr";
                            jSONArray = optJSONArray2;
                            String str17 = "show_tags";
                            jSONObject = jSONObject2;
                            String str18 = "degree";
                            i = i3;
                            if (optJSONObject5.has("launch")) {
                                JSONArray optJSONArray3 = optJSONObject5.optJSONArray("launch");
                                int i4 = 0;
                                while (i4 < optJSONArray3.length()) {
                                    JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i4);
                                    JSONArray jSONArray2 = optJSONArray3;
                                    ArrayList<CommonSceneOnline.O00000Oo> arrayList2 = commonSceneOnline2.O00000o;
                                    CommonSceneOnline commonSceneOnline3 = commonSceneOnline2;
                                    CommonSceneOnline.O00000Oo o00000Oo = new CommonSceneOnline.O00000Oo();
                                    JSONObject jSONObject3 = optJSONObject5;
                                    o00000Oo.f10658O000000o = optJSONObject6.optString("name");
                                    o00000Oo.O00000oo = optJSONObject6.optString("key");
                                    o00000Oo.O00000o = optJSONObject6.optInt("tr_id");
                                    o00000Oo.O00000Oo = optJSONObject6.optInt("sc_id");
                                    o00000Oo.O0000O0o = optJSONObject6.opt(str13);
                                    o00000Oo.O0000OOo = optJSONObject6.optString("plug_id");
                                    if (!optJSONObject6.has(str15) || (optJSONObject3 = optJSONObject6.optJSONObject(str15)) == null || !optJSONObject3.has(str14)) {
                                        str4 = str13;
                                        str5 = str15;
                                    } else {
                                        str4 = str13;
                                        str5 = str15;
                                        o00000Oo.O00000o0 = optJSONObject3.optInt(str14, -1);
                                        o00000Oo.O00000oO = optJSONObject3.optString("intro");
                                    }
                                    if (optJSONObject6.has(str16)) {
                                        JSONObject optJSONObject7 = optJSONObject6.optJSONObject(str16);
                                        int optInt3 = optJSONObject7.optInt("attr_id");
                                        str9 = str14;
                                        if (optInt3 == 1001) {
                                            CommonSceneOnline.O0000OOo o0000OOo = new CommonSceneOnline.O0000OOo();
                                            o0000OOo.f10659O000000o = optInt3;
                                            JSONObject optJSONObject8 = optJSONObject7.optJSONObject("params");
                                            str8 = str16;
                                            arrayList = arrayList2;
                                            o0000OOo.O00000Oo = (float) optJSONObject8.optDouble("max_val");
                                            o0000OOo.O00000o0 = (float) optJSONObject8.optDouble("min_val");
                                            o0000OOo.O00000o = (float) optJSONObject8.optDouble("interval");
                                            String degreeConfig = hor.O000000o().getDegreeConfig(optJSONObject8.optString(str18));
                                            if (!TextUtils.isEmpty(degreeConfig)) {
                                                o0000OOo.O00000oO = degreeConfig;
                                            } else {
                                                o0000OOo.O00000oO = optJSONObject8.optString(str18);
                                            }
                                            o0000OOo.O00000oo = optJSONObject8.optString("json_val_tag");
                                            o0000OOo.O0000O0o = optJSONObject8.optString("display_sub_title");
                                            o0000OOo.O0000OOo = (float) optJSONObject8.optDouble("default_val");
                                            if (optJSONObject8.has(str17)) {
                                                JSONArray optJSONArray4 = optJSONObject8.optJSONArray(str17);
                                                int i5 = 0;
                                                while (i5 < optJSONArray4.length()) {
                                                    CommonSceneOnline.NumberPickerTag numberPickerTag = new CommonSceneOnline.NumberPickerTag();
                                                    numberPickerTag.f10656O000000o = (float) optJSONArray4.optJSONObject(i5).optDouble("from");
                                                    numberPickerTag.O00000Oo = (float) optJSONArray4.optJSONObject(i5).optDouble("to");
                                                    numberPickerTag.O00000o0 = optJSONArray4.optJSONObject(i5).optString("tag");
                                                    o0000OOo.O0000Oo0.add(numberPickerTag);
                                                    i5++;
                                                    i4 = i4;
                                                    str17 = str17;
                                                    str18 = str18;
                                                }
                                            }
                                            str6 = str18;
                                            str7 = str17;
                                            i2 = i4;
                                            o00000Oo.O0000Oo0 = o0000OOo;
                                            if (o00000Oo.O0000O0o != null && (o00000Oo.O0000O0o instanceof JSONObject)) {
                                                JSONObject jSONObject4 = (JSONObject) o00000Oo.O0000O0o;
                                                if (jSONObject4.has("piid") || jSONObject4.has("sub_props")) {
                                                    o00000Oo.O0000O0o = hrc.O000000o(jSONObject4);
                                                    o00000Oo.O0000Oo = true;
                                                }
                                            }
                                        } else {
                                            str6 = str18;
                                            str7 = str17;
                                            i2 = i4;
                                            str8 = str16;
                                            arrayList = arrayList2;
                                            if (optInt3 == 1002) {
                                                CommonSceneOnline.O0000O0o o0000O0o = new CommonSceneOnline.O0000O0o();
                                                o0000O0o.f10659O000000o = optInt3;
                                                JSONObject optJSONObject9 = optJSONObject7.optJSONObject("params");
                                                o0000O0o.O00000oO = optJSONObject9.optString("display_sub_title");
                                                o0000O0o.O0000O0o = optJSONObject9.optString("act_name");
                                                o0000O0o.O00000oo = optJSONObject9.optString("radius_degree");
                                                o00000Oo.O0000Oo0 = o0000O0o;
                                            }
                                        }
                                    } else {
                                        str6 = str18;
                                        str7 = str17;
                                        i2 = i4;
                                        str8 = str16;
                                        arrayList = arrayList2;
                                        str9 = str14;
                                    }
                                    if (optJSONObject6.has("attr_new")) {
                                        str12 = str8;
                                        JSONObject optJSONObject10 = optJSONObject6.optJSONObject(str12);
                                        int optInt4 = optJSONObject10.optInt("attr_id");
                                        if (optInt4 == 1001) {
                                            CommonSceneOnline.O0000OOo o0000OOo2 = new CommonSceneOnline.O0000OOo();
                                            o0000OOo2.f10659O000000o = optInt4;
                                            JSONObject optJSONObject11 = optJSONObject10.optJSONObject("params");
                                            o0000OOo2.O00000Oo = (float) optJSONObject11.optDouble("max_val");
                                            o0000OOo2.O00000o0 = (float) optJSONObject11.optDouble("min_val");
                                            o0000OOo2.O00000o = (float) optJSONObject11.optDouble("interval");
                                            str11 = str6;
                                            o0000OOo2.O00000oO = optJSONObject11.optString(str11);
                                            String degreeConfig2 = hor.O000000o().getDegreeConfig(optJSONObject11.optString(str11));
                                            if (!TextUtils.isEmpty(degreeConfig2)) {
                                                o0000OOo2.O00000oO = degreeConfig2;
                                            } else {
                                                o0000OOo2.O00000oO = optJSONObject11.optString(str11);
                                            }
                                            o0000OOo2.O00000oo = optJSONObject11.optString("json_val_tag");
                                            o0000OOo2.O0000O0o = optJSONObject11.optString("display_sub_title");
                                            o0000OOo2.O0000OOo = (float) optJSONObject11.optDouble("default_val");
                                            str10 = str7;
                                            if (optJSONObject11.has(str10)) {
                                                JSONArray optJSONArray5 = optJSONObject11.optJSONArray(str10);
                                                for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                                                    CommonSceneOnline.NumberPickerTag numberPickerTag2 = new CommonSceneOnline.NumberPickerTag();
                                                    numberPickerTag2.f10656O000000o = (float) optJSONArray5.optJSONObject(i6).optDouble("from");
                                                    numberPickerTag2.O00000Oo = (float) optJSONArray5.optJSONObject(i6).optDouble("to");
                                                    numberPickerTag2.O00000o0 = optJSONArray5.optJSONObject(i6).optString("tag");
                                                    o0000OOo2.O0000Oo0.add(numberPickerTag2);
                                                }
                                            }
                                            o00000Oo.O0000Oo0 = o0000OOo2;
                                            if (o00000Oo.O0000O0o != null && (o00000Oo.O0000O0o instanceof JSONObject)) {
                                                JSONObject jSONObject5 = (JSONObject) o00000Oo.O0000O0o;
                                                if (jSONObject5.has("piid") || jSONObject5.has("sub_props")) {
                                                    o00000Oo.O0000O0o = hrc.O000000o(jSONObject5);
                                                    o00000Oo.O0000Oo = true;
                                                }
                                            }
                                        } else {
                                            str10 = str7;
                                            str11 = str6;
                                            if (optInt4 == 1002) {
                                                CommonSceneOnline.O0000O0o o0000O0o2 = new CommonSceneOnline.O0000O0o();
                                                o0000O0o2.f10659O000000o = optInt4;
                                                JSONObject optJSONObject12 = optJSONObject10.optJSONObject("params");
                                                o0000O0o2.O00000oO = optJSONObject12.optString("display_sub_title");
                                                o0000O0o2.O0000O0o = optJSONObject12.optString("act_name");
                                                o0000O0o2.O00000oo = optJSONObject12.optString("radius_degree");
                                                o00000Oo.O0000Oo0 = o0000O0o2;
                                            }
                                        }
                                    } else {
                                        str12 = str8;
                                        str10 = str7;
                                        str11 = str6;
                                    }
                                    arrayList.add(o00000Oo);
                                    i4 = i2 + 1;
                                    str17 = str10;
                                    optJSONArray3 = jSONArray2;
                                    commonSceneOnline2 = commonSceneOnline3;
                                    str15 = str5;
                                    str13 = str4;
                                    str14 = str9;
                                    str16 = str12;
                                    str18 = str11;
                                    optJSONObject5 = jSONObject3;
                                }
                            }
                            JSONObject jSONObject6 = optJSONObject5;
                            commonSceneOnline = commonSceneOnline2;
                            String str19 = str13;
                            String str20 = str14;
                            String str21 = str15;
                            String str22 = str18;
                            String str23 = str16;
                            String str24 = str17;
                            JSONObject jSONObject7 = jSONObject6;
                            if (jSONObject7.has("action_list")) {
                                JSONArray optJSONArray6 = jSONObject7.optJSONArray("action_list");
                                int i7 = 0;
                                while (i7 < optJSONArray6.length()) {
                                    JSONObject optJSONObject13 = optJSONArray6.optJSONObject(i7);
                                    CommonSceneOnline commonSceneOnline4 = commonSceneOnline;
                                    ArrayList<CommonSceneOnline.O000000o> arrayList3 = commonSceneOnline4.O00000oO;
                                    CommonSceneOnline.O000000o o000000o = new CommonSceneOnline.O000000o();
                                    o000000o.f10657O000000o = optJSONObject13.optString("name");
                                    o000000o.O00000Oo = optJSONObject13.optInt("sa_id");
                                    JSONObject optJSONObject14 = optJSONObject13.optJSONObject("payload");
                                    o000000o.O00000oO = optJSONObject14.optString("command");
                                    JSONArray jSONArray3 = optJSONArray6;
                                    String str25 = str19;
                                    o000000o.O00000oo = optJSONObject14.opt(str25);
                                    o000000o.O0000O0o = optJSONObject14.optString("plug_id");
                                    o000000o.O0000OOo = optJSONObject13.optInt("tr_id");
                                    String str26 = str21;
                                    if (!optJSONObject13.has(str26) || (optJSONObject2 = optJSONObject13.optJSONObject(str26)) == null) {
                                        str21 = str26;
                                        commonSceneOnline = commonSceneOnline4;
                                        str19 = str25;
                                        str = str20;
                                    } else {
                                        str21 = str26;
                                        str = str20;
                                        if (optJSONObject2.has(str)) {
                                            commonSceneOnline = commonSceneOnline4;
                                            str19 = str25;
                                            o000000o.O00000o0 = optJSONObject2.optInt(str, -1);
                                            o000000o.O00000o = optJSONObject2.optString("intro");
                                        } else {
                                            commonSceneOnline = commonSceneOnline4;
                                            str19 = str25;
                                        }
                                    }
                                    if (!optJSONObject14.has(str23) || (optInt = (optJSONObject = optJSONObject14.optJSONObject(str23)).optInt("attr_id")) != 2001) {
                                        str20 = str;
                                        str3 = str23;
                                        str2 = str22;
                                    } else {
                                        CommonSceneOnline.O0000OOo o0000OOo3 = new CommonSceneOnline.O0000OOo();
                                        o0000OOo3.f10659O000000o = optInt;
                                        JSONObject optJSONObject15 = optJSONObject.optJSONObject("params");
                                        str20 = str;
                                        str3 = str23;
                                        o0000OOo3.O00000Oo = (float) optJSONObject15.optDouble("max_val");
                                        o0000OOo3.O00000o0 = (float) optJSONObject15.optDouble("min_val");
                                        o0000OOo3.O00000o = (float) optJSONObject15.optDouble("interval");
                                        String degreeConfig3 = hor.O000000o().getDegreeConfig(optJSONObject15.optString(str22));
                                        if (!TextUtils.isEmpty(degreeConfig3)) {
                                            o0000OOo3.O00000oO = degreeConfig3;
                                        } else {
                                            o0000OOo3.O00000oO = optJSONObject15.optString(str22);
                                        }
                                        o0000OOo3.O00000oo = optJSONObject15.optString("json_val_tag");
                                        o0000OOo3.O0000OOo = (float) optJSONObject15.optDouble("default_val");
                                        if (optJSONObject.has(str24)) {
                                            JSONArray optJSONArray7 = optJSONObject.optJSONArray(str24);
                                            int i8 = 0;
                                            while (i8 < optJSONArray7.length()) {
                                                CommonSceneOnline.NumberPickerTag numberPickerTag3 = new CommonSceneOnline.NumberPickerTag();
                                                numberPickerTag3.f10656O000000o = (float) optJSONArray7.optJSONObject(i8).optDouble("from");
                                                numberPickerTag3.O00000Oo = (float) optJSONArray7.optJSONObject(i8).optDouble("to");
                                                numberPickerTag3.O00000o0 = optJSONArray7.optJSONObject(i8).optString("tag");
                                                o0000OOo3.O0000Oo0.add(numberPickerTag3);
                                                i8++;
                                                str22 = str22;
                                            }
                                        }
                                        str2 = str22;
                                        o000000o.O0000Oo0 = o0000OOo3;
                                        if (o000000o.O00000oo != null && (o000000o.O00000oo instanceof JSONObject)) {
                                            JSONObject jSONObject8 = (JSONObject) o000000o.O00000oo;
                                            if (jSONObject8.has("piid")) {
                                                o000000o.O00000oo = hrc.O000000o(jSONObject8);
                                                o000000o.O0000Oo = true;
                                            } else if (jSONObject8.has("aiid")) {
                                                o000000o.O00000oo = hqz.O000000o(jSONObject8);
                                                o000000o.O0000Oo = true;
                                            }
                                            arrayList3.add(o000000o);
                                            i7++;
                                            optJSONArray6 = jSONArray3;
                                            str23 = str3;
                                            str22 = str2;
                                        }
                                    }
                                    arrayList3.add(o000000o);
                                    i7++;
                                    optJSONArray6 = jSONArray3;
                                    str23 = str3;
                                    str22 = str2;
                                }
                            }
                        } else {
                            jSONObject = jSONObject2;
                            jSONArray = optJSONArray2;
                            i = i3;
                            commonSceneOnline = commonSceneOnline2;
                        }
                        HashMap hashMap = new HashMap();
                        CommonSceneOnline commonSceneOnline5 = commonSceneOnline;
                        for (int i9 = 0; i9 < commonSceneOnline5.O00000o.size(); i9++) {
                            if (commonSceneOnline5.O00000o.get(i9).O00000o0 != -1 && !hashMap.containsKey(Integer.valueOf(commonSceneOnline5.O00000o.get(i9).O00000o0))) {
                                CommonSceneOnline.O00000o0 o00000o0 = new CommonSceneOnline.O00000o0();
                                o00000o0.f10660O000000o = commonSceneOnline5.O00000o.get(i9).O00000oO;
                                o00000o0.O00000Oo = commonSceneOnline5.O00000o.get(i9).O00000o0;
                                commonSceneOnline5.O00000oo.add(o00000o0);
                                hashMap.put(Integer.valueOf(o00000o0.O00000Oo), o00000o0.f10660O000000o);
                            }
                        }
                        hashMap.clear();
                        for (int i10 = 0; i10 < commonSceneOnline5.O00000oO.size(); i10++) {
                            if (commonSceneOnline5.O00000oO.get(i10).O00000o0 != -1 && !hashMap.containsKey(Integer.valueOf(commonSceneOnline5.O00000oO.get(i10).O00000o0))) {
                                CommonSceneOnline.O00000o0 o00000o02 = new CommonSceneOnline.O00000o0();
                                o00000o02.f10660O000000o = commonSceneOnline5.O00000oO.get(i10).O00000o;
                                o00000o02.O00000Oo = commonSceneOnline5.O00000oO.get(i10).O00000o0;
                                commonSceneOnline5.O0000O0o.add(o00000o02);
                                hashMap.put(Integer.valueOf(o00000o02.O00000Oo), o00000o02.f10660O000000o);
                            }
                        }
                        Map map = map;
                        map.put(commonSceneOnline5.f10655O000000o + commonSceneOnline5.O00000Oo, commonSceneOnline5);
                        i3 = i + 1;
                        r0 = this;
                        optJSONArray2 = jSONArray;
                        jSONObject2 = jSONObject;
                    }
                }
                AnonymousClass4 r2 = r0;
                JSONObject jSONObject9 = jSONObject2;
                if (jSONObject9.has("filter") && (optJSONArray = jSONObject9.optJSONArray("filter")) != null && optJSONArray.length() > 0) {
                    hod.this.O000000o(optJSONArray.optJSONObject(0));
                }
                if (jSONObject9.optBoolean("has_more")) {
                    String optString = jSONObject9.optString("max_did");
                    if (gfr.O0000OOo) {
                        gsy.O00000Oo(LogType.GENERAL, "SceneManager", "updateMoreSceneTemplate onSuccess hasmore max_id:".concat(String.valueOf(optString)));
                    }
                    hod.this.O000000o("/scene/tpl_paging", map, optString, fsm);
                    return;
                }
                if (gfr.O0000OOo) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "SceneManager", "updateMoreSceneTemplate onSuccess " + map.size());
                }
                fsm.onSuccess(map);
            }

            public final void onFailure(fso fso) {
                fsm.onFailure(fso);
                gsy.O00000Oo(LogType.GENERAL, "SceneManager", "updateMoreSceneTemplate onFailure");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O0000Oo0() {
        O0000OOo();
    }

    public final List<SceneApi.O000OOOo> O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        if (!this.O00000oo || this.f416O000000o == null) {
            return arrayList;
        }
        for (int i = 0; i < this.f416O000000o.size(); i++) {
            if (this.f416O000000o.get(i).O0000O0o != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < this.f416O000000o.get(i).O0000O0o.size()) {
                        if (this.f416O000000o.get(i).O0000O0o.get(i2).f11121O000000o == LAUNCH_TYPE.DEVICE && this.f416O000000o.get(i).O0000O0o.get(i2).O00000o0 != null && TextUtils.equals(str, this.f416O000000o.get(i).O0000O0o.get(i2).O00000o0.f11122O000000o)) {
                            arrayList.add(this.f416O000000o.get(i));
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (i2 == this.f416O000000o.get(i).O0000O0o.size()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < this.f416O000000o.get(i).O00000oo.size()) {
                            if (this.f416O000000o.get(i).O00000oo.get(i3).f11120O000000o == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value && this.f416O000000o.get(i).O00000oo.get(i3).O0000O0o != null && TextUtils.equals(str, this.f416O000000o.get(i).O00000oo.get(i3).O0000O0o.O00000o)) {
                                arrayList.add(this.f416O000000o.get(i));
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final SceneApi.O000OOOo O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.f416O000000o.size(); i++) {
            if (this.f416O000000o.get(i) != null && TextUtils.equals(this.f416O000000o.get(i).f11131O000000o, str)) {
                return this.f416O000000o.get(i);
            }
        }
        return null;
    }

    public final boolean O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.f416O000000o.size(); i++) {
            if (TextUtils.equals(str, this.f416O000000o.get(i).f11131O000000o)) {
                this.f416O000000o.remove(i);
                return true;
            }
        }
        for (int i2 = 0; i2 < this.O00000Oo.size(); i2++) {
            if (TextUtils.equals(str, this.O00000Oo.get(i2).f11131O000000o)) {
                this.O00000Oo.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final void O00000o0(SceneApi.O000OOOo o000OOOo) {
        this.f416O000000o.add(o000OOOo);
    }

    public final void O000000o(String str, SceneApi.O000OOOo o000OOOo) {
        for (int i = 0; i < this.f416O000000o.size(); i++) {
            if (TextUtils.equals(str, this.f416O000000o.get(i).f11131O000000o)) {
                this.f416O000000o.remove(i);
                this.f416O000000o.add(i, o000OOOo);
                return;
            }
        }
    }

    public final void O00000Oo(hny hny) {
        hny hny2;
        if (hny != null) {
            int i = 0;
            while (i < this.O000O0oO.size()) {
                WeakReference weakReference = this.O000O0oO.get(i);
                if (weakReference == null || (hny2 = (hny) weakReference.get()) == null || hny2 != hny) {
                    i++;
                } else {
                    gsy.O00000Oo("SceneManager", "registerLiteSceneListener return");
                    return;
                }
            }
            this.O000O0oO.add(new WeakReference(hny));
        }
    }

    public final boolean O00000o0(hny hny) {
        if (hny == null) {
            return false;
        }
        for (int i = 0; i < this.O000O0oO.size(); i++) {
            if (this.O000O0oO.get(i).get() == hny) {
                this.O000O0oO.remove(i);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0(int i) {
        gsy.O00000o0(LogType.SCENE, "scene", "SceneManager notifySuccess  type: ".concat(String.valueOf(i)));
        if (i != 1) {
            int i2 = 0;
            if (i == 12) {
                while (i2 < this.O000O0oO.size()) {
                    if (this.O000O0oO.get(i2).get() != null) {
                        ((hny) this.O000O0oO.get(i2).get()).onRefreshScenceSuccess(i);
                    }
                    i2++;
                }
            } else if (i == 4) {
                this.O000O0o = true;
                while (i2 < this.O000O0oO.size()) {
                    if (this.O000O0oO.get(i2).get() != null) {
                        ((hny) this.O000O0oO.get(i2).get()).onRefreshScenceSuccess(i);
                    }
                    i2++;
                }
            } else if (i == 5) {
                this.O0000Oo0 = true;
                for (int i3 = 0; i3 < this.O000O0oO.size(); i3++) {
                    if (this.O000O0oO.get(i3).get() != null) {
                        ((hny) this.O000O0oO.get(i3).get()).onRefreshScenceSuccess(i);
                    }
                }
                for (int i4 = 0; i4 < this.O000O0oo.size(); i4++) {
                    hny hny = this.O000O0oo.get(i4);
                    if (hny != null) {
                        hny.onRefreshScenceSuccess(i);
                    }
                }
                this.O000O0o = false;
                this.O000O0oo.clear();
            } else if (i == 6) {
                this.O0000OOo = true;
            }
        } else {
            this.O00000o.sendEmptyMessage(5);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o(int i) {
        this.O00000oO = false;
        this.O0000Oo0 = false;
        for (int i2 = 0; i2 < this.O000O0oO.size(); i2++) {
            if (this.O000O0oO.get(i2).get() != null) {
                ((hny) this.O000O0oO.get(i2).get()).onRefreshScenceFailed(i);
            }
        }
        for (int i3 = 0; i3 < this.O000O0oo.size(); i3++) {
            this.O000O0oo.get(i3).onRefreshScenceFailed(i);
        }
        this.O000O0oo.clear();
    }

    public final synchronized void O0000Oo() {
        this.O00oOooo.clear();
        this.O000O00o.clear();
        this.O00000o0.clear();
        this.O00000o0.addAll(this.f416O000000o);
        for (SceneApi.O000OOOo next : this.f416O000000o) {
            if (O000000o(next)) {
                this.O000O00o.add(next);
            }
            if (O00000Oo(next)) {
                this.O00oOooo.add(next);
            }
        }
    }

    public static synchronized hod O0000OoO() {
        hod hod;
        synchronized (hod.class) {
            if (O00oOooO == null) {
                O00oOooO = new hod();
            }
            hod = O00oOooO;
        }
        return hod;
    }

    public static void O0000Ooo() {
        hod hod = O00oOooO;
        hod hod2 = new hod();
        O00oOooO = hod2;
        hod2.O000O0oo.addAll(hod.O000O0oo);
        O00oOooO.O000O0oO.addAll(hod.O000O0oO);
    }

    public final void O0000o00() {
        this.f416O000000o.clear();
        this.O0000OoO.clear();
        this.O00000oo = false;
        this.O0000Oo0 = false;
        this.O0000Oo = 0;
        this.O0000OOo = false;
    }

    public static SceneInfo O00000o(SceneApi.O000OOOo o000OOOo) {
        SceneInfo sceneInfo = new SceneInfo();
        sceneInfo.mSceneIdV2 = o000OOOo.f11131O000000o;
        try {
            sceneInfo.mSceneId = (int) Long.parseLong(o000OOOo.f11131O000000o);
        } catch (Exception unused) {
            sceneInfo.mSceneId = -1;
        }
        sceneInfo.mName = o000OOOo.O00000Oo;
        sceneInfo.mStatus = o000OOOo.O0000o0o;
        sceneInfo.mType = o000OOOo.O0000o;
        sceneInfo.mEnable = o000OOOo.O0000Oo0;
        sceneInfo.mLaunchList = new ArrayList();
        sceneInfo.mConditionDevice = new ArrayList();
        Iterator<SceneApi.O000000o> it = o000OOOo.O0000O0o.iterator();
        while (true) {
            String str = "";
            if (it.hasNext()) {
                SceneApi.O000000o next = it.next();
                SceneInfo.SceneLaunch sceneLaunch = new SceneInfo.SceneLaunch();
                switch (AnonymousClass6.f425O000000o[next.f11121O000000o.ordinal()]) {
                    case 1:
                        sceneLaunch.mLaunchType = 0;
                        break;
                    case 2:
                        sceneLaunch.mLaunchType = 2;
                        sceneLaunch.mDeviceModel = next.O00000o0.O00000o;
                        break;
                    case 3:
                        sceneLaunch.mLaunchType = 1;
                        break;
                    case 4:
                        sceneLaunch.mLaunchType = 4;
                        break;
                    case 5:
                        sceneLaunch.mLaunchType = 3;
                        break;
                    case 6:
                        sceneLaunch.mLaunchType = 7;
                        break;
                    case 7:
                        sceneLaunch.mLaunchType = 8;
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                        sceneLaunch.mLaunchType = 14;
                        break;
                    case 9:
                        sceneLaunch.mLaunchType = 15;
                        break;
                    case 10:
                        sceneLaunch.mLaunchType = 16;
                        break;
                    case 11:
                        sceneLaunch.mLaunchType = 17;
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        sceneLaunch.mLaunchType = 18;
                        break;
                    case 13:
                        sceneLaunch.mLaunchType = 19;
                        break;
                    case 14:
                        sceneLaunch.mLaunchType = 20;
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        sceneLaunch.mLaunchType = 21;
                        break;
                    case 16:
                        sceneLaunch.mLaunchType = 22;
                        break;
                }
                sceneLaunch.mLaunchName = hnw.O00000o(ServiceApplication.getAppContext(), next);
                if (next.O00000o0 != null) {
                    sceneLaunch.mDid = next.O00000o0.f11122O000000o;
                    sceneInfo.mConditionDevice.add(new SceneInfo.ConditionDevice(sceneLaunch.mDid, next.O00000o0.O00000o));
                }
                if (next.O00000o0 != null && (next.O00000o0 instanceof SceneApi.O00000o0)) {
                    sceneLaunch.mExtra = ((SceneApi.O00000o0) next.O00000o0).O0000o00;
                }
                if (!(next.O00000o0 == null || next.O00000o0.O0000Oo == null)) {
                    str = next.O00000o0.O0000Oo;
                }
                sceneLaunch.mEventString = str;
                if (next.O00000o0 != null && (next.O00000o0 instanceof SceneApi.O00000o0)) {
                    try {
                        sceneLaunch.mEventValue = ((SceneApi.O00000o0) next.O00000o0).O0000Ooo;
                    } catch (Exception unused2) {
                    }
                }
                sceneInfo.mLaunchList.add(sceneLaunch);
                sceneInfo.mLaunch = sceneLaunch;
            } else {
                sceneInfo.mActions = new ArrayList();
                for (SceneApi.Action next2 : o000OOOo.O00000oo) {
                    SceneInfo.SceneAction sceneAction = new SceneInfo.SceneAction();
                    if (next2.O00000Oo != null) {
                        sceneAction.mDeviceName = next2.O00000Oo;
                    } else {
                        sceneAction.mDeviceName = str;
                    }
                    sceneAction.mActionName = next2.O00000o0;
                    sceneAction.mDeviceModel = next2.O00000oO;
                    sceneAction.mDelayTime = next2.O0000O0o.O00000oo;
                    if (next2.O0000O0o.O00000o0 == null) {
                        sceneAction.mActionString = next2.O00000o0;
                    } else {
                        sceneAction.mActionString = next2.O0000O0o.O00000o0;
                    }
                    sceneAction.mDid = next2.O0000O0o.O00000o;
                    try {
                        sceneAction.mActionValue = next2.O0000O0o.O00000oO;
                    } catch (Exception unused3) {
                    }
                    if (next2.O0000O0o instanceof SceneApi.O000O00o) {
                        sceneAction.mActionType = 12;
                    } else if (next2.O0000O0o instanceof SceneApi.O000O0OO) {
                        sceneAction.mActionType = 10;
                    } else if (next2.O0000O0o instanceof SceneApi.O000O0o0) {
                        sceneAction.mActionType = 9;
                    } else if (next2.O0000O0o instanceof SceneApi.O000OO0o) {
                        sceneAction.mActionType = 13;
                    } else if (next2.O0000O0o instanceof SceneApi.O000OO) {
                        sceneAction.mActionType = 11;
                    }
                    sceneInfo.mActions.add(sceneAction);
                }
                return sceneInfo;
            }
        }
    }

    /* renamed from: _m_j.hod$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f425O000000o = new int[LAUNCH_TYPE.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f425O000000o[LAUNCH_TYPE.CLICK.ordinal()] = 1;
            f425O000000o[LAUNCH_TYPE.DEVICE.ordinal()] = 2;
            f425O000000o[LAUNCH_TYPE.TIMER.ordinal()] = 3;
            f425O000000o[LAUNCH_TYPE.COME_HOME.ordinal()] = 4;
            f425O000000o[LAUNCH_TYPE.LEAVE_HOME.ordinal()] = 5;
            f425O000000o[LAUNCH_TYPE.PHONE_CALL.ordinal()] = 6;
            f425O000000o[LAUNCH_TYPE.PHONE_SMS.ordinal()] = 7;
            f425O000000o[LAUNCH_TYPE.HUMIDITY.ordinal()] = 8;
            f425O000000o[LAUNCH_TYPE.AQI.ordinal()] = 9;
            f425O000000o[LAUNCH_TYPE.SUN_RISE.ordinal()] = 10;
            f425O000000o[LAUNCH_TYPE.SUN_SET.ordinal()] = 11;
            f425O000000o[LAUNCH_TYPE.TEMPERATURE.ordinal()] = 12;
            f425O000000o[LAUNCH_TYPE.COME_LOC.ordinal()] = 13;
            f425O000000o[LAUNCH_TYPE.LEAVE_LOC.ordinal()] = 14;
            f425O000000o[LAUNCH_TYPE.ENTER_FENCE.ordinal()] = 15;
            try {
                f425O000000o[LAUNCH_TYPE.LEAVE_FENCE.ordinal()] = 16;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static boolean O00000oO(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() == 0) {
            return false;
        }
        int i = 0;
        while (i < o000OOOo.O0000O0o.size()) {
            if (o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.COME_LOC || o000OOOo.O0000O0o.get(i).f11121O000000o == LAUNCH_TYPE.LEAVE_LOC) {
                return false;
            }
            if ((o000OOOo.O0000O0o.get(i).f11121O000000o != LAUNCH_TYPE.ENTER_FENCE && o000OOOo.O0000O0o.get(i).f11121O000000o != LAUNCH_TYPE.LEAVE_FENCE) || o000OOOo.O0000O0o.get(i).O0000Oo == null || TextUtils.isEmpty(o000OOOo.O0000O0o.get(i).O0000Oo.O0000o0O) || (!TextUtils.equals("leave_fence", o000OOOo.O0000O0o.get(i).O0000Oo.O0000o0O) && !TextUtils.equals("enter_fence", o000OOOo.O0000O0o.get(i).O0000Oo.O0000o0O))) {
                i++;
            } else if (hpf.O000000o().O00000o0()) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public final boolean O00000o(String str) {
        gsy.O00000Oo("SceneManager", "parseDegreeConfig ".concat(String.valueOf(str)));
        this.O0000o0O.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("key");
                    String string2 = jSONObject.getString("zh");
                    String string3 = jSONObject.getString("en");
                    O000000o o000000o = new O000000o();
                    o000000o.f429O000000o = string2;
                    o000000o.O00000Oo = string3;
                    this.O0000o0O.put(string, o000000o);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f429O000000o;
        public String O00000Oo;

        public O000000o() {
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [_m_j.hqr] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void O000000o(String str, String str2, final fsm fsm) {
        Map<String, SceneApi.O000OOOo> map = this.O0000oO;
        ? r2 = 0;
        SceneApi.O000OOOo o000OOOo = map == null ? null : map.get(str);
        if (o000OOOo == null || !o000OOOo.O0000Oo0 || o000OOOo.O0000O0o == null || o000OOOo.O00000oo == null) {
            Map<String, hqr> map2 = this.O0000oOO;
            if (map2 != null) {
                r2 = map2.get(str);
            }
            if (r2 != 0) {
                final long j = r2.f528O000000o;
                String str3 = r2.O00000o0;
                gsy.O00000Oo(LogType.SCENE, "GEO_FENCE", "try to run spec scene ".concat(String.valueOf(j)));
                hnz.O000000o(ServiceApplication.getAppContext(), str3, j, new fsm<JSONObject, fso>() {
                    /* class _m_j.hod.AnonymousClass7 */

                    public final void onFailure(fso fso) {
                        LogType logType = LogType.SCENE;
                        gsy.O00000o0(logType, "GEO_FENCE", "run spec scene fail " + j);
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        LogType logType = LogType.SCENE;
                        gsy.O00000o0(logType, "GEO_FENCE", "run spec scene success " + j);
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.onSuccess(null);
                        }
                    }
                });
                return;
            }
            gsy.O00000o0(LogType.SCENE, "GEO_FENCE", "no  scene for fence： ".concat(String.valueOf(str)));
            fsm.onFailure(new fso(-9999, "no  scene for fence： ".concat(String.valueOf(str))));
            return;
        }
        LAUNCH_TYPE launch_type = LAUNCH_TYPE.LEAVE_FENCE;
        int i = 0;
        while (true) {
            if (i >= o000OOOo.O0000O0o.size()) {
                break;
            } else if (o000OOOo.O0000O0o.get(i) == null || o000OOOo.O0000O0o.get(i).O0000Oo == null || !((launch_type = o000OOOo.O0000O0o.get(i).f11121O000000o) == LAUNCH_TYPE.LEAVE_FENCE || launch_type == LAUNCH_TYPE.ENTER_FENCE)) {
                i++;
            }
        }
        r2 = o000OOOo.O0000O0o.get(i).O0000Oo.O0000o0O;
        boolean isEmpty = TextUtils.isEmpty(r2);
        String str4 = r2;
        if (isEmpty) {
            str4 = launch_type == LAUNCH_TYPE.LEAVE_FENCE ? "leave_fence" : "enter_fence";
        }
        if (TextUtils.isEmpty(str4)) {
            LogType logType = LogType.SCENE;
            gsy.O00000Oo(logType, "GEO_FENCE", "onTriger,but no this scene： " + o000OOOo.f11131O000000o);
            fsm.onFailure(new fso(-90, "empty key"));
        } else if (launch_type == LAUNCH_TYPE.LEAVE_FENCE) {
            O000000o(str4, str2, o000OOOo, fsm, 3, new int[]{0, 10, 10}, System.currentTimeMillis(), 60000);
        } else {
            O000000o(str4, str2, o000OOOo, fsm, 2, new int[]{0, 10}, System.currentTimeMillis(), DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
        }
    }

    public static boolean O000000o(CorntabUtils.CorntabParam corntabParam, CorntabUtils.CorntabParam corntabParam2) {
        return corntabParam2.O000000o(corntabParam) == 1;
    }
}
