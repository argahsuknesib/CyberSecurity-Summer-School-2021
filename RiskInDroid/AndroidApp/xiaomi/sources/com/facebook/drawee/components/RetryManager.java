package com.facebook.drawee.components;

public class RetryManager {
    private int mMaxTapToRetryAttempts;
    private int mTapToRetryAttempts;
    private boolean mTapToRetryEnabled;

    public RetryManager() {
        init();
    }

    public static RetryManager newInstance() {
        return new RetryManager();
    }

    public void init() {
        this.mTapToRetryEnabled = false;
        this.mMaxTapToRetryAttempts = 4;
        reset();
    }

    public void reset() {
        this.mTapToRetryAttempts = 0;
    }

    public boolean isTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public void setTapToRetryEnabled(boolean z) {
        this.mTapToRetryEnabled = z;
    }

    public void setMaxTapToRetryAttemps(int i) {
        this.mMaxTapToRetryAttempts = i;
    }

    public boolean shouldRetryOnTap() {
        return this.mTapToRetryEnabled && this.mTapToRetryAttempts < this.mMaxTapToRetryAttempts;
    }

    public void notifyTapToRetry() {
        this.mTapToRetryAttempts++;
    }
}
