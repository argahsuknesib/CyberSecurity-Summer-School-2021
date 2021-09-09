package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import com.facebook.internal.FetchedAppSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FetchedAppSettingsManager {
    private static final String[] APP_SETTING_FIELDS = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting"};
    public static final String TAG = "FetchedAppSettingsManager";
    public static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    private static boolean isUnityInit = false;
    public static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    public static boolean printedSDKUpdatedMessage = false;
    private static JSONArray unityEventBindings = null;

    enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    public static void loadAppSettingsAsync() {
        final Context applicationContext = FacebookSdk.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            pollCallbacks();
        } else if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            pollCallbacks();
        } else {
            if (!(loadingState.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || loadingState.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING))) {
                pollCallbacks();
                return;
            }
            final String format = String.format("com.facebook.internal.APP_SETTINGS.%s", applicationId);
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.internal.FetchedAppSettingsManager.AnonymousClass1 */

                public final void run() {
                    JSONObject jSONObject;
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                    FetchedAppSettings fetchedAppSettings = null;
                    String string = sharedPreferences.getString(format, null);
                    if (!Utility.isNullOrEmpty(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (JSONException e) {
                            Utility.logd("FacebookSDK", e);
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            fetchedAppSettings = FetchedAppSettingsManager.parseAppSettingsFromJSON(applicationId, jSONObject);
                        }
                    }
                    JSONObject appSettingsQueryResponse = FetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
                    if (appSettingsQueryResponse != null) {
                        FetchedAppSettingsManager.parseAppSettingsFromJSON(applicationId, appSettingsQueryResponse);
                        sharedPreferences.edit().putString(format, appSettingsQueryResponse.toString()).apply();
                    }
                    if (fetchedAppSettings != null) {
                        String sdkUpdateMessage = fetchedAppSettings.getSdkUpdateMessage();
                        if (!FetchedAppSettingsManager.printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                            FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                            Log.w(FetchedAppSettingsManager.TAG, sdkUpdateMessage);
                        }
                    }
                    FetchedAppGateKeepersManager.queryAppGateKeepers(applicationId, true);
                    AutomaticAnalyticsLogger.logActivateAppEvent();
                    InAppPurchaseActivityLifecycleTracker.update();
                    FetchedAppSettingsManager.loadingState.set(FetchedAppSettingsManager.fetchedAppSettings.containsKey(applicationId) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
                    FetchedAppSettingsManager.pollCallbacks();
                }
            });
        }
    }

    public static FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    public static void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        fetchedAppSettingsCallbacks.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        return;
     */
    public static synchronized void pollCallbacks() {
        synchronized (FetchedAppSettingsManager.class) {
            FetchAppSettingState fetchAppSettingState = loadingState.get();
            if (!FetchAppSettingState.NOT_LOADED.equals(fetchAppSettingState)) {
                if (!FetchAppSettingState.LOADING.equals(fetchAppSettingState)) {
                    final FetchedAppSettings fetchedAppSettings2 = fetchedAppSettings.get(FacebookSdk.getApplicationId());
                    Handler handler = new Handler(Looper.getMainLooper());
                    if (FetchAppSettingState.ERROR.equals(fetchAppSettingState)) {
                        while (!fetchedAppSettingsCallbacks.isEmpty()) {
                            final FetchedAppSettingsCallback poll = fetchedAppSettingsCallbacks.poll();
                            handler.post(new Runnable() {
                                /* class com.facebook.internal.FetchedAppSettingsManager.AnonymousClass2 */

                                public final void run() {
                                    poll.onError();
                                }
                            });
                        }
                        return;
                    }
                    while (!fetchedAppSettingsCallbacks.isEmpty()) {
                        final FetchedAppSettingsCallback poll2 = fetchedAppSettingsCallbacks.poll();
                        handler.post(new Runnable() {
                            /* class com.facebook.internal.FetchedAppSettingsManager.AnonymousClass3 */

                            public final void run() {
                                poll2.onSuccess(fetchedAppSettings2);
                            }
                        });
                    }
                }
            }
        }
    }

    public static FetchedAppSettings queryAppSettings(String str, boolean z) {
        if (!z && fetchedAppSettings.containsKey(str)) {
            return fetchedAppSettings.get(str);
        }
        JSONObject appSettingsQueryResponse = getAppSettingsQueryResponse(str);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON = parseAppSettingsFromJSON(str, appSettingsQueryResponse);
        if (str.equals(FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            pollCallbacks();
        }
        return parseAppSettingsFromJSON;
    }

    public static FetchedAppSettings parseAppSettingsFromJSON(String str, JSONObject jSONObject) {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        JSONObject jSONObject2 = jSONObject;
        JSONArray optJSONArray = jSONObject2.optJSONArray("android_sdk_error_categories");
        if (optJSONArray == null) {
            facebookRequestErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
        } else {
            facebookRequestErrorClassification = FacebookRequestErrorClassification.createFromJSON(optJSONArray);
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification2 = facebookRequestErrorClassification;
        int optInt = jSONObject2.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("auto_event_mapping_android");
        unityEventBindings = optJSONArray2;
        if (optJSONArray2 != null && InternalSettings.isUnityApp()) {
            UnityReflection.sendEventMapping(optJSONArray2.toString());
        }
        FetchedAppSettings fetchedAppSettings2 = r2;
        FetchedAppSettings fetchedAppSettings3 = new FetchedAppSettings(jSONObject2.optBoolean("supports_implicit_sdk_logging", false), jSONObject2.optString("gdpv4_nux_content", ""), jSONObject2.optBoolean("gdpv4_nux_enabled", false), jSONObject2.optInt("app_events_session_timeout", Constants.getDefaultAppEventsSessionTimeoutInSeconds()), SmartLoginOption.parseOptions(jSONObject2.optLong("seamless_login")), parseDialogConfigurations(jSONObject2.optJSONObject("android_dialog_configs")), z, facebookRequestErrorClassification2, jSONObject2.optString("smart_login_bookmark_icon_url"), jSONObject2.optString("smart_login_menu_icon_url"), z2, z3, optJSONArray2, jSONObject2.optString("sdk_update_message"), z4, jSONObject2.optString("aam_rules"), jSONObject2.optString("suggested_events_setting"), jSONObject2.optString("restrictive_data_filter_params"));
        FetchedAppSettings fetchedAppSettings4 = fetchedAppSettings2;
        fetchedAppSettings.put(str, fetchedAppSettings4);
        return fetchedAppSettings4;
    }

    public static void setIsUnityInit(boolean z) {
        isUnityInit = z;
        JSONArray jSONArray = unityEventBindings;
        if (jSONArray != null && isUnityInit) {
            UnityReflection.sendEventMapping(jSONArray.toString());
        }
    }

    public static JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(APP_SETTING_FIELDS))));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, str, null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest.executeAndWait().getJSONObject();
    }

    private static Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                FetchedAppSettings.DialogFeatureConfig parseDialogConfig = FetchedAppSettings.DialogFeatureConfig.parseDialogConfig(optJSONArray.optJSONObject(i));
                if (parseDialogConfig != null) {
                    String dialogName = parseDialogConfig.getDialogName();
                    Map map = (Map) hashMap.get(dialogName);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(dialogName, map);
                    }
                    map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                }
            }
        }
        return hashMap;
    }
}
