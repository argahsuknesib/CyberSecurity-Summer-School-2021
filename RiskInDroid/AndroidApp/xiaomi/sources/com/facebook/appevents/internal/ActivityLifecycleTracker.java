package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivityLifecycleTracker {
    public static final String TAG = "com.facebook.appevents.internal.ActivityLifecycleTracker";
    public static int activityReferences = 0;
    public static String appId;
    private static WeakReference<Activity> currActivity;
    public static long currentActivityAppearTime;
    public static volatile ScheduledFuture currentFuture;
    public static final Object currentFutureLock = new Object();
    public static volatile SessionInfo currentSession;
    public static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private static AtomicBoolean tracking = new AtomicBoolean(false);

    public static void startTracking(Application application, String str) {
        if (tracking.compareAndSet(false, true)) {
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new FeatureManager.Callback() {
                /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass1 */

                public final void onCompleted(boolean z) {
                    if (z) {
                        CodelessManager.enable();
                    } else {
                        CodelessManager.disable();
                    }
                }
            });
            appId = str;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass2 */

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityCreated(activity);
                }

                public final void onActivityStarted(Activity activity) {
                    ActivityLifecycleTracker.activityReferences++;
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
                }

                public final void onActivityResumed(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityResumed(activity);
                }

                public final void onActivityPaused(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityPaused(activity);
                }

                public final void onActivityStopped(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
                    AppEventsLogger.onContextStop();
                    ActivityLifecycleTracker.activityReferences--;
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
                }

                public final void onActivityDestroyed(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
                    ActivityLifecycleTracker.onActivityDestroyed(activity);
                }
            });
        }
    }

    public static boolean isInBackground() {
        return activityReferences == 0;
    }

    public static boolean isTracking() {
        return tracking.get();
    }

    public static UUID getCurrentSessionGuid() {
        if (currentSession != null) {
            return currentSession.getSessionId();
        }
        return null;
    }

    public static void onActivityCreated(Activity activity) {
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass3 */

            public final void run() {
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = SessionInfo.getStoredSessionInfo();
                }
            }
        });
    }

    public static void onActivityResumed(Activity activity) {
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager.trackActivity(activity);
        final Context applicationContext = activity.getApplicationContext();
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass4 */

            public final void run() {
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId, applicationContext);
                } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null) {
                    long longValue = currentTimeMillis - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
                    if (longValue > ((long) (ActivityLifecycleTracker.getSessionTimeoutInSeconds() * 1000))) {
                        SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                        SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId, applicationContext);
                        ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    } else if (longValue > 1000) {
                        ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
                    }
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
            }
        });
    }

    public static void onActivityPaused(Activity activity) {
        if (foregroundActivityCount.decrementAndGet() < 0) {
            foregroundActivityCount.set(0);
            Log.w(TAG, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new Runnable() {
            /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass5 */

            public final void run() {
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                    AnonymousClass1 r0 = new Runnable() {
                        /* class com.facebook.appevents.internal.ActivityLifecycleTracker.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                                SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                                SessionInfo.clearSavedSessionFromDisk();
                                ActivityLifecycleTracker.currentSession = null;
                            }
                            synchronized (ActivityLifecycleTracker.currentFutureLock) {
                                ActivityLifecycleTracker.currentFuture = null;
                            }
                        }
                    };
                    synchronized (ActivityLifecycleTracker.currentFutureLock) {
                        ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(r0, (long) ActivityLifecycleTracker.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                    }
                }
                long j = ActivityLifecycleTracker.currentActivityAppearTime;
                long j2 = 0;
                if (j > 0) {
                    j2 = (currentTimeMillis - j) / 1000;
                }
                AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, j2);
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
            }
        });
    }

    public static void onActivityDestroyed(Activity activity) {
        CodelessManager.onActivityDestroyed(activity);
    }

    public static int getSessionTimeoutInSeconds() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
        }
        return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    private static void cancelCurrentTask() {
        synchronized (currentFutureLock) {
            if (currentFuture != null) {
                currentFuture.cancel(false);
            }
            currentFuture = null;
        }
    }

    public static Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
