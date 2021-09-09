package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;

class SessionInfo {
    private Long diskRestoreTime;
    private int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    public SessionInfo(Long l, Long l2) {
        this(l, l2, UUID.randomUUID());
    }

    public SessionInfo(Long l, Long l2, UUID uuid) {
        this.sessionStartTime = l;
        this.sessionLastEventTime = l2;
        this.sessionId = uuid;
    }

    public static SessionInfo getStoredSessionInfo() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        long j = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0);
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0);
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (j == 0 || j2 == 0 || string == null) {
            return null;
        }
        SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j), Long.valueOf(j2));
        sessionInfo.interruptionCount = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        sessionInfo.sourceApplicationInfo = SourceApplicationInfo.getStoredSourceApplicatioInfo();
        sessionInfo.diskRestoreTime = Long.valueOf(System.currentTimeMillis());
        sessionInfo.sessionId = UUID.fromString(string);
        return sessionInfo;
    }

    public static void clearSavedSessionFromDisk() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        edit.remove("com.facebook.appevents.SessionInfo.sessionId");
        edit.apply();
        SourceApplicationInfo.clearSavedSourceApplicationInfoFromDisk();
    }

    public Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public void setSessionLastEventTime(Long l) {
        this.sessionLastEventTime = l;
    }

    public int getInterruptionCount() {
        return this.interruptionCount;
    }

    public void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public long getDiskRestoreTime() {
        Long l = this.diskRestoreTime;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public long getSessionLength() {
        Long l;
        if (this.sessionStartTime == null || (l = this.sessionLastEventTime) == null) {
            return 0;
        }
        return l.longValue() - this.sessionStartTime.longValue();
    }

    public SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo2) {
        this.sourceApplicationInfo = sourceApplicationInfo2;
    }

    public void writeSessionToDisk() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.sessionStartTime.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.sessionLastEventTime.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.interruptionCount);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.sessionId.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo2 = this.sourceApplicationInfo;
        if (sourceApplicationInfo2 != null) {
            sourceApplicationInfo2.writeSourceApplicationInfoToDisk();
        }
    }
}
