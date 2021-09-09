package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum CameraEffectFeature implements DialogFeature {
    SHARE_CAMERA_EFFECT(20170417);
    
    private int minVersion;

    public final String getAction() {
        return "com.facebook.platform.action.request.CAMERA_EFFECT";
    }

    private CameraEffectFeature(int i) {
        this.minVersion = i;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
