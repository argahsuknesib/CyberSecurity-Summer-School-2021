package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingLog implements Log {
    private final Log log;

    public CommonsLoggingLog(String str) {
        this.log = LogFactory.getLog(str);
    }

    public boolean isLevelEnabled(Log.Level level) {
        switch (level) {
            case TRACE:
                return this.log.isTraceEnabled();
            case DEBUG:
                return this.log.isDebugEnabled();
            case INFO:
                return this.log.isInfoEnabled();
            case WARNING:
                return this.log.isWarnEnabled();
            case ERROR:
                return this.log.isErrorEnabled();
            case FATAL:
                return this.log.isFatalEnabled();
            default:
                return this.log.isInfoEnabled();
        }
    }

    public void log(Log.Level level, String str) {
        switch (level) {
            case TRACE:
                this.log.trace(str);
                return;
            case DEBUG:
                this.log.debug(str);
                return;
            case INFO:
                this.log.info(str);
                return;
            case WARNING:
                this.log.warn(str);
                return;
            case ERROR:
                this.log.error(str);
                return;
            case FATAL:
                this.log.fatal(str);
                return;
            default:
                this.log.info(str);
                return;
        }
    }

    public void log(Log.Level level, String str, Throwable th) {
        switch (level) {
            case TRACE:
                this.log.trace(str, th);
                return;
            case DEBUG:
                this.log.debug(str, th);
                return;
            case INFO:
                this.log.info(str, th);
                return;
            case WARNING:
                this.log.warn(str, th);
                return;
            case ERROR:
                this.log.error(str, th);
                return;
            case FATAL:
                this.log.fatal(str, th);
                return;
            default:
                this.log.info(str, th);
                return;
        }
    }
}
