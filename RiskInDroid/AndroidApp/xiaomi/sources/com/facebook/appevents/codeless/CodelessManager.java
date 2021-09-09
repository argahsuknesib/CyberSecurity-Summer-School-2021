package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CodelessManager {
    public static String deviceSessionID;
    public static Boolean isAppIndexingEnabled = Boolean.FALSE;
    public static volatile Boolean isCheckingSession = Boolean.FALSE;
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    private static SensorManager sensorManager;
    public static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    public static void onActivityResumed(Activity activity) {
        if (isCodelessEnabled.get()) {
            CodelessMatcher.getInstance().add(activity);
            Context applicationContext = activity.getApplicationContext();
            final String applicationId = FacebookSdk.getApplicationId();
            final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
                sensorManager = sensorManager2;
                if (sensorManager2 != null) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                    viewIndexer = new ViewIndexer(activity);
                    viewIndexingTrigger.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener() {
                        /* class com.facebook.appevents.codeless.CodelessManager.AnonymousClass1 */

                        public final void onShake() {
                            FetchedAppSettings fetchedAppSettings = appSettingsWithoutQuery;
                            boolean z = fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled();
                            boolean codelessSetupEnabled = FacebookSdk.getCodelessSetupEnabled();
                            if (z && codelessSetupEnabled) {
                                CodelessManager.checkCodelessSession(applicationId);
                            }
                        }
                    });
                    sensorManager.registerListener(viewIndexingTrigger, defaultSensor, 2);
                    if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        viewIndexer.schedule();
                    }
                }
            }
        }
    }

    public static void onActivityPaused(Activity activity) {
        if (isCodelessEnabled.get()) {
            CodelessMatcher.getInstance().remove(activity);
            ViewIndexer viewIndexer2 = viewIndexer;
            if (viewIndexer2 != null) {
                viewIndexer2.unschedule();
            }
            SensorManager sensorManager2 = sensorManager;
            if (sensorManager2 != null) {
                sensorManager2.unregisterListener(viewIndexingTrigger);
            }
        }
    }

    public static void onActivityDestroyed(Activity activity) {
        CodelessMatcher.getInstance().destroy(activity);
    }

    public static void enable() {
        isCodelessEnabled.set(true);
    }

    public static void disable() {
        isCodelessEnabled.set(false);
    }

    public static void checkCodelessSession(final String str) {
        if (!isCheckingSession.booleanValue()) {
            isCheckingSession = Boolean.TRUE;
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.appevents.codeless.CodelessManager.AnonymousClass2 */

                public final void run() {
                    boolean z = true;
                    GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", str), null, null);
                    Bundle parameters = newPostRequest.getParameters();
                    if (parameters == null) {
                        parameters = new Bundle();
                    }
                    AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                    if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
                        jSONArray.put("");
                    } else {
                        jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                    }
                    String str = "0";
                    jSONArray.put(str);
                    if (AppEventUtility.isEmulator()) {
                        str = "1";
                    }
                    jSONArray.put(str);
                    Locale currentLocale = Utility.getCurrentLocale();
                    jSONArray.put(currentLocale.getLanguage() + "_" + currentLocale.getCountry());
                    String jSONArray2 = jSONArray.toString();
                    parameters.putString("device_session_id", CodelessManager.getCurrentDeviceSessionID());
                    parameters.putString("extinfo", jSONArray2);
                    newPostRequest.setParameters(parameters);
                    JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
                    if (jSONObject == null || !jSONObject.optBoolean("is_app_indexing_enabled", false)) {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    CodelessManager.isAppIndexingEnabled = valueOf;
                    if (!valueOf.booleanValue()) {
                        CodelessManager.deviceSessionID = null;
                    } else if (CodelessManager.viewIndexer != null) {
                        CodelessManager.viewIndexer.schedule();
                    }
                    CodelessManager.isCheckingSession = Boolean.FALSE;
                }
            });
        }
    }

    static String getCurrentDeviceSessionID() {
        if (deviceSessionID == null) {
            deviceSessionID = UUID.randomUUID().toString();
        }
        return deviceSessionID;
    }

    static boolean getIsAppIndexingEnabled() {
        return isAppIndexingEnabled.booleanValue();
    }

    static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
