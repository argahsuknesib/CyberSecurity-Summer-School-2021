package com.otaliastudios.cameraview;

import _m_j.cps;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class SessionType extends Enum<SessionType> implements cps {
    private static final /* synthetic */ SessionType[] $VALUES;
    static final SessionType DEFAULT;
    public static final SessionType PICTURE = new SessionType("PICTURE", 0, 0);
    public static final SessionType VIDEO = new SessionType("VIDEO", 1, 1);
    private int value;

    public static SessionType valueOf(String str) {
        return (SessionType) Enum.valueOf(SessionType.class, str);
    }

    public static SessionType[] values() {
        return (SessionType[]) $VALUES.clone();
    }

    static {
        SessionType sessionType = PICTURE;
        $VALUES = new SessionType[]{sessionType, VIDEO};
        DEFAULT = sessionType;
    }

    private SessionType(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static SessionType fromValue(int i) {
        for (SessionType sessionType : values()) {
            if (sessionType.value() == i) {
                return sessionType;
            }
        }
        return null;
    }
}
