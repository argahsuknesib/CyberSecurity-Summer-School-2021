package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum ShareStoryFeature implements DialogFeature {
    SHARE_STORY_ASSET(20170417);
    
    private int minVersion;

    public final String getAction() {
        return "com.facebook.platform.action.request.SHARE_STORY";
    }

    private ShareStoryFeature(int i) {
        this.minVersion = i;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
