package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphActionDialogFeature implements DialogFeature {
    OG_ACTION_DIALOG(20130618);
    
    private int minVersion;

    public final String getAction() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    private OpenGraphActionDialogFeature(int i) {
        this.minVersion = i;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
