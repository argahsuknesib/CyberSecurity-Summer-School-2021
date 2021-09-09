package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class AnalyticsUserIDStore {
    private static final String TAG = "AnalyticsUserIDStore";
    private static volatile boolean initialized = false;
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static String userID;

    AnalyticsUserIDStore() {
    }

    public static void initStore() {
        if (!initialized) {
            InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
                /* class com.facebook.appevents.AnalyticsUserIDStore.AnonymousClass1 */

                public final void run() {
                    AnalyticsUserIDStore.initAndWait();
                }
            });
        }
    }

    public static void setUserID(final String str) {
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.AnalyticsUserIDStore.AnonymousClass2 */

            public final void run() {
                AnalyticsUserIDStore.lock.writeLock().lock();
                try {
                    AnalyticsUserIDStore.userID = str;
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", AnalyticsUserIDStore.userID);
                    edit.apply();
                } finally {
                    AnalyticsUserIDStore.lock.writeLock().unlock();
                }
            }
        });
    }

    public static String getUserID() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        lock.readLock().lock();
        try {
            return userID;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void initAndWait() {
        if (!initialized) {
            lock.writeLock().lock();
            try {
                if (!initialized) {
                    userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                    initialized = true;
                }
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
