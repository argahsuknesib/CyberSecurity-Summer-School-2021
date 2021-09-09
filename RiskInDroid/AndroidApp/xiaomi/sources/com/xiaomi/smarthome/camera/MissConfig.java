package com.xiaomi.smarthome.camera;

public class MissConfig {
    private final int externalFlag;
    private final int length;
    private final int maxAudioReceiveSize;
    private final int maxAudioSendSize;
    private final int maxFrameSize;
    private final int maxResendSize;
    private final int maxVideoReceiveSize;
    private final int maxVideoSendSize;

    public int getLength() {
        return this.length;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public int getMaxResendSize() {
        return this.maxResendSize;
    }

    public int getMaxVideoSendSize() {
        return this.maxVideoSendSize;
    }

    public int getMaxAudioSendSize() {
        return this.maxAudioSendSize;
    }

    public int getMaxVideoReceiveSize() {
        return this.maxVideoReceiveSize;
    }

    public int getMaxAudioReceiveSize() {
        return this.maxAudioReceiveSize;
    }

    public int getExternalFlag() {
        return this.externalFlag;
    }

    public static class Builder {
        public int externalFlag = 1;
        public int length;
        public int maxAudioReceiveSize = 32768;
        public int maxAudioSendSize = 32768;
        public int maxFrameSize;
        public int maxResendSize;
        public int maxVideoReceiveSize = 524288;
        public int maxVideoSendSize = 524288;

        public Builder setLength(int i) {
            this.length = i;
            return this;
        }

        public Builder setMaxFrameSize(int i) {
            this.maxFrameSize = i;
            return this;
        }

        public Builder setMaxResendSize(int i) {
            this.maxResendSize = i;
            return this;
        }

        public Builder setMaxVideoSendSize(int i) {
            this.maxVideoSendSize = i;
            return this;
        }

        public Builder setMaxAudioSendSize(int i) {
            this.maxAudioSendSize = i;
            return this;
        }

        public Builder setMaxVideoReceiveSize(int i) {
            this.maxVideoReceiveSize = i;
            return this;
        }

        public Builder setMaxAudioReceiveSize(int i) {
            this.maxAudioReceiveSize = i;
            return this;
        }

        public Builder setExternalFlag(int i) {
            this.externalFlag = i;
            return this;
        }

        public MissConfig build() {
            return new MissConfig(this);
        }
    }

    private MissConfig(Builder builder) {
        this.length = builder.length;
        this.maxFrameSize = builder.maxFrameSize;
        this.maxResendSize = builder.maxResendSize;
        this.maxVideoSendSize = builder.maxVideoSendSize;
        this.maxAudioSendSize = builder.maxAudioSendSize;
        this.maxVideoReceiveSize = builder.maxVideoReceiveSize;
        this.maxAudioReceiveSize = builder.maxAudioReceiveSize;
        this.externalFlag = builder.externalFlag;
    }
}
