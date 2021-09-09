package com.xiaomi.smarthome.frame;

import _m_j.dgm;
import _m_j.fdc;
import _m_j.ft;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class CoreContentProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f7428O000000o = "CoreContentProvider";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        if (TextUtils.equals("isUsrExpPlanEnabled", str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("enabled", O000000o.O000000o(getContext()));
            return bundle2;
        } else if (TextUtils.equals("setUsrExpPlanEnabled", str)) {
            if (bundle == null) {
                return null;
            }
            boolean z = bundle.getBoolean("enabled", true);
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("enabled", O000000o.O000000o(getContext(), z));
            return bundle3;
        } else if (TextUtils.equals("isDeviceUsrExpPlanEnabled", str)) {
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("device_id", "");
            Bundle bundle4 = new Bundle();
            bundle4.putBoolean("enabled", O000000o.O000000o(getContext(), string));
            return bundle4;
        } else if (!TextUtils.equals("setDeviceUsrExpPlanEnabled", str) || bundle == null) {
            return null;
        } else {
            boolean z2 = bundle.getBoolean("enabled", true);
            O000000o.O000000o(getContext(), bundle.getString("device_id", ""), z2);
            return null;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static volatile int f7429O000000o = -1;
        private static Map<String, Boolean> O00000Oo = new ConcurrentHashMap();

        public static boolean O000000o(Context context) {
            if (f7429O000000o == -1) {
                f7429O000000o = context.getSharedPreferences("usr_exp_plan", 0).getInt("enabled", 0);
            }
            if (f7429O000000o == 1) {
                return true;
            }
            return false;
        }

        public static boolean O000000o(Context context, String str) {
            Boolean bool;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            O00000Oo(context);
            Map<String, Boolean> map = O00000Oo;
            if (map.containsKey(str) && (bool = map.get(str)) != null && (bool instanceof Boolean)) {
                return bool.booleanValue();
            }
            return true;
        }

        public static void O000000o(Context context, String str, boolean z) {
            String str2;
            if (!TextUtils.isEmpty(str)) {
                O00000Oo(context);
                Map<String, Boolean> map = O00000Oo;
                map.put(str, Boolean.valueOf(z));
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    if (map != null) {
                        if (!map.isEmpty()) {
                            for (Map.Entry next : map.entrySet()) {
                                if (!(next == null || next.getValue() == null)) {
                                    String str3 = (String) next.getKey();
                                    if (!TextUtils.isEmpty(str3)) {
                                        jSONObject2.put(str3, next.getValue());
                                    }
                                }
                            }
                            jSONObject.put("data", jSONObject2);
                        }
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("usr_exp_plan", 0);
                    ServerBean O0000o0O = fdc.O000000o().O0000o0O();
                    if (O0000o0O == null) {
                        str2 = "";
                    } else {
                        str2 = O0000o0O.f7546O000000o;
                    }
                    sharedPreferences.edit().putString("device_uep_".concat(String.valueOf(str2)), jSONObject.toString()).apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private static void O00000Oo(Context context) {
            JSONObject optJSONObject;
            if (O00000Oo.isEmpty()) {
                String O000000o2 = C0071O000000o.O000000o(context);
                if (!TextUtils.isEmpty(O000000o2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(O000000o2);
                        if (!jSONObject.isNull("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                if (!TextUtils.isEmpty(next)) {
                                    concurrentHashMap.put(next, Boolean.valueOf(optJSONObject.optBoolean(next, true)));
                                } else {
                                    return;
                                }
                            }
                            O00000Oo = concurrentHashMap;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* renamed from: com.xiaomi.smarthome.frame.CoreContentProvider$O000000o$O000000o  reason: collision with other inner class name */
        static class C0071O000000o {
            public static String O000000o(Context context) {
                String str;
                SharedPreferences sharedPreferences = context.getSharedPreferences("usr_exp_plan", 0);
                ServerBean O0000o0O = fdc.O000000o().O0000o0O();
                if (O0000o0O == null) {
                    str = "";
                } else {
                    str = O0000o0O.f7546O000000o;
                }
                String string = sharedPreferences.getString("device_uep_".concat(String.valueOf(str)), "");
                return TextUtils.isEmpty(string) ? sharedPreferences.getString("device_uep", "") : string;
            }
        }

        public static boolean O000000o(Context context, boolean z) {
            boolean z2;
            if (f7429O000000o != z) {
                context.getSharedPreferences("usr_exp_plan", 0).edit().putInt("enabled", z ? 1 : 0).apply();
                f7429O000000o = z;
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
            Intent intent = new Intent("com.xiaomi.smarthome.usr_exp_plan_change");
            intent.putExtra("usr_exp_plan_value", f7429O000000o);
            ft.O000000o(context).O000000o(intent);
            if (f7429O000000o == 0) {
                dgm.f14605O000000o = false;
            } else {
                dgm.f14605O000000o = true;
            }
            return true;
        }
    }
}
