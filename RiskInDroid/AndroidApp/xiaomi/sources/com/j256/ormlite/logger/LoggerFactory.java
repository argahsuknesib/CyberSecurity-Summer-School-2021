package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;

public class LoggerFactory {
    private static LogType logType;

    private LoggerFactory() {
    }

    public static Logger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static Logger getLogger(String str) {
        if (logType == null) {
            logType = findLogType();
        }
        return new Logger(logType.createLog(str));
    }

    public static String getSimpleClassName(String str) {
        String[] split = str.split("\\.");
        if (split.length <= 1) {
            return str;
        }
        return split[split.length - 1];
    }

    private static LogType findLogType() {
        String property = System.getProperty("com.j256.ormlite.logger.type");
        if (property != null) {
            try {
                return LogType.valueOf(property);
            } catch (IllegalArgumentException unused) {
                new LocalLog(LoggerFactory.class.getName()).log(Log.Level.WARNING, "Could not find valid log-type from system property 'com.j256.ormlite.logger.type', value '" + property + "'");
            }
        }
        for (LogType logType2 : LogType.values()) {
            if (logType2.isAvailable()) {
                return logType2;
            }
        }
        return LogType.LOCAL;
    }

    public enum LogType {
        SLF4J("org.slf4j.LoggerFactory", "com.j256.ormlite.logger.Slf4jLoggingLog"),
        ANDROID("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
        COMMONS_LOGGING("org.apache.commons.logging.LogFactory", "com.j256.ormlite.logger.CommonsLoggingLog"),
        LOG4J2("org.apache.logging.log4j.LogManager", "com.j256.ormlite.logger.Log4j2Log"),
        LOG4J("org.apache.log4j.Logger", "com.j256.ormlite.logger.Log4jLog"),
        LOCAL(LocalLog.class.getName(), LocalLog.class.getName()) {
            public final boolean isAvailable() {
                return true;
            }

            public final Log createLog(String str) {
                return new LocalLog(str);
            }
        },
        JAVA_UTIL("java.util.logging.Logger", "com.j256.ormlite.logger.JavaUtilLog");
        
        private final String detectClassName;
        private final String logClassName;

        private LogType(String str, String str2) {
            this.detectClassName = str;
            this.logClassName = str2;
        }

        public Log createLog(String str) {
            try {
                return createLogFromClassName(str);
            } catch (Exception e) {
                LocalLog localLog = new LocalLog(str);
                Log.Level level = Log.Level.WARNING;
                localLog.log(level, "Unable to call constructor with single String argument for class " + this.logClassName + ", so had to use local log: " + e.getMessage());
                return localLog;
            }
        }

        public boolean isAvailable() {
            if (!isAvailableTestClass()) {
                return false;
            }
            try {
                createLogFromClassName(getClass().getName()).isLevelEnabled(Log.Level.INFO);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        private Log createLogFromClassName(String str) throws Exception {
            return (Log) Class.forName(this.logClassName).getConstructor(String.class).newInstance(str);
        }

        /* access modifiers changed from: package-private */
        public boolean isAvailableTestClass() {
            try {
                Class.forName(this.detectClassName);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
