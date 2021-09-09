package _m_j;

import _m_j.gsj;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.config.model.DeviceRoomConfig;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fbv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f16050O000000o = "fbv";
    private static volatile fbv O0000Oo;
    public List<fce> O00000Oo = new ArrayList();
    public boolean O00000o = false;
    public List<fcg> O00000o0 = new ArrayList();
    public boolean O00000oO = false;
    public int O00000oo;
    public AtomicBoolean O0000O0o = new AtomicBoolean(false);
    public long O0000OOo = 0;
    private DeviceRoomConfig O0000Oo0;

    private fbv() {
        AppConfigHelper.O000000o();
    }

    public static fbv O000000o() {
        if (O0000Oo == null) {
            synchronized (fbv.class) {
                if (O0000Oo == null) {
                    O0000Oo = new fbv();
                }
            }
        }
        return O0000Oo;
    }

    public final void O00000Oo() {
        if (Math.abs(System.currentTimeMillis() - this.O0000OOo) >= 5000 && !this.O0000O0o.getAndSet(true)) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", "zh_CN");
                StringBuilder sb = new StringBuilder("android_common_config");
                sb.append(gfr.O0000oo0 ? "_preview" : "");
                jSONObject.put("name", sb.toString());
                jSONObject.put("version", "1");
            } catch (Exception unused) {
                this.O0000O0o.set(false);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            gsj gsj = null;
            try {
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsj = o000000o.O00000Oo(hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).O000000o();
            } catch (UnsupportedEncodingException e) {
                this.O0000O0o.set(false);
                e.printStackTrace();
            }
            if (gsj == null) {
                this.O0000O0o.set(false);
            } else {
                gsg.O00000Oo(gsj, new gsl() {
                    /* class _m_j.fbv.AnonymousClass1 */

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                    }

                    public final void onSuccess(Object obj, Response response) {
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: org.json.JSONObject} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    public final void processResponse(Response response) {
                        try {
                            JSONObject jSONObject = new JSONObject(response.body().string());
                            if (jSONObject.isNull("result")) {
                                fbv.this.O0000O0o.set(false);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            LogType logType = LogType.NETWORK;
                            String str = fbv.f16050O000000o;
                            gsy.O000000o(logType, str, "getRemoteConfig  result" + optJSONObject.toString());
                            if (optJSONObject.isNull("content")) {
                                fbv.this.O0000O0o.set(false);
                                return;
                            }
                            JSONObject jSONObject2 = null;
                            Object obj = optJSONObject.get("content");
                            if (obj instanceof JSONObject) {
                                jSONObject2 = obj;
                            } else if (obj instanceof String) {
                                jSONObject2 = new JSONObject((String) obj);
                            }
                            fbv.this.O00000Oo(jSONObject2);
                            fbv.O000000o(jSONObject2);
                            fbv.this.O0000O0o.set(false);
                            fbv.this.O0000OOo = System.currentTimeMillis();
                        } catch (IOException e) {
                            fbv.this.O0000O0o.set(false);
                            e.printStackTrace();
                        } catch (JSONException e2) {
                            fbv.this.O0000O0o.set(false);
                            e2.printStackTrace();
                        } catch (Exception e3) {
                            fbv.this.O0000O0o.set(false);
                            e3.printStackTrace();
                        }
                    }

                    public final void processFailure(Call call, IOException iOException) {
                        fbv.this.O0000O0o.set(false);
                        fbv.this.O0000OOo = System.currentTimeMillis();
                        hsl.O00000Oo().addLocalDeny();
                        JSONObject O00000o0 = fbv.O00000o0();
                        if (O00000o0 != null) {
                            fbv.this.O00000Oo(O00000o0);
                            gsy.O00000o0(LogType.NETWORK, fbv.f16050O000000o, "getRemoteConfig fail, read from cache");
                        }
                    }
                });
            }
        }
    }

    public static void O000000o(JSONObject jSONObject) {
        try {
            SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("android_common_config", 0);
            ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
            StringBuilder sb = new StringBuilder("data_");
            sb.append(O000000o2 == null ? "" : O000000o2.f7546O000000o);
            gpv.O00000Oo(sharedPreferences, sb.toString(), jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject O00000o0() {
        try {
            SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("android_common_config", 0);
            ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
            StringBuilder sb = new StringBuilder("data_");
            sb.append(O000000o2 == null ? "" : O000000o2.f7546O000000o);
            String O000000o3 = gpv.O000000o(sharedPreferences, sb.toString(), (String) null);
            if (TextUtils.isEmpty(O000000o3)) {
                return null;
            }
            return new JSONObject(O000000o3);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O00000Oo(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (!jSONObject.isNull("lumi_device_support_local") && (optJSONArray = jSONObject.optJSONArray("lumi_device_support_local")) != null) {
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && !optJSONObject.isNull("model")) {
                        fce fce = new fce();
                        fce.f16078O000000o = optJSONObject.optString("model");
                        arrayList.add(fce);
                    }
                }
            }
            this.O00000Oo = arrayList;
        }
        if (!jSONObject.isNull("support_ble_gatway_firmware_version_config")) {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("support_ble_gatway_firmware_version_config");
            if (optJSONArray2 != null) {
                this.O00000o0 = fcg.O000000o(optJSONArray2);
            } else {
                this.O00000o0 = new ArrayList();
            }
        } else {
            this.O00000o0 = new ArrayList();
        }
        if (!jSONObject.isNull("android_mini_program_switch")) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("android_mini_program_switch");
            if (optJSONObject2 != null) {
                this.O00000o = optJSONObject2.optBoolean("status");
            } else {
                this.O00000o = false;
            }
        } else {
            this.O00000o = false;
        }
        if (!jSONObject.isNull("main_device_room_tab_config")) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("main_device_room_tab_config");
            if (optJSONObject3 != null) {
                this.O0000Oo0 = new DeviceRoomConfig(optJSONObject3.optInt("click_icon_op", 2), optJSONObject3.optInt("icon_cnt", 3));
            } else {
                this.O0000Oo0 = new DeviceRoomConfig(2, 3);
            }
        } else {
            this.O0000Oo0 = new DeviceRoomConfig(2, 3);
        }
        boolean z = true;
        if (jSONObject.optInt("enable_scene_operation", 0) != 1) {
            z = false;
        }
        this.O00000oO = z;
        if (jSONObject.has("voice_device_auth_mask_models")) {
            JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_device_auth_mask_models");
            for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                hsl.O00000Oo().addDenyModels(optJSONArray3.optString(i2));
            }
        }
        this.O00000oo = jSONObject.optInt("family_add_device_redpoint_count", 2);
    }
}
