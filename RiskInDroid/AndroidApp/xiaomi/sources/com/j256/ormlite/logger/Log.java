package com.j256.ormlite.logger;

public interface Log {
    boolean isLevelEnabled(Level level);

    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    public enum Level {
        TRACE(1),
        DEBUG(2),
        INFO(3),
        WARNING(4),
        ERROR(5),
        FATAL(6);
        
        private int level;

        private Level(int i) {
            this.level = i;
        }

        public final boolean isEnabled(Level level2) {
            return this.level <= level2.level;
        }
    }
}
