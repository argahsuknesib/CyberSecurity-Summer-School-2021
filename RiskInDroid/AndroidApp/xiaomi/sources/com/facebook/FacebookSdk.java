package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import android.util.Log;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import java.io.File;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

public final class FacebookSdk {
    private static final Object LOCK = new Object();
    private static final String TAG = "com.facebook.FacebookSdk";
    private static volatile String appClientToken;
    public static Context applicationContext;
    public static volatile String applicationId;
    private static volatile String applicationName;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = 64206;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    private static volatile String facebookDomain = "facebook.com";
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static Boolean sdkFullyInitialized = Boolean.FALSE;
    private static Boolean sdkInitialized = Boolean.FALSE;

    public interface InitializeCallback {
        void onInitialized();
    }

    public static String getSdkVersion() {
        return "5.13.0";
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, i, null);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (sdkInitialized.booleanValue()) {
                if (i != callbackRequestCodeOffset) {
                    throw new FacebookException("The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method");
                }
            }
            if (i >= 0) {
                callbackRequestCodeOffset = i;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException("The callback request code offset can't be negative.");
            }
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        return;
     */
    @Deprecated
    public static synchronized void sdkInitialize(final Context context, final InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            if (!sdkInitialized.booleanValue()) {
                Validate.notNull(context, "applicationContext");
                Validate.hasFacebookActivity(context, false);
                Validate.hasInternetPermissions(context, false);
                applicationContext = context.getApplicationContext();
                AppEventsLogger.getAnonymousAppDeviceGUID(context);
                loadDefaultsFromMetadata(applicationContext);
                if (!Utility.isNullOrEmpty(applicationId)) {
                    sdkInitialized = Boolean.TRUE;
                    if (getAutoInitEnabled()) {
                        fullyInitialize();
                    }
                    if ((applicationContext instanceof Application) && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                        ActivityLifecycleTracker.startTracking((Application) applicationContext, applicationId);
                    }
                    FetchedAppSettingsManager.loadAppSettingsAsync();
                    NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                    BoltsMeasurementEventListener.getInstance(applicationContext);
                    cacheDir = new LockOnGetVariable<>((Callable) new Callable<File>() {
                        /* class com.facebook.FacebookSdk.AnonymousClass1 */

                        public final File call() throws Exception {
                            return FacebookSdk.applicationContext.getCacheDir();
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new FeatureManager.Callback() {
                        /* class com.facebook.FacebookSdk.AnonymousClass2 */

                        public final void onCompleted(boolean z) {
                            if (z) {
                                InstrumentManager.start();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new FeatureManager.Callback() {
                        /* class com.facebook.FacebookSdk.AnonymousClass3 */

                        public final void onCompleted(boolean z) {
                            if (z) {
                                AppEventsManager.start();
                            }
                        }
                    });
                    getExecutor().execute(new FutureTask(new Callable<Void>() {
                        /* class com.facebook.FacebookSdk.AnonymousClass4 */

                        public final Void call() throws Exception {
                            AccessTokenManager.getInstance().loadCurrentAccessToken();
                            ProfileManager.getInstance().loadCurrentProfile();
                            if (AccessToken.isCurrentAccessTokenActive() && Profile.getCurrentProfile() == null) {
                                Profile.fetchProfileForCurrentAccessToken();
                            }
                            InitializeCallback initializeCallback = initializeCallback;
                            if (initializeCallback != null) {
                                initializeCallback.onInitialized();
                            }
                            AppEventsLogger.initializeLib(FacebookSdk.applicationContext, FacebookSdk.applicationId);
                            AppEventsLogger.newLogger(context.getApplicationContext()).flush();
                            return null;
                        }
                    }));
                    return;
                }
                throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
            } else if (initializeCallback != null) {
                initializeCallback.onInitialized();
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static synchronized boolean isFullyInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            booleanValue = sdkFullyInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static void fullyInitialize() {
        sdkFullyInitialized = Boolean.TRUE;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
            updateGraphDebugBehavior();
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(loggingBehavior);
        }
    }

    public static void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        synchronized (loggingBehaviors) {
            z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor2) {
        Validate.notNull(executor2, "executor");
        synchronized (LOCK) {
            executor = executor2;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static void setGraphApiVersion(String str) {
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (!Utility.isNullOrEmpty(str) && !graphApiVersion.equals(str)) {
            graphApiVersion = str;
        }
    }

    public static String getGraphApiVersion() {
        Utility.logd(TAG, String.format("getGraphApiVersion: %s", graphApiVersion));
        return graphApiVersion;
    }

    public static void publishInstallAsync(Context context, final String str) {
        final Context applicationContext2 = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            /* class com.facebook.FacebookSdk.AnonymousClass5 */

            public final void run() {
                FacebookSdk.publishInstallAndWaitForResponse(applicationContext2, str);
            }
        });
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    static void publishInstallAndWaitForResponse(Context context, String str) {
        if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        try {
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            String str2 = str + "ping";
            long j = sharedPreferences.getLong(str2, 0);
            GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format("%s/activities", str), AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context), null);
            if (j == 0 && newPostRequest.executeAndWait().getError() == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str2, System.currentTimeMillis());
                edit.apply();
            }
        } catch (JSONException e) {
            throw new FacebookException("An error occurred while publishing install.", e);
        } catch (Exception e2) {
            Utility.logd("Facebook-publish", e2);
        }
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        Validate.sdkInitialized();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    static void loadDefaultsFromMetadata(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                applicationId = str.substring(2);
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (callbackRequestCodeOffset == 64206) {
                        callbackRequestCodeOffset = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
                    }
                    if (codelessDebugLogEnabled == null) {
                        codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static String getApplicationSignature(Context context) {
        PackageManager packageManager;
        Validate.sdkInitialized();
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (!(signatureArr == null || signatureArr.length == 0)) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                return Base64.encodeToString(instance.digest(), 9);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static String getApplicationId() {
        Validate.sdkInitialized();
        return applicationId;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        Validate.sdkInitialized();
        return appClientToken;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    public static void setAutoInitEnabled(boolean z) {
        UserSettingsManager.setAutoInitEnabled(z);
        if (z) {
            fullyInitialize();
        }
    }

    public static boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z);
        if (z) {
            ActivityLifecycleTracker.startTracking((Application) applicationContext, applicationId);
        }
    }

    public static boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        return codelessDebugLogEnabled.booleanValue();
    }

    public static boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    public static void setAdvertiserIDCollectionEnabled(boolean z) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z);
    }

    public static boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    public static void setCodelessDebugLogEnabled(boolean z) {
        codelessDebugLogEnabled = Boolean.valueOf(z);
    }

    public static File getCacheDir() {
        Validate.sdkInitialized();
        return cacheDir.getValue();
    }

    public static void setCacheDir(File file) {
        cacheDir = new LockOnGetVariable<>(file);
    }

    public static int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    public static boolean isFacebookRequestCode(int i) {
        int i2 = callbackRequestCodeOffset;
        return i >= i2 && i < i2 + 100;
    }
}
