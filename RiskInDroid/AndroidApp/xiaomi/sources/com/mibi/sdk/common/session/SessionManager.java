package com.mibi.sdk.common.session;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mibi.sdk.common.account.loader.AccountLoader;
import com.mibi.sdk.common.session.Session;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static SessionCache sSessionCache = new SessionCache();

    private SessionManager() {
    }

    public static Session newSession(Context context, AccountLoader accountLoader) {
        Session session = new Session(context, accountLoader);
        Log.v("SessionManager", "new session " + session.getUuid() + " created");
        sSessionCache.put(session);
        return session;
    }

    public static Session get(String str) {
        return sSessionCache.get(str);
    }

    public static Session.SessionSaveData saveSession(Session session) {
        return Session.saveSession(session);
    }

    public static Session restoreOrUpdateSession(Context context, Session.SessionSaveData sessionSaveData, Session.SessionSaveData sessionSaveData2) {
        if (sessionSaveData2 == null && sessionSaveData == null) {
            Log.d("SessionManager", "intent session and saved session all null");
            return null;
        }
        String str = sessionSaveData2 != null ? sessionSaveData2.mUuid : sessionSaveData.mUuid;
        StringBuilder sb = new StringBuilder("session ");
        sb.append(str);
        sb.append(" restore from ");
        sb.append(sessionSaveData2 != null ? "intent data" : "saved data");
        Log.v("SessionManager", sb.toString());
        if (sessionSaveData == null || sessionSaveData2 == null ? sessionSaveData != null : sessionSaveData2.mTimeStamp <= sessionSaveData.mTimeStamp) {
            sessionSaveData2 = sessionSaveData;
        }
        Session session = get(str);
        if (session == null) {
            StringBuilder sb2 = new StringBuilder("session ");
            sb2.append(str);
            sb2.append(" is not in cache, restore from ");
            sb2.append(sessionSaveData2 == sessionSaveData ? "saved data" : "intent data");
            Log.v("SessionManager", sb2.toString());
            Session session2 = new Session(context, sessionSaveData2);
            sSessionCache.put(session2);
            return session2;
        }
        synchronized (session) {
            if (sessionSaveData2.mTimeStamp > session.getTimeStamp()) {
                StringBuilder sb3 = new StringBuilder("session ");
                sb3.append(str);
                sb3.append(" in cache is out of date, try to update from ");
                sb3.append(sessionSaveData2 == sessionSaveData ? "saved data" : "intent data");
                Log.v("SessionManager", sb3.toString());
                session.update(sessionSaveData2);
            } else {
                Log.v("SessionManager", "session " + str + " found in cache");
            }
        }
        return session;
    }

    static class SessionCache {
        private static Map<String, SoftReference<Session>> sSessionCache = new ConcurrentHashMap();

        private SessionCache() {
        }

        public Session get(String str) {
            SoftReference softReference;
            if (!TextUtils.isEmpty(str) && (softReference = sSessionCache.get(str)) != null) {
                return (Session) softReference.get();
            }
            return null;
        }

        public void put(Session session) {
            if (session != null) {
                sSessionCache.put(session.getUuid(), new SoftReference(session));
            }
        }
    }
}
