package com.xiaomi.account.diagnosis.log;

public enum LogLevel {
    VERBOSE("V"),
    DEBUG("D"),
    INFO("I"),
    WARN("W"),
    ERROR("E");
    
    private final String mLevelStr;

    private LogLevel(String str) {
        this.mLevelStr = str;
    }

    public static LogLevel fromInt(int i) {
        if (i == 2) {
            return VERBOSE;
        }
        if (i == 3) {
            return DEBUG;
        }
        if (i == 4) {
            return INFO;
        }
        if (i == 5) {
            return WARN;
        }
        if (i != 6) {
            return VERBOSE;
        }
        return ERROR;
    }

    public final String toString() {
        return this.mLevelStr;
    }
}
