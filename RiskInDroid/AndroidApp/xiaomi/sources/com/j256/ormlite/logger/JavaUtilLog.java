package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaUtilLog implements Log {
    private final Logger logger;

    public JavaUtilLog(String str) {
        this.logger = Logger.getLogger(str);
    }

    public boolean isLevelEnabled(Log.Level level) {
        return this.logger.isLoggable(levelToJavaLevel(level));
    }

    public void log(Log.Level level, String str) {
        this.logger.log(levelToJavaLevel(level), str);
    }

    public void log(Log.Level level, String str, Throwable th) {
        this.logger.log(levelToJavaLevel(level), str, th);
    }

    private Level levelToJavaLevel(Log.Level level) {
        switch (level) {
            case TRACE:
                return Level.FINER;
            case DEBUG:
                return Level.FINE;
            case INFO:
                return Level.INFO;
            case WARNING:
                return Level.WARNING;
            case ERROR:
                return Level.SEVERE;
            case FATAL:
                return Level.SEVERE;
            default:
                return Level.INFO;
        }
    }
}
