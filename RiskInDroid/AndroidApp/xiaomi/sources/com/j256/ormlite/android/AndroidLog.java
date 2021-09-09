package com.j256.ormlite.android;

import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.LoggerFactory;

public class AndroidLog implements Log {
    private String className;
    private final boolean[] levelCache;
    private volatile int levelCacheC = 0;

    public AndroidLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        int length = this.className.length();
        if (length > 23) {
            this.className = this.className.substring(length - 23, length);
        }
        int i = 0;
        for (Log.Level levelToAndroidLevel : Log.Level.values()) {
            int levelToAndroidLevel2 = levelToAndroidLevel(levelToAndroidLevel);
            if (levelToAndroidLevel2 > i) {
                i = levelToAndroidLevel2;
            }
        }
        this.levelCache = new boolean[(i + 1)];
        refreshLevelCache();
    }

    public boolean isLevelEnabled(Log.Level level) {
        int i = this.levelCacheC + 1;
        this.levelCacheC = i;
        if (i >= 200) {
            refreshLevelCache();
            this.levelCacheC = 0;
        }
        int levelToAndroidLevel = levelToAndroidLevel(level);
        boolean[] zArr = this.levelCache;
        if (levelToAndroidLevel < zArr.length) {
            return zArr[levelToAndroidLevel];
        }
        return isLevelEnabledInternal(levelToAndroidLevel);
    }

    public void log(Log.Level level, String str) {
        switch (level) {
            case TRACE:
                android.util.Log.v(this.className, str);
                return;
            case DEBUG:
                android.util.Log.d(this.className, str);
                return;
            case INFO:
                android.util.Log.i(this.className, str);
                return;
            case WARNING:
                android.util.Log.w(this.className, str);
                return;
            case ERROR:
                android.util.Log.e(this.className, str);
                return;
            case FATAL:
                android.util.Log.e(this.className, str);
                return;
            default:
                android.util.Log.i(this.className, str);
                return;
        }
    }

    public void log(Log.Level level, String str, Throwable th) {
        switch (level) {
            case TRACE:
                android.util.Log.v(this.className, str, th);
                return;
            case DEBUG:
                android.util.Log.d(this.className, str, th);
                return;
            case INFO:
                android.util.Log.i(this.className, str, th);
                return;
            case WARNING:
                android.util.Log.w(this.className, str, th);
                return;
            case ERROR:
                android.util.Log.e(this.className, str, th);
                return;
            case FATAL:
                android.util.Log.e(this.className, str, th);
                return;
            default:
                android.util.Log.i(this.className, str, th);
                return;
        }
    }

    private void refreshLevelCache() {
        for (Log.Level levelToAndroidLevel : Log.Level.values()) {
            int levelToAndroidLevel2 = levelToAndroidLevel(levelToAndroidLevel);
            boolean[] zArr = this.levelCache;
            if (levelToAndroidLevel2 < zArr.length) {
                zArr[levelToAndroidLevel2] = isLevelEnabledInternal(levelToAndroidLevel2);
            }
        }
    }

    private boolean isLevelEnabledInternal(int i) {
        return android.util.Log.isLoggable(this.className, i) || android.util.Log.isLoggable("ORMLite", i);
    }

    private int levelToAndroidLevel(Log.Level level) {
        switch (level) {
            case TRACE:
                return 2;
            case DEBUG:
                return 3;
            case INFO:
                return 4;
            case WARNING:
                return 5;
            case ERROR:
            case FATAL:
                return 6;
            default:
                return 4;
        }
    }
}
