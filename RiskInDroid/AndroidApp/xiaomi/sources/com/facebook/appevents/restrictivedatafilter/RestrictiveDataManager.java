package com.facebook.appevents.restrictivedatafilter;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class RestrictiveDataManager {
    private static final String TAG = "com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager";
    private static boolean enabled = false;
    private static Set<String> restrictiveEvents = new HashSet();
    private static List<RestrictiveParam> restrictiveParams = new ArrayList();

    public static synchronized void enable() {
        synchronized (RestrictiveDataManager.class) {
            enabled = true;
            initialize();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0088, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private static synchronized void initialize() {
        synchronized (RestrictiveDataManager.class) {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings != null) {
                String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
                if (restrictiveDataSetting != null) {
                    if (!restrictiveDataSetting.isEmpty()) {
                        JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                        restrictiveParams.clear();
                        restrictiveEvents.clear();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            if (jSONObject2 != null) {
                                if (jSONObject2.optBoolean("is_deprecated_event")) {
                                    restrictiveEvents.add(next);
                                } else {
                                    JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                                    JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                                    RestrictiveParam restrictiveParam = new RestrictiveParam(next, new HashMap(), new ArrayList());
                                    if (optJSONObject != null) {
                                        restrictiveParam.restrictiveParams = Utility.convertJSONObjectToStringMap(optJSONObject);
                                    }
                                    if (optJSONArray != null) {
                                        restrictiveParam.deprecatedParams = Utility.convertJSONArrayToList(optJSONArray);
                                    }
                                    restrictiveParams.add(restrictiveParam);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void processEvents(List<AppEvent> list) {
        if (enabled) {
            Iterator<AppEvent> it = list.iterator();
            while (it.hasNext()) {
                if (isDeprecatedEvent(it.next().getName())) {
                    it.remove();
                }
            }
        }
    }

    public static void processParameters(Map<String, String> map, String str) {
        if (enabled) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList(map.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String matchedRuleType = getMatchedRuleType(str, str2);
                if (matchedRuleType != null) {
                    hashMap.put(str2, matchedRuleType);
                    map.remove(str2);
                }
            }
            for (RestrictiveParam next : restrictiveParams) {
                if (next.eventName.equals(str)) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        String str3 = (String) it2.next();
                        if (next.deprecatedParams.contains(str3)) {
                            map.remove(str3);
                        }
                    }
                }
            }
            if (hashMap.size() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    map.put("_restrictedParams", jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }

    private static boolean isDeprecatedEvent(String str) {
        return restrictiveEvents.contains(str);
    }

    private static String getMatchedRuleType(String str, String str2) {
        try {
            Iterator it = new ArrayList(restrictiveParams).iterator();
            while (it.hasNext()) {
                RestrictiveParam restrictiveParam = (RestrictiveParam) it.next();
                if (restrictiveParam != null && str.equals(restrictiveParam.eventName)) {
                    for (String next : restrictiveParam.restrictiveParams.keySet()) {
                        if (str2.equals(next)) {
                            return restrictiveParam.restrictiveParams.get(next);
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            Log.w(TAG, "getMatchedRuleType failed", e);
            return null;
        }
    }

    static class RestrictiveParam {
        List<String> deprecatedParams;
        String eventName;
        Map<String, String> restrictiveParams;

        RestrictiveParam(String str, Map<String, String> map, List<String> list) {
            this.eventName = str;
            this.restrictiveParams = map;
            this.deprecatedParams = list;
        }
    }
}
