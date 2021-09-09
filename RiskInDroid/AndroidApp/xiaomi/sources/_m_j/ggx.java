package _m_j;

import _m_j.ggb;
import _m_j.gsj;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ggx {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, O000000o> f17758O000000o = new HashMap();
    public JSONArray O00000Oo;

    public interface O000000o {
        void onRecommendName(String str, List<String> list);
    }

    public ggx() {
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.ggx.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:40:0x0083 A[SYNTHETIC, Splitter:B:40:0x0083] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x00d2 A[SYNTHETIC, Splitter:B:48:0x00d2] */
            public final void run() {
                InputStream inputStream;
                Exception e;
                ggx ggx = ggx.this;
                SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("recommend_device_name_config", 0);
                try {
                    String string = sharedPreferences.getString("pref_recommend_config_names", "");
                    if (TextUtils.isEmpty(string)) {
                        InputStream open = CommonApplication.getAppContext().getAssets().open("cardControl/recommend_deivce_name.json");
                        try {
                            byte[] bArr = new byte[open.available()];
                            open.read(bArr);
                            String str = new String(bArr, "utf8");
                            inputStream = open;
                            string = str;
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = open;
                            try {
                                e.printStackTrace();
                                if (inputStream != null) {
                                }
                                String str2 = hsk.O000000o(CommonApplication.getAppContext(), "home.mi.com", "st.iot.home.mi.com") + "/newoperation/recommendNames";
                                gsy.O00000Oo("RecommendDeviceNameApi", "request ".concat(String.valueOf(str2)));
                                gsj.O000000o o000000o = new gsj.O000000o();
                                o000000o.f18212O000000o = "GET";
                                gsg.O00000Oo(o000000o.O00000Oo(str2).O000000o(), new gsl(sharedPreferences) {
                                    /* class _m_j.ggx.AnonymousClass2 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ SharedPreferences f17760O000000o;

                                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                                    }

                                    public final void onSuccess(Object obj, Response response) {
                                    }

                                    public final void processFailure(Call call, IOException iOException) {
                                    }

                                    {
                                        this.f17760O000000o = r2;
                                    }

                                    public final void processResponse(Response response) {
                                        String str;
                                        try {
                                            str = response.body().string();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                            str = null;
                                        }
                                        ggx.this.O000000o(str);
                                        ggx.this.f17758O000000o.clear();
                                        if (ggx.this.O00000Oo != null) {
                                            gsy.O00000Oo("RecommendDeviceNameApi", "processResponse");
                                            this.f17760O000000o.edit().putString("pref_recommend_config_names", str).apply();
                                            return;
                                        }
                                        gsy.O00000Oo("RecommendDeviceNameApi", "processResponse error");
                                    }
                                });
                            } catch (Throwable th) {
                                th = th;
                                if (inputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = open;
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    } else {
                        inputStream = null;
                    }
                    try {
                        if (!ggx.O000000o(string) || ggx.O00000Oo == null || ggx.O00000Oo.length() == 0) {
                            ggx.O00000Oo = null;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            String str22 = hsk.O000000o(CommonApplication.getAppContext(), "home.mi.com", "st.iot.home.mi.com") + "/newoperation/recommendNames";
                            gsy.O00000Oo("RecommendDeviceNameApi", "request ".concat(String.valueOf(str22)));
                            gsj.O000000o o000000o2 = new gsj.O000000o();
                            o000000o2.f18212O000000o = "GET";
                            gsg.O00000Oo(o000000o2.O00000Oo(str22).O000000o(), new gsl(sharedPreferences) {
                                /* class _m_j.ggx.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ SharedPreferences f17760O000000o;

                                public final void onFailure(gsf gsf, Exception exc, Response response) {
                                }

                                public final void onSuccess(Object obj, Response response) {
                                }

                                public final void processFailure(Call call, IOException iOException) {
                                }

                                {
                                    this.f17760O000000o = r2;
                                }

                                public final void processResponse(Response response) {
                                    String str;
                                    try {
                                        str = response.body().string();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        str = null;
                                    }
                                    ggx.this.O000000o(str);
                                    ggx.this.f17758O000000o.clear();
                                    if (ggx.this.O00000Oo != null) {
                                        gsy.O00000Oo("RecommendDeviceNameApi", "processResponse");
                                        this.f17760O000000o.edit().putString("pref_recommend_config_names", str).apply();
                                        return;
                                    }
                                    gsy.O00000Oo("RecommendDeviceNameApi", "processResponse error");
                                }
                            });
                        }
                        gsy.O00000Oo("RecommendDeviceNameApi", "use cache");
                        ggx.f17758O000000o.clear();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        if (inputStream != null) {
                        }
                        String str222 = hsk.O000000o(CommonApplication.getAppContext(), "home.mi.com", "st.iot.home.mi.com") + "/newoperation/recommendNames";
                        gsy.O00000Oo("RecommendDeviceNameApi", "request ".concat(String.valueOf(str222)));
                        gsj.O000000o o000000o22 = new gsj.O000000o();
                        o000000o22.f18212O000000o = "GET";
                        gsg.O00000Oo(o000000o22.O00000Oo(str222).O000000o(), new gsl(sharedPreferences) {
                            /* class _m_j.ggx.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ SharedPreferences f17760O000000o;

                            public final void onFailure(gsf gsf, Exception exc, Response response) {
                            }

                            public final void onSuccess(Object obj, Response response) {
                            }

                            public final void processFailure(Call call, IOException iOException) {
                            }

                            {
                                this.f17760O000000o = r2;
                            }

                            public final void processResponse(Response response) {
                                String str;
                                try {
                                    str = response.body().string();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    str = null;
                                }
                                ggx.this.O000000o(str);
                                ggx.this.f17758O000000o.clear();
                                if (ggx.this.O00000Oo != null) {
                                    gsy.O00000Oo("RecommendDeviceNameApi", "processResponse");
                                    this.f17760O000000o.edit().putString("pref_recommend_config_names", str).apply();
                                    return;
                                }
                                gsy.O00000Oo("RecommendDeviceNameApi", "processResponse error");
                            }
                        });
                    }
                } catch (Exception e6) {
                    inputStream = null;
                    e = e6;
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    String str2222 = hsk.O000000o(CommonApplication.getAppContext(), "home.mi.com", "st.iot.home.mi.com") + "/newoperation/recommendNames";
                    gsy.O00000Oo("RecommendDeviceNameApi", "request ".concat(String.valueOf(str2222)));
                    gsj.O000000o o000000o222 = new gsj.O000000o();
                    o000000o222.f18212O000000o = "GET";
                    gsg.O00000Oo(o000000o222.O00000Oo(str2222).O000000o(), new gsl(sharedPreferences) {
                        /* class _m_j.ggx.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ SharedPreferences f17760O000000o;

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                        }

                        public final void onSuccess(Object obj, Response response) {
                        }

                        public final void processFailure(Call call, IOException iOException) {
                        }

                        {
                            this.f17760O000000o = r2;
                        }

                        public final void processResponse(Response response) {
                            String str;
                            try {
                                str = response.body().string();
                            } catch (IOException e) {
                                e.printStackTrace();
                                str = null;
                            }
                            ggx.this.O000000o(str);
                            ggx.this.f17758O000000o.clear();
                            if (ggx.this.O00000Oo != null) {
                                gsy.O00000Oo("RecommendDeviceNameApi", "processResponse");
                                this.f17760O000000o.edit().putString("pref_recommend_config_names", str).apply();
                                return;
                            }
                            gsy.O00000Oo("RecommendDeviceNameApi", "processResponse error");
                        }
                    });
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        });
    }

    public final void O000000o(String str, O000000o o000000o) {
        if (str == null) {
            return;
        }
        if (this.O00000Oo == null) {
            this.f17758O000000o.put(str, o000000o);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, o000000o);
        O000000o(hashMap);
    }

    public final boolean O000000o(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            this.O00000Oo = optJSONObject.optJSONArray("product_type");
            O000000o(this.f17758O000000o);
            if (optJSONObject.optLong("expireTs") > System.currentTimeMillis()) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            gsy.O000000o(6, "RecommendDeviceNameApi", "parseResult:".concat(String.valueOf(str)));
            return false;
        }
    }

    private void O000000o(Map<String, O000000o> map) {
        if (this.O00000Oo != null) {
            int i = 0;
            while (i < this.O00000Oo.length()) {
                try {
                    JSONObject optJSONObject = this.O00000Oo.optJSONObject(i);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("model");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        for (Map.Entry next : map.entrySet()) {
                            if (((String) next.getKey()).equals(optJSONArray.optString(i2))) {
                                O000000o(optJSONObject, (O000000o) next.getValue());
                                return;
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void O000000o(JSONObject jSONObject, final O000000o o000000o) {
        if (jSONObject != null) {
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                O00oOooo = Locale.getDefault();
            }
            final String str = "";
            JSONArray jSONArray = null;
            JSONObject optJSONObject = jSONObject.optJSONObject("defaultName");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("recommend");
            try {
                if (gwc.O000000o(O00oOooo, Locale.CHINA)) {
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("zh_CN");
                    }
                    if (optJSONObject2 != null) {
                        jSONArray = optJSONObject2.optJSONArray("zh_CN");
                    }
                } else if (gwc.O000000o(O00oOooo, Locale.TRADITIONAL_CHINESE)) {
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("zh_TW");
                    }
                    if (optJSONObject2 != null) {
                        jSONArray = optJSONObject2.optJSONArray("zh_TW");
                    }
                } else if (gwc.O000000o(O00oOooo, gwc.f18401O000000o)) {
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("zh_HK");
                    }
                    if (optJSONObject2 != null) {
                        jSONArray = optJSONObject2.optJSONArray("zh_HK");
                    }
                } else {
                    String language = O00oOooo.getLanguage();
                    if (gwc.O000000o(O00oOooo, new Locale("in", "ID"))) {
                        language = "id";
                    }
                    if (optJSONObject != null) {
                        str = optJSONObject.optString(language);
                    }
                    if (optJSONObject2 != null) {
                        jSONArray = optJSONObject2.optJSONArray(language);
                    }
                }
                final ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                }
                CommonApplication.getGlobalHandler().post(new Runnable() {
                    /* class _m_j.ggx.AnonymousClass3 */

                    public final void run() {
                        o000000o.onRecommendName(str, arrayList);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d A[LOOP:0: B:4:0x000c->B:18:0x004d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[SYNTHETIC] */
    public static String O000000o(Device device, String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        int i = 2;
        while (true) {
            if (!TextUtils.isEmpty(str2)) {
                Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Device device2 = (Device) it.next().getValue();
                    if ((device == null || !TextUtils.equals(device.did, device2.did)) && str2.equals(device2.name)) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return str2;
                }
                str2 = str + i;
                i++;
            }
            z = false;
            if (z) {
            }
        }
    }

    public final void O000000o(Context context, final Device device, final String str, final Callback<String> callback) {
        List<Room> O000000o2 = ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo());
        ArrayList arrayList = new ArrayList();
        for (Room name : O000000o2) {
            arrayList.add(name.getName());
        }
        LogType logType = LogType.HOME_ROOM;
        gsy.O00000Oo(logType, "RecommendDeviceNameApi", "doSaveDeviceRoom  RoomName:" + str + " names:" + arrayList);
        if (arrayList.contains(str)) {
            O000000o(device, str, callback);
        } else if (TextUtils.isEmpty(str) || context.getString(R.string.room_default).equals(str)) {
            O000000o(device, callback);
        } else {
            LogType logType2 = LogType.HOME_ROOM;
            gsy.O00000Oo(logType2, "RecommendDeviceNameApi", "createRoom  did:" + device.did);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(device.did);
            ggb.O00000Oo().O000000o(str, arrayList2, (String) null, new ggb.O00000o() {
                /* class _m_j.ggx.AnonymousClass4 */

                public final void O000000o() {
                    ggx.this.O000000o(device, str, callback);
                }

                public final void O000000o(int i, fso fso) {
                    if (fso == null || fso.f17063O000000o != -35) {
                        gqg.O00000Oo((int) R.string.set_room_fail);
                        gsy.O00000Oo(LogType.HOME_ROOM, "RecommendDeviceNameApi", "error".concat(String.valueOf(fso)));
                        callback.onFailure(i, String.valueOf(fso));
                        return;
                    }
                    O000000o();
                }
            });
        }
    }

    public final void O000000o(Device device, String str, final Callback<String> callback) {
        Room room = null;
        for (Room next : ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000OOo())) {
            if (TextUtils.equals(next.getName(), str)) {
                room = next;
            }
        }
        gsy.O00000Oo(LogType.HOME_ROOM, "RecommendDeviceNameApi", "doSaveDeviceToRoom  room:".concat(String.valueOf(room)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(device.did);
        if (room == null || TextUtils.isEmpty(room.getId())) {
            O000000o(device, callback);
        } else {
            ggb.O00000Oo().O000000o(room, arrayList, (List<String>) null, new ggb.O00000o() {
                /* class _m_j.ggx.AnonymousClass5 */

                public final void O000000o() {
                    gsy.O00000Oo(LogType.HOME_ROOM, "RecommendDeviceNameApi", "doSaveDeviceToRoom.editRoom  onSuccess");
                    callback.onSuccess("");
                }

                public final void O000000o(int i, fso fso) {
                    gsy.O00000Oo(LogType.HOME_ROOM, "RecommendDeviceNameApi", "error".concat(String.valueOf(fso)));
                    gqg.O00000Oo((int) R.string.multikey_noroom_hint);
                    callback.onFailure(i, String.valueOf(fso));
                }
            });
        }
    }

    private void O000000o(Device device, final Callback<String> callback) {
        ggb.O00000Oo().O000000o(ggb.O00000Oo().O0000Oo0(), (Room) null, device, new ggb.O00000o() {
            /* class _m_j.ggx.AnonymousClass6 */

            public final void O000000o() {
                gsy.O00000Oo(LogType.HOME_ROOM, "RecommendDeviceNameApi", "doSaveDeviceToDefaultRoom  bindDeviceToRoom.onSuccess");
                callback.onSuccess("");
            }

            public final void O000000o(int i, fso fso) {
                gsy.O00000Oo(LogType.HOME_ROOM, "RecommendDeviceNameApi", "error".concat(String.valueOf(fso)));
                gqg.O00000Oo((int) R.string.tag_recommend_room);
                callback.onFailure(i, String.valueOf(fso));
            }
        });
    }
}
