package com.j256.ormlite.logger;

import _m_j.jmx;
import _m_j.jmy;
import com.j256.ormlite.logger.Log;

public class Slf4jLoggingLog implements Log {
    private final jmx logger;

    public Slf4jLoggingLog(String str) {
        this.logger = jmy.O000000o(str);
    }

    public boolean isLevelEnabled(Log.Level level) {
        switch (level) {
            case TRACE:
                return this.logger.O000000o();
            case DEBUG:
                return this.logger.O00000Oo();
            case INFO:
                return this.logger.O00000o0();
            case WARNING:
                return this.logger.O00000o();
            case ERROR:
                return this.logger.O00000oO();
            case FATAL:
                return this.logger.O00000oO();
            default:
                return this.logger.O00000o0();
        }
    }

    public void log(Log.Level level, String str) {
        switch (level) {
            case TRACE:
                this.logger.O000000o(str);
                return;
            case DEBUG:
                this.logger.O00000Oo(str);
                return;
            case INFO:
                this.logger.O00000o0(str);
                return;
            case WARNING:
                this.logger.O00000o(str);
                return;
            case ERROR:
                this.logger.O00000oO(str);
                return;
            case FATAL:
                this.logger.O00000oO(str);
                return;
            default:
                this.logger.O00000o0(str);
                return;
        }
    }

    public void log(Log.Level level, String str, Throwable th) {
        switch (level) {
            case TRACE:
                this.logger.O000000o(str, th);
                return;
            case DEBUG:
                this.logger.O00000Oo(str, th);
                return;
            case INFO:
                this.logger.O00000o0(str, th);
                return;
            case WARNING:
                this.logger.O00000o(str, th);
                return;
            case ERROR:
                this.logger.O00000oO(str, th);
                return;
            case FATAL:
                this.logger.O00000oO(str, th);
                return;
            default:
                this.logger.O00000o0(str, th);
                return;
        }
    }
}
