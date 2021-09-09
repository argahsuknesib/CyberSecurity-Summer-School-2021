package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class UserSettingsManager {
    private static final String TAG = "com.facebook.UserSettingsManager";
    public static UserSetting advertiserIDCollectionEnabled = new UserSetting(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
    private static UserSetting autoInitEnabled = new UserSetting(true, "com.facebook.sdk.AutoInitEnabled");
    private static UserSetting autoLogAppEventsEnabled = new UserSetting(true, "com.facebook.sdk.AutoLogAppEventsEnabled");
    public static UserSetting codelessSetupEnabled = new UserSetting(false, "auto_event_setup_enabled");
    public static AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static SharedPreferences userSettingPref;

    UserSettingsManager() {
    }

    public static void initializeIfNotInitialized() {
        if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
            userSettingPref = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
            initializeUserSetting(autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled);
            initializeCodelessSetupEnabledAsync();
            logWarnings();
            logIfSDKSettingsChanged();
            logIfAutoAppLinkEnabled();
        }
    }

    private static void initializeUserSetting(UserSetting... userSettingArr) {
        for (UserSetting userSetting : userSettingArr) {
            if (userSetting == codelessSetupEnabled) {
                initializeCodelessSetupEnabledAsync();
            } else if (userSetting.value == null) {
                readSettingFromCache(userSetting);
                if (userSetting.value == null) {
                    loadSettingFromManifest(userSetting);
                }
            } else {
                writeSettingToCache(userSetting);
            }
        }
    }

    private static void initializeCodelessSetupEnabledAsync() {
        readSettingFromCache(codelessSetupEnabled);
        final long currentTimeMillis = System.currentTimeMillis();
        if (codelessSetupEnabled.value == null || currentTimeMillis - codelessSetupEnabled.lastTS >= 604800000) {
            UserSetting userSetting = codelessSetupEnabled;
            userSetting.value = null;
            userSetting.lastTS = 0;
            if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new Runnable() {
                    /* class com.facebook.UserSettingsManager.AnonymousClass1 */

                    public final void run() {
                        FetchedAppSettings queryAppSettings;
                        if (UserSettingsManager.advertiserIDCollectionEnabled.getValue() && (queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false)) != null && queryAppSettings.getCodelessEventsEnabled()) {
                            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                            if (((attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId()) != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                                bundle.putString("fields", "auto_event_setup_enabled");
                                GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, FacebookSdk.getApplicationId(), null);
                                newGraphPathRequest.setSkipClientToken(true);
                                newGraphPathRequest.setParameters(bundle);
                                JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                                if (jSONObject != null) {
                                    UserSettingsManager.codelessSetupEnabled.value = Boolean.valueOf(jSONObject.optBoolean("auto_event_setup_enabled", false));
                                    UserSettingsManager.codelessSetupEnabled.lastTS = currentTimeMillis;
                                    UserSettingsManager.writeSettingToCache(UserSettingsManager.codelessSetupEnabled);
                                }
                            }
                        }
                        UserSettingsManager.isFetchingCodelessStatus.set(false);
                    }
                });
            }
        }
    }

    public static void writeSettingToCache(UserSetting userSetting) {
        validateInitialized();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", userSetting.value);
            jSONObject.put("last_timestamp", userSetting.lastTS);
            userSettingPref.edit().putString(userSetting.key, jSONObject.toString()).commit();
            logIfSDKSettingsChanged();
        } catch (Exception e) {
            Utility.logd(TAG, e);
        }
    }

    private static void readSettingFromCache(UserSetting userSetting) {
        validateInitialized();
        try {
            String string = userSettingPref.getString(userSetting.key, "");
            if (!string.isEmpty()) {
                JSONObject jSONObject = new JSONObject(string);
                userSetting.value = Boolean.valueOf(jSONObject.getBoolean("value"));
                userSetting.lastTS = jSONObject.getLong("last_timestamp");
            }
        } catch (JSONException e) {
            Utility.logd(TAG, e);
        }
    }

    private static void loadSettingFromManifest(UserSetting userSetting) {
        validateInitialized();
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(userSetting.key)) {
                userSetting.value = Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.key, userSetting.defaultVal));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Utility.logd(TAG, e);
        }
    }

    private static void logWarnings() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                    Log.w(TAG, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                    Log.w(TAG, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
                }
                if (!getAdvertiserIDCollectionEnabled()) {
                    Log.w(TAG, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static void logIfSDKSettingsChanged() {
        int i;
        if (isInitialized.get() && FacebookSdk.isInitialized()) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            int i2 = 0;
            int i3 = ((autoInitEnabled.getValue() ? 1 : 0) << false) | 0 | ((autoLogAppEventsEnabled.getValue() ? 1 : 0) << true) | ((advertiserIDCollectionEnabled.getValue() ? 1 : 0) << true);
            int i4 = userSettingPref.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
            if (i4 != i3) {
                userSettingPref.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i3).commit();
                try {
                    ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                        String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled"};
                        boolean[] zArr = {true, true, true};
                        int i5 = 0;
                        int i6 = 0;
                        i = 0;
                        while (i5 < 3) {
                            try {
                                i |= (applicationInfo.metaData.containsKey(strArr[i5]) ? 1 : 0) << i5;
                                i6 |= (applicationInfo.metaData.getBoolean(strArr[i5], zArr[i5]) ? 1 : 0) << i5;
                                i5++;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                        }
                        i2 = i6;
                        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                        Bundle bundle = new Bundle();
                        bundle.putInt("usage", i);
                        bundle.putInt("initial", i2);
                        bundle.putInt("previous", i4);
                        bundle.putInt("current", i3);
                        internalAppEventsLogger.logEventImplicitly("fb_sdk_settings_changed", bundle);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                i = 0;
                InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("usage", i);
                bundle2.putInt("initial", i2);
                bundle2.putInt("previous", i4);
                bundle2.putInt("current", i3);
                internalAppEventsLogger2.logEventImplicitly("fb_sdk_settings_changed", bundle2);
            }
        }
    }

    private static void logIfAutoAppLinkEnabled() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                Bundle bundle = new Bundle();
                if (!Utility.isAutoAppLinkSetup()) {
                    bundle.putString("SchemeWarning", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                    Log.w(TAG, "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                }
                internalAppEventsLogger.logEvent("fb_auto_applink", bundle);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static void validateInitialized() {
        if (!isInitialized.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    public static void setAutoInitEnabled(boolean z) {
        autoInitEnabled.value = Boolean.valueOf(z);
        autoInitEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(autoInitEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAutoInitEnabled() {
        initializeIfNotInitialized();
        return autoInitEnabled.getValue();
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        autoLogAppEventsEnabled.value = Boolean.valueOf(z);
        autoLogAppEventsEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(autoLogAppEventsEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAutoLogAppEventsEnabled() {
        initializeIfNotInitialized();
        return autoLogAppEventsEnabled.getValue();
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        advertiserIDCollectionEnabled.value = Boolean.valueOf(z);
        advertiserIDCollectionEnabled.lastTS = System.currentTimeMillis();
        if (isInitialized.get()) {
            writeSettingToCache(advertiserIDCollectionEnabled);
        } else {
            initializeIfNotInitialized();
        }
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        initializeIfNotInitialized();
        return advertiserIDCollectionEnabled.getValue();
    }

    public static boolean getCodelessSetupEnabled() {
        initializeIfNotInitialized();
        return codelessSetupEnabled.getValue();
    }

    static class UserSetting {
        boolean defaultVal;
        String key;
        long lastTS;
        Boolean value;

        UserSetting(boolean z, String str) {
            this.defaultVal = z;
            this.key = str;
        }

        /* access modifiers changed from: package-private */
        public boolean getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }
}
