package _m_j;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.scene.Scene;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class flb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile flb f16560O000000o;
    static final Object O00000Oo = new Object();
    public boolean O00000o = false;
    public HandlerThread O00000o0 = new HandlerThread("scene_executor");
    private HashMap<String, ArrayList<Scene>> O00000oO = new HashMap<>();
    private Handler O00000oo;

    public static flb O000000o() {
        if (f16560O000000o == null) {
            synchronized (O00000Oo) {
                if (f16560O000000o == null) {
                    f16560O000000o = new flb();
                }
            }
        }
        return f16560O000000o;
    }

    private flb() {
        this.O00000o0.start();
        this.O00000oo = new Handler(this.O00000o0.getLooper()) {
            /* class _m_j.flb.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    if (message.obj == null) {
                        flb.this.O00000o0();
                    } else {
                        flb.this.O00000o0();
                    }
                }
            }
        };
    }

    public final void O000000o(String str) {
        List list = this.O00000oO.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Scene scene = (Scene) list.get(i);
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", scene.O00000Oo);
                    jSONObject.put("us_id", scene.f6741O000000o);
                } catch (JSONException unused) {
                }
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/start").O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>(scene, true) {
                    /* class _m_j.flb.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Scene f16563O000000o;
                    final /* synthetic */ boolean O00000Oo = true;

                    {
                        this.f16563O000000o = r2;
                    }

                    public final /* synthetic */ void onFailure(Error error) {
                        NetError netError = (NetError) error;
                        if (this.O00000Oo) {
                            Intent intent = new Intent("com.xiaomi.smarthome.scene.execute_failed");
                            intent.putExtra("id", this.f16563O000000o.f6741O000000o);
                            if (!gfr.O0000OOo) {
                                intent.putExtra("name", this.f16563O000000o.O00000oO);
                            } else if (netError != null) {
                                intent.putExtra("name", netError.f6718O000000o + "," + netError.O00000Oo + "," + this.f16563O000000o.O00000oO);
                            } else {
                                intent.putExtra("name", this.f16563O000000o.O00000oO);
                            }
                            CommonApplication.getAppContext().sendBroadcast(intent);
                            fld.O00000o0().O000000o(StatType.EVENT.getValue(), "mihome", "geofence_exe_scene_fail", this.f16563O000000o.O00000Oo + "," + this.f16563O000000o.f6741O000000o, netError.f6718O000000o + "," + netError.O00000Oo, false);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        NetResult netResult = (NetResult) obj;
                        if (netResult.O00000o0 != null) {
                            gsy.O000000o(6, "SceneManager", netResult.O00000o0);
                        }
                        if (gfr.O0000OOo) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class _m_j.flb.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    Context appContext = CommonApplication.getAppContext();
                                    izb.O000000o(appContext, AnonymousClass3.this.f16563O000000o.O00000oO + " 执行成功！", 1).show();
                                }
                            });
                        }
                        if (this.O00000Oo) {
                            Intent intent = new Intent("com.xiaomi.smarthome.scene.execute_success");
                            intent.putExtra("id", this.f16563O000000o.f6741O000000o);
                            intent.putExtra("name", this.f16563O000000o.O00000oO);
                            CommonApplication.getAppContext().sendBroadcast(intent);
                        }
                        fld O00000o02 = fld.O00000o0();
                        String value = StatType.EVENT.getValue();
                        O00000o02.O000000o(value, "mihome", "geofence_exe_scene_suc", this.f16563O000000o.O00000Oo + "," + this.f16563O000000o.f6741O000000o, null, false);
                    }
                });
            }
        }
        if (gfr.O0000OOo && list == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class _m_j.flb.AnonymousClass2 */

                public final void run() {
                    izb.O000000o(CommonApplication.getAppContext(), "cannot find scene in mSceneMap", 1).show();
                }
            });
        }
    }

    public final void O00000Oo() {
        this.O00000oo.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        gsy.O000000o(6, "SceneManager", "Start Get Scene");
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("st_id", "15");
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/scene/list").O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
            /* class _m_j.flb.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                if (netResult == null || netResult.O00000o0 == null || netResult.O00000o0.isEmpty()) {
                    ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("scene_manager_init_fail_normal_scene"));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(netResult.O00000o0);
                    gsy.O000000o(6, "SceneManager", "Get Scene Success");
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    if (optJSONObject != null) {
                        flb.this.O000000o(optJSONObject);
                        flb.this.O00000o = true;
                        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("scene_manager_init_success_normal_scene"));
                    }
                } catch (JSONException unused) {
                    ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("scene_manager_init_fail_normal_scene"));
                }
            }

            public final /* synthetic */ void onFailure(Error error) {
                ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("scene_manager_init_fail_normal_scene"));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(JSONObject jSONObject) {
        JSONArray optJSONArray;
        this.O00000oO.clear();
        for (int i = 0; jSONObject.has(String.valueOf(i)); i++) {
            JSONObject optJSONObject = jSONObject.optJSONObject(String.valueOf(i));
            Scene scene = new Scene();
            scene.f6741O000000o = optJSONObject.optString("us_id");
            scene.O00000oO = optJSONObject.optString("name");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("setting");
            scene.O00000o0 = optJSONObject2.optString("enable").equals("1");
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("launch");
            if (optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("sub_launch");
                JSONArray optJSONArray2 = optJSONObject3.optJSONArray("attr");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        try {
                            Object obj = optJSONArray2.get(i2);
                            if (obj != null) {
                                if (obj instanceof JSONObject) {
                                    if (TextUtils.equals("user", ((JSONObject) obj).optString("src"))) {
                                        String optString = optJSONArray2.optJSONObject(i2).optString("key");
                                        if (!TextUtils.isEmpty(optString)) {
                                            scene.O00000Oo = optString;
                                            ArrayList arrayList = this.O00000oO.get(optString);
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                                this.O00000oO.put(optString, arrayList);
                                            }
                                            arrayList.add(scene);
                                        }
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (!(optJSONObject4 == null || (optJSONArray = optJSONObject4.optJSONArray("attr")) == null || optJSONArray.length() <= 0)) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        if (optJSONArray.optJSONObject(i3).optString("src").equalsIgnoreCase("user")) {
                            String optString2 = optJSONArray.optJSONObject(i3).optString("key");
                            if (!TextUtils.isEmpty(optString2)) {
                                scene.O00000Oo = optString2;
                                if (!this.O00000oO.containsKey(optString2)) {
                                    this.O00000oO.put(optString2, new ArrayList());
                                }
                                this.O00000oO.get(optString2).add(scene);
                            }
                        }
                    }
                }
            }
        }
    }
}
