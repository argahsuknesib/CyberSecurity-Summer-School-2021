package com.xiaomi.smarthome.uwb.lib;

public class UwbSdkConfig {
    private final int logLevel;
    private final int mode;

    public UwbSdkConfig(int i, int i2) {
        this.logLevel = i;
        this.mode = i2;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public int getMode() {
        return this.mode;
    }

    public static class Builder {
        private int logLevel = 3;
        private int mode = 1;

        public Builder setLogLevel(int i) {
            this.logLevel = i;
            return this;
        }

        public UwbSdkConfig build() {
            return new UwbSdkConfig(this.logLevel, this.mode);
        }

        public Builder setMode(int i) {
            this.mode = i;
            return this;
        }
    }
}
