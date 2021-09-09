package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
    private static final String TAG = "com.facebook.appevents.AppEventStore";

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
            } else {
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                readAndClearStore.addEvents(next, appEventCollection.get(next).getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:53:0x0088 */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.facebook.appevents.PersistedEvents] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008a A[Catch:{ Exception -> 0x002e }] */
    public static synchronized PersistedEvents readAndClearStore() {
        MovedClassObjectInputStream movedClassObjectInputStream;
        MovedClassObjectInputStream movedClassObjectInputStream2;
        String str;
        String str2;
        Throwable th;
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            Context applicationContext = FacebookSdk.getApplicationContext();
            movedClassObjectInputStream = 0;
            try {
                movedClassObjectInputStream2 = new MovedClassObjectInputStream(new BufferedInputStream(applicationContext.openFileInput("AppEventsLogger.persistedevents")));
                try {
                    PersistedEvents persistedEvents = (PersistedEvents) movedClassObjectInputStream2.readObject();
                    Utility.closeQuietly(movedClassObjectInputStream2);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", e);
                    }
                    movedClassObjectInputStream = persistedEvents;
                } catch (FileNotFoundException unused) {
                    Utility.closeQuietly(movedClassObjectInputStream2);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e2) {
                        e = e2;
                        str = TAG;
                        str2 = "Got unexpected exception when removing events file: ";
                        Log.w(str, str2, e);
                        if (movedClassObjectInputStream == 0) {
                        }
                        return movedClassObjectInputStream;
                    }
                    if (movedClassObjectInputStream == 0) {
                    }
                    return movedClassObjectInputStream;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.w(TAG, "Got unexpected exception while reading events: ", e);
                        Utility.closeQuietly(movedClassObjectInputStream2);
                        if (movedClassObjectInputStream == 0) {
                        }
                        return movedClassObjectInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        movedClassObjectInputStream = movedClassObjectInputStream2;
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        } catch (Exception e4) {
                            Log.w(TAG, "Got unexpected exception when removing events file: ", e4);
                        }
                        throw th;
                    }
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e5) {
                        e = e5;
                        str = TAG;
                        str2 = "Got unexpected exception when removing events file: ";
                        Log.w(str, str2, e);
                        if (movedClassObjectInputStream == 0) {
                        }
                        return movedClassObjectInputStream;
                    }
                }
            } catch (FileNotFoundException unused2) {
                movedClassObjectInputStream2 = null;
                Utility.closeQuietly(movedClassObjectInputStream2);
                applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                if (movedClassObjectInputStream == 0) {
                }
                return movedClassObjectInputStream;
            } catch (Exception e6) {
                e = e6;
                movedClassObjectInputStream2 = null;
                Log.w(TAG, "Got unexpected exception while reading events: ", e);
                Utility.closeQuietly(movedClassObjectInputStream2);
                applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                if (movedClassObjectInputStream == 0) {
                }
                return movedClassObjectInputStream;
            } catch (Throwable th3) {
                th = th3;
                Utility.closeQuietly(movedClassObjectInputStream);
                applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                throw th;
            }
            if (movedClassObjectInputStream == 0) {
                movedClassObjectInputStream = new PersistedEvents();
            }
        }
        return movedClassObjectInputStream;
    }

    private static void saveEventsToDisk(PersistedEvents persistedEvents) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                objectOutputStream2.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream2);
            } catch (Exception e) {
                e = e;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", e);
                    try {
                        applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                    }
                    Utility.closeQuietly(objectOutputStream);
                } catch (Throwable th) {
                    th = th;
                    Utility.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
                Utility.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Log.w(TAG, "Got unexpected exception while persisting events: ", e);
            applicationContext.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            Utility.closeQuietly(objectOutputStream);
        }
    }

    static class MovedClassObjectInputStream extends ObjectInputStream {
        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class) : readClassDescriptor;
        }
    }
}
