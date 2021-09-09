package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FetchedAppGateKeepersManager {
    private static final String TAG = "com.facebook.internal.FetchedAppGateKeepersManager";
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();
    public static final AtomicBoolean isLoading = new AtomicBoolean(false);
    public static Long timestamp;

    public interface Callback {
        void onCompleted();
    }

    static void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    static synchronized void loadAppGateKeepersAsync(Callback callback) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (callback != null) {
                callbacks.add(callback);
            }
            if (isTimestampValid(timestamp)) {
                pollCallbacks();
                return;
            }
            final Context applicationContext = FacebookSdk.getApplicationContext();
            final String applicationId = FacebookSdk.getApplicationId();
            final String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", applicationId);
            if (applicationContext != null) {
                JSONObject jSONObject = null;
                String string = applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(format, null);
                if (!Utility.isNullOrEmpty(string)) {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException e) {
                        Utility.logd("FacebookSDK", e);
                    }
                    if (jSONObject != null) {
                        parseAppGateKeepersFromJSON(applicationId, jSONObject);
                    }
                }
                Executor executor = FacebookSdk.getExecutor();
                if (executor != null) {
                    if (isLoading.compareAndSet(false, true)) {
                        executor.execute(new Runnable() {
                            /* class com.facebook.internal.FetchedAppGateKeepersManager.AnonymousClass1 */

                            public final void run() {
                                JSONObject appGateKeepersQueryResponse = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
                                if (appGateKeepersQueryResponse != null) {
                                    FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, appGateKeepersQueryResponse);
                                    applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(format, appGateKeepersQueryResponse.toString()).apply();
                                    FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                                }
                                FetchedAppGateKeepersManager.pollCallbacks();
                                FetchedAppGateKeepersManager.isLoading.set(false);
                            }
                        });
                    }
                }
            }
        }
    }

    public static void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!callbacks.isEmpty()) {
            final Callback poll = callbacks.poll();
            if (poll != null) {
                handler.post(new Runnable() {
                    /* class com.facebook.internal.FetchedAppGateKeepersManager.AnonymousClass2 */

                    public final void run() {
                        poll.onCompleted();
                    }
                });
            }
        }
    }

    static JSONObject queryAppGateKeepers(String str, boolean z) {
        if (!z && fetchedAppGateKeepers.containsKey(str)) {
            return fetchedAppGateKeepers.get(str);
        }
        JSONObject appGateKeepersQueryResponse = getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse == null) {
            return null;
        }
        Context applicationContext = FacebookSdk.getApplicationContext();
        applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", str), appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON(str, appGateKeepersQueryResponse);
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        loadAppGateKeepersAsync();
        return (str2 == null || !fetchedAppGateKeepers.containsKey(str2)) ? z : fetchedAppGateKeepers.get(str2).optBoolean(str, z);
    }

    public static JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        bundle.putString("sdk_version", FacebookSdk.getSdkVersion());
        bundle.putString("fields", "gatekeepers");
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", str, "mobile_sdk_gk"), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    public static synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            if (fetchedAppGateKeepers.containsKey(str)) {
                jSONObject2 = fetchedAppGateKeepers.get(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject jSONObject3 = null;
            if (optJSONArray != null) {
                jSONObject3 = optJSONArray.optJSONObject(0);
            }
            if (!(jSONObject3 == null || jSONObject3.optJSONArray("gatekeepers") == null)) {
                JSONArray optJSONArray2 = jSONObject3.optJSONArray("gatekeepers");
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean("value"));
                    } catch (JSONException e) {
                        Utility.logd("FacebookSDK", e);
                    }
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private static boolean isTimestampValid(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < 3600000;
    }
}
